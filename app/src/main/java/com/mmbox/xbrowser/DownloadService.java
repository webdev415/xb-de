package com.mmbox.xbrowser;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.mmbox.xbrowser.BrowserDownloadManager;
import java.util.HashMap;
import java.util.Iterator;

public class DownloadService extends Service {

    public Handler f4498b;

    public Runnable f4499c;

    public long f4501e;

    public int f4497a = 0;

    public boolean f4500d = false;

    public HashMap f4502f = new HashMap<>();

    public class C1516a implements BrowserDownloadManager.k {

        public final BrowserDownloadManager.i f4503a;

        public C1516a(BrowserDownloadManager.i iVar) {
            this.f4503a = iVar;
        }

        @Override
        public void mo6506a() {
            Log.d("DownloadService", "Download failed for id: " + this.f4503a.f4644a);
            DownloadService.this.m6498h(this.f4503a.f4644a);
            DownloadService.this.m6499i();
        }

        @Override
        public void mo6507b() {
            Log.d("DownloadService", "Download finished for id: " + this.f4503a.f4644a);
            DownloadService.this.m6498h(this.f4503a.f4644a);
            DownloadService.this.m6499i();
            DownloadService.this.stopForeground(true);
        }
    }

    public class RunnableC1517b implements Runnable {
        public RunnableC1517b() {
        }

        @Override
        public void run() {
            Log.d("DownloadService", "Service idle timeout reached, stopping service");
            DownloadService.this.m6504n();
        }
    }

    public class RunnableC1518c implements Runnable {

        public final BrowserDownloadManager.i f4506l;

        public RunnableC1518c(BrowserDownloadManager.i iVar) {
            this.f4506l = iVar;
        }

        @Override
        public void run() {
            DownloadService.this.m6497g(this.f4506l.f4644a);
        }
    }

    public static class C1519d {

        public long f4508a;

        public long f4509b = System.currentTimeMillis();

        public long f4510c = 0;

        public long f4511d = 0;

        public Runnable f4512e;

        public C1519d(long j) {
            this.f4508a = j;
        }

        public long m6508a() {
            return System.currentTimeMillis() - this.f4509b;
        }

        public boolean m6509b() {
            return System.currentTimeMillis() - this.f4509b > 180000;
        }

        public boolean m6510c(long j) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z = j > this.f4510c;
            if (z) {
                this.f4509b = jCurrentTimeMillis;
                this.f4510c = j;
            }
            this.f4511d = j;
            return z;
        }
    }

    public final void m6495e() {
        Runnable runnable = this.f4499c;
        if (runnable != null) {
            this.f4498b.removeCallbacks(runnable);
            this.f4499c = null;
            Log.d("DownloadService", "Cancelled idle timeout protection");
        }
    }

    public final void m6496f() {
        if (this.f4498b != null) {
            m6495e();
            Iterator it = this.f4502f.values().iterator();
            while (it.hasNext()) {
                Runnable runnable = ((C1519d) it.next()).f4512e;
                if (runnable != null) {
                    this.f4498b.removeCallbacks(runnable);
                }
            }
            this.f4502f.clear();
            this.f4498b.removeCallbacksAndMessages(null);
            Log.d("DownloadService", "All timeout protections canceled");
        }
    }

    public final void m6497g(long j) {
        C1519d c1519d = (C1519d) this.f4502f.get(Long.valueOf(j));
        if (c1519d == null) {
            Log.d("DownloadService", "Progress monitor not found for download id: " + j);
            return;
        }
        BrowserDownloadManager.i iVarM6698n = BrowserDownloadManager.m6674q().m6698n(String.valueOf(j));
        if (iVarM6698n == null) {
            Log.d("DownloadService", "Download info not found for id: " + j);
            m6498h(j);
            return;
        }
        boolean zM6510c = c1519d.m6510c(iVarM6698n.f4652i);
        if (!c1519d.m6509b()) {
            long j2 = zM6510c ? 30000L : 10000L;
            if (zM6510c) {
                Log.d("DownloadService", "Download progress detected for id: " + j + ", downloaded: " + iVarM6698n.f4652i + " bytes");
                m6505o();
                m6495e();
            }
            this.f4498b.postDelayed(c1519d.f4512e, j2);
            return;
        }
        Log.w("DownloadService", "Download timeout due to no progress for " + (c1519d.m6508a() / 1000) + " seconds, download id: " + j);
        try {
            BrowserDownloadManager.m6674q().m6676B(String.valueOf(j));
            m6498h(j);
            m6499i();
        } catch (Throwable th) {
            Log.e("DownloadService", "Error handling progress timeout", th);
            m6498h(j);
            m6499i();
        }
    }

    public final void m6498h(long j) {
        Runnable runnable;
        C1519d c1519d = (C1519d) this.f4502f.remove(Long.valueOf(j));
        if (c1519d == null || (runnable = c1519d.f4512e) == null) {
            return;
        }
        this.f4498b.removeCallbacks(runnable);
        Log.d("DownloadService", "Cleaned up progress monitor for download id: " + j);
    }

    public final void m6499i() {
        Log.d("DownloadService", "Task finished/failed, mActiveTasks before: " + this.f4497a);
        synchronized (this) {
            try {
                int i = this.f4497a;
                if (i > 0) {
                    this.f4497a = i - 1;
                }
                Log.d("DownloadService", "mActiveTasks after decrement: " + this.f4497a);
                if (this.f4497a <= 0) {
                    Log.d("DownloadService", "All tasks completed, setting up idle timeout");
                    m6501k();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m6500j(BrowserDownloadManager.i iVar) {
        iVar.f4659p = new C1516a(iVar);
    }

    public final void m6501k() {
        String str;
        Runnable runnable = this.f4499c;
        if (runnable != null) {
            this.f4498b.removeCallbacks(runnable);
        }
        if (this.f4497a <= 0) {
            RunnableC1517b runnableC1517b = new RunnableC1517b();
            this.f4499c = runnableC1517b;
            this.f4498b.postDelayed(runnableC1517b, 120000L);
            str = "Service idle timeout protection set for 120 seconds";
        } else {
            str = "Active tasks present (" + this.f4497a + "), skipping idle timeout";
        }
        Log.d("DownloadService", str);
    }

    public final void m6502l(BrowserDownloadManager.i iVar) {
        C1519d c1519d = new C1519d(iVar.f4644a);
        this.f4502f.put(Long.valueOf(iVar.f4644a), c1519d);
        RunnableC1518c runnableC1518c = new RunnableC1518c(iVar);
        c1519d.f4512e = runnableC1518c;
        this.f4498b.postDelayed(runnableC1518c, 30000L);
        Log.d("DownloadService", "Progress-based timeout protection set for download id: " + iVar.f4644a);
    }

    public final void m6503m(int i, BrowserDownloadManager.i iVar) {
        if (this.f4500d) {
            Log.w("DownloadService", "Service is stopping, cannot start foreground");
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(i, iVar.m6711b().m6722a(), 1);
            } else {
                startForeground(i, iVar.m6711b().m6722a());
            }
            Log.d("DownloadService", "Started foreground service with id: " + i);
        } catch (SecurityException e) {
            Log.w("DownloadService", "startForeground rejected by system: " + e.getMessage());
            m6504n();
        } catch (Throwable th) {
            Log.e("DownloadService", "Failed to startForeground", th);
            m6504n();
        }
    }

    public final void m6504n() {
        if (this.f4500d) {
            Log.d("DownloadService", "Service already stopping, ignoring duplicate call");
            return;
        }
        this.f4500d = true;
        Log.d("DownloadService", "Stopping service safely");
        m6496f();
        try {
            stopForeground(1);
            Log.d("DownloadService", "Foreground service stopped");
        } catch (Throwable th) {
            Log.w("DownloadService", "Error stopping foreground service: " + th.getMessage());
        }
        try {
            stopSelf();
            Log.d("DownloadService", "Service stopped");
        } catch (Throwable th2) {
            Log.w("DownloadService", "Error stopping service: " + th2.getMessage());
        }
    }

    public final void m6505o() {
        this.f4501e = System.currentTimeMillis();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d("DownloadService", "onDestroy called");
        m6496f();
        this.f4500d = true;
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00fc  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int onStartCommand(Intent r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.DownloadService.onStartCommand(android.content.Intent, int, int):int");
    }
}
