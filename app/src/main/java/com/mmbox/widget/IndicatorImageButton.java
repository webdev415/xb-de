package com.mmbox.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageButton;

public class IndicatorImageButton extends ImageButton {

    public Paint textPaint;

    public final float textOffsetX;

    public final float textOffsetY;

    public String indicatorText = "1";

    public IndicatorImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        textPaint = new Paint();
        textPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTextSize((int) dpToPx(context, 10.0f));

        textOffsetX = dpToPx(context, 0.0f);
        textOffsetY = dpToPx(context, -8.0f);
    }

    public Paint getPaint() {
        return this.textPaint;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.isEmpty(indicatorText)) {
            return;
        }
        Rect drawableBounds = getDrawable() != null ? getDrawable().getBounds() : new Rect(0, 0, getWidth(), getHeight());
        Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();

        float textWidth = textPaint.measureText(indicatorText);
        float x = ((getMeasuredWidth() - textWidth) / 2.0f) - textOffsetX;
        float y = ((drawableBounds.bottom + drawableBounds.top - fontMetrics.bottom - fontMetrics.top) / 2f) - textOffsetY;
        canvas.drawText(indicatorText, x, y, textPaint);
    }

    public void setIndicatorText(String str) {
        this.indicatorText = str;
        invalidate();
    }

    private float dpToPx(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
