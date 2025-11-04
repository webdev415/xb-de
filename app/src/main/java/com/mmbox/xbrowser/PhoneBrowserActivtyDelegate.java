package com.mmbox.xbrowser;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.mmbox.widget.IndicatorImageButton;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.xbrowser.play.R;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import p000.NetworkUtils;
import p000.AbstractC0448Jo;
import p000.AndroidSystemUtils;
import p000.ContentViewManager;
import p000.SingleTextFieldDialog;
import p000.ConfirmDialog;
import p000.C0401In;
import p000.ResourceCacheManager;
import p000.ApiEndpointsManager;
import p000.C0669Of;
import p000.C1039Wi;
import p000.C1045Wo;
import p000.PhoneUtils;
import p000.C1345c2;
import p000.C1625d7;
import p000.JSManager;
import p000.C2179p3;
import p000.ThemeManager;
import p000.C2406u0;
import p000.C2439uo;
import p000.DialogInterfaceOnDismissListenerC0189E4;
import p000.InterfaceC0345Hd;
import p000.InterfaceC0529Ld;
import p000.InterfaceC0575Md;
import p000.InterfaceC1300b3;
import p000.ViewOnClickListenerC0309Gn;
import p000.ViewOnClickListenerC2063mh;
import p000.ViewOnFocusChangeListenerC0985Va;

public class PhoneBrowserActivtyDelegate extends BrowserActivityDelegate implements InterfaceC0529Ld.a, InterfaceC0575Md {

    public BrowserActivity browserActivity;

    public C2179p3 f4514l;

    public C0401In f4515m;

    public TabWindowManager f4516n;

    public class DialogC1520a extends ConfirmDialog {

        public final String f4517f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DialogC1520a(Context context, String str) {
            super(context);
            this.f4517f = str;
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onOK() throws JSONException {
            Toast.makeText(PhoneBrowserActivtyDelegate.this.browserActivity, R.string.toast_uploading_script, Toast.LENGTH_LONG).show();
            JSManager.getInstance().m8484C0(this.f4517f, false);
        }
    }

    public class C1521b implements BrowserDownloadManager.j {
        public C1521b() {
        }

        @Override
        public void mo6445a(String str) {
        }

        @Override
        public void mo6446b(String str, String str2, String str3, long j) {
            PhoneBrowserActivtyDelegate.this.m6399H(str, null, null, NetworkUtils.generateFileName(str, str3, str2), str2, j);
        }
    }

    public class DialogC1522c extends ConfirmDialog {
        public DialogC1522c(Context context) {
            super(context);
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onOK() throws URISyntaxException {
            PhoneBrowserActivtyDelegate.this.browserActivity.m6307d2(C2439uo.getInstance().m10235v() + "&callback=x:rf");
        }
    }

    public class DialogC1523d extends SingleTextFieldDialog {
        public DialogC1523d(BrowserActivity browserActivity, int i) {
            super(browserActivity, i);
        }

        @Override
        public void onOK(String str) {
            if (TextUtils.isEmpty(str) || !NetworkUtils.isHttpUrl(str)) {
                Toast.makeText(PhoneBrowserActivtyDelegate.this.browserActivity, R.string.toast_invalid_url, Toast.LENGTH_SHORT).show();
            } else {
                JSManager.getInstance().m8503M(str);
            }
        }
    }

    public class RunnableC1524e implements Runnable {
        public RunnableC1524e() {
        }

        @Override
        public void run() {
            PhoneBrowserActivtyDelegate.this.browserActivity.m6324h3();
        }
    }

    public class ViewOnClickListenerC1525f implements View.OnClickListener {
        public ViewOnClickListenerC1525f() {
        }

        @Override
        public void onClick(View view) throws URISyntaxException {
            PhoneBrowserActivtyDelegate.this.browserActivity.m6307d2("x:me");
            PhoneBrowserActivtyDelegate.this.f4514l.m9655v();
        }
    }

    public class RunnableC1526g implements Runnable {

        public final InterfaceC1300b3 f4524l;

        public final Bitmap f4525m;

        public RunnableC1526g(InterfaceC1300b3 interfaceC1300b3, Bitmap bitmap) {
            this.f4524l = interfaceC1300b3;
            this.f4525m = bitmap;
        }

        @Override
        public void run() throws IOException {
            String strM445C = NetworkUtils.getFaviconUrl(this.f4524l.getUrlFromTitle());
            if (strM445C != null) {
                AndroidSystemUtils.saveBitmapToFile(this.f4525m, ResourceCacheManager.getInstance().getUrlOrFilePath(strM445C, 1));
            }
        }
    }

    public class ViewOnClickListenerC1527h implements View.OnClickListener {
        public ViewOnClickListenerC1527h() {
        }

        @Override
        public void onClick(View view) throws URISyntaxException {
            PhoneBrowserActivtyDelegate.this.f4514l.m9655v();
            PhoneBrowserActivtyDelegate.this.browserActivity.openUrl("x:settings", true, 0);
        }
    }

    public class ViewOnClickListenerC1528i implements View.OnClickListener {
        public ViewOnClickListenerC1528i() {
        }

        @Override
        public void onClick(View view) {
            PhoneBrowserActivtyDelegate.this.f4514l.m9655v();
        }
    }

    public class ViewOnClickListenerC1529j implements View.OnClickListener {
        public ViewOnClickListenerC1529j() {
        }

        @Override
        public void onClick(View view) throws SQLException {
            PhoneBrowserActivtyDelegate.this.f4514l.m9655v();
            PhoneBrowserActivtyDelegate.this.browserActivity.tryExit();
        }
    }

    public class C1530k implements InterfaceC0529Ld.a {

        public final WebViewBrowserController f4530a;

        public C1530k(WebViewBrowserController webViewBrowserController) {
            this.f4530a = webViewBrowserController;
        }

        @Override
        public void mo1615w(InterfaceC0529Ld interfaceC0529Ld, ContextMenu.ContextMenuInfo contextMenuInfo) {
            int iIntValue = ((Integer) interfaceC0529Ld.mo2666e()).intValue();
            if (iIntValue >= 0) {
                PhoneBrowserActivtyDelegate.this.browserActivity.getTabManager().m9304l(iIntValue);
                return;
            }
            Log.i("back-menu", "go to step:" + iIntValue);
            this.f4530a.m6770F0().goBackOrForward(iIntValue);
        }
    }

    public class RunnableC1531l implements Runnable {
        public RunnableC1531l() {
        }

        @Override
        public void run() {
            PhoneBrowserActivtyDelegate.this.mo6418a0(1);
        }
    }

    public class RunnableC1532m implements Runnable {
        public RunnableC1532m() {
        }

        @Override
        public void run() {
            PhoneBrowserActivtyDelegate.this.mo6417Z();
        }
    }

    public class DialogC1533n extends ConfirmDialog {
        public DialogC1533n(Context context) {
            super(context);
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onOK() throws URISyntaxException {
            PhoneBrowserActivtyDelegate.this.browserActivity.m6307d2(C2439uo.getInstance().m10235v() + "&callback=x:sc");
        }
    }

    public PhoneBrowserActivtyDelegate(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f4514l = null;
        this.f4515m = null;
        this.f4516n = null;
        this.browserActivity = browserActivity;
    }

    public static String m6513r0(String str) {
        try {
            String[] strArrSplit = str.split("/");
            return "https://greasyfork.org/zh-CN/scripts/" + (strArrSplit[4] + "-" + URLDecoder.decode(strArrSplit[5], "UTF-8")).replace(".user.js", "") + "/feedback";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public AbstractScrollableListController mo6393A() {
        return this.f4515m;
    }

    @Override
    public void mo6401J(InterfaceC0345Hd interfaceC0345Hd) {
        super.mo6401J(interfaceC0345Hd);
        this.browserActivity.m6234M0();
    }

    @Override
    public void mo6402K(Bundle bundle) {
        m6406O(R.layout.main_frame);
        this.f4381e = new ViewOnClickListenerC0309Gn(this.browserActivity);
        this.f4382f = new ViewOnFocusChangeListenerC0985Va(this.browserActivity);
        m6521p0();
        m6519n0();
        m6520o0();
    }

    @Override
    public void mo6407P() {
        C0401In c0401In = this.f4515m;
        if (c0401In == null) {
            m6520o0();
        } else {
            c0401In.m9649j();
        }
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_new_script), R.string.pop_menu_new_script);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_new_script_by_sharing), R.string.pop_menu_new_script_by_sharing);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_import_by_tampermonkey), R.string.pop_menu_import_by_tampermonkey);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_import_script_from_file), R.string.pop_menu_import_script_from_file);
        if (PhoneUtils.getInstance().isGooglePlayChannel()) {
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_import_from_greasyfork), R.string.pop_menu_import_from_greasyfork);
        }
        this.f4515m.mo7047F(this.browserActivity.getBrowserFrameLayout().f4455v, this.browserActivity.getBrowserFrameLayout().f4456w, 51);
    }

    @Override
    public void mo6409R(String str) {
        C0401In c0401In = this.f4515m;
        if (c0401In == null) {
            m6520o0();
        } else {
            c0401In.m9649j();
        }
        this.f4515m.m9640C("host", str);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_auto_fill_edit), R.string.pop_menu_auto_fill_edit);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_auto_fill_del), R.string.pop_menu_auto_fill_del);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_auto_fill_copy), R.string.pop_menu_auto_fill_copy);
        this.f4515m.mo7047F(this.browserActivity.getBrowserFrameLayout().f4455v, this.browserActivity.getBrowserFrameLayout().f4456w, 51);
    }

    @Override
    public void mo6410S() {
        C0401In c0401In = this.f4515m;
        if (c0401In == null) {
            m6520o0();
        } else {
            c0401In.m9649j();
        }
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_auto_fill_new), R.string.pop_menu_auto_fill_new);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_auto_fill_export), R.string.pop_menu_auto_fill_export);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_auto_fill_import), R.string.pop_menu_auto_fill_import);
        this.f4515m.mo7047F(this.browserActivity.getBrowserFrameLayout().f4455v, this.browserActivity.getBrowserFrameLayout().f4456w, 51);
    }

    @Override
    public boolean mo6411T() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (!(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return false;
        }
        WebViewBrowserController webViewBrowserController = (WebViewBrowserController) interfaceC1300b3;
        WebBackForwardList webBackForwardListCopyBackForwardList = webViewBrowserController.m6770F0().copyBackForwardList();
        if (webBackForwardListCopyBackForwardList.getSize() == 0) {
            return false;
        }
        new C1345c2(this.browserActivity, new C1530k(webViewBrowserController), webBackForwardListCopyBackForwardList, (int) this.browserActivity.getResources().getDimension(R.dimen.ctx_menu_width), -2).mo7047F((int) this.browserActivity.getResources().getDimension(R.dimen.back_list_menu_margin_x), this.browserActivity.findViewById(R.id.bottom_content).getHeight() + ((int) this.browserActivity.getResources().getDimension(R.dimen.back_list_menu_margin_y)), 83);
        return true;
    }

    @Override
    public void mo6412U(String str) {
        C0401In c0401In = this.f4515m;
        if (c0401In == null) {
            m6520o0();
        } else {
            c0401In.m9649j();
        }
        this.f4515m.m9640C("current_path", str);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_new_bm), R.string.pop_menu_new_bm);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_new_bm_dir), R.string.pop_menu_new_bm_dir);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_bm_edit_mode), R.string.pop_menu_bm_edit_mode);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_import_bm), R.string.pop_menu_import_bm);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_export_bm), R.string.pop_menu_export_bm);
        this.f4515m.mo7047F(this.browserActivity.getBrowserFrameLayout().f4455v, this.browserActivity.getBrowserFrameLayout().f4456w, 51);
    }

    @Override
    public void mo6413V(String str) {
        C0401In c0401In = this.f4515m;
        if (c0401In == null) {
            m6520o0();
        } else {
            c0401In.m9649j();
        }
        this.f4515m.m9640C("download_id", str);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_dl_open), R.string.pop_menu_dl_open);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_dl_re_download), R.string.pop_menu_dl_re_download);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_dl_remove), R.string.pop_menu_dl_remove);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_dl_copy_url), R.string.pop_menu_dl_copy_url);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_dl_share), R.string.pop_menu_dl_share);
        this.f4515m.mo7047F(this.browserActivity.getBrowserFrameLayout().f4455v, this.browserActivity.getBrowserFrameLayout().f4456w, 51);
    }

    @Override
    public void mo6415X() {
        C0401In c0401In = this.f4515m;
        if (c0401In == null) {
            m6520o0();
        } else {
            c0401In.m9649j();
        }
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_rf_import_file), R.string.pop_menu_rf_import_file);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_rf_import_url), R.string.pop_menu_rf_import_url);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_rf_import_shares), R.string.pop_menu_rf_import_shares);
        this.f4515m.mo7047F(this.browserActivity.getBrowserFrameLayout().f4455v, this.browserActivity.getBrowserFrameLayout().f4456w, 51);
    }

    @Override
    public void mo6416Y() {
        C2179p3 c2179p3 = this.f4514l;
        if (c2179p3 != null && c2179p3.m9656x()) {
            this.f4514l.m9655v();
            return;
        }
        m6518m0();
        this.browserActivity.getBrowserFrameLayout().m6458g();
        AndroidSystemUtils.startTiming();
        this.f4514l.mo7047F(0, m6516k0(), 83);
        AndroidSystemUtils.logElapsedTime();
        ImageButton imageButton = (ImageButton) this.browserActivity.findViewById(R.id.menu_bottom_setting);
        if (imageButton != null) {
            imageButton.setOnClickListener(new ViewOnClickListenerC1527h());
        }
        ImageButton imageButton2 = (ImageButton) this.browserActivity.findViewById(R.id.menu_bottom_close_menu);
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new ViewOnClickListenerC1528i());
        }
        ImageButton imageButton3 = (ImageButton) this.browserActivity.findViewById(R.id.menu_bottom_exit);
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(new ViewOnClickListenerC1529j());
        }
    }

    @Override
    public void mo6417Z() {
        mo6428g0();
        if (this.f4516n.m9656x()) {
            this.f4516n.m9655v();
            return;
        }
        int height = this.browserActivity.findViewById(R.id.bottom_content).getHeight();
        ThemeManager.getInstance().m9500u().setLayoutView(this.f4516n.m9654t());
        this.f4516n.mo7047F(0, height, 83);
    }

    @Override
    public void mo6418a0(int i) {
        m6520o0();
        Iterator it = MenuConfigManager.getInstance().getMenuList("tool_menu").iterator();
        while (it.hasNext()) {
            MenuConfigManager.MenuItem menuItemVar = (MenuConfigManager.MenuItem) it.next();
            if (menuItemVar.active) {
                InterfaceC0529Ld interfaceC0529LdM9646f = this.f4515m.m9646f(menuItemVar.title, menuItemVar.icon, menuItemVar.titleResId, menuItemVar.order);
                if (menuItemVar.titleResId == R.string.pop_menu_add_bookmark) {
                    m6523s0(interfaceC0529LdM9646f);
                }
            }
        }
        JSManager.getInstance().m8538j0(this.f4515m, "ep.menu.tool");
        int dimension = (int) this.browserActivity.getResources().getDimension(R.dimen.pop_menu_left_margin);
        int dimension2 = (int) this.browserActivity.getResources().getDimension(R.dimen.pop_menu_top_margin);
        int width = (m6440z().getWindow().getDecorView().getWidth() - ((int) this.browserActivity.getResources().getDimension(R.dimen.ctx_menu_width))) - dimension;
        if (Build.VERSION.SDK_INT >= 35) {
            dimension2 += PhoneUtils.getInstance().getStatusBarHeight();
        }
        this.f4515m.mo7047F(width, dimension2, (i == 1 ? 80 : 48) | 3);
    }

    @Override
    public void mo6420b0(String str, String str2, String str3, String str4) {
        C0401In c0401In;
        BrowserActivity browserActivity;
        int i;
        C0401In c0401In2 = this.f4515m;
        if (c0401In2 == null) {
            m6520o0();
        } else {
            c0401In2.m9649j();
        }
        this.f4515m.m9640C("url", str);
        this.f4515m.m9640C("id", str2);
        this.f4515m.m9640C("origin_host", str3);
        this.f4515m.m9640C("source", "resource");
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_copy_url), R.string.pop_menu_copy_url);
        if (str4.equals("media")) {
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_download), R.string.pop_menu_download);
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_play), R.string.pop_menu_play);
        }
        if (ContentDataManager.getInstance().m6628m0(str3, str, 0) || ContentDataManager.getInstance().m6628m0(str3, str, 1) || ContentDataManager.getInstance().m6628m0(str3, str, 2)) {
            c0401In = this.f4515m;
            browserActivity = this.browserActivity;
            i = R.string.pop_menu_allow_res_url;
        } else {
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_block_res_url), R.string.pop_menu_block_res_url);
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_block_res_host), R.string.pop_menu_block_res_host);
            c0401In = this.f4515m;
            browserActivity = this.browserActivity;
            i = R.string.pop_menu_block_res_host_global;
        }
        c0401In.m9644d(browserActivity.getString(i), i);
        this.f4515m.mo7047F(this.browserActivity.getBrowserFrameLayout().f4455v, this.browserActivity.getBrowserFrameLayout().f4456w, 51);
    }

    @Override
    public void mo2860c(String str) {
        if (this.browserActivity.getTabManager().getActiveTab().getTabId().equals(str)) {
            return;
        }
        this.browserActivity.getTabManager().m9300X(str);
        this.f4378b.setVisibility(View.INVISIBLE);
        C1039Wi.m4517p().m4519k();
    }

    @Override
    public void mo6421c0(String str) {
        C0401In c0401In;
        BrowserActivity browserActivity;
        int i;
        C0401In c0401In2 = this.f4515m;
        if (c0401In2 == null) {
            m6520o0();
        } else {
            c0401In2.m9649j();
        }
        if (str.startsWith("abp:subscribe")) {
            str = str.replace("&title", "&amp;title");
        }
        this.f4515m.m9640C("rule_source", str);
        ContentDataManager.Rule ruleVarM6614F0 = ContentDataManager.getInstance().m6614f0(str);
        if (ruleVarM6614F0 == null) {
            return;
        }
        if (ruleVarM6614F0.active) {
            c0401In = this.f4515m;
            browserActivity = this.browserActivity;
            i = R.string.pop_menu_rf_off;
        } else {
            c0401In = this.f4515m;
            browserActivity = this.browserActivity;
            i = R.string.pop_menu_rf_on;
        }
        c0401In.m9644d(browserActivity.getString(i), i);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_rf_delete), R.string.pop_menu_rf_delete);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_rf_reload), R.string.pop_menu_rf_reload);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_rf_view), R.string.pop_menu_rf_view);
        if (ruleVarM6614F0.sourceUrl != null && str.startsWith("http")) {
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_rf_share_source), R.string.pop_menu_rf_share_source);
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_rf_update), R.string.pop_menu_rf_update);
        }
        this.f4515m.mo7047F(this.browserActivity.getBrowserFrameLayout().f4455v, this.browserActivity.getBrowserFrameLayout().f4456w, 51);
    }

    @Override
    public void mo6423d0(String str) {
        C0401In c0401In;
        BrowserActivity browserActivity;
        int i;
        C0401In c0401In2 = this.f4515m;
        if (c0401In2 == null) {
            m6520o0();
        } else {
            c0401In2.m9649j();
        }
        this.f4515m.m9640C("script_id", str);
        if (JSManager.getInstance().m8504M0(str) == 1) {
            c0401In = this.f4515m;
            browserActivity = this.browserActivity;
            i = R.string.pop_menu_script_off;
        } else {
            c0401In = this.f4515m;
            browserActivity = this.browserActivity;
            i = R.string.pop_menu_script_on;
        }
        c0401In.m9644d(browserActivity.getString(i), i);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_script_edit), R.string.pop_menu_script_edit);
        this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_script_del), R.string.pop_menu_script_del);
        if (JSManager.getInstance().m8504M0(str) == 1) {
            if (!C2439uo.getInstance().m10206D()) {
                PhoneUtils.getInstance().isInChina();
            }
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_script_share_to_friend), R.string.pop_menu_script_share_to_friend);
        }
        String strM8521Z = JSManager.getInstance().getUserScriptSource(str);
        this.f4515m.m9640C("script_source_url", strM8521Z);
        if (!TextUtils.isEmpty(strM8521Z) && strM8521Z.startsWith("http")) {
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_script_review), R.string.pop_menu_script_review);
            this.f4515m.m9644d(this.browserActivity.getString(R.string.pop_menu_script_update), R.string.pop_menu_script_update);
        }
        this.f4515m.mo7047F(this.browserActivity.getBrowserFrameLayout().f4455v, this.browserActivity.getBrowserFrameLayout().f4456w, 51);
    }

    @Override
    public void mo6448f(InterfaceC1300b3 interfaceC1300b3, Bitmap bitmap, boolean z) throws Resources.NotFoundException {
        ViewOnClickListenerC0309Gn viewOnClickListenerC0309Gn;
        if (bitmap == null || bitmap.getHeight() <= 0) {
            return;
        }
        Drawable bitmapDrawable = new BitmapDrawable(this.browserActivity.getResources(), bitmap);
        String strMo1573b = interfaceC1300b3.getUrlFromTitle();
        if (strMo1573b != null && (strMo1573b.indexOf("m.so.com") >= 0 || strMo1573b.indexOf("sogou.com") >= 0 || strMo1573b.indexOf("search.yahoo.com") >= 0 || strMo1573b.indexOf("m.sm.cn") >= 0 || strMo1573b.indexOf("so.toutiao.com") >= 0 || strMo1573b.indexOf("skyjem.com") >= 0)) {
            bitmapDrawable = this.browserActivity.getResources().getDrawable(R.drawable.ic_search);
        }
        interfaceC1300b3.mo5632y(bitmapDrawable);
        if (z || SharedPreferencesHelper.getInstance().enterPrivateMode || interfaceC1300b3.mo5626h() == 8) {
            if (!z) {
                viewOnClickListenerC0309Gn = this.f4381e;
                bitmapDrawable = interfaceC1300b3.mo5621A(0);
            }
            this.browserActivity.getHandler().postDelayed(new RunnableC1526g(interfaceC1300b3, bitmap), 200L);
        }
        viewOnClickListenerC0309Gn = this.f4381e;
        viewOnClickListenerC0309Gn.m1438u(bitmapDrawable);
        this.browserActivity.getHandler().postDelayed(new RunnableC1526g(interfaceC1300b3, bitmap), 200L);
    }

    @Override
    public void mo6428g0() {
        Drawable drawableM9503x;
        String strMo1574c;
        Drawable drawable;
        String string;
        this.f4516n.m9649j();
        int iM9280D = this.browserActivity.getTabManager().getTabCount();
        ((IndicatorImageButton) this.browserActivity.findViewById(R.id.toolbar_btn_muti_window)).setIndicatorText(iM9280D + "");
        int iM9278B = this.browserActivity.getTabManager().getActiveIndex();
        ArrayList arrayListM9286J = this.browserActivity.getTabManager().getTabList();
        int i = 0;
        while (i < arrayListM9286J.size()) {
            ContentViewManager.Tab tabVar = (ContentViewManager.Tab) arrayListM9286J.get(i);
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) tabVar.m9333l();
            boolean z = i == iM9278B;
            if (interfaceC1300b3 == null && tabVar.m9344w()) {
                drawableM9503x = ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_default, 1);
                string = tabVar.m9337p();
                if (TextUtils.isEmpty(string)) {
                }
                drawable = drawableM9503x;
                strMo1574c = string;
                this.f4516n.m7048J(drawable, strMo1574c, tabVar.getTabId(), z, tabVar.m9345x());
                i++;
            } else if (interfaceC1300b3 != null) {
                Drawable drawableMo5621A = interfaceC1300b3.mo5621A(1);
                if (drawableMo5621A == null) {
                    drawableMo5621A = ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_default, 1);
                }
                strMo1574c = interfaceC1300b3.mo1574c();
                drawable = drawableMo5621A;
                this.f4516n.m7048J(drawable, strMo1574c, tabVar.getTabId(), z, tabVar.m9345x());
                i++;
            } else {
                drawableM9503x = ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_default, 1);
            }
            string = this.browserActivity.getString(R.string.des_btn_new_tab);
            drawable = drawableM9503x;
            strMo1574c = string;
            this.f4516n.m7048J(drawable, strMo1574c, tabVar.getTabId(), z, tabVar.m9345x());
            i++;
        }
        this.f4516n.m7055Q();
    }

    @Override
    public void mo6430h0() {
    }

    @Override
    public void mo2861i() {
        m6436u();
    }

    public final void m6514i0() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (interfaceC1300b3 != null) {
            String strMo1574c = interfaceC1300b3.mo1574c();
            String strMo1573b = interfaceC1300b3.getUrlFromTitle();
            if (strMo1573b.indexOf("baidu.com") > 0) {
                strMo1573b.indexOf("from=");
            }
            new ViewOnClickListenerC2063mh(this.browserActivity).m8586n(strMo1574c, strMo1573b);
        }
    }

    @Override
    public void mo2862j() {
        m6434s();
    }

    public final int m6515j0() {
        int i;
        View viewFindViewById;
        C1045Wo c1045WoM2080i;
        float f;
        float f2;
        if (Build.VERSION.SDK_INT < 35 || this.browserActivity.getApplication().getApplicationInfo().targetSdkVersion < 35 || (viewFindViewById = this.browserActivity.findViewById(android.R.id.content)) == null || (c1045WoM2080i = AbstractC0448Jo.m2080i(viewFindViewById)) == null) {
            i = 0;
        } else {
            int iMax = Math.max(c1045WoM2080i.m4549f(C1045Wo.m.m4601e()).f7068d, Math.max(c1045WoM2080i.m4549f(C1045Wo.m.m4604h()).f7068d, c1045WoM2080i.m4549f(C1045Wo.m.m4597a()).f7068d));
            if (AndroidSystemUtils.m8674H(c1045WoM2080i, this.browserActivity)) {
                f = iMax;
                f2 = 0.8f;
            } else {
                f = iMax;
                f2 = 1.0f;
            }
            i = (int) (f * f2);
        }
        return i == 0 ? PhoneUtils.getInstance().getNavigationBarHeight() : i;
    }

    public final int m6516k0() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 35 && this.browserActivity.getApplication().getApplicationInfo().targetSdkVersion >= 35 && !SharedPreferencesHelper.getInstance().browserFullscreenMode) {
            return m6515j0();
        }
        if (i >= 35) {
            return PhoneUtils.getInstance().getNavigationBarHeight();
        }
        return 0;
    }

    @Override
    public void mo6449l(InterfaceC1300b3 interfaceC1300b3, String str, boolean z) {
        ViewOnClickListenerC0309Gn viewOnClickListenerC0309GnM6394C;
        BrowserActivity browserActivity;
        int i;
        if (z) {
            String strMo1573b = interfaceC1300b3.getUrlFromTitle();
            if (strMo1573b.equals("x:home")) {
                browserActivity = this.browserActivity;
                i = R.string.home_controller_title;
            } else if (strMo1573b.equals("x:history")) {
                browserActivity = this.browserActivity;
                i = R.string.web_str_title_history;
            } else if (strMo1573b.startsWith("x:bm")) {
                browserActivity = this.browserActivity;
                i = R.string.web_str_title_bookmark;
            } else {
                if (!strMo1573b.startsWith("x:settings")) {
                    if (strMo1573b.indexOf("skyjem.com") > 0) {
                        viewOnClickListenerC0309GnM6394C = m6394C();
                        str = "Quick search power by Google";
                    } else {
                        viewOnClickListenerC0309GnM6394C = m6394C();
                    }
                    viewOnClickListenerC0309GnM6394C.m1439v(str);
                    return;
                }
                browserActivity = this.browserActivity;
                i = R.string.web_str_title_setting;
            }
            m6394C().m1439v(browserActivity.getString(i));
        }
    }

    public final void m6517l0(String str, String str2) throws URISyntaxException {
        if (str.indexOf("xbext.com") >= 0) {
            str = ApiEndpointsManager.getInstance().getShareScriptsEndpoint() + "&filter=forward&resource_id=" + str2;
        } else if (str.indexOf("greasyfork.org") >= 0) {
            str = m6513r0(str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.browserActivity.openUrl(str, true, 0);
    }

    @Override
    public void mo2863m(String str) {
        mo6438x(str);
    }

    public final void m6518m0() {
        InterfaceC0529Ld interfaceC0529LdM9646f;
        boolean z;
        C2179p3 c2179p3 = new C2179p3((FrameLayout) this.browserActivity.findViewById(R.id.main_root), this, -1, -2);
        this.f4514l = c2179p3;
        View viewFindViewById = c2179p3.m9654t().findViewById(R.id.user_center);
        if (viewFindViewById != null) {
            if (C2439uo.getInstance().m10206D()) {
                ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.avatar);
                Drawable drawableM10236w = C2439uo.getInstance().m10236w();
                if (drawableM10236w != null) {
                    imageView.setImageDrawable(drawableM10236w);
                }
            }
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC1525f());
        }
        Iterator it = MenuConfigManager.getInstance().getMenuList("main_menu").iterator();
        while (it.hasNext()) {
            MenuConfigManager.MenuItem menuItemVar = (MenuConfigManager.MenuItem) it.next();
            if (menuItemVar.active) {
                int i = menuItemVar.titleResId;
                if (i == R.string.menu_night_mode) {
                    interfaceC0529LdM9646f = this.f4514l.m9646f(menuItemVar.title, menuItemVar.icon, i, menuItemVar.order);
                    z = SharedPreferencesHelper.getInstance().enterNightMode;
                } else if (i == R.string.menu_no_pic) {
                    m6524t0(this.f4514l.m9646f(menuItemVar.title, menuItemVar.icon, i, menuItemVar.order));
                } else if (i == R.string.menu_new_bookmark) {
                    m6523s0(this.f4514l.m9646f(menuItemVar.title, menuItemVar.icon, i, menuItemVar.order));
                } else if (i == R.string.menu_pc_mode) {
                    interfaceC0529LdM9646f = this.f4514l.m9646f(menuItemVar.title, menuItemVar.icon, i, menuItemVar.order);
                    z = SharedPreferencesHelper.getInstance().enterDesktopMode;
                } else {
                    if (i == R.string.menu_ad_block) {
                        String string = menuItemVar.title;
                        if (SharedPreferencesHelper.getInstance().enableSmartADB) {
                            string = this.browserActivity.getString(R.string.menu_strong_ad_block);
                        }
                        InterfaceC0529Ld interfaceC0529LdM9646f2 = this.f4514l.m9646f(string, menuItemVar.icon, menuItemVar.titleResId, menuItemVar.order);
                        interfaceC0529LdM9646f2.mo2670i(SharedPreferencesHelper.getInstance().activeAdBlock);
                        interfaceC0529LdM9646f2.mo2671j(true);
                    } else if (i == R.string.menu_full_screen) {
                        this.f4514l.m9646f(menuItemVar.title, menuItemVar.icon, menuItemVar.titleResId, menuItemVar.order).mo2670i((SharedPreferencesHelper.getInstance().getDefaultLayoutType() & 8192) == 8192);
                    } else if (i == R.string.menu_tampermonkey) {
                        interfaceC0529LdM9646f = this.f4514l.m9646f(menuItemVar.title, menuItemVar.icon, i, menuItemVar.order);
                        z = SharedPreferencesHelper.getInstance().enableTampermonkey;
                    } else if (i == R.string.menu_private_mode) {
                        interfaceC0529LdM9646f = this.f4514l.m9646f(menuItemVar.title, menuItemVar.icon, i, menuItemVar.order);
                        z = SharedPreferencesHelper.getInstance().enterPrivateMode;
                    } else if (i == R.string.web_str_setting_disable_js) {
                        interfaceC0529LdM9646f = this.f4514l.m9646f(menuItemVar.title, menuItemVar.icon, i, menuItemVar.order);
                        z = SharedPreferencesHelper.getInstance().disableJavascript;
                    } else {
                        this.f4514l.m9646f(menuItemVar.title, menuItemVar.icon, i, menuItemVar.order);
                    }
                }
                interfaceC0529LdM9646f.mo2670i(z);
            }
        }
        JSManager.getInstance().m8538j0(this.f4514l, "ep.menu.main");
    }

    public final void m6519n0() {
        this.f4516n = new TabWindowManager(browserActivity.findViewById(R.id.main_root), this);
    }

    @Override
    public void mo2864o() throws URISyntaxException {
        this.browserActivity.openUrl(SharedPreferencesHelper.getInstance().m6857H(), true, 8);
        this.browserActivity.getHandler().postDelayed(new RunnableC1524e(), 500L);
    }

    public final void m6520o0() {
        this.f4515m = new C0401In((FrameLayout) this.browserActivity.findViewById(R.id.main_root), this, (int) this.browserActivity.getResources().getDimension(R.dimen.ctx_menu_width), -2);
    }

    public final void m6521p0() {
        ThemeManager.getInstance().m9475C(new C0669Of(this.browserActivity));
        ThemeManager.getInstance().m9475C(new C1625d7(this.browserActivity));
        String strM6871P = SharedPreferencesHelper.getInstance().getString("browser_theme", ThemeManager.getInstance().m9502w());
        int i = this.browserActivity.getResources().getConfiguration().uiMode & 48;
        if (SharedPreferencesHelper.getInstance().f4915l0 < 0) {
            SharedPreferencesHelper.getInstance().f4915l0 = i;
        }
        if ((!SharedPreferencesHelper.getInstance().followSystemDarkMode || i != 32) && !SharedPreferencesHelper.getInstance().enterNightMode) {
            ThemeManager.getInstance().m9481b(this.browserActivity, strM6871P);
            SharedPreferencesHelper.getInstance().enterNightMode = false;
        } else {
            SharedPreferencesHelper.getInstance().enterNightMode = true;
            ThemeManager.getInstance().m9481b(this.browserActivity, "dark");
            this.browserActivity.applyDarkMode();
        }
    }

    public final void m6522q0() throws URISyntaxException {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("default_downloader", "com.x.browser.downloader");
        if (strM6871P.equals("com.x.browser.downloader")) {
            this.browserActivity.openUrl("x:dl");
        } else if (!strM6871P.equals("com.android.providers.downloads")) {
            C2406u0.getInstance().m9894m(strM6871P);
        } else {
            this.browserActivity.startActivity(new Intent("android.intent.action.VIEW_DOWNLOADS"));
        }
    }

    public final void m6523s0(InterfaceC0529Ld interfaceC0529Ld) {
        if (this.browserActivity.m6358t1(this.browserActivity.m6234M0())) {
            interfaceC0529Ld.mo2670i(true);
            interfaceC0529Ld.mo2673l(this.browserActivity.getString(R.string.menu_bookmarked));
        }
    }

    public final void m6524t0(InterfaceC0529Ld interfaceC0529Ld) {
        boolean z = true;
        interfaceC0529Ld.mo2671j(true);
        int iM6869O = SharedPreferencesHelper.getInstance().getInt("save_traffic_strategy", 0);
        String string = this.browserActivity.getString(R.string.menu_no_pic);
        if (iM6869O != 0) {
            if (iM6869O == 1) {
                interfaceC0529Ld.mo2673l(string);
            } else if (iM6869O == 2) {
                interfaceC0529Ld.mo2673l(this.browserActivity.getString(R.string.menu_smart_no_pic));
            }
            interfaceC0529Ld.mo2670i(z);
        }
        interfaceC0529Ld.mo2673l(string);
        z = false;
        interfaceC0529Ld.mo2670i(z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:247:0x08cb  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo1615w(p000.InterfaceC0529Ld r24, ContextMenu.ContextMenuInfo r25) throws JSONException, IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, URISyntaxException, SecurityException, SQLException, IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 2782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.PhoneBrowserActivtyDelegate.mo1615w(Ld, android.view.ContextMenu$ContextMenuInfo):void");
    }

    @Override
    public void mo6438x(String str) {
        try {
            this.f4516n.m7054P(this.browserActivity.getTabManager().getActiveTab().getTabId());
            this.f4516n.m7050L(str);
            this.browserActivity.getTabManager().removeTab(str);
            if (this.browserActivity.getTabManager().getTabCount() == 0) {
                this.f4516n.m9655v();
                this.browserActivity.m6307d2(SharedPreferencesHelper.getInstance().m6857H());
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.browserActivity.m6233M();
            this.browserActivity.m6324h3();
            throw th;
        }
        this.browserActivity.m6233M();
        this.browserActivity.m6324h3();
    }

    @Override
    public boolean mo6439y(String str) throws URISyntaxException {
        if (this.browserActivity.m6230L0() != 0 && this.browserActivity.m6230L0() != 512 && this.browserActivity.m6230L0() != 32) {
            return false;
        }
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (str.equals("go_to_top")) {
            if (interfaceC1300b3 != null && (interfaceC1300b3 instanceof WebViewBrowserController)) {
                ((WebViewBrowserController) interfaceC1300b3).m6770F0().pageUp(true);
                return true;
            }
        } else if (str.equals("go_to_bottom")) {
            if (interfaceC1300b3 != null && (interfaceC1300b3 instanceof WebViewBrowserController)) {
                ((WebViewBrowserController) interfaceC1300b3).m6770F0().pageDown(true);
                return true;
            }
        } else {
            if (str.equals("refresh")) {
                interfaceC1300b3.mo5625f();
                return true;
            }
            if (str.equals("search")) {
                this.browserActivity.m6360u();
                return true;
            }
            if (str.equals("go_to_home")) {
                m6395D();
                return true;
            }
            if (str.equals("new_tab")) {
                mo2862j();
                return true;
            }
            if (str.equals("remove_tabs")) {
                m6436u();
                return true;
            }
            if (str.equals("close_tab")) {
                this.browserActivity.getActivityDelegate().mo6431k();
                return true;
            }
            if (str.equals("revert_tab")) {
                this.browserActivity.m6375x2();
                return true;
            }
            if (str.equals("next_tab")) {
                this.browserActivity.getTabManager().m9290N();
                return true;
            }
            if (str.equals("previous_tab")) {
                this.browserActivity.getTabManager().m9291O();
                return true;
            }
            if (str.equals("add_to_bm")) {
                m6514i0();
            } else {
                if (str.equals("copy_url")) {
                    AndroidSystemUtils.m8701i(this.browserActivity, interfaceC1300b3.getUrlFromTitle());
                    Toast.makeText(this.browserActivity, R.string.toast_copy_to_clip_board, Toast.LENGTH_SHORT).show();
                    return true;
                }
                if (str.equals("open_toolbox")) {
                    this.browserActivity.m6234M0();
                    this.browserActivity.getHandler().postDelayed(new RunnableC1531l(), 100L);
                } else {
                    if (str.equals("toggle_fullscreen")) {
                        this.browserActivity.m6288Z2();
                        return true;
                    }
                    if (str.equals("open_bookmark")) {
                        this.browserActivity.m6271V1();
                        return true;
                    }
                    if (str.equals("open_history")) {
                        this.browserActivity.openUrl("x:history");
                        return true;
                    }
                    if (str.equals("switch_search_engine")) {
                        new DialogInterfaceOnDismissListenerC0189E4(this.browserActivity).show();
                        return true;
                    }
                    if (str.equals("open_site_config")) {
                        this.browserActivity.openSiteFromCurrentTab();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void mo6447a(InterfaceC1300b3 interfaceC1300b3, int i, String str, String str2) {
    }
}
