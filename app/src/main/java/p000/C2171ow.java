package p000;

import java.util.List;
import p000.AbstractC0703PC;

public final class C2171ow extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C2171ow zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf;
    private boolean zzh;
    private String zzg = "";
    private InterfaceC1865iD zzi = AbstractC0703PC.m3495C();

    public static final class a extends AbstractC0703PC.b implements InterfaceC2097nE {
        public a() {
            super(C2171ow.zzc);
        }
    }

    public enum b implements InterfaceC1209aD {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);


        public final int f6606l;

        b(int i) {
            this.f6606l = i;
        }

        public static b m8996c(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }

        public static InterfaceC1116YC m8997e() {
            return C0272Fw.f697a;
        }

        @Override
        public final int mo1742a() {
            return this.f6606l;
        }

        @Override
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f6606l + " name=" + name() + '>';
        }
    }

    static {
        C2171ow c2171ow = new C2171ow();
        zzc = c2171ow;
        AbstractC0703PC.m3502u(C2171ow.class, c2171ow);
    }

    public static C2171ow m8987I() {
        return zzc;
    }

    public final b m8988G() {
        b bVarM8996c = b.m8996c(this.zzf);
        return bVarM8996c == null ? b.UNKNOWN_MATCH_TYPE : bVarM8996c;
    }

    public final String m8989J() {
        return this.zzg;
    }

    public final List m8990K() {
        return this.zzi;
    }

    public final boolean m8991L() {
        return this.zzh;
    }

    public final boolean m8992M() {
        return (this.zze & 4) != 0;
    }

    public final boolean m8993N() {
        return (this.zze & 2) != 0;
    }

    public final boolean m8994O() {
        return (this.zze & 1) != 0;
    }

    public final int m8995j() {
        return this.zzi.size();
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC1893iw.f5832a[i - 1]) {
            case 1:
                return new C2171ow();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", b.m8997e(), "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C2171ow.class) {
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
