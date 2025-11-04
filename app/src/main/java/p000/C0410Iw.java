package p000;

import java.util.List;
import p000.AbstractC0703PC;

public final class C0410Iw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0410Iw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private boolean zzi;
    private InterfaceC1865iD zzf = AbstractC0703PC.m3495C();
    private InterfaceC1865iD zzg = AbstractC0703PC.m3495C();
    private InterfaceC1865iD zzh = AbstractC0703PC.m3495C();
    private InterfaceC1865iD zzj = AbstractC0703PC.m3495C();

    public static final class a extends AbstractC0703PC.b implements InterfaceC2097nE {
        public a() {
            super(C0410Iw.zzc);
        }
    }

    public static final class b extends AbstractC0703PC implements InterfaceC2097nE {
        private static final b zzc;
        private static volatile InterfaceC2650zE zzd;
        private int zze;
        private int zzf;
        private int zzg;

        public static final class a extends b implements InterfaceC2097nE {
            public a() {
                super(b.zzc);
            }
        }

        static {
            b bVar = new b();
            zzc = bVar;
            AbstractC0703PC.m3502u(b.class, bVar);
        }

        public final d m1735H() {
            d dVarM1740c = d.m1740c(this.zzg);
            return dVarM1740c == null ? d.CONSENT_STATUS_UNSPECIFIED : dVarM1740c;
        }

        public final e m1736I() {
            e eVarM1743c = e.m1743c(this.zzf);
            return eVarM1743c == null ? e.CONSENT_TYPE_UNSPECIFIED : eVarM1743c;
        }

        @Override
        public final Object mo567m(int i, Object obj, Object obj2) {
            switch (AbstractC0364Hw.f1109a[i - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a();
                case 3:
                    return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", e.m1744e(), "zzg", d.m1741e()});
                case 4:
                    return zzc;
                case 5:
                    InterfaceC2650zE aVar = zzd;
                    if (aVar == null) {
                        synchronized (b.class) {
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

    public static final class c extends AbstractC0703PC implements InterfaceC2097nE {
        private static final c zzc;
        private static volatile InterfaceC2650zE zzd;
        private int zze;
        private int zzf;
        private int zzg;

        public static final class a extends b implements InterfaceC2097nE {
            public a() {
                super(c.zzc);
            }
        }

        static {
            c cVar = new c();
            zzc = cVar;
            AbstractC0703PC.m3502u(c.class, cVar);
        }

        public final e m1738H() {
            e eVarM1743c = e.m1743c(this.zzg);
            return eVarM1743c == null ? e.CONSENT_TYPE_UNSPECIFIED : eVarM1743c;
        }

        public final e m1739I() {
            e eVarM1743c = e.m1743c(this.zzf);
            return eVarM1743c == null ? e.CONSENT_TYPE_UNSPECIFIED : eVarM1743c;
        }

        @Override
        public final Object mo567m(int i, Object obj, Object obj2) {
            switch (AbstractC0364Hw.f1109a[i - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a();
                case 3:
                    return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", e.m1744e(), "zzg", e.m1744e()});
                case 4:
                    return zzc;
                case 5:
                    InterfaceC2650zE aVar = zzd;
                    if (aVar == null) {
                        synchronized (c.class) {
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

    public enum d implements InterfaceC1209aD {
        CONSENT_STATUS_UNSPECIFIED(0),
        GRANTED(1),
        DENIED(2);


        public final int f1230l;

        d(int i) {
            this.f1230l = i;
        }

        public static d m1740c(int i) {
            if (i == 0) {
                return CONSENT_STATUS_UNSPECIFIED;
            }
            if (i == 1) {
                return GRANTED;
            }
            if (i != 2) {
                return null;
            }
            return DENIED;
        }

        public static InterfaceC1116YC m1741e() {
            return C1754fx.f5549a;
        }

        @Override
        public final int mo1742a() {
            return this.f1230l;
        }

        @Override
        public final String toString() {
            return "<" + d.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1230l + " name=" + name() + '>';
        }
    }

    public enum e implements InterfaceC1209aD {
        CONSENT_TYPE_UNSPECIFIED(0),
        AD_STORAGE(1),
        ANALYTICS_STORAGE(2),
        AD_USER_DATA(3),
        AD_PERSONALIZATION(4);


        public final int f1237l;

        e(int i) {
            this.f1237l = i;
        }

        public static e m1743c(int i) {
            if (i == 0) {
                return CONSENT_TYPE_UNSPECIFIED;
            }
            if (i == 1) {
                return AD_STORAGE;
            }
            if (i == 2) {
                return ANALYTICS_STORAGE;
            }
            if (i == 3) {
                return AD_USER_DATA;
            }
            if (i != 4) {
                return null;
            }
            return AD_PERSONALIZATION;
        }

        public static InterfaceC1116YC m1744e() {
            return C1848hx.f5775a;
        }

        @Override
        public final int mo1742a() {
            return this.f1237l;
        }

        @Override
        public final String toString() {
            return "<" + e.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1237l + " name=" + name() + '>';
        }
    }

    public static final class f extends AbstractC0703PC implements InterfaceC2097nE {
        private static final f zzc;
        private static volatile InterfaceC2650zE zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        public static final class a extends b implements InterfaceC2097nE {
            public a() {
                super(f.zzc);
            }
        }

        static {
            f fVar = new f();
            zzc = fVar;
            AbstractC0703PC.m3502u(f.class, fVar);
        }

        public final String m1746H() {
            return this.zzf;
        }

        @Override
        public final Object mo567m(int i, Object obj, Object obj2) {
            switch (AbstractC0364Hw.f1109a[i - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a();
                case 3:
                    return AbstractC0703PC.m3498o(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    InterfaceC2650zE aVar = zzd;
                    if (aVar == null) {
                        synchronized (f.class) {
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

    static {
        C0410Iw c0410Iw = new C0410Iw();
        zzc = c0410Iw;
        AbstractC0703PC.m3502u(C0410Iw.class, c0410Iw);
    }

    public static C0410Iw m1727H() {
        return zzc;
    }

    public final List m1728I() {
        return this.zzh;
    }

    public final List m1729J() {
        return this.zzf;
    }

    public final List m1730K() {
        return this.zzg;
    }

    public final List m1731L() {
        return this.zzj;
    }

    public final boolean m1732M() {
        return this.zzi;
    }

    public final boolean m1733N() {
        return (this.zze & 1) != 0;
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0364Hw.f1109a[i - 1]) {
            case 1:
                return new C0410Iw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", b.class, "zzg", c.class, "zzh", f.class, "zzi", "zzj", b.class});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0410Iw.class) {
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
