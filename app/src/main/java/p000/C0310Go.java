package p000;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class C0310Go {

    public static C0310Go f982g;

    public FrameLayout f984b;

    public BrowserActivity f983a = null;

    public ImageView[] f985c = new ImageView[2];

    public int f986d = 0;

    public int f987e = 0;

    public boolean f988f = false;

    public class a implements Runnable {
        public a() {
        }

        @Override
        public void run() {
            C0310Go c0310Go = C0310Go.this;
            int i = c0310Go.f986d % 2;
            ImageView[] imageViewArr = c0310Go.f985c;
            if (i == 0) {
                imageViewArr[0].setColorFilter(-12303292);
                C0310Go.this.f985c[1].setColorFilter(-1);
            } else {
                imageViewArr[0].setColorFilter(-1);
                C0310Go.this.f985c[1].setColorFilter(-12303292);
            }
            C0310Go c0310Go2 = C0310Go.this;
            c0310Go2.f986d++;
            if (c0310Go2.f988f) {
                c0310Go2.m1449f();
            }
        }
    }

    public static C0310Go m1445b() {
        if (f982g == null) {
            f982g = new C0310Go();
        }
        return f982g;
    }

    public void m1446c(BrowserActivity browserActivity) {
        this.f983a = browserActivity;
        this.f984b = new FrameLayout(browserActivity);
        this.f984b.addView(View.inflate(this.f983a, R.layout.play_speed_indicator, null));
        this.f985c[0] = (ImageView) this.f984b.findViewById(R.id.speed_indicator_one);
        this.f985c[1] = (ImageView) this.f984b.findViewById(R.id.speed_indicator_two);
        this.f987e = (int) this.f983a.getResources().getDimension(R.dimen.video_long_press_indicator_top_margin);
    }

    public void m1447d(FrameLayout frameLayout) {
        this.f988f = false;
        frameLayout.removeView(this.f984b);
        this.f983a.m6361u0("_XJSAPI_.update_play_speed(1.0)");
    }

    public void m1448e(FrameLayout frameLayout) {
        this.f988f = true;
        this.f986d = 0;
        frameLayout.removeView(this.f984b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f987e;
        frameLayout.addView(this.f984b, layoutParams);
        this.f983a.m6361u0("_XJSAPI_.update_play_speed(3.0)");
        m1449f();
    }

    public final void m1449f() {
        this.f984b.postDelayed(new a(), 250L);
    }
}
