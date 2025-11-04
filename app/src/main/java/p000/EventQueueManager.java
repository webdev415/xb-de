package p000;

import android.database.Cursor;
import android.database.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class C1825ha {

    public static C1825ha instance;

    public final ArrayList f5733a = new ArrayList<>();

    public final HashMap f5734b = new HashMap<>();

    public class a {

        public int f5735a;

        public Class f5736b;

        public a(int i, Class cls) {
            this.f5735a = i;
            this.f5736b = cls;
        }
    }

    public static C1825ha getInstance() {
        if (instance == null) {
            instance = new C1825ha();
        }
        return instance;
    }

    public void m7825a() {
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("event_queue", DatabaseColumns.EVENT_QUEUE, null, null, null, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex("tran_id"));
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("event_id"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("event_params"));
                        m7826b(j);
                        if (i != 0) {
                            m7831h(j, i, string, null);
                        }
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m7826b(long j) {
        this.f5734b.remove(j);
        try {
            MySQLiteOpenHelper.getInstance().getWritableDatabase().execSQL("DELETE FROM event_queue WHERE tran_id=" + j);
        } catch (Exception unused) {
        }
    }

    public void m7827c(AbstractC2313s abstractC2313s) throws SQLException {
        this.f5734b.put(abstractC2313s.m9456c(), abstractC2313s);
        MySQLiteOpenHelper.getInstance().getWritableDatabase().execSQL("INSERT INTO event_queue(tran_id,event_id,event_params,status ) VALUES (" + abstractC2313s.f6987a + ", " + abstractC2313s.f6988b + ",'" + abstractC2313s.f6989c + "',0)");
    }

    public void m7828e(int i) {
        m7829f(i, null);
    }

    public void m7829f(int i, String str) {
        m7831h(System.currentTimeMillis(), i, str, null);
    }

    public void m7830g(int i, String str, Object obj) {
        m7831h(System.currentTimeMillis(), i, str, obj);
    }

    public void m7831h(long j, int i, String str, Object obj) {
        for (Object o : this.f5733a) {
            a aVar = (a) o;
            if (aVar.f5735a == i) {
                try {
                    AbstractC2313s abstractC2313s = (AbstractC2313s) aVar.f5736b.newInstance();
                    abstractC2313s.m9458e(j);
                    if (!abstractC2313s.m9457d(i, str, obj)) {
                        m7827c(abstractC2313s);
                    }
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void m7832i(int i, Class cls) {
        this.f5733a.add(new a(i, cls));
    }
}
