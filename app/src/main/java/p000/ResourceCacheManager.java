package p000;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

import com.mmbox.xbrowser.SharedPreferencesHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResourceCacheManager {

    public static ResourceCacheManager instance;

    public HashMap<String, String> resourceMap = new HashMap<>();

    public static ResourceCacheManager getInstance() {
        if (instance == null) {
            instance = new ResourceCacheManager();
        }
        return instance;
    }

    public String getUrlOrFilePath(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }

        switch (i) {
            case 0:
                return getFullTouchIconUrl(str);
            case 7:
                return getTouchIconUrlFor(str);
            case 1:
                return getHashedCacheFilePath(str);
            case 9:
                return getHashedResourceFilePath(str);
            case 2:
                return getSearchUrl(str);
            case 8:
                return resourceMap.get(str);
            case 10:
                return resourceMap.get(str + ".touch-icon");
            case 1004:
                return getReadModeOrHostFromUrl(str);
            default:
                return getResourceValueByKey(str);
        }
    }

    private String getSearchUrl(String url) {
        int index = url.indexOf("?");
        String searchUrl = null;
        if (index > 0) {
            String baseUrl = url.substring(0, index);
            String queryString = url.substring(index);
            String mappedUrl = this.resourceMap.get(baseUrl);
            if (mappedUrl != null) {
                searchUrl = mappedUrl + queryString;
            } else {
                searchUrl = (baseUrl.equals("x:s") || baseUrl.equals("x://s"))
                        ? SharedPreferencesHelper.getInstance().getSearchUrl().replace("%keywords%", NetworkUtils.getQueryParam("q", url))
                        : null;
            }
        } else {
            searchUrl = this.resourceMap.get(url);
        }

        if (searchUrl == null && !url.equals("x:s") && !url.equals("x://s")) {
            searchUrl = SharedPreferencesHelper.getInstance().getSearchUrl();
        }

        if (TextUtils.isEmpty(searchUrl)) {
            return url;
        }

        int index2 = searchUrl.indexOf("?");
        if (index2 > 0) {
            return searchUrl.substring(0, index2);
        }
        return searchUrl;
    }

    public final String getHashedCacheFilePath(String input) {
        String cacheDir = PhoneUtils.getInstance().getCacheDirPath();
        int hash = Math.abs(input.hashCode());
        return cacheDir + "/" + hash;
    }

    public final String getHashedResourceFilePath(String str) {
        return PhoneUtils.getInstance().getResourcesDirPath() + "/" + Math.abs(str.hashCode());
    }

    @SuppressLint("Range")
    public String getResourceValueByKey(String resourceKey) {
        String result = null;

        try (Cursor cursor = MySQLiteOpenHelper.getInstance().getReadableDatabase().rawQuery(
                "SELECT resource_value FROM resource_map WHERE resource_key=?",
                new String[]{resourceKey})) {

            if (cursor.moveToFirst()) {
                result = cursor.getString(cursor.getColumnIndex("resource_value"));
            }
        } catch (Exception e) {
            e.printStackTrace();  // You could use a logger instead
        }
        // Always close cursor in finally block

        return result;
    }

    public String getStringFromJsonOrDefault(String key, String defaultValue) {
        String resourceUrl = getUrlOrFilePath("resource_url", 1007);

        // Return the default value if resource URL is empty
        if (TextUtils.isEmpty(resourceUrl)) {
            return defaultValue;
        }

        try {
            // Parse the JSON string to retrieve the value associated with the key
            JSONObject jsonObject = new JSONObject(resourceUrl);
            String value = jsonObject.optString(key, defaultValue);

            // Return the value if found, else return the default value
            return !TextUtils.isEmpty(value) ? value : defaultValue;

        } catch (JSONException e) {
            e.printStackTrace();  // Log the exception for debugging
            return defaultValue;
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
        initializeResourceMappings();
        initializeResourceIcons();
        mapIconsFromJson();
    }

    public final void initializeResourceMappings() {
        // Resource mappings for common resources
        addCommonResources();

        // Region-specific resources
        if (PhoneUtils.getInstance().isInChina()) {
            addChinaSpecificResources();
        } else {
            addGlobalResources();
        }
    }

    private void addCommonResources() {
        this.resourceMap.put("x:history", "file:///android_asset/histories/histories.html");
        this.resourceMap.put("x:bookmark", "file:///android_asset/bookmarks/bookmarks.html");
        this.resourceMap.put("x:bm", "file:///android_asset/bookmarks/bookmarks.html");
        this.resourceMap.put("x:dl", "file:///android_asset/download-manager/download-manager.html");
        this.resourceMap.put("x:settings", "file:///android_asset/settings/settings.html");
        this.resourceMap.put("x:st", "file:///android_asset/settings/settings.html");
        this.resourceMap.put("x:as", "file:///android_asset/settings/adv-setting.html");
        this.resourceMap.put("x:ua", "file:///android_asset/settings/custom-user-agent.html");
        this.resourceMap.put("file:///android_asset/settings/custom-user-agent.html", "x:ua");
        this.resourceMap.put("x:se", "file:///android_asset/settings/custom-search-engine.html");
        this.resourceMap.put("file:///android_asset/settings/custom-search-engine.html", "x:se");
        this.resourceMap.put("x:cr", "file:///android_asset/settings/custom-ad-rules.html");
        this.resourceMap.put("file:///android_asset/settings/custom-ad-rules.html", "x:cr");
        this.resourceMap.put("x:home", "file:///android_asset/start-page/index.html");
        this.resourceMap.put("file:///android_asset/start-page/index.html", "x:home");
        this.resourceMap.put("file:///android_asset/settings/custom-ad-rules.html", "x:block-rule");
        this.resourceMap.put("file:///android_asset/settings/browser-info.html", "x:info");
    }

    private void addChinaSpecificResources() {
        // China-specific URLs
        String baseUrl = "https://www.xbext.com";
        this.resourceMap.put("x:sh", baseUrl + "/docs/#user_script");
        this.resourceMap.put(baseUrl + "/docs/#user_script", "x:sh");
        this.resourceMap.put("x:rh", baseUrl + "/docs/#ad_block");
        this.resourceMap.put(baseUrl + "/docs/#ad_block", "x:rh");
        this.resourceMap.put("x:ush", baseUrl + "/docs/#user_script");
        this.resourceMap.put(baseUrl + "/docs/#user_script", "x:ush");
        this.resourceMap.put("x:help", baseUrl + "/docs/#faq");
        this.resourceMap.put(baseUrl + "/docs/#faq", "x:help");
        this.resourceMap.put("x:pp", baseUrl + "/docs/privacy-policy.html");
        this.resourceMap.put(baseUrl + "/docs/privacy-policy.html", "x:pp");

        // Conditional feedback URL
        if (PhoneUtils.getInstance().isGooglePlayChannel()) {
            this.resourceMap.put("x:fb", "https://en.xbext.com/feedback/");
            this.resourceMap.put("https://en.xbext.com/feedback/", "x:fb");
        } else {
            this.resourceMap.put("x:thk", baseUrl + "/thanks/");
            this.resourceMap.put(baseUrl + "/thanks/", "x:thk");
        }

        this.resourceMap.put("x:thk", baseUrl + "/thanks/");
        this.resourceMap.put(baseUrl + "/thanks/", "x:thk");
        this.resourceMap.put("x:hp", baseUrl + "/?channel=" + PhoneUtils.getInstance().getChannelCode());
        this.resourceMap.put(baseUrl + "/?channel=" + PhoneUtils.getInstance().getChannelCode(), "x:hp");
        this.resourceMap.put("x:home-about", baseUrl + "/about/");
        this.resourceMap.put("x:plyr", "file:///android_asset/xplayer.html");
        this.resourceMap.put(baseUrl + "/tags/%E6%89%A9%E5%B1%95/", "x:addon");
    }

    private void addGlobalResources() {
        // Global URLs
        String baseUrl = "https://en.xbext.com";
        this.resourceMap.put("x:sh", baseUrl + "/docs/#user_script");
        this.resourceMap.put(baseUrl + "/docs/#user_script", "x:sh");
        this.resourceMap.put("x:rh", baseUrl + "/docs/tutorials/write-adblock-rule-for-xbrowser/");
        this.resourceMap.put(baseUrl + "/docs/tutorials/write-adblock-rule-for-xbrowser/", "x:rh");
        this.resourceMap.put("x:ush", baseUrl + "/docs/#user_script");
        this.resourceMap.put(baseUrl + "/docs/#user_script", "x:ush");
        this.resourceMap.put("x:help", baseUrl + "/docs/#faq");
        this.resourceMap.put(baseUrl + "/docs/#faq", "x:help");
        this.resourceMap.put("x:pp", baseUrl + "/docs/privacy-policy.html");
        this.resourceMap.put(baseUrl + "/docs/privacy-policy.html", "x:pp");
        this.resourceMap.put("x:fb", baseUrl + "/feedback/");
        this.resourceMap.put(baseUrl + "/feedback/", "x:fb");
        this.resourceMap.put("x:hp", baseUrl + "/?channel=" + PhoneUtils.getInstance().getChannelCode());
        this.resourceMap.put(baseUrl + "/?channel=" + PhoneUtils.getInstance().getChannelCode(), "x:hp");
        this.resourceMap.put("x:home-about", baseUrl + "/about/");
        this.resourceMap.put("x:thk", baseUrl + "/thanks/");
        this.resourceMap.put(baseUrl + "/thanks/", "x:thk");
        this.resourceMap.put("x:plyr", "file:///android_asset/xplayer_en.html");
        this.resourceMap.put(baseUrl + "/tags/Extension/", "x:addon");
    }

    public final void initializeResourceIcons() {
        // List of domains for which we want to fetch the icons
        List<String> domains = Arrays.asList(
                "baidu.com", "taobao.com", "m.taobao.com", "mos.m.taobao.com", "google.com",
                "twitter.com", "youtube.com", "facebook.com", "ebay.com", "amazon.com",
                "toutiao.com", "iwebshuttle.com", "qq.com", "guokr.com", "36kr.com",
                "youku.com", "weibo.com", "v.qq.com", "sina.com", "zhihu.com", "bing.com",
                "bilibili.com", "x:bookmark", "x:history", "x:his", "hupu.com", "weibo.cn",
                "xbext.com", "union-click.jd.com", "coolapk.com", "sm.cn", "gamezop.com",
                "astrozop.com", "read.astrozop.com", "read.criczop.com", "read.newszop.com",
                "gamereo.com", "thopquiz.com", "play.quizzop.com", "sogou.com", "metaso.cn",
                "news.mxfast.com"
        );

        // Iterate over the domains and apply the icon mapping
        for (String domain : domains) {
            mapIconToDomain(domain, "url-to-icon-by-domain", 10);
        }

        // Special URLs with specific icons
        mapIconToDomain("https://ww55.affinity.net/sssdomweb?enk=f22c65f06952917b0746605835ffffc962d68ee5c9c538fc847beb151f58c840d5978d3011f650737d4321895a2d798c3acec33b49c3549d297065f2975465e8f2c8d29d83cedfdb&di={device_identifier}&cid={click_id}&subid={subid}&qld={app_domain}&ch_ua_fvl={ch_ua_fvl}&ch_ua_bit={ch_ua_bit}&ch_ua_model={ch_ua_model}&ch_ua_pf_v={ch_ua_pf_v}&ch_ua_pf={ch_ua_pf}&ch_ua_fv={ch_ua_fv}&ch_ua_mob={ch_ua_mob}&ch_ua={ch_ua}&dc={dc}", "croma.com", 10);
        mapIconToDomain("https://ww55.affinity.net/sssdomweb?enk=f22c65f06952917b0746605835ffffc962d68ee5c9c538fcf7e4ce043dd4e313b41c4c05b86c2a316dfd482904d9d17b3acec33b49c3549d297065f2975465e8f2c8d29d83cedfdb&di={device_identifier}&cid={click_id}&subid={subid}&qld={app_domain}&ch_ua_fvl={ch_ua_fvl}&ch_ua_bit={ch_ua_bit}&ch_ua_model={ch_ua_model}&ch_ua_pf_v={ch_ua_pf_v}&ch_ua_pf={ch_ua_pf}&ch_ua_fv={ch_ua_fv}&ch_ua_mob={ch_ua_mob}&ch_ua={ch_ua}&dc={dc}", "amazon.com", 10);
        mapIconToDomain("https://ww55.siteplug.com/sssdomweb?enk=f22c65f06952917b0746605835ffffc962d68ee5c9c538fc294687d1771cf04b7c20567570c10fbacf1d0451eb0837b13acec33b49c3549d297065f2975465e8f2c8d29d83cedfdb&di={device_identifier}&cid={click_id}&subid={subid}&qld={app_domain}&ch_ua_fvl={ch_ua_fvl}&ch_ua_bit={ch_ua_bit}&ch_ua_model={ch_ua_model}&ch_ua_pf_v={ch_ua_pf_v}&ch_ua_pf={ch_ua_pf}&ch_ua_fv={ch_ua_fv}&ch_ua_mob={ch_ua_mob}&ch_ua={ch_ua}&dc={dc}", "myntra.com", 10);
        mapIconToDomain("https://browser.umeweb.com/cn_ume_api/goto?target=sohu_new01", "sohu.com", 10);
        mapIconToDomain("https://go.hypergames.top/Xmini/donttap/index.html", "game.dont.tap", 10);
        mapIconToDomain("https://go.hypergames.top/Xmini/footballsuperstars/index.html", "game.football", 10);
    }

    public void mapIconToDomain(String url, String icon, int i) {
        if (i == 10) {
            this.resourceMap.put(url + ".touch-icon", icon);
        }
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

    public void mapIconsFromJson() {
        String resourceValue = getResourceValueByKey("url_icon_maps");
        if (TextUtils.isEmpty(resourceValue)) {
            return;
        }
        try {
            JSONArray jsonArray = new JSONArray(resourceValue);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String url = JsonUtils.getString(jsonObject, "url", "");
                String iconKey = JsonUtils.getString(jsonObject, "icon_key", "");
                if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(iconKey)) {
                    mapIconToDomain(url, iconKey, 10);
                }
            }
        } catch (Exception e) {
            // Handle exception if needed, or log it
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

    public final String getReadModeOrHostFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.contains("article_list_for_xb_readmode") ? "x.readmode" : Uri.parse(str).getHost();
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
            String shortName = getUrlOrFilePath(url, 10);
            if (!TextUtils.isEmpty(shortName)) {
                result = shortName;
            } else {
                String host = Uri.parse(url).getHost();
                result = host != null ? NetworkUtils.getDomain(host) : "";
            }
        }

        return result + ".png";
    }
}
