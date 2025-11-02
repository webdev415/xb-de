package p000;

import android.content.ContentValues;
import android.database.Cursor;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.provider.BrowserProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C2244qd extends AbstractResourceManager {
    public C2244qd(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() {
        return m9153x().toString();
    }

    @Override
    public String getKey() {
        return "sync_tag_setting";
    }

    @Override
    public void saveToLocal(String str) throws JSONException {
        loadFromRemote(str);
    }

    @Override
    public void loadFromRemote(String str) throws JSONException {
        m9154y(new JSONArray(str));
    }

    public final JSONArray m9153x() {
        Cursor cursorQuery = BrowserActivity.getActivity().getContentResolver().query(BrowserProvider.uriHostList, null, null, null, null);
        JSONArray jSONArray = new JSONArray();
        try {
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("host"));
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("host_type"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("host", string);
                        jSONObject.put("host_type", i);
                        jSONObject.put("extra", string2);
                        jSONArray.put(jSONObject);
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return jSONArray;
        } finally {
            cursorQuery.close();
        }
    }

    public final void m9154y(JSONArray jSONArray) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                ContentValues contentValues = new ContentValues();
                contentValues.put("host", jSONObject.getString("host"));
                contentValues.put("host_type", Integer.valueOf(jSONObject.getInt("host_type")));
                contentValues.put("extra", jSONObject.getString("extra"));
                MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        MySQLiteOpenHelper.getInstance().insertOrReplaceEntries("host_list", true);
    }
}
