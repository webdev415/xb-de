package p000;

import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2415u9 extends AbstractC2221q {
    @Override
    public String mo61f() {
        return "browser.cmd";
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException, NumberFormatException {
        ArrayList arrayList = new ArrayList<>();
        if (i == 1) {
            JSONArray jSONArray = new JSONArray((String) obj);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                C2273r5 c2273r5 = new C2273r5();
                c2273r5.f6870a = jSONObject.getString("command");
                c2273r5.f6871b = jSONObject.getString("params");
                c2273r5.f6873d = jSONObject.getString("update_id");
                arrayList.add(c2273r5);
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            m9995m((C2273r5) arrayList.get(i3));
        }
        return arrayList;
    }

    public final void m9995m(C2273r5 c2273r5) throws NumberFormatException {
        String str = c2273r5.f6870a + ".update_id";
        if (Integer.parseInt(c2273r5.f6873d) > Integer.parseInt(SharedPreferencesHelper.getInstance().getString(str, "0"))) {
            C2365t5.m9680b().m9681a(m9087k(), c2273r5);
        }
        SharedPreferencesHelper.getInstance().putString(str, c2273r5.f6873d);
    }
}
