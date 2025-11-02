package p000;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xbrowser.play.R;

public class C2564xb {

    public static C2564xb f7967f;

    public FrameLayout f7969b;

    public int f7971d;

    public int f7972e;

    public Activity f7968a = null;

    public boolean f7970c = false;

    public static C2564xb m10653b() {
        if (f7967f == null) {
            f7967f = new C2564xb();
        }
        return f7967f;
    }

    public void m10654a() {
        ((FrameLayout) this.f7968a.getWindow().getDecorView()).removeView(this.f7969b);
        this.f7970c = false;
    }

    public void m10655c(Activity activity) {
        this.f7968a = activity;
        this.f7969b = new FrameLayout(activity);
        this.f7969b.addView(View.inflate(this.f7968a, R.layout.float_message_box, null));
        this.f7971d = (int) this.f7968a.getResources().getDimension(R.dimen.float_message_box_width);
        this.f7972e = (int) this.f7968a.getResources().getDimension(R.dimen.float_message_box_margin);
    }

    public void m10656d(int i, Drawable drawable, String str) {
        if (!this.f7970c) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (i == -1) {
                layoutParams.gravity = 17;
            } else {
                layoutParams.gravity = 49;
                layoutParams.topMargin = i - this.f7972e;
            }
            layoutParams.width = this.f7971d;
            ((FrameLayout) this.f7968a.getWindow().getDecorView()).addView(this.f7969b, layoutParams);
            this.f7970c = true;
        }
        ImageView imageView = (ImageView) this.f7969b.findViewById(R.id.indicator);
        TextView textView = (TextView) this.f7969b.findViewById(R.id.message);
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void m10657e(Drawable drawable, String str) {
        m10656d(-1, drawable, str);
    }
}
