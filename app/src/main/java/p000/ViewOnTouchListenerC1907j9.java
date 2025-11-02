package p000;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;

import com.mobeta.android.dslv.AbstractC1605a;
import com.mobeta.android.dslv.DragSortListView;

/* loaded from: classes.dex */
public class ViewOnTouchListenerC1907j9 extends AbstractC1605a implements View.OnTouchListener, GestureDetector.OnGestureListener {

    public final DragSortListView dragSortListView;

    public int f5908B;

    public final GestureDetector.OnGestureListener f5909C;

    public int f5910e;

    public boolean f5911f;

    public int f5912g;

    public boolean f5913h;

    public boolean f5914i;

    public final GestureDetector f5915j;

    public final GestureDetector f5916k;

    public final int f5917l;

    public int f5918m;

    public int f5919n;

    public int f5920o;

    public final int[] f5921p;

    public int f5922q;

    public int f5923r;

    public int f5924s;

    public int f5925t;

    public boolean f5926u;

    public final float f5927v;

    public int f5928w;

    public int f5929x;

    public int f5930y;

    public boolean f5931z;

    public class a extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f5913h && f5914i && Math.abs(f) > Math.abs(f2)) {
                int width = dragSortListView.getWidth() / 3;
                if (f <= 800.0f ? !(f >= -800.0f || f5908B >= width) : f5908B > (-width)) {
                    dragSortListView.m7242q0(true, f);
                }
                f5914i = false;
            }
            return false;
        }
    }

    public ViewOnTouchListenerC1907j9(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.f5910e = 0;
        this.f5911f = true;
        this.f5913h = false;
        this.f5914i = false;
        this.f5918m = -1;
        this.f5919n = -1;
        this.f5920o = -1;
        this.f5921p = new int[2];
        this.f5926u = false;
        this.f5927v = 800.0f;
        a aVar = new a();
        this.f5909C = aVar;
        this.dragSortListView = dragSortListView;
        this.f5915j = new GestureDetector(dragSortListView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(dragSortListView.getContext(), aVar);
        this.f5916k = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f5917l = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.f5928w = i;
        this.f5929x = i4;
        this.f5930y = i5;
        m8118n(i3);
        m8116l(i2);
    }

    @Override
    public void mo7263c(View view, Point point, Point point2) {
        if (this.f5913h && this.f5914i) {
            this.f5908B = point.x;
        }
    }

    public int m8114j(MotionEvent motionEvent) {
        return m8123s(motionEvent, this.f5928w);
    }

    public int m8115k(MotionEvent motionEvent) {
        return m8123s(motionEvent, this.f5930y);
    }

    public void m8116l(int i) {
        this.f5910e = i;
    }

    public void m8117m(boolean z) {
        this.f5913h = z;
    }

    public void m8118n(int i) {
        this.f5912g = i;
    }

    public void m8119o(boolean z) {
        this.f5911f = z;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        if (this.f5913h && this.f5912g == 0) {
            this.f5920o = m8123s(motionEvent, this.f5929x);
        }
        int iM8121q = m8121q(motionEvent);
        this.f5918m = iM8121q;
        if (iM8121q != -1 && this.f5910e == 0) {
            m8120p(iM8121q, ((int) motionEvent.getX()) - this.f5922q, ((int) motionEvent.getY()) - this.f5923r);
        }
        this.f5914i = false;
        this.f5931z = true;
        this.f5908B = 0;
        this.f5919n = m8122r(motionEvent);
        return true;
    }

    @Override
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        if (this.f5918m == -1 || this.f5910e != 2) {
            return;
        }
        this.dragSortListView.performHapticFeedback(0);
        m8120p(this.f5918m, this.f5924s - this.f5922q, this.f5925t - this.f5923r);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        if (r6.f5913h != false) goto L30;
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onScroll(MotionEvent r7, MotionEvent r8, float r9, float r10) {
        /*
            r6 = this;
            r9 = 0
            if (r7 == 0) goto L81
            if (r8 != 0) goto L7
            goto L81
        L7:
            float r10 = r7.getX()
            int r10 = (int) r10
            float r7 = r7.getY()
            int r7 = (int) r7
            float r0 = r8.getX()
            int r0 = (int) r0
            float r8 = r8.getY()
            int r8 = (int) r8
            int r1 = r6.f5922q
            int r1 = r0 - r1
            int r2 = r6.f5923r
            int r2 = r8 - r2
            boolean r3 = r6.f5931z
            if (r3 == 0) goto L81
            boolean r3 = r6.f5926u
            if (r3 != 0) goto L81
            int r3 = r6.f5918m
            r4 = -1
            if (r3 != r4) goto L34
            int r5 = r6.f5919n
            if (r5 == r4) goto L81
        L34:
            r5 = 1
            if (r3 == r4) goto L64
            int r3 = r6.f5910e
            if (r3 != r5) goto L4e
            int r8 = r8 - r7
            int r7 = java.lang.Math.abs(r8)
            int r8 = r6.f5917l
            if (r7 <= r8) goto L4e
            boolean r7 = r6.f5911f
            if (r7 == 0) goto L4e
            int r7 = r6.f5918m
        L4a:
            r6.m8120p(r7, r1, r2)
            goto L81
        L4e:
            int r7 = r6.f5910e
            if (r7 == 0) goto L81
            int r0 = r0 - r10
            int r7 = java.lang.Math.abs(r0)
            int r8 = r6.f5917l
            if (r7 <= r8) goto L81
            boolean r7 = r6.f5913h
            if (r7 == 0) goto L81
        L5f:
            r6.f5914i = r5
            int r7 = r6.f5919n
            goto L4a
        L64:
            int r3 = r6.f5919n
            if (r3 == r4) goto L81
            int r0 = r0 - r10
            int r10 = java.lang.Math.abs(r0)
            int r0 = r6.f5917l
            if (r10 <= r0) goto L76
            boolean r10 = r6.f5913h
            if (r10 == 0) goto L76
            goto L5f
        L76:
            int r8 = r8 - r7
            int r7 = java.lang.Math.abs(r8)
            int r8 = r6.f5917l
            if (r7 <= r8) goto L81
            r6.f5931z = r9
        L81:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ViewOnTouchListenerC1907j9.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        int i;
        if (!this.f5913h || this.f5912g != 0 || (i = this.f5920o) == -1) {
            return true;
        }
        dragSortListView.m7234i0(i - dragSortListView.getHeaderViewsCount());
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dragSortListView.m7229d0() && !this.dragSortListView.m7230e0()) {
            this.f5915j.onTouchEvent(motionEvent);
            if (this.f5913h && this.f5926u && this.f5912g == 1) {
                this.f5916k.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                    }
                } else if (this.f5913h && this.f5914i) {
                    int i = this.f5908B;
                    if (i < 0) {
                        i = -i;
                    }
                    if (i > this.dragSortListView.getWidth() / 2) {
                        this.dragSortListView.m7242q0(true, 0.0f);
                    }
                }
                this.f5914i = false;
                this.f5926u = false;
            } else {
                this.f5924s = (int) motionEvent.getX();
                this.f5925t = (int) motionEvent.getY();
            }
        }
        return false;
    }

    public boolean m8120p(int i, int i2, int i3) {
        int i4 = (!this.f5911f || this.f5914i) ? 0 : 12;
        if (this.f5913h && this.f5914i) {
            i4 |= 3;
        }
        DragSortListView dragSortListView = this.dragSortListView;
        boolean zM7238m0 = dragSortListView.m7238m0(i - dragSortListView.getHeaderViewsCount(), i4, i2, i3);
        this.f5926u = zM7238m0;
        return zM7238m0;
    }

    public int m8121q(MotionEvent motionEvent) {
        return m8114j(motionEvent);
    }

    public int m8122r(MotionEvent motionEvent) {
        if (this.f5912g == 1) {
            return m8115k(motionEvent);
        }
        return -1;
    }

    public int m8123s(MotionEvent motionEvent, int i) {
        int iPointToPosition = this.dragSortListView.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.dragSortListView.getHeaderViewsCount();
        int footerViewsCount = this.dragSortListView.getFooterViewsCount();
        int count = this.dragSortListView.getCount();
        if (iPointToPosition != -1 && iPointToPosition >= headerViewsCount && iPointToPosition < count - footerViewsCount) {
            DragSortListView dragSortListView = this.dragSortListView;
            View childAt = dragSortListView.getChildAt(iPointToPosition - dragSortListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View viewFindViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (viewFindViewById != null) {
                viewFindViewById.getLocationOnScreen(this.f5921p);
                int[] iArr = this.f5921p;
                int i2 = iArr[0];
                if (rawX > i2 && rawY > iArr[1] && rawX < i2 + viewFindViewById.getWidth() && rawY < this.f5921p[1] + viewFindViewById.getHeight()) {
                    this.f5922q = childAt.getLeft();
                    this.f5923r = childAt.getTop();
                    return iPointToPosition;
                }
            }
        }
        return -1;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
    }
}
