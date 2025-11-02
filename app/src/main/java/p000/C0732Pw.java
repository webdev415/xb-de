package p000;

import p000.AbstractC0703PC;

public final class C0732Pw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0732Pw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0732Pw.zzc);
        }
    }

    static {
        C0732Pw c0732Pw = new C0732Pw();
        zzc = c0732Pw;
        AbstractC0703PC.m3502u(C0732Pw.class, c0732Pw);
    }

    public final String m3593H() {
        return this.zzf;
    }

    public final String m3594I() {
        return this.zzg;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0364Hw.f1109a[i - 1]) {
            case 1:
                return new C0732Pw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0732Pw.class) {
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
