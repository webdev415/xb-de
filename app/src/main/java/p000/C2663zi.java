package p000;

/* loaded from: classes.dex */
public final class C2663zi implements InterfaceC0373I4 {

    public final Class f8264a;

    public final String f8265b;

    public C2663zi(Class cls, String str) {
        AbstractC0116Ce.m476e(cls, "jClass");
        AbstractC0116Ce.m476e(str, "moduleName");
        this.f8264a = cls;
        this.f8265b = str;
    }

    @Override
    public Class mo1674a() {
        return this.f8264a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2663zi) && AbstractC0116Ce.m472a(mo1674a(), ((C2663zi) obj).mo1674a());
    }

    public int hashCode() {
        return mo1674a().hashCode();
    }

    public String toString() {
        return mo1674a().toString() + " (Kotlin reflection is not available)";
    }
}
