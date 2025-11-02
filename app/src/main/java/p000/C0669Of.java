package p000;

import android.graphics.drawable.Drawable;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class C0669Of extends AbstractC2128o {
    public C0669Of(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f6509g = 0xFFFFFFFF;
        this.f6507e = 0xFFFFFFFF;
        this.backgroundColor = 0xFFFFFFFF;
        this.f6504b = 0xFFFFFFFF;
        this.f6526x = 0xFFFFFFFF;
        this.f6510h = -855310;
        this.f6500N = true;
        this.f6502P = true;
        this.f6497K = 0xFFFFFFFF;
    }

    @Override
    public int mo1384c() {
        return -1;
    }

    @Override
    public int mo1388g() {
        return -1;
    }

    @Override
    public String getKey() {
        return "light";
    }

    @Override
    public Drawable getBackground() {
        return this.browserActivity.getResources().getDrawable(R.drawable.white);
    }
}
