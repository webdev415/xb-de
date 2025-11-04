package p000;

import java.util.Iterator;

public abstract class AbstractC0421J6 {
    public static final void m1821a(InterfaceC0191E6 interfaceC0191E6, Throwable th) {
        Iterator it = AbstractC0375I6.m1675a().iterator();
        while (it.hasNext()) {
            try {
                ((InterfaceC0329H6) it.next()).mo1511g(interfaceC0191E6, th);
            } catch (Throwable th2) {
                AbstractC0375I6.m1676b(AbstractC0467K6.m2290b(th, th2));
            }
        }
        try {
            AbstractC2241qa.m9151a(th, new C0836S8(interfaceC0191E6));
        } catch (Throwable unused) {
        }
        AbstractC0375I6.m1676b(th);
    }
}
