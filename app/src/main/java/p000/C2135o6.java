package p000;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class C2135o6 implements InterfaceC0031Al {

    public final AtomicReference f6536a;

    public C2135o6(InterfaceC0031Al interfaceC0031Al) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "sequence");
        this.f6536a = new AtomicReference(interfaceC0031Al);
    }

    @Override
    public Iterator iterator() {
        InterfaceC0031Al interfaceC0031Al = (InterfaceC0031Al) this.f6536a.getAndSet(null);
        if (interfaceC0031Al != null) {
            return interfaceC0031Al.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
