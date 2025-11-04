package p000;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

public class C0848Sb {

    public static C0848Sb instance;

    public BrowserActivity browserActivity;
    public View fullscreenFloatBtnHolder;
    public long lastTouchTime;
    public float offsetX;
    public float offsetY;
    public int lastX;
    public int lastY;
    public int btnRightMargin;
    public int btnBottomMargin;

    private static final int MAX_TOUCH_DELTA = 10;
    private static final int MAX_CLICK_TIME = 200;

    // Singleton instance
    public static C0848Sb getInstance() {
        if (instance == null) {
            instance = new C0848Sb();
        }
        return instance;
    }

    // Hide the floating button
    public void hideFloatingButton() {
        this.fullscreenFloatBtnHolder.setVisibility(View.INVISIBLE);
    }

    // Initialize the floating button
    public void init(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
        this.fullscreenFloatBtnHolder = browserActivity.findViewById(R.id.fullscreen_float_btn_holder);

        // Load margins from resources
        this.btnRightMargin = (int) this.browserActivity.getResources().getDimension(R.dimen.full_screen_float_btn_right_margin);
        this.btnBottomMargin = (int) this.browserActivity.getResources().getDimension(R.dimen.full_screen_float_btn_bottom_margin);

        // Set button click listener
        this.fullscreenFloatBtnHolder.setOnClickListener(view -> this.browserActivity.getBrowserFrameLayout().m6457f());

        // Load last position from SharedPreferences
        this.lastX = SharedPreferencesHelper.getInstance().getInt("last_float_btn_x", -1);
        this.lastY = SharedPreferencesHelper.getInstance().getInt("last_float_btn_y", -1);

        // Set touch listener
        this.fullscreenFloatBtnHolder.setOnTouchListener(new View.OnTouchListener() {

            private float initialTouchX;
            private float initialTouchY;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getActionMasked();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        onActionDown(view, motionEvent);
                        break;

                    case MotionEvent.ACTION_UP:
                        onActionUp(view, motionEvent);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        onActionMove(view, motionEvent);
                        break;

                    default:
                        return false;
                }

                return true;
            }

            private void onActionDown(View view, MotionEvent motionEvent) {
                offsetX = view.getX() - motionEvent.getRawX();
                offsetY = view.getY() - motionEvent.getRawY();
                initialTouchX = motionEvent.getRawX();
                initialTouchY = motionEvent.getRawY();
                lastTouchTime = System.currentTimeMillis();
            }

            private void onActionUp(View view, MotionEvent motionEvent) {
                long elapsedTime = System.currentTimeMillis() - lastTouchTime;
                float deltaX = Math.abs(motionEvent.getRawX() - initialTouchX);
                float deltaY = Math.abs(motionEvent.getRawY() - initialTouchY);

                // If the touch was quick and small, perform a click
                if (elapsedTime < MAX_CLICK_TIME && deltaX < MAX_TOUCH_DELTA && deltaY < MAX_TOUCH_DELTA) {
                    view.performClick();
                }
            }

            private void onActionMove(View view, MotionEvent motionEvent) {
                float rawX = motionEvent.getRawX() + offsetX;
                float rawY = motionEvent.getRawY() + offsetY;

                // Ensure the floating button stays within screen bounds
                rawX = clamp(rawX, 0, browserActivity.getWindow().getDecorView().getWidth() - view.getWidth());
                rawY = clamp(rawY, 0, browserActivity.getWindow().getDecorView().getHeight() - view.getHeight());

                view.setX(rawX);
                view.setY(rawY);

                // Save the position for later use
                lastX = (int) rawX;
                lastY = (int) rawY;
            }
        });
    }

    // Save the button position to SharedPreferences
    public void savePosition() {
        SharedPreferencesHelper.getInstance().putInt("last_float_btn_x", (int) fullscreenFloatBtnHolder.getX());
        SharedPreferencesHelper.getInstance().putInt("last_float_btn_y", (int) fullscreenFloatBtnHolder.getY());
    }

    // Restore the button's last position
    public void restorePosition() {
        fullscreenFloatBtnHolder.post(() -> {
            if (lastY <= 0 || lastX >= browserActivity.getWindow().getDecorView().getWidth() - fullscreenFloatBtnHolder.getWidth() ||
                    lastY <= 0 || lastY >= browserActivity.getWindow().getDecorView().getHeight() - fullscreenFloatBtnHolder.getHeight()) {
                // Position button at the bottom-right corner if out of bounds
                fullscreenFloatBtnHolder.setX(browserActivity.getWindow().getDecorView().getWidth() - fullscreenFloatBtnHolder.getWidth() - btnRightMargin);
                fullscreenFloatBtnHolder.setY(browserActivity.getWindow().getDecorView().getHeight() - fullscreenFloatBtnHolder.getHeight() - btnBottomMargin);
            } else {
                fullscreenFloatBtnHolder.setX(lastX);
                fullscreenFloatBtnHolder.setY(lastY);
            }
            fullscreenFloatBtnHolder.setVisibility(View.VISIBLE);
        });
    }

    // Check if the motion event is within the floating button's bounds
    public boolean isTouchInside(MotionEvent motionEvent) {
        Rect rect = new Rect();
        fullscreenFloatBtnHolder.getHitRect(rect);
        return rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    // Clamp value to a given range
    private float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(value, max));
    }
}
