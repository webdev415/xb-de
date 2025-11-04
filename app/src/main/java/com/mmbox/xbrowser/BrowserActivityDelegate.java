package com.mmbox.xbrowser;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.mmbox.widget.messagebox.MessageBoxManager;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.xbrowser.play.R;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import p000.NetworkUtils;
import p000.FileUtils;
import p000.AndroidSystemUtils;
import p000.ConfirmDialog;
import p000.DownloadConfirmDialog;
import p000.C0219Ep;
import p000.ResourceCacheManager;
import p000.SyncManager;
import p000.PhoneUtils;
import p000.JSManager;
import p000.C2406u0;
import p000.InterfaceC0345Hd;
import p000.InterfaceC1300b3;
import p000.ViewOnClickListenerC0309Gn;
import p000.ViewOnFocusChangeListenerC0985Va;

public abstract class BrowserActivityDelegate implements BrowserControllerListener {

    public static String f4376j = "";

    public BrowserActivity browserActivity;

    public boolean f4379c;

    public ProgressBar f4378b = null;

    public boolean f4380d = false;

    public ViewOnClickListenerC0309Gn f4381e = null;

    public ViewOnFocusChangeListenerC0985Va f4382f = null;

    public String f4383g = null;

    public String f4384h = null;

    public String f4385i = null;

    public class DialogC1486a extends DownloadConfirmDialog {

        public final String f4386n;

        public final String f4387o;

        public final String f4388p;

        public final String f4389q;

        public final long f4390r;

        public final String f4391s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DialogC1486a(BrowserActivity browserActivity, String str, String str2, String str3, String str4, long j, String str5) {
            super(browserActivity);
            this.f4386n = str;
            this.f4387o = str2;
            this.f4388p = str3;
            this.f4389q = str4;
            this.f4390r = j;
            this.f4391s = str5;
        }

        @Override
        public void mo6441e() {
        }

        @Override
        public void mo6442f() {
            ((ClipboardManager) browserActivity.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("download_link", this.f4387o));
            Toast.makeText(browserActivity, R.string.toast_copy_link_to_clipboard, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void mo6443g() {
            String string = ((EditText) findViewById(R.id.file_name)).getText().toString();
            String strM457l = NetworkUtils.getMimeType(string);
            if (TextUtils.isEmpty(strM457l) || strM457l.equals("application/octet-stream")) {
                strM457l = this.f4386n;
            }
            m6399H(this.f4387o, this.f4388p, this.f4389q, string, strM457l, this.f4390r);
        }

        @Override
        public void mo6444h() {
            AndroidSystemUtils.share(browserActivity, this.f4391s, this.f4387o, null, null, null);
        }
    }

    public class C1487b implements BrowserDownloadManager.j {

        public final String f4393a;

        public final boolean f4394b;

        public final String f4395c;

        public class a implements Runnable {

            public final String f4397l;

            public final String f4398m;

            public final String f4399n;

            public final long f4400o;

            public class DialogC2707a extends DownloadConfirmDialog {
                public DialogC2707a(BrowserActivity browserActivity) {
                    super(browserActivity);
                }

                @Override
                public void mo6441e() {
                }

                @Override
                public void mo6442f() {
                    ((ClipboardManager) browserActivity.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("download_link", a.this.f4397l));
                    Toast.makeText(browserActivity, R.string.toast_copy_link_to_clipboard, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void mo6443g() {
                    String string = ((EditText) findViewById(R.id.file_name)).getText().toString();
                    a aVar = a.this;
                    C1487b c1487b = C1487b.this;
                    m6400I(aVar.f4397l, null, null, string, aVar.f4399n, aVar.f4400o, c1487b.f4395c);
                }

                @Override
                public void mo6444h() {
                    AndroidSystemUtils.share(browserActivity, f4393a, f4397l, null, null, null);
                }
            }

            public a(String str, String str2, String str3, long j) {
                this.f4397l = str;
                this.f4398m = str2;
                this.f4399n = str3;
                this.f4400o = j;
            }

            @Override
            public void run() {
                BrowserActivity browserActivity;
                int i;
                String strM6871P = SharedPreferencesHelper.getInstance().getString("bind_default_downloader", "");
                if (!TextUtils.isEmpty((strM6871P.equals("com.x.browser.downloader") || strM6871P.equals("com.android.providers.downloads") || C2406u0.getInstance().m9893l(strM6871P)) ? strM6871P : "")) {
                    m6399H(this.f4397l, null, null, this.f4398m, this.f4399n, this.f4400o);
                    return;
                }
                C1487b c1487b = C1487b.this;
                if (!c1487b.f4394b) {
                    m6400I(this.f4397l, null, null, this.f4398m, this.f4399n, this.f4400o, c1487b.f4395c);
                    return;
                }
                DialogC2707a dialogC2707a = new DialogC2707a(BrowserActivityDelegate.this.browserActivity);
                String string = BrowserActivityDelegate.this.browserActivity.getString(R.string.dlg_download_title);
                if (AndroidSystemUtils.isWifiConnected(BrowserActivityDelegate.this.browserActivity)) {
                    browserActivity = BrowserActivityDelegate.this.browserActivity;
                    i = R.string.dlg_download_text;
                } else {
                    browserActivity = BrowserActivityDelegate.this.browserActivity;
                    i = R.string.dlg_download_text_no_wifi;
                }
                dialogC2707a.m7812i(string, browserActivity.getString(i), this.f4398m, AndroidSystemUtils.formatFileSize(this.f4400o));
            }
        }

        public C1487b(String str, boolean z, String str2) {
            this.f4393a = str;
            this.f4394b = z;
            this.f4395c = str2;
        }

        @Override
        public void mo6445a(String str) {
        }

        @Override
        public void mo6446b(String str, String str2, String str3, long j) {
            if (!TextUtils.isEmpty(this.f4393a)) {
                str3 = "filename=\"" + this.f4393a + "\"";
            }
            browserActivity.runOnUiThread(new a(str, NetworkUtils.generateFileName(str, str3, str2), str2, j));
        }
    }

    public class DialogC1488c extends DownloadConfirmDialog {

        public final String f4403n;

        public final String f4404o;

        public final String f4405p;

        public final String f4406q;

        public final String f4407r;

        public final String f4408s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DialogC1488c(BrowserActivity browserActivity, boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
            super(browserActivity, z);
            this.f4403n = str;
            this.f4404o = str2;
            this.f4405p = str3;
            this.f4406q = str4;
            this.f4407r = str5;
            this.f4408s = str6;
        }

        @Override
        public void mo6441e() {
        }

        @Override
        public void mo6442f() {
            ((ClipboardManager) browserActivity.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("download_link", this.f4407r));
            Toast.makeText(browserActivity, R.string.toast_copy_link_to_clipboard, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void mo6443g() throws IOException {
            String string = ((EditText) findViewById(R.id.file_name)).getText().toString();
            String strM457l = NetworkUtils.getMimeType(string);
            if (TextUtils.isEmpty(strM457l) || strM457l.equals("application/octet-stream")) {
                strM457l = this.f4403n;
            }
            String str = this.f4404o + "/" + string;
            if (this.f4405p.equals("base64")) {
                FileUtils.writeBytesToFile(Base64.decode(this.f4406q, 0), this.f4404o + "/" + string);
            } else {
                FileUtils.writeBytesToFile(this.f4406q.getBytes(), this.f4404o + "/" + string);
            }
            BrowserDownloadManager.getInstance().m6689e(str, str, this.f4404o, strM457l);
            Toast.makeText(browserActivity, R.string.toast_download_stared, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void mo6444h() {
            AndroidSystemUtils.share(browserActivity, this.f4408s, this.f4407r, null, null, null);
        }
    }

    public class C1489d implements BrowserDownloadManager.j {

        public final String f4410a;

        public final String f4411b;

        public final String f4412c;

        public final String f4413d;

        public class a implements Runnable {

            public final String f4415l;

            public final String f4416m;

            public final long f4417n;

            public a(String str, String str2, long j) {
                this.f4415l = str;
                this.f4416m = str2;
                this.f4417n = j;
            }

            @Override
            public void run() {
                C1489d c1489d = C1489d.this;
                m6425e0(this.f4415l, c1489d.f4411b, c1489d.f4412c, this.f4416m, c1489d.f4413d, this.f4417n);
            }
        }

        public C1489d(String str, String str2, String str3, String str4) {
            this.f4410a = str;
            this.f4411b = str2;
            this.f4412c = str3;
            this.f4413d = str4;
        }

        @Override
        public void mo6445a(String str) {
        }

        @Override
        public void mo6446b(String str, String str2, String str3, long j) {
            if (str3 == null) {
                str3 = this.f4410a;
            }
            browserActivity.runOnUiThread(new a(str, NetworkUtils.generateFileName(str, str3, str2), j));
        }
    }

    public class RunnableC1490e implements Runnable {

        public final String f4419l;

        public final InterfaceC1300b3 f4420m;

        public RunnableC1490e(String str, InterfaceC1300b3 interfaceC1300b3) {
            this.f4419l = str;
            this.f4420m = interfaceC1300b3;
        }

        @Override
        public void run() {
            if (SiteSettingsManager.getInstance().m6946O(Uri.parse(this.f4419l).getHost())) {
                browserActivity.m6191B1(this.f4420m.mo1574c(), this.f4419l);
            }
        }
    }

    public class RunnableC1491f implements Runnable {
        public RunnableC1491f() {
        }

        @Override
        public void run() {
            int progress = f4378b.getProgress();
            if (f4378b.getVisibility() == 4) {
                f4378b.setVisibility(View.VISIBLE);
            }
            BrowserActivityDelegate browserActivityDelegate = BrowserActivityDelegate.this;
            if (!browserActivityDelegate.f4379c || progress >= 85) {
                return;
            }
            browserActivityDelegate.f4378b.setProgress(progress + 15);
            browserActivity.getHandler().postDelayed(this, 20L);
        }
    }

    public class C1492g implements MessageBoxBase.MessageBoxListener {

        public final String f4423a;

        public C1492g(String str) {
            this.f4423a = str;
        }

        @Override
        public void onShown() throws URISyntaxException {
            browserActivity.m6190B0(this.f4423a);
        }

        @Override
        public void onDismissed() {
        }

        @Override
        public void onDismiss() {
        }
    }

    public class RunnableC1493h implements Runnable {
        public RunnableC1493h() {
        }

        @Override
        public void run() {
            browserActivity.m6324h3();
        }
    }

    public class RunnableC1494i implements Runnable {
        public RunnableC1494i() {
        }

        @Override
        public void run() throws URISyntaxException {
            if (browserActivity == null) {
                return;
            }
            boolean zIsDestroyed = browserActivity.isDestroyed();
            if (browserActivity.isFinishing() || zIsDestroyed) {
                return;
            }
            if (browserActivity.getTabManager().getTabCount() == 0) {
                browserActivity.m6307d2(SharedPreferencesHelper.getInstance().m6857H());
            }
            mo6428g0();
        }
    }

    public class DialogC1495j extends ConfirmDialog {
        public DialogC1495j(Context context) {
            super(context);
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onOK() {
            CheckBox checkBox = (CheckBox) findViewById(R.id.another_condition);
            if (checkBox != null && checkBox.isChecked()) {
                SharedPreferencesHelper.getInstance().putBoolean("confirm-when-close-tabs", false);
            }
            m6437v();
        }
    }

    public class RunnableC1496k implements Runnable {
        public RunnableC1496k() {
        }

        @Override
        public void run() {
            Toast.makeText(browserActivity, R.string.toast_download_stared, Toast.LENGTH_SHORT).show();
        }
    }

    public class RunnableC1497l implements Runnable {
        public RunnableC1497l() {
        }

        @Override
        public void run() {
            Toast.makeText(browserActivity, "Not invalid url", Toast.LENGTH_SHORT).show();
        }
    }

    public BrowserActivityDelegate(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
    }

    public AbstractScrollableListController mo6393A() {
        return null;
    }

    public ViewOnClickListenerC0309Gn m6394C() {
        return this.f4381e;
    }

    public void m6395D() {
        if (m6397F(this.browserActivity.m6234M0(), SharedPreferencesHelper.getInstance().m6857H())) {
            return;
        }
        int iM9280D = this.browserActivity.getTabManager().getTabCount();
        for (int i = 0; i < iM9280D; i++) {
            InterfaceC0345Hd interfaceC0345HdM9333l = this.browserActivity.getTabManager().getTab(i).m9333l();
            if (interfaceC0345HdM9333l != null && (interfaceC0345HdM9333l instanceof WebViewBrowserController) && m6397F(interfaceC0345HdM9333l.getUrlFromTitle(), SharedPreferencesHelper.getInstance().m6857H())) {
                this.browserActivity.getTabManager().m9298V(i);
                return;
            }
        }
        this.browserActivity.m6307d2(SharedPreferencesHelper.getInstance().m6857H());
    }

    public void m6396E() {
        this.f4382f.m4386b();
    }

    public final boolean m6397F(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(str, 2);
        return strM2046a != null && strM2046a.equals(str2);
    }

    public final boolean m6398G(String str) {
        if (!str.startsWith("http") || TextUtils.isEmpty(SharedPreferencesHelper.getInstance().googleEnhancedSearchUrl)) {
            return false;
        }
        return SharedPreferencesHelper.getInstance().googleEnhancedSearchUrl.indexOf(Uri.parse(str).getHost()) >= 0;
    }

    public void m6399H(String str, String str2, String str3, String str4, String str5, long j) {
        m6400I(str, str2, str3, str4, str5, j, "");
    }

    public void m6400I(String str, String str2, String str3, String str4, String str5, long j, String str6) {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("default_downloader", "com.x.browser.downloader");
        if (!strM6871P.equals("com.android.providers.downloads")) {
            if (strM6871P.equals("com.x.browser.downloader")) {
                BrowserDownloadManager.getInstance().m6685K(str, str2, str3, str4, str5, j, str6);
                return;
            } else {
                C2406u0.getInstance().m9884b(strM6871P, str, str3, str2, CookieManager.getInstance().getCookie(str));
                return;
            }
        }
        this.browserActivity.runOnUiThread(new RunnableC1496k());
        DownloadManager downloadManager = (DownloadManager) this.browserActivity.getSystemService("download");
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
        if (str2 != null) {
            request.addRequestHeader("Referer", str2);
            request.addRequestHeader("User-Agent", str3);
        }
        String cookie = CookieManager.getInstance().getCookie(str);
        if (cookie != null) {
            request.addRequestHeader("Cookie", cookie);
        }
        request.addRequestHeader("User-Agent", str3);
        if (str4 != null) {
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str4);
            request.setTitle(str4);
        }
        request.setNotificationVisibility(1);
        request.setVisibleInDownloadsUi(true);
        downloadManager.enqueue(request);
    }

    public abstract void mo6402K(Bundle bundle);

    public void m6403L(String str) {
        if (str.equals("file:///android_asset/start-page/index.html")) {
            this.f4381e.m1438u(this.browserActivity.getDrawable(R.drawable.ic_fav_default));
            return;
        }
        this.f4378b.setVisibility(View.VISIBLE);
        if (!str.startsWith(SharedPreferencesHelper.getInstance().m6857H())) {
            this.f4381e.m1429l(1);
            this.f4381e.m1439v(str);
        }
        if (m6398G(str)) {
            this.f4381e.m1439v("Google Enhanced Search");
        }
        m6426f0();
    }

    public void m6404M(String str) {
        this.f4378b.setVisibility(View.VISIBLE);
        this.f4381e.m1429l(1);
        m6426f0();
    }

    public void m6405N(String str, String str2, boolean z, String str3) {
        BrowserDownloadManager.getInstance().m6691g(str, null, new C1487b(str2, z, str3));
    }

    public void m6406O(int i) {
        this.browserActivity.setContentView(i);
        this.f4378b = (ProgressBar) this.browserActivity.findViewById(R.id.progress_bar);
    }

    public void mo6407P() {
    }

    public final void m6408Q(String str, String str2) throws Resources.NotFoundException {
        Log.i("app-callback", ">>>>> callback:" + str2);
        MessageBoxManager.getInstance().showToast(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getResources().getString(R.string.message_prepare_launch_app), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_allow), new C1492g(str2));
    }

    public void mo6409R(String str) {
    }

    public void mo6410S() {
    }

    public boolean mo6411T() {
        return false;
    }

    public void mo6412U(String str) {
    }

    public void mo6413V(String str) {
    }

    public void m6414W() {
        this.f4382f.m4387c();
    }

    public void mo6415X() {
    }

    public void mo6416Y() {
    }

    public void mo6417Z() {
    }

    public void mo6418a0(int i) {
    }

    @Override
    public void mo6419b(InterfaceC1300b3 interfaceC1300b3) {
        this.browserActivity.getTabManager().m9312u(interfaceC1300b3, true);
        SyncManager.getInstance().getResourceManager("syncable_user_tabs").incrementVersion();
        mo6428g0();
    }

    public void mo6420b0(String str, String str2, String str3, String str4) {
    }

    public void mo6421c0(String str) {
    }

    @Override
    public boolean mo6422d(InterfaceC1300b3 interfaceC1300b3, String str, boolean z, boolean z2) throws Resources.NotFoundException, URISyntaxException {
        BrowserActivity browserActivity;
        int iMo5626h;
        this.f4380d = false;
        if (str.indexOf("greasyfork.org") > 0 && str.endsWith(".js") && str.indexOf("http", 4) < 0) {
            JSManager.getInstance().m8565z0(str);
            return true;
        }
        if (str.startsWith("http") || str.startsWith("x:") || str.startsWith("file:///")) {
            if (interfaceC1300b3 instanceof WebViewBrowserController) {
                if (interfaceC1300b3.mo5626h() != 2 && (SharedPreferencesHelper.getInstance().supportSuperCache || SharedPreferencesHelper.getInstance().forceOpenInBackground || SharedPreferencesHelper.getInstance().forceOpenInNewTab)) {
                    WebView webViewM6770F0 = ((WebViewBrowserController) interfaceC1300b3).m6770F0();
                    if (webViewM6770F0 != null) {
                        if (interfaceC1300b3.mo5629o()) {
                            return false;
                        }
                        webViewM6770F0.getHitTestResult();
                        if (z) {
                            if (SharedPreferencesHelper.getInstance().forceOpenInBackground) {
                                BrowserActivity browserActivity2 = this.browserActivity;
                                browserActivity2.openUrl(str, false, browserActivity2.m6230L0());
                            } else if (!SharedPreferencesHelper.getInstance().forceOpenInNewTab) {
                                if (interfaceC1300b3.mo5626h() == 0) {
                                    browserActivity = this.browserActivity;
                                    iMo5626h = browserActivity.m6230L0();
                                } else {
                                    browserActivity = this.browserActivity;
                                    iMo5626h = interfaceC1300b3.mo5626h();
                                }
                                browserActivity.m6311e2(str, interfaceC1300b3, iMo5626h, true);
                            } else if (interfaceC1300b3.mo5626h() == 0) {
                                BrowserActivity browserActivity3 = this.browserActivity;
                                browserActivity3.openUrl(str, true, browserActivity3.m6230L0());
                            } else {
                                this.browserActivity.openUrl(str, true, interfaceC1300b3.mo5626h());
                            }
                            return true;
                        }
                    }
                }
                return false;
            }
        } else {
            if (!str.startsWith("local://")) {
                Log.i("third-app", "url: " + str);
                if (SharedPreferencesHelper.getInstance().enableCallApp) {
                    m6435t(str, z);
                }
                return true;
            }
            this.browserActivity.m6194C0(str);
        }
        return true;
    }

    public void mo6423d0(String str) {
    }

    @Override
    public void mo6424e(String str, String str2, String str3, String str4, String str5, long j) throws UnsupportedEncodingException {
        String str6;
        try {
            if (TextUtils.isEmpty(f4376j) || !TextUtils.isEmpty(str4)) {
                str6 = str4;
            } else {
                str6 = "filename=\"" + f4376j + "\"";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str.startsWith("data:")) {
            String[] strArrM447b = NetworkUtils.parseDataUri(str);
            String str7 = strArrM447b[0];
            String str8 = strArrM447b[1];
            String str9 = strArrM447b[2];
            String strM468w = NetworkUtils.generateFileName(str, str6, str7);
            new DialogC1488c(this.browserActivity, false, str7, PhoneUtils.getInstance().getDownloadsDirPath(), str8, str9, str, strM468w).m7812i(this.browserActivity.getString(R.string.dlg_download_title), this.browserActivity.getString(R.string.dlg_download_text), strM468w, AndroidSystemUtils.formatFileSize(j));
            return;
        }
        if (str.startsWith("blob:")) {
            this.browserActivity.updateTitle("_XJSAPI_.downloadBlobUrl('" + str + "', '" + str5 + "');");
            return;
        }
        if (TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5)) {
            String str10 = "filename=" + ((InterfaceC1300b3) this.browserActivity.getTabManager().m9316y()).mo1574c();
            Toast.makeText(this.browserActivity, R.string.toast_getting_download_info, Toast.LENGTH_SHORT).show();
            BrowserDownloadManager.getInstance().m6691g(str, str2, new C1489d(str10, str2, str3, str5));
        } else {
            String strDecode = URLDecoder.decode(str6, "utf-8");
            String strTrim = NetworkUtils.generateFileName(str, strDecode, str5).trim();
            String strM457l = !TextUtils.isEmpty(strDecode) ? NetworkUtils.getMimeType(strTrim) : str5;
            m6425e0(str, str2, str3, strTrim, TextUtils.isEmpty(strM457l) ? str5 : strM457l, j);
        }
        mo6432n(this.browserActivity.getBrowserController(), str);
    }

    public void m6425e0(String str, String str2, String str3, String str4, String str5, long j) {
        BrowserActivity browserActivity;
        int i;
        int i2;
        if (!str.startsWith("http")) {
            this.browserActivity.runOnUiThread(new RunnableC1497l());
            return;
        }
        String string = this.browserActivity.getString(R.string.dlg_download_title);
        if (SharedPreferencesHelper.getInstance().f4936w && (i2 = Build.VERSION.SDK_INT) < 29 && SharedPreferencesHelper.getInstance().f4936w && i2 < 29 && !BrowserActivity.getActivity().m6285Z("android.permission.WRITE_EXTERNAL_STORAGE")) {
            BrowserActivity.getActivity().m6290a0();
            return;
        }
        String strM6871P = SharedPreferencesHelper.getInstance().getString("bind_default_downloader", "");
        String strM6871P2 = SharedPreferencesHelper.getInstance().getString("default_downloader", "com.x.browser.downloader");
        String str6 = (strM6871P.equals("com.x.browser.downloader") || strM6871P.equals("com.android.providers.downloads") || C2406u0.getInstance().m9893l(strM6871P)) ? strM6871P : "";
        if (str.indexOf("open=true") > 0 || (!TextUtils.isEmpty(str6) && !strM6871P2.equals("com.x.browser.downloader"))) {
            m6399H(str, str2, str3, str4, str5, j);
            return;
        }
        DialogC1486a dialogC1486a = new DialogC1486a(this.browserActivity, str5, str, str2, str3, j, string);
        if (AndroidSystemUtils.isWifiConnected(this.browserActivity)) {
            browserActivity = this.browserActivity;
            i = R.string.dlg_download_text;
        } else {
            browserActivity = this.browserActivity;
            i = R.string.dlg_download_text_no_wifi;
        }
        dialogC1486a.m7812i(string, browserActivity.getString(i), str4, AndroidSystemUtils.formatFileSize(j));
    }

    public final void m6426f0() {
        this.f4379c = true;
        this.f4378b.setVisibility(View.VISIBLE);
        this.browserActivity.getHandler().postDelayed(new RunnableC1491f(), 10L);
    }

    @Override
    public void mo6427g(InterfaceC1300b3 interfaceC1300b3, int i, boolean z) {
        if (!this.f4380d) {
            if (z) {
                return;
            }
            if (i < 85) {
                m6426f0();
            } else {
                this.f4379c = false;
                if (i > this.f4378b.getProgress()) {
                    this.f4378b.setProgress(i);
                }
            }
            if ((this.f4378b.getProgress() != 100 || !this.f4380d) && i != 100) {
                return;
            }
        }
        this.f4378b.setVisibility(View.INVISIBLE);
    }

    public abstract void mo6428g0();

    @Override
    public void mo6429h(InterfaceC1300b3 interfaceC1300b3, String str, Bitmap bitmap) {
        this.f4380d = false;
        if (interfaceC1300b3.mo5624a() && !str.equals("file:///android_asset/start-page/index.html")) {
            this.f4378b.setVisibility(View.VISIBLE);
            this.f4381e.m1429l(1);
        }
    }

    public void mo6430h0() {
    }

    @Override
    public void mo6431k() {
        mo6438x(this.browserActivity.getTabManager().getActiveTab().getTabId());
        SiteSettingsManager.getInstance().m6950S();
        SyncManager.getInstance().getResourceManager("syncable_user_tabs").incrementVersion();
    }

    @Override
    public void mo6432n(InterfaceC1300b3 interfaceC1300b3, String str) {
        this.f4378b.setProgress(0);
        this.f4380d = true;
        this.f4378b.setVisibility(View.INVISIBLE);
        this.f4379c = false;
        this.browserActivity.m6254R0().m7074k();
        if (!TextUtils.isEmpty(interfaceC1300b3.mo1574c())) {
            interfaceC1300b3.mo5624a();
        }
        Log.i("toolbar", " set state to finished...");
        this.f4381e.m1429l(0);
    }

    @Override
    public void mo6433p(InterfaceC1300b3 interfaceC1300b3, String str, boolean z) {
        if (str.equals("x:history") || SharedPreferencesHelper.getInstance().enterPrivateMode || interfaceC1300b3.mo5626h() == 8 || str.indexOf("article_list_for_xb_readmode") >= 0 || str.startsWith("x:") || str.startsWith("data:")) {
            return;
        }
        this.browserActivity.getHandler().postDelayed(new RunnableC1490e(str, interfaceC1300b3), 500L);
    }

    public void m6434s() {
        this.browserActivity.openUrl(SharedPreferencesHelper.getInstance().m6857H(), true, 0);
        m6394C().m1429l(0);
        SyncManager.getInstance().getResourceManager("syncable_user_tabs").incrementVersion();
        this.browserActivity.getHandler().postDelayed(new RunnableC1493h(), 500L);
    }

    public final void m6435t(String str, boolean z) throws Resources.NotFoundException, URISyntaxException {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return;
        }
        String strMo1573b = interfaceC1300b3.getUrlFromTitle();
        Log.i("third-app", "refererUrl: " + strMo1573b + " mLastTouchCanResonse:" + ((C0219Ep) ((WebViewBrowserController) interfaceC1300b3).m6770F0()).f556g);
        String host = Uri.parse(strMo1573b).getHost();
        if (!z) {
            if (str.indexOf("baiduboxlite://v1/browser/open") >= 0 || str.indexOf("baiduboxapp://v1/browser/open") >= 0 || str.indexOf("baiduboxlite://utils") >= 0 || str.indexOf("baiduboxapp://utils") >= 0) {
                return;
            }
            if (!str.startsWith("mqqopensdkapi://")) {
                if (str.indexOf("bytedance://dispatch_message/") >= 0) {
                    return;
                }
                if (!str.startsWith("magnet:")) {
                    if (SiteSettingsManager.getInstance().getHost(3, host) != null) {
                        return;
                    }
                    m6408Q(host, str);
                }
            }
            this.browserActivity.m6190B0(str);
            return;
        }
        if (str.indexOf("mimarket://details?id=com.baidu.searchbox") < 0 && str.indexOf("sinanews://") < 0 && str.indexOf("bytedance://dispatch_message/") < 0 && str.indexOf("baiduboxlite://v1/browser/open") < 0 && str.indexOf("baiduboxapp://v1/browser/open") < 0 && str.indexOf("baiduboxlite://utils") < 0 && str.indexOf("baiduboxapp://utils") < 0) {
            if (str.indexOf("wtloginmqq://") >= 0) {
                str = str.replaceAll("googlechrome", "mmbox");
            }
            SiteSettingsManager.Host hostVarM6982X = SiteSettingsManager.getInstance().getHost(3, host);
            if (hostVarM6982X != null) {
                if (!hostVarM6982X.extra.equals("true")) {
                    hostVarM6982X.extra.equals("false");
                    return;
                }
                if (str.indexOf("baiduboxapp://utils") >= 0 || str.indexOf("baiduboxlite://utils") >= 0) {
                    m6408Q(host, str);
                    return;
                }
                this.browserActivity.m6190B0(str);
                return;
            }
            m6408Q(host, str);
        }
    }

    public void m6436u() {
        if (SharedPreferencesHelper.getInstance().getBoolean("confirm-when-close-tabs", true)) {
            new DialogC1495j(this.browserActivity).show(this.browserActivity.getString(R.string.dlg_remove_tabs), this.browserActivity.getString(R.string.dlg_remove_tabs_confrim), this.browserActivity.getString(R.string.check_box_do_not_show));
        } else {
            m6437v();
        }
    }

    public final void m6437v() {
        BrowserActivity browserActivity = this.browserActivity;
        if (browserActivity == null) {
            return;
        }
        boolean zIsDestroyed = browserActivity.isDestroyed();
        if (this.browserActivity.isFinishing() || zIsDestroyed) {
            return;
        }
        this.browserActivity.getTabManager().m9292P(new RunnableC1494i());
    }

    public void mo6438x(String str) {
    }

    public boolean mo6439y(String str) {
        return false;
    }

    public Activity m6440z() {
        return this.browserActivity;
    }

    public void mo6401J(InterfaceC0345Hd interfaceC0345Hd) {
    }
}
