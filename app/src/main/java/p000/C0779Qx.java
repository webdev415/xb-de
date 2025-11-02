package p000;

import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C0779Qx extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0779Qx zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private long zzf;
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private float zzj;
    private double zzk;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0779Qx.zzc);
        }

        public final a m3738A() {
            m3527q();
            C0779Qx.m3724Q((C0779Qx) this.f2099m);
            return this;
        }

        public final a m3739t() {
            m3527q();
            C0779Qx.m3717H((C0779Qx) this.f2099m);
            return this;
        }

        public final a m3740u(double d) {
            m3527q();
            C0779Qx.m3718I((C0779Qx) this.f2099m, d);
            return this;
        }

        public final a m3741v(long j) {
            m3527q();
            C0779Qx.m3719J((C0779Qx) this.f2099m, j);
            return this;
        }

        public final a m3742w(String str) {
            m3527q();
            C0779Qx.m3720K((C0779Qx) this.f2099m, str);
            return this;
        }

        public final a m3743x() {
            m3527q();
            C0779Qx.m3721M((C0779Qx) this.f2099m);
            return this;
        }

        public final a m3744y(long j) {
            m3527q();
            C0779Qx.m3722N((C0779Qx) this.f2099m, j);
            return this;
        }

        public final a m3745z(String str) {
            m3527q();
            C0779Qx.m3723O((C0779Qx) this.f2099m, str);
            return this;
        }
    }

    static {
        C0779Qx c0779Qx = new C0779Qx();
        zzc = c0779Qx;
        AbstractC0703PC.m3502u(C0779Qx.class, c0779Qx);
    }

    public static void m3717H(C0779Qx c0779Qx) {
        c0779Qx.zze &= -33;
        c0779Qx.zzk = 0.0d;
    }

    public static void m3718I(C0779Qx c0779Qx, double d) {
        c0779Qx.zze |= 32;
        c0779Qx.zzk = d;
    }

    public static void m3719J(C0779Qx c0779Qx, long j) {
        c0779Qx.zze |= 8;
        c0779Qx.zzi = j;
    }

    public static void m3720K(C0779Qx c0779Qx, String str) {
        str.getClass();
        c0779Qx.zze |= 2;
        c0779Qx.zzg = str;
    }

    public static void m3721M(C0779Qx c0779Qx) {
        c0779Qx.zze &= -9;
        c0779Qx.zzi = 0L;
    }

    public static void m3722N(C0779Qx c0779Qx, long j) {
        c0779Qx.zze |= 1;
        c0779Qx.zzf = j;
    }

    public static void m3723O(C0779Qx c0779Qx, String str) {
        str.getClass();
        c0779Qx.zze |= 4;
        c0779Qx.zzh = str;
    }

    public static void m3724Q(C0779Qx c0779Qx) {
        c0779Qx.zze &= -5;
        c0779Qx.zzh = zzc.zzh;
    }

    public static a m3725S() {
        return (a) zzc.m3516x();
    }

    public final double m3727G() {
        return this.zzk;
    }

    public final float m3728L() {
        return this.zzj;
    }

    public final long m3729P() {
        return this.zzi;
    }

    public final long m3730R() {
        return this.zzf;
    }

    public final String m3731U() {
        return this.zzg;
    }

    public final String m3732V() {
        return this.zzh;
    }

    public final boolean m3733W() {
        return (this.zze & 32) != 0;
    }

    public final boolean m3734X() {
        return (this.zze & 16) != 0;
    }

    public final boolean m3735Y() {
        return (this.zze & 8) != 0;
    }

    public final boolean m3736Z() {
        return (this.zze & 1) != 0;
    }

    public final boolean m3737a0() {
        return (this.zze & 4) != 0;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0779Qx();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0779Qx.class) {
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
