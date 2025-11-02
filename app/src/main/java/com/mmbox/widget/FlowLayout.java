package com.mmbox.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple FlowLayout that arranges child views horizontally and wraps them to a new line
 * when they exceed the available width.
 */
public class FlowLayout extends ViewGroup {

    /**
     * The current row height, including spacing.
     */
    private int lineHeight;

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Custom LayoutParams with horizontal and vertical spacing between child views.
     */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public final int horizontalSpacing;
        public final int verticalSpacing;

        public LayoutParams(int horizontalSpacing, int verticalSpacing) {
            super(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            this.horizontalSpacing = horizontalSpacing;
            this.verticalSpacing = verticalSpacing;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int childCount = getChildCount();
        int xPos = getPaddingLeft();
        int yPos = getPaddingTop();
        lineHeight = 0;

        int childHeightSpec = (heightMode == MeasureSpec.AT_MOST)
                ? MeasureSpec.makeMeasureSpec(parentHeight, MeasureSpec.AT_MOST)
                : MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) continue;

            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            child.measure(MeasureSpec.makeMeasureSpec(parentWidth, MeasureSpec.AT_MOST), childHeightSpec);

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            lineHeight = Math.max(lineHeight, childHeight + lp.verticalSpacing);

            if (xPos + childWidth > parentWidth) {
                // Move to next line
                xPos = getPaddingLeft();
                yPos += lineHeight;
            }

            xPos += childWidth + lp.horizontalSpacing;
        }

        int finalHeight = yPos + lineHeight + getPaddingBottom();

        if (heightMode == MeasureSpec.EXACTLY) {
            finalHeight = parentHeight;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            finalHeight = Math.min(finalHeight, parentHeight);
        }

        setMeasuredDimension(parentWidth, finalHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int parentWidth = right - left;
        int xPos = getPaddingLeft();
        int yPos = getPaddingTop();

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE) continue;

            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            if (xPos + childWidth > parentWidth) {
                xPos = getPaddingLeft();
                yPos += lineHeight;
            }

            child.layout(xPos, yPos, xPos + childWidth, yPos + childHeight);
            xPos += childWidth + lp.horizontalSpacing;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Consume all touch events (if needed for overlay interception)
        return true;
    }
}
