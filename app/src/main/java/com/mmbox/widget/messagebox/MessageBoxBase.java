package com.mmbox.widget.messagebox;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.xbrowser.play.R;

/**
 * Base class for a swipe-dismissable message box.
 * Handles drag gestures, velocity tracking, and fade animations.
 */
public abstract class MessageBoxBase extends FrameLayout {

    // Animation duration (in ms)
    public long animationDuration;

    // Touch coordinates
    public float startX;
    public float startY;

    // Whether currently swiping horizontally
    public boolean isSwiping;

    // Swipe direction threshold
    public int swipeThreshold;

    // Velocity tracking
    public VelocityTracker velocityTracker;

    // Touch pointer id
    public int activePointerId;

    // The view being dismissed
    public View swipeView;

    // Whether a swipe is locked
    public boolean swipeLocked;

    // View width cache
    public int viewWidth;

    // Min & max velocity thresholds
    public int minFlingVelocity;
    public int maxFlingVelocity;

    // Swipe detection sensitivity
    public int touchSlop;

    // Message style type (used for animation)
    public int messageStyle;

    // Is message currently shown
    public boolean isShown;

    // Listener for message box events
    public MessageBoxListener listener;


    /**
     * Animation listener for dismiss animation.
     */
    public class DismissAnimationListener extends AnimatorListenerAdapter {
        @Override
        public void onAnimationEnd(Animator animator) {
            if (listener != null) {
                listener.onDismissed();
            }
            removeFromParent();
        }
    }


    /**
     * Listener interface for message box actions.
     */
    public interface MessageBoxListener {
        void onShown();
        void onDismissed();
        void onDismiss();
    }


    @SuppressLint("ResourceType")
    public MessageBoxBase(Context context) {
        super(context);
        this.viewWidth = 1;
        this.isShown = false;
        setId(4672);
        this.animationDuration = context.getResources().getInteger(android.R.integer.config_shortAnimTime);
    }


    /**
     * Removes this view from its parent container and notifies listener.
     */
    public void removeFromParent() {
        FrameLayout parent = (FrameLayout) getTag();
        if (parent != null) {
            parent.removeView(this);
        }
        if (listener != null) {
            listener.onDismiss();
        }
        this.isShown = false;
    }


    public boolean isShowing() {
        return this.isShown;
    }


    /**
     * Adds this message box to a container with entry animation.
     */
    public void show(FrameLayout container) {
        container.removeView(this);
        setTag(container);

        if (this.messageStyle == 3) {
            setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.faid_in));
        } else {
            setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.message_bar_show_anim));
        }

        container.addView(this);
        this.isShown = true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.viewWidth < 2) {
            this.viewWidth = getWidth();
        }

        this.swipeView = this;
        int action = event.getActionMasked();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (this.swipeLocked) {
                    return false;
                }
                if (this.swipeView != null) {
                    this.startX = event.getRawX();
                    this.startY = event.getRawY();
                    this.velocityTracker = VelocityTracker.obtain();
                    this.velocityTracker.addMovement(event);
                }
                return true;

            case MotionEvent.ACTION_MOVE:
                if (this.velocityTracker != null && !this.swipeLocked) {
                    this.velocityTracker.addMovement(event);
                    float deltaX = event.getRawX() - this.startX;
                    float deltaY = event.getRawY() - this.startY;

                    if (Math.abs(deltaX) > this.touchSlop && Math.abs(deltaY) < Math.abs(deltaX) / 2f) {
                        this.isSwiping = true;
                        this.swipeThreshold = deltaX > 0 ? this.touchSlop : -this.touchSlop;
                        MotionEvent cancelEvent = MotionEvent.obtain(event);
                        cancelEvent.setAction((event.getActionIndex() << 8) | MotionEvent.ACTION_CANCEL);
                        cancelEvent.recycle();
                    }

                    if (this.isSwiping) {
                        this.swipeView.setTranslationX(deltaX - this.swipeThreshold);
                        float alpha = 1f - (Math.abs(deltaX) * 2f / this.viewWidth);
                        this.swipeView.setAlpha(Math.max(0f, Math.min(1f, alpha)));
                        return true;
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                if (this.velocityTracker != null) {
                    float deltaX = event.getRawX() - this.startX;
                    this.velocityTracker.addMovement(event);
                    this.velocityTracker.computeCurrentVelocity(1000);

                    float xVelocity = this.velocityTracker.getXVelocity();
                    float absXVelocity = Math.abs(xVelocity);
                    float absYVelocity = Math.abs(this.velocityTracker.getYVelocity());

                    boolean dismiss = false;
                    boolean toRight = false;

                    if (Math.abs(deltaX) > this.viewWidth / 4f && this.isSwiping) {
                        dismiss = true;
                        toRight = deltaX > 0;
                    } else if (this.minFlingVelocity <= absXVelocity && absXVelocity <= this.maxFlingVelocity &&
                            absYVelocity < absXVelocity && this.isSwiping) {
                        dismiss = ((xVelocity < 0) == (deltaX < 0));
                        toRight = xVelocity > 0;
                    }

                    if (dismiss) {
                        this.swipeView.animate()
                                .translationX(toRight ? this.viewWidth : -this.viewWidth)
                                .alpha(0f)
                                .setDuration(this.animationDuration)
                                .setListener(new DismissAnimationListener());
                    } else {
                        this.swipeView.animate()
                                .translationX(0f)
                                .alpha(1f)
                                .setDuration(this.animationDuration)
                                .setListener(null);
                    }

                    // Reset
                    this.velocityTracker.recycle();
                    this.velocityTracker = null;
                    this.startX = 0f;
                    this.startY = 0f;
                    this.swipeView = null;
                    this.activePointerId = -1;
                    this.isSwiping = false;
                }
                break;

            case MotionEvent.ACTION_CANCEL:
                if (this.velocityTracker != null) {
                    View v = this.swipeView;
                    if (v != null && this.isSwiping) {
                        v.animate().translationX(0f).alpha(1f).setDuration(this.animationDuration).setListener(null);
                    }
                    this.velocityTracker.recycle();
                    this.velocityTracker = null;
                    this.startX = 0f;
                    this.startY = 0f;
                    this.swipeView = null;
                    this.activePointerId = -1;
                    this.isSwiping = false;
                }
                break;
        }

        return true;
    }


    /**
     * Sets the message box action listener.
     */
    public void setOnActionListener(MessageBoxListener listener) {
        this.listener = listener;
    }
}
