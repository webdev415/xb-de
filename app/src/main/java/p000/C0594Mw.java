package p000;

import p000.AbstractC0703PC;

/* loaded from: classes.dex */
public final class C0594Mw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0594Mw zzc;
    private static volatile InterfaceC2650zE zzd;
    private InterfaceC1865iD zze = AbstractC0703PC.m3495C();

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0594Mw.zzc);
        }
    }

    static {
        C0594Mw c0594Mw = new C0594Mw();
        zzc = c0594Mw;
        AbstractC0703PC.m3502u(C0594Mw.class, c0594Mw);
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0364Hw.f1109a[i - 1]) {
            case 1:
                return new C0594Mw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0594Mw.class) {
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
