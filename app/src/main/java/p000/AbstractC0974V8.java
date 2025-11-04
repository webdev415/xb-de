package p000;

import java.util.concurrent.CancellationException;
import p000.AbstractC0674Ok;

public abstract class AbstractC0974V8 {

    public static final C0951Um f2940a = new C0951Um("UNDEFINED");

    public static final C0951Um f2941b = new C0951Um("REUSABLE_CLAIMED");

    public static final void m4341b(InterfaceC2458v6 interfaceC2458v6, Object obj, InterfaceC0986Vb interfaceC0986Vb) {
        if (!(interfaceC2458v6 instanceof C0928U8)) {
            interfaceC2458v6.mo198h(obj);
            return;
        }
        C0928U8 c0928u8 = (C0928U8) interfaceC2458v6;
        Object objM1347b = AbstractC0282G5.m1347b(obj, interfaceC0986Vb);
        if (c0928u8.f2829o.mo1352U(c0928u8.mo197f())) {
            c0928u8.f2831q = objM1347b;
            c0928u8.f3036n = 1;
            c0928u8.f2829o.mo1351T(c0928u8.mo197f(), c0928u8);
            return;
        }
        AbstractC1964ka abstractC1964kaM10781a = C2576xn.f8026a.m10781a();
        if (abstractC1964kaM10781a.m8270c0()) {
            c0928u8.f2831q = objM1347b;
            c0928u8.f3036n = 1;
            abstractC1964kaM10781a.m8267Y(c0928u8);
            return;
        }
        abstractC1964kaM10781a.m8269a0(true);
        try {
            InterfaceC1081Xe interfaceC1081Xe = (InterfaceC1081Xe) c0928u8.mo197f().mo855b(InterfaceC1081Xe.f3236c);
            if (interfaceC1081Xe == null || interfaceC1081Xe.mo4769a()) {
                InterfaceC2458v6 interfaceC2458v62 = c0928u8.f2830p;
                Object obj2 = c0928u8.f2832r;
                InterfaceC0191E6 interfaceC0191E6Mo197f = interfaceC2458v62.mo197f();
                Object objM10600c = AbstractC2530wn.m10600c(interfaceC0191E6Mo197f, obj2);
                if (objM10600c != AbstractC2530wn.f7898a) {
                    AbstractC0237F6.m1207f(interfaceC2458v62, interfaceC0191E6Mo197f, objM10600c);
                }
                try {
                    c0928u8.f2830p.mo198h(obj);
                    C2116no c2116no = C2116no.f6480a;
                } finally {
                    AbstractC2530wn.m10598a(interfaceC0191E6Mo197f, objM10600c);
                }
            } else {
                CancellationException cancellationExceptionMo4770l = interfaceC1081Xe.mo4770l();
                c0928u8.mo4191a(objM1347b, cancellationExceptionMo4770l);
                AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
                c0928u8.mo198h(AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(cancellationExceptionMo4770l)));
            }
            while (abstractC1964kaM10781a.m8272e0()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void m4342c(InterfaceC2458v6 interfaceC2458v6, Object obj, InterfaceC0986Vb interfaceC0986Vb, int i, Object obj2) {
        if ((i & 2) != 0) {
            interfaceC0986Vb = null;
        }
        m4341b(interfaceC2458v6, obj, interfaceC0986Vb);
    }
}
