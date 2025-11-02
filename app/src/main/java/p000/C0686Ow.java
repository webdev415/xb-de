package p000;

import p000.AbstractC0703PC;

public final class C0686Ow extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0686Ow zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0686Ow.zzc);
        }
    }

    static {
        C0686Ow c0686Ow = new C0686Ow();
        zzc = c0686Ow;
        AbstractC0703PC.m3502u(C0686Ow.class, c0686Ow);
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0364Hw.f1109a[i - 1]) {
            case 1:
                return new C0686Ow();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0686Ow.class) {
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
