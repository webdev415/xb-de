package p000;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
public abstract class AbstractC1656dt extends SQLiteOpenHelper {
    public AbstractC1656dt(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(context, str, null, 1, AbstractC1844ht.f5771a);
    }

    public AbstractC1656dt(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, AbstractC1844ht abstractC1844ht) {
        super(context, (str == null || AbstractC0911Ts.m4185a().mo4854b(str, abstractC1844ht, EnumC1336bt.SQLITE_OPEN_HELPER_TYPE).equals("")) ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
    }
}
