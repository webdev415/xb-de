package p000;

import android.content.ContentValues;
import android.database.Cursor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C2151od extends AbstractResourceManager {
    public C2151od(String str) {
        super(str, false);
        this.isEnabled = false;
    }

    @Override
    public String getResourceValue() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("history", DatabaseColumns.HISTORY, null, null, null, null, "last_visit DESC", "2000");
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        JSONObject jSONObject = new JSONObject();
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex("last_visit"));
                        jSONObject.put("title", string);
                        jSONObject.put("url", string2);
                        jSONObject.put("last_visit", j);
                        jSONArray.put(jSONObject);
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray.toString();
    }

    @Override
    public void applyResource(String str, boolean z) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", jSONObject.getString("title"));
                contentValues.put("url", jSONObject.getString("url"));
                contentValues.put("last_visit", jSONObject.getString("last_visit"));
                MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues);
            }
            MySQLiteOpenHelper.getInstance().insertOrReplaceEntries("history", !z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getKey() {
        return "histories";
    }

    @Override
    public void saveToLocal(String str) {
    }

    @Override
    public void loadFromRemote(String str) {
    }
}
