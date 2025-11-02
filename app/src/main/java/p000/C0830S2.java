package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0830S2 extends AbstractResourceManager {
    public C0830S2(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() {
        return m3981x().toString();
    }

    @Override
    public String getKey() {
        return "sync_tag_bookmark";
    }

    @Override
    public void saveToLocal(String str) throws Throwable {
        JSONArray jSONArrayM3981x = m3981x();
        HashMap map = new HashMap<>();
        for (int i = 0; i < jSONArrayM3981x.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArrayM3981x.get(i);
                map.put(jSONObject.getString("url"), jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                String string = jSONObject2.getString("url");
                if (map.containsKey(string)) {
                    JsonUtils.copyJSONObject(jSONObject2, (JSONObject) map.get(string));
                } else {
                    jSONArrayM3981x.put(jSONObject2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        m3982y(jSONArrayM3981x);
    }

    @Override
    public void loadFromRemote(String str) {
        try {
            m3982y(new JSONArray(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final JSONArray m3981x() throws Throwable {
        Cursor cursor;
        int i;
        JSONObject jSONObject;
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("bookmark", null, null, null, null, null, null);
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        if (cursorQuery != null) {
            try {
                try {
                    cursorQuery.moveToFirst();
                    while (true) {
                        try {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("parent"));
                            int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("type"));
                            int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("item_order"));
                            JSONArray jSONArray2 = jSONArray;
                            i = i2;
                            try {
                                long j = cursorQuery.getLong(cursorQuery.getColumnIndex("last_visit"));
                                int i5 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                                cursor = cursorQuery;
                                try {
                                    try {
                                        jSONObject = new JSONObject();
                                        jSONObject.put("title", string);
                                        jSONObject.put("url", string2);
                                        jSONObject.put("parent", string3);
                                        jSONObject.put("type", i3);
                                        jSONObject.put("item_order", i4);
                                        jSONObject.put("last_visit", j);
                                        jSONObject.put("status", i5);
                                        jSONArray = jSONArray2;
                                    } catch (Exception e) {
                                        e = e;
                                        jSONArray = jSONArray2;
                                        i2 = i;
                                        e.printStackTrace();
                                        cursor.close();
                                        Log.i("Bookmarks", "count:" + i2);
                                        return jSONArray;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                cursor = cursorQuery;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            cursor = cursorQuery;
                        }
                        try {
                            jSONArray.put(jSONObject);
                            i2 = i + 1;
                            try {
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                                cursorQuery = cursor;
                            } catch (Exception e4) {
                                e = e4;
                                e.printStackTrace();
                                cursor.close();
                                Log.i("Bookmarks", "count:" + i2);
                                return jSONArray;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            i2 = i;
                            e.printStackTrace();
                            cursor.close();
                            Log.i("Bookmarks", "count:" + i2);
                            return jSONArray;
                        }
                    }
                    cursor.close();
                } catch (Exception e6) {
                    e = e6;
                    cursor = cursorQuery;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                cursor.close();
                throw th;
            }
        } else {
            cursor = cursorQuery;
        }
        cursor.close();
        Log.i("Bookmarks", "count:" + i2);
        return jSONArray;
    }

    public final void m3982y(JSONArray jSONArray) throws JSONException {
        int i;
        int i2;
        int iM3660e;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", jSONObject.getString("title"));
                contentValues.put("url", jSONObject.getString("url"));
                String string = "/";
                try {
                    string = jSONObject.getString("parent");
                    i = jSONObject.getInt("type");
                    try {
                        i2 = jSONObject.getInt("item_order");
                    } catch (Exception unused) {
                        i2 = 0;
                    }
                } catch (Exception unused2) {
                    i = 0;
                    i2 = 0;
                }
                try {
                    iM3660e = JsonUtils.getInt(jSONObject, "status", 0);
                } catch (Exception unused3) {
                    iM3660e = 0;
                    long jM3663h = JsonUtils.getLong(jSONObject, "last_visit");
                    contentValues.put("parent", string);
                    contentValues.put("type", Integer.valueOf(i));
                    contentValues.put("item_order", Integer.valueOf(i2));
                    contentValues.put("last_visit", Long.valueOf(jM3663h));
                    contentValues.put("status", Integer.valueOf(iM3660e));
                    MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues);
                }
                long jM3663h2 = JsonUtils.getLong(jSONObject, "last_visit");
                contentValues.put("parent", string);
                contentValues.put("type", Integer.valueOf(i));
                contentValues.put("item_order", Integer.valueOf(i2));
                contentValues.put("last_visit", Long.valueOf(jM3663h2));
                contentValues.put("status", Integer.valueOf(iM3660e));
                MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        MySQLiteOpenHelper.getInstance().insertOrReplaceEntries("bookmark", true);
    }
}
