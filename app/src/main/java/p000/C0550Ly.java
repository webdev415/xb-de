package p000;

import java.util.List;
import p000.AbstractC0703PC;

public final class C0550Ly extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0550Ly zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf;
    private InterfaceC1865iD zzg = AbstractC0703PC.m3495C();
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private double zzk;

    public static final class a extends AbstractC0703PC.b implements InterfaceC2097nE {
        public a() {
            super(C0550Ly.zzc);
        }
    }

    public enum b implements InterfaceC1209aD {
        UNKNOWN(0),
        STRING(1),
        NUMBER(2),
        BOOLEAN(3),
        STATEMENT(4);


        public final int f1746l;

        b(int i) {
            this.f1746l = i;
        }

        public static b m2805c(int i) {
            if (i == 0) {
                return UNKNOWN;
            }
            if (i == 1) {
                return STRING;
            }
            if (i == 2) {
                return NUMBER;
            }
            if (i == 3) {
                return BOOLEAN;
            }
            if (i != 4) {
                return null;
            }
            return STATEMENT;
        }

        public static InterfaceC1116YC m2806e() {
            return C1616cz.f5266a;
        }

        @Override
        public final int mo1742a() {
            return this.f1746l;
        }

        @Override
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1746l + " name=" + name() + '>';
        }
    }

    static {
        C0550Ly c0550Ly = new C0550Ly();
        zzc = c0550Ly;
        AbstractC0703PC.m3502u(C0550Ly.class, c0550Ly);
    }

    public final double m2796G() {
        return this.zzk;
    }

    public final b m2797H() {
        b bVarM2805c = b.m2805c(this.zzf);
        return bVarM2805c == null ? b.UNKNOWN : bVarM2805c;
    }

    public final String m2798J() {
        return this.zzh;
    }

    public final String m2799K() {
        return this.zzi;
    }

    public final List m2800L() {
        return this.zzg;
    }

    public final boolean m2801M() {
        return this.zzj;
    }

    public final boolean m2802N() {
        return (this.zze & 8) != 0;
    }

    public final boolean m2803O() {
        return (this.zze & 16) != 0;
    }

    public final boolean m2804P() {
        return (this.zze & 4) != 0;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0780Qy.f2301a[i - 1]) {
            case 1:
                return new C0550Ly();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", b.m2806e(), "zzg", C0550Ly.class, "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0550Ly.class) {
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
