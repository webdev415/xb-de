package p000;

import android.content.ContentValues;
import android.util.Log;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.provider.BrowserProvider;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2645z9 extends DataSource {
    @Override
    public String mo8842b() {
        return "browser.qa";
    }

    @Override
    public String mo61f() {
        return "browser.qa";
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        if (i == 1) {
            JSONArray jSONArray = new JSONArray((String) obj);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                C0259Fj c0259Fj = new C0259Fj();
                c0259Fj.m1267e(jSONObject.getString("title"));
                c0259Fj.m1269g(jSONObject.getString("url"));
                c0259Fj.m1266d(jSONObject.getString("guid"));
                c0259Fj.m1265c(jSONObject.getString("created_at"));
                c0259Fj.m1268f(jSONObject.getString("updated_at"));
                arrayList.add(c0259Fj);
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            m10992m((C0259Fj) arrayList.get(i3));
        }
        if (BrowserActivity.getActivity() != null) {
            BrowserActivity.getActivity().refreshQuickAccessUI();
        }
        return arrayList;
    }

    public final void m10992m(C0259Fj c0259Fj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", c0259Fj.m1263a());
        contentValues.put("url", c0259Fj.m1264b());
        Log.i("data-source", " update qa:" + contentValues);
        m9087k().getContentResolver().insert(BrowserProvider.uriQuickAccess, contentValues);
    }
}
