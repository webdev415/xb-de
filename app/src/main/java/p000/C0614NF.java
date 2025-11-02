package p000;

/* loaded from: classes.dex */
public final class C0614NF extends AbstractC0430JF {
    public static void m3311m(Object obj, C0338HF c0338hf) {
        ((AbstractC0703PC) obj).zzb = c0338hf;
    }

    @Override
    public final int mo1874a(Object obj) {
        return ((C0338HF) obj).m1545a();
    }

    @Override
    public final Object mo1875b(Object obj, Object obj2) {
        C0338HF c0338hf = (C0338HF) obj;
        C0338HF c0338hf2 = (C0338HF) obj2;
        return C0338HF.m1543k().equals(c0338hf2) ? c0338hf : C0338HF.m1543k().equals(c0338hf) ? C0338HF.m1541c(c0338hf, c0338hf2) : c0338hf.m1546b(c0338hf2);
    }

    @Override
    public final void mo1876c(Object obj, int i, AbstractC2233qB abstractC2233qB) {
        ((C0338HF) obj).m1548e((i << 3) | 2, abstractC2233qB);
    }

    @Override
    public final void mo1877d(Object obj, InterfaceC0017AG interfaceC0017AG) {
        ((C0338HF) obj).m1550h(interfaceC0017AG);
    }

    @Override
    public final int mo1878e(Object obj) {
        return ((C0338HF) obj).m1551i();
    }

    @Override
    public final void mo1879f(Object obj, int i, long j) {
        ((C0338HF) obj).m1548e(i << 3, Long.valueOf(j));
    }

    @Override
    public final void mo1880g(Object obj, Object obj2) {
        m3311m(obj, (C0338HF) obj2);
    }

    @Override
    public final void mo1881h(Object obj, InterfaceC0017AG interfaceC0017AG) {
        ((C0338HF) obj).m1552j(interfaceC0017AG);
    }

    @Override
    public final Object mo1882i(Object obj) {
        C0338HF c0338hf = ((AbstractC0703PC) obj).zzb;
        if (c0338hf != C0338HF.m1543k()) {
            return c0338hf;
        }
        C0338HF c0338hfM1544l = C0338HF.m1544l();
        m3311m(obj, c0338hfM1544l);
        return c0338hfM1544l;
    }

    @Override
    public final void mo1883j(Object obj, Object obj2) {
        m3311m(obj, (C0338HF) obj2);
    }

    @Override
    public final Object mo1884k(Object obj) {
        return ((AbstractC0703PC) obj).zzb;
    }

    @Override
    public final void mo1885l(Object obj) {
        ((AbstractC0703PC) obj).zzb.m1553m();
    }
}
