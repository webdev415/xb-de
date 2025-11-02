package p000;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C2599y9 extends AbstractC2221q {
    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        if (i == 1) {
            JSONObject jSONObject = new JSONObject((String) obj);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                C2615yg c2615yg = new C2615yg();
                JSONObject jSONObject2 = jSONObject.getJSONObject(itKeys.next());
                c2615yg.m10884d(jSONObject2.getString("service_code"));
                c2615yg.m10885e(jSONObject2.getString("service_url"));
                c2615yg.m10886f(jSONObject2.getString("updated_at"));
                arrayList.add(c2615yg);
            }
        }
        return arrayList;
    }
}
