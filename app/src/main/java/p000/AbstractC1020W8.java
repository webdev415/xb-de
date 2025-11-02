package p000;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import p000.AbstractC0674Ok;

/* loaded from: classes.dex */
public abstract class AbstractC1020W8 extends AbstractRunnableC1744fn {

    public int f3036n;

    public AbstractC1020W8(int i) {
        this.f3036n = i;
    }

    public abstract void mo4191a(Object obj, Throwable th);

    public abstract InterfaceC2458v6 mo4192b();

    public Throwable mo4451c(Object obj) {
        C0098C5 c0098c5 = obj instanceof C0098C5 ? (C0098C5) obj : null;
        if (c0098c5 != null) {
            return c0098c5.f244a;
        }
        return null;
    }

    public final void m4453g(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            AbstractC2241qa.m9151a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        AbstractC0116Ce.m473b(th);
        AbstractC0467K6.m2289a(mo4192b().mo197f(), new C0788R6("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object mo4193i();

    @Override
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objM3431a;
        Object objM3431a2;
        Object objM3431a3;
        InterfaceC1931jn interfaceC1931jn = this.f5548m;
        try {
            InterfaceC2458v6 interfaceC2458v6Mo4192b = mo4192b();
            AbstractC0116Ce.m474c(interfaceC2458v6Mo4192b, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C0928U8 c0928u8 = (C0928U8) interfaceC2458v6Mo4192b;
            InterfaceC2458v6 interfaceC2458v6 = c0928u8.f2830p;
            Object obj = c0928u8.f2832r;
            InterfaceC0191E6 interfaceC0191E6Mo197f = interfaceC2458v6.mo197f();
            Object objM10600c = AbstractC2530wn.m10600c(interfaceC0191E6Mo197f, obj);
            if (objM10600c != AbstractC2530wn.f7898a) {
                AbstractC0237F6.m1207f(interfaceC2458v6, interfaceC0191E6Mo197f, objM10600c);
            }
            try {
                InterfaceC0191E6 interfaceC0191E6Mo197f2 = interfaceC2458v6.mo197f();
                Object objMo4193i = mo4193i();
                Throwable thMo4451c = mo4451c(objMo4193i);
                InterfaceC1081Xe interfaceC1081Xe = (thMo4451c == null && AbstractC1066X8.m4660b(this.f3036n)) ? (InterfaceC1081Xe) interfaceC0191E6Mo197f2.mo855b(InterfaceC1081Xe.f3236c) : null;
                if (interfaceC1081Xe != null && !interfaceC1081Xe.mo4769a()) {
                    CancellationException cancellationExceptionMo4770l = interfaceC1081Xe.mo4770l();
                    mo4191a(objMo4193i, cancellationExceptionMo4770l);
                    AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
                    objM3431a2 = AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(cancellationExceptionMo4770l));
                } else if (thMo4451c != null) {
                    AbstractC0674Ok.a aVar2 = AbstractC0674Ok.f2054l;
                    objM3431a2 = AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(thMo4451c));
                } else {
                    AbstractC0674Ok.a aVar3 = AbstractC0674Ok.f2054l;
                    objM3431a2 = AbstractC0674Ok.m3431a(mo4452e(objMo4193i));
                }
                interfaceC2458v6.mo198h(objM3431a2);
                C2116no c2116no = C2116no.f6480a;
                AbstractC2530wn.m10598a(interfaceC0191E6Mo197f, objM10600c);
                try {
                    interfaceC1931jn.mo8203b();
                    objM3431a3 = AbstractC0674Ok.m3431a(C2116no.f6480a);
                } catch (Throwable th) {
                    AbstractC0674Ok.a aVar4 = AbstractC0674Ok.f2054l;
                    objM3431a3 = AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(th));
                }
                m4453g(null, AbstractC0674Ok.m3432b(objM3431a3));
            } catch (Throwable th2) {
                AbstractC2530wn.m10598a(interfaceC0191E6Mo197f, objM10600c);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                AbstractC0674Ok.a aVar5 = AbstractC0674Ok.f2054l;
                interfaceC1931jn.mo8203b();
                objM3431a = AbstractC0674Ok.m3431a(C2116no.f6480a);
            } catch (Throwable th4) {
                AbstractC0674Ok.a aVar6 = AbstractC0674Ok.f2054l;
                objM3431a = AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(th4));
            }
            m4453g(th3, AbstractC0674Ok.m3432b(objM3431a));
        }
    }

    public Object mo4452e(Object obj) {
        return obj;
    }
}
