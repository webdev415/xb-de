package p000;

import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C0319Gx extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0319Gx zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf;
    private long zzg;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0319Gx.zzc);
        }

        public final a m1459t(int i) {
            m3527q();
            C0319Gx.m1451G((C0319Gx) this.f2099m, i);
            return this;
        }

        public final a m1460u(long j) {
            m3527q();
            C0319Gx.m1452H((C0319Gx) this.f2099m, j);
            return this;
        }
    }

    static {
        C0319Gx c0319Gx = new C0319Gx();
        zzc = c0319Gx;
        AbstractC0703PC.m3502u(C0319Gx.class, c0319Gx);
    }

    public static void m1451G(C0319Gx c0319Gx, int i) {
        c0319Gx.zze |= 1;
        c0319Gx.zzf = i;
    }

    public static void m1452H(C0319Gx c0319Gx, long j) {
        c0319Gx.zze |= 2;
        c0319Gx.zzg = j;
    }

    public static a m1453J() {
        return (a) zzc.m3516x();
    }

    public final long m1455I() {
        return this.zzg;
    }

    public final boolean m1456L() {
        return (this.zze & 2) != 0;
    }

    public final boolean m1457M() {
        return (this.zze & 1) != 0;
    }

    public final int m1458j() {
        return this.zzf;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0319Gx();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0319Gx.class) {
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
