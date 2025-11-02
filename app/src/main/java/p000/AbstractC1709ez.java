package p000;

/* loaded from: classes.dex */
public abstract class AbstractC1709ez {

    public static InterfaceC1943jz f5475a;

    public static synchronized InterfaceC1943jz m7479a() {
        try {
            if (f5475a == null) {
                m7480b(new C1896iz());
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5475a;
    }

    public static synchronized void m7480b(InterfaceC1943jz interfaceC1943jz) {
        if (f5475a != null) {
            throw new IllegalStateException("init() already called");
        }
        f5475a = interfaceC1943jz;
    }
}
