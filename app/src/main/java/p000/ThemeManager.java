package p000;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ThemeManager {

    public static final int[] f6998j = {-12303292, -12303292};

    public static ThemeManager instance = null;

    public int navigationBarColor;

    public BrowserActivity browserActivity = null;

    public final ArrayList<Integer> idList = new ArrayList<>(5);

    public final HashMap<String, InterfaceC0299Gd> f7002c = new HashMap<>(5);

    public final ArrayList<View> views = new ArrayList<>(3);

    public String mode = null;

    public final String f7005f = "light";

    public final int f7006g = -1;

    public boolean f7008i = true;

    public static ThemeManager getInstance() {
        if (instance == null) {
            instance = new ThemeManager();
        }
        return instance;
    }

    public boolean isColorLight(int color) {
        // Extract RGB components
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        // Calculate luminance (optimized to avoid unnecessary casting to double)
        int luminance = (int) (red * 0.2126 + green * 0.7152 + blue * 0.0722);

        // Return true if luminance is greater than 128, indicating a light color
        return luminance > 128;
    }

    public void m9474B(int[] iArr) {
        m9500u().mo1387f(iArr);
    }

    public void m9475C(InterfaceC0299Gd interfaceC0299Gd) {
        this.f7002c.put(interfaceC0299Gd.getKey(), interfaceC0299Gd);
    }

    public void m9476D() {
        m9474B(new int[]{m9500u().mo1388g(), m9500u().mo1384c()});
    }

    public void m9477E() {
        this.mode = "light";
    }

    public void m9478F(Activity activity) {
        if (TextUtils.isEmpty(this.mode)) {
            return;
        }
        InterfaceC0299Gd interfaceC0299Gd = (InterfaceC0299Gd) this.f7002c.get(this.mode);
        if (interfaceC0299Gd == null) {
            interfaceC0299Gd = (InterfaceC0299Gd) this.f7002c.get("light");
        }
        activity.getWindow().setBackgroundDrawable(interfaceC0299Gd.getBackground());
        interfaceC0299Gd.start();
        for (Integer id : this.idList) {
            View view = findViewByIdInViews(id);
            if (view != null) {
                interfaceC0299Gd.setLayoutView(view);
            }
        }
    }

    public void m9479G() {
        ViewGroup viewGroup = (ViewGroup) this.browserActivity.getBrowserFrameLayout().findViewById(R.id.bottom_content);
        viewGroup.removeAllViews();
        View viewM9498s = m9498s();
        View viewInflate = View.inflate(this.browserActivity, R.layout.toolbar_mark, null);
        viewGroup.addView(viewM9498s);
        viewGroup.addView(viewInflate);
    }

    public final void addViewIfAbsent(View view) {
        if (this.views.contains(view)) {
            return;
        }
        this.views.add(view);
    }

    public void m9481b(Activity activity, String str) {
        this.mode = str;
        m9478F(activity);
    }

    public View inflateContextMenuItem(ViewGroup root) {
        View view = this.browserActivity.getLayoutInflater().inflate(R.layout.context_menu_item, root, false);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) this.browserActivity.getResources().getDimension(R.dimen.context_menu_item_height)));
        m9500u().setLayoutView(view);
        return view;
    }

    public View inflateContextMenuView(Context context, ViewGroup root) {
        View view = this.browserActivity.getLayoutInflater().inflate(R.layout.context_menu_view, root, false);
        if (SharedPreferencesHelper.getInstance().enterNightMode) {
            view.setBackgroundResource(R.drawable.night_context_menu_bg);
        }
        addViewIfAbsent(view);
        return view;
    }

    public View getFloatControlView() {
        View view = View.inflate(this.browserActivity, R.layout.float_control_box, null);
        m9500u().setLayoutView(view);
        return view;
    }

    public View m9485f() {
        View viewInflate = View.inflate(this.browserActivity, R.layout.suggestion_hotword, null);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9486g(ViewGroup viewGroup) {
        View viewInflate = View.inflate(this.browserActivity, R.layout.main_menu_item, null);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public View m9487h(ViewGroup r6) {
        /*
            r5 = this;
            com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            int r0 = r0.f4890Y
            r1 = 4097(0x1001, float:5.741E-42)
            r0 = r0 & r1
            r2 = 2131296321(0x7f090041, float:1.8210555E38)
            r3 = 0
            if (r0 != r1) goto L37
            com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            java.lang.String r1 = "search-bar-at-top.toolbar_layout"
            java.lang.String r4 = "layout_1"
            java.lang.String r0 = r0.m6871P(r1, r4)
            boolean r1 = r0.equals(r4)
            if (r1 != 0) goto L29
            java.lang.String r1 = "layout_5"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
        L29:
            com.mmbox.xbrowser.BrowserActivity r0 = r5.f7000a
            android.view.LayoutInflater r0 = r0.getLayoutInflater()
            r1 = 2131296320(0x7f090040, float:1.8210553E38)
            android.view.View r6 = r0.inflate(r1, r6, r3)
            goto L41
        L37:
            com.mmbox.xbrowser.BrowserActivity r0 = r5.f7000a
            android.view.LayoutInflater r0 = r0.getLayoutInflater()
            android.view.View r6 = r0.inflate(r2, r6, r3)
        L41:
            r5.m9480a(r6)
            Gd r0 = r5.m9500u()
            r0.mo1383b(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ThemeManager.m9487h(android.view.ViewGroup):android.view.View");
    }

    public View m9488i() {
        View viewInflate = View.inflate(this.browserActivity, R.layout.toolbar_layout_mark_ad, null);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9489j(Context context, int i) {
        if (i == 1) {
            View viewInflate = View.inflate(context, R.layout.default_message_bar, null);
            m9500u().setLayoutView(viewInflate);
            return viewInflate;
        }
        if (i != 2) {
            if (i == 3) {
                return View.inflate(context, R.layout.tiny_message_bar, null);
            }
            if (i != 4) {
                return null;
            }
        }
        View viewInflate2 = View.inflate(context, R.layout.default_message_bar2, null);
        m9500u().setLayoutView(viewInflate2);
        return viewInflate2;
    }

    public View m9490k(ViewGroup viewGroup) {
        View viewInflate = this.browserActivity.getLayoutInflater().inflate(R.layout.muti_window_item, viewGroup, false);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9491l(ViewGroup viewGroup) {
        View viewInflate = this.browserActivity.getLayoutInflater().inflate(R.layout.muti_window_list, viewGroup, false);
        addViewIfAbsent(viewInflate);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9492m() {
        View viewInflate = View.inflate(this.browserActivity, R.layout.video_open_menu_item, null);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9493n() {
        View viewInflate = this.browserActivity.getLayoutInflater().inflate(R.layout.pop_video_play_settings, (ViewGroup) null, false);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9494o(ViewGroup viewGroup) {
        View viewInflate = this.browserActivity.getLayoutInflater().inflate(R.layout.pop_menu_item, viewGroup, false);
        viewInflate.setLayoutParams(new AbsListView.LayoutParams(-1, (int) this.browserActivity.getResources().getDimension(R.dimen.context_menu_item_height)));
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9495p(ViewGroup viewGroup) {
        View viewInflate = this.browserActivity.getLayoutInflater().inflate(R.layout.pop_menu_view, viewGroup, false);
        addViewIfAbsent(viewInflate);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9496q(ViewGroup viewGroup, int i) {
        Context context;
        int i2;
        if (i == 1) {
            context = viewGroup.getContext();
            i2 = R.layout.suggestion_item_normal;
        } else if (i == 7) {
            context = viewGroup.getContext();
            i2 = R.layout.suggestion_item_tab;
        } else if (i == 2) {
            context = viewGroup.getContext();
            i2 = R.layout.suggestion_item_trans;
        } else if (i == 3) {
            context = viewGroup.getContext();
            i2 = R.layout.suggestion_item_clipboard;
        } else if (i == 8) {
            context = viewGroup.getContext();
            i2 = R.layout.suggestion_item_current_input;
        } else if (i == 0) {
            context = viewGroup.getContext();
            i2 = R.layout.suggestion_hotwords_container;
        } else if (i == 4) {
            context = viewGroup.getContext();
            i2 = R.layout.suggestion_search_his_container;
        } else if (i == 5) {
            context = viewGroup.getContext();
            i2 = R.layout.suggestion_keywords_container;
        } else {
            if (i != 6) {
                throw new IllegalStateException("invalid item type");
            }
            context = viewGroup.getContext();
            i2 = R.layout.suggestion_item_current_url;
        }
        View viewInflate = View.inflate(context, i2, null);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9497r() {
        View viewInflate = View.inflate(this.browserActivity, R.layout.tts_float_control_btn, null);
        m9500u().setLayoutView(viewInflate);
        return viewInflate;
    }

    public View m9498s() {
        int i;
        BrowserActivity browserActivity;
        int i2;
        if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4097) == 4097) {
            String strM6871P = SharedPreferencesHelper.getInstance().getString("search-bar-at-top.toolbar_layout", "layout_1");
            boolean zEquals = strM6871P.equals("layout_1");
            i = R.layout.toolbar_layout_1;
            if (!zEquals) {
                if (strM6871P.equals("layout_2")) {
                    browserActivity = this.browserActivity;
                    i2 = R.layout.toolbar_layout_2;
                } else if (strM6871P.equals("layout_5")) {
                    browserActivity = this.browserActivity;
                    i2 = R.layout.toolbar_layout_5;
                }
                return View.inflate(browserActivity, i2, null);
            }
            return View.inflate(this.browserActivity, i, null);
        }
        if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4098) != 4098) {
            throw new IllegalStateException("Not invalid layout type");
        }
        String strM6871P2 = SharedPreferencesHelper.getInstance().getString("search-bar-at-bottom.toolbar_layout", "layout_4");
        boolean zEquals2 = strM6871P2.equals("layout_4");
        i = R.layout.toolbar_layout_4;
        if (!zEquals2) {
            if (strM6871P2.equals("layout_3")) {
                browserActivity = this.browserActivity;
                i2 = R.layout.toolbar_layout_3;
            } else if (strM6871P2.equals("layout_6")) {
                browserActivity = this.browserActivity;
                i2 = R.layout.toolbar_layout_6;
            }
            return View.inflate(browserActivity, i2, null);
        }
        return View.inflate(this.browserActivity, i, null);
    }

    public WebView m9499t() {
        WebView webView = AbstractC0907To.m4181a(this.browserActivity, 0);
        webView.setId(4663);
        m9500u().setLayoutView(webView);
        return webView;
    }

    public InterfaceC0299Gd m9500u() {
        InterfaceC0299Gd interfaceC0299Gd = this.f7002c.get(this.mode);
        if (interfaceC0299Gd != null) {
            return interfaceC0299Gd;
        }
        this.mode = "light";
        return this.f7002c.get("light");
    }

    public View findViewByIdInViews(int viewId) {
        // Iterate over the list of views to find the one with the matching ID
        for (View view : this.views) {
            if (view.getId() == viewId) {
                return view;
            }
        }
        // If not found in the list, fallback to finding it in the browser activity
        return this.browserActivity.findViewById(viewId);
    }

    public String m9502w() {
        return "light";
    }

    public Drawable getDrawable(int resId, int i2) {
        return m9500u().getDrawable(resId, i2);
    }

    public void init(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
        idList.add(R.id.main_root);
        idList.add(4664);
        idList.add(R.id.toolbar_mixed_container);
        idList.add(R.id.toolbar_container);
        idList.add(R.id.top_content);
        idList.add(R.id.toolbar_mixed_container);
        idList.add(R.id.main_menu_container);
        idList.add(R.id.context_menu_container);
        idList.add(R.id.pop_menu_container);
        idList.add(R.id.muti_window_container);
        idList.add(R.id.find_in_page_box);
        idList.add(R.id.back_indicator);
        idList.add(R.id.forward_indicator);
        idList.add(R.id.search_bar_bottom);
        idList.add(R.id.search_bar_top);
        m9477E();
        navigationBarColor = browserActivity.getWindow().getNavigationBarColor();
    }
}
