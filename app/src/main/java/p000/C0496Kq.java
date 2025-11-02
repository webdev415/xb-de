package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000.AbstractC0703PC;
import p000.C0595Mx;
import p000.C0687Ox;
import p000.C1940jw;
import p000.C1986kw;
import p000.C2032lw;
import p000.C2124nw;

public final class C0496Kq extends AbstractC2513wF {

    public static final String[] f1622f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    public static final String[] f1623g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    public static final String[] f1624h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;"};

    public static final String[] f1625i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    public static final String[] f1626j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    public static final String[] f1627k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    public static final String[] f1628l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    public static final String[] f1629m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    public static final String[] f1630n = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};

    public static final String[] f1631o = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    public final C1608cr f1632d;

    public final C2006lF f1633e;

    public C0496Kq(C0200EF c0200ef) {
        super(c0200ef);
        this.f1633e = new C2006lF(mo345b());
        this.f1632d = new C1608cr(this, mo344a(), "google_app_measurement.db");
    }

    public static void m2454T(ContentValues contentValues, String str, Object obj) {
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4801j(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Double) obj);
        }
    }

    public final long m2465A() {
        return m2475F("select max(timestamp) from raw_events", null, 0L);
    }

    public final long m2466A0(String str) {
        AbstractC1085Xi.m4795d(str);
        mo356n();
        m10440u();
        return m2475F("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
    }

    public final SQLiteDatabase m2467B() {
        mo356n();
        try {
            return this.f1632d.getWritableDatabase();
        } catch (SQLiteException e) {
            mo349g().m9623L().m10617b("Error opening database", e);
            throw e;
        }
    }

    public final long m2468B0(String str, String str2) {
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4795d(str2);
        mo356n();
        m10440u();
        SQLiteDatabase sQLiteDatabaseM2467B = m2467B();
        sQLiteDatabaseM2467B.beginTransaction();
        long j = 0;
        try {
            try {
                long jM2475F = m2475F("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (jM2475F == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseM2467B.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        mo349g().m9618G().m10618c("Failed to insert column (got -1). appId", C2356sx.m9613v(str), str2);
                        return -1L;
                    }
                    jM2475F = 0;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + jM2475F));
                    if (sQLiteDatabaseM2467B.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        mo349g().m9618G().m10618c("Failed to update column (got 0). appId", C2356sx.m9613v(str), str2);
                        return -1L;
                    }
                    sQLiteDatabaseM2467B.setTransactionSuccessful();
                    return jM2475F;
                } catch (SQLiteException e) {
                    long j2 = jM2475F;
                    e = e;
                    j = j2;
                    mo349g().m9618G().m10619d("Error inserting column. appId", C2356sx.m9613v(str), str2, e);
                    sQLiteDatabaseM2467B.endTransaction();
                    return j;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } finally {
            sQLiteDatabaseM2467B.endTransaction();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final String m2469C() throws Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.m2467B()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L27
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L1e
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L3c
        L1c:
            r2 = move-exception
            goto L29
        L1e:
            r0.close()
            return r1
        L22:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3c
        L27:
            r2 = move-exception
            r0 = r1
        L29:
            sx r3 = r6.mo349g()     // Catch: java.lang.Throwable -> L1a
            wx r3 = r3.m9618G()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.m10617b(r4, r2)     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L3b
            r0.close()
        L3b:
            return r1
        L3c:
            if (r0 == 0) goto L41
            r0.close()
        L41:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2469C():java.lang.String");
    }

    public final long m2470C0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = m2467B().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                mo349g().m9618G().m10618c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final int m2471D(String str, String str2) {
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4795d(str2);
        mo356n();
        m10440u();
        try {
            return m2467B().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo349g().m9618G().m10619d("Error deleting conditional property", C2356sx.m9613v(str), mo350h().m9213g(str2), e);
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a1, code lost:
    
        mo349g().m9618G().m10617b("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final List m2472D0(String r23, String r24, String r25) throws Throwable {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2472D0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final long m2473E(String str) {
        AbstractC1085Xi.m4795d(str);
        mo356n();
        m10440u();
        try {
            return m2467B().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, mo347e().m10823y(str, AbstractC0818Rr.f2528q))))});
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error deleting over the limit events. appId", C2356sx.m9613v(str), e);
            return 0L;
        }
    }

    public final void m2474E0(String str, C0425JA c0425ja) {
        AbstractC1085Xi.m4801j(str);
        AbstractC1085Xi.m4801j(c0425ja);
        mo356n();
        m10440u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", c0425ja.m1867z());
        contentValues.put("consent_source", Integer.valueOf(c0425ja.m1854b()));
        m2504V("consent_settings", "app_id", contentValues);
    }

    public final long m2475F(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = m2467B().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j;
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e) {
                mo349g().m9618G().m10618c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final boolean m2476F0(String str, List list) {
        AbstractC1085Xi.m4795d(str);
        m10440u();
        mo356n();
        SQLiteDatabase sQLiteDatabaseM2467B = m2467B();
        try {
            long jM2470C0 = m2470C0("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, mo347e().m10823y(str, AbstractC0818Rr.f2445I)));
            if (jM2470C0 <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String str2 = "(" + TextUtils.join(",", arrayList) + ")";
            StringBuilder sb = new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb.append(str2);
            sb.append(" order by rowid desc limit -1 offset ?)");
            return sQLiteDatabaseM2467B.delete("audience_filter_values", sb.toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Database error querying filters. appId", C2356sx.m9613v(str), e);
            return false;
        }
    }

    public final long m2477G(C0595Mx c0595Mx) {
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(c0595Mx);
        AbstractC1085Xi.m4795d(c0595Mx.m3117x2());
        byte[] bArrM4464i = c0595Mx.m4464i();
        long jM8908A = mo3244o().m8908A(bArrM4464i);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c0595Mx.m3117x2());
        contentValues.put("metadata_fingerprint", Long.valueOf(jM8908A));
        contentValues.put("metadata", bArrM4464i);
        try {
            m2467B().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jM8908A;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing raw event metadata. appId", C2356sx.m9613v(c0595Mx.m3117x2()), e);
            throw e;
        }
    }

    public final long m2478G0(String str) {
        AbstractC1085Xi.m4795d(str);
        return m2475F("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0031: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:50), block:B:10:0x0031 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final Pair m2479H(String r6, Long r7) throws Throwable {
        /*
            r5 = this;
            r5.mo356n()
            r5.m10440u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.m2467B()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            java.lang.String r3 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String[] r3 = new java.lang.String[]{r6, r3}     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            if (r2 != 0) goto L35
            sx r6 = r5.mo349g()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            wx r6 = r6.m9622K()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.String r7 = "Main event not found"
            r6.m10616a(r7)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r1.close()
            return r0
        L30:
            r6 = move-exception
            r0 = r1
            goto L8a
        L33:
            r6 = move-exception
            goto L77
        L35:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r3 = 1
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            Hx$a r4 = p000.C0365Hx.m1631S()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            hE r2 = p000.C2145oG.m8894P(r4, r2)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            Hx$a r2 = (p000.C0365Hx.a) r2     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            jE r2 = r2.m3526o()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            PC r2 = (p000.AbstractC0703PC) r2     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            Hx r2 = (p000.C0365Hx) r2     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            android.util.Pair r6 = android.util.Pair.create(r2, r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r1.close()
            return r6
        L5d:
            r2 = move-exception
            sx r3 = r5.mo349g()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            wx r3 = r3.m9618G()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r6 = p000.C2356sx.m9613v(r6)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r3.m10619d(r4, r6, r7, r2)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r1.close()
            return r0
        L73:
            r6 = move-exception
            goto L8a
        L75:
            r6 = move-exception
            r1 = r0
        L77:
            sx r7 = r5.mo349g()     // Catch: java.lang.Throwable -> L30
            wx r7 = r7.m9618G()     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = "Error selecting main event"
            r7.m10617b(r2, r6)     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L89
            r1.close()
        L89:
            return r0
        L8a:
            if (r0 == 0) goto L8f
            r0.close()
        L8f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2479H(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0053: MOVE (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]) (LINE:84), block:B:14:0x0053 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C2303rq m2480H0(String r27, String r28) throws Throwable {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2480H0(java.lang.String, java.lang.String):rq");
    }

    public final Object m2481I(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            mo349g().m9618G().m10616a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            mo349g().m9618G().m10617b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        mo349g().m9618G().m10616a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C0267Fr m2482I0(String r29, String r30, String r31) throws Throwable {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2482I0(java.lang.String, java.lang.String, java.lang.String):Fr");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final Object m2483J(String r3, String[] r4, InterfaceC1047Wq r5) throws Throwable {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.m2467B()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            if (r4 != 0) goto L25
            sx r4 = r2.mo349g()     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            wx r4 = r4.m9622K()     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            java.lang.String r5 = "No data found"
            r4.m10616a(r5)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            r3.close()
            return r0
        L20:
            r4 = move-exception
            r0 = r3
            goto L44
        L23:
            r4 = move-exception
            goto L31
        L25:
            java.lang.Object r4 = r5.mo3707a(r3)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L23
            r3.close()
            return r4
        L2d:
            r4 = move-exception
            goto L44
        L2f:
            r4 = move-exception
            r3 = r0
        L31:
            sx r5 = r2.mo349g()     // Catch: java.lang.Throwable -> L20
            wx r5 = r5.m9618G()     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = "Error querying database."
            r5.m10617b(r1, r4)     // Catch: java.lang.Throwable -> L20
            if (r3 == 0) goto L43
            r3.close()
        L43:
            return r0
        L44:
            if (r0 == 0) goto L49
            r0.close()
        L49:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2483J(java.lang.String, java.lang.String[], Wq):java.lang.Object");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:46), block:B:10:0x002d */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final Bundle m2484J0(String r6) throws Throwable {
        /*
            r5 = this;
            r5.mo356n()
            r5.m10440u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.m2467B()     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r6}     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L6d android.database.sqlite.SQLiteException -> L6f
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            if (r2 != 0) goto L31
            sx r6 = r5.mo349g()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            wx r6 = r6.m9622K()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            java.lang.String r2 = "Default event parameters not found"
            r6.m10616a(r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            r1.close()
            return r0
        L2c:
            r6 = move-exception
            r0 = r1
            goto L84
        L2f:
            r6 = move-exception
            goto L71
        L31:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            Hx$a r3 = p000.C0365Hx.m1631S()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            hE r2 = p000.C2145oG.m8894P(r3, r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            Hx$a r2 = (p000.C0365Hx.a) r2     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            jE r2 = r2.m3526o()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            PC r2 = (p000.AbstractC0703PC) r2     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            Hx r2 = (p000.C0365Hx) r2     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f java.io.IOException -> L57
            r5.mo3244o()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            java.util.List r6 = r2.m1638V()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            android.os.Bundle r6 = p000.C2145oG.m8889B(r6)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            r1.close()
            return r6
        L57:
            r2 = move-exception
            sx r3 = r5.mo349g()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            wx r3 = r3.m9618G()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = p000.C2356sx.m9613v(r6)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            r3.m10618c(r4, r6, r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L2f
            r1.close()
            return r0
        L6d:
            r6 = move-exception
            goto L84
        L6f:
            r6 = move-exception
            r1 = r0
        L71:
            sx r2 = r5.mo349g()     // Catch: java.lang.Throwable -> L2c
            wx r2 = r2.m9618G()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "Error selecting default event parameters"
            r2.m10617b(r3, r6)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L83
            r1.close()
        L83:
            return r0
        L84:
            if (r0 == 0) goto L89
            r0.close()
        L89:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2484J0(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final String m2485K(long r4) throws Throwable {
        /*
            r3 = this;
            r3.mo356n()
            r3.m10440u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r3.m2467B()     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            android.database.Cursor r4 = r1.rawQuery(r2, r4)     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            boolean r5 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            if (r5 != 0) goto L35
            sx r5 = r3.mo349g()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            wx r5 = r5.m9622K()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.String r1 = "No expired configs for apps with pending events"
            r5.m10616a(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r4.close()
            return r0
        L30:
            r5 = move-exception
            r0 = r4
            goto L55
        L33:
            r5 = move-exception
            goto L42
        L35:
            r5 = 0
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r4.close()
            return r5
        L3e:
            r5 = move-exception
            goto L55
        L40:
            r5 = move-exception
            r4 = r0
        L42:
            sx r1 = r3.mo349g()     // Catch: java.lang.Throwable -> L30
            wx r1 = r1.m9618G()     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = "Error selecting expired configs"
            r1.m10617b(r2, r5)     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L54
            r4.close()
        L54:
            return r0
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2485K(long):java.lang.String");
    }

    public final C0267Fr m2486K0(String str, String str2) {
        return m2482I0("events", str, str2);
    }

    public final String m2487L(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = m2467B().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return str2;
                }
                String string = cursorRawQuery.getString(0);
                cursorRawQuery.close();
                return string;
            } catch (SQLiteException e) {
                mo349g().m9618G().m10618c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C2403ty m2488L0(String r51) {
        /*
            Method dump skipped, instructions count: 928
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2488L0(java.lang.String):ty");
    }

    public final List m2489M(String str, int i, int i2) {
        C2540wx c2540wxM9618G;
        String str2;
        Object objM9613v;
        byte[] bArrM8927l0;
        long jM3729P;
        long jM3729P2;
        mo356n();
        m10440u();
        int i3 = 1;
        AbstractC1085Xi.m4792a(i > 0);
        AbstractC1085Xi.m4792a(i2 > 0);
        AbstractC1085Xi.m4795d(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = m2467B().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List listEmptyList = Collections.emptyList();
                    cursorQuery.close();
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList<>();
                int length = 0;
                while (true) {
                    long j = cursorQuery.getLong(0);
                    try {
                        bArrM8927l0 = mo3244o().m8927l0(cursorQuery.getBlob(i3));
                    } catch (IOException e) {
                        e = e;
                        c2540wxM9618G = mo349g().m9618G();
                        str2 = "Failed to unzip queued bundle. appId";
                        objM9613v = C2356sx.m9613v(str);
                    }
                    if (!arrayList.isEmpty() && bArrM8927l0.length + length > i2) {
                        break;
                    }
                    try {
                        C0595Mx.a aVar = (C0595Mx.a) C2145oG.m8894P(C0595Mx.m3030u2(), bArrM8927l0);
                        if (!arrayList.isEmpty()) {
                            C0595Mx c0595Mx = (C0595Mx) ((Pair) arrayList.get(0)).first;
                            C0595Mx c0595Mx2 = (C0595Mx) ((AbstractC0703PC) aVar.m3526o());
                            if (!c0595Mx.m3072Y().equals(c0595Mx2.m3072Y()) || !c0595Mx.m3070X().equals(c0595Mx2.m3070X()) || c0595Mx.m3102o0() != c0595Mx2.m3102o0() || !c0595Mx.m3075Z().equals(c0595Mx2.m3075Z())) {
                                break;
                            }
                            Iterator it = c0595Mx.m3099m0().iterator();
                            while (true) {
                                jM3729P = -1;
                                if (!it.hasNext()) {
                                    jM3729P2 = -1;
                                    break;
                                }
                                C0779Qx c0779Qx = (C0779Qx) it.next();
                                if ("_npa".equals(c0779Qx.m3731U())) {
                                    jM3729P2 = c0779Qx.m3729P();
                                    break;
                                }
                            }
                            Iterator it2 = c0595Mx2.m3099m0().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                C0779Qx c0779Qx2 = (C0779Qx) it2.next();
                                if ("_npa".equals(c0779Qx2.m3731U())) {
                                    jM3729P = c0779Qx2.m3729P();
                                    break;
                                }
                            }
                            if (jM3729P2 != jM3729P) {
                                break;
                            }
                        }
                        if (!cursorQuery.isNull(2)) {
                            aVar.m3204x0(cursorQuery.getInt(2));
                        }
                        length += bArrM8927l0.length;
                        arrayList.add(Pair.create((C0595Mx) ((AbstractC0703PC) aVar.m3526o()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        e = e2;
                        c2540wxM9618G = mo349g().m9618G();
                        str2 = "Failed to merge queued bundle. appId";
                        objM9613v = C2356sx.m9613v(str);
                        c2540wxM9618G.m10618c(str2, objM9613v, e);
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        break;
                        cursorQuery.close();
                        return arrayList;
                    }
                    if (!cursorQuery.moveToNext() || length > i2) {
                        break;
                        break;
                    }
                    i3 = 1;
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e3) {
                mo349g().m9618G().m10618c("Error querying bundles. appId", C2356sx.m9613v(str), e3);
                List listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:107), block:B:19:0x006a */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C2238qG m2490M0(String r11, String r12) {
        /*
            r10 = this;
            p000.AbstractC1085Xi.m4795d(r11)
            p000.AbstractC1085Xi.m4795d(r12)
            r10.mo356n()
            r10.m10440u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.m2467B()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            java.lang.String r2 = "user_attributes"
            java.lang.String r3 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            java.lang.String r4 = "app_id=? and name=?"
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L74
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            if (r2 != 0) goto L34
            r1.close()
            return r0
        L34:
            r2 = 0
            long r7 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            r2 = 1
            java.lang.Object r9 = r10.m2481I(r1, r2)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            if (r9 != 0) goto L44
            r1.close()
            return r0
        L44:
            r2 = 2
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            qG r2 = new qG     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            r3 = r2
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            if (r3 == 0) goto L6e
            sx r3 = r10.mo349g()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            wx r3 = r3.m9618G()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            java.lang.String r4 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r5 = p000.C2356sx.m9613v(r11)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            r3.m10617b(r4, r5)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteException -> L6c
            goto L6e
        L69:
            r11 = move-exception
            r0 = r1
            goto L95
        L6c:
            r2 = move-exception
            goto L76
        L6e:
            r1.close()
            return r2
        L72:
            r11 = move-exception
            goto L95
        L74:
            r2 = move-exception
            r1 = r0
        L76:
            sx r3 = r10.mo349g()     // Catch: java.lang.Throwable -> L69
            wx r3 = r3.m9618G()     // Catch: java.lang.Throwable -> L69
            java.lang.String r4 = "Error querying user property. appId"
            java.lang.Object r11 = p000.C2356sx.m9613v(r11)     // Catch: java.lang.Throwable -> L69
            qx r5 = r10.mo350h()     // Catch: java.lang.Throwable -> L69
            java.lang.String r12 = r5.m9213g(r12)     // Catch: java.lang.Throwable -> L69
            r3.m10619d(r4, r11, r12, r2)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L94
            r1.close()
        L94:
            return r0
        L95:
            if (r0 == 0) goto L9a
            r0.close()
        L9a:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2490M0(java.lang.String, java.lang.String):qG");
    }

    public final List m2491N(String str, String str2, String str3) {
        AbstractC1085Xi.m4795d(str);
        mo356n();
        m10440u();
        ArrayList arrayList = new ArrayList<>(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb.append(" and name glob ?");
        }
        return m2493O(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final Map m2492N0(String str, String str2) {
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4795d(str2);
        C2453v1 c2453v1 = new C2453v1();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = m2467B().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        C1986kw c1986kw = (C1986kw) ((AbstractC0703PC) ((C1986kw.a) C2145oG.m8894P(C1986kw.m8321K(), cursorQuery.getBlob(1))).m3526o());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) c2453v1.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            c2453v1.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(c1986kw);
                    } catch (IOException e) {
                        mo349g().m9618G().m10618c("Failed to merge filter. appId", C2356sx.m9613v(str), e);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return c2453v1;
            } catch (SQLiteException e2) {
                mo349g().m9618G().m10618c("Database error querying filters. appId", C2356sx.m9613v(str), e2);
                Map mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        mo349g().m9618G().m10617b("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final List m2493O(String r27, String[] r28) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2493O(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0059: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:90), block:B:14:0x0059 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C0680Oq m2494O0(String r10) throws Throwable {
        /*
            r9 = this;
            p000.AbstractC1085Xi.m4795d(r10)
            r9.mo356n()
            r9.m10440u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.m2467B()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            java.lang.String r4 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            if (r2 != 0) goto L31
            r1.close()
            return r0
        L31:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r3 = 1
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r4 = 2
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            boolean r5 = r1.moveToNext()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            if (r5 == 0) goto L5d
            sx r5 = r9.mo349g()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            wx r5 = r5.m9618G()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = p000.C2356sx.m9613v(r10)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r5.m10617b(r6, r7)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            goto L5d
        L58:
            r10 = move-exception
            r0 = r1
            goto L87
        L5b:
            r2 = move-exception
            goto L70
        L5d:
            if (r2 != 0) goto L63
            r1.close()
            return r0
        L63:
            Oq r5 = new Oq     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r5.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5b
            r1.close()
            return r5
        L6c:
            r10 = move-exception
            goto L87
        L6e:
            r2 = move-exception
            r1 = r0
        L70:
            sx r3 = r9.mo349g()     // Catch: java.lang.Throwable -> L58
            wx r3 = r3.m9618G()     // Catch: java.lang.Throwable -> L58
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r10 = p000.C2356sx.m9613v(r10)     // Catch: java.lang.Throwable -> L58
            r3.m10618c(r4, r10, r2)     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L86
            r1.close()
        L86:
            return r0
        L87:
            if (r0 == 0) goto L8c
            r0.close()
        L8c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2494O0(java.lang.String):Oq");
    }

    public final C0955Uq m2495P(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        AbstractC1085Xi.m4795d(str);
        mo356n();
        m10440u();
        String[] strArr = {str};
        C0955Uq c0955Uq = new C0955Uq();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseM2467B = m2467B();
                Cursor cursorQuery = sQLiteDatabaseM2467B.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    mo349g().m9623L().m10617b("Not updating daily counts, app is not known. appId", C2356sx.m9613v(str));
                    cursorQuery.close();
                    return c0955Uq;
                }
                if (cursorQuery.getLong(0) == j) {
                    c0955Uq.f2883b = cursorQuery.getLong(1);
                    c0955Uq.f2882a = cursorQuery.getLong(2);
                    c0955Uq.f2884c = cursorQuery.getLong(3);
                    c0955Uq.f2885d = cursorQuery.getLong(4);
                    c0955Uq.f2886e = cursorQuery.getLong(5);
                    c0955Uq.f2887f = cursorQuery.getLong(6);
                }
                if (z) {
                    c0955Uq.f2883b += j2;
                }
                if (z2) {
                    c0955Uq.f2882a += j2;
                }
                if (z3) {
                    c0955Uq.f2884c += j2;
                }
                if (z4) {
                    c0955Uq.f2885d += j2;
                }
                if (z5) {
                    c0955Uq.f2886e += j2;
                }
                if (z6) {
                    c0955Uq.f2887f += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(c0955Uq.f2882a));
                contentValues.put("daily_events_count", Long.valueOf(c0955Uq.f2883b));
                contentValues.put("daily_conversions_count", Long.valueOf(c0955Uq.f2884c));
                contentValues.put("daily_error_events_count", Long.valueOf(c0955Uq.f2885d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(c0955Uq.f2886e));
                contentValues.put("daily_realtime_dcu_count", Long.valueOf(c0955Uq.f2887f));
                sQLiteDatabaseM2467B.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return c0955Uq;
            } catch (SQLiteException e) {
                mo349g().m9618G().m10618c("Error updating daily counts. appId", C2356sx.m9613v(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return c0955Uq;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final Map m2496P0(String str, String str2) {
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4795d(str2);
        C2453v1 c2453v1 = new C2453v1();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = m2467B().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        C2124nw c2124nw = (C2124nw) ((AbstractC0703PC) ((C2124nw.a) C2145oG.m8894P(C2124nw.m8799I(), cursorQuery.getBlob(1))).m3526o());
                        int i = cursorQuery.getInt(0);
                        List arrayList = (List) c2453v1.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            c2453v1.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(c2124nw);
                    } catch (IOException e) {
                        mo349g().m9618G().m10618c("Failed to merge filter", C2356sx.m9613v(str), e);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return c2453v1;
            } catch (SQLiteException e2) {
                mo349g().m9618G().m10618c("Database error querying filters. appId", C2356sx.m9613v(str), e2);
                Map mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final C0955Uq m2497Q(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return m2495P(j, str, 1L, false, false, z3, false, z5, z6);
    }

    public final C1981kr m2498Q0(String str) {
        AbstractC1085Xi.m4801j(str);
        mo356n();
        m10440u();
        return C1981kr.m8309d(m2487L("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final C0425JA m2499R0(String str) {
        AbstractC1085Xi.m4801j(str);
        mo356n();
        m10440u();
        return C0425JA.m1850q(m2487L("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void m2500S0(String str, String str2) {
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4795d(str2);
        mo356n();
        m10440u();
        try {
            m2467B().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            mo349g().m9618G().m10619d("Error deleting user property. appId", C2356sx.m9613v(str), mo350h().m9213g(str2), e);
        }
    }

    public final C0425JA m2501T0(String str) {
        AbstractC1085Xi.m4801j(str);
        mo356n();
        m10440u();
        C0425JA c0425ja = (C0425JA) m2483J("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new InterfaceC1047Wq() {
            @Override
            public final Object mo3707a(Cursor cursor) {
                return C0425JA.m1846i(cursor.getString(0), cursor.getInt(1));
            }
        });
        return c0425ja == null ? C0425JA.f1295c : c0425ja;
    }

    public final void m2502U(Long l) throws SQLException {
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(l);
        if ((!C2470vI.m10339a() || mo347e().m10818t(AbstractC0818Rr.f2430A0)) && m2540o0()) {
            if (m2470C0("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                mo349g().m9623L().m10616a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                m2467B().execSQL("UPDATE upload_queue SET retry_count = retry_count + 1 WHERE rowid = " + l + " AND retry_count < 2147483647");
            } catch (SQLiteException e) {
                mo349g().m9618G().m10617b("Error incrementing retry count. error", e);
            }
        }
    }

    public final void m2503U0(String str, String str2) {
        AbstractC1085Xi.m4795d(str2);
        mo356n();
        m10440u();
        try {
            m2467B().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error deleting snapshot. appId", C2356sx.m9613v(str2), e);
        }
    }

    public final void m2504V(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseM2467B = m2467B();
            if (contentValues.getAsString(str2) == null) {
                mo349g().m9619H().m10617b("Value of the primary key is not set.", C2356sx.m9613v(str2));
                return;
            }
            if (sQLiteDatabaseM2467B.update(str, contentValues, str2 + " = ?", new String[]{r1}) == 0 && sQLiteDatabaseM2467B.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                mo349g().m9618G().m10618c("Failed to insert/update table (got -1). key", C2356sx.m9613v(str), C2356sx.m9613v(str2));
            }
        } catch (SQLiteException e) {
            mo349g().m9618G().m10619d("Error storing into table. key", C2356sx.m9613v(str), C2356sx.m9613v(str2), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0171  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C1680eG m2505V0(String r15) throws Throwable {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2505V0(java.lang.String):eG");
    }

    public final void m2506W(String str, List list) {
        boolean z;
        C2540wx c2540wxM9623L;
        String str2;
        Object objM9613v;
        Integer numValueOf;
        boolean z2;
        AbstractC1085Xi.m4801j(list);
        for (int i = 0; i < list.size(); i++) {
            C1940jw.a aVarM8221v = (C1940jw.a) ((C1940jw) list.get(i)).m3517y();
            if (aVarM8221v.m8219t() != 0) {
                for (int i2 = 0; i2 < aVarM8221v.m8219t(); i2++) {
                    C1986kw.a aVar = (C1986kw.a) aVarM8221v.m8222w(i2).m3517y();
                    C1986kw.a aVar2 = (C1986kw.a) ((AbstractC0703PC.b) aVar.clone());
                    String strM3492b = AbstractC0701PA.m3492b(aVar.m8339x());
                    if (strM3492b != null) {
                        aVar2.m8337v(strM3492b);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < aVar.m8335t(); i3++) {
                        C2032lw c2032lwM8338w = aVar.m8338w(i3);
                        String strM3307a = AbstractC0609NA.m3307a(c2032lwM8338w.m8420L());
                        if (strM3307a != null) {
                            aVar2.m8336u(i3, (C2032lw) ((AbstractC0703PC) ((C2032lw.a) c2032lwM8338w.m3517y()).m8426t(strM3307a).m3526o()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        C1940jw.a aVarM8220u = aVarM8221v.m8220u(i2, aVar2);
                        list.set(i, (C1940jw) ((AbstractC0703PC) aVarM8220u.m3526o()));
                        aVarM8221v = aVarM8220u;
                    }
                }
            }
            if (aVarM8221v.m8223x() != 0) {
                for (int i4 = 0; i4 < aVarM8221v.m8223x(); i4++) {
                    C2124nw c2124nwM8224y = aVarM8221v.m8224y(i4);
                    String strM4118a = AbstractC0884TA.m4118a(c2124nwM8224y.m8802K());
                    if (strM4118a != null) {
                        aVarM8221v = aVarM8221v.m8221v(i4, ((C2124nw.a) c2124nwM8224y.m3517y()).m8809t(strM4118a));
                        list.set(i, (C1940jw) ((AbstractC0703PC) aVarM8221v.m3526o()));
                    }
                }
            }
        }
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4801j(list);
        SQLiteDatabase sQLiteDatabaseM2467B = m2467B();
        sQLiteDatabaseM2467B.beginTransaction();
        try {
            m10440u();
            mo356n();
            AbstractC1085Xi.m4795d(str);
            SQLiteDatabase sQLiteDatabaseM2467B2 = m2467B();
            sQLiteDatabaseM2467B2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseM2467B2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C1940jw c1940jw = (C1940jw) it.next();
                m10440u();
                mo356n();
                AbstractC1085Xi.m4795d(str);
                AbstractC1085Xi.m4801j(c1940jw);
                if (c1940jw.m8217P()) {
                    int iM8218j = c1940jw.m8218j();
                    Iterator it2 = c1940jw.m8215N().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((C1986kw) it2.next()).m8332T()) {
                                c2540wxM9623L = mo349g().m9623L();
                                str2 = "Event filter with no ID. Audience definition ignored. appId, audienceId";
                                objM9613v = C2356sx.m9613v(str);
                                numValueOf = Integer.valueOf(iM8218j);
                                break;
                            }
                        } else {
                            Iterator it3 = c1940jw.m8216O().iterator();
                            while (it3.hasNext()) {
                                if (!((C2124nw) it3.next()).m8806O()) {
                                    c2540wxM9623L = mo349g().m9623L();
                                    str2 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
                                    objM9613v = C2356sx.m9613v(str);
                                    numValueOf = Integer.valueOf(iM8218j);
                                }
                            }
                            Iterator it4 = c1940jw.m8215N().iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    if (!m2522e0(str, iM8218j, (C1986kw) it4.next())) {
                                        z = false;
                                        break;
                                    }
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                Iterator it5 = c1940jw.m8216O().iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        if (!m2524f0(str, iM8218j, (C2124nw) it5.next())) {
                                            z = false;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            if (!z) {
                                m10440u();
                                mo356n();
                                AbstractC1085Xi.m4795d(str);
                                SQLiteDatabase sQLiteDatabaseM2467B3 = m2467B();
                                sQLiteDatabaseM2467B3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iM8218j)});
                                sQLiteDatabaseM2467B3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iM8218j)});
                            }
                        }
                    }
                    c2540wxM9623L.m10618c(str2, objM9613v, numValueOf);
                    break;
                }
                mo349g().m9623L().m10617b("Audience with no ID. appId", C2356sx.m9613v(str));
            }
            ArrayList arrayList = new ArrayList<>();
            Iterator it6 = list.iterator();
            while (it6.hasNext()) {
                C1940jw c1940jw2 = (C1940jw) it6.next();
                arrayList.add(c1940jw2.m8217P() ? Integer.valueOf(c1940jw2.m8218j()) : null);
            }
            m2476F0(str, arrayList);
            sQLiteDatabaseM2467B.setTransactionSuccessful();
            sQLiteDatabaseM2467B.endTransaction();
        } catch (Throwable th) {
            sQLiteDatabaseM2467B.endTransaction();
            throw th;
        }
    }

    public final List m2507W0(String str) {
        AbstractC1085Xi.m4795d(str);
        mo356n();
        m10440u();
        ArrayList arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = m2467B().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new C1913jF(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                mo349g().m9618G().m10618c("Error querying trigger uris. appId", C2356sx.m9613v(str), e);
                List listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final void m2508X(String str, C1981kr c1981kr) {
        AbstractC1085Xi.m4801j(str);
        AbstractC1085Xi.m4801j(c1981kr);
        mo356n();
        m10440u();
        if (mo347e().m10818t(AbstractC0818Rr.f2464R0)) {
            C0425JA c0425jaM2501T0 = m2501T0(str);
            C0425JA c0425ja = C0425JA.f1295c;
            if (c0425jaM2501T0 == c0425ja) {
                m2474E0(str, c0425ja);
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", c1981kr.m8316j());
        m2504V("consent_settings", "app_id", contentValues);
    }

    public final List m2509X0(String str) {
        AbstractC1085Xi.m4795d(str);
        mo356n();
        m10440u();
        ArrayList arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = m2467B().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = cursorQuery.getLong(2);
                    Object objM2481I = m2481I(cursorQuery, 3);
                    if (objM2481I == null) {
                        mo349g().m9618G().m10617b("Read invalid user property value, ignoring it. appId", C2356sx.m9613v(str));
                    } else {
                        arrayList.add(new C2238qG(str, str2, string, j, objM2481I));
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e) {
                mo349g().m9618G().m10618c("Error querying user properties. appId", C2356sx.m9613v(str), e);
                List listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final void m2510Y(String str, C0267Fr c0267Fr) {
        AbstractC1085Xi.m4801j(c0267Fr);
        mo356n();
        m10440u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c0267Fr.f683a);
        contentValues.put("name", c0267Fr.f684b);
        contentValues.put("lifetime_count", Long.valueOf(c0267Fr.f685c));
        contentValues.put("current_bundle_count", Long.valueOf(c0267Fr.f686d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c0267Fr.f688f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(c0267Fr.f689g));
        contentValues.put("last_bundled_day", c0267Fr.f690h);
        contentValues.put("last_sampled_complex_event_id", c0267Fr.f691i);
        contentValues.put("last_sampling_rate", c0267Fr.f692j);
        contentValues.put("current_session_count", Long.valueOf(c0267Fr.f687e));
        Boolean bool = c0267Fr.f693k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (m2467B().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                mo349g().m9618G().m10617b("Failed to insert/update event aggregates (got -1). appId", C2356sx.m9613v(c0267Fr.f683a));
            }
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing event aggregates. appId", C2356sx.m9613v(c0267Fr.f683a), e);
        }
    }

    public final Map m2511Y0(String str) {
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = m2467B().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                C2453v1 c2453v1 = new C2453v1();
                do {
                    int i = cursorQuery.getInt(0);
                    try {
                        c2453v1.put(Integer.valueOf(i), (C0687Ox) ((AbstractC0703PC) ((C0687Ox.a) C2145oG.m8894P(C0687Ox.m3454R(), cursorQuery.getBlob(1))).m3526o()));
                    } catch (IOException e) {
                        mo349g().m9618G().m10619d("Failed to merge filter results. appId, audienceId, error", C2356sx.m9613v(str), Integer.valueOf(i), e);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return c2453v1;
            } catch (SQLiteException e2) {
                mo349g().m9618G().m10618c("Database error querying filter results. appId", C2356sx.m9613v(str), e2);
                Map mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void m2512Z(String str, C0425JA c0425ja) {
        AbstractC1085Xi.m4801j(str);
        AbstractC1085Xi.m4801j(c0425ja);
        mo356n();
        m10440u();
        m2474E0(str, m2501T0(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", c0425ja.m1867z());
        m2504V("consent_settings", "app_id", contentValues);
    }

    public final Map m2513Z0(String str) {
        AbstractC1085Xi.m4795d(str);
        C2453v1 c2453v1 = new C2453v1();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = m2467B().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        C1986kw c1986kw = (C1986kw) ((AbstractC0703PC) ((C1986kw.a) C2145oG.m8894P(C1986kw.m8321K(), cursorQuery.getBlob(1))).m3526o());
                        if (c1986kw.m8331S()) {
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) c2453v1.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                                c2453v1.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(c1986kw);
                        }
                    } catch (IOException e) {
                        mo349g().m9618G().m10618c("Failed to merge filter. appId", C2356sx.m9613v(str), e);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return c2453v1;
            } catch (SQLiteException e2) {
                mo349g().m9618G().m10618c("Database error querying filters. appId", C2356sx.m9613v(str), e2);
                Map mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void m2514a0(List list) throws SQLException {
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(list);
        AbstractC1085Xi.m4803l(list.size());
        if (m2540o0()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (m2470C0("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                mo349g().m9623L().m10616a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                m2467B().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                mo349g().m9618G().m10617b("Error incrementing retry count. error", e);
            }
        }
    }

    public final Map m2515a1(String str) {
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        C2453v1 c2453v1 = new C2453v1();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = m2467B().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!cursorRawQuery.moveToFirst()) {
                    Map mapEmptyMap = Collections.emptyMap();
                    cursorRawQuery.close();
                    return mapEmptyMap;
                }
                do {
                    int i = cursorRawQuery.getInt(0);
                    List arrayList = (List) c2453v1.get(Integer.valueOf(i));
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        c2453v1.put(Integer.valueOf(i), arrayList);
                    }
                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                } while (cursorRawQuery.moveToNext());
                cursorRawQuery.close();
                return c2453v1;
            } catch (SQLiteException e) {
                mo349g().m9618G().m10618c("Database error querying scoped filters. appId", C2356sx.m9613v(str), e);
                Map mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void m2516b0(C0267Fr c0267Fr) {
        m2510Y("events", c0267Fr);
    }

    public final void m2517b1() {
        m10440u();
        m2467B().beginTransaction();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2518c0(C2403ty r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 881
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2518c0(ty, boolean, boolean):void");
    }

    public final void m2519c1(String str) {
        mo356n();
        m10440u();
        try {
            m2467B().execSQL("delete from default_event_params where app_id=?", new String[]{str});
        } catch (SQLiteException e) {
            mo349g().m9618G().m10617b("Error clearing default event params", e);
        }
    }

    public final boolean m2520d0(long j, C2672zr c2672zr, long j2, boolean z) {
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(c2672zr);
        AbstractC1085Xi.m4795d(c2672zr.f8281a);
        byte[] bArrM4464i = mo3244o().m8917N(c2672zr).m4464i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c2672zr.f8281a);
        contentValues.put("name", c2672zr.f8282b);
        contentValues.put("timestamp", Long.valueOf(c2672zr.f8284d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", bArrM4464i);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            long jUpdate = m2467B().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
            if (jUpdate == 1) {
                return true;
            }
            mo349g().m9618G().m10618c("Failed to update raw event. appId, updatedRows", C2356sx.m9613v(c2672zr.f8281a), Long.valueOf(jUpdate));
            return false;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error updating raw event. appId", C2356sx.m9613v(c2672zr.f8281a), e);
            return false;
        }
    }

    public final void m2521d1(String str) {
        C0267Fr c0267FrM2486K0;
        m2503U0("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = m2467B().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string != null && (c0267FrM2486K0 = m2486K0(str, string)) != null) {
                        m2510Y("events_snapshot", c0267FrM2486K0);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            } catch (SQLiteException e) {
                mo349g().m9618G().m10618c("Error creating snapshot. appId", C2356sx.m9613v(str), e);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final boolean m2522e0(String str, int i, C1986kw c1986kw) {
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4801j(c1986kw);
        if (c1986kw.m8326N().isEmpty()) {
            mo349g().m9623L().m10619d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", C2356sx.m9613v(str), Integer.valueOf(i), String.valueOf(c1986kw.m8332T() ? Integer.valueOf(c1986kw.m8324J()) : null));
            return false;
        }
        byte[] bArrM4464i = c1986kw.m4464i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", c1986kw.m8332T() ? Integer.valueOf(c1986kw.m8324J()) : null);
        contentValues.put("event_name", c1986kw.m8326N());
        contentValues.put("session_scoped", c1986kw.m8333U() ? Boolean.valueOf(c1986kw.m8330R()) : null);
        contentValues.put("data", bArrM4464i);
        try {
            if (m2467B().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            mo349g().m9618G().m10617b("Failed to insert event filter (got -1). appId", C2356sx.m9613v(str));
            return true;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing event filter. appId", C2356sx.m9613v(str), e);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2523e1(String r20) throws Throwable {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0496Kq.m2523e1(java.lang.String):void");
    }

    public final boolean m2524f0(String str, int i, C2124nw c2124nw) {
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4801j(c2124nw);
        if (c2124nw.m8802K().isEmpty()) {
            mo349g().m9623L().m10619d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", C2356sx.m9613v(str), Integer.valueOf(i), String.valueOf(c2124nw.m8806O() ? Integer.valueOf(c2124nw.m8808j()) : null));
            return false;
        }
        byte[] bArrM4464i = c2124nw.m4464i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", c2124nw.m8806O() ? Integer.valueOf(c2124nw.m8808j()) : null);
        contentValues.put("property_name", c2124nw.m8802K());
        contentValues.put("session_scoped", c2124nw.m8807P() ? Boolean.valueOf(c2124nw.m8805N()) : null);
        contentValues.put("data", bArrM4464i);
        try {
            if (m2467B().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            mo349g().m9618G().m10617b("Failed to insert property filter (got -1). appId", C2356sx.m9613v(str));
            return false;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing property filter. appId", C2356sx.m9613v(str), e);
            return false;
        }
    }

    public final boolean m2525f1(String str) {
        if (C2470vI.m10339a() && !mo347e().m10818t(AbstractC0818Rr.f2430A0)) {
            return false;
        }
        String strM2544z0 = m2544z0();
        StringBuilder sb = new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE ");
        sb.append(strM2544z0);
        return m2470C0(sb.toString(), new String[]{str}) != 0;
    }

    public final boolean m2526g0(String str, Bundle bundle) {
        mo356n();
        m10440u();
        byte[] bArrM4464i = mo3244o().m8917N(new C2672zr(this.f8058a, "", str, "dep", 0L, 0L, bundle)).m4464i();
        mo349g().m9622K().m10618c("Saving default event parameters, appId, data size", mo350h().m9209b(str), Integer.valueOf(bArrM4464i.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrM4464i);
        try {
            if (m2467B().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            mo349g().m9618G().m10617b("Failed to insert default event parameters (got -1). appId", C2356sx.m9613v(str));
            return false;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing default event parameters. appId", C2356sx.m9613v(str), e);
            return false;
        }
    }

    public final void m2527g1() {
        m10440u();
        m2467B().endTransaction();
    }

    public final boolean m2528h0(String str, Long l, long j, C0365Hx c0365Hx) {
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(c0365Hx);
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4801j(l);
        byte[] bArrM4464i = c0365Hx.m4464i();
        mo349g().m9622K().m10618c("Saving complex main event, appId, data size", mo350h().m9209b(str), Integer.valueOf(bArrM4464i.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrM4464i);
        try {
            if (m2467B().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            mo349g().m9618G().m10617b("Failed to insert complex main event (got -1). appId", C2356sx.m9613v(str));
            return false;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing complex main event. appId", C2356sx.m9613v(str), e);
            return false;
        }
    }

    public final void m2529h1() {
        int iDelete;
        mo356n();
        m10440u();
        if (m2540o0()) {
            long jM9085a = mo3248s().f7389e.m9085a();
            long jMo2817c = mo345b().mo2817c();
            if (Math.abs(jMo2817c - jM9085a) > C2579xq.m10789U()) {
                mo3248s().f7389e.m9086b(jMo2817c);
                mo356n();
                m10440u();
                if (!m2540o0() || (iDelete = m2467B().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(mo345b().mo2815a()), String.valueOf(C2579xq.m10788T())})) <= 0) {
                    return;
                }
                mo349g().m9622K().m10617b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    public final boolean m2530i0(String str, C0549Lx c0549Lx, String str2, Map map, EnumC0016AF enumC0016AF) {
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(c0549Lx);
        AbstractC1085Xi.m4795d(str);
        if (C2470vI.m10339a() && !mo347e().m10818t(AbstractC0818Rr.f2430A0)) {
            return false;
        }
        mo356n();
        m10440u();
        if (m2540o0()) {
            long jM9085a = mo3248s().f7390f.m9085a();
            long jMo2817c = mo345b().mo2817c();
            if (Math.abs(jMo2817c - jM9085a) > C2579xq.m10789U()) {
                mo3248s().f7390f.m9086b(jMo2817c);
                mo356n();
                m10440u();
                if (m2540o0()) {
                    SQLiteDatabase sQLiteDatabaseM2467B = m2467B();
                    mo345b().mo2815a();
                    EnumC0016AF enumC0016AF2 = EnumC0016AF.GOOGLE_SIGNAL;
                    enumC0016AF2.m70a();
                    C2579xq.m10786R();
                    enumC0016AF2.m70a();
                    C2579xq.m10788T();
                    int iDelete = sQLiteDatabaseM2467B.delete("upload_queue", "ABS(creation_timestamp - ?) > CAST(? as integer)", new String[0]);
                    if (iDelete > 0) {
                        mo349g().m9622K().m10617b("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
        }
        byte[] bArrM4464i = c0549Lx.m4464i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrM4464i);
        contentValues.put("upload_uri", str2);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        if (size > 0) {
            sb.append((CharSequence) arrayList.get(0));
            int i = 1;
            while (i < size) {
                sb.append((CharSequence) "\r\n");
                Object obj = arrayList.get(i);
                i++;
                sb.append((CharSequence) obj);
            }
        }
        contentValues.put("upload_headers", sb.toString());
        contentValues.put("upload_type", Integer.valueOf(enumC0016AF.m70a()));
        contentValues.put("creation_timestamp", Long.valueOf(mo345b().mo2815a()));
        contentValues.put("retry_count", (Integer) 0);
        try {
            if (m2467B().insert("upload_queue", null, contentValues) != -1) {
                return true;
            }
            mo349g().m9618G().m10617b("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return false;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing MeasurementBatch to upload_queue. appId", str, e);
            return false;
        }
    }

    public final void m2531i1() {
        m10440u();
        m2467B().setTransactionSuccessful();
    }

    public final boolean m2532j0(String str, C1913jF c1913jF) {
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(c1913jF);
        AbstractC1085Xi.m4795d(str);
        long jMo2815a = mo345b().mo2815a();
        if (c1913jF.f5938m < jMo2815a - C2579xq.m10788T() || c1913jF.f5938m > C2579xq.m10788T() + jMo2815a) {
            mo349g().m9623L().m10619d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", C2356sx.m9613v(str), Long.valueOf(jMo2815a), Long.valueOf(c1913jF.f5938m));
        }
        mo349g().m9622K().m10616a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", c1913jF.f5937l);
        contentValues.put("source", Integer.valueOf(c1913jF.f5939n));
        contentValues.put("timestamp_millis", Long.valueOf(c1913jF.f5938m));
        try {
            if (m2467B().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            mo349g().m9618G().m10617b("Failed to insert trigger URI (got -1). appId", C2356sx.m9613v(str));
            return false;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing trigger URI. appId", C2356sx.m9613v(str), e);
            return false;
        }
    }

    public final boolean m2533j1() {
        return m2470C0("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean m2534k0(C2303rq c2303rq) {
        AbstractC1085Xi.m4801j(c2303rq);
        mo356n();
        m10440u();
        String str = c2303rq.f6976l;
        AbstractC1085Xi.m4801j(str);
        if (m2490M0(str, c2303rq.f6978n.f6158m) == null && m2470C0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", c2303rq.f6977m);
        contentValues.put("name", c2303rq.f6978n.f6158m);
        m2454T(contentValues, "value", AbstractC1085Xi.m4801j(c2303rq.f6978n.m8448d()));
        contentValues.put("active", Boolean.valueOf(c2303rq.f6980p));
        contentValues.put("trigger_event_name", c2303rq.f6981q);
        contentValues.put("trigger_timeout", Long.valueOf(c2303rq.f6983s));
        mo352j();
        contentValues.put("timed_out_event", C2514wG.m10470q0(c2303rq.f6982r));
        contentValues.put("creation_timestamp", Long.valueOf(c2303rq.f6979o));
        mo352j();
        contentValues.put("triggered_event", C2514wG.m10470q0(c2303rq.f6984t));
        contentValues.put("triggered_timestamp", Long.valueOf(c2303rq.f6978n.f6159n));
        contentValues.put("time_to_live", Long.valueOf(c2303rq.f6985u));
        mo352j();
        contentValues.put("expired_event", C2514wG.m10470q0(c2303rq.f6986v));
        try {
            if (m2467B().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            mo349g().m9618G().m10617b("Failed to insert/update conditional user property (got -1)", C2356sx.m9613v(str));
            return true;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing conditional user property", C2356sx.m9613v(str), e);
            return true;
        }
    }

    public final boolean m2535k1() {
        return m2470C0("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final boolean m2536l0(C2672zr c2672zr, long j, boolean z) {
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(c2672zr);
        AbstractC1085Xi.m4795d(c2672zr.f8281a);
        byte[] bArrM4464i = mo3244o().m8917N(c2672zr).m4464i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c2672zr.f8281a);
        contentValues.put("name", c2672zr.f8282b);
        contentValues.put("timestamp", Long.valueOf(c2672zr.f8284d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrM4464i);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (m2467B().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            mo349g().m9618G().m10617b("Failed to insert raw event (got -1). appId", C2356sx.m9613v(c2672zr.f8281a));
            return false;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing raw event. appId", C2356sx.m9613v(c2672zr.f8281a), e);
            return false;
        }
    }

    public final boolean m2537l1() {
        return m2470C0("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final boolean m2538m0(C0595Mx c0595Mx, boolean z) {
        C2540wx c2540wxM9618G;
        Object objM9613v;
        String str;
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(c0595Mx);
        AbstractC1085Xi.m4795d(c0595Mx.m3117x2());
        AbstractC1085Xi.m4804m(c0595Mx.m3052L0());
        m2529h1();
        long jMo2815a = mo345b().mo2815a();
        if (c0595Mx.m3081c2() < jMo2815a - C2579xq.m10788T() || c0595Mx.m3081c2() > C2579xq.m10788T() + jMo2815a) {
            mo349g().m9623L().m10619d("Storing bundle outside of the max uploading time span. appId, now, timestamp", C2356sx.m9613v(c0595Mx.m3117x2()), Long.valueOf(jMo2815a), Long.valueOf(c0595Mx.m3081c2()));
        }
        try {
            byte[] bArrM8925i0 = mo3244o().m8925i0(c0595Mx.m4464i());
            mo349g().m9622K().m10617b("Saving bundle, size", Integer.valueOf(bArrM8925i0.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", c0595Mx.m3117x2());
            contentValues.put("bundle_end_timestamp", Long.valueOf(c0595Mx.m3081c2()));
            contentValues.put("data", bArrM8925i0);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (c0595Mx.m3061S0()) {
                contentValues.put("retry_count", Integer.valueOf(c0595Mx.m3040B1()));
            }
            try {
                if (m2467B().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                mo349g().m9618G().m10617b("Failed to insert bundle (got -1). appId", C2356sx.m9613v(c0595Mx.m3117x2()));
                return false;
            } catch (SQLiteException e) {
                e = e;
                c2540wxM9618G = mo349g().m9618G();
                objM9613v = C2356sx.m9613v(c0595Mx.m3117x2());
                str = "Error storing bundle. appId";
                c2540wxM9618G.m10618c(str, objM9613v, e);
                return false;
            }
        } catch (IOException e2) {
            e = e2;
            c2540wxM9618G = mo349g().m9618G();
            objM9613v = C2356sx.m9613v(c0595Mx.m3117x2());
            str = "Data loss. Failed to serialize bundle. appId";
        }
    }

    public final boolean m2539n0(C2238qG c2238qG) {
        AbstractC1085Xi.m4801j(c2238qG);
        mo356n();
        m10440u();
        if (m2490M0(c2238qG.f6716a, c2238qG.f6718c) == null) {
            if (C2514wG.m10454L0(c2238qG.f6718c)) {
                if (m2470C0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{c2238qG.f6716a}) >= mo347e().m10815q(c2238qG.f6716a, AbstractC0818Rr.f2447J, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(c2238qG.f6718c) && m2470C0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{c2238qG.f6716a, c2238qG.f6717b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", c2238qG.f6716a);
        contentValues.put("origin", c2238qG.f6717b);
        contentValues.put("name", c2238qG.f6718c);
        contentValues.put("set_timestamp", Long.valueOf(c2238qG.f6719d));
        m2454T(contentValues, "value", c2238qG.f6720e);
        try {
            if (m2467B().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            mo349g().m9618G().m10617b("Failed to insert/update user property (got -1). appId", C2356sx.m9613v(c2238qG.f6716a));
            return true;
        } catch (SQLiteException e) {
            mo349g().m9618G().m10618c("Error storing user property. appId", C2356sx.m9613v(c2238qG.f6716a), e);
            return true;
        }
    }

    public final boolean m2540o0() {
        return mo344a().getDatabasePath("google_app_measurement.db").exists();
    }

    @Override
    public final boolean mo2541x() {
        return false;
    }

    public final long m2542y() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = m2467B().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                mo349g().m9618G().m10617b("Error querying raw events", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long m2543z() {
        return m2475F("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final String m2544z0() {
        long jMo2815a = mo345b().mo2815a();
        EnumC0016AF enumC0016AF = EnumC0016AF.GOOGLE_SIGNAL;
        return "app_id=? AND (" + ("(upload_type = " + enumC0016AF.m70a() + " AND (ABS(creation_timestamp - " + jMo2815a + ") <= CAST(" + C2579xq.m10786R() + " AS INTEGER)))") + " OR" + ("(upload_type != " + enumC0016AF.m70a() + " AND (ABS(creation_timestamp - " + jMo2815a + ") <= CAST(" + C2579xq.m10788T() + " AS INTEGER)))") + ")";
    }
}
