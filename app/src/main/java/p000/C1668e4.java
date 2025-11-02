package p000;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class C1668e4 extends C0098C5 {

    public static final AtomicIntegerFieldUpdater f5391c = AtomicIntegerFieldUpdater.newUpdater(C1668e4.class, "_resumed");
    private volatile int _resumed;

    public C1668e4(InterfaceC2458v6 interfaceC2458v6, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + interfaceC2458v6 + " was cancelled normally");
        }
        super(th, z);
        this._resumed = 0;
    }

    public final boolean m7386c() {
        return f5391c.compareAndSet(this, 0, 1);
    }
}
