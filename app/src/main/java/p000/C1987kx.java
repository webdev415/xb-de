package p000;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;

public final class C1987kx extends AbstractC1656dt {

    public final C2079mx f6044l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1987kx(C2079mx c2079mx, Context context, String str) {
        super(context, str, null, 1);
        this.f6044l = c2079mx;
    }

    @Override
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e) {
            throw e;
        } catch (SQLiteException unused) {
            this.f6044l.mo349g().m9618G().m10616a("Opening the local database failed, dropping and recreating it");
            if (!this.f6044l.mo344a().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.f6044l.mo349g().m9618G().m10617b("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e2) {
                this.f6044l.mo349g().m9618G().m10617b("Failed to open local database. Events will bypass local storage", e2);
                return null;
            }
        }
    }

    @Override
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        AbstractC1287ar.m5566b(this.f6044l.mo349g(), sQLiteDatabase);
    }

    @Override
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws SQLException {
        AbstractC1287ar.m5567c(this.f6044l.mo349g(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    @Override
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
