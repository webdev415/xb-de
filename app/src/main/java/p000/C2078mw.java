package p000;

import p000.AbstractC0703PC;

public final class C2078mw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C2078mw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    public static final class a extends AbstractC0703PC.b implements InterfaceC2097nE {
        public a() {
            super(C2078mw.zzc);
        }
    }

    public enum b implements InterfaceC1209aD {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);


        public final int f6275l;

        b(int i) {
            this.f6275l = i;
        }

        public static b m8654c(int i) {
            if (i == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i == 1) {
                return LESS_THAN;
            }
            if (i == 2) {
                return GREATER_THAN;
            }
            if (i == 3) {
                return EQUAL;
            }
            if (i != 4) {
                return null;
            }
            return BETWEEN;
        }

        public static InterfaceC1116YC m8655e() {
            return C2677zw.f8287a;
        }

        @Override
        public final int mo1742a() {
            return this.f6275l;
        }

        @Override
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f6275l + " name=" + name() + '>';
        }
    }

    static {
        C2078mw c2078mw = new C2078mw();
        zzc = c2078mw;
        AbstractC0703PC.m3502u(C2078mw.class, c2078mw);
    }

    public static C2078mw m8643I() {
        return zzc;
    }

    public final b m8644G() {
        b bVarM8654c = b.m8654c(this.zzf);
        return bVarM8654c == null ? b.UNKNOWN_COMPARISON_TYPE : bVarM8654c;
    }

    public final String m8645J() {
        return this.zzh;
    }

    public final String m8646K() {
        return this.zzj;
    }

    public final String m8647L() {
        return this.zzi;
    }

    public final boolean m8648M() {
        return this.zzg;
    }

    public final boolean m8649N() {
        return (this.zze & 1) != 0;
    }

    public final boolean m8650O() {
        return (this.zze & 4) != 0;
    }

    public final boolean m8651P() {
        return (this.zze & 2) != 0;
    }

    public final boolean m8652Q() {
        return (this.zze & 16) != 0;
    }

    public final boolean m8653R() {
        return (this.zze & 8) != 0;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC1893iw.f5832a[i - 1]) {
            case 1:
                return new C2078mw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", b.m8655e(), "zzg", "zzh", "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C2078mw.class) {
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
