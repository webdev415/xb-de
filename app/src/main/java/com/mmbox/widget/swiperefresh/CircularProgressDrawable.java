package com.mmbox.widget.swiperefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

import p000.C0526La;

public class CircularProgressDrawable extends Drawable implements Animatable {

    public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final Interpolator MATERIAL_INTERPOLATOR = new C0526La(); // custom easing

    public final int[] colors;
    public final ArrayList<Animation> animations = new ArrayList<><>();
    public final Ring ring;

    public float rotation;

    public final Resources resources;
    public final View parentView;

    public Animation mainAnimation;

    public float rotationCount;

    public double width;
    public double height;

    public boolean finishing;

    public final Callback drawableCallback;

    // === Inner classes ===

    public class RingAnimation extends Animation {
        public final Ring targetRing;

        public RingAnimation(Ring ring) {
            this.targetRing = ring;
        }

        @Override
        public void applyTransformation(float interpolatedTime, Transformation transformation) {
            if (finishing) {
                applyFinishTranslation(interpolatedTime, targetRing);
                return;
            }
            float startTrim = getStartingTrim(targetRing);
            float startAngle = targetRing.getStartTrim();
            float endAngle = targetRing.getEndTrim();
            float rotation = targetRing.getRotation();
            updateRingColor(interpolatedTime, targetRing);
            if (interpolatedTime <= 0.5f) {
                targetRing.setEndTrim(startAngle + ((0.8f - startTrim) * MATERIAL_INTERPOLATOR.getInterpolation(interpolatedTime / 0.5f)));
            }
            if (interpolatedTime > 0.5f) {
                targetRing.setStartTrim(startAngle + ((0.8f - startTrim) * MATERIAL_INTERPOLATOR.getInterpolation((interpolatedTime - 0.5f) / 0.5f)));
            }
            targetRing.setRotation(rotation + (0.25f * interpolatedTime));
            setRotation((interpolatedTime * 216.0f) + ((rotationCount / 5.0f) * 1080.0f));
        }
    }

    public class DrawableCallback implements Callback {
        @Override
        public void invalidateDrawable(Drawable drawable) {
            invalidateSelf();
        }

        @Override
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long time) {
            scheduleSelf(runnable, time);
        }

        @Override
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            unscheduleSelf(runnable);
        }
    }

    public static class Ring {
        public final RectF bounds = new RectF();
        public final Paint paint;
        public final Paint arrowPaint;
        public final Callback callback;

        public float startTrim;
        public float endTrim;
        public float rotation;
        public float strokeWidth = 5.0f;
        public float centerRadius = 2.5f;

        public int[] colors;
        public int colorIndex;
        public int alpha;
        public float startFraction;
        public float endFraction;
        public boolean showArrow;
        public Path arrow;
        public float arrowScale = 1.0f;
        public double radius;
        public int arrowWidth;
        public int arrowHeight;
        public int arrowColor;
        public final Paint backgroundPaint;
        public int currentColor;
        public int nextColor;

        public Ring(Callback callback) {
            this.callback = callback;
            this.paint = new Paint();
            this.arrowPaint = new Paint();
            this.backgroundPaint = new Paint();

            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);

            arrowPaint.setStyle(Paint.Style.FILL);
            arrowPaint.setAntiAlias(true);
        }

        public void setSize(int width, int height) {
            double halfStroke = (radius <= 0 || width < 0) ? Math.ceil(strokeWidth / 2.0f) : (width / 2.0f) - radius;
            centerRadius = (float) halfStroke;
        }

        public void setRotation(float rotation) {
            this.rotation = rotation;
            invalidate();
        }

        public void setShowArrow(boolean showArrow) {
            if (this.showArrow != showArrow) {
                this.showArrow = showArrow;
                invalidate();
            }
        }

        public void setStartTrim(float startTrim) {
            this.startTrim = startTrim;
            invalidate();
        }

        public void setStrokeWidth(float strokeWidth) {
            this.strokeWidth = strokeWidth;
            paint.setStrokeWidth(strokeWidth);
            invalidate();
        }

        public void storeOriginals() {
            startFraction = startTrim;
            endFraction = endTrim;
            rotation = this.rotation;
        }

        public void draw(Canvas canvas, Rect bounds) {
            RectF arcBounds = this.bounds;
            arcBounds.set(bounds);
            arcBounds.inset(centerRadius, centerRadius);

            float startAngle = startTrim * 360.0f;
            float sweepAngle = (endTrim + rotation) * 360.0f - startAngle;

            paint.setColor(currentColor);
            canvas.drawArc(arcBounds, startAngle, sweepAngle, false, paint);

            drawArrow(canvas, startAngle, sweepAngle, bounds);

            if (alpha < 255) {
                backgroundPaint.setColor(nextColor);
                backgroundPaint.setAlpha(255 - alpha);
                canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), bounds.width() / 2.0f, backgroundPaint);
            }
        }

        private void drawArrow(Canvas canvas, float startAngle, float sweepAngle, Rect bounds) {
            if (!showArrow) return;

            if (arrow == null) arrow = new Path();
            else arrow.reset();

            float arrowRadiusOffset = ((int) centerRadius / 2.0f) * arrowScale;
            float centerX = (float) (radius * Math.cos(0.0d) + bounds.exactCenterX());
            float centerY = (float) (radius * Math.sin(0.0d) + bounds.exactCenterY());

            arrow.moveTo(0.0f, 0.0f);
            arrow.lineTo(arrowWidth * arrowScale, 0.0f);
            arrow.lineTo((arrowWidth * arrowScale) / 2.0f, arrowHeight * arrowScale);
            arrow.offset(centerX - arrowRadiusOffset, centerY);
            arrow.close();

            arrowPaint.setColor(currentColor);
            canvas.rotate((startAngle + sweepAngle) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(arrow, arrowPaint);
        }

        public void setAlpha(int alpha) {
            this.alpha = alpha;
            invalidate();
        }

        public int getAlpha() {
            return alpha;
        }

        public float getStartTrim() {
            return startTrim;
        }

        public float getEndTrim() {
            return endTrim;
        }

        public void setEndTrim(float endTrim) {
            this.endTrim = endTrim;
            invalidate();
        }

        public float getRotation() {
            return rotation;
        }

        public void setRotationInternal(float rotation) {
            this.rotation = rotation;
            invalidate();
        }

        public void nextColor() {
            setColorIndex((colorIndex + 1) % colors.length);
        }

        public void setColorIndex(int index) {
            colorIndex = index;
            currentColor = colors[index];
        }

        public void setColors(int[] colors) {
            this.colors = colors;
            setColorIndex(0);
        }

        public void resetOriginals() {
            startFraction = 0.0f;
            endFraction = 0.0f;
            rotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotationInternal(0.0f);
        }

        public void setArrowDimensions(float width, float height) {
            arrowWidth = (int) width;
            arrowHeight = (int) height;
        }

        public void setArrowScale(float scale) {
            if (arrowScale != scale) {
                arrowScale = scale;
                invalidate();
            }
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public void setColor(int color) {
            currentColor = color;
        }

        public void setColorFilter(ColorFilter filter) {
            paint.setColorFilter(filter);
            invalidate();
        }

        private void invalidate() {
            callback.invalidateDrawable(null);
        }
    }

    // === Constructor ===
    public CircularProgressDrawable(Context context, View view) {
        colors = new int[]{0xFF000000};
        drawableCallback = new DrawableCallback();
        parentView = view;
        resources = context.getResources();
        ring = new Ring(drawableCallback);
        ring.setColors(colors);
        setSize(1);
        setupAnimation();
    }

    // === Utility ===
    public static boolean isLayoutRtl(View view) {
        return view.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL;
    }

    // === Draw ===
    @Override
    public void draw(Canvas canvas) {
        boolean isRtl = isLayoutRtl(parentView);
        Rect bounds = getBounds();
        int save = canvas.save();
        if (isRtl) canvas.scale(-1.0f, 1.0f, bounds.exactCenterX(), bounds.exactCenterY());
        canvas.rotate(rotation, bounds.exactCenterX(), bounds.exactCenterY());
        ring.draw(canvas, bounds);
        if (isRtl) canvas.scale(-1.0f, 1.0f, bounds.exactCenterX(), bounds.exactCenterY());
        canvas.restoreToCount(save);
    }

    @Override
    public int getAlpha() {
        return ring.getAlpha();
    }

    @Override
    public int getIntrinsicHeight() {
        return (int) height;
    }

    @Override
    public int getIntrinsicWidth() {
        return (int) width;
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setAlpha(int alpha) {
        ring.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        ring.setColorFilter(colorFilter);
    }

    @Override
    public boolean isRunning() {
        for (Animation animation : animations) {
            if (animation.hasStarted() && !animation.hasEnded()) return true;
        }
        return false;
    }

    @Override
    public void start() {
        long duration;
        mainAnimation.reset();
        ring.storeOriginals();
        if (ring.getEndTrim() != ring.getStartTrim()) {
            finishing = true;
            duration = 666;
        } else {
            ring.setColorIndex(0);
            ring.resetOriginals();
            duration = 1332;
        }
        mainAnimation.setDuration(duration);
        parentView.startAnimation(mainAnimation);
    }

    @Override
    public void stop() {
        parentView.clearAnimation();
        setRotation(0.0f);
        ring.setShowArrow(false);
        ring.setColorIndex(0);
        ring.resetOriginals();
    }

    public void setupAnimation() {
        RingAnimation anim = new RingAnimation(ring);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(Animation.RESTART);
        anim.setInterpolator(LINEAR_INTERPOLATOR);
        anim.setAnimationListener(new AnimationListener(ring));
        mainAnimation = anim;
    }

    public void setShowArrow(boolean showArrow) {
        ring.setShowArrow(showArrow);
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
        invalidateSelf();
    }

    public void setSize(int size) {
        if (size == 0) setDimensions(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        else setDimensions(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
    }

    public void setDimensions(double w, double h, double radius, double strokeWidth, float arrowWidth, float arrowHeight) {
        float density = resources.getDisplayMetrics().density;
        width = w * density;
        height = h * density;
        ring.setStrokeWidth((float) strokeWidth * density);
        ring.setRadius(radius * density);
        ring.setColorIndex(0);
        ring.setArrowDimensions(arrowWidth * density, arrowHeight * density);
        ring.setSize((int) width, (int) height);
    }

    public void setTrim(float start, float end) {
        ring.setStartTrim(start);
        ring.setEndTrim(end);
    }

    public void setProgress(float v) {
        ring.setArrowScale(v);
    }

    public void setBackgroundColor(int v) {
        ring.nextColor = v;
    }

    public void setColorSchemeColors(int... colors) {
        ring.setColors(colors);
        ring.setColorIndex(0);
    }

    // === Inner animation listener ===
    public class AnimationListener implements Animation.AnimationListener {
        public final Ring ring;

        public AnimationListener(Ring ring) {
            this.ring = ring;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            ring.storeOriginals();
            ring.nextColor();
            ring.setStartTrim(ring.getStartTrim());
            if (!finishing) rotationCount = (rotationCount + 1) % 5.0f;
            else {
                finishing = false;
                animation.setDuration(1332L);
                ring.setShowArrow(false);
            }
        }

        @Override
        public void onAnimationStart(Animation animation) {
            rotationCount = 0.0f;
        }

        @Override
        public void onAnimationEnd(Animation animation) {}
    }

    // === Color interpolation ===
    public final int interpolateColor(float fraction, int startColor, int endColor) {
        int startA = (startColor >> 24) & 255;
        int startR = (startColor >> 16) & 255;
        int startG = (startColor >> 8) & 255;
        int startB = startColor & 255;

        int endA = (endColor >> 24) & 255;
        int endR = (endColor >> 16) & 255;
        int endG = (endColor >> 8) & 255;
        int endB = endColor & 255;

        return ((startA + (int) ((endA - startA) * fraction)) << 24) |
                ((startR + (int) ((endR - startR) * fraction)) << 16) |
                ((startG + (int) ((endG - startG) * fraction)) << 8) |
                (startB + (int) ((endB - startB) * fraction));
    }

    public final float getStartingTrim(Ring ring) {
        return (float) Math.toRadians(ring.strokeWidth / (ring.radius * 2.0 * Math.PI));
    }

    public final void applyFinishTranslation(float fraction, Ring ring) {
        updateRingColor(fraction, ring);
        float endTrimFloor = (float) (Math.floor(ring.getRotation() / 0.8f) + 1.0d);
        ring.setStartTrim(ring.getEndTrim() + ((ring.getStartTrim() - getStartingTrim(ring) - ring.getEndTrim()) * fraction));
        ring.setEndTrim(ring.getEndTrim());
        ring.setRotationInternal(ring.getRotation() + ((endTrimFloor - ring.getRotation()) * fraction));
    }

    public final void updateRingColor(float fraction, Ring ring) {
        if (fraction > 0.75f) {
            ring.setColor(interpolateColor((fraction - 0.75f) / 0.25f, ring.currentColor, ring.colors[(ring.colorIndex + 1) % ring.colors.length]));
        }
    }
}
