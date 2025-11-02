package p000;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class AbstractC0705PE {

    public static volatile InterfaceC2487vq f2113e;

    public static Context f2115g;

    public static final AbstractBinderC0473KC f2109a = new BinderC0547Lv(AbstractBinderC0195EA.m883Q("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    public static final AbstractBinderC0473KC f2110b = new BinderC1340bx(AbstractBinderC0195EA.m883Q("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    public static final AbstractBinderC0473KC f2111c = new BinderC2495vy(AbstractBinderC0195EA.m883Q("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    public static final AbstractBinderC0473KC f2112d = new BinderC0137Cz(AbstractBinderC0195EA.m883Q("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    public static final Object f2114f = new Object();

    public static C1316bJ m3531a(String str, AbstractBinderC0195EA abstractBinderC0195EA, boolean z, boolean z2) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return m3536f(str, abstractBinderC0195EA, z, z2);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static C1316bJ m3532b(String str, boolean z, boolean z2, boolean z3) {
        return m3537g(str, z, false, false, true);
    }

    public static String m3533c(boolean z, String str, AbstractBinderC0195EA abstractBinderC0195EA) throws NoSuchAlgorithmException {
        String str2 = (z || !m3536f(str, abstractBinderC0195EA, true, false).f3864a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestM4083b = AbstractC0874T0.m4083b("SHA-256");
        AbstractC1085Xi.m4801j(messageDigestM4083b);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, AbstractC2013ld.m8394a(messageDigestM4083b.digest(abstractBinderC0195EA.mo884R())), Boolean.valueOf(z), "12451000.false");
    }

    public static synchronized void m3534d(Context context) {
        if (f2115g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f2115g = context.getApplicationContext();
        }
    }

    public static boolean m3535e() {
        boolean zMo9081e;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                m3538h();
                zMo9081e = f2113e.mo9081e();
            } catch (RemoteException | DynamiteModule.C1378a e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                zMo9081e = false;
            }
            return zMo9081e;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static C1316bJ m3536f(final String str, final AbstractBinderC0195EA abstractBinderC0195EA, final boolean z, boolean z2) {
        try {
            m3538h();
            AbstractC1085Xi.m4801j(f2115g);
            try {
                return f2113e.mo9083o(new C0111CI(str, abstractBinderC0195EA, z, z2), BinderC0211Eh.m1041R(f2115g.getPackageManager())) ? C1316bJ.m5651b() : new C0892TI(new Callable() {
                    @Override
                    public final Object call() {
                        return AbstractC0705PE.m3533c(z, str, abstractBinderC0195EA);
                    }
                }, null);
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return C1316bJ.m5653d("module call", e);
            }
        } catch (DynamiteModule.C1378a e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            return C1316bJ.m5653d("module init: ".concat(String.valueOf(e2.getMessage())), e2);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [Od, android.os.IBinder] */
    public static C1316bJ m3537g(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        String strConcat;
        C1316bJ c1316bJM5653d;
        C0797RF c0797rf;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            AbstractC1085Xi.m4801j(f2115g);
            try {
                m3538h();
                c0797rf = new C0797RF(str, z, false, BinderC0211Eh.m1041R(f2115g), false, true);
            } catch (DynamiteModule.C1378a e) {
                e = e;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                strConcat = "module init: ".concat(String.valueOf(e.getMessage()));
            }
            try {
                C2377tH c2377tHMo9084u = z4 ? f2113e.mo9084u(c0797rf) : f2113e.mo9082g(c0797rf);
                if (c2377tHMo9084u.m9690f()) {
                    c1316bJM5653d = C1316bJ.m5654f(c2377tHMo9084u.m9691g());
                } else {
                    String strM9689d = c2377tHMo9084u.m9689d();
                    PackageManager.NameNotFoundException nameNotFoundException = c2377tHMo9084u.m9692h() == 4 ? new PackageManager.NameNotFoundException() : null;
                    if (strM9689d == null) {
                        strM9689d = "error checking package certificate";
                    }
                    c1316bJM5653d = C1316bJ.m5655g(c2377tHMo9084u.m9691g(), c2377tHMo9084u.m9692h(), strM9689d, nameNotFoundException);
                }
            } catch (RemoteException e2) {
                e = e2;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                strConcat = "module call";
                c1316bJM5653d = C1316bJ.m5653d(strConcat, e);
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return c1316bJM5653d;
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return c1316bJM5653d;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public static void m3538h() {
        if (f2113e != null) {
            return;
        }
        AbstractC1085Xi.m4801j(f2115g);
        synchronized (f2114f) {
            try {
                if (f2113e == null) {
                    f2113e = AbstractBinderC2349sq.m9597P(DynamiteModule.m5949d(f2115g, DynamiteModule.f4006f, "com.google.android.gms.googlecertificates").m5957c("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
