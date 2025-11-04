package p000;

import p000.AbstractC0703PC;

public final class C0411Ix extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0411Ix zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private String zzf = "";
    private long zzg;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0411Ix.zzc);
        }

        public final a m1751t(long j) {
            m3527q();
            C0411Ix.m1748H((C0411Ix) this.f2099m, j);
            return this;
        }

        public final a m1752u(String str) {
            m3527q();
            C0411Ix.m1749I((C0411Ix) this.f2099m, str);
            return this;
        }
    }

    static {
        C0411Ix c0411Ix = new C0411Ix();
        zzc = c0411Ix;
        AbstractC0703PC.m3502u(C0411Ix.class, c0411Ix);
    }

    public static a m1747G() {
        return (a) zzc.m3516x();
    }

    public static void m1748H(C0411Ix c0411Ix, long j) {
        c0411Ix.zze |= 2;
        c0411Ix.zzg = j;
    }

    public static void m1749I(C0411Ix c0411Ix, String str) {
        str.getClass();
        c0411Ix.zze |= 1;
        c0411Ix.zzf = str;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0411Ix();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0411Ix.class) {
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
