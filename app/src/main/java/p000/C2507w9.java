package p000;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2507w9 extends AbstractC2221q {
    public C2507w9(boolean z) {
        super(z);
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        String str = (String) obj;
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    C2476vf c2476vf = new C2476vf();
                    c2476vf.f7677b = jSONObject.getString("keyword");
                    c2476vf.f7678c = jSONObject.getString("clickUrl");
                    arrayList.add(c2476vf);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
