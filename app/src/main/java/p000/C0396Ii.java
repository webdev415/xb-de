package p000;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0396Ii extends AbstractResourceManager {
    public C0396Ii(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() {
        return C0600N1.m3257k().m3266o("auto_fill_passwd");
    }

    @Override
    public String getKey() {
        return "sync_tag_autofill";
    }

    @Override
    public void saveToLocal(String str) throws JSONException {
        String strM3266o = C0600N1.m3257k().m3266o("auto_fill_passwd");
        JSONArray jSONArray = new JSONArray(strM3266o);
        JSONArray jSONArray2 = new JSONArray(str);
        HashMap map = new HashMap<>();
        for (int i = 0; i < strM3266o.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                map.put(jSONObject.getString("s_id"), jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                String strM3666k = JsonUtils.getString(jSONObject2, "s_id", "");
                if (map.containsKey(strM3666k)) {
                    JsonUtils.copyJSONObject(jSONObject2, (JSONObject) map.get(strM3666k));
                } else {
                    jSONArray.put(jSONObject2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        loadFromRemote(jSONArray.toString());
    }

    @Override
    public void loadFromRemote(String str) {
        C0600N1.m3257k().m3270s("auto_fill_passwd", new JSONArray(str));
        C0600N1.m3257k().m3266o("auto_fill_passwd");
    }
}
