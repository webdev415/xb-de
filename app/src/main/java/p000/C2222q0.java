package p000;

import android.content.ContentValues;
import android.database.Cursor;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.provider.BrowserProvider;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C2222q0 extends AbstractResourceManager {
    public C2222q0(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() {
        return m9090y().toString();
    }

    @Override
    public String getKey() {
        return "sync_tag_custom_ad_rule";
    }

    @Override
    public void saveToLocal(String str) throws JSONException {
        JSONArray jSONArrayM9090y = m9090y();
        HashMap map = new HashMap<>();
        for (int i = 0; i < jSONArrayM9090y.length(); i++) {
            try {
                JSONObject jSONObject = jSONArrayM9090y.getJSONObject(i);
                map.put(jSONObject.getString("rule_hash"), jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                String string = jSONObject2.getString("rule_hash");
                if (map.containsKey(string)) {
                    JsonUtils.copyJSONObject(jSONObject2, (JSONObject) map.get(string));
                } else {
                    jSONArrayM9090y.put(jSONObject2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        m9089x(jSONArrayM9090y);
    }

    @Override
    public void loadFromRemote(String str) {
        m9089x(new JSONArray(str));
    }

    public final void m9089x(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                ContentValues contentValues = new ContentValues();
                contentValues.put("rule_hash", jSONObject.getString("rule_hash"));
                contentValues.put("rule_data", jSONObject.getString("rule_data"));
                contentValues.put("host", jSONObject.getString("host"));
                contentValues.put("extra", jSONObject.getString("extra"));
                contentValues.put("rule_type", Integer.valueOf(jSONObject.getInt("rule_type")));
                contentValues.put("hit_times", Integer.valueOf(jSONObject.getInt("hit_times")));
                MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        MySQLiteOpenHelper.getInstance().insertOrReplaceEntries("ad_block_rule", true);
    }

    public final JSONArray m9090y() {
        Cursor cursorQuery = BrowserActivity.getActivity().getContentResolver().query(BrowserProvider.uriAdBlockRule, null, null, null, null);
        JSONArray jSONArray = new JSONArray();
        if (cursorQuery != null) {
            try {
                try {
                    cursorQuery.moveToFirst();
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rule_hash"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("rule_data"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("host"));
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("rule_type"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("hit_times"));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("rule_hash", string);
                        jSONObject.put("rule_data", string2);
                        if (string3 == null) {
                            string3 = "";
                        }
                        jSONObject.put("extra", string3);
                        jSONObject.put("rule_type", i);
                        jSONObject.put("hit_times", i2);
                        jSONObject.put("host", string4);
                        jSONArray.put(jSONObject);
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return jSONArray;
    }
}
