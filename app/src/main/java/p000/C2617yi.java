package p000;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;

/* loaded from: classes.dex */
public class C2617yi {

    public final Context f8110a;

    public C2617yi(Context context) {
        this.f8110a = context;
    }

    public int m10888a(String str) {
        return this.f8110a.checkCallingOrSelfPermission(str);
    }

    public ApplicationInfo m10889b(String str, int i) {
        return this.f8110a.getPackageManager().getApplicationInfo(str, i);
    }

    public PackageInfo m10890c(String str, int i) {
        return this.f8110a.getPackageManager().getPackageInfo(str, i);
    }

    public boolean m10891d() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return AbstractC2475ve.m10353a(this.f8110a);
        }
        if (!AbstractC0993Vi.m4418g() || (nameForUid = this.f8110a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f8110a.getPackageManager().isInstantApp(nameForUid);
    }

    public final boolean m10892e(int i, String str) {
        if (AbstractC0993Vi.m4414c()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.f8110a.getSystemService("appops");
                if (appOpsManager == null) {
                    throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                }
                appOpsManager.checkPackage(i, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f8110a.getPackageManager().getPackagesForUid(i);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
