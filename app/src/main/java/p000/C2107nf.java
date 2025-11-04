package p000;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.BrowserActivityDelegate;
import com.mmbox.xbrowser.ContentDataManager;
import com.mmbox.xbrowser.BrowserDownloadManager;
import com.mmbox.xbrowser.C1570e;
import com.mmbox.xbrowser.VideoSniffingManager;
import com.mmbox.xbrowser.MenuConfigManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.mmbox.xbrowser.provider.BrowserProvider;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2107nf {

    public BrowserActivity browserActivity;

    public class A implements Runnable {

        public final String f6314l;

        public final boolean f6315m;

        public A(String str, boolean z) {
            this.f6314l = str;
            this.f6315m = z;
        }

        @Override
        public void run() throws URISyntaxException {
            C2107nf.this.browserActivity.m6315f2(this.f6314l, this.f6315m);
        }
    }

    public class B implements Runnable {
        public B() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.openDownloads();
        }
    }

    public class C implements Runnable {

        public final String f6318l;

        public final int f6319m;

        public C(String str, int i) {
            this.f6318l = str;
            this.f6319m = i;
        }

        @Override
        public void run() throws URISyntaxException {
            C2107nf.this.browserActivity.openUrl(this.f6318l, true, this.f6319m);
        }
    }

    public class D implements Runnable {

        public final String f6321l;

        public D(String str) {
            this.f6321l = str;
        }

        @Override
        public void run() throws URISyntaxException {
            C2107nf.this.browserActivity.m6307d2(this.f6321l);
        }
    }

    public class E implements Runnable {

        public final String f6323l;

        public final int f6324m;

        public final boolean f6325n;

        public E(String str, int i, boolean z) {
            this.f6323l = str;
            this.f6324m = i;
            this.f6325n = z;
        }

        @Override
        public void run() throws URISyntaxException {
            C2107nf.this.browserActivity.m6311e2(this.f6323l, null, this.f6324m, this.f6325n);
        }
    }

    public class F implements Runnable {
        public F() {
        }

        @Override
        public void run() throws URISyntaxException {
            C2107nf.this.browserActivity.m6307d2(C2439uo.getInstance().m10235v());
        }
    }

    public class G implements Runnable {
        public G() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.m6320g3();
        }
    }

    public class H implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() {
                int[] iArrM6258S0 = C2107nf.this.browserActivity.getColors();
                if (iArrM6258S0 == null || iArrM6258S0.length <= 0) {
                    return;
                }
                SharedPreferencesHelper.getInstance().putBoolean("is_light_start_page_bg", ThemeManager.getInstance().isColorLight(iArrM6258S0[0]));
                C2107nf.this.browserActivity.updateTitle("document.dispatchEvent(new CustomEvent('themechange'))");
            }
        }

        public H() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.m6203E1();
            C2107nf.this.browserActivity.getHandler().postDelayed(new a(), 200L);
        }
    }

    public class I implements Runnable {
        public I() {
        }

        @Override
        public void run() {
            new ViewOnClickListenerC1110Y6(C2107nf.this.browserActivity).m4873b(SharedPreferencesHelper.getInstance().m6857H());
            SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
        }
    }

    public class J implements Runnable {

        public final String f6332l;

        public J(String str) {
            this.f6332l = str;
        }

        @Override
        public void run() {
            C2107nf.this.openUrl(this.f6332l, 0, false);
        }
    }

    public class K implements Runnable {

        public final String f6334l;

        public K(String str) {
            this.f6334l = str;
        }

        @Override
        public void run() {
            C2107nf.this.openUrl(this.f6334l, 0, false);
        }
    }

    public class L implements Runnable {

        public final String f6336l;

        public L(String str) {
            this.f6336l = str;
        }

        @Override
        public void run() throws URISyntaxException {
            C2107nf.this.browserActivity.openUrl("file://" + this.f6336l, true, 0);
        }
    }

    public class M implements Runnable {

        public final String f6338l;

        public M(String str) {
            this.f6338l = str;
        }

        @Override
        public void run() {
            try {
                FileUtils.writeBytesToFile(this.f6338l.getBytes(StandardCharsets.UTF_8), FileUtils.getNextAvailableFilePath(PhoneUtils.getInstance().getOfflinesDirPath() + "/" + NetworkUtils.sanitizeFileName(((InterfaceC1300b3) C2107nf.this.browserActivity.getTabManager().m9316y()).mo1574c(), Math.abs(((InterfaceC1300b3) C2107nf.this.browserActivity.getTabManager().m9316y()).getUrlFromTitle().hashCode()) + "", ".html")));
            } catch (Exception unused) {
                Toast.makeText(C2107nf.this.browserActivity, "Save as html file fail", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class N implements Runnable {

        public final String f6340l;

        public N(String str) {
            this.f6340l = str;
        }

        @Override
        public void run() {
            try {
                FileUtils.writeBytesToFile(this.f6340l.getBytes(StandardCharsets.UTF_8), FileUtils.getNextAvailableFilePath(PhoneUtils.getInstance().getOfflinesDirPath() + "/" + NetworkUtils.sanitizeFileName(((InterfaceC1300b3) C2107nf.this.browserActivity.getTabManager().m9316y()).mo1574c(), Math.abs(((InterfaceC1300b3) C2107nf.this.browserActivity.getTabManager().m9316y()).getUrlFromTitle().hashCode()) + "", ".txt")));
            } catch (Exception unused) {
                Toast.makeText(C2107nf.this.browserActivity, "Save as text file fail", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class R implements Comparator {
        public R() {
        }

        @Override
        public int compare(C0784R2 c0784r2, C0784R2 c0784r22) {
            if (c0784r22 != null && c0784r2 != null) {
                int i = c0784r22.f2318f;
                int i2 = c0784r2.f2318f;
                if (i > i2) {
                    if ((i & 2) == 2) {
                        return 1;
                    }
                    if ((i2 & 2) == 2) {
                        return -1;
                    }
                } else if (i < i2 && ((i != 0 || i2 != 1) && i2 != 4)) {
                    return (i & 2) == 2 ? 1 : -1;
                }
            }
            return 0;
        }
    }

    public class S implements Runnable {

        public class a extends ImportBookmarkDialog {
            public a(BrowserActivity browserActivity) {
                super(browserActivity);
            }

            /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
            @Override
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onOK(int type) {
                /*
                    r3 = this;
                    r0 = 0
                    if (r4 != 0) goto L5
                L3:
                    r1 = r0
                    goto L8
                L5:
                    r1 = 1
                    if (r4 != r1) goto L3
                L8:
                    f3 r4 = p000.MySQLiteOpenHelper.getInstance()
                    java.lang.String r2 = "bookmark"
                    int r4 = r4.m7529m0(r2, r1)
                    nf$S r1 = p000.C2107nf.S.this
                    nf r1 = p000.C2107nf.this
                    com.mmbox.xbrowser.BrowserActivity r1 = p000.C2107nf.m8759a(r1)
                    r2 = 2131558992(0x7f0d0250, float:1.8743315E38)
                    java.lang.String r1 = r1.getString(r2)
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                    java.lang.Object[] r4 = new java.lang.Object[]{r4}
                    java.lang.String r4 = java.lang.String.format(r1, r4)
                    nf$S r1 = p000.C2107nf.S.this
                    nf r1 = p000.C2107nf.this
                    com.mmbox.xbrowser.BrowserActivity r1 = p000.C2107nf.m8759a(r1)
                    android.widget.Toast r4 = android.widget.Toast.makeText(r1, r4, r0)
                    r4.show()
                    nf$S r4 = p000.C2107nf.S.this
                    nf r4 = p000.C2107nf.this
                    com.mmbox.xbrowser.BrowserActivity r4 = p000.C2107nf.m8759a(r4)
                    r4.m6345o2()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p000.C2107nf.S.a.mo7415b(int):void");
            }
        }

        public S() {
        }

        @Override
        public void run() {
            new a(C2107nf.this.browserActivity).show();
        }
    }

    public class T implements Runnable {

        public final int f6350l;

        public T(int i) {
            this.f6350l = i;
        }

        @Override
        public void run() {
            Toast.makeText(C2107nf.this.browserActivity, String.format(C2107nf.this.browserActivity.getString(com.xbrowser.play.R.string.toast_total_marked_ad_saved), this.f6350l + ""), Toast.LENGTH_SHORT).show();
            C2107nf.this.browserActivity.updateTitle("commit_marked_targets()");
            C2107nf.this.browserActivity.m6377y0();
        }
    }

    public class U implements Runnable {
        public U() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.m6267U1();
        }
    }

    public class V implements Runnable {

        public final String f6353l;

        public final String f6354m;

        public V(String str, String str2) {
            this.f6353l = str;
            this.f6354m = str2;
        }

        @Override
        public void run() {
            try {
                C1199a3.getInstance().m5094e(this.f6354m, new JSONObject(this.f6353l));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class W implements C0232F1.d {

        public class a implements Runnable {

            public final String f6357l;

            public final String f6358m;

            public a(String str, String str2) {
                this.f6357l = str;
                this.f6358m = str2;
            }

            @Override
            public void run() throws IOException {
                Uri uriM8703k = AndroidSystemUtils.m8703k(C2107nf.this.browserActivity, FileUtils.getFileName(this.f6357l), this.f6358m, C2107nf.this.browserActivity.getString(com.xbrowser.play.R.string.app_name));
                if (uriM8703k != null) {
                    AndroidSystemUtils.m8698f(C2107nf.this.browserActivity, this.f6357l, uriM8703k);
                }
                AndroidSystemUtils.scanMediaFile(C2107nf.this.browserActivity, this.f6357l);
                Toast.makeText(C2107nf.this.browserActivity, "已经保存至了相册", Toast.LENGTH_SHORT).show();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override
            public void run() {
                Toast.makeText(C2107nf.this.browserActivity, "download failed", Toast.LENGTH_SHORT).show();
            }
        }

        public W() {
        }

        @Override
        public void mo844a(String str, String str2) {
            C2107nf.this.browserActivity.runOnUiThread(new a(str, str2));
        }

        @Override
        public void mo845b() {
            C2107nf.this.browserActivity.runOnUiThread(new b());
        }
    }

    public class X implements Runnable {
        public X() {
        }

        @Override
        public void run() {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) C2107nf.this.browserActivity.getTabManager().m9316y();
            if (interfaceC1300b3 instanceof WebViewBrowserController) {
                ((WebViewBrowserController) interfaceC1300b3).m6786V0();
            }
        }
    }

    public class Y implements Runnable {

        public final String f6362l;

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() {
                C2107nf.this.browserActivity.m6259S1(false);
            }
        }

        public Y(String str) {
            this.f6362l = str;
        }

        @Override
        public void run() {
            if (TextUtils.isEmpty(this.f6362l)) {
                C2107nf.this.browserActivity.getHandler().postDelayed(new a(), 500L);
            } else {
                C2107nf.this.browserActivity.m6259S1(true);
            }
        }
    }

    public class Z implements Runnable {
        public Z() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.m6381z0();
        }
    }

    public class RunnableC2729a implements Runnable {
        public RunnableC2729a() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6415X();
        }
    }

    public class a0 implements Runnable {
        public a0() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6431k();
        }
    }

    public class RunnableC2730b implements Runnable {
        public RunnableC2730b() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6407P();
        }
    }

    public class b0 implements Runnable {

        public final boolean f6369l;

        public b0(boolean z) {
            this.f6369l = z;
        }

        @Override
        public void run() throws NumberFormatException {
            int i;
            String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(((InterfaceC1300b3) C2107nf.this.browserActivity.getTabManager().m9316y()).getUrlFromTitle(), 1004);
            try {
                i = Integer.parseInt(C1570e.getInstance().getHost(7, strM2046a).extra);
            } catch (Exception unused) {
                i = 100;
            }
            int i2 = this.f6369l ? i - 10 : i + 10;
            if (i2 < 50) {
                i2 = 50;
            }
            if (i2 > 200) {
                i2 = 200;
            }
            C1570e.getInstance().m6958a(7, strM2046a, i2 + "");
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) C2107nf.this.browserActivity.getTabManager().m9316y();
            if (interfaceC1300b3 instanceof WebViewBrowserController) {
                ((WebViewBrowserController) interfaceC1300b3).m6770F0().getSettings().setTextZoom(i2);
            }
        }
    }

    public class RunnableC2731c implements Runnable {

        public final String f6371l;

        public RunnableC2731c(String str) {
            this.f6371l = str;
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6413V(this.f6371l);
        }
    }

    public class c0 implements Runnable {

        public final InterfaceC1300b3 f6373l;

        public final int f6374m;

        public final int f6375n;

        public c0(InterfaceC1300b3 interfaceC1300b3, int i, int i2) {
            this.f6373l = interfaceC1300b3;
            this.f6374m = i;
            this.f6375n = i2;
        }

        @Override
        public void run() {
            ((C0219Ep) ((WebViewBrowserController) this.f6373l).m6770F0()).m1091l(this.f6374m, this.f6375n);
        }
    }

    public class RunnableC2732d implements Runnable {
        public RunnableC2732d() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6410S();
        }
    }

    public class d0 implements Runnable {

        public final int f6378l;

        public final int f6379m;

        public d0(int i, int i2) {
            this.f6378l = i;
            this.f6379m = i2;
        }

        @Override
        public void run() {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) C2107nf.this.browserActivity.getTabManager().m9316y();
            if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
                return;
            }
            ((C0219Ep) ((WebViewBrowserController) interfaceC1300b3).m6770F0()).m1093n(this.f6378l, this.f6379m);
        }
    }

    public class RunnableC2733e implements Runnable {

        public final String f6381l;

        public RunnableC2733e(String str) {
            this.f6381l = str;
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6409R(this.f6381l);
        }
    }

    public class e0 implements Runnable {

        public final String f6383l;

        public e0(String str) {
            this.f6383l = str;
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6423d0(this.f6383l);
        }
    }

    public class RunnableC2734f implements Runnable {
        public RunnableC2734f() {
        }

        @Override
        public void run() {
            ThemeManager.getInstance().m9476D();
        }
    }

    public class f0 implements Runnable {
        public f0() {
        }

        @Override
        public void run() {
            Toast.makeText(C2107nf.this.browserActivity, com.xbrowser.play.R.string.toast_user_rule_source_exist, Toast.LENGTH_SHORT).show();
        }
    }

    public class RunnableC2735g implements Runnable {

        public final boolean f6387l;

        public RunnableC2735g(boolean z) {
            this.f6387l = z;
        }

        @Override
        public void run() {
            WebView.setWebContentsDebuggingEnabled(this.f6387l);
        }
    }

    public class g0 implements Runnable {
        public g0() {
        }

        @Override
        public void run() {
            Toast.makeText(C2107nf.this.browserActivity, com.xbrowser.play.R.string.toast_add_rule_import_task, Toast.LENGTH_LONG).show();
        }
    }

    public class RunnableC2736h implements Runnable {

        public final boolean f6390l;

        public RunnableC2736h(boolean z) {
            this.f6390l = z;
        }

        @Override
        public void run() {
            if (this.f6390l) {
                C2107nf.this.browserActivity.getWindow().addFlags(128);
            } else {
                C2107nf.this.browserActivity.getWindow().clearFlags(128);
            }
        }
    }

    public class h0 implements Runnable {
        public h0() {
        }

        @Override
        public void run() {
            Toast.makeText(C2107nf.this.browserActivity, com.xbrowser.play.R.string.toast_add_rule_import_task, Toast.LENGTH_LONG).show();
        }
    }

    public class RunnableC2737i implements Runnable {
        public RunnableC2737i() {
        }

        @Override
        public void run() throws Resources.NotFoundException {
            C2439uo.getInstance().m10217O();
        }
    }

    public class i0 implements Runnable {

        public final String f6394l;

        public i0(String str) {
            this.f6394l = str;
        }

        @Override
        public void run() {
            C2564xb.getInstance().m10657e(null, this.f6394l);
        }
    }

    public class RunnableC2738j implements Runnable {

        public final String f6396l;

        public RunnableC2738j(String str) {
            this.f6396l = str;
        }

        @Override
        public void run() {
            new DialogInterfaceOnDismissListenerC0097C4(C2107nf.this.browserActivity, this.f6396l).show();
        }
    }

    public class j0 implements Runnable {
        public j0() {
        }

        @Override
        public void run() {
            C2564xb.getInstance().m10654a();
        }
    }

    public class RunnableC2739k implements Runnable {

        public final String f6399l;

        public RunnableC2739k(String str) {
            this.f6399l = str;
        }

        @Override
        public void run() throws URISyntaxException {
            if (this.f6399l.indexOf("_xbpm_") >= 0) {
                C2107nf.this.browserActivity.openUrl(this.f6399l, true, 0);
            } else {
                C2107nf.this.browserActivity.m6315f2(this.f6399l, true);
            }
        }
    }

    public class k0 implements Runnable {
        public k0() {
        }

        @Override
        public void run() {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) C2107nf.this.browserActivity.getTabManager().m9316y();
            if (interfaceC1300b3 instanceof WebViewBrowserController) {
                ((C0219Ep) ((WebViewBrowserController) interfaceC1300b3).m6770F0()).m1092m();
                C2107nf.this.browserActivity.updateTitle("native_call_fullscreen()");
            }
        }
    }

    public class RunnableC2740l implements Runnable {
        public RunnableC2740l() {
        }

        @Override
        public void run() {
            Toast.makeText(C2107nf.this.browserActivity, com.xbrowser.play.R.string.toast_reset_site_conf, Toast.LENGTH_SHORT).show();
        }
    }

    public class l0 implements Runnable {

        public final int f6403l;

        public l0(int i) {
            this.f6403l = i;
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.m6196C2(this.f6403l);
        }
    }

    public class RunnableC2741m implements Runnable {
        public RunnableC2741m() {
        }

        @Override
        public void run() {
            new DialogInterfaceOnDismissListenerC0189E4(C2107nf.this.browserActivity).show();
        }
    }

    public class m0 implements Runnable {
        public m0() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.m6382z1();
        }
    }

    public class RunnableC2742n implements Runnable {
        public RunnableC2742n() {
        }

        @Override
        public void run() {
            new DialogInterfaceOnDismissListenerC0554M1(C2107nf.this.browserActivity).show();
        }
    }

    public class RunnableC2743o implements Runnable {
        public RunnableC2743o() {
        }

        @Override
        public void run() {
            new DialogInterfaceOnDismissListenerC1974kk(C2107nf.this.browserActivity).show();
        }
    }

    public class o0 implements Runnable {
        public o0() {
        }

        @Override
        public void run() throws JSONException, IOException {
            C0600N1.getInstance().m3260h();
        }
    }

    public class DialogC2744p extends SetDefaultBrowserDialog {

        public final boolean f6411c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DialogC2744p(BrowserActivity browserActivity, boolean z) {
            super(browserActivity);
            this.f6411c = z;
        }

        @Override
        public void onGo() {
            AndroidSystemUtils.m8687U(C2107nf.this.browserActivity, this.f6411c);
        }
    }

    public class p0 implements Runnable {

        public final String f6413l;

        public final String f6414m;

        public p0(String str, String str2) {
            this.f6413l = str;
            this.f6414m = str2;
        }

        @Override
        public void run() throws UnsupportedEncodingException {
            C2107nf.this.browserActivity.getActivityDelegate().mo6424e(this.f6413l, null, null, null, this.f6414m, 0L);
        }
    }

    public class RunnableC2745q implements Runnable {
        public RunnableC2745q() {
        }

        @Override
        public void run() {
            Toast.makeText(C2107nf.this.browserActivity, com.xbrowser.play.R.string.toast_created_new_ad_rule, Toast.LENGTH_SHORT).show();
            C2107nf.this.browserActivity.m6300c0();
        }
    }

    public class q0 implements Runnable {

        public final String f6417l;

        public final String f6418m;

        public q0(String str, String str2) {
            this.f6417l = str;
            this.f6418m = str2;
        }

        @Override
        public void run() {
            try {
                JSManager.getInstance().m8530e(this.f6417l, this.f6418m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class RunnableC2746r implements Runnable {

        public final String f6420l;

        public final String f6421m;

        public final String f6422n;

        public final String f6423o;

        public RunnableC2746r(String str, String str2, String str3, String str4) {
            this.f6420l = str;
            this.f6421m = str2;
            this.f6422n = str3;
            this.f6423o = str4;
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6420b0(this.f6420l, this.f6421m, this.f6422n, this.f6423o);
        }
    }

    public class r0 implements Runnable {

        public final String f6425l;

        public r0(String str) {
            this.f6425l = str;
        }

        @Override
        public void run() {
            C1651dn.getInstance().m7361h(this.f6425l);
        }
    }

    public class RunnableC2747s implements Runnable {

        public final String f6427l;

        public RunnableC2747s(String str) {
            this.f6427l = str;
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6412U(this.f6427l);
        }
    }

    public class s0 implements Runnable {
        public s0() {
        }

        @Override
        public void run() {
            C2107nf.this.showToast("test");
            C2107nf.this.browserActivity.installApk(Uri.parse("https://www.xbext.com"));
        }
    }

    public class RunnableC2748t implements Runnable {

        public final boolean f6430l;

        public final boolean f6431m;

        public RunnableC2748t(boolean z, boolean z2) {
            this.f6430l = z;
            this.f6431m = z2;
        }

        @Override
        public void run() {
            if (this.f6430l) {
                if (this.f6431m && !SharedPreferencesHelper.getInstance().enterNightMode) {
                    C2107nf.this.browserActivity.m6352r0(true, false);
                } else if (!this.f6431m && SharedPreferencesHelper.getInstance().enterNightMode) {
                    C2107nf.this.browserActivity.m6352r0(false, false);
                }
            }
            MenuConfigManager.getInstance().m7037t();
        }
    }

    public class RunnableC2749u implements Runnable {
        public RunnableC2749u() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.m6340n0(false);
        }
    }

    public class RunnableC2750v implements Runnable {
        public RunnableC2750v() {
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getBrowserFrameLayout().m6461j();
        }
    }

    public class v0 implements Runnable {

        public final String f6438l;

        public v0(String str) {
            this.f6438l = str;
        }

        @Override
        public void run() {
            C2107nf.this.browserActivity.getActivityDelegate().mo6421c0(this.f6438l);
        }
    }

    public class RunnableC2751w implements Runnable {

        public final String f6440l;

        public RunnableC2751w(String str) {
            this.f6440l = str;
        }

        @Override
        public void run() {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.f6440l);
            intent.putExtra("android.intent.extra.SUBJECT", C2107nf.this.browserActivity.getString(com.xbrowser.play.R.string.share_sign));
            intent.setFlags(268435456);
            try {
                C2107nf.this.browserActivity.startActivity(Intent.createChooser(intent, C2107nf.this.browserActivity.getString(com.xbrowser.play.R.string.choose_app)));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(C2107nf.this.browserActivity, "no app to share", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class RunnableC2752x implements Runnable {

        public final String f6442l;

        public RunnableC2752x(String str) {
            this.f6442l = str;
        }

        @Override
        public void run() {
            BrowserActivity browserActivity;
            int i;
            if (this.f6442l.equals("auto")) {
                browserActivity = C2107nf.this.browserActivity;
                i = 10;
            } else if (this.f6442l.equals("landscape")) {
                browserActivity = C2107nf.this.browserActivity;
                i = 0;
            } else {
                if (!this.f6442l.equals("portrait")) {
                    return;
                }
                browserActivity = C2107nf.this.browserActivity;
                i = 1;
            }
            browserActivity.setRequestedOrientation(i);
        }
    }

    public class RunnableC2753y implements Runnable {
        public RunnableC2753y() {
        }

        @Override
        public void run() throws URISyntaxException {
            C2107nf.this.browserActivity.m6307d2("x:block-rule");
        }
    }

    public class RunnableC2754z implements Runnable {
        public RunnableC2754z() {
        }

        @Override
        public void run() throws URISyntaxException {
            C2107nf.this.browserActivity.m6307d2("x:autoproxy");
        }
    }

    public C2107nf(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
    }

    @JavascriptInterface
    public void GM_EX_ShareTextToApp(String str) {
        this.browserActivity.runOnUiThread(new RunnableC2751w(str));
    }

    @JavascriptInterface
    public void GM_EX_TTS(String str) {
        TTS(str);
    }

    @JavascriptInterface
    public String GM_EX_getAppSearchEngineUrl(String str) {
        return SharedPreferencesHelper.getInstance().getSearchUrl().replace("%keywords%", str);
    }

    @JavascriptInterface
    public String GM_EX_getSearchEngines() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayListM5292h = C1224ai.getInstance().getAppList("search_engine");
        for (int i = 0; i < arrayListM5292h.size(); i++) {
            C1224ai.ThirdApp thirdAppVar = (C1224ai.ThirdApp) arrayListM5292h.get(i);
            JSONObject jSONObject = new JSONObject();
            try {
                String str = thirdAppVar.pkg;
                String strM471z = NetworkUtils.getHostFileExtension(str);
                jSONObject.put("name", thirdAppVar.name);
                jSONObject.put("host", strM471z);
                jSONObject.put("url", str);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public void GM_EX_setDeviceOrientation(String str) {
        this.browserActivity.runOnUiThread(new RunnableC2752x(str));
    }

    @JavascriptInterface
    public void GM_EX_sniffMedia() {
        this.browserActivity.runOnUiThread(new RunnableC2749u());
    }

    @JavascriptInterface
    public void GM_cookie_delete(String str, String str2) {
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie != null) {
            for (String str3 : cookie.split(";")) {
                if (str3.trim().split("=")[0].trim().equals(str2)) {
                    cookieManager.setCookie(str, str2 + "=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/");
                    cookieManager.flush();
                    return;
                }
            }
        }
    }

    @JavascriptInterface
    public String GM_cookie_list(String str, String str2, String str3, String str4) throws JSONException {
        String cookie;
        if (!TextUtils.isEmpty(str)) {
            cookie = CookieManager.getInstance().getCookie(str);
        } else if (TextUtils.isEmpty(str2)) {
            cookie = "";
        } else {
            if (str2.startsWith(".")) {
                str2 = str2.substring(1);
            }
            cookie = CookieManager.getInstance().getCookie("http://" + str2);
            if (TextUtils.isEmpty(cookie)) {
                cookie = CookieManager.getInstance().getCookie("https://" + str2);
            }
        }
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(cookie)) {
            for (String str5 : cookie.split(";")) {
                String[] strArrSplit = str5.split("=");
                if (strArrSplit.length == 2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        String strTrim = strArrSplit[0].trim();
                        String strTrim2 = strArrSplit[1].trim();
                        jSONObject.put("name", strTrim);
                        jSONObject.put("value", strTrim2);
                        if ((TextUtils.isEmpty(str3) && (TextUtils.isEmpty(str4) || str4.equals("/"))) || ((!TextUtils.isEmpty(str3) && strTrim.equals(str3) && (TextUtils.isEmpty(str4) || str4.equals("/"))) || ((!TextUtils.isEmpty(str4) && strTrim.equals(str4) && (TextUtils.isEmpty(str4) || str4.equals("/"))) || (!TextUtils.isEmpty(str3) && cookie.indexOf(str3) >= 0 && cookie.indexOf(str4) >= 0)))) {
                            jSONArray.put(jSONObject);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String GM_cookie_set(String str, String str2, String str3, String str4, String str5) {
        String str6;
        CookieManager.getInstance().setAcceptCookie(true);
        String str7 = "";
        if (!TextUtils.isEmpty(str)) {
            CookieManager.getInstance().setCookie(str, str3 + "=" + str4);
            str6 = "";
            str7 = str;
        } else if (TextUtils.isEmpty(str2)) {
            str6 = "";
        } else {
            if (str2.startsWith(".")) {
                str2 = str2.substring(1);
            }
            str7 = "https://" + str2;
            str6 = "http://" + str2;
        }
        if (!TextUtils.isEmpty(str7)) {
            CookieManager.getInstance().setCookie(str7, str3 + "=" + str4 + "; path=" + str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            CookieManager.getInstance().setCookie(str6, str3 + "=" + str4 + "; path=" + str5);
        }
        return GM_cookie_list(str, str2, str3, str5);
    }

    @JavascriptInterface
    public void GM_deleteValue(String str, String str2) throws SQLException {
        JSManager.getInstance().deleteResourceMap(str + "_" + str2);
        String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(str, 1009);
        if (TextUtils.isEmpty(strM2046a)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(strM2046a);
            JsonUtils.remove(jSONArray, str2);
            ResourceCacheManager.getInstance().m2061q(str, jSONArray.toString(), 1008);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @JavascriptInterface
    public void GM_download(String str, String str2, boolean z, String str3) {
        this.browserActivity.getActivityDelegate().m6405N(str, str2, z, str3);
    }

    @JavascriptInterface
    public void GM_downloadV2(String str, String str2, String str3) {
        try {
            this.browserActivity.m6236M2(com.xbrowser.play.R.string.toast_script_downding, 5000L);
            JSManager.getInstance().m8524b(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public String GM_getResourceText(String str, String str2) {
        return JSManager.getInstance().m8526c(str, str2.trim());
    }

    @JavascriptInterface
    public String GM_getResourceURL(String str, String str2) {
        return JSManager.getInstance().m8528d(str, str2);
    }

    @JavascriptInterface
    public String GM_getResourceValue(String str, String str2) {
        return JSManager.getInstance().getUserScriptResourceValue(str, str2);
    }

    @JavascriptInterface
    public String GM_getValue(String str, String str2) {
        return ResourceCacheManager.getInstance().getUrlOrFilePath(str + "_" + str2, 1008);
    }

    @JavascriptInterface
    public String GM_listValueKeys(String str) {
        return ResourceCacheManager.getInstance().getUrlOrFilePath(str, 1009);
    }

    @JavascriptInterface
    public void GM_notification(String str, String str2) {
        this.browserActivity.runOnUiThread(new q0(str, str2));
    }

    @JavascriptInterface
    public String GM_readStream(String str) {
        return JSManager.getInstance().m8532f(str);
    }

    @JavascriptInterface
    public String GM_registerMenuCommand(String str, String str2, String str3) {
        return JSManager.getInstance().m8533g(str, str2, str3);
    }

    @JavascriptInterface
    public void GM_setValue(String str, String str2, String str3) {
        ResourceCacheManager.getInstance().m2061q(str + "_" + str2, str3, 1008);
        JSONArray jSONArray = new JSONArray();
        try {
            String strM2049e = ResourceCacheManager.getInstance().getResourceValueByKey(str);
            if (strM2049e != null) {
                jSONArray = new JSONArray(strM2049e);
            }
            boolean z = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                if (((String) jSONArray.get(i)).equals(str2)) {
                    z = true;
                }
            }
            if (!z) {
                jSONArray.put(str2);
            }
        } catch (JSONException unused) {
        }
        ResourceCacheManager.getInstance().m2061q(str, jSONArray.toString(), 1009);
    }

    @JavascriptInterface
    public void GM_unregisterMenuCommand(String str, String str2) throws NumberFormatException {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return;
        }
        JSManager.getInstance().m8508O0(str, str2);
    }

    @JavascriptInterface
    public void GM_xmlhttpRequest(String str, String str2, String str3) {
        try {
            JSManager.getInstance().m8535h(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void TTS(String str) {
        this.browserActivity.runOnUiThread(new r0(str));
    }

    @JavascriptInterface
    public void activeAdBlock(boolean z) {
        ContentDataManager.getInstance().m6636q(z);
    }

    @JavascriptInterface
    public void activeSearchBar() {
        this.browserActivity.m6360u();
    }

    @JavascriptInterface
    public boolean adBlockActived() {
        return SharedPreferencesHelper.getInstance().activeAdBlock;
    }

    @JavascriptInterface
    public void addBadRule(String str) throws NoSuchAlgorithmException {
        ContentDataManager.getInstance().m6642s(str);
    }

    @JavascriptInterface
    public void addBookmark(String str, String str2, String str3, boolean z) {
        if (m8760b()) {
            ContentValues contentValues = new ContentValues();
            if (str.indexOf("&amp;") >= 0) {
                str = str.replaceAll("&amp;", "＆");
            } else if (str.indexOf("&") >= 0) {
                str = str.replaceAll("&", "＆");
            }
            contentValues.put("title", str);
            if (z) {
                if (str2.indexOf("&amp;") >= 0) {
                    str2 = str2.replaceAll("&amp;", "＆");
                } else if (str3.indexOf("&") >= 0) {
                    str2 = str2.replaceAll("&", "＆");
                }
                contentValues.put("url", str2);
            } else {
                contentValues.put("url", str2);
                if (str3.indexOf("&amp;") >= 0) {
                    str3 = str3.replaceAll("&amp;", "＆");
                } else if (str3.indexOf("&") >= 0) {
                    str3 = str3.replaceAll("&", "＆");
                }
            }
            contentValues.put("parent", str3);
            contentValues.put("type", Integer.valueOf(z ? 1 : 0));
            contentValues.put("last_visit", Long.valueOf(System.currentTimeMillis()));
            MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues);
        }
    }

    @JavascriptInterface
    public void addBookmarkItemFlag(String str, int i) {
        MySQLiteOpenHelper.getInstance().m7510a(str, i);
    }

    @JavascriptInterface
    public void addCustomAdRule(String str) {
        if (ContentDataManager.getInstance().m6644t(str) != null) {
            this.browserActivity.runOnUiThread(new RunnableC2745q());
        } else {
            this.browserActivity.m6252Q2(com.xbrowser.play.R.string.toast_rule_syntax_not_support);
        }
    }

    @JavascriptInterface
    public void addCustomSearches(String str) {
        m8764f("custom_search_urls", str);
        SharedPreferencesHelper.getInstance().putString("custom_search_url", "");
    }

    @JavascriptInterface
    public void addCustomUAString(String str) throws JSONException {
        m8764f("custom_ua", str);
        SharedPreferencesHelper.getInstance().m6897h0();
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }

    @JavascriptInterface
    public void addDomain(int i, String str, String str2) {
        C1570e.getInstance().m6958a(i, str, str2);
    }

    @JavascriptInterface
    public void addImageRes(String str, String str2) throws JSONException {
        VideoSniffingManager.getInstance().m6994d(str, str2);
    }

    @JavascriptInterface
    public void addNewQaItem(String str) throws JSONException {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        try {
            JSONObject jSONObject = new JSONObject(str);
            ContentValues contentValues = new ContentValues();
            String string = jSONObject.getString("id");
            String string2 = jSONObject.getString("title");
            String strM3666k = JsonUtils.getString(jSONObject, "url", null);
            String strM3666k2 = JsonUtils.getString(jSONObject, "icon_uri", null);
            int iM3660e = JsonUtils.getInt(jSONObject, "type", 0);
            int iM3660e2 = JsonUtils.getInt(jSONObject, "order", 0);
            String strM3666k3 = JsonUtils.getString(jSONObject, "parent", "root");
            JSONObject jSONObjectM3662g = JsonUtils.getJSONObject(jSONObject, "extra");
            String string3 = jSONObjectM3662g != null ? jSONObjectM3662g.toString() : null;
            contentValues.put("guid", string);
            contentValues.put("title", string2);
            if (!TextUtils.isEmpty(strM3666k)) {
                contentValues.put("url", strM3666k);
            }
            if (!TextUtils.isEmpty(strM3666k2)) {
                contentValues.put("icon_uri", strM3666k2);
            }
            contentValues.put("item_order", Integer.valueOf(iM3660e2));
            contentValues.put("item_type", Integer.valueOf(iM3660e));
            contentValues.put("parent", strM3666k3);
            if (!TextUtils.isEmpty(string3)) {
                contentValues.put("extra", string3);
            }
            Log.i("affect", "insert new id:" + writableDatabase.insert("quick_access", null, contentValues));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void addQuickAccess(String str, String str2, int i) throws Resources.NotFoundException {
        this.browserActivity.m6376y(str, str2, i);
    }

    @JavascriptInterface
    public void addTagToResource(String str, String str2) {
        VideoSniffingManager.getInstance().m6996f(str, str2);
    }

    @JavascriptInterface
    public void adjustBrightness() {
        this.browserActivity.m6185A();
    }

    @JavascriptInterface
    public void adjustFontSize() {
        this.browserActivity.m6249Q();
    }

    @JavascriptInterface
    public void allowAccessLocation(boolean z) {
        m8762d("enable_geolocation", z);
    }

    @JavascriptInterface
    public void allowAutoFillOnDomain(String str, boolean z) {
        C1570e.getInstance().m6960b(str, z);
    }

    @JavascriptInterface
    public boolean allowBackgroundPlay(String str) {
        return C1570e.getInstance().m6961c(str);
    }

    @JavascriptInterface
    public void allowCallApp(String str, boolean z) {
        C1570e.getInstance().m6962d(str, z);
    }

    @JavascriptInterface
    public void allowCookiesOnDomain(String str, boolean z) {
        C1570e.getInstance().m6963e(str, z);
    }

    @JavascriptInterface
    public void allowJsOnDomin(String str, boolean z) {
        C1570e.getInstance().m6964f(str, z);
    }

    @JavascriptInterface
    public void allowPermOnDomain(String str, String str2, boolean z) {
        C1570e.getInstance().m6965g(str, str2, z);
    }

    @JavascriptInterface
    public void allowRequstLocation(String str, boolean z) {
        C1570e.getInstance().m6967i(str, z);
    }

    @JavascriptInterface
    public void allowUserScriptOnDomain(String str, boolean z) throws JSONException {
        C1570e.getInstance().m6969k(str, z);
    }

    @JavascriptInterface
    public void autoCleanWebCache(boolean z) {
        SharedPreferencesHelper.getInstance().autoCleanWebCache = z;
        m8762d("auto-clean-web-cache", z);
    }

    @JavascriptInterface
    public void autoOpenUncloseTab(boolean z) {
        m8762d("open-unclose-tab", z);
        SharedPreferencesHelper.getInstance().openUncloseTab = z;
    }

    public final boolean m8760b() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return false;
        }
        String strM6767C0 = ((WebViewBrowserController) interfaceC1300b3).m6767C0();
        return TextUtils.isEmpty(strM6767C0) || strM6767C0.startsWith("x:") || strM6767C0.startsWith("file:///") || strM6767C0.indexOf("xbext.com") >= 0 || strM6767C0.indexOf("iwebshuttle.com") >= 0;
    }

    @JavascriptInterface
    public void backupUserData() {
        C2439uo.getInstance().m10223j(true, "");
    }

    @JavascriptInterface
    public void bindUser(int i, String str, String str2, String str3) {
        C2439uo.getInstance().m10224k(i, str, str2, str3);
    }

    @JavascriptInterface
    public void bindUser2(String str, String str2) {
        C2439uo.getInstance().m10225l(str, str2);
    }

    @JavascriptInterface
    public void bindUserInfo(String str, String str2, String str3) {
        C2439uo.getInstance().m10226m(str, str2, str3);
    }

    @JavascriptInterface
    public void blockPopWindow(boolean z) {
        SharedPreferencesHelper.getInstance().blockPopWindow = z;
        m8762d("block-pop-window", z);
    }

    @JavascriptInterface
    public void blockThirdPartSite(String str, boolean z) {
        C1570e.getInstance().m6976r(str, z);
    }

    @JavascriptInterface
    public boolean bookmarkNewOrder(String str, int i, int i2, String str2) {
        boolean zM7488C = MySQLiteOpenHelper.getInstance().m7488C(str, i, i2, str2);
        SyncManager.getInstance().getResourceManager("syncable_bookmark").incrementVersion();
        return zM7488C;
    }

    public final boolean m8761c(String str) {
        String str2;
        int iIndexOf;
        if (str.indexOf("->") >= 0 || str.indexOf("+js(") >= 0 || str.indexOf(":style(") >= 0 || str.indexOf(":-abp") >= 0) {
            return true;
        }
        return ((str.indexOf(":has") < 0 || (str2 = AbstractC0907To.f2782a) == null || (iIndexOf = str2.indexOf(".")) <= 0 || Integer.parseInt(AbstractC0907To.f2782a.substring(0, iIndexOf)) >= 105) && NetworkUtils.areBracketsBalanced(str) && NetworkUtils.areQuotesBalanced(str)) ? false : true;
    }

    @JavascriptInterface
    public void castCurrentMedia() {
        showToast("call case meida");
    }

    @JavascriptInterface
    public void changeBackForwardGesutre() {
        new DialogC2180p4(this.browserActivity).show();
    }

    @JavascriptInterface
    public void changeGestureAction(String str) {
        new DialogC2272r4(this.browserActivity, str).show();
    }

    @JavascriptInterface
    public void changeLanguage() {
        new DialogInterfaceOnDismissListenerC2318s4(this.browserActivity).show();
    }

    @JavascriptInterface
    public void chooseExpoint(String str) {
        this.browserActivity.runOnUiThread(new RunnableC2738j(str));
    }

    @JavascriptInterface
    public void chooseScreenRotation() {
        this.browserActivity.m6295b0();
    }

    @JavascriptInterface
    public void chooseSearchEngine() {
        this.browserActivity.runOnUiThread(new RunnableC2741m());
    }

    @JavascriptInterface
    public void chooseUA() {
        new DialogC0235F4(this.browserActivity).show();
    }

    @JavascriptInterface
    public void cleanBookmarkItemFlag(String str, int i) {
        MySQLiteOpenHelper.getInstance().m7491E(str, i);
    }

    @JavascriptInterface
    public void cleanData() {
        this.browserActivity.m6313f0();
    }

    @JavascriptInterface
    public void cleanStartPageBg() {
        this.browserActivity.m6309e0();
        this.browserActivity.m6363u2();
        this.browserActivity.clearImmersePageCache();
    }

    @JavascriptInterface
    public void cleanStartPageLogo() {
        FileUtils.deleteFile(ResourceCacheManager.getInstance().getUrlOrFilePath("start-page.logo", 9));
    }

    @JavascriptInterface
    public void cleanWebCacheOnExit(boolean z) {
        if (z) {
            new DialogC0465K4(this.browserActivity, false).show();
        }
        m8762d("clean-web-cache-on-exit", z);
        SharedPreferencesHelper.getInstance().cleanCacheOnExit = z;
    }

    @JavascriptInterface
    public void clickQaItem(String str) {
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("quick_access", DatabaseColumns.QUICK_ACCESS, "guid= ?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("url"));
                    cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("icon_uri"));
                    String strM471z = NetworkUtils.getHostFileExtension(string);
                    if (!TextUtils.isEmpty(strM471z)) {
                        C1344c1.getInstance().m5698h("QA Item Click", "qa_item_click/" + strM471z);
                        try {
                            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.browserActivity);
                            firebaseAnalytics.setAnalyticsCollectionEnabled(true);
                            Bundle bundle = new Bundle();
                            bundle.putString("domain", strM471z);
                            bundle.putString("country_code", PhoneUtils.getInstance().getSimOrNetworkCountryCode());
                            firebaseAnalytics.logEvent("qa_item_click", bundle);
                        } catch (Throwable unused) {
                        }
                    }
                    this.browserActivity.runOnUiThread(new RunnableC2739k(string));
                }
            } catch (Exception unused2) {
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
            cursorQuery.close();
        }
    }

    @JavascriptInterface
    public void closeTabInOrder(boolean z) {
        m8762d("close-tab-in-order", z);
    }

    @JavascriptInterface
    public void commitBookmarkImport() {
        this.browserActivity.runOnUiThread(new S());
    }

    @JavascriptInterface
    public void confirmWhenCloseTabs(boolean z) {
        m8762d("confirm-when-close-tabs", z);
    }

    @JavascriptInterface
    public void continueAccessBlockedUrl(String str, boolean z) {
        WebViewBrowserController.f4697M = str;
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return;
        }
        ContentDataManager.getInstance().m6560D(host);
        if (z) {
            C1570e.getInstance().m6958a(1, host, "true");
        }
    }

    @JavascriptInterface
    public void copyToClipboard(String str) {
        AndroidSystemUtils.m8701i(this.browserActivity, str);
        Toast.makeText(this.browserActivity, com.xbrowser.play.R.string.toast_copy_to_clip_board, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void costExchangeCode(int i, int i2) {
        EventQueueManager eventQueueManagerM7824D;
        String str;
        int i3;
        if (i2 == 0) {
            eventQueueManagerM7824D = EventQueueManager.getInstance();
            str = i + "";
            i3 = 15;
        } else {
            if (i2 != 1) {
                return;
            }
            eventQueueManagerM7824D = EventQueueManager.getInstance();
            str = i + "";
            i3 = 16;
        }
        eventQueueManagerM7824D.processEvent(i3, str);
    }

    @JavascriptInterface
    public void cutBookmark(String str) {
        WebViewBrowserController.f4699O.add(str);
    }

    public final void m8762d(String str, boolean z) {
        if (m8760b()) {
            SharedPreferencesHelper.getInstance().putBoolean(str, z);
            SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
        }
    }

    @JavascriptInterface
    public String dataToItemId(String str) {
        return AndroidSystemUtils.prefixWithMd5(str);
    }

    @JavascriptInterface
    public void deleteBookmark(String str) {
        if (m8760b()) {
            this.browserActivity.m6321h0(str);
        }
    }

    @JavascriptInterface
    public void deleteFile(String str) {
        C0801Ra.getInstance().m3801c(str);
    }

    @JavascriptInterface
    public void disableADBOnDomain(String str, boolean z) {
        if (z) {
            C1570e.getInstance().m6958a(1, str, null);
            ContentDataManager.getInstance().m6560D(str);
        } else {
            C1570e.getInstance().m6951T(1, str);
            ContentDataManager.getInstance().m6613e1(str);
        }
    }

    @JavascriptInterface
    public void disableCallApp(boolean z) {
        SharedPreferencesHelper.getInstance().setEnableCallApp(!z);
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }

    @JavascriptInterface
    public void disableClipboard(String str, boolean z) {
        C1570e.getInstance().m6978t(str, z);
    }

    public void disablePullToRefreshGesture(boolean z) {
        BrowserActivity browserActivity;
        int i;
        m8762d("disable-pull-to-refresh-gesture", z);
        SharedPreferencesHelper.getInstance().disablePullToRefreshGesture = z;
        if (z) {
            browserActivity = this.browserActivity;
            i = com.xbrowser.play.R.string.toast_disable_pull_to_refresh_gesture;
        } else {
            browserActivity = this.browserActivity;
            i = com.xbrowser.play.R.string.toast_enable_pull_to_refresh_gesture;
        }
        Toast.makeText(browserActivity, i, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void disablePullToSearchGesture(boolean z) {
        m8762d("disable-pull-to-search-gesture", z);
        SharedPreferencesHelper.getInstance().disablePullToSearchGesture = z;
    }

    @JavascriptInterface
    public void disableReadMode(boolean z) {
        SharedPreferencesHelper.getInstance().disableReadMode = z;
        m8762d("disable-read-mode", z);
    }

    @JavascriptInterface
    public void disableRule(String str, boolean z) {
        ContentDataManager.getInstance().m6574K(str, z);
    }

    @JavascriptInterface
    public void disableSearchBarHotWord(boolean z) {
        SharedPreferencesHelper.getInstance().disableSearchBarHotword = z;
        m8762d("disable-search-bar-hotword", z);
    }

    @JavascriptInterface
    public void disableSearchSuggestion(boolean z) {
        SharedPreferencesHelper.getInstance().disableSearchSuggestion = z;
        m8762d("disable-search-suggestion", z);
    }

    @JavascriptInterface
    public void disableThirdCookies(boolean z) {
        SharedPreferencesHelper.getInstance().disableThirdCookies = z;
        m8762d("disable-third-cookies", z);
        this.browserActivity.m6280X2();
    }

    @JavascriptInterface
    public void dismissContextMenu() {
        this.browserActivity.runOnUiThread(new RunnableC2750v());
    }

    @JavascriptInterface
    public void dismissFloatMessageBox() {
        this.browserActivity.runOnUiThread(new j0());
    }

    @JavascriptInterface
    public void dispatchEvent(String str, String str2) {
        this.browserActivity.runOnUiThread(new V(str2, str));
    }

    @JavascriptInterface
    public void doNotShowBrowserBookmarks(boolean z) {
        SharedPreferencesHelper.getInstance().hideBookmarks = z;
        m8762d("do-not-show-browser-bookmarks", z);
    }

    @JavascriptInterface
    public void doNotShowBrowserHistory(boolean z) {
        SharedPreferencesHelper.getInstance().hideBrowserHistory = z;
        m8762d("do-not-show-browser-his", z);
    }

    @JavascriptInterface
    public void doNotShowClipboardContent(boolean z) {
        SharedPreferencesHelper.getInstance().hideClipboardContent = z;
        m8762d("do-not-show-clipboard-content", z);
    }

    @JavascriptInterface
    public void doNotShowSearchHistory(boolean z) {
        SharedPreferencesHelper.getInstance().hideSearchHistory = z;
        m8762d("do-not-show-search-his", z);
    }

    @JavascriptInterface
    public void doNotUploadUXData(boolean z) {
        SharedPreferencesHelper.getInstance().dontUploadUserExpData = z;
        m8762d("dont-upload-user-exp-data", z);
    }

    @JavascriptInterface
    public void doTest() {
        EventQueueManager.getInstance().processEvent(18);
    }

    @JavascriptInterface
    public void donateTryApp(String str) {
        this.browserActivity.runOnUiThread(new K(str));
    }

    @JavascriptInterface
    public void downloadPayQrcode(int i) {
        C0232F1.m1169l().m1170e(PhoneUtils.getInstance().getCacheDirPath(), i == 1 ? "https://www.xbext.com/img/qrcode_airpay_for_phone.jpg" : "https://www.xbext.com/img/qrcode_wx_for_phone.png", new W());
    }

    @JavascriptInterface
    public void dumpDom(String str) {
        String str2 = PhoneUtils.getInstance().getCacheDirPath() + "/dom_dump.txt";
        FileUtils.writeBytesToFile(str.getBytes(StandardCharsets.UTF_8), str2);
        this.browserActivity.runOnUiThread(new L(str2));
    }

    public final void m8763e(String str, int i) {
        SharedPreferencesHelper.getInstance().putInt(str, i);
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }

    @JavascriptInterface
    public void enableDNT(boolean z) {
        SharedPreferencesHelper.getInstance().enableDNT = z;
        m8762d("enable-dnt", z);
    }

    @JavascriptInterface
    public void enableDomainSmartAdb(String str, boolean z) {
        C1570e.getInstance().m6979u(str, z);
        if (z) {
            SharedPreferencesHelper.getInstance().activeAdBlock = true;
            m8762d("active-ad-block", true);
        }
        ContentDataManager.getInstance().m6575K0();
    }

    @JavascriptInterface
    public void enableImmersiveMode(boolean z) {
        SharedPreferencesHelper.getInstance().enableImmersiveMode = z;
        m8762d("enable-immersive-mode", z);
        if (z) {
            return;
        }
        this.browserActivity.runOnUiThread(new RunnableC2734f());
    }

    @JavascriptInterface
    public void enableRemoteDebug(boolean z) {
        SharedPreferencesHelper.getInstance().enableRemoteDebug = z;
        m8762d("enable-remote-debug", z);
        this.browserActivity.runOnUiThread(new RunnableC2735g(z));
    }

    @JavascriptInterface
    public void enableSmartAdb(boolean z) {
        ContentDataManager.getInstance().m6582O(z);
    }

    @JavascriptInterface
    public void enableViewInDesktop(String str, boolean z) {
        C1570e.getInstance().m6980v(str, z);
    }

    @JavascriptInterface
    public void enterDevToolSelectMode() {
        this.browserActivity.uiLayoutMode = 4;
    }

    @JavascriptInterface
    public void exitDevToolSelectMode() {
        this.browserActivity.uiLayoutMode = 0;
    }

    @JavascriptInterface
    public void exitMediaPlayer() {
        this.browserActivity.runOnUiThread(new a0());
    }

    @JavascriptInterface
    public void exitReadMode(String str, String str2, String str3, String str4) {
        this.browserActivity.runOnUiThread(new Z());
    }

    @JavascriptInterface
    public void exportBookmarkToHtml() {
        C2439uo.getInstance().m10232s();
    }

    @JavascriptInterface
    public void exportCustomRule() {
        ContentDataManager.getInstance().m6584P();
    }

    @JavascriptInterface
    public void exportDirToZipFile(String str) {
        C2439uo.getInstance().m10233t(this.browserActivity.getExternalFilesDir("").getAbsolutePath() + File.separator + str);
    }

    public final void m8764f(String str, String str2) {
        if (m8760b()) {
            SharedPreferencesHelper.getInstance().putString(str, str2);
            SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
        }
    }

    @JavascriptInterface
    public String fetchCacheDataWithJson() {
        return C1039Wi.m4517p().m4522n();
    }

    @JavascriptInterface
    public void fetchScript(String str) {
        JSManager.getInstance().m8501L(str);
    }

    @JavascriptInterface
    public void forceOpenInBg(boolean z) {
        SharedPreferencesHelper.getInstance().forceOpenInBackground = z;
        m8762d("force-open-in-bg", z);
    }

    @JavascriptInterface
    public void forceOpenInNewTab(boolean z) {
        SharedPreferencesHelper.getInstance().forceOpenInNewTab = z;
        m8762d("force-open-in-new-tab", z);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0097 A[Catch: Exception -> 0x00f7, TryCatch #2 {Exception -> 0x00f7, blocks: (B:21:0x0064, B:23:0x0097, B:25:0x009d, B:27:0x00ec, B:32:0x00f9, B:35:0x010a, B:39:0x0127, B:43:0x013d), top: B:52:0x0064 }] */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public String getAdbLogs(String r21, int r22, int r23) throws JSONException, UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2107nf.getAdbLogs(java.lang.String, int, int):java.lang.String");
    }

    @JavascriptInterface
    public String getAppLogoUri() {
        try {
            return AndroidSystemUtils.m8672F(this.browserActivity, com.xbrowser.play.R.drawable.ic_slogan);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @JavascriptInterface
    public String getAvatarURI() {
        return C2439uo.getInstance().m10237x();
    }

    @JavascriptInterface
    public void getBase64FromBlobData(String str, String str2) {
        Log.i("blob", "receive-blob:" + str);
        this.browserActivity.runOnUiThread(new p0(str, str2));
    }

    @JavascriptInterface
    public String getBfGestureName() {
        return SharedPreferencesHelper.getInstance().gestureMode == 0 ? this.browserActivity.getString(com.xbrowser.play.R.string.bf_gesture_none) : SharedPreferencesHelper.getInstance().gestureMode == 1 ? this.browserActivity.getString(com.xbrowser.play.R.string.bf_gesture_normal) : SharedPreferencesHelper.getInstance().gestureMode == 2 ? this.browserActivity.getString(com.xbrowser.play.R.string.bf_gesture_edge) : SharedPreferencesHelper.getInstance().gestureMode == 3 ? this.browserActivity.getString(com.xbrowser.play.R.string.bf_gesture_bottom) : this.browserActivity.getString(com.xbrowser.play.R.string.bf_gesture_normal);
    }

    @JavascriptInterface
    public int getBookmarkStatus(String str) {
        return MySQLiteOpenHelper.getInstance().getBookmarkStatus(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(8:104|30|31|112|32|33|110|34)|(4:(1:49)(5:41|(0)(1:45)|102|55|(1:125)(1:58))|102|55|(0)(0))|(1:51)(1:52)|116|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0154, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0155, code lost:
    
        r1 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0143 A[EDGE_INSN: B:125:0x0143->B:57:0x0143 BREAK  A[LOOP:1: B:104:0x009c->B:58:0x0144], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0144 A[LOOP:1: B:104:0x009c->B:58:0x0144, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x023e  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public String getBookmarks(String r22, String r23, String r24) throws JSONException, SQLException {
        /*
            Method dump skipped, instructions count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2107nf.getBookmarks(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    @JavascriptInterface
    public boolean getBooleanPreference(String str) {
        if (!m8760b()) {
            return false;
        }
        if (str.equals("support_proxy")) {
            return SharedPreferencesHelper.getInstance().getString("support_proxy", "false").equals("true");
        }
        if (!str.equals("disable-javascript") && !str.equals("enable_call_app") && !str.equals("accept_cookies") && !str.equals("support-cookies-in-priv") && !str.equals("open-unclose-tab") && !str.equals("support-switch-tab-gesture") && !str.equals("show-ad-block-toast") && !str.equals("follow-sys-dark-mode") && !str.equals("enable_geolocation") && !str.equals("use-public-download-dir")) {
            if (str.equals("ignore_security_warnings")) {
                return SharedPreferencesHelper.getInstance().m6892e0();
            }
            if (str.equals("dont-upload-user-exp-data")) {
                return SharedPreferencesHelper.getInstance().getBoolean(str, false);
            }
            if (str.equals("auto-sniff-media")) {
                return SharedPreferencesHelper.getInstance().getBoolean(str, SharedPreferencesHelper.getInstance().autoSniffMedia);
            }
            if (str.equals("auto-clean-web-cache")) {
                return SharedPreferencesHelper.getInstance().getBoolean(str, SharedPreferencesHelper.getInstance().autoCleanWebCache);
            }
            if (!str.equals("confirm-when-close-tabs") && !str.equals("enable-immersive-mode") && !str.equals("show-qa-icons")) {
                return str.equals("enable-remote-debug") ? SharedPreferencesHelper.getInstance().enableRemoteDebug : str.equals("fullscreen-with-float-btn") ? SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn : str.equals("display-qa-in-single-screen") ? SharedPreferencesHelper.getInstance().getBoolean(str, true) : SharedPreferencesHelper.getInstance().getBoolean(str, false);
            }
            return SharedPreferencesHelper.getInstance().getBoolean(str, true);
        }
        return SharedPreferencesHelper.getInstance().getBoolean(str, true);
    }

    @JavascriptInterface
    public String getBrowserInfoObj() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("package_name", this.browserActivity.getPackageName());
            jSONObject.put("channel", PhoneUtils.getInstance().getChannelCode());
            jSONObject.put("lang", PhoneUtils.getInstance().getLanguageCode());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getBrowserLayoutType() {
        if ((this.browserActivity.getBrowserFrameLayout().getLayoutType() & 4097) == 4097) {
            return "search-bar-at-top";
        }
        this.browserActivity.getBrowserFrameLayout().getLayoutType();
        return "search-bar-at-bottom";
    }

    @JavascriptInterface
    public int getBrowserState() {
        return this.browserActivity.m6226K0();
    }

    @JavascriptInterface
    public int getBrowserToolbarHeight() {
        View bottomContainer;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.browserActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 8192) == 8192) {
            return 0;
        }
        if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4097) == 4097) {
            View topContainer = this.browserActivity.getBrowserFrameLayout().getTopContainer();
            View bottomContainer2 = this.browserActivity.getBrowserFrameLayout().getBottomContainer();
            height = topContainer != null ? topContainer.getHeight() : 0;
            if (bottomContainer2 != null) {
                height += bottomContainer2.getHeight();
            }
        } else if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4098) == 4098 && (bottomContainer = this.browserActivity.getBrowserFrameLayout().getBottomContainer()) != null) {
            height = bottomContainer.getHeight();
        }
        return (int) (height / displayMetrics.density);
    }

    @JavascriptInterface
    public String getChannelCode() {
        return PhoneUtils.getInstance().getChannelCode();
    }

    @JavascriptInterface
    public String getConfigValue(String str, String str2) {
        return (str.equals("file_order") || str.equals("bm_order")) ? SharedPreferencesHelper.getInstance().getString(str, str2) : str2;
    }

    @JavascriptInterface
    public int getCountAdbLogs() {
        return MySQLiteOpenHelper.getInstance().getTableRowCount(MySQLiteOpenHelper.getInstance().getReadableDatabase(), "ad_block_log");
    }

    @JavascriptInterface
    public int getCountCustomAdRules() {
        return MySQLiteOpenHelper.getInstance().getTableRowCount(MySQLiteOpenHelper.getInstance().getReadableDatabase(), "ad_block_rule");
    }

    @JavascriptInterface
    public int getCountHistories() {
        return MySQLiteOpenHelper.getInstance().getTableRowCount(MySQLiteOpenHelper.getInstance().getReadableDatabase(), "history");
    }

    @JavascriptInterface
    public String getCurrentDownloaderName() {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("default_downloader", "com.x.browser.downloader");
        if (strM6871P.equals("com.x.browser.downloader")) {
            return this.browserActivity.getString(com.xbrowser.play.R.string.title_default_downloader);
        }
        if (strM6871P.equals("com.android.providers.downloads")) {
            return this.browserActivity.getString(com.xbrowser.play.R.string.title_system_downloader);
        }
        Addon addonM9886D = C2406u0.getInstance().m9886d(strM6871P);
        return addonM9886D != null ? addonM9886D.title : this.browserActivity.getString(com.xbrowser.play.R.string.title_default_downloader);
    }

    @JavascriptInterface
    public String getCustomAdRules(String str, int i, int i2) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        str.indexOf(".");
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("ad_block_rule", DatabaseColumns.AD_BLOCK_RULE, null, null, null, null, "_id DESC LIMIT " + i + "  OFFSET " + i2);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        JSONObject jSONObject = new JSONObject();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("host"));
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("rule_type"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("rule_hash"));
                        String string3 = i3 == 2 ? "📎(mark)" : cursorQuery.getString(cursorQuery.getColumnIndex("rule_data"));
                        if (!string3.startsWith("=+")) {
                            if (TextUtils.isEmpty(string)) {
                                string = "*";
                            }
                            if (TextUtils.isEmpty(str) || string3.indexOf(str) >= 0) {
                                jSONObject.put("origin_host", string);
                                jSONObject.put("rule", string3);
                                jSONObject.put("rule_hash", string2);
                                jSONArray.put(jSONObject);
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getCustomSearches() throws JSONException {
        JSONArray jSONArray;
        String strM6871P = SharedPreferencesHelper.getInstance().getString("custom_search_url", "https://www.google.com/search?q=test&");
        String strM6871P2 = SharedPreferencesHelper.getInstance().getString("custom_search_urls", "[]");
        JSONArray jSONArray2 = new JSONArray();
        try {
            jSONArray = new JSONArray(strM6871P2);
            try {
                if (!TextUtils.isEmpty(strM6871P)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("title", this.browserActivity.getString(com.xbrowser.play.R.string.search_name_custom));
                    jSONObject.put("url", strM6871P);
                    jSONObject.put("id", AndroidSystemUtils.prefixWithMd5(strM6871P));
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
                jSONArray2 = jSONArray;
                jSONArray = jSONArray2;
                return jSONArray.toString();
            }
        } catch (Exception unused2) {
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getCustomUAStrings() throws JSONException {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("custom_ua", "");
        JSONArray jSONArray = new JSONArray();
        try {
            if (strM6871P.indexOf("[") >= 0 && strM6871P.indexOf("{") >= 0) {
                jSONArray = new JSONArray(strM6871P);
            } else if (!strM6871P.equals("") && !strM6871P.equals("[]")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("title", "Custom UA");
                jSONObject.put("ua_string", strM6871P);
                jSONObject.put("id", AndroidSystemUtils.prefixWithMd5(strM6871P));
                jSONArray.put(jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getDeviceId() {
        return PhoneUtils.getInstance().getDeviceId();
    }

    @JavascriptInterface
    public String getDomains(int i) {
        return C1570e.getInstance().m6984z(i);
    }

    @JavascriptInterface
    public String getDownloadDir() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    }

    @JavascriptInterface
    public String getDownloadInfo(String str) throws JSONException {
        BrowserDownloadManager.i iVarM6698n = BrowserDownloadManager.getInstance().m6698n(str);
        JSONObject jSONObject = new JSONObject();
        if (iVarM6698n != null) {
            long j = iVarM6698n.downloadedBytes;
            String strM8711s = AndroidSystemUtils.formatFileSize(j);
            String strM8711s2 = AndroidSystemUtils.formatFileSize(iVarM6698n.f4654k);
            String str2 = String.format("%s/%s", strM8711s, strM8711s2);
            String strM6712c = iVarM6698n.m6712c();
            try {
                jSONObject.put("downloaded", j);
                jSONObject.put("total", iVarM6698n.f4654k);
                jSONObject.put("status", iVarM6698n.downloadStatus);
                jSONObject.put("text_progress", str2);
                jSONObject.put("text_total", strM8711s2);
                jSONObject.put("text_speed", strM6712c);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getElementRules(String str) {
        String strM458m = NetworkUtils.getDomain(str);
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayListM6599X = ContentDataManager.getInstance().m6599X(strM458m);
        ArrayList arrayListM6599X2 = ContentDataManager.getInstance().m6599X(str);
        ArrayList arrayListM6599X3 = ContentDataManager.getInstance().m6599X("*");
        if (arrayListM6599X != null) {
            for (int i = 0; i < arrayListM6599X.size(); i++) {
                String str2 = (String) arrayListM6599X.get(i);
                if (ContentDataManager.getInstance().m6649v0(str2 + "@" + strM458m) && ContentDataManager.getInstance().m6649v0(str2 + "@" + str)) {
                    jSONArray.put(arrayListM6599X.get(i));
                }
            }
        }
        if (arrayListM6599X2 != null) {
            for (int i2 = 0; i2 < arrayListM6599X2.size(); i2++) {
                String str3 = (String) arrayListM6599X2.get(i2);
                if (ContentDataManager.getInstance().m6649v0(str3 + "@" + str) && ContentDataManager.getInstance().m6649v0(str3 + "@" + strM458m)) {
                    jSONArray.put(str3);
                }
            }
        }
        if (arrayListM6599X3 != null) {
            for (int i3 = 0; i3 < arrayListM6599X3.size(); i3++) {
                String str4 = (String) arrayListM6599X3.get(i3);
                if (ContentDataManager.getInstance().m6649v0(str4) && ContentDataManager.getInstance().m6649v0(str4 + "@" + strM458m) && ContentDataManager.getInstance().m6649v0(str4 + "@" + str)) {
                    jSONArray.put(str4);
                }
            }
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getExchangeCodeOptions() {
        ApiEndpointsManager.getInstance().getUserExchangeCodeEndpoint();
        C2439uo.getInstance().getUser().getUserId();
        PhoneUtils.getInstance().getChannelCode();
        return "";
    }

    @JavascriptInterface
    public String getExtraCss() {
        return JSManager.getInstance().m8511Q();
    }

    @JavascriptInterface
    public String getFaviconURI(String str) {
        C0896Td c0896TdM4137c;
        if (str.startsWith("http")) {
            c0896TdM4137c = C0896Td.m4137c();
        } else {
            c0896TdM4137c = C0896Td.m4137c();
            str = "http://" + str;
        }
        return c0896TdM4137c.getIconUri(str);
    }

    @JavascriptInterface
    public String getFiles(String str, String str2) {
        return C0801Ra.getInstance().getFilesAsJson(str, str2);
    }

    @JavascriptInterface
    public String getH5storeItems(String str) throws JSONException {
        String str2;
        String[] strArr;
        String str3;
        JSONArray jSONArray = new JSONArray();
        String[] strArr2 = {str};
        if (str.equals("latest")) {
            str3 = "created_at DESC";
            str2 = null;
            strArr = null;
        } else {
            str2 = "cate_id = ?";
            strArr = strArr2;
            str3 = "score DESC";
        }
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("h5store", DatabaseColumns.H_5_STORE, str2, strArr, null, null, str3, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        JSONObject jSONObject = new JSONObject();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("intro"));
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("ctr_flag"));
                        jSONObject.put("title", string);
                        jSONObject.put("url", string2);
                        jSONObject.put("intro", string3);
                        jSONObject.put("ctr_flag", i);
                        jSONObject.put("icon_url", ResourceCacheManager.getInstance().getUrlOrFilePath(string2, 7));
                        jSONObject.put("added", MySQLiteOpenHelper.getInstance().m7541w0(MySQLiteOpenHelper.getInstance().getWritableDatabase(), string2));
                        jSONArray.put(jSONObject);
                    } while (cursorQuery.moveToNext());
                } else {
                    try {
                        Toast.makeText(this.browserActivity, "no data please reload page", Toast.LENGTH_SHORT).show();
                        C2275r7.m9348e().m9354g("browser.h5store");
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        return jSONArray.toString();
                    }
                }
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e = e2;
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getHistories(String str, int i, int i2) throws JSONException {
        String str2;
        String[] strArr;
        if (!m8760b()) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = null;
                strArr = null;
            } else {
                strArr = new String[]{"%" + str + "%", "%" + str + "%"};
                str2 = "title LIKE ? COLLATE NOCASE OR url LIKE ? COLLATE NOCASE";
            }
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("history", DatabaseColumns.HISTORY, str2, strArr, null, null, "last_visit DESC LIMIT " + i + "  OFFSET " + i2);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        JSONObject jSONObject = new JSONObject();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex("last_visit"));
                        try {
                            String strM8717y = AndroidSystemUtils.m8717y(this.browserActivity, j);
                            String strM8668B = AndroidSystemUtils.m8668B(j);
                            String strM4138a = C0896Td.m4137c().getIconUri(string2);
                            jSONObject.put("id", AndroidSystemUtils.prefixWithMd5(string2));
                            jSONObject.put("raw_title", string);
                            if (!TextUtils.isEmpty(str)) {
                                string = string.replace(str, "<span style='color:red'>" + str + "</span>");
                            }
                            jSONObject.put("title", string);
                            jSONObject.put("url", string2);
                            jSONObject.put("visit_time", strM8668B);
                            jSONObject.put("visit_date", strM8717y);
                            jSONObject.put("icon_uri", "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAA8FBMVEUAAAB4SSB3QhR7TSd6US2JSQ59RRN7Rhl4PQpzPQ2GSQ+GSBFuOg5/SBh8SRx/PgdtOgl3PQuFRxBmOQvtzpGPRgLw1p/03a3iwYJ1OQKAPwXatXUdTA3SrGvMo2KNUhWbYSXn1p+7ik/z4rzCllmnczexf0MhVRFrOgbiyoyfCgSSFAQoYRa9vYjay5dkfEOURR/JxpOIlFtZi0FRazM8YSU3WR+PLRGhwYvhrYSXomXQg2S+X0a2UTs7eiTl37agrXBKfi+vNSatGhPE2rbPl3DIdFh1jlSdUirpwJSytYAubRueKhjg7NaGonO1bUtNntHaAAAAFHRSTlMAPncsHOudY9u618WShVHw6sqvypFNNF0AAAVnSURBVFjD5ZdpW9pAFIVNwiIiUJVgZmLIQhKRRYsLCsV9X9r+/3/Te+8MmfAARdQvfXqMmDC5L+eemcSw8o9Ly3wJJlNa1b6CUy6yb18AMnJZ/gUgo5Q1OQPQZzFrJnAAZHwqYx0wxGGrxicw+WKWOATKfHyqCEOcJmMF2WnpA1NljjmIWheBcX1JTh7DUX6aTV3kvmRUxmZWcYRy5JDrH7Gj/DBuiryWMqSRHRJhGOd0QIaWtiMNEUYdV7SlJ4vEEaIEB8XycnbmK5vLvGcpg52F2jTesZTN96ioLWprvh0vCoIg9lxJAk/lXGkeT5/LiepWFWXZgUBtZvDkNe2vflwvhk+PvATjBoiRsj1KvJhFd8VZuWtZWWXLTw/HqLCalhWJNy0Hxksz5kvkHNlTJUGKojzFtLNmTJrJayu6S8NWqqJWjRFNe0p7VcfF9OHMwDT1NCeXhVW2Rn6sqpVgakRy7RrJVyjim3Ww7Jmb6ZArkAz58WxFIQEpBEZyJGTZLnZMxKyRDsetYxw0pkDSR227lpYgebLlupktp2crFENuyhBtoG3YiCXfEOMB2sfc3VRIOuZmufQZe5OGiEEcf3+f/EiFIm0sK6moOcyk7FpxlBu0c3Z0fXAoUTVqyeQE8nguARV4KEH1FMfvDh8Pu4AB1YYXRxed3QMk+WTLxiBwfidB9WmQf3V9cdE5uSJQ7/ro7qjT2RnKqOTp9iQos8Ed9DgGiYy710dnR53dfg/8bF9dnP2Eg50DX06ciNTBv9MgDiAVzxBqr6F2iI6uXs/uTuDgWA6q023OdNUaQ4Anw5YpH77e3b1C7SFwGi+dx1+wv3PsJ2sJQSGEzlhezRrDqzuCeYgJRKzDztmvXag9aGw3Gt1OB/d3TvZFSOpzo2bqoWmdISDmtFbleq4Nd0/6WHtwCaAecPCgDyCUWEjcDR3eLGTUgmx6OAIgb9wa5AuFWHt82Wg0/BPYG4N8QQo4566LDwSJtG/chm4RZCWgF6SMQZcHtC9mzceVRHGDmluGAmW2GHTrAMhVoF5f1gIIQiJLJ1115WJzANrChFRITdeq2a4C0bRRZ/1ug9R7PD5+7In8fB8wtIR4pUwA1VszsmJIL6gqkH/Y3909fiHMNsj3t/HSo9aqpIglDwLKUtMDo64lp19cq/vdHhQTiEQc0PPvHwSqc27mJ0HGFj7+8AiHKUwiTQnfhEkbtM4JZLtc3oyUtC0GyQUEIhLdg6ZAorVR67c/DkmClIwigOiahQQESHIatJEEPrg9daokj/Fxa0o5aNghUHAzqCmSEgXkD0a3rYjubXuWyyrlmSCbQD8gghkp1VCDh5t2G5etaG3W45sOrdli/K19PkCO/KENSc/3o7dW+zQAPySH87XMFKhckSAI4bR1O7q3wEBi5nlw/3D+1gJM1E3+3waMb854cFzlPJTn3H9vt1u3N+ejhx+gh9H5zc1tq91un36PbWJgQHixMZW1UoHTOiJTVvB02gaYVJsgXuDIcAACqvPZj9w6rexEdhh7T0/fUU9eFIQJJJHH+frMZ3ToLSDb8gX9k+hIQpQgoTlflnOcgaW9PcBYSFFbut6Wr6FLt/15lmILXcyXPRZwONxkZ6tkwsRNlY5/EzmwxZzxDW3us3oBhkMqtGfLEQo9xhkENFfaBoPupsuV6rCFkckYK8znUEyMcS90ZLmqTwSLAmxztujriAbLElBBXQFSkCDycJixjfzi7zTrFcbQVhQH4RgQhkEceS7HAUxZBzuLVS7g+VTjSkF1om8FhVlkKp9bZVMi9mpB15b7hp1f36hMICqrGzk9b6wsr4xRzuv6Oqqk58uakVn5T/UHcaonOO1JaeYAAAAASUVORK5CYII=");
                            jSONObject.put("icon_uri", strM4138a);
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            return jSONArray.toString();
                        }
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e = e2;
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getHosts(int i) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorQuery = this.browserActivity.getContentResolver().query(BrowserProvider.uriHostList, DatabaseColumns.HOST_LIST, "host_type = ?", new String[]{i + ""}, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("host", cursorQuery.getString(cursorQuery.getColumnIndex("host")));
                        jSONArray.put(jSONObject);
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getImageResWithJson() {
        return VideoSniffingManager.getInstance().m7003m();
    }

    @JavascriptInterface
    public String getInstallInfo(String str, String str2) {
        return JSManager.getInstance().m8513R(str, str2);
    }

    @JavascriptInterface
    public int getIntPreference(String str) {
        SharedPreferencesHelper sharedPreferencesHelperM6833I;
        int i;
        if (str.equals("auto_backup_circle")) {
            sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
            i = 4;
        } else {
            sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
            i = 0;
        }
        return sharedPreferencesHelperM6833I.getInt(str, i);
    }

    @JavascriptInterface
    public String getItem(String str) {
        try {
            return C1199a3.getInstance().mo5091b(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "ErrorData";
        }
    }

    @JavascriptInterface
    public String getJsModuleListenerMethods() {
        return JSManager.getInstance().m8514S();
    }

    @JavascriptInterface
    public String getLastSelectUAId() {
        return DialogC0235F4.f635g;
    }

    @JavascriptInterface
    public String getLogs() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("event_log", DatabaseColumns.EVENT_LOG, null, null, null, null, "create_at DESC", null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        JSONObject jSONObject = new JSONObject();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("event_message"));
                        String strM8718z = AndroidSystemUtils.m8718z(cursorQuery.getLong(cursorQuery.getColumnIndex("create_at")));
                        jSONObject.put("event_message", string);
                        jSONObject.put("create_at", strM8718z);
                        jSONArray.put(jSONObject);
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getMenuConfig(String str) {
        return MenuConfigManager.getInstance().m7025g(str);
    }

    @JavascriptInterface
    public int getNavBarHeight() {
        return PhoneUtils.getInstance().getNavigationBarHeight();
    }

    @JavascriptInterface
    public String getProxyTotalReceived() {
        return AndroidSystemUtils.formatFileSize(C2439uo.getInstance().getUser().getDownloadFlow());
    }

    @JavascriptInterface
    public String getProxyTotalSend() {
        return AndroidSystemUtils.formatFileSize(C2439uo.getInstance().getUser().getUploadFlow());
    }

    @JavascriptInterface
    public String getQAWithJson() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("quick_access", DatabaseColumns.QUICK_ACCESS, "status>= ?", new String[]{"0"}, null, null, "item_order DESC");
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        JSONObject jSONObject = new JSONObject();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        jSONObject.put("id", AndroidSystemUtils.prefixWithMd5(string2));
                        jSONObject.put("title", string);
                        jSONObject.put("url", string2);
                        if (!string2.equals("x:add-qa")) {
                            jSONArray.put(jSONObject);
                        }
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public int getQaMaxOrder(String str) {
        return MySQLiteOpenHelper.getInstance().getMaxColumnValue(MySQLiteOpenHelper.getInstance().getReadableDatabase(), "quick_access", "item_order", str) + 1;
    }

    @JavascriptInterface
    public String getReadModeBgColor() {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("read_mode.bg", "rgb(255, 255, 255)");
        return (strM6871P.equals("rgb(255, 255, 255)") && SharedPreferencesHelper.getInstance().m6893f0()) ? AndroidSystemUtils.m8696d(SharedPreferencesHelper.getInstance().goodForEyeColor) : strM6871P;
    }

    @JavascriptInterface
    public int getReadModeZoom() {
        return SharedPreferencesHelper.getInstance().getInt("read_mode.zoom", 100);
    }

    @JavascriptInterface
    public String getResourceListWithJson(String str, String str2) {
        return VideoSniffingManager.getInstance().m7004o(str, str2);
    }

    @JavascriptInterface
    public String getRuleFiles() {
        ContentDataManager.getInstance().m6594U0();
        return ContentDataManager.getInstance().m6578M();
    }

    @JavascriptInterface
    public int getSdkLevel() {
        return Build.VERSION.SDK_INT;
    }

    @JavascriptInterface
    public String getSelectedOptionName(String str) {
        return C1224ai.getInstance().m5297m(str);
    }

    @JavascriptInterface
    public String getServiceUrl(String str) {
        return str.equals("destroy_account") ? ApiEndpointsManager.getInstance().getAccountDeletionEndpoint() : "";
    }

    @JavascriptInterface
    public String getSessionToken() {
        return C2439uo.getInstance().getUser().getUserToken();
    }

    @JavascriptInterface
    public String getSiteBindUATitle(String str) {
        return C1570e.getInstance().m6933B(str);
    }

    @JavascriptInterface
    public boolean getSiteSwitchState(String str, String str2) {
        return C1570e.getInstance().m6934C(str, str2);
    }

    @JavascriptInterface
    public String getSniffMediaResource() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("src", VideoSniffingManager.getInstance().m7000j().path);
            jSONObject.put("title", VideoSniffingManager.getInstance().m7000j().title);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getStartPageBg() {
        return this.browserActivity.m6274W0();
    }

    @JavascriptInterface
    public String getStartPageLogo() {
        String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath("start-page.logo", 9);
        if (FileUtils.fileExists(strM2046a)) {
            return FileUtils.readFileToString(strM2046a);
        }
        return null;
    }

    @JavascriptInterface
    public String getStringResource(String str) {
        Log.i("js-console", "resKey:" + str);
        try {
            return this.browserActivity.getString(((Integer) AbstractC2343sk.m9588b(AbstractC0627Nj.class, str)).intValue());
        } catch (Exception e) {
            e.printStackTrace();
            return "not-found-string-key";
        }
    }

    @JavascriptInterface
    public boolean getSwitchState(String str) {
        return getBooleanPreference(str);
    }

    @JavascriptInterface
    public String getSyncableResourceConf() {
        return SyncManager.getInstance().getSyncResourceConfig();
    }

    @JavascriptInterface
    public int getTextSize() {
        return SharedPreferencesHelper.getInstance().m6885Y();
    }

    @JavascriptInterface
    public String getToken() {
        return AbstractCryptoUtils.toMd5(C2439uo.getInstance().getUser().getUserId());
    }

    @JavascriptInterface
    public String getToolbarIconData() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("back", AndroidSystemUtils.m8672F(this.browserActivity, com.xbrowser.play.R.drawable.ic_arrow_left));
            jSONObject.put("forward", AndroidSystemUtils.m8672F(this.browserActivity, com.xbrowser.play.R.drawable.ic_arrow_right));
            jSONObject.put("menu", AndroidSystemUtils.m8672F(this.browserActivity, com.xbrowser.play.R.drawable.ic_menu));
            jSONObject.put("tabs", AndroidSystemUtils.m8672F(this.browserActivity, com.xbrowser.play.R.drawable.ic_muti_window));
            jSONObject.put("home", AndroidSystemUtils.m8672F(this.browserActivity, com.xbrowser.play.R.drawable.ic_home));
            jSONObject.put("refresh", AndroidSystemUtils.m8672F(this.browserActivity, com.xbrowser.play.R.drawable.ic_refresh_small));
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getToolbarLayoutSetting() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String strM6871P = SharedPreferencesHelper.getInstance().getString("search-bar-at-top.toolbar_layout", "layout_1");
            String strM6871P2 = SharedPreferencesHelper.getInstance().getString("search-bar-at-bottom.toolbar_layout", "layout_4");
            jSONObject.put("search-bar-at-top", strM6871P);
            jSONObject.put("search-bar-at-bottom", strM6871P2);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public int getTotalBlockAds(int i) {
        return MySQLiteOpenHelper.getInstance().getAdBlockHitCount(i);
    }

    @JavascriptInterface
    public int getTotalRules() {
        return ContentDataManager.getInstance().m6620i0();
    }

    @JavascriptInterface
    public String getTranLang() {
        return PhoneUtils.getInstance().getLanguageCode().equals("zh") ? PhoneUtils.getInstance().getLocaleCode() : PhoneUtils.getInstance().getLanguageCode();
    }

    @JavascriptInterface
    public String getUATitleByUaId(String str) {
        return SharedPreferencesHelper.getInstance().getUserAgentById(str).title;
    }

    @JavascriptInterface
    public String getUnlockPasswd() {
        return !m8760b() ? "{}" : SharedPreferencesHelper.getInstance().getString("unlock-password", "{}");
    }

    @JavascriptInterface
    public String getUserId() {
        return C2439uo.getInstance().getUser().getUserId();
    }

    @JavascriptInterface
    public String getUserInfo() {
        return C2439uo.getInstance().getUser().getResourceValue();
    }

    @JavascriptInterface
    public String getUserMarkRules(String str) {
        String strM6626l0 = ContentDataManager.getInstance().m6626l0(NetworkUtils.getDomain(str));
        JSONArray jSONArray = new JSONArray();
        try {
            if (!TextUtils.isEmpty(strM6626l0)) {
                for (String str2 : strM6626l0.split("#_mark_rule_div_#")) {
                    if (ContentDataManager.getInstance().m6649v0(str2)) {
                        jSONArray.put(new JSONObject(str2));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getUserNick() {
        return C2439uo.getInstance().getUser().getUserNick();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c9  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public String getUserQaItems(String r27) throws JSONException {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2107nf.getUserQaItems(java.lang.String):java.lang.String");
    }

    @JavascriptInterface
    public String getUserScriptByJson(String str) {
        return JSManager.getInstance().getUserScriptJson(str);
    }

    @JavascriptInterface
    public String getUserScriptListByJson() {
        return JSManager.getInstance().m8531e0();
    }

    @JavascriptInterface
    public int getVersionCode() {
        return PhoneUtils.getInstance().getVersionCode();
    }

    @JavascriptInterface
    public boolean hasCache(String str) {
        return C1039Wi.m4517p().m4524q(str);
    }

    @JavascriptInterface
    public boolean hasCustomHomePage() {
        return (SharedPreferencesHelper.getInstance().m6857H().equals("x:home") || SharedPreferencesHelper.getInstance().m6857H().equals("file:///android_asset/start-page/index.html")) ? false : true;
    }

    @JavascriptInterface
    public boolean hasFreePrivilegeFlow() {
        return C2439uo.getInstance().getUser().getLeftFlow() > 0;
    }

    @JavascriptInterface
    public boolean hasLogin() {
        return C2439uo.getInstance().m10206D();
    }

    @JavascriptInterface
    public boolean hasStartPageBg() {
        return C2439uo.getInstance().m10207E();
    }

    @JavascriptInterface
    public boolean hasUnlocked() {
        return SharedPreferencesHelper.getInstance().f4899d0;
    }

    @JavascriptInterface
    public boolean iconIsModify(String str) {
        return FileUtils.fileExists(ResourceCacheManager.getInstance().getUrlOrFilePath(str, 9));
    }

    @JavascriptInterface
    public void ignoreHttpsSecurityWarning(boolean z) {
        m8762d("ignore_security_warnings", !z);
        SharedPreferencesHelper.getInstance().putBoolean("ignore_security_warnings.change", true);
    }

    @JavascriptInterface
    @Deprecated
    public void importAdRule() {
        this.browserActivity.m6326i1();
    }

    @JavascriptInterface
    public void importAdRuleFromUrl(String str) {
        ContentDataManager.getInstance().m6630n0(str.trim());
    }

    @JavascriptInterface
    public void importBookmarkFromHtml() {
        this.browserActivity.openTextFilePicker();
    }

    @JavascriptInterface
    public boolean inChina() {
        return PhoneUtils.getInstance().isInChina();
    }

    @JavascriptInterface
    public boolean inDebugMode() {
        return false;
    }

    @JavascriptInterface
    public boolean inNightMode() {
        return SharedPreferencesHelper.getInstance().enterNightMode;
    }

    @JavascriptInterface
    public boolean inWhiteList(String str) {
        return ContentDataManager.getInstance().m6637q0(str);
    }

    @JavascriptInterface
    public boolean isAllowAutoFillOnDomain(String str) {
        return C1570e.getInstance().m6935D(str);
    }

    @JavascriptInterface
    public boolean isAllowCallApp(String str) {
        return C1570e.getInstance().m6936E(str);
    }

    @JavascriptInterface
    public boolean isAllowCookiesOnDomain(String str) {
        return C1570e.getInstance().m6937F(str);
    }

    @JavascriptInterface
    public boolean isAllowJsOnDomain(String str) {
        return C1570e.getInstance().m6938G(str);
    }

    @JavascriptInterface
    public boolean isAllowPullToSearch() {
        boolean z = !SharedPreferencesHelper.getInstance().disablePullToSearchGesture;
        if (SharedPreferencesHelper.getInstance().browserFullscreenMode && !SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
            return false;
        }
        return z;
    }

    @JavascriptInterface
    public boolean isAllowRequestLocation(String str) {
        return C1570e.getInstance().m6940I(str);
    }

    @JavascriptInterface
    public boolean isAllowRule(String str) {
        return ContentDataManager.getInstance().m6649v0(str);
    }

    @JavascriptInterface
    public boolean isAllowUserScriptOnDomain(String str) {
        return C1570e.getInstance().m6941J(str);
    }

    @JavascriptInterface
    public boolean isBlockThirdPartSite(String str) {
        return C1570e.getInstance().m6943L(str);
    }

    @JavascriptInterface
    public boolean isDefaultBrowser() {
        return AndroidSystemUtils.isDefaultBrowser(this.browserActivity);
    }

    @JavascriptInterface
    public boolean isDenyPermOnDomain(String str, String str2) {
        return C1570e.getInstance().m6944M(str, str2);
    }

    @JavascriptInterface
    public boolean isDisableADBOnDomain(String str) {
        return C1570e.getInstance().getHost(1, str) != null;
    }

    @JavascriptInterface
    public boolean isDisabledClipboard(String str) {
        return C1570e.getInstance().m6945N(str);
    }

    @JavascriptInterface
    public boolean isEnableDomainSmartAdb(String str) {
        boolean zM6947P = C1570e.getInstance().m6947P(str);
        ContentDataManager.getInstance().m6575K0();
        return zM6947P;
    }

    @JavascriptInterface
    public boolean isGooglePlayChannel() {
        return PhoneUtils.getInstance().isGooglePlayChannel();
    }

    @JavascriptInterface
    public boolean isInAdjustmentOderMode() {
        return this.browserActivity.uiLayoutMode == 2;
    }

    @JavascriptInterface
    public boolean isInDevToolSelectMode() {
        return this.browserActivity.uiLayoutMode == 1;
    }

    @JavascriptInterface
    public boolean isInMultiSelectMode() {
        return this.browserActivity.uiLayoutMode == 3;
    }

    @JavascriptInterface
    public boolean isLightStartPageTheme() {
        return this.browserActivity.m6314f1() ? SharedPreferencesHelper.getInstance().getBoolean("is_light_start_page_bg", false) : !SharedPreferencesHelper.getInstance().enterNightMode;
    }

    @JavascriptInterface
    public boolean isLogHisOnDomain(String str) {
        return C1570e.getInstance().m6946O(str);
    }

    @JavascriptInterface
    public void keepScreenOn(boolean z) {
        m8762d("keep-screen-on", z);
        SharedPreferencesHelper.getInstance().keepScreenOn = z;
        this.browserActivity.runOnUiThread(new RunnableC2736h(z));
    }

    @JavascriptInterface
    public void launchQrScan() {
        this.browserActivity.runOnUiThread(new m0());
    }

    @JavascriptInterface
    public String loadAutoFill(String str) {
        return C0600N1.getInstance().m3266o(str);
    }

    @JavascriptInterface
    public String loadDownloads() {
        return !m8760b() ? "" : BrowserDownloadManager.getInstance().m6704u();
    }

    @JavascriptInterface
    public String loadHideElementRule(String str, String str2) {
        JSONArray jSONArray;
        int i;
        boolean z;
        ArrayList arrayList;
        ArrayList arrayList2;
        String strSubstring = str;
        if (strSubstring.indexOf(":") > 0) {
            strSubstring = strSubstring.substring(0, strSubstring.indexOf(":"));
        }
        if (TextUtils.isEmpty(str2)) {
            return str2.equals("json") ? "[]" : "";
        }
        StringBuffer stringBuffer = null;
        if (str2.equals("css")) {
            stringBuffer = new StringBuffer();
            jSONArray = null;
        } else {
            if (!str2.equals("json")) {
                return str2.equals("json") ? "[]" : "";
            }
            jSONArray = new JSONArray();
        }
        if (!SharedPreferencesHelper.getInstance().activeAdBlock || TextUtils.isEmpty(strSubstring) || ContentDataManager.getInstance().m6637q0(strSubstring)) {
            return str2.equals("json") ? "[]" : "";
        }
        String strM458m = NetworkUtils.getDomain(strSubstring);
        ArrayList arrayListM6599X = ContentDataManager.getInstance().m6599X(strM458m);
        ArrayList arrayListM6599X2 = ContentDataManager.getInstance().m6599X(strSubstring);
        ArrayList arrayListM6599X3 = ContentDataManager.getInstance().m6599X("*");
        if (arrayListM6599X != null) {
            int i2 = 0;
            i = 0;
            z = true;
            while (i2 < arrayListM6599X.size()) {
                String str3 = (String) arrayListM6599X.get(i2);
                if (m8761c(str3)) {
                    arrayList2 = arrayListM6599X;
                } else {
                    arrayList2 = arrayListM6599X;
                    if (ContentDataManager.getInstance().m6649v0(str3 + "@" + strM458m) && ContentDataManager.getInstance().m6649v0(str3 + "@" + strSubstring)) {
                        if (!str2.equals("css")) {
                            jSONArray.put(str3);
                        } else if (z) {
                            stringBuffer.append(str3);
                            z = false;
                        } else {
                            stringBuffer.append(',');
                            stringBuffer.append(str3);
                        }
                    }
                    int i3 = i + 1;
                    if (str2.equals("css") && i3 > 0 && i3 % 1000 == 0) {
                        stringBuffer.append("{display:none !important;width: 0 !important; height: 0 !important;}");
                        stringBuffer.append("###-style-###");
                        i = i3;
                        z = true;
                    } else {
                        i = i3;
                    }
                }
                i2++;
                arrayListM6599X = arrayList2;
            }
        } else {
            i = 0;
            z = true;
        }
        if (arrayListM6599X2 != null) {
            int i4 = 0;
            while (i4 < arrayListM6599X2.size()) {
                String str4 = (String) arrayListM6599X2.get(i4);
                if (m8761c(str4)) {
                    arrayList = arrayListM6599X2;
                } else {
                    arrayList = arrayListM6599X2;
                    if (ContentDataManager.getInstance().m6649v0(str4 + "@" + strSubstring) && ContentDataManager.getInstance().m6649v0(str4 + "@" + strM458m)) {
                        if (!str2.equals("css")) {
                            jSONArray.put(str4);
                        } else if (z) {
                            stringBuffer.append(str4);
                            z = false;
                        } else {
                            stringBuffer.append(',');
                            stringBuffer.append(str4);
                        }
                    }
                    int i5 = i + 1;
                    if (str2.equals("css") && i5 > 0 && i5 % 1000 == 0) {
                        stringBuffer.append("{display:none !important;}");
                        stringBuffer.append("###-style-###");
                        i = i5;
                        z = true;
                    } else {
                        i = i5;
                    }
                }
                i4++;
                arrayListM6599X2 = arrayList;
            }
        }
        if (arrayListM6599X3 != null) {
            for (int i6 = 0; i6 < arrayListM6599X3.size(); i6++) {
                String str5 = (String) arrayListM6599X3.get(i6);
                if (!m8761c(str5)) {
                    if (ContentDataManager.getInstance().m6649v0(str5) && ContentDataManager.getInstance().m6649v0(str5 + "@" + strM458m) && ContentDataManager.getInstance().m6649v0(str5 + "@" + strSubstring)) {
                        if (!str2.equals("css")) {
                            jSONArray.put(str5);
                        } else if (z) {
                            stringBuffer.append(str5);
                            z = false;
                        } else {
                            stringBuffer.append(',');
                            stringBuffer.append(str5);
                        }
                    }
                    int i7 = i + 1;
                    if (str2.equals("css") && i7 > 0 && i7 % 1000 == 0) {
                        stringBuffer.append("{display:none !important;}");
                        stringBuffer.append("###-style-###");
                        i = i7;
                        z = true;
                    } else {
                        i = i7;
                    }
                }
            }
        }
        int i8 = i;
        if (!str2.equals("css")) {
            return jSONArray.toString();
        }
        if (stringBuffer.length() > 0 && i8 % 1000 != 0) {
            stringBuffer.append("{display:none !important;}");
        }
        return stringBuffer.toString();
    }

    @JavascriptInterface
    public void log(String str) {
        Log.i("jslog", str);
    }

    @JavascriptInterface
    public void logBlockOneAd(String str, String str2, String str3, int i) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ContentDataManager.getInstance().m6579M0(str, null, str2, str3, i);
    }

    @JavascriptInterface
    public void logHisOnDomain(String str, boolean z) {
        C1570e.getInstance().m6949R(str, z);
    }

    @JavascriptInterface
    public void makeAsDefaultBrowser(boolean z) {
        if (z) {
            new DialogC2744p(this.browserActivity, z).show();
        } else {
            AndroidSystemUtils.m8695c(this.browserActivity);
        }
    }

    @JavascriptInterface
    public void makeFollowSysDarkMode(boolean z) {
        SharedPreferencesHelper.getInstance().followSystemDarkMode = z;
        m8762d("follow-sys-dark-mode", z);
        this.browserActivity.runOnUiThread(new RunnableC2748t(z, (SharedPreferencesHelper.getInstance().f4915l0 & 48) == 32));
    }

    @JavascriptInterface
    public void modifyAvatar() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        intent.addCategory("android.intent.category.OPENABLE");
        this.browserActivity.startActivityForResult(intent, 67);
    }

    @JavascriptInterface
    public void modifyQaIcon(String str) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        intent.addCategory("android.intent.category.OPENABLE");
        this.browserActivity.m6200D2(str);
        this.browserActivity.startActivityForResult(intent, 64);
    }

    @JavascriptInterface
    public void newDir(String str) {
        C0801Ra.getInstance().m3806i(str);
    }

    @JavascriptInterface
    public void newExchangeCode() {
        this.browserActivity.runOnUiThread(new D(ApiEndpointsManager.getInstance().getUserExchangeCodeEndpoint() + "/send_code?user_id=" + C2439uo.getInstance().getUser().getUserId()));
    }

    @JavascriptInterface
    public void notifyBlockNumberAds(int i) {
        if (SharedPreferencesHelper.getInstance().showAdBlockToast) {
            ContentDataManager.getInstance().m6605a0();
            ContentDataManager.getInstance().f4571t += i;
        }
    }

    @JavascriptInterface
    public void notifyDetectVideoOrientation(String str) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) interfaceC1300b3).f4725y = str;
        }
    }

    @JavascriptInterface
    public void notifyDownloadLinkClicked(String str, String str2) {
        BrowserActivityDelegate.f4376j = str2;
    }

    @JavascriptInterface
    public void notifyFoundUserScript(String str) {
        JSManager.getInstance().m8565z0(str);
    }

    @JavascriptInterface
    public void notifyHasVideoTag(String str) {
        VideoSniffingManager.getInstance().m6990B(str);
    }

    @JavascriptInterface
    public void notifyLoadModuleFailed(String str) {
        this.browserActivity.onLoadModuleFailed(str);
    }

    @JavascriptInterface
    public void notifyParseContentFailed() {
        C1039Wi.m4517p().m4526s();
    }

    @JavascriptInterface
    public void notifySniffMediaRes(boolean z) {
        this.browserActivity.runOnUiThread(new O());
    }

    @JavascriptInterface
    public void notifyUnlocked(String str) {
        if (m8760b()) {
            SharedPreferencesHelper.getInstance().f4899d0 = true;
            if (str.equals("export-passwd-auto-fill")) {
                this.browserActivity.runOnUiThread(new o0());
            }
        }
    }

    @JavascriptInterface
    public void notifyVideoLoad(String str, int i) {
        VideoSniffingManager.getInstance().m7000j().f2130b = i;
        VideoSniffingManager.getInstance().m6990B(str);
    }

    @JavascriptInterface
    public void notifyVideoPaused() {
        VideoSniffingManager.getInstance().m7000j().f2129a = true;
    }

    @JavascriptInterface
    public void notifyVideoPlayed(String str, int i, int i2, int i3, String str2) {
        Log.i("sniff-video", ">>>>>> Play video>>>>>>> volume:" + i3);
        VideoSniffingManager.getInstance().m7000j().f2129a = false;
        VideoSniffingManager.getInstance().m7000j().f2130b = i;
        VideoSniffingManager.getInstance().m7000j().f2131c = i2;
        VideoSniffingManager.getInstance().m7000j().f2135g = i3;
        VideoSniffingManager.getInstance().m6990B(str);
    }

    @JavascriptInterface
    public void notifyVideoTimeUpdate(int i, int i2) {
        VideoSniffingManager.getInstance().m7000j().f2131c = i;
        VideoSniffingManager.getInstance().m7000j().f2130b = i2;
    }

    @JavascriptInterface
    public int numberOfBlocked() {
        return ContentDataManager.getInstance().f4572u;
    }

    @JavascriptInterface
    public void onDOMContentLoaded() {
        this.browserActivity.getHandler().postDelayed(new X(), 200L);
    }

    @JavascriptInterface
    public void onElementHitTest(String str) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return;
        }
        ((C0219Ep) ((WebViewBrowserController) interfaceC1300b3).m6770F0()).setHitTestData(str);
    }

    @JavascriptInterface
    public void onOuterCSSApplied() {
        this.browserActivity.getHandler().removeCallbacks(null);
        this.browserActivity.getHandler().postDelayed(new U(), 1500L);
    }

    @JavascriptInterface
    public void onSelectTextChange(String str) {
        this.browserActivity.runOnUiThread(new Y(str));
    }

    @JavascriptInterface
    public void onSubmitForm(String str) {
        C0600N1.getInstance().m3267p(str);
    }

    @JavascriptInterface
    public void onTouchEventElement() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return;
        }
        ((C0219Ep) ((WebViewBrowserController) interfaceC1300b3).m6770F0()).f556g = true;
        Log.i("third-app", ">>> i click button");
    }

    @JavascriptInterface
    public void openAutoProxySetting() {
        this.browserActivity.runOnUiThread(new RunnableC2754z());
    }

    @JavascriptInterface
    public void openDownload(String str) {
        BrowserDownloadManager.getInstance().m6709z(str);
    }

    @JavascriptInterface
    public void openDownloadDir() {
        if (SharedPreferencesHelper.getInstance().f4936w) {
            this.browserActivity.runOnUiThread(new B());
            return;
        }
        openLocalPage("x:sd?path=" + SharedPreferencesHelper.getInstance().m6878T() + "&sort=date");
    }

    @JavascriptInterface
    public void openFile(String str) {
        C0801Ra.getInstance().m3808k(str);
    }

    @JavascriptInterface
    public void openLocalPage(String str) {
        openLocalPage(str, true);
    }

    @JavascriptInterface
    public void openLoginOrProfile() {
        this.browserActivity.runOnUiThread(new F());
    }

    @JavascriptInterface
    public void openMarket() {
        this.browserActivity.runOnUiThread(new RunnableC2737i());
    }

    @JavascriptInterface
    public void openMarkingRules() {
        this.browserActivity.runOnUiThread(new RunnableC2753y());
    }

    @JavascriptInterface
    public void openPayQrCode(int i) {
        BrowserActivity browserActivity;
        String str;
        if (i == 0) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI"));
                intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
                intent.setFlags(335544320);
                intent.setAction("android.intent.action.VIEW");
                this.browserActivity.startActivity(intent);
                return;
            } catch (Exception unused) {
                browserActivity = this.browserActivity;
                str = "打开微信扫码失败，请手动打开";
            }
        } else {
            if (i != 1) {
                return;
            }
            try {
                this.browserActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp?saId=10000007")));
                return;
            } catch (Exception unused2) {
                browserActivity = this.browserActivity;
                str = "打开失败，请手动打开";
            }
        }
        Toast.makeText(browserActivity, str, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void openUrl(String str, int i, boolean z) {
        this.browserActivity.runOnUiThread(new E(str, i, z));
    }

    @JavascriptInterface
    public void openUrlOnNewTab(String str, int i) {
        this.browserActivity.runOnUiThread(new C(str, i));
    }

    @JavascriptInterface
    public void pauseDownload(String str) {
        BrowserDownloadManager.getInstance().m6676B(str);
    }

    @JavascriptInterface
    public void prepareCommitMarkedAd(int i, int i2) {
        ConfirmDialog q;
        BrowserActivity browserActivity;
        int i3;
        String string = this.browserActivity.getString(com.xbrowser.play.R.string.dlg_mark_title);
        if (i > 10) {
            q = new P(this.browserActivity);
            browserActivity = this.browserActivity;
            i3 = com.xbrowser.play.R.string.dlg_mark_too_many_hits;
        } else if (i != 0) {
            this.browserActivity.runOnUiThread(new T(i2));
            return;
        } else {
            q = new Q(this.browserActivity);
            browserActivity = this.browserActivity;
            i3 = com.xbrowser.play.R.string.dlg_mark_no_marked;
        }
        q.show(string, browserActivity.getString(i3));
    }

    @JavascriptInterface
    public void pull() {
        if (C2439uo.getInstance().m10206D()) {
            SyncManager.getInstance().m4828p(true);
        } else {
            openLoginOrProfile();
        }
    }

    @JavascriptInterface
    public void push() {
        if (C2439uo.getInstance().m10206D()) {
            SyncManager.getInstance().m4829q();
        } else {
            openLoginOrProfile();
        }
    }

    @JavascriptInterface
    public void pushToCache(String str, String str2, String str3) {
        C1039Wi.m4517p().m4529v(str, str2, str3);
    }

    @JavascriptInterface
    public void putBooleanPreference(String str, boolean z) {
        if (m8760b()) {
            if (str.equals("disable-gesture-in-video-fullscreen")) {
                SharedPreferencesHelper.getInstance().disableGestureInVideoFullscreen = z;
            }
            if (str.equals("disable-write-clipboard")) {
                SharedPreferencesHelper.getInstance().disableWriteClipboard = z;
            }
            if (str.equals("new-tab-at-bottom")) {
                SharedPreferencesHelper.getInstance().newTabAtBottom = z;
            }
            if (str.equals("disable-fast-scrolling-slider")) {
                SharedPreferencesHelper.getInstance().disableFastScrollingSlider = z;
            }
            if (str.equals("fullscreen-with-float-btn")) {
                SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn = z;
                if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                    C0848Sb c0848SbM4048n = C0848Sb.getInstance();
                    if (z) {
                        c0848SbM4048n.restorePosition();
                    } else {
                        c0848SbM4048n.hideFloatingButton();
                    }
                }
            }
            if (str.equals("disable-back-forward-gesture")) {
                SharedPreferencesHelper.getInstance().disableBackForwardGesture = z;
            }
            SharedPreferencesHelper.getInstance().putBoolean(str, z);
        }
    }

    @JavascriptInterface
    public void regPendingMethod(String str, String str2) {
        JSManager.getInstance().m8498J0(str, str2);
    }

    @JavascriptInterface
    public void reloadFrontPage() {
        this.browserActivity.refreshQuickAccessUI();
    }

    @JavascriptInterface
    public void remindMeWhenDownloadComplete(boolean z) {
        SharedPreferencesHelper.getInstance().remindWhenDownloadComplete = z;
        m8762d("remind-when-down-complete", z);
    }

    @JavascriptInterface
    public void removeAdRule(String str) {
        ContentDataManager.getInstance().m6602Y0(str);
    }

    @JavascriptInterface
    public void removeAllBookmarks() {
        if (m8760b()) {
            this.browserActivity.getContentResolver().delete(BrowserProvider.uriBookmark, null, null);
        }
    }

    @JavascriptInterface
    public void removeAllDownloads() {
        if (m8760b()) {
            new n0(this.browserActivity).show(this.browserActivity.getString(com.xbrowser.play.R.string.dlg_clean_download), this.browserActivity.getString(com.xbrowser.play.R.string.dlg_clean_download_confirm), this.browserActivity.getString(com.xbrowser.play.R.string.dlg_clean_downoad_file));
        }
    }

    @JavascriptInterface
    public void removeAllEventLogs() throws SQLException {
        MySQLiteOpenHelper.getInstance().m7496I();
    }

    @JavascriptInterface
    public void removeAutoFill(String str, String str2) {
        C0600N1.getInstance().m3268q(str, str2);
    }

    @JavascriptInterface
    public void removeBlockLogs() {
        if (m8760b()) {
            new t0(this.browserActivity).show(this.browserActivity.getString(com.xbrowser.play.R.string.dlg_clean_adb_log), this.browserActivity.getString(com.xbrowser.play.R.string.dlg_clean_adb_log_confirm));
        }
    }

    @JavascriptInterface
    public void removeCustomSearch(String str) throws JSONException {
        if (m8760b()) {
            String strM6871P = SharedPreferencesHelper.getInstance().getString("custom_search_urls", "");
            try {
                if (strM6871P.indexOf("[") < 0 || strM6871P.indexOf("{") < 0) {
                    return;
                }
                JSONArray jSONArray = new JSONArray(strM6871P);
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (!JsonUtils.getString(jSONObject, "id", "").equals(str)) {
                        jSONArray2.put(jSONObject);
                    }
                }
                addCustomSearches(jSONArray2.toString());
            } catch (Exception unused) {
            }
        }
    }

    @JavascriptInterface
    public void removeCustomUA(String str) throws JSONException {
        if (m8760b()) {
            String strM6871P = SharedPreferencesHelper.getInstance().getString("custom_ua", "");
            try {
                if (strM6871P.indexOf("[") < 0 || strM6871P.indexOf("{") < 0) {
                    return;
                }
                JSONArray jSONArray = new JSONArray(strM6871P);
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (!JsonUtils.getString(jSONObject, "id", "").equals(str)) {
                        jSONArray2.put(jSONObject);
                    }
                }
                addCustomUAString(jSONArray2.toString());
            } catch (Exception unused) {
            }
        }
    }

    @JavascriptInterface
    public void removeDomain(int i, String str) {
        if (m8760b()) {
            C1570e.getInstance().m6951T(i, str);
        }
    }

    @JavascriptInterface
    public void removeHosts(int i) {
        if (m8760b()) {
            new u0(this.browserActivity, i).show(this.browserActivity.getString(com.xbrowser.play.R.string.dlg_clean_data), this.browserActivity.getString(com.xbrowser.play.R.string.dlg_clean_data_confirm));
        }
    }

    @JavascriptInterface
    public void removeQaItem(String str) {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        Log.i("affect", "affect" + writableDatabase.update("quick_access", contentValues, "guid= ? ", new String[]{str}) + "  guid:" + str);
    }

    @JavascriptInterface
    public void renameFile(String str) {
        C0801Ra.getInstance().m3811n(str);
    }

    @JavascriptInterface
    public void requestVideoFullScreen() {
        this.browserActivity.runOnUiThread(new k0());
    }

    @JavascriptInterface
    public void resetSiteSettings(String str) {
        if (m8760b()) {
            C1570e.getInstance().m6952U(str);
            this.browserActivity.runOnUiThread(new RunnableC2740l());
        }
    }

    @JavascriptInterface
    public void restoreDefaultDownloader() {
        SharedPreferencesHelper.getInstance().putString("bind_default_downloader", "");
        SharedPreferencesHelper.getInstance().putString("default_downloader", "com.x.browser.downloader");
        showToast(this.browserActivity.getString(com.xbrowser.play.R.string.toast_reset_to_default_downloader));
    }

    @JavascriptInterface
    public void restroeUserData() {
        this.browserActivity.m6342n2();
    }

    @JavascriptInterface
    public void resumeDownload(String str) {
        BrowserDownloadManager.getInstance().m6682H(str);
    }

    @JavascriptInterface
    public void revertDefaultHomePage() {
        SharedPreferencesHelper.getInstance().m6861J0("file:///android_asset/start-page/index.html");
        this.browserActivity.updateTitle("native_call_update_set_home_btn()");
    }

    @JavascriptInterface
    public void revertIcon(String str) {
        FileUtils.deleteFile(ResourceCacheManager.getInstance().getUrlOrFilePath(str, 9));
        this.browserActivity.updateTitle("native_call_update_item('" + AndroidSystemUtils.prefixWithMd5(str) + "')");
    }

    @JavascriptInterface
    public void saveMenuConfig(String str, String str2) {
        MenuConfigManager.getInstance().m7040w(str, str2);
    }

    @JavascriptInterface
    public void saveSource(String str) {
        this.browserActivity.runOnUiThread(new M(str));
    }

    @JavascriptInterface
    public void saveSyncableResourceConf(String str) {
        SyncManager.getInstance().m4833u(str);
    }

    @JavascriptInterface
    public void saveText(String str) {
        this.browserActivity.runOnUiThread(new N(str));
    }

    @JavascriptInterface
    public boolean scriptInstalled(String str) {
        return JSManager.getInstance().m8504M0(str) != -1;
    }

    @JavascriptInterface
    public void selectDomainUA(String str) {
        new DialogC0235F4(this.browserActivity, str).show();
    }

    @JavascriptInterface
    public void sendExchangeCode(String str, int i) {
        new TextAreaDialog(this.browserActivity).m3828d("送你" + i + "M访问Google的特权流量\n兑换码:" + str, "X浏览器下载:http://www.xbext.com/?from=exchange", 1);
    }

    @JavascriptInterface
    public void sendLongPress(int i, int i2) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.browserActivity.getTabManager().m9316y();
        if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return;
        }
        this.browserActivity.runOnUiThread(new c0(interfaceC1300b3, i, i2));
    }

    @JavascriptInterface
    public void sendTouchEvent(int i, int i2) {
        this.browserActivity.getHandler().postDelayed(new d0(i, i2), 200L);
    }

    @JavascriptInterface
    public void setAutoBackupCycle() {
        this.browserActivity.runOnUiThread(new RunnableC2742n());
    }

    @JavascriptInterface
    public void setBackgroundPlay(String str, boolean z) {
        C1570e.getInstance().m6955X(str, z);
    }

    @JavascriptInterface
    public void setBrowserState(int i) {
        this.browserActivity.runOnUiThread(new l0(i));
    }

    @JavascriptInterface
    public void setConfigValue(String str, String str2) {
        if (str.equals("file_order") || str.equals("bm_order")) {
            SharedPreferencesHelper.getInstance().putString(str, str2);
        }
    }

    @JavascriptInterface
    public void setHomePage() {
        this.browserActivity.runOnUiThread(new I());
    }

    @JavascriptInterface
    public void setItem(String str, String str2) {
        try {
            C1199a3.getInstance().mo5092c(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("setItem error");
        }
    }

    @JavascriptInterface
    public void setProgressUrl(String str) {
        C1039Wi.m4517p().m4530w(str);
    }

    @JavascriptInterface
    public void setRecoveryTabsType() {
        this.browserActivity.runOnUiThread(new RunnableC2743o());
    }

    @JavascriptInterface
    public void setSiteSwitchState(String str, String str2, boolean z) throws JSONException {
        C1570e.getInstance().m6956Y(str, str2, z);
    }

    @JavascriptInterface
    public void setStartPageBg(String str) {
        FileUtils.writeBytesToFile(str.getBytes(), ResourceCacheManager.getInstance().getUrlOrFilePath("start-page.bg", 9));
        if (SharedPreferencesHelper.getInstance().enableImmersiveMode) {
            this.browserActivity.getHandler().postDelayed(new H(), 200L);
        }
    }

    @JavascriptInterface
    public void setStartPageLogo(String str) {
        FileUtils.writeBytesToFile(str.getBytes(), ResourceCacheManager.getInstance().getUrlOrFilePath("start-page.logo", 9));
    }

    @JavascriptInterface
    public void setSwitchState(String str, boolean z) {
        putBooleanPreference(str, z);
    }

    @JavascriptInterface
    public void setUnlockPasswd(String str) {
        if (m8760b()) {
            m8764f("unlock-password", str);
        }
    }

    @JavascriptInterface
    public void share(String str, String str2) throws Resources.NotFoundException {
        AndroidSystemUtils.share(this.browserActivity, str, str2, this.browserActivity.getResources().getString(com.xbrowser.play.R.string.choose_app));
    }

    @JavascriptInterface
    public void sharePage() {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("share_message", "");
        if (TextUtils.isEmpty(strM6871P)) {
            strM6871P = this.browserActivity.getString(com.xbrowser.play.R.string.recommand_title);
        }
        new TextAreaDialog(this.browserActivity).m3828d(strM6871P, ApiEndpointsManager.getInstance().getAppStoreUrl(), 0);
    }

    @JavascriptInterface
    public void shareResource(String str, String str2) {
        AndroidSystemUtils.share(BrowserActivity.getActivity(), str, str2, null, null, null);
    }

    @JavascriptInterface
    public void shareScript(String str, String str2) {
        JSManager.getInstance().m8506N0(str, this.browserActivity.getString(com.xbrowser.play.R.string.share_script_title) + "[" + str2 + "]");
    }

    @JavascriptInterface
    public void showAboutDialog() {
        new ViewOnClickListenerC2082n(this.browserActivity).show();
    }

    @JavascriptInterface
    public void showAdBlockToast(boolean z) {
        SharedPreferencesHelper.getInstance().showAdBlockToast = z;
        m8762d("show-ad-block-toast", z);
    }

    @JavascriptInterface
    public void showAddScriptMenu() {
        this.browserActivity.runOnUiThread(new RunnableC2730b());
    }

    @JavascriptInterface
    public boolean showAllowAccesLocationOption() {
        return PhoneUtils.getInstance().getChannelCode().equals("mi");
    }

    @JavascriptInterface
    public void showAutoFillContextMenu(String str) {
        this.browserActivity.runOnUiThread(new RunnableC2733e(str));
    }

    @JavascriptInterface
    public void showAutoFillToolMenu() {
        this.browserActivity.runOnUiThread(new RunnableC2732d());
    }

    @JavascriptInterface
    public void showBookMarkToolMenu(String str) {
        this.browserActivity.runOnUiThread(new RunnableC2747s(str));
    }

    @JavascriptInterface
    public void showConfirmDlgOnExit(boolean z) {
        SharedPreferencesHelper.getInstance().showExitConfirmDialog = z;
        m8762d("show-confirm-dlg-on-exit", z);
    }

    @JavascriptInterface
    public void showDownloadContextMenu(String str) {
        this.browserActivity.runOnUiThread(new RunnableC2731c(str));
    }

    @JavascriptInterface
    public void showFloatMessageBox(int i, String str) {
        this.browserActivity.runOnUiThread(new i0(str));
    }

    @JavascriptInterface
    public void showImportRuleFileMenu() {
        this.browserActivity.runOnUiThread(new RunnableC2729a());
    }

    @JavascriptInterface
    public void showResourceContextMenu(String str, String str2, String str3, String str4) {
        this.browserActivity.runOnUiThread(new RunnableC2746r(str, str2, str3, str4));
    }

    @JavascriptInterface
    public void showRuleFileContextMenu(String str) {
        this.browserActivity.runOnUiThread(new v0(str));
    }

    @JavascriptInterface
    public void showScriptContextMenu(String str, int i) {
        this.browserActivity.runOnUiThread(new e0(str));
    }

    @JavascriptInterface
    public void showSearchResOnNewTab(boolean z) {
        SharedPreferencesHelper.getInstance().openSearchInNewTab = z;
        m8762d("open-search-in-new-tab", z);
    }

    @JavascriptInterface
    public void showToast(String str) {
        String stringResource = getStringResource(str);
        if (!stringResource.equals("not-found-string-key")) {
            str = stringResource;
        }
        Toast.makeText(this.browserActivity, str, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void startNewPreload(String str) {
        C1039Wi.m4517p().m4531x(str);
    }

    @JavascriptInterface
    public String string2MD5(String str) {
        return AbstractCryptoUtils.toMd5(str);
    }

    @JavascriptInterface
    public void supportInstanTran(boolean z) {
        SharedPreferencesHelper.getInstance().setSupportInstantTranslate(z);
    }

    @JavascriptInterface
    public void supportQuickGesture(boolean z) {
        m8762d("support-quick-gesture", z);
        SharedPreferencesHelper.getInstance().supportQuickGesture = z;
    }

    @JavascriptInterface
    public void supportSuperCache(boolean z) {
        SharedPreferencesHelper.getInstance().supportSuperCache = z;
        m8762d("support-super-cache", z);
        if (z) {
            return;
        }
        Toast.makeText(this.browserActivity, com.xbrowser.play.R.string.toast_disable_supper_cache, Toast.LENGTH_LONG).show();
    }

    @JavascriptInterface
    public void supportSwitchTabGesture(boolean z) {
        m8762d("support-switch-tab-gesture", z);
        SharedPreferencesHelper.getInstance().supportSwitchTabGesture = z;
    }

    @JavascriptInterface
    public void supportTouchScreenPageDown(boolean z) {
        m8762d("support-touch-page-down", z);
        SharedPreferencesHelper.getInstance().supportTouchPageDown = z;
    }

    @JavascriptInterface
    public void supportVolumeKeyPageDown(boolean z) {
        m8762d("support-volume-page-down", z);
        SharedPreferencesHelper.getInstance().supportVolumePageDown = z;
    }

    @JavascriptInterface
    public void test() {
        this.browserActivity.runOnUiThread(new s0());
    }

    @JavascriptInterface
    public boolean toolbarIsShowing() {
        return this.browserActivity.getBrowserFrameLayout().m6458g();
    }

    @JavascriptInterface
    public void totalBookmarkDeleted(int i) {
        if (i > 0) {
            Toast.makeText(this.browserActivity, String.format(this.browserActivity.getString(com.xbrowser.play.R.string.toast_total_bm_deleted), i + ""), Toast.LENGTH_SHORT).show();
        }
    }

    @JavascriptInterface
    public void tryApp(String str, String str2) {
        if (AndroidSystemUtils.isAppInstalled(this.browserActivity, str)) {
            Toast.makeText(this.browserActivity, "App has already installed", Toast.LENGTH_SHORT).show();
            return;
        }
        m8762d("wait_for_try_app", true);
        m8764f("try_app_package", str);
        this.browserActivity.runOnUiThread(new J(str2));
    }

    @JavascriptInterface
    public void unBindUser() {
        C2439uo.getInstance().m10218P();
    }

    @JavascriptInterface
    public void uninstallScript(String str) {
        JSManager.getInstance().m8500K0(str);
        this.browserActivity.updateTitle("nav_call_update_btn_state('" + str + "')");
        showToast(this.browserActivity.getString(com.xbrowser.play.R.string.toast_script_removed));
    }

    @JavascriptInterface
    public void unlockSuccess() {
        SharedPreferencesHelper.getInstance().f4899d0 = true;
    }

    @JavascriptInterface
    public void unlockToViewHis(boolean z) {
        m8762d("unlock-to-view-his", z);
    }

    @JavascriptInterface
    public void updateAdRule(String str, String str2) {
        ContentDataManager.getInstance().m6631n1(str, str2);
    }

    @JavascriptInterface
    public void updateAutoFill(String str) {
        C0600N1.getInstance().m3275x(str);
    }

    @JavascriptInterface
    public void updateBrowserLayout(String str) {
        if (!str.equals(getBrowserLayoutType())) {
            this.browserActivity.m6312e3(str);
        }
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }

    @JavascriptInterface
    public void updateCurrentElementCanHScroll(boolean b) {
        SharedPreferencesHelper.getInstance().canHScroll = b;
    }

    @JavascriptInterface
    public void updateCurrentElementCanVScroll(boolean b) {
        SharedPreferencesHelper.getInstance().canVScroll = b;
    }

    @JavascriptInterface
    public void updateNextUrlForActivePage(String str) {
        C1039Wi.m4517p().m4532y(str);
    }

    @JavascriptInterface
    public void updateOrNewQa(String str) throws Resources.NotFoundException, SQLException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.browserActivity.m6316f3(JsonUtils.getString(jSONObject, "id", ""), JsonUtils.getString(jSONObject, "title", ""), JsonUtils.getString(jSONObject, "url", ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void updateOrNewUserScript(String str) {
        try {
            JSManager.getInstance().m8510P0(str, "local");
        } catch (Exception unused) {
            this.browserActivity.showToast(this.browserActivity.getString(com.xbrowser.play.R.string.toast_install_script_failed));
        }
    }

    @JavascriptInterface
    public void updateReadModeZoom(int i) {
        m8763e("read_mode.zoom", i);
    }

    @JavascriptInterface
    public void updateToolbarLayout(String str, String str2) {
        try {
            if ("search-bar-at-top.toolbar_layout".startsWith(str)) {
                SharedPreferencesHelper.getInstance().putString("search-bar-at-top.toolbar_layout", str2);
            } else if ("search-bar-at-bottom.toolbar_layout".startsWith(str)) {
                SharedPreferencesHelper.getInstance().putString("search-bar-at-bottom.toolbar_layout", str2);
            }
            this.browserActivity.runOnUiThread(new G());
        } catch (Exception unused) {
        }
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }

    @JavascriptInterface
    public void updateUserQaItems(String str) {
        String str2;
        String str3 = "";
        String str4 = "title";
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        String string = this.browserActivity.getString(com.xbrowser.play.R.string.web_str_title_folder);
        try {
            try {
                JSONArray jSONArray = new JSONArray(str);
                writableDatabase.beginTransaction();
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string2 = jSONObject.getString("id");
                    String strM3666k = JsonUtils.getString(jSONObject, "parent", "root");
                    String strM3666k2 = JsonUtils.getString(jSONObject, "type", "0");
                    JSONObject jSONObjectM3662g = JsonUtils.getJSONObject(jSONObject, "extra");
                    String strM3666k3 = JsonUtils.getString(jSONObject, str4, str3);
                    String strM3666k4 = JsonUtils.getString(jSONObject, "icon_uri", str3);
                    String string3 = jSONObjectM3662g != null ? jSONObjectM3662g.toString() : null;
                    String str5 = str3;
                    int i2 = jSONObject.getInt("order");
                    String[] strArr = {string2};
                    String str6 = string;
                    ContentValues contentValues = new ContentValues();
                    JSONArray jSONArray2 = jSONArray;
                    if (Integer.parseInt(strM3666k2) == 1) {
                        str2 = TextUtils.isEmpty(strM3666k3) ? str6 : strM3666k3;
                        contentValues.put(str4, str2);
                    } else {
                        str2 = strM3666k3;
                    }
                    contentValues.put("parent", strM3666k);
                    String str7 = str4;
                    contentValues.put("item_order", Integer.valueOf(i2));
                    contentValues.put("icon_uri", strM3666k4);
                    contentValues.put("status", (Integer) 1);
                    if (!TextUtils.isEmpty(string3)) {
                        contentValues.put("extra", string3);
                    }
                    Log.i("affect", "id:" + writableDatabase.update("quick_access", contentValues, "guid= ?", strArr) + " guid:" + string2 + " new-order:" + i2 + " parent:" + strM3666k + " title:" + str2);
                    i++;
                    str4 = str7;
                    str3 = str5;
                    string = str6;
                    jSONArray = jSONArray2;
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
            writableDatabase.endTransaction();
            SyncManager.getInstance().getResourceManager("syncable_quick_access").incrementVersion();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    @JavascriptInterface
    public void usePublicDownloadDir(boolean z) {
        SharedPreferencesHelper.getInstance().f4936w = z;
        m8762d("use-public-download-dir", z);
    }

    @JavascriptInterface
    public boolean viewInDesktopMode(String str) {
        return C1570e.getInstance().m6959a0(str);
    }

    @JavascriptInterface
    public void zoomCurrentPage(boolean z) {
        this.browserActivity.runOnUiThread(new b0(z));
    }

    @JavascriptInterface
    public void zoomIn() {
        int iM6885Y = SharedPreferencesHelper.getInstance().m6885Y();
        if (iM6885Y > 50) {
            SharedPreferencesHelper.getInstance().applyTextSize(iM6885Y - 25);
        } else {
            Toast.makeText(this.browserActivity, "can't adjuest more small", Toast.LENGTH_SHORT).show();
        }
        this.browserActivity.m6280X2();
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }

    @JavascriptInterface
    public void zoomOut() {
        int iM6885Y = SharedPreferencesHelper.getInstance().m6885Y();
        if (iM6885Y < 200) {
            SharedPreferencesHelper.getInstance().applyTextSize(iM6885Y + 25);
        } else {
            Toast.makeText(this.browserActivity, "can't adjuest more big", Toast.LENGTH_SHORT).show();
        }
        this.browserActivity.m6280X2();
    }

    @JavascriptInterface
    public void importAdRule(String str) {
        BrowserActivity browserActivity;
        Runnable h0Var;
        ContentDataManager.Rule ruleVarM6614F0 = ContentDataManager.getInstance().m6614f0(str);
        if (ruleVarM6614F0 == null) {
            ContentDataManager.getInstance().m6630n0(str);
            browserActivity = this.browserActivity;
            h0Var = new h0();
        } else if (ruleVarM6614F0.status != 3) {
            browserActivity = this.browserActivity;
            h0Var = new f0();
        } else {
            ruleVarM6614F0.status = -1;
            ContentDataManager.getInstance().m6630n0(str);
            browserActivity = this.browserActivity;
            h0Var = new g0();
        }
        browserActivity.runOnUiThread(h0Var);
    }

    @JavascriptInterface
    public void openLocalPage(String str, boolean z) {
        this.browserActivity.runOnUiThread(new A(str, z));
    }

    public class O implements Runnable {
        public O() {
        }

        @Override
        public void run() {
        }
    }

    public class P extends ConfirmDialog {

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() {
                C2107nf.this.browserActivity.m6377y0();
            }
        }

        public P(Context context) {
            super(context);
        }

        @Override
        public void onOK() {
            C2107nf.this.browserActivity.updateTitle("commit_marked_targets()");
            C2107nf.this.browserActivity.runOnUiThread(new a());
        }

        @Override
        public void onCancel() {
        }
    }

    public class Q extends ConfirmDialog {

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() {
                C2107nf.this.browserActivity.m6377y0();
            }
        }

        public Q(Context context) {
            super(context);
        }

        @Override
        public void onOK() {
            C2107nf.this.browserActivity.runOnUiThread(new a());
        }

        @Override
        public void onCancel() {
        }
    }

    public class n0 extends ConfirmDialog {
        public n0(Context context) {
            super(context);
        }

        @Override
        public void onOK() {
            CheckBox checkBox = (CheckBox) findViewById(com.xbrowser.play.R.id.another_condition);
            BrowserDownloadManager.getInstance().m6678D(checkBox != null && checkBox.isChecked());
            C2107nf.this.browserActivity.updateTitle("native_call_clearDownloads()");
        }

        @Override
        public void onCancel() {
        }
    }

    public class t0 extends ConfirmDialog {
        public t0(Context context) {
            super(context);
        }

        @Override
        public void onOK() {
            ContentDataManager.getInstance().m6568H();
            C2107nf.this.browserActivity.updateTitle("native_call_clear_adb_logs()");
        }

        @Override
        public void onCancel() {
        }
    }

    public class u0 extends ConfirmDialog {

        public final int f6435f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(Context context, int i) {
            super(context);
            this.f6435f = i;
        }

        @Override
        public void onOK() {
            C1570e.getInstance().m6953V(this.f6435f);
        }

        @Override
        public void onCancel() {
        }
    }

    @JavascriptInterface
    public void closeCurrentPage() {
    }

    @JavascriptInterface
    public void notifyReadModeAvailable() {
    }

    @JavascriptInterface
    public void onPageLoaded() {
    }

    @JavascriptInterface
    public void GM_closeStream(String str) {
    }

    @JavascriptInterface
    public void downloadImage(String str) {
    }

    @JavascriptInterface
    public void enterFullScreenMode(boolean z) {
    }

    @JavascriptInterface
    public void foundAudioTag(String str) {
    }

    @JavascriptInterface
    public void foundVideoTag(String str) {
    }

    @JavascriptInterface
    public void notifyLockAd(boolean z) {
    }

    @JavascriptInterface
    public void preload(String str) {
    }

    @JavascriptInterface
    public void updateReadModeBg(String str) {
    }

    @JavascriptInterface
    public void openApp(String str, String str2) {
    }

    @JavascriptInterface
    public void testLoadMore(String str, String str2, String str3, String str4) {
    }
}
