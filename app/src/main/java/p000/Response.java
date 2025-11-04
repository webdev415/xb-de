package p000;

import java.io.Closeable;
import java.util.List;

public final class Response implements Closeable {

    public C0280G3 f1580l;

    public final Request request;

    public final EnumC2342sj protocol;

    public final String message;

    public final int code;

    public final C0941Uc f1585q;

    public final Headers headers;

    public final AbstractC0536Lk f1587s;

    public final Response f1588t;

    public final Response f1589u;

    public final Response f1590v;

    public final long f1591w;

    public final long f1592x;

    public final C2287ra f1593y;

    public static class a {

        public Request f1594a;

        public EnumC2342sj f1595b;

        public int f1596c;

        public String f1597d;

        public C0941Uc f1598e;

        public Headers.a f1599f;

        public AbstractC0536Lk f1600g;

        public Response f1601h;

        public Response f1602i;

        public Response f1603j;

        public long f1604k;

        public long f1605l;

        public C2287ra f1606m;

        public a() {
            this.f1596c = -1;
            this.f1599f = new Headers.a();
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

        public Response m2404c() {
            int i = this.f1596c;
            if (!(i >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.f1596c).toString());
            }
            Request request = this.f1594a;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            EnumC2342sj enumC2342sj = this.f1595b;
            if (enumC2342sj == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.f1597d;
            if (str != null) {
                return new Response(request, enumC2342sj, str, i, this.f1598e, this.f1599f.m4745d(), this.f1600g, this.f1601h, this.f1602i, this.f1603j, this.f1604k, this.f1605l, this.f1606m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public a m2405d(Response response) {
            m2407f("cacheResponse", response);
            this.f1602i = response;
            return this;
        }

        public final void m2406e(Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        public final void m2407f(String str, Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException((str + ".body != null").toString());
                }
                if (!(response.m2385B() == null)) {
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                if (!(response.m2394g() == null)) {
                    throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                }
                if (response.m2387E() == null) {
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

        public a m2412k(Headers headers) {
            AbstractC0116Ce.m476e(headers, "headers");
            this.f1599f = headers.m4739g();
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

        public a m2415n(Response response) {
            m2407f("networkResponse", response);
            this.f1601h = response;
            return this;
        }

        public a m2416o(Response response) {
            m2406e(response);
            this.f1603j = response;
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

        public a m2419r(Request request) {
            AbstractC0116Ce.m476e(request, "request");
            this.f1594a = request;
            return this;
        }

        public a m2420s(long j) {
            this.f1604k = j;
            return this;
        }

        public a(Response response) {
            AbstractC0116Ce.m476e(response, "response");
            this.f1596c = -1;
            this.f1594a = response.getRequest();
            this.f1595b = response.getProtocol();
            this.f1596c = response.getStatus();
            this.f1597d = response.getMessage();
            this.f1598e = response.m2398l();
            this.f1599f = response.getHeaders().m4739g();
            this.f1600g = response.body();
            this.f1601h = response.m2385B();
            this.f1602i = response.m2394g();
            this.f1603j = response.m2387E();
            this.f1604k = response.m2391T();
            this.f1605l = response.m2389J();
            this.f1606m = response.m2397k();
        }
    }

    public Response(Request request, EnumC2342sj enumC2342sj, String str, int i, C0941Uc c0941Uc, Headers headers, AbstractC0536Lk abstractC0536Lk, Response response, Response response2, Response response3, long j, long j2, C2287ra c2287ra) {
        AbstractC0116Ce.m476e(request, "request");
        AbstractC0116Ce.m476e(enumC2342sj, "protocol");
        AbstractC0116Ce.m476e(str, "message");
        AbstractC0116Ce.m476e(headers, "headers");
        this.request = request;
        this.protocol = enumC2342sj;
        this.message = str;
        this.code = i;
        this.f1585q = c0941Uc;
        this.headers = headers;
        this.f1587s = abstractC0536Lk;
        this.f1588t = response;
        this.f1589u = response2;
        this.f1590v = response3;
        this.f1591w = j;
        this.f1592x = j2;
        this.f1593y = c2287ra;
    }

    public static String m2383w(Response response, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return response.m2400u(str, str2);
    }

    public final String getMessage() {
        return this.message;
    }

    public final Response m2385B() {
        return this.f1588t;
    }

    public final a m2386C() {
        return new a(this);
    }

    public final Response m2387E() {
        return this.f1590v;
    }

    public final EnumC2342sj getProtocol() {
        return this.protocol;
    }

    public final long m2389J() {
        return this.f1592x;
    }

    public final Request getRequest() {
        return this.request;
    }

    public final long m2391T() {
        return this.f1591w;
    }

    public final AbstractC0536Lk body() {
        return this.f1587s;
    }

    public final C0280G3 m2393b() {
        C0280G3 c0280g3 = this.f1580l;
        if (c0280g3 != null) {
            return c0280g3;
        }
        C0280G3 c0280g3M1336b = C0280G3.f711p.m1336b(this.headers);
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

    public final Response m2394g() {
        return this.f1589u;
    }

    public final List m2395i() {
        String str;
        Headers headers = this.headers;
        int i = this.code;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return AbstractC1810h5.m7783f();
            }
            str = "Proxy-Authenticate";
        }
        return AbstractC2658zd.m11019a(headers, str);
    }

    public final int getStatus() {
        return this.code;
    }

    public final C2287ra m2397k() {
        return this.f1593y;
    }

    public final C0941Uc m2398l() {
        return this.f1585q;
    }

    public final String getContentType(String str) {
        return m2383w(this, str, null, 2, null);
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.getUrl() + '}';
    }

    public final String m2400u(String str, String str2) {
        AbstractC0116Ce.m476e(str, "name");
        String strM4737d = this.headers.m4737d(str);
        return strM4737d != null ? strM4737d : str2;
    }

    public final Headers getHeaders() {
        return this.headers;
    }
}
