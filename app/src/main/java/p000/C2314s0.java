package p000;

import android.os.Build;
import android.os.ext.SdkExtensions;

public final class C2314s0 {

    public static final C2314s0 f6991a = new C2314s0();

    public static final class a {

        public static final a f6992a = new a();

        public final int m9460a() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    public final int m9459a() {
        if (Build.VERSION.SDK_INT >= 30) {
            return a.f6992a.m9460a();
        }
        return 0;
    }
}
