package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;

public class C0528Lc {

    public static C0528Lc f1711c;

    public final Context f1712a;

    public volatile String f1713b;

    public C0528Lc(Context context) {
        this.f1712a = context.getApplicationContext();
    }

    public static C0528Lc m2656a(Context context) {
        AbstractC1085Xi.m4801j(context);
        synchronized (C0528Lc.class) {
            try {
                if (f1711c == null) {
                    AbstractC0705PE.m3534d(context);
                    f1711c = new C0528Lc(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f1711c;
    }

    public static final AbstractBinderC0195EA m2657d(PackageInfo packageInfo, AbstractBinderC0195EA... abstractBinderC0195EAArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            BinderC0380IB binderC0380IB = new BinderC0380IB(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < abstractBinderC0195EAArr.length; i++) {
                if (abstractBinderC0195EAArr[i].equals(binderC0380IB)) {
                    return abstractBinderC0195EAArr[i];
                }
            }
        }
        return null;
    }

    public static final boolean m2658e(PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (!z) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            AbstractBinderC0195EA[] abstractBinderC0195EAArr = AbstractC0520LD.f1699a;
            if ((z ? m2657d(packageInfo2, abstractBinderC0195EAArr) : m2657d(packageInfo2, abstractBinderC0195EAArr[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m2659b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m2658e(packageInfo, false)) {
            return true;
        }
        if (m2658e(packageInfo, true)) {
            if (AbstractC0482Kc.m2368b(this.f1712a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean m2660c(int i) throws PackageManager.NameNotFoundException {
        C1316bJ c1316bJM5652c;
        int length;
        String[] packagesForUid = this.f1712a.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            c1316bJM5652c = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    AbstractC1085Xi.m4801j(c1316bJM5652c);
                    break;
                }
                c1316bJM5652c = m2661f(packagesForUid[i2], false, false);
                if (c1316bJM5652c.f3864a) {
                    break;
                }
                i2++;
            }
        } else {
            c1316bJM5652c = C1316bJ.m5652c("no pkgs");
        }
        c1316bJM5652c.m5656e();
        return c1316bJM5652c.f3864a;
    }

    public final C1316bJ m2661f(String str, boolean z, boolean z2) throws PackageManager.NameNotFoundException {
        C1316bJ c1316bJM5652c;
        ApplicationInfo applicationInfo;
        String str2 = "null pkg";
        if (str == null) {
            return C1316bJ.m5652c("null pkg");
        }
        if (str.equals(this.f1713b)) {
            return C1316bJ.m5651b();
        }
        if (AbstractC0705PE.m3535e()) {
            c1316bJM5652c = AbstractC0705PE.m3532b(str, AbstractC0482Kc.m2368b(this.f1712a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f1712a.getPackageManager().getPackageInfo(str, 64);
                boolean zM2368b = AbstractC0482Kc.m2368b(this.f1712a);
                if (packageInfo != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        str2 = "single cert required";
                    } else {
                        BinderC0380IB binderC0380IB = new BinderC0380IB(packageInfo.signatures[0].toByteArray());
                        String str3 = packageInfo.packageName;
                        C1316bJ c1316bJM3531a = AbstractC0705PE.m3531a(str3, binderC0380IB, zM2368b, false);
                        if (!c1316bJM3531a.f3864a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !AbstractC0705PE.m3531a(str3, binderC0380IB, false, true).f3864a) {
                            c1316bJM5652c = c1316bJM3531a;
                        } else {
                            str2 = "debuggable release cert app rejected";
                        }
                    }
                    c1316bJM5652c = C1316bJ.m5652c(str2);
                } else {
                    c1316bJM5652c = C1316bJ.m5652c(str2);
                }
            } catch (PackageManager.NameNotFoundException e) {
                return C1316bJ.m5653d("no pkg ".concat(str), e);
            }
        }
        if (c1316bJM5652c.f3864a) {
            this.f1713b = str;
        }
        return c1316bJM5652c;
    }
}
