package p000;

import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C0227Ex extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0227Ex zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0227Ex.zzc);
        }

        public final a m1150t(boolean z) {
            m3527q();
            C0227Ex.m1134H((C0227Ex) this.f2099m, z);
            return this;
        }

        public final a m1151u(boolean z) {
            m3527q();
            C0227Ex.m1136J((C0227Ex) this.f2099m, z);
            return this;
        }

        public final a m1152v(boolean z) {
            m3527q();
            C0227Ex.m1138L((C0227Ex) this.f2099m, z);
            return this;
        }

        public final a m1153w(boolean z) {
            m3527q();
            C0227Ex.m1139M((C0227Ex) this.f2099m, z);
            return this;
        }

        public final a m1154x(boolean z) {
            m3527q();
            C0227Ex.m1140O((C0227Ex) this.f2099m, z);
            return this;
        }

        public final a m1155y(boolean z) {
            m3527q();
            C0227Ex.m1141Q((C0227Ex) this.f2099m, z);
            return this;
        }

        public final a m1156z(boolean z) {
            m3527q();
            C0227Ex.m1142S((C0227Ex) this.f2099m, z);
            return this;
        }
    }

    static {
        C0227Ex c0227Ex = new C0227Ex();
        zzc = c0227Ex;
        AbstractC0703PC.m3502u(C0227Ex.class, c0227Ex);
    }

    public static a m1133G() {
        return (a) zzc.m3516x();
    }

    public static void m1134H(C0227Ex c0227Ex, boolean z) {
        c0227Ex.zze |= 32;
        c0227Ex.zzk = z;
    }

    public static void m1136J(C0227Ex c0227Ex, boolean z) {
        c0227Ex.zze |= 16;
        c0227Ex.zzj = z;
    }

    public static C0227Ex m1137K() {
        return zzc;
    }

    public static void m1138L(C0227Ex c0227Ex, boolean z) {
        c0227Ex.zze |= 1;
        c0227Ex.zzf = z;
    }

    public static void m1139M(C0227Ex c0227Ex, boolean z) {
        c0227Ex.zze |= 64;
        c0227Ex.zzl = z;
    }

    public static void m1140O(C0227Ex c0227Ex, boolean z) {
        c0227Ex.zze |= 2;
        c0227Ex.zzg = z;
    }

    public static void m1141Q(C0227Ex c0227Ex, boolean z) {
        c0227Ex.zze |= 4;
        c0227Ex.zzh = z;
    }

    public static void m1142S(C0227Ex c0227Ex, boolean z) {
        c0227Ex.zze |= 8;
        c0227Ex.zzi = z;
    }

    public final boolean m1143N() {
        return this.zzk;
    }

    public final boolean m1144P() {
        return this.zzj;
    }

    public final boolean m1145R() {
        return this.zzf;
    }

    public final boolean m1146T() {
        return this.zzl;
    }

    public final boolean m1147U() {
        return this.zzg;
    }

    public final boolean m1148V() {
        return this.zzh;
    }

    public final boolean m1149W() {
        return this.zzi;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0227Ex();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0227Ex.class) {
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
