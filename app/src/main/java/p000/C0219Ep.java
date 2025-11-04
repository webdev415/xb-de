package p000;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.C1570e;
import com.mmbox.xbrowser.SharedPreferencesHelper;

public class C0219Ep extends WebView {

    public static boolean f545E = false;

    public Drawable f546A;

    public Runnable f547B;

    public View f548C;

    public FrameLayout f549D;

    public int f550a;

    public int f551b;

    public int f552c;

    public final int f553d;

    public boolean f554e;

    public boolean f555f;

    public boolean f556g;

    public MotionEvent f557h;

    public MotionEvent f558i;

    public String hitTestData;

    public boolean f560k;

    public boolean f561l;

    public final int f562m;

    public FrameLayout.LayoutParams f563n;

    public VelocityTracker f564o;

    public float f565p;

    public final Rect f566q;

    public int f567r;

    public float f568s;

    public int f569t;

    public float f570u;

    public boolean f571v;

    public boolean f572w;

    public final int f573x;

    public int f574y;

    public Drawable f575z;

    public class a implements Runnable {
        public a() {
        }

        @Override
        public void run() throws Resources.NotFoundException {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(C0219Ep.this.getContext(), R.anim.slide_out_right);
            animationLoadAnimation.setInterpolator(new AccelerateInterpolator());
            C0219Ep.this.f548C.startAnimation(animationLoadAnimation);
            C0219Ep.this.f548C.setVisibility(View.INVISIBLE);
            C0219Ep.this.setVerticalScrollBarEnabled(false);
            Log.i("web-scroll", ">>>> do  hide fast scroll");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override
        public void run() {
            C0219Ep.this.f549D.addView(C0219Ep.this.f548C, C0219Ep.this.f563n);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override
        public void run() {
            C0219Ep.this.f549D.removeView(C0219Ep.this.f548C);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override
        public void run() {
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 1.0f, 100.0f, 0);
            MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis + 10, 1, 1.0f, 100.0f, 0);
            C0219Ep.this.dispatchTouchEvent(motionEventObtain);
            C0219Ep.this.dispatchTouchEvent(motionEventObtain2);
        }
    }

    public class e implements Runnable {

        public final int f580l;

        public final int f581m;

        public class a implements Runnable {

            public final MotionEvent f583l;

            public a(MotionEvent motionEvent) {
                this.f583l = motionEvent;
            }

            @Override
            public void run() {
                C0219Ep.this.dispatchTouchEvent(this.f583l);
            }
        }

        public e(int i, int i2) {
            this.f580l = i;
            this.f581m = i2;
        }

        @Override
        public void run() {
            long jUptimeMillis = SystemClock.uptimeMillis();
            int i = this.f580l;
            int i2 = this.f581m;
            MotionEvent.obtain(C0219Ep.this.f557h);
            float f = i;
            float f2 = i2;
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, f, f2, 0);
            MotionEvent.obtain(jUptimeMillis, jUptimeMillis + 20, 2, i + 20, f2, 0);
            MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis + 100, 1, f, f2, 0);
            C0219Ep.this.dispatchTouchEvent(motionEventObtain);
            C0219Ep.this.postDelayed(new a(motionEventObtain2), 100L);
        }
    }

    public class f implements Runnable {

        public final int f585l;

        public final int f586m;

        public class a implements Runnable {

            public final MotionEvent f588l;

            public class RunnableC2687a implements Runnable {
                public RunnableC2687a() {
                }

                @Override
                public void run() {
                    if (C0219Ep.this.f560k) {
                        return;
                    }
                    JSManager.getInstance().evaluateJavascript(C0219Ep.this, "_XJSAPI_.force_select_text(" + C0219Ep.this.f550a + "," + C0219Ep.this.f551b + "," + C0219Ep.this.getHeight() + "," + C0219Ep.this.getWidth() + ")");
                }
            }

            public a(MotionEvent motionEvent) {
                this.f588l = motionEvent;
            }

            @Override
            public void run() {
                C0219Ep.this.dispatchTouchEvent(this.f588l);
                C0219Ep.this.getHandler().post(new RunnableC2687a());
            }
        }

        public f(int i, int i2) {
            this.f585l = i;
            this.f586m = i2;
        }

        @Override
        public void run() {
            long jUptimeMillis = SystemClock.uptimeMillis();
            int i = this.f585l;
            int i2 = this.f586m;
            MotionEvent.obtain(C0219Ep.this.f557h);
            float f = i;
            float f2 = i2;
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, f, f2, 0);
            MotionEvent.obtain(jUptimeMillis, jUptimeMillis + 20, 2, i + 20, f2, 0);
            MotionEvent motionEventObtain2 = MotionEvent.obtain(jUptimeMillis, jUptimeMillis + 700, 1, f, f2, 0);
            C0219Ep.this.dispatchTouchEvent(motionEventObtain);
            C0219Ep.this.postDelayed(new a(motionEventObtain2), 700L);
        }
    }

    public C0219Ep(Context context) {
        super(context);
        this.f554e = false;
        this.f555f = false;
        this.f556g = false;
        this.f557h = null;
        this.f558i = null;
        this.hitTestData = null;
        this.f560k = false;
        this.f561l = false;
        this.f563n = null;
        this.f565p = 0.0f;
        this.f566q = new Rect();
        this.f567r = 0;
        this.f568s = 0.0f;
        this.f569t = 0;
        this.f570u = 0.0f;
        this.f571v = false;
        this.f572w = false;
        this.f574y = 0;
        this.f575z = null;
        this.f546A = null;
        this.f547B = new a();
        this.f548C = null;
        this.f549D = null;
        this.f553d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f562m = (int) getResources().getDimension(com.xbrowser.play.R.dimen.swipe_slop);
        this.f548C = View.inflate(context, com.xbrowser.play.R.layout.fast_scroll_bar, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.f563n = layoutParams;
        layoutParams.gravity = 5;
        this.f549D = (FrameLayout) BrowserActivity.getActivity().findViewById(com.xbrowser.play.R.id.main_content);
        this.f573x = (int) getResources().getDimension(com.xbrowser.play.R.dimen.max_scroll_speed);
        this.f575z = getContext().getResources().getDrawable(com.xbrowser.play.R.drawable.ic_fast_ff);
        this.f546A = getContext().getResources().getDrawable(com.xbrowser.play.R.drawable.ic_fast_back);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0) {
            View view = this.f548C;
            if (view != null && view.getVisibility() == 0) {
                this.f548C.getHitRect(this.f566q);
            }
            this.f571v = this.f566q.contains(x, y);
            this.f550a = (int) motionEvent.getX();
            this.f551b = (int) motionEvent.getY();
            getHandler().removeCallbacks(this.f547B);
            this.f557h = MotionEvent.obtain(motionEvent);
            this.hitTestData = null;
        } else if (action == 1) {
            this.f558i = MotionEvent.obtain(motionEvent);
        } else if (action == 2 && this.f571v) {
            int i = this.f552c;
            int i2 = i == 0 ? 0 : y - i;
            if (Math.abs(y - this.f551b) >= this.f553d) {
                View view2 = this.f548C;
                view2.layout(view2.getLeft(), this.f548C.getTop() + i2, this.f548C.getRight(), this.f548C.getBottom() + i2);
                m1088i(i2);
            }
            this.f552c = y;
        }
        if (action == 3 || action == 1) {
            this.f571v = false;
            m1085f();
        }
        if (this.f571v && this.f548C.getVisibility() == 0) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void m1084e() {
        JSManager.getInstance().evaluateJavascript(this, "_XJSAPI_.cancel_select()");
    }

    public final void m1085f() {
        if (getHandler() == null) {
            return;
        }
        if (this.f547B != null) {
            getHandler().removeCallbacks(this.f547B);
        }
        View view = this.f548C;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        getHandler().postDelayed(this.f547B, 1500L);
    }

    public final void m1086g() {
        this.f572w = true;
        JSManager.getInstance().evaluateJavascript(this, "if(window._XJSAPI_ != undefined) _XJSAPI_.hit_test(" + this.f550a + "," + this.f551b + "," + getHeight() + "," + getWidth() + ")");
    }

    public String getHitTestData() {
        return this.hitTestData;
    }

    public int getLastMotionX() {
        return this.f550a;
    }

    public int getLastMotionY() {
        return this.f551b;
    }

    public void m1087h(boolean z) {
        if (z) {
            this.f560k = true;
        } else {
            this.f560k = false;
            m1084e();
        }
    }

    public final void m1088i(int i) {
        scrollBy(0, (int) (i * this.f570u));
    }

    public final void m1089j() {
        BrowserActivity.getActivity().m6196C2(0);
        if (this.f574y != 0) {
            Log.i("video-seek", "seek " + this.f574y);
            JSManager.getInstance().evaluateJavascript(this, "_XJSAPI_.change_video_seek(" + this.f574y + ")");
        }
    }

    public void m1090k() {
        JSManager.getInstance().evaluateJavascript(this, "_XJSAPI_.select_text(" + this.f550a + "," + this.f551b + "," + getHeight() + "," + getWidth() + ")");
    }

    public void m1091l(int i, int i2) {
        post(new f(i, i2));
    }

    public void m1092m() {
        post(new d());
    }

    public void m1093n(int i, int i2) {
        post(new e(i, i2));
    }

    public final void m1094o() {
        this.f548C.setVisibility(View.VISIBLE);
        setVerticalScrollBarEnabled(true);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f549D != null) {
            this.f548C.setVisibility(View.VISIBLE);
            this.f549D.post(new b());
        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f549D != null) {
            this.f548C.setVisibility(View.INVISIBLE);
            this.f549D.post(new c());
        }
        Log.i("web-scroll", "deattch to main view");
    }

    @Override
    public void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        Log.i("web-scroll", "scrollX:" + scrollX + "over scroll y:" + scrollY + " clampedX:" + clampedX + " clampedY:" + clampedY);
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        SharedPreferencesHelper.getInstance().canHScroll = !clampedX;
        SharedPreferencesHelper.getInstance().canVScroll = !clampedY;
    }

    @Override
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (SharedPreferencesHelper.getInstance().disableFastScrollingSlider) {
            return;
        }
        setVerticalScrollBarEnabled(true);
        float contentHeight = getContentHeight() * getScale();
        int measuredHeight = getMeasuredHeight();
        float f2 = measuredHeight;
        this.f568s = contentHeight - f2;
        int scrollY = getScrollY();
        boolean z = contentHeight / f2 > 5.0f;
        if (z && this.f565p >= this.f573x) {
            m1094o();
            m1085f();
        }
        View view = this.f548C;
        if (view == null || !z) {
            return;
        }
        float f3 = scrollY / this.f568s;
        int measuredHeight2 = view.getMeasuredHeight();
        int i5 = measuredHeight - measuredHeight2;
        this.f569t = i5;
        this.f570u = this.f568s / i5;
        this.f567r = (int) (i5 * f3);
        View view2 = this.f548C;
        view2.layout(view2.getLeft(), this.f567r, this.f548C.getRight(), this.f567r + measuredHeight2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C2564xb c2564xbM10653b;
        Drawable drawable;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f555f = false;
            this.f574y = 0;
            this.f556g = false;
            this.f565p = 0.0f;
            this.f560k = false;
        }
        if (!this.f560k) {
            if (action == 0) {
                VelocityTracker velocityTracker = this.f564o;
                if (velocityTracker == null) {
                    this.f564o = VelocityTracker.obtain();
                } else {
                    velocityTracker.clear();
                }
                this.f564o.addMovement(motionEvent);
                this.f554e = true;
                this.f561l = false;
                m1086g();
            } else if (action == 2) {
                this.f564o.addMovement(motionEvent);
                this.f564o.computeCurrentVelocity(1000);
                this.f565p = Math.abs(this.f564o.getYVelocity());
                int x = (int) motionEvent.getX();
                Math.abs(this.f550a - x);
                int y = (int) motionEvent.getY();
                Math.abs(y - this.f551b);
                if (BrowserActivity.getActivity().m6226K0() == 1) {
                    Log.i("video-gesutre", ">>>> do seek >>>>>>");
                    int i = this.f550a - x;
                    int i2 = this.f551b - y;
                    if (Math.abs(i) > this.f553d && Math.abs(i) > Math.abs(i2) / 2) {
                        float fAbs = (Math.abs(i) - this.f553d) / 2.0f;
                        if (i > 0) {
                            this.f574y = -((int) (fAbs * BrowserActivity.getActivity().m6270V0()));
                            c2564xbM10653b = C2564xb.getInstance();
                            drawable = this.f546A;
                        } else {
                            this.f574y = (int) (fAbs * BrowserActivity.getActivity().m6270V0());
                            c2564xbM10653b = C2564xb.getInstance();
                            drawable = this.f575z;
                        }
                        c2564xbM10653b.m10656d(y, drawable, AndroidSystemUtils.m8710r(Math.abs(this.f574y) * 1000));
                    }
                }
            } else if (action == 1) {
                this.f554e = false;
                int y2 = (int) motionEvent.getY();
                int x2 = (int) motionEvent.getX();
                boolean zM1095p = m1095p();
                if (Math.abs(this.f551b - y2) < this.f553d && Math.abs(this.f550a - x2) < this.f553d && motionEvent.getEventTime() - motionEvent.getDownTime() < 500 && SharedPreferencesHelper.getInstance().supportTouchPageDown && zM1095p) {
                    if (this.f551b > getHeight() / 2) {
                        pageDown(false);
                    } else {
                        pageUp(false);
                    }
                }
                if (SharedPreferencesHelper.getInstance().supportTouchPageDown && Math.abs(this.f551b - y2) < this.f553d) {
                    Math.abs(this.f550a - x2);
                }
                m1089j();
                if (this.f555f) {
                    motionEvent.setAction(3);
                }
            } else if (action == 3) {
                m1089j();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override
    public void onWindowVisibilityChanged(int visibility) {
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            String host = Uri.parse(url).getHost();
            if (!TextUtils.isEmpty(host) && C1570e.getInstance().m6961c(host)) {
                if (visibility != 8) {
                    super.onWindowVisibilityChanged(0);
                    return;
                }
                return;
            }
        }
        super.onWindowVisibilityChanged(visibility);
    }

    public final boolean m1095p() {
        HitTestResult hitTestResult = getHitTestResult();
        if (hitTestResult != null) {
            int type = hitTestResult.getType();
            if (type == 0 || type == 5) {
                f545E = true;
                return true;
            }
            f545E = false;
        }
        return false;
    }

    public void setHitTestData(String data) {
        this.hitTestData = data;
    }
}
