package p000;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractC0671Oh {

    public boolean f2050a;

    public CopyOnWriteArrayList f2051b = new CopyOnWriteArrayList();

    public AbstractC0671Oh(boolean z) {
        this.f2050a = z;
    }

    public void m3421a(InterfaceC1200a4 interfaceC1200a4) {
        this.f2051b.add(interfaceC1200a4);
    }

    public abstract void mo1961b();

    public final boolean m3422c() {
        return this.f2050a;
    }

    public final void m3423d() {
        Iterator it = this.f2051b.iterator();
        while (it.hasNext()) {
            ((InterfaceC1200a4) it.next()).cancel();
        }
    }

    public void m3424e(InterfaceC1200a4 interfaceC1200a4) {
        this.f2051b.remove(interfaceC1200a4);
    }

    public final void m3425f(boolean z) {
        this.f2050a = z;
    }
}
