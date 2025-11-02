package p000;

import java.io.Serializable;
import p000.AbstractC0674Ok;

/* loaded from: classes.dex */
public abstract class AbstractC2408u2 implements InterfaceC2458v6, InterfaceC0697P6, Serializable {

    public final InterfaceC2458v6 f7344l;

    public AbstractC2408u2(InterfaceC2458v6 interfaceC2458v6) {
        this.f7344l = interfaceC2458v6;
    }

    public InterfaceC2458v6 mo2875a(Object obj, InterfaceC2458v6 interfaceC2458v6) {
        AbstractC0116Ce.m476e(interfaceC2458v6, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public final InterfaceC2458v6 m9896b() {
        return this.f7344l;
    }

    @Override
    public InterfaceC0697P6 mo3475d() {
        InterfaceC2458v6 interfaceC2458v6 = this.f7344l;
        if (interfaceC2458v6 instanceof InterfaceC0697P6) {
            return (InterfaceC0697P6) interfaceC2458v6;
        }
        return null;
    }

    public StackTraceElement m9897g() {
        return AbstractC2413u7.m9994d(this);
    }

    @Override
    public final void mo198h(Object obj) {
        Object objMo706i;
        InterfaceC2458v6 interfaceC2458v6 = this;
        while (true) {
            AbstractC2459v7.m10325b(interfaceC2458v6);
            AbstractC2408u2 abstractC2408u2 = (AbstractC2408u2) interfaceC2458v6;
            InterfaceC2458v6 interfaceC2458v62 = abstractC2408u2.f7344l;
            AbstractC0116Ce.m473b(interfaceC2458v62);
            try {
                objMo706i = abstractC2408u2.mo706i(obj);
            } catch (Throwable th) {
                AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
                obj = AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(th));
            }
            if (objMo706i == AbstractC0208Ee.m1037c()) {
                return;
            }
            obj = AbstractC0674Ok.m3431a(objMo706i);
            abstractC2408u2.mo9898k();
            if (!(interfaceC2458v62 instanceof AbstractC2408u2)) {
                interfaceC2458v62.mo198h(obj);
                return;
            }
            interfaceC2458v6 = interfaceC2458v62;
        }
    }

    public abstract Object mo706i(Object obj);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object objM9897g = m9897g();
        if (objM9897g == null) {
            objM9897g = getClass().getName();
        }
        sb.append(objM9897g);
        return sb.toString();
    }

    public void mo9898k() {
    }
}
