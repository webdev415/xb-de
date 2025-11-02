package p000;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class C0461K0 {

    public static C0461K0 f1497k;

    public final View f1498a;

    public final FrameLayout f1499b;

    public int f1500c;

    public final FrameLayout.LayoutParams f1501d;

    public int f1502e;

    public boolean f1503f = true;

    public final Activity f1504g;

    public final int f1505h;

    public final int f1506i;

    public final int f1507j;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override
        public void onGlobalLayout() {
            if (C0461K0.this.f1503f) {
                C0461K0 c0461k0 = C0461K0.this;
                c0461k0.f1502e = c0461k0.f1498a.getHeight();
                C0461K0.this.f1503f = false;
            }
            Log.i("screen_size", ">>>>>>>>> browser window:" + C0461K0.this.f1499b.getHeight());
            Log.i("screen_size", ">>>>>>>>> h:" + C0461K0.this.f1504g.getWindow().getDecorView().getHeight() + " w" + C0461K0.this.f1504g.getWindow().getDecorView().getWidth() + " contentH:" + C0461K0.this.f1502e);
            C0461K0.this.m2248k();
        }
    }

    public C0461K0(Activity activity) {
        this.f1505h = activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        this.f1506i = activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
        this.f1507j = (int) activity.getResources().getDimension(R.dimen.bottom_toolbar_height);
        this.f1504g = activity;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(android.R.id.content);
        FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(R.id.main_root);
        this.f1499b = frameLayout2;
        if (frameLayout2 != null) {
            Log.i("screen_size", ">>>>>>>>> browser window:" + frameLayout2.getHeight());
        }
        View childAt = frameLayout.getChildAt(0);
        this.f1498a = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.f1501d = (FrameLayout.LayoutParams) childAt.getLayoutParams();
    }

    public static void m2246i(Activity activity) {
        f1497k = new C0461K0(activity);
    }

    public final int m2247j() {
        Rect rect = new Rect();
        this.f1498a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public final void m2248k() {
        FrameLayout.LayoutParams layoutParams;
        int i;
        int iM2247j = m2247j();
        if (iM2247j != this.f1500c) {
            int height = this.f1498a.getRootView().getHeight();
            int i2 = height - iM2247j;
            if (i2 > height / 4) {
                Log.i("screen_size", ">>>>>>>>> usableHeight: + " + height + "usableHeightNow:" + iM2247j);
                if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                    layoutParams = this.f1501d;
                    i = height - i2;
                } else {
                    layoutParams = this.f1501d;
                    i = (height - i2) + this.f1507j;
                }
                layoutParams.height = i;
            } else {
                this.f1501d.height = -1;
            }
            this.f1498a.requestLayout();
            this.f1500c = iM2247j;
        }
    }
}
