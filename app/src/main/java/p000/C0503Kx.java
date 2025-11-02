package p000;

import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C0503Kx extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0503Kx zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private C0181Dx zzh;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0503Kx.zzc);
        }
    }

    static {
        C0503Kx c0503Kx = new C0503Kx();
        zzc = c0503Kx;
        AbstractC0703PC.m3502u(C0503Kx.class, c0503Kx);
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0503Kx();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0503Kx.class) {
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
