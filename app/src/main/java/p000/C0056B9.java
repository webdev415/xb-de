package p000;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C0056B9 extends AbstractC2221q {
    @Override
    public String mo61f() {
        return "browser.sug.topsite";
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        if (i == 1) {
            JSONArray jSONArray = new JSONArray((String) obj);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                C0447Jn c0447Jn = new C0447Jn();
                c0447Jn.m2070a(jSONObject.getString("title"));
                c0447Jn.m2071b(jSONObject.getString("url"));
                arrayList.add(c0447Jn);
            }
        }
        return arrayList;
    }
}
