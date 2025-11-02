package com.mmbox.widget.swiperefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

import androidx.annotation.StyleableRes;

public class SwipeRefreshLayout extends ViewGroup {

    @SuppressLint("ResourceType")
    @StyleableRes
    public static final int[] ENABLED_ATTRS = {android.R.attr.enabled};

    public final Animation refreshToStartAnimation;
    public final Animation moveToTargetAnimation;

    public OnRefreshListener onRefreshListener;

    public boolean isRefreshingState;
    public float distanceToTriggerSync;

    public final int mediumAnimationDuration;

    public int circleCurrentTop;

    public boolean isCircleBeingDragged;
    public boolean isCircleBeingAnimated;
    public boolean scaleEnabled;

    public final DecelerateInterpolator decelerateInterpolator;

    public CircleImageView circleView;

    public int circleIndex;
    public int circleWidth;
    public float animationProgress;
    public int circleStartTop;

    public CircularProgressDrawable progressDrawable;

    public Animation scaleUpAnimation;
    public Animation scaleDownAnimation;
    public Animation alphaHideAnimation;

    public Animation.AnimationListener refreshAnimationListener;
    public float totalDragDistance;

    public boolean notifyListener;
    public int circleDiameter;
    public int circleDiameterPx;
    public boolean circleScaled;

    public final Animation.AnimationListener defaultAnimationListener;

    public class DefaultAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationEnd(Animation animation) {
            if (isRefreshingState) {
                progressDrawable.setAlpha(255);
                progressDrawable.start();
                if (notifyListener && onRefreshListener != null) {
                    onRefreshListener.onRefresh();
                }
            } else {
                resetSpinner();
            }
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            swipeRefreshLayout.circleCurrentTop = swipeRefreshLayout.circleView.getTop();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }
    }

    public class ScaleUpAnimation extends Animation {
        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            setAnimationProgress(interpolatedTime);
        }
    }

    public class ScaleDownAnimation extends Animation {
        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            setAnimationProgress(1.0f - interpolatedTime);
        }
    }

    public class CircleReturnAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationEnd(Animation animation) {
            if (scaleEnabled) {
                return;
            }
            animateCircleToStartPosition(defaultAnimationListener);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }
    }

    public class CircleTranslateAnimation extends Animation {
        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            int distance = (int) (!circleScaled ? totalDragDistance - Math.abs(circleStartTop) : totalDragDistance);
            moveCircle((circleWidth + (int) ((distance - circleWidth) * interpolatedTime)) - circleView.getTop(), false);
            progressDrawable.setProgress(1.0f - interpolatedTime);
        }
    }

    public class CircleOffsetAnimation extends Animation {
        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            updateCirclePosition(interpolatedTime);
        }
    }

    public class CircleOffsetReverseAnimation extends Animation {
        @Override
        public void applyTransformation(float interpolatedTime, Transformation t) {
            setAnimationProgress(animationProgress + ((-animationProgress) * interpolatedTime));
            updateCirclePosition(interpolatedTime);
        }
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        isRefreshingState = false;
        distanceToTriggerSync = -1.0f;
        isCircleBeingAnimated = false;
        circleIndex = -1;
        defaultAnimationListener = new DefaultAnimationListener();
        refreshToStartAnimation = new CircleTranslateAnimation();
        moveToTargetAnimation = new CircleOffsetAnimation();
        mediumAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        decelerateInterpolator = new DecelerateInterpolator(2.0f);

        TypedArray a = context.obtainStyledAttributes(attrs, ENABLED_ATTRS);
        setEnabled(a.getBoolean(0, true));
        a.recycle();

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float density = metrics.density;
        circleDiameter = (int) (density * 40.0f);
        circleDiameterPx = (int) (density * 40.0f);

        createProgressCircle();
        setChildrenDrawingOrderEnabled(true);

        totalDragDistance = density * 64.0f;
        distanceToTriggerSync = totalDragDistance;
    }

    public void setAnimationProgress(float progress) {
        if (isScalingEnabled()) {
            setColorViewAlpha((int) (progress * 255.0f));
        } else {
            circleView.setScaleX(progress);
            circleView.setScaleY(progress);
        }
    }

    private void setColorViewAlpha(int alpha) {
        circleView.getBackground().setAlpha(alpha);
        progressDrawable.setAlpha(alpha);
    }

    public boolean startManualRefresh() {
        if (!isEnabled() || isRefreshingState) {
            return false;
        }
        circleView.clearAnimation();
        progressDrawable.stop();
        moveCircle(circleStartTop - circleView.getTop(), true);
        totalDragDistance = 0.0f;
        isCircleBeingAnimated = true;
        progressDrawable.setAlpha(76);
        return true;
    }

    public final void animateCircleToStartPosition(Animation.AnimationListener listener) {
        if (scaleDownAnimation == null) {
            ScaleDownAnimation scaleDown = new ScaleDownAnimation();
            scaleDownAnimation = scaleDown;
            scaleDown.setDuration(150L);
        }
        circleView.setAnimationListener(listener);
        circleView.clearAnimation();
        circleView.startAnimation(scaleDownAnimation);
    }

    public final void animateCircleToPosition(int targetTop, Animation.AnimationListener listener) {
        circleWidth = targetTop;
        animationProgress = isScalingEnabled() ? progressDrawable.getAlpha() : circleView.getScaleX();
        if (alphaHideAnimation == null) {
            CircleOffsetReverseAnimation anim = new CircleOffsetReverseAnimation();
            alphaHideAnimation = anim;
            anim.setDuration(150L);
        }
        if (listener != null) {
            circleView.setAnimationListener(listener);
        }
        circleView.clearAnimation();
        circleView.startAnimation(alphaHideAnimation);
    }

    public final void animateCircleToRefreshPosition(Animation.AnimationListener listener) {
        circleView.setVisibility(VISIBLE);
        progressDrawable.setAlpha(255);
        if (scaleUpAnimation == null) {
            ScaleUpAnimation anim = new ScaleUpAnimation();
            scaleUpAnimation = anim;
            anim.setDuration(mediumAnimationDuration);
        }
        if (listener != null) {
            circleView.setAnimationListener(listener);
        }
        circleView.clearAnimation();
        circleView.startAnimation(scaleUpAnimation);
    }

    @Override
    public int getChildDrawingOrder(int childCount, int i) {
        int index = circleIndex;
        return index < 0 ? i : i == childCount - 1 ? index : i >= index ? i + 1 : i;
    }

    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int measuredWidth = getMeasuredWidth();
        if (getChildCount() == 0) return;

        int circleWidthMeasured = circleView.getMeasuredWidth();
        int circleHeightMeasured = circleView.getMeasuredHeight();
        int mid = measuredWidth / 2;
        int halfCircle = circleWidthMeasured / 2;
        int currentTop = circleCurrentTop;

        circleView.layout(mid - halfCircle, currentTop, mid + halfCircle, circleHeightMeasured + currentTop);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        circleView.measure(MeasureSpec.makeMeasureSpec(circleDiameter, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(circleDiameterPx, MeasureSpec.EXACTLY));

        if (!circleScaled && !isCircleBeingAnimated) {
            isCircleBeingAnimated = true;
            int startTop = (int) (-circleView.getMeasuredHeight() * 1.05f);
            circleStartTop = startTop;
            circleCurrentTop = startTop;
        }

        circleIndex = -1;
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) == circleView) {
                circleIndex = i;
                return;
            }
        }
    }

    public final void animateCircleBackToTop(int targetTop, Animation.AnimationListener listener) {
        circleWidth = targetTop;
        refreshToStartAnimation.reset();
        refreshToStartAnimation.setDuration(200L);
        refreshToStartAnimation.setInterpolator(decelerateInterpolator);

        if (listener != null) {
            circleView.setAnimationListener(listener);
        }
        circleView.clearAnimation();
        circleView.startAnimation(refreshToStartAnimation);
    }

    public final void animateCircleTo(int targetTop, Animation.AnimationListener listener) {
        if (scaleEnabled) {
            animateCircleToPosition(targetTop, listener);
            return;
        }
        circleWidth = targetTop;
        moveToTargetAnimation.reset();
        moveToTargetAnimation.setDuration(200L);
        moveToTargetAnimation.setInterpolator(decelerateInterpolator);

        if (listener != null) {
            circleView.setAnimationListener(listener);
        }
        circleView.clearAnimation();
        circleView.startAnimation(moveToTargetAnimation);
    }

    public final void createProgressCircle() {
        circleView = new CircleImageView(getContext(), -328966, 20.0f);
        progressDrawable = new CircularProgressDrawable(getContext(), this);
        progressDrawable.setBackgroundColor(-328966);
        circleView.setImageDrawable(progressDrawable);
        circleView.setVisibility(GONE);
        addView(circleView);
    }

    public final boolean isScalingEnabled() {
        return false;
    }

    @Deprecated
    public void setColorScheme(int... colors) {
        setColorSchemeResources(colors);
    }

    public void setColorSchemeColors(int... colors) {
        progressDrawable.setColorSchemeColors(colors);
    }

    public void setColorSchemeResources(int... resIds) {
        Resources res = getResources();
        int[] colors = new int[resIds.length];
        for (int i = 0; i < resIds.length; i++) {
            colors[i] = res.getColor(resIds[i]);
        }
        setColorSchemeColors(colors);
    }

    public void setDistanceToTriggerSync(int distance) {
        distanceToTriggerSync = distance;
    }

    public void setOnRefreshListener(OnRefreshListener listener) {
        onRefreshListener = listener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int color) {
        setProgressBackgroundColorSchemeResource(color);
    }

    public void setProgressBackgroundColorSchemeColor(int color) {
        circleView.setBackgroundColor(color);
        progressDrawable.setBackgroundColor(color);
    }

    public void setProgressBackgroundColorSchemeResource(int resId) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(resId));
    }

    public void setRefreshing(boolean refreshing) {
        if (!refreshing || isRefreshingState == refreshing) {
            setRefreshingState(refreshing, false);
            return;
        }
        isRefreshingState = refreshing;
        moveCircle(((int) (!circleScaled ? totalDragDistance + circleStartTop : totalDragDistance)) - circleCurrentTop, true);
        notifyListener = false;
        animateCircleToRefreshPosition(defaultAnimationListener);
    }

    public void setSize(int size) {
        if (size == 0 || size == 1) {
            int dimension = (int) (getResources().getDisplayMetrics().density * (size == 0 ? 56.0f : 40.0f));
            circleDiameter = dimension;
            circleDiameterPx = dimension;
            circleView.setImageDrawable(null);
            progressDrawable.setSize(size);
            circleView.setImageDrawable(progressDrawable);
        }
    }

    public boolean isRefreshing() {
        return isRefreshingState;
    }

    public final void updateCirclePosition(float fraction) {
        moveCircle((circleWidth + ((int) ((circleStartTop - circleWidth) * fraction))) - circleView.getTop(), false);
    }

    public void onPull(float overscroll) {
        if (isEnabled() && isCircleBeingAnimated) {
            float maxDistance = distanceToTriggerSync / 3.0f;
            float boundedDrag = totalDragDistance + Math.max(-maxDistance, Math.min(maxDistance, overscroll * 1.2f));
            totalDragDistance = boundedDrag;

            progressDrawable.setArrowEnabled(true);
            float dragFraction = boundedDrag / distanceToTriggerSync;
            if (dragFraction < 0.0f) return;

            float boundedFraction = Math.min(1.0f, Math.abs(dragFraction));
            float tensionFraction = (((float) Math.max(boundedFraction - 0.4, 0.0)) * 5.0f) / 3.0f;
            float extraOverscroll = Math.abs(boundedDrag) - distanceToTriggerSync;
            float slingshotDist = circleScaled ? totalDragDistance - circleStartTop : totalDragDistance;
            double tensionPercent = Math.max(0.0, Math.min(extraOverscroll, slingshotDist * 2.0) / slingshotDist) / 4.0;
            float tension = ((float) (tensionPercent - Math.pow(tensionPercent, 2.0))) * 2.0f;

            int targetTop = circleStartTop + ((int) ((slingshotDist * boundedFraction) + (slingshotDist * tension * 2.0f)));
            if (circleView.getVisibility() != VISIBLE) {
                circleView.setVisibility(VISIBLE);
            }
            if (!scaleEnabled) {
                circleView.setScaleX(1.0f);
                circleView.setScaleY(1.0f);
            }
            float triggerDistance = distanceToTriggerSync;
            if (boundedDrag < triggerDistance && scaleEnabled) {
                setAnimationProgress(boundedDrag / triggerDistance);
            }
            progressDrawable.setStartEndTrim(0.0f, Math.min(0.8f, tensionFraction * 0.8f));
            progressDrawable.setProgress(Math.min(1.0f, tensionFraction));
            progressDrawable.setAlpha(((int) (Math.max(0.0f, Math.min(1.0f, (boundedFraction - 0.9f) / 0.1f)) * 179.0f)) + 76);
            progressDrawable.setArrowScale((((tensionFraction * 0.4f) - 0.25f) + (tension * 2.0f)) * 0.5f);

            moveCircle(targetTop - circleCurrentTop, true);
        }
    }

    public void releaseAction(boolean notify) {
        if (isCircleBeingAnimated) {
            isCircleBeingAnimated = false;
            if (isEnabled() && notify && totalDragDistance > distanceToTriggerSync) {
                setRefreshingState(true, true);
                return;
            }
            isRefreshingState = false;
            progressDrawable.setStartEndTrim(0.0f, 0.0f);

            Animation.AnimationListener listener = null;
            if (!scaleEnabled) {
                if (refreshAnimationListener == null) {
                    refreshAnimationListener = new CircleReturnAnimationListener();
                }
                listener = refreshAnimationListener;
            }

            animateCircleTo(circleCurrentTop, listener);
            progressDrawable.setArrowEnabled(false);
        }
    }

    public void resetSpinner() {
        isCircleBeingAnimated = false;
        setRefreshingState(false, false);
        progressDrawable.stop();
        circleView.setVisibility(GONE);
        setColorViewAlpha(255);
        if (scaleEnabled) {
            setAnimationProgress(0.0f);
        } else {
            moveCircle(circleStartTop - circleCurrentTop, true);
        }
        circleCurrentTop = circleView.getTop();
    }

    public final void setRefreshingState(boolean refreshing, boolean notify) {
        if (isRefreshingState != refreshing) {
            notifyListener = notify;
            isRefreshingState = refreshing;
            if (refreshing) {
                animateCircleBackToTop(circleCurrentTop, defaultAnimationListener);
            } else {
                animateCircleToStartPosition(defaultAnimationListener);
            }
        }
    }

    public final void moveCircle(int offset, boolean update) {
        circleView.bringToFront();
        circleView.offsetTopAndBottom(offset);
        circleCurrentTop = circleView.getTop();
    }
}
