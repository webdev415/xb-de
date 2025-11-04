package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class C1905j7 {

    public final Context f5903a;

    public final SharedPreferences f5904b;

    public final InterfaceC2526wj f5905c;

    public boolean f5906d;

    public C1905j7(Context context, String str, InterfaceC2526wj interfaceC2526wj) {
        Context contextM8105a = m8105a(context);
        this.f5903a = contextM8105a;
        this.f5904b = contextM8105a.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f5905c = interfaceC2526wj;
        this.f5906d = m8107c();
    }

    public static Context m8105a(Context context) {
        return AbstractC2320s6.m9506b(context);
    }

    public synchronized boolean m8106b() {
        return this.f5906d;
    }

    public final boolean m8107c() {
        return this.f5904b.contains("firebase_data_collection_default_enabled") ? this.f5904b.getBoolean("firebase_data_collection_default_enabled", true) : m8108d();
    }

    public final boolean m8108d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f5903a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f5903a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
