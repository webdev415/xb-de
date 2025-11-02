package p000;

import java.util.List;
import p000.InterfaceC0070Be;

public final class C1882ik implements InterfaceC0070Be.a {

    public int f5816a;

    public final C1694ek f5817b;

    public final List f5818c;

    public final int f5819d;

    public final C2287ra f5820e;

    public final C0122Ck f5821f;

    public final int f5822g;

    public final int f5823h;

    public final int f5824i;

    public C1882ik(C1694ek c1694ek, List list, int i, C2287ra c2287ra, C0122Ck c0122Ck, int i2, int i3, int i4) {
        AbstractC0116Ce.m476e(c1694ek, "call");
        AbstractC0116Ce.m476e(list, "interceptors");
        AbstractC0116Ce.m476e(c0122Ck, "request");
        this.f5817b = c1694ek;
        this.f5818c = list;
        this.f5819d = i;
        this.f5820e = c2287ra;
        this.f5821f = c0122Ck;
        this.f5822g = i2;
        this.f5823h = i3;
        this.f5824i = i4;
    }

    public static C1882ik m7967d(C1882ik c1882ik, int i, C2287ra c2287ra, C0122Ck c0122Ck, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = c1882ik.f5819d;
        }
        if ((i5 & 2) != 0) {
            c2287ra = c1882ik.f5820e;
        }
        C2287ra c2287ra2 = c2287ra;
        if ((i5 & 4) != 0) {
            c0122Ck = c1882ik.f5821f;
        }
        C0122Ck c0122Ck2 = c0122Ck;
        if ((i5 & 8) != 0) {
            i2 = c1882ik.f5822g;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = c1882ik.f5823h;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = c1882ik.f5824i;
        }
        return c1882ik.m7968c(i, c2287ra2, c0122Ck2, i6, i7, i4);
    }

    @Override
    public C0122Ck mo303a() {
        return this.f5821f;
    }

    @Override
    public C0490Kk mo304b(C0122Ck c0122Ck) {
        AbstractC0116Ce.m476e(c0122Ck, "request");
        if (!(this.f5819d < this.f5818c.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f5816a++;
        C2287ra c2287ra = this.f5820e;
        if (c2287ra != null) {
            if (!c2287ra.m9369j().m9699g(c0122Ck.m498i())) {
                throw new IllegalStateException(("network interceptor " + ((InterfaceC0070Be) this.f5818c.get(this.f5819d - 1)) + " must retain the same host and port").toString());
            }
            if (!(this.f5816a == 1)) {
                throw new IllegalStateException(("network interceptor " + ((InterfaceC0070Be) this.f5818c.get(this.f5819d - 1)) + " must call proceed() exactly once").toString());
            }
        }
        C1882ik c1882ikM7967d = m7967d(this, this.f5819d + 1, null, c0122Ck, 0, 0, 0, 58, null);
        InterfaceC0070Be interfaceC0070Be = (InterfaceC0070Be) this.f5818c.get(this.f5819d);
        C0490Kk c0490KkMo302a = interfaceC0070Be.mo302a(c1882ikM7967d);
        if (c0490KkMo302a == null) {
            throw new NullPointerException("interceptor " + interfaceC0070Be + " returned null");
        }
        if (this.f5820e != null) {
            if (!(this.f5819d + 1 >= this.f5818c.size() || c1882ikM7967d.f5816a == 1)) {
                throw new IllegalStateException(("network interceptor " + interfaceC0070Be + " must call proceed() exactly once").toString());
            }
        }
        if (c0490KkMo302a.m2392a() != null) {
            return c0490KkMo302a;
        }
        throw new IllegalStateException(("interceptor " + interfaceC0070Be + " returned a response with no body").toString());
    }

    public final C1882ik m7968c(int i, C2287ra c2287ra, C0122Ck c0122Ck, int i2, int i3, int i4) {
        AbstractC0116Ce.m476e(c0122Ck, "request");
        return new C1882ik(this.f5817b, this.f5818c, i, c2287ra, c0122Ck, i2, i3, i4);
    }

    @Override
    public InterfaceC0418J3 call() {
        return this.f5817b;
    }

    public final C1694ek m7969e() {
        return this.f5817b;
    }

    public final int m7970f() {
        return this.f5822g;
    }

    public final C2287ra m7971g() {
        return this.f5820e;
    }

    public final int m7972h() {
        return this.f5823h;
    }

    public final C0122Ck m7973i() {
        return this.f5821f;
    }

    public final int m7974j() {
        return this.f5824i;
    }

    public int m7975k() {
        return this.f5823h;
    }
}
