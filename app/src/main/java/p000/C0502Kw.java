package p000;

import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C0502Kw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0502Kw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private boolean zzh;
    private int zzi;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0502Kw.zzc);
        }

        public final boolean m2560A() {
            return ((C0502Kw) this.f2099m).m2558N();
        }

        public final int m2561t() {
            return ((C0502Kw) this.f2099m).m2559j();
        }

        public final a m2562u(String str) {
            m3527q();
            C0502Kw.m2551G((C0502Kw) this.f2099m, str);
            return this;
        }

        public final String m2563v() {
            return ((C0502Kw) this.f2099m).m2553I();
        }

        public final boolean m2564w() {
            return ((C0502Kw) this.f2099m).m2554J();
        }

        public final boolean m2565x() {
            return ((C0502Kw) this.f2099m).m2555K();
        }

        public final boolean m2566y() {
            return ((C0502Kw) this.f2099m).m2556L();
        }

        public final boolean m2567z() {
            return ((C0502Kw) this.f2099m).m2557M();
        }
    }

    static {
        C0502Kw c0502Kw = new C0502Kw();
        zzc = c0502Kw;
        AbstractC0703PC.m3502u(C0502Kw.class, c0502Kw);
    }

    public static void m2551G(C0502Kw c0502Kw, String str) {
        str.getClass();
        c0502Kw.zze |= 1;
        c0502Kw.zzf = str;
    }

    public final String m2553I() {
        return this.zzf;
    }

    public final boolean m2554J() {
        return this.zzg;
    }

    public final boolean m2555K() {
        return this.zzh;
    }

    public final boolean m2556L() {
        return (this.zze & 2) != 0;
    }

    public final boolean m2557M() {
        return (this.zze & 4) != 0;
    }

    public final boolean m2558N() {
        return (this.zze & 8) != 0;
    }

    public final int m2559j() {
        return this.zzi;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0364Hw.f1109a[i - 1]) {
            case 1:
                return new C0502Kw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0502Kw.class) {
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
