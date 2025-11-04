package p000;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public final class C2336sd implements InterfaceC2333sa {

    public static final d f7039h = new d(null);

    public int f7040a;

    public final C1125Yc f7041b;

    public Headers f7042c;

    public final OkHttpClient f7043d;

    public final Connection f7044e;

    public final InterfaceC2547x3 f7045f;

    public final InterfaceC2501w3 f7046g;

    public abstract class a implements InterfaceC2161om {

        public final C0113Cb f7047l;

        public boolean f7048m;

        public a() {
            this.f7047l = new C0113Cb(C2336sd.this.f7045f.mo239d());
        }

        public final boolean m9562a() {
            return this.f7048m;
        }

        public final void m9563b() {
            if (C2336sd.this.f7040a == 6) {
                return;
            }
            if (C2336sd.this.f7040a == 5) {
                C2336sd.this.m9553r(this.f7047l);
                C2336sd.this.f7040a = 6;
            } else {
                throw new IllegalStateException("state: " + C2336sd.this.f7040a);
            }
        }

        @Override
        public C0125Cn mo239d() {
            return this.f7047l;
        }

        public final void m9564g(boolean z) {
            this.f7048m = z;
        }

        @Override
        public long mo1488n(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "sink");
            try {
                return C2336sd.this.f7045f.mo1488n(c2409u3, j);
            } catch (IOException e) {
                C2336sd.this.mo9537h().m7636y();
                m9563b();
                throw e;
            }
        }
    }

    public final class b implements InterfaceC1134Yl {

        public final C0113Cb f7050l;

        public boolean f7051m;

        public b() {
            this.f7050l = new C0113Cb(C2336sd.this.f7046g.mo114d());
        }

        @Override
        public synchronized void close() {
            if (this.f7051m) {
                return;
            }
            this.f7051m = true;
            C2336sd.this.f7046g.mo5925H("0\r\n\r\n");
            C2336sd.this.m9553r(this.f7050l);
            C2336sd.this.f7040a = 3;
        }

        @Override
        public C0125Cn mo114d() {
            return this.f7050l;
        }

        @Override
        public synchronized void flush() {
            if (this.f7051m) {
                return;
            }
            C2336sd.this.f7046g.flush();
        }

        @Override
        public void mo115h(C2409u3 c2409u3, long j) {
            AbstractC0116Ce.m476e(c2409u3, "source");
            if (!(!this.f7051m)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j == 0) {
                return;
            }
            C2336sd.this.f7046g.mo5932m(j);
            C2336sd.this.f7046g.mo5925H("\r\n");
            C2336sd.this.f7046g.mo115h(c2409u3, j);
            C2336sd.this.f7046g.mo5925H("\r\n");
        }
    }

    public final class c extends a {

        public long f7053o;

        public boolean f7054p;

        public final C0069Bd f7055q;

        public final C2336sd f7056r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C2336sd c2336sd, C0069Bd c0069Bd) {
            super();
            AbstractC0116Ce.m476e(c0069Bd, "url");
            this.f7056r = c2336sd;
            this.f7055q = c0069Bd;
            this.f7053o = -1L;
            this.f7054p = true;
        }

        @Override
        public void close() {
            if (m9562a()) {
                return;
            }
            if (this.f7054p && !AbstractC2623yo.m10941p(this, 100, TimeUnit.MILLISECONDS)) {
                this.f7056r.mo9537h().m7636y();
                m9563b();
            }
            m9564g(true);
        }

        public final void m9565i() throws ProtocolException {
            if (this.f7053o != -1) {
                this.f7056r.f7045f.mo7330D();
            }
            try {
                this.f7053o = this.f7056r.f7045f.mo7335O();
                String strMo7330D = this.f7056r.f7045f.mo7330D();
                if (strMo7330D == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String string = AbstractC0584Mm.m2956n0(strMo7330D).toString();
                if (this.f7053o < 0 || (string.length() > 0 && !AbstractC0538Lm.m2731w(string, ";", false, 2, null))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f7053o + string + '\"');
                }
                if (this.f7053o == 0) {
                    this.f7054p = false;
                    C2336sd c2336sd = this.f7056r;
                    c2336sd.f7042c = c2336sd.f7041b.m4936a();
                    OkHttpClient okHttpClient = this.f7056r.f7043d;
                    AbstractC0116Ce.m473b(okHttpClient);
                    InterfaceC0053B6 interfaceC0053B6M1994n = okHttpClient.m1994n();
                    C0069Bd c0069Bd = this.f7055q;
                    Headers headers = this.f7056r.f7042c;
                    AbstractC0116Ce.m473b(headers);
                    AbstractC2658zd.m11024f(interfaceC0053B6M1994n, c0069Bd, headers);
                    m9563b();
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override
        public long mo1488n(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!(!m9562a())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f7054p) {
                return -1L;
            }
            long j2 = this.f7053o;
            if (j2 == 0 || j2 == -1) {
                m9565i();
                if (!this.f7054p) {
                    return -1L;
                }
            }
            long jMo1488n = super.mo1488n(c2409u3, Math.min(j, this.f7053o));
            if (jMo1488n != -1) {
                this.f7053o -= jMo1488n;
                return jMo1488n;
            }
            this.f7056r.mo9537h().m7636y();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            m9563b();
            throw protocolException;
        }
    }

    public static final class d {
        public d() {
        }

        public d(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public final class e extends a {

        public long f7057o;

        public e(long j) {
            super();
            this.f7057o = j;
            if (j == 0) {
                m9563b();
            }
        }

        @Override
        public void close() {
            if (m9562a()) {
                return;
            }
            if (this.f7057o != 0 && !AbstractC2623yo.m10941p(this, 100, TimeUnit.MILLISECONDS)) {
                C2336sd.this.mo9537h().m7636y();
                m9563b();
            }
            m9564g(true);
        }

        @Override
        public long mo1488n(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!(!m9562a())) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.f7057o;
            if (j2 == 0) {
                return -1L;
            }
            long jMo1488n = super.mo1488n(c2409u3, Math.min(j2, j));
            if (jMo1488n == -1) {
                C2336sd.this.mo9537h().m7636y();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m9563b();
                throw protocolException;
            }
            long j3 = this.f7057o - jMo1488n;
            this.f7057o = j3;
            if (j3 == 0) {
                m9563b();
            }
            return jMo1488n;
        }
    }

    public final class f implements InterfaceC1134Yl {

        public final C0113Cb f7059l;

        public boolean f7060m;

        public f() {
            this.f7059l = new C0113Cb(C2336sd.this.f7046g.mo114d());
        }

        @Override
        public void close() {
            if (this.f7060m) {
                return;
            }
            this.f7060m = true;
            C2336sd.this.m9553r(this.f7059l);
            C2336sd.this.f7040a = 3;
        }

        @Override
        public C0125Cn mo114d() {
            return this.f7059l;
        }

        @Override
        public void flush() {
            if (this.f7060m) {
                return;
            }
            C2336sd.this.f7046g.flush();
        }

        @Override
        public void mo115h(C2409u3 c2409u3, long j) {
            AbstractC0116Ce.m476e(c2409u3, "source");
            if (!(!this.f7060m)) {
                throw new IllegalStateException("closed".toString());
            }
            AbstractC2623yo.m10934i(c2409u3.m9911Y(), 0L, j);
            C2336sd.this.f7046g.mo115h(c2409u3, j);
        }
    }

    public final class g extends a {

        public boolean f7062o;

        public g() {
            super();
        }

        @Override
        public void close() {
            if (m9562a()) {
                return;
            }
            if (!this.f7062o) {
                m9563b();
            }
            m9564g(true);
        }

        @Override
        public long mo1488n(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            if (!(!m9562a())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f7062o) {
                return -1L;
            }
            long jMo1488n = super.mo1488n(c2409u3, j);
            if (jMo1488n != -1) {
                return jMo1488n;
            }
            this.f7062o = true;
            m9563b();
            return -1L;
        }
    }

    public C2336sd(OkHttpClient okHttpClient, Connection connection, InterfaceC2547x3 interfaceC2547x3, InterfaceC2501w3 interfaceC2501w3) {
        AbstractC0116Ce.m476e(connection, "connection");
        AbstractC0116Ce.m476e(interfaceC2547x3, "source");
        AbstractC0116Ce.m476e(interfaceC2501w3, "sink");
        this.f7043d = okHttpClient;
        this.f7044e = connection;
        this.f7045f = interfaceC2547x3;
        this.f7046g = interfaceC2501w3;
        this.f7041b = new C1125Yc(interfaceC2547x3);
    }

    public final void m9552A(Headers headers, String str) {
        AbstractC0116Ce.m476e(headers, "headers");
        AbstractC0116Ce.m476e(str, "requestLine");
        if (!(this.f7040a == 0)) {
            throw new IllegalStateException(("state: " + this.f7040a).toString());
        }
        this.f7046g.mo5925H(str).mo5925H("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.f7046g.mo5925H(headers.m4738f(i)).mo5925H(": ").mo5925H(headers.m4740h(i)).mo5925H("\r\n");
        }
        this.f7046g.mo5925H("\r\n");
        this.f7040a = 1;
    }

    @Override
    public void mo9530a(Request request) {
        AbstractC0116Ce.m476e(request, "request");
        C0260Fk c0260Fk = C0260Fk.f676a;
        Proxy.Type type = mo9537h().m7637z().getProxy().type();
        AbstractC0116Ce.m475d(type, "connection.route().proxy.type()");
        m9552A(request.m494e(), c0260Fk.m1270a(request, type));
    }

    @Override
    public InterfaceC2161om mo9531b(Response response) {
        long jM10944s;
        AbstractC0116Ce.m476e(response, "response");
        if (!AbstractC2658zd.m11020b(response)) {
            jM10944s = 0;
        } else {
            if (m9555t(response)) {
                return m9557v(response.getRequest().getUrl());
            }
            jM10944s = AbstractC2623yo.m10944s(response);
            if (jM10944s == -1) {
                return m9560y();
            }
        }
        return m9558w(jM10944s);
    }

    @Override
    public void mo9532c() {
        this.f7046g.flush();
    }

    @Override
    public void cancel() {
        mo9537h().m7615d();
    }

    @Override
    public void mo9533d() {
        this.f7046g.flush();
    }

    @Override
    public Response.a mo9534e(boolean z) {
        int i = this.f7040a;
        boolean z2 = true;
        if (i != 1 && i != 3) {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalStateException(("state: " + this.f7040a).toString());
        }
        try {
            C2529wm c2529wmM10597a = C2529wm.f7894d.m10597a(this.f7041b.m4937b());
            Response.a aVarM2412k = new Response.a().m2417p(c2529wmM10597a.f7895a).m2408g(c2529wmM10597a.f7896b).m2414m(c2529wmM10597a.f7897c).m2412k(this.f7041b.m4936a());
            if (z && c2529wmM10597a.f7896b == 100) {
                return null;
            }
            if (c2529wmM10597a.f7896b == 100) {
                this.f7040a = 3;
                return aVarM2412k;
            }
            this.f7040a = 4;
            return aVarM2412k;
        } catch (EOFException e2) {
            throw new IOException("unexpected end of stream on " + mo9537h().m7637z().m5675a().m10421l().m255n(), e2);
        }
    }

    @Override
    public InterfaceC1134Yl mo9535f(Request request, long j) throws ProtocolException {
        AbstractC0116Ce.m476e(request, "request");
        if (request.m490a() != null && request.m490a().m722f()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (m9554s(request)) {
            return m9556u();
        }
        if (j != -1) {
            return m9559x();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override
    public long mo9536g(Response response) {
        AbstractC0116Ce.m476e(response, "response");
        if (!AbstractC2658zd.m11020b(response)) {
            return 0L;
        }
        if (m9555t(response)) {
            return -1L;
        }
        return AbstractC2623yo.m10944s(response);
    }

    @Override
    public Connection mo9537h() {
        return this.f7044e;
    }

    public final void m9553r(C0113Cb c0113Cb) {
        C0125Cn c0125CnM440i = c0113Cb.m440i();
        c0113Cb.m441j(C0125Cn.f305d);
        c0125CnM440i.mo433a();
        c0125CnM440i.mo434b();
    }

    public final boolean m9554s(Request request) {
        return AbstractC0538Lm.m2720l("chunked", request.m493d("Transfer-Encoding"), true);
    }

    public final boolean m9555t(Response response) {
        return AbstractC0538Lm.m2720l("chunked", Response.m2383w(response, "Transfer-Encoding", null, 2, null), true);
    }

    public final InterfaceC1134Yl m9556u() {
        if (this.f7040a == 1) {
            this.f7040a = 2;
            return new b();
        }
        throw new IllegalStateException(("state: " + this.f7040a).toString());
    }

    public final InterfaceC2161om m9557v(C0069Bd c0069Bd) {
        if (this.f7040a == 4) {
            this.f7040a = 5;
            return new c(this, c0069Bd);
        }
        throw new IllegalStateException(("state: " + this.f7040a).toString());
    }

    public final InterfaceC2161om m9558w(long j) {
        if (this.f7040a == 4) {
            this.f7040a = 5;
            return new e(j);
        }
        throw new IllegalStateException(("state: " + this.f7040a).toString());
    }

    public final InterfaceC1134Yl m9559x() {
        if (this.f7040a == 1) {
            this.f7040a = 2;
            return new f();
        }
        throw new IllegalStateException(("state: " + this.f7040a).toString());
    }

    public final InterfaceC2161om m9560y() {
        if (this.f7040a == 4) {
            this.f7040a = 5;
            mo9537h().m7636y();
            return new g();
        }
        throw new IllegalStateException(("state: " + this.f7040a).toString());
    }

    public final void m9561z(Response response) {
        AbstractC0116Ce.m476e(response, "response");
        long jM10944s = AbstractC2623yo.m10944s(response);
        if (jM10944s == -1) {
            return;
        }
        InterfaceC2161om interfaceC2161omM9558w = m9558w(jM10944s);
        AbstractC2623yo.m10912H(interfaceC2161omM9558w, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        interfaceC2161omM9558w.close();
    }
}
