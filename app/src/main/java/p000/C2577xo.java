package p000;

import android.text.TextUtils;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2577xo extends AbstractResourceManager {

    public class a implements Runnable {

        public final JSONArray f8028l;

        public final CountDownLatch f8029m;

        public a(JSONArray jSONArray, CountDownLatch countDownLatch) {
            this.f8028l = jSONArray;
            this.f8029m = countDownLatch;
        }

        @Override
        public void run() {
            try {
                for (int length = this.f8028l.length() - 1; length >= 0; length--) {
                    JSONObject jSONObject = this.f8028l.getJSONObject(length);
                    WebViewBrowserController webViewBrowserController = new WebViewBrowserController(BrowserActivity.getActivity(), BrowserActivity.getActivity().m6218I0());
                    String strM3666k = JsonUtils.getString(jSONObject, "id", "");
                    String strM3666k2 = JsonUtils.getString(jSONObject, "title", "");
                    String strM3666k3 = JsonUtils.getString(jSONObject, "url", "");
                    if (BrowserActivity.getActivity().m6222J0().m9281E(strM3666k) < 0 && !TextUtils.isEmpty(strM3666k) && !TextUtils.isEmpty(strM3666k3)) {
                        webViewBrowserController.m6792b1(strM3666k, strM3666k2, strM3666k3);
                        AbstractC2274r6.d dVarM9311t = BrowserActivity.getActivity().m6222J0().m9311t(webViewBrowserController, strM3666k);
                        if (dVarM9311t != null) {
                            dVarM9311t.m9324C(JsonUtils.getBoolean(jSONObject, "locked", false));
                        }
                    }
                }
                BrowserActivity.getActivity().m6218I0().mo6428g0();
            } catch (JSONException unused) {
            } catch (Throwable th) {
                this.f8029m.countDown();
                throw th;
            }
            this.f8029m.countDown();
        }
    }

    public class b implements Runnable {

        public final JSONArray f8031l;

        public final CountDownLatch f8032m;

        public b(JSONArray jSONArray, CountDownLatch countDownLatch) {
            this.f8031l = jSONArray;
            this.f8032m = countDownLatch;
        }

        @Override
        public void run() {
            try {
                int iM9280D = BrowserActivity.getActivity().m6222J0().m9280D();
                for (int i = 0; i < iM9280D; i++) {
                    String strM9283G = BrowserActivity.getActivity().m6222J0().m9283G(i);
                    AbstractC2274r6.d dVarM9282F = BrowserActivity.getActivity().m6222J0().m9282F(i);
                    if (dVarM9282F != null) {
                        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) dVarM9282F.m9333l();
                        if (interfaceC1300b3 == null) {
                            break;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", strM9283G);
                        jSONObject.put("title", interfaceC1300b3.mo1574c());
                        jSONObject.put("url", interfaceC1300b3.mo1573b());
                        jSONObject.put("locked", dVarM9282F.m9345x());
                        this.f8031l.put(jSONObject);
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f8032m.countDown();
                throw th;
            }
            this.f8032m.countDown();
        }
    }

    public C2577xo(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        JSONArray jSONArray = new JSONArray();
        BrowserActivity.getActivity().runOnUiThread(new b(jSONArray, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return jSONArray.toString();
    }

    @Override
    public void applyResource(String str, boolean z) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        BrowserActivity.getActivity().getHandler().post(new a(new JSONArray(str), countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    @Override
    public String getKey() {
        return "sync_tag_opened_tab";
    }

    @Override
    public void saveToLocal(String str) {
    }

    @Override
    public void loadFromRemote(String str) {
    }
}
