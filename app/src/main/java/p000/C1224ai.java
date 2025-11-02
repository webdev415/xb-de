package p000;

import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.C1541c;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1224ai {

    public static C1224ai f3546b;

    public BrowserActivity f3547a = null;

    public class a {

        public String f3548a;

        public String f3549b;

        public a() {
        }
    }

    public static C1224ai m5285e() {
        if (f3546b == null) {
            f3546b = new C1224ai();
        }
        return f3546b;
    }

    public String m5286a(int i) {
        BrowserActivity browserActivity;
        int i2;
        if (i == 1) {
            browserActivity = this.f3547a;
            i2 = R.string.str_backup_every_day;
        } else if (i == 2) {
            browserActivity = this.f3547a;
            i2 = R.string.str_backup_every_three_day;
        } else if (i == 3) {
            browserActivity = this.f3547a;
            i2 = R.string.str_backup_every_five_day;
        } else if (i == 4) {
            browserActivity = this.f3547a;
            i2 = R.string.str_backup_weekly;
        } else {
            browserActivity = this.f3547a;
            i2 = R.string.str_never_auto_backup;
        }
        return browserActivity.getString(i2);
    }

    public String m5287b(int i) {
        BrowserActivity browserActivity;
        int i2;
        if (i == 1) {
            browserActivity = this.f3547a;
            i2 = R.string.str_update_once_a_day;
        } else if (i == 2) {
            browserActivity = this.f3547a;
            i2 = R.string.str_update_every_three_day;
        } else if (i == 3) {
            browserActivity = this.f3547a;
            i2 = R.string.str_update_every_five_day;
        } else if (i == 4) {
            browserActivity = this.f3547a;
            i2 = R.string.str_update_weekly;
        } else {
            browserActivity = this.f3547a;
            i2 = R.string.str_never_auto_update;
        }
        return browserActivity.getString(i2);
    }

    public final String m5288c(String str) {
        return TextUtils.isEmpty(str) ? this.f3547a.getString(R.string.web_str_ex_point_auto_run) : str.equals("ep.menu.tool") ? this.f3547a.getString(R.string.web_str_ex_point_t_menu) : str.equals("ep.menu.context") ? this.f3547a.getString(R.string.web_str_ex_point_c_menu) : str.equals("ep.menu.main") ? this.f3547a.getString(R.string.web_str_ex_point_m_menu) : this.f3547a.getString(R.string.web_str_ex_point_auto_run);
    }

    public final ArrayList m5289d() {
        ArrayList arrayList = new ArrayList<>();
        a aVar = new a();
        aVar.f3549b = this.f3547a.getString(R.string.title_default_downloader);
        aVar.f3548a = "com.x.browser.downloader";
        arrayList.add(aVar);
        if (C1541c.m6674q().m6690f()) {
            a aVar2 = new a();
            aVar2.f3549b = this.f3547a.getString(R.string.title_system_downloader);
            aVar2.f3548a = "com.android.providers.downloads";
            arrayList.add(aVar2);
        }
        ArrayList arrayListM9887e = C2406u0.m9882f().m9887e(16);
        for (int i = 0; i < arrayListM9887e.size(); i++) {
            Player player = (Player) arrayListM9887e.get(i);
            if (C2406u0.m9882f().m9883a(player.packageName)) {
                a aVar3 = new a();
                aVar3.f3549b = player.f7126a;
                aVar3.f3548a = player.packageName;
                arrayList.add(aVar3);
            }
        }
        return arrayList;
    }

    public final ArrayList m5290f() throws Resources.NotFoundException {
        ArrayList arrayList = new ArrayList<>();
        String[] stringArray = this.f3547a.getResources().getStringArray(R.array.settings_language_list);
        String[] stringArray2 = this.f3547a.getResources().getStringArray(R.array.settings_language_code);
        for (int i = 0; i < stringArray.length; i++) {
            a aVar = new a();
            aVar.f3549b = stringArray[i];
            aVar.f3548a = stringArray2[i];
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public int m5291g(String str, String str2) throws JSONException, Resources.NotFoundException {
        if (str.equals("downloader")) {
            ArrayList arrayListM5289d = m5289d();
            for (int i = 0; i < arrayListM5289d.size(); i++) {
                if (((a) arrayListM5289d.get(i)).f3548a.equals(str2)) {
                    return i;
                }
            }
            return -1;
        }
        if (str.equals("search_engine")) {
            ArrayList arrayListM5296l = m5296l();
            for (int i2 = 0; i2 < arrayListM5296l.size(); i2++) {
                boolean zEquals = str2.indexOf("baidu.com") >= 0 ? Uri.parse(str2).getHost().equals(Uri.parse(((a) arrayListM5296l.get(i2)).f3548a).getHost()) : false;
                if (((a) arrayListM5296l.get(i2)).f3548a.equals(str2) || zEquals) {
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
        ArrayList arrayListM5290f = m5290f();
        for (int i3 = 0; i3 < arrayListM5290f.size(); i3++) {
            if (TextUtils.isEmpty(str2)) {
                return 0;
            }
            if (((a) arrayListM5290f.get(i3)).f3548a.equals(str2)) {
                return i3;
            }
        }
        return -1;
    }

    public ArrayList m5292h(String str) {
        if (str.equals("downloader")) {
            return m5289d();
        }
        if (str.equals("search_engine")) {
            return m5296l();
        }
        if (str.equals("language")) {
            return m5290f();
        }
        if (str.equals("tab_revert_way")) {
            return m5295k();
        }
        return null;
    }

    public String m5293i(String str, String str2) throws JSONException, Resources.NotFoundException {
        int iM5291g = m5291g(str, str2);
        return iM5291g < 0 ? "not-set" : ((a) m5292h(str).get(iM5291g)).f3549b;
    }

    public final String m5294j() {
        int i;
        Exception e;
        String string = this.f3547a.getString(R.string.str_total_items);
        try {
            JSONArray jSONArray = new JSONArray(C1089Xm.getInstance().getSyncResourceConfig());
            i = 0;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    if (jSONArray.getJSONObject(i2).getBoolean("checked")) {
                        i++;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return String.format(string, Integer.valueOf(i));
                }
            }
        } catch (Exception e3) {
            i = 0;
            e = e3;
        }
        return String.format(string, Integer.valueOf(i));
    }

    public final ArrayList m5295k() {
        ArrayList arrayList = new ArrayList<>();
        a aVar = new a();
        aVar.f3549b = this.f3547a.getString(R.string.recover_tabs);
        aVar.f3548a = "0";
        arrayList.add(aVar);
        a aVar2 = new a();
        aVar2.f3549b = this.f3547a.getString(R.string.recover_tabs_query);
        aVar2.f3548a = "1";
        arrayList.add(aVar2);
        a aVar3 = new a();
        aVar3.f3549b = this.f3547a.getString(R.string.recover_tabs_never);
        aVar3.f3548a = "2";
        arrayList.add(aVar3);
        return arrayList;
    }

    public final ArrayList m5296l() throws JSONException, Resources.NotFoundException {
        ArrayList arrayList = new ArrayList<>();
        String[] stringArray = this.f3547a.getResources().getStringArray(R.array.settings_default_search_choices);
        String[] stringArray2 = this.f3547a.getResources().getStringArray(R.array.settings_default_search_values);
        for (int i = 0; i < stringArray.length; i++) {
            a aVar = new a();
            aVar.f3549b = stringArray[i];
            aVar.f3548a = stringArray2[i];
            arrayList.add(aVar);
        }
        a aVar2 = new a();
        aVar2.f3549b = this.f3547a.getString(R.string.search_name_google);
        aVar2.f3548a = "https://www.google.com.hk/search?q=%keywords%";
        arrayList.add(aVar2);
        a aVar3 = new a();
        aVar3.f3549b = this.f3547a.getString(R.string.search_name_duckduckgo);
        aVar3.f3548a = "https://duckduckgo.com/?q=%keywords%";
        arrayList.add(aVar3);
        try {
            JSONArray jSONArray = new JSONArray(SharedPreferencesHelper.getInstance().getString("custom_search_urls", "[]"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                a aVar4 = new a();
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String strM3666k = JsonUtils.getString(jSONObject, "title", "");
                String strM3666k2 = JsonUtils.getString(jSONObject, "url", "");
                aVar4.f3549b = strM3666k;
                aVar4.f3548a = strM3666k2;
                arrayList.add(aVar4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public String m5297m(String str) {
        if (str.equals("rule_file_update_cycle")) {
            return m5287b(SharedPreferencesHelper.getInstance().adRuleUpdateCircle);
        }
        if (str.equals("downloader")) {
            return m5293i(str, SharedPreferencesHelper.getInstance().getString("default_downloader", "com.x.browser.downloader"));
        }
        if (str.equals("search_engine")) {
            return m5293i(str, SharedPreferencesHelper.getInstance().getSearchUrl());
        }
        if (!str.equals("tab_revert_way")) {
            return str.equals("language") ? m5293i(str, SharedPreferencesHelper.getInstance().defaultLangCode) : str.equals("script_execute_mode") ? m5288c(C2061mf.m8471f0().executionPoint) : str.equals("auto_backup_cycle") ? m5286a(SharedPreferencesHelper.getInstance().getInt("auto_backup_circle", 4)) : str.equals("sync_items") ? m5294j() : this.f3547a.m6206F0(SharedPreferencesHelper.getInstance().m6855G(str));
        }
        return m5293i(str, SharedPreferencesHelper.getInstance().recoveryTabType + "");
    }

    public void m5298n(BrowserActivity browserActivity) {
        this.f3547a = browserActivity;
    }

    public final int m5299o(String str) {
        ArrayList arrayListM5295k = m5295k();
        for (int i = 0; i < arrayListM5295k.size(); i++) {
            if (((a) arrayListM5295k.get(i)).f3548a.equals(str)) {
                return i;
            }
        }
        return 0;
    }
}
