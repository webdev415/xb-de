package com.mmbox.xbrowser;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import p000.AndroidSystemUtils;
import p000.C0010A9;
import p000.C0056B9;
import p000.SyncTagQuickAccessManager;
import p000.SyncTagSettingManager;
import p000.C0396Ii;
import p000.ResourceCacheManager;
import p000.ApiEndpointsManager;
import p000.C0721Pl;
import p000.C0830S2;
import p000.C0834S6;
import p000.SyncManager;
import p000.C1831hg;
import p000.C1949k4;
import p000.C2062mg;
import p000.C2138o9;
import p000.C2151od;
import p000.C2185p9;
import p000.C2222q0;
import p000.C2244qd;
import p000.C2275r7;
import p000.C2366t6;
import p000.C2369t9;
import p000.UserResourceManager;
import p000.C2415u9;
import p000.C2439uo;
import p000.C2452v0;
import p000.C2461v9;
import p000.C2480vj;
import p000.C2531wo;
import p000.C2553x9;
import p000.C2577xo;
import p000.C2645z9;

public class Browser extends Application {

    public static Browser f4236a;

    public static Context m6161a() {
        return f4236a;
    }

    public final void m6162b() {
    }

    public final void m6163c() {
        C2275r7.m9348e().m9353f(this);
        C2645z9 c2645z9 = new C2645z9();
        c2645z9.m9088l("browser.qa");
        C2275r7.m9348e().m9358k(c2645z9);
        C0056B9 c0056b9 = new C0056B9();
        c0056b9.m9088l("browser.sug.topsite");
        C2275r7.m9348e().m9358k(c0056b9);
        C2461v9 c2461v9 = new C2461v9();
        c2461v9.m9088l("browser.conf");
        C2275r7.m9348e().m9358k(c2461v9);
        C2415u9 c2415u9 = new C2415u9();
        c2415u9.m9088l("browser.cmd");
        C2275r7.m9348e().m9358k(c2415u9);
        C2138o9 c2138o9 = new C2138o9();
        c2138o9.m9088l("browser.ad_rule");
        C2275r7.m9348e().m9358k(c2138o9);
        C2369t9 c2369t9 = new C2369t9();
        c2369t9.m9088l("browser.blacklist");
        C2275r7.m9348e().m9358k(c2369t9);
        C2275r7.m9348e().m9358k(new C0010A9());
        C2275r7.m9348e().m9358k(new C2553x9());
        C2275r7.m9348e().m9358k(new C2185p9());
        m6165e();
    }

    public final void m6164d() {
    }

    public final void m6165e() {
        BrowserReceiver browserReceiver = new BrowserReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(browserReceiver, intentFilter, 4);
        } else {
            registerReceiver(browserReceiver, intentFilter);
        }
    }

    public final void m6166f() {
        SyncManager.getInstance().m4832t(new UserResourceManager("syncable_user_info"));
        SyncManager.getInstance().m4832t(new SyncTagQuickAccessManager("syncable_quick_access"));
        SyncManager.getInstance().m4832t(new C0830S2("syncable_bookmark"));
        SyncManager.getInstance().m4832t(new C2222q0("syncable_ad_rule"));
        SyncManager.getInstance().m4832t(new C2244qd("syncable_host"));
        SyncManager.getInstance().m4832t(new C2151od("syncable_history"));
        SyncManager.getInstance().m4832t(new C0721Pl("syncable_setting"));
        SyncManager.getInstance().m4832t(new C2062mg("syncable_menu"));
        SyncManager.getInstance().m4832t(new SyncTagSettingManager("syncable_tool_menu"));
        SyncManager.getInstance().m4832t(new C2366t6("syncable_context_menu"));
        SyncManager.getInstance().m4832t(new C2531wo("syncable_user_script"));
        SyncManager.getInstance().m4832t(new C2577xo("syncable_user_tabs"));
        SyncManager.getInstance().m4832t(new C0396Ii("syncable_passwd_autofill"));
        SyncManager.getInstance().m4832t(new C2452v0("syncable_addr_autofill"));
        SyncManager.getInstance().m4832t(new C1949k4("syncable_card_autofill"));
    }

    public final void m6167g() {
    }

    @Override
    public void onCreate() throws Throwable {
        super.onCreate();
        AndroidSystemUtils.startTiming("Browser APP Create");
        C0834S6.m4012a().m4013b(this);
        SharedPreferencesHelper.getInstance().m6895g0(this);
        m6164d();
        ApiEndpointsManager.getInstance().setContext(this);
        m6163c();
        C1831hg.m7836c().m7839d(this, ApiEndpointsManager.getInstance().getServiceHashEndpoint());
        m6162b();
        m6166f();
        C2439uo.getInstance().m10209G(this);
        Log.i("find-bug", "Browser onCreate >>>>>>>>>>>>>>>>>>>>>>>>>");
        ResourceCacheManager.getInstance().m2053i();
        m6167g();
        C2480vj.getInstance().m10379o(this);
        f4236a = this;
        SharedPreferencesHelper.getInstance().m6912p();
        AndroidSystemUtils.logElapsedTime();
    }
}
