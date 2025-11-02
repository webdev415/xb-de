package p000;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2231q9 extends AbstractC2221q {
    public C2231q9(boolean z) {
        super(z);
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        String str;
        ArrayList arrayList = new ArrayList<>();
        if (i == 1 && (str = (String) obj) != null) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    C2476vf c2476vf = new C2476vf();
                    c2476vf.f7677b = jSONObject.getString("title");
                    c2476vf.f7678c = jSONObject.getString("curl");
                    arrayList.add(c2476vf);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
