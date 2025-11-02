package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public class C0098C5 {

    public static final AtomicIntegerFieldUpdater f243b = AtomicIntegerFieldUpdater.newUpdater(C0098C5.class, "_handled");
    private volatile int _handled;

    public final Throwable f244a;

    public C0098C5(Throwable th, boolean z) {
        this.f244a = th;
        this._handled = z ? 1 : 0;
    }

    public final boolean m402a() {
        return f243b.get(this) != 0;
    }

    public final boolean m403b() {
        return f243b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return AbstractC2505w7.m10433a(this) + '[' + this.f244a + ']';
    }

    public C0098C5(Throwable th, boolean z, int i, AbstractC0881T7 abstractC0881T7) {
        this(th, (i & 2) != 0 ? false : z);
    }
}
