package p000;

import p000.AbstractC0674Ok;

public abstract class AbstractC1066X8 {
    public static final void m4659a(AbstractC1020W8 abstractC1020W8, int i) {
        InterfaceC2458v6 interfaceC2458v6Mo4192b = abstractC1020W8.mo4192b();
        boolean z = i == 4;
        if (z || !(interfaceC2458v6Mo4192b instanceof C0928U8) || m4660b(i) != m4660b(abstractC1020W8.f3036n)) {
            m4662d(abstractC1020W8, interfaceC2458v6Mo4192b, z);
            return;
        }
        AbstractC0283G6 abstractC0283G6 = ((C0928U8) interfaceC2458v6Mo4192b).f2829o;
        InterfaceC0191E6 interfaceC0191E6Mo197f = interfaceC2458v6Mo4192b.mo197f();
        if (abstractC0283G6.mo1352U(interfaceC0191E6Mo197f)) {
            abstractC0283G6.mo1351T(interfaceC0191E6Mo197f, abstractC1020W8);
        } else {
            m4663e(abstractC1020W8);
        }
    }

    public static final boolean m4660b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean m4661c(int i) {
        return i == 2;
    }

    public static final void m4662d(AbstractC1020W8 abstractC1020W8, InterfaceC2458v6 interfaceC2458v6, boolean z) {
        Object objMo4452e;
        Object objMo4193i = abstractC1020W8.mo4193i();
        Throwable thMo4451c = abstractC1020W8.mo4451c(objMo4193i);
        if (thMo4451c != null) {
            AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
            objMo4452e = AbstractC0766Qk.m3695a(thMo4451c);
        } else {
            AbstractC0674Ok.a aVar2 = AbstractC0674Ok.f2054l;
            objMo4452e = abstractC1020W8.mo4452e(objMo4193i);
        }
        Object objM3431a = AbstractC0674Ok.m3431a(objMo4452e);
        if (!z) {
            interfaceC2458v6.mo198h(objM3431a);
            return;
        }
        AbstractC0116Ce.m474c(interfaceC2458v6, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        C0928U8 c0928u8 = (C0928U8) interfaceC2458v6;
        InterfaceC2458v6 interfaceC2458v62 = c0928u8.f2830p;
        Object obj = c0928u8.f2832r;
        InterfaceC0191E6 interfaceC0191E6Mo197f = interfaceC2458v62.mo197f();
        Object objM10600c = AbstractC2530wn.m10600c(interfaceC0191E6Mo197f, obj);
        if (objM10600c != AbstractC2530wn.f7898a) {
            AbstractC0237F6.m1207f(interfaceC2458v62, interfaceC0191E6Mo197f, objM10600c);
        }
        try {
            c0928u8.f2830p.mo198h(objM3431a);
            C2116no c2116no = C2116no.f6480a;
        } finally {
            AbstractC2530wn.m10598a(interfaceC0191E6Mo197f, objM10600c);
        }
    }

    public static final void m4663e(AbstractC1020W8 abstractC1020W8) {
        AbstractC1964ka abstractC1964kaM10781a = C2576xn.f8026a.m10781a();
        if (abstractC1964kaM10781a.m8270c0()) {
            abstractC1964kaM10781a.m8267Y(abstractC1020W8);
            return;
        }
        abstractC1964kaM10781a.m8269a0(true);
        try {
            m4662d(abstractC1020W8, abstractC1020W8.mo4192b(), true);
            do {
            } while (abstractC1964kaM10781a.m8272e0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
