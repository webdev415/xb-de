package p000;

import android.content.ContentValues;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import com.mmbox.widget.messagebox.MessageBoxManager;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.BrowserDownloadManager;
import com.mmbox.xbrowser.MenuConfigManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.xbrowser.play.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;

public class JSManager {

    public static JSManager instance;

    public ScriptMap assetScriptMap;

    public OkHttpClient httpClient = null;

    public final ScriptMap f6187b = new ScriptMap();

    public final ScriptMap f6188c = new ScriptMap();

    public final ScriptMap f6189d = new ScriptMap();

    public ScriptMap f6190e = null;

    public ScriptMap f6191f = null;

    public String executionPoint = null;

    public ScriptMap onlineScriptMap = null;

    public class a implements

    public class b implements InterfaceC0556M3 {

        public final String f6197a;

        public b(String str) {
            this.f6197a = str;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) {
            String strM2399p = response.getContentType("Content-Type");
            if (strM2399p != null) {
                try {
                    if (strM2399p.indexOf("application/json") >= 0) {
                        try {
                            String strM2714l = response.body().m2714l();
                            int iM3660e = JsonUtils.getInt(new JSONObject(strM2714l), "status", -1);
                            if (iM3660e == 1 || iM3660e == 2 || iM3660e == 0 || iM3660e == 3) {
                                String strM8546p0 = m8546p0(this.f6197a, strM2714l, 0);
                                BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_success));
                                BrowserActivity.getActivity().updateTitle("nav_call_update_btn_state('" + strM8546p0 + "')");
                            } else {
                                BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_failed));
                            }
                        } catch (Exception unused) {
                            BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_failed));
                        }
                        response.body().close();
                        return;
                    }
                } catch (Throwable th) {
                    response.body().close();
                    throw th;
                }
            }
            BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_failed));
        }

        @Override
        public void onError(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_failed));
        }
    }

    public class d implements InterfaceC0556M3 {

        public final String f6203a;

        public d(String str) {
            this.f6203a = str;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) {
            String strM2399p = response.getContentType("Content-Type");
            if ((strM2399p == null || strM2399p.indexOf("text/javascript") < 0) && strM2399p.indexOf("text/plain") < 0 && strM2399p.indexOf("application/javascript") < 0) {
                BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_failed));
                return;
            }
            try {
                try {
                    m8546p0(this.f6203a, response.body().m2714l(), 1);
                    BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_success));
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
            BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_failed));
        }
    }

    public class g implements

    public class i implements C0232F1.d {

        public final CountDownLatch f6212a;

        public i(CountDownLatch countDownLatch) {
            this.f6212a = countDownLatch;
        }

        @Override
        public void mo844a(String str, String str2) {
            this.f6212a.countDown();
        }

        @Override
        public void mo845b() {
            this.f6212a.countDown();
            Log.w("js-manager", "get resource content failed");
            BrowserActivity.getActivity().m6240N2(BrowserActivity.getActivity().getString(R.string.toast_fetch_resource_failed), 30000L);
        }
    }

    public class k implements BrowserDownloadManager.k {

        public final String f6216a;

        public final String f6217b;

        public k(String str, String str2) {
            this.f6216a = str;
            this.f6217b = str2;
        }

        @Override
        public void mo6506a() {
            try {
                m8489F(this.f6216a, this.f6217b, -1);
            } catch (Exception unused) {
            }
        }

        @Override
        public void mo6507b() throws JSONException {
            m8487E(this.f6216a, this.f6217b);
        }
    }

    public class l implements InterfaceC0556M3 {

        public final String f6219a;

        public final String f6220b;

        public final String f6221c;

        public l(String str, String str2, String str3) {
            this.f6219a = str;
            this.f6220b = str2;
            this.f6221c = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo1180a(InterfaceC0418J3 r5, Response r6) {
            /*
                r4 = this;
                java.lang.String r5 = "stream"
                int r0 = r6.code()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                r1 = 500(0x1f4, float:7.0E-43)
                if (r0 >= r1) goto L37
                mf r0 = p000.C2061mf.this     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r1 = r4.f6219a     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r2 = r4.f6220b     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r3 = r4.f6221c     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                p000.C2061mf.m8475l(r0, r1, r2, r6, r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                mf r0 = p000.C2061mf.this     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r1 = r4.f6219a     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r2 = r4.f6220b     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                r3 = 2
                p000.C2061mf.m8476m(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                mf r0 = p000.C2061mf.this     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r1 = r4.f6219a     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r2 = r4.f6220b     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r3 = r4.f6221c     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                p000.C2061mf.m8477n(r0, r1, r2, r6, r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                mf r0 = p000.C2061mf.this     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r1 = r4.f6219a     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r2 = r4.f6220b     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                r3 = 4
                p000.C2061mf.m8476m(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                goto L44
            L35:
                r0 = move-exception
                goto L85
            L37:
                mf r0 = p000.C2061mf.this     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r1 = r4.f6219a     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                java.lang.String r2 = r4.f6220b     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                int r3 = r6.code()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
                p000.C2061mf.m8473j(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L54 java.lang.IllegalStateException -> L67 org.json.JSONException -> L7a
            L44:
                java.lang.String r0 = r4.f6221c
                boolean r5 = r0.equals(r5)
                if (r5 != 0) goto L9e
            L4c:
                Lk r5 = r6.body()
                r5.close()
                goto L9e
            L54:
                mf r0 = p000.C2061mf.this     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L5e
                java.lang.String r1 = r4.f6219a     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L5e
                java.lang.String r2 = r4.f6220b     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L5e
                r3 = -1
                p000.C2061mf.m8473j(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L5e
            L5e:
                java.lang.String r0 = r4.f6221c
                boolean r5 = r0.equals(r5)
                if (r5 != 0) goto L9e
                goto L4c
            L67:
                mf r0 = p000.C2061mf.this     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L71
                java.lang.String r1 = r4.f6219a     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L71
                java.lang.String r2 = r4.f6220b     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L71
                r3 = -3
                p000.C2061mf.m8473j(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L71
            L71:
                java.lang.String r0 = r4.f6221c
                boolean r5 = r0.equals(r5)
                if (r5 != 0) goto L9e
                goto L4c
            L7a:
                mf r0 = p000.C2061mf.this     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L95
                java.lang.String r1 = r4.f6219a     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L95
                java.lang.String r2 = r4.f6220b     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L95
                r3 = -2
                p000.C2061mf.m8473j(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> L35 org.json.JSONException -> L95
                goto L95
            L85:
                java.lang.String r1 = r4.f6221c
                boolean r5 = r1.equals(r5)
                if (r5 != 0) goto L94
                Lk r5 = r6.body()
                r5.close()
            L94:
                throw r0
            L95:
                java.lang.String r0 = r4.f6221c
                boolean r5 = r0.equals(r5)
                if (r5 != 0) goto L9e
                goto L4c
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C2061mf.l.mo1180a(J3, Kk):void");
        }

        @Override
        public void onError(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            try {
                m8489F(this.f6219a, this.f6220b, -1);
            } catch (Exception unused) {
            }
        }
    }

    public class UserScriptMeta {

        public final HashMap f6223a = new HashMap<>();

        public String getDescription() {
            String description = (String) this.f6223a.get("description:" + PhoneUtils.getInstance().getLocaleCode());
            if (description == null) {
                description = (String) this.f6223a.get("description:" + PhoneUtils.getInstance().getLanguageCode());
            }
            return description == null ? (String) this.f6223a.get("description") : description;
        }

        public String m8568b() {
            String match = (String) this.f6223a.get("match");
            String include = (String) this.f6223a.get("include");
            if (!TextUtils.isEmpty(include)) {
                if (TextUtils.isEmpty(match)) {
                    match = include;
                } else {
                    match = match + "`" + include;
                }
            }
            return TextUtils.isEmpty(match) ? "*" : match;
        }

        public String get(String str) {
            return (String) this.f6223a.get(str);
        }

        public final int getType(String str) {
            if (TextUtils.isEmpty(str) || str.equals("raw-script")) {
                return 2;
            }
            return str.equals("bookmarklet") ? 3 : 0;
        }

        public String getName() {
            String name = (String) this.f6223a.get("name:" + PhoneUtils.getInstance().getLocaleCode());
            if (name == null) {
                name = (String) this.f6223a.get("name:" + PhoneUtils.getInstance().getLanguageCode());
            }
            return name == null ? (String) this.f6223a.get("name") : name;
        }

        public int getType() {
            if (!this.f6223a.isEmpty()) {
                return getType(get("type"));
            }
            return 0;
        }

        public void put(String str, String str2) {
            String str3;
            if ((str.equals("include") || str.equals("match") || str.equals("require") || str.equals("exclude") || str.equals("resource") || str.equals("grant"))
                    && (str3 = (String) this.f6223a.get(str)) != null) {
                str2 = str3 + "`" + str2;
            }
            this.f6223a.put(str, str2);
        }
    }

    public JSManager() {
        this.assetScriptMap = null;
        this.assetScriptMap = new ScriptMap();
        initialize();
    }

    public static JSManager getInstance() {
        if (instance == null) {
            instance = new JSManager();
        }
        return instance;
    }

    public static boolean m8478v0(String str, String str2) {
        if (str2.indexOf(str) > 0) {
            return true;
        }
        int length = 0;
        for (String str3 : str.split("\\*")) {
            if (!str3.isEmpty()) {
                int iIndexOf = str2.indexOf(str3, length);
                if (iIndexOf == -1) {
                    return false;
                }
                length = iIndexOf + str3.length();
            }
        }
        return true;
    }

    public final void m8479A(String str, String str2) {
        Log.i("user-script", ">>>>>>> execute script: " + str + "=================");
        String strM8515T = getScriptPath(str);
        if (!FileUtils.fileExists(strM8515T)) {
            installScript(str, str2);
        }
        BrowserActivity.getActivity().m6353r1(FileUtils.readFileToString(strM8515T));
    }

    public final String m8480A0(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return "{}";
        }
        String[] strArrSplit = str.split("`");
        JSONObject jSONObject = new JSONObject();
        for (String str2 : strArrSplit) {
            try {
                String[] strArrSplit2 = str2.split("[ \t]{1,12}");
                String str3 = strArrSplit2[1];
                jSONObject.put(strArrSplit2[0], str3);
                m8557v(str3);
            } catch (Exception unused) {
            }
        }
        return jSONObject.toString();
    }

    public void m8481B(String str, boolean z) {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(z ? 1 : 0));
        writableDatabase.update("user_script", contentValues, "script_id= ?", new String[]{str});
    }

    /**
     * Parse UserScript metadata block (e.g. // @name, // @author ...)
     * until "==/UserScript==" marker.
     *
     * @param script JS script source
     * @return metadata container
     */
    public final UserScriptMeta parseUserScriptMeta(String script) {
        UserScriptMeta meta = new UserScriptMeta();

        try (BufferedReader reader = new BufferedReader(new StringReader(script))) {
            String line;

            while ((line = reader.readLine()) != null) {

                // Stop at metadata end
                if (line.contains("==/UserScript==")) {
                    break;
                }

                // Only process comment lines
                if (!line.contains("//")) continue;

                // Extract key/value pair (delegated to your helper)
                String[] pair = NetworkUtils.extractUserScriptAuthor(line);
                if (pair != null && pair.length == 2) {
                    meta.put(pair[0], pair[1].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return meta;
    }

    public void evaluateJavascript(WebView webView, String script) {
        if (script.startsWith("javascript:")) {
            script = script.substring(11);
        }
        webView.evaluateJavascript(script, result -> Log.d("WebView", "JavaScript returned value: " + result));
    }

    public void m8484C0(String str, boolean z) throws JSONException {
        StringBuilder sb;
        String strM8527c0 = getUserScriptJson(str);
        String str2 = ApiEndpointsManager.getInstance().getPostShareScriptEndpoint() + "?resource_id=" + str + "&user_id=" + C2439uo.getInstance().getUser().getUserId();
        if (z) {
            sb = new StringBuilder();
            sb.append(str2);
            sb.append("&forward=true");
        } else {
            sb = PhoneUtils.getInstance().isInChina() ? new StringBuilder() : new StringBuilder();
            sb.append(str2);
            sb.append("&pub=false");
        }
        try {
            this.httpClient.newCall(new Request.Builder().url(sb.toString()).m504f(AbstractC0168Dk.m718d(C0716Pg.m3568g("text/json"), strM8527c0.getBytes(StandardCharsets.UTF_8))).m500b()).mo1791i(new c(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m8485D(int i2) {
        BrowserActivity.getActivity().updateTitle("_XJSAPI_.exec_menu_cmd('" + i2 + "')");
    }

    public final void installScript(String module, String script) {
        try {
            UserScriptMeta meta = parseUserScriptMeta(script);
            String name = meta.getName() == null ? "" : meta.getName();
            String description = meta.getDescription() == null ? name : meta.getDescription();
            String author = meta.get("author") == null ? "" : meta.get("author");
            String grant = meta.get("grant") == null ? null : meta.get("grant");
            String require = meta.get("require") == null ? null : meta.get("require");
            String resource = m8480A0(meta.get("resource") == null ? null : meta.get("resource"));
            String version = meta.get("version") == null ? "1.0" : meta.get("version");
            String include = meta.get("include") == null ? null : meta.get("include");
            String match = meta.get("match") == null ? null : meta.get("match");
            m8488E0(module, name, description, author, script, require, resource, include, include, match, grant, version);
        } catch (Exception e) {
            BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_failed));
            e.printStackTrace();
        }
    }

    public final void m8487E(String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("methodName", "GM_download");
            jSONObject.put("callbackName", "onload");
            jSONObject.put("status", 0);
            String str3 = "_" + str + "_" + str2 + "_GM_download";
            String string = jSONObject.toString();
            BrowserActivity.getActivity().updateTitle("_XJSAPI_.exec_gm_callback('" + str3 + "'," + JSONObject.quote(string) + ")");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void m8488E0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) throws Exception {
        StringBuffer stringBuffer = new StringBuffer(512);
        m8553t(stringBuffer, str, str2, str3, str4, str12, str7, str8, str9, str10, str5);
        m8547q(stringBuffer, str11, str5);
        if (!TextUtils.isEmpty(str6)) {
            m8551s(stringBuffer, str6);
        }
        m8549r(stringBuffer, str5);
        m8545p(stringBuffer);
        String strM8515T = getScriptPath(str);
        byte[] bytes = stringBuffer.toString().getBytes(StandardCharsets.UTF_8);
        if (bytes != null) {
            Log.i("user-script", "============ precompiled file ==================\n" + strM8515T);
            FileUtils.writeBytesToFile(bytes, strM8515T);
        }
    }

    public final void m8489F(String str, String str2, int status) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("methodName", "GM_xmlhttpRequest");
        jSONObject.put("callbackName", "onerror");
        jSONObject.put("readyState", -1);
        jSONObject.put("status", status);
        String strQuote = JSONObject.quote(jSONObject.toString());
        String str3 = "_" + str + "_" + str2 + "_GM_xmlhttpRequest";
        BrowserActivity.getActivity().updateTitle("_XJSAPI_.exec_gm_callback('" + str3 + "'," + strQuote + ")");
    }

    public void m8490F0() {
        if (f6191f == null) {
            this.f6191f = new ScriptMap();
        } else {
            f6191f.clear();
        }
        if (onlineScriptMap == null) {
            this.onlineScriptMap = new ScriptMap();
        } else {
            onlineScriptMap.clear();
        }
        if (f6189d != null) {
            f6189d.clear();
        }
    }

    public final void m8491G(String str, String str2, Response response, String str3) throws JSONException {
        String str4;
        String str5;
        String string = response.getRequest().getUrl().toString();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("methodName", "GM_xmlhttpRequest");
        jSONObject.put("callbackName", "onload");
        jSONObject.put("readyState", 4);
        jSONObject.put("status", response.getStatus());
        jSONObject.put("statusText", response.getMessage());
        jSONObject.put("finalUrl", string);
        String contentType = response.getContentType("Content-Type");
        if (TextUtils.isEmpty(contentType)) {
            contentType = "text/plain";
        }
        Headers headersM2401Z = response.getHeaders();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i2 = 0; i2 < headersM2401Z.size(); i2++) {
            String strM4738f = headersM2401Z.m4738f(i2);
            String strM4740h = headersM2401Z.m4740h(i2);
            Log.i("user-script", "name:" + strM4738f + " val: " + strM4740h);
            stringBuffer.append(strM4738f);
            stringBuffer.append(": ");
            stringBuffer.append(URLDecoder.decode(strM4740h));
            stringBuffer.append("\r\n");
            if (strM4738f.equalsIgnoreCase("set-cookie")) {
                String[] strArrSplit = strM4740h.split(";");
                if (stringBuffer2.length() == 0) {
                    str5 = strArrSplit[0];
                } else {
                    stringBuffer2.append("; ");
                    str5 = strArrSplit[0];
                }
                stringBuffer2.append(str5);
            }
        }
        m8560x(stringBuffer2, string);
        jSONObject.put("responseHeaders", stringBuffer.toString());
        String str6 = "_" + str + "_" + str2 + "_GM_xmlhttpRequest";
        if (str3.equals("json")) {
            jSONObject.put("response", new JSONObject(response.body().m2714l()));
        } else if (str3.equals("blob") || str3.equals("arraybuffer")) {
            String strEncodeToString = Base64.encodeToString(response.body().m2709b(), 0);
            jSONObject.put("response", "");
            jSONObject.put("response_base64", strEncodeToString);
        } else if (str3.equals("stream")) {
            jSONObject.put("response", "");
            this.onlineScriptMap.put(str6, response);
        } else {
            str4 = "text";
            if (TextUtils.isEmpty(str3) || str3.equals("text") || (!str3.equals("document") && contentType.indexOf("text/html") < 0 && contentType.indexOf("xml") < 0)) {
                jSONObject.put("responseText", response.body().m2714l());
                jSONObject.put("responseType", str4);
                String strQuote = JSONObject.quote(jSONObject.toString());
                BrowserActivity.getActivity().updateTitle("_XJSAPI_.exec_gm_callback('" + str6 + "'," + strQuote + ")");
            }
            jSONObject.put("responseText", response.body().m2714l());
        }
        str4 = str3;
        jSONObject.put("responseType", str4);
        String strQuote2 = JSONObject.quote(jSONObject.toString());
        BrowserActivity.getActivity().updateTitle("_XJSAPI_.exec_gm_callback('" + str6 + "'," + strQuote2 + ")");
    }

    /**
     * Load a JS file from app assets under a package-like path and cache its contents.
     *
     * Example: packageName "com.example.lib", fileName "script" -> loads "com/example/lib/script.js"
     *
     * @return file contents (UTF-8) or empty string on error/not found
     */
    public final String getAssetScriptContent(String packageName, String fileName) {
        if (TextUtils.isEmpty(packageName) || TextUtils.isEmpty(fileName)) return "";

        // ensure .js suffix
        String file = fileName.endsWith(".js") ? fileName : (fileName + ".js");
        String assetPath = packageName.replace('.', '/') + "/" + file;

        try {
            // check cache first
            String cached = (String) this.assetScriptMap.get(assetPath);
            if (!TextUtils.isEmpty(cached)) return cached;

            // load from assets
            try (InputStream is = BrowserActivity.getActivity().getAssets().open(assetPath)) {
                String content = AndroidSystemUtils.readStreamToString(is);
                if (content == null) content = "";
                this.assetScriptMap.put(assetPath, content);
                return content;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final void getOnlineScriptMap(String str, String str2, Response response, String responseType) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("methodName", "GM_xmlhttpRequest");
        jSONObject.put("callbackName", "onloadstart");
        jSONObject.put("responseType", responseType);
        jSONObject.put("status", 0);
        String strQuote = JSONObject.quote(jSONObject.toString());
        String str4 = "_" + str + "_" + str2 + "_GM_xmlhttpRequest";
        if (responseType.equals("stream")) {
            this.onlineScriptMap.put(str4, response);
        }
        BrowserActivity.getActivity().updateTitle("_XJSAPI_.exec_gm_callback('" + str4 + "'," + strQuote + ")");
    }

    public void m8494H0(AbstractC2359t abstractC2359t) {
        Iterator it = this.f6189d.keySet().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) this.f6189d.get((String) it.next());
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    C0762Qg c0762Qg = (C0762Qg) arrayList.get(i2);
                    c0762Qg.mo2675n(Integer.MAX_VALUE);
                    String str = (String) c0762Qg.mo2666e();
                    if (c0762Qg.mo2683v() == -1) {
                        c0762Qg.mo2662a(getInstance().m8529d0(str));
                        abstractC2359t.m9643c(c0762Qg).mo2668g();
                    } else {
                        abstractC2359t.m9643c(c0762Qg);
                    }
                }
            }
        }
    }

    public final void m8495I(String str, String str2, int i2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("methodName", "GM_xmlhttpRequest");
        jSONObject.put("callbackName", "onreadystatechange");
        jSONObject.put("readyState", i2);
        String strQuote = JSONObject.quote(jSONObject.toString());
        String str3 = "_" + str + "_" + str2 + "_GM_xmlhttpRequest";
        BrowserActivity.getActivity().updateTitle("_XJSAPI_.exec_gm_callback('" + str3 + "'," + strQuote + ")");
    }

    public String m8496I0(String str, String str2, String str3) {
        StringBuilder sb;
        ArrayList arrayList = (ArrayList) this.f6189d.get(str);
        int iAbs = Math.abs((str + str3).hashCode());
        C0762Qg c0762Qg = new C0762Qg();
        c0762Qg.mo2673l(str3);
        c0762Qg.mo2663b(iAbs);
        if (arrayList.contains(c0762Qg)) {
            sb = new StringBuilder();
        } else {
            arrayList.add(c0762Qg);
            sb = new StringBuilder();
        }
        sb.append(iAbs);
        sb.append("");
        return sb.toString();
    }

    public void m8497J(String str) {
        String str2 = (String) this.f6188c.get(str);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        BrowserActivity.getActivity().updateTitle(str2);
    }

    public void m8498J0(String str, String str2) {
        this.f6188c.put(str, str2);
    }

    public void m8499K(String str) {
        String[] strArr = {str};
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("user_script", DatabaseColumns.USER_SCRIPT, "script_id= ?", strArr, null, null, null);
            if (cursorQuery != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    AbstractC2015lf.m8396a();
                    ((AbstractWindowedCursor) cursorQuery).setWindow(AbstractC1969kf.m8296a("bigwindow", 5242880L));
                }
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("script_data"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                    if (cursorQuery.getInt(cursorQuery.getColumnIndex("type")) == 3 || string.startsWith("javascript:")) {
                        m8564z(string);
                    } else {
                        m8561x0(str, string2);
                        m8479A(str, string);
                    }
                }
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
    }

    public void m8500K0(String str) {
        MySQLiteOpenHelper.getInstance().getWritableDatabase().delete("user_script", "script_id= ?", new String[]{str});
        SyncManager.getInstance().getResourceManager("syncable_user_script").incrementVersion();
    }

    public void m8501L(String str) {
        Toast.makeText(BrowserActivity.getActivity(), R.string.toast_installing_script, Toast.LENGTH_SHORT).show();
        String str2 = ApiEndpointsManager.getInstance().getFetchShareScriptEndpoint() + "?resource_id=" + str;
        this.httpClient.newCall(new Request.Builder().url(str2).m500b()).mo1791i(new b(str2));
    }

    public final String m8502L0(String str) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String string = jSONObject.getString(next);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", next);
            jSONObject2.put("url", string);
            jSONArray.put(jSONObject2);
        }
        return jSONArray.toString();
    }

    public void m8503M(String str) {
        Toast.makeText(BrowserActivity.getActivity(), R.string.toast_installing_script, Toast.LENGTH_SHORT).show();
        Request.Builder builderVarM507I = new Request.Builder().url(str);
        builderVarM507I.addHeader("User-Agent", SharedPreferencesHelper.defaultUserAgent);
        this.httpClient.newCall(builderVarM507I.m500b()).mo1791i(new d(str));
    }

    public int m8504M0(String str) {
        String[] strArr = {str};
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("user_script", new String[]{"status"}, "script_id= ?", strArr, null, null, null);
            if (cursorQuery != null) {
                i = cursorQuery.moveToFirst() ? cursorQuery.getInt(cursorQuery.getColumnIndex("status")) : -1;
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        return i;
    }

    public void install(String moduleName) {
        FileUtils.deleteFile(getScriptPath(moduleName));
        String script = getAssetScriptContent("module", moduleName);
        if (!TextUtils.isEmpty(script)) {
            installScript(moduleName, script);
        }
    }

    public void m8506N0(String str, String str2) {
        AndroidSystemUtils.share(BrowserActivity.getActivity(), str2, ApiEndpointsManager.getInstance().getShareScriptsEndpoint() + "&filter=forward&resource_id=" + str,  null, null, null);
    }

    public final int m8507O(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.equals("document-start") || str.equals("document-body")) {
            return 2;
        }
        if (str.equals("document-end")) {
            return 1;
        }
        if (str.equals("document-idle")) {
            return 0;
        }
        if (str.equals("main-menu")) {
            return 3;
        }
        if (str.equals("context-menu")) {
            return 4;
        }
        return str.equals("tool-menu") ? 5 : 0;
    }

    public void m8508O0(String str, String str2) throws NumberFormatException {
        ScriptMap scriptMap = this.f6189d;
        if (scriptMap != null) {
            ArrayList arrayList = (ArrayList) scriptMap.get(str);
            int i2 = Integer.parseInt(str2);
            if (arrayList != null) {
                int i3 = -1;
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    if (((C0762Qg) arrayList.get(i4)).mo2683v() == i2) {
                        i3 = i4;
                    }
                }
                if (i3 >= 0) {
                    arrayList.remove(i3);
                }
            }
        }
    }

    public final String m8509P(String str) {
        if (this.f6190e == null) {
            return null;
        }
        return (String) this.f6190e.get(Uri.parse(str).getHost());
    }

    public String m8510P0(String str, String str2) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        String strM3666k = JsonUtils.getString(jSONObject, "title", "");
        String strM3666k2 = JsonUtils.getString(jSONObject, "description", "");
        String strM3666k3 = JsonUtils.getString(jSONObject, "create_by", "");
        String strM3666k4 = JsonUtils.getString(jSONObject, "content", "");
        String strM3666k5 = JsonUtils.getString(jSONObject, "resource_id", null);
        String strM3666k6 = JsonUtils.getString(jSONObject, "extra", null);
        if (!TextUtils.isEmpty(strM3666k6) && strM3666k6.indexOf("data:") < 0) {
            strM3666k6 = strM3666k6.replaceAll(",", "`");
        }
        UserScriptMeta mVarUserScriptMeta8482B0 = parseUserScriptMeta(strM3666k4);
        String strM8571e = mVarUserScriptMeta8482B0.getName();
        String str3 = !TextUtils.isEmpty(strM8571e) ? strM8571e : strM3666k;
        String strM8569c = mVarUserScriptMeta8482B0.get("name") == null ? "" : mVarUserScriptMeta8482B0.get("name");
        String str4 = TextUtils.isEmpty(strM8569c) ? str3 : strM8569c;
        String strM8567a = TextUtils.isEmpty(strM3666k2) ? mVarUserScriptMeta8482B0.getDescription() : strM3666k2;
        String strM8569c2 = mVarUserScriptMeta8482B0.get("author") == null ? strM3666k3 : mVarUserScriptMeta8482B0.get("author");
        String strM8569c3 = mVarUserScriptMeta8482B0.get("require");
        String strM8569c4 = mVarUserScriptMeta8482B0.get("exclude");
        String strM8569c5 = mVarUserScriptMeta8482B0.get("icon");
        String strM8569c6 = mVarUserScriptMeta8482B0.get("source");
        String strM8480A0 = m8480A0(mVarUserScriptMeta8482B0.get("resource") == null ? null : mVarUserScriptMeta8482B0.get("resource"));
        String strM8569c7 = mVarUserScriptMeta8482B0.get("include") == null ? null : mVarUserScriptMeta8482B0.get("include");
        String strM8569c8 = mVarUserScriptMeta8482B0.get("match") == null ? null : mVarUserScriptMeta8482B0.get("match");
        String strM8569c9 = mVarUserScriptMeta8482B0.get("grant") == null ? null : mVarUserScriptMeta8482B0.get("grant");
        String strM8569c10 = mVarUserScriptMeta8482B0.get("version") == null ? "1.0" : mVarUserScriptMeta8482B0.get("version");
        String strM8569c11 = mVarUserScriptMeta8482B0.get("namespace") != null ? mVarUserScriptMeta8482B0.get("namespace") : "";
        if (TextUtils.isEmpty(strM3666k5)) {
            strM3666k5 = AbstractCryptoUtils.toMd5(strM3666k4);
        }
        String str5 = strM3666k5;
        String str6 = TextUtils.isEmpty(strM8569c6) ? str2 : strM8569c6;
        if (TextUtils.isEmpty(strM8569c5)) {
            strM8569c5 = m8562y(mVarUserScriptMeta8482B0.getType());
        }
        String str7 = strM8569c5;
        m8555u(str7);
        String strM8568b = mVarUserScriptMeta8482B0.m8568b();
        if (TextUtils.isEmpty(strM3666k6)) {
            strM3666k6 = strM8568b;
        }
        int iM8507O = m8507O(mVarUserScriptMeta8482B0.get("run-at"));
        int iM8572f = mVarUserScriptMeta8482B0.getType();
        if (iM8507O == 3) {
            strM3666k6 = "ep.menu.main";
        } else if (iM8507O == 4) {
            strM3666k6 = "ep.menu.context";
        } else if (iM8507O == 5) {
            strM3666k6 = "ep.menu.tool";
        }
        String str8 = strM3666k6;
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        if (m8512Q0(writableDatabase, str5, str4, strM8569c11, str3, strM8567a, str7, strM8569c2, strM3666k4, str8, strM8569c3, strM8569c4, strM8480A0, strM8569c7, strM8569c8, strM8569c9, strM8569c10, iM8507O, iM8572f) < 0) {
            m8559w0(writableDatabase, str5, str4, strM8569c11, str3, strM8567a, strM8569c2, strM3666k4, str8, strM8569c3, strM8569c4, str7, str6, strM8480A0, strM8569c7, strM8569c8, strM8569c9, strM8569c10, iM8507O, iM8572f);
        }
        SyncManager.getInstance().getResourceManager("syncable_user_script").incrementVersion();
        MenuConfigManager.getInstance().m7037t();
        return str5;
    }

    public String m8511Q() {
        String strReplaceAll;
        int iM8715w;
        String strReplaceAll2 = "";
        if (SharedPreferencesHelper.getInstance().m6893f0()) {
            int i2 = SharedPreferencesHelper.getInstance().goodForEyeColor;
            if (ThemeManager.getInstance().isColorLight(i2)) {
                strReplaceAll = "data:text/css,.toggle.active{background-color:transparent;border:2px solid #579ef1;box-shadow:inset 0 0 0 13px #579ef1!important;}html,body,iframe,table,tr,td,th,tbody,form,article,dt,ul,ol,li,dl,dd,section,footer,nav,strong,aside,header,label,address,bdo,big,blockquote,caption,center,cite,dialog,dir,fieldset,figcaption,figure,main,pre,small,h1,h2,h3,h4,h5,h6{background:#000000!important;background-image:none!important;background-color:#000000!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div{background-color:transparent!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div[class*=\"guide\"],div[class*=\"banner\"],div[class*=\"dialog\"],div[class*=\"header\"],div[class*=\"nav\"],div[class*=\"box\"],div[class*=\"content\"]{background-color:#000000!important;color:#7f7f7f!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div[class*='dialog']{;border:1px solid #212A32!important}div[class=\"game-icon-layer\"],div[id=\"slides\"],div[class=\"icon\"]{background:none!important}p{color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}html,body{scrollbar-base-color:#46567b!important;scrollbar-face-color:#56688f!important;scrollbar-shadow-color:#222!important;scrollbar-highlight-color:#56688f!important;scrollbar-dlight-color:#2e3952!important;scrollbar-darkshadow-color:#222!important;scrollbar-track-color:#46567b!important;scrollbar-arrow-color:#000!important;scrollbar-3dlight-color:#7a7967!important}input,select,button,textarea{box-shadow:0 0 0!important;color:#7f7f7f!important;background-color:#000000!important;border-color:#212A32!important;opacity:1}span,em{background-color:transparent!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}input:focus,select:focus,option:focus,button:focus,textarea:focus{background-color:#000000!important;color:#7f7f7f!important;border-color:#7f7f7f!important;outline:2px solid #7f7f7f!important}input[type=text],input[type=password]{background-image:none!important}input[type=submit],button{border:1px solid #212A32!important}img[src],input[type=image],input[type=checkbox],input[type=file]{opacity:.3}a,a *{background-color:transparent!important;color:#5C84AC!important;text-decoration:none!important;border-color:#212A32!important;text-shadow:0 0 0!important}a:visited,a:visited *{color:#3C648C!important}a:active{color:none!important;border-color:none!important}a img{background:none!important}button.suggest-item-title{background-color:#000000!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div:empty,div[id=\"x-video-button\"],div[class=\"x-advert\"],div[class=\"player_controls svp_ctrl\"]{background-color:transparent!important}span,em{background-color:transparent!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}html input[type=image]:hover{opacity:1}div[class=\"img-view\"],ul[id=\"imgview\"],a[class^=\"prev\"],a[class^=\"next\"]a[class^=\"topic_img\"],a[class^=\"arrow\"],a:active[class^=\"arrow\"],a:visited[class^=\"arrow\"],img[src^=\"data\"],img[loaded=\"1\"]{background:none!important}a[class^=\"arrow\"]{height:0}.anythingSlider .arrow{background:none!important}#toolbarBox,#move_tip{background:none!important}#logolink,#mask{background-color:#000000!important;border-bottom:none!important}div::after{background-color:transparent!important}*:before,*:after{background-color:transparent!important;border-color:#212A32!important;color:#7f7f7f!important}input::-webkit-input-placeholder{color:#7f7f7f!important}div[class=\"x-prompt\"],div[class=\"x-dashboard\"]{background:none!important}div[class=\"x-progress-play-mini\"]{background:#eb3c10!important}div[class=\"suggest-box\"]{background:#000000!important}div[class=\"x-console\"],div[class=\"x-progress\"],div[class=\"x-progress-seek\"]{background:none!important}div[class=\"x-progress-track\"]{background-color:#555555!important}div[class=\"x-progress-load\"]{background-color:#909090!important}div[class=\"x-progress-play\"],div[class=\"x-seek-handle\"]{background-color:#eb3c10!important}div[class=\"chain-con te\"],div[class=\"chain-arrow\"],div[class=\"toolbar\"],div[class=\"toolbar-con\"],div[id=\"index-box\"],div[class=\"suggest-div\"],div[class=\"suggest-box\"],div[class=\"nova-suggest\"],div[class=\"suggest-container\"],div.suggest-container.suggest-history,div[class=\"s-sugs\"],div[class=\"gstl_0 sbdd_a\"],div[class=\"se-inner\"],div[id=\"blabla-pro\"],div[id=\"fixedTitle\"],div[class=\"searchboxtop\"],div[select=\"domain\"],div[class=\"dialog\"],div[id=\"doc-link-box\"],div[id=\"searchInputBoxHistory\"],div[class=\"nearby-geolocate\"],div[class=\"popImgInr\"],div[class=\"sebox\"],div[class=\"suggest-pop\"],div[class=\"dbtg\"],div[class=\"nav-home ng-scope fixed-top\"],div[class=\"ui-suggestion-content\"],div[class=\"sw-cat\"],div[class=\"bxzbb se-sug J_SeIpt_Sug\"],input[id=\"J_searchtext\"],textarea.se-input,button[id=\"se-bn\"],button[id=\"index-bn\"],a.btn,div[class=\"weather-panel-in\"],div[class=\"schWrap fat\"],div[class=\"headerNav clearfix\"],div[class=\"foot_comment\"],s[class=\"weather-blank\"],select.weather-panel-province,select.weather-panel-city,select.weather-panel-town,div[node-type=\"box\"],div[class=\"lymb-thumb\"],a[class=\"signup_a\"],div[node-type=\"tipBox\"],div[class=\"common_search_sug\"],div[id=\"mHeader\"],div[class=\"fastli\"],div[class=\"search-box\"],div[class=\"dk_bar_sy1\"],span[id=\"wy\"],div[class=\"ui-suggestion\"],div[class=\"hot-sug\"],div[class=\"ui-suggestion-result no-result\"],div[class=\"ui-suggestion-clear\"],.pic-list li p,a.h-tab,.pic-list-n li p,div[class=\"wszh\"],.wszh span:first-child,div[class=\"ad_list\"],div[class=\"ui-suggestion-button\"],selection.tips-bar,a.sort-new,div[class=\"shareTip active\"],a#_allcomlist2,div[class=\"weather-panel-area-wrap\"],div[class=\"page transition center\"],option,#nav-view .rec li.add span:last-child,div[class=\"g-navbar ng-scope ng-isolate-scope\"],div[class=\"common_search shadow\"],div[class=\"ui-suggestion-quickdel\"],div[class=\"input-text search-area\"],div[class=\"-col-auto\"],div[class=\"locbar row -bg-light -ft-tertiary\"],div[class=\"log\"],div[class=\"head_channels\"],.channels ul li,nav[class=\"nav-mod\"],h3.weather-panel-tit,span.gbgs4,.ml-map,table.suggestions,.ml-settings-top,div[jsaction=\"settings.drag;pointerleave:settings.drag;pointerup:settings.drag;pointermove:settings.drag;pointerdown:settings.drag;touchstart:settings.drag;touchleave:settings.drag;touchmove:settings.drag;touchend:settings.drag\"],div.title,div.livetit,footer#ft,button#neighbor_getpos.pio-btn,div[id=\"cardsmanger\"],em.title_news,td.gssb_e,nav,h3,div[class=\"summary2\"],div.info,div.g-header-input-container,form.g-header-v1 .g-header-search-form,ul[class=\"cate\"],div[id=\"bd\"],div[id=\"doc\"],div.titlebar,div.from,div.input-container,input#searchInputBox.q,div.rt-startend-container,input#lineStartInputBox.rt-text,input#lineEndInputBox.rt-text,div.chart-hd,div.chart-nav2,div.nav-quirk,div.nav-main,div[class=\"mod-caizhong clearfix\"],div#hd.zst-top,div.table-more,div.input-container,input#q.q,a.down,p.tit,h2#navtit,div.head,ul.pick-betting,div.pick-c,div.pop-box,div.dg-foot,div.btm-bar,.errType textarea,div.gotop,div[class$=\"dsk\"],div.p_tabnav_nav,div.p_tabnav,div.bst_wrap,p.footer_c,div.footer,.pick-b,.index-widget-searchbox .search-area .se-input-poi,button#se-btn.btn.-brand,div.input-wrapper,input[class=\"search-input top-search-bar\"],app-card{background:#000000!important}div.ml-did-you-mean-query-correction-container{background-color:rgba(163,157,157,1)!important}textarea#q.g-header-q{border:#7f7f7f!important}.card-wrap app-card{border-bottom:#000000!important}.-bg-normal,.g-header-v1 .g-header-search-button,header,div#tsfi.msfi,div#gbr,button.g-header-search-button,.sumext-wenda .fold-btn,.search-mod .search-btn,ui.chart-tag,ol.gbtc{background-color:#000000!important}section[class=\"switch-page-main\"],div[class=\"container shelf\"],header[class=\"hd switch-page-tab\"],div[class=\"page center current\"],div[class=\"page transition right100\"],div[class=\"container nsh\"],.pic-list li,.pick-red li span,.pick-blue li span,h1.title,ul.item,ul.pic-list,div[class=\"page-content rank-content\"],ol.rank-list,div[class=\"page-content cate-content\"],ul[class=\"classification-nav js-classify\"],.classification-nav li,.rank-list li,div[id=\"nsh-anim\"],section.anzaibody,div.info,nav.switch-page-tab-nav,li.pic,div.content,ul.item,div.container-bd,b.name,div[class=\"flyout popover_visible\"]{background-color:#000000!important}.shelf .item li,.recommended li{border-bottom:1px solid #000000!important}.tab-cont .pitch,.pick-red li .selected,.pick-red li.selected span{background-color:#E62217!important}.pick-blue li .selected{background-color:#2152b7!important}td.dg-bet-btn.dg-bet-btn-active{background:#0a9400!important}.k3bet-table td.on{background:#0e4417!important}.select-boll-list li.active .poker-num{background:#0c5322!important}.ml-searchbox input,.ml-searchbox,html input[type=button]:hover,input[type=checkbox]:hover,input[type=file]:hover,input[type=radio]:hover,input[type=reset]:hover,input[type=submit]:hover{background-color:#343434!important;color:#7f7f7f!important}b.name,b.icon{color:#7f7f7f!important}h1#logo{background-color:transparent!important}.weather-panel-tit{border-bottom:#000000!important}select{-webkit-appearance:none!important;box-sizing:border-box!important;align-items:center!important;border:1px solid!important;border-image-source:initial!important;border-image-slice:initial!important;border-image-width:initial!important;border-image-outset:initial!important;border-image-repeat:initial!important;white-space:pre!important;-webkit-rtl-ordering:logical!important;color:#0c5322!important;background-color:#0c5322!important}div.ml-searchbox-settings-button,td#gs_tti50.gsib_a,form[id=ml-searchboxform\"],div#J_Shade{background-color:#343434!important;color:#7f7f7f!important}span.js-nodetail.btn.read-btn{background-color:#40c802!important}.pic_slider div img{opacity:.3!important}".replaceAll("#000000", AndroidSystemUtils.m8696d(i2)).replaceAll("opacity:1", "").replaceAll("opacity:\\.3", "").replaceAll("#7f7f7f", "#272727").replaceAll("opacity:\\.3!important", "").replaceAll("#579ef1", AndroidSystemUtils.m8696d(AndroidSystemUtils.m8716x(i2)));
                iM8715w = AndroidSystemUtils.m8716x(i2);
            } else {
                strReplaceAll = "data:text/css,.toggle.active{background-color:transparent;border:2px solid #579ef1;box-shadow:inset 0 0 0 13px #579ef1!important;}html,body,iframe,table,tr,td,th,tbody,form,article,dt,ul,ol,li,dl,dd,section,footer,nav,strong,aside,header,label,address,bdo,big,blockquote,caption,center,cite,dialog,dir,fieldset,figcaption,figure,main,pre,small,h1,h2,h3,h4,h5,h6{background:#000000!important;background-image:none!important;background-color:#000000!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div{background-color:transparent!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div[class*=\"guide\"],div[class*=\"banner\"],div[class*=\"dialog\"],div[class*=\"header\"],div[class*=\"nav\"],div[class*=\"box\"],div[class*=\"content\"]{background-color:#000000!important;color:#7f7f7f!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div[class*='dialog']{;border:1px solid #212A32!important}div[class=\"game-icon-layer\"],div[id=\"slides\"],div[class=\"icon\"]{background:none!important}p{color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}html,body{scrollbar-base-color:#46567b!important;scrollbar-face-color:#56688f!important;scrollbar-shadow-color:#222!important;scrollbar-highlight-color:#56688f!important;scrollbar-dlight-color:#2e3952!important;scrollbar-darkshadow-color:#222!important;scrollbar-track-color:#46567b!important;scrollbar-arrow-color:#000!important;scrollbar-3dlight-color:#7a7967!important}input,select,button,textarea{box-shadow:0 0 0!important;color:#7f7f7f!important;background-color:#000000!important;border-color:#212A32!important;opacity:1}span,em{background-color:transparent!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}input:focus,select:focus,option:focus,button:focus,textarea:focus{background-color:#000000!important;color:#7f7f7f!important;border-color:#7f7f7f!important;outline:2px solid #7f7f7f!important}input[type=text],input[type=password]{background-image:none!important}input[type=submit],button{border:1px solid #212A32!important}img[src],input[type=image],input[type=checkbox],input[type=file]{opacity:.3}a,a *{background-color:transparent!important;color:#5C84AC!important;text-decoration:none!important;border-color:#212A32!important;text-shadow:0 0 0!important}a:visited,a:visited *{color:#3C648C!important}a:active{color:none!important;border-color:none!important}a img{background:none!important}button.suggest-item-title{background-color:#000000!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div:empty,div[id=\"x-video-button\"],div[class=\"x-advert\"],div[class=\"player_controls svp_ctrl\"]{background-color:transparent!important}span,em{background-color:transparent!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}html input[type=image]:hover{opacity:1}div[class=\"img-view\"],ul[id=\"imgview\"],a[class^=\"prev\"],a[class^=\"next\"]a[class^=\"topic_img\"],a[class^=\"arrow\"],a:active[class^=\"arrow\"],a:visited[class^=\"arrow\"],img[src^=\"data\"],img[loaded=\"1\"]{background:none!important}a[class^=\"arrow\"]{height:0}.anythingSlider .arrow{background:none!important}#toolbarBox,#move_tip{background:none!important}#logolink,#mask{background-color:#000000!important;border-bottom:none!important}div::after{background-color:transparent!important}*:before,*:after{background-color:transparent!important;border-color:#212A32!important;color:#7f7f7f!important}input::-webkit-input-placeholder{color:#7f7f7f!important}div[class=\"x-prompt\"],div[class=\"x-dashboard\"]{background:none!important}div[class=\"x-progress-play-mini\"]{background:#eb3c10!important}div[class=\"suggest-box\"]{background:#000000!important}div[class=\"x-console\"],div[class=\"x-progress\"],div[class=\"x-progress-seek\"]{background:none!important}div[class=\"x-progress-track\"]{background-color:#555555!important}div[class=\"x-progress-load\"]{background-color:#909090!important}div[class=\"x-progress-play\"],div[class=\"x-seek-handle\"]{background-color:#eb3c10!important}div[class=\"chain-con te\"],div[class=\"chain-arrow\"],div[class=\"toolbar\"],div[class=\"toolbar-con\"],div[id=\"index-box\"],div[class=\"suggest-div\"],div[class=\"suggest-box\"],div[class=\"nova-suggest\"],div[class=\"suggest-container\"],div.suggest-container.suggest-history,div[class=\"s-sugs\"],div[class=\"gstl_0 sbdd_a\"],div[class=\"se-inner\"],div[id=\"blabla-pro\"],div[id=\"fixedTitle\"],div[class=\"searchboxtop\"],div[select=\"domain\"],div[class=\"dialog\"],div[id=\"doc-link-box\"],div[id=\"searchInputBoxHistory\"],div[class=\"nearby-geolocate\"],div[class=\"popImgInr\"],div[class=\"sebox\"],div[class=\"suggest-pop\"],div[class=\"dbtg\"],div[class=\"nav-home ng-scope fixed-top\"],div[class=\"ui-suggestion-content\"],div[class=\"sw-cat\"],div[class=\"bxzbb se-sug J_SeIpt_Sug\"],input[id=\"J_searchtext\"],textarea.se-input,button[id=\"se-bn\"],button[id=\"index-bn\"],a.btn,div[class=\"weather-panel-in\"],div[class=\"schWrap fat\"],div[class=\"headerNav clearfix\"],div[class=\"foot_comment\"],s[class=\"weather-blank\"],select.weather-panel-province,select.weather-panel-city,select.weather-panel-town,div[node-type=\"box\"],div[class=\"lymb-thumb\"],a[class=\"signup_a\"],div[node-type=\"tipBox\"],div[class=\"common_search_sug\"],div[id=\"mHeader\"],div[class=\"fastli\"],div[class=\"search-box\"],div[class=\"dk_bar_sy1\"],span[id=\"wy\"],div[class=\"ui-suggestion\"],div[class=\"hot-sug\"],div[class=\"ui-suggestion-result no-result\"],div[class=\"ui-suggestion-clear\"],.pic-list li p,a.h-tab,.pic-list-n li p,div[class=\"wszh\"],.wszh span:first-child,div[class=\"ad_list\"],div[class=\"ui-suggestion-button\"],selection.tips-bar,a.sort-new,div[class=\"shareTip active\"],a#_allcomlist2,div[class=\"weather-panel-area-wrap\"],div[class=\"page transition center\"],option,#nav-view .rec li.add span:last-child,div[class=\"g-navbar ng-scope ng-isolate-scope\"],div[class=\"common_search shadow\"],div[class=\"ui-suggestion-quickdel\"],div[class=\"input-text search-area\"],div[class=\"-col-auto\"],div[class=\"locbar row -bg-light -ft-tertiary\"],div[class=\"log\"],div[class=\"head_channels\"],.channels ul li,nav[class=\"nav-mod\"],h3.weather-panel-tit,span.gbgs4,.ml-map,table.suggestions,.ml-settings-top,div[jsaction=\"settings.drag;pointerleave:settings.drag;pointerup:settings.drag;pointermove:settings.drag;pointerdown:settings.drag;touchstart:settings.drag;touchleave:settings.drag;touchmove:settings.drag;touchend:settings.drag\"],div.title,div.livetit,footer#ft,button#neighbor_getpos.pio-btn,div[id=\"cardsmanger\"],em.title_news,td.gssb_e,nav,h3,div[class=\"summary2\"],div.info,div.g-header-input-container,form.g-header-v1 .g-header-search-form,ul[class=\"cate\"],div[id=\"bd\"],div[id=\"doc\"],div.titlebar,div.from,div.input-container,input#searchInputBox.q,div.rt-startend-container,input#lineStartInputBox.rt-text,input#lineEndInputBox.rt-text,div.chart-hd,div.chart-nav2,div.nav-quirk,div.nav-main,div[class=\"mod-caizhong clearfix\"],div#hd.zst-top,div.table-more,div.input-container,input#q.q,a.down,p.tit,h2#navtit,div.head,ul.pick-betting,div.pick-c,div.pop-box,div.dg-foot,div.btm-bar,.errType textarea,div.gotop,div[class$=\"dsk\"],div.p_tabnav_nav,div.p_tabnav,div.bst_wrap,p.footer_c,div.footer,.pick-b,.index-widget-searchbox .search-area .se-input-poi,button#se-btn.btn.-brand,div.input-wrapper,input[class=\"search-input top-search-bar\"],app-card{background:#000000!important}div.ml-did-you-mean-query-correction-container{background-color:rgba(163,157,157,1)!important}textarea#q.g-header-q{border:#7f7f7f!important}.card-wrap app-card{border-bottom:#000000!important}.-bg-normal,.g-header-v1 .g-header-search-button,header,div#tsfi.msfi,div#gbr,button.g-header-search-button,.sumext-wenda .fold-btn,.search-mod .search-btn,ui.chart-tag,ol.gbtc{background-color:#000000!important}section[class=\"switch-page-main\"],div[class=\"container shelf\"],header[class=\"hd switch-page-tab\"],div[class=\"page center current\"],div[class=\"page transition right100\"],div[class=\"container nsh\"],.pic-list li,.pick-red li span,.pick-blue li span,h1.title,ul.item,ul.pic-list,div[class=\"page-content rank-content\"],ol.rank-list,div[class=\"page-content cate-content\"],ul[class=\"classification-nav js-classify\"],.classification-nav li,.rank-list li,div[id=\"nsh-anim\"],section.anzaibody,div.info,nav.switch-page-tab-nav,li.pic,div.content,ul.item,div.container-bd,b.name,div[class=\"flyout popover_visible\"]{background-color:#000000!important}.shelf .item li,.recommended li{border-bottom:1px solid #000000!important}.tab-cont .pitch,.pick-red li .selected,.pick-red li.selected span{background-color:#E62217!important}.pick-blue li .selected{background-color:#2152b7!important}td.dg-bet-btn.dg-bet-btn-active{background:#0a9400!important}.k3bet-table td.on{background:#0e4417!important}.select-boll-list li.active .poker-num{background:#0c5322!important}.ml-searchbox input,.ml-searchbox,html input[type=button]:hover,input[type=checkbox]:hover,input[type=file]:hover,input[type=radio]:hover,input[type=reset]:hover,input[type=submit]:hover{background-color:#343434!important;color:#7f7f7f!important}b.name,b.icon{color:#7f7f7f!important}h1#logo{background-color:transparent!important}.weather-panel-tit{border-bottom:#000000!important}select{-webkit-appearance:none!important;box-sizing:border-box!important;align-items:center!important;border:1px solid!important;border-image-source:initial!important;border-image-slice:initial!important;border-image-width:initial!important;border-image-outset:initial!important;border-image-repeat:initial!important;white-space:pre!important;-webkit-rtl-ordering:logical!important;color:#0c5322!important;background-color:#0c5322!important}div.ml-searchbox-settings-button,td#gs_tti50.gsib_a,form[id=ml-searchboxform\"],div#J_Shade{background-color:#343434!important;color:#7f7f7f!important}span.js-nodetail.btn.read-btn{background-color:#40c802!important}.pic_slider div img{opacity:.3!important}".replaceAll("#000000", AndroidSystemUtils.m8696d(i2)).replaceAll("#7f7f7f", "#f2f2f2").replaceAll("#579ef1", AndroidSystemUtils.m8696d(AndroidSystemUtils.m8716x(i2)));
                iM8715w = AndroidSystemUtils.m8715w(i2);
            }
            strReplaceAll2 = strReplaceAll.replaceAll("#212A32", AndroidSystemUtils.m8696d(iM8715w));
        } else if (SharedPreferencesHelper.getInstance().enterNightMode && Build.VERSION.SDK_INT < 29) {
            strReplaceAll2 = "data:text/css,.toggle.active{background-color:transparent;border:2px solid #579ef1;box-shadow:inset 0 0 0 13px #579ef1!important;}html,body,iframe,table,tr,td,th,tbody,form,article,dt,ul,ol,li,dl,dd,section,footer,nav,strong,aside,header,label,address,bdo,big,blockquote,caption,center,cite,dialog,dir,fieldset,figcaption,figure,main,pre,small,h1,h2,h3,h4,h5,h6{background:#000000!important;background-image:none!important;background-color:#000000!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div{background-color:transparent!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div[class*=\"guide\"],div[class*=\"banner\"],div[class*=\"dialog\"],div[class*=\"header\"],div[class*=\"nav\"],div[class*=\"box\"],div[class*=\"content\"]{background-color:#000000!important;color:#7f7f7f!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div[class*='dialog']{;border:1px solid #212A32!important}div[class=\"game-icon-layer\"],div[id=\"slides\"],div[class=\"icon\"]{background:none!important}p{color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}html,body{scrollbar-base-color:#46567b!important;scrollbar-face-color:#56688f!important;scrollbar-shadow-color:#222!important;scrollbar-highlight-color:#56688f!important;scrollbar-dlight-color:#2e3952!important;scrollbar-darkshadow-color:#222!important;scrollbar-track-color:#46567b!important;scrollbar-arrow-color:#000!important;scrollbar-3dlight-color:#7a7967!important}input,select,button,textarea{box-shadow:0 0 0!important;color:#7f7f7f!important;background-color:#000000!important;border-color:#212A32!important;opacity:1}span,em{background-color:transparent!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}input:focus,select:focus,option:focus,button:focus,textarea:focus{background-color:#000000!important;color:#7f7f7f!important;border-color:#7f7f7f!important;outline:2px solid #7f7f7f!important}input[type=text],input[type=password]{background-image:none!important}input[type=submit],button{border:1px solid #212A32!important}img[src],input[type=image],input[type=checkbox],input[type=file]{opacity:.3}a,a *{background-color:transparent!important;color:#5C84AC!important;text-decoration:none!important;border-color:#212A32!important;text-shadow:0 0 0!important}a:visited,a:visited *{color:#3C648C!important}a:active{color:none!important;border-color:none!important}a img{background:none!important}button.suggest-item-title{background-color:#000000!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}div:empty,div[id=\"x-video-button\"],div[class=\"x-advert\"],div[class=\"player_controls svp_ctrl\"]{background-color:transparent!important}span,em{background-color:transparent!important;color:#7f7f7f!important;border-color:#212A32!important;box-shadow:0 0 0!important;text-shadow:0 0 0!important}html input[type=image]:hover{opacity:1}div[class=\"img-view\"],ul[id=\"imgview\"],a[class^=\"prev\"],a[class^=\"next\"]a[class^=\"topic_img\"],a[class^=\"arrow\"],a:active[class^=\"arrow\"],a:visited[class^=\"arrow\"],img[src^=\"data\"],img[loaded=\"1\"]{background:none!important}a[class^=\"arrow\"]{height:0}.anythingSlider .arrow{background:none!important}#toolbarBox,#move_tip{background:none!important}#logolink,#mask{background-color:#000000!important;border-bottom:none!important}div::after{background-color:transparent!important}*:before,*:after{background-color:transparent!important;border-color:#212A32!important;color:#7f7f7f!important}input::-webkit-input-placeholder{color:#7f7f7f!important}div[class=\"x-prompt\"],div[class=\"x-dashboard\"]{background:none!important}div[class=\"x-progress-play-mini\"]{background:#eb3c10!important}div[class=\"suggest-box\"]{background:#000000!important}div[class=\"x-console\"],div[class=\"x-progress\"],div[class=\"x-progress-seek\"]{background:none!important}div[class=\"x-progress-track\"]{background-color:#555555!important}div[class=\"x-progress-load\"]{background-color:#909090!important}div[class=\"x-progress-play\"],div[class=\"x-seek-handle\"]{background-color:#eb3c10!important}div[class=\"chain-con te\"],div[class=\"chain-arrow\"],div[class=\"toolbar\"],div[class=\"toolbar-con\"],div[id=\"index-box\"],div[class=\"suggest-div\"],div[class=\"suggest-box\"],div[class=\"nova-suggest\"],div[class=\"suggest-container\"],div.suggest-container.suggest-history,div[class=\"s-sugs\"],div[class=\"gstl_0 sbdd_a\"],div[class=\"se-inner\"],div[id=\"blabla-pro\"],div[id=\"fixedTitle\"],div[class=\"searchboxtop\"],div[select=\"domain\"],div[class=\"dialog\"],div[id=\"doc-link-box\"],div[id=\"searchInputBoxHistory\"],div[class=\"nearby-geolocate\"],div[class=\"popImgInr\"],div[class=\"sebox\"],div[class=\"suggest-pop\"],div[class=\"dbtg\"],div[class=\"nav-home ng-scope fixed-top\"],div[class=\"ui-suggestion-content\"],div[class=\"sw-cat\"],div[class=\"bxzbb se-sug J_SeIpt_Sug\"],input[id=\"J_searchtext\"],textarea.se-input,button[id=\"se-bn\"],button[id=\"index-bn\"],a.btn,div[class=\"weather-panel-in\"],div[class=\"schWrap fat\"],div[class=\"headerNav clearfix\"],div[class=\"foot_comment\"],s[class=\"weather-blank\"],select.weather-panel-province,select.weather-panel-city,select.weather-panel-town,div[node-type=\"box\"],div[class=\"lymb-thumb\"],a[class=\"signup_a\"],div[node-type=\"tipBox\"],div[class=\"common_search_sug\"],div[id=\"mHeader\"],div[class=\"fastli\"],div[class=\"search-box\"],div[class=\"dk_bar_sy1\"],span[id=\"wy\"],div[class=\"ui-suggestion\"],div[class=\"hot-sug\"],div[class=\"ui-suggestion-result no-result\"],div[class=\"ui-suggestion-clear\"],.pic-list li p,a.h-tab,.pic-list-n li p,div[class=\"wszh\"],.wszh span:first-child,div[class=\"ad_list\"],div[class=\"ui-suggestion-button\"],selection.tips-bar,a.sort-new,div[class=\"shareTip active\"],a#_allcomlist2,div[class=\"weather-panel-area-wrap\"],div[class=\"page transition center\"],option,#nav-view .rec li.add span:last-child,div[class=\"g-navbar ng-scope ng-isolate-scope\"],div[class=\"common_search shadow\"],div[class=\"ui-suggestion-quickdel\"],div[class=\"input-text search-area\"],div[class=\"-col-auto\"],div[class=\"locbar row -bg-light -ft-tertiary\"],div[class=\"log\"],div[class=\"head_channels\"],.channels ul li,nav[class=\"nav-mod\"],h3.weather-panel-tit,span.gbgs4,.ml-map,table.suggestions,.ml-settings-top,div[jsaction=\"settings.drag;pointerleave:settings.drag;pointerup:settings.drag;pointermove:settings.drag;pointerdown:settings.drag;touchstart:settings.drag;touchleave:settings.drag;touchmove:settings.drag;touchend:settings.drag\"],div.title,div.livetit,footer#ft,button#neighbor_getpos.pio-btn,div[id=\"cardsmanger\"],em.title_news,td.gssb_e,nav,h3,div[class=\"summary2\"],div.info,div.g-header-input-container,form.g-header-v1 .g-header-search-form,ul[class=\"cate\"],div[id=\"bd\"],div[id=\"doc\"],div.titlebar,div.from,div.input-container,input#searchInputBox.q,div.rt-startend-container,input#lineStartInputBox.rt-text,input#lineEndInputBox.rt-text,div.chart-hd,div.chart-nav2,div.nav-quirk,div.nav-main,div[class=\"mod-caizhong clearfix\"],div#hd.zst-top,div.table-more,div.input-container,input#q.q,a.down,p.tit,h2#navtit,div.head,ul.pick-betting,div.pick-c,div.pop-box,div.dg-foot,div.btm-bar,.errType textarea,div.gotop,div[class$=\"dsk\"],div.p_tabnav_nav,div.p_tabnav,div.bst_wrap,p.footer_c,div.footer,.pick-b,.index-widget-searchbox .search-area .se-input-poi,button#se-btn.btn.-brand,div.input-wrapper,input[class=\"search-input top-search-bar\"],app-card{background:#000000!important}div.ml-did-you-mean-query-correction-container{background-color:rgba(163,157,157,1)!important}textarea#q.g-header-q{border:#7f7f7f!important}.card-wrap app-card{border-bottom:#000000!important}.-bg-normal,.g-header-v1 .g-header-search-button,header,div#tsfi.msfi,div#gbr,button.g-header-search-button,.sumext-wenda .fold-btn,.search-mod .search-btn,ui.chart-tag,ol.gbtc{background-color:#000000!important}section[class=\"switch-page-main\"],div[class=\"container shelf\"],header[class=\"hd switch-page-tab\"],div[class=\"page center current\"],div[class=\"page transition right100\"],div[class=\"container nsh\"],.pic-list li,.pick-red li span,.pick-blue li span,h1.title,ul.item,ul.pic-list,div[class=\"page-content rank-content\"],ol.rank-list,div[class=\"page-content cate-content\"],ul[class=\"classification-nav js-classify\"],.classification-nav li,.rank-list li,div[id=\"nsh-anim\"],section.anzaibody,div.info,nav.switch-page-tab-nav,li.pic,div.content,ul.item,div.container-bd,b.name,div[class=\"flyout popover_visible\"]{background-color:#000000!important}.shelf .item li,.recommended li{border-bottom:1px solid #000000!important}.tab-cont .pitch,.pick-red li .selected,.pick-red li.selected span{background-color:#E62217!important}.pick-blue li .selected{background-color:#2152b7!important}td.dg-bet-btn.dg-bet-btn-active{background:#0a9400!important}.k3bet-table td.on{background:#0e4417!important}.select-boll-list li.active .poker-num{background:#0c5322!important}.ml-searchbox input,.ml-searchbox,html input[type=button]:hover,input[type=checkbox]:hover,input[type=file]:hover,input[type=radio]:hover,input[type=reset]:hover,input[type=submit]:hover{background-color:#343434!important;color:#7f7f7f!important}b.name,b.icon{color:#7f7f7f!important}h1#logo{background-color:transparent!important}.weather-panel-tit{border-bottom:#000000!important}select{-webkit-appearance:none!important;box-sizing:border-box!important;align-items:center!important;border:1px solid!important;border-image-source:initial!important;border-image-slice:initial!important;border-image-width:initial!important;border-image-outset:initial!important;border-image-repeat:initial!important;white-space:pre!important;-webkit-rtl-ordering:logical!important;color:#0c5322!important;background-color:#0c5322!important}div.ml-searchbox-settings-button,td#gs_tti50.gsib_a,form[id=ml-searchboxform\"],div#J_Shade{background-color:#343434!important;color:#7f7f7f!important}span.js-nodetail.btn.read-btn{background-color:#40c802!important}.pic_slider div img{opacity:.3!important}";
        }
        if (TextUtils.isEmpty(strReplaceAll2)) {
            return "data:text/css,html,body,a,div,p,img,textarea{-webkit-touch-callout:text !important;-webkit-user-select:text !important;user-select:text !important;}";
        }
        return strReplaceAll2 + "html,body,a,div,p,img,textarea{-webkit-touch-callout:text !important;-webkit-user-select:text !important;user-select:text !important;}";
    }

    public long m8512Q0(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i2, int i3) {
        Cursor cursorQuery = sQLiteDatabase.query("user_script", DatabaseColumns.USER_SCRIPT, "script_id= ?", new String[]{str}, null, null, null);
        if (Build.VERSION.SDK_INT >= 28) {
            ((AbstractWindowedCursor) cursorQuery).setWindow(AbstractC1969kf.m8296a("bigwindow", 5242880L));
        }
        if (cursorQuery == null) {
            return -1L;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                return -1L;
            }
            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str2);
            contentValues.put("namespace", str3);
            contentValues.put("title", str4);
            contentValues.put("script_desc", str5);
            contentValues.put("icon_url", str6);
            contentValues.put("create_by", str7);
            contentValues.put("script_data", str8);
            contentValues.put("ex_point", str9);
            contentValues.put("include_script", str10);
            contentValues.put("resources", str12);
            contentValues.put("version", str16);
            contentValues.put("exclude", str11);
            contentValues.put("auto_run_at", Integer.valueOf(i2));
            contentValues.put("type", Integer.valueOf(i3));
            m8488E0(str, str4, str5, str7, str8, str10, str12, str11, str13, str14, str15, str16);
            contentValues.put("create_at", Long.valueOf(System.currentTimeMillis()));
            sQLiteDatabase.update("user_script", contentValues, "_id=" + j2, null);
            return j2;
        } finally {
            cursorQuery.close();
        }
    }

    public String m8513R(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("user_script", DatabaseColumns.USER_SCRIPT, "name= ? AND namespace= ?", new String[]{str, str2}, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("version"));
                    jSONObject.put("name", str);
                    jSONObject.put("installed", true);
                    jSONObject.put("enabled", i2 != 0);
                    jSONObject.put("version", string);
                } else {
                    jSONObject.put("name", str);
                    jSONObject.put("installed", false);
                }
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public String m8514S() {
        JSONObject jSONObject = new JSONObject();
        for (int i2 = 0; i2 < this.f6187b.size(); i2++) {
            new JSONArray().put(((String) this.f6187b.get(Integer.valueOf(i2))) + "_main");
        }
        return jSONObject.toString();
    }

    public final String getScriptPath(String str) {
        return PhoneUtils.getInstance().getAppFilesDir() + "/" + Math.abs(("XMonkey_1.2.5_" + str).hashCode());
    }

    public final String m8516U(String str) throws UnsupportedEncodingException {
        String strM8691Y = "";
        try {
            if (str.startsWith("http")) {
                strM8691Y = new String(m8517V(str), StandardCharsets.UTF_8);
            } else if (str.startsWith("data:")) {
                String[] strArrM470y = NetworkUtils.parseDataUriLegacy(str);
                if (strArrM470y.length == 3) {
                    strM8691Y = URLDecoder.decode(strArrM470y[2], "utf-8");
                }
            } else if (str.startsWith("assets:")) {
                strM8691Y = AndroidSystemUtils.readStreamToString(BrowserActivity.getActivity().getAssets().open(str.substring(7)));
                Log.d("js-manager", "get require lib from assets:" + str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return strM8691Y;
    }

    public final byte[] m8517V(String str) throws IOException {
        String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(str, 1);
        if (FileUtils.fileExists(strM2046a)) {
            return FileUtils.readFileToByteArray(strM2046a);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C0232F1.m1169l().m1175j(str, new i(countDownLatch), 1);
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return FileUtils.readFileToByteArray(strM2046a);
    }

    public String getUserScriptResourceValue(String scriptId, String key) {
        if (TextUtils.isEmpty(scriptId)) {
            return "";
        }

        String resourcesJson = getUserScriptResources(scriptId);
        if (TextUtils.isEmpty(resourcesJson)) {
            return "";
        }

        try {
            return new JSONObject(resourcesJson).getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Reads the content of a file in the app's files directory.
     * If the file does not exist, returns a JavaScript toast string indicating a missing library.
     *
     * @param fileName The name of the file to read.
     * @return File content as a string, or JS toast message if file is missing.
     */
    public String readAppFileOrToast(String fileName) {
        String filePath = PhoneUtils.getInstance().getAppFilesDir() + "/" + fileName;

        if (FileUtils.fileExists(filePath)) {
            return FileUtils.readFileToString(filePath);
        }

        return "mbrowser.showToast('lost lib:" + fileName + "');";
    }

    /**
     * Retrieves the 'resources' field for a given script ID from the user_script table.
     *
     * @param scriptId The ID of the script to query.
     * @return The resources string if found; otherwise null.
     */
    public final String getUserScriptResources(String scriptId) {
        String resources = null;
        String[] selectionArgs = {scriptId};

        try (Cursor cursor = MySQLiteOpenHelper.getInstance()
                .getReadableDatabase()
                .query(
                        "user_script",
                        new String[]{"resources"}, // only select the column we need
                        "script_id = ?",
                        selectionArgs,
                        null,
                        null,
                        null
                )) {

            if (cursor != null && cursor.moveToFirst()) {
                resources = cursor.getString(cursor.getColumnIndexOrThrow("resources"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resources;
    }

    /**
     * Retrieves the 'source' field for a given script ID from the user_script table.
     * Uses a cursor window of 5MB for large data on Android P+ (API 28+).
     *
     * @param scriptId The ID of the script to query.
     * @return The source string if found; otherwise null.
     */
    public String getUserScriptSource(String scriptId) {
        String source = null;
        String[] selectionArgs = {scriptId};

        try (Cursor cursor = MySQLiteOpenHelper.getInstance()
                .getReadableDatabase()
                .query(
                        "user_script",
                        new String[]{"source"}, // select only the source column
                        "script_id = ?",
                        selectionArgs,
                        null,
                        null,
                        null
                )) {

            if (cursor != null) {
                if (Build.VERSION.SDK_INT >= 28 && cursor instanceof AbstractWindowedCursor) {
                    // Set a larger cursor window for large data
                    AbstractC2015lf.m8396a();
                    ((AbstractWindowedCursor) cursor).setWindow(
                            AbstractC1969kf.m8296a("bigwindow", 5 * 1024 * 1024L)
                    );
                }

                if (cursor.moveToFirst()) {
                    source = cursor.getString(cursor.getColumnIndexOrThrow("source"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return source;
    }

    /**
     * Deletes a resource mapping by its resource key.
     *
     * @param resourceKey The key of the resource to delete.
     * @throws SQLException if a database error occurs.
     */
    public void deleteResourceMap(String resourceKey) throws SQLException {
        try {
            MySQLiteOpenHelper.getInstance()
                    .getWritableDatabase()
                    .delete(
                            "resource_map",
                            "resource_key = ?",
                            new String[]{resourceKey}
                    );
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Failed to delete resource_map for key: " + resourceKey, e);
        }
    }

    public String m8523a0(String str) {
        try {
            return JsonUtils.getString(new JSONObject(getUserScriptJson(str)), "title", "");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void m8524b(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject(str3);
        String strM3665j = JsonUtils.getString(jSONObject, "url");
        String strM3665j2 = JsonUtils.getString(jSONObject, "tag");
        String strM3665j3 = JsonUtils.getString(jSONObject, "name");
        JSONObject jSONObjectM3662g = JsonUtils.getJSONObject(jSONObject, "headers");
        String strM6849D = SharedPreferencesHelper.getInstance().m6849D();
        if (strM6849D == null) {
            strM6849D = SharedPreferencesHelper.defaultUserAgent;
        }
        String str4 = strM6849D;
        HashMap map = new HashMap<>();
        if (jSONObjectM3662g != null) {
            Iterator<String> itKeys = jSONObjectM3662g.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectM3662g.getString(next));
            }
        }
        BrowserDownloadManager.getInstance().m6684J(strM3665j, null, str4, strM3665j3, null, -1L, strM3665j2, new k(str, str2), map);
    }

    public String m8525b0(String str) {
        String strM8515T = getScriptPath(str);
        return FileUtils.fileExists(strM8515T) ? FileUtils.readFileToString(strM8515T) : "(function() { mbrowser.showToast('Load user script failed');})();";
    }

    public String m8526c(String str, String str2) {
        String strM8518W = getUserScriptResourceValue(str, str2);
        try {
            return !TextUtils.isEmpty(strM8518W) ? new String(m8517V(strM8518W), StandardCharsets.UTF_8) : "";
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getUserScriptJson(String scriptId) throws JSONException {
        JSONObject result = new JSONObject();
        String[] selectionArgs = {scriptId};

        try {
            Cursor cursor = MySQLiteOpenHelper.getInstance()
                    .getReadableDatabase()
                    .query(
                            "user_script",
                            DatabaseColumns.USER_SCRIPT,
                            "script_id = ?",
                            selectionArgs,
                            null,
                            null,
                            "create_at DESC"
                    );

            if (cursor != null) {
                // For large cursor windows on Android 9+
                if (Build.VERSION.SDK_INT >= 28) {
                    AbstractC2015lf.m8396a();
                    ((AbstractWindowedCursor) cursor).setWindow(
                            AbstractC1969kf.m8296a("bigwindow", 5242880L)
                    );
                }

                if (cursor.moveToFirst()) {
                    String title = cursor.getString(cursor.getColumnIndex("title"));
                    String description = cursor.getString(cursor.getColumnIndex("script_desc"));
                    String data = cursor.getString(cursor.getColumnIndex("script_data"));
                    String createdBy = cursor.getString(cursor.getColumnIndex("create_by"));
                    String executionPoint = cursor.getString(cursor.getColumnIndex("ex_point"));
                    int status = cursor.getInt(cursor.getColumnIndex("status"));

                    result.put("id", AndroidSystemUtils.prefixWithMd5(scriptId));
                    result.put("script_id", scriptId);
                    result.put("title", TextUtils.isEmpty(title) ? "unnamed" : title);
                    result.put("script_desc", TextUtils.isEmpty(description) ? "" : description);
                    result.put("script_data", data);
                    result.put("create_by", createdBy == null ? "" : createdBy);
                    result.put("ex_point", executionPoint);
                    result.put("status", status);

                    this.executionPoint = executionPoint;
                }

                cursor.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String m8528d(String str, String str2) {
        byte[] bArrM8517V;
        String strM8518W = getUserScriptResourceValue(str, str2);
        String strM457l = NetworkUtils.getMimeType(strM8518W);
        try {
            bArrM8517V = m8517V(strM8518W);
        } catch (Exception unused) {
            bArrM8517V = null;
        }
        if (bArrM8517V == null) {
            return "";
        }
        return "data:" + strM457l + ";base64," + Base64.encodeToString(bArrM8517V, 0);
    }

    public Drawable m8529d0(String str) {
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("user_script", DatabaseColumns.USER_SCRIPT, "script_id= ? ", new String[]{str}, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                return null;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("icon_url"));
            if (TextUtils.isEmpty(string)) {
                string = m8562y(0);
            }
            return C0896Td.m4137c().m4142f(string, string, 5);
        } catch (Exception unused) {
            return null;
        }
    }

    public void m8530e(String str, String str2) {
        MessageBoxManager.getInstance().m6117h(BrowserActivity.getActivity().getBrowserFrameLayout(), JsonUtils.getString(new JSONObject(str2), "text"), BrowserActivity.getActivity().getString(R.string.btn_text_ok), new j("_" + str + "_GM_notification"));
    }

    public String m8531e0() throws JSONException {
        String str = "version";
        String str2 = "icon_url";
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("user_script", DatabaseColumns.USER_SCRIPT, null, null, null, null, "create_at DESC");
            if (cursorQuery != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    AbstractC2015lf.m8396a();
                    ((AbstractWindowedCursor) cursorQuery).setWindow(AbstractC1969kf.m8296a("bigwindow", 5242880L));
                }
                if (cursorQuery.moveToFirst()) {
                    while (true) {
                        JSONObject jSONObject = new JSONObject();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("script_id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("script_desc"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(str2));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("type"));
                        long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("create_at"));
                        JSONArray jSONArray2 = jSONArray;
                        try {
                            String string5 = cursorQuery.getString(cursorQuery.getColumnIndex(str));
                            String str3 = str;
                            StringBuilder sb = new StringBuilder();
                            String str4 = str2;
                            sb.append(BrowserActivity.getActivity().getString(R.string.web_str_update_at));
                            sb.append(" ");
                            sb.append(AndroidSystemUtils.m8718z(j2));
                            String string6 = sb.toString();
                            if (TextUtils.isEmpty(string4)) {
                                try {
                                    string4 = m8562y(i2);
                                } catch (Exception e2) {
                                    e = e2;
                                    jSONArray = jSONArray2;
                                    e.printStackTrace();
                                    return jSONArray.toString();
                                }
                            }
                            int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                            jSONObject.put("id", AndroidSystemUtils.prefixWithMd5(string));
                            jSONObject.put("script_id", string);
                            if (TextUtils.isEmpty(string2)) {
                                string2 = "Unnamed";
                            }
                            jSONObject.put("title", string2);
                            if (TextUtils.isEmpty(string3)) {
                                string3 = "Empty";
                            }
                            jSONObject.put("script_desc", string3);
                            jSONObject.put(str4, string4);
                            jSONObject.put("updated_at", string6);
                            str = str3;
                            jSONObject.put(str, string5);
                            jSONObject.put("status", i3);
                            jSONArray = jSONArray2;
                            try {
                                jSONArray.put(jSONObject);
                                if (!cursorQuery.moveToNext()) {
                                    break;
                                }
                                str2 = str4;
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                return jSONArray.toString();
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    }
                }
                cursorQuery.close();
            }
        } catch (Exception e5) {
            e = e5;
        }
        return jSONArray.toString();
    }

    public String m8532f(String str) {
        byte[] bArr;
        int i2;
        Response response = (Response) this.onlineScriptMap.get(str);
        try {
            if (response.getStatus() != 200 || (i2 = response.body().byteStream().read((bArr = new byte[8192]))) <= 0) {
                return "LS08ZW5kIG9mIHN0cmVhbT4tLQ==";
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return Base64.encodeToString(bArr2, 0);
        } catch (Exception unused) {
            response.body().close();
            return "LS08ZW5kIG9mIHN0cmVhbT4tLQ==";
        }
    }

    public String m8533g(String str, String str2, String str3) {
        Log.i("reg-menu", " >>> scriptId:" + str + " name:" + str2 + " title:" + str3);
        return m8496I0(str, str2, str3);
    }

    public final boolean m8534g0(String str, String str2) {
        String str3 = str + str2;
        ScriptMap scriptMap = this.f6191f;
        return (scriptMap == null || scriptMap.get(str3) == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8535h(String r8, String r9, String r10) throws JSONException {
        /*
            r7 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r10)
            java.lang.String r10 = "url"
            java.lang.String r10 = p000.AbstractC0760Qe.m3665j(r0, r10)
            java.lang.String r1 = "headers"
            org.json.JSONObject r1 = p000.AbstractC0760Qe.m3662g(r0, r1)
            java.lang.String r2 = "data"
            java.lang.String r2 = p000.AbstractC0760Qe.m3665j(r0, r2)
            java.lang.String r3 = "responseType"
            java.lang.String r4 = "text"
            java.lang.String r3 = p000.AbstractC0760Qe.m3666k(r0, r3, r4)
            Ck$a r4 = new Ck$a
            r4.<init>()
            r4.url(r10)
            com.mmbox.xbrowser.d r5 = com.mmbox.xbrowser.SharedPreferencesHelper.getInstance()
            java.lang.String r5 = r5.m6849D()
            if (r5 != 0) goto L33
            java.lang.String r5 = com.mmbox.xbrowser.SharedPreferencesHelper.f4839X0
        L33:
            java.lang.String r6 = "User-Agent"
            r4.addHeader(r6, r5)
            java.lang.String r5 = "Accept-Language"
            java.lang.String r6 = "zh-CN,zh;q=0.9,en;q=0.8"
            r4.addHeader(r5, r6)
            java.lang.String r5 = "Accept"
        */
        //  java.lang.String r6 = "*/*"
        /*
            r4.addHeader(r5, r6)
            java.lang.String r5 = r7.m8509P(r10)
            android.webkit.CookieManager r6 = android.webkit.CookieManager.getInstance()
            java.lang.String r10 = r6.getCookie(r10)
            boolean r6 = android.text.TextUtils.isEmpty(r10)
            if (r6 != 0) goto L74
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L73
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "; "
            r6.append(r5)
            r6.append(r10)
            java.lang.String r5 = r6.toString()
            goto L74
        L73:
            r5 = r10
        L74:
            boolean r10 = android.text.TextUtils.isEmpty(r5)
            if (r10 != 0) goto L83
            java.lang.String r10 = "Cookie"
            java.lang.String r5 = r5.trim()
            r4.addHeader(r10, r5)
        L83:
            if (r1 == 0) goto L9d
            java.util.Iterator r10 = r1.keys()
        L89:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L9d
            java.lang.Object r5 = r10.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = r1.getString(r5)
            r4.m501c(r5, r6)
            goto L89
        L9d:
            boolean r10 = android.text.TextUtils.isEmpty(r2)
            if (r10 != 0) goto Ld9
            if (r1 == 0) goto Lcb
            java.lang.String r10 = "Content-type"
            r0 = 0
            java.lang.String r10 = p000.AbstractC0760Qe.m3666k(r1, r10, r0)
            boolean r5 = android.text.TextUtils.isEmpty(r10)
            if (r5 == 0) goto Lb8
            java.lang.String r10 = "Content-Type"
            java.lang.String r10 = p000.AbstractC0760Qe.m3666k(r1, r10, r0)
        Lb8:
            boolean r5 = android.text.TextUtils.isEmpty(r10)
            if (r5 == 0) goto Lc4
            java.lang.String r10 = "content-type"
            java.lang.String r10 = p000.AbstractC0760Qe.m3666k(r1, r10, r0)
        Lc4:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto Lcb
            goto Lcd
        Lcb:
            java.lang.String r10 = "application/x-www-form-urlencoded"
        Lcd:
            Pg r10 = p000.C0716Pg.m3568g(r10)
            Dk r10 = p000.AbstractC0168Dk.m717c(r10, r2)
        Ld5:
            r4.m504f(r10)
            goto Lfe
        Ld9:
            java.lang.String r10 = "data_url"
            java.lang.String r1 = ""
            java.lang.String r10 = p000.AbstractC0760Qe.m3666k(r0, r10, r1)
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto Lfe
            java.lang.String[] r10 = p000.NetworkUtils.m447b(r10)
            r0 = 0
            r1 = r10[r0]
            r2 = 2
            r10 = r10[r2]
            byte[] r10 = android.util.Base64.decode(r10, r0)
            Pg r0 = p000.C0716Pg.m3568g(r1)
            Dk r10 = p000.AbstractC0168Dk.m718d(r0, r10)
            goto Ld5
        Lfe:
            Ck r10 = r4.m500b()
            Jh r0 = r7.f6186a
            J3 r10 = r0.newCall(r10)
            mf$l r0 = new mf$l
            r0.<init>(r8, r9, r3)
            r10.mo1791i(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2061mf.m8535h(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void m8536h0(String str) {
        if (FileUtils.getFileSize(str) > 5242880) {
            BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_file_too_large));
            return;
        }
        if (!FileUtils.isMostlyTextFile(str)) {
            BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_invalid_file_format));
            return;
        }
        Toast.makeText(BrowserActivity.getActivity(), R.string.toast_installing_script, Toast.LENGTH_SHORT).show();
        try {
            m8546p0(str, FileUtils.readFileToString(str), 2);
            BrowserActivity.getActivity().showToast(BrowserActivity.getActivity().getString(R.string.toast_install_script_success));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void init() {
        Looper.myQueue().addIdleHandler(() -> {
            BackgroundTaskManager.submitBackgroundTask(() -> m8540l0());
            return false;
        });
    }

    public void m8538j0(AbstractC2359t abstractC2359t, String str) {
        Drawable drawable;
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("user_script", DatabaseColumns.USER_SCRIPT, "ex_point= ? AND status= ?", new String[]{str, "1"}, null, null, null);
            if (cursorQuery != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    AbstractC2015lf.m8396a();
                    ((AbstractWindowedCursor) cursorQuery).setWindow(AbstractC1969kf.m8296a("bigwindow", 5242880L));
                }
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("script_id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("icon_url"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("type"));
                        if (TextUtils.isEmpty(string3)) {
                            string3 = m8562y(i2);
                        }
                        boolean z = false;
                        if (TextUtils.isEmpty(string3)) {
                            drawable = null;
                        } else {
                            drawable = C0896Td.m4137c().m4142f(string3, string3, 5);
                            if (drawable != null) {
                                z = true;
                            }
                        }
                        if (drawable == null) {
                            drawable = BrowserActivity.getActivity().getResources().getDrawable(R.drawable.ic_script);
                        }
                        if (z) {
                            abstractC2359t.mo9011g(string2, drawable, -2, Integer.MAX_VALUE, string).mo2668g();
                        } else {
                            abstractC2359t.mo9011g(string2, drawable, -2, Integer.MAX_VALUE, string);
                        }
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
            if (str.equals("ep.menu.tool")) {
                getInstance().m8494H0(abstractC2359t);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void m8539k0(String str) {
        if (FileUtils.fileExists(getScriptPath(str))) {
            return;
        }
        String strM8492G0 = getAssetScriptContent("module", str);
        if (TextUtils.isEmpty(strM8492G0)) {
            return;
        }
        installScript(str, strM8492G0);
    }

    public final void m8540l0() {
        if (SharedPreferencesHelper.getInstance().f4849D) {
            m8539k0("devtools");
        }
        m8539k0("page_tts_v2");
    }

    public final void initialize() {
        if (this.httpClient == null) {
            C1112Y8 c1112y8 = new C1112Y8();
            c1112y8.m4883j(64);
            c1112y8.m4884k(5);
            this.httpClient = new OkHttpClient();
        }
    }

    public void injectJavascript(WebView webView, String name) {
        if (name.lastIndexOf(".js") < 0) {
            name = name + ".js";
        }
        String script = getAssetScriptContent("inject", name);
        if (!TextUtils.isEmpty(script)) {
            evaluateJavascript(webView, script);
        }
    }

    public void m8543o(WebView webView) {
        if (!SharedPreferencesHelper.getInstance().m6893f0()) {
            evaluateJavascript(webView, "if(window._COLOR_THEME_) window._COLOR_THEME_.removeThemeStyle()");
            if (!SharedPreferencesHelper.getInstance().enterNightMode) {
                ThemeManager.getInstance().m9474B(BrowserActivity.getActivity().getColors());
            }
        } else {
            String theme = ThemeDialog.getThemeForColor(SharedPreferencesHelper.getInstance().goodForEyeColor);
            if ("default".equals(theme)) {
                evaluateJavascript(webView, "if(window._COLOR_THEME_) window._COLOR_THEME_.removeThemeStyle()");
                ThemeManager.getInstance().m9474B(WebViewBrowserController.getColorsByTheme());
            } else {
                evaluateJavascript(webView, "if(window._COLOR_THEME_) window._COLOR_THEME_.applyColorTheme('" + theme + "')");
                ThemeManager.getInstance().m9474B(new int[]{SharedPreferencesHelper.getInstance().goodForEyeColor, SharedPreferencesHelper.getInstance().goodForEyeColor});
            }
        }
    }

    public void m8544o0(WebView webView) {
        injectJavascript(webView, "xjsapi");
        injectJavascript(webView, "color_theme");
        BrowserActivity.getActivity().getHandler().postDelayed(() -> m8543o(webView), 100L);
        m8543o(webView);
    }

    public final void m8545p(StringBuffer stringBuffer) {
        stringBuffer.append("\n");
        stringBuffer.append("!(function () {\n  if(typeof define === \"function\" && closeAmdFlag ) {\n    define.amd = true;\n  }\n})();\n");
        stringBuffer.append("})();\n");
        stringBuffer.append("/* end of script */\n");
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public String m8546p0(String r38, String r39, int r40) throws Exception {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2061mf.m8546p0(java.lang.String, java.lang.String, int):java.lang.String");
    }

    public final void m8547q(StringBuffer stringBuffer, String str, String str2) {
        stringBuffer.append("if (typeof GM == 'undefined') {\n  var GM = {\n    \"user_script_id\" : user_script_id,\n    \"user_script_title\" : user_script_title\n  };\n}\n");
        if (!TextUtils.isEmpty(str) && str.indexOf("addStyle") >= 0) {
            stringBuffer.append("function GM_addStyle (cssStr) {\n    var D               = document;\n    var newNode         = D.createElement ('style');\n    newNode.textContent = cssStr;\n    var targ    = D.getElementsByTagName ('head')[0] || D.body || D.documentElement;\n    targ.appendChild (newNode);\n    return newNode;\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("addElement") >= 0) {
            stringBuffer.append("function GM_addElement(p1, p2, p3) {\n    if(!p1) {\n       var head = document.getElementsByTagName('head').item(0);  \n        var e = document.createElement(p2);\n        for(var i in p3) {\n            if(i == 'textContent') {\n                e.innerHTML = p3[i];\n            } else {\n                e.setAttribute(i,p3[i]);\n            }\n        }\n        head.appendChild(e);\n        return e;\n    }\n    else if(typeof p1 == 'object') {\n        var e = document.createElement(p2);\n        for(var i in p3) {\n            if(i == 'textContent') {\n                e.innerHTML = p3[i];\n            } else {\n                e.setAttribute(i,p3[i]);\n            }\n\n        }\n        p1.appendChild(e);\n        return e;\n\n    } else if(typeof p1 =='string'){\n        var head = document.getElementsByTagName('head').item(0);\n        var e = document.createElement(p1);\n        for(var i in p2) {\n            if(i == 'textContent') {\n                e.innerHTML = p2[i];\n            } else {\n                e.setAttribute(i,p2[i]);\n            }\n        }\n        head.appendChild(e);\n        return e;\n    } \n    return p1;\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("getValue") >= 0) {
            stringBuffer.append("function GM_getValue(name,defaultVal) {\n    var s = mbrowser.GM_getValue(user_script_id,name);\n    if(!s) {\n        return defaultVal ;\n    }\n    try {\n     let o =  JSON.parse(s);\n     if(o.value === null) {\n        if(!o.valueType) return null;\n        if(o.valueType == \"NaN\") {\n            return NaN;\n        } else if(o.valueType ==\"Infinity\") {\n            return Infinity;\n        } else if(o.valueType == \"-Infinity\") {\n            return -Infinity;\n        } else {\n            return null;\n        }\n     }\n     else if(o.value === undefined)  {\n        return undefined;\n     }\n     else {\n        return o.value;\n     }\n    } catch(e) {\n        return defaultVal;\n    }\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("setValue") >= 0) {
            stringBuffer.append("function GM_setValue(name,value) {\n    var valueType = \"normal\";\n    if(value !== value) {\n        valueType = \"NaN\";\n    } else if(value == Infinity) {\n        valueType = \"Infinity\"\n    } else if(value == -Infinity) {\n        valueType = \"-Infinity\";\n    }\n    var o = { \"name\":name,\"value\":value,\"valueType\":valueType};\n    var val = JSON.stringify(o);\n    var oldValue = GM_getValue(name);\n    if(oldValue == undefined || oldValue != value) {\n        for(var i = 0; i < value_change_listeners.length; i++) {\n            var l = value_change_listeners[i];\n            if(l.key == name && l.cb) {\n                l.cb(name,oldValue,value,false);\n            }\n        }\n    }\n    mbrowser.GM_setValue(user_script_id,name,val);\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("listValues") >= 0) {
            stringBuffer.append("function GM_listValues() {\n    var values = [];\n    var s =  mbrowser.GM_listValueKeys(user_script_id);\n    try {\n        let keys =  JSON.parse(s);\n        for (var i=0, len = keys.length; i < len; i++){\n            values.push(keys[i]);\n        }\n    } catch(e) {\n        return values;\n    }\n    return values;\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("deleteValue") >= 0) {
            stringBuffer.append("function GM_deleteValue(name) {\n    var oldValue = GM_getValue(name);\n    mbrowser.GM_deleteValue(user_script_id,name);\n    if(oldValue != undefined) {\n        for(var i = 0; i < value_change_listeners.length; i++) {\n            var l = value_change_listeners[i];\n            if(l.key == name && l.cb) {\n                l.cb(name,oldValue,undefined,false);\n            }\n        }\n    }\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("addValueChangeListener") >= 0) {
            stringBuffer.append("function GM_addValueChangeListener(name,callback) {\n    var listener = {};\n    listener.id = parseInt(uuid(),16);\n    listener.key = name;\n    listener.cb = callback;\n    value_change_listeners.push(listener);\n    return  listener.id ;\n}");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("removeValueChangeListener") >= 0) {
            stringBuffer.append("function GM_removeValueChangeListener(listener_id) {\n    var newListeners = [];\n    for(var i = 0; i < value_change_listeners.length; i++) {\n        var listener = value_change_listeners[i];\n        if(listener.id != listener_id) {\n            newListeners.push(listener);\n        }\n    }\n    value_change_listeners = newListeners;\n}");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_log") >= 0) {
            stringBuffer.append("function GM_log(message) {\n    console.log(message);\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_notification") >= 0) {
            stringBuffer.append("function GM_notification(message,title,image,onclick) {\n    \n    if(typeof message == 'object') {\n        _XJSAPI_.g_gm_callback_map[\"_\" + user_script_id + \"_GM_notification\"] = message;\n        mbrowser.GM_notification(user_script_id,JSON.stringify(message))\n    } else if(onclick) {\n       let req = { \"text\" : message, \"onclick\" : onclick };\n       _XJSAPI_.g_gm_callback_map[\"_\" + user_script_id + \"_GM_notification\"] = req;\n       mbrowser.GM_notification(user_script_id,JSON.stringify(req));\n    } else {\n        mbrowser.showToast(message);\n    }\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_registerMenuCommand") >= 0) {
            stringBuffer.append("function GM_registerMenuCommand(title,callback) {\n    console.log(\">>>>> register menu command>>> \" + user_script_title + \"_\" + title + \" function:\" + callback);\n    var cmd = {};\n    cmd.title = title;\n    cmd.callback = callback;\n    cmd.id = mbrowser.GM_registerMenuCommand(user_script_id,user_script_title,title);\n    _XJSAPI_.g_ctx_menu_cmd.push(cmd);\n    return  cmd.id;\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_unregisterMenuCommand") >= 0) {
            stringBuffer.append("function GM_unregisterMenuCommand(commandId) {\n    var pos = -1;\n    for(var i = 0; i < _XJSAPI_.g_ctx_menu_cmd.length; i ++) {\n        var cmd = _XJSAPI_.g_ctx_menu_cmd[i];\n        if(cmd.id == commandId) {\n            pos = i;\n        }\n    }\n    if(pos >= 0) {\n        _XJSAPI_.g_ctx_menu_cmd.splice(pos,1);\n        mbrowser.GM_unregisterMenuCommand(user_script_id,commandId);\n    }  \n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_openInTab") >= 0) {
            stringBuffer.append("function GM_openInTab(url,detail) {\n    var active = true;\n    if(typeof detail == 'object') {\n        active = detail.active;\n    }     else if(detail == undefined) {       active = false;    }    else {\n        active = !detail;\n    }\n    if(active) {\n        mbrowser.openUrlOnNewTab(url,-1);\n    } else {\n        mbrowser.openUrlOnNewTab(url,-1);\n    } \n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_download") >= 0) {
            stringBuffer.append("function GM_download(req,name) {\n    if(typeof req == 'object') {\n        var trans_id = uuid();\n        _XJSAPI_.g_gm_callback_map[\"_\" + user_script_id + \"_\" + trans_id + \"_GM_download\"] = req;\n        mbrowser.GM_downloadV2(user_script_id,trans_id,JSON.stringify(req));   \n    } else {\n        mbrowser.GM_download(req,name == undefined?null:name,true,null);\n    }\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_batch_download") >= 0) {
            stringBuffer.append("function GM_batch_download(urls,package_name) {\n    alert('this method not implement now');\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_setClipboard") >= 0) {
            stringBuffer.append("function GM_setClipboard(data) {\n    mbrowser.copyToClipboard(data);\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_getResourceText") >= 0) {
            stringBuffer.append("function GM_getResourceText(name) {\n    return mbrowser.GM_getResourceText(user_script_id,name);\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_getResourceURL") >= 0) {
            stringBuffer.append("function GM_getResourceURL(name) {\n    return mbrowser.GM_getResourceURL(user_script_id,name);\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_getResourceValue") >= 0) {
            stringBuffer.append("function GM_getResourceValue(name) {\n    return mbrowser.GM_getResourceValue(user_script_id,name);\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_xmlhttpRequest") >= 0) {
            stringBuffer.append("function GM_xmlhttpRequest(req) {\n    var trans_id = uuid();\n    if(!req.url.toLowerCase().startsWith(\"http\")) {\n       var reqUrl = new URL(req.url,window.location.href); \n       req.url = reqUrl.href; \n    } \n    _XJSAPI_.g_gm_callback_map[\"_\" + user_script_id + \"_\" + trans_id + \"_GM_xmlhttpRequest\"] = req;\n    if(req.data) {\n\n       if(req.headers) {\n            if(!req.headers['Content-type'] && !req.headers['content-type'] &&  !req.headers['Content-Type']) {\n                req.headers[\"Content-type\"] = \"application/x-www-form-urlencoded\";\n            }\n        } else {\n            req.headers = { \"Content-type\" : \"application/x-www-form-urlencoded\" };\n        }\n        if(typeof req.data  == 'string') {\n             mbrowser.GM_xmlhttpRequest(user_script_id,trans_id,JSON.stringify(req));  \n        }\n        else if(req.data instanceof File) {\n            const reader = new FileReader();\n            reader.onload = () => {\n                /* 文件类型转换为base64 dataURL */\n                const dataURL = reader.result; \n                req.data = '';\n                req.data_url = dataURL;  \n                mbrowser.GM_xmlhttpRequest(user_script_id,trans_id,JSON.stringify(req));  \n\n            };\n            reader.readAsDataURL(req.data);\n\n        } else if(typeof req.data == 'object') {\n            var _formData = null;\n            for(var [key, val] of req.data.entries()) {\n                if(!_formData) {\n                    _formData = `${key}=${val}`\n                } else {\n                    _formData += `&${key}=${val}`\n                }\n            }\n            req.data = _formData;\n            mbrowser.GM_xmlhttpRequest(user_script_id,trans_id,JSON.stringify(req));  \n        } else {\n            /* 不做任何处理默认 req.data 为字符串类型 */\n            console.warn(\"not support send this data:\" + req.data);\n        }\n      \n    } else {\n        mbrowser.GM_xmlhttpRequest(user_script_id,trans_id,JSON.stringify(req));  \n    }\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_EX_sniffMedia") >= 0) {
            stringBuffer.append("function GM_EX_sniffMedia() {\n    return mbrowser.GM_EX_sniffMedia();\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_EX_getSearchEngines") >= 0) {
            stringBuffer.append("function GM_EX_getSearchEngines() {\n    return mbrowser.GM_EX_getSearchEngines();\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_EX_getAppSearchEngineUrl") >= 0) {
            stringBuffer.append("function GM_EX_getAppSearchEngineUrl(keyword) {\n    return mbrowser.GM_EX_getAppSearchEngineUrl(keyword);\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_EX_TTS") >= 0) {
            stringBuffer.append("function GM_EX_TTS(text) {\n    return mbrowser.GM_EX_TTS(text);\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_EX_ShareTextToApp") >= 0) {
            stringBuffer.append("function GM_EX_ShareTextToApp(text) {\n    return mbrowser.GM_EX_ShareTextToApp(text);\n}\n");
        }
        if (!TextUtils.isEmpty(str) && str.indexOf("GM_cookie") >= 0) {
            stringBuffer.append("function GM_cookie(action,details,callback) {\n    function _list(details,callback) {\n        var url = details.url?details.url:\"\";\n        var domain = details.domain?details.domain:\"\";\n        var name = details.name?details.name:\"\";\n        var path = details.path?details.path:\"/\";\n        var secure = details.secure?details.secure:\"\";\n\n        if(url == \"\" && domain == \"\" ) {\n            url = document.location.href;\n        }\n\n        if(window.mbrowser) {\n           var cookies =  JSON.parse(mbrowser.GM_cookie_list(url,domain,name,path));\n           if(callback) {\n            callback(cookies,null);\n           } else {\n                return Promise.resolve(cookies);\n           }\n             \n        } else {\n            if(callback) {\n                callback([],\"Error\");\n            } else {\n                return Promise.reject(\"Failure\");\n            }\n        }\n    }\n\n    function _set(details,callback) {\n        var url = details.url?details.url:\"\";\n        var domain = details.domain?details.domain:\"\";\n        var name = details.name?details.name:\"\";\n        var path = details.path?details.path:\"/\";\n        var value = details.value?details.value:\"\";\n\n        if(url == \"\" && domain == \"\" ) {\n            url = document.location.href;\n        }\n\n        if(window.mbrowser) {\n            mbrowser.GM_cookie_set(url,domain,name,value,path);\n            if(callback) {\n                callback(\"Success\");\n            } else {\n                return Promise.resolve(\"Success\");\n            }\n           \n        } else {\n            if(callback) {\n                callback(\"Error\");\n            } else {\n                return  Promise.reject(\"Failure\");\n            }    \n        }  \n    }\n\n    function _delete(details,callback) {\n        var url = details.url?details.url:document.location.href;\n        var name = details.name?details.name:\"\";\n        if(window.mbrowser) {\n            mbrowser.GM_cookie_delete(url,name);\n            if(callback) {\n                callback(\"Success\");\n            } else {\n                return Promise.resolve(\"Success\");\n            }\n        } else {\n            if(callback) {\n                callback(\"Error\");\n            } else {\n                return Promise.reject(\"Failure\");\n            }    \n        }\n    }\n    if(action == \"list\") {\n        return _list(details,callback);\n    } else if(action == \"set\") {\n        return  _set(details,callback);\n    } else if(action == \"delete\") {\n        return _delete(details,callback);\n    } else {\n        return {\n            list: _list,\n            set: _set,\n            delete: _delete\n        }\n    }\n}\n");
            if (str2.indexOf("GM_cookie.") > 0 || str2.indexOf("GM_Cookie.") > 0) {
                stringBuffer.append("var GM_cookie = GM_cookie();\n");
            }
        }
        stringBuffer.append("!(function() { \n  if(typeof GM_addStyle !== 'undefined') { GM['addStyle'] = GM_addStyle; }\n  if(typeof GM_addElement !== 'undefined') { GM['addElement'] = GM_addElement; }\n  if(typeof GM_getValue !== 'undefined') { GM['getValue'] = GM_getValue; }\n  if(typeof GM_setValue !== 'undefined') { GM['setValue'] = GM_setValue; }\n  if(typeof GM_listValues !== 'undefined') { GM['listValues'] = GM_listValues; }\n  if(typeof GM_deleteValue !== 'undefined') { GM['deleteValue'] = GM_deleteValue; }\n  if(typeof GM_addValueChangeListener !== 'undefined') { GM['addValueChangeListener'] = GM_addValueChangeListener; }\n  if(typeof GM_removeValueChangeListener !== 'undefined') { GM['removeValueChangeListener'] = GM_removeValueChangeListener; }\n  if(typeof GM_log !== 'undefined') { GM['log'] = GM_log; }\n  if(typeof GM_notification !== 'undefined') { GM['notification'] = GM_notification; }\n  if(typeof GM_registerMenuCommand !== 'undefined') { GM['registerMenuCommand'] = GM_registerMenuCommand; }\n  if(typeof GM_unregisterMenuCommand !== 'undefined') { GM['unregisterMenuCommand'] = GM_unregisterMenuCommand; }\n  if(typeof GM_openInTab !== 'undefined') { GM['openInTab'] = GM_openInTab; }\n  if(typeof GM_download !== 'undefined') { GM['download'] = GM_download; }\n  if(typeof GM_batch_download !== 'undefined') { GM['batch_download'] = GM_batch_download; }\n  if(typeof GM_setClipboard !== 'undefined') { GM['setClipboard'] = GM_setClipboard; }\n  if(typeof GM_getResourceText !== 'undefined') { GM['getResourceText'] = GM_getResourceText; }\n  if(typeof GM_getResourceURL !== 'undefined') { GM['getResourceURL'] = GM_getResourceURL; }\n  if(typeof GM_getResourceValue !== 'undefined') { GM['getResourceValue'] = GM_getResourceValue; }\n  if(typeof GM_xmlhttpRequest !== 'undefined') { GM['xmlhttpRequest'] = GM_xmlhttpRequest; }\n  \n\n})();\n");
        stringBuffer.append("\nif(Object.entries) {\n    Object.entries(GM).forEach(([name, fun]) => {\n      let old = fun;\n      if (old) {\n        GM[name] = function(...args) {\n          return new Promise((resolve, reject) => {\n            try {\n              resolve(old.apply(this, args));\n            } catch (e) {\n              reject(e);\n            }\n          });\n        };\n      }\n    });\n}\n");
        stringBuffer.append("GM.info = GM_info;\n");
        if (TextUtils.isEmpty(str) || str.indexOf("urlchange") < 0) {
            return;
        }
        stringBuffer.append("    (function() {\n        'use strict';\n    \n        // 保存原始的 pushState 和 replaceState 方法\n        const pushState = history.pushState;\n        const replaceState = history.replaceState;\n    \n        // 重写 pushState 方法\n        history.pushState = function(...args) {\n            // 调用原始的 pushState 方法\n            pushState.apply(this, args);\n            // 触发自定义的 urlchange 事件\n            window.dispatchEvent(new Event('urlchange'));\n        };\n    \n        // 重写 replaceState 方法\n        history.replaceState = function(...args) {\n            // 调用原始的 replaceState 方法\n            replaceState.apply(this, args);\n            // 触发自定义的 urlchange 事件\n            window.dispatchEvent(new Event('urlchange'));\n        };\n    \n        // 监听 popstate 事件\n        window.addEventListener('popstate', () => {\n            window.dispatchEvent(new Event('urlchange'));\n        });\n\n    })();");
    }

    public final String m8548q0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "[]";
        }
        String[] strArrSplit = str.split("`");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            String str2 = strArrSplit[i2];
            if (i2 == 0) {
                stringBuffer.append("'");
            } else {
                stringBuffer.append(",'");
            }
            stringBuffer.append(str2);
            stringBuffer.append("'");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public final void m8549r(StringBuffer stringBuffer, String str) {
        stringBuffer.append("\n/* ============ Main script ============ */\n");
        stringBuffer.append(str);
        stringBuffer.append("\n");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e5 A[Catch: Exception -> 0x0076, TRY_LEAVE, TryCatch #0 {Exception -> 0x0076, blocks: (B:13:0x0050, B:15:0x005d, B:17:0x0063, B:20:0x0079, B:22:0x007f, B:25:0x00ce, B:27:0x00d4, B:29:0x00da, B:30:0x00de, B:59:0x0142, B:33:0x00e5, B:37:0x00ee, B:39:0x00f4, B:41:0x00fa, B:42:0x00fe, B:47:0x010c, B:49:0x0112, B:51:0x0127, B:53:0x012f, B:56:0x0138, B:58:0x013f, B:57:0x013c, B:45:0x0106, B:61:0x0148), top: B:65:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8550r0(String r11, int r12) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2061mf.m8550r0(java.lang.String, int):void");
    }

    public final void m8551s(StringBuffer stringBuffer, String str) throws Exception {
        for (String str2 : str.split("`")) {
            stringBuffer.append("\n/*" + str2 + "*/\n");
            String strM8516U = m8516U(str2);
            if (TextUtils.isEmpty(strM8516U)) {
                throw new Exception("require lib:" + str2 + " failed");
            }
            stringBuffer.append(strM8516U);
            stringBuffer.append("\n");
            stringBuffer.append("\n /* end of " + str2 + " */\n");
        }
    }

    public void m8552s0(WebView webView, String str) {
        String strM8515T = getScriptPath(str);
        if (FileUtils.fileExists(strM8515T)) {
            evaluateJavascript(webView, FileUtils.readFileToString(strM8515T));
        } else {
            BrowserActivity.getActivity().onLoadModuleFailed(str);
        }
    }

    public final void m8553t(StringBuffer stringBuffer, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        String strM453h = NetworkUtils.extractUserScriptMeta(str10);
        String strQuote = TextUtils.isEmpty(str2) ? "\"\"" : JSONObject.quote(str2);
        String strQuote2 = TextUtils.isEmpty(str3) ? "\"\"" : JSONObject.quote(str3);
        String strQuote3 = TextUtils.isEmpty(str4) ? "\"\"" : JSONObject.quote(str4);
        String strQuote4 = TextUtils.isEmpty(str5) ? "\"\"" : JSONObject.quote(str5);
        String strQuote5 = JSONObject.quote(strM453h);
        stringBuffer.append("(function(){\nvar unsafeWindow = window;\nvar closeAmdFlag = false;\n");
        stringBuffer.append("(function () {\n  if(typeof define === \"function\" && define.amd ) {\n    define.amd = false;\n    closeAmdFlag = true;\n  }\n})();\n");
        stringBuffer.append("let user_script_id =\"" + str + "\";\n");
        stringBuffer.append("let user_script_title =\"" + str2 + "\";\n");
        stringBuffer.append("let value_change_listeners = [];\n");
        stringBuffer.append("let GM_info = {\n                  \"script\": {\n                     \"id:\": \"" + str + "\" ,\n                      \"author\": " + strQuote3 + ",\n                      \"version\": " + strQuote4 + ",\n                      \"copyright\": \"\",\n                      \"includes\": " + m8548q0(str8) + ",\n                      \"matches\": " + m8548q0(str9) + ",\n                      \"excludes\": " + m8548q0(str7) + ",\n                      \"resources\": " + m8502L0(str6) + ",\n                      \"description\": " + strQuote2 + ",\n                      \"homepage\": \"\",\n                      \"name\": " + strQuote + ",\n                      \"namespace\": \"\"\n                  },\n                  \"version\": \"1.2.5\",\n                  \"scriptMetaStr\": " + strQuote5 + ",\n                  \"scriptHandler\": \"XMonkey\"\n              };\n");
        stringBuffer.append("function uuid() {\n    var s = [];\n    var hexDigits = \"0123456789abcdef\";\n    for (var i = 0; i < 36; i++) {\n        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);\n    }\n    s[14] = \"4\"; \n    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);\n    s[8] = s[13] = s[18] = s[23] = \"-\";\n \n    var uuid = s.join(\"\");\n    return uuid;\n}\n");
    }

    public final void m8554t0(String str, String str2) {
        if (this.f6191f != null) {
            String str3 = str + str2;
            this.f6191f.put(str3, str3);
        }
    }

    public void m8555u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("http")) {
            C0186E1.m842a().m843b(str, new h());
            return;
        }
        if (str.startsWith("data:image")) {
            String[] strArrM470y = NetworkUtils.parseDataUriLegacy(str);
            if (strArrM470y.length > 0) {
                String str2 = strArrM470y[1];
                String str3 = strArrM470y[2];
                String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(str, 9);
                if (str2 == null || !str2.equals("base64")) {
                    return;
                }
                FileUtils.writeBytesToFile(Base64.decode(str3, 0), strM2046a);
            }
        }
    }

    public final boolean m8556u0(String str, String str2) {
        for (String str3 : str.split("`")) {
            if (m8478v0(str3, str2)) {
                return true;
            }
            if (str3.length() > 2 && str3.startsWith("/") && str3.endsWith("/") && str2.matches(str3.substring(1, str3.length() - 1))) {
                return true;
            }
            str3.indexOf("://");
        }
        return false;
    }

    public final void m8557v(String str) {
        if (FileUtils.fileExists(ResourceCacheManager.getInstance().getUrlOrFilePath(str, 9))) {
            return;
        }
        C0232F1.m1169l().m1173h(str);
    }

    public void m8558w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            m8557v(jSONObject.getString(itKeys.next()));
        }
    }

    public void m8559w0(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i2, int i3) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("script_id", str);
        contentValues.put("name", str2);
        contentValues.put("namespace", str3);
        contentValues.put("title", str4);
        contentValues.put("script_desc", str5);
        contentValues.put("create_by", str6);
        contentValues.put("script_data", str7);
        contentValues.put("ex_point", str8);
        contentValues.put("include_script", str9);
        contentValues.put("exclude", str10);
        contentValues.put("resources", str13);
        contentValues.put("version", str17);
        contentValues.put("auto_run_at", Integer.valueOf(i2));
        contentValues.put("icon_url", str11);
        contentValues.put("source", str12);
        contentValues.put("auto_run_at", Integer.valueOf(i2));
        contentValues.put("type", Integer.valueOf(i3));
        contentValues.put("create_at", Long.valueOf(System.currentTimeMillis()));
        m8488E0(str, str4, str5, str6, str7, str9, str13, str10, str14, str15, str16, str17);
        sQLiteDatabase.insert("user_script", null, contentValues);
    }

    public final void m8560x(StringBuffer stringBuffer, String str) {
        if (this.f6190e == null) {
            this.f6190e = new ScriptMap();
        }
        String host = Uri.parse(str).getHost();
        String string = stringBuffer.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f6190e.put(host, string);
        Log.i("user-script", ">>>> prepare send cookies:" + string);
    }

    public final void m8561x0(String str, String str2) {
        if (((ArrayList) this.f6189d.get(str)) == null) {
            this.f6189d.put(str, new ArrayList<>());
        }
    }

    public final String m8562y(int i2) {
        return i2 == 0 ? "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAYAAADimHc4AAAACXBIWXMAACxLAAAsSwGlPZapAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAVmSURBVHgB7Z3vmRs1EMZf8vCdo4KbDggVZOngqCBLB6YCmwpwBzYVECrwUUGgAisVcKmA7MTnD7msXmlXf1Za6/c882nWtqTRjEYa2QYajUaj0Wg0bpFvkI+7QbpB5Fm+Qz18HORpkH+exaASdND7QU6D/L8ieT/IFpeJVCz9IP+hroGdIwcUZgjB+ma8j2xRADLIGXUNXEz5E5ewuwiC2x78q5yxQEgStMF/aQQvT4iVhh4Heev5rHmWzvGcpn3vUAY6mDLI6wmv0bb/jAz08JsVB3w56DuP10zpcA4El/7qDPfp8wYZcDVG9Z3ltUe4jVYqO7gNoGl40kW5R9iCdAf3XmGxrMKDHgt7wcnx4Z3He2xQgBsH0IO3/4SExAofzAuSdiASRyzgxR3CZ/+VHRboQEQEvP297YWvMB+WoWgK+Qh/jg59h7IxuJyS2hCbIsQAbFayxoxhwI94S0tHx/iX6O5tihADMAym8zfR3WOlfIs0fI/pGKJ7QOFn7+Be+sGmCDHAE9HNmbGG6K7VtNUREoKYAUrPWnJjHasQA8xa9W+UJAZ4cugFcd+vZgwSwTYfU1NHn3OhGuVM+hychhqim2oA9YCfUNGVDw+0T7QmEJqGxl6IdV1RI3RYfh15A3vmZQb5Axx9RosySUOrfoDN9faomx4zw8oUQkMQs25NN9/GYH0TRCLlGiCoG9d5VpS9TjOAHVfsLsIAa94NP4H3L8oJbUoPuMM6jGCj+BCk1G4AQ3SCCKQMQYqgbj4Q3T0iEKMgY4hOUDdsgs2peXxFjIJMjDipC9oW+UqP12uPvzmeM0QXxQNiGEBrobaBE7jRZ07Iv15omztcjj5sFL8IK6G74QOWW6w78Epb8ppH6jXAJ6TkCjs2OqJLnmSk9gCfmb10IYZ9vgEn2HNLyIJcx7opuS7GDEN0S3vvZwS8IiQe77FH/kqVVt98BvA9eY8NAkmdhio+bqodUSO8Rp4F+Xp10if86WYsJMujxDKAim3gBH5XFQ3KLEcmrXnEupq45lNRQ3SCQGIZgF1MFdSNITpBIDk84B51k9S7YxnAEF2UQ6sFMUQXXPPIYYAfUDfGoS/CAGsvTTIEAeTwgGA3LQBDdIIAcniAsmYvEASQwwMUgR+64zwh75HEwaN9LM0uYg1QDNEJ3OgzOvgd8tLDXRBKthuOaYDQhXiP5UKVgB+sGaILOhGNaQB2g0DgZukNG/v8ZFlerhDk46ZLF2Y+Ep0hOkEAuUKQwI3rhkJKtO17ojfgCGZS0iL8OMivyH8kbeD+Zk6yNDvmF7VjxMk98hZmDPwMHqvm8RXMAILLN9R9z3LuHDoV3zg/qzOJYQaI7gFvET8tnGKAEtHNmFh0gpm8srzZDvFDQFC+XABJah5jBtCBEsSn9vMgQ3Szax5jBkg1UIK6MUQ3u+ZhC0EpaKXJEVL9YNMYrTQ5wlgWJOCNeCR6gf00c80eoMzK8qZuxB4H+YXoe9gNUPsinISxEBTytRy2gRLUjWsCzdrjjBnAkOffIKwRgnpx7WOiGYDNYp0FHdEbcGoOQw9EF/XoRAeJ/XDSGXwgz+S1PepEwOvKe8zEtgb8Bd6YLdEnyZcX5uDQv0NkOrhvE/wOe2Oiz5QF0cnGxuGMRJzg93to8uJ1R/ArILWg3qrtdY1Bj0QI/H9ET4318NzoneO50tE+bOHX9zMCcf2Jzwb2UGODFS5UFzVjiIxgWqr8IzL0Zwf/W2a3JDtkZIe6B6vqwb+yQd2DVvXgXxHc7j/m6aL8gELocVuGiH1BIRodLnn/GXUNqI+ckOZywhe40tApyAtRDOo6ATWY9i36RqPRaDQajcYsPgHcoDphXa481wAAAABJRU5ErkJggg==" : "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAYAAADimHc4AAAACXBIWXMAACxLAAAsSwGlPZapAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAPmSURBVHgB7Z3/cdMwFMe/cPwPTBBtQNnAbAATkA3aDWImaJkg2gA2cDZomSDqBJQJgh5JrmmP6of95GfF73P3vfROjl/1vpIs6xQbUBRFURRFURRlbrwCP++8msPnUcQCdXF/8rc76M7rAROk8brx2nrtzlxbr7WXwQQwXh3qSiCn1hA04tLrN+pMHKcoB1cYmRXqTloJrTASKwA7lYwJlwB2qqCyhqOcaajxusXjtDKGO+gBE526JWBOPk3id6iuH7GvOysWcfe32LeAVJNqguq0RNpUuwMzJiGoxXkm/jlUR7rnieWjASM2EuwG88NixJyEuh2VzaHlP4fqHMsLW6CQ00vMF7rehXLD0jCbMYJUSqxxfo6d4DXimECZQ71TTA6o7i5QHm2cHAbMHRcoYzFACfMnUFbcAAdl0BA8dAhSwixiB+gQJIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIIwaIMwbjA/tlaEtewaPuwboN7l3BzmURTp+NhYv731cp5/m3x7TDvF99XROA36aQvEtePJTLAC1uGvEK/5c1+DZ+Fs6vsWEDTDYd+tdT20xrDeYEeJbDDCg5EWYWk/n9QH9MV4/0K8nSMdPoqQBK/CM5Rfo9/tb6fhsWOR3MYP+3f4lNUjHjBjfYoJDUAt+VhnHtuCnSC8oYYDx+gp+GqSNxUY4fhYlDLhAOaK/uZpA/CxqM8AkHCMdP4tSQ1ApFgnHGJQjJX4WuhgnTAkDHMpxn3CMQzlS4mdRmwF3Ccc4lCMlfhYlDPiJcqQkQDp+FiUMoJ9tbsCPRVrrlo6fRamL8Dfwk3NO6fjJlDJg4/UdfNC5XMbxG8jGZ8Wi32IT3bbfYvgi2Bb9l6PHiG8xwcU4gsbiLxjWcn55fUK/xwFIx0+i9I2Yw/4Jgn2GA/pOg2EJdMLxWWgxoIudYJD25MUOeWv/0vFt4Fxt7MtDt6W8zzjWYf94sxb7BTPS4lB2fyinOXyp7u4KxR+0PpRiQOgfeot8HB4rK4ETjv+ElGtAyAADxQTKHCJwGFBsx0AFUN1NoNyBKUjoonWF+bJEODdsjXML/hul2hntwa3EDcJOrzE/YtsdWXPSID5/5trLOXWojpTcWD4MmOkSglK3W+J8H19P17vQsJPd+sd4gQNQ7+Mtj+9BM5jACxyI2MOqVSPMClsAO9V/1WIkWtSfrGqTf4S6mr7ITehFbkcM0pZ4z1UdJvROSYv5vMyTbkwbMJAzDU2Fpm201m7wtHUsUBfHXXAPJ9pg3i+sUBRFURRFURSFgb8bbE62Ld0MBAAAAABJRU5ErkJggg==";
    }

    public final void m8563y0(String str, String str2, boolean z) {
        if (((ArrayList) this.f6189d.get(str)) == null) {
            ArrayList arrayList = new ArrayList<>();
            C0762Qg c0762Qg = new C0762Qg();
            c0762Qg.mo2667f(z);
            c0762Qg.mo2663b(-1);
            c0762Qg.mo2673l(str2);
            c0762Qg.mo2676o(str);
            arrayList.add(c0762Qg);
            this.f6189d.put(str, arrayList);
        }
    }

    public final void m8564z(String str) {
        BrowserActivity.getActivity().m6353r1(str);
    }

    public void m8565z0(String str) {
        BrowserActivity.getActivity().runOnUiThread(new e(str));
    }

    public class c implements InterfaceC0556M3 {

        public final String f6199a;

        public c(String str) {
            this.f6199a = str;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) {
            BrowserActivity browserActivityM6183s1;
            String string;
            if (response.getStatus() != 200) {
                BrowserActivity.getActivity().showToast("Upload fail server status code:" + response.getStatus());
                return;
            }
            String strM2399p = response.getContentType("Content-Type");
            if (strM2399p == null || strM2399p.indexOf("application/json") < 0) {
                return;
            }
            try {
                int i = new JSONObject(response.body().m2714l()).getInt("status");
                if (i == 1) {
                    BrowserActivity.getActivity().runOnUiThread(new a());
                } else if (i == 2) {
                    m8506N0(this.f6199a, BrowserActivity.getActivity().getString(R.string.share_script_title) + "[" + m8523a0(this.f6199a) + "]");
                } else {
                    if (i == 3) {
                        browserActivityM6183s1 = BrowserActivity.getActivity();
                        string = BrowserActivity.getActivity().getString(R.string.toast_script_under_review);
                    } else if (i == 4) {
                        browserActivityM6183s1 = BrowserActivity.getActivity();
                        string = BrowserActivity.getActivity().getString(R.string.toast_script_not_approved);
                    } else if (i == 0) {
                        browserActivityM6183s1 = BrowserActivity.getActivity();
                        string = BrowserActivity.getActivity().getString(R.string.toast_script_exist);
                    }
                    browserActivityM6183s1.showToast(string);
                }
            } catch (JSONException unused) {
            } catch (Throwable th) {
                response.body().close();
                throw th;
            }
            response.body().close();
        }

        @Override
        public void onError(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            BrowserActivity.getActivity().showToast("Netwrok error!");
        }

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() {
                MessageBoxManager.getInstance().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getString(R.string.toast_post_script_success), BrowserActivity.getActivity().getString(R.string.btn_text_view), new C2718a(), false);
            }

            public class C2718a implements MessageBoxBase.MessageBoxListener {
                public C2718a() {
                }

                @Override
                public void onShown() throws URISyntaxException, UnsupportedEncodingException {
                    String strM9755H = C2439uo.getInstance().getUser().getUserId();
                    try {
                        strM9755H = URLEncoder.encode(strM9755H, "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    BrowserActivity.getActivity().m6307d2(ApiEndpointsManager.getInstance().getPublicScriptsEndpoint() + "&user_id=" + strM9755H);
                }

                @Override
                public void onDismissed() {
                }

                @Override
                public void onDismiss() {
                }
            }
        }
    }

    public class e implements Runnable {

        public final String f6205l;

        public e(String str) {
            this.f6205l = str;
        }

        @Override
        public void run() {
            MessageBoxManager.getInstance().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getString(R.string.toast_found_tampermonkey_script), BrowserActivity.getActivity().getString(R.string.btn_text_install), new a(), false);
        }

        public class a implements MessageBoxBase.MessageBoxListener {
            public a() {
            }

            @Override
            public void onShown() {
                if (e.this.f6205l.startsWith("http")) {
                    e eVar = e.this;
                    m8503M(eVar.f6205l);
                } else {
                    e eVar2 = e.this;
                    m8536h0(eVar2.f6205l);
                }
            }

            @Override
            public void onDismissed() {
            }

            @Override
            public void onDismiss() {
            }
        }
    }

    public class h implements C0186E1.b {
        public h() {
        }

        @Override
        public void mo846a(Drawable drawable) {
            Log.i("user-script", "download icon success");
        }

        @Override
        public void mo847b() {
        }
    }

    public class j implements MessageBoxBase.MessageBoxListener {

        public final String f6214a;

        public j(String str) {
            this.f6214a = str;
        }

        @Override
        public void onShown() throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("methodName", "GM_notification");
                jSONObject.put("callbackName", "onclick");
                String strQuote = JSONObject.quote(jSONObject.toString());
                BrowserActivity.getActivity().updateTitle("_XJSAPI_.exec_gm_callback('" + this.f6214a + "'," + strQuote + ")");
            } catch (Exception unused) {
            }
        }

        @Override
        public void onDismiss() throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("methodName", "GM_notification");
                jSONObject.put("callbackName", "ondone");
                String strQuote = JSONObject.quote(jSONObject.toString());
                BrowserActivity.getActivity().updateTitle("_XJSAPI_.exec_gm_callback('" + this.f6214a + "'," + strQuote + ")");
            } catch (Exception unused) {
            }
        }

        @Override
        public void onDismissed() {
        }
    }
}
