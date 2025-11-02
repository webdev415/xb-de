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
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import p000.AbstractC1223ah;
import p000.AbstractC2343sk;
import p000.PhoneUtils;
import p000.InterfaceC0529Ld;
import p000.InterfaceC2018li;

public class BrowserFrameLayout extends FrameLayout {

    public final int f4430A;

    public AbstractScrollableListController.b f4431B;

    public AbstractScrollableListController f4432C;

    public ContextMenu.ContextMenuInfo f4433D;

    public int f4434a;

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

    public int f4453t;

    public long f4454u;

    public int f4455v;

    public int f4456w;

    public boolean f4457x;

    public InterfaceC1509l f4458y;

    public InterfaceC1510m f4459z;

    public class RunnableC1498a implements Runnable {
        public RunnableC1498a() {
        }

        @Override
        public void run() {
            BrowserActivity.getActivity().m6291a1();
        }
    }

    public class RunnableC1499b implements Runnable {
        public RunnableC1499b() {
        }

        @Override
        public void run() {
            BrowserActivity.getActivity().m6296b1();
        }
    }

    public class ScrollController extends AbstractScrollableListController {
        public ScrollController(FrameLayout frameLayout, InterfaceC0529Ld.a aVar, int i, int i2) {
            super(frameLayout, aVar, i, i2);
        }
    }

    public class HideAnimationListener extends AnimatorListenerAdapter {
        public HideAnimationListener() {
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            BrowserFrameLayout.this.f4453t = -2;
        }
    }

    public class HideAnimationUpdater implements ValueAnimator.AnimatorUpdateListener {
        public HideAnimationUpdater() {
        }

        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BrowserFrameLayout.this.m6464m(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class ShowAnimationListener extends AnimatorListenerAdapter {
        public ShowAnimationListener() {
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            BrowserFrameLayout.this.f4453t = -3;
        }
    }

    public class ShowAnimationUpdater implements ValueAnimator.AnimatorUpdateListener {
        public ShowAnimationUpdater() {
        }

        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BrowserFrameLayout.this.m6462k(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class EmptyAnimationListener extends AnimatorListenerAdapter {
        public EmptyAnimationListener() {
        }

        @Override
        public void onAnimationEnd(Animator animator) {
        }
    }

    public class LayoutAnimationUpdater implements ValueAnimator.AnimatorUpdateListener {
        public LayoutAnimationUpdater() {
        }

        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BrowserFrameLayout.this.f4439f.getRight() >= 0) {
                BrowserFrameLayout.this.f4439f.layout(BrowserFrameLayout.this.f4439f.getLeft() - iIntValue, BrowserFrameLayout.this.f4439f.getTop(), BrowserFrameLayout.this.f4439f.getRight() - iIntValue, BrowserFrameLayout.this.f4439f.getBottom());
            }
        }
    }

    public class SlideAnimationListener extends AnimatorListenerAdapter {
        public SlideAnimationListener() {
        }

        @Override
        public void onAnimationEnd(Animator animator) {
        }
    }

    public class SlideAnimationUpdater implements ValueAnimator.AnimatorUpdateListener {
        public SlideAnimationUpdater() {
        }

        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BrowserFrameLayout.this.f4440g.getLeft() <= BrowserFrameLayout.this.getRight()) {
                BrowserFrameLayout.this.f4440g.layout(BrowserFrameLayout.this.f4440g.getLeft() + iIntValue, BrowserFrameLayout.this.f4440g.getTop(), BrowserFrameLayout.this.f4440g.getRight() + iIntValue, BrowserFrameLayout.this.f4440g.getBottom());
            }
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
        this.f4434a = 4097;
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
        this.f4453t = -1;
        this.f4457x = false;
        this.f4458y = null;
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
        if (this.f4440g.getRight() > getRight() && BrowserActivity.getActivity().m6221J() && this.f4439f.getRight() <= 0 && !SharedPreferencesHelper.getInstance().canHScroll && this.f4445l == 1) {
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
        if (this.f4439f.getLeft() < 0 && BrowserActivity.getActivity().m6217I() && this.f4440g.getLeft() >= getRight() && !SharedPreferencesHelper.getInstance().canHScroll && this.f4445l == 2) {
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

    /* JADX WARN: Removed duplicated region for block: B:102:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013f  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.BrowserFrameLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void m6456e() {
        int iAbs = Math.abs(this.f4437d.getBottom() - getBottomPostion());
        if (iAbs == 0 && this.f4453t == -3) {
            iAbs = this.f4435b.getMeasuredHeight();
        }
        ValueAnimator duration = ValueAnimator.ofInt(0, iAbs).setDuration(this.f4448o);
        duration.addListener(new HideAnimationListener());
        duration.addUpdateListener(new HideAnimationUpdater());
        duration.start();
    }

    public void m6457f() {
        ValueAnimator duration = ValueAnimator.ofInt(0, Math.abs(this.f4437d.getBottom() - getBottomPostion())).setDuration(this.f4448o);
        duration.addListener(new ShowAnimationListener());
        duration.addUpdateListener(new ShowAnimationUpdater());
        duration.start();
    }

    public boolean m6458g() {
        return this.f4437d.getBottom() == getBottomPostion();
    }

    public View getBottomContainer() {
        return this.f4437d;
    }

    public int getBottomPostion() {
        return this.f4457x ? getBottom() - this.f4446m : getBottom();
    }

    public AbstractScrollableListController getContextMenu() {
        return this.f4432C;
    }

    public InterfaceC1509l getEventListener() {
        return this.f4458y;
    }

    public int getLayoutType() {
        return this.f4434a;
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
        int i = this.f4450q;
        if (x > i) {
            this.f4445l = 2;
        } else if (x < i) {
            this.f4445l = 1;
        }
    }

    public boolean m6461j() {
        AbstractScrollableListController abstractC1540b = this.f4432C;
        if (abstractC1540b == null || !abstractC1540b.m9656x()) {
            return false;
        }
        this.f4432C.m9655v();
        return true;
    }

    public final void m6462k(int i) {
        View view;
        int left;
        int top;
        int right;
        View view2;
        int i2 = this.f4434a;
        if ((i2 & 4097) == 4097) {
            if (this.f4435b.getTop() < 0 && this.f4435b.getVisibility() == 0) {
                if (i > Math.abs(this.f4435b.getTop())) {
                    i = Math.abs(this.f4435b.getTop());
                }
                View view3 = this.f4435b;
                view3.layout(view3.getLeft(), this.f4435b.getTop() + i, this.f4435b.getRight(), this.f4435b.getBottom() + i);
                View view4 = this.f4438e;
                view4.layout(view4.getLeft(), this.f4438e.getTop() + i, this.f4438e.getRight(), this.f4438e.getBottom() + i);
            }
            if (this.f4437d.getBottom() > getBottomPostion()) {
                if (i > Math.abs(this.f4437d.getBottom() - getBottomPostion())) {
                    i = Math.abs(this.f4437d.getBottom() - getBottomPostion());
                }
                view = this.f4437d;
                left = view.getLeft();
                top = this.f4437d.getTop() - i;
                right = this.f4437d.getRight();
                view2 = this.f4437d;
                view.layout(left, top, right, view2.getBottom() - i);
            }
        } else if ((i2 & 4098) == 4098 && this.f4437d.getBottom() > getBottomPostion()) {
            if (i > Math.abs(this.f4437d.getBottom() - getBottomPostion())) {
                i = Math.abs(this.f4437d.getBottom() - getBottomPostion());
            }
            View view5 = this.f4437d;
            view5.layout(view5.getLeft(), this.f4437d.getTop() - i, this.f4437d.getRight(), this.f4437d.getBottom() - i);
            view = this.f4438e;
            left = view.getLeft();
            top = this.f4438e.getTop() - i;
            right = this.f4438e.getRight();
            view2 = this.f4438e;
            view.layout(left, top, right, view2.getBottom() - i);
        }
        this.f4453t = this.f4437d.getBottom() == getBottomPostion() ? -3 : -4;
    }

    public final void m6463l(MotionEvent motionEvent, int i) {
        InterfaceC2018li interfaceC2018li;
        int y = (int) motionEvent.getY();
        if (motionEvent.getPointerCount() > 1) {
            return;
        }
        int i2 = this.f4451r;
        if (y > i2) {
            interfaceC2018li = this.f4447n;
        } else {
            if (y >= i2) {
                return;
            }
            interfaceC2018li = this.f4447n;
            i = -i;
        }
        interfaceC2018li.mo7070b(i);
    }

    public final void m6464m(int i) {
        int i2 = this.f4434a;
        if ((i2 & 4097) == 4097) {
            if (this.f4435b.getBottom() > 0) {
                int bottom = i > this.f4435b.getBottom() ? this.f4435b.getBottom() : i;
                View view = this.f4435b;
                view.layout(view.getLeft(), this.f4435b.getTop() - bottom, this.f4435b.getRight(), this.f4435b.getBottom() - bottom);
            }
            if (this.f4438e.getTop() > 0) {
                int top = i > this.f4438e.getTop() ? this.f4438e.getTop() : i;
                View view2 = this.f4438e;
                view2.layout(view2.getLeft(), this.f4438e.getTop() - top, this.f4438e.getRight(), this.f4438e.getBottom() - top);
            }
            if (this.f4437d.getTop() < getBottom()) {
                if (i > getBottomPostion() - this.f4437d.getTop()) {
                    i = getBottomPostion() - this.f4437d.getTop();
                }
                View view3 = this.f4437d;
                view3.layout(view3.getLeft(), this.f4437d.getTop() + i, this.f4437d.getRight(), this.f4437d.getBottom() + i);
            }
        } else if ((i2 & 4098) == 4098 && this.f4437d.getTop() < getBottom()) {
            if (i > getBottomPostion() - this.f4437d.getTop()) {
                i = getBottomPostion() - this.f4437d.getTop();
            }
            View view4 = this.f4438e;
            view4.layout(view4.getLeft(), this.f4438e.getTop() + i, this.f4438e.getRight(), this.f4438e.getBottom() + i);
            View view32 = this.f4437d;
            view32.layout(view32.getLeft(), this.f4437d.getTop() + i, this.f4437d.getRight(), this.f4437d.getBottom() + i);
        }
        this.f4453t = -4;
    }

    public void m6465n() {
        findViewById(com.xbrowser.play.R.id.mark_toolbar_container).setVisibility(View.VISIBLE);
        setLayoutType(4098);
    }

    public void m6466o(int i) {
        ViewGroup viewGroup = (ViewGroup) findViewById(com.xbrowser.play.R.id.mark_toolbar_container);
        viewGroup.removeAllViews();
        viewGroup.setVisibility(View.INVISIBLE);
        setLayoutType(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005d  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        /*
            r0 = this;
            super.onLayout(r1, r2, r3, r4, r5)
            android.view.View r1 = r0.f4436c
            if (r1 == 0) goto Lbe
            android.view.View r1 = r0.f4438e
            if (r1 == 0) goto Lbe
            android.view.View r2 = r0.f4435b
            if (r2 == 0) goto Lbe
            if (r1 != 0) goto L13
            goto Lbe
        L13:
            int r1 = r0.f4434a
            r2 = r1 & 4097(0x1001, float:5.741E-42)
            r3 = -2
            r4 = 4097(0x1001, float:5.741E-42)
            r5 = 8192(0x2000, float:1.148E-41)
            if (r2 != r4) goto L3f
            r1 = r1 & r5
            if (r1 != r5) goto L3b
            int r1 = r0.f4453t
            r2 = -3
            if (r1 != r2) goto L2a
            r0.m6475x()
            goto L6c
        L2a:
            com.mmbox.xbrowser.d r1 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            boolean r1 = r1.f4916m
            if (r1 == 0) goto L36
        L32:
            r0.m6468q()
            goto L6c
        L36:
            int r1 = r0.f4453t
            if (r1 != r3) goto L6c
            goto L32
        L3b:
            r0.m6474w()
            goto L6c
        L3f:
            r2 = r1 & 4098(0x1002, float:5.743E-42)
            r4 = 4098(0x1002, float:5.743E-42)
            if (r2 != r4) goto L61
            r1 = r1 & r5
            if (r1 != r5) goto L5d
            int r1 = r0.f4453t
            if (r1 != r3) goto L4d
            goto L32
        L4d:
            r2 = 3
            if (r1 != r2) goto L59
            com.mmbox.xbrowser.d r1 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            boolean r1 = r1.f4916m
            if (r1 == 0) goto L59
            goto L32
        L59:
            r0.m6477z()
            goto L6c
        L5d:
            r0.m6476y()
            goto L6c
        L61:
            r2 = r1 & 4100(0x1004, float:5.745E-42)
            r3 = 4100(0x1004, float:5.745E-42)
            if (r2 != r3) goto L68
            goto L5d
        L68:
            r1 = r1 & r5
            if (r1 != r5) goto L6c
            goto L32
        L6c:
            android.view.View r1 = r0.f4439f
            int r2 = r1.getLeft()
            android.view.View r3 = r0.f4439f
            int r3 = r3.getWidth()
            int r2 = r2 - r3
            android.view.View r3 = r0.f4439f
            int r3 = r3.getTop()
            android.view.View r4 = r0.f4439f
            int r4 = r4.getRight()
            android.view.View r5 = r0.f4439f
            int r5 = r5.getWidth()
            int r4 = r4 - r5
            android.view.View r5 = r0.f4439f
            int r5 = r5.getBottom()
            r1.layout(r2, r3, r4, r5)
            android.view.View r1 = r0.f4440g
            int r2 = r1.getLeft()
            android.view.View r3 = r0.f4440g
            int r3 = r3.getWidth()
            int r2 = r2 + r3
            android.view.View r3 = r0.f4440g
            int r3 = r3.getTop()
            android.view.View r4 = r0.f4440g
            int r4 = r4.getRight()
            android.view.View r5 = r0.f4440g
            int r5 = r5.getWidth()
            int r4 = r4 + r5
            android.view.View r5 = r0.f4440g
            int r5 = r5.getBottom()
            r1.layout(r2, r3, r4, r5)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.BrowserFrameLayout.onLayout(boolean, int, int, int, int):void");
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
        int i4 = this.f4434a;
        if ((i4 & 8192) != 8192) {
            if (i4 == 4097) {
                size -= this.f4435b.getMeasuredHeight();
            } else if (i4 != 4098 && i4 != 4100) {
                return;
            }
            size -= this.f4437d.getMeasuredHeight();
        }
        this.f4436c.measure(i, MeasureSpec.makeMeasureSpec(size, 1073741824));
    }

    public final void m6467p() {
        ValueAnimator duration = ValueAnimator.ofInt(0, Math.abs(this.f4439f.getRight())).setDuration(this.f4448o);
        duration.addListener(new EmptyAnimationListener());
        duration.addUpdateListener(new LayoutAnimationUpdater());
        duration.start();
    }

    public final void m6468q() {
        View view = this.f4436c;
        view.layout(view.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPostion());
        View view2 = this.f4435b;
        view2.layout(view2.getLeft(), getTopPostion() - this.f4435b.getMeasuredHeight(), this.f4435b.getRight(), getTopPostion());
        View view3 = this.f4437d;
        view3.layout(view3.getLeft(), getBottomPostion(), this.f4437d.getRight(), getBottomPostion() + this.f4437d.getMeasuredHeight());
        View view4 = this.f4438e;
        view4.layout(view4.getLeft(), getTopPostion(), this.f4438e.getRight(), getTopPostion() + this.f4438e.getMeasuredHeight());
    }

    public final void m6469r() {
        ValueAnimator duration = ValueAnimator.ofInt(0, Math.abs(getRight() - this.f4440g.getLeft())).setDuration(this.f4448o);
        duration.addListener(new SlideAnimationListener());
        duration.addUpdateListener(new SlideAnimationUpdater());
        duration.start();
    }

    public boolean m6470s(int i, int i2) {
        return ((float) i) > this.f4437d.getX() && i2 > this.f4437d.getTop();
    }

    public void setContextMenuListener(AbstractScrollableListController.b bVar) {
        this.f4431B = bVar;
    }

    public void setEventListener(InterfaceC1509l interfaceC1509l) {
        this.f4458y = interfaceC1509l;
    }

    public void setLayoutType(int i) {
        if (this.f4434a == i) {
            return;
        }
        this.f4434a = i;
        if (i == 4097 || i == 4098) {
            this.f4453t = -1;
        } else if ((i & 8192) == 8192) {
            this.f4453t = -2;
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
        view3.layout(view3.getLeft(), getBottomPostion() - this.f4437d.getMeasuredHeight(), this.f4437d.getRight(), getBottomPostion());
        View view4 = this.f4438e;
        view4.layout(view4.getLeft(), this.f4435b.getMeasuredHeight() - this.f4438e.getMeasuredHeight(), this.f4438e.getRight(), this.f4435b.getMeasuredHeight());
    }

    public final void m6475x() {
        View view;
        int left;
        int bottomPostion;
        int right;
        int bottomPostion2;
        int i = this.f4453t;
        if (i == -2) {
            View view2 = this.f4436c;
            view2.layout(view2.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPostion());
            View view3 = this.f4435b;
            view3.layout(view3.getLeft(), getTopPostion() - this.f4435b.getMeasuredHeight(), this.f4435b.getRight(), getTopPostion());
            View view4 = this.f4438e;
            view4.layout(view4.getLeft(), getTopPostion() + this.f4438e.getMeasuredHeight(), this.f4438e.getRight(), getTopPostion() + this.f4438e.getMeasuredHeight());
            view = this.f4437d;
            left = view.getLeft();
            bottomPostion = getBottomPostion();
            right = this.f4437d.getRight();
            bottomPostion2 = getBottomPostion() + this.f4437d.getMeasuredHeight();
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
            bottomPostion = getBottomPostion() - this.f4437d.getMeasuredHeight();
            right = this.f4437d.getRight();
            bottomPostion2 = getBottomPostion();
        }
        view.layout(left, bottomPostion, right, bottomPostion2);
    }

    public final void m6476y() {
        View view = this.f4436c;
        view.layout(view.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPostion());
        View view2 = this.f4435b;
        view2.layout(view2.getLeft(), getTopPostion() - this.f4435b.getMeasuredHeight(), this.f4435b.getRight(), getTopPostion());
        View view3 = this.f4437d;
        view3.layout(view3.getLeft(), getBottomPostion() - this.f4437d.getMeasuredHeight(), this.f4437d.getRight(), getBottomPostion());
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
        int i = this.f4453t;
        if (i == -2) {
            View view3 = this.f4436c;
            view3.layout(view3.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPostion());
            View view4 = this.f4437d;
            view4.layout(view4.getLeft(), getBottomPostion(), this.f4437d.getRight(), getBottomPostion() + this.f4437d.getMeasuredHeight());
            view = this.f4438e;
            left = view.getLeft();
            top = getBottomPostion() - this.f4438e.getMeasuredHeight();
            right = this.f4438e.getRight();
            bottom = getBottomPostion();
        } else {
            if (i != -3) {
                return;
            }
            View view5 = this.f4436c;
            view5.layout(view5.getLeft(), getTopPostion(), this.f4436c.getRight(), getBottomPostion());
            View view6 = this.f4437d;
            view6.layout(view6.getLeft(), getBottomPostion() - this.f4437d.getMeasuredHeight(), this.f4437d.getRight(), getBottomPostion());
            view = this.f4438e;
            left = view.getLeft();
            top = this.f4437d.getTop() - this.f4438e.getMeasuredHeight();
            right = this.f4438e.getRight();
            bottom = this.f4437d.getBottom();
        }
        view.layout(left, top, right, bottom);
    }
}
