package p000;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.mmbox.widget.messagebox.C1418a;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.xbrowser.play.R;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C0600N1 {

    public static C0600N1 f1880d;

    public BrowserActivity f1881a = null;

    public JSONArray f1882b = null;

    public JSONArray f1883c = null;

    public static C0600N1 m3257k() {
        if (f1880d == null) {
            f1880d = new C0600N1();
        }
        return f1880d;
    }

    public final void m3258f(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (((obj instanceof String) && !((String) obj).isEmpty()) || (obj instanceof Long)) {
                jSONObject2.put(next, obj);
            }
        }
    }

    public final void m3259g(String str) throws JSONException {
        if (str.equals("auto_fill_passwd")) {
            String strM6767C0 = ((WebViewBrowserController) ((InterfaceC1300b3) this.f1881a.m6222J0().m9316y())).m6767C0();
            if (!TextUtils.isEmpty(strM6767C0)) {
                for (int i = 0; i < this.f1882b.length(); i++) {
                    JSONObject jSONObject = this.f1882b.getJSONObject(i);
                    String strM3666k = JsonUtils.getString(jSONObject, "s_id", "");
                    String strM3666k2 = JsonUtils.getString(jSONObject, "host", "");
                    if (TextUtils.isEmpty(strM3666k)) {
                        jSONObject.put("s_id", AndroidSystemUtils.m8713u());
                    }
                    if (strM3666k2.indexOf(strM6767C0) >= 0) {
                        this.f1883c.put(new JSONObject(jSONObject.toString()));
                    }
                }
                return;
            }
        }
        this.f1883c = this.f1882b;
    }

    public void m3260h() throws JSONException, IOException {
        if (Build.VERSION.SDK_INT < 29 && !BrowserActivity.getActivity().m6285Z("android.permission.WRITE_EXTERNAL_STORAGE")) {
            BrowserActivity.getActivity().m6290a0();
            return;
        }
        String str = "passwd_auto_fill_" + AndroidSystemUtils.m8667A(System.currentTimeMillis()) + ".csv";
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + str;
        String strM2046a = ResourceCacheManager.getInstance().m2046a(str2, 1);
        try {
            m3266o("auto_fill_passwd");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(strM2046a));
            bufferedWriter.write("name,url,username,password,note");
            bufferedWriter.newLine();
            for (int i = 0; i < this.f1882b.length(); i++) {
                JSONObject jSONObject = this.f1882b.getJSONObject(i);
                bufferedWriter.write(JsonUtils.getString(jSONObject, "host", "") + ',' + JsonUtils.getString(jSONObject, "login_url", "") + ',' + JsonUtils.getString(jSONObject, "login_name", "") + ',' + JsonUtils.getString(jSONObject, "password", "") + ',' + JsonUtils.getString(jSONObject, "remark", ""));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            if (Build.VERSION.SDK_INT >= 29) {
                Uri uriM8704l = AndroidSystemUtils.m8704l(this.f1881a, str, "text/csv", "");
                if (uriM8704l != null) {
                    AndroidSystemUtils.m8698f(this.f1881a, strM2046a, uriM8704l);
                }
            } else {
                AndroidSystemUtils.m8699g(strM2046a, str2);
            }
            C2439uo.getInstance().m10216N(str2);
        } catch (Exception unused) {
        }
    }

    public final JSONObject m3261i(JSONArray jSONArray, String str, String str2) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (JsonUtils.getString(jSONObject, str, "").equals(str2)) {
                return jSONObject;
            }
        }
        return null;
    }

    public String m3262j(String str) {
        return this.f1881a.getFilesDir().getAbsolutePath() + "/" + str;
    }

    public final boolean m3263l(JSONArray jSONArray, String str, String str2) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String strM3666k = JsonUtils.getString(jSONObject, "login_url", "");
            String strM3666k2 = JsonUtils.getString(jSONObject, "login_name", "");
            if (strM3666k.equals(str) && strM3666k2.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void m3264m(String str) {
        if (Build.VERSION.SDK_INT < 29 && !BrowserActivity.getActivity().m6285Z("android.permission.WRITE_EXTERNAL_STORAGE")) {
            BrowserActivity.getActivity().m6290a0();
            return;
        }
        m3266o("auto_fill_passwd");
        m3262j("auto_fill_passwd");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            int i = 0;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    m3270s("auto_fill_passwd", this.f1882b);
                    Toast.makeText(this.f1881a, String.format(this.f1881a.getString(R.string.toast_import_passwd), Integer.valueOf(i)), Toast.LENGTH_SHORT).show();
                    this.f1881a.m6361u0("nav_call_reload_passwd_auto_fill()");
                    C1089Xm.getInstance().m4822j("syncable_passwd_autofill").incrementVersion();
                    return;
                }
                if (line.indexOf("username") <= 0 || line.indexOf("password") <= 0) {
                    String[] strArrSplit = line.split(",");
                    if (strArrSplit.length >= 4) {
                        String host = strArrSplit[0];
                        if (host.startsWith("http")) {
                            host = Uri.parse(host).getHost();
                        }
                        String str2 = strArrSplit[1];
                        String str3 = strArrSplit[2];
                        if (!m3263l(this.f1882b, str2, str3)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("s_id", AndroidSystemUtils.m8713u());
                            jSONObject.put("host", host);
                            jSONObject.put("login_url", strArrSplit[1]);
                            jSONObject.put("login_name", str3);
                            jSONObject.put("password", strArrSplit[3]);
                            if (strArrSplit.length == 5) {
                                jSONObject.put("remark", strArrSplit[4]);
                            }
                            this.f1882b.put(jSONObject);
                            i++;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void m3265n(BrowserActivity browserActivity) {
        this.f1881a = browserActivity;
    }

    public String m3266o(String str) {
        try {
            String strM3262j = m3262j(str);
            this.f1882b = new JSONArray(FileUtils.fileExists(strM3262j) ? FileUtils.readFileToString(strM3262j) : "[]");
            this.f1883c = new JSONArray();
            m3259g(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.f1883c.toString();
    }

    public void m3267p(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            m3271t(JsonUtils.getString(jSONObject, "auto_fill_type", "auto_fill_passwd"), jSONObject, this.f1882b, true);
        } catch (Exception unused) {
        }
    }

    public void m3268q(String str, String str2) {
        C1089Xm c1089XmM4819i;
        String str3;
        try {
            m3266o(str);
            m3269r(this.f1882b, "s_id", str2);
            if (str.equals("auto_fill_passwd")) {
                c1089XmM4819i = C1089Xm.getInstance();
                str3 = "syncable_passwd_autofill";
            } else {
                if (!str.equals("auto_fill_card")) {
                    if (str.equals("auto_fill_addr")) {
                        c1089XmM4819i = C1089Xm.getInstance();
                        str3 = "syncable_addr_autofill";
                    }
                    m3270s(str, this.f1882b);
                }
                c1089XmM4819i = C1089Xm.getInstance();
                str3 = "syncable_card_autofill";
            }
            c1089XmM4819i.m4822j(str3).incrementVersion();
            m3270s(str, this.f1882b);
        } catch (Exception unused) {
        }
    }

    public final void m3269r(JSONArray jSONArray, String str, String str2) {
        int i = 0;
        while (true) {
            if (i >= jSONArray.length()) {
                i = -1;
                break;
            } else if (JsonUtils.getString(jSONArray.getJSONObject(i), str, "").equals(str2)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            jSONArray.remove(i);
        }
    }

    public void m3270s(String str, JSONArray jSONArray) {
        FileUtils.writeBytesToFile(jSONArray.toString().getBytes(StandardCharsets.UTF_8), m3262j(str));
    }

    public final void m3271t(String str, JSONObject jSONObject, JSONArray jSONArray, boolean z) throws JSONException {
        C1089Xm c1089XmM4819i;
        String str2;
        if (str.equals("auto_fill_passwd")) {
            m3274w(jSONObject, z);
            return;
        }
        if (str.equals("auto_fill_card")) {
            m3273v(jSONObject);
            c1089XmM4819i = C1089Xm.getInstance();
            str2 = "syncable_card_autofill";
        } else {
            if (!str.equals("auto_fill_addr")) {
                return;
            }
            m3272u(jSONObject);
            c1089XmM4819i = C1089Xm.getInstance();
            str2 = "syncable_addr_autofill";
        }
        c1089XmM4819i.m4822j(str2).incrementVersion();
    }

    public final void m3272u(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectM3261i = m3261i(this.f1882b, "s_id", JsonUtils.getString(jSONObject, "s_id", ""));
        if (jSONObjectM3261i != null) {
            m3258f(jSONObject, jSONObjectM3261i);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            m3258f(jSONObject, jSONObject2);
            this.f1882b.put(jSONObject2);
        }
        m3270s("auto_fill_addr", this.f1882b);
    }

    public final void m3273v(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectM3261i = m3261i(this.f1882b, "s_id", JsonUtils.getString(jSONObject, "s_id", ""));
        if (jSONObjectM3261i != null) {
            m3258f(jSONObject, jSONObjectM3261i);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            m3258f(jSONObject, jSONObject2);
            this.f1882b.put(jSONObject2);
        }
        m3270s("auto_fill_card", this.f1882b);
    }

    public final void m3274w(JSONObject jSONObject, boolean z) throws JSONException {
        String strM3666k = JsonUtils.getString(jSONObject, "s_id", "");
        String strM3666k2 = JsonUtils.getString(jSONObject, "host", "");
        String strM3666k3 = JsonUtils.getString(jSONObject, "login_name", "");
        String strM3666k4 = JsonUtils.getString(jSONObject, "password", "");
        JSONObject jSONObjectM3261i = m3261i(this.f1882b, "s_id", strM3666k);
        if (jSONObjectM3261i != null) {
            if (z) {
                JSONObject jSONObjectM3261i2 = m3261i(this.f1883c, "login_name", strM3666k3);
                if (jSONObjectM3261i2 == null) {
                    this.f1881a.runOnUiThread(new a(strM3666k, jSONObjectM3261i, strM3666k3, jSONObject));
                } else {
                    String strM3666k5 = JsonUtils.getString(jSONObjectM3261i2, "password", "");
                    if (!strM3666k4.equals(strM3666k5)) {
                        this.f1881a.runOnUiThread(new b(jSONObjectM3261i, strM3666k5));
                    }
                }
            }
            m3258f(jSONObject, jSONObjectM3261i);
        } else {
            JSONObject jSONObjectM3261i3 = m3261i(this.f1882b, "login_name", strM3666k3);
            if (jSONObjectM3261i3 != null && JsonUtils.getString(jSONObjectM3261i3, "host", "").equals(strM3666k2)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            m3258f(jSONObject, jSONObject2);
            this.f1882b.put(jSONObject2);
        }
        m3270s("auto_fill_passwd", this.f1882b);
    }

    public void m3275x(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            m3271t(JsonUtils.getString(jSONObject, "auto_fill_type", "auto_fill_passwd"), jSONObject, this.f1882b, false);
        } catch (Exception unused) {
        }
    }

    public class a implements Runnable {

        public final String f1884l;

        public final JSONObject f1885m;

        public final String f1886n;

        public final JSONObject f1887o;

        public a(String str, JSONObject jSONObject, String str2, JSONObject jSONObject2) {
            this.f1884l = str;
            this.f1885m = jSONObject;
            this.f1886n = str2;
            this.f1887o = jSONObject2;
        }

        @Override
        public void run() throws Resources.NotFoundException {
            C1418a.m6110b().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getResources().getString(R.string.message_auto_fill_keep_passwd), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_ok), new C2694a(), true);
        }

        public class C2694a implements MessageBoxBase.MessageBoxListener {
            public C2694a() {
            }

            @Override
            public void onShown() throws JSONException {
                try {
                    C0600N1 c0600n1 = C0600N1.this;
                    JSONObject jSONObjectM3261i = c0600n1.m3261i(c0600n1.f1883c, "s_id", a.this.f1884l);
                    if (jSONObjectM3261i == null || JsonUtils.getString(jSONObjectM3261i, "login_name", "").equals(a.this.f1886n)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    a aVar = a.this;
                    C0600N1.this.m3258f(aVar.f1887o, jSONObject);
                    jSONObject.put("s_id", AndroidSystemUtils.m8713u());
                    C0600N1.this.f1882b.put(jSONObject);
                    a aVar2 = a.this;
                    C0600N1.this.m3258f(jSONObjectM3261i, aVar2.f1885m);
                    C0600N1 c0600n12 = C0600N1.this;
                    c0600n12.m3270s("auto_fill_passwd", c0600n12.f1882b);
                } catch (Exception unused) {
                }
            }

            @Override
            public void onDismissed() {
                try {
                    C0600N1 c0600n1 = C0600N1.this;
                    JSONObject jSONObjectM3261i = c0600n1.m3261i(c0600n1.f1883c, "s_id", a.this.f1884l);
                    if (jSONObjectM3261i != null) {
                        a aVar = a.this;
                        C0600N1.this.m3258f(jSONObjectM3261i, aVar.f1885m);
                    } else {
                        C0600N1 c0600n12 = C0600N1.this;
                        c0600n12.m3269r(c0600n12.f1882b, "s_id", a.this.f1884l);
                    }
                    C0600N1 c0600n13 = C0600N1.this;
                    c0600n13.m3270s("auto_fill_passwd", c0600n13.f1882b);
                } catch (JSONException unused) {
                }
            }

            @Override
            public void onDismiss() {
            }
        }
    }

    public class b implements Runnable {

        public final JSONObject f1890l;

        public final String f1891m;

        public b(JSONObject jSONObject, String str) {
            this.f1890l = jSONObject;
            this.f1891m = str;
        }

        @Override
        public void run() throws Resources.NotFoundException {
            C1418a.m6110b().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getResources().getString(R.string.message_auto_fill_passwd_changed), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_ok), new a(), true);
        }

        public class a implements MessageBoxBase.MessageBoxListener {
            public a() {
            }

            @Override
            public void onDismissed() throws JSONException {
                try {
                    b bVar = b.this;
                    bVar.f1890l.put("password", bVar.f1891m);
                    C0600N1 c0600n1 = C0600N1.this;
                    c0600n1.m3270s("auto_fill_passwd", c0600n1.f1882b);
                } catch (JSONException unused) {
                }
            }

            @Override
            public void onShown() {
            }

            @Override
            public void onDismiss() {
            }
        }
    }
}
