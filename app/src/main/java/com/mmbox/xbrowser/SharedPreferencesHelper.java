package com.mmbox.xbrowser;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;

import com.xbrowser.play.R;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import p000.JsonUtils;
import p000.AbstractC1761g3;
import p000.AbstractC1807h2;
import p000.AndroidSystemUtils;
import p000.C1089Xm;
import p000.PhoneUtils;

public class SharedPreferencesHelper implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static String defaultUserAgent = "Mozilla/5.0 (Linux; Android 13; M2102J2SC Build/TKQ1.220829.002) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Mobile Safari/537.36";

    public static String[] f4840Y0 = {"long_press_back_btn", "long_press_forward_btn", "long_press_home", "long_press_multi_tab", "long_press_menu", "double_click_blank", "push_bottom_toolbar_up"};

    public static boolean initialized = false;

    public static SharedPreferencesHelper instance = null;

    public int defaultBrightness;

    public int nightBrightness;

    public int defaultLayoutType;

    public int homeIconStyle;

    public LinkedList<WeakReference<WebSettings>> webSettingsList;

    public SharedPreferences sharedPreferences;

    public ArrayList<UserAgent> uaList = null;

    public boolean acceptCookieNotSet = true;

    public float densityRatio = 1.0f;

    public final int f4900e = 1;

    public Context context = null;

    public boolean activeAdBlock = false;

    public boolean enableTampermonkey = true;

    public boolean f4910j = false;

    public boolean disableGestureInVideoFullscreen = false;

    public boolean browserFullscreenMode = false;

    public boolean fullscreenWithFloatBtn = false;

    public boolean enableSmartADB = false;

    public boolean blockPopWindow = false;

    public boolean supportInstantTranslate = false;

    public boolean active = true;

    public boolean showAdBlockToast = false;

    public boolean enterNightMode = false;

    public boolean followSystemDarkMode = true;

    public boolean enterDesktopMode = false;

    public boolean enterPrivateMode = false;

    public boolean f4936w = true;

    public boolean enableAutoFill = true;

    public boolean remindWhenDownloadComplete = false;

    public boolean openSearchInNewTab = false;

    public boolean forceOpenInBackground = false;

    public boolean forceOpenInNewTab = false;

    public boolean supportCookiesInPrivate = false;

    public boolean f4849D = false;

    public int appLaunchTimes = 0;

    public boolean normalExit = false;

    public boolean disableSearchBarHotword = false;

    public boolean hideSearchHistory = false;

    public boolean hideClipboardContent = false;

    public boolean hideBrowserHistory = false;

    public boolean hideBookmarks = false;

    public boolean supportTouchPageDown = false;

    public boolean supportVolumePageDown = false;

    public boolean enableLongPressBackOrForward = false;

    public boolean showExitConfirmDialog = true;

    public boolean f4873P = true;

    public boolean autoSniffMedia = false;

    public boolean forceUserScalable = false;

    public boolean autoWrapWhenScaled = false;

    public boolean disableReadMode = false;

    public boolean dontUploadUserExpData = false;

    public boolean acceptEula = false;

    public boolean showFraudAlert = false;

    public boolean returnToBrowser = true;

    public boolean enableImmersiveMode = true;

    public String f4895b0 = null;

    public String f4897c0 = null;

    public boolean f4899d0 = false;

    public boolean f4901e0 = false;

    public String f4903f0 = null;

    public String f4905g0 = null;

    public String f4907h0 = null;

    public String f4909i0 = null;

    public String configSearchUrl = null;

    public int f4913k0 = 50;

    public int f4915l0 = -1;

    public String defaultLangCode = null;

    public boolean supportSuperCache = false;

    public boolean autoCleanWebCache = true;

    public boolean disableJavascript = false;

    public boolean disableThirdCookies = false;

    public boolean acceptCookies = true;

    public boolean enableCallApp = true;

    public boolean disableFastScrollingSlider = false;

    public boolean disableWriteClipboard = false;

    public boolean enableDNT = false;

    public boolean supportMultiWindow = true;

    public boolean enableRemoteDebug = false;

    public int gestureMode = 3;

    public boolean disableBackForwardGesture = false;

    public boolean supportQuickGesture = true;

    public boolean supportSwitchTabGesture = true;

    public boolean disablePullToRefreshGesture = false;

    public boolean canVScroll = false;

    public boolean canHScroll = false;

    public boolean disablePullToSearchGesture = false;

    public boolean someFlag1 = false;

    public boolean f4858H0 = false;

    public boolean keepScreenOn = false;

    public boolean openUncloseTab = false;

    public boolean cleanCacheOnExit = true;

    public boolean newTabAtBottom = false;

    public boolean disableSearchSuggestion = false;

    public String searchUrl = null;

    public boolean f4872O0 = false;

    public String f4878R0 = "ua_default";

    public int goodForEyeColor = 0;

    public int adRuleUpdateCircle = 0;

    public int recoveryTabType = 0;

    public String homePage = "file:///android_asset/start-page/index.html";

    public final Runnable initPreferencesRunnable = new Runnable() {
        @Override
        public void run() {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            densityRatio = displayMetrics.scaledDensity / displayMetrics.density;
            sharedPreferences.registerOnSharedPreferenceChangeListener(SharedPreferencesHelper.this);
            if (Build.VERSION.CODENAME.equals("REL")) {
                setDebugMenuEnabled(false);
            }
            if (sharedPreferences.contains("text_size")) {
                int textSize;
                switch (getTextSize()) {
                    case SMALLEST:
                        textSize = 50;
                        break;
                    case SMALLER:
                        textSize = 75;
                        break;
                    case LARGER:
                        textSize = 150;
                        break;
                    case LARGEST:
                        textSize = 200;
                        break;
                    default:
                        textSize = 100; // no-op
                }

                if (textSize != 100) {
                    applyTextSize(textSize);
                }
                sharedPreferences.edit().remove("text_size").apply();
            }
            synchronized (SharedPreferencesHelper.class) {
                SharedPreferencesHelper.initialized = true;
                notifyAll();
            }
        }
    };

    public class UserAgent {
        public String id;

        public String title;

        public String ua;
    }

    public static SharedPreferencesHelper getInstance() {
        if (instance == null) {
            instance = new SharedPreferencesHelper();
        }
        return instance;
    }

    /**
     * Encodes a value using linear transform: x -> (x * 5) + 50
     */
    public static int encodeValue(int value) {
        return (value * 5) + 50;
    }

    /**
     * Decodes a value encoded by encodeValue()
     */
    public static int decodeValue(int encoded) {
        return (encoded / 5) - 10;
    }

    public static int adjustValue(int value) {
        return (value + 1 > 1) ? value + 4 : value + 1;
    }

    public static void waitUntilInitialized() {
        synchronized (SharedPreferencesHelper.class) {
            while (!initialized) {
                try {
                    SharedPreferencesHelper.class.wait();
                } catch (InterruptedException ignored) {
                    // Preserve interruption status for good practice
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final String getBackupSearchUrl() {
        return getString("backup_search_url2", "https://m.baidu.com/s?from=1023722p&word=%keywords%");
    }

    public void loadGoodForEyeColor() {
        goodForEyeColor = getInstance().getInt("good_for_eye_color", 0);
    }

    public int getDefaultLayoutType() {
        return defaultLayoutType;
    }

    public String replaceFromPrefs(String input, String keyOld, String keyNew) {
        return replaceFromPrefs(input, keyOld, keyNew, null);
    }

    public String m6847C() {
        return f4878R0;
    }

    public String replaceFromPrefs(String input, String keyOld, String keyNew, String resultKey) {
        String oldValue = getString(keyOld, null);
        String newValue = getString(keyNew, null);

        if (!TextUtils.isEmpty(oldValue)
                && !TextUtils.isEmpty(newValue)
                && input.contains(oldValue)) {

            input = input.replace(oldValue, newValue);

            if (!TextUtils.isEmpty(resultKey)) {
                putString(resultKey, input);
            }
        }

        return input;
    }

    public String m6849D() {
        return getUserAgentString(enterDesktopMode ? "ua_desktop" : f4878R0);
    }

    public final String ensureValidSearchUrl(String str) {
        String string;
        if (str.indexOf("baidu.com") > 0) {
            string = sharedPreferences.getString("s_baidu", null);
            if (TextUtils.isEmpty(string)) {
                return str;
            }
        } else if (str.indexOf("google.com") > 0) {
            string = sharedPreferences.getString("s_google", null);
            if (TextUtils.isEmpty(string)) {
                return str;
            }
        } else if (str.indexOf("m.so.com") > 0) {
            string = sharedPreferences.getString("s_qihu", null);
            if (TextUtils.isEmpty(string)) {
                return str;
            }
        } else if (str.indexOf("sogou.com") > 0) {
            string = sharedPreferences.getString("s_sogou_new", null);
            if (TextUtils.isEmpty(string)) {
                return str;
            }
        } else if (str.indexOf("sm.cn") > 0) {
            string = sharedPreferences.getString("s_sm", null);
            if (TextUtils.isEmpty(string) || str.indexOf("quark") >= 0) {
                return str;
            }
        } else if (str.indexOf("yahoo.com") > 0) {
            string = sharedPreferences.getString("s_yahoo", null);
            if (TextUtils.isEmpty(string)) {
                return str;
            }
        } else if (str.indexOf("bing.com") > 0) {
            string = sharedPreferences.getString("s_bing", null);
            if (TextUtils.isEmpty(string)) {
                return str;
            }
        } else if (str.indexOf("m.toutiao.com") > 0) {
            string = sharedPreferences.getString("s_tt", null);
            if (TextUtils.isEmpty(string)) {
                return str;
            }
        } else if (str.indexOf("so.douyin.com") > 0) {
            string = sharedPreferences.getString("s_douyin", null);
            if (TextUtils.isEmpty(string)) {
                return str;
            }
        } else {
            String string2 = sharedPreferences.getString("rewrite_key", "");
            if (TextUtils.isEmpty(string2) || str.indexOf(string2) <= 0) {
                return str;
            }
            string = sharedPreferences.getString("s_rewrite", "");
            if (TextUtils.isEmpty(string)) {
                return str;
            }
        }
        return string;
    }

    public final String getDefaultSearchUrl() {
        String strM6871P = getString("default_search_url", null);
        return strM6871P == null ? getDefaultSearchUrlForChannel() : strM6871P;
    }

    public boolean m6852E0() {
        return sharedPreferences.getBoolean("save_formdata", true);
    }

    public String m6853F() {
        return sharedPreferences.getString("default_text_encoding", "utf-8");
    }

    public void m6854F0(int i) {
        defaultLayoutType = i;
        sharedPreferences.edit().putInt("default_layout_type", i).apply();
    }

    public String m6855G(String str) {
        String string = sharedPreferences.getString(str, "not_set");
        if (!string.equals("not_set")) {
            return string;
        }
        if (str.equals("long_press_multi_tab")) {
            return "new_tab";
        }
        if (!str.equals("long_press_home")) {
            if (str.equals("long_press_menu")) {
                return "open_toolbox";
            }
            if (!str.equals("push_bottom_toolbar_up")) {
                return string;
            }
            if ((getInstance().defaultLayoutType & 4098) == 4098) {
                return "go_to_home";
            }
            if ((getInstance().defaultLayoutType & 4097) != 4097) {
                return string;
            }
        }
        return "search";
    }

    public void m6856G0(String str) {
        f4878R0 = str;
        putString("user_agent", str);
    }

    public String m6857H() {
        if (!TextUtils.isEmpty(homePage) && !homePage.startsWith("http") && !homePage.startsWith("file://") && !homePage.startsWith("x:")) {
            homePage = "http://" + homePage;
        }
        return homePage;
    }

    public void setDebugMenuEnabled(boolean enabled) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("debug_menu", enabled);

        // If disabling debug menu, also disable hardware acceleration flag
        if (!enabled) {
            editor.putBoolean("enable_hardware_accel_skia", false);
        }

        editor.apply();
    }

    public void m6859I0(String str, String str2) {
        putString(str, str2);
        enableLongPressBackOrForward = !isLongPressBackOrForwardBtnNotSet();
    }

    public WebSettings.LayoutAlgorithm m6860J() {
        WebSettings.LayoutAlgorithm layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL;
        return m6901j0() ? m6909n0() ? WebSettings.LayoutAlgorithm.SINGLE_COLUMN : m6905l0() ? layoutAlgorithm : WebSettings.LayoutAlgorithm.NARROW_COLUMNS : isAutofitPagesEnabled() ? WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING : layoutAlgorithm;
    }

    public void m6861J0(String str) {
        homePage = str;
    }

    public long m6862K(String str, long j) {
        ensurePreferencesLoaded();
        return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
    }

    public void m6863K0(String str) {
        sharedPreferences.edit().putString("screen_orientation", str).commit();
    }

    public int m6864L() {
        return adjustValue(sharedPreferences.getInt("min_font_size", 0));
    }

    public void applyTextSize(int i) {
        m6866M0(decodeValue(i));
    }

    public void m6866M0(int i) {
        SharedPreferences.Editor editorEdit;
        boolean z;
        sharedPreferences.edit().putInt("text_zoom", i).apply();
        if (i == 10) {
            editorEdit = sharedPreferences.edit();
            z = true;
        } else {
            editorEdit = sharedPreferences.edit();
            z = false;
        }
        editorEdit.putBoolean("autofit_pages", z).apply();
    }

    public WebSettings.PluginState m6867N() {
        return WebSettings.PluginState.valueOf(sharedPreferences.getString("plugin_state", "ON"));
    }

    public void m6868N0(WebView webView) {
        WebSettings settings = webView.getSettings();
        if (TextUtils.isEmpty(AbstractC1761g3.userAgentString)) {
            settings.setUserAgentString(null);
            AbstractC1761g3.userAgentString = settings.getUserAgentString();
        }
        String userAgentString = settings.getUserAgentString();
        if (!TextUtils.isEmpty(userAgentString) && userAgentString.equals(AbstractC1761g3.userAgentString)) {
            AbstractC1761g3.userAgent = userAgentString;
            String strReplace = userAgentString.replace("; wv", "");
            AbstractC1761g3.userAgent = strReplace;
            AbstractC1761g3.userAgent = strReplace.replace("Version/4.0 ", "");
        }
        if (acceptCookieNotSet) {
            m6879T0();
        }
        synchronized (webSettingsList) {
            m6881U0(settings);
            m6877S0(settings);
            webSettingsList.add(new WeakReference<>(settings));
        }
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, !disableThirdCookies);
    }

    /**
     * Retrieves an integer value from SharedPreferences,
     * falling back to PhoneUtils config if not present.
     *
     * @param key the preference key
     * @param defaultValue fallback value if not found
     * @return the stored or default integer value
     */
    public int getInt(String key, int defaultValue) {
        ensurePreferencesLoaded();

        if (sharedPreferences != null) {
            int value = sharedPreferences.getInt(key, -1);
            if (value != -1) {
                return value;
            }
        }

        // Fallback to PhoneUtils config
        return PhoneUtils.getInstance().getConfigInt(key, defaultValue);
    }

    /**
     * Removes a WebSettings instance from the tracked list.
     *
     * @param webSettings the WebSettings object to remove
     */
    public void removeWebSettings(WebSettings webSettings) {
        Iterator<WeakReference<WebSettings>> iterator = webSettingsList.iterator();

        while (iterator.hasNext()) {
            WeakReference<WebSettings> ref = iterator.next();
            if (ref.get() == webSettings) {
                iterator.remove();
                return; // exit after removing the first match
            }
        }
    }

    /**
     * Retrieves a string value from SharedPreferences,
     * falling back to PhoneUtils config if not present.
     *
     * @param key the preference key
     * @param defaultValue fallback value if not found
     * @return the stored or default string value
     */
    public String getString(String key, String defaultValue) {
        ensurePreferencesLoaded();

        if (sharedPreferences != null) {
            String value = sharedPreferences.getString(key, null);
            if (value != null) {
                return value;
            }
        }

        // Fallback to PhoneUtils config
        return PhoneUtils.getInstance().getString(key, defaultValue);
    }

    /**
     * Enables or disables the instant translate feature.
     *
     * @param enabled true to enable, false to disable
     */
    public void setSupportInstantTranslate(boolean enabled) {
        supportInstantTranslate = enabled;
        putBoolean("support-instant-tran", enabled);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        ensurePreferencesLoaded();

        if (sharedPreferences != null) {
            boolean value = sharedPreferences.getBoolean(key, defaultValue);
            if (value != defaultValue || sharedPreferences.getBoolean(key + ".change", false)) {
                return value;
            }
        }
        return PhoneUtils.getInstance().getBoolean(key, defaultValue);
    }

    public void loadPreferences() {
        PhoneUtils.getInstance().initialize(context, "xbrowser");
        activeAdBlock = sharedPreferences.getBoolean("active-ad-block", false);
        enableTampermonkey = sharedPreferences.getBoolean("enable-tampermonkey", true);
        enableSmartADB = sharedPreferences.getBoolean("enable-smart-adb", false);
        blockPopWindow = sharedPreferences.getBoolean("block-pop-window", false);
        supportInstantTranslate = sharedPreferences.getBoolean("support-instant-tran", false);
        showAdBlockToast = sharedPreferences.getBoolean("show-ad-block-toast", true);
        enterNightMode = sharedPreferences.getBoolean("enter-night-mode", false);
        followSystemDarkMode = sharedPreferences.getBoolean("follow-sys-dark-mode", true);
        enterDesktopMode = sharedPreferences.getBoolean("enter-desktop-mode", false);
        openUncloseTab = sharedPreferences.getBoolean("open-unclose-tab", true);

        goodForEyeColor = sharedPreferences.getInt("good_for_eye_color", 0);
        adRuleUpdateCircle = sharedPreferences.getInt("ad_rule_update_circle", 0);
        recoveryTabType = sharedPreferences.getInt("recovery_tab_type", -1);
        if (recoveryTabType == -1) {
            recoveryTabType = openUncloseTab ? 0 : 2;
        }
        appLaunchTimes = sharedPreferences.getInt("app_launch_times", 1);

        normalExit = sharedPreferences.getBoolean("normal_exit", false);
        enterPrivateMode = sharedPreferences.getBoolean("enter-private-mode", false);
        remindWhenDownloadComplete = sharedPreferences.getBoolean("remind-when-down-complete", false);
        enableAutoFill = sharedPreferences.getBoolean("enable-auto-fill", true);
        openSearchInNewTab = sharedPreferences.getBoolean("open-search-in-new-tab", false);
        forceOpenInBackground = sharedPreferences.getBoolean("force-open-in-bg", false);
        forceOpenInNewTab = sharedPreferences.getBoolean("force-open-in-new-tab", false);
        supportCookiesInPrivate = sharedPreferences.getBoolean("support-cookies-in-priv", true);
        supportSuperCache = sharedPreferences.getBoolean("support-super-cache", supportSuperCache);
        autoCleanWebCache = sharedPreferences.getBoolean("auto-clean-web-cache", autoCleanWebCache);
        defaultBrightness = sharedPreferences.getInt("default_brightness", -1);
        nightBrightness = sharedPreferences.getInt("night_brightness", -1);
        supportMultiWindow = sharedPreferences.getBoolean("support-multi-win", true);
        supportQuickGesture = sharedPreferences.getBoolean("support-quick-gesture", false);
        disableBackForwardGesture = sharedPreferences.getBoolean("disable-back-forward-gesture", false);
        supportSwitchTabGesture = sharedPreferences.getBoolean("support-switch-tab-gesture", true);
        disablePullToRefreshGesture = sharedPreferences.getBoolean("disable-pull-to-refresh-gesture", false);
        disablePullToSearchGesture = sharedPreferences.getBoolean("disable-pull-to-search-gesture", false);
        keepScreenOn = sharedPreferences.getBoolean("keep-screen-on", false);
        cleanCacheOnExit = sharedPreferences.getBoolean("clean-web-cache-on-exit", false);
        newTabAtBottom = sharedPreferences.getBoolean("new-tab-at-bottom", false);
        disableSearchBarHotword = sharedPreferences.getBoolean("disable-search-bar-hotword", true);
        hideSearchHistory = sharedPreferences.getBoolean("do-not-show-search-his", false);
        hideBrowserHistory = sharedPreferences.getBoolean("do-not-show-browser-his", false);
        hideBookmarks = sharedPreferences.getBoolean("do-not-show-browser-bookmarks", false);
        hideClipboardContent = sharedPreferences.getBoolean("do-not-show-clipboard-content", false);
        disableSearchSuggestion = sharedPreferences.getBoolean("disable-search-suggestion", false);
        enableLongPressBackOrForward = !isLongPressBackOrForwardBtnNotSet();
        supportTouchPageDown = sharedPreferences.getBoolean("support-touch-page-down", false);
        supportVolumePageDown = sharedPreferences.getBoolean("support-volume-page-down", false);
        showExitConfirmDialog = sharedPreferences.getBoolean("show-confirm-dlg-on-exit", false);
        if (f4849D) {
            defaultLayoutType = getInt("default_layout_type", 4097);
            putInt("default_layout_type", defaultLayoutType);
            putString("home_page", "file:///android_asset/start-page/index.html");
        } else {
            defaultLayoutType = getInt("default_layout_type", 4097);
        }
        homeIconStyle = getInt("home_icon_style", 0);
        enableImmersiveMode = getBoolean("enable-immersive-mode", true);
        returnToBrowser = getBoolean("return_to_browser", true);
        autoSniffMedia = getBoolean("auto-sniff-media", autoSniffMedia);
        forceUserScalable = getBoolean("force-user-scalable", false);
        autoWrapWhenScaled = getBoolean("auto-wrap-when-scaled", false);
        disableReadMode = getBoolean("disable-read-mode", false);
        dontUploadUserExpData = getBoolean("dont-upload-user-exp-data", false);
        acceptEula = getBoolean("accept-eula", acceptEula);
        showFraudAlert = getBoolean("show_fraud_alert", true);
        disableJavascript = sharedPreferences.getBoolean("disable-javascript", false);
        enableCallApp = getBoolean("enable_call_app", true);
        disableFastScrollingSlider = getBoolean("disable-fast-scrolling-slider", false);
        disableWriteClipboard = getBoolean("disable-write-clipboard", false);
        enableDNT = getBoolean("enable-dnt", false);
        enableRemoteDebug = getBoolean("enable-remote-debug", false);
        disableThirdCookies = getBoolean("disable-third-cookies", false);
        defaultLangCode = getString("default_lang_code", null);
        homePage = getString("home_page", "file:///android_asset/start-page/index.html");
        disableGestureInVideoFullscreen = getBoolean("disable-gesture-in-video-fullscreen", false);
        browserFullscreenMode = getBoolean("browser_fullscreen_mode", false);
        fullscreenWithFloatBtn = getBoolean("fullscreen-with-float-btn", false);
        if (enableRemoteDebug) {
            WebView.setWebContentsDebuggingEnabled(enableRemoteDebug);
        }
    }

    public SharedPreferences m6875R() {
        return sharedPreferences;
    }

    public void m6876R0() {
        f4895b0 = sharedPreferences.getString("default_baidu_feecode", "1023722p");
        f4897c0 = sharedPreferences.getString("baidu_fake_feecode", "1023722p");
        f4905g0 = sharedPreferences.getString("qihu_feecode", "xbrowser_1");
        f4903f0 = sharedPreferences.getString("sogou_feecode", "sogou-mobb-f30402d250ee0d24");
        f4907h0 = sharedPreferences.getString("dftt_feecode", "xbrowser");
        f4909i0 = sharedPreferences.getString("sm_feecode", "wm725516");
        f4910j = sharedPreferences.getBoolean("ad_test", false);
        configSearchUrl = sharedPreferences.getString("google_enhanced_search_url", "https://www.google.com/search?q=%keywords%&c=xbrowser");
    }

    public final void m6877S0(WebSettings webSettings) {
        webSettings.setGeolocationEnabled(m6916r());
        webSettings.setJavaScriptEnabled(!disableJavascript);
        webSettings.setLightTouchEnabled(m6920t());
        webSettings.setDefaultTextEncodingName(m6853F());
        webSettings.setMinimumFontSize(m6864L());
        webSettings.setMinimumLogicalFontSize(m6864L());
        webSettings.setPluginState(m6867N());
        webSettings.setTextZoom(m6885Y());
        webSettings.setLayoutAlgorithm(m6860J());
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(m6911o0());
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setUseWideViewPort(true);
        int i = Build.VERSION.SDK_INT;
        webSettings.setMixedContentMode(0);
        int iM5618z = PhoneUtils.getInstance().getConfigInt("cache_mode", -1);
        if (iM5618z >= 0) {
            webSettings.setCacheMode(iM5618z);
        }
        webSettings.setAllowFileAccess(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        if (i >= 33 && enterNightMode) {
            webSettings.setAlgorithmicDarkeningAllowed(true);
        }
        if (i >= 29) {
            if (enterNightMode) {
                webSettings.setForceDark(2);
            } else {
                webSettings.setForceDark(0);
            }
        }
        f4878R0 = sharedPreferences.getString("user_agent", "ua_default");
        if (enterDesktopMode) {
            webSettings.setUserAgentString(getUserAgentString("ua_desktop"));
        } else {
            try {
                webSettings.setUserAgentString(m6849D());
            } catch (Exception unused) {
                m6856G0("ua_default");
            }
        }
        if (enterPrivateMode) {
            m6924v(webSettings);
        } else {
            m6925v0(webSettings);
        }
    }

    public String m6878T() {
        return "downloads";
    }

    public final void m6879T0() {
        acceptCookieNotSet = false;
        CookieManager.getInstance().setAcceptCookie(isAcceptCookies());
    }

    public String m6880U() {
        return sharedPreferences.getString("screen_orientation", PhoneUtils.getInstance().getString("screen_orientation", "portrait"));
    }

    public final void m6881U0(WebSettings webSettings) {
        webSettings.setDefaultFontSize(16);
        webSettings.setDefaultFixedFontSize(13);
        webSettings.setNeedInitialFocus(false);
        webSettings.setSupportMultipleWindows(supportMultiWindow);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        webSettings.setSaveFormData(m6852E0());
        webSettings.setSavePassword(m6926w0());
        webSettings.setEnableSmoothTransition(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        webSettings.setCacheMode(-1);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabasePath(context.getDir("databases", 0).getPath());
        webSettings.setGeolocationDatabasePath(context.getDir("geolocation", 0).getPath());
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setMixedContentMode(2);
    }

    public String getSearchUrl() {
        // Return cached result if already computed
        if (this.searchUrl != null) {
            return this.searchUrl;
        }

        String userSearchUrl = getCustomSearchUrl();
        String defaultUrl = getDefaultSearchUrl();
        String assignKey = "assign_search_url";
        String assignedUrl = getString(assignKey, null);

        // Resolve initial URL candidate
        if (TextUtils.isEmpty(userSearchUrl)) {
            if (!TextUtils.isEmpty(assignedUrl)) {
                if (PhoneUtils.getInstance().isInChina()
                        && !PhoneUtils.getInstance().getChannelCode().equals("coolapk")) {
                    assignedUrl = defaultUrl;
                }
            } else {
                if (PhoneUtils.getInstance().isInChina()
                        && PhoneUtils.getInstance().getChannelCode().equals("coolapk")) {
                    assignedUrl = defaultUrl;
                } else {
                    assignedUrl = getFallbackSearchUrl(defaultUrl);
                }
            }
        } else {
            if (containsSpecialCode(userSearchUrl)) {
                defaultUrl = getBackupSearchUrl();
            } else {
                defaultUrl = userSearchUrl;
            }
        }

        String url = assignedUrl != null ? assignedUrl : defaultUrl;

        // Rewrite stored URL if rewrite rules exist
        try {
            if (url.contains("baidu.com")) {
                String rewrite = this.sharedPreferences.getString("rewrite_baidu", null);
                if (!TextUtils.isEmpty(rewrite)) {
                    putString(assignKey, rewrite);
                    url = rewrite;
                }
            } else if (url.contains("sogou.com")) {
                String rewrite = this.sharedPreferences.getString("rewrite_sogou", null);
                if (!TextUtils.isEmpty(rewrite)) {
                    putString(assignKey, rewrite);
                    url = rewrite;
                }
            } else if (url.contains("m.so.com")) {
                String rewrite = this.sharedPreferences.getString("rewrite_360", null);
                if (!TextUtils.isEmpty(rewrite)) {
                    putString(assignKey, rewrite);
                    url = rewrite;
                }
            } else if (url.contains("sm.cn")) {
                String rewrite = this.sharedPreferences.getString("rewrite_sm", null);
                if (!TextUtils.isEmpty(rewrite)) {
                    putString(assignKey, rewrite);
                    url = rewrite;
                }
            }
        } catch (Exception ignored) {
        }

        // Patch feecode replacements based on search engine
        if (url.contains("baidu.com")) {
            url = replaceFromPrefs(url, "baidu_old_feecode", "baidu_new_feecode", assignKey);
            url = replaceFromPrefs(url, "baidu_old_feecode1", "baidu_new_feecode1", assignKey);
            url = replaceFromPrefs(url, "baidu_old_feecode2", "baidu_new_feecode2", assignKey);
        } else if (url.contains("sogou.com")) {
            url = replaceFromPrefs(url, "sogou_old_feecode", "sogou_new_feecode", assignKey);
            url = replaceFromPrefs(url, "sogou_old_feecode1", "sogou_new_feecode1", assignKey);
            url = replaceFromPrefs(url, "sogou_old_feecode2", "sogou_new_feecode2", assignKey);
        } else if (url.contains("sm.cn")) {
            url = replaceFromPrefs(url, "sm_old_feecode", "sm_new_feecode", assignKey);
            url = replaceFromPrefs(url, "sm_old_feecode1", "sm_new_feecode1", assignKey);
            url = replaceFromPrefs(url, "sm_old_feecode2", "sm_new_feecode2", assignKey);
        } else if (!url.contains("m.so.com")) {
            url = replaceFromPrefs(url, "old_feecode", "new_feecode", assignKey);
        }

        // Failsafe domain check
        if (containsSpecialCode(url)) {
            url = getBackupSearchUrl();
        }

        // Final normalization
        String finalUrl = ensureValidSearchUrl(url);
        if (TextUtils.isEmpty(finalUrl)) {
            finalUrl = getDefaultSearchUrl();
        }

        this.searchUrl = finalUrl;
        return finalUrl;
    }

    public String getDefaultSearchUrlForChannel() {
        String searchUrl;
        String defaultUrl = getString("default.search", "https://m.baidu.com/s?from=1023722s&word=%keywords%");
        if (PhoneUtils.getInstance().isInChina()) {
            String channel = PhoneUtils.getInstance().getChannelCode();
            String searchKey = null;
            if (channel.equals("yyb")) {
                searchKey = "yyb.search";
            } else if (channel.equals("official")) {
                searchKey = "official.search";
            } else if (channel.equals("google_play_std")) {
                searchKey = "google_play_std.search";
            } else if (channel.equals("mi")) {
                searchKey = "mi.search";
            } else if (channel.equals("huawei")) {
                searchKey = "huawei.search";
            } else if (channel.equals("coolapk")) {
                searchKey = "coolapk.search";
            } else if (channel.equals("vivo")) {
                searchKey = "vivo.search";
            } else if (channel.equals("baidu")) {
                searchKey = "baidu.search";
            } else if (channel.equals("meizu")) {
                searchKey = "meizu.search";
            } else if (channel.equals("x5")) {
                searchKey = "x5.search";
            } else if (channel.equals("xbrowser_for_gp")) {
                searchKey = "xbrowser_for_gp.search";
            }
            searchUrl = getString(searchKey, defaultUrl);
        } else {
            defaultUrl = getString("default.search", "https://www.google.com/search?q=%keywords%");
            PhoneUtils.getInstance().isInIndia();
            searchUrl = getString("config.search", configSearchUrl);
        }
        return !TextUtils.isEmpty(searchUrl) ? searchUrl : defaultUrl;
    }

    public WebSettings.TextSize getTextSize() {
        String textSizeValue = sharedPreferences.getString("text_size", "NORMAL");
        return WebSettings.TextSize.valueOf(textSizeValue);
    }

    public int m6885Y() {
        waitUntilInitialized();
        return m6927x(m6891d0());
    }

    /**
     * Returns the User-Agent string for the given UserAgent ID.
     * If not found or invalid, returns a default value.
     *
     * @param userAgentId the ID of the UserAgent
     * @return sanitized User-Agent string
     */
    public String getUserAgentString(String userAgentId) {
        UserAgent userAgent = getUserAgentById(userAgentId);

        if (userAgent == null) {
            return defaultUserAgent; // fallback default
        }

        String uaValue = userAgent.ua;

        if (uaValue == null || uaValue.equals(defaultUserAgent) || "ua_default".equals(userAgent.id)) {
            userAgent.ua = (AbstractC1761g3.userAgent != null) ? AbstractC1761g3.userAgent : defaultUserAgent;
        }

        return userAgent.ua.replace("\n", "");
    }

    public final boolean isAcceptCookies() {
        acceptCookies = sharedPreferences.getBoolean("accept_cookies", true);
        return acceptCookies;
    }

    /**
     * Finds a UserAgent by its ID from the list.
     *
     * @param id the UserAgent ID to search for
     * @return the matching UserAgent, or null if not found
     */
    public UserAgent getUserAgentById(String id) {
        for (UserAgent ua : uaList) {
            if (ua.id.equals(id)) {
                return ua;
            }
        }
        return null;
    }

    /**
     * Returns the list of all UserAgents.
     *
     * @return the UserAgent list
     */
    public ArrayList<UserAgent> getUserAgentList() {
        return uaList;
    }

    public final String getCustomSearchUrl() {
        String str;
        getString("default.search", "https://m.baidu.com/s?from=1023722s&word=%keywords%");
        String strM6871P = getString("user_search_url", null);
        if (TextUtils.isEmpty(strM6871P)) {
            return strM6871P;
        }
        if (strM6871P.indexOf("wap.sogou.com") > 0 && strM6871P.indexOf("bid=") > 0) {
            return getString("search.baidu", "https://m.baidu.com/s?from=1023722s&word=%keywords%");
        }
        if (strM6871P.indexOf("baidu.com") > 0) {
            return m6907m0(strM6871P) ? getString("search.baidu", strM6871P) : strM6871P;
        }
        if (strM6871P.indexOf("yahoo.com") > 0) {
            str = "search.yahoo";
        } else if (strM6871P.indexOf("google.com") > 0) {
            str = "search.google";
        } else if (strM6871P.indexOf("toutiao.com") > 0) {
            str = "search.tt";
        } else if (strM6871P.indexOf("sm.cn") > 0 && strM6871P.indexOf("quark") < 0) {
            str = "search.sm";
        } else if (strM6871P.indexOf("so.douyin.com") > 0) {
            str = "search.douyin";
        } else {
            if (strM6871P.indexOf("m.so.com") < 0) {
                return strM6871P;
            }
            str = "search.360";
        }
        return getString(str, strM6871P);
    }

    public int m6891d0() {
        return sharedPreferences.getInt("text_zoom", 10);
    }

    public boolean m6892e0() {
        return getBoolean("ignore_security_warnings", true);
    }

    public boolean m6893f0() {
        return (enterNightMode || goodForEyeColor == 0) ? false : true;
    }

    public void m6894g() {
        acceptCookies = true;
        CookieManager.getInstance().setAcceptCookie(true);
        sharedPreferences.edit().putBoolean("accept_cookies", true).apply();
    }

    public void m6895g0(Context context) throws JSONException {
        this.context = context;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences = defaultSharedPreferences;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        m6897h0();
        webSettingsList = new LinkedList();
        AbstractC1807h2.m7778a(initPreferencesRunnable);
        loadPreferences();
        m6876R0();
    }

    public final String getFallbackSearchUrl(String str) {
        int iRandom = (int) (Math.random() * 15.0d);
        try {
            int i = Integer.parseInt(sharedPreferences.getString("p1", "10"));
            int i2 = Integer.parseInt(sharedPreferences.getString("p2", "5"));
            int i3 = Integer.parseInt(sharedPreferences.getString("p3", "0"));
            String string = sharedPreferences.getString("s_url1", null);
            String string2 = sharedPreferences.getString("s_url2", null);
            String string3 = sharedPreferences.getString("s_url3", null);
            if (iRandom < i) {
                string = (iRandom < i2 || iRandom >= i) ? (iRandom < i3 || iRandom >= i2) ? str : string3 : string2;
            }
            if (!TextUtils.isEmpty(string)) {
                str = string;
            }
        } catch (Exception unused) {
            TextUtils.isEmpty(str);
        } catch (Throwable th) {
            if (!TextUtils.isEmpty(null)) {
                str = null;
            }
            putString("assign_search_url", str);
            throw th;
        }
        putString("assign_search_url", str);
        return str;
    }

    public void m6897h0() throws JSONException {
        uaList = new ArrayList<>(5);

        UserAgent usDefault = new UserAgent();
        usDefault.id = "ua_default";
        usDefault.title = context.getString(R.string.ua_android);
        usDefault.ua = null;
        uaList.add(usDefault);

        UserAgent usIPhone = new UserAgent();
        usIPhone.id = "ua_iphone";
        usIPhone.title = context.getString(R.string.ua_iphone);
        usIPhone.ua = "Mozilla/5.0 (iPhone; CPU iPhone OS 15_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.1 Mobile/15E148 Safari/604.1";
        uaList.add(usIPhone);

        UserAgent uaIPad = new UserAgent();
        uaIPad.id = "ua_ipad";
        uaIPad.title = context.getString(R.string.ua_ipad);
        uaIPad.ua = "Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B367 Safari/531.21.10";
        uaList.add(uaIPad);

        UserAgent uaDesktop = new UserAgent();
        uaDesktop.id = "ua_desktop";
        uaDesktop.title = context.getString(R.string.ua_desktop);
        uaDesktop.ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36";
        uaList.add(uaDesktop);

        UserAgent uaWap = new UserAgent();
        uaWap.id = "ua_wap";
        uaWap.title = context.getString(R.string.ua_wap);
        uaWap.ua = "Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18124";
        uaList.add(uaWap);

        try {
            JSONArray jSONArray = new JSONArray(sharedPreferences.getString("custom_ua", ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                UserAgent ua = new UserAgent();
                ua.title = jSONObject.getString("title");
                String uaString = jSONObject.getString("ua_string");
                ua.ua = uaString;
                ua.id = JsonUtils.getString(jSONObject, "id", AndroidSystemUtils.prefixWithMd5(uaString));
                uaList.add(ua);
            }
        } catch (Exception unused) {
        }
    }

    public boolean isAutofitPagesEnabled() {
        return sharedPreferences.getBoolean("autofit_pages", true);
    }

    public boolean containsSpecialCode(String str) {
        Set<String> SPECIAL_CODES = new HashSet<>(Arrays.asList(
                "1013843e", "1013843i", "1013843a", "1013843f", "1013843c",
                "1013843d", "1013843q", "1013843j", "1013843n", "1013843o",
                "1013843m", "1022844r", "1022246c", "1013843l", "1023547b",
                "1013843h", "1013843k", "1013843t", "1023722h", "1015011k",
                "1015011h", "1022282s", "1023722g", "1023722m", "1023722e",
                "1023722i", "1023722f"
        ));

        if (str == null) return false;
        for (String code : SPECIAL_CODES) {
            if (str.contains(code)) {
                return true;
            }
        }
        return false;
    }

    public void m6900j() {
        m6908n(new File(PhoneUtils.getInstance().getCacheDirPath()), 0);
        m6908n(context.getFilesDir(), 0);
    }

    public boolean m6901j0() {
        waitUntilInitialized();
        return sharedPreferences.getBoolean("debug_menu", false);
    }

    public void m6902k() {
        WebViewDatabase.getInstance(context).clearFormData();
        WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
        WebViewDatabase.getInstance(context).clearUsernamePassword();
    }

    public final boolean isLongPressBackOrForwardBtnNotSet() {
        String backButtonSetting = sharedPreferences.getString("long_press_back_btn", "not_set");
        String forwardButtonSetting = sharedPreferences.getString("long_press_forward_btn", "not_set");

        return (backButtonSetting.equals("none") || backButtonSetting.equals("not_set"))
                && (forwardButtonSetting.equals("none") || forwardButtonSetting.equals("not_set"));
    }

    public void m6904l() {
        goodForEyeColor = 0;
    }

    public boolean m6905l0() {
        if (m6901j0()) {
            return sharedPreferences.getBoolean("normal_layout", false);
        }
        return false;
    }

    public void m6906m(boolean z) {
        WebView webView = new WebView(context);
        webView.clearCache(true);
        webView.destroy();
        m6908n(context.getCacheDir(), 0);
        if (z) {
            m6908n(context.getDir("webview", 0), 0);
        }
    }

    public final boolean m6907m0(String str) {
        return str.indexOf("1013843") > 0 || str.indexOf("1023722") > 0;
    }

    public final int m6908n(File file, int i) {
        int i2 = 0;
        boolean zM6873Q = getInstance().getBoolean("clean_storage_checked", false);
        boolean zM6873Q2 = getInstance().getBoolean("clean_web_data_checked", false);
        if (file == null || !file.isDirectory()) {
            return 0;
        }
        try {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            int iM6908n = 0;
            while (i2 < length) {
                try {
                    File file2 = fileArrListFiles[i2];
                    if (file2.getName().indexOf("Cookies") < 0 && file2.getName().indexOf("Session Storage") < 0 && ((file2.getName().toLowerCase().indexOf("storage") < 0 || zM6873Q) && ((file2.getName().toLowerCase().indexOf("webview_data") < 0 || zM6873Q2) && file2.getName().toLowerCase().indexOf("menu") < 0 && file2.getName().toLowerCase().indexOf("auto_fill") < 0 && file2.getName().toLowerCase().indexOf("sync_able") < 0))) {
                        if (file2.isDirectory()) {
                            try {
                                iM6908n += m6908n(file2, i);
                            } catch (Exception e) {
                                e = e;
                                i2 = iM6908n;
                                Log.e("settings", String.format("Failed to clean the cache, error %s", e.getMessage()));
                                return i2;
                            }
                        }
                        if (file2.lastModified() < new Date().getTime() - (i * 86400000) && file2.delete()) {
                            iM6908n++;
                        }
                    }
                    i2++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return iM6908n;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public boolean m6909n0() {
        if (m6901j0()) {
            return sharedPreferences.getBoolean("small_screen", false);
        }
        return false;
    }

    public void m6910o() {
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().removeSessionCookies(null);
    }

    public boolean m6911o0() {
        return sharedPreferences.getBoolean("load_images", true);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
    }

    public void m6912p() {
        int i = appLaunchTimes + 1;
        appLaunchTimes = i;
        putInt("app_launch_times", i);
    }

    /**
     * Saves a boolean value to SharedPreferences.
     *
     * @param key the preference key
     * @param value the boolean value to store
     */
    public void putBoolean(String key, boolean value) {
        ensurePreferencesLoaded();
        if (sharedPreferences == null) {
            return;
        }

        sharedPreferences.edit()
                .putBoolean(key, value)
                .apply();
    }

    public void m6914q(boolean z) {
        enableCallApp = z;
        sharedPreferences.edit().putBoolean("enable_call_app", enableCallApp).apply();
    }

    public void putInt(String key, int value) {
        saveInt(key, value, false);
    }

    public boolean m6916r() {
        return sharedPreferences.getBoolean("enable_geolocation", true);
    }

    public void saveInt(String key, int value, boolean useSync) {
        ensurePreferencesLoaded();
        if (sharedPreferences == null) {
            return;
        }
        if (useSync) {
            sharedPreferences.edit().putInt(key, value).commit();
        } else {
            sharedPreferences.edit().putInt(key, value).apply();
        }
    }

    public void m6918s(boolean z) {
        disableJavascript = !z;
        sharedPreferences.edit().putBoolean("disable-javascript", disableJavascript).apply();
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
    }

    public void m6919s0(String str, long j) {
        ensurePreferencesLoaded();
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public boolean m6920t() {
        if (m6901j0()) {
            return sharedPreferences.getBoolean("enable_light_touch", false);
        }
        return false;
    }

    public void putString(String key, String value) {
        saveString(key, value, false);
    }

    public final void ensurePreferencesLoaded() {
        if (sharedPreferences == null) {
            if (context == null) {
                context = Browser.m6161a();
            }
            Context context = this.context;
            if (context != null) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            }
        }
    }

    public void saveString(String key, String value, boolean useSync) {
        ensurePreferencesLoaded();
        if (sharedPreferences == null) {
            return;
        }
        if (useSync) {
            sharedPreferences.edit().putString(key, value).commit();
        } else {
            sharedPreferences.edit().putString(key, value).apply();
        }
    }

    public void m6924v(WebSettings webSettings) {
        boolean z = false;
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        CookieManager cookieManager = CookieManager.getInstance();
        if (supportCookiesInPrivate && acceptCookies) {
            z = true;
        }
        cookieManager.setAcceptCookie(z);
    }

    public void m6925v0(WebSettings webSettings) {
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        CookieManager.getInstance().setAcceptCookie(acceptCookies);
    }

    public boolean m6926w0() {
        return sharedPreferences.getBoolean("remember_passwords", true);
    }

    public final int m6927x(int i) {
        return (int) ((((i - 10) * 5) + 100) * densityRatio);
    }

    public String m6928y() {
        return PhoneUtils.getInstance().getString("app_type", "browser");
    }

    public void m6929y0() {
        putBoolean("active-ad-block", false);
        putBoolean("enable-tampermonkey", true);
        putBoolean("enable-smart-adb", false);
        putBoolean("block-pop-window", false);
        putBoolean("support-instant-tran", false);
        putBoolean("show-ad-block-toast", true);
        putBoolean("enter-night-mode", false);
        putBoolean("follow-sys-dark-mode", true);
        putBoolean("enter-desktop-mode", false);
        putBoolean("enter-private-mode", false);
        putBoolean("use-public-download-dir", true);
        putBoolean("remind-when-down-complete", false);
        putBoolean("support-multi-win", true);
        putBoolean("open-search-in-new-tab", false);
        putBoolean("confirm-when-close-tabs", false);
        putBoolean("close-tab-in-order", false);
        putBoolean("new-tab-at-bottom", false);
        putBoolean("force-open-in-bg", false);
        putBoolean("force-open-in-new-tab", false);
        putBoolean("support-cookies-in-priv", true);
        putBoolean("support-super-cache", false);
        putBoolean("auto-clean-web-cache", true);
        putBoolean("support_adjust_brightness", false);
        putBoolean("support-quick-gesture", false);
        putBoolean("disable-back-forward-gesture", false);
        putBoolean("support-switch-tab-gesture", true);
        putBoolean("disable-pull-to-refresh-gesture", false);
        putBoolean("disable-pull-to-search-gesture", false);
        putBoolean("keep-screen-on", false);
        putBoolean("disable-fast-scrolling-slider", false);
        putBoolean("open-unclose-tab", true);
        putBoolean("clean-web-cache-on-exit", false);
        putBoolean("force-user-scalable", false);
        putBoolean("enable-immersive-mode", true);
        putBoolean("fullscreen-with-float-btn", false);
        putBoolean("auto-wrap-when-scaled", false);
        putBoolean("disable-search-bar-hotword", false);
        putBoolean("do-not-show-search-his", false);
        putBoolean("do-not-show-browser-his", false);
        putBoolean("do-not-show-clipboard-content", false);
        putBoolean("disable-search-suggestion", false);
        putBoolean("support-touch-page-down", false);
        putBoolean("support-volume-page-down", false);
        putBoolean("show-confirm-dlg-on-exit", false);
        putBoolean("return_to_browser", true);
        putBoolean("disable-read-mode", false);
        putBoolean("first-sniff-media", false);
        putBoolean("disable-javascript", false);
        putBoolean("enable_call_app", true);
        putBoolean("disable-write-clipboard", false);
        putBoolean("enable-dnt", false);
        putBoolean("enable-remote-debug", false);
        putBoolean("disable-third-cookies", false);
        putBoolean("disable-video-force-landscape", false);
        putBoolean("disable-gesture-in-video-fullscreen", false);
        putBoolean("browser_fullscreen_mode", false);
        putBoolean("auto-sniff-media", false);
        putBoolean("deep-sniff-media", false);
        putBoolean("accept_cookies", true);
        putBoolean("remember_passwords", true);
        putBoolean("save_formdata", true);
        putBoolean("ignore_security_warnings", true);
        putBoolean("hide-add-qa-btn", false);
        putBoolean("hide-start-page-logo", false);
        putBoolean("use-circular-style-qa-icon", false);
        putBoolean("use-pure-color-icon", false);
        putBoolean("display-qa-in-single-screen", true);
        putBoolean("qa-fill-the-whole-screen", false);
        putBoolean("show-qa-icons", true);
        putBoolean("autofit_pages", true);
        putBoolean("load_page", true);
        putBoolean("load_images", true);
        putBoolean("enable_light_touch", false);
        putBoolean("normal_layout", false);
        putBoolean("small_screen", false);
        putBoolean("dont-upload-user-exp-data", false);
        putBoolean("enable_geolocation", true);
        putBoolean("clean_history_checked", false);
        putBoolean("clean_search_his_checked", false);
        putBoolean("clean_web_cache_checked", false);
        putBoolean("clean_web_app_cache_checked", false);
        putBoolean("clean_web_cookies_checked", false);
        putBoolean("clean_form_data_checked", false);
        putBoolean("app_crashed", false);
        putString("default_lang_code", null);
        putString("default_text_encoding", null);
        putString("default_zoom", "MEDIUM");
        putString("plugin_state", "ON");
        putString("text_size", "NORMAL");
        putString("user_agent", "ua_default");
        putString("status_bar_style_new", "-1");
        putString("browser_theme", PhoneUtils.getInstance().getString("browser_theme", "light"));
        putString("user_download_dir", Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Environment.DIRECTORY_DOWNLOADS);
        putString("share_message", "");
        putString("review_message", "");
        putString("screen_orientation", PhoneUtils.getInstance().getString("screen_orientation", "portrait"));
        putString("user_search_url", null);
        putString("trans_engine_url", null);
        putString("home_page", "file:///android_asset/start-page/index.html");
        putString("default_downloader", "");
        putString("bind_default_downloader", "");
        putString("search-bar-at-top.toolbar_layout", "layout_1");
        putString("search-bar-at-bottom.toolbar_layout", "layout_3");
        putInt("good_for_eye_color", 0);
        putInt("default_brightness", -1);
        putInt("night_brightness", -1);
        putInt("back-forward-gesture-trigger-type", 2);
        putInt("default_layout_type", 4097);
        putInt("ad_rule_update_circle", 0);
        putInt("recovery_tab_type", 0);
        putInt("home_icon_style", 0);
        putInt("min_font_size", 0);
        putInt("text_zoom", 10);
        putInt("double_tap_zoom", 5);
        putInt("home_icon_alpha", 255);
        putInt("save_traffic_strategy", 0);
        putInt("last_float_btn_x", -1);
        putInt("last_float_btn_y", -1);
        m6894g();
        loadPreferences();
        MenuConfigManager.getInstance().m7038u();
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
    }

    public final String getOverrideSearchUrl() {
        return getString("backup_search_url", "https://m.baidu.com/s?from=1023722p&word=%keywords%");
    }

    public void m6931z0() {
        searchUrl = null;
        putString("assign_search_url", null);
    }
}
