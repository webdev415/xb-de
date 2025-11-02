package p000;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2277r9 extends AbstractC2221q {
    public C2277r9(boolean z) {
        super(z);
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        if (i == 1) {
            try {
                JSONArray jSONArray = new JSONObject((String) obj).getJSONObject("result").getJSONArray("topwords");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    C2476vf c2476vf = new C2476vf();
                    c2476vf.f7677b = jSONObject.getString("keyword");
                    arrayList.add(c2476vf);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
