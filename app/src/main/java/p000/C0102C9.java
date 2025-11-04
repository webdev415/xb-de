package p000;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0102C9 extends DataSource {
    public C0102C9(boolean z) {
        super(z);
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        String str;
        ArrayList arrayList = new ArrayList<>();
        if (i == 1 && (str = (String) obj) != null) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONObject("gossip").getJSONArray("results");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getJSONObject(i2).getString("key");
                    C2476vf c2476vf = new C2476vf();
                    c2476vf.f7677b = string;
                    arrayList.add(c2476vf);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
