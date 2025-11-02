package p000;

import p000.AbstractC0674Ok;

/* loaded from: classes.dex */
public abstract class AbstractC2505w7 {
    public static final String m10433a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String m10434b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String m10435c(InterfaceC2458v6 interfaceC2458v6) {
        Object objM3431a;
        if (interfaceC2458v6 instanceof C0928U8) {
            return interfaceC2458v6.toString();
        }
        try {
            AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
            objM3431a = AbstractC0674Ok.m3431a(interfaceC2458v6 + '@' + m10434b(interfaceC2458v6));
        } catch (Throwable th) {
            AbstractC0674Ok.a aVar2 = AbstractC0674Ok.f2054l;
            objM3431a = AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(th));
        }
        if (AbstractC0674Ok.m3432b(objM3431a) != null) {
            objM3431a = interfaceC2458v6.getClass().getName() + '@' + m10434b(interfaceC2458v6);
        }
        return (String) objM3431a;
    }
}
