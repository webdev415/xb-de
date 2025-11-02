package p000;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.mmbox.widget.messagebox.C1418a;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.C1572g;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.mmbox.xbrowser.user.BackgroundWebviewHandler;
import com.mmbox.xbrowser.user.FetchResourceEventHandler;
import com.mmbox.xbrowser.user.StdUserEventHandler;
import com.xbrowser.play.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C2439uo {

    public static C2439uo instance;

    public UserResourceManager f7574d;

    public Context f7571a = null;

    public String f7572b = null;

    public OkHttpClient f7573c = null;

    public boolean f7575e = true;

    public String f7576f = null;

    public final HashMap f7577g = new HashMap<>();

    public boolean f7578h = false;

    public int f7579i = 1;

    public class c implements InterfaceC0556M3 {
        public c() {
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) {
            String strM2399p = c0490Kk.m2399p("Content-Type");
            if (c0490Kk.m2396j() != 200) {
                if (f7579i > 0) {
                    C2439uo c2439uo = C2439uo.this;
                    c2439uo.m10234u(c2439uo.m10238y());
                    C2439uo.m10196b(C2439uo.this);
                    return;
                }
                return;
            }
            if (strM2399p == null || strM2399p.indexOf("image/") < 0) {
                return;
            }
            try {
                try {
                    FileUtils.writeBytesToFile(c0490Kk.m2392a().m2709b(), ResourceCacheManager.getInstance().m2046a(getUser().getUserId(), 1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                c0490Kk.m2392a().close();
            }
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            if (f7579i > 0) {
                C2439uo c2439uo = C2439uo.this;
                c2439uo.m10234u(c2439uo.m10238y());
                C2439uo.m10196b(C2439uo.this);
            }
        }
    }

    public class d implements Runnable {

        public final boolean f7583l;

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() {
                Toast.makeText(f7571a, R.string.toast_restore_finished, Toast.LENGTH_SHORT).show();
                ((InterfaceC1300b3) BrowserActivity.getActivity().m6222J0().m9316y()).mo5625f();
            }
        }

        public d(boolean z) {
            this.f7583l = z;
        }

        @Override
        public void run() throws Throwable {
            try {
                m10214L("quick_access.dat", "syncable_quick_access");
                m10214L("bookmark.dat", "syncable_bookmark");
                m10214L("ad_rule.dat", "syncable_ad_rule");
                m10214L("ap_hosts.dat", "syncable_host");
                m10214L("history.dat", "syncable_history");
                m10214L("settings.dat", "syncable_setting");
                m10214L("main_menu.dat", "syncable_menu");
                m10214L("tool_menu.dat", "syncable_tool_menu");
                m10214L("context_menu.dat", "syncable_context_menu");
                m10214L("user_scripts.dat", "syncable_user_script");
                m10214L("user_tabs.dat", "syncable_user_tabs");
                m10214L("password_autofill.dat", "syncable_passwd_autofill");
                m10214L("addr_autofill.dat", "syncable_addr_autofill");
                m10214L("card_autofill.dat", "syncable_card_autofill");
                C1572g.getInstance().m7036s();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f7583l) {
                BrowserActivity.getActivity().runOnUiThread(new a());
            }
        }
    }

    public class e implements Runnable {

        public final String f7586l;

        public final boolean f7587m;

        public e(String str, boolean z) {
            this.f7586l = str;
            this.f7587m = z;
        }

        @Override
        public void run() {
            C2439uo c2439uo;
            boolean z;
            String strM8667A;
            try {
                m10221h("quick_access.dat", "syncable_quick_access");
                m10221h("bookmark.dat", "syncable_bookmark");
                m10221h("ad_rule.dat", "syncable_ad_rule");
                m10221h("ap_hosts.dat", "syncable_host");
                m10221h("history.dat", "syncable_history");
                m10221h("settings.dat", "syncable_setting");
                m10221h("main_menu.dat", "syncable_menu");
                m10221h("tool_menu.dat", "syncable_tool_menu");
                m10221h("context_menu.dat", "syncable_context_menu");
                m10221h("user_scripts.dat", "syncable_user_script");
                m10221h("user_tabs.dat", "syncable_user_tabs");
                m10221h("password_autofill.dat", "syncable_passwd_autofill");
                m10221h("addr_autofill.dat", "syncable_addr_autofill");
                m10221h("card_autofill.dat", "syncable_card_autofill");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f7586l)) {
                c2439uo = C2439uo.this;
                z = this.f7587m;
                strM8667A = AndroidSystemUtils.m8667A(System.currentTimeMillis());
            } else {
                c2439uo = C2439uo.this;
                z = this.f7587m;
                strM8667A = this.f7586l;
            }
            c2439uo.m10222i(z, strM8667A);
        }
    }

    public class f implements Runnable {

        public final String f7589l;

        public final String f7590m;

        public final String f7591n;

        public class a implements Runnable {

            public final String f7593l;

            public a(String str) {
                this.f7593l = str;
            }

            @Override
            public void run() throws Resources.NotFoundException {
                m10216N(this.f7593l);
            }
        }

        public f(String str, String str2, String str3) {
            this.f7589l = str;
            this.f7590m = str2;
            this.f7591n = str3;
        }

        @Override
        public void run() throws Throwable {
            ZipHelper.zipFiles(new File[]{new File(this.f7589l)}, this.f7590m);
            f7575e = true;
            String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + this.f7591n;
            if (Build.VERSION.SDK_INT >= 29) {
                Uri uriM8704l = AndroidSystemUtils.m8704l(f7571a, this.f7591n, "application/octet-stream", "");
                if (uriM8704l != null) {
                    AndroidSystemUtils.m8698f(f7571a, this.f7590m, uriM8704l);
                }
            } else {
                AndroidSystemUtils.m8699g(this.f7590m, str);
            }
            FileUtils.deleteFile(this.f7590m);
            BrowserActivity.getActivity().runOnUiThread(new a(str));
        }
    }

    public class g implements Runnable {

        public final boolean f7595l;

        public final String f7596m;

        public final String f7597n;

        public class a implements Runnable {

            public final Uri f7599l;

            public final String f7600m;

            public class DialogC2724a extends AbstractDialogC1303b6 {
                public DialogC2724a(Context context, int i) {
                    super(context, i);
                }

                @Override
                public void mo315b() {
                    FileUtils.deleteFile(g.this.f7596m);
                }

                @Override
                public void mo316c() {
                    if (Build.VERSION.SDK_INT < 29) {
                        AndroidSystemUtils.m8686T(BrowserActivity.getActivity(), a.this.f7600m);
                    } else if (a.this.f7599l != null) {
                        AndroidSystemUtils.shareFile(BrowserActivity.getActivity(), a.this.f7599l);
                    }
                }
            }

            public a(Uri uri, String str) {
                this.f7599l = uri;
                this.f7600m = str;
            }

            @Override
            public void run() {
                new DialogC2724a(BrowserActivity.getActivity(), 2).m5643d(f7571a.getString(R.string.dlg_title_backup_user_data), String.format(f7571a.getString(R.string.toast_backup_user_data), this.f7600m));
            }
        }

        public g(boolean z, String str, String str2) {
            this.f7595l = z;
            this.f7596m = str;
            this.f7597n = str2;
        }

        @Override
        public void run() throws Throwable {
            Uri uriM8704l;
            String str;
            Uri uriM8704l2;
            File file = new File(PhoneUtils.getInstance().getBackupDirPath());
            File file2 = new File(PhoneUtils.getInstance().getOfflinesDirPath());
            File file3 = new File(PhoneUtils.getInstance().getResourcesDirPath());
            File file4 = new File(PhoneUtils.getInstance().getAdRulesDirPath());
            if (FileUtils.fileExists(file.getAbsolutePath() + "/.backup")) {
                FileUtils.deleteFile(file.getAbsolutePath() + "/.backup");
            }
            ZipHelper.zipFiles(this.f7595l ? new File[]{file, file2, file3, file4} : new File[]{file, file3, file4}, this.f7596m);
            C2439uo c2439uo = C2439uo.this;
            c2439uo.f7575e = true;
            if (!this.f7595l) {
                if (Build.VERSION.SDK_INT < 29) {
                    AndroidSystemUtils.m8699g(this.f7596m, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + this.f7597n);
                    return;
                }
                String strM6871P = SharedPreferencesHelper.getInstance().getString("last_auto_backup_uri", "");
                if (TextUtils.isEmpty(strM6871P)) {
                    Context context = f7571a;
                    uriM8704l = AndroidSystemUtils.m8704l(context, this.f7597n, "application/octet-stream", context.getPackageName());
                    if (uriM8704l != null) {
                        SharedPreferencesHelper.getInstance().putString("last_auto_backup_uri", uriM8704l.toString());
                    }
                } else {
                    uriM8704l = Uri.parse(strM6871P);
                }
                if (uriM8704l != null) {
                    AndroidSystemUtils.m8698f(f7571a, this.f7596m, uriM8704l);
                    f7575e = true;
                    FileUtils.deleteFile(this.f7596m);
                    return;
                }
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Context context2 = c2439uo.f7571a;
                uriM8704l2 = AndroidSystemUtils.m8704l(context2, this.f7597n, "application/octet-stream", context2.getPackageName());
                if (uriM8704l2 != null) {
                    AndroidSystemUtils.m8698f(f7571a, this.f7596m, uriM8704l2);
                }
                str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + f7571a.getPackageName() + "/" + this.f7597n;
            } else {
                str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + this.f7597n;
                AndroidSystemUtils.m8699g(this.f7596m, str);
                uriM8704l2 = null;
            }
            FileUtils.deleteFile(this.f7596m);
            BrowserActivity.getActivity().runOnUiThread(new a(uriM8704l2, str));
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override
        public void run() throws Resources.NotFoundException {
            boolean zM9758K = getUser().shouldShowRankingMessageBar();
            if (!SharedPreferencesHelper.getInstance().getString("show_ranking_message_bar", "true").equals("true") || zM9758K) {
                return;
            }
            m10217O();
        }
    }

    public class i implements InterfaceC0556M3 {
        public i() {
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) {
            String strM2399p = c0490Kk.m2399p("Content-Type");
            if (strM2399p == null || !strM2399p.equals("application/json")) {
                return;
            }
            try {
                try {
                    JSONArray jSONArray = new JSONArray(c0490Kk.m2392a().m2714l());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string = jSONObject.getString("event_id");
                        String strReplace = jSONObject.getString("created_at").replace("Z", "UTC");
                        m10205C(string, jSONObject.getString("event_param"), strReplace);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                c0490Kk.m2392a().close();
            }
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public C2439uo() {
        this.f7574d = null;
        UserResourceManager userResourceManager = (UserResourceManager) C1089Xm.getInstance().m4822j("syncable_user_info");
        this.f7574d = userResourceManager;
        if (userResourceManager == null) {
            throw new IllegalStateException("you must register user info first");
        }
    }

    public static int m10196b(C2439uo c2439uo) {
        int i2 = c2439uo.f7579i;
        c2439uo.f7579i = i2 - 1;
        return i2;
    }

    public static C2439uo getInstance() {
        if (instance == null) {
            instance = new C2439uo();
        }
        return instance;
    }

    public UserResourceManager getUser() {
        return this.f7574d;
    }

    public final String m10204B() {
        return ApiEndpointsManager.getInstance().getAvatarEndpoint() + "/" + (AbstractCryptoUtils.toMd5(getUser().getUserId().toLowerCase()) + ".png");
    }

    public final void m10205C(String str, String str2, String str3) {
        if (str.equals("event_share_link_visited")) {
            C1825ha.m7824d().m7829f(12, str3);
        } else if (str.equals("event_exchange_code_costed")) {
            C1825ha.m7824d().m7829f(14, str2);
        }
    }

    public boolean m10206D() {
        String strM9755H = this.f7574d.getUserId();
        return !TextUtils.isEmpty(strM9755H) && strM9755H.indexOf(64) > 0;
    }

    public boolean m10207E() {
        return FileUtils.fileExists(ResourceCacheManager.getInstance().m2046a("start-page.bg", 9));
    }

    public boolean m10208F() {
        return FileUtils.fileExists(ResourceCacheManager.getInstance().m2046a("start-page.logo", 9));
    }

    public void m10209G(Context context) {
        this.f7571a = context;
        this.f7572b = PhoneUtils.getInstance().getBackupDirPath();
        this.f7573c = new OkHttpClient();
        File file = new File(this.f7572b);
        if (!file.exists()) {
            file.mkdirs();
        }
        C1825ha.m7824d().m7832i(0, StdUserEventHandler.class);
        C1825ha.m7824d().m7832i(1, StdUserEventHandler.class);
        C1825ha.m7824d().m7832i(2, StdUserEventHandler.class);
        C1825ha.m7824d().m7832i(54, StdUserEventHandler.class);
        C1825ha.m7824d().m7832i(18, StdUserEventHandler.class);
        C1825ha.m7824d().m7832i(19, BackgroundWebviewHandler.class);
        C1825ha.m7824d().m7832i(20, BackgroundWebviewHandler.class);
        C1825ha.m7824d().m7832i(21, BackgroundWebviewHandler.class);
        C1825ha.m7824d().m7832i(22, BackgroundWebviewHandler.class);
        C1825ha.m7824d().m7832i(52, BackgroundWebviewHandler.class);
        C1825ha.m7824d().m7832i(50, FetchResourceEventHandler.class);
        C1825ha.m7824d().m7832i(51, FetchResourceEventHandler.class);
        C1825ha.m7824d().m7832i(53, StdUserEventHandler.class);
        m10227n();
    }

    public void m10210H() throws JSONException {
        this.f7577g.put("chengkai.me@gmail.com", "chengkai.me@gmail.com");
        this.f7577g.put("1985980570@qq.com", "1985980570@qq.com");
        try {
            String strM2046a = ResourceCacheManager.getInstance().m2046a("privilege_user", 1002);
            if (strM2046a != null) {
                JSONArray jSONArray = new JSONArray(strM2046a);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    this.f7577g.put(string, string);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m10211I() {
        C1418a.m6110b().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getResources().getString(R.string.message_recovery_failed), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_ok), new j(), true);
    }

    public String readFile(String path) throws IOException {
        // If the file doesn't exist, try the backup file
        if (!FileUtils.fileExists(path)) {
            path = path.replaceAll("\\.dat$", ".bak");
        }

        // Read file into byte array
        byte[] fileBytes = FileUtils.readFileToByteArray(path);

        // If the file is a .dat file, invert bytes
        if (path.endsWith(".dat")) {
            AbstractCryptoUtils.invertBytes(fileBytes);
        }

        // Convert bytes to UTF-8 string
        return new String(fileBytes, StandardCharsets.UTF_8);
    }

    public void m10213K(String str) {
        if (!FileUtils.fileExists(str)) {
            Toast.makeText(this.f7571a, "Not found any recovery file", Toast.LENGTH_SHORT).show();
        } else if (ZipHelper.unzip(PhoneUtils.getInstance().getExternalDirPath(), str)) {
            m10215M(true);
        }
    }

    public final void m10214L(String str, String str2) throws Throwable {
        String strM10212J = readFile(PhoneUtils.getInstance().getBackupDirPath() + "/" + str);
        AbstractResourceManager abstractResourceManagerM4822J = C1089Xm.getInstance().m4822j(str2);
        if (abstractResourceManagerM4822J != null) {
            abstractResourceManagerM4822J.applyResource(strM10212J, true);
            abstractResourceManagerM4822J.incrementVersion();
        }
    }

    public void m10215M(boolean z) {
        AbstractC1807h2.m7778a(new d(z));
    }

    public void m10216N(String str) throws Resources.NotFoundException {
        C1418a.m6110b().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getResources().getString(R.string.toast_export_to) + str, BrowserActivity.getActivity().getResources().getString(R.string.btn_text_check), new a(), true);
    }

    public void m10217O() throws Resources.NotFoundException {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("review_message", "");
        if (TextUtils.isEmpty(strM6871P)) {
            strM6871P = BrowserActivity.getActivity().getResources().getString(R.string.message_please_review);
        }
        C1418a.m6110b().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), strM6871P, BrowserActivity.getActivity().getResources().getString(R.string.btn_text_ranking), new b(), true);
    }

    public void m10218P() {
        this.f7574d.clearUser();
        this.f7578h = true;
    }

    public final void m10219Q(SQLiteDatabase sQLiteDatabase, StringBuffer stringBuffer, String str) {
        String[] strArr = {str, "0"};
        Log.i("export-html", "selection:parent = ? AND status >= ?");
        Log.i("export-html", "path:" + str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("bookmark", DatabaseColumns.BOOKMARK, "parent = ? AND status >= ?", strArr, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    int i2 = 0;
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        if (cursorQuery.getInt(cursorQuery.getColumnIndex("type")) == 1) {
                            stringBuffer.append("<DT>");
                            stringBuffer.append("<H3>");
                            stringBuffer.append(string);
                            stringBuffer.append("</H3>\n");
                            stringBuffer.append("<DL>\n");
                            m10219Q(sQLiteDatabase, stringBuffer, string2);
                            stringBuffer.append("</DL>\n");
                        } else {
                            stringBuffer.append("<DT>");
                            stringBuffer.append("<A HREF=\"" + string2 + "\">");
                            stringBuffer.append(string);
                            stringBuffer.append("</A>");
                        }
                        stringBuffer.append("</DT>\n");
                        stringBuffer.append("");
                        i2++;
                        Log.i("export-html", "total record:" + i2 + " at:" + str);
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery == null) {
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery == null) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public void m10220R(String str, String str2) throws IOException {
        File file = new File(str);
        if (file.isDirectory() || file.getParentFile().isDirectory() || !file.getParentFile().mkdirs()) {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            if (str.indexOf(".dat") > 0) {
                AbstractCryptoUtils.toggleBytes(bytes);
            }
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }

    public final void m10221h(String str, String str2) throws IOException {
        String str3 = PhoneUtils.getInstance().getBackupDirPath() + "/" + str;
        AbstractResourceManager abstractResourceManagerM4822J = C1089Xm.getInstance().m4822j(str2);
        if (abstractResourceManagerM4822J != null) {
            m10220R(str3, abstractResourceManagerM4822J.getResourceValue());
        }
    }

    public void m10222i(boolean z, String str) {
        String strM5611r = PhoneUtils.getInstance().getRecoveryDirPath();
        File file = new File(strM5611r);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = strM5611r + "/" + (PhoneUtils.getInstance().getString("alias", "xbrowser") + "_" + str + ".xb");
        AbstractC1807h2.m7778a(new g(z, str2, FileUtils.getFileName(str2)));
    }

    public void m10223j(boolean z, String str) {
        this.f7575e = true;
        if (SharedPreferencesHelper.getInstance().acceptEula) {
            if (!z || Build.VERSION.SDK_INT >= 29 || BrowserActivity.getActivity().m6285Z("android.permission.WRITE_EXTERNAL_STORAGE")) {
                AbstractC1807h2.m7778a(new e(str, z));
            } else {
                BrowserActivity.getActivity().m6290a0();
            }
        }
    }

    public void m10224k(int i2, String str, String str2, String str3) {
        if (this.f7578h) {
            return;
        }
        try {
            if (!this.f7574d.getUserId().equals(str)) {
                this.f7574d.setUserId(str);
                this.f7574d.applyResource(str2, false);
                C1089Xm.getInstance().m4827o();
                this.f7574d.setVersionCodes(i2);
                this.f7574d.sync();
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f7574d.setUserToken(str3);
            }
            m10227n();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void m10225l(String str, String str2) {
        m10226m(str, null, str2);
    }

    public void m10226m(String str, String str2, String str3) {
        if (this.f7578h) {
            return;
        }
        try {
            if (!this.f7574d.getUserId().equals(str)) {
                this.f7574d.setUserId(str);
                C1089Xm.getInstance().m4827o();
                this.f7574d.sync();
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f7574d.setUserToken(str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f7574d.setUserNick(str2);
            }
            m10227n();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void m10227n() {
        ResourceCacheManager.getInstance().m2046a(getUser().getUserId(), 1);
        m10234u(m10204B());
    }

    public void m10228o() {
        BrowserActivity.getActivity().getHandler().postDelayed(new h(), 10000L);
    }

    public void m10229p() {
        try {
            this.f7573c.m2004y(new C0122Ck.a().m507i(ApiEndpointsManager.getInstance().getUserEventQueryUrl() + "?user_id=" + this.f7574d.getUserId()).m500b()).mo1791i(new i());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m10230q() {
        int i2 = Calendar.getInstance().get(6);
        UserResourceManager userResourceManagerM10203A = getInstance().getUser();
        if (userResourceManagerM10203A.getLastDay() > 0 && i2 - userResourceManagerM10203A.getLastDay() == 1) {
            C1825ha.m7824d().m7828e(3);
        }
        if (i2 - userResourceManagerM10203A.getLastDay() >= 1) {
            userResourceManagerM10203A.resetDailySearchCount();
        }
        userResourceManagerM10203A.setLastDay(i2);
    }

    public void m10231r() {
        boolean zM6873Q = SharedPreferencesHelper.getInstance().getBoolean("wait_for_try_app", false);
        String strM6871P = SharedPreferencesHelper.getInstance().getString("try_app_package", null);
        if (getInstance().getUser().hasTriedAppRequest() || !zM6873Q || strM6871P == null || !AndroidSystemUtils.isAppInstalled(this.f7571a, strM6871P)) {
            return;
        }
        C1825ha.m7824d().m7828e(17);
    }

    public void m10232s() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29 && !BrowserActivity.getActivity().m6285Z("android.permission.WRITE_EXTERNAL_STORAGE")) {
            BrowserActivity.getActivity().m6290a0();
            return;
        }
        this.f7575e = true;
        try {
            SQLiteDatabase readableDatabase = MySQLiteOpenHelper.getInstance().getReadableDatabase();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<!DOCTYPE NETSCAPE-Bookmark-file-1>\n");
            stringBuffer.append("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">\n");
            stringBuffer.append("<TITLE>Bookmarks</TITLE>\n");
            stringBuffer.append("<H1>Bookmarks</H1>\n");
            stringBuffer.append("<DL>\n");
            m10219Q(readableDatabase, stringBuffer, "/");
            stringBuffer.append("</DL>\n");
            String str = PhoneUtils.getInstance().getRecoveryDirPath() + "/bookmark_" + AndroidSystemUtils.m8667A(System.currentTimeMillis()) + ".html";
            m10220R(str, stringBuffer.toString());
            String strM4227k = FileUtils.getFileName(str);
            String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + strM4227k;
            if (i2 >= 29) {
                Uri uriM8704l = AndroidSystemUtils.m8704l(this.f7571a, strM4227k, "text/html", "");
                if (uriM8704l != null) {
                    AndroidSystemUtils.m8698f(this.f7571a, str, uriM8704l);
                    this.f7575e = true;
                }
            } else {
                AndroidSystemUtils.m8699g(str, str2);
            }
            Toast.makeText(this.f7571a, this.f7571a.getResources().getString(R.string.toast_export_bookmark) + str2, Toast.LENGTH_LONG).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m10233t(String str) {
        String str2 = PhoneUtils.getInstance().getCacheDirPath() + "/" + FileUtils.getFileName(str) + ".zip";
        AbstractC1807h2.m7778a(new f(str, str2, FileUtils.getFileName(str2)));
    }

    public final void m10234u(String str) {
        try {
            this.f7573c.m2004y(new C0122Ck.a().m507i(str).m500b()).mo1791i(new c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String m10235v() {
        String str = PhoneUtils.getInstance().isInChina() ? "zh" : "en";
        if (m10206D()) {
            return ApiEndpointsManager.getInstance().getUserEndpoint() + "/profile?token=" + this.f7574d.getUserToken();
        }
        this.f7578h = false;
        return ApiEndpointsManager.getInstance().getUserEndpoint() + "/login?locale=" + str + "&device_id=" + PhoneUtils.getInstance().getDeviceId() + "&token=" + this.f7574d.getUserToken();
    }

    public Drawable m10236w() {
        return C0896Td.m4137c().m4144h(getUser().getUserId(), 0);
    }

    public String m10237x() throws NoSuchAlgorithmException {
        String strM2046a = ResourceCacheManager.getInstance().m2046a(getUser().getUserId(), 1);
        if (FileUtils.fileExists(strM2046a)) {
            return AndroidSystemUtils.m8694b(C0988Vd.m4391d().m4396f(strM2046a));
        }
        return "https://api.multiavatar.com/" + AbstractCryptoUtils.toMd5(getUser().getUserId().toLowerCase()) + ".svg";
    }

    public final String m10238y() {
        return "https://secure.gravatar.com/avatar/" + (AbstractCryptoUtils.toMd5(getUser().getUserId().toLowerCase()) + ".png");
    }

    public class a implements MessageBoxBase.MessageBoxListener {
        public a() {
        }

        @Override
        public void onShown() {
            BrowserActivity.getActivity().m6374x1();
        }

        @Override
        public void onDismissed() {
        }

        @Override
        public void onDismiss() {
        }
    }

    public class b implements MessageBoxBase.MessageBoxListener {
        public b() {
        }

        @Override
        public void onShown() throws URISyntaxException {
            C1825ha.m7824d().m7828e(5);
            BrowserActivity.getActivity().m6283Y1();
            SharedPreferencesHelper.getInstance().putBoolean("open-review-btn", true);
            C1344c1.m5691d().m5698h("Go to review", "review_go_times");
        }

        @Override
        public void onDismiss() {
            C2439uo.getInstance().getUser().markRankingMessageBarShown();
            C1344c1.m5691d().m5698h("Open mark for review", "review_go_times");
            C1344c1.m5691d().m5698h("Show review", "review_showed");
        }

        @Override
        public void onDismissed() {
        }
    }

    public class j implements MessageBoxBase.MessageBoxListener {
        public j() {
        }

        @Override
        public void onShown() {
        }

        @Override
        public void onDismissed() {
        }

        @Override
        public void onDismiss() {
        }
    }
}
