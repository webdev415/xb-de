package com.mmbox.xbrowser;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import p000.AbstractC1223ah;
import p000.AbstractC2343sk;
import p000.C0848Sb;
import p000.InterfaceC0529Ld;
import p000.InterfaceC2018li;
import p000.PhoneUtils;

public class BrowserFrameLayout extends FrameLayout {

    public final int f4430A;

    public AbstractScrollableListController.b f4431B;

    public AbstractScrollableListController f4432C;

    public ContextMenu.ContextMenuInfo f4433D;

    public int layoutFlags;

    public View f4435b;

    public View f4436c;

    public View f4437d;

    public View f4438e;

    public View f4439f;

    public View f4440g;

    public boolean f4441h;

    public boolean f4442i;

    public int f4443j;

    public int f4444k;

    public int f4445l;

    public int f4446m;

    public InterfaceC2018li f4447n;

    public long f4448o;

    public int f4449p;

    public int f4450q;

    public int f4451r;

    public int f4452s;

    public int state;

    public long f4454u;

    public int f4455v;

    public int f4456w;

    public boolean f4457x;

    public InterfaceC1509l eventListener;

    public InterfaceC1510m f4459z;

    public class ScrollController extends AbstractScrollableListController {
        public ScrollController(FrameLayout layout, InterfaceC0529Ld.a aVar, int i, int i2) {
            super(layout, aVar, i, i2);
        }
    }

    public interface InterfaceC1509l {
        void mo6390a(int i);
    }

    public interface InterfaceC1510m {
        boolean mo6389a(MotionEvent motionEvent);
    }

    public BrowserFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.layoutFlags = 4097;
        this.f4435b = null;
        this.f4436c = null;
        this.f4437d = null;
        this.f4438e = null;
        this.f4439f = null;
        this.f4440g = null;
        this.f4441h = false;
        this.f4442i = false;
        this.f4445l = 0;
        this.f4447n = null;
        this.state = -1;
        this.f4457x = false;
        this.eventListener = null;
        this.f4459z = null;
        this.f4430A = 0;
        this.f4433D = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4448o = getContext().getResources().getInteger(R.integer.config_shortAnimTime) + 300;
        this.f4432C = new ScrollController(this, this.f4431B, (int) getContext().getResources().getDimension(com.xbrowser.play.R.dimen.ctx_menu_width), -2);
        this.f4443j = viewConfiguration.getScaledTouchSlop();
        this.f4446m = PhoneUtils.getInstance().getStatusBarHeight();
        this.f4444k = (int) getResources().getDimension(com.xbrowser.play.R.dimen.swipe_slop);
    }

    public final void m6454A(int i) {
        if (this.f4440g.getRight() > getRight() && BrowserActivity.getActivity().isNextTabValid() && this.f4439f.getRight() <= 0 && !SharedPreferencesHelper.getInstance().canHScroll && this.f4445l == 1) {
            int right = i > this.f4440g.getRight() - getRight() ? this.f4440g.getRight() - getRight() : i;
            if (this.f4440g.getRight() >= getRight()) {
                View view = this.f4440g;
                view.layout(view.getLeft() - right, this.f4440g.getTop(), this.f4440g.getRight() - right, this.f4440g.getBottom());
            }
        }
        if (this.f4439f.getRight() <= 0 || this.f4445l != 2) {
            return;
        }
        if (i > this.f4439f.getRight()) {
            i = this.f4439f.getRight();
        }
        View view2 = this.f4439f;
        view2.layout(view2.getLeft() - i, this.f4439f.getTop(), this.f4439f.getRight() - i, this.f4439f.getBottom());
    }

    public final void m6455B(int i) {
        if (this.f4439f.getLeft() < 0 && BrowserActivity.getActivity().isPreviousTabValid() && this.f4440g.getLeft() >= getRight() && !SharedPreferencesHelper.getInstance().canHScroll && this.f4445l == 2) {
            int iAbs = i > Math.abs(this.f4439f.getLeft()) ? Math.abs(this.f4439f.getLeft()) : i;
            if (this.f4439f.getLeft() <= getLeft()) {
                View view = this.f4439f;
                view.layout(view.getLeft() + iAbs, this.f4439f.getTop(), this.f4439f.getRight() + iAbs, this.f4439f.getBottom());
            }
        }
        if (this.f4440g.getLeft() >= getRight() || this.f4445l != 1) {
            return;
        }
        if (i > getRight() - this.f4440g.getLeft()) {
            i = getRight() - this.f4440g.getLeft();
        }
        View view2 = this.f4440g;
        view2.layout(view2.getLeft() + i, this.f4440g.getTop(), this.f4440g.getRight() + i, this.f4440g.getBottom());
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN) {
            handleActionDown(event, x, y);
        } else {
            InterfaceC1510m handler = this.f4459z;
            if (handler != null && handler.mo6389a(event)) {
                return true;
            }

            TouchDelegate touchDelegate = getTouchDelegate();
            if (touchDelegate != null && touchDelegate.onTouchEvent(event)) {
                return true;
            }
        }

        switch (action) {
            case MotionEvent.ACTION_MOVE:
                handleActionMove(event, x, y);
                break;

            case MotionEvent.ACTION_UP:
                handleActionUp(event, x, y);
                break;

            case MotionEvent.ACTION_CANCEL:
                // Handle ACTION_CANCEL if needed
                break;
        }

        return super.dispatchTouchEvent(event);
    }

    private void handleActionDown(MotionEvent event, int x, int y) {
        this.f4442i = false;
        this.f4442i = C0848Sb.getInstance().isTouchInside(event);
        this.f4454u = System.currentTimeMillis();
        this.f4455v = x;
        this.f4456w = y;

        SharedPreferencesHelper.getInstance().f4852E0 = true;
        SharedPreferencesHelper.getInstance().f4850D0 = true;

        // Reset additional values related to touch events
        this.f4449p = y;
        this.f4450q = x;
        this.f4451r = 0;
        this.f4445l = 0;
    }

    private void handleActionMove(MotionEvent event, int x, int y) {
        int deltaX = Math.abs(x - this.f4452s);
        int deltaY = Math.abs(y - this.f4451r);

        Log.d("main-frame", "Move span y: " + deltaY + " move span x: " + deltaX);
        m6460i(event); // Call method for handling move event

        // Handle swipe/gesture actions based on movement
        if (this.f4445l == 0) {
            if (x - this.f4452s > 0) {
                m6455B(deltaX); // Handle swipe right
            } else if (x - this.f4452s < 0) {
                m6454A(deltaX); // Handle swipe left
            }
        }

        int currentState = this.state;
        if (currentState == -1) {
            // Handle state change if needed
        } else if (currentState == -2 || currentState == -4) {
            // Handle other states
        } else if (currentState == 3) {
            m6463l(event, deltaY); // Handle specific logic for state 3
        }
    }

    private void handleActionUp(MotionEvent event, int x, int y) {
        Log.d("browser-frame", "Current state: " + this.state);

        if (state == 3) {
            this.f4447n.mo7069a(true);
            if ((this.layoutFlags & 8192) != 8192) {
                this.state = -1; // Reset state if conditions met
            }
        }

        // Handle other state transitions based on touch position
        if (state == -3 || state == 3) {
            this.f4441h = false;
            if (this.f4439f.getRight() > 0) {
                m6467p(); // Perform specific action when right is positive
            }

            long elapsedTime = System.currentTimeMillis() - this.f4454u;
            if (this.f4439f.getRight() >= (this.f4439f.getWidth() - this.f4443j) && elapsedTime > 200) {
                BrowserActivity.getActivity().getHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BrowserActivity.getActivity().m6291a1();
                    }
                }, 200);
            }

            if (this.f4440g.getLeft() <= (getRight() - (this.f4440g.getWidth() - this.f4443j)) && elapsedTime > 200) {
                BrowserActivity.getActivity().getHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BrowserActivity.getActivity().m6296b1();
                    }
                }, 200);
            }
        }

        // Handle other touch actions here as needed
        this.f4451r = y;
        this.f4452s = x;
    }

    public void m6456e() {
        int iAbs = Math.abs(this.f4437d.getBottom() - getBottomPosition());
        if (iAbs == 0 && this.state == -3) {
            iAbs = this.f4435b.getMeasuredHeight();
        }
        ValueAnimator duration = ValueAnimator.ofInt(0, iAbs).setDuration(this.f4448o);
        duration.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animator) {
                state = -2;
            }
        });
        duration.addUpdateListener(animation -> m6464m((Integer) animation.getAnimatedValue()));
        duration.start();
    }

    public void m6457f() {
        ValueAnimator duration = ValueAnimator.ofInt(0, Math.abs(this.f4437d.getBottom() - getBottomPosition())).setDuration(this.f4448o);
        duration.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                state = -3;
            }
        });
        duration.addUpdateListener(animation -> m6462k((Integer) animation.getAnimatedValue()));
        duration.start();
    }

    public boolean m6458g() {
        return this.f4437d.getBottom() == getBottomPosition();
    }

    public View getBottomContainer() {
        return this.f4437d;
    }

    public int getBottomPosition() {
        return this.f4457x ? getBottom() - this.f4446m : getBottom();
    }

    public AbstractScrollableListController getContextMenu() {
        return this.f4432C;
    }

    public InterfaceC1509l getEventListener() {
        return this.eventListener;
    }

    public int getLayoutType() {
        return this.layoutFlags;
    }

    public FrameLayout getMainContainer() {
        return (FrameLayout) this.f4436c;
    }

    public View getTopContainer() {
        return this.f4435b;
    }

    public int getTopPostion() {
        return this.f4457x ? getTop() - this.f4446m : getTop();
    }

    public boolean m6459h(MotionEvent motionEvent) {
        return BrowserActivity.getActivity().m6272V2() && !this.f4442i;
    }

    public final void m6460i(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (Math.abs(y - this.f4449p) >= Math.abs(x - this.f4450q) / 1.5f || AbstractC1223ah.m5282c(motionEvent) != 1 || y <= this.f4435b.getBottom() || y >= this.f4437d.getTop() || Math.abs(x - this.f4450q) <= this.f4444k || this.f4442i || SharedPreferencesHelper.getInstance().disableBackForwardGesture || this.f4445l != 0) {
            return;
        }
        if (x > f4450q) {
            this.f4445l = 2;
        } else if (x < f4450q) {
            this.f4445l = 1;
        }
    }

    public boolean m6461j() {
        if (f4432C == null || !f4432C.m9656x()) {
            return false;
        }
        this.f4432C.m9655v();
        return true;
    }

    public final void m6462k(int i) {
        if ((layoutFlags & 4097) == 4097) {
            // Adjust f4435b and f4438e if f4435b's top is negative and visible
            if (this.f4435b.getTop() < 0 && this.f4435b.getVisibility() == View.VISIBLE) {
                i = Math.min(i, Math.abs(this.f4435b.getTop())); // Limit i based on f4435b's top position
                f4435b.layout(f4435b.getLeft(), this.f4435b.getTop() + i, f4435b.getRight(), this.f4435b.getBottom() + i);
                f4438e.layout(f4438e.getLeft(), this.f4438e.getTop() + i, f4438e.getRight(), this.f4438e.getBottom() + i);
            }

            // Adjust f4437d if it's below the bottom position
            if (this.f4437d.getBottom() > getBottomPosition()) {
                i = Math.min(i, Math.abs(this.f4437d.getBottom() - getBottomPosition())); // Limit i based on f4437d's bottom position
                f4437d.layout(f4437d.getLeft(), this.f4437d.getTop() - i, f4437d.getRight(), f4437d.getBottom() - i);
            }
        } else if ((layoutFlags & 4098) == 4098 && this.f4437d.getBottom() > getBottomPosition()) {
            // Adjust f4437d and f4438e if layoutFlag 4098 is set and f4437d's bottom is beyond the bottom position
            i = Math.min(i, Math.abs(this.f4437d.getBottom() - getBottomPosition())); // Limit i based on f4437d's bottom position
            f4437d.layout(f4437d.getLeft(), this.f4437d.getTop() - i, f4437d.getRight(), this.f4437d.getBottom() - i);

            // Adjust f4438e based on the movement of f4437d
            f4438e.layout(f4438e.getLeft(), this.f4438e.getTop() - i, f4438e.getRight(), this.f4438e.getBottom() - i);
        }

        // Set state based on f4437d's final position
        this.state = (this.f4437d.getBottom() == getBottomPosition()) ? -3 : -4;
    }

    public final void m6463l(MotionEvent motionEvent, int i) {
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() <= 1) {
            if (y <= f4451r && y < f4451r) {
                i = -i;
                f4447n.mo7070b(i);
            }
        }
    }

    public final void m6464m(int i) {
        if ((layoutFlags & 4097) == 4097) {
            // Adjust f4435b if it's within bounds
            if (this.f4435b.getBottom() > 0) {
                int bottom = Math.min(i, this.f4435b.getBottom());
                f4435b.layout(f4435b.getLeft(), this.f4435b.getTop() - bottom, f4435b.getRight(), this.f4435b.getBottom() - bottom);
            }

            // Adjust f4438e if it's within bounds
            if (this.f4438e.getTop() > 0) {
                int top = Math.min(i, this.f4438e.getTop());
                f4438e.layout(f4438e.getLeft(), this.f4438e.getTop() - top, f4438e.getRight(), this.f4438e.getBottom() - top);
            }

            // Adjust f4437d if within the bottom bounds
            if (this.f4437d.getTop() < getBottom()) {
                int adjustedI = Math.min(i, getBottomPosition() - this.f4437d.getTop());
                f4437d.layout(f4437d.getLeft(), this.f4437d.getTop() + adjustedI, f4437d.getRight(), this.f4437d.getBottom() + adjustedI);
            }
        } else if ((layoutFlags & 4098) == 4098 && this.f4437d.getTop() < getBottom()) {
            // Adjust both f4438e and f4437d if within bounds and layoutFlag matches
            int adjustedI = Math.min(i, getBottomPosition() - this.f4437d.getTop());
            f4438e.layout(f4438e.getLeft(), this.f4438e.getTop() + adjustedI, f4438e.getRight(), this.f4438e.getBottom() + adjustedI);
            f4437d.layout(f4437d.getLeft(), this.f4437d.getTop() + adjustedI, f4437d.getRight(), this.f4437d.getBottom() + adjustedI);
        }

        // Set state after layout
        this.state = -4;
    }

    public void m6465n() {
        findViewById(com.xbrowser.play.R.id.mark_toolbar_container).setVisibility(View.VISIBLE);
        setLayoutType(4098);
    }

    public void m6466o(int layoutType) {
        // Get the view group container
        ViewGroup toolbarContainer = (ViewGroup) findViewById(com.xbrowser.play.R.id.mark_toolbar_container);

        // Remove all views and hide the container
        toolbarContainer.removeAllViews();
        toolbarContainer.setVisibility(View.INVISIBLE);

        // Set the layout type
        setLayoutType(layoutType);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);

        if (f4436c == null) return;
        if (f4438e == null) return;
        if (f4435b == null) return;

        // Check the condition for the first layout flag (4097)
        if ((layoutFlags & 4097) == 4097) {
            if ((layoutFlags & 8192) == 8192) {
                if (state == -3) {
                    m6475x();
                } else {
                    if (SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                        m6468q();
                    } else if (state == -2) {
                        m6468q();
                    } else {
                        m6474w();
                    }
                }
            } else {
                m6474w();
            }
        } else if ((layoutFlags & 4098) == 4098) {
            if ((layoutFlags & 8192) == 8192) {
                if (state == -2) {
                    if (SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                        m6468q();
                    }
                } else if (state == 3) {
                    if (SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                        m6468q();
                    } else {
                        m6477z();
                    }
                } else {
                    m6476y();
                }
            } else {
                m6476y();
            }
        }

        // Check the condition for the third layout flag (4100)
        else if ((layoutFlags & 4100) == 4100) {
            m6476y();
        }

        int left1 = f4439f.getLeft() - f4439f.getWidth();
        int top1 = f4439f.getTop();
        int right1 = f4439f.getRight() - f4439f.getWidth();
        int bottom1 = f4439f.getBottom();
        f4439f.layout(left1, top1, right1, bottom1);

        int left2 = f4440g.getLeft() + f4440g.getWidth();
        int top2 = f4440g.getTop();
        int right2 = f4440g.getRight() + f4440g.getWidth();
        int bottom2 = f4440g.getBottom();
        f4440g.layout(left2, top2, right2, bottom2);
    }

    @Override
    public void onMeasure(int i, int i2) {
        if (this.f4457x) {
            ((LayoutParams) getLayoutParams()).topMargin = this.f4446m;
        } else {
            ((LayoutParams) getLayoutParams()).topMargin = 0;
        }
        super.onMeasure(i, i2);
        MeasureSpec.getMode(i);
        MeasureSpec.getMode(i2);
        MeasureSpec.getSize(i);
        int size = MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        Log.e("browser-frame", "content height:" + size);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            childAt.getMeasuredWidth();
            childAt.getMeasuredHeight();
            if (childAt.getId() == com.xbrowser.play.R.id.main_content) {
                this.f4436c = childAt;
            } else if (childAt.getId() == com.xbrowser.play.R.id.top_content) {
                this.f4435b = childAt;
            } else if (childAt.getId() == com.xbrowser.play.R.id.bottom_content) {
                this.f4437d = childAt;
            } else if (childAt.getId() == com.xbrowser.play.R.id.progress_bar) {
                this.f4438e = childAt;
            } else if (childAt.getId() == com.xbrowser.play.R.id.back_indicator) {
                this.f4439f = childAt;
            } else if (childAt.getId() == com.xbrowser.play.R.id.forward_indicator) {
                this.f4440g = childAt;
            }
        }
        if ((layoutFlags & 8192) != 8192) {
            if (layoutFlags == 4097) {
                size -= this.f4435b.getMeasuredHeight();
            } else if (layoutFlags != 4098 && layoutFlags != 4100) {
                return;
            }
            size -= this.f4437d.getMeasuredHeight();
        }
        this.f4436c.measure(i, MeasureSpec.makeMeasureSpec(size, View.MeasureSpec.EXACTLY));
    }

    public final void m6467p() {
        ValueAnimator duration = ValueAnimator.ofInt(0, Math.abs(this.f4439f.getRight())).setDuration(this.f4448o);
        duration.addListener(new AnimatorListenerAdapter() {
        });
        duration.addUpdateListener(animation -> {
            int iIntValue = (Integer) animation.getAnimatedValue();
            if (f4439f.getRight() >= 0) {
                f4439f.layout(f4439f.getLeft() - iIntValue, f4439f.getTop(), f4439f.getRight() - iIntValue, f4439f.getBottom());
            }
        });
        duration.start();
    }

    public final void m6468q() {
        f4436c.layout(f4436c.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPosition());
        f4435b.layout(f4435b.getLeft(), getTopPostion() - this.f4435b.getMeasuredHeight(), this.f4435b.getRight(), getTopPostion());
        f4437d.layout(f4437d.getLeft(), getBottomPosition(), this.f4437d.getRight(), getBottomPosition() + this.f4437d.getMeasuredHeight());
        f4438e.layout(f4438e.getLeft(), getTopPostion(), this.f4438e.getRight(), getTopPostion() + this.f4438e.getMeasuredHeight());
    }

    public final void m6469r() {
        ValueAnimator duration = ValueAnimator.ofInt(0, Math.abs(getRight() - this.f4440g.getLeft())).setDuration(this.f4448o);
        duration.addListener(new AnimatorListenerAdapter() {
        });
        duration.addUpdateListener(animation -> {
            int iIntValue = (Integer) animation.getAnimatedValue();
            if (f4440g.getLeft() <= getRight()) {
                f4440g.layout(f4440g.getLeft() + iIntValue, f4440g.getTop(), f4440g.getRight() + iIntValue, f4440g.getBottom());
            }
        });
        duration.start();
    }

    public boolean m6470s(int i, int i2) {
        return ((float) i) > this.f4437d.getX() && i2 > this.f4437d.getTop();
    }

    public void setContextMenuListener(AbstractScrollableListController.b bVar) {
        this.f4431B = bVar;
    }

    public void setEventListener(InterfaceC1509l interfaceC1509l) {
        this.eventListener = interfaceC1509l;
    }

    public void setLayoutType(int i) {
        if (this.layoutFlags == i) {
            return;
        }
        this.layoutFlags = i;
        if (i == 4097 || i == 4098) {
            this.state = -1;
        } else if ((i & 8192) == 8192) {
            this.state = -2;
        }
        if (i == 8198) {
            Toast.makeText(getContext(), com.xbrowser.play.R.string.toast_retrun_key_to_exit_fullscreen, Toast.LENGTH_LONG).show();
        }
        requestLayout();
    }

    public void setOverscrollRefreshHandler(InterfaceC2018li interfaceC2018li) {
        this.f4447n = interfaceC2018li;
    }

    public void setTouchHooker(InterfaceC1510m interfaceC1510m) {
        this.f4459z = interfaceC1510m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean showContextMenuForChild(View r5) {
        /*
            r4 = this;
            com.mmbox.xbrowser.b r0 = r4.f4432C
            boolean r0 = r0.m9656x()
            r1 = 1
            if (r0 == 0) goto La
            return r1
        La:
            r0 = 0
            r4.f4433D = r0
            com.mmbox.xbrowser.b r2 = r4.f4432C
            r2.m9649j()
            boolean r2 = r5 instanceof android.widget.EditText
            if (r2 == 0) goto L1b
            boolean r5 = super.showContextMenuForChild(r5)
            return r5
        L1b:
            boolean r2 = r5 instanceof com.mmbox.xbrowser.AbstractScrollableListController.b
            if (r2 == 0) goto L34
            r0 = r5
            com.mmbox.xbrowser.b$b r0 = (com.mmbox.xbrowser.AbstractScrollableListController.b) r0
        L22:
            com.mmbox.xbrowser.b r2 = r4.f4432C
            r2.m9641D(r0)
            android.view.ContextMenu$ContextMenuInfo r2 = r4.m6473v(r5)
            r4.f4433D = r2
            com.mmbox.xbrowser.b r3 = r4.f4432C
            boolean r0 = r0.mo6669B(r3, r5, r2)
            goto L54
        L34:
            java.lang.Object r2 = r5.getTag()
            boolean r2 = r2 instanceof com.mmbox.xbrowser.AbstractScrollableListController.b
            if (r2 == 0) goto L43
            java.lang.Object r0 = r5.getTag()
            com.mmbox.xbrowser.b$b r0 = (com.mmbox.xbrowser.AbstractScrollableListController.b) r0
            goto L22
        L43:
            com.mmbox.xbrowser.b$b r2 = r4.f4431B
            if (r2 == 0) goto L66
            com.mmbox.xbrowser.b r3 = r4.f4432C
            r3.m9641D(r2)
            com.mmbox.xbrowser.b$b r2 = r4.f4431B
            com.mmbox.xbrowser.b r3 = r4.f4432C
            boolean r0 = r2.mo6669B(r3, r5, r0)
        L54:
            if (r0 == 0) goto L61
            com.mmbox.xbrowser.b r5 = r4.f4432C
            int r0 = r4.f4455v
            int r2 = r4.f4456w
            r3 = -1
            r5.mo7047F(r0, r2, r3)
            return r1
        L61:
            boolean r5 = super.showContextMenuForChild(r5)
            return r5
        L66:
            boolean r5 = super.showContextMenuForChild(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.BrowserFrameLayout.showContextMenuForChild(android.view.View):boolean");
    }

    public final boolean m6471t(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        View viewFindViewById = findViewById(com.xbrowser.play.R.id.fast_scroll_bar_holder);
        return Math.abs(y - ((float) this.f4449p)) > Math.abs(x - ((float) this.f4450q)) && Math.abs(y - ((float) this.f4449p)) > ((float) this.f4443j) && x < ((float) (getWidth() - (viewFindViewById != null ? viewFindViewById.getWidth() : 0))) && motionEvent.getEventTime() - motionEvent.getDownTime() > 200;
    }

    public void m6472u() {
        this.f4441h = true;
    }

    public final ContextMenu.ContextMenuInfo m6473v(View view) {
        try {
            return (ContextMenu.ContextMenuInfo) AbstractC2343sk.m9587a(View.class, view, "getContextMenuInfo", new Class[0], new Object[0]);
        } catch (Exception e) {
            Log.d("MxMainFrameLayout", "getContextMenuInfo;" + e);
            return null;
        }
    }

    public final void m6474w() {
        View view = this.f4436c;
        view.layout(view.getLeft(), this.f4436c.getTop() + this.f4435b.getMeasuredHeight(), this.f4436c.getRight(), this.f4436c.getBottom() + this.f4435b.getMeasuredHeight());
        View view2 = this.f4435b;
        view2.layout(view2.getLeft(), this.f4435b.getTop(), this.f4435b.getRight(), this.f4435b.getBottom());
        View view3 = this.f4437d;
        view3.layout(view3.getLeft(), getBottomPosition() - this.f4437d.getMeasuredHeight(), this.f4437d.getRight(), getBottomPosition());
        View view4 = this.f4438e;
        view4.layout(view4.getLeft(), this.f4435b.getMeasuredHeight() - this.f4438e.getMeasuredHeight(), this.f4438e.getRight(), this.f4435b.getMeasuredHeight());
    }

    public final void m6475x() {
        View view;
        int left;
        int bottomPostion;
        int right;
        int bottomPostion2;
        int i = this.state;
        if (i == -2) {
            View view2 = this.f4436c;
            view2.layout(view2.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPosition());
            View view3 = this.f4435b;
            view3.layout(view3.getLeft(), getTopPostion() - this.f4435b.getMeasuredHeight(), this.f4435b.getRight(), getTopPostion());
            View view4 = this.f4438e;
            view4.layout(view4.getLeft(), getTopPostion() + this.f4438e.getMeasuredHeight(), this.f4438e.getRight(), getTopPostion() + this.f4438e.getMeasuredHeight());
            view = this.f4437d;
            left = view.getLeft();
            bottomPostion = getBottomPosition();
            right = this.f4437d.getRight();
            bottomPostion2 = getBottomPosition() + this.f4437d.getMeasuredHeight();
        } else {
            if (i != -3) {
                return;
            }
            View view5 = this.f4436c;
            view5.layout(view5.getLeft(), this.f4436c.getTop(), this.f4436c.getRight(), this.f4436c.getBottom());
            View view6 = this.f4435b;
            view6.layout(view6.getLeft(), getTopPostion(), this.f4435b.getRight(), getTopPostion() + this.f4435b.getMeasuredHeight());
            View view7 = this.f4438e;
            view7.layout(view7.getLeft(), this.f4435b.getMeasuredHeight() - this.f4438e.getMeasuredHeight(), this.f4438e.getRight(), this.f4435b.getMeasuredHeight());
            view = this.f4437d;
            left = view.getLeft();
            bottomPostion = getBottomPosition() - this.f4437d.getMeasuredHeight();
            right = this.f4437d.getRight();
            bottomPostion2 = getBottomPosition();
        }
        view.layout(left, bottomPostion, right, bottomPostion2);
    }

    public final void m6476y() {
        View view = this.f4436c;
        view.layout(view.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPosition());
        View view2 = this.f4435b;
        view2.layout(view2.getLeft(), getTopPostion() - this.f4435b.getMeasuredHeight(), this.f4435b.getRight(), getTopPostion());
        View view3 = this.f4437d;
        view3.layout(view3.getLeft(), getBottomPosition() - this.f4437d.getMeasuredHeight(), this.f4437d.getRight(), getBottomPosition());
        View view4 = this.f4438e;
        view4.layout(view4.getLeft(), this.f4437d.getTop() - this.f4438e.getMeasuredHeight(), this.f4438e.getRight(), this.f4437d.getTop());
    }

    public final void m6477z() {
        View view;
        int left;
        int top;
        int right;
        int bottom;
        View view2 = this.f4435b;
        view2.layout(view2.getLeft(), getTopPostion() - this.f4435b.getMeasuredHeight(), this.f4435b.getRight(), getTopPostion());
        int i = this.state;
        if (i == -2) {
            View view3 = this.f4436c;
            view3.layout(view3.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPosition());
            View view4 = this.f4437d;
            view4.layout(view4.getLeft(), getBottomPosition(), this.f4437d.getRight(), getBottomPosition() + this.f4437d.getMeasuredHeight());
            view = this.f4438e;
            left = view.getLeft();
            top = getBottomPosition() - this.f4438e.getMeasuredHeight();
            right = this.f4438e.getRight();
            bottom = getBottomPosition();
        } else {
            if (i != -3) {
                return;
            }
            View view5 = this.f4436c;
            view5.layout(view5.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPosition());
            View view6 = this.f4437d;
            view6.layout(view6.getLeft(), getBottomPosition() - this.f4437d.getMeasuredHeight(), this.f4437d.getRight(), getBottomPosition());
            view = this.f4438e;
            left = view.getLeft();
            top = this.f4437d.getTop() - this.f4438e.getMeasuredHeight();
            right = this.f4438e.getRight();
            bottom = this.f4437d.getBottom();
        }
        view.layout(left, top, right, bottom);
    }
}
