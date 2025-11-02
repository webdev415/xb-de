package com.mmbox.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.xbrowser.play.R;

/**
 * A custom FrameLayout that can optionally draw a semi-transparent overlay color on top of its contents.
 * Typically used as the main browser container background, with the ability to dim or shade content dynamically.
 */
public class BrowserMainContainer extends FrameLayout {

    /** Whether the overlay color should be drawn. */
    private boolean drawOverlay = false;

    /** The color of the overlay (including alpha). */
    private int overlayColor = 0x50000000; // Default: semi-transparent black (≈ 1342177280)

    public BrowserMainContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Enables or disables the overlay with the default color.
     *
     * @param enabled true to draw overlay, false to disable
     */
    public void setOverlayEnabled(boolean enabled) {
        setOverlay(enabled, overlayColor);
    }

    /**
     * Enables or disables the overlay with a specific color.
     *
     * @param enabled whether to show the overlay
     * @param color the color (including alpha) of the overlay
     */
    public void setOverlay(boolean enabled, int color) {
        this.overlayColor = color;
        this.drawOverlay = enabled;
        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (drawOverlay) {
            canvas.drawColor(overlayColor);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        // Hide the fast scroll bar holder if present
        View fastScrollBar = findViewById(R.id.fast_scroll_bar_holder);
        if (fastScrollBar != null) {
            fastScrollBar.setVisibility(View.INVISIBLE);
        }
    }
}
