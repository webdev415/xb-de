package p000;

import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes.dex */
public final class C1075XH {

    public final Object f3215a = new Object();

    public Queue f3216b;

    public boolean f3217c;

    public final void m4717a(InterfaceC2331sH interfaceC2331sH) {
        synchronized (this.f3215a) {
            try {
                if (this.f3216b == null) {
                    this.f3216b = new ArrayDeque();
                }
                this.f3216b.add(interfaceC2331sH);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m4718b(AbstractC1838hn abstractC1838hn) {
        InterfaceC2331sH interfaceC2331sH;
        synchronized (this.f3215a) {
            if (this.f3216b != null && !this.f3217c) {
                this.f3217c = true;
                while (true) {
                    synchronized (this.f3215a) {
                        try {
                            interfaceC2331sH = (InterfaceC2331sH) this.f3216b.poll();
                            if (interfaceC2331sH == null) {
                                this.f3217c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    interfaceC2331sH.mo1870a(abstractC1838hn);
                }
            }
        }
    }
}
