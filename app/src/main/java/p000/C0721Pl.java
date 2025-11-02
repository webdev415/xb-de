package p000;

import android.text.TextUtils;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class C0721Pl extends AbstractResourceManager {

    public class a implements Runnable {
        public a() {
        }

        @Override
        public void run() {
            BrowserActivity.getActivity().m6308d3();
        }
    }

    public C0721Pl(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accept_cookies", SharedPreferencesHelper.getInstance().getBoolean("accept_cookies", true));
            jSONObject.put("disable-third-cookies", SharedPreferencesHelper.getInstance().getBoolean("disable-third-cookies", false));
            jSONObject.put("active-ad-block", SharedPreferencesHelper.getInstance().getBoolean("active-ad-block", false));
            jSONObject.put("enable-tampermonkey", SharedPreferencesHelper.getInstance().getBoolean("enable-tampermonkey", true));
            jSONObject.put("support-volume-page-down", SharedPreferencesHelper.getInstance().getBoolean("support-volume-page-down", false));
            jSONObject.put("auto-sniff-media", SharedPreferencesHelper.getInstance().getBoolean("auto-sniff-media", false));
            jSONObject.put("deep-sniff-media", SharedPreferencesHelper.getInstance().getBoolean("deep-sniff-media", false));
            jSONObject.put("disable-read-mode", SharedPreferencesHelper.getInstance().getBoolean("disable-read-mode", false));
            jSONObject.put("accept-eula", SharedPreferencesHelper.getInstance().getBoolean("accept-eula", true));
            jSONObject.put("unlock-to-view-his", SharedPreferencesHelper.getInstance().getBoolean("unlock-to-view-his", false));
            jSONObject.put("browser_theme", SharedPreferencesHelper.getInstance().getString("browser_theme", ThemeManager.getInstance().m9502w()));
            jSONObject.put("clean_history_checked", SharedPreferencesHelper.getInstance().getBoolean("clean_history_checked", false));
            jSONObject.put("ignore_security_warnings", SharedPreferencesHelper.getInstance().getBoolean("ignore_security_warnings", false));
            jSONObject.put("dont-upload-user-exp-data", SharedPreferencesHelper.getInstance().getBoolean("dont-upload-user-exp-data", false));
            jSONObject.put("enable_geolocation", SharedPreferencesHelper.getInstance().getBoolean("enable_geolocation", true));
            jSONObject.put("clean_web_cookies_checked", SharedPreferencesHelper.getInstance().getBoolean("clean_web_cookies_checked", false));
            jSONObject.put("clean_history_checked", SharedPreferencesHelper.getInstance().getBoolean("clean_history_checked", false));
            jSONObject.put("clean_web_app_cache_checked", SharedPreferencesHelper.getInstance().getBoolean("clean_web_app_cache_checked", false));
            jSONObject.put("clean-web-cache-on-exit", SharedPreferencesHelper.getInstance().getBoolean("clean-web-cache-on-exit", false));
            jSONObject.put("force-user-scalable", SharedPreferencesHelper.getInstance().getBoolean("force-user-scalable", false));
            jSONObject.put("auto-wrap-when-scaled", SharedPreferencesHelper.getInstance().getBoolean("auto-wrap-when-scaled", false));
            jSONObject.put("default_layout_type", SharedPreferencesHelper.getInstance().getInt("default_layout_type", 4097));
            jSONObject.put("ad_rule_update_circle", SharedPreferencesHelper.getInstance().getInt("ad_rule_update_circle", 0));
            jSONObject.put("recovery_tab_type", SharedPreferencesHelper.getInstance().getInt("recovery_tab_type", 0));
            jSONObject.put("custom_search_urls", SharedPreferencesHelper.getInstance().getString("custom_search_urls", ""));
            jSONObject.put("trans_engine_url", SharedPreferencesHelper.getInstance().getString("trans_engine_url", ""));
            jSONObject.put("custom_ua", SharedPreferencesHelper.getInstance().getString("custom_ua", ""));
            jSONObject.put("sync_resource_conf", SharedPreferencesHelper.getInstance().getString("sync_resource_conf", ""));
            jSONObject.put("rule_file_info", SharedPreferencesHelper.getInstance().getString("rule_file_info", ""));
            jSONObject.put("bm_order", SharedPreferencesHelper.getInstance().getString("bm_order", ""));
            jSONObject.put("unlock-password", SharedPreferencesHelper.getInstance().getString("unlock-password", "{}"));
            jSONObject.put("default_brightness", SharedPreferencesHelper.getInstance().getInt("default_brightness", -1));
            jSONObject.put("support-switch-tab-gesture", SharedPreferencesHelper.getInstance().getBoolean("support-switch-tab-gesture", false));
            jSONObject.put("disable-pull-to-refresh-gesture", SharedPreferencesHelper.getInstance().getBoolean("disable-pull-to-refresh-gesture", false));
            jSONObject.put("disable-pull-to-search-gesture", SharedPreferencesHelper.getInstance().getBoolean("disable-pull-to-search-gesture", false));
            jSONObject.put("disable-search-bar-hotword", SharedPreferencesHelper.getInstance().getBoolean("disable-search-bar-hotword", false));
            jSONObject.put("disable-search-suggestion", SharedPreferencesHelper.getInstance().getBoolean("disable-search-suggestion", false));
            jSONObject.put("do-not-show-browser-his", SharedPreferencesHelper.getInstance().getBoolean("do-not-show-browser-his", false));
            jSONObject.put("do-not-show-clipboard-content", SharedPreferencesHelper.getInstance().getBoolean("do-not-show-clipboard-content", false));
            jSONObject.put("do-not-show-search-his", SharedPreferencesHelper.getInstance().getBoolean("do-not-show-search-his", false));
            jSONObject.put("disable-javascript", SharedPreferencesHelper.getInstance().getBoolean("disable-javascript", false));
            jSONObject.put("enable-smart-adb", SharedPreferencesHelper.getInstance().getBoolean("enable-smart-adb", false));
            jSONObject.put("block-pop-window", SharedPreferencesHelper.getInstance().getBoolean("block-pop-window", false));
            jSONObject.put("support-multi-win", SharedPreferencesHelper.getInstance().getBoolean("support-multi-win", true));
            jSONObject.put("enter-night-mode", SharedPreferencesHelper.getInstance().getBoolean("enter-night-mode", false));
            jSONObject.put("follow-sys-dark-mode", SharedPreferencesHelper.getInstance().getBoolean("follow-sys-dark-mode", false));
            jSONObject.put("enter-private-mode", SharedPreferencesHelper.getInstance().getBoolean("enter-private-mode", false));
            jSONObject.put("use-public-download-dir", SharedPreferencesHelper.getInstance().getBoolean("use-public-download-dir", true));
            jSONObject.put("remind-when-down-complete", SharedPreferencesHelper.getInstance().getBoolean("remind-when-down-complete", false));
            jSONObject.put("hide-add-qa-btn", SharedPreferencesHelper.getInstance().getBoolean("hide-add-qa-btn", false));
            jSONObject.put("hide-start-page-logo", SharedPreferencesHelper.getInstance().getBoolean("hide-start-page-logo", false));
            jSONObject.put("use-circular-style-qa-icon", SharedPreferencesHelper.getInstance().getBoolean("use-circular-style-qa-icon", false));
            jSONObject.put("use-pure-color-icon", SharedPreferencesHelper.getInstance().getBoolean("use-pure-color-icon", false));
            jSONObject.put("display-qa-in-single-screen", SharedPreferencesHelper.getInstance().getBoolean("display-qa-in-single-screen", false));
            jSONObject.put("qa-fill-the-whole-screen", SharedPreferencesHelper.getInstance().getBoolean("qa-fill-the-whole-screen", false));
            jSONObject.put("show-qa-icons", SharedPreferencesHelper.getInstance().getBoolean("show-qa-icons", true));
            jSONObject.put("enable_call_app", SharedPreferencesHelper.getInstance().getBoolean("enable_call_app", true));
            jSONObject.put("disable-write-clipboard", SharedPreferencesHelper.getInstance().getBoolean("disable-write-clipboard", false));
            jSONObject.put("enable-dnt", SharedPreferencesHelper.getInstance().getBoolean("enable-dnt", false));
            jSONObject.put("enable-remote-debug", SharedPreferencesHelper.getInstance().getBoolean("enable-remote-debug", false));
            jSONObject.put("home_page", SharedPreferencesHelper.getInstance().getString("home_page", "x:home"));
            jSONObject.put("search-bar-at-top.toolbar_layout", SharedPreferencesHelper.getInstance().getString("search-bar-at-top.toolbar_layout", "layout_1"));
            jSONObject.put("search-bar-at-bottom.toolbar_layout", SharedPreferencesHelper.getInstance().getString("search-bar-at-bottom.toolbar_layout", "layout_3"));
            jSONObject.put("search-bar-at-top.toolbar_layout", SharedPreferencesHelper.getInstance().getString("search-bar-at-top.toolbar_layout", "x:home"));
            jSONObject.put("user_search_url", SharedPreferencesHelper.getInstance().getString("user_search_url", null));
            jSONObject.put("home_icon_alpha", SharedPreferencesHelper.getInstance().getInt("home_icon_alpha", 255));
            jSONObject.put("keep-screen-on", SharedPreferencesHelper.getInstance().getBoolean("keep-screen-on", false));
            jSONObject.put("disable-fast-scrolling-slider", SharedPreferencesHelper.getInstance().getBoolean("disable-fast-scrolling-slider", false));
            jSONObject.put("load_images", SharedPreferencesHelper.getInstance().getBoolean("load_images", true));
            jSONObject.put("enable-immersive-mode", SharedPreferencesHelper.getInstance().getBoolean("enable-immersive-mode", true));
            jSONObject.put("fullscreen-with-float-btn", SharedPreferencesHelper.getInstance().getBoolean("fullscreen-with-float-btn", false));
            jSONObject.put("night_brightness", SharedPreferencesHelper.getInstance().getInt("night_brightness", 15));
            jSONObject.put("open-search-in-new-tab", SharedPreferencesHelper.getInstance().getBoolean("open-search-in-new-tab", false));
            jSONObject.put("confirm-when-close-tabs", SharedPreferencesHelper.getInstance().getBoolean("confirm-when-close-tabs", false));
            jSONObject.put("close-tab-in-order", SharedPreferencesHelper.getInstance().getBoolean("close-tab-in-order", false));
            jSONObject.put("new-tab-at-bottom", SharedPreferencesHelper.getInstance().getBoolean("new-tab-at-bottom", false));
            jSONObject.put("force-open-in-new-tab", SharedPreferencesHelper.getInstance().getBoolean("force-open-in-new-tab", false));
            jSONObject.put("open-unclose-tab", SharedPreferencesHelper.getInstance().getBoolean("open-unclose-tab", true));
            jSONObject.put("limit_xproxy_flow", SharedPreferencesHelper.getInstance().getBoolean("limit_xproxy_flow", true));
            jSONObject.put("disable-video-force-landscape", SharedPreferencesHelper.getInstance().getBoolean("disable-video-force-landscape", false));
            jSONObject.put("disable-gesture-in-video-fullscreen", SharedPreferencesHelper.getInstance().getBoolean("disable-gesture-in-video-fullscreen", false));
            jSONObject.put("browser_fullscreen_mode", SharedPreferencesHelper.getInstance().getBoolean("browser_fullscreen_mode", false));
            jSONObject.put("PLS_RANK_MESSAGE_SHOWED", SharedPreferencesHelper.getInstance().getBoolean("PLS_RANK_MESSAGE_SHOWED", false));
            jSONObject.put("PLS_SHARE_MESSAGE_SHOWED", SharedPreferencesHelper.getInstance().getBoolean("PLS_SHARE_MESSAGE_SHOWED", false));
            jSONObject.put("ranking_message_bar_showed", SharedPreferencesHelper.getInstance().getBoolean("ranking_message_bar_showed", false));
            jSONObject.put("show-ad-block-toast", SharedPreferencesHelper.getInstance().getBoolean("show-ad-block-toast", false));
            jSONObject.put("showed_tips", SharedPreferencesHelper.getInstance().getString("showed_tips", ""));
            jSONObject.put("support_adjust_brightness", SharedPreferencesHelper.getInstance().getBoolean("support_adjust_brightness", true));
            jSONObject.put("support_proxy", SharedPreferencesHelper.getInstance().getBoolean("support_proxy", false));
            jSONObject.put("support-cookies-in-priv", SharedPreferencesHelper.getInstance().getBoolean("support-cookies-in-priv", true));
            jSONObject.put("status_bar_style_new", SharedPreferencesHelper.getInstance().getString("status_bar_style_new", "-1"));
            jSONObject.put("support-instant-tran", SharedPreferencesHelper.getInstance().getBoolean("support-instant-tran", false));
            jSONObject.put("support-quick-gesture", SharedPreferencesHelper.getInstance().getBoolean("support-quick-gesture", false));
            jSONObject.put("disable-back-forward-gesture", SharedPreferencesHelper.getInstance().getBoolean("disable-back-forward-gesture", false));
            jSONObject.put("block-pop-window", SharedPreferencesHelper.getInstance().getBoolean("block-pop-window", false));
            jSONObject.put("support-multi-win", SharedPreferencesHelper.getInstance().getBoolean("support-multi-win", true));
            jSONObject.put("support-touch-page-down", SharedPreferencesHelper.getInstance().getBoolean("support-touch-page-down", false));
            jSONObject.put("support-super-cache", SharedPreferencesHelper.getInstance().getBoolean("support-super-cache", false));
            jSONObject.put("auto-clean-web-cache", SharedPreferencesHelper.getInstance().getBoolean("auto-clean-web-cache", false));
            jSONObject.put("text_zoom", SharedPreferencesHelper.getInstance().getInt("text_zoom", 10));
            jSONObject.put("back-forward-gesture-trigger-type", SharedPreferencesHelper.getInstance().getInt("back-forward-gesture-trigger-type", 1));
            jSONObject.put("show-confirm-dlg-on-exit", SharedPreferencesHelper.getInstance().getBoolean("show-confirm-dlg-on-exit", false));
            for (int i = 0; i < SharedPreferencesHelper.f4840Y0.length; i++) {
                jSONObject.put(SharedPreferencesHelper.f4840Y0[i], SharedPreferencesHelper.getInstance().m6855G(SharedPreferencesHelper.f4840Y0[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override
    public String getKey() {
        return "sync_tag_setting";
    }

    @Override
    public void saveToLocal(String str) {
        loadFromRemote(str);
    }

    @Override
    public void incrementVersion() {
        super.incrementVersion();
    }

    @Override
    public void loadFromRemote(String str) {
        SharedPreferencesHelper.getInstance().f4849D = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            SharedPreferencesHelper.getInstance().putBoolean("accept_cookies", JsonUtils.getBoolean(jSONObject, "accept_cookies"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-third-cookies", JsonUtils.getBoolean(jSONObject, "disable-third-cookies"));
            SharedPreferencesHelper.getInstance().putBoolean("active-ad-block", JsonUtils.getBoolean(jSONObject, "active-ad-block"));
            SharedPreferencesHelper.getInstance().putBoolean("enable-tampermonkey", JsonUtils.getBoolean(jSONObject, "enable-tampermonkey", true));
            SharedPreferencesHelper.getInstance().putBoolean("support-volume-page-down", JsonUtils.getBoolean(jSONObject, "support-volume-page-down"));
            SharedPreferencesHelper.getInstance().putBoolean("auto-sniff-media", JsonUtils.getBoolean(jSONObject, "auto-sniff-media"));
            SharedPreferencesHelper.getInstance().putBoolean("deep-sniff-media", JsonUtils.getBoolean(jSONObject, "deep-sniff-media"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-read-mode", JsonUtils.getBoolean(jSONObject, "disable-read-mode"));
            SharedPreferencesHelper.getInstance().putBoolean("accept-eula", true);
            SharedPreferencesHelper.getInstance().putBoolean("unlock-to-view-his", JsonUtils.getBoolean(jSONObject, "unlock-to-view-his"));
            SharedPreferencesHelper.getInstance().putString("browser_theme", JsonUtils.getString(jSONObject, "browser_theme"));
            SharedPreferencesHelper.getInstance().putBoolean("clean_history_checked", JsonUtils.getBoolean(jSONObject, "clean_history_checked"));
            SharedPreferencesHelper.getInstance().putBoolean("ignore_security_warnings", JsonUtils.getBoolean(jSONObject, "ignore_security_warnings"));
            SharedPreferencesHelper.getInstance().putBoolean("dont-upload-user-exp-data", JsonUtils.getBoolean(jSONObject, "dont-upload-user-exp-data"));
            SharedPreferencesHelper.getInstance().putBoolean("enable_geolocation", JsonUtils.getBoolean(jSONObject, "enable_geolocation"));
            SharedPreferencesHelper.getInstance().putBoolean("clean_web_cookies_checked", JsonUtils.getBoolean(jSONObject, "clean_web_cookies_checked"));
            SharedPreferencesHelper.getInstance().putBoolean("clean_history_checked", JsonUtils.getBoolean(jSONObject, "clean_history_checked"));
            SharedPreferencesHelper.getInstance().putBoolean("clean_web_app_cache_checked", JsonUtils.getBoolean(jSONObject, "clean_web_app_cache_checked"));
            SharedPreferencesHelper.getInstance().putBoolean("force-user-scalable", JsonUtils.getBoolean(jSONObject, "force-user-scalable"));
            SharedPreferencesHelper.getInstance().putBoolean("auto-wrap-when-scaled", JsonUtils.getBoolean(jSONObject, "auto-wrap-when-scaled"));
            SharedPreferencesHelper.getInstance().putBoolean("clean-web-cache-on-exit", JsonUtils.getBoolean(jSONObject, "clean-web-cache-on-exit"));
            SharedPreferencesHelper.getInstance().putInt("default_layout_type", JsonUtils.getInt(jSONObject, "default_layout_type"));
            SharedPreferencesHelper.getInstance().putInt("ad_rule_update_circle", JsonUtils.getInt(jSONObject, "ad_rule_update_circle", 0));
            SharedPreferencesHelper.getInstance().putInt("recovery_tab_type", JsonUtils.getInt(jSONObject, "recovery_tab_type", 0));
            SharedPreferencesHelper.getInstance().putString("custom_search_urls", JsonUtils.getString(jSONObject, "custom_search_urls"));
            SharedPreferencesHelper.getInstance().putString("trans_engine_url", JsonUtils.getString(jSONObject, "trans_engine_url"));
            SharedPreferencesHelper.getInstance().putString("custom_ua", JsonUtils.getString(jSONObject, "custom_ua"));
            SharedPreferencesHelper.getInstance().putString("sync_resource_conf", JsonUtils.getString(jSONObject, "sync_resource_conf"));
            SharedPreferencesHelper.getInstance().putString("rule_file_info", JsonUtils.getString(jSONObject, "rule_file_info"));
            SharedPreferencesHelper.getInstance().putString("unlock-password", JsonUtils.getString(jSONObject, "unlock-password"));
            SharedPreferencesHelper.getInstance().putString("bm_order", JsonUtils.getString(jSONObject, "bm_order"));
            SharedPreferencesHelper.getInstance().putInt("default_brightness", JsonUtils.getInt(jSONObject, "default_brightness"));
            SharedPreferencesHelper.getInstance().putBoolean("support-switch-tab-gesture", JsonUtils.getBoolean(jSONObject, "support-switch-tab-gesture"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-pull-to-refresh-gesture", JsonUtils.getBoolean(jSONObject, "disable-pull-to-refresh-gesture"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-pull-to-search-gesture", JsonUtils.getBoolean(jSONObject, "disable-pull-to-search-gesture"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-search-bar-hotword", JsonUtils.getBoolean(jSONObject, "disable-search-bar-hotword"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-search-suggestion", JsonUtils.getBoolean(jSONObject, "disable-search-suggestion"));
            SharedPreferencesHelper.getInstance().putBoolean("do-not-show-browser-his", JsonUtils.getBoolean(jSONObject, "do-not-show-browser-his"));
            SharedPreferencesHelper.getInstance().putBoolean("do-not-show-clipboard-content", JsonUtils.getBoolean(jSONObject, "do-not-show-clipboard-content"));
            SharedPreferencesHelper.getInstance().putBoolean("do-not-show-search-his", JsonUtils.getBoolean(jSONObject, "do-not-show-search-his"));
            SharedPreferencesHelper.getInstance().putString("user_download_dir", JsonUtils.getString(jSONObject, "user_download_dir"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-javascript", JsonUtils.getBoolean(jSONObject, "disable-javascript"));
            SharedPreferencesHelper.getInstance().putBoolean("enable-smart-adb", JsonUtils.getBoolean(jSONObject, "enable-smart-adb"));
            SharedPreferencesHelper.getInstance().putBoolean("block-pop-window", JsonUtils.getBoolean(jSONObject, "block-pop-window"));
            SharedPreferencesHelper.getInstance().putBoolean("support-multi-win", JsonUtils.getBoolean(jSONObject, "support-multi-win"));
            SharedPreferencesHelper.getInstance().putBoolean("enter-night-mode", JsonUtils.getBoolean(jSONObject, "enter-night-mode"));
            SharedPreferencesHelper.getInstance().putBoolean("follow-sys-dark-mode", JsonUtils.getBoolean(jSONObject, "follow-sys-dark-mode"));
            SharedPreferencesHelper.getInstance().putBoolean("enter-private-mode", JsonUtils.getBoolean(jSONObject, "enter-private-mode"));
            SharedPreferencesHelper.getInstance().putBoolean("use-public-download-dir", JsonUtils.getBoolean(jSONObject, "use-public-download-dir"));
            SharedPreferencesHelper.getInstance().putBoolean("remind-when-down-complete", JsonUtils.getBoolean(jSONObject, "remind-when-down-complete"));
            SharedPreferencesHelper.getInstance().putBoolean("hide-add-qa-btn", JsonUtils.getBoolean(jSONObject, "hide-add-qa-btn"));
            SharedPreferencesHelper.getInstance().putBoolean("hide-start-page-logo", JsonUtils.getBoolean(jSONObject, "hide-start-page-logo"));
            SharedPreferencesHelper.getInstance().putBoolean("use-circular-style-qa-icon", JsonUtils.getBoolean(jSONObject, "use-circular-style-qa-icon"));
            SharedPreferencesHelper.getInstance().putBoolean("use-pure-color-icon", JsonUtils.getBoolean(jSONObject, "use-pure-color-icon"));
            SharedPreferencesHelper.getInstance().putBoolean("display-qa-in-single-screen", JsonUtils.getBoolean(jSONObject, "display-qa-in-single-screen"));
            SharedPreferencesHelper.getInstance().putBoolean("qa-fill-the-whole-screen", JsonUtils.getBoolean(jSONObject, "qa-fill-the-whole-screen"));
            SharedPreferencesHelper.getInstance().putBoolean("show-qa-icons", JsonUtils.getBoolean(jSONObject, "show-qa-icons", true));
            SharedPreferencesHelper.getInstance().putBoolean("enable_call_app", JsonUtils.getBoolean(jSONObject, "enable_call_app"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-write-clipboard", JsonUtils.getBoolean(jSONObject, "disable-write-clipboard"));
            SharedPreferencesHelper.getInstance().putBoolean("enable-dnt", JsonUtils.getBoolean(jSONObject, "enable-dnt"));
            SharedPreferencesHelper.getInstance().putBoolean("enable-remote-debug", JsonUtils.getBoolean(jSONObject, "enable-remote-debug"));
            SharedPreferencesHelper.getInstance().putString("home_page", JsonUtils.getString(jSONObject, "home_page"));
            SharedPreferencesHelper.getInstance().putString("search-bar-at-top.toolbar_layout", JsonUtils.getString(jSONObject, "search-bar-at-top.toolbar_layout"));
            SharedPreferencesHelper.getInstance().putString("search-bar-at-bottom.toolbar_layout", JsonUtils.getString(jSONObject, "search-bar-at-bottom.toolbar_layout"));
            String strM3665j = JsonUtils.getString(jSONObject, "user_search_url");
            SharedPreferencesHelper.getInstance().putString("user_search_url", strM3665j);
            if (!TextUtils.isEmpty(strM3665j)) {
                SharedPreferencesHelper.getInstance().searchUrl = null;
            }
            SharedPreferencesHelper.getInstance().putInt("home_icon_alpha", JsonUtils.getInt(jSONObject, "home_icon_alpha"));
            SharedPreferencesHelper.getInstance().putBoolean("keep-screen-on", JsonUtils.getBoolean(jSONObject, "keep-screen-on"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-fast-scrolling-slider", JsonUtils.getBoolean(jSONObject, "disable-fast-scrolling-slider"));
            SharedPreferencesHelper.getInstance().putBoolean("load_images", JsonUtils.getBoolean(jSONObject, "load_images"));
            SharedPreferencesHelper.getInstance().putBoolean("enable-immersive-mode", JsonUtils.getBoolean(jSONObject, "enable-immersive-mode"));
            SharedPreferencesHelper.getInstance().putBoolean("fullscreen-with-float-btn", JsonUtils.getBoolean(jSONObject, "fullscreen-with-float-btn"));
            SharedPreferencesHelper.getInstance().putInt("night_brightness", JsonUtils.getInt(jSONObject, "night_brightness"));
            SharedPreferencesHelper.getInstance().putBoolean("open-search-in-new-tab", JsonUtils.getBoolean(jSONObject, "open-search-in-new-tab"));
            SharedPreferencesHelper.getInstance().putBoolean("confirm-when-close-tabs", JsonUtils.getBoolean(jSONObject, "confirm-when-close-tabs"));
            SharedPreferencesHelper.getInstance().putBoolean("close-tab-in-order", JsonUtils.getBoolean(jSONObject, "close-tab-in-order"));
            SharedPreferencesHelper.getInstance().putBoolean("new-tab-at-bottom", JsonUtils.getBoolean(jSONObject, "new-tab-at-bottom"));
            SharedPreferencesHelper.getInstance().putBoolean("force-open-in-new-tab", JsonUtils.getBoolean(jSONObject, "force-open-in-new-tab"));
            SharedPreferencesHelper.getInstance().putBoolean("open-unclose-tab", JsonUtils.getBoolean(jSONObject, "open-unclose-tab"));
            SharedPreferencesHelper.getInstance().putBoolean("limit_xproxy_flow", JsonUtils.getBoolean(jSONObject, "limit_xproxy_flow"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-video-force-landscape", JsonUtils.getBoolean(jSONObject, "disable-video-force-landscape"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-gesture-in-video-fullscreen", JsonUtils.getBoolean(jSONObject, "disable-gesture-in-video-fullscreen"));
            SharedPreferencesHelper.getInstance().putBoolean("browser_fullscreen_mode", JsonUtils.getBoolean(jSONObject, "browser_fullscreen_mode"));
            SharedPreferencesHelper.getInstance().putBoolean("PLS_RANK_MESSAGE_SHOWED", JsonUtils.getBoolean(jSONObject, "PLS_RANK_MESSAGE_SHOWED"));
            SharedPreferencesHelper.getInstance().putBoolean("PLS_SHARE_MESSAGE_SHOWED", JsonUtils.getBoolean(jSONObject, "PLS_SHARE_MESSAGE_SHOWED"));
            SharedPreferencesHelper.getInstance().putBoolean("ranking_message_bar_showed", JsonUtils.getBoolean(jSONObject, "ranking_message_bar_showed"));
            SharedPreferencesHelper.getInstance().putBoolean("show-ad-block-toast", JsonUtils.getBoolean(jSONObject, "show-ad-block-toast"));
            SharedPreferencesHelper.getInstance().putString("showed_tips", JsonUtils.getString(jSONObject, "showed_tips"));
            SharedPreferencesHelper.getInstance().putBoolean("support_adjust_brightness", JsonUtils.getBoolean(jSONObject, "support_adjust_brightness"));
            SharedPreferencesHelper.getInstance().putBoolean("support_proxy", JsonUtils.getBoolean(jSONObject, "support_proxy"));
            SharedPreferencesHelper.getInstance().putBoolean("support-cookies-in-priv", JsonUtils.getBoolean(jSONObject, "support-cookies-in-priv"));
            SharedPreferencesHelper.getInstance().putString("status_bar_style_new", JsonUtils.getString(jSONObject, "status_bar_style_new"));
            SharedPreferencesHelper.getInstance().putBoolean("support-instant-tran", JsonUtils.getBoolean(jSONObject, "support-instant-tran"));
            SharedPreferencesHelper.getInstance().putBoolean("support-quick-gesture", JsonUtils.getBoolean(jSONObject, "support-quick-gesture"));
            SharedPreferencesHelper.getInstance().putBoolean("disable-back-forward-gesture", JsonUtils.getBoolean(jSONObject, "disable-back-forward-gesture"));
            SharedPreferencesHelper.getInstance().putBoolean("support-touch-page-down", JsonUtils.getBoolean(jSONObject, "support-touch-page-down"));
            SharedPreferencesHelper.getInstance().putBoolean("support-super-cache", JsonUtils.getBoolean(jSONObject, "support-super-cache"));
            SharedPreferencesHelper.getInstance().putBoolean("auto-clean-web-cache", JsonUtils.getBoolean(jSONObject, "auto-clean-web-cache"));
            SharedPreferencesHelper.getInstance().putInt("text_zoom", JsonUtils.getInt(jSONObject, "text_zoom"));
            SharedPreferencesHelper.getInstance().putInt("back-forward-gesture-trigger-type", JsonUtils.getInt(jSONObject, "back-forward-gesture-trigger-type"));
            SharedPreferencesHelper.getInstance().putBoolean("show-confirm-dlg-on-exit", JsonUtils.getBoolean(jSONObject, "show-confirm-dlg-on-exit"));
            int i = 0;
            while (true) {
                String[] strArr = SharedPreferencesHelper.f4840Y0;
                if (i >= strArr.length) {
                    SharedPreferencesHelper.getInstance().loadPreferences();
                    ThemeManager.getInstance().m9477E();
                    try {
                        BrowserActivity.getActivity().runOnUiThread(new a());
                        return;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        return;
                    }
                }
                SharedPreferencesHelper.getInstance().putString(SharedPreferencesHelper.f4840Y0[i], JsonUtils.getString(jSONObject, strArr[i]));
                i++;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
