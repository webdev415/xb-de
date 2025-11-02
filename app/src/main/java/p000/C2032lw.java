package p000;

import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C2032lw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C2032lw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private C2171ow zzf;
    private C2078mw zzg;
    private boolean zzh;
    private String zzi = "";

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C2032lw.zzc);
        }

        public final a m8426t(String str) {
            m3527q();
            C2032lw.m8416H((C2032lw) this.f2099m, str);
            return this;
        }
    }

    static {
        C2032lw c2032lw = new C2032lw();
        zzc = c2032lw;
        AbstractC0703PC.m3502u(C2032lw.class, c2032lw);
    }

    public static void m8416H(C2032lw c2032lw, String str) {
        str.getClass();
        c2032lw.zze |= 8;
        c2032lw.zzi = str;
    }

    public static C2032lw m8417I() {
        return zzc;
    }

    public final C2078mw m8418J() {
        C2078mw c2078mw = this.zzg;
        return c2078mw == null ? C2078mw.m8643I() : c2078mw;
    }

    public final C2171ow m8419K() {
        C2171ow c2171ow = this.zzf;
        return c2171ow == null ? C2171ow.m8987I() : c2171ow;
    }

    public final String m8420L() {
        return this.zzi;
    }

    public final boolean m8421M() {
        return this.zzh;
    }

    public final boolean m8422N() {
        return (this.zze & 4) != 0;
    }

    public final boolean m8423O() {
        return (this.zze & 2) != 0;
    }

    public final boolean m8424P() {
        return (this.zze & 8) != 0;
    }

    public final boolean m8425Q() {
        return (this.zze & 1) != 0;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC1893iw.f5832a[i - 1]) {
            case 1:
                return new C2032lw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C2032lw.class) {
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
