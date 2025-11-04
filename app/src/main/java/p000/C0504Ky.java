package p000;

import java.util.List;
import p000.AbstractC0703PC;

public final class C0504Ky extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0504Ky zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private InterfaceC1865iD zzf = AbstractC0703PC.m3495C();
    private C0412Iy zzg;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0504Ky.zzc);
        }
    }

    static {
        C0504Ky c0504Ky = new C0504Ky();
        zzc = c0504Ky;
        AbstractC0703PC.m3502u(C0504Ky.class, c0504Ky);
    }

    public final C0412Iy m2570G() {
        C0412Iy c0412Iy = this.zzg;
        return c0412Iy == null ? C0412Iy.m1754H() : c0412Iy;
    }

    public final List m2571I() {
        return this.zzf;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0780Qy.f2301a[i - 1]) {
            case 1:
                return new C0504Ky();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", C0550Ly.class, "zzg"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0504Ky.class) {
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
