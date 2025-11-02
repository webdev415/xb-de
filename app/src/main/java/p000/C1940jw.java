package p000;

import java.util.List;
import p000.AbstractC0703PC;
import p000.C1986kw;
import p000.C2124nw;

public final class C1940jw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C1940jw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private int zzf;
    private InterfaceC1865iD zzg = AbstractC0703PC.m3495C();
    private InterfaceC1865iD zzh = AbstractC0703PC.m3495C();
    private boolean zzi;
    private boolean zzj;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C1940jw.zzc);
        }

        public final int m8219t() {
            return ((C1940jw) this.f2099m).m8212J();
        }

        public final a m8220u(int i, C1986kw.a aVar) {
            m3527q();
            C1940jw.m8208H((C1940jw) this.f2099m, i, (C1986kw) ((AbstractC0703PC) aVar.m3526o()));
            return this;
        }

        public final a m8221v(int i, C2124nw.a aVar) {
            m3527q();
            C1940jw.m8209I((C1940jw) this.f2099m, i, (C2124nw) ((AbstractC0703PC) aVar.m3526o()));
            return this;
        }

        public final C1986kw m8222w(int i) {
            return ((C1940jw) this.f2099m).m8211G(i);
        }

        public final int m8223x() {
            return ((C1940jw) this.f2099m).m8214L();
        }

        public final C2124nw m8224y(int i) {
            return ((C1940jw) this.f2099m).m8213K(i);
        }
    }

    static {
        C1940jw c1940jw = new C1940jw();
        zzc = c1940jw;
        AbstractC0703PC.m3502u(C1940jw.class, c1940jw);
    }

    public static void m8208H(C1940jw c1940jw, int i, C1986kw c1986kw) {
        c1986kw.getClass();
        InterfaceC1865iD interfaceC1865iD = c1940jw.zzh;
        if (!interfaceC1865iD.mo7402c()) {
            c1940jw.zzh = AbstractC0703PC.m3501t(interfaceC1865iD);
        }
        c1940jw.zzh.set(i, c1986kw);
    }

    public static void m8209I(C1940jw c1940jw, int i, C2124nw c2124nw) {
        c2124nw.getClass();
        InterfaceC1865iD interfaceC1865iD = c1940jw.zzg;
        if (!interfaceC1865iD.mo7402c()) {
            c1940jw.zzg = AbstractC0703PC.m3501t(interfaceC1865iD);
        }
        c1940jw.zzg.set(i, c2124nw);
    }

    public final C1986kw m8211G(int i) {
        return (C1986kw) this.zzh.get(i);
    }

    public final int m8212J() {
        return this.zzh.size();
    }

    public final C2124nw m8213K(int i) {
        return (C2124nw) this.zzg.get(i);
    }

    public final int m8214L() {
        return this.zzg.size();
    }

    public final List m8215N() {
        return this.zzh;
    }

    public final List m8216O() {
        return this.zzg;
    }

    public final boolean m8217P() {
        return (this.zze & 1) != 0;
    }

    public final int m8218j() {
        return this.zzf;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC1893iw.f5832a[i - 1]) {
            case 1:
                return new C1940jw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", C2124nw.class, "zzh", C1986kw.class, "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C1940jw.class) {
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
