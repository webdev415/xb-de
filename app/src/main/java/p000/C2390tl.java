package p000;

import android.database.Cursor;
import android.util.Log;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2390tl {

    public static C2390tl f7238j;

    public static final Pattern f7239k = Pattern.compile("window\\.baidu\\.sug\\((.*)\\);");

    public final String f7240a = "http://sugg.search.yahoo.net/sg/?output=json&nresults=10&command=%wd%";

    public final String f7241b = "https://suggestion.baidu.com/su?from=1013843g&wd=%wd%&json=1";

    public final String f7242c = "http://top.baidu.com/mobile_v2/buzz/hotspot";

    public final String f7243d = "http://m.hao123.com/hao123_api/api/cpc/cms/?tn=1013843g";

    public final String f7244e = "http://trends.mobitech-search.xyz/mobitech/trends?p_key=FSTMINBR8513CE34&user_id=%user_id%&c=%country%";

    public final long f7245f = 600000;

    public final String f7246g = "";

    public Random f7247h = null;

    public OkHttpClient f7248i = null;

    public class a implements InterfaceC0556M3 {

        public final c f7249a;

        public final String f7250b;

        public class RunnableC2722a implements Runnable {
            public RunnableC2722a() {
            }

            @Override
            public void run() {
                a.this.f7249a.mo7158b();
            }
        }

        public class b implements Runnable {

            public final ArrayList f7253l;

            public b(ArrayList arrayList) {
                this.f7253l = arrayList;
            }

            @Override
            public void run() {
                a.this.f7249a.mo7157a(this.f7253l);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override
            public void run() {
                a.this.f7249a.mo7158b();
            }
        }

        public a(c cVar, String str) {
            this.f7249a = cVar;
            this.f7250b = str;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) throws IllegalAccessException, JSONException, IOException, IllegalArgumentException, InvocationTargetException {
            if (response.getStatus() != 200) {
                Log.i("fetch-search-sug", ">>>>>> fetch suggestion failed:");
                if (this.f7249a != null) {
                    BrowserActivity.getActivity().runOnUiThread(new c());
                    return;
                }
                return;
            }
            String strM2399p = response.getContentType("Content-Type");
            String strM2714l = response.body().m2714l();
            if (strM2399p != null && (strM2399p.indexOf("/json") >= 0 || strM2399p.indexOf("text/") >= 0)) {
                ArrayList arrayListM9742m = C2390tl.this.m9742m(strM2714l, this.f7250b);
                if (this.f7249a != null) {
                    BrowserActivity.getActivity().runOnUiThread(new b(arrayListM9742m));
                }
            }
            response.body().close();
        }

        @Override
        public void onError(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            Log.i("fetch-search-sug", ">>>>>> fetch suggestion failed:");
            if (this.f7249a != null) {
                BrowserActivity.getActivity().runOnUiThread(new RunnableC2722a());
            }
        }
    }

    public class b implements Comparator {
        public b() {
        }

        @Override
        public int compare(C2476vf c2476vf, C2476vf c2476vf2) {
            return c2476vf.f7677b.compareTo(c2476vf2.f7677b);
        }
    }

    public interface c {
        void mo7157a(ArrayList arrayList);

        void mo7158b();
    }

    public static C2390tl getInstance() {
        if (f7238j == null) {
            f7238j = new C2390tl();
        }
        return f7238j;
    }

    public final void m9732b(ArrayList arrayList, int i, String str) {
        ArrayList arrayListMo9040g;
        int size;
        DataSource dataSource = (DataSource) C2275r7.m9348e().m9352d(str);
        if (dataSource == null || (arrayListMo9040g = dataSource.mo9040g()) == null || (size = arrayListMo9040g.size()) <= 0) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            C2476vf c2476vf = (C2476vf) arrayListMo9040g.get(this.f7247h.nextInt(size));
            if (!arrayList.contains(c2476vf)) {
                arrayList.add(c2476vf);
                i2++;
            }
            if (i2 >= i) {
                return;
            }
        }
    }

    public final void m9733c(ArrayList arrayList, int i) {
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("search_his", DatabaseColumns.SEARCH_HISTORY, null, null, null, null, "last_search DESC", i + "");
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("key_words"));
                        C2476vf c2476vf = new C2476vf();
                        c2476vf.f7676a = 1;
                        c2476vf.f7677b = string;
                        arrayList.add(c2476vf);
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final C2476vf m9734d(String str, String str2) {
        ArrayList arrayListMo9040g;
        DataSource dataSource = (DataSource) C2275r7.m9348e().m9352d(str2);
        if (dataSource == null || (arrayListMo9040g = dataSource.mo9040g()) == null) {
            return null;
        }
        for (int i = 0; i < arrayListMo9040g.size(); i++) {
            C2476vf c2476vf = (C2476vf) arrayListMo9040g.get(i);
            if (c2476vf.f7677b.equals(str)) {
                return c2476vf;
            }
        }
        return null;
    }

    public C2476vf m9735e(String str) {
        C2476vf c2476vfM9734d = m9734d(str, "browser.hotword.baidu_std");
        return c2476vfM9734d == null ? m9734d(str, "browser.hotword.baidu_ad") : c2476vfM9734d;
    }

    public ArrayList m9736g() {
        ArrayList arrayList = new ArrayList<>();
        m9733c(arrayList, 5);
        return arrayList;
    }

    public ArrayList m9737h() {
        ArrayList arrayList = new ArrayList<>();
        m9743n(arrayList);
        return arrayList;
    }

    public final String m9738i(String str) {
        String str2 = !PhoneUtils.getInstance().isInChina() ? "http://sugg.search.yahoo.net/sg/?output=json&nresults=10&command=%wd%" : "https://suggestion.baidu.com/su?from=1013843g&wd=%wd%&json=1";
        try {
            if (str.indexOf("\\") >= 0) {
                str = str.replaceAll("\\\\", "");
            }
            return str2.replaceAll("%wd%", str);
        } catch (Exception unused) {
            return str2;
        }
    }

    public void init() {
        this.f7247h = new Random();
        m9741l();
        m9740k();
        this.f7248i = new OkHttpClient();
    }

    public final void m9740k() {
        C2277r9 c2277r9 = new C2277r9(true);
        c2277r9.mo9036a("http://top.baidu.com/mobile_v2/buzz/hotspot");
        c2277r9.mo9038d("browser.hotword.baidu_std");
        C2275r7.m9348e().m9357j(c2277r9);
        C2231q9 c2231q9 = new C2231q9(true);
        c2231q9.mo9036a("http://m.hao123.com/hao123_api/api/cpc/cms/?tn=1013843g");
        c2231q9.mo9038d("browser.hotword.baidu_ad");
        C2275r7.m9348e().m9357j(c2231q9);
        C2507w9 c2507w9 = new C2507w9(true);
        c2507w9.mo9036a("http://trends.mobitech-search.xyz/mobitech/trends?p_key=FSTMINBR8513CE34&user_id=%user_id%&c=%country%");
        c2507w9.mo9038d("browser.hotword.global");
        C2275r7.m9348e().m9357j(c2507w9);
    }

    public final void m9741l() {
        InterfaceC2183p7 c0102c9;
        String str;
        if (PhoneUtils.getInstance().getLocaleCode().equals("zh-CN")) {
            c0102c9 = new C2323s9(true);
            c0102c9.mo9036a("https://suggestion.baidu.com/su?from=1013843g&wd=%wd%&json=1");
            str = "browser.sug.baidu";
        } else {
            c0102c9 = new C0102C9(true);
            c0102c9.mo9036a("http://sugg.search.yahoo.net/sg/?output=json&nresults=10&command=%wd%");
            str = "browser.sug.bing";
        }
        c0102c9.mo9038d(str);
        C2275r7.m9348e().m9357j(c0102c9);
    }

    public final ArrayList m9742m(String str, String str2) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        int i = 0;
        try {
            if (str2.indexOf("suggestion.baidu.com") >= 0) {
                Matcher matcher = f7239k.matcher(str);
                String strGroup = matcher.matches() ? matcher.group(1) : null;
                if (strGroup != null) {
                    JSONArray jSONArray = new JSONObject(strGroup).getJSONArray("s");
                    while (i < jSONArray.length()) {
                        String string = jSONArray.getString(i);
                        C2476vf c2476vf = new C2476vf();
                        c2476vf.f7677b = string;
                        arrayList.add(c2476vf);
                        i++;
                    }
                }
            } else if (str2.indexOf("sugg.search.yahoo.net") >= 0 && str != null) {
                JSONArray jSONArray2 = new JSONObject(str).getJSONObject("gossip").getJSONArray("results");
                while (i < jSONArray2.length()) {
                    String string2 = jSONArray2.getJSONObject(i).getString("key");
                    C2476vf c2476vf2 = new C2476vf();
                    c2476vf2.f7677b = string2;
                    arrayList.add(c2476vf2);
                    i++;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void m9743n(ArrayList arrayList) {
        if (SharedPreferencesHelper.getInstance().disableSearchBarHotword) {
            return;
        }
        if (PhoneUtils.getInstance().isInChina()) {
            m9732b(arrayList, 5, "browser.hotword.baidu_std");
            m9732b(arrayList, 1, "browser.hotword.baidu_ad");
        } else {
            m9732b(arrayList, 7, "browser.hotword.global");
        }
        Collections.sort(arrayList, new b());
    }

    public void m9744o(String str, c cVar) {
        String strM9738i = m9738i(str);
        Request.Builder builderVarM507I = new Request.Builder().url(strM9738i);
        builderVarM507I.addHeader("User-Agent", SharedPreferencesHelper.defaultUserAgent);
        this.f7248i.newCall(builderVarM507I.m500b()).mo1791i(new a(cVar, strM9738i));
    }
}
