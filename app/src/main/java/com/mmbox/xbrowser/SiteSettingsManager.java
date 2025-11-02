package com.mmbox.xbrowser;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000.DatabaseColumns;
import p000.ResourceCacheManager;
import p000.C1089Xm;
import p000.MySQLiteOpenHelper;

public class SiteSettingsManager {

    public static SiteSettingsManager instance;

    public String cachedUrl = null;

    public long cachedTime = 0;

    public String cachedHost = null;

    public HashMap<String, String> settingsCache = new HashMap<>();

    public class Host {

        public int hostType;

        public String host = null;

        public String extra = null;
    }

    public static SiteSettingsManager getInstance() {
        if (instance == null) {
            instance = new SiteSettingsManager();
        }
        return instance;
    }

    public String m6933B(String str) {
        SharedPreferencesHelper.UserAgent userAgentVarM6888A0;
        Host hostVarM6982X = getHost(2, str);
        return (hostVarM6982X == null || hostVarM6982X.extra == null || (userAgentVarM6888A0 = SharedPreferencesHelper.getInstance().getUserAgentById(hostVarM6982X.extra)) == null) ? SharedPreferencesHelper.getInstance().getUserAgentById("ua_default").title : userAgentVarM6888A0.title;
    }

    public boolean m6934C(String str, String str2) {
        if (str2.equals("disable_adblock")) {
            Host hostVarM6982X = getHost(1, str);
            if (hostVarM6982X == null) {
                return false;
            }
            return hostVarM6982X.extra.equals("true");
        }
        if (str2.equals("enable_strong_adblock")) {
            return m6947P(str);
        }
        if (str2.equals("enable_desktop_mode")) {
            return m6959a0(str);
        }
        if (str2.equals("disable_js")) {
            return !m6938G(str);
        }
        if (str2.equals("disable_cookies")) {
            return !m6937F(str);
        }
        if (str2.equals("disable_auto_fill")) {
            return !m6935D(str);
        }
        if (str2.equals("disable_log_his")) {
            return !m6946O(str);
        }
        if (str2.equals("disable_location_acquisition")) {
            return !m6940I(str);
        }
        if (str2.equals("enable_background_play")) {
            return m6961c(str);
        }
        if (str2.equals("disable_clipboard")) {
            return m6945N(str);
        }
        if (str2.equals("disable_user_script")) {
            return !m6941J(str);
        }
        if (str2.equals("disable_startup_app")) {
            return !m6936E(str);
        }
        if (str2.equals("disable_request_camera")) {
            return m6944M(str, "android.webkit.resource.VIDEO_CAPTURE");
        }
        if (str2.equals("disable_request_microphone")) {
            return m6944M(str, "android.webkit.resource.AUDIO_CAPTURE");
        }
        if (str2.equals("enable_req_location")) {
            return m6977s(str, "geolocation");
        }
        if (str2.equals("enable_block_jumping_to_other")) {
            return m6943L(str);
        }
        return false;
    }

    public boolean m6935D(String str) {
        Host hostVarM6982X = getHost(16, str);
        if (hostVarM6982X == null) {
            return true;
        }
        return hostVarM6982X.extra.equals("true");
    }

    public boolean m6936E(String str) {
        Host hostVarM6982X = getHost(3, str);
        if (hostVarM6982X == null) {
            return true;
        }
        return hostVarM6982X.extra.equals("true");
    }

    public boolean m6937F(String str) {
        Host hostVarM6982X = getHost(5, str);
        return hostVarM6982X == null ? SharedPreferencesHelper.getInstance().acceptCookies : hostVarM6982X.extra.equals("true");
    }

    public boolean m6938G(String str) {
        Host hostVarM6982X = getHost(4, str);
        return hostVarM6982X == null ? !SharedPreferencesHelper.getInstance().disableJavascript : hostVarM6982X.extra.equals("true");
    }

    public boolean m6939H(String str, String str2) {
        return this.settingsCache.get(str) != null && ((String) this.settingsCache.get(str)).indexOf(str2) >= 0;
    }

    public boolean m6940I(String str) {
        Host hostVarM6982X = getHost(13, str);
        if (hostVarM6982X == null) {
            return true;
        }
        return hostVarM6982X.extra.equals("true");
    }

    public boolean m6941J(String str) {
        return m6942K(str, null);
    }

    public boolean m6942K(String str, String str2) throws JSONException {
        String str3;
        Host hostVarM6982X = getHost(10, str);
        if (hostVarM6982X == null || TextUtils.isEmpty(hostVarM6982X.extra)) {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(str2, true);
                    m6958a(10, str, jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            return true;
        }
        if (str2 == null && (str3 = hostVarM6982X.extra) != null) {
            return !str3.equals("false");
        }
        if (!TextUtils.isEmpty(hostVarM6982X.extra) && !TextUtils.isEmpty(str2)) {
            try {
                return new JSONObject(hostVarM6982X.extra).getBoolean(str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean m6943L(String str) {
        Host hostVarM6982X = getHost(17, str);
        if (hostVarM6982X == null) {
            return false;
        }
        return hostVarM6982X.extra.equals("true");
    }

    public boolean m6944M(String str, String str2) {
        Host hostVarM6982X;
        int iM6983y = m6983y(str2);
        return iM6983y > 0 && (hostVarM6982X = getHost(iM6983y, str)) != null && hostVarM6982X.extra.equals("false");
    }

    public boolean m6945N(String str) {
        Host hostVarM6982X = getHost(15, str);
        if (hostVarM6982X == null) {
            return false;
        }
        return hostVarM6982X.extra.equals("true");
    }

    public boolean m6946O(String str) {
        Host hostVarM6982X = getHost(12, str);
        if (hostVarM6982X == null) {
            return true;
        }
        return hostVarM6982X.extra.equals("true");
    }

    public boolean m6947P(String str) {
        Host hostVarM6982X = getHost(9, str);
        if (hostVarM6982X == null) {
            return false;
        }
        return hostVarM6982X.extra.equals("true");
    }

    public String m6948Q() {
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("host_list", DatabaseColumns.HOST_LIST, "host_type= ?", new String[]{"9"}, null, null, null);
        String string = "";
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        boolean zEquals = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("extra")).equals("true");
                        if (TextUtils.isEmpty(string)) {
                            if (zEquals) {
                                string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("host"));
                            }
                        } else if (zEquals) {
                            string = string + "," + cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("host"));
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
            cursorQuery.close();
        }
        return string;
    }

    public void m6949R(String str, boolean z) {
        m6958a(12, str, z ? "true" : "false");
    }

    public void m6950S() {
        this.cachedUrl = null;
    }

    public void m6951T(int i, String str) {
        MySQLiteOpenHelper.getInstance().getWritableDatabase().delete("host_list", "host = ? AND host_type = ? ", new String[]{str, i + ""});
        if (i != 0 && i == 1) {
            ContentDataManager.getInstance().m6613e1(str);
        }
        C1089Xm.getInstance().m4822j("syncable_host").incrementVersion();
    }

    public void m6952U(String str) {
        MySQLiteOpenHelper.getInstance().getWritableDatabase().delete("host_list", "host = ?", new String[]{str});
        BrowserActivity.getActivity().refreshQuickAccessUI();
    }

    public void m6953V(int i) {
        MySQLiteOpenHelper.getInstance().getWritableDatabase().delete("host_list", "host_type = ? ", new String[]{i + ""});
        BrowserActivity.getActivity().m6361u0("native_call_clearHosts()");
    }

    public void m6954W() {
        MySQLiteOpenHelper.getInstance().getWritableDatabase().delete("host_list", null, null);
    }

    public void m6955X(String str, boolean z) {
        m6958a(14, str, z ? "true" : "false");
    }

    public void m6956Y(String str, String str2, boolean z) throws JSONException {
        boolean z2;
        String str3;
        if (str2.equals("disable_adblock")) {
            if (z) {
                ContentDataManager.getInstance().m6560D(str);
                m6958a(1, str, "true");
                return;
            } else {
                m6951T(1, str);
                ContentDataManager.getInstance().m6613e1(str);
                return;
            }
        }
        if (str2.equals("enable_strong_adblock")) {
            m6979u(str, z);
            return;
        }
        if (str2.equals("enable_desktop_mode")) {
            m6980v(str, z);
            return;
        }
        if (str2.equals("disable_js")) {
            m6964f(str, !z);
            return;
        }
        if (str2.equals("disable_cookies")) {
            m6963e(str, !z);
            return;
        }
        if (str2.equals("disable_auto_fill")) {
            m6960b(str, !z);
            return;
        }
        if (str2.equals("disable_log_his")) {
            m6949R(str, !z);
            return;
        }
        if (str2.equals("disable_location_acquisition")) {
            m6967i(str, !z);
            return;
        }
        if (str2.equals("enable_background_play")) {
            m6955X(str, z);
            return;
        }
        if (str2.equals("disable_clipboard")) {
            m6978t(str, z);
            return;
        }
        if (str2.equals("disable_user_script")) {
            m6969k(str, !z);
            return;
        }
        if (str2.equals("disable_startup_app")) {
            m6962d(str, !z);
            return;
        }
        if (str2.equals("disable_request_camera")) {
            z2 = !z;
            str3 = "android.webkit.resource.VIDEO_CAPTURE";
        } else {
            if (!str2.equals("disable_request_microphone")) {
                if (str2.equals("enable_req_location")) {
                    m6965g(str, "geolocation", z);
                    return;
                } else {
                    if (str2.equals("enable_block_jumping_to_other")) {
                        m6976r(str, z);
                        return;
                    }
                    return;
                }
            }
            z2 = !z;
            str3 = "android.webkit.resource.AUDIO_CAPTURE";
        }
        m6965g(str, str3, z2);
    }

    public final long m6957Z(SQLiteDatabase sQLiteDatabase, int i, String str, String str2) {
        Cursor cursorQuery = sQLiteDatabase.query("host_list", DatabaseColumns.HOST_LIST, "host= ? AND host_type= ?", new String[]{str, i + ""}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("host_type", Integer.valueOf(i));
                    contentValues.put("host", str);
                    contentValues.put("extra", str2);
                    sQLiteDatabase.update("host_list", contentValues, "_id=" + j, null);
                    return j;
                }
            } finally {
                cursorQuery.close();
            }
        }
        C1089Xm.getInstance().m4822j("syncable_host").incrementVersion();
        return -1L;
    }

    public void m6958a(int i, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_type", Integer.valueOf(i));
        contentValues.put("host", str);
        contentValues.put("extra", str2);
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        if (m6957Z(writableDatabase, i, str, str2) < 0) {
            writableDatabase.insert("host_list", null, contentValues);
        }
        if (i != 0 && i == 1) {
            ContentDataManager.getInstance().m6560D(str);
        }
        m6950S();
        C1089Xm.getInstance().m4822j("syncable_host").incrementVersion();
    }

    public boolean m6959a0(String str) {
        Host hostVarM6982X = getHost(11, str);
        if (hostVarM6982X == null) {
            return false;
        }
        return hostVarM6982X.extra.equals("true");
    }

    public void m6960b(String str, boolean z) {
        m6958a(16, str, z ? "true" : "false");
    }

    public boolean m6961c(String str) {
        Host hostVarM6982X = getHost(14, str);
        if (hostVarM6982X == null) {
            return false;
        }
        return hostVarM6982X.extra.equals("true");
    }

    public void m6962d(String str, boolean z) {
        m6958a(3, str, z ? "true" : "false");
    }

    public void m6963e(String str, boolean z) {
        m6958a(5, str, z ? "true" : "false");
    }

    public void m6964f(String str, boolean z) {
        m6958a(4, str, z ? "true" : "false");
    }

    public void m6965g(String str, String str2, boolean z) {
        String str3 = z ? "true" : "false";
        int iM6983y = m6983y(str2);
        if (iM6983y > 0) {
            m6958a(iM6983y, str, str3);
        }
    }

    public void m6966h(String str, String str2) {
        if (this.settingsCache.get(str) != null) {
            String str3 = (String) this.settingsCache.get(str);
            if (str3.indexOf(str2) >= 0) {
                return;
            }
            str2 = str3 + "," + str2;
        }
        this.settingsCache.put(str, str2);
    }

    public void m6967i(String str, boolean z) {
        m6958a(13, str, z ? "true" : "false");
    }

    public void m6968j(String str, String str2, boolean z) throws JSONException {
        String string;
        Host hostVarM6982X;
        if (str2 == null) {
            string = z ? "true" : "false";
        } else if (TextUtils.isEmpty(str2) || (hostVarM6982X = getHost(10, str)) == null || hostVarM6982X.extra == null) {
            string = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(hostVarM6982X.extra);
                jSONObject.put(str2, z);
                string = jSONObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        m6958a(10, str, string);
    }

    public void m6969k(String str, boolean z) throws JSONException {
        m6968j(str, null, z);
    }

    public final void m6970l(boolean z) {
        if (CookieManager.getInstance().acceptCookie() != z) {
            CookieManager.getInstance().setAcceptCookie(z);
        }
    }

    public final void m6971m(WebSettings webSettings, boolean z) {
        if (webSettings.getJavaScriptEnabled() != z) {
            webSettings.setJavaScriptEnabled(z);
        }
    }

    public final void m6972n(WebView webView, String str) throws NumberFormatException {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        String strM6886Z;
        WebSettings settings;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.cachedTime;
        Log.i("domain-set", ">>>>>> cur:" + jCurrentTimeMillis + " mLastChangeTime:" + this.cachedTime + " val:" + j);
        StringBuilder sb = new StringBuilder();
        sb.append("current domain:");
        sb.append(this.cachedUrl);
        sb.append("new domain:");
        sb.append(str);
        Log.i("domain-set", sb.toString());
        Log.i("domain-set", "current ua:" + webView.getSettings().getUserAgentString());
        if (str == null) {
            return;
        }
        if (TextUtils.isEmpty(this.cachedUrl) || (!this.cachedUrl.equals(str) && j > 1000)) {
            this.cachedUrl = str;
            this.cachedTime = jCurrentTimeMillis;
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("host_list", DatabaseColumns.HOST_LIST, "host = ? ", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        z = false;
                        z2 = false;
                        z3 = false;
                        do {
                            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("host_type"));
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("extra"));
                            if (i2 == 2) {
                                if (string == null) {
                                    string = null;
                                }
                                if (!SharedPreferencesHelper.getInstance().m6847C().equals(string)) {
                                    strM6886Z = SharedPreferencesHelper.getInstance().getUserAgentString(string);
                                    settings = webView.getSettings();
                                    m6973o(settings, strM6886Z);
                                    z = true;
                                }
                            } else if (i2 == 4) {
                                Log.i("domain-set", "change js settings by " + str + "js-enable:" + string);
                                if (string.equals("false")) {
                                    m6971m(webView.getSettings(), false);
                                } else if (string.equals("true")) {
                                    m6971m(webView.getSettings(), true);
                                }
                                z2 = true;
                            } else if (i2 == 5) {
                                if (string.equals("false")) {
                                    Log.i("domain-set", "change cookies settings by " + str);
                                    m6970l(false);
                                    z3 = true;
                                }
                            } else if (i2 == 11) {
                                if (string.equals("true")) {
                                    Log.i("domain-set", "view in desktop mode :" + str);
                                    strM6886Z = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36";
                                    settings = webView.getSettings();
                                    m6973o(settings, strM6886Z);
                                    z = true;
                                }
                            } else if (i2 == 7 && !TextUtils.isEmpty(string)) {
                                try {
                                    i = Integer.parseInt(string);
                                } catch (Exception unused) {
                                    i = 100;
                                }
                                webView.getSettings().setTextZoom(i);
                            }
                        } while (cursorQuery.moveToNext());
                    } else {
                        z = false;
                        z2 = false;
                        z3 = false;
                    }
                    if (!z) {
                        m6973o(webView.getSettings(), SharedPreferencesHelper.getInstance().m6849D());
                    }
                    if (!z2) {
                        m6971m(webView.getSettings(), !SharedPreferencesHelper.getInstance().disableJavascript);
                    }
                    if (z3) {
                        return;
                    }
                    m6970l((!SharedPreferencesHelper.getInstance().enterPrivateMode || SharedPreferencesHelper.getInstance().supportCookiesInPrivate) ? SharedPreferencesHelper.getInstance().acceptCookies : false);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public final void m6973o(WebSettings webSettings, String str) {
        String str2;
        if (webSettings.getUserAgentString().equals(str)) {
            return;
        }
        if (str == null && (str2 = this.cachedHost) != null && str2.equals(webSettings.getUserAgentString())) {
            return;
        }
        if (!SharedPreferencesHelper.getInstance().enterDesktopMode) {
            webSettings.setUserAgentString(str);
        }
        if (str == null) {
            this.cachedHost = webSettings.getUserAgentString();
        }
        Log.i("domain-set", "ua changed current ua string:" + webSettings.getUserAgentString());
    }

    public void m6974p(WebView webView, String str) {
        m6975q(webView, str, false);
    }

    public void m6975q(WebView webView, String str, boolean z) {
        if (z) {
            this.cachedUrl = null;
        }
        if (str.startsWith("http")) {
            m6972n(webView, ResourceCacheManager.getInstance().m2046a(str, 1004));
        } else if (str.startsWith("file:///")) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setLoadsImagesAutomatically(true);
        }
        if (str.indexOf("xbext.com") > 0) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }

    public void m6976r(String str, boolean z) {
        m6958a(17, str, z ? "true" : "false");
    }

    public boolean m6977s(String str, String str2) {
        Host hostVarM6982X;
        int iM6983y = m6983y(str2);
        if (iM6983y <= 0 || (hostVarM6982X = getHost(iM6983y, str)) == null || !hostVarM6982X.extra.equals("true")) {
            return m6981w(str, str2);
        }
        return true;
    }

    public void m6978t(String str, boolean z) {
        m6958a(15, str, z ? "true" : "false");
    }

    public void m6979u(String str, boolean z) {
        m6958a(9, str, z ? "true" : "false");
        ContentDataManager.getInstance().m6575K0();
    }

    public void m6980v(String str, boolean z) {
        m6958a(11, str, z ? "true" : "false");
    }

    public final boolean m6981w(String str, String str2) {
        if (str2.equals("android.webkit.resource.VIDEO_CAPTURE")
                || str2.equals("android.webkit.resource.AUDIO_CAPTURE")) {
            return m6939H(str, str2);
        }
        return false;
    }

    public Host getHost(int hostType, String host) {
        if (host == null) return null;

        Host result = null;
        SQLiteDatabase db = MySQLiteOpenHelper.getInstance().getReadableDatabase();

        String selection = "host_type = ? AND host = ?";
        String[] selectionArgs = {String.valueOf(hostType), host};

        try (Cursor cursor = db.query("host_list", DatabaseColumns.HOST_LIST, selection, selectionArgs, null, null, null)) {
            if (cursor.moveToFirst()) {
                result = new Host();
                result.hostType = hostType;
                result.host = host;
                result.extra = cursor.getString(cursor.getColumnIndexOrThrow("extra"));
            }
        } catch (Exception e) {
            Log.e("DB_ERROR", "Error reading host from database", e);
        }

        return result;
    }

    public final int m6983y(String str) {
        if (str.equals("geolocation")) {
            return 13;
        }
        if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
            return 20;
        }
        return str.equals("android.webkit.resource.AUDIO_CAPTURE") ? 19 : -1;
    }

    public String m6984z(int i) {
        JSONArray jSONArray = new JSONArray();
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("host_list", DatabaseColumns.HOST_LIST, "host_type= ?", new String[]{i + ""}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        jSONArray.put(cursorQuery.getString(cursorQuery.getColumnIndex("host")));
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
            cursorQuery.close();
        }
        return jSONArray.toString();
    }
}
