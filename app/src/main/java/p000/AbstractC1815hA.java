package p000;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

public abstract class AbstractC1815hA {

    public static volatile AbstractC1325bi f5722a = AbstractC1325bi.m5671a();

    public static final Object f5723b = new Object();

    public static boolean m7816a(Context context) {
        return (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0;
    }

    public static boolean m7817b(Context context, Uri uri) {
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            Log.e("PhenotypeClientHelper", authority + " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            return false;
        }
        if (!f5722a.mo5674c()) {
            synchronized (f5723b) {
                try {
                    if (f5722a.mo5674c()) {
                        return ((Boolean) f5722a.mo5673b()).booleanValue();
                    }
                    if (!"com.google.android.gms".equals(context.getPackageName())) {
                        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", Build.VERSION.SDK_INT < 29 ? 0 : 268435456);
                        if (providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                        }
                        f5722a = AbstractC1325bi.m5672d(Boolean.valueOf(z));
                    }
                    if (m7816a(context)) {
                        z = true;
                    }
                    f5722a = AbstractC1325bi.m5672d(Boolean.valueOf(z));
                } finally {
                }
            }
        }
        return ((Boolean) f5722a.mo5673b()).booleanValue();
    }
}
