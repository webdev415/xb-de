package p000;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

public class C0848Sb {

    public static C0848Sb f2629k;

    public BrowserActivity f2630a;

    public View f2631b;

    public long f2632c;

    public float f2633d;

    public float f2634e;

    public int f2635f;

    public int f2636g;

    public int f2637h;

    public int f2638i;

    public int f2639j;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            C0848Sb.this.f2630a.getBrowserFrameLayout().m6457f();
        }
    }

    public class b implements View.OnTouchListener {

        public float f2641a;

        public float f2642b;

        public b() {
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                C0848Sb.this.f2633d = view.getX() - motionEvent.getRawX();
                C0848Sb.this.f2634e = view.getY() - motionEvent.getRawY();
                this.f2641a = motionEvent.getRawX();
                this.f2642b = motionEvent.getRawY();
                C0848Sb.this.f2632c = System.currentTimeMillis();
                C0848Sb.this.f2637h = 0;
            } else if (actionMasked == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis() - C0848Sb.this.f2632c;
                float fAbs = Math.abs(motionEvent.getRawX() - this.f2641a);
                float fAbs2 = Math.abs(motionEvent.getRawY() - this.f2642b);
                if (jCurrentTimeMillis < 200 && fAbs < 10.0f && fAbs2 < 10.0f) {
                    view.performClick();
                }
            } else {
                if (actionMasked != 2) {
                    return false;
                }
                float rawX = motionEvent.getRawX() + C0848Sb.this.f2633d;
                float rawY = motionEvent.getRawY() + C0848Sb.this.f2634e;
                int width = C0848Sb.this.f2630a.getWindow().getDecorView().getWidth();
                int height = C0848Sb.this.f2630a.getWindow().getDecorView().getHeight();
                int width2 = view.getWidth();
                int height2 = view.getHeight();
                if (rawX < 0.0f) {
                    rawX = 0.0f;
                } else {
                    float f = width - width2;
                    if (rawX > f) {
                        rawX = f;
                    }
                }
                if (rawY < 0.0f) {
                    rawY = 0.0f;
                } else {
                    float f2 = height - height2;
                    if (rawY > f2) {
                        rawY = f2;
                    }
                }
                view.setY(rawY);
                view.setX(rawX);
                C0848Sb.this.f2637h = 2;
                C0848Sb.this.f2635f = (int) view.getX();
                C0848Sb.this.f2636g = (int) view.getY();
            }
            return true;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override
        public void run() {
            View view;
            int height;
            if (C0848Sb.this.f2636g <= 0 || C0848Sb.this.f2635f >= C0848Sb.this.f2630a.getWindow().getDecorView().getWidth() - C0848Sb.this.f2631b.getWidth() || C0848Sb.this.f2636g <= 0 || C0848Sb.this.f2636g >= C0848Sb.this.f2630a.getWindow().getDecorView().getHeight() - C0848Sb.this.f2631b.getHeight()) {
                C0848Sb.this.f2631b.setX((r0.f2630a.getWindow().getDecorView().getWidth() - C0848Sb.this.f2631b.getWidth()) - C0848Sb.this.f2639j);
                C0848Sb c0848Sb = C0848Sb.this;
                view = c0848Sb.f2631b;
                height = (c0848Sb.f2630a.getWindow().getDecorView().getHeight() - C0848Sb.this.f2631b.getHeight()) - C0848Sb.this.f2638i;
            } else {
                C0848Sb.this.f2631b.setX(r0.f2635f);
                C0848Sb c0848Sb2 = C0848Sb.this;
                view = c0848Sb2.f2631b;
                height = c0848Sb2.f2636g;
            }
            view.setY(height);
            C0848Sb.this.f2631b.setVisibility(View.VISIBLE);
        }
    }

    public static C0848Sb m4048n() {
        if (f2629k == null) {
            f2629k = new C0848Sb();
        }
        return f2629k;
    }

    public void m4049o() {
        this.f2631b.setVisibility(View.INVISIBLE);
    }

    public void m4050p(BrowserActivity browserActivity) {
        this.f2630a = browserActivity;
        this.f2631b = browserActivity.findViewById(R.id.fullscreen_float_btn_holder);
        this.f2639j = (int) this.f2630a.getResources().getDimension(R.dimen.full_screen_float_btn_right_margin);
        this.f2638i = (int) this.f2630a.getResources().getDimension(R.dimen.full_screen_float_btn_bottom_margin);
        this.f2631b.setOnClickListener(new a());
        this.f2635f = SharedPreferencesHelper.getInstance().getInt("last_float_btn_x", -1);
        this.f2636g = SharedPreferencesHelper.getInstance().getInt("last_float_btn_y", -1);
        this.f2631b.setOnTouchListener(new b());
    }

    public void m4051q() {
        SharedPreferencesHelper.getInstance().putInt("last_float_btn_x", (int) this.f2631b.getX());
        SharedPreferencesHelper.getInstance().putInt("last_float_btn_y", (int) this.f2631b.getY());
    }

    public void m4052r() {
        this.f2631b.post(new c());
    }

    public boolean m4053s(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        this.f2631b.getHitRect(rect);
        return rect.contains((int) x, (int) y);
    }
}
