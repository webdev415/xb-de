package p000;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class AbstractC1783gf {
    public static final InterfaceC2641z5 m7732a(InterfaceC1081Xe interfaceC1081Xe) {
        return new C1221af(interfaceC1081Xe);
    }

    public static InterfaceC2641z5 m7733b(InterfaceC1081Xe interfaceC1081Xe, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC1081Xe = null;
        }
        return AbstractC1736ff.m7582a(interfaceC1081Xe);
    }

    public static final void m7734c(InterfaceC0191E6 interfaceC0191E6, CancellationException cancellationException) {
        InterfaceC1081Xe interfaceC1081Xe = (InterfaceC1081Xe) interfaceC0191E6.mo855b(InterfaceC1081Xe.f3236c);
        if (interfaceC1081Xe != null) {
            interfaceC1081Xe.mo4768A(cancellationException);
        }
    }

    public static void m7735d(InterfaceC0191E6 interfaceC0191E6, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        AbstractC1736ff.m7584c(interfaceC0191E6, cancellationException);
    }
}
