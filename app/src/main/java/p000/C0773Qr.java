package p000;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class C0773Qr extends AbstractC1935jr {
    public C0773Qr() {
        this.f5966a.add(EnumC2259qs.FOR_IN);
        this.f5966a.add(EnumC2259qs.FOR_IN_CONST);
        this.f5966a.add(EnumC2259qs.FOR_IN_LET);
        this.f5966a.add(EnumC2259qs.FOR_LET);
        this.f5966a.add(EnumC2259qs.FOR_OF);
        this.f5966a.add(EnumC2259qs.FOR_OF_CONST);
        this.f5966a.add(EnumC2259qs.FOR_OF_LET);
        this.f5966a.add(EnumC2259qs.WHILE);
    }

    public static InterfaceC0909Tq m3708c(InterfaceC1140Yr interfaceC1140Yr, Iterator it, InterfaceC0909Tq interfaceC0909Tq) {
        if (it != null) {
            while (it.hasNext()) {
                InterfaceC0909Tq interfaceC0909TqM9630b = interfaceC1140Yr.mo4295a((InterfaceC0909Tq) it.next()).m9630b((C2257qq) interfaceC0909Tq);
                if (interfaceC0909TqM9630b instanceof C0174Dq) {
                    C0174Dq c0174Dq = (C0174Dq) interfaceC0909TqM9630b;
                    if ("break".equals(c0174Dq.m781b())) {
                        return InterfaceC0909Tq.f2785d;
                    }
                    if ("return".equals(c0174Dq.m781b())) {
                        return c0174Dq;
                    }
                }
            }
        }
        return InterfaceC0909Tq.f2785d;
    }

    public static InterfaceC0909Tq m3709d(InterfaceC1140Yr interfaceC1140Yr, InterfaceC0909Tq interfaceC0909Tq, InterfaceC0909Tq interfaceC0909Tq2) {
        return m3708c(interfaceC1140Yr, interfaceC0909Tq.mo155i(), interfaceC0909Tq2);
    }

    public static InterfaceC0909Tq m3710e(InterfaceC1140Yr interfaceC1140Yr, InterfaceC0909Tq interfaceC0909Tq, InterfaceC0909Tq interfaceC0909Tq2) {
        if (interfaceC0909Tq instanceof Iterable) {
            return m3708c(interfaceC1140Yr, ((Iterable) interfaceC0909Tq).iterator(), interfaceC0909Tq2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[SYNTHETIC] */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final InterfaceC0909Tq mo160b(String r11, C2357sy r12, java.util.List r13) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0773Qr.mo160b(java.lang.String, sy, java.util.List):Tq");
    }
}
