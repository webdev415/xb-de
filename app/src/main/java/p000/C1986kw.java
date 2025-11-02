package p000;

import java.util.List;
import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C1986kw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C1986kw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private InterfaceC1865iD zzh = AbstractC0703PC.m3495C();
    private boolean zzi;
    private C2078mw zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C1986kw.zzc);
        }

        public final int m8335t() {
            return ((C1986kw) this.f2099m).m8334j();
        }

        public final a m8336u(int i, C2032lw c2032lw) {
            m3527q();
            C1986kw.m8319H((C1986kw) this.f2099m, i, c2032lw);
            return this;
        }

        public final a m8337v(String str) {
            m3527q();
            C1986kw.m8320I((C1986kw) this.f2099m, str);
            return this;
        }

        public final C2032lw m8338w(int i) {
            return ((C1986kw) this.f2099m).m8323G(i);
        }

        public final String m8339x() {
            return ((C1986kw) this.f2099m).m8326N();
        }
    }

    static {
        C1986kw c1986kw = new C1986kw();
        zzc = c1986kw;
        AbstractC0703PC.m3502u(C1986kw.class, c1986kw);
    }

    public static void m8319H(C1986kw c1986kw, int i, C2032lw c2032lw) {
        c2032lw.getClass();
        InterfaceC1865iD interfaceC1865iD = c1986kw.zzh;
        if (!interfaceC1865iD.mo7402c()) {
            c1986kw.zzh = AbstractC0703PC.m3501t(interfaceC1865iD);
        }
        c1986kw.zzh.set(i, c2032lw);
    }

    public static void m8320I(C1986kw c1986kw, String str) {
        str.getClass();
        c1986kw.zze |= 2;
        c1986kw.zzg = str;
    }

    public static a m8321K() {
        return (a) zzc.m3516x();
    }

    public final C2032lw m8323G(int i) {
        return (C2032lw) this.zzh.get(i);
    }

    public final int m8324J() {
        return this.zzf;
    }

    public final C2078mw m8325M() {
        C2078mw c2078mw = this.zzj;
        return c2078mw == null ? C2078mw.m8643I() : c2078mw;
    }

    public final String m8326N() {
        return this.zzg;
    }

    public final List m8327O() {
        return this.zzh;
    }

    public final boolean m8328P() {
        return this.zzk;
    }

    public final boolean m8329Q() {
        return this.zzl;
    }

    public final boolean m8330R() {
        return this.zzm;
    }

    public final boolean m8331S() {
        return (this.zze & 8) != 0;
    }

    public final boolean m8332T() {
        return (this.zze & 1) != 0;
    }

    public final boolean m8333U() {
        return (this.zze & 64) != 0;
    }

    public final int m8334j() {
        return this.zzh.size();
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC1893iw.f5832a[i - 1]) {
            case 1:
                return new C1986kw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", C2032lw.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C1986kw.class) {
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
