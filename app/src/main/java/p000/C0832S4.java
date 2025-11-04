package p000;

import android.content.Context;
import android.database.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0832S4 implements InterfaceC2319s5 {
    @Override
    public void mo3474a(Context context, C2273r5 c2273r5) throws JSONException, SQLException {
        if (c2273r5.f6871b != null) {
            try {
                JSONObject jSONObject = new JSONObject(c2273r5.f6871b);
                String string = jSONObject.getString("table_name");
                JSONArray jSONArray = jSONObject.getJSONArray("items");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    String string2 = jSONObject2.getString("key_name");
                    String string3 = jSONObject2.getString("key_value");
                    if (string3 != null) {
                        string3 = string3.trim();
                    }
                    String string4 = jSONObject2.getString("target_filed");
                    String string5 = jSONObject2.getString("new_field_value");
                    if (string5 != null) {
                        string5 = string5.trim();
                    }
                    MySQLiteOpenHelper.getInstance().getWritableDatabase().execSQL((string4.equals("*") || string4.equals("") || string5.equals("*")) ? "DELETE FROM " + string + " WHERE " + string2 + " = '" + string3 + "'" : "UPDATE " + string + " SET " + string4 + " = '" + string5 + "' WHERE " + string2 + " = '" + string3 + "'");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
