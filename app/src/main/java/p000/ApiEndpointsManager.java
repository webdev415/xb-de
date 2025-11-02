package p000;

import android.content.Context;
import android.text.TextUtils;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.net.URLEncoder;

public class ApiEndpointsManager {

    public static ApiEndpointsManager instance;

    public Context context = null;

    public String touchIconUrl = null;

    public String avatarEndpoint = null;

    public String smallTouchIconUrl = null;

    public String appStoreUrl = null;

    public String userExchangeCodeEndpoint = null;

    public String userDataEndPoint = null;

    public String userEventQueryUrl = null;

    public String serviceHashEndpoint = null;

    public String userEndpoint = null;

    public String clientResourcesEndpoint = null;


    public static ApiEndpointsManager getInstance() {
        if (instance == null) {
            instance = new ApiEndpointsManager();
        }
        return instance;
    }

    public String processTemplateWithRegion(String template) {
        String baseUrl = PhoneUtils.getInstance().isInChina()
                ? "https://www.xbext.com"
                : "https://en.xbext.com";
        return replaceDynamicPlaceholders(template, baseUrl);
    }

    public final String replaceDynamicPlaceholders(String input, String serverBaseUri) {
        try {
            PhoneUtils phoneUtils = PhoneUtils.getInstance();
            String packageName = this.context.getPackageName();

            return input
                    .replaceAll("%server_base_uri%", serverBaseUri)
                    .replaceAll("%device_id%", URLEncoder.encode(phoneUtils.getDeviceId(), "UTF-8"))
                    .replaceAll("%device_code%", URLEncoder.encode(phoneUtils.getMobileModel(), "UTF-8"))
                    .replaceAll("%channel_code%", URLEncoder.encode(phoneUtils.getChannelCode(), "UTF-8"))
                    .replaceAll("%version_code%", URLEncoder.encode(String.valueOf(phoneUtils.getVersionCode()), "UTF-8"))
                    .replaceAll("%country_code%", URLEncoder.encode(phoneUtils.getCountryCode(), "UTF-8"))
                    .replaceAll("%language_code%", URLEncoder.encode(phoneUtils.getLanguageCode(), "UTF-8"))
                    .replaceAll("%density%", URLEncoder.encode(phoneUtils.getDensityBucket(), "UTF-8"))
                    .replaceAll("%package_name%", URLEncoder.encode(packageName, "UTF-8"))
                    .replaceAll("%app_tag%", phoneUtils.getString("alias", "xbrowser"))
                    .replaceAll("%locale%", phoneUtils.isInChina() ? "zh" : "en")
                    .replaceAll("%timestamp%", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            return input;
        }
    }

    public String getUserEndpoint() {
        if (this.userEndpoint == null) {
            this.userEndpoint = processTemplateWithRegion("%server_base_uri%/user");
        }
        return this.userEndpoint;
    }

    public String getAvatarEndpoint() {
        if (this.avatarEndpoint == null) {
            this.avatarEndpoint = processTemplateWithRegion("%server_base_uri%/avatars");
        }
        return this.avatarEndpoint;
    }

    public String getAccountDeletionEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/app_users/destroy_account");
    }

    public String getUserExchangeCodeEndpoint() {
        if (this.userExchangeCodeEndpoint == null) {
            this.userExchangeCodeEndpoint = processTemplateWithRegion("%server_base_uri%/user_exchange_code");
        }
        return this.userExchangeCodeEndpoint;
    }

    public String getFetchShareScriptEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/mobile/fetch_share_script");
    }

    public String getServiceHashEndpoint() {
        if (this.serviceHashEndpoint == null) {
            this.serviceHashEndpoint = processTemplateWithRegion("%server_base_uri%/api/service_hash?country_code=%country_code%&language_code=%language_code%&channel_code=%channel_code%&device_code=%device_code%&density=%density%&version_code=%version_code%&timestamp=%timestamp%");
        }
        return this.serviceHashEndpoint;
    }

    public String getUserScriptsEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/user-scripts/");
    }

    public String getPostShareScriptEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/mobile/post_share_script");
    }

    public String getPostShareRuleEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/mobile/post_share_rule");
    }

    public String getPublicScriptsEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/mobile/pub_scripts?locale=%locale%");
    }

    public String getClientResourcesEndpoint() {
        if (this.clientResourcesEndpoint == null) {
            this.clientResourcesEndpoint = processTemplateWithRegion("%server_base_uri%/client_res");
        }
        return this.clientResourcesEndpoint;
    }

    public String getSavePageAsEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/api/save_page_as");
    }

    public String getArticleListEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/mobile/article_list_for_xb_readmode_v5.html?version=v5.0");
    }

    public String getShareAdRulesEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/mobile/share_ad_rules?locale=%locale%");
    }

    public String getShareScriptsEndpoint() {
        return processTemplateWithRegion("%server_base_uri%/mobile/share_scripts?locale=%locale%");
    }

    public String getAppStoreUrl() {
        if (this.appStoreUrl == null) {
            if (PhoneUtils.getInstance().isInChina()) {
                this.appStoreUrl = processTemplateWithRegion("https://www.xbext.com");
            } else {
                this.appStoreUrl = "https://play.google.com/store/apps/details?id=" + this.context.getPackageName();
            }
        }
        return this.appStoreUrl;
    }

    public String getUserDataEndPoint() {
        if (this.userDataEndPoint == null) {
            this.userDataEndPoint = processTemplateWithRegion("%server_base_uri%/user_data");
        }
        return this.userDataEndPoint;
    }

    public String getTouchIconUrl() {
        if (this.touchIconUrl == null) {
            int dpi = this.context.getResources().getDisplayMetrics().densityDpi;
            String baseUrl = processTemplateWithRegion("%server_base_uri%/touch_icons");
            String backupUrl = SharedPreferencesHelper.getInstance().getString("icon_base_url_backup", baseUrl);

            if (!TextUtils.isEmpty(backupUrl)) {
                baseUrl = backupUrl;
            }

            String sizePath;
            if (dpi >= 560) {
                sizePath = "/192x192";
            } else if (dpi >= 400) {
                sizePath = "/144x144";
            } else if (dpi >= 280) {
                sizePath = "/96x96";
            } else {
                sizePath = "/72x72";
            }

            this.touchIconUrl = baseUrl + sizePath;
        }
        return this.touchIconUrl;
    }

    public String getUserEventQueryUrl() {
        if (this.userEventQueryUrl == null) {
            this.userEventQueryUrl = processTemplateWithRegion("%server_base_uri%/user_event/query");
        }
        return this.userEventQueryUrl;
    }

    public String getViewPicListUrl() {
        return processTemplateWithRegion("%server_base_uri%/mobile/view_pic_list.html");
    }

    /** Returns the small touch icon URL (48x48) */
    public String getSmallTouchIconUrl() {
        if (this.smallTouchIconUrl == null) {
            this.smallTouchIconUrl = processTemplateWithRegion("%server_base_uri%/touch_icons") + "/48x48";
        }
        return this.smallTouchIconUrl;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
