package p000;

public final class RunnableC1293ax implements Runnable {

    public final C2449uy f3812l;

    public RunnableC1293ax(C2449uy c2449uy) {
        this.f3812l = c2449uy;
    }

    @Override
    public final void run() {
        synchronized (this.f3812l.f7609b) {
            try {
                C2449uy c2449uy = this.f3812l;
                if (c2449uy.f7610c != null) {
                    c2449uy.f7610c.mo3672b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
