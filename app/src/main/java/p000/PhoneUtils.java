package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Insets;
import android.graphics.Point;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;

import com.mmbox.xbrowser.SharedPreferencesHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

public class PhoneUtils {

    public static String osBuildTag = "";

    public static PhoneUtils instance;

    public static int deviceType;

    public Point screenSize;

    public Context context = null;

    public String channelCode = null;

    public String countryCode = null;

    public String countryCodeIso = null;

    public String cachedLanguage = null;

    public String cachedLocaleCode = null;

    public String mobileModel = null;


    public String devicesId = "";

    public String versionName = null;

    public String rootDir = null;


    public String cacheDirectory = null;


    public String appSignatureMd5 = null;

    public JSONObject configJson = null;

    public static PhoneUtils getInstance() {
        if (instance == null) {
            instance = new PhoneUtils();
        }
        return instance;
    }

    public int getSystemDimensionPixelSize(String dimenName) {
        int resourceId = context.getResources().getIdentifier(dimenName, "dimen", "android");
        if (resourceId > 0) {
            return context.getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    public String getLanguageCode() {
        if (this.cachedLanguage == null) {
            this.cachedLanguage = Locale.getDefault().getLanguage();
        }
        return this.cachedLanguage;
    }

    public int getNavigationBarHeight() {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                if (windowManager != null) {
                    Insets insets = windowManager.getCurrentWindowMetrics()
                            .getWindowInsets()
                            .getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars());

                    int maxInset = Math.max(Math.max(insets.left, insets.right),
                            Math.max(insets.top, insets.bottom));

                    if (maxInset > 0) {
                        if (Build.VERSION.SDK_INT < 35) {
                            return maxInset;
                        }

                        float scale = maxInset < AndroidSystemUtils.dpToPx(24, context) ? 0.8f : 1.0f;
                        return (int) (maxInset * scale);
                    }
                }
            } catch (Throwable ignored) {
            }
        }

        // Fallback
        getStatusBarHeight(); // optional, if needed
        return 0;
    }

    public int getScreenHeight() {
        return this.context.getResources().getDisplayMetrics().heightPixels;
    }

    public int getScreenWidth() {
        return this.context.getResources().getDisplayMetrics().widthPixels;
    }

    public String getAppSignatureMd5() {
        if (TextUtils.isEmpty(this.appSignatureMd5)) {
            Signature[] signatures = AndroidSystemUtils.getAppSignatures(this.context);
            if (signatures.length > 0) {
                this.appSignatureMd5 = AbstractCryptoUtils.toMd5(signatures[0].toCharsString());
            }
        }
        return this.appSignatureMd5;
    }

    public int getStatusBarHeight() {
        return getSystemDimensionPixelSize("status_bar_height");
    }

    public String getString(String key, String defaultValue) {
        if (configJson == null) {
            return defaultValue;
        }
        try {
            return configJson.getString(key);
        } catch (JSONException unused) {
            return defaultValue;
        }
    }

    public String loadConfig(String str) {
        String str2 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.context.getResources().getAssets().open(str)));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return str2;
                }
                str2 = str2 + line;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public String getAppFilesDir() {
        return this.context.getFilesDir().getAbsolutePath();
    }

    public int getVersionCode() {
        try {
            return this.context
                    .getPackageManager()
                    .getPackageInfo(this.context.getPackageName(), 0)
                    .versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getVersionName() {
        if (this.versionName == null) {
            try {
                this.versionName = this.context
                        .getPackageManager()
                        .getPackageInfo(this.context.getPackageName(), 0)
                        .versionName;
            } catch (Exception e) {
                e.printStackTrace();
                this.versionName = "1.0";
            }
        }
        return this.versionName;
    }

    public boolean isInChina() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();

        return "zh".equalsIgnoreCase(language) || "CN".equalsIgnoreCase(country);
    }

    public boolean isInIndia() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();

        // List of languages commonly used in India
        Set<String> indianLanguages = Set.of(
                "in", "bn", "ta", "te", "mr", "jv", "kn", "ml"
        );

        return "IN".equalsIgnoreCase(country) || indianLanguages.contains(language);
    }

    public void initialize(Context context, String rootDir) {
        this.context = context;
        this.rootDir = rootDir;

        // Load the default configuration
        String appConfig = loadConfig("app_default_conf.json");
        if (!TextUtils.isEmpty(appConfig)) {
            try {
                this.configJson = new JSONObject(appConfig);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Get screen size
        Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        screenSize = new Point();
        defaultDisplay.getSize(screenSize);

        // Set cache directory
        this.cacheDirectory = getString("cache_dir", "cache");

        // Check device-specific properties
        checkDeviceProperties();
    }

    public boolean isGooglePlayChannel() {
        String channel = getInstance().getChannelCode();
        Set<String> googlePlayChannels = Set.of(
                "google_play",
                "google_play_new",
                "xbrowser_for_gp",
                "xbrowser_for_gp_beta",
                "google_play_fmb",
                "webshuttle",
                "web_shuttle_new",
                "google_play_std"
        );
        return googlePlayChannels.contains(channel);
    }

    public boolean getSystemApp() {
        try {
            return (this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).applicationInfo.flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void checkDeviceProperties() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));

            // Check if the device is MIUI
            if (properties.getProperty("ro.miui.ui.version.code", null) != null ||
                    properties.getProperty("ro.miui.ui.version.name", null) != null ||
                    properties.getProperty("ro.miui.internal.storage", null) != null) {
                deviceType = 1; // MIUI
            }
        } catch (Exception ignored) {
        }

        try {
            Class<?> systemPropertiesClass = Class.forName("android.os.SystemProperties");
            osBuildTag = (String) systemPropertiesClass.getMethod("get", String.class, String.class)
                    .invoke(systemPropertiesClass, "ro.build.display.id", "");

            // Check if the device is Flyme
            if (!TextUtils.isEmpty(osBuildTag) && osBuildTag.toLowerCase().contains("flyme")) {
                deviceType = 2; // Flyme
            }
        } catch (Exception ignored) {
        }
    }

    public String getAndroidId() {
        return Settings.Secure.getString(this.context.getContentResolver(), "android_id");
    }

    public String getCacheDirPath() {
        return context.getCacheDir().getAbsolutePath();
    }

    public String getAppKey() {
        return getMetaDataValue("UMENG_APPKEY");
    }

    public final String getMetaDataValue(String key) {
        try {
            ApplicationInfo appInfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            return appInfo.metaData != null ? appInfo.metaData.getString(key) : null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean getBoolean(String str, boolean z) {
        boolean boolValueOf = z;
        if (configJson != null) {
            try {
                boolValueOf = configJson.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return boolValueOf;
    }

    public String getChannelCode() {
        if (this.channelCode == null) {
            // Try to read from SharedPreferences
            String code = SharedPreferencesHelper.getInstance().getString("channel_code", null);

            if (code == null) {
                // Try to read from manifest meta-data
                code = getMetaDataValue("UMENG_CHANNEL");
                if (code != null) {
                    SharedPreferencesHelper.getInstance().putString("channel_code", code);
                }

                // Fallback to "official"
                if (code == null) {
                    code = "official";
                }
            }

            this.channelCode = code;
        }

        return this.channelCode;
    }

    /**
     * Returns the default country code from Locale if no other info is available.
     */
    public String getCountryCode() {
        if (this.countryCode == null) {
            this.countryCode = Locale.getDefault().getCountry();
        }
        return this.countryCode;
    }

    /**
     * Returns the 2-letter country code from SIM or network, falling back to Locale.
     */
    public String getSimOrNetworkCountryCode() {
        if (countryCodeIso == null) {
            try {
                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                String code = null;

                String simCountryIso = tm.getSimCountryIso();
                if (simCountryIso != null && simCountryIso.length() == 2) {
                    code = simCountryIso.toLowerCase(Locale.US);
                } else if (tm.getPhoneType() != TelephonyManager.PHONE_TYPE_CDMA) {
                    String networkCountryIso = tm.getNetworkCountryIso();
                    if (networkCountryIso != null && networkCountryIso.length() == 2) {
                        code = networkCountryIso.toLowerCase(Locale.US);
                    }
                }

                countryCodeIso = code;
            } catch (Exception ignored) {
                // fallback below
            }
        }
        return TextUtils.isEmpty(countryCodeIso) ? getCountryCode() : countryCodeIso;
    }

    /**
     * Returns the density bucket string based on device screen DPI.
     */
    public String getDensityBucket() {
        int dpi = context.getResources().getDisplayMetrics().densityDpi;

        switch (dpi) {
            case 120:
                return "ldpi";
            case 160:
                return "mdpi";
            case 240:
                return "hdpi";
            case 320:
                return "xhdpi";
            case 480:
                return "xxhdpi";
            case 640:
                return "xxxhdpi";
            default:
                return "unknown";
        }
    }

    public String getMobileModel() {
        if (this.mobileModel == null) {
            this.mobileModel = Build.MODEL;
        }
        return this.mobileModel;
    }

    public String getDeviceId() {
        if (devicesId == null) {
            TextUtils.isEmpty(devicesId);
            if (TextUtils.isEmpty(devicesId)) {
                devicesId = SharedPreferencesHelper.getInstance().getString("devices_id", "");
                if (TextUtils.isEmpty(devicesId)) {
                    devicesId = UUID.randomUUID().toString();
                    SharedPreferencesHelper.getInstance().putString("devices_id", devicesId);
                }
            }
        }
        return this.devicesId;
    }

    public String getBackupDir() {
        return this.rootDir + "/.backup";
    }

    public String getCacheDir() {
        return this.rootDir + "/cache";
    }

    public String getBackupDirPath() {
        return this.context.getExternalFilesDir(".backup").getAbsolutePath();
    }

    public String getCrashDirPath() {
        return this.context.getExternalFilesDir("crash").getAbsolutePath();
    }

    public String getDownloadsDirPath() {
        return this.context.getExternalFilesDir("downloads").getAbsolutePath();
    }

    public String getRecoveryDirPath() {
        return this.context.getExternalFilesDir("recovery").getAbsolutePath();
    }

    public String getOfflinesDirPath() {
        return this.context.getExternalFilesDir("offlines").getAbsolutePath();
    }

    public String getAdRulesDirPath() {
        return this.context.getExternalFilesDir("ad_rules").getAbsolutePath();
    }

    public String getResourcesDirPath() {
        return this.context.getExternalFilesDir("resources").getAbsolutePath();
    }

    public String getExternalDirPath() {
        return this.context.getExternalFilesDir("").getAbsolutePath();
    }

    public String getLocaleCode() {
        if (this.cachedLocaleCode == null) {
            Locale currentLocale = Locale.getDefault();
            this.cachedLocaleCode = currentLocale.getLanguage() + "-" + currentLocale.getCountry().toUpperCase();
        }
        return this.cachedLocaleCode;
    }

    public String getMobileImei() {
        return "0000000000000000000";
    }

    /**
     * Retrieves an integer value from the config JSON.
     * Returns the default value if the key is missing or on error.
     *
     * @param key          The JSON key.
     * @param defaultValue The default value to return if key is missing.
     * @return The integer value from configJson, or defaultValue.
     */
    public int getConfigInt(String key, int defaultValue) {
        if (configJson == null) {
            return defaultValue;
        }
        try {
            return configJson.getInt(key);
        } catch (JSONException e) {
            return defaultValue;
        }
    }
}
