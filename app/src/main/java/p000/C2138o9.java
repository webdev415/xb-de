package p000;

import android.content.ContentValues;
import android.database.SQLException;
import com.mmbox.xbrowser.provider.BrowserProvider;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2138o9 extends DataSource {
    @Override
    public String mo8842b() {
        return "browser.ad_rule";
    }

    @Override
    public String mo61f() {
        return "browser.ad_rule";
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException, SQLException {
        ArrayList arrayList = new ArrayList<>();
        if (i == 1) {
            JSONArray jSONArray = new JSONArray((String) obj);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                C2176p0 c2176p0 = new C2176p0();
                c2176p0.f6608a = jSONObject.getInt("rule_type");
                c2176p0.f6609b = jSONObject.getString("rule_data");
                arrayList.add(c2176p0);
            }
        }
        MySQLiteOpenHelper.getInstance().m7492E0();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            m8843m((C2176p0) arrayList.get(i3));
        }
        return arrayList;
    }

    public final void m8843m(C2176p0 c2176p0) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("rule_type", Integer.valueOf(c2176p0.f6608a));
        contentValues.put("rule_data", c2176p0.f6609b);
        contentValues.put("rule_hash", AbstractCryptoUtils.toMd5(c2176p0.f6609b));
        m9087k().getContentResolver().insert(BrowserProvider.uriAdBlockRule, contentValues);
    }
}
