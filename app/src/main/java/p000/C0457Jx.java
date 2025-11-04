package p000;

import java.util.List;
import p000.AbstractC0703PC;

public final class C0457Jx extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0457Jx zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private long zzh;
    private float zzi;
    private double zzj;
    private String zzf = "";
    private String zzg = "";
    private InterfaceC1865iD zzk = AbstractC0703PC.m3495C();

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0457Jx.zzc);
        }

        public final a m2200A(String str) {
            m3527q();
            C0457Jx.m2182P((C0457Jx) this.f2099m, str);
            return this;
        }

        public final a m2201B() {
            m3527q();
            C0457Jx.m2181O((C0457Jx) this.f2099m);
            return this;
        }

        public final a m2202C() {
            m3527q();
            C0457Jx.m2183R((C0457Jx) this.f2099m);
            return this;
        }

        public final a m2203D() {
            m3527q();
            C0457Jx.m2184T((C0457Jx) this.f2099m);
            return this;
        }

        public final String m2204E() {
            return ((C0457Jx) this.f2099m).m2191W();
        }

        public final String m2205F() {
            return ((C0457Jx) this.f2099m).m2192X();
        }

        public final int m2206t() {
            return ((C0457Jx) this.f2099m).m2189Q();
        }

        public final a m2207u(double d) {
            m3527q();
            C0457Jx.m2176I((C0457Jx) this.f2099m, d);
            return this;
        }

        public final a m2208v(long j) {
            m3527q();
            C0457Jx.m2177J((C0457Jx) this.f2099m, j);
            return this;
        }

        public final a m2209w(Iterable iterable) {
            m3527q();
            C0457Jx.m2178K((C0457Jx) this.f2099m, iterable);
            return this;
        }

        public final a m2210x(String str) {
            m3527q();
            C0457Jx.m2179L((C0457Jx) this.f2099m, str);
            return this;
        }

        public final a m2211y(a aVar) {
            m3527q();
            C0457Jx.m2180M((C0457Jx) this.f2099m, (C0457Jx) ((AbstractC0703PC) aVar.m3526o()));
            return this;
        }

        public final a m2212z() {
            m3527q();
            C0457Jx.m2175H((C0457Jx) this.f2099m);
            return this;
        }
    }

    static {
        C0457Jx c0457Jx = new C0457Jx();
        zzc = c0457Jx;
        AbstractC0703PC.m3502u(C0457Jx.class, c0457Jx);
    }

    public static void m2175H(C0457Jx c0457Jx) {
        c0457Jx.zze &= -17;
        c0457Jx.zzj = 0.0d;
    }

    public static void m2176I(C0457Jx c0457Jx, double d) {
        c0457Jx.zze |= 16;
        c0457Jx.zzj = d;
    }

    public static void m2177J(C0457Jx c0457Jx, long j) {
        c0457Jx.zze |= 4;
        c0457Jx.zzh = j;
    }

    public static void m2178K(C0457Jx c0457Jx, Iterable iterable) {
        c0457Jx.m2199e0();
        AbstractC1022WA.m4463f(iterable, c0457Jx.zzk);
    }

    public static void m2179L(C0457Jx c0457Jx, String str) {
        str.getClass();
        c0457Jx.zze |= 1;
        c0457Jx.zzf = str;
    }

    public static void m2180M(C0457Jx c0457Jx, C0457Jx c0457Jx2) {
        c0457Jx2.getClass();
        c0457Jx.m2199e0();
        c0457Jx.zzk.add(c0457Jx2);
    }

    public static void m2181O(C0457Jx c0457Jx) {
        c0457Jx.zze &= -5;
        c0457Jx.zzh = 0L;
    }

    public static void m2182P(C0457Jx c0457Jx, String str) {
        str.getClass();
        c0457Jx.zze |= 2;
        c0457Jx.zzg = str;
    }

    public static void m2183R(C0457Jx c0457Jx) {
        c0457Jx.zzk = AbstractC0703PC.m3495C();
    }

    public static void m2184T(C0457Jx c0457Jx) {
        c0457Jx.zze &= -3;
        c0457Jx.zzg = zzc.zzg;
    }

    public static a m2185U() {
        return (a) zzc.m3516x();
    }

    public final double m2187G() {
        return this.zzj;
    }

    public final float m2188N() {
        return this.zzi;
    }

    public final int m2189Q() {
        return this.zzk.size();
    }

    public final long m2190S() {
        return this.zzh;
    }

    public final String m2191W() {
        return this.zzf;
    }

    public final String m2192X() {
        return this.zzg;
    }

    public final List m2193Y() {
        return this.zzk;
    }

    public final boolean m2194Z() {
        return (this.zze & 16) != 0;
    }

    public final boolean m2195a0() {
        return (this.zze & 8) != 0;
    }

    public final boolean m2196b0() {
        return (this.zze & 4) != 0;
    }

    public final boolean m2197c0() {
        return (this.zze & 1) != 0;
    }

    public final boolean m2198d0() {
        return (this.zze & 2) != 0;
    }

    public final void m2199e0() {
        InterfaceC1865iD interfaceC1865iD = this.zzk;
        if (interfaceC1865iD.mo7402c()) {
            return;
        }
        this.zzk = AbstractC0703PC.m3501t(interfaceC1865iD);
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0457Jx();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", C0457Jx.class});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0457Jx.class) {
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
