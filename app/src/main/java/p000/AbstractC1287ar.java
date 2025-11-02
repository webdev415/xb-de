package p000;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractC1287ar {
    public static Set m5565a(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    public static void m5566b(C2356sx c2356sx, SQLiteDatabase sQLiteDatabase) {
        if (c2356sx == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(AbstractC0911Ts.m4185a().mo4857g(sQLiteDatabase.getPath()));
        if (!file.setReadable(false, false)) {
            c2356sx.m9623L().m10616a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            c2356sx.m9623L().m10616a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            c2356sx.m9623L().m10616a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        c2356sx.m9623L().m10616a("Failed to turn on database write permission for owner");
    }

    public static void m5567c(C2356sx c2356sx, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLException {
        if (c2356sx == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!m5568d(c2356sx, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            Set setM5565a = m5565a(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!setM5565a.remove(str4)) {
                    throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!setM5565a.remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (setM5565a.isEmpty()) {
                return;
            }
            c2356sx.m9623L().m10618c("Table has extra columns. table, columns", str, TextUtils.join(", ", setM5565a));
        } catch (SQLiteException e) {
            c2356sx.m9618G().m10617b("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    public static boolean m5568d(C2356sx c2356sx, SQLiteDatabase sQLiteDatabase, String str) {
        if (c2356sx == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
                return zMoveToFirst;
            } catch (SQLiteException e) {
                c2356sx.m9623L().m10618c("Error querying for table", str, e);
                if (cursorQuery == null) {
                    return false;
                }
                cursorQuery.close();
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
