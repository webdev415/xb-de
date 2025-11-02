package p000;

import android.text.TextUtils;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1344c1 {

    public static String f3903d;

    public static String f3904e;

    public static final C0716Pg f3905f = C0716Pg.m3567e("application/json; charset=utf-8");

    public static final OkHttpClient f3906g = new OkHttpClient();

    public static C1344c1 f3907h = null;

    public long f3909b;

    public boolean f3908a = false;

    public ArrayList f3910c = new ArrayList<>();

    public class a implements InterfaceC0556M3 {
        public a() {
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) {
            PrintStream printStream = System.out;
            printStream.println("Response code: " + c0490Kk.m2396j());
            printStream.println("Response body: " + c0490Kk.m2392a().m2714l());
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static C1344c1 m5691d() {
        if (f3907h == null) {
            f3907h = new C1344c1();
        }
        return f3907h;
    }

    public final void m5692a() throws JSONException {
        if (!this.f3908a || System.currentTimeMillis() - this.f3909b > 600000) {
            this.f3908a = true;
            m5697g();
            m5696f();
        }
        m5702l();
    }

    public final String m5693b() {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("app_uuid", null);
        if (strM6871P != null) {
            return strM6871P;
        }
        String string = UUID.randomUUID().toString();
        SharedPreferencesHelper.getInstance().putString("app_uuid", string);
        return string;
    }

    public final String m5694c() {
        String strM5602i = PhoneUtils.getInstance().getSimOrNetworkCountryCode();
        if (TextUtils.isEmpty(strM5602i)) {
            strM5602i = PhoneUtils.getInstance().getCountryCode();
        }
        return strM5602i.toUpperCase();
    }

    public void m5695e() {
        SharedPreferencesHelper sharedPreferencesHelperM6833I;
        String str;
        if (PhoneUtils.getInstance().isInChina()) {
            f3903d = "https://cnappstat.xbext.com/api/v0/count";
            sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
            str = "1qsnxlmwbl7r51bl57z18uc7bfvadm645cow9814j7u4prczh69";
        } else {
            f3903d = "https://enappstat.xbext.com/api/v0/count";
            sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
            str = "mscuezejcrsw14df192hd2p2c16f2o44918znta3uk3by2zjmi";
        }
        f3904e = sharedPreferencesHelperM6833I.getString("app_token", str);
    }

    public final void m5696f() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", "app_startup/" + PhoneUtils.getInstance().getChannelCode());
            jSONObject.put("title", "App Startup By Channel");
            jSONObject.put("event", true);
            jSONObject.put("location", m5694c());
            jSONObject.put("session", m5693b());
            this.f3910c.add(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3909b = System.currentTimeMillis();
    }

    public final void m5697g() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", "app_startup");
            jSONObject.put("title", "App Startup");
            jSONObject.put("event", true);
            jSONObject.put("location", m5694c());
            jSONObject.put("session", m5693b());
            this.f3910c.add(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3909b = System.currentTimeMillis();
    }

    public void m5698h(String str, String str2) {
        m5699i(str, str2, null);
    }

    public void m5699i(String str, String str2, String str3) {
        if (SharedPreferencesHelper.getInstance().dontUploadUserExpData) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("path", str2);
            jSONObject.put("title", str);
            jSONObject.put("event", true);
            jSONObject.put("location", m5694c());
            jSONObject.put("session", UUID.randomUUID().toString());
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("ref", "[" + NetworkUtils.getDomainFromUrl(str3) + "](" + str3 + ")");
            }
            this.f3910c.add(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3909b = System.currentTimeMillis();
        if (this.f3910c.size() >= 10 || System.currentTimeMillis() - this.f3909b > 600000) {
            m5702l();
        }
    }

    public void m5700j() {
        m5692a();
    }

    public void m5701k() {
        m5692a();
    }

    public final synchronized void m5702l() {
        try {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f3910c.size() != 0 && SharedPreferencesHelper.getInstance().acceptEula) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.f3910c.size(); i++) {
                    jSONArray.put((JSONObject) this.f3910c.get(i));
                }
                jSONObject.put("hits", jSONArray);
                AbstractC0168Dk abstractC0168DkM719e = AbstractC0168Dk.m719e(jSONObject.toString(), f3905f);
                this.f3910c.clear();
                f3906g.m2004y(new C0122Ck.a().m507i(f3903d).m499a("Authorization", "Bearer " + f3904e).m499a("Content-Type", "application/json").m499a("User-Agent", SharedPreferencesHelper.getInstance().m6849D()).m504f(abstractC0168DkM719e).m500b()).mo1791i(new a());
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
