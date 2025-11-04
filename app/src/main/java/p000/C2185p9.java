package p000;

import com.mmbox.xbrowser.BrowserActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2185p9 extends DataSource {
    @Override
    public String mo8842b() {
        return "browser.addon";
    }

    @Override
    public String mo61f() {
        return "browser.addon";
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        JSONArray jSONArray = new JSONArray((String) obj);
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            Addon addon = new Addon();
            addon.title = jSONObject.getString("title");
            addon.intro = jSONObject.getString("intro");
            addon.id = jSONObject.getString("addon_id");
            addon.type = jSONObject.getInt("addon_type");
            addon.extPoint = jSONObject.getInt("ext_point");
        }
        if (BrowserActivity.getActivity() == null) {
            return null;
        }
        BrowserActivity.getActivity().refreshQuickAccessUI();
        return null;
    }
}
