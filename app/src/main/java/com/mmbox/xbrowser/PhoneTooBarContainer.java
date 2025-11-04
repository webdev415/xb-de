package com.mmbox.xbrowser;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class PhoneTooBarContainer extends LinearLayout {

    public OnTouchListener f4535a;

    public PhoneTooBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4535a = null;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        OnTouchListener onTouchListener = this.f4535a;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f4535a = onTouchListener;
    }
}
