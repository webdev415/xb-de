package p000;

import java.util.Collections;
import java.util.List;
import p000.AbstractC0703PC;
import p000.C0457Jx;

public final class C0365Hx extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0365Hx zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private InterfaceC1865iD zzf = AbstractC0703PC.m3495C();
    private String zzg = "";
    private long zzh;
    private long zzi;
    private int zzj;

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0365Hx.zzc);
        }

        public final a m1644A(C0457Jx.a aVar) {
            m3527q();
            C0365Hx.m1629N((C0365Hx) this.f2099m, (C0457Jx) ((AbstractC0703PC) aVar.m3526o()));
            return this;
        }

        public final a m1645B(C0457Jx c0457Jx) {
            m3527q();
            C0365Hx.m1629N((C0365Hx) this.f2099m, c0457Jx);
            return this;
        }

        public final long m1646C() {
            return ((C0365Hx) this.f2099m).m1635Q();
        }

        public final a m1647D(long j) {
            m3527q();
            C0365Hx.m1630P((C0365Hx) this.f2099m, j);
            return this;
        }

        public final C0457Jx m1648E(int i) {
            return ((C0365Hx) this.f2099m).m1633G(i);
        }

        public final long m1649F() {
            return ((C0365Hx) this.f2099m).m1636R();
        }

        public final a m1650G() {
            m3527q();
            C0365Hx.m1623H((C0365Hx) this.f2099m);
            return this;
        }

        public final String m1651H() {
            return ((C0365Hx) this.f2099m).m1637U();
        }

        public final List m1652I() {
            return Collections.unmodifiableList(((C0365Hx) this.f2099m).m1638V());
        }

        public final boolean m1653J() {
            return ((C0365Hx) this.f2099m).m1641Y();
        }

        public final int m1654t() {
            return ((C0365Hx) this.f2099m).m1634O();
        }

        public final a m1655u(int i) {
            m3527q();
            C0365Hx.m1624I((C0365Hx) this.f2099m, i);
            return this;
        }

        public final a m1656v(int i, C0457Jx.a aVar) {
            m3527q();
            C0365Hx.m1625J((C0365Hx) this.f2099m, i, (C0457Jx) ((AbstractC0703PC) aVar.m3526o()));
            return this;
        }

        public final a m1657w(int i, C0457Jx c0457Jx) {
            m3527q();
            C0365Hx.m1625J((C0365Hx) this.f2099m, i, c0457Jx);
            return this;
        }

        public final a m1658x(long j) {
            m3527q();
            C0365Hx.m1626K((C0365Hx) this.f2099m, j);
            return this;
        }

        public final a m1659y(Iterable iterable) {
            m3527q();
            C0365Hx.m1627L((C0365Hx) this.f2099m, iterable);
            return this;
        }

        public final a m1660z(String str) {
            m3527q();
            C0365Hx.m1628M((C0365Hx) this.f2099m, str);
            return this;
        }
    }

    static {
        C0365Hx c0365Hx = new C0365Hx();
        zzc = c0365Hx;
        AbstractC0703PC.m3502u(C0365Hx.class, c0365Hx);
    }

    public static void m1623H(C0365Hx c0365Hx) {
        c0365Hx.zzf = AbstractC0703PC.m3495C();
    }

    public static void m1624I(C0365Hx c0365Hx, int i) {
        c0365Hx.m1642Z();
        c0365Hx.zzf.remove(i);
    }

    public static void m1625J(C0365Hx c0365Hx, int i, C0457Jx c0457Jx) {
        c0457Jx.getClass();
        c0365Hx.m1642Z();
        c0365Hx.zzf.set(i, c0457Jx);
    }

    public static void m1626K(C0365Hx c0365Hx, long j) {
        c0365Hx.zze |= 4;
        c0365Hx.zzi = j;
    }

    public static void m1627L(C0365Hx c0365Hx, Iterable iterable) {
        c0365Hx.m1642Z();
        AbstractC1022WA.m4463f(iterable, c0365Hx.zzf);
    }

    public static void m1628M(C0365Hx c0365Hx, String str) {
        str.getClass();
        c0365Hx.zze |= 1;
        c0365Hx.zzg = str;
    }

    public static void m1629N(C0365Hx c0365Hx, C0457Jx c0457Jx) {
        c0457Jx.getClass();
        c0365Hx.m1642Z();
        c0365Hx.zzf.add(c0457Jx);
    }

    public static void m1630P(C0365Hx c0365Hx, long j) {
        c0365Hx.zze |= 2;
        c0365Hx.zzh = j;
    }

    public static a m1631S() {
        return (a) zzc.m3516x();
    }

    public final C0457Jx m1633G(int i) {
        return (C0457Jx) this.zzf.get(i);
    }

    public final int m1634O() {
        return this.zzf.size();
    }

    public final long m1635Q() {
        return this.zzi;
    }

    public final long m1636R() {
        return this.zzh;
    }

    public final String m1637U() {
        return this.zzg;
    }

    public final List m1638V() {
        return this.zzf;
    }

    public final boolean m1639W() {
        return (this.zze & 8) != 0;
    }

    public final boolean m1640X() {
        return (this.zze & 4) != 0;
    }

    public final boolean m1641Y() {
        return (this.zze & 2) != 0;
    }

    public final void m1642Z() {
        InterfaceC1865iD interfaceC1865iD = this.zzf;
        if (interfaceC1865iD.mo7402c()) {
            return;
        }
        this.zzf = AbstractC0703PC.m3501t(interfaceC1865iD);
    }

    public final int m1643j() {
        return this.zzj;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0089Bx.f224a[i - 1]) {
            case 1:
                return new C0365Hx();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", C0457Jx.class, "zzg", "zzh", "zzi", "zzj"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0365Hx.class) {
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
