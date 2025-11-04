package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0010A9 extends DataSource {
    @Override
    public String mo61f() {
        return "browser.resource_map";
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        if (i == 1) {
            JSONArray jSONArray = new JSONArray((String) obj);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                C0398Ik c0398Ik = new C0398Ik();
                c0398Ik.f1199a = jSONObject.getString("resource_key");
                c0398Ik.f1200b = jSONObject.getString("resource_value");
                c0398Ik.f1201c = jSONObject.getInt("resource_type");
                arrayList.add(c0398Ik);
                m64n(c0398Ik);
                m63m(c0398Ik.f1199a);
            }
        }
        return arrayList;
    }

    public final void m63m(String str) throws JSONException {
        if (!str.equals("proxy_node") && str.equals("url_icon_maps")) {
            ResourceCacheManager.getInstance().mapIconsFromJson();
        }
    }

    public final void m64n(C0398Ik c0398Ik) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("resource_key", c0398Ik.f1199a);
        contentValues.put("resource_value", c0398Ik.f1200b);
        contentValues.put("resource_type", Integer.valueOf(c0398Ik.f1201c));
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        if (m65o(c0398Ik, writableDatabase) < 0) {
            writableDatabase.insert("resource_map", null, contentValues);
        }
    }

    public final long m65o(C0398Ik c0398Ik, SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = sQLiteDatabase.query("resource_map", DatabaseColumns.RESOURCE_MAP, "resource_key= ?", new String[]{c0398Ik.f1199a}, null, null, null);
        if (cursorQuery == null) {
            return -1L;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                return -1L;
            }
            long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
            ContentValues contentValues = new ContentValues();
            contentValues.put("resource_value", c0398Ik.f1200b);
            sQLiteDatabase.update("resource_map", contentValues, "_id=" + j, null);
            return j;
        } finally {
            cursorQuery.close();
        }
    }
}
