package p000;

import java.util.concurrent.Callable;

public final class RunnableC1871iJ implements Runnable {

    public final C1076XI f5801l;

    public final Callable f5802m;

    public RunnableC1871iJ(C1076XI c1076xi, Callable callable) {
        this.f5801l = c1076xi;
        this.f5802m = callable;
    }

    @Override
    public final void run() {
        try {
            this.f5801l.m4728j(this.f5802m.call());
        } catch (Exception e) {
            this.f5801l.m4727i(e);
        } catch (Throwable th) {
            this.f5801l.m4727i(new RuntimeException(th));
        }
    }
}
