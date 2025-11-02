package p000;

import p000.AbstractC0703PC;
import p000.C0687Ox;

public final class C0273Fx extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0273Fx zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf;
    private C0687Ox zzg;
    private C0687Ox zzh;
    private boolean zzi;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0273Fx.zzc);
        }

        public final a m1307t(int i) {
            m3527q();
            C0273Fx.m1294G((C0273Fx) this.f2099m, i);
            return this;
        }

        public final a m1308u(C0687Ox.a aVar) {
            m3527q();
            C0273Fx.m1295H((C0273Fx) this.f2099m, (C0687Ox) ((AbstractC0703PC) aVar.m3526o()));
            return this;
        }

        public final a m1309v(C0687Ox c0687Ox) {
            m3527q();
            C0273Fx.m1298K((C0273Fx) this.f2099m, c0687Ox);
            return this;
        }

        public final a m1310w(boolean z) {
            m3527q();
            C0273Fx.m1296I((C0273Fx) this.f2099m, z);
            return this;
        }
    }

    static {
        C0273Fx c0273Fx = new C0273Fx();
        zzc = c0273Fx;
        AbstractC0703PC.m3502u(C0273Fx.class, c0273Fx);
    }

    public static void m1294G(C0273Fx c0273Fx, int i) {
        c0273Fx.zze |= 1;
        c0273Fx.zzf = i;
    }

    public static void m1295H(C0273Fx c0273Fx, C0687Ox c0687Ox) {
        c0687Ox.getClass();
        c0273Fx.zzg = c0687Ox;
        c0273Fx.zze |= 2;
    }

    public static void m1296I(C0273Fx c0273Fx, boolean z) {
        c0273Fx.zze |= 8;
        c0273Fx.zzi = z;
    }

    public static a m1297J() {
        return (a) zzc.m3516x();
    }

    public static void m1298K(C0273Fx c0273Fx, C0687Ox c0687Ox) {
        c0687Ox.getClass();
        c0273Fx.zzh = c0687Ox;
        c0273Fx.zze |= 4;
    }

    public final C0687Ox m1300M() {
        C0687Ox c0687Ox = this.zzg;
        return c0687Ox == null ? C0687Ox.m3456T() : c0687Ox;
    }

    public final C0687Ox m1301N() {
        C0687Ox c0687Ox = this.zzh;
        return c0687Ox == null ? C0687Ox.m3456T() : c0687Ox;
    }

    public final boolean m1302O() {
        return this.zzi;
    }

    public final boolean m1303P() {
        return (this.zze & 1) != 0;
    }

    public final boolean m1304Q() {
        return (this.zze & 8) != 0;
    }

    public final boolean m1305R() {
        return (this.zze & 4) != 0;
    }

    public final int m1306j() {
        return this.zzf;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0273Fx();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0273Fx.class) {
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
