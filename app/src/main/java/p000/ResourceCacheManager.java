package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ResourceCacheManager {

    public static ResourceCacheManager instance;

    public HashMap f1435a = new HashMap<>();

    public static ResourceCacheManager getInstance() {
        if (instance == null) {
            instance = new ResourceCacheManager();
        }
        return instance;
    }

    public String m2046a(String str, int i) {
        HashMap map;
        String strM6882V;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i == 0) {
            return getFullTouchIconUrl(str);
        }
        if (i == 7) {
            return getTouchIconUrlFor(str);
        }
        if (i == 1) {
            return getHashedCacheFilePath(str);
        }
        if (i == 9) {
            return getHashedResourceFilePath(str);
        }
        if (i != 2) {
            if (i == 8) {
                map = this.f1435a;
            } else {
                if (i != 10) {
                    return i == 1004 ? m2063s(str) : getCachedResource(str);
                }
                map = this.f1435a;
                str = str + ".touch-icon";
            }
            return (String) map.get(str);
        }
        int iIndexOf = str.indexOf(63);
        if (iIndexOf > 0) {
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf);
            String str2 = (String) this.f1435a.get(strSubstring);
            if (str2 != null) {
                strM6882V = str2 + strSubstring2;
            } else {
                strM6882V = (strSubstring.equals("x:s") || strSubstring.equals("x://s")) ? SharedPreferencesHelper.getInstance().getSearchUrl().replace("%keywords%", NetworkUtils.getQueryParam("q", str)) : null;
            }
        } else {
            strM6882V = (String) this.f1435a.get(str);
        }
        if (strM6882V == null) {
            if (!str.equals("x:s") && !str.equals("x://s")) {
                return str;
            }
            strM6882V = SharedPreferencesHelper.getInstance().getSearchUrl();
            if (TextUtils.isEmpty(strM6882V)) {
                return str;
            }
            int iIndexOf2 = strM6882V.indexOf(63);
            if (iIndexOf2 > 0) {
                return strM6882V.substring(0, iIndexOf2);
            }
        }
        return strM6882V;
    }

    public final String getHashedCacheFilePath(String input) {
        String cacheDir = PhoneUtils.getInstance().getCacheDirPath();
        int hash = Math.abs(input.hashCode());
        return cacheDir + "/" + hash;
    }

    public final String getHashedResourceFilePath(String str) {
        return PhoneUtils.getInstance().getResourcesDirPath() + "/" + Math.abs(str.hashCode());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x003f A[EXC_TOP_SPLITTER, PHI: r6
  0x003f: PHI (r6v7 android.database.Cursor) = (r6v6 android.database.Cursor), (r6v10 android.database.Cursor) binds: [B:22:0x004d, B:14:0x003d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public String getCachedResource(String r6) {
        /*
            r5 = this;
            r0 = 0
            f3 r1 = p000.C1714f3.m7483o0()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            r2.<init>()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            java.lang.String r3 = "SELECT resource_value FROM  resource_map WHERE resource_key='"
            r2.append(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            r2.append(r6)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            java.lang.String r6 = "'"
            r2.append(r6)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            android.database.Cursor r6 = r1.rawQuery(r6, r0)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            if (r6 == 0) goto L3d
            boolean r1 = r6.moveToFirst()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            if (r1 == 0) goto L3d
            java.lang.String r1 = "resource_value"
            int r1 = r6.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.lang.String r0 = r6.getString(r1)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r6.close()     // Catch: java.lang.Exception -> L38
        L38:
            return r0
        L39:
            r0 = move-exception
            goto L51
        L3b:
            r1 = move-exception
            goto L4a
        L3d:
            if (r6 == 0) goto L50
        L3f:
            r6.close()     // Catch: java.lang.Exception -> L50
            goto L50
        L43:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L51
        L48:
            r1 = move-exception
            r6 = r0
        L4a:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L39
            if (r6 == 0) goto L50
            goto L3f
        L50:
            return r0
        L51:
            if (r6 == 0) goto L56
            r6.close()     // Catch: java.lang.Exception -> L56
        L56:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ResourceCacheManager.m2049e(java.lang.String):java.lang.String");
    }

    public String m2050f(String str, String str2) throws JSONException {
        String strM2046a = m2046a("resource_url", 1007);
        if (TextUtils.isEmpty(strM2046a)) {
            return str2;
        }
        try {
            String string = new JSONObject(strM2046a).getString(str);
            return !TextUtils.isEmpty(string) ? string : str2;
        } catch (Exception unused) {
            return str2;
        }
    }

    public final String getFullTouchIconUrl(String url) {
        String baseIconUrl = ApiEndpointsManager.getInstance().getTouchIconUrl();
        String fileName = getImageFileName(url);

        if (".png".equals(fileName)) {
            return "";
        }

        return baseIconUrl + "/" + fileName;
    }

    public final String getTouchIconUrlFor(String url) {
        String baseIconUrl = ApiEndpointsManager.getInstance().getSmallTouchIconUrl();
        String fileName = getImageFileName(url);

        if (".png".equals(fileName)) {
            return "";
        }

        return baseIconUrl + "/" + fileName;
    }

    public void m2053i() throws JSONException {
        m2054j();
        m2055k();
        m2057m();
    }

    public final void m2054j() {
        HashMap map;
        String str;
        this.f1435a.put("x:history", "file:///android_asset/histories/histories.html");
        this.f1435a.put("x:bookmark", "file:///android_asset/bookmarks/bookmarks.html");
        this.f1435a.put("x:bm", "file:///android_asset/bookmarks/bookmarks.html");
        this.f1435a.put("x:dl", "file:///android_asset/download-manager/download-manager.html");
        this.f1435a.put("x:settings", "file:///android_asset/settings/settings.html");
        this.f1435a.put("x:st", "file:///android_asset/settings/settings.html");
        this.f1435a.put("x:as", "file:///android_asset/settings/adv-setting.html");
        this.f1435a.put("x:ua", "file:///android_asset/settings/custom-user-agent.html");
        this.f1435a.put("file:///android_asset/settings/custom-user-agent.html", "x:ua");
        this.f1435a.put("x:se", "file:///android_asset/settings/custom-search-engine.html");
        this.f1435a.put("file:///android_asset/settings/custom-search-engine.html", "x:se");
        this.f1435a.put("x:cr", "file:///android_asset/settings/custom-ad-rules.html");
        this.f1435a.put("file:///android_asset/settings/custom-ad-rules.html", "x:cr");
        this.f1435a.put("x:home", "file:///android_asset/start-page/index.html");
        this.f1435a.put("file:///android_asset/start-page/index.html", "x:home");
        this.f1435a.put("file:///android_asset/settings/custom-ad-rules.html", "x:block-rule");
        this.f1435a.put("file:///android_asset/settings/browser-info.html", "x:info");
        if (PhoneUtils.getInstance().isInChina()) {
            this.f1435a.put("x:sh", "https://www.xbext.com/docs/#user_script");
            this.f1435a.put("https://www.xbext.com/docs/#user_script", "x:sh");
            this.f1435a.put("x:rh", "https://www.xbext.com/docs/#ad_block");
            this.f1435a.put("https://www.xbext.com/docs/#ad_block", "x:rh");
            this.f1435a.put("x:ush", "https://www.xbext.com/docs/#user_script");
            this.f1435a.put("https://www.xbext.com/docs/#user_script", "x:ush");
            this.f1435a.put("x:help", "https://www.xbext.com/docs/#faq");
            this.f1435a.put("https://www.xbext.com/docs/#faq", "x:help");
            this.f1435a.put("x:pp", "https://www.xbext.com/docs/privacy-policy.html");
            this.f1435a.put("https://www.xbext.com/docs/privacy-policy.html", "x:pp");
            if (PhoneUtils.getInstance().isGooglePlayChannel()) {
                this.f1435a.put("x:fb", "https://en.xbext.com/feedback/");
                this.f1435a.put("https://en.xbext.com/feedback/", "x:fb");
            } else {
                this.f1435a.put("x:thk", "https://www.xbext.com/thanks/");
                this.f1435a.put("https://www.xbext.com/thanks/", "x:thk");
            }
            this.f1435a.put("x:thk", "https://www.xbext.com/thanks/");
            this.f1435a.put("https://www.xbext.com/thanks/", "x:thk");
            this.f1435a.put("x:hp", "https://www.xbext.com/?channel=" + PhoneUtils.getInstance().getChannelCode());
            this.f1435a.put("https://www.xbext.com/?channel=" + PhoneUtils.getInstance().getChannelCode(), "x:hp");
            this.f1435a.put("x:home-about", "https://www.xbext.com/about/");
            this.f1435a.put("x:plyr", "file:///android_asset/xplayer.html");
            this.f1435a.put("https://www.xbext.com/tags/%E6%89%A9%E5%B1%95/", "x:addon");
            map = this.f1435a;
            str = "https://www.xbext.com/tags/%E6%89%A9%E5%B1%95/";
        } else {
            this.f1435a.put("x:sh", "https://en.xbext.com/docs/#user_script");
            this.f1435a.put("https://en.xbext.com/docs/#user_script", "x:sh");
            this.f1435a.put("x:rh", "https://en.xbext.com/docs/tutorials/write-adblock-rule-for-xbrowser/");
            this.f1435a.put("https://en.xbext.com/docs/tutorials/write-adblock-rule-for-xbrowser/", "x:rh");
            this.f1435a.put("x:ush", "https://en.xbext.com/docs/#user_script");
            this.f1435a.put("https://en.xbext.com/docs/#user_script", "x:ush");
            this.f1435a.put("x:help", "https://en.xbext.com/docs/#faq");
            this.f1435a.put("https://en.xbext.com/docs/#faq", "x:help");
            this.f1435a.put("x:pp", "https://en.xbext.com/docs/privacy-policy.html");
            this.f1435a.put("https://en.xbext.com/docs/privacy-policy.html", "x:pp");
            this.f1435a.put("x:fb", "https://en.xbext.com/feedback/");
            this.f1435a.put("https://en.xbext.com/feedback/", "x:fb");
            this.f1435a.put("x:hp", "https://en.xbext.com/?channel=" + PhoneUtils.getInstance().getChannelCode());
            this.f1435a.put("https://en.xbext.com/?channel=" + PhoneUtils.getInstance().getChannelCode(), "x:hp");
            this.f1435a.put("x:home-about", "https://en.xbext.com/about/");
            this.f1435a.put("x:thk", "https://en.xbext.com/thanks/");
            this.f1435a.put("https://en.xbext.com/thanks/", "x:thk");
            this.f1435a.put("x:plyr", "file:///android_asset/xplayer_en.html");
            this.f1435a.put("https://en.xbext.com/tags/Extension/", "x:addon");
            map = this.f1435a;
            str = "https://en.xbext.com/tags/Extension/";
        }
        map.put("x:addon", str);
        this.f1435a.put("x:sc", "file:///android_asset/settings/user-scripts.html");
        this.f1435a.put("file:///android_asset/settings/user-scripts.html", "x:sc");
        this.f1435a.put("x:sf", "file:///android_asset/settings/user-script-form.html");
        this.f1435a.put("file:///android_asset/settings/user-script-form.html", "x:sf");
        this.f1435a.put("x:log", "file:///android_asset/log.html");
        this.f1435a.put("file:///android_asset/log.html", "x:log");
        this.f1435a.put("x:sd", "file:///android_asset/private-file-manager/private-file-manager.html");
        this.f1435a.put("file:///android_asset/private-file-manager/private-file-manager.html", "x:sd");
        this.f1435a.put("x:site", "file:///android_asset/settings/site-settings.html");
        this.f1435a.put("file:///android_asset/settings/site-settings.html", "x:site");
        this.f1435a.put("x:rl", "file:///android_asset/settings/site-settings.html?path=offlines");
        this.f1435a.put("file:///android_asset/settings/site-settings.html?path=offlines", "x:rl");
        this.f1435a.put("x:adb", "file:///android_asset/settings/adblock-setting.html");
        this.f1435a.put("file:///android_asset/settings/adblock-setting.html", "x:adb");
        this.f1435a.put("x:rf", "file:///android_asset/settings/ad-rule-file.html");
        this.f1435a.put("file:///android_asset/settings/ad-rule-file.html", "x:rf");
        this.f1435a.put("x:res", "file:///android_asset/page-resources/page-resources.html");
        this.f1435a.put("file:///android_asset/page-resources/page-resources.html", "x:res");
        this.f1435a.put("x:mc", "file:///android_asset/settings/menu-config.html");
        this.f1435a.put("file:///android_asset/settings/menu-config.html", "x:mc");
        this.f1435a.put("x:gs", "file:///android_asset/settings/gesture-setting.html");
        this.f1435a.put("file:///android_asset/settings/gesture-setting.html", "x:gs");
        this.f1435a.put("x:custom", "file:///android_asset/settings/customization.html");
        this.f1435a.put("file:///android_asset/settings/customization.html", "x:custom");
        this.f1435a.put("x:gens", "file:///android_asset/settings/general-setting.html");
        this.f1435a.put("file:///android_asset/settings/general-setting.html", "x:gens");
        this.f1435a.put("x:me", "file:///android_asset/settings/user-center.html");
        this.f1435a.put("file:///android_asset/settings/user-center.html", "x:me");
        this.f1435a.put("x:sp", "file:///android_asset/settings/privacy-setting.html");
        this.f1435a.put("file:///android_asset/settings/privacy-setting.html", "x:sp");
        this.f1435a.put("x:about", "file:///android_asset/settings/about.html");
        this.f1435a.put("file:///android_asset/settings/about.html", "x:about");
        this.f1435a.put("x:adb-log", "file:///android_asset/settings/adblock-log.html");
        this.f1435a.put("file:///android_asset/settings/adblock-log.html", "x:adb-log");
        this.f1435a.put("x:af", "file:///android_asset/settings/auto-fill-setting.html");
        this.f1435a.put("file:///android_asset/settings/auto-fill-setting.html", "x:af");
        this.f1435a.put("x:afp", "file:///android_asset/settings/auto-fill-passwd.html");
        this.f1435a.put("file:///android_asset/settings/auto-fill-passwd.html", "x:afp");
        this.f1435a.put("x:afc", "file:///android_asset/settings/auto-fill-card.html");
        this.f1435a.put("file:///android_asset/settings/auto-fill-card.html", "x:afc");
        this.f1435a.put("x:afa", "file:///android_asset/settings/auto-fill-addr.html");
        this.f1435a.put("file:///android_asset/settings/auto-fill-addr.html", "x:afa");
        this.f1435a.put("x:info", "file:///android_asset/settings/browser-info.html");
        this.f1435a.put("x:hosts", "file:///android_asset/settings/domain-manager.html");
        this.f1435a.put("file:///android_asset/settings/domain-manager.html", "x:hosts");
        this.f1435a.put("x:block-rule", "file:///android_asset/settings/custom-ad-rules.html");
        this.f1435a.put("file:///android_asset/settings/custom-ad-rules.html", "x:block-rule");
    }

    public final void m2055k() {
        m2059o("baidu.com", "url-to-icon-by-domain", 10);
        m2059o("taobao.com", "url-to-icon-by-domain", 10);
        m2059o("m.taobao.com", "url-to-icon-by-domain", 10);
        m2059o("mos.m.taobao.com", "url-to-icon-by-domain", 10);
        m2059o("google.com", "url-to-icon-by-domain", 10);
        m2059o("twitter.com", "url-to-icon-by-domain", 10);
        m2059o("youtube.com", "url-to-icon-by-domain", 10);
        m2059o("facebook.com", "url-to-icon-by-domain", 10);
        m2059o("ebay.com", "url-to-icon-by-domain", 10);
        m2059o("amazon.com", "url-to-icon-by-domain", 10);
        m2059o("toutiao.com", "url-to-icon-by-domain", 10);
        m2059o("iwebshuttle.com", "url-to-icon-by-domain", 10);
        m2059o("qq.com", "url-to-icon-by-domain", 10);
        m2059o("guokr.com", "url-to-icon-by-domain", 10);
        m2059o("36kr.com", "url-to-icon-by-domain", 10);
        m2059o("youku.com", "url-to-icon-by-domain", 10);
        m2059o("weibo.com", "url-to-icon-by-domain", 10);
        m2059o("v.qq.com", "url-to-icon-by-domain", 10);
        m2059o("sina.com", "url-to-icon-by-domain", 10);
        m2059o("zhihu.com", "url-to-icon-by-domain", 10);
        m2059o("bing.com", "url-to-icon-by-domain", 10);
        m2059o("bilibili.com", "url-to-icon-by-domain", 10);
        m2059o("x:bookmark", "url-to-icon-by-domain", 10);
        m2059o("x:history", "url-to-icon-by-domain", 10);
        m2059o("x:his", "url-to-icon-by-domain", 10);
        m2059o("hupu.com", "url-to-icon-by-domain", 10);
        m2059o("weibo.cn", "url-to-icon-by-domain", 10);
        m2059o("xbext.com", "url-to-icon-by-domain", 10);
        m2059o("union-click.jd.com", "url-to-icon-by-domain", 10);
        m2059o("coolapk.com", "url-to-icon-by-domain", 10);
        m2059o("sm.cn", "url-to-icon-by-domain", 10);
        m2059o("gamezop.com", "url-to-icon-by-domain", 10);
        m2059o("astrozop.com", "url-to-icon-by-domain", 10);
        m2059o("read.astrozop.com", "url-to-icon-by-domain", 10);
        m2059o("read.criczop.com", "url-to-icon-by-domain", 10);
        m2059o("read.newszop.com", "url-to-icon-by-domain", 10);
        m2059o("gamereo.com", "url-to-icon-by-domain", 10);
        m2059o("thopquiz.com", "url-to-icon-by-domain", 10);
        m2059o("play.quizzop.com", "url-to-icon-by-domain", 10);
        m2059o("sogou.com", "url-to-icon-by-domain", 10);
        m2059o("metaso.cn", "url-to-icon-by-domain", 10);
        m2059o("news.mxfast.com", "url-to-icon-by-domain", 10);
        m2059o("https://ww55.affinity.net/sssdomweb?enk=f22c65f06952917b0746605835ffffc962d68ee5c9c538fc847beb151f58c840d5978d3011f650737d4321895a2d798c3acec33b49c3549d297065f2975465e8f2c8d29d83cedfdb&di={device_identifier}&cid={click_id}&subid={subid}&qld={app_domain}&ch_ua_fvl={ch_ua_fvl}&ch_ua_bit={ch_ua_bit}&ch_ua_model={ch_ua_model}&ch_ua_pf_v={ch_ua_pf_v}&ch_ua_pf={ch_ua_pf}&ch_ua_fv={ch_ua_fv}&ch_ua_mob={ch_ua_mob}&ch_ua={ch_ua}&dc={dc}", "croma.com", 10);
        m2059o("https://ww55.affinity.net/sssdomweb?enk=f22c65f06952917b0746605835ffffc962d68ee5c9c538fcf7e4ce043dd4e313b41c4c05b86c2a316dfd482904d9d17b3acec33b49c3549d297065f2975465e8f2c8d29d83cedfdb&di={device_identifier}&cid={click_id}&subid={subid}&qld={app_domain}&ch_ua_fvl={ch_ua_fvl}&ch_ua_bit={ch_ua_bit}&ch_ua_model={ch_ua_model}&ch_ua_pf_v={ch_ua_pf_v}&ch_ua_pf={ch_ua_pf}&ch_ua_fv={ch_ua_fv}&ch_ua_mob={ch_ua_mob}&ch_ua={ch_ua}&dc={dc}", "amazon.com", 10);
        m2059o("https://ww55.siteplug.com/sssdomweb?enk=f22c65f06952917b0746605835ffffc962d68ee5c9c538fc294687d1771cf04b7c20567570c10fbacf1d0451eb0837b13acec33b49c3549d297065f2975465e8f2c8d29d83cedfdb&di={device_identifier}&cid={click_id}&subid={subid}&qld={app_domain}&ch_ua_fvl={ch_ua_fvl}&ch_ua_bit={ch_ua_bit}&ch_ua_model={ch_ua_model}&ch_ua_pf_v={ch_ua_pf_v}&ch_ua_pf={ch_ua_pf}&ch_ua_fv={ch_ua_fv}&ch_ua_mob={ch_ua_mob}&ch_ua={ch_ua}&dc={dc}", "myntra.com", 10);
        m2059o("https://browser.umeweb.com/cn_ume_api/goto?target=sohu_new01", "sohu.com", 10);
        m2059o("https://go.hypergames.top/Xmini/donttap/index.html", "game.dont.tap", 10);
        m2059o("https://go.hypergames.top/Xmini/footballsuperstars/index.html", "game.football", 10);
    }

    public final boolean m2056l(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("resource_map", DatabaseColumns.RESOURCE_MAP, "resource_key= ?", new String[]{str}, null, null, null);
        long j = -1;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return j >= 0;
    }

    public void m2057m() throws JSONException {
        String strM2049e = getCachedResource("url_icon_maps");
        if (TextUtils.isEmpty(strM2049e)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(strM2049e);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strM3666k = JsonUtils.getString(jSONObject, "url", "");
                String strM3666k2 = JsonUtils.getString(jSONObject, "icon_key", "");
                if (!TextUtils.isEmpty(strM3666k) && !TextUtils.isEmpty(strM3666k2)) {
                    m2059o(strM3666k, strM3666k2, 10);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final String getUriPathAsDotNotation(String url) {
        Uri uri = Uri.parse(url);
        String path = uri.getPath();

        if (!TextUtils.isEmpty(path)) {
            // Remove leading slash
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            // Remove trailing slash
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            // Replace remaining slashes with dots
            if (!path.isEmpty()) {
                return path.replace("/", ".");
            }
        }

        // Fallback to host if path is empty
        return uri.getHost();
    }

    public void m2059o(String str, String str2, int i) {
        if (i == 10) {
            this.f1435a.put(str + ".touch-icon", str2);
        }
    }

    public void saveResource(String str, String str2) throws SQLException {
        String str3;
        try {
            SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
            if (m2056l(writableDatabase, str)) {
                str3 = "UPDATE resource_map SET resource_value ='" + str2 + "' WHERE resource_key='" + str + "'";
            } else {
                str3 = "INSERT INTO resource_map(resource_key,resource_value ) VALUES ('" + str + "', '" + str2 + "')";
            }
            writableDatabase.execSQL(str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m2061q(String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("resource_key", str);
        contentValues.put("resource_value", str2);
        contentValues.put("resource_type", Integer.valueOf(i));
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        if (m2062r(str, str2) < 0) {
            writableDatabase.insert("resource_map", null, contentValues);
        }
    }

    public final long m2062r(String str, String str2) {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        Cursor cursorQuery = writableDatabase.query("resource_map", DatabaseColumns.RESOURCE_MAP, "resource_key= ?", new String[]{str}, null, null, null);
        if (cursorQuery == null) {
            return -1L;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                return -1L;
            }
            long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
            ContentValues contentValues = new ContentValues();
            contentValues.put("resource_value", str2);
            writableDatabase.update("resource_map", contentValues, "_id=" + j, null);
            return j;
        } finally {
            cursorQuery.close();
        }
    }

    public final String m2063s(String str) {
        return TextUtils.isEmpty(str) ? "" : str.indexOf("article_list_for_xb_readmode") > 0 ? "x.readmode" : Uri.parse(str).getHost();
    }

    public final String getImageFileName(String url) {
        if (TextUtils.isEmpty(url)) {
            return "";
        }

        String result;

        if (url.startsWith("x:")) {
            // Replace ':' with '.'
            result = url.replace(":", ".");
        } else if (url.contains("xbext.com") || url.startsWith("https://lkbx.me")) {
            result = getUriPathAsDotNotation(url);
        } else if (url.startsWith("https://ai.m.taobao.com/bu.html")) {
            result = "tj.taobao.com";
        } else if (url.startsWith("https://mos.m.taobao.com/union/1212shishi2c_2C")) {
            result = "mos.m.taobao.com";
        } else if (url.startsWith("https://s.click.taobao.com/t")) {
            result = "tmall.com";
        } else {
            String shortName = m2046a(url, 10);
            if (!TextUtils.isEmpty(shortName)) {
                result = shortName;
            } else {
                String host = Uri.parse(url).getHost();
                result = host != null ? NetworkUtils.getFileExtension(host) : "";
            }
        }

        return result + ".png";
    }
}
