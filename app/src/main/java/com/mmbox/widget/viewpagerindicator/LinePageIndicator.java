package com.mmbox.widget.viewpagerindicator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.xbrowser.play.R;

/**
 * Minimal line-style indicator for ViewPager.
 */
public class LinePageIndicator extends View implements ViewPager.OnPageChangeListener {

    private final Paint unselectedPaint;
    private final Paint selectedPaint;

    private ViewPager viewPager;
    private ViewPager.OnPageChangeListener externalListener;

    private int currentPage;
    private boolean centered = true;
    private float lineWidth;
    private float gapWidth;
    private float strokeWidth;
    private int touchSlop;
    private int activePointerId = -1;
    private float lastMotionX = -1f;
    private boolean isDragging;

    public LinePageIndicator(Context context) {
        this(context, null);
    }

    public LinePageIndicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinePageIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        unselectedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        selectedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // Default values
        int defaultSelectedColor = 0xFFFFFFFF;
        int defaultUnselectedColor = 0x44FFFFFF;
        float defaultLineWidth = 20f;
        float defaultGapWidth = 10f;
        float defaultStrokeWidth = 5f;

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LinePageIndicator, defStyleAttr, 0);
            centered = a.getBoolean(R.styleable.LinePageIndicator_centered, true);
            lineWidth = a.getDimension(R.styleable.LinePageIndicator_lineWidth, defaultLineWidth);
            gapWidth = a.getDimension(R.styleable.LinePageIndicator_gapWidth, defaultGapWidth);
            strokeWidth = a.getDimension(R.styleable.LinePageIndicator_strokeWidth, defaultStrokeWidth);
            unselectedPaint.setColor(a.getColor(R.styleable.LinePageIndicator_unselectedColor, defaultUnselectedColor));
            selectedPaint.setColor(a.getColor(R.styleable.LinePageIndicator_selectedColor, defaultSelectedColor));
            a.recycle();
        } else {
            lineWidth = defaultLineWidth;
            gapWidth = defaultGapWidth;
            strokeWidth = defaultStrokeWidth;
            unselectedPaint.setColor(defaultUnselectedColor);
            selectedPaint.setColor(defaultSelectedColor);
        }

        unselectedPaint.setStrokeWidth(strokeWidth);
        selectedPaint.setStrokeWidth(strokeWidth);
        touchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    public void setViewPager(ViewPager pager) {
        if (pager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager must have an adapter");
        }
        this.viewPager = pager;
        pager.addOnPageChangeListener(this);
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.externalListener = listener;
    }

    public void setCurrentItem(int item) {
        if (viewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound");
        }
        viewPager.setCurrentItem(item);
        currentPage = item;
        invalidate();
    }

    @Override
    public void onPageScrolled(int position, float offset, int offsetPixels) {
        if (externalListener != null) {
            externalListener.onPageScrolled(position, offset, offsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        currentPage = position;
        invalidate();
        if (externalListener != null) {
            externalListener.onPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (externalListener != null) {
            externalListener.onPageScrollStateChanged(state);
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (viewPager == null || viewPager.getAdapter() == null) return;

        int count = viewPager.getAdapter().getCount();
        if (count == 0) return;

        float totalWidth = (count * lineWidth) + ((count - 1) * gapWidth);
        float startX = getPaddingLeft();
        float centerY = getHeight() / 2f;

        if (centered) {
            startX += (getWidth() - getPaddingLeft() - getPaddingRight() - totalWidth) / 2f;
        }

        for (int i = 0; i < count; i++) {
            float x = startX + i * (lineWidth + gapWidth);
            canvas.drawLine(x, centerY, x + lineWidth, centerY,
                    i == currentPage ? selectedPaint : unselectedPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = (viewPager != null && viewPager.getAdapter() != null)
                ? viewPager.getAdapter().getCount() : 0;

        float width = getPaddingLeft() + getPaddingRight()
                + (count * lineWidth) + ((count - 1) * gapWidth);
        float height = getPaddingTop() + getPaddingBottom() + strokeWidth;

        setMeasuredDimension((int) Math.ceil(width), (int) Math.ceil(height));
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // If superclass handles it, consume.
        if (super.onTouchEvent(event)) {
            return true;
        }

        if (viewPager == null || viewPager.getAdapter() == null || viewPager.getAdapter().getCount() == 0) {
            return false;
        }

        final int action = event.getAction() & MotionEvent.ACTION_MASK;

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                activePointerId = event.getPointerId(0);
                lastMotionX = event.getX();
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                final int activePointerIndex = event.findPointerIndex(activePointerId);
                final float x = event.getX(activePointerIndex);
                final float deltaX = x - lastMotionX;

                if (!isDragging && Math.abs(deltaX) > touchSlop) {
                    isDragging = true;
                }

                if (isDragging) {
                    lastMotionX = x;
                    if (viewPager.isFakeDragging() || viewPager.beginFakeDrag()) {
                        viewPager.fakeDragBy(deltaX);
                    }
                }
                break;
            }

            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP: {
                if (!isDragging) {
                    final int count = viewPager.getAdapter().getCount();
                    final float halfWidth = getWidth() / 2f;
                    final float sixthWidth = getWidth() / 6f;

                    if (currentPage > 0 && event.getX() < (halfWidth - sixthWidth)) {
                        viewPager.setCurrentItem(currentPage - 1);
                        return true;
                    } else if (currentPage < count - 1 && event.getX() > (halfWidth + sixthWidth)) {
                        viewPager.setCurrentItem(currentPage + 1);
                        return true;
                    }
                }

                isDragging = false;
                activePointerId = -1;
                if (viewPager.isFakeDragging()) {
                    viewPager.endFakeDrag();
                }
                break;
            }

            case MotionEvent.ACTION_POINTER_DOWN: {
                final int index = event.getActionIndex();
                lastMotionX = event.getX(index);
                activePointerId = event.getPointerId(index);
                break;
            }

            case MotionEvent.ACTION_POINTER_UP: {
                final int pointerIndex = event.getActionIndex();
                final int pointerId = event.getPointerId(pointerIndex);
                if (pointerId == activePointerId) {
                    // Pick a new active pointer and adjust motion tracking
                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    activePointerId = event.getPointerId(newPointerIndex);
                    lastMotionX = event.getX(newPointerIndex);
                }
                break;
            }
        }

        return true;
    }

    // Save/restore state
    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.currentPage = currentPage;
        return ss;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        currentPage = ss.currentPage;
        requestLayout();
    }

    static class SavedState extends BaseSavedState {
        int currentPage;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            currentPage = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(currentPage);
        }

        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
