package p000;

import java.util.List;

public abstract class AbstractC2016lg {
    public static final AbstractC0899Tg m8397a(Throwable th, String str) throws Throwable {
        if (th != null) {
            throw th;
        }
        m8400d();
        throw new C2568xf();
    }

    public static AbstractC0899Tg m8398b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return m8397a(th, str);
    }

    public static final boolean m8399c(AbstractC1878ig abstractC1878ig) {
        return abstractC1878ig.mo3817W() instanceof AbstractC0899Tg;
    }

    public static final Void m8400d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final AbstractC1878ig m8401e(InterfaceC1924jg interfaceC1924jg, List list) {
        try {
            return interfaceC1924jg.mo2809c(list);
        } catch (Throwable th) {
            return m8397a(th, interfaceC1924jg.mo2808b());
        }
    }
}
