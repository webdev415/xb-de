package p000;

import java.util.List;
import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C0733Px extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0733Px zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf;
    private InterfaceC1356cD zzg = AbstractC0703PC.m3494B();

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0733Px.zzc);
        }

        public final a m3604t(int i) {
            m3527q();
            C0733Px.m3595H((C0733Px) this.f2099m, i);
            return this;
        }

        public final a m3605u(Iterable iterable) {
            m3527q();
            C0733Px.m3596I((C0733Px) this.f2099m, iterable);
            return this;
        }
    }

    static {
        C0733Px c0733Px = new C0733Px();
        zzc = c0733Px;
        AbstractC0703PC.m3502u(C0733Px.class, c0733Px);
    }

    public static void m3595H(C0733Px c0733Px, int i) {
        c0733Px.zze |= 1;
        c0733Px.zzf = i;
    }

    public static void m3596I(C0733Px c0733Px, Iterable iterable) {
        InterfaceC1356cD interfaceC1356cD = c0733Px.zzg;
        if (!interfaceC1356cD.mo7402c()) {
            c0733Px.zzg = AbstractC0703PC.m3500s(interfaceC1356cD);
        }
        AbstractC1022WA.m4463f(iterable, c0733Px.zzg);
    }

    public static a m3597K() {
        return (a) zzc.m3516x();
    }

    public final long m3599G(int i) {
        return this.zzg.mo5850j(i);
    }

    public final int m3600J() {
        return this.zzf;
    }

    public final List m3601M() {
        return this.zzg;
    }

    public final boolean m3602N() {
        return (this.zze & 1) != 0;
    }

    public final int m3603j() {
        return this.zzg.size();
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0733Px();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0733Px.class) {
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
