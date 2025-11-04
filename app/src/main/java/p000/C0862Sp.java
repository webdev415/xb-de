package p000;

import android.os.Process;

public final class C0862Sp extends Thread {
    public C0862Sp(ThreadGroup threadGroup, String str) {
        super(threadGroup, "GmsDynamite");
    }

    @Override
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(19);
        synchronized (this) {
            while (true) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }
}
