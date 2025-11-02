package p000;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

public final class SystemUiController {

    public final AbsSystemUiManager systemUiManager;

    public static class LegacyManager extends AbsSystemUiManager {

        public final Window window;

        public final KeyboardHelper keyboardHelper;

        public LegacyManager(Window window, KeyboardHelper keyboardHelper) {
            this.window = window;
            this.keyboardHelper = keyboardHelper;
        }

        @Override
        public void hideInsets(int types) {
            for (int mode = 1; mode <= 256; mode <<= 1) {
                if ((types & mode) != 0) {
                    hide(mode);
                }
            }
        }

        @Override
        public void showInsets(int type) {
            for (int mode = 1; mode <= 256; mode <<= 1) {
                if ((type & mode) != 0) {
                    show(mode);
                }
            }
        }

        @Override
        public void setSystemBarsBehavior(int behavior) {

            // 6144 = 4096 | 2048 (both flags)
            if (behavior == 0) {
                clearSystemUiFlags(6144);
                return;
            }

            if (behavior == 1) {
                // Disable "show transient bars by swipe" then enable "show by touch"
                clearSystemUiFlags(4096);
                applySystemUiFlags(2048);
                return;
            }

            if (behavior == 2) {
                // Disable "show by touch" then enable "show transient bars by swipe"
                clearSystemUiFlags(2048);
                applySystemUiFlags(4096);
            }
        }

        @Override
        public void setLightStatusBar(boolean enabled) {
            if (!enabled) {
                clearSystemUiFlags(8192);
                return;
            }
            clearWindowFlags(67108864);
            addWindowFlags(Integer.MIN_VALUE);
            applySystemUiFlags(8192);
        }

        /**
         * Applies UI behavior based on the given mode flag.
         * 1 = Fullscreen
         * 2 = Hide navigation bar
         * 8 = Hide keyboard
         */
        public final void hide(int mode) {
            if (mode == 1) {
                // Enable fullscreen
                applySystemUiFlags(View.SYSTEM_UI_FLAG_FULLSCREEN);
                addWindowFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } else if (mode == 2) {
                // Hide navigation bar
                applySystemUiFlags(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            } else if (mode == 8) {
                // Hide soft keyboard
                if (keyboardHelper != null) {
                    keyboardHelper.hideSoftKeyboard();
                }
            }
        }

        /**
         * Handles UI mode changes based on the given type.
         *
         * @param type UI mode flag:
         *             1 = Exit fullscreen
         *             2 = Show navigation bar
         *             8 = Show keyboard (IME)
         */
        public void show(int type) {
            if (type == 1) {
                // Exit fullscreen
                clearSystemUiFlags(View.SYSTEM_UI_FLAG_FULLSCREEN);
                clearWindowFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } else if (type == 2) {
                // Show navigation bar
                clearSystemUiFlags(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            } else if (type == 8) {
                // Show keyboard
                if (keyboardHelper != null) {
                    keyboardHelper.requestFocusSafely();
                }
            }
        }

        /**
         * Adds specific system UI visibility flags to the window's decor view.
         *
         * @param flags The flags to add (e.g., View.SYSTEM_UI_FLAG_FULLSCREEN)
         */
        public void applySystemUiFlags(int flags) {
            if (window == null) return;

            View decorView = window.getDecorView();
            int currentFlags = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(currentFlags | flags);
        }

        /**
         * Removes specific system UI visibility flags from the window's decor view.
         *
         * @param flags The flags to remove (e.g., View.SYSTEM_UI_FLAG_FULLSCREEN)
         */
        public void clearSystemUiFlags(int flags) {
            if (window == null) return;

            View decorView = window.getDecorView();
            int currentFlags = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(currentFlags & ~flags);
        }

        /**
         * Adds flags to the current window.
         *
         * @param flags The window flags to add (e.g., WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
         */
        public void addWindowFlags(int flags) {
            if (window == null) return;
            window.addFlags(flags);
        }

        /**
         * Clears specified Window flags.
         *
         * @param flags Window flags to clear (e.g. WindowManager.LayoutParams.FLAG_FULLSCREEN)
         */
        public void clearWindowFlags(int flags) {
            if (window == null) return;
            window.clearFlags(flags);
        }
    }

    public static class LegacyManagerWithNav extends LegacyManager {
        public LegacyManagerWithNav(Window window, KeyboardHelper keyboardHelper) {
            super(window, keyboardHelper);
        }

        @Override
        public void setLightNavigationBar(boolean enabled) {
            if (!enabled) {
                clearSystemUiFlags(16);
                return;
            }
            clearWindowFlags(134217728);
            addWindowFlags(Integer.MIN_VALUE);
            applySystemUiFlags(16);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public static class SystemUiManager extends AbsSystemUiManager {

        public final WindowInsetsController insetsController;
        public final KeyboardHelper keyboardHelper;

        public Window window;

        public SystemUiManager(Window window, KeyboardHelper keyboardHelper) {
            this(window.getInsetsController(), keyboardHelper);
            this.window = window;
        }

        public SystemUiManager(WindowInsetsController insetsController, KeyboardHelper keyboardHelper) {
            this.insetsController = insetsController;
            this.keyboardHelper = keyboardHelper;
        }

        // ----------------------------------------------
        // System UI / Insets Methods
        // ----------------------------------------------
        @Override
        public void showInsets(int type) {
            if (insetsController == null) return;

            final int TYPE_IME_FLAG = WindowInsets.Type.ime();

            if ((type & TYPE_IME_FLAG) != 0 && keyboardHelper != null) {
                keyboardHelper.requestFocusSafely();
            }

            insetsController.show(type & ~TYPE_IME_FLAG);
        }

        @Override
        public void hideInsets(int types) {
            if (insetsController == null) return;

            final int TYPE_IME_FLAG = WindowInsets.Type.ime();

            if ((types & TYPE_IME_FLAG) != 0 && keyboardHelper != null) {
                keyboardHelper.hideSoftKeyboard();
            }

            insetsController.hide(types & ~TYPE_IME_FLAG);
        }

        @Override
        public void setLightStatusBar(boolean enabled) {
            if (insetsController == null) return;

            final int FLAG = WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS;

            if (window != null) {
                if (enabled) applySystemUiFlags(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                else clearSystemUiFlags(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

            insetsController.setSystemBarsAppearance(enabled ? FLAG : 0, FLAG);
        }

        @Override
        public void setLightNavigationBar(boolean enabled) {
            if (insetsController == null) return;

            final int FLAG = WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS;

            if (window != null) {
                if (enabled) applySystemUiFlags(FLAG);
                else clearSystemUiFlags(FLAG);
            }

            insetsController.setSystemBarsAppearance(enabled ? FLAG : 0, FLAG);
        }

        @Override
        public void setSystemBarsBehavior(int behavior) {
            if (insetsController != null) {
                insetsController.setSystemBarsBehavior(behavior);
            }
        }

        // ----------------------------------------------
        // DecorView Helpers
        // ----------------------------------------------
        public void applySystemUiFlags(int flags) {
            if (window == null) return;

            View decorView = window.getDecorView();

            int currentFlags = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(currentFlags | flags);
        }

        public void clearSystemUiFlags(int flags) {
            if (window == null) return;

            View decorView = window.getDecorView();

            int currentFlags = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(currentFlags & ~flags);
        }
    }

    public SystemUiController(Window window, View decorView) {
        KeyboardHelper keyboardHelper = new KeyboardHelper(decorView);
        if (Build.VERSION.SDK_INT >= 30)
            systemUiManager = new SystemUiManager(window, keyboardHelper);
        else if (Build.VERSION.SDK_INT >= 26)
            systemUiManager = new LegacyManagerWithNav(window, keyboardHelper);
        else
            systemUiManager = new LegacyManager(window, keyboardHelper);
    }

    public void hideInsets(int types) {
        systemUiManager.hideInsets(types);
    }

    public void setLightNavigationBar(boolean enabled) {
        systemUiManager.setLightNavigationBar(enabled);
    }

    public void setLightStatusBar(boolean enabled) {
        systemUiManager.setLightStatusBar(enabled);
    }

    public void setSystemBarsBehavior(int behavior) {
        systemUiManager.setSystemBarsBehavior(behavior);
    }

    public void showInsets(int type) {
        systemUiManager.showInsets(type);
    }

    public static abstract class AbsSystemUiManager {
        public abstract void hideInsets(int types);

        public abstract void setLightStatusBar(boolean enabled);

        public abstract void setSystemBarsBehavior(int behavior);

        public abstract void showInsets(int type);

        public void setLightNavigationBar(boolean enabled) {
        }
    }
}
