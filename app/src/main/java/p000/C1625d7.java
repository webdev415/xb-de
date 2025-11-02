package p000;

import android.graphics.drawable.Drawable;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public class C1625d7 extends AbstractC2128o {
    public C1625d7(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f6504b = 0xFF000000;
        this.f6512j = 0xFF000000;
        this.f6509g = 0xFF000000;
        this.f6507e = 0xFF000000;
        this.backgroundColor = 0xFF000000;
        this.f6526x = 0xFF000000;
        this.f6510h = -1734829928;
        this.f6496J = 1.0f;
        this.f6525w = -986896;
        this.f6487A = 0xFF000000;
        this.f6491E = -4210753;
        this.f6527y = -4210753;
        this.f6492F = -11053225;
        this.f6488B = -10197916;
        this.f6522t = -986896;
        this.f6500N = false;
        this.f6524v = -986896;
    }

    @Override
    public int mo1384c() {
        return 0xFF000000;
    }

    @Override
    public int mo1388g() {
        return 0xFF000000;
    }

    @Override
    public String getKey() {
        return "dark";
    }

    @Override
    public Drawable getBackground() {
        return this.browserActivity.getResources().getDrawable(R.drawable.black);
    }

    @Override
    public Drawable mo7302o() {
        return m8823x(R.drawable.night_context_menu_bg);
    }

    @Override
    public Drawable mo7303p() {
        return m8823x(R.drawable.night_sugguest_hotwrod_bg);
    }

    @Override
    public Drawable mo7304q() {
        return m8823x(R.drawable.night_main_menu_bg);
    }

    @Override
    public Drawable mo7305r() {
        return m8823x(R.drawable.night_tool_bar_bg);
    }

    @Override
    public Drawable mo7306s() {
        return m8823x(R.drawable.message_box_bg_dark);
    }

    @Override
    public Drawable mo7307t() {
        return m8823x(R.drawable.night_muti_window_item_bg);
    }

    @Override
    public Drawable mo7308w() {
        return m8823x(R.drawable.night_tool_bar_bg);
    }
}
