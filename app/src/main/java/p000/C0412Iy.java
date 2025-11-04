package p000;

import java.util.List;
import p000.AbstractC0703PC;

public final class C0412Iy extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0412Iy zzc;
    private static volatile InterfaceC2650zE zzd;
    private InterfaceC1865iD zze = AbstractC0703PC.m3495C();

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0412Iy.zzc);
        }
    }

    static {
        C0412Iy c0412Iy = new C0412Iy();
        zzc = c0412Iy;
        AbstractC0703PC.m3502u(C0412Iy.class, c0412Iy);
    }

    public static C0412Iy m1754H() {
        return zzc;
    }

    public final List m1755I() {
        return this.zze;
    }

    public final int m1756j() {
        return this.zze.size();
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0780Qy.f2301a[i - 1]) {
            case 1:
                return new C0412Iy();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", C0458Jy.class});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0412Iy.class) {
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
