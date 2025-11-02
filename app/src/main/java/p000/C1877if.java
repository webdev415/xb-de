package p000;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000.C1222ag;
import p000.InterfaceC0191E6;
import p000.InterfaceC1081Xe;

public class C1877if implements InterfaceC1081Xe, InterfaceC0051B4, InterfaceC0350Hi {

    public static final AtomicReferenceFieldUpdater f5803l = AtomicReferenceFieldUpdater.newUpdater(C1877if.class, Object.class, "_state");

    public static final AtomicReferenceFieldUpdater f5804m = AtomicReferenceFieldUpdater.newUpdater(C1877if.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    public static final class a extends AbstractC1830hf {

        public final C1877if f5805p;

        public final b f5806q;

        public final C0005A4 f5807r;

        public final Object f5808s;

        public a(C1877if c1877if, b bVar, C0005A4 c0005a4, Object obj) {
            this.f5805p = c1877if;
            this.f5806q = bVar;
            this.f5807r = c0005a4;
            this.f5808s = obj;
        }

        @Override
        public /* bridge */ Object mo15n(Object obj) {
            mo16w((Throwable) obj);
            return C2116no.f6480a;
        }

        @Override
        public void mo16w(Throwable th) {
            this.f5805p.m7906F(this.f5806q, this.f5807r, this.f5808s);
        }
    }

    public static final class b implements InterfaceC1876ie {

        public static final AtomicIntegerFieldUpdater f5809m = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isCompleting");

        public static final AtomicReferenceFieldUpdater f5810n = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_rootCause");

        public static final AtomicReferenceFieldUpdater f5811o = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        public final C2202ph f5812l;

        public b(C2202ph c2202ph, boolean z, Throwable th) {
            this.f5812l = c2202ph;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        @Override
        public boolean mo2837a() {
            return m7955e() == null;
        }

        public final void m7952b(Throwable th) {
            Throwable thM7955e = m7955e();
            if (thM7955e == null) {
                m7962m(th);
                return;
            }
            if (th == thM7955e) {
                return;
            }
            Object objM7954d = m7954d();
            if (objM7954d == null) {
                m7961l(th);
                return;
            }
            if (objM7954d instanceof Throwable) {
                if (th == objM7954d) {
                    return;
                }
                ArrayList arrayListM7953c = m7953c();
                arrayListM7953c.add(objM7954d);
                arrayListM7953c.add(th);
                m7961l(arrayListM7953c);
                return;
            }
            if (objM7954d instanceof ArrayList) {
                ((ArrayList) objM7954d).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objM7954d).toString());
        }

        public final ArrayList m7953c() {
            return new ArrayList<>(4);
        }

        public final Object m7954d() {
            return f5811o.get(this);
        }

        public final Throwable m7955e() {
            return (Throwable) f5810n.get(this);
        }

        @Override
        public C2202ph mo2838f() {
            return this.f5812l;
        }

        public final boolean m7956g() {
            return m7955e() != null;
        }

        public final boolean m7957h() {
            return f5809m.get(this) != 0;
        }

        public final boolean m7958i() {
            return m7954d() == AbstractC1923jf.f5952e;
        }

        public final List m7959j(Throwable th) {
            ArrayList arrayListM7953c;
            Object objM7954d = m7954d();
            if (objM7954d == null) {
                arrayListM7953c = m7953c();
            } else if (objM7954d instanceof Throwable) {
                ArrayList arrayListM7953c2 = m7953c();
                arrayListM7953c2.add(objM7954d);
                arrayListM7953c = arrayListM7953c2;
            } else {
                if (!(objM7954d instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objM7954d).toString());
                }
                arrayListM7953c = (ArrayList) objM7954d;
            }
            Throwable thM7955e = m7955e();
            if (thM7955e != null) {
                arrayListM7953c.add(0, thM7955e);
            }
            if (th != null && !AbstractC0116Ce.m472a(th, thM7955e)) {
                arrayListM7953c.add(th);
            }
            m7961l(AbstractC1923jf.f5952e);
            return arrayListM7953c;
        }

        public final void m7960k(boolean z) {
            f5809m.set(this, z ? 1 : 0);
        }

        public final void m7961l(Object obj) {
            f5811o.set(this, obj);
        }

        public final void m7962m(Throwable th) {
            f5810n.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + m7956g() + ", completing=" + m7957h() + ", rootCause=" + m7955e() + ", exceptions=" + m7954d() + ", list=" + mo2838f() + ']';
        }
    }

    public static final class c extends C1222ag.a {

        public final C1877if f5813d;

        public final Object f5814e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C1222ag c1222ag, C1877if c1877if, Object obj) {
            super(c1222ag);
            this.f5813d = c1877if;
            this.f5814e = obj;
        }

        @Override
        public Object mo1782d(C1222ag c1222ag) {
            if (this.f5813d.m7915T() == this.f5814e) {
                return null;
            }
            return AbstractC1174Zf.m5039a();
        }
    }

    public C1877if(boolean z) {
        this._state = z ? AbstractC1923jf.f5954g : AbstractC1923jf.f5953f;
    }

    public static CancellationException m7904q0(C1877if c1877if, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return c1877if.m7938p0(th, str);
    }

    @Override
    public void mo4768A(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new C1127Ye(mo7950x(), null, this);
        }
        m7942s(cancellationException);
    }

    @Override
    public InterfaceC0191E6 mo852B(InterfaceC0191E6.c cVar) {
        return InterfaceC1081Xe.a.m4777d(this, cVar);
    }

    public final void m7905D(InterfaceC1876ie interfaceC1876ie, Object obj) throws Throwable {
        InterfaceC2640z4 interfaceC2640z4M7914R = m7914R();
        if (interfaceC2640z4M7914R != null) {
            interfaceC2640z4M7914R.mo7309b();
            m7933m0(C2248qh.f6728l);
        }
        C0098C5 c0098c5 = obj instanceof C0098C5 ? (C0098C5) obj : null;
        Throwable th = c0098c5 != null ? c0098c5.f244a : null;
        if (!(interfaceC1876ie instanceof AbstractC1830hf)) {
            C2202ph c2202phMo2838f = interfaceC1876ie.mo2838f();
            if (c2202phMo2838f != null) {
                m7927f0(c2202phMo2838f, th);
                return;
            }
            return;
        }
        try {
            ((AbstractC1830hf) interfaceC1876ie).mo16w(th);
        } catch (Throwable th2) {
            mo7917V(new C0236F5("Exception in completion handler " + interfaceC1876ie + " for " + this, th2));
        }
    }

    @Override
    public Object mo853E(Object obj, InterfaceC1920jc interfaceC1920jc) {
        return InterfaceC1081Xe.a.m4774a(this, obj, interfaceC1920jc);
    }

    public final void m7906F(b bVar, C0005A4 c0005a4, Object obj) {
        C0005A4 c0005a4M7925d0 = m7925d0(c0005a4);
        if (c0005a4M7925d0 == null || !m7949w0(bVar, c0005a4M7925d0, obj)) {
            m7939q(m7908H(bVar, obj));
        }
    }

    public final Throwable m7907G(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new C1127Ye(mo7950x(), null, this) : th;
        }
        AbstractC0116Ce.m474c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((InterfaceC0350Hi) obj).mo1592i();
    }

    public final Object m7908H(b bVar, Object obj) throws Throwable {
        boolean zM7956g;
        Throwable thM7912N;
        C0098C5 c0098c5 = obj instanceof C0098C5 ? (C0098C5) obj : null;
        Throwable th = c0098c5 != null ? c0098c5.f244a : null;
        synchronized (bVar) {
            zM7956g = bVar.m7956g();
            List listM7959j = bVar.m7959j(th);
            thM7912N = m7912N(bVar, listM7959j);
            if (thM7912N != null) {
                m7936o(thM7912N, listM7959j);
            }
        }
        if (thM7912N != null && thM7912N != th) {
            obj = new C0098C5(thM7912N, false, 2, null);
        }
        if (thM7912N != null && (m7947v(thM7912N) || m7916U(thM7912N))) {
            AbstractC0116Ce.m474c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((C0098C5) obj).m403b();
        }
        if (!zM7956g) {
            m7928g0(thM7912N);
        }
        mo7929h0(obj);
        AbstractC0506L.m2572a(f5803l, this, bVar, AbstractC1923jf.m8175g(obj));
        m7905D(bVar, obj);
        return obj;
    }

    @Override
    public InterfaceC0191E6 mo854I(InterfaceC0191E6 interfaceC0191E6) {
        return InterfaceC1081Xe.a.m4778e(this, interfaceC0191E6);
    }

    public final C0005A4 m7909K(InterfaceC1876ie interfaceC1876ie) {
        C0005A4 c0005a4 = interfaceC1876ie instanceof C0005A4 ? (C0005A4) interfaceC1876ie : null;
        if (c0005a4 != null) {
            return c0005a4;
        }
        C2202ph c2202phMo2838f = interfaceC1876ie.mo2838f();
        if (c2202phMo2838f != null) {
            return m7925d0(c2202phMo2838f);
        }
        return null;
    }

    public final Object m7910L() throws Throwable {
        Object objM7915T = m7915T();
        if (!(!(objM7915T instanceof InterfaceC1876ie))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objM7915T instanceof C0098C5) {
            throw ((C0098C5) objM7915T).f244a;
        }
        return AbstractC1923jf.m8176h(objM7915T);
    }

    public final Throwable m7911M(Object obj) {
        C0098C5 c0098c5 = obj instanceof C0098C5 ? (C0098C5) obj : null;
        if (c0098c5 != null) {
            return c0098c5.f244a;
        }
        return null;
    }

    public final Throwable m7912N(b bVar, List list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.m7956g()) {
                return new C1127Ye(mo7950x(), null, this);
            }
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : (Throwable) list.get(0);
    }

    public boolean mo5263O() {
        return true;
    }

    public boolean mo5264P() {
        return false;
    }

    public final C2202ph m7913Q(InterfaceC1876ie interfaceC1876ie) {
        C2202ph c2202phMo2838f = interfaceC1876ie.mo2838f();
        if (c2202phMo2838f != null) {
            return c2202phMo2838f;
        }
        if (interfaceC1876ie instanceof C0562M9) {
            return new C2202ph();
        }
        if (interfaceC1876ie instanceof AbstractC1830hf) {
            m7931k0((AbstractC1830hf) interfaceC1876ie);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC1876ie).toString());
    }

    public final InterfaceC2640z4 m7914R() {
        return (InterfaceC2640z4) f5804m.get(this);
    }

    public final Object m7915T() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5803l;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof AbstractC1084Xh)) {
                return obj;
            }
            ((AbstractC1084Xh) obj).mo1779a(this);
        }
    }

    public boolean m7916U(Throwable th) {
        return false;
    }

    public final void m7918W(InterfaceC1081Xe interfaceC1081Xe) {
        if (interfaceC1081Xe == null) {
            m7933m0(C2248qh.f6728l);
            return;
        }
        interfaceC1081Xe.start();
        InterfaceC2640z4 interfaceC2640z4Mo4772u = interfaceC1081Xe.mo4772u(this);
        m7933m0(interfaceC2640z4Mo4772u);
        if (m7919X()) {
            interfaceC2640z4Mo4772u.mo7309b();
            m7933m0(C2248qh.f6728l);
        }
    }

    public final boolean m7919X() {
        return !(m7915T() instanceof InterfaceC1876ie);
    }

    public boolean m7920Y() {
        return false;
    }

    public final Object m7921Z(Object obj) throws Throwable {
        Throwable thM7907G = null;
        while (true) {
            Object objM7915T = m7915T();
            if (objM7915T instanceof b) {
                synchronized (objM7915T) {
                    if (((b) objM7915T).m7958i()) {
                        return AbstractC1923jf.f5951d;
                    }
                    boolean zM7956g = ((b) objM7915T).m7956g();
                    if (obj != null || !zM7956g) {
                        if (thM7907G == null) {
                            thM7907G = m7907G(obj);
                        }
                        ((b) objM7915T).m7952b(thM7907G);
                    }
                    Throwable thM7955e = zM7956g ^ true ? ((b) objM7915T).m7955e() : null;
                    if (thM7955e != null) {
                        m7926e0(((b) objM7915T).mo2838f(), thM7955e);
                    }
                    return AbstractC1923jf.f5948a;
                }
            }
            if (!(objM7915T instanceof InterfaceC1876ie)) {
                return AbstractC1923jf.f5951d;
            }
            if (thM7907G == null) {
                thM7907G = m7907G(obj);
            }
            InterfaceC1876ie interfaceC1876ie = (InterfaceC1876ie) objM7915T;
            if (!interfaceC1876ie.mo2837a()) {
                Object objM7946u0 = m7946u0(objM7915T, new C0098C5(thM7907G, false, 2, null));
                if (objM7946u0 == AbstractC1923jf.f5948a) {
                    throw new IllegalStateException(("Cannot happen in " + objM7915T).toString());
                }
                if (objM7946u0 != AbstractC1923jf.f5950c) {
                    return objM7946u0;
                }
            } else if (m7945t0(interfaceC1876ie, thM7907G)) {
                return AbstractC1923jf.f5948a;
            }
        }
    }

    @Override
    public boolean mo4769a() {
        Object objM7915T = m7915T();
        return (objM7915T instanceof InterfaceC1876ie) && ((InterfaceC1876ie) objM7915T).mo2837a();
    }

    public final Object m7922a0(Object obj) {
        Object objM7946u0;
        do {
            objM7946u0 = m7946u0(m7915T(), obj);
            if (objM7946u0 == AbstractC1923jf.f5948a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, m7911M(obj));
            }
        } while (objM7946u0 == AbstractC1923jf.f5950c);
        return objM7946u0;
    }

    @Override
    public InterfaceC0191E6.b mo855b(InterfaceC0191E6.c cVar) {
        return InterfaceC1081Xe.a.m4775b(this, cVar);
    }

    public final AbstractC1830hf m7923b0(InterfaceC0986Vb interfaceC0986Vb, boolean z) {
        AbstractC1830hf c0530Le;
        if (z) {
            c0530Le = interfaceC0986Vb instanceof AbstractC1173Ze ? (AbstractC1173Ze) interfaceC0986Vb : null;
            if (c0530Le == null) {
                c0530Le = new C0484Ke(interfaceC0986Vb);
            }
        } else {
            c0530Le = interfaceC0986Vb instanceof AbstractC1830hf ? (AbstractC1830hf) interfaceC0986Vb : null;
            if (c0530Le == null) {
                c0530Le = new C0530Le(interfaceC0986Vb);
            }
        }
        c0530Le.m7835y(this);
        return c0530Le;
    }

    public String mo7924c0() {
        return AbstractC2505w7.m10433a(this);
    }

    public final C0005A4 m7925d0(C1222ag c1222ag) {
        while (c1222ag.mo4952r()) {
            c1222ag = c1222ag.m5274q();
        }
        while (true) {
            c1222ag = c1222ag.m5273p();
            if (!c1222ag.mo4952r()) {
                if (c1222ag instanceof C0005A4) {
                    return (C0005A4) c1222ag;
                }
                if (c1222ag instanceof C2202ph) {
                    return null;
                }
            }
        }
    }

    public final void m7926e0(C2202ph c2202ph, Throwable th) throws Throwable {
        m7928g0(th);
        Object objM5272o = c2202ph.m5272o();
        AbstractC0116Ce.m474c(objM5272o, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        C0236F5 c0236f5 = null;
        for (C1222ag c1222agM5273p = (C1222ag) objM5272o; !AbstractC0116Ce.m472a(c1222agM5273p, c2202ph); c1222agM5273p = c1222agM5273p.m5273p()) {
            if (c1222agM5273p instanceof AbstractC1173Ze) {
                AbstractC1830hf abstractC1830hf = (AbstractC1830hf) c1222agM5273p;
                try {
                    abstractC1830hf.mo16w(th);
                } catch (Throwable th2) {
                    if (c0236f5 != null) {
                        AbstractC2241qa.m9151a(c0236f5, th2);
                    } else {
                        c0236f5 = new C0236F5("Exception in completion handler " + abstractC1830hf + " for " + this, th2);
                        C2116no c2116no = C2116no.f6480a;
                    }
                }
            }
        }
        if (c0236f5 != null) {
            mo7917V(c0236f5);
        }
        m7947v(th);
    }

    public final void m7927f0(C2202ph c2202ph, Throwable th) throws Throwable {
        Object objM5272o = c2202ph.m5272o();
        AbstractC0116Ce.m474c(objM5272o, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        C0236F5 c0236f5 = null;
        for (C1222ag c1222agM5273p = (C1222ag) objM5272o; !AbstractC0116Ce.m472a(c1222agM5273p, c2202ph); c1222agM5273p = c1222agM5273p.m5273p()) {
            if (c1222agM5273p instanceof AbstractC1830hf) {
                AbstractC1830hf abstractC1830hf = (AbstractC1830hf) c1222agM5273p;
                try {
                    abstractC1830hf.mo16w(th);
                } catch (Throwable th2) {
                    if (c0236f5 != null) {
                        AbstractC2241qa.m9151a(c0236f5, th2);
                    } else {
                        c0236f5 = new C0236F5("Exception in completion handler " + abstractC1830hf + " for " + this, th2);
                        C2116no c2116no = C2116no.f6480a;
                    }
                }
            }
        }
        if (c0236f5 != null) {
            mo7917V(c0236f5);
        }
    }

    @Override
    public final InterfaceC0191E6.c getKey() {
        return InterfaceC1081Xe.f3236c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override
    public CancellationException mo1592i() {
        CancellationException cancellationExceptionM7955e;
        Object objM7915T = m7915T();
        if (objM7915T instanceof b) {
            cancellationExceptionM7955e = ((b) objM7915T).m7955e();
        } else if (objM7915T instanceof C0098C5) {
            cancellationExceptionM7955e = ((C0098C5) objM7915T).f244a;
        } else {
            if (objM7915T instanceof InterfaceC1876ie) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objM7915T).toString());
            }
            cancellationExceptionM7955e = null;
        }
        CancellationException cancellationException = cancellationExceptionM7955e instanceof CancellationException ? cancellationExceptionM7955e : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new C1127Ye("Parent job is " + m7937o0(objM7915T), cancellationExceptionM7955e, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [fe] */
    public final void m7930j0(C0562M9 c0562m9) {
        C2202ph c2202ph = new C2202ph();
        if (!c0562m9.mo2837a()) {
            c2202ph = new C1735fe(c2202ph);
        }
        AbstractC0506L.m2572a(f5803l, this, c0562m9, c2202ph);
    }

    public final void m7931k0(AbstractC1830hf abstractC1830hf) {
        abstractC1830hf.m5268i(new C2202ph());
        AbstractC0506L.m2572a(f5803l, this, abstractC1830hf, abstractC1830hf.m5273p());
    }

    @Override
    public final CancellationException mo4770l() {
        Object objM7915T = m7915T();
        if (!(objM7915T instanceof b)) {
            if (objM7915T instanceof InterfaceC1876ie) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objM7915T instanceof C0098C5) {
                return m7904q0(this, ((C0098C5) objM7915T).f244a, null, 1, null);
            }
            return new C1127Ye(AbstractC2505w7.m10433a(this) + " has completed normally", null, this);
        }
        Throwable thM7955e = ((b) objM7915T).m7955e();
        if (thM7955e != null) {
            CancellationException cancellationExceptionM7938p0 = m7938p0(thM7955e, AbstractC2505w7.m10433a(this) + " is cancelling");
            if (cancellationExceptionM7938p0 != null) {
                return cancellationExceptionM7938p0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final void m7932l0(AbstractC1830hf abstractC1830hf) {
        Object objM7915T;
        do {
            objM7915T = m7915T();
            if (!(objM7915T instanceof AbstractC1830hf)) {
                if (!(objM7915T instanceof InterfaceC1876ie) || ((InterfaceC1876ie) objM7915T).mo2838f() == null) {
                    return;
                }
                abstractC1830hf.m5275s();
                return;
            }
            if (objM7915T != abstractC1830hf) {
                return;
            }
        } while (!AbstractC0506L.m2572a(f5803l, this, objM7915T, AbstractC1923jf.f5954g));
    }

    public final void m7933m0(InterfaceC2640z4 interfaceC2640z4) {
        f5804m.set(this, interfaceC2640z4);
    }

    public final boolean m7934n(Object obj, C2202ph c2202ph, AbstractC1830hf abstractC1830hf) {
        int iM5278v;
        c cVar = new c(abstractC1830hf, this, obj);
        do {
            iM5278v = c2202ph.m5274q().m5278v(abstractC1830hf, c2202ph, cVar);
            if (iM5278v == 1) {
                return true;
            }
        } while (iM5278v != 2);
        return false;
    }

    public final int m7935n0(Object obj) {
        if (obj instanceof C0562M9) {
            if (((C0562M9) obj).mo2837a()) {
                return 0;
            }
            if (!AbstractC0506L.m2572a(f5803l, this, obj, AbstractC1923jf.f5954g)) {
                return -1;
            }
            mo707i0();
            return 1;
        }
        if (!(obj instanceof C1735fe)) {
            return 0;
        }
        if (!AbstractC0506L.m2572a(f5803l, this, obj, ((C1735fe) obj).mo2838f())) {
            return -1;
        }
        mo707i0();
        return 1;
    }

    public final void m7936o(Throwable th, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                AbstractC2241qa.m9151a(th, th2);
            }
        }
    }

    public final String m7937o0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof InterfaceC1876ie ? ((InterfaceC1876ie) obj).mo2837a() ? "Active" : "New" : obj instanceof C0098C5 ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.m7956g() ? "Cancelling" : bVar.m7957h() ? "Completing" : "Active";
    }

    @Override
    public final InterfaceC1627d9 mo4771p(boolean z, boolean z2, InterfaceC0986Vb interfaceC0986Vb) {
        AbstractC1830hf abstractC1830hfM7923b0 = m7923b0(interfaceC0986Vb, z);
        while (true) {
            Object objM7915T = m7915T();
            if (objM7915T instanceof C0562M9) {
                C0562M9 c0562m9 = (C0562M9) objM7915T;
                if (!c0562m9.mo2837a()) {
                    m7930j0(c0562m9);
                } else if (AbstractC0506L.m2572a(f5803l, this, objM7915T, abstractC1830hfM7923b0)) {
                    return abstractC1830hfM7923b0;
                }
            } else {
                if (!(objM7915T instanceof InterfaceC1876ie)) {
                    if (z2) {
                        C0098C5 c0098c5 = objM7915T instanceof C0098C5 ? (C0098C5) objM7915T : null;
                        interfaceC0986Vb.mo15n(c0098c5 != null ? c0098c5.f244a : null);
                    }
                    return C2248qh.f6728l;
                }
                C2202ph c2202phMo2838f = ((InterfaceC1876ie) objM7915T).mo2838f();
                if (c2202phMo2838f == null) {
                    AbstractC0116Ce.m474c(objM7915T, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    m7931k0((AbstractC1830hf) objM7915T);
                } else {
                    InterfaceC1627d9 interfaceC1627d9 = C2248qh.f6728l;
                    if (z && (objM7915T instanceof b)) {
                        synchronized (objM7915T) {
                            try {
                                thM7955e = ((b) objM7915T).m7955e();
                                if (thM7955e == null || ((interfaceC0986Vb instanceof C0005A4) && !((b) objM7915T).m7957h())) {
                                    if (m7934n(objM7915T, c2202phMo2838f, abstractC1830hfM7923b0)) {
                                        if (thM7955e == null) {
                                            return abstractC1830hfM7923b0;
                                        }
                                        interfaceC1627d9 = abstractC1830hfM7923b0;
                                    }
                                }
                                C2116no c2116no = C2116no.f6480a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (thM7955e != null) {
                        if (z2) {
                            interfaceC0986Vb.mo15n(thM7955e);
                        }
                        return interfaceC1627d9;
                    }
                    if (m7934n(objM7915T, c2202phMo2838f, abstractC1830hfM7923b0)) {
                        return abstractC1830hfM7923b0;
                    }
                }
            }
        }
    }

    public final CancellationException m7938p0(Throwable th, String str) {
        CancellationException c1127Ye = th instanceof CancellationException ? (CancellationException) th : null;
        if (c1127Ye == null) {
            if (str == null) {
                str = mo7950x();
            }
            c1127Ye = new C1127Ye(str, th, this);
        }
        return c1127Ye;
    }

    public final boolean m7940r(Object obj) throws Throwable {
        Object objM7921Z = AbstractC1923jf.f5948a;
        if (mo5264P() && (objM7921Z = m7944t(obj)) == AbstractC1923jf.f5949b) {
            return true;
        }
        if (objM7921Z == AbstractC1923jf.f5948a) {
            objM7921Z = m7921Z(obj);
        }
        if (objM7921Z == AbstractC1923jf.f5948a || objM7921Z == AbstractC1923jf.f5949b) {
            return true;
        }
        if (objM7921Z == AbstractC1923jf.f5951d) {
            return false;
        }
        m7939q(objM7921Z);
        return true;
    }

    public final String m7941r0() {
        return mo7924c0() + '{' + m7937o0(m7915T()) + '}';
    }

    public void m7942s(Throwable th) throws Throwable {
        m7940r(th);
    }

    public final boolean m7943s0(InterfaceC1876ie interfaceC1876ie, Object obj) throws Throwable {
        if (!AbstractC0506L.m2572a(f5803l, this, interfaceC1876ie, AbstractC1923jf.m8175g(obj))) {
            return false;
        }
        m7928g0(null);
        mo7929h0(obj);
        m7905D(interfaceC1876ie, obj);
        return true;
    }

    @Override
    public final boolean start() {
        int iM7935n0;
        do {
            iM7935n0 = m7935n0(m7915T());
            if (iM7935n0 == 0) {
                return false;
            }
        } while (iM7935n0 != 1);
        return true;
    }

    public final Object m7944t(Object obj) {
        Object objM7946u0;
        do {
            Object objM7915T = m7915T();
            if (!(objM7915T instanceof InterfaceC1876ie) || ((objM7915T instanceof b) && ((b) objM7915T).m7957h())) {
                return AbstractC1923jf.f5948a;
            }
            objM7946u0 = m7946u0(objM7915T, new C0098C5(m7907G(obj), false, 2, null));
        } while (objM7946u0 == AbstractC1923jf.f5950c);
        return objM7946u0;
    }

    public final boolean m7945t0(InterfaceC1876ie interfaceC1876ie, Throwable th) throws Throwable {
        C2202ph c2202phM7913Q = m7913Q(interfaceC1876ie);
        if (c2202phM7913Q == null) {
            return false;
        }
        if (!AbstractC0506L.m2572a(f5803l, this, interfaceC1876ie, new b(c2202phM7913Q, false, th))) {
            return false;
        }
        m7926e0(c2202phM7913Q, th);
        return true;
    }

    public String toString() {
        return m7941r0() + '@' + AbstractC2505w7.m10434b(this);
    }

    @Override
    public final InterfaceC2640z4 mo4772u(InterfaceC0051B4 interfaceC0051B4) {
        InterfaceC1627d9 interfaceC1627d9M4776c = InterfaceC1081Xe.a.m4776c(this, true, false, new C0005A4(interfaceC0051B4), 2, null);
        AbstractC0116Ce.m474c(interfaceC1627d9M4776c, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (InterfaceC2640z4) interfaceC1627d9M4776c;
    }

    public final Object m7946u0(Object obj, Object obj2) {
        return !(obj instanceof InterfaceC1876ie) ? AbstractC1923jf.f5948a : ((!(obj instanceof C0562M9) && !(obj instanceof AbstractC1830hf)) || (obj instanceof C0005A4) || (obj2 instanceof C0098C5)) ? m7948v0((InterfaceC1876ie) obj, obj2) : m7943s0((InterfaceC1876ie) obj, obj2) ? obj2 : AbstractC1923jf.f5950c;
    }

    public final boolean m7947v(Throwable th) {
        if (m7920Y()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        InterfaceC2640z4 interfaceC2640z4M7914R = m7914R();
        return (interfaceC2640z4M7914R == null || interfaceC2640z4M7914R == C2248qh.f6728l) ? z : interfaceC2640z4M7914R.mo14d(th) || z;
    }

    public final Object m7948v0(InterfaceC1876ie interfaceC1876ie, Object obj) throws Throwable {
        C2202ph c2202phM7913Q = m7913Q(interfaceC1876ie);
        if (c2202phM7913Q == null) {
            return AbstractC1923jf.f5950c;
        }
        b bVar = interfaceC1876ie instanceof b ? (b) interfaceC1876ie : null;
        if (bVar == null) {
            bVar = new b(c2202phM7913Q, false, null);
        }
        C2205pk c2205pk = new C2205pk();
        synchronized (bVar) {
            if (bVar.m7957h()) {
                return AbstractC1923jf.f5948a;
            }
            bVar.m7960k(true);
            if (bVar != interfaceC1876ie && !AbstractC0506L.m2572a(f5803l, this, interfaceC1876ie, bVar)) {
                return AbstractC1923jf.f5950c;
            }
            boolean zM7956g = bVar.m7956g();
            C0098C5 c0098c5 = obj instanceof C0098C5 ? (C0098C5) obj : null;
            if (c0098c5 != null) {
                bVar.m7952b(c0098c5.f244a);
            }
            Throwable thM7955e = true ^ zM7956g ? bVar.m7955e() : null;
            c2205pk.f6647l = thM7955e;
            C2116no c2116no = C2116no.f6480a;
            if (thM7955e != null) {
                m7926e0(c2202phM7913Q, thM7955e);
            }
            C0005A4 c0005a4M7909K = m7909K(interfaceC1876ie);
            return (c0005a4M7909K == null || !m7949w0(bVar, c0005a4M7909K, obj)) ? m7908H(bVar, obj) : AbstractC1923jf.f5949b;
        }
    }

    @Override
    public final InterfaceC1627d9 mo4773w(InterfaceC0986Vb interfaceC0986Vb) {
        return mo4771p(false, true, interfaceC0986Vb);
    }

    public final boolean m7949w0(b bVar, C0005A4 c0005a4, Object obj) {
        while (InterfaceC1081Xe.a.m4776c(c0005a4.f5p, false, false, new a(this, bVar, c0005a4, obj), 1, null) == C2248qh.f6728l) {
            c0005a4 = m7925d0(c0005a4);
            if (c0005a4 == null) {
                return false;
            }
        }
        return true;
    }

    public String mo7950x() {
        return "Job was cancelled";
    }

    public boolean m7951y(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return m7940r(th) && mo5263O();
    }

    @Override
    public final void mo196z(InterfaceC0350Hi interfaceC0350Hi) throws Throwable {
        m7940r(interfaceC0350Hi);
    }

    public void mo707i0() {
    }

    public void mo7917V(Throwable th) throws Throwable {
        throw th;
    }

    public void m7928g0(Throwable th) {
    }

    public void mo7929h0(Object obj) {
    }

    public void m7939q(Object obj) {
    }
}
