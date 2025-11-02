package p000;

import java.util.concurrent.CancellationException;
import p000.InterfaceC0191E6;

/* loaded from: classes.dex */
public interface InterfaceC1081Xe extends InterfaceC0191E6.b {

    public static final b f3236c = b.f3237l;

    public static final class a {
        public static Object m4774a(InterfaceC1081Xe interfaceC1081Xe, Object obj, InterfaceC1920jc interfaceC1920jc) {
            return InterfaceC0191E6.b.a.m859a(interfaceC1081Xe, obj, interfaceC1920jc);
        }

        public static InterfaceC0191E6.b m4775b(InterfaceC1081Xe interfaceC1081Xe, c cVar) {
            return InterfaceC0191E6.b.a.m860b(interfaceC1081Xe, cVar);
        }

        public static InterfaceC1627d9 m4776c(InterfaceC1081Xe interfaceC1081Xe, boolean z, boolean z2, InterfaceC0986Vb interfaceC0986Vb, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return interfaceC1081Xe.mo4771p(z, z2, interfaceC0986Vb);
        }

        public static InterfaceC0191E6 m4777d(InterfaceC1081Xe interfaceC1081Xe, c cVar) {
            return InterfaceC0191E6.b.a.m861c(interfaceC1081Xe, cVar);
        }

        public static InterfaceC0191E6 m4778e(InterfaceC1081Xe interfaceC1081Xe, InterfaceC0191E6 interfaceC0191E6) {
            return InterfaceC0191E6.b.a.m862d(interfaceC1081Xe, interfaceC0191E6);
        }
    }

    public static final class b implements c {

        public static final b f3237l = new b();
    }

    void mo4768A(CancellationException cancellationException);

    boolean mo4769a();

    CancellationException mo4770l();

    InterfaceC1627d9 mo4771p(boolean z, boolean z2, InterfaceC0986Vb interfaceC0986Vb);

    boolean start();

    InterfaceC2640z4 mo4772u(InterfaceC0051B4 interfaceC0051B4);

    InterfaceC1627d9 mo4773w(InterfaceC0986Vb interfaceC0986Vb);
}
