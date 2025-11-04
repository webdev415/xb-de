package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mmbox.xbrowser.BrowserActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2553x9 extends DataSource {
    @Override
    public String mo8842b() {
        return "browser.h5store";
    }

    @Override
    public String mo61f() {
        return "browser.h5store";
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        JSONArray jSONArray = new JSONArray((String) obj);
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            C0758Qc c0758Qc = new C0758Qc();
            c0758Qc.f2236a = jSONObject.getString("cateid");
            c0758Qc.f2237b = jSONObject.getString("title");
            c0758Qc.f2238c = jSONObject.getString("intro");
            c0758Qc.f2239d = jSONObject.getString("url");
            c0758Qc.f2240e = jSONObject.getInt("ctr_flag");
            c0758Qc.f2243h = jSONObject.getString("created_at");
            arrayList.add(c0758Qc);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            m10631m((C0758Qc) arrayList.get(i3));
        }
        if (BrowserActivity.getActivity() != null) {
            BrowserActivity.getActivity().refreshQuickAccessUI();
        }
        return arrayList;
    }

    public final void m10631m(C0758Qc c0758Qc) {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cate_id", c0758Qc.f2236a);
        contentValues.put("title", c0758Qc.f2237b);
        contentValues.put("intro", c0758Qc.f2238c);
        contentValues.put("url", c0758Qc.f2239d);
        contentValues.put("ctr_flag", Integer.valueOf(c0758Qc.f2240e));
        contentValues.put("created_at", c0758Qc.f2243h);
        contentValues.put("score", Integer.valueOf(c0758Qc.f2241f));
        contentValues.put("status", Integer.valueOf(c0758Qc.f2242g));
        if (m10632n(c0758Qc.f2239d, writableDatabase, contentValues) == -1) {
            writableDatabase.insert("h5store", null, contentValues);
        }
    }

    public final long m10632n(String str, SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        Cursor cursorQuery = sQLiteDatabase.query("h5store", DatabaseColumns.H_5_STORE, "url= ?", new String[]{str}, null, null, null);
        if (cursorQuery == null) {
            return -1L;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                return -1L;
            }
            long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
            contentValues.put("cate_id", contentValues.getAsString("cate_id"));
            contentValues.put("intro", contentValues.getAsString("intro"));
            contentValues.put("ctr_flag", Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("ctr_flag"))));
            contentValues.put("score", contentValues.getAsInteger("score"));
            contentValues.put("status", contentValues.getAsInteger("status"));
            sQLiteDatabase.update("h5store", contentValues, "_id=" + j, null);
            return j;
        } finally {
            cursorQuery.close();
        }
    }
}
