package p000;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class C2374tE implements InterfaceC1026WE {

    public final InterfaceC1912jE f7198a;

    public final AbstractC0430JF f7199b;

    public final boolean f7200c;

    public final AbstractC2188pC f7201d;

    public C2374tE(AbstractC0430JF abstractC0430JF, AbstractC2188pC abstractC2188pC, InterfaceC1912jE interfaceC1912jE) {
        this.f7199b = abstractC0430JF;
        this.f7200c = abstractC2188pC.mo9046d(interfaceC1912jE);
        this.f7201d = abstractC2188pC;
        this.f7198a = interfaceC1912jE;
    }

    public static C2374tE m9688j(AbstractC0430JF abstractC0430JF, AbstractC2188pC abstractC2188pC, InterfaceC1912jE interfaceC1912jE) {
        return new C2374tE(abstractC0430JF, abstractC2188pC, interfaceC1912jE);
    }

    @Override
    public final Object mo4474a() {
        InterfaceC1912jE interfaceC1912jE = this.f7198a;
        return interfaceC1912jE instanceof AbstractC0703PC ? ((AbstractC0703PC) interfaceC1912jE).m3518z() : interfaceC1912jE.mo3507a().mo3523k();
    }

    @Override
    public final int mo4475b(Object obj) {
        AbstractC0430JF abstractC0430JF = this.f7199b;
        int iMo1878e = abstractC0430JF.mo1878e(abstractC0430JF.mo1884k(obj));
        return this.f7200c ? iMo1878e + this.f7201d.mo9044b(obj).m10640a() : iMo1878e;
    }

    @Override
    public final void mo4476c(Object obj, Object obj2) {
        AbstractC1211aF.m5230o(this.f7199b, obj, obj2);
        if (this.f7200c) {
            AbstractC1211aF.m5228m(this.f7201d, obj, obj2);
        }
    }

    @Override
    public final boolean mo4477d(Object obj) {
        return this.f7201d.mo9044b(obj).m10647n();
    }

    @Override
    public final int mo4478e(Object obj) {
        int iHashCode = this.f7199b.mo1884k(obj).hashCode();
        return this.f7200c ? (iHashCode * 53) + this.f7201d.mo9044b(obj).hashCode() : iHashCode;
    }

    @Override
    public final void mo4479f(Object obj) {
        this.f7199b.mo1885l(obj);
        this.f7201d.mo9048f(obj);
    }

    @Override
    public final void mo4480g(Object obj, InterfaceC0017AG interfaceC0017AG) {
        Iterator itM10645l = this.f7201d.mo9044b(obj).m10645l();
        if (itM10645l.hasNext()) {
            AbstractC2524wh.m10586a(((Map.Entry) itM10645l.next()).getKey());
            throw null;
        }
        AbstractC0430JF abstractC0430JF = this.f7199b;
        abstractC0430JF.mo1877d(abstractC0430JF.mo1884k(obj), interfaceC0017AG);
    }

    @Override
    public final void mo4481h(Object obj, byte[] bArr, int i, int i2, C1769gB c1769gB) {
        AbstractC0703PC abstractC0703PC = (AbstractC0703PC) obj;
        if (abstractC0703PC.zzb == C0338HF.m1543k()) {
            abstractC0703PC.zzb = C0338HF.m1544l();
        }
        AbstractC2524wh.m10586a(obj);
        throw null;
    }

    @Override
    public final boolean mo4482i(Object obj, Object obj2) {
        if (!this.f7199b.mo1884k(obj).equals(this.f7199b.mo1884k(obj2))) {
            return false;
        }
        if (this.f7200c) {
            return this.f7201d.mo9044b(obj).equals(this.f7201d.mo9044b(obj2));
        }
        return true;
    }
}
