package p000;

import java.io.Closeable;
import java.util.List;
import p000.C1079Xc;

/* loaded from: classes.dex */
public final class C0490Kk implements Closeable {

    public C0280G3 f1580l;

    public final C0122Ck f1581m;

    public final EnumC2342sj f1582n;

    public final String f1583o;

    public final int f1584p;

    public final C0941Uc f1585q;

    public final C1079Xc f1586r;

    public final AbstractC0536Lk f1587s;

    public final C0490Kk f1588t;

    public final C0490Kk f1589u;

    public final C0490Kk f1590v;

    public final long f1591w;

    public final long f1592x;

    public final C2287ra f1593y;

    public static class a {

        public C0122Ck f1594a;

        public EnumC2342sj f1595b;

        public int f1596c;

        public String f1597d;

        public C0941Uc f1598e;

        public C1079Xc.a f1599f;

        public AbstractC0536Lk f1600g;

        public C0490Kk f1601h;

        public C0490Kk f1602i;

        public C0490Kk f1603j;

        public long f1604k;

        public long f1605l;

        public C2287ra f1606m;

        public a() {
            this.f1596c = -1;
            this.f1599f = new C1079Xc.a();
        }

        public a m2402a(String str, String str2) {
            AbstractC0116Ce.m476e(str, "name");
            AbstractC0116Ce.m476e(str2, "value");
            this.f1599f.m4742a(str, str2);
            return this;
        }

        public a m2403b(AbstractC0536Lk abstractC0536Lk) {
            this.f1600g = abstractC0536Lk;
            return this;
        }

        public C0490Kk m2404c() {
            int i = this.f1596c;
            if (!(i >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.f1596c).toString());
            }
            C0122Ck c0122Ck = this.f1594a;
            if (c0122Ck == null) {
                throw new IllegalStateException("request == null".toString());
            }
            EnumC2342sj enumC2342sj = this.f1595b;
            if (enumC2342sj == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.f1597d;
            if (str != null) {
                return new C0490Kk(c0122Ck, enumC2342sj, str, i, this.f1598e, this.f1599f.m4745d(), this.f1600g, this.f1601h, this.f1602i, this.f1603j, this.f1604k, this.f1605l, this.f1606m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public a m2405d(C0490Kk c0490Kk) {
            m2407f("cacheResponse", c0490Kk);
            this.f1602i = c0490Kk;
            return this;
        }

        public final void m2406e(C0490Kk c0490Kk) {
            if (c0490Kk != null) {
                if (!(c0490Kk.m2392a() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        public final void m2407f(String str, C0490Kk c0490Kk) {
            if (c0490Kk != null) {
                if (!(c0490Kk.m2392a() == null)) {
                    throw new IllegalArgumentException((str + ".body != null").toString());
                }
                if (!(c0490Kk.m2385B() == null)) {
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                if (!(c0490Kk.m2394g() == null)) {
                    throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                }
                if (c0490Kk.m2387E() == null) {
                    return;
                }
                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
            }
        }

        public a m2408g(int i) {
            this.f1596c = i;
            return this;
        }

        public final int m2409h() {
            return this.f1596c;
        }

        public a m2410i(C0941Uc c0941Uc) {
            this.f1598e = c0941Uc;
            return this;
        }

        public a m2411j(String str, String str2) {
            AbstractC0116Ce.m476e(str, "name");
            AbstractC0116Ce.m476e(str2, "value");
            this.f1599f.m4748g(str, str2);
            return this;
        }

        public a m2412k(C1079Xc c1079Xc) {
            AbstractC0116Ce.m476e(c1079Xc, "headers");
            this.f1599f = c1079Xc.m4739g();
            return this;
        }

        public final void m2413l(C2287ra c2287ra) {
            AbstractC0116Ce.m476e(c2287ra, "deferredTrailers");
            this.f1606m = c2287ra;
        }

        public a m2414m(String str) {
            AbstractC0116Ce.m476e(str, "message");
            this.f1597d = str;
            return this;
        }

        public a m2415n(C0490Kk c0490Kk) {
            m2407f("networkResponse", c0490Kk);
            this.f1601h = c0490Kk;
            return this;
        }

        public a m2416o(C0490Kk c0490Kk) {
            m2406e(c0490Kk);
            this.f1603j = c0490Kk;
            return this;
        }

        public a m2417p(EnumC2342sj enumC2342sj) {
            AbstractC0116Ce.m476e(enumC2342sj, "protocol");
            this.f1595b = enumC2342sj;
            return this;
        }

        public a m2418q(long j) {
            this.f1605l = j;
            return this;
        }

        public a m2419r(C0122Ck c0122Ck) {
            AbstractC0116Ce.m476e(c0122Ck, "request");
            this.f1594a = c0122Ck;
            return this;
        }

        public a m2420s(long j) {
            this.f1604k = j;
            return this;
        }

        public a(C0490Kk c0490Kk) {
            AbstractC0116Ce.m476e(c0490Kk, "response");
            this.f1596c = -1;
            this.f1594a = c0490Kk.m2390S();
            this.f1595b = c0490Kk.m2388I();
            this.f1596c = c0490Kk.m2396j();
            this.f1597d = c0490Kk.m2384A();
            this.f1598e = c0490Kk.m2398l();
            this.f1599f = c0490Kk.m2401z().m4739g();
            this.f1600g = c0490Kk.m2392a();
            this.f1601h = c0490Kk.m2385B();
            this.f1602i = c0490Kk.m2394g();
            this.f1603j = c0490Kk.m2387E();
            this.f1604k = c0490Kk.m2391T();
            this.f1605l = c0490Kk.m2389J();
            this.f1606m = c0490Kk.m2397k();
        }
    }

    public C0490Kk(C0122Ck c0122Ck, EnumC2342sj enumC2342sj, String str, int i, C0941Uc c0941Uc, C1079Xc c1079Xc, AbstractC0536Lk abstractC0536Lk, C0490Kk c0490Kk, C0490Kk c0490Kk2, C0490Kk c0490Kk3, long j, long j2, C2287ra c2287ra) {
        AbstractC0116Ce.m476e(c0122Ck, "request");
        AbstractC0116Ce.m476e(enumC2342sj, "protocol");
        AbstractC0116Ce.m476e(str, "message");
        AbstractC0116Ce.m476e(c1079Xc, "headers");
        this.f1581m = c0122Ck;
        this.f1582n = enumC2342sj;
        this.f1583o = str;
        this.f1584p = i;
        this.f1585q = c0941Uc;
        this.f1586r = c1079Xc;
        this.f1587s = abstractC0536Lk;
        this.f1588t = c0490Kk;
        this.f1589u = c0490Kk2;
        this.f1590v = c0490Kk3;
        this.f1591w = j;
        this.f1592x = j2;
        this.f1593y = c2287ra;
    }

    public static String m2383w(C0490Kk c0490Kk, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return c0490Kk.m2400u(str, str2);
    }

    public final String m2384A() {
        return this.f1583o;
    }

    public final C0490Kk m2385B() {
        return this.f1588t;
    }

    public final a m2386C() {
        return new a(this);
    }

    public final C0490Kk m2387E() {
        return this.f1590v;
    }

    public final EnumC2342sj m2388I() {
        return this.f1582n;
    }

    public final long m2389J() {
        return this.f1592x;
    }

    public final C0122Ck m2390S() {
        return this.f1581m;
    }

    public final long m2391T() {
        return this.f1591w;
    }

    public final AbstractC0536Lk m2392a() {
        return this.f1587s;
    }

    public final C0280G3 m2393b() {
        C0280G3 c0280g3 = this.f1580l;
        if (c0280g3 != null) {
            return c0280g3;
        }
        C0280G3 c0280g3M1336b = C0280G3.f711p.m1336b(this.f1586r);
        this.f1580l = c0280g3M1336b;
        return c0280g3M1336b;
    }

    @Override
    public void close() {
        AbstractC0536Lk abstractC0536Lk = this.f1587s;
        if (abstractC0536Lk == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        abstractC0536Lk.close();
    }

    public final C0490Kk m2394g() {
        return this.f1589u;
    }

    public final List m2395i() {
        String str;
        C1079Xc c1079Xc = this.f1586r;
        int i = this.f1584p;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return AbstractC1810h5.m7783f();
            }
            str = "Proxy-Authenticate";
        }
        return AbstractC2658zd.m11019a(c1079Xc, str);
    }

    public final int m2396j() {
        return this.f1584p;
    }

    public final C2287ra m2397k() {
        return this.f1593y;
    }

    public final C0941Uc m2398l() {
        return this.f1585q;
    }

    public final String m2399p(String str) {
        return m2383w(this, str, null, 2, null);
    }

    public String toString() {
        return "Response{protocol=" + this.f1582n + ", code=" + this.f1584p + ", message=" + this.f1583o + ", url=" + this.f1581m.m498i() + '}';
    }

    public final String m2400u(String str, String str2) {
        AbstractC0116Ce.m476e(str, "name");
        String strM4737d = this.f1586r.m4737d(str);
        return strM4737d != null ? strM4737d : str2;
    }

    public final C1079Xc m2401z() {
        return this.f1586r;
    }
}
