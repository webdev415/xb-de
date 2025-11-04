package p000;

import com.mmbox.xbrowser.BrowserActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class C1199a3 implements InterfaceC1671e7, InterfaceC0028Ai {

    public static C1199a3 f3483d;

    public BrowserActivity f3484a;

    public InterfaceC1671e7 f3485b;

    public InterfaceC0028Ai f3486c;

    public class a implements Runnable {

        public final JSONObject f3487l;

        public a(JSONObject jSONObject) {
            this.f3487l = jSONObject;
        }

        @Override
        public void run() {
            C1199a3.this.f3486c.mo135a(this.f3487l);
        }
    }

    public static final C1199a3 getInstance() {
        if (f3483d == null) {
            f3483d = new C1199a3();
        }
        return f3483d;
    }

    @Override
    public void mo135a(JSONObject jSONObject) {
        this.f3486c.mo135a(jSONObject);
    }

    @Override
    public String mo5091b(String str) {
        return this.f3485b.mo5091b(str);
    }

    @Override
    public void mo5092c(String str, String str2) {
        this.f3485b.mo5092c(str, str2);
    }

    public void m5093d(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("transId", str2);
            m5094e(str, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void m5094e(String str, JSONObject jSONObject) {
        if (str.equals("event_app_to_page")) {
            String strQuote = JSONObject.quote(jSONObject.toString());
            this.f3484a.updateTitle("_XAPP_.dispatchEvent('" + str + "'," + strQuote + ")");
        } else if (str.equals("event_page_to_app")) {
            this.f3484a.runOnUiThread(new a(jSONObject));
        }
    }

    public final void init(BrowserActivity browserActivity) {
        this.f3484a = browserActivity;
        this.f3486c = new C0074Bi(browserActivity);
        this.f3485b = new C1718f7(browserActivity);
    }

    public void m5096h(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("transId", "option_changed");
            jSONObject.put("selectedOptionName", C1224ai.getInstance().m5297m(str));
            getInstance().m5094e("event_app_to_page", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void m5097i(String str) {
        m5093d("event_app_to_page", str);
    }

    public void m5098j(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transId", str);
            jSONObject.put(str2, str3);
            m5094e("event_app_to_page", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
