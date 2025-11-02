package p000;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.C1539a;
import com.mmbox.xbrowser.C1541c;
import com.mmbox.xbrowser.C1570e;
import com.mmbox.xbrowser.C1572g;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.xbrowser.play.R;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C0074Bi implements InterfaceC0028Ai {

    public BrowserActivity f178a;

    public String f179b = null;

    public class d implements Runnable {
        public d() {
        }

        @Override
        public void run() throws URISyntaxException {
            C0074Bi.this.f178a.m6307d2(C2439uo.getInstance().m10235v());
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override
        public void run() {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", "com.google.android.webview", null));
            C0074Bi.this.f178a.startActivity(intent);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override
        public void run() {
            Intent intent = new Intent();
            intent.setAction("com.android.webview.SHOW_DEV_UI");
            intent.setClassName("com.google.android.webview", "org.chromium.android_webview.devui.MainActivity");
            C0074Bi.this.f178a.startActivity(intent);
        }
    }

    public class g extends AbstractDialogC0537Ll {
        public g(BrowserActivity browserActivity) {
            super(browserActivity);
        }

        @Override
        public void mo317b() {
            AndroidSystemUtils.m8687U(C0074Bi.this.f178a, true);
        }
    }

    public C0074Bi(BrowserActivity browserActivity) {
        this.f178a = browserActivity;
    }

    @Override
    public void mo135a(JSONObject jSONObject) throws JSONException, Resources.NotFoundException, URISyntaxException, IOException {
        Dialog dialogC2666zl;
        Dialog dialogInterfaceOnDismissListenerC0097C4;
        String strM3665j = JsonUtils.getString(jSONObject, "transId");
        if (TextUtils.isEmpty(strM3665j)) {
            throw new IllegalArgumentException("transId is empty");
        }
        if (!strM3665j.equals("change_auto_update_cycle")) {
            if (strM3665j.equals("change_search_engine")) {
                dialogC2666zl = new DialogInterfaceOnDismissListenerC0189E4(this.f178a);
            } else if (strM3665j.equals("change_downloader")) {
                dialogC2666zl = new DialogInterfaceOnDismissListenerC2226q4(this.f178a);
            } else if (strM3665j.equals("change_tab_revert_way")) {
                dialogC2666zl = new DialogInterfaceOnDismissListenerC1974kk(this.f178a);
            } else if (strM3665j.equals("change_domain_ua")) {
                dialogInterfaceOnDismissListenerC0097C4 = new DialogC0235F4(this.f178a, JsonUtils.getString(jSONObject, "data-host"));
            } else if (strM3665j.equals("change_language")) {
                dialogC2666zl = new DialogInterfaceOnDismissListenerC2318s4(this.f178a);
            } else if (strM3665j.equals("change_gesture_bind_action")) {
                dialogInterfaceOnDismissListenerC0097C4 = new DialogC2272r4(this.f178a, JsonUtils.getString(jSONObject, "data-option-group-name"));
            } else if (strM3665j.equals("change_script_execute_mode")) {
                dialogInterfaceOnDismissListenerC0097C4 = new DialogInterfaceOnDismissListenerC0097C4(this.f178a, JsonUtils.getString(jSONObject, "data-execute-mode"));
            } else {
                if (strM3665j.equals("reset_menu_config")) {
                    C1572g.getInstance().m7038u();
                    return;
                }
                if (strM3665j.equals("set_as_default_browser")) {
                    dialogC2666zl = new g(this.f178a);
                } else {
                    if (strM3665j.equals("import_rule_file")) {
                        this.f178a.m6218I0().mo6415X();
                        return;
                    }
                    if (strM3665j.equals("import_rule_from_url")) {
                        C1539a.getInstance().m6630n0(JsonUtils.getString(jSONObject, "url").trim());
                        return;
                    }
                    if (strM3665j.equals("export_ad_rules")) {
                        C1539a.getInstance().m6584P();
                        return;
                    }
                    if (strM3665j.equals("clean_adblock_logs")) {
                        new h(this.f178a).m5643d(this.f178a.getString(R.string.dlg_clean_adb_log), this.f178a.getString(R.string.dlg_clean_adb_log_confirm));
                        return;
                    }
                    if (strM3665j.equals("clean_user_privacy_data")) {
                        this.f178a.m6313f0();
                        return;
                    }
                    if (strM3665j.equals("show_rule_file_menu")) {
                        this.f178a.m6218I0().mo6421c0(JsonUtils.getString(jSONObject, "sourceUrl"));
                        return;
                    }
                    if (strM3665j.equals("show_auto_fill_menu")) {
                        this.f178a.m6218I0().mo6410S();
                        return;
                    }
                    if (strM3665j.equals("show_new_script_menu")) {
                        this.f178a.m6218I0().mo6407P();
                        C2061mf.m8471f0().executionPoint = null;
                        return;
                    }
                    if (strM3665j.equals("show_user_script_menu")) {
                        this.f178a.m6218I0().mo6423d0(JsonUtils.getString(jSONObject, "data-script-id"));
                        return;
                    }
                    if (strM3665j.equals("export_passwd_auto_fill")) {
                        C0600N1.m3257k().m3260h();
                        return;
                    }
                    if (strM3665j.equals("export_files")) {
                        C2439uo.getInstance().m10233t(this.f178a.getExternalFilesDir("").getAbsolutePath() + File.separator + JsonUtils.getString(jSONObject, "currentPath"));
                        return;
                    }
                    if (strM3665j.equals("clean_history")) {
                        m310d();
                        return;
                    }
                    if (strM3665j.equals("remove_history_items")) {
                        MySQLiteOpenHelper.getInstance().m7493F0(JsonUtils.getJsonArray(jSONObject, "urls"));
                        return;
                    }
                    if (strM3665j.equals("remove_bookmark_items")) {
                        MySQLiteOpenHelper.getInstance().m7490D0(JsonUtils.getJsonArray(jSONObject, "urls"));
                        return;
                    }
                    if (strM3665j.equals("show_bookmark_menu")) {
                        this.f178a.m6218I0().mo6412U(JsonUtils.getString(jSONObject, "path"));
                        return;
                    }
                    if (strM3665j.equals("update_bookmark_item_order")) {
                        MySQLiteOpenHelper.getInstance().m7499J0(JsonUtils.getJsonArray(jSONObject, "bookmarks"));
                        return;
                    }
                    if (strM3665j.equals("cut_bookmark_items")) {
                        JSONArray jSONArrayM3661f = JsonUtils.getJsonArray(jSONObject, "urls");
                        for (int i = 0; i < jSONArrayM3661f.length(); i++) {
                            WebViewBrowserController.f4699O.add(jSONArrayM3661f.optString(i));
                        }
                        return;
                    }
                    if (strM3665j.equals("backup_user_data")) {
                        C2439uo.getInstance().m10223j(true, "");
                        return;
                    }
                    if (strM3665j.equals("recover_user_data")) {
                        this.f178a.m6342n2();
                        return;
                    }
                    if (strM3665j.equals("auto_backup_user_data")) {
                        dialogC2666zl = new DialogInterfaceOnDismissListenerC0554M1(this.f178a);
                    } else {
                        if (strM3665j.equals("import_bookmark")) {
                            this.f178a.m6329j1();
                            return;
                        }
                        if (strM3665j.equals("export_bookmark")) {
                            C2439uo.getInstance().m10232s();
                            return;
                        }
                        if (!strM3665j.equals("select_sync_item")) {
                            if (strM3665j.equals("push_user_data")) {
                                if (C2439uo.getInstance().m10206D()) {
                                    C1199a3.m5090f().m5093d("event_app_to_page", "push_user_data_start");
                                    C1089Xm.getInstance().m4829q();
                                    return;
                                }
                            } else if (strM3665j.equals("pull_user_data")) {
                                if (C2439uo.getInstance().m10206D()) {
                                    C1199a3.m5090f().m5093d("event_app_to_page", "pull_user_data_start");
                                    C1089Xm.getInstance().m4828p(true);
                                    return;
                                }
                            } else if (!strM3665j.equals("open_login_or_profile")) {
                                if (strM3665j.equals("open_user_script_help")) {
                                    this.f178a.m6279X1("x:ush");
                                    return;
                                }
                                if (strM3665j.equals("open_file")) {
                                    String strM3665j2 = JsonUtils.getString(jSONObject, "data-file-name");
                                    if (TextUtils.isEmpty(strM3665j2)) {
                                        return;
                                    }
                                    C0801Ra.m3798f().m3808k(strM3665j2);
                                    return;
                                }
                                if (strM3665j.equals("new_file_dir")) {
                                    C0801Ra.m3798f().m3806i(JsonUtils.getString(jSONObject, "path"));
                                    return;
                                }
                                if (strM3665j.equals("show_resource_menu")) {
                                    this.f178a.m6218I0().mo6420b0(JsonUtils.getString(jSONObject, "url"), JsonUtils.getString(jSONObject, "id"), JsonUtils.getString(jSONObject, "host"), JsonUtils.getString(jSONObject, "type", ""));
                                    return;
                                }
                                if (strM3665j.equals("show_download_menu")) {
                                    this.f178a.m6218I0().mo6413V(JsonUtils.getString(jSONObject, "downloadId"));
                                    return;
                                }
                                if (strM3665j.equals("pause_download")) {
                                    C1541c.m6674q().m6676B(JsonUtils.getString(jSONObject, "downloadId"));
                                    return;
                                }
                                if (strM3665j.equals("resume_download")) {
                                    C1541c.m6674q().m6681G(JsonUtils.getString(jSONObject, "downloadId"));
                                    return;
                                }
                                if (strM3665j.equals("open_download")) {
                                    C1541c.m6674q().m6709z(JsonUtils.getString(jSONObject, "downloadId"));
                                    return;
                                }
                                if (strM3665j.equals("remove_downloads")) {
                                    m311e();
                                    return;
                                }
                                if (strM3665j.equals("open_download_dir")) {
                                    this.f178a.m6374x1();
                                    return;
                                }
                                if (strM3665j.equals("check_update")) {
                                    return;
                                }
                                if (strM3665j.equals("share_to_friend")) {
                                    String strM6871P = SharedPreferencesHelper.getInstance().getString("share_message", "");
                                    if (TextUtils.isEmpty(strM6871P)) {
                                        strM6871P = this.f178a.getString(R.string.recommand_title);
                                    }
                                    new DialogC0812Rl(this.f178a).m3828d(strM6871P, ApiEndpointsManager.getInstance().getAppStoreUrl(), 0);
                                    return;
                                }
                                if (strM3665j.equals("give_me_five")) {
                                    C2439uo.getInstance().m10217O();
                                    return;
                                }
                                if (strM3665j.equals("reset_settings")) {
                                    m312f();
                                    return;
                                }
                                if (strM3665j.equals("reset_site_settings")) {
                                    String strM3665j3 = JsonUtils.getString(jSONObject, "data-host");
                                    if (TextUtils.isEmpty(strM3665j3)) {
                                        return;
                                    }
                                    C1570e.getInstance().m6952U(strM3665j3);
                                    Toast.makeText(this.f178a, R.string.toast_reset_site_conf, Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                if (strM3665j.equals("view_wv_info")) {
                                    m314h();
                                    return;
                                }
                                if (strM3665j.equals("open_wv_devtools")) {
                                    m309c();
                                    return;
                                } else if (strM3665j.equals("reset_unlock_gestures")) {
                                    m313g();
                                    return;
                                } else {
                                    if (strM3665j.equals("revert_closed_tabs")) {
                                        this.f178a.m6371w2();
                                        return;
                                    }
                                    return;
                                }
                            }
                            m308b();
                            return;
                        }
                        dialogC2666zl = new DialogC2666zl(this.f178a);
                    }
                }
            }
            dialogC2666zl.show();
            return;
        }
        dialogInterfaceOnDismissListenerC0097C4 = new DialogInterfaceOnDismissListenerC0738Q1(this.f178a, JsonUtils.getString(jSONObject, "data-option-group-name"));
        dialogInterfaceOnDismissListenerC0097C4.show();
    }

    public final void m308b() {
        this.f178a.runOnUiThread(new d());
    }

    public final void m309c() {
        this.f178a.runOnUiThread(new f());
    }

    public final void m310d() {
        new a(this.f178a).m5643d(this.f178a.getString(R.string.dlg_clean_history), this.f178a.getString(R.string.dlg_clean_history_confirm));
    }

    public final void m311e() {
        new c(this.f178a).m5644e(this.f178a.getString(R.string.dlg_clean_download), this.f178a.getString(R.string.dlg_clean_download_confirm), this.f178a.getString(R.string.dlg_clean_downoad_file));
    }

    public final void m312f() {
        new b(this.f178a).m5643d(this.f178a.getString(R.string.dlg_reset_set_title), this.f178a.getString(R.string.dlg_reset_set_text));
    }

    public final void m313g() {
        SharedPreferencesHelper.getInstance().putString("unlock-password", "{}");
        Toast.makeText(this.f178a, "Unlock password has been reset", Toast.LENGTH_SHORT).show();
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
    }

    public final void m314h() {
        this.f178a.runOnUiThread(new e());
    }

    public class a extends AbstractDialogC1303b6 {
        public a(Context context) {
            super(context);
        }

        @Override
        public void mo316c() throws SQLException {
            MySQLiteOpenHelper.getInstance().m7498J();
            C1199a3.m5090f().m5093d("event_app_to_page", "clean_history");
        }

        @Override
        public void mo315b() {
        }
    }

    public class b extends AbstractDialogC1303b6 {

        public class a implements Runnable {

            public class RunnableC2683a implements Runnable {
                public RunnableC2683a() {
                }

                @Override
                public void run() {
                    C0848Sb.m4048n().m4049o();
                    C0074Bi.this.f178a.m6264T2();
                }
            }

            public a() {
            }

            @Override
            public void run() {
                SharedPreferencesHelper.getInstance().m6929y0();
                C1570e.getInstance().m6954W();
                C0074Bi.this.f178a.runOnUiThread(new RunnableC2683a());
            }
        }

        public b(Context context) {
            super(context);
        }

        @Override
        public void mo316c() {
            Toast.makeText(C0074Bi.this.f178a, R.string.toast_reset_to_default, Toast.LENGTH_SHORT).show();
            AbstractC1807h2.m7778a(new a());
        }

        @Override
        public void mo315b() {
        }
    }

    public class c extends AbstractDialogC1303b6 {
        public c(Context context) {
            super(context);
        }

        @Override
        public void mo316c() {
            CheckBox checkBox = (CheckBox) findViewById(R.id.another_condition);
            C1541c.m6674q().m6678D(checkBox != null && checkBox.isChecked());
            C1199a3.m5090f().m5093d("event_app_to_page", "notify_remove_downloads");
        }

        @Override
        public void mo315b() {
        }
    }

    public class h extends AbstractDialogC1303b6 {
        public h(Context context) {
            super(context);
        }

        @Override
        public void mo316c() {
            C1539a.getInstance().m6568H();
            C1199a3.m5090f().m5093d("event_app_to_page", "clean_adblock_logs");
        }

        @Override
        public void mo315b() {
        }
    }
}
