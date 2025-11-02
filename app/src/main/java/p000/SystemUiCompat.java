package p000;

import android.os.Build;
import android.view.View;
import android.view.Window;

import androidx.annotation.RequiresApi;

/**
 * A compatibility helper for managing system UI behavior across Android versions.
 * This class provides safe methods for toggling fullscreen modes and
 * controlling whether the content fits system windows.
 */
public abstract class SystemUiCompat {

    /**
     * Controls decor fitting on Android 10 and below.
     * (Before API 30, we manually adjust SYSTEM_UI_FLAGs.)
     */
    private static class LegacyCompat {
        static void setDecorFitsSystemWindows(Window window, boolean fitsSystemWindows) {
            if (window == null) return;
            View decorView = window.getDecorView();
            if (decorView == null) return;

            int flags = decorView.getSystemUiVisibility();
            if (fitsSystemWindows) {
                // Clear fullscreen flags
                decorView.setSystemUiVisibility(flags & ~(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN));
            } else {
                // Apply fullscreen layout flags
                decorView.setSystemUiVisibility(flags |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }
        }
    }

    /**
     * Controls decor fitting on Android 11+ (API 30+)
     * using Window#setDecorFitsSystemWindows.
     */
    @RequiresApi(api = Build.VERSION_CODES.R)
    private static class ModernCompat {
        static void setDecorFitsSystemWindows(Window window, boolean fitsSystemWindows) {
            if (window != null) {
                window.setDecorFitsSystemWindows(fitsSystemWindows);
            }
        }
    }

    /**
     * Creates a {@link SystemUiController} bound to the given window and decor view.
     */
    public static SystemUiController create(Window window, View decorView) {
        return new SystemUiController(window, decorView);
    }

    /**
     * Sets whether the content should fit within the system windows (status/navigation bars).
     *
     * @param window            The target window.
     * @param fitsSystemWindows If true, the content will avoid overlapping system bars.
     */
    public static void setDecorFitsSystemWindows(Window window, boolean fitsSystemWindows) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            ModernCompat.setDecorFitsSystemWindows(window, fitsSystemWindows);
        } else {
            LegacyCompat.setDecorFitsSystemWindows(window, fitsSystemWindows);
        }
    }
}
