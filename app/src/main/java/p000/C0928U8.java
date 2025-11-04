package p000;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class C0928U8 extends AbstractC1020W8 implements InterfaceC0697P6, InterfaceC2458v6 {

    public static final AtomicReferenceFieldUpdater f2828s = AtomicReferenceFieldUpdater.newUpdater(C0928U8.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    public final AbstractC0283G6 f2829o;

    public final InterfaceC2458v6 f2830p;

    public Object f2831q;

    public final Object f2832r;

    public C0928U8(AbstractC0283G6 abstractC0283G6, InterfaceC2458v6 interfaceC2458v6) {
        super(-1);
        this.f2829o = abstractC0283G6;
        this.f2830p = interfaceC2458v6;
        this.f2831q = AbstractC0974V8.f2940a;
        this.f2832r = AbstractC2530wn.m10599b(mo197f());
    }

    @Override
    public void mo4191a(Object obj, Throwable th) {
        if (obj instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) obj).onCancellation.mo15n(th);
        }
    }

    @Override
    public InterfaceC0697P6 mo3475d() {
        InterfaceC2458v6 interfaceC2458v6 = this.f2830p;
        if (interfaceC2458v6 instanceof InterfaceC0697P6) {
            return (InterfaceC0697P6) interfaceC2458v6;
        }
        return null;
    }

    @Override
    public InterfaceC0191E6 mo197f() {
        return this.f2830p.mo197f();
    }

    @Override
    public void mo198h(Object obj) {
        InterfaceC0191E6 interfaceC0191E6Mo197f = this.f2830p.mo197f();
        Object objM1348c = AbstractC0282G5.m1348c(obj, null, 1, null);
        if (this.f2829o.mo1352U(interfaceC0191E6Mo197f)) {
            this.f2831q = objM1348c;
            this.f3036n = 0;
            this.f2829o.mo1351T(interfaceC0191E6Mo197f, this);
            return;
        }
        AbstractC1964ka abstractC1964kaM10781a = C2576xn.f8026a.m10781a();
        if (abstractC1964kaM10781a.m8270c0()) {
            this.f2831q = objM1348c;
            this.f3036n = 0;
            abstractC1964kaM10781a.m8267Y(this);
            return;
        }
        abstractC1964kaM10781a.m8269a0(true);
        try {
            InterfaceC0191E6 interfaceC0191E6Mo197f2 = mo197f();
            Object objM10600c = AbstractC2530wn.m10600c(interfaceC0191E6Mo197f2, this.f2832r);
            try {
                this.f2830p.mo198h(obj);
                C2116no c2116no = C2116no.f6480a;
                while (abstractC1964kaM10781a.m8272e0()) {
                }
            } finally {
                AbstractC2530wn.m10598a(interfaceC0191E6Mo197f2, objM10600c);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override
    public Object mo4193i() {
        Object obj = this.f2831q;
        this.f2831q = AbstractC0974V8.f2940a;
        return obj;
    }

    public final void m4194j() {
        while (f2828s.get(this) == AbstractC0974V8.f2941b) {
        }
    }

    public final C1347c4 m4195k() {
        Object obj = f2828s.get(this);
        if (obj instanceof C1347c4) {
            return (C1347c4) obj;
        }
        return null;
    }

    public final boolean m4196l() {
        return f2828s.get(this) != null;
    }

    public final boolean m4197m(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2828s;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            C0951Um c0951Um = AbstractC0974V8.f2941b;
            if (AbstractC0116Ce.m472a(obj, c0951Um)) {
                if (AbstractC0506L.m2572a(f2828s, this, c0951Um, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (AbstractC0506L.m2572a(f2828s, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void m4198n() {
        m4194j();
        C1347c4 c1347c4M4195k = m4195k();
        if (c1347c4M4195k != null) {
            c1347c4M4195k.m5718n();
        }
    }

    public final Throwable m4199o(InterfaceC1301b4 interfaceC1301b4) {
        C0951Um c0951Um;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2828s;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c0951Um = AbstractC0974V8.f2941b;
            if (obj != c0951Um) {
                if (obj instanceof Throwable) {
                    if (AbstractC0506L.m2572a(f2828s, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!AbstractC0506L.m2572a(f2828s, this, c0951Um, interfaceC1301b4));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f2829o + ", " + AbstractC2505w7.m10435c(this.f2830p) + ']';
    }

    @Override
    public InterfaceC2458v6 mo4192b() {
        return this;
    }
}
