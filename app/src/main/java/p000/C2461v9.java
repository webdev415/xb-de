package p000;

import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2461v9 extends DataSource {
    @Override
    public String mo61f() {
        return "browser.conf";
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        if (i == 1) {
            JSONArray jSONArray = new JSONArray((String) obj);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                C1202a6 c1202a6 = new C1202a6();
                c1202a6.f3489a = jSONObject.getString("attr_name");
                c1202a6.f3490b = jSONObject.getString("attr_value");
                arrayList.add(c1202a6);
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            C1202a6 c1202a62 = (C1202a6) arrayList.get(i3);
            SharedPreferencesHelper.getInstance().putString(c1202a62.f3489a, c1202a62.f3490b);
        }
        m10327m();
        SharedPreferencesHelper.getInstance().initFeecodes();
        return arrayList;
    }

    public void m10327m() {
    }
}
