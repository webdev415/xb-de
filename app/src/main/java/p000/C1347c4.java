package p000;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000.InterfaceC1081Xe;

public class C1347c4 extends AbstractC1020W8 implements InterfaceC1301b4, InterfaceC0697P6 {

    public static final AtomicIntegerFieldUpdater f3914q = AtomicIntegerFieldUpdater.newUpdater(C1347c4.class, "_decisionAndIndex");

    public static final AtomicReferenceFieldUpdater f3915r = AtomicReferenceFieldUpdater.newUpdater(C1347c4.class, Object.class, "_state");

    public static final AtomicReferenceFieldUpdater f3916s = AtomicReferenceFieldUpdater.newUpdater(C1347c4.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    public final InterfaceC2458v6 f3917o;

    public final InterfaceC0191E6 f3918p;

    public C1347c4(InterfaceC2458v6 interfaceC2458v6, int i) {
        super(i);
        this.f3917o = interfaceC2458v6;
        this.f3918p = interfaceC2458v6.mo197f();
        this._decisionAndIndex = 536870911;
        this._state = C2083n0.f6285l;
    }

    public static void m5706D(C1347c4 c1347c4, Object obj, int i, InterfaceC0986Vb interfaceC0986Vb, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            interfaceC0986Vb = null;
        }
        c1347c4.m5710C(obj, i, interfaceC0986Vb);
    }

    private final boolean m5707y() {
        if (AbstractC1066X8.m4661c(this.f3036n)) {
            InterfaceC2458v6 interfaceC2458v6 = this.f3917o;
            AbstractC0116Ce.m474c(interfaceC2458v6, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((C0928U8) interfaceC2458v6).m4196l()) {
                return true;
            }
        }
        return false;
    }

    public final void m5708A(Throwable th) {
        if (m5717m(th)) {
            return;
        }
        m5716l(th);
        m5719o();
    }

    public final void m5709B() {
        Throwable thM4199o;
        InterfaceC2458v6 interfaceC2458v6 = this.f3917o;
        C0928U8 c0928u8 = interfaceC2458v6 instanceof C0928U8 ? (C0928U8) interfaceC2458v6 : null;
        if (c0928u8 == null || (thM4199o = c0928u8.m4199o(this)) == null) {
            return;
        }
        m5718n();
        m5716l(thM4199o);
    }

    public final void m5710C(Object obj, int i, InterfaceC0986Vb interfaceC0986Vb) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3915r;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof InterfaceC2294rh)) {
                if (obj2 instanceof C1668e4) {
                    C1668e4 c1668e4 = (C1668e4) obj2;
                    if (c1668e4.m7386c()) {
                        if (interfaceC0986Vb != null) {
                            m5715k(interfaceC0986Vb, c1668e4.f244a);
                            return;
                        }
                        return;
                    }
                }
                m5714j(obj);
                throw new C2568xf();
            }
        } while (!AbstractC0506L.m2572a(f3915r, this, obj2, m5711E((InterfaceC2294rh) obj2, obj, i, interfaceC0986Vb, null)));
        m5719o();
        m5720p(i);
    }

    public final Object m5711E(InterfaceC2294rh interfaceC2294rh, Object obj, int i, InterfaceC0986Vb interfaceC0986Vb, Object obj2) {
        return obj instanceof C0098C5 ? obj : (AbstractC1066X8.m4660b(i) || obj2 != null) ? (interfaceC0986Vb == null && obj2 == null) ? obj : new C0006A5(obj, null, interfaceC0986Vb, obj2, null, 16, null) : obj;
    }

    public final boolean m5712F() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3914q;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f3914q.compareAndSet(this, i, 1073741824 + (536870911 & i)));
        return true;
    }

    public final boolean m5713G() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3914q;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f3914q.compareAndSet(this, i, 536870912 + (536870911 & i)));
        return true;
    }

    @Override
    public void mo4191a(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3915r;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof InterfaceC2294rh) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof C0098C5) {
                return;
            }
            if (obj2 instanceof C0006A5) {
                C0006A5 c0006a5 = (C0006A5) obj2;
                if (!(!c0006a5.m19c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (AbstractC0506L.m2572a(f3915r, this, obj2, C0006A5.m17b(c0006a5, null, null, null, null, th, 15, null))) {
                    c0006a5.m20d(this, th);
                    return;
                }
            } else if (AbstractC0506L.m2572a(f3915r, this, obj2, new C0006A5(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override
    public final InterfaceC2458v6 mo4192b() {
        return this.f3917o;
    }

    @Override
    public Throwable mo4451c(Object obj) {
        Throwable thMo4451c = super.mo4451c(obj);
        if (thMo4451c != null) {
            return thMo4451c;
        }
        return null;
    }

    @Override
    public InterfaceC0697P6 mo3475d() {
        InterfaceC2458v6 interfaceC2458v6 = this.f3917o;
        if (interfaceC2458v6 instanceof InterfaceC0697P6) {
            return (InterfaceC0697P6) interfaceC2458v6;
        }
        return null;
    }

    @Override
    public Object mo4452e(Object obj) {
        return obj instanceof C0006A5 ? ((C0006A5) obj).f6a : obj;
    }

    @Override
    public InterfaceC0191E6 mo197f() {
        return this.f3918p;
    }

    @Override
    public void mo198h(Object obj) {
        m5706D(this, AbstractC0282G5.m1346a(obj, this), this.f3036n, null, 4, null);
    }

    @Override
    public Object mo4193i() {
        return m5724t();
    }

    public final Void m5714j(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void m5715k(InterfaceC0986Vb interfaceC0986Vb, Throwable th) {
        try {
            interfaceC0986Vb.mo15n(th);
        } catch (Throwable th2) {
            AbstractC0467K6.m2289a(mo197f(), new C0236F5("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public boolean m5716l(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3915r;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof InterfaceC2294rh)) {
                return false;
            }
        } while (!AbstractC0506L.m2572a(f3915r, this, obj, new C1668e4(this, th, false)));
        m5719o();
        m5720p(this.f3036n);
        return true;
    }

    public final boolean m5717m(Throwable th) {
        if (!m5707y()) {
            return false;
        }
        InterfaceC2458v6 interfaceC2458v6 = this.f3917o;
        AbstractC0116Ce.m474c(interfaceC2458v6, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C0928U8) interfaceC2458v6).m4197m(th);
    }

    public final void m5718n() {
        InterfaceC1627d9 interfaceC1627d9M5722r = m5722r();
        if (interfaceC1627d9M5722r == null) {
            return;
        }
        interfaceC1627d9M5722r.mo7309b();
        f3916s.set(this, C2248qh.f6728l);
    }

    public final void m5719o() {
        if (m5707y()) {
            return;
        }
        m5718n();
    }

    public final void m5720p(int i) {
        if (m5712F()) {
            return;
        }
        AbstractC1066X8.m4659a(this, i);
    }

    public Throwable m5721q(InterfaceC1081Xe interfaceC1081Xe) {
        return interfaceC1081Xe.mo4770l();
    }

    public final InterfaceC1627d9 m5722r() {
        return (InterfaceC1627d9) f3916s.get(this);
    }

    public final Object m5723s() throws Throwable {
        InterfaceC1081Xe interfaceC1081Xe;
        boolean zM5707y = m5707y();
        if (m5713G()) {
            if (m5722r() == null) {
                m5727w();
            }
            if (zM5707y) {
                m5709B();
            }
            return AbstractC0208Ee.m1037c();
        }
        if (zM5707y) {
            m5709B();
        }
        Object objM5724t = m5724t();
        if (objM5724t instanceof C0098C5) {
            throw ((C0098C5) objM5724t).f244a;
        }
        if (!AbstractC1066X8.m4660b(this.f3036n) || (interfaceC1081Xe = (InterfaceC1081Xe) mo197f().mo855b(InterfaceC1081Xe.f3236c)) == null || interfaceC1081Xe.mo4769a()) {
            return mo4452e(objM5724t);
        }
        CancellationException cancellationExceptionMo4770l = interfaceC1081Xe.mo4770l();
        mo4191a(objM5724t, cancellationExceptionMo4770l);
        throw cancellationExceptionMo4770l;
    }

    public final Object m5724t() {
        return f3915r.get(this);
    }

    public String toString() {
        return m5729z() + '(' + AbstractC2505w7.m10435c(this.f3917o) + "){" + m5725u() + "}@" + AbstractC2505w7.m10434b(this);
    }

    public final String m5725u() {
        Object objM5724t = m5724t();
        return objM5724t instanceof InterfaceC2294rh ? "Active" : objM5724t instanceof C1668e4 ? "Cancelled" : "Completed";
    }

    public void m5726v() {
        InterfaceC1627d9 interfaceC1627d9M5727w = m5727w();
        if (interfaceC1627d9M5727w != null && m5728x()) {
            interfaceC1627d9M5727w.mo7309b();
            f3916s.set(this, C2248qh.f6728l);
        }
    }

    public final InterfaceC1627d9 m5727w() {
        InterfaceC1081Xe interfaceC1081Xe = (InterfaceC1081Xe) mo197f().mo855b(InterfaceC1081Xe.f3236c);
        if (interfaceC1081Xe == null) {
            return null;
        }
        InterfaceC1627d9 interfaceC1627d9M4776c = InterfaceC1081Xe.a.m4776c(interfaceC1081Xe, true, false, new C2594y4(this), 2, null);
        AbstractC0506L.m2572a(f3916s, this, null, interfaceC1627d9M4776c);
        return interfaceC1627d9M4776c;
    }

    public boolean m5728x() {
        return !(m5724t() instanceof InterfaceC2294rh);
    }

    public String m5729z() {
        return "CancellableContinuation";
    }
}
