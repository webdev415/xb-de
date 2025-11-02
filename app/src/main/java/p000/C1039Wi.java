package p000;

import android.util.Log;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class C1039Wi {

    public static C1039Wi f3079g;

    public ArrayList f3080a;

    public int f3081b = 0;

    public String f3082c = null;

    public String f3083d = null;

    public String f3084e = null;

    public int f3085f = 0;

    public class a implements Runnable {

        public final String f3086l;

        public final String f3087m;

        public final String f3088n;

        public a(String str, String str2, String str3) {
            this.f3086l = str;
            this.f3087m = str2;
            this.f3088n = str3;
        }

        @Override
        public void run() {
            String strMo1573b = ((InterfaceC1300b3) BrowserActivity.getActivity().m6222J0().m9316y()).mo1573b();
            if (!C1039Wi.this.m4525r(strMo1573b)) {
                C1039Wi.this.f3082c = strMo1573b;
            }
            C1039Wi c1039Wi = C1039Wi.this;
            if (!c1039Wi.m4524q(c1039Wi.f3082c)) {
                Log.i("jslog", "push new url>>>" + C1039Wi.this.f3082c + "next_url:" + this.f3086l);
                String strM443A = NetworkUtils.stripHtmlTags(this.f3087m);
                C1039Wi c1039Wi2 = C1039Wi.this;
                c1039Wi2.m4518j(c1039Wi2.f3082c, strM443A, this.f3088n, this.f3086l);
            }
            if (C1039Wi.this.m4520l()) {
                BrowserActivity.getActivity().m6361u0("native_call_notify_got_data()");
            } else if (BrowserActivity.getActivity().m6218I0().m6394C().m1431n() != 3) {
                BrowserActivity.getActivity().m6263T1();
            } else if (C1039Wi.this.f3081b == 1) {
                C1039Wi.this.m4527t();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override
        public void run() {
            if (BrowserActivity.getActivity().m6338m1()) {
                BrowserActivity.getActivity().m6361u0("native_call_parse_content_error()");
            }
        }
    }

    public class c implements Runnable {

        public final String f3091l;

        public c(String str) {
            this.f3091l = str;
        }

        @Override
        public void run() {
            C1039Wi c1039Wi = C1039Wi.this;
            f fVarM4523o = c1039Wi.m4523o(c1039Wi.f3082c);
            if (fVarM4523o != null) {
                fVarM4523o.f3098c = this.f3091l;
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override
        public void run() throws URISyntaxException {
            BrowserActivity.getActivity().m6307d2(C1039Wi.this.f3083d);
            C1039Wi.this.f3080a.clear();
        }
    }

    public class e implements Runnable {

        public final String f3094l;

        public e(String str) {
            this.f3094l = str;
        }

        @Override
        public void run() {
            Log.i("jslog", "========>>> do preload =============");
            Log.i("jslog", this.f3094l);
            f fVarM4523o = C1039Wi.this.m4523o(this.f3094l);
            if (fVarM4523o == null) {
                fVarM4523o = C1039Wi.this.m4518j(this.f3094l, null, null, null);
            }
            if (fVarM4523o.f3099d != null || C1039Wi.this.f3085f >= 3) {
                return;
            }
            C1039Wi.this.f3082c = this.f3094l;
            C1825ha.m7824d().m7831h(0L, 52, this.f3094l, null);
            C1039Wi.m4516i(C1039Wi.this);
        }
    }

    public class f {

        public String f3096a;

        public String f3097b;

        public String f3098c;

        public String f3099d;

        public f() {
        }
    }

    public C1039Wi() {
        this.f3080a = null;
        this.f3080a = new ArrayList<>(3);
    }

    public static int m4516i(C1039Wi c1039Wi) {
        int i = c1039Wi.f3085f;
        c1039Wi.f3085f = i + 1;
        return i;
    }

    public static C1039Wi m4517p() {
        if (f3079g == null) {
            f3079g = new C1039Wi();
        }
        return f3079g;
    }

    public f m4518j(String str, String str2, String str3, String str4) {
        f fVarM4523o = m4523o(str);
        if (fVarM4523o == null) {
            fVarM4523o = new f();
            this.f3080a.add(fVarM4523o);
        }
        fVarM4523o.f3096a = str;
        fVarM4523o.f3098c = str4;
        fVarM4523o.f3097b = str2;
        fVarM4523o.f3099d = str3;
        return fVarM4523o;
    }

    public void m4519k() {
        this.f3080a.clear();
    }

    public boolean m4520l() {
        return m4525r(((InterfaceC1300b3) BrowserActivity.getActivity().m6222J0().m9316y()).mo1573b());
    }

    public void m4521m() {
        String str;
        String str2 = this.f3084e;
        if (str2 == null || (str = this.f3083d) == null) {
            return;
        }
        if (str2.equals(str)) {
            this.f3080a.clear();
        } else {
            BrowserActivity.getActivity().getHandler().postDelayed(new d(), 200L);
        }
    }

    public String m4522n() throws JSONException {
        String str;
        String string = null;
        if (this.f3080a.size() > 0) {
            f fVar = (f) this.f3080a.remove(0);
            if (fVar.f3099d != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", AndroidSystemUtils.prefixWithMd5(fVar.f3096a));
                    jSONObject.put("url", fVar.f3096a);
                    jSONObject.put("title", fVar.f3097b);
                    jSONObject.put("data", fVar.f3099d);
                    jSONObject.put("next_url", fVar.f3098c);
                    string = jSONObject.toString();
                } catch (JSONException unused) {
                }
                String str2 = fVar.f3098c;
                if (str2 != null && str2.startsWith("http")) {
                    str = fVar.f3098c;
                }
            } else {
                str = fVar.f3096a;
            }
            m4528u(str);
        }
        return string;
    }

    public final f m4523o(String str) {
        for (int i = 0; i < this.f3080a.size(); i++) {
            f fVar = (f) this.f3080a.get(i);
            if (fVar.f3096a.equals(str)) {
                return fVar;
            }
        }
        return null;
    }

    public boolean m4524q(String str) {
        f fVarM4523o = m4523o(str);
        return (fVarM4523o == null || fVarM4523o.f3099d == null) ? false : true;
    }

    public final boolean m4525r(String str) {
        if (str != null) {
            return str.indexOf("article_list_for_xb_readmode") > 0 || str.indexOf("app_users/") > 0;
        }
        return false;
    }

    public void m4526s() {
        Log.i("jslog", ">>>>>>>> parse content failed >>>>>>>>>>>>>>>");
        BrowserActivity.getActivity().runOnUiThread(new b());
    }

    public void m4527t() {
        if (this.f3080a.size() <= 0) {
            this.f3081b = 1;
            C2061mf.m8471f0().m8542n0(((WebViewBrowserController) BrowserActivity.getActivity().m6210G0()).m6770F0(), "preload");
        } else {
            String strMo1573b = ((InterfaceC1300b3) BrowserActivity.getActivity().m6222J0().m9316y()).mo1573b();
            this.f3084e = strMo1573b;
            this.f3083d = strMo1573b;
            BrowserActivity.getActivity().openUrl(ApiEndpointsManager.getInstance().getArticleListEndpoint(), true, 16);
            this.f3081b = 0;
        }
    }

    public void m4528u(String str) {
        BrowserActivity.getActivity().runOnUiThread(new e(str));
    }

    public void m4529v(String str, String str2, String str3) {
        BrowserActivity.getActivity().runOnUiThread(new a(str3, str, str2));
    }

    public void m4530w(String str) {
        this.f3083d = str;
    }

    public void m4531x(String str) {
        this.f3085f = 0;
        m4528u(str);
    }

    public void m4532y(String str) {
        BrowserActivity.getActivity().runOnUiThread(new c(str));
    }
}
