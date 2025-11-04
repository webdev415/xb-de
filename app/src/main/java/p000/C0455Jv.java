package p000;

import java.util.concurrent.Callable;

public final class C0455Jv {

    public final C0129Cr f1466a;

    public final C2357sy f1467b;

    public final C2357sy f1468c;

    public final C0335HC f1469d;

    public C0455Jv() {
        C0129Cr c0129Cr = new C0129Cr();
        this.f1466a = c0129Cr;
        C2357sy c2357sy = new C2357sy(null, c0129Cr);
        this.f1468c = c2357sy;
        this.f1467b = c2357sy.m9632d();
        C0335HC c0335hc = new C0335HC();
        this.f1469d = c0335hc;
        c2357sy.m9636h("require", new C1777gJ(c0335hc));
        c0335hc.m1536b("internal.platform", new Callable() {
            @Override
            public final Object call() {
                return new C1637dJ();
            }
        });
        c2357sy.m9636h("runtime.counter", new C0036Aq(Double.valueOf(0.0d)));
    }

    public final InterfaceC0909Tq m2171a(C2357sy c2357sy, C0550Ly... c0550LyArr) {
        InterfaceC0909Tq interfaceC0909TqM415b = InterfaceC0909Tq.f2785d;
        for (C0550Ly c0550Ly : c0550LyArr) {
            interfaceC0909TqM415b = AbstractC0103CA.m415b(c0550Ly);
            AbstractC1145Yw.m4995b(this.f1468c);
            if ((interfaceC0909TqM415b instanceof C1185Zq) || (interfaceC0909TqM415b instanceof C1001Vq)) {
                interfaceC0909TqM415b = this.f1466a.m526a(c2357sy, interfaceC0909TqM415b);
            }
        }
        return interfaceC0909TqM415b;
    }

    public final void m2172b(String str, Callable callable) {
        this.f1469d.m1536b(str, callable);
    }
}
