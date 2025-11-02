package p000;

import dalvik.system.PathClassLoader;

/* loaded from: classes.dex */
public final class C0084Bs extends PathClassLoader {
    public C0084Bs(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    @Override
    public final Class loadClass(String str, boolean z) {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.loadClass(str, z);
    }
}
