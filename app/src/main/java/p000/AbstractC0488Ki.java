package p000;

import android.content.Context;
import android.os.Process;

/* loaded from: classes.dex */
public abstract class AbstractC0488Ki {
    public static int m2381a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String strM4610c = AbstractC1058X0.m4610c(str);
        if (strM4610c == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return ((Process.myUid() != i2 || !AbstractC0349Hh.m1589a(context.getPackageName(), str2)) ? AbstractC1058X0.m4609b(context, strM4610c, str2) : AbstractC1058X0.m4608a(context, i2, strM4610c, str2)) == 0 ? 0 : -2;
    }

    public static int m2382b(Context context, String str) {
        return m2381a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
