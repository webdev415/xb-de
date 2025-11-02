package p000;

import java.util.Collections;
import java.util.List;
import p000.AbstractC0703PC;
import p000.C0595Mx;

public final class C0549Lx extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0549Lx zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private InterfaceC1865iD zzf = AbstractC0703PC.m3495C();
    private String zzg = "";
    private String zzh = "";
    private int zzi;

    public static final class a extends AbstractC0703PC.b implements InterfaceC2097nE {
        public a() {
            super(C0549Lx.zzc);
        }

        public final String m2784A() {
            return ((C0549Lx) this.f2099m).m2777P();
        }

        public final List m2785B() {
            return Collections.unmodifiableList(((C0549Lx) this.f2099m).m2779R());
        }

        public final int m2786t() {
            return ((C0549Lx) this.f2099m).m2783j();
        }

        public final a m2787u(Iterable iterable) {
            m3527q();
            C0549Lx.m2769I((C0549Lx) this.f2099m, iterable);
            return this;
        }

        public final a m2788v(String str) {
            m3527q();
            C0549Lx.m2770J((C0549Lx) this.f2099m, str);
            return this;
        }

        public final a m2789w(C0595Mx.a aVar) {
            m3527q();
            C0549Lx.m2771K((C0549Lx) this.f2099m, (C0595Mx) ((AbstractC0703PC) aVar.m3526o()));
            return this;
        }

        public final C0595Mx m2790x(int i) {
            return ((C0549Lx) this.f2099m).m2776H(0);
        }

        public final a m2791y() {
            m3527q();
            C0549Lx.m2773M((C0549Lx) this.f2099m);
            return this;
        }

        public final a m2792z(String str) {
            m3527q();
            C0549Lx.m2774N((C0549Lx) this.f2099m, str);
            return this;
        }
    }

    public enum b implements InterfaceC1209aD {
        SDK(0),
        SGTM(1);


        public final int f1739l;

        b(int i) {
            this.f1739l = i;
        }

        public static b m2793c(int i) {
            if (i == 0) {
                return SDK;
            }
            if (i != 1) {
                return null;
            }
            return SGTM;
        }

        public static InterfaceC1116YC m2794e() {
            return C2587xy.f8038a;
        }

        @Override
        public final int mo1742a() {
            return this.f1739l;
        }

        @Override
        public final String toString() {
            return "<" + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1739l + " name=" + name() + '>';
        }
    }

    static {
        C0549Lx c0549Lx = new C0549Lx();
        zzc = c0549Lx;
        AbstractC0703PC.m3502u(C0549Lx.class, c0549Lx);
    }

    public static a m2768G(C0549Lx c0549Lx) {
        return (a) zzc.m3514q(c0549Lx);
    }

    public static void m2769I(C0549Lx c0549Lx, Iterable iterable) {
        c0549Lx.m2782U();
        AbstractC1022WA.m4463f(iterable, c0549Lx.zzf);
    }

    public static void m2770J(C0549Lx c0549Lx, String str) {
        str.getClass();
        c0549Lx.zze |= 1;
        c0549Lx.zzg = str;
    }

    public static void m2771K(C0549Lx c0549Lx, C0595Mx c0595Mx) {
        c0595Mx.getClass();
        c0549Lx.m2782U();
        c0549Lx.zzf.add(c0595Mx);
    }

    public static a m2772L() {
        return (a) zzc.m3516x();
    }

    public static void m2773M(C0549Lx c0549Lx) {
        c0549Lx.zzf = AbstractC0703PC.m3495C();
    }

    public static void m2774N(C0549Lx c0549Lx, String str) {
        str.getClass();
        c0549Lx.zze |= 2;
        c0549Lx.zzh = str;
    }

    public final C0595Mx m2776H(int i) {
        return (C0595Mx) this.zzf.get(0);
    }

    public final String m2777P() {
        return this.zzg;
    }

    public final String m2778Q() {
        return this.zzh;
    }

    public final List m2779R() {
        return this.zzf;
    }

    public final boolean m2780S() {
        return (this.zze & 1) != 0;
    }

    public final boolean m2781T() {
        return (this.zze & 2) != 0;
    }

    public final void m2782U() {
        InterfaceC1865iD interfaceC1865iD = this.zzf;
        if (interfaceC1865iD.mo7402c()) {
            return;
        }
        this.zzf = AbstractC0703PC.m3501t(interfaceC1865iD);
    }

    public final int m2783j() {
        return this.zzf.size();
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0549Lx();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zze", "zzf", C0595Mx.class, "zzg", "zzh", "zzi", b.m2794e()});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0549Lx.class) {
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
