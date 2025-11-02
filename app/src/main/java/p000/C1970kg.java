package p000;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* loaded from: classes.dex */
public final class C1970kg {

    public static final C1970kg f6020a;

    public static final AbstractC1878ig f6021b;

    static {
        C1970kg c1970kg = new C1970kg();
        f6020a = c1970kg;
        AbstractC1229an.m5307f("kotlinx.coroutines.fast.service.loader", true);
        f6021b = c1970kg.m8297a();
    }

    public final AbstractC1878ig m8297a() {
        Object next;
        AbstractC1878ig abstractC1878igM8401e;
        try {
            List listM1280j = AbstractC0261Fl.m1280j(AbstractC0169Dl.m731a(ServiceLoader.load(InterfaceC1924jg.class, InterfaceC1924jg.class.getClassLoader()).iterator()));
            Iterator it = listM1280j.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iMo2807a = ((InterfaceC1924jg) next).mo2807a();
                    do {
                        Object next2 = it.next();
                        int iMo2807a2 = ((InterfaceC1924jg) next2).mo2807a();
                        if (iMo2807a < iMo2807a2) {
                            next = next2;
                            iMo2807a = iMo2807a2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            InterfaceC1924jg interfaceC1924jg = (InterfaceC1924jg) next;
            if (interfaceC1924jg != null && (abstractC1878igM8401e = AbstractC2016lg.m8401e(interfaceC1924jg, listM1280j)) != null) {
                return abstractC1878igM8401e;
            }
            return AbstractC2016lg.m8398b(null, null, 3, null);
        } catch (Throwable th) {
            return AbstractC2016lg.m8398b(th, null, 2, null);
        }
    }
}
