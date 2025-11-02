package p000;

import android.content.Context;
import android.content.res.Resources;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C0741Q4 extends AbstractC2175p {

    public class a implements Runnable {
        public a() {
        }

        @Override
        public void run() throws Resources.NotFoundException {
            boolean zM6873Q = SharedPreferencesHelper.getInstance().getBoolean("open-review-btn", false);
            int iM6869O = SharedPreferencesHelper.getInstance().getInt("app_launch_times", 1);
            if (zM6873Q || iM6869O % 7 != 0) {
                return;
            }
            C2439uo.getInstance().m10217O();
        }
    }

    @Override
    public void mo3474a(Context context, C2273r5 c2273r5) throws JSONException {
        if (c2273r5.f6871b != null) {
            try {
                JSONObject jSONObject = new JSONObject(c2273r5.f6871b);
                String string = jSONObject.getString("action");
                if (string.equals("request_user_review")) {
                    BrowserActivity.getActivity().runOnUiThread(new a());
                } else if (string.equals("reset-default-key")) {
                    String strM3665j = JsonUtils.getString(jSONObject, "target_key");
                    if (SharedPreferencesHelper.getInstance().getString(strM3665j, "").indexOf(JsonUtils.getString(jSONObject, "match_value")) >= 0) {
                        SharedPreferencesHelper.getInstance().putString(strM3665j, "");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
