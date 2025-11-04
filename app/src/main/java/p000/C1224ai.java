package p000;

import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;

import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.BrowserDownloadManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class C1224ai {

    public static C1224ai f3546b;

    public BrowserActivity browserActivity = null;

    public static class ThirdApp {

        public String pkg;

        public String name;
    }

    public static C1224ai getInstance() {
        if (f3546b == null) {
            f3546b = new C1224ai();
        }
        return f3546b;
    }

    public String getBackupLabel(int i) {
        switch (i) {
            case 1:
                return browserActivity.getString(R.string.str_backup_every_day);
            case 2:
                return browserActivity.getString(R.string.str_backup_every_three_day);
            case 3:
                return browserActivity.getString(R.string.str_backup_every_five_day);
            case 4:
                return browserActivity.getString(R.string.str_backup_weekly);
            default:
                return browserActivity.getString(R.string.str_never_auto_backup);
        }
    }

    public String getUpdateLabel(int i) {
        switch (i) {
            case 1:
                return browserActivity.getString(R.string.str_update_once_a_day);
            case 2:
                return browserActivity.getString(R.string.str_update_every_three_day);
            case 3:
                return browserActivity.getString(R.string.str_update_every_five_day);
            case 4:
                return browserActivity.getString(R.string.str_update_weekly);
            default:
                return browserActivity.getString(R.string.str_never_auto_update);
        }
    }

    public final String getMenuLabelForPoint(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.browserActivity.getString(R.string.web_str_ex_point_auto_run);
        }

        switch (str) {
            case "ep.menu.tool":
                return this.browserActivity.getString(R.string.web_str_ex_point_t_menu);
            case "ep.menu.context":
                return this.browserActivity.getString(R.string.web_str_ex_point_c_menu);
            case "ep.menu.main":
                return this.browserActivity.getString(R.string.web_str_ex_point_m_menu);
            default:
                return this.browserActivity.getString(R.string.web_str_ex_point_auto_run);
        }
    }

    public final ArrayList<ThirdApp> getAvailableDownloaders() {
        ArrayList<ThirdApp> arrayList = new ArrayList<>();
        ThirdApp xThirdApp = new ThirdApp();
        xThirdApp.name = this.browserActivity.getString(R.string.title_default_downloader);
        xThirdApp.pkg = "com.x.browser.downloader";
        arrayList.add(xThirdApp);

        if (BrowserDownloadManager.getInstance().isDownloadProviderEnabled()) {
            ThirdApp thirdApp = new ThirdApp();
            thirdApp.name = this.browserActivity.getString(R.string.title_system_downloader);
            thirdApp.pkg = "com.android.providers.downloads";
            arrayList.add(thirdApp);
        }

        ArrayList arrayListM9887e = C2406u0.getInstance().m9887e(16);
        for (int i = 0; i < arrayListM9887e.size(); i++) {
            Addon addon = (Addon) arrayListM9887e.get(i);
            if (C2406u0.getInstance().m9883a(addon.id)) {
                ThirdApp thirdApp = new ThirdApp();
                thirdApp.name = addon.title;
                thirdApp.pkg = addon.id;
                arrayList.add(thirdApp);
            }
        }
        return arrayList;
    }

    public final ArrayList<ThirdApp> getAvailableLanguages() throws Resources.NotFoundException {
        ArrayList<ThirdApp> arrayList = new ArrayList<>();
        String[] stringArray = this.browserActivity.getResources().getStringArray(R.array.settings_language_list);
        String[] stringArray2 = this.browserActivity.getResources().getStringArray(R.array.settings_language_code);
        for (int i = 0; i < stringArray.length; i++) {
            ThirdApp thirdAppVar = new ThirdApp();
            thirdAppVar.name = stringArray[i];
            thirdAppVar.pkg = stringArray2[i];
            arrayList.add(thirdAppVar);
        }
        return arrayList;
    }

    public int m5291g(String str, String str2) throws Resources.NotFoundException {
        if (str.equals("downloader")) {
            ArrayList arrayListM5289d = getAvailableDownloaders();
            for (int i = 0; i < arrayListM5289d.size(); i++) {
                if (((ThirdApp) arrayListM5289d.get(i)).pkg.equals(str2)) {
                    return i;
                }
            }
            return -1;
        }
        if (str.equals("search_engine")) {
            ArrayList arrayListM5296l = getSearchEngines();
            for (int i2 = 0; i2 < arrayListM5296l.size(); i2++) {
                boolean zEquals = str2.indexOf("baidu.com") >= 0 ? Uri.parse(str2).getHost().equals(Uri.parse(((ThirdApp) arrayListM5296l.get(i2)).pkg).getHost()) : false;
                if (((ThirdApp) arrayListM5296l.get(i2)).pkg.equals(str2) || zEquals) {
                    return i2;
                }
            }
            return -1;
        }
        if (!str.equals("language")) {
            if (str.equals("tab_revert_way")) {
                return m5299o(str2);
            }
            return -1;
        }
        ArrayList arrayListM5290f = getAvailableLanguages();
        for (int i3 = 0; i3 < arrayListM5290f.size(); i3++) {
            if (TextUtils.isEmpty(str2)) {
                return 0;
            }
            if (((ThirdApp) arrayListM5290f.get(i3)).pkg.equals(str2)) {
                return i3;
            }
        }
        return -1;
    }

    public ArrayList<ThirdApp> getAppList(String str) {
        switch (str) {
            case "downloader":
                return getAvailableDownloaders();
            case "search_engine":
                return getSearchEngines();
            case "language":
                return getAvailableLanguages();
            case "tab_revert_way":
                return getRecoveryApps();
        }
        return null;
    }

    public String m5293i(String str, String str2) throws Resources.NotFoundException {
        int iM5291g = m5291g(str, str2);
        return iM5291g < 0 ? "not-set" : ((ThirdApp) getAppList(str).get(iM5291g)).name;
    }

    public final String m5294j() {
        int i;
        Exception e;
        String string = this.browserActivity.getString(R.string.str_total_items);
        try {
            JSONArray jSONArray = new JSONArray(SyncManager.getInstance().getSyncResourceConfig());
            i = 0;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    if (jSONArray.getJSONObject(i2).getBoolean("checked")) {
                        i++;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return String.format(string, i);
                }
            }
        } catch (Exception e3) {
            i = 0;
            e = e3;
        }
        return String.format(string, i);
    }

    public final ArrayList<ThirdApp> getRecoveryApps() {
        ArrayList<ThirdApp> arrayList = new ArrayList<>();

        // Add entries for recovering tabs
        arrayList.add(createThirdApp(R.string.recover_tabs, "0"));
        arrayList.add(createThirdApp(R.string.recover_tabs_query, "1"));
        arrayList.add(createThirdApp(R.string.recover_tabs_never, "2"));

        return arrayList;
    }

    private ThirdApp createThirdApp(int stringResId, String pkg) {
        ThirdApp thirdApp = new ThirdApp();
        thirdApp.name = this.browserActivity.getString(stringResId);
        thirdApp.pkg = pkg;
        return thirdApp;
    }

    public final ArrayList<ThirdApp> getSearchEngines() throws Resources.NotFoundException {
        ArrayList<ThirdApp> arrayList = new ArrayList<>();
        String[] stringArray = this.browserActivity.getResources().getStringArray(R.array.settings_default_search_choices);
        String[] stringArray2 = this.browserActivity.getResources().getStringArray(R.array.settings_default_search_values);
        for (int i = 0; i < stringArray.length; i++) {
            ThirdApp thirdAppVar = new ThirdApp();
            thirdAppVar.name = stringArray[i];
            thirdAppVar.pkg = stringArray2[i];
            arrayList.add(thirdAppVar);
        }
        ThirdApp thirdAppVar2 = new ThirdApp();
        thirdAppVar2.name = this.browserActivity.getString(R.string.search_name_google);
        thirdAppVar2.pkg = "https://www.google.com.hk/search?q=%keywords%";
        arrayList.add(thirdAppVar2);
        ThirdApp thirdAppVar3 = new ThirdApp();
        thirdAppVar3.name = this.browserActivity.getString(R.string.search_name_duckduckgo);
        thirdAppVar3.pkg = "https://duckduckgo.com/?q=%keywords%";
        arrayList.add(thirdAppVar3);
        try {
            JSONArray jSONArray = new JSONArray(SharedPreferencesHelper.getInstance().getString("custom_search_urls", "[]"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                ThirdApp thirdAppVar4 = new ThirdApp();
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String strM3666k = JsonUtils.getString(jSONObject, "title", "");
                String strM3666k2 = JsonUtils.getString(jSONObject, "url", "");
                thirdAppVar4.name = strM3666k;
                thirdAppVar4.pkg = strM3666k2;
                arrayList.add(thirdAppVar4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public String m5297m(String str) {
        if (str.equals("rule_file_update_cycle")) {
            return getUpdateLabel(SharedPreferencesHelper.getInstance().adRuleUpdateCircle);
        }
        if (str.equals("downloader")) {
            return m5293i(str, SharedPreferencesHelper.getInstance().getString("default_downloader", "com.x.browser.downloader"));
        }
        if (str.equals("search_engine")) {
            return m5293i(str, SharedPreferencesHelper.getInstance().getSearchUrl());
        }
        if (!str.equals("tab_revert_way")) {
            return str.equals("language") ? m5293i(str, SharedPreferencesHelper.getInstance().defaultLangCode) : str.equals("script_execute_mode") ? getMenuLabelForPoint(JSManager.getInstance().executionPoint) : str.equals("auto_backup_cycle") ? getBackupLabel(SharedPreferencesHelper.getInstance().getInt("auto_backup_circle", 4)) : str.equals("sync_items") ? m5294j() : this.browserActivity.getActionText(SharedPreferencesHelper.getInstance().getDefaultActionForKey(str));
        }
        return m5293i(str, SharedPreferencesHelper.getInstance().recoveryTabType + "");
    }

    public void init(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
    }

    public final int m5299o(String str) {
        ArrayList arrayListM5295k = getRecoveryApps();
        for (int i = 0; i < arrayListM5295k.size(); i++) {
            if (((ThirdApp) arrayListM5295k.get(i)).pkg.equals(str)) {
                return i;
            }
        }
        return 0;
    }
}
