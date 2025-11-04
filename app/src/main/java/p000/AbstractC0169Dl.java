package p000;

import java.util.Iterator;

public abstract class AbstractC0169Dl extends AbstractC0123Cl {

    public static final class a implements InterfaceC0031Al {

        public final Iterator f421a;

        public a(Iterator it) {
            this.f421a = it;
        }

        @Override
        public Iterator iterator() {
            return this.f421a;
        }
    }

    public static InterfaceC0031Al m731a(Iterator it) {
        AbstractC0116Ce.m476e(it, "<this>");
        return m732b(new a(it));
    }

    public static final InterfaceC0031Al m732b(InterfaceC0031Al interfaceC0031Al) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "<this>");
        return interfaceC0031Al instanceof C2135o6 ? interfaceC0031Al : new C2135o6(interfaceC0031Al);
    }
}
