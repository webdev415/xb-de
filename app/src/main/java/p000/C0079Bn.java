package p000;

public final class C0079Bn {

    public final InterfaceC0191E6 f194a;

    public final Object[] f195b;

    public final InterfaceC2484vn[] f196c;

    public int f197d;

    public C0079Bn(InterfaceC0191E6 interfaceC0191E6, int i) {
        this.f194a = interfaceC0191E6;
        this.f195b = new Object[i];
        this.f196c = new InterfaceC2484vn[i];
    }

    public final void m325a(InterfaceC2484vn interfaceC2484vn, Object obj) {
        Object[] objArr = this.f195b;
        int i = this.f197d;
        objArr[i] = obj;
        InterfaceC2484vn[] interfaceC2484vnArr = this.f196c;
        this.f197d = i + 1;
        AbstractC0116Ce.m474c(interfaceC2484vn, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        interfaceC2484vnArr[i] = interfaceC2484vn;
    }

    public final void m326b(InterfaceC0191E6 interfaceC0191E6) {
        int length = this.f196c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            InterfaceC2484vn interfaceC2484vn = this.f196c[length];
            AbstractC0116Ce.m473b(interfaceC2484vn);
            interfaceC2484vn.m10403j(interfaceC0191E6, this.f195b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }
}
