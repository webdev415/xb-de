package p000;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class C1989kz extends Thread {

    public final Object f6045l;

    public final BlockingQueue f6046m;

    public boolean f6047n = false;

    public final C1662dz f6048o;

    public C1989kz(C1662dz c1662dz, String str, BlockingQueue blockingQueue) {
        this.f6048o = c1662dz;
        AbstractC1085Xi.m4801j(str);
        AbstractC1085Xi.m4801j(blockingQueue);
        this.f6045l = new Object();
        this.f6046m = blockingQueue;
        setName(str);
    }

    public final void m8340a() {
        synchronized (this.f6045l) {
            this.f6045l.notifyAll();
        }
    }

    public final void m8341b(InterruptedException interruptedException) {
        this.f6048o.mo349g().m9623L().m10617b(getName() + " was interrupted", interruptedException);
    }

    public final void m8342c() {
        synchronized (this.f6048o.f5358i) {
            try {
                if (!this.f6047n) {
                    this.f6048o.f5359j.release();
                    this.f6048o.f5358i.notifyAll();
                    if (this == this.f6048o.f5352c) {
                        this.f6048o.f5352c = null;
                    } else if (this == this.f6048o.f5353d) {
                        this.f6048o.f5353d = null;
                    } else {
                        this.f6048o.mo349g().m9618G().m10616a("Current scheduler thread is neither worker nor network");
                    }
                    this.f6047n = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void run() throws InterruptedException {
        boolean z = false;
        while (!z) {
            try {
                this.f6048o.f5359j.acquire();
                z = true;
            } catch (InterruptedException e) {
                m8341b(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                C2081mz c2081mz = (C2081mz) this.f6046m.poll();
                if (c2081mz != null) {
                    Process.setThreadPriority(c2081mz.f6279m ? threadPriority : 10);
                    c2081mz.run();
                } else {
                    synchronized (this.f6045l) {
                        if (this.f6046m.peek() == null && !this.f6048o.f5360k) {
                            try {
                                this.f6045l.wait(30000L);
                            } catch (InterruptedException e2) {
                                m8341b(e2);
                            }
                        }
                    }
                    synchronized (this.f6048o.f5358i) {
                        if (this.f6046m.peek() == null) {
                            m8342c();
                            m8342c();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            m8342c();
            throw th;
        }
    }
}
