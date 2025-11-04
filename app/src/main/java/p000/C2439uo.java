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
import com.mmbox.widget.messagebox.MessageBoxManager;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.MenuConfigManager;
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

import okhttp3.OkHttpClient;

public class C2439uo {

    public static C2439uo instance;

    public UserResourceManager userResourceManager;

    public Context context = null;

    public String f7572b = null;

    public OkHttpClient okHttpClient = null;

    public boolean f7575e = true;

    public String f7576f = null;

    public final HashMap f7577g = new HashMap<>();

    public boolean f7578h = false;

    public int f7579i = 1;

    public class c implements InterfaceC0556M3 {
        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) {
            String strM2399p = response.getContentType("Content-Type");
            if (response.getStatus() != 200) {
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
                    FileUtils.writeBytesToFile(response.body().m2709b(), ResourceCacheManager.getInstance().getUrlOrFilePath(getUser().getUserId(), 1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                response.body().close();
            }
        }

        @Override
        public void onError(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            if (f7579i > 0) {
                C2439uo c2439uo = C2439uo.this;
                c2439uo.m10234u(c2439uo.m10238y());
                C2439uo.m10196b(C2439uo.this);
            }
        }
    }

    public class d implements

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
                Uri uriM8704l = AndroidSystemUtils.m8704l(context, this.f7591n, "application/octet-stream", "");
                if (uriM8704l != null) {
                    AndroidSystemUtils.m8698f(context, this.f7590m, uriM8704l);
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

            public class DialogC2724a extends ConfirmDialog {
                public DialogC2724a(Context context, int i) {
                    super(context, i);
                }

                @Override
                public void onCancel() {
                    FileUtils.deleteFile(g.this.f7596m);
                }

                @Override
                public void onOK() {
                    if (Build.VERSION.SDK_INT < 29) {
                        AndroidSystemUtils.m8686T(BrowserActivity.getActivity(), f7600m);
                    } else if (f7599l != null) {
                        AndroidSystemUtils.shareFile(BrowserActivity.getActivity(), f7599l);
                    }
                }
            }

            public a(Uri uri, String str) {
                this.f7599l = uri;
                this.f7600m = str;
            }

            @Override
            public void run() {
                new DialogC2724a(BrowserActivity.getActivity(), 2).show(context.getString(R.string.dlg_title_backup_user_data), String.format(context.getString(R.string.toast_backup_user_data), this.f7600m));
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
                    Context context = C2439uo.this.context;
                    uriM8704l = AndroidSystemUtils.m8704l(context, this.f7597n, "application/octet-stream", context.getPackageName());
                    if (uriM8704l != null) {
                        SharedPreferencesHelper.getInstance().putString("last_auto_backup_uri", uriM8704l.toString());
                    }
                } else {
                    uriM8704l = Uri.parse(strM6871P);
                }
                if (uriM8704l != null) {
                    AndroidSystemUtils.m8698f(context, this.f7596m, uriM8704l);
                    f7575e = true;
                    FileUtils.deleteFile(this.f7596m);
                    return;
                }
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Context context2 = c2439uo.context;
                uriM8704l2 = AndroidSystemUtils.m8704l(context2, this.f7597n, "application/octet-stream", context2.getPackageName());
                if (uriM8704l2 != null) {
                    AndroidSystemUtils.m8698f(context, this.f7596m, uriM8704l2);
                }
                str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + context.getPackageName() + "/" + this.f7597n;
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
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) {
            String strM2399p = response.getContentType("Content-Type");
            if (strM2399p == null || !strM2399p.equals("application/json")) {
                return;
            }
            try {
                try {
                    JSONArray jSONArray = new JSONArray(response.body().m2714l());
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
                response.body().close();
            }
        }

        @Override
        public void onError(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public C2439uo() {
        this.userResourceManager = null;
        UserResourceManager userResourceManager = (UserResourceManager) SyncManager.getInstance().getResourceManager("syncable_user_info");
        this.userResourceManager = userResourceManager;
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
        return this.userResourceManager;
    }

    public final String m10204B() {
        return ApiEndpointsManager.getInstance().getAvatarEndpoint() + "/" + (AbstractCryptoUtils.toMd5(getUser().getUserId().toLowerCase()) + ".png");
    }

    public final void m10205C(String str, String str2, String str3) {
        if (str.equals("event_share_link_visited")) {
            EventQueueManager.getInstance().processEvent(12, str3);
        } else if (str.equals("event_exchange_code_costed")) {
            EventQueueManager.getInstance().processEvent(14, str2);
        }
    }

    public boolean m10206D() {
        String strM9755H = this.userResourceManager.getUserId();
        return !TextUtils.isEmpty(strM9755H) && strM9755H.indexOf(64) > 0;
    }

    public boolean m10207E() {
        return FileUtils.fileExists(ResourceCacheManager.getInstance().getUrlOrFilePath("start-page.bg", 9));
    }

    public boolean m10208F() {
        return FileUtils.fileExists(ResourceCacheManager.getInstance().getUrlOrFilePath("start-page.logo", 9));
    }

    public void m10209G(Context context) {
        this.context = context;
        this.f7572b = PhoneUtils.getInstance().getBackupDirPath();
        this.okHttpClient = new OkHttpClient();
        File file = new File(this.f7572b);
        if (!file.exists()) {
            file.mkdirs();
        }
        EventQueueManager.getInstance().registerEventHandler(0, StdUserEventHandler.class);
        EventQueueManager.getInstance().registerEventHandler(1, StdUserEventHandler.class);
        EventQueueManager.getInstance().registerEventHandler(2, StdUserEventHandler.class);
        EventQueueManager.getInstance().registerEventHandler(54, StdUserEventHandler.class);
        EventQueueManager.getInstance().registerEventHandler(18, StdUserEventHandler.class);
        EventQueueManager.getInstance().registerEventHandler(19, BackgroundWebviewHandler.class);
        EventQueueManager.getInstance().registerEventHandler(20, BackgroundWebviewHandler.class);
        EventQueueManager.getInstance().registerEventHandler(21, BackgroundWebviewHandler.class);
        EventQueueManager.getInstance().registerEventHandler(22, BackgroundWebviewHandler.class);
        EventQueueManager.getInstance().registerEventHandler(52, BackgroundWebviewHandler.class);
        EventQueueManager.getInstance().registerEventHandler(50, FetchResourceEventHandler.class);
        EventQueueManager.getInstance().registerEventHandler(51, FetchResourceEventHandler.class);
        EventQueueManager.getInstance().registerEventHandler(53, StdUserEventHandler.class);
        m10227n();
    }

    public void m10210H() throws JSONException {
        this.f7577g.put("chengkai.me@gmail.com", "chengkai.me@gmail.com");
        this.f7577g.put("1985980570@qq.com", "1985980570@qq.com");
        try {
            String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath("privilege_user", 1002);
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
        MessageBoxManager.getInstance().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getResources().getString(R.string.message_recovery_failed), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_ok), new MessageBoxBase.MessageBoxListener() {
            @Override
            public void onShown() {
            }

            @Override
            public void onDismissed() {
            }

            @Override
            public void onDismiss() {
            }
        }, true);
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

    public void recover(String path) {
        if (!FileUtils.fileExists(path)) {
            Toast.makeText(this.context, "Not found any recovery file", Toast.LENGTH_SHORT).show();
        } else if (ZipHelper.unzip(PhoneUtils.getInstance().getExternalDirPath(), path)) {
            loadResources(true);
        }
    }

    public final void applyResource(String fileName, String resourceName) throws Throwable {
        String fileContent = readFile(PhoneUtils.getInstance().getBackupDirPath() + "/" + fileName);
        AbstractResourceManager resourceManager = SyncManager.getInstance().getResourceManager(resourceName);
        if (resourceManager != null) {
            resourceManager.applyResource(fileContent, true);
            resourceManager.incrementVersion();
        }
    }

    public void loadResources(boolean callback) {
        BackgroundTaskManager.submitBackgroundTask(() -> {
            try {
                applyResource("quick_access.dat", "syncable_quick_access");
                applyResource("bookmark.dat", "syncable_bookmark");
                applyResource("ad_rule.dat", "syncable_ad_rule");
                applyResource("ap_hosts.dat", "syncable_host");
                applyResource("history.dat", "syncable_history");
                applyResource("settings.dat", "syncable_setting");
                applyResource("main_menu.dat", "syncable_menu");
                applyResource("tool_menu.dat", "syncable_tool_menu");
                applyResource("context_menu.dat", "syncable_context_menu");
                applyResource("user_scripts.dat", "syncable_user_script");
                applyResource("user_tabs.dat", "syncable_user_tabs");
                applyResource("password_autofill.dat", "syncable_passwd_autofill");
                applyResource("addr_autofill.dat", "syncable_addr_autofill");
                applyResource("card_autofill.dat", "syncable_card_autofill");
                MenuConfigManager.getInstance().m7036s();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (callback) {
                BrowserActivity.getActivity().runOnUiThread(() -> {
                    Toast.makeText(context, R.string.toast_restore_finished, Toast.LENGTH_SHORT).show();
                    ((InterfaceC1300b3) BrowserActivity.getActivity().getTabManager().m9316y()).mo5625f();
                });
            }
        });
    }

    public void m10216N(String str) throws Resources.NotFoundException {
        MessageBoxManager.getInstance().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getResources().getString(R.string.toast_export_to) + str, BrowserActivity.getActivity().getResources().getString(R.string.btn_text_check), new MessageBoxBase.MessageBoxListener() {
            @Override
            public void onShown() {
                BrowserActivity.getActivity().openDownloads();
            }

            @Override
            public void onDismissed() {
            }

            @Override
            public void onDismiss() {
            }
        }, true);
    }

    public void m10217O() throws Resources.NotFoundException {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("review_message", "");
        if (TextUtils.isEmpty(strM6871P)) {
            strM6871P = BrowserActivity.getActivity().getResources().getString(R.string.message_please_review);
        }
        MessageBoxManager.getInstance().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), strM6871P, BrowserActivity.getActivity().getResources().getString(R.string.btn_text_ranking), new MessageBoxBase.MessageBoxListener() {
            @Override
            public void onShown() throws URISyntaxException {
                EventQueueManager.getInstance().processEvent(5);
                BrowserActivity.getActivity().m6283Y1();
                SharedPreferencesHelper.getInstance().putBoolean("open-review-btn", true);
                C1344c1.getInstance().m5698h("Go to review", "review_go_times");
            }

            @Override
            public void onDismiss() {
                C2439uo.getInstance().getUser().markRankingMessageBarShown();
                C1344c1.getInstance().m5698h("Open mark for review", "review_go_times");
                C1344c1.getInstance().m5698h("Show review", "review_showed");
            }

            @Override
            public void onDismissed() {
            }
        }, true);
    }

    public void m10218P() {
        this.userResourceManager.clearUser();
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
        AbstractResourceManager abstractResourceManagerM4822J = SyncManager.getInstance().getResourceManager(str2);
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
        BackgroundTaskManager.submitBackgroundTask(new g(z, str2, FileUtils.getFileName(str2)));
    }

    public void m10223j(boolean z, String str) {
        this.f7575e = true;
        if (SharedPreferencesHelper.getInstance().acceptEula) {
            if (!z || Build.VERSION.SDK_INT >= 29 || BrowserActivity.getActivity().m6285Z("android.permission.WRITE_EXTERNAL_STORAGE")) {
                BackgroundTaskManager.submitBackgroundTask(new e(str, z));
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
            if (!this.userResourceManager.getUserId().equals(str)) {
                this.userResourceManager.setUserId(str);
                this.userResourceManager.applyResource(str2, false);
                SyncManager.getInstance().m4827o();
                this.userResourceManager.setVersionCodes(i2);
                this.userResourceManager.sync();
            }
            if (!TextUtils.isEmpty(str3)) {
                this.userResourceManager.setUserToken(str3);
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
            if (!this.userResourceManager.getUserId().equals(str)) {
                this.userResourceManager.setUserId(str);
                SyncManager.getInstance().m4827o();
                this.userResourceManager.sync();
            }
            if (!TextUtils.isEmpty(str3)) {
                this.userResourceManager.setUserToken(str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                this.userResourceManager.setUserNick(str2);
            }
            m10227n();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void m10227n() {
        ResourceCacheManager.getInstance().getUrlOrFilePath(getUser().getUserId(), 1);
        m10234u(m10204B());
    }

    public void m10228o() {
        BrowserActivity.getActivity().getHandler().postDelayed(new h(), 10000L);
    }

    public void m10229p() {
        try {
            this.okHttpClient.newCall(new Request.Builder().url(ApiEndpointsManager.getInstance().getUserEventQueryUrl() + "?user_id=" + this.userResourceManager.getUserId()).m500b()).mo1791i(new i());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m10230q() {
        int i2 = Calendar.getInstance().get(6);
        UserResourceManager userResourceManagerM10203A = getInstance().getUser();
        if (userResourceManagerM10203A.getLastDay() > 0 && i2 - userResourceManagerM10203A.getLastDay() == 1) {
            EventQueueManager.getInstance().processEvent(3);
        }
        if (i2 - userResourceManagerM10203A.getLastDay() >= 1) {
            userResourceManagerM10203A.resetDailySearchCount();
        }
        userResourceManagerM10203A.setLastDay(i2);
    }

    public void m10231r() {
        boolean zM6873Q = SharedPreferencesHelper.getInstance().getBoolean("wait_for_try_app", false);
        String strM6871P = SharedPreferencesHelper.getInstance().getString("try_app_package", null);
        if (getInstance().getUser().hasTriedAppRequest() || !zM6873Q || strM6871P == null || !AndroidSystemUtils.isAppInstalled(this.context, strM6871P)) {
            return;
        }
        EventQueueManager.getInstance().processEvent(17);
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
                Uri uriM8704l = AndroidSystemUtils.m8704l(this.context, strM4227k, "text/html", "");
                if (uriM8704l != null) {
                    AndroidSystemUtils.m8698f(this.context, str, uriM8704l);
                    this.f7575e = true;
                }
            } else {
                AndroidSystemUtils.m8699g(str, str2);
            }
            Toast.makeText(this.context, this.context.getResources().getString(R.string.toast_export_bookmark) + str2, Toast.LENGTH_LONG).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m10233t(String str) {
        String str2 = PhoneUtils.getInstance().getCacheDirPath() + "/" + FileUtils.getFileName(str) + ".zip";
        BackgroundTaskManager.submitBackgroundTask(new f(str, str2, FileUtils.getFileName(str2)));
    }

    public final void m10234u(String str) {
        try {
            this.okHttpClient.newCall(new Request.Builder().url(str).m500b()).mo1791i(new c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String m10235v() {
        String str = PhoneUtils.getInstance().isInChina() ? "zh" : "en";
        if (m10206D()) {
            return ApiEndpointsManager.getInstance().getUserEndpoint() + "/profile?token=" + this.userResourceManager.getUserToken();
        }
        this.f7578h = false;
        return ApiEndpointsManager.getInstance().getUserEndpoint() + "/login?locale=" + str + "&device_id=" + PhoneUtils.getInstance().getDeviceId() + "&token=" + this.userResourceManager.getUserToken();
    }

    public Drawable m10236w() {
        return C0896Td.m4137c().m4144h(getUser().getUserId(), 0);
    }

    public String m10237x() throws NoSuchAlgorithmException {
        String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(getUser().getUserId(), 1);
        if (FileUtils.fileExists(strM2046a)) {
            return AndroidSystemUtils.m8694b(C0988Vd.getInstance().m4396f(strM2046a));
        }
        return "https://api.multiavatar.com/" + AbstractCryptoUtils.toMd5(getUser().getUserId().toLowerCase()) + ".svg";
    }

    public final String m10238y() {
        return "https://secure.gravatar.com/avatar/" + (AbstractCryptoUtils.toMd5(getUser().getUserId().toLowerCase()) + ".png");
    }
}
