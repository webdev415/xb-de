package p000;

import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C0456Jw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0456Jw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private String zzf = "";
    private InterfaceC1865iD zzg = AbstractC0703PC.m3495C();
    private boolean zzh;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0456Jw.zzc);
        }
    }

    static {
        C0456Jw c0456Jw = new C0456Jw();
        zzc = c0456Jw;
        AbstractC0703PC.m3502u(C0456Jw.class, c0456Jw);
    }

    public final String m2174H() {
        return this.zzf;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0364Hw.f1109a[i - 1]) {
            case 1:
                return new C0456Jw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", C0686Ow.class, "zzh"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0456Jw.class) {
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
