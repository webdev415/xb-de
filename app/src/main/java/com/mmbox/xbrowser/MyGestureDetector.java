package com.mmbox.xbrowser;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import com.xbrowser.play.R;

import java.util.ArrayList;

public class MyGestureDetector {

    public int invalidGestureDistance = 0;

    public int validGestureDistance = 0;

    public ArrayList<Character> gestureSequence = new ArrayList<>();

    public final int touchSlop;

    public final int threshold;

    public MotionEvent initialMotionEvent;

    public GestureCallback gestureCallback;

    public interface GestureCallback {
        void onGestureDetected(String gesturePattern);
    }

    public MyGestureDetector(Context context, GestureCallback gestureCallback) {
        this.gestureCallback = gestureCallback;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.threshold = context.getResources().getDimensionPixelSize(R.dimen.gesture_min_delta_slot);
    }

    public char detectSwipeDirection(MotionEvent motionEvent, MotionEvent motionEvent2) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float x2 = motionEvent2.getX() - x;
        float y2 = motionEvent2.getY() - y;
        if (Math.abs(x2) > Math.abs(y2)) {
            if (x2 <= 0.0f || x2 <= this.touchSlop) {
                return (x2 >= 0.0f || Math.abs(x2) <= ((float) this.touchSlop)) ? '-' : 'L';
            }
            return 'R';
        }
        if (Math.abs(y2) <= Math.abs(x2)) {
            return '-';
        }
        if (y2 <= 0.0f || y2 <= this.touchSlop) {
            return (y2 >= 0.0f || Math.abs(y2) <= ((float) this.touchSlop)) ? '-' : 'U';
        }
        return 'D';
    }

    public String getGesturePattern() {
        StringBuilder builder = new StringBuilder();
        for (Character character : this.gestureSequence) {
            builder.append(character.charValue());
        }
        return builder.toString();
    }

    public boolean handleMotionEvent(MotionEvent event) {
        if (event == null) return false;

        // Get X and Y coordinates from MotionEvent
        float currentX = event.getX();
        float currentY = event.getY();

        // Action 0: Initialize the motion
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            this.initialMotionEvent = MotionEvent.obtain(event);
            return false;
        }

        // Action 2: Handle movement
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            if (this.initialMotionEvent == null)
                return false;

            float deltaX = Math.abs(currentX - initialMotionEvent.getX());
            float deltaY = Math.abs(currentY - initialMotionEvent.getY());

            // If movement exceeds the threshold
            if (deltaX > this.threshold) {
                char direction = detectSwipeDirection(this.initialMotionEvent, event);

                // Direction checks
                boolean shouldClear = false;
                if (direction == 'D' || direction == 'U') {
                    shouldClear = true;
                }

                if (direction == 'L' || direction == 'R') {
                    shouldClear = false;
                }

                // Calculate distance squared
                int distanceSquared = (int) (deltaX * deltaX + deltaY * deltaY);

                // Handle the list of directions
                if (this.gestureSequence.isEmpty() || direction != this.gestureSequence.get(this.gestureSequence.size() - 1)) {
                    this.gestureSequence.add(direction);
                }

                // Check for angle thresholds
                if (Math.toDegrees(Math.atan(deltaY / deltaX)) >= 30.0d || Math.toDegrees(Math.atan(deltaX / deltaY)) >= 30.0d) {
                    shouldClear = true;
                }

                // Update totals based on whether we should clear
                if (shouldClear) {
                    this.validGestureDistance += distanceSquared;
                } else {
                    this.invalidGestureDistance += distanceSquared;
                }

                return false;
            }
        }

        // Action 1: End of movement
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (this.invalidGestureDistance < this.validGestureDistance) {
                this.gestureCallback.onGestureDetected(getGesturePattern());
            }
            // Reset after action up
            this.invalidGestureDistance = 0;
            this.validGestureDistance = 0;
            this.gestureSequence.clear();
            return false;
        }

        return false;
    }
}
