package p000;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class C2534wr {

    public final C0455Jv f7907a;

    public C2357sy f7908b;

    public C1700eq f7909c;

    public final C1184Zp f7910d;

    public C2534wr() {
        this(new C0455Jv());
    }

    public final C1700eq m10607a() {
        return this.f7909c;
    }

    public final void m10608b(String str, Callable callable) {
        this.f7907a.m2172b(str, callable);
    }

    public final void m10609c(C0504Ky c0504Ky) {
        AbstractC0450Jq abstractC0450Jq;
        try {
            this.f7908b = this.f7907a.f1467b.m9632d();
            if (this.f7907a.m2171a(this.f7908b, (C0550Ly[]) c0504Ky.m2571I().toArray(new C0550Ly[0])) instanceof C0174Dq) {
                throw new IllegalStateException("Program loading failed");
            }
            for (C0458Jy c0458Jy : c0504Ky.m2570G().m1755I()) {
                List listM2215I = c0458Jy.m2215I();
                String strM2214H = c0458Jy.m2214H();
                Iterator it = listM2215I.iterator();
                while (it.hasNext()) {
                    InterfaceC0909Tq interfaceC0909TqM2171a = this.f7907a.m2171a(this.f7908b, (C0550Ly) it.next());
                    if (!(interfaceC0909TqM2171a instanceof C0817Rq)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    C2357sy c2357sy = this.f7908b;
                    if (c2357sy.m9635g(strM2214H)) {
                        InterfaceC0909Tq interfaceC0909TqM9629a = c2357sy.m9629a(strM2214H);
                        if (!(interfaceC0909TqM9629a instanceof AbstractC0450Jq)) {
                            throw new IllegalStateException("Invalid function name: " + strM2214H);
                        }
                        abstractC0450Jq = (AbstractC0450Jq) interfaceC0909TqM9629a;
                    } else {
                        abstractC0450Jq = null;
                    }
                    if (abstractC0450Jq == null) {
                        throw new IllegalStateException("Rule function is undefined: " + strM2214H);
                    }
                    abstractC0450Jq.mo1366b(this.f7908b, Collections.singletonList(interfaceC0909TqM2171a));
                }
            }
        } catch (Throwable th) {
            throw new C0222Es(th);
        }
    }

    public final boolean m10610d(C1888iq c1888iq) {
        try {
            this.f7909c.m7475c(c1888iq);
            this.f7907a.f1468c.m9636h("runtime.counter", new C0036Aq(Double.valueOf(0.0d)));
            this.f7910d.m5083c(this.f7908b.m9632d(), this.f7909c);
            if (m10613g()) {
                return true;
            }
            return m10612f();
        } catch (Throwable th) {
            throw new C0222Es(th);
        }
    }

    public final AbstractC0450Jq m10611e() {
        return new C0984VI(this.f7910d);
    }

    public final boolean m10612f() {
        return !this.f7909c.m7478f().isEmpty();
    }

    public final boolean m10613g() {
        return !this.f7909c.m7476d().equals(this.f7909c.m7473a());
    }

    public C2534wr(C0455Jv c0455Jv) {
        this.f7907a = c0455Jv;
        this.f7908b = c0455Jv.f1467b.m9632d();
        this.f7909c = new C1700eq();
        this.f7910d = new C1184Zp();
        c0455Jv.m2172b("internal.registerCallback", new Callable() {
            @Override
            public final Object call() {
                return this.f3000a.m10611e();
            }
        });
        c0455Jv.m2172b("internal.eventLogger", new Callable() {
            @Override
            public final Object call() {
                return new C0288GB(this.f1862a.f7909c);
            }
        });
    }
}
