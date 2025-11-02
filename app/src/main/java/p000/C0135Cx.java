package p000;

import p000.AbstractC0703PC;

public final class C0135Cx extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0135Cx zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private long zzi;
    private long zzm;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0135Cx.zzc);
        }

        public final a m569A(String str) {
            m3527q();
            C0135Cx.m543Q((C0135Cx) this.f2099m, str);
            return this;
        }

        public final a m570B() {
            m3527q();
            C0135Cx.m538L((C0135Cx) this.f2099m);
            return this;
        }

        public final a m571C(String str) {
            m3527q();
            C0135Cx.m546T((C0135Cx) this.f2099m, str);
            return this;
        }

        public final a m572D() {
            m3527q();
            C0135Cx.m542P((C0135Cx) this.f2099m);
            return this;
        }

        public final a m573E(String str) {
            m3527q();
            C0135Cx.m549W((C0135Cx) this.f2099m, str);
            return this;
        }

        public final a m574F() {
            m3527q();
            C0135Cx.m545S((C0135Cx) this.f2099m);
            return this;
        }

        public final a m575G(String str) {
            m3527q();
            C0135Cx.m551Z((C0135Cx) this.f2099m, str);
            return this;
        }

        public final a m576H() {
            m3527q();
            C0135Cx.m548V((C0135Cx) this.f2099m);
            return this;
        }

        public final a m577I() {
            m3527q();
            C0135Cx.m550Y((C0135Cx) this.f2099m);
            return this;
        }

        public final long m578t() {
            return ((C0135Cx) this.f2099m).m552G();
        }

        public final a m579u(long j) {
            m3527q();
            C0135Cx.m536I((C0135Cx) this.f2099m, j);
            return this;
        }

        public final a m580v(String str) {
            m3527q();
            C0135Cx.m537J((C0135Cx) this.f2099m, str);
            return this;
        }

        public final long m581w() {
            return ((C0135Cx) this.f2099m).m553K();
        }

        public final a m582x(long j) {
            m3527q();
            C0135Cx.m539M((C0135Cx) this.f2099m, j);
            return this;
        }

        public final a m583y(String str) {
            m3527q();
            C0135Cx.m540N((C0135Cx) this.f2099m, str);
            return this;
        }

        public final a m584z() {
            m3527q();
            C0135Cx.m535H((C0135Cx) this.f2099m);
            return this;
        }
    }

    static {
        C0135Cx c0135Cx = new C0135Cx();
        zzc = c0135Cx;
        AbstractC0703PC.m3502u(C0135Cx.class, c0135Cx);
    }

    public static void m535H(C0135Cx c0135Cx) {
        c0135Cx.zze &= -5;
        c0135Cx.zzh = zzc.zzh;
    }

    public static void m536I(C0135Cx c0135Cx, long j) {
        c0135Cx.zze |= 8;
        c0135Cx.zzi = j;
    }

    public static void m537J(C0135Cx c0135Cx, String str) {
        str.getClass();
        c0135Cx.zze |= 4;
        c0135Cx.zzh = str;
    }

    public static void m538L(C0135Cx c0135Cx) {
        c0135Cx.zze &= -3;
        c0135Cx.zzg = zzc.zzg;
    }

    public static void m539M(C0135Cx c0135Cx, long j) {
        c0135Cx.zze |= 128;
        c0135Cx.zzm = j;
    }

    public static void m540N(C0135Cx c0135Cx, String str) {
        str.getClass();
        c0135Cx.zze |= 2;
        c0135Cx.zzg = str;
    }

    public static a m541O() {
        return (a) zzc.m3516x();
    }

    public static void m542P(C0135Cx c0135Cx) {
        c0135Cx.zze &= -2;
        c0135Cx.zzf = zzc.zzf;
    }

    public static void m543Q(C0135Cx c0135Cx, String str) {
        str.getClass();
        c0135Cx.zze |= 1;
        c0135Cx.zzf = str;
    }

    public static void m545S(C0135Cx c0135Cx) {
        c0135Cx.zze &= -65;
        c0135Cx.zzl = zzc.zzl;
    }

    public static void m546T(C0135Cx c0135Cx, String str) {
        str.getClass();
        c0135Cx.zze |= 64;
        c0135Cx.zzl = str;
    }

    public static C0135Cx m547U() {
        return zzc;
    }

    public static void m548V(C0135Cx c0135Cx) {
        c0135Cx.zze &= -33;
        c0135Cx.zzk = zzc.zzk;
    }

    public static void m549W(C0135Cx c0135Cx, String str) {
        str.getClass();
        c0135Cx.zze |= 32;
        c0135Cx.zzk = str;
    }

    public static void m550Y(C0135Cx c0135Cx) {
        c0135Cx.zze &= -17;
        c0135Cx.zzj = zzc.zzj;
    }

    public static void m551Z(C0135Cx c0135Cx, String str) {
        str.getClass();
        c0135Cx.zze |= 16;
        c0135Cx.zzj = str;
    }

    public final long m552G() {
        return this.zzi;
    }

    public final long m553K() {
        return this.zzm;
    }

    public final String m554X() {
        return this.zzh;
    }

    public final String m555a0() {
        return this.zzg;
    }

    public final String m556b0() {
        return this.zzf;
    }

    public final String m557c0() {
        return this.zzl;
    }

    public final String m558d0() {
        return this.zzk;
    }

    public final String m559e0() {
        return this.zzj;
    }

    public final boolean m560f0() {
        return (this.zze & 4) != 0;
    }

    public final boolean m561g0() {
        return (this.zze & 2) != 0;
    }

    public final boolean m562h0() {
        return (this.zze & 1) != 0;
    }

    public final boolean m563i0() {
        return (this.zze & 8) != 0;
    }

    public final boolean m564j0() {
        return (this.zze & 128) != 0;
    }

    public final boolean m565k0() {
        return (this.zze & 64) != 0;
    }

    public final boolean m566l0() {
        return (this.zze & 32) != 0;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0135Cx();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0135Cx.class) {
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

    public final boolean m568m0() {
        return (this.zze & 16) != 0;
    }
}
