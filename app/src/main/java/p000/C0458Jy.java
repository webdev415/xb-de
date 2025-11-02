package p000;

import java.util.List;
import p000.AbstractC0703PC;

public final class C0458Jy extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0458Jy zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private String zzf = "";
    private InterfaceC1865iD zzg = AbstractC0703PC.m3495C();

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0458Jy.zzc);
        }
    }

    static {
        C0458Jy c0458Jy = new C0458Jy();
        zzc = c0458Jy;
        AbstractC0703PC.m3502u(C0458Jy.class, c0458Jy);
    }

    public final String m2214H() {
        return this.zzf;
    }

    public final List m2215I() {
        return this.zzg;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0780Qy.f2301a[i - 1]) {
            case 1:
                return new C0458Jy();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", C0550Ly.class});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0458Jy.class) {
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
