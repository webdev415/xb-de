package p000;

import java.util.Collections;
import java.util.List;
import p000.AbstractC0703PC;
import p000.C0502Kw;

/* loaded from: classes.dex */
public final class C0548Lw extends AbstractC0703PC implements InterfaceC2097nE {
    private static final C0548Lw zzc;
    private static volatile InterfaceC2650zE zzd;
    private int zze;
    private long zzf;
    private int zzh;
    private boolean zzm;
    private C0410Iw zzr;
    private C0640Nw zzs;
    private C0778Qw zzt;
    private C0686Ow zzu;
    private C0594Mw zzv;
    private String zzg = "";
    private InterfaceC1865iD zzi = AbstractC0703PC.m3495C();
    private InterfaceC1865iD zzj = AbstractC0703PC.m3495C();
    private InterfaceC1865iD zzk = AbstractC0703PC.m3495C();
    private String zzl = "";
    private InterfaceC1865iD zzn = AbstractC0703PC.m3495C();
    private InterfaceC1865iD zzo = AbstractC0703PC.m3495C();
    private String zzp = "";
    private String zzq = "";

    public static final class a extends b implements InterfaceC2097nE {
        public a() {
            super(C0548Lw.zzc);
        }

        public final int m2761t() {
            return ((C0548Lw) this.f2099m).m2745J();
        }

        public final C0502Kw m2762u(int i) {
            return ((C0548Lw) this.f2099m).m2744G(i);
        }

        public final a m2763v(int i, C0502Kw.a aVar) {
            m3527q();
            C0548Lw.m2740I((C0548Lw) this.f2099m, i, (C0502Kw) ((AbstractC0703PC) aVar.m3526o()));
            return this;
        }

        public final a m2764w() {
            m3527q();
            C0548Lw.m2739H((C0548Lw) this.f2099m);
            return this;
        }

        public final String m2765x() {
            return ((C0548Lw) this.f2099m).m2750R();
        }

        public final List m2766y() {
            return Collections.unmodifiableList(((C0548Lw) this.f2099m).m2751S());
        }

        public final List m2767z() {
            return Collections.unmodifiableList(((C0548Lw) this.f2099m).m2752T());
        }
    }

    static {
        C0548Lw c0548Lw = new C0548Lw();
        zzc = c0548Lw;
        AbstractC0703PC.m3502u(C0548Lw.class, c0548Lw);
    }

    public static void m2739H(C0548Lw c0548Lw) {
        c0548Lw.zzk = AbstractC0703PC.m3495C();
    }

    public static void m2740I(C0548Lw c0548Lw, int i, C0502Kw c0502Kw) {
        c0502Kw.getClass();
        InterfaceC1865iD interfaceC1865iD = c0548Lw.zzj;
        if (!interfaceC1865iD.mo7402c()) {
            c0548Lw.zzj = AbstractC0703PC.m3501t(interfaceC1865iD);
        }
        c0548Lw.zzj.set(i, c0502Kw);
    }

    public static a m2741M() {
        return (a) zzc.m3516x();
    }

    public static C0548Lw m2743O() {
        return zzc;
    }

    public final C0502Kw m2744G(int i) {
        return (C0502Kw) this.zzj.get(i);
    }

    public final int m2745J() {
        return this.zzj.size();
    }

    public final long m2746K() {
        return this.zzf;
    }

    public final C0410Iw m2747L() {
        C0410Iw c0410Iw = this.zzr;
        return c0410Iw == null ? C0410Iw.m1727H() : c0410Iw;
    }

    public final C0778Qw m2748P() {
        C0778Qw c0778Qw = this.zzt;
        return c0778Qw == null ? C0778Qw.m3713H() : c0778Qw;
    }

    public final String m2749Q() {
        return this.zzg;
    }

    public final String m2750R() {
        return this.zzp;
    }

    public final List m2751S() {
        return this.zzk;
    }

    public final List m2752T() {
        return this.zzo;
    }

    public final List m2753U() {
        return this.zzn;
    }

    public final List m2754V() {
        return this.zzi;
    }

    public final boolean m2755W() {
        return this.zzm;
    }

    public final boolean m2756X() {
        return (this.zze & 128) != 0;
    }

    public final boolean m2757Y() {
        return (this.zze & 2) != 0;
    }

    public final boolean m2758Z() {
        return (this.zze & 512) != 0;
    }

    public final boolean m2759a0() {
        return (this.zze & 1) != 0;
    }

    public final int m2760j() {
        return this.zzn.size();
    }

    @Override
    public final Object mo567m(int i, Object obj, Object obj2) {
        switch (AbstractC0364Hw.f1109a[i - 1]) {
            case 1:
                return new C0548Lw();
            case 2:
                return new a();
            case 3:
                return AbstractC0703PC.m3498o(zzc, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", C0732Pw.class, "zzj", C0502Kw.class, "zzk", C1940jw.class, "zzl", "zzm", "zzn", C0504Ky.class, "zzo", C0456Jw.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv"});
            case 4:
                return zzc;
            case 5:
                InterfaceC2650zE aVar = zzd;
                if (aVar == null) {
                    synchronized (C0548Lw.class) {
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
