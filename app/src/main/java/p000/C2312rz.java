package p000;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import java.util.Map;

public final class C2312rz implements InterfaceC2496vz {
    @Override
    public final Map mo9453a(ContentResolver contentResolver, String[] strArr, InterfaceC2220pz interfaceC2220pz) throws C2404tz {
        Uri uri = AbstractC1803gz.f5669b;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
            throw new C2404tz("Unable to acquire ContentProviderClient");
        }
        try {
            try {
                Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, strArr, null);
                try {
                    if (cursorQuery == null) {
                        throw new C2404tz("ContentProvider query returned null cursor");
                    }
                    Map mapMo8814e = interfaceC2220pz.mo8814e(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        mapMo8814e.put(cursorQuery.getString(0), cursorQuery.getString(1));
                    }
                    if (!cursorQuery.isAfterLast()) {
                        throw new C2404tz("Cursor read incomplete (ContentProvider dead?)");
                    }
                    cursorQuery.close();
                    return mapMo8814e;
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
                throw new C2404tz("ContentProvider query failed", e);
            }
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
    }

    @Override
    public final String mo9454b(ContentResolver contentResolver, String str) throws C2404tz {
        Uri uri = AbstractC1803gz.f5668a;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                throw new C2404tz("Unable to acquire ContentProviderClient");
            }
            try {
                Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, new String[]{str}, null);
                try {
                    if (cursorQuery == null) {
                        throw new C2404tz("ContentProvider query returned null cursor");
                    }
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(1);
                        cursorQuery.close();
                        return string;
                    }
                    cursorQuery.close();
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return null;
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
                throw new C2404tz("ContentProvider query failed", e);
            }
        } finally {
            contentProviderClientAcquireUnstableContentProviderClient.release();
        }
    }
}
