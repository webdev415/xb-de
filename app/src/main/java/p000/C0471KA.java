package p000;

public final class C0471KA {

    public final boolean f1551a;

    public C0471KA(InterfaceC0747QA interfaceC0747QA) {
        AbstractC1131Yi.m4974j(interfaceC0747QA, "BuildInfo must be non-null");
        this.f1551a = !interfaceC0747QA.mo3644a();
    }

    public final boolean m2317a(String str) {
        AbstractC1131Yi.m4974j(str, "flagName must not be null");
        if (this.f1551a) {
            return ((AbstractC1172Zd) AbstractC0655OA.f2010a.get()).mo1312b(str);
        }
        return true;
    }
}
