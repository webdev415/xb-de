package p000;

import p000.AbstractC0674Ok;

/* loaded from: classes.dex */
public abstract class AbstractC1622d4 {
    public static final void m7296a(InterfaceC2458v6 interfaceC2458v6, Throwable th) throws Throwable {
        AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
        interfaceC2458v6.mo198h(AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(th)));
        throw th;
    }

    public static final void m7297b(InterfaceC2458v6 interfaceC2458v6, InterfaceC2458v6 interfaceC2458v62) throws Throwable {
        try {
            InterfaceC2458v6 interfaceC2458v6M705b = AbstractC0162De.m705b(interfaceC2458v6);
            AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
            AbstractC0974V8.m4342c(interfaceC2458v6M705b, AbstractC0674Ok.m3431a(C2116no.f6480a), null, 2, null);
        } catch (Throwable th) {
            m7296a(interfaceC2458v62, th);
        }
    }

    public static final void m7298c(InterfaceC1920jc interfaceC1920jc, Object obj, InterfaceC2458v6 interfaceC2458v6, InterfaceC0986Vb interfaceC0986Vb) throws Throwable {
        try {
            InterfaceC2458v6 interfaceC2458v6M705b = AbstractC0162De.m705b(AbstractC0162De.m704a(interfaceC1920jc, obj, interfaceC2458v6));
            AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
            AbstractC0974V8.m4341b(interfaceC2458v6M705b, AbstractC0674Ok.m3431a(C2116no.f6480a), interfaceC0986Vb);
        } catch (Throwable th) {
            m7296a(interfaceC2458v6, th);
        }
    }

    public static void m7299d(InterfaceC1920jc interfaceC1920jc, Object obj, InterfaceC2458v6 interfaceC2458v6, InterfaceC0986Vb interfaceC0986Vb, int i, Object obj2) throws Throwable {
        if ((i & 4) != 0) {
            interfaceC0986Vb = null;
        }
        m7298c(interfaceC1920jc, obj, interfaceC2458v6, interfaceC0986Vb);
    }
}
