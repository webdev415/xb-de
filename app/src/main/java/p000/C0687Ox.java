package p000;

import java.util.List;
import p000.AbstractC0703PC;

public final class C0687Ox extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0687Ox zzc;
    private static volatile InterfaceC2650zE zzd;
    private InterfaceC1356cD zze = AbstractC0703PC.m3494B();
    private InterfaceC1356cD zzf = AbstractC0703PC.m3494B();
    private InterfaceC1865iD zzg = AbstractC0703PC.m3495C();
    private InterfaceC1865iD zzh = AbstractC0703PC.m3495C();

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0687Ox.zzc);
        }

        public final a m3465A(Iterable iterable) {
            m3527q();
            C0687Ox.m3453Q((C0687Ox) this.f2099m, iterable);
            return this;
        }

        public final a m3466t() {
            m3527q();
            C0687Ox.m3446G((C0687Ox) this.f2099m);
            return this;
        }

        public final a m3467u(Iterable iterable) {
            m3527q();
            C0687Ox.m3447H((C0687Ox) this.f2099m, iterable);
            return this;
        }

        public final a m3468v() {
            m3527q();
            C0687Ox.m3448J((C0687Ox) this.f2099m);
            return this;
        }

        public final a m3469w(Iterable iterable) {
            m3527q();
            C0687Ox.m3449K((C0687Ox) this.f2099m, iterable);
            return this;
        }

        public final a m3470x() {
            m3527q();
            C0687Ox.m3450M((C0687Ox) this.f2099m);
            return this;
        }

        public final a m3471y(Iterable iterable) {
            m3527q();
            C0687Ox.m3451N((C0687Ox) this.f2099m, iterable);
            return this;
        }

        public final a m3472z() {
            m3527q();
            C0687Ox.m3452P((C0687Ox) this.f2099m);
            return this;
        }
    }

    static {
        C0687Ox c0687Ox = new C0687Ox();
        zzc = c0687Ox;
        AbstractC0703PC.m3502u(C0687Ox.class, c0687Ox);
    }

    public static void m3446G(C0687Ox c0687Ox) {
        c0687Ox.zzg = AbstractC0703PC.m3495C();
    }

    public static void m3447H(C0687Ox c0687Ox, Iterable iterable) {
        InterfaceC1865iD interfaceC1865iD = c0687Ox.zzg;
        if (!interfaceC1865iD.mo7402c()) {
            c0687Ox.zzg = AbstractC0703PC.m3501t(interfaceC1865iD);
        }
        AbstractC1022WA.m4463f(iterable, c0687Ox.zzg);
    }

    public static void m3448J(C0687Ox c0687Ox) {
        c0687Ox.zzf = AbstractC0703PC.m3494B();
    }

    public static void m3449K(C0687Ox c0687Ox, Iterable iterable) {
        InterfaceC1356cD interfaceC1356cD = c0687Ox.zzf;
        if (!interfaceC1356cD.mo7402c()) {
            c0687Ox.zzf = AbstractC0703PC.m3500s(interfaceC1356cD);
        }
        AbstractC1022WA.m4463f(iterable, c0687Ox.zzf);
    }

    public static void m3450M(C0687Ox c0687Ox) {
        c0687Ox.zzh = AbstractC0703PC.m3495C();
    }

    public static void m3451N(C0687Ox c0687Ox, Iterable iterable) {
        InterfaceC1865iD interfaceC1865iD = c0687Ox.zzh;
        if (!interfaceC1865iD.mo7402c()) {
            c0687Ox.zzh = AbstractC0703PC.m3501t(interfaceC1865iD);
        }
        AbstractC1022WA.m4463f(iterable, c0687Ox.zzh);
    }

    public static void m3452P(C0687Ox c0687Ox) {
        c0687Ox.zze = AbstractC0703PC.m3494B();
    }

    public static void m3453Q(C0687Ox c0687Ox, Iterable iterable) {
        InterfaceC1356cD interfaceC1356cD = c0687Ox.zze;
        if (!interfaceC1356cD.mo7402c()) {
            c0687Ox.zze = AbstractC0703PC.m3500s(interfaceC1356cD);
        }
        AbstractC1022WA.m4463f(iterable, c0687Ox.zze);
    }

    public static a m3454R() {
        return (a) zzc.m3516x();
    }

    public static C0687Ox m3456T() {
        return zzc;
    }

    public final int m3457I() {
        return this.zzf.size();
    }

    public final int m3458L() {
        return this.zzh.size();
    }

    public final int m3459O() {
        return this.zze.size();
    }

    public final List m3460U() {
        return this.zzg;
    }

    public final List m3461V() {
        return this.zzf;
    }

    public final List m3462W() {
        return this.zzh;
    }

    public final List m3463X() {
        return this.zze;
    }

    public final int m3464j() {
        return this.zzg.size();
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0687Ox();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", C0319Gx.class, "zzh", C0733Px.class});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0687Ox.class) {
                        try {
                            aVar = zzd;
                            if (aVar == null) {
                                aVar = new AbstractC0703PC.a(zzc);
                                zzd = aVar;
                            }
                        } finally {
                        }
                    }
                }
                return aVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
