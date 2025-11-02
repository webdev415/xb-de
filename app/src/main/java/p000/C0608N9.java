package p000;

import java.io.Serializable;
import p000.InterfaceC0191E6;

/* loaded from: classes.dex */
public final class C0608N9 implements InterfaceC0191E6, Serializable {

    public static final C0608N9 f1911l = new C0608N9();

    @Override
    public InterfaceC0191E6 mo852B(c cVar) {
        AbstractC0116Ce.m476e(cVar, "key");
        return this;
    }

    @Override
    public Object mo853E(Object obj, InterfaceC1920jc interfaceC1920jc) {
        AbstractC0116Ce.m476e(interfaceC1920jc, "operation");
        return obj;
    }

    @Override
    public InterfaceC0191E6 mo854I(InterfaceC0191E6 interfaceC0191E6) {
        AbstractC0116Ce.m476e(interfaceC0191E6, "context");
        return interfaceC0191E6;
    }

    @Override
    public b mo855b(c cVar) {
        AbstractC0116Ce.m476e(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
