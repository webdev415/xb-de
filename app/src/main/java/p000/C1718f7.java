package p000;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.ContentDataManager;
import com.mmbox.xbrowser.BrowserDownloadManager;
import com.mmbox.xbrowser.MenuConfigManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1718f7 implements InterfaceC1671e7 {

    public final BrowserActivity browserActivity;

    public C1718f7(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
    }

    public final String m7552a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", PhoneUtils.getInstance().getAppKey());
            jSONObject.put("signature", PhoneUtils.getInstance().getAppSignatureMd5());
            jSONObject.put("version_name", PhoneUtils.getInstance().getVersionName());
            jSONObject.put("version_code", PhoneUtils.getInstance().getVersionCode());
            jSONObject.put("channel_code", PhoneUtils.getInstance().getChannelCode());
            jSONObject.put("android_id", PhoneUtils.getInstance().getAndroidId());
            jSONObject.put("device_id", PhoneUtils.getInstance().getDeviceId());
            jSONObject.put("mobile_model", PhoneUtils.getInstance().getMobileModel());
            jSONObject.put("language_code", PhoneUtils.getInstance().getLanguageCode());
            jSONObject.put("country_code", PhoneUtils.getInstance().getCountryCode());
            jSONObject.put("mobile_imei", PhoneUtils.getInstance().getMobileImei());
            jSONObject.put("screen_size", getScreenSize());
            jSONObject.put("screen_density", getScreenDensity());
            jSONObject.put("os_build_tag", PhoneUtils.osBuildTag);
            jSONObject.put("os_name", PhoneUtils.osBuildTag.toLowerCase().substring(0, 7));
            jSONObject.put("phone_model", Build.MODEL);
            jSONObject.put("phone_os", Build.VERSION.RELEASE + " api level:" + Build.VERSION.SDK);
            jSONObject.put("package_name", this.browserActivity.getPackageName());
            jSONObject.put("system_app", PhoneUtils.getInstance().getSystemApp());
            jSONObject.put("launch_times", SharedPreferencesHelper.getInstance().appLaunchTimes);
            jSONObject.put("cache_dir", PhoneUtils.getInstance().getCacheDir());
            jSONObject.put("backup_user_data_dir", PhoneUtils.getInstance().getBackupDir());
            jSONObject.put("use_memory", AndroidSystemUtils.formatFileSize(AndroidSystemUtils.getMemoryUsed()));
            jSONObject.put("url_rules", ContentDataManager.getInstance().getUrlRules());
            jSONObject.put("element_rules", ContentDataManager.getInstance().getElementRules());
            jSONObject.put("regular_rules", ContentDataManager.getInstance().getRegularRules());
            jSONObject.put("exception_rules", ContentDataManager.getInstance().getExceptionRules());
            jSONObject.put("user_mark_rules", ContentDataManager.getInstance().getUserMarkRules());
            jSONObject.put("is_default_browser", AndroidSystemUtils.isDefaultBrowser(this.browserActivity));
            jSONObject.put("is_in_china", PhoneUtils.getInstance().isInChina());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override
    public String mo5091b(String str) throws Exception {
        int iIndexOf = str.indexOf(46);
        if (iIndexOf > 0) {
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            if (strSubstring.equals("setting_boolean")) {
                return String.valueOf(m7557h(strSubstring2));
            }
            if (strSubstring.equals("setting_string")) {
                return m7558i(strSubstring2);
            }
            throw new Exception("unknow data type");
        }
        if (str.equals("rule_file_list")) {
            ContentDataManager.getInstance().m6594U0();
            return ContentDataManager.getInstance().m6578M();
        }
        if (str.equals("toolbar_layout_setting")) {
            JSONObject jSONObject = new JSONObject();
            String strM6871P = SharedPreferencesHelper.getInstance().getString("search-bar-at-top.toolbar_layout", "layout_1");
            String strM6871P2 = SharedPreferencesHelper.getInstance().getString("search-bar-at-bottom.toolbar_layout", "layout_4");
            jSONObject.put("search-bar-at-top", strM6871P);
            jSONObject.put("search-bar-at-bottom", strM6871P2);
            return jSONObject.toString();
        }
        if (str.equals("toolbar_layout_data")) {
            return "{\"search-bar-at-top\":{\"layout_1\":[\"back\",\"forward\",\"menu\",\"tabs\",\"home\"],\"layout_2\":[\"back\",\"forward\",\"home\",\"tabs\",\"menu\"],\"layout_5\":[\"back\",\"forward\",\"menu\",\"tabs\",\"refresh\"]},\"search-bar-at-bottom\":{\"layout_3\":[\"back\",\"home\",\"tabs\",\"menu\"],\"layout_4\":[\"back\",\"forward\",\"tabs\",\"menu\"],\"layout_6\":[\"back\",\"refresh\",\"tabs\",\"menu\"]}}";
        }
        if (str.equals("toolbar_icon_data")) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("back", AndroidSystemUtils.m8672F(this.browserActivity, R.drawable.ic_arrow_left));
            jSONObject2.put("forward", AndroidSystemUtils.m8672F(this.browserActivity, R.drawable.ic_arrow_right));
            jSONObject2.put("menu", AndroidSystemUtils.m8672F(this.browserActivity, R.drawable.ic_menu));
            jSONObject2.put("tabs", AndroidSystemUtils.m8672F(this.browserActivity, R.drawable.ic_muti_window));
            jSONObject2.put("home", AndroidSystemUtils.m8672F(this.browserActivity, R.drawable.ic_home));
            jSONObject2.put("refresh", AndroidSystemUtils.m8672F(this.browserActivity, R.drawable.ic_refresh_small));
            return jSONObject2.toString();
        }
        if (!str.equals("main_menu") && !str.equals("tool_menu") && !str.equals("context_menu")) {
            if (str.equals("browser_info")) {
                return m7552a();
            }
            if (str.equals("user_scripts")) {
                return JSManager.getInstance().m8531e0();
            }
            if (str.equals("downloads")) {
                return BrowserDownloadManager.getInstance().m6704u();
            }
            if (str.equals("custom_ua_list")) {
                return m7554e();
            }
            if (str.equals("custom_search_list")) {
                return m7553d();
            }
            if (str.equals("user_info")) {
                return C2439uo.getInstance().getUser().getResourceValue();
            }
            throw new Exception("unknow data type:" + str);
        }
        return MenuConfigManager.getInstance().m7025g(str);
    }

    @Override
    public void mo5092c(String str, String str2) throws JSONException {
        int iIndexOf = str.indexOf(46);
        if (iIndexOf > 0) {
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            if (strSubstring.equals("setting_boolean")) {
                m7559j(strSubstring2, Boolean.parseBoolean(str2));
                return;
            } else if (strSubstring.equals("setting_string")) {
                m7560k(strSubstring2, str2);
                return;
            } else {
                strSubstring.equals("auto_fill");
                return;
            }
        }
        if (str.equals("main_menu") || str.equals("tool_menu") || str.equals("context_menu")) {
            MenuConfigManager.getInstance().m7040w(str, str2);
            return;
        }
        if (str.equals("rule_file_list")) {
            return;
        }
        if (str.equals("custom_ua_list")) {
            SharedPreferencesHelper.getInstance().putString("custom_ua", str2);
            SharedPreferencesHelper.getInstance().m6897h0();
        } else if (!str.equals("custom_search_list")) {
            return;
        } else {
            SharedPreferencesHelper.getInstance().putString("custom_search_urls", str2);
        }
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }

    public final String m7553d() {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("custom_search_urls", "[]");
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray = new JSONArray(strM6871P);
        } catch (Exception unused) {
        }
        return jSONArray.toString();
    }

    public final String m7554e() throws JSONException {
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

    public final String getScreenDensity() {
        return this.browserActivity.m6270V0() + "";
    }

    public final String getScreenSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.browserActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    public final boolean m7557h(String str) {
        if (str.equals("disable-javascript")) {
            return SharedPreferencesHelper.getInstance().disableJavascript;
        }
        if (str.equals("enable_call_app")) {
            return !SharedPreferencesHelper.getInstance().enableCallApp;
        }
        if (str.equals("accept_cookies")) {
            return !SharedPreferencesHelper.getInstance().acceptCookies;
        }
        if (str.equals("support-cookies-in-priv")) {
            return SharedPreferencesHelper.getInstance().supportCookiesInPrivate;
        }
        if (str.equals("enable-auto-fill")) {
            return SharedPreferencesHelper.getInstance().enableAutoFill;
        }
        if (str.equals("open-unclose-tab")) {
            return SharedPreferencesHelper.getInstance().getBoolean(str, true);
        }
        if (str.equals("support-switch-tab-gesture")) {
            return SharedPreferencesHelper.getInstance().supportSwitchTabGesture;
        }
        if (!str.equals("show-ad-block-toast") && !str.equals("follow-sys-dark-mode")) {
            if (str.equals("enable_geolocation")) {
                return SharedPreferencesHelper.getInstance().isEnableGeolocation();
            }
            if (!str.equals("use-public-download-dir") && !str.equals("ignore_security_warnings")) {
                return str.equals("dont-upload-user-exp-data") ? SharedPreferencesHelper.getInstance().dontUploadUserExpData : str.equals("auto-sniff-media") ? SharedPreferencesHelper.getInstance().getBoolean(str, SharedPreferencesHelper.getInstance().autoSniffMedia) : str.equals("auto-clean-web-cache") ? SharedPreferencesHelper.getInstance().getBoolean(str, SharedPreferencesHelper.getInstance().autoCleanWebCache) : str.equals("confirm-when-close-tabs") ? SharedPreferencesHelper.getInstance().getBoolean(str, true) : str.equals("enable-immersive-mode") ? SharedPreferencesHelper.getInstance().enableImmersiveMode : str.equals("disable-pull-to-refresh-gesture") ? SharedPreferencesHelper.getInstance().disablePullToRefreshGesture : str.equals("disable-pull-to-search-gesture") ? SharedPreferencesHelper.getInstance().disablePullToSearchGesture : str.equals("support-quick-gesture") ? SharedPreferencesHelper.getInstance().supportQuickGesture : str.equals("disable-gesture-in-video-fullscreen") ? SharedPreferencesHelper.getInstance().disableGestureInVideoFullscreen : str.equals("support-touch-page-down") ? SharedPreferencesHelper.getInstance().supportTouchPageDown : str.equals("support-volume-page-down") ? SharedPreferencesHelper.getInstance().supportVolumePageDown : str.equals("show-qa-icons") ? !SharedPreferencesHelper.getInstance().getBoolean(str, true) : str.equals("enable-remote-debug") ? SharedPreferencesHelper.getInstance().enableRemoteDebug : str.equals("fullscreen-with-float-btn") ? SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn : str.equals("display-qa-in-single-screen") ? SharedPreferencesHelper.getInstance().getBoolean(str, true) : str.equals("support-multi-win") ? SharedPreferencesHelper.getInstance().supportMultiWindow : str.equals("force-open-in-bg") ? SharedPreferencesHelper.getInstance().forceOpenInBackground : str.equals("force-open-in-new-tab") ? SharedPreferencesHelper.getInstance().forceOpenInNewTab : str.equals("disable-back-forward-gesture") ? SharedPreferencesHelper.getInstance().disableBackForwardGesture : str.equals("block-pop-window") ? SharedPreferencesHelper.getInstance().blockPopWindow : SharedPreferencesHelper.getInstance().getBoolean(str, false);
            }
            return SharedPreferencesHelper.getInstance().getBoolean(str, true);
        }
        return SharedPreferencesHelper.getInstance().getBoolean(str, true);
    }

    public final String m7558i(String str) {
        String strM6871P = SharedPreferencesHelper.getInstance().getString(str, "");
        return str.equals("home_page") ? (strM6871P.equals("x:home") || strM6871P.equals("file:///android_asset/start-page/index.html")) ? "" : strM6871P : SharedPreferencesHelper.getInstance().getString(str, "");
    }

    public final void m7559j(String str, boolean z) {
        if (str.equals("disable-write-clipboard")) {
            SharedPreferencesHelper.getInstance().disableWriteClipboard = z;
        } else if (str.equals("follow-sys-dark-mode")) {
            SharedPreferencesHelper.getInstance().followSystemDarkMode = z;
        } else if (str.equals("disable-search-suggestion")) {
            SharedPreferencesHelper.getInstance().disableSearchSuggestion = z;
        } else if (str.equals("dont-upload-user-exp-data")) {
            SharedPreferencesHelper.getInstance().dontUploadUserExpData = z;
        } else if (str.equals("remind-when-down-complete")) {
            SharedPreferencesHelper.getInstance().remindWhenDownloadComplete = z;
        } else if (str.equals("support-cookies-in-priv")) {
            SharedPreferencesHelper.getInstance().supportCookiesInPrivate = z;
        } else if (str.equals("enable-auto-fill")) {
            SharedPreferencesHelper.getInstance().enableAutoFill = z;
        } else if (str.equals("support-switch-tab-gesture")) {
            SharedPreferencesHelper.getInstance().supportSwitchTabGesture = z;
        } else if (str.equals("new-tab-at-bottom")) {
            SharedPreferencesHelper.getInstance().newTabAtBottom = z;
        } else if (str.equals("disable-pull-to-refresh-gesture")) {
            SharedPreferencesHelper.getInstance().disablePullToRefreshGesture = z;
        } else if (str.equals("support-quick-gesture")) {
            SharedPreferencesHelper.getInstance().supportQuickGesture = z;
        } else if (str.equals("disable-gesture-in-video-fullscreen")) {
            SharedPreferencesHelper.getInstance().disableGestureInVideoFullscreen = z;
        } else if (str.equals("support-touch-page-down")) {
            SharedPreferencesHelper.getInstance().supportTouchPageDown = z;
        } else if (str.equals("support-volume-page-down")) {
            SharedPreferencesHelper.getInstance().supportVolumePageDown = z;
        } else if (str.equals("disable-pull-to-search-gesture")) {
            SharedPreferencesHelper.getInstance().disablePullToSearchGesture = z;
        } else if (str.equals("disable-fast-scrolling-slider")) {
            SharedPreferencesHelper.getInstance().disableFastScrollingSlider = z;
        } else if (str.equals("enable_call_app")) {
            z = !z;
            SharedPreferencesHelper.getInstance().enableCallApp = z;
        } else if (str.equals("accept_cookies")) {
            z = !z;
            SharedPreferencesHelper.getInstance().acceptCookies = z;
        } else if (str.equals("disable-javascript")) {
            SharedPreferencesHelper.getInstance().disableJavascript = z;
        } else if (str.equals("force-open-in-new-tab")) {
            SharedPreferencesHelper.getInstance().forceOpenInNewTab = z;
        } else if (str.equals("fullscreen-with-float-btn")) {
            SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn = z;
            if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                C0848Sb c0848SbM4048n = C0848Sb.getInstance();
                if (z) {
                    c0848SbM4048n.restorePosition();
                } else {
                    c0848SbM4048n.hideFloatingButton();
                }
            }
        } else if (str.equals("clean-web-cache-on-exit")) {
            if (z) {
                new DialogC0465K4(this.browserActivity, false).show();
            }
            SharedPreferencesHelper.getInstance().cleanCacheOnExit = z;
        } else if (str.equals("disable-back-forward-gesture")) {
            SharedPreferencesHelper.getInstance().disableBackForwardGesture = z;
        } else if (str.equals("block-pop-window")) {
            SharedPreferencesHelper.getInstance().blockPopWindow = z;
        } else if (str.equals("support-multi-win")) {
            SharedPreferencesHelper.getInstance().supportMultiWindow = z;
            this.browserActivity.m6280X2();
        }
        SharedPreferencesHelper.getInstance().putBoolean(str, z);
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
        SharedPreferencesHelper.getInstance().initSettings();
    }

    public final void m7560k(String str, String str2) {
        if (str.equals("home_page")) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "file:///android_asset/start-page/index.html";
            }
            SharedPreferencesHelper.getInstance().m6861J0(str2);
        }
        SharedPreferencesHelper.getInstance().putString(str, str2);
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }
}
