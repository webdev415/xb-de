package p000;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class C0413Iz implements InterfaceC0643Nz {

    public static final Map f1238h = new ScriptMap();

    public static final String[] f1239i = {"key", "value"};

    public final ContentResolver f1240a;

    public final Uri f1241b;

    public final Runnable f1242c;

    public final ContentObserver f1243d;

    public final Object f1244e;

    public volatile Map f1245f;

    public final List f1246g;

    public C0413Iz(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        C0551Lz c0551Lz = new C0551Lz(this, null);
        this.f1243d = c0551Lz;
        this.f1244e = new Object();
        this.f1246g = new ArrayList<>();
        AbstractC1131Yi.m4973i(contentResolver);
        AbstractC1131Yi.m4973i(uri);
        this.f1240a = contentResolver;
        this.f1241b = uri;
        this.f1242c = runnable;
        contentResolver.registerContentObserver(uri, false, c0551Lz);
    }

    public static C0413Iz m1757b(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        C0413Iz c0413Iz;
        synchronized (C0413Iz.class) {
            Map map = f1238h;
            c0413Iz = (C0413Iz) map.get(uri);
            if (c0413Iz == null) {
                try {
                    C0413Iz c0413Iz2 = new C0413Iz(contentResolver, uri, runnable);
                    try {
                        map.put(uri, c0413Iz2);
                    } catch (SecurityException unused) {
                    }
                    c0413Iz = c0413Iz2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return c0413Iz;
    }

    public static synchronized void m1758d() {
        try {
            for (C0413Iz c0413Iz : f1238h.values()) {
                c0413Iz.f1240a.unregisterContentObserver(c0413Iz.f1243d);
            }
            f1238h.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Map m1759a() {
        Map mapM1762f = this.f1245f;
        if (mapM1762f == null) {
            synchronized (this.f1244e) {
                try {
                    mapM1762f = this.f1245f;
                    if (mapM1762f == null) {
                        mapM1762f = m1762f();
                        this.f1245f = mapM1762f;
                    }
                } finally {
                }
            }
        }
        return mapM1762f != null ? mapM1762f : Collections.emptyMap();
    }

    public final Map m1760c() {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = this.f1240a.acquireUnstableContentProviderClient(this.f1241b);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.emptyMap();
            }
            Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(this.f1241b, f1239i, null, null, null);
            try {
                if (cursorQuery == null) {
                    Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                    Map mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                int count = cursorQuery.getCount();
                if (count == 0) {
                    Map mapEmptyMap2 = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap2;
                }
                Map c2453v1 = count <= 256 ? new ScriptMap(count) : new HashMap<>(count, 1.0f);
                while (cursorQuery.moveToNext()) {
                    c2453v1.put(cursorQuery.getString(0), cursorQuery.getString(1));
                }
                if (cursorQuery.isAfterLast()) {
                    cursorQuery.close();
                    return c2453v1;
                }
                Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                Map mapEmptyMap3 = Collections.emptyMap();
                cursorQuery.close();
                return mapEmptyMap3;
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (RemoteException e) {
            Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
            return Collections.emptyMap();
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
    }

    public final void m1761e() {
        synchronized (this.f1244e) {
            this.f1245f = null;
            this.f1242c.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.f1246g.iterator();
                if (it.hasNext()) {
                    AbstractC2524wh.m10586a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map m1762f() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) AbstractC0918Tz.m4186a(new InterfaceC0826Rz() {
                    @Override
                    public final Object mo1461a() {
                        return this.f997a.m1760c();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException e) {
                Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                return Collections.emptyMap();
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    @Override
    public final Object mo1365g(String str) {
        return (String) m1759a().get(str);
    }
}
