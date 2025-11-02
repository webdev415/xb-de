package p000;

/* loaded from: classes.dex */
public final class C2465vD implements InterfaceC2557xD {
    public static InterfaceC1865iD m10328c(Object obj, long j) {
        return (InterfaceC1865iD) AbstractC0476KF.m2320B(obj, j);
    }

    @Override
    public final void mo10329a(Object obj, Object obj2, long j) {
        InterfaceC1865iD interfaceC1865iDM10328c = m10328c(obj, j);
        InterfaceC1865iD interfaceC1865iDM10328c2 = m10328c(obj2, j);
        int size = interfaceC1865iDM10328c.size();
        int size2 = interfaceC1865iDM10328c2.size();
        if (size > 0 && size2 > 0) {
            if (!interfaceC1865iDM10328c.mo7402c()) {
                interfaceC1865iDM10328c = interfaceC1865iDM10328c.mo1538e(size2 + size);
            }
            interfaceC1865iDM10328c.addAll(interfaceC1865iDM10328c2);
        }
        if (size > 0) {
            interfaceC1865iDM10328c2 = interfaceC1865iDM10328c;
        }
        AbstractC0476KF.m2334j(obj, j, interfaceC1865iDM10328c2);
    }

    @Override
    public final void mo10330b(Object obj, long j) {
        m10328c(obj, j).mo7401b();
    }
}
