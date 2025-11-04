package p000;

import p000.AbstractC0703PC;

public final class C2124nw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C2124nw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private C2032lw zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C2124nw.zzc);
        }

        public final a m8809t(String str) {
            m3527q();
            C2124nw.m8798G((C2124nw) this.f2099m, str);
            return this;
        }
    }

    static {
        C2124nw c2124nw = new C2124nw();
        zzc = c2124nw;
        AbstractC0703PC.m3502u(C2124nw.class, c2124nw);
    }

    public static void m8798G(C2124nw c2124nw, String str) {
        str.getClass();
        c2124nw.zze |= 2;
        c2124nw.zzg = str;
    }

    public static a m8799I() {
        return (a) zzc.m3516x();
    }

    public final C2032lw m8801H() {
        C2032lw c2032lw = this.zzh;
        return c2032lw == null ? C2032lw.m8417I() : c2032lw;
    }

    public final String m8802K() {
        return this.zzg;
    }

    public final boolean m8803L() {
        return this.zzi;
    }

    public final boolean m8804M() {
        return this.zzj;
    }

    public final boolean m8805N() {
        return this.zzk;
    }

    public final boolean m8806O() {
        return (this.zze & 1) != 0;
    }

    public final boolean m8807P() {
        return (this.zze & 32) != 0;
    }

    public final int m8808j() {
        return this.zzf;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC1893iw.f5832a[i - 1]) {
            case 1:
                return new C2124nw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C2124nw.class) {
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
