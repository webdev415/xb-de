package p000;

import p000.AbstractC0703PC;
import p000.C0411Ix;

public final class C0641Nx extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0641Nx zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf = 1;
    private InterfaceC1865iD zzg = AbstractC0703PC.m3495C();

    public static final class a extends AbstractC0703PC.b implements InterfaceC2097nE {
        public a() {
            super(C0641Nx.zzc);
        }

        public final a m3347t(C0411Ix.a aVar) {
            m3527q();
            C0641Nx.m3345H((C0641Nx) this.f2099m, (C0411Ix) ((AbstractC0703PC) aVar.m3526o()));
            return this;
        }
    }

    public enum b implements InterfaceC1209aD {
        RADS(1),
        PROVISIONING(2);


        public final int f1984l;

        b(int i) {
            this.f1984l = i;
        }

        public static b m3348c(int i) {
            if (i == 1) {
                return RADS;
            }
            if (i != 2) {
                return null;
            }
            return PROVISIONING;
        }

        public static InterfaceC1116YC m3349e() {
            return C0182Dy.f440a;
        }

        @Override
        public final int mo1742a() {
            return this.f1984l;
        }

        @Override
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1984l + " name=" + name() + '>';
        }
    }

    static {
        C0641Nx c0641Nx = new C0641Nx();
        zzc = c0641Nx;
        AbstractC0703PC.m3502u(C0641Nx.class, c0641Nx);
    }

    public static a m3344G() {
        return (a) zzc.m3516x();
    }

    public static void m3345H(C0641Nx c0641Nx, C0411Ix c0411Ix) {
        c0411Ix.getClass();
        InterfaceC1865iD interfaceC1865iD = c0641Nx.zzg;
        if (!interfaceC1865iD.mo7402c()) {
            c0641Nx.zzg = AbstractC0703PC.m3501t(interfaceC1865iD);
        }
        c0641Nx.zzg.add(c0411Ix);
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0641Nx();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zze", "zzf", b.m3349e(), "zzg", C0411Ix.class});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0641Nx.class) {
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
