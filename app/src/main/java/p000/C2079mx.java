package p000;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;

public final class C2079mx extends AbstractC0501Kv {

    public final C1987kx f6276c;

    public boolean f6277d;

    public C2079mx(C2266qz c2266qz) {
        super(c2266qz);
        this.f6276c = new C1987kx(this, mo344a(), "google_app_measurement_local.db");
    }

    public static long m8656B(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1L;
            }
            long j = cursorQuery.getLong(0);
            cursorQuery.close();
            return j;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private final boolean m8657L() {
        return mo344a().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override
    public final boolean mo2545A() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d0 A[PHI: r8 r15
  0x01d0: PHI (r8v3 int) = (r8v1 int), (r8v1 int), (r8v4 int) binds: [B:117:0x01be, B:132:0x01e9, B:125:0x01ce] A[DONT_GENERATE, DONT_INLINE]
  0x01d0: PHI (r15v6 android.database.sqlite.SQLiteDatabase) = 
  (r15v4 android.database.sqlite.SQLiteDatabase)
  (r15v5 android.database.sqlite.SQLiteDatabase)
  (r15v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:117:0x01be, B:132:0x01e9, B:125:0x01ce] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ec A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List m8658C(int r22) throws Throwable {
        /*
            Method dump skipped, instructions count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2079mx.m8658C(int):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fb A[PHI: r6 r9
  0x00fb: PHI (r6v3 int) = (r6v1 int), (r6v4 int) binds: [B:73:0x0116, B:66:0x00f9] A[DONT_GENERATE, DONT_INLINE]
  0x00fb: PHI (r9v7 android.database.sqlite.SQLiteDatabase) = (r9v6 android.database.sqlite.SQLiteDatabase), (r9v8 android.database.sqlite.SQLiteDatabase) binds: [B:73:0x0116, B:66:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0126  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m8659D(int r17, byte[] r18) throws Throwable {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2079mx.m8659D(int, byte[]):boolean");
    }

    public final boolean m8660E(C2303rq c2303rq) {
        mo352j();
        byte[] bArrM10470q0 = C2514wG.m10470q0(c2303rq);
        if (bArrM10470q0.length <= 131072) {
            return m8659D(2, bArrM10470q0);
        }
        mo349g().m9620I().m10616a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean m8661F(C0635Nr c0635Nr) {
        Parcel parcelObtain = Parcel.obtain();
        c0635Nr.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return m8659D(0, bArrMarshall);
        }
        mo349g().m9620I().m10616a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean m8662G(C2053mG c2053mG) {
        Parcel parcelObtain = Parcel.obtain();
        c2053mG.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return m8659D(1, bArrMarshall);
        }
        mo349g().m9620I().m10616a("User property too long for local database. Sending directly to service");
        return false;
    }

    public final void m8663H() {
        int iDelete;
        mo356n();
        try {
            SQLiteDatabase sQLiteDatabaseM8666K = m8666K();
            if (sQLiteDatabaseM8666K == null || (iDelete = sQLiteDatabaseM8666K.delete("messages", null, null)) <= 0) {
                return;
            }
            mo349g().m9622K().m10617b("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e) {
            mo349g().m9618G().m10617b("Error resetting local analytics data. error", e);
        }
    }

    public final boolean m8664I() {
        return m8659D(3, new byte[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006d A[PHI: r4
  0x006d: PHI (r4v4 int) = (r4v1 int), (r4v2 int), (r4v1 int) binds: [B:32:0x0064, B:35:0x006b, B:38:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m8665J() {
        /*
            r10 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r10.mo356n()
            boolean r1 = r10.f6277d
            r2 = 0
            if (r1 == 0) goto Lb
            return r2
        Lb:
            boolean r1 = r10.m8657L()
            if (r1 != 0) goto L12
            return r2
        L12:
            r1 = 5
            r4 = r1
            r3 = r2
        L15:
            if (r3 >= r1) goto L8a
            r5 = 1
            r6 = 0
            android.database.sqlite.SQLiteDatabase r6 = r10.m8666K()     // Catch: java.lang.Throwable -> L27 android.database.sqlite.SQLiteException -> L29 android.database.sqlite.SQLiteFullException -> L2b android.database.sqlite.SQLiteDatabaseLockedException -> L65
            if (r6 != 0) goto L2d
            r10.f6277d = r5     // Catch: java.lang.Throwable -> L27 android.database.sqlite.SQLiteException -> L29 android.database.sqlite.SQLiteFullException -> L2b android.database.sqlite.SQLiteDatabaseLockedException -> L65
            if (r6 == 0) goto L26
            r6.close()
        L26:
            return r2
        L27:
            r0 = move-exception
            goto L84
        L29:
            r7 = move-exception
            goto L4a
        L2b:
            r7 = move-exception
            goto L71
        L2d:
            r6.beginTransaction()     // Catch: java.lang.Throwable -> L27 android.database.sqlite.SQLiteException -> L29 android.database.sqlite.SQLiteFullException -> L2b android.database.sqlite.SQLiteDatabaseLockedException -> L65
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            r9 = 3
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch: java.lang.Throwable -> L27 android.database.sqlite.SQLiteException -> L29 android.database.sqlite.SQLiteFullException -> L2b android.database.sqlite.SQLiteDatabaseLockedException -> L65
            java.lang.String[] r9 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L27 android.database.sqlite.SQLiteException -> L29 android.database.sqlite.SQLiteFullException -> L2b android.database.sqlite.SQLiteDatabaseLockedException -> L65
            r6.delete(r7, r8, r9)     // Catch: java.lang.Throwable -> L27 android.database.sqlite.SQLiteException -> L29 android.database.sqlite.SQLiteFullException -> L2b android.database.sqlite.SQLiteDatabaseLockedException -> L65
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L27 android.database.sqlite.SQLiteException -> L29 android.database.sqlite.SQLiteFullException -> L2b android.database.sqlite.SQLiteDatabaseLockedException -> L65
            r6.endTransaction()     // Catch: java.lang.Throwable -> L27 android.database.sqlite.SQLiteException -> L29 android.database.sqlite.SQLiteFullException -> L2b android.database.sqlite.SQLiteDatabaseLockedException -> L65
            r6.close()
            return r5
        L4a:
            if (r6 == 0) goto L55
            boolean r8 = r6.inTransaction()     // Catch: java.lang.Throwable -> L27
            if (r8 == 0) goto L55
            r6.endTransaction()     // Catch: java.lang.Throwable -> L27
        L55:
            sx r8 = r10.mo349g()     // Catch: java.lang.Throwable -> L27
            wx r8 = r8.m9618G()     // Catch: java.lang.Throwable -> L27
            r8.m10617b(r0, r7)     // Catch: java.lang.Throwable -> L27
            r10.f6277d = r5     // Catch: java.lang.Throwable -> L27
            if (r6 == 0) goto L81
            goto L6d
        L65:
            long r7 = (long) r4     // Catch: java.lang.Throwable -> L27
            android.os.SystemClock.sleep(r7)     // Catch: java.lang.Throwable -> L27
            int r4 = r4 + 20
            if (r6 == 0) goto L81
        L6d:
            r6.close()
            goto L81
        L71:
            sx r8 = r10.mo349g()     // Catch: java.lang.Throwable -> L27
            wx r8 = r8.m9618G()     // Catch: java.lang.Throwable -> L27
            r8.m10617b(r0, r7)     // Catch: java.lang.Throwable -> L27
            r10.f6277d = r5     // Catch: java.lang.Throwable -> L27
            if (r6 == 0) goto L81
            goto L6d
        L81:
            int r3 = r3 + 1
            goto L15
        L84:
            if (r6 == 0) goto L89
            r6.close()
        L89:
            throw r0
        L8a:
            sx r0 = r10.mo349g()
            wx r0 = r0.m9623L()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.m10616a(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2079mx.m8665J():boolean");
    }

    public final SQLiteDatabase m8666K() {
        if (this.f6277d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f6276c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f6277d = true;
        return null;
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    @Override
    public final /* bridge */ C1755fy mo351i() {
        return super.mo351i();
    }

    @Override
    public final /* bridge */ C2514wG mo352j() {
        return super.mo352j();
    }

    @Override
    public final /* bridge */ void mo353k() {
        super.mo353k();
    }

    @Override
    public final /* bridge */ C1662dz mo354l() {
        return super.mo354l();
    }

    @Override
    public final /* bridge */ void mo355m() {
        super.mo355m();
    }

    @Override
    public final /* bridge */ void mo356n() {
        super.mo356n();
    }

    @Override
    public final /* bridge */ C1092Xp mo3783o() {
        return super.mo3783o();
    }

    @Override
    public final /* bridge */ C1801gx mo3784p() {
        return super.mo3784p();
    }

    @Override
    public final /* bridge */ C2079mx mo3785q() {
        return super.mo3785q();
    }

    @Override
    public final /* bridge */ C1207aB mo3786r() {
        return super.mo3786r();
    }

    @Override
    public final /* bridge */ C1070XC mo3787s() {
        return super.mo3787s();
    }

    @Override
    public final /* bridge */ C2142oD mo3788t() {
        return super.mo3788t();
    }

    @Override
    public final /* bridge */ C0796RE mo3789u() {
        return super.mo3789u();
    }
}
