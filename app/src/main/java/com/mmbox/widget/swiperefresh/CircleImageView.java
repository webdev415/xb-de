package com.mmbox.widget.swiperefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/**
 * A circular ImageView used by SwipeRefreshLayout to show the refresh indicator.
 * Draws either a simple circle or one with a soft drop shadow depending on elevation support.
 */
class CircleImageView extends ImageView {

    private Animation.AnimationListener animationListener;
    private final int shadowRadius;

    public CircleImageView(@NonNull Context context, @ColorInt int color, float diameterDp) {
        super(context);

        final float density = getResources().getDisplayMetrics().density;
        this.shadowRadius = (int) (3.5f * density);

        ShapeDrawable backgroundDrawable = supportsElevation()
                ? createSimpleCircle()
                : createShadowedCircle(diameterDp, density);

        backgroundDrawable.getPaint().setColor(color);
        setBackground(backgroundDrawable);
    }

    /**
     * Determines if this device supports elevation shadows (Lollipop+).
     */
    private boolean supportsElevation() {
        return true; // always true for modern Android
    }

    /**
     * Creates a simple circular shape without shadow.
     */
    private ShapeDrawable createSimpleCircle() {
        return new ShapeDrawable(new OvalShape());
    }

    /**
     * Creates a circular shape with a soft shadow using RadialGradient.
     */
    private ShapeDrawable createShadowedCircle(float diameterDp, float density) {
        int diameterPx = (int) (diameterDp * density * 2f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new ShadowOvalShape(shadowRadius, diameterPx));
        setLayerType(LAYER_TYPE_SOFTWARE, shapeDrawable.getPaint());

        shapeDrawable.getPaint().setShadowLayer(
                shadowRadius,
                0,
                (int) (1.75f * density),
                0x1E000000 // semi-transparent shadow color
        );

        setPadding(shadowRadius, shadowRadius, shadowRadius, shadowRadius);
        return shapeDrawable;
    }

    /**
     * Custom oval shape with a radial gradient shadow.
     */
    private class ShadowOvalShape extends OvalShape {
        private final Paint shadowPaint = new Paint();
        private final int shadowRadius;
        private final int circleDiameter;
        private final RadialGradient radialGradient;

        ShadowOvalShape(int shadowRadius, int circleDiameter) {
            this.shadowRadius = shadowRadius;
            this.circleDiameter = circleDiameter;
            radialGradient = new RadialGradient(
                    circleDiameter / 2f,
                    circleDiameter / 2f,
                    shadowRadius,
                    new int[]{0x3D000000, 0x00000000}, // gradient fade
                    null,
                    Shader.TileMode.CLAMP
            );
            shadowPaint.setShader(radialGradient);
        }

        @Override
        public void draw(Canvas canvas, Paint paint) {
            float cx = CircleImageView.this.getWidth() / 2f;
            float cy = CircleImageView.this.getHeight() / 2f;

            // Draw shadow circle
            canvas.drawCircle(cx, cy, (circleDiameter / 2f) + shadowRadius, shadowPaint);
            // Draw main circle
            canvas.drawCircle(cx, cy, circleDiameter / 2f, paint);
        }
    }

    /**
     * Sets an animation listener for start and end callbacks.
     */
    public void setAnimationListener(Animation.AnimationListener listener) {
        this.animationListener = listener;
    }

    @Override
    public void onAnimationStart() {
        super.onAnimationStart();
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override
    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!supportsElevation()) {
            setMeasuredDimension(
                    getMeasuredWidth() + shadowRadius * 2,
                    getMeasuredHeight() + shadowRadius * 2
            );
        }
    }

    @Override
    public void setBackgroundColor(@ColorInt int color) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(color);
        }
    }
}
