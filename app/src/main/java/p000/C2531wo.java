package p000;

import android.content.ContentValues;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C2531wo extends AbstractResourceManager {
    public C2531wo(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() {
        return m10605y().toString();
    }

    @Override
    public String getKey() {
        return "sync_tag_userscript";
    }

    @Override
    public void saveToLocal(String str) throws Throwable {
        JSONArray jSONArrayM10605y = m10605y();
        HashMap map = new HashMap<>();
        for (int i = 0; i < jSONArrayM10605y.length(); i++) {
            try {
                JSONObject jSONObject = jSONArrayM10605y.getJSONObject(i);
                map.put(jSONObject.getString("script_id"), jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                String string = jSONObject2.getString("script_id");
                if (map.containsKey(string)) {
                    JsonUtils.copyJSONObject(jSONObject2, (JSONObject) map.get(string));
                } else {
                    jSONArrayM10605y.put(jSONObject2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        m10604x(jSONArrayM10605y);
    }

    @Override
    public void loadFromRemote(String str) {
        m10604x(new JSONArray(str));
    }

    public final void m10604x(JSONArray jSONArray) {
        String str = "auto_run_at";
        String str2 = "version";
        String str3 = "include_script";
        String str4 = "title";
        int i = 0;
        String str5 = "status";
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                int i2 = i;
                ContentValues contentValues = new ContentValues();
                contentValues.put("script_id", jSONObject.getString("script_id"));
                contentValues.put(str4, jSONObject.getString(str4));
                String str6 = str4;
                contentValues.put("script_desc", JsonUtils.getString(jSONObject, "script_desc", null));
                contentValues.put("script_data", jSONObject.getString("script_data"));
                contentValues.put("ex_point", jSONObject.getString("ex_point"));
                contentValues.put(str3, JsonUtils.getString(jSONObject, str3, null));
                contentValues.put(str2, JsonUtils.getString(jSONObject, str2, null));
                String strM3666k = JsonUtils.getString(jSONObject, "icon_url", null);
                String str7 = str2;
                String strM3666k2 = JsonUtils.getString(jSONObject, "resources", null);
                String str8 = str3;
                String strM3666k3 = JsonUtils.getString(jSONObject, "source", null);
                contentValues.put("icon_url", strM3666k);
                contentValues.put("resources", strM3666k2);
                contentValues.put("source", strM3666k3);
                contentValues.put("exclude", JsonUtils.getString(jSONObject, "exclude", null));
                contentValues.put("create_by", JsonUtils.getString(jSONObject, "create_by", null));
                contentValues.put("create_at", Long.valueOf(jSONObject.getLong("create_at")));
                str = str;
                contentValues.put(str, Integer.valueOf(jSONObject.getInt(str)));
                String str9 = str5;
                contentValues.put(str9, Integer.valueOf(jSONObject.getInt(str9)));
                MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues);
                C2061mf.m8471f0().m8555u(strM3666k);
                C2061mf.m8471f0().m8558w(strM3666k2);
                i = i2 + 1;
                str5 = str9;
                str4 = str6;
                str2 = str7;
                str3 = str8;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        MySQLiteOpenHelper.getInstance().insertOrReplaceEntries("user_script", true);
    }

    public final JSONArray m10605y() throws Throwable {
        JSONArray jSONArray;
        Cursor cursor;
        String str;
        String str2 = "source";
        String str3 = "create_by";
        String str4 = "version";
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("user_script", DatabaseColumns.USER_SCRIPT, null, null, null, null, null);
        String str5 = "auto_run_at";
        JSONArray jSONArray2 = new JSONArray();
        if (cursorQuery != null) {
            JSONArray jSONArray3 = jSONArray2;
            try {
                try {
                    String str6 = "status";
                    if (Build.VERSION.SDK_INT >= 28) {
                        AbstractC2015lf.m8396a();
                        str = "create_at";
                        ((AbstractWindowedCursor) cursorQuery).setWindow(AbstractC1969kf.m8296a("bigwindow", 5242880L));
                    } else {
                        str = "create_at";
                    }
                    cursorQuery.moveToFirst();
                    while (true) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("script_id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("script_desc"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("script_data"));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("ex_point"));
                        String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("include_script"));
                        String string7 = cursorQuery.getString(cursorQuery.getColumnIndex("icon_url"));
                        String string8 = cursorQuery.getString(cursorQuery.getColumnIndex("resources"));
                        String string9 = cursorQuery.getString(cursorQuery.getColumnIndex(str4));
                        String string10 = cursorQuery.getString(cursorQuery.getColumnIndex("exclude"));
                        String str7 = str4;
                        String string11 = cursorQuery.getString(cursorQuery.getColumnIndex(str3));
                        String str8 = str3;
                        String string12 = cursorQuery.getString(cursorQuery.getColumnIndex(str2));
                        String str9 = str2;
                        String str10 = str;
                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex(str10));
                        String str11 = str5;
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex(str11));
                        String str12 = str6;
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(str12));
                        cursor = cursorQuery;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("script_id", string);
                            jSONObject.put("title", string2);
                            jSONObject.put("script_desc", string3);
                            jSONObject.put("script_data", string4);
                            jSONObject.put("ex_point", string5);
                            jSONObject.put("include_script", string6);
                            jSONObject.put("exclude", string10);
                            jSONObject.put("icon_url", string7);
                            jSONObject.put("resources", string8);
                            jSONObject.put(str7, string9);
                            jSONObject.put(str8, string11);
                            jSONObject.put(str10, j);
                            jSONObject.put(str11, i);
                            jSONObject.put(str9, string12);
                            jSONObject.put(str12, i2);
                            jSONArray = jSONArray3;
                            try {
                                jSONArray.put(jSONObject);
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                                str5 = str11;
                                str = str10;
                                str6 = str12;
                                jSONArray3 = jSONArray;
                                str4 = str7;
                                str3 = str8;
                                cursorQuery = cursor;
                                str2 = str9;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                cursor.close();
                                return jSONArray;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            jSONArray = jSONArray3;
                            e.printStackTrace();
                            cursor.close();
                            return jSONArray;
                        }
                    }
                    cursor.close();
                } catch (Exception e3) {
                    e = e3;
                    cursor = cursorQuery;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    cursor.close();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor.close();
                throw th;
            }
        } else {
            jSONArray = jSONArray2;
            cursor = cursorQuery;
        }
        cursor.close();
        return jSONArray;
    }
}
