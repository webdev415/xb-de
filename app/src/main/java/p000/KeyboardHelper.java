package p000;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Keyboard visibility helper that safely handles showing/hiding the soft input
 * across all Android versions (pre and post WindowInsetsController).
 */
public final class KeyboardHelper {

    private final KeyboardController keyboardController;

    public KeyboardHelper(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            keyboardController = new InsetsKeyboardController(view);
        } else {
            keyboardController = new BaseKeyboardController(view);
        }
    }

    public void hideSoftKeyboard() {
        keyboardController.hideSoftKeyboard();
    }

    public void requestFocusSafely() {
        keyboardController.showSoftKeboard();
    }

    // ------------------------------------------------------------
    // Base abstract controller
    // ------------------------------------------------------------
    public static abstract class KeyboardController {
        public abstract void hideSoftKeyboard();
        public abstract void showSoftKeboard();
    }

    // ------------------------------------------------------------
    // Legacy API (pre-Android 11)
    // ------------------------------------------------------------
    public static class BaseKeyboardController extends KeyboardController {

        @Nullable
        protected final View decorView;

        public BaseKeyboardController(@Nullable View view) {
            this.decorView = view;
        }

        protected static void showSoftKeyboard(@NonNull View view) {
            InputMethodManager imm = (InputMethodManager)
                    view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) imm.showSoftInput(view, 0);
        }

        @Override
        public void hideSoftKeyboard() {
            if (decorView == null) return;

            InputMethodManager imm = (InputMethodManager)
                    decorView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(decorView.getWindowToken(), 0);
            }
        }

        @Override
        public void showSoftKeboard() {
            if (decorView == null) return;

            View target = decorView;

            if (target.isInEditMode()) {
                target.requestFocus();
                return;
            }

            if (!target.onCheckIsTextEditor()) {
                target = target.getRootView().findFocus();
            }

            if (target == null && decorView.getRootView() != null) {
                target = decorView.getRootView().findViewById(android.R.id.content);
            }

            if (target == null) return;

            if (target.hasWindowFocus()) {
                View finalTarget = target;
                target.post(() -> showSoftKeyboard(finalTarget));
            }
        }
    }

    // ------------------------------------------------------------
    // Modern API (Android 11+)
    // ------------------------------------------------------------
    @RequiresApi(api = Build.VERSION_CODES.R)
    public static class InsetsKeyboardController extends BaseKeyboardController {

        @Nullable
        private WindowInsetsController windowInsetsController;

        public InsetsKeyboardController(@Nullable View view) {
            super(view);
            this.windowInsetsController = view != null ? view.getWindowInsetsController() : null;
        }

        @Override
        public void hideSoftKeyboard() {
            if (windowInsetsController == null && decorView != null) {
                windowInsetsController = decorView.getWindowInsetsController();
            }

            if (windowInsetsController == null) {
                super.hideSoftKeyboard();
                return;
            }

            AtomicBoolean imeControllable = new AtomicBoolean(false);

            WindowInsetsController.OnControllableInsetsChangedListener listener =
                    (controller, types) -> imeControllable.set((types & WindowInsets.Type.ime()) != 0);

            windowInsetsController.addOnControllableInsetsChangedListener(listener);

            // Fallback hide if IME control isn't confirmed
            if (!imeControllable.get() && decorView != null) {
                InputMethodManager imm = (InputMethodManager)
                        decorView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(decorView.getWindowToken(), 0);
                }
            }

            windowInsetsController.removeOnControllableInsetsChangedListener(listener);
            windowInsetsController.hide(WindowInsets.Type.ime());
        }

        @Override
        public void showSoftKeboard() {
            if (decorView != null && Build.VERSION.SDK_INT < 33) {
                InputMethodManager imm = (InputMethodManager)
                        decorView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) imm.isActive(); // trigger IME readiness check
            }

            if (windowInsetsController == null && decorView != null) {
                windowInsetsController = decorView.getWindowInsetsController();
            }

            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }

            super.showSoftKeboard();
        }
    }
}
