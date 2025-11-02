package p000;

import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C0640Nw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0640Nw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf = 14;
    private int zzg = 11;
    private int zzh = 60;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0640Nw.zzc);
        }
    }

    static {
        C0640Nw c0640Nw = new C0640Nw();
        zzc = c0640Nw;
        AbstractC0703PC.m3502u(C0640Nw.class, c0640Nw);
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0364Hw.f1109a[i - 1]) {
            case 1:
                return new C0640Nw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0640Nw.class) {
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
