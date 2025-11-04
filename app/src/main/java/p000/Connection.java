package p000;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class C1741fk extends C2428ud.d implements InterfaceC1624d6 {

    public static final a f5511t = new a(null);

    public Socket f5512c;

    public Socket f5513d;

    public C0941Uc f5514e;

    public EnumC2342sj f5515f;

    public C2428ud f5516g;

    public InterfaceC2547x3 f5517h;

    public InterfaceC2501w3 f5518i;

    public boolean f5519j;

    public boolean f5520k;

    public int f5521l;

    public int f5522m;

    public int f5523n;

    public int f5524o;

    public final List f5525p;

    public long f5526q;

    public final C1835hk f5527r;

    public final C1328bl f5528s;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b extends AbstractC0025Af implements InterfaceC0894Tb {

        public final C2087n4 f5529m;

        public final C0941Uc f5530n;

        public final C2498w0 f5531o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C2087n4 c2087n4, C0941Uc c0941Uc, C2498w0 c2498w0) {
            super(0);
            this.f5529m = c2087n4;
            this.f5530n = c0941Uc;
            this.f5531o = c2498w0;
        }

        @Override
        public final List mo4135c() {
            AbstractC2041m4 abstractC2041m4M8726d = this.f5529m.m8726d();
            AbstractC0116Ce.m473b(abstractC2041m4M8726d);
            return abstractC2041m4M8726d.mo2573a(this.f5530n.m4246d(), this.f5531o.m10421l().m249h());
        }
    }

    public static final class c extends AbstractC0025Af implements InterfaceC0894Tb {
        public c() {
            super(0);
        }

        @Override
        public final List mo4135c() {
            C0941Uc c0941Uc = C1741fk.this.f5514e;
            AbstractC0116Ce.m473b(c0941Uc);
            List<Certificate> listM4246d = c0941Uc.m4246d();
            ArrayList arrayList = new ArrayList<>(AbstractC1857i5.m7866n(listM4246d, 10));
            for (Certificate certificate : listM4246d) {
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public C1741fk(C1835hk c1835hk, C1328bl c1328bl) {
        AbstractC0116Ce.m476e(c1835hk, "connectionPool");
        AbstractC0116Ce.m476e(c1328bl, "route");
        this.f5527r = c1835hk;
        this.f5528s = c1328bl;
        this.f5524o = 1;
        this.f5525p = new ArrayList<>();
        this.f5526q = Long.MAX_VALUE;
    }

    public final boolean m7606A(List list) {
        List<C1328bl> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (C1328bl c1328bl : list2) {
            Proxy.Type type = c1328bl.m5676b().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && this.f5528s.m5676b().type() == type2 && AbstractC0116Ce.m472a(this.f5528s.m5678d(), c1328bl.m5678d())) {
                return true;
            }
        }
        return false;
    }

    public final void m7607B(long j) {
        this.f5526q = j;
    }

    public final void m7608C(boolean z) {
        this.f5519j = z;
    }

    public Socket m7609D() {
        Socket socket = this.f5513d;
        AbstractC0116Ce.m473b(socket);
        return socket;
    }

    public final void m7610E(int i) throws SocketException {
        Socket socket = this.f5513d;
        AbstractC0116Ce.m473b(socket);
        InterfaceC2547x3 interfaceC2547x3 = this.f5517h;
        AbstractC0116Ce.m473b(interfaceC2547x3);
        InterfaceC2501w3 interfaceC2501w3 = this.f5518i;
        AbstractC0116Ce.m473b(interfaceC2501w3);
        socket.setSoTimeout(0);
        C2428ud c2428udM10063a = new C2428ud.b(true, C2300rn.f6963h).m10075m(socket, this.f5528s.m5675a().m10421l().m249h(), interfaceC2547x3, interfaceC2501w3).m10073k(this).m10074l(i).m10063a();
        this.f5516g = c2428udM10063a;
        this.f5524o = C2428ud.f7404O.m10076a().m3700d();
        C2428ud.m10026u0(c2428udM10063a, false, null, 3, null);
    }

    public final boolean m7611F(C0069Bd c0069Bd) {
        C0941Uc c0941Uc;
        if (AbstractC2623yo.f8134h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        C0069Bd c0069BdM10421l = this.f5528s.m5675a().m10421l();
        if (c0069Bd.m253l() != c0069BdM10421l.m253l()) {
            return false;
        }
        if (AbstractC0116Ce.m472a(c0069Bd.m249h(), c0069BdM10421l.m249h())) {
            return true;
        }
        if (this.f5520k || (c0941Uc = this.f5514e) == null) {
            return false;
        }
        AbstractC0116Ce.m473b(c0941Uc);
        return m7616e(c0069Bd, c0941Uc);
    }

    public final synchronized void m7612G(C1694ek c1694ek, IOException iOException) {
        int i;
        try {
            AbstractC0116Ce.m476e(c1694ek, "call");
            if (iOException instanceof C2575xm) {
                if (((C2575xm) iOException).f8025l == EnumC1159Z9.REFUSED_STREAM) {
                    int i2 = this.f5523n + 1;
                    this.f5523n = i2;
                    if (i2 > 1) {
                        this.f5519j = true;
                        i = this.f5521l;
                        this.f5521l = i + 1;
                    }
                } else if (((C2575xm) iOException).f8025l != EnumC1159Z9.CANCEL || !c1694ek.m7450w()) {
                    this.f5519j = true;
                    i = this.f5521l;
                    this.f5521l = i + 1;
                }
            } else if (!m7633v() || (iOException instanceof C1764g6)) {
                this.f5519j = true;
                if (this.f5522m == 0) {
                    if (iOException != null) {
                        m7618g(c1694ek.m7442n(), this.f5528s, iOException);
                    }
                    i = this.f5521l;
                    this.f5521l = i + 1;
                }
            }
        } finally {
        }
    }

    @Override
    public synchronized void mo7613a(C2428ud c2428ud, C0767Ql c0767Ql) {
        AbstractC0116Ce.m476e(c2428ud, "connection");
        AbstractC0116Ce.m476e(c0767Ql, "settings");
        this.f5524o = c0767Ql.m3700d();
    }

    @Override
    public void mo7614b(C2566xd c2566xd) {
        AbstractC0116Ce.m476e(c2566xd, "stream");
        c2566xd.m10683d(EnumC1159Z9.REFUSED_STREAM, null);
    }

    public final void m7615d() {
        Socket socket = this.f5512c;
        if (socket != null) {
            AbstractC2623yo.m10936k(socket);
        }
    }

    public final boolean m7616e(C0069Bd c0069Bd, C0941Uc c0941Uc) {
        List listM4246d = c0941Uc.m4246d();
        if (!listM4246d.isEmpty()) {
            C0395Ih c0395Ih = C0395Ih.f1155a;
            String strM249h = c0069Bd.m249h();
            Object obj = listM4246d.get(0);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            if (c0395Ih.m1705c(strM249h, (X509Certificate) obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m7617f(int r17, int r18, int r19, int r20, boolean r21, InterfaceC0418J3 r22, AbstractC1918ja r23) throws Throwable {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1741fk.m7617f(int, int, int, int, boolean, J3, ja):void");
    }

    public final void m7618g(OkHttpClient okHttpClient, C1328bl c1328bl, IOException iOException) {
        AbstractC0116Ce.m476e(okHttpClient, "client");
        AbstractC0116Ce.m476e(c1328bl, "failedRoute");
        AbstractC0116Ce.m476e(iOException, "failure");
        if (c1328bl.m5676b().type() != Proxy.Type.DIRECT) {
            C2498w0 c2498w0M5675a = c1328bl.m5675a();
            c2498w0M5675a.m10418i().connectFailed(c2498w0M5675a.m10421l().m258q(), c1328bl.m5676b().address(), iOException);
        }
        okHttpClient.m2000u().m7352b(c1328bl);
    }

    public final void m7619h(int i, int i2, InterfaceC0418J3 interfaceC0418J3, AbstractC1918ja abstractC1918ja) throws IOException {
        Socket socket;
        int i3;
        Proxy proxyM5676b = this.f5528s.m5676b();
        C2498w0 c2498w0M5675a = this.f5528s.m5675a();
        Proxy.Type type = proxyM5676b.type();
        if (type != null && ((i3 = AbstractC1788gk.f5641a[type.ordinal()]) == 1 || i3 == 2)) {
            socket = c2498w0M5675a.m10419j().createSocket();
            AbstractC0116Ce.m473b(socket);
        } else {
            socket = new Socket(proxyM5676b);
        }
        this.f5512c = socket;
        abstractC1918ja.m8140i(interfaceC0418J3, this.f5528s.m5678d(), proxyM5676b);
        socket.setSoTimeout(i2);
        try {
            C0764Qi.f2268c.m3690g().mo3677f(socket, this.f5528s.m5678d(), i);
            try {
                this.f5517h = AbstractC0487Kh.m2376b(AbstractC0487Kh.m2380f(socket));
                this.f5518i = AbstractC0487Kh.m2375a(AbstractC0487Kh.m2378d(socket));
            } catch (NullPointerException e) {
                if (AbstractC0116Ce.m472a(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f5528s.m5678d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void m7620i(C1858i6 c1858i6) throws Throwable {
        C2498w0 c2498w0M5675a = this.f5528s.m5675a();
        SSLSocketFactory sSLSocketFactoryM10420k = c2498w0M5675a.m10420k();
        SSLSocket sSLSocket = null;
        try {
            AbstractC0116Ce.m473b(sSLSocketFactoryM10420k);
            Socket socketCreateSocket = sSLSocketFactoryM10420k.createSocket(this.f5512c, c2498w0M5675a.m10421l().m249h(), c2498w0M5675a.m10421l().m253l(), true);
            if (socketCreateSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                C1811h6 c1811h6M7867a = c1858i6.m7867a(sSLSocket2);
                if (c1811h6M7867a.m7798h()) {
                    C0764Qi.f2268c.m3690g().mo1315e(sSLSocket2, c2498w0M5675a.m10421l().m249h(), c2498w0M5675a.m10415f());
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                C0941Uc.a aVar = C0941Uc.f2850e;
                AbstractC0116Ce.m475d(session, "sslSocketSession");
                C0941Uc c0941UcM4248a = aVar.m4248a(session);
                HostnameVerifier hostnameVerifierM10414e = c2498w0M5675a.m10414e();
                AbstractC0116Ce.m473b(hostnameVerifierM10414e);
                if (hostnameVerifierM10414e.verify(c2498w0M5675a.m10421l().m249h(), session)) {
                    C2087n4 c2087n4M10410a = c2498w0M5675a.m10410a();
                    AbstractC0116Ce.m473b(c2087n4M10410a);
                    this.f5514e = new C0941Uc(c0941UcM4248a.m4247e(), c0941UcM4248a.m4243a(), c0941UcM4248a.m4245c(), new b(c2087n4M10410a, c0941UcM4248a, c2498w0M5675a));
                    c2087n4M10410a.m8724b(c2498w0M5675a.m10421l().m249h(), new c());
                    String strMo1316g = c1811h6M7867a.m7798h() ? C0764Qi.f2268c.m3690g().mo1316g(sSLSocket2) : null;
                    this.f5513d = sSLSocket2;
                    this.f5517h = AbstractC0487Kh.m2376b(AbstractC0487Kh.m2380f(sSLSocket2));
                    this.f5518i = AbstractC0487Kh.m2375a(AbstractC0487Kh.m2378d(sSLSocket2));
                    this.f5515f = strMo1316g != null ? EnumC2342sj.f7078t.m9586a(strMo1316g) : EnumC2342sj.HTTP_1_1;
                    C0764Qi.f2268c.m3690g().mo3675b(sSLSocket2);
                    return;
                }
                List listM4246d = c0941UcM4248a.m4246d();
                if (!(!listM4246d.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + c2498w0M5675a.m10421l().m249h() + " not verified (no certificates)");
                }
                Object obj = listM4246d.get(0);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                X509Certificate x509Certificate = (X509Certificate) obj;
                StringBuilder sb = new StringBuilder();
                sb.append("\n              |Hostname ");
                sb.append(c2498w0M5675a.m10421l().m249h());
                sb.append(" not verified:\n              |    certificate: ");
                sb.append(C2087n4.f6294d.m8729a(x509Certificate));
                sb.append("\n              |    DN: ");
                Principal subjectDN = x509Certificate.getSubjectDN();
                AbstractC0116Ce.m475d(subjectDN, "cert.subjectDN");
                sb.append(subjectDN.getName());
                sb.append("\n              |    subjectAltNames: ");
                sb.append(C0395Ih.f1155a.m1703a(x509Certificate));
                sb.append("\n              ");
                throw new SSLPeerUnverifiedException(AbstractC0216Em.m1074e(sb.toString(), null, 1, null));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    C0764Qi.f2268c.m3690g().mo3675b(sSLSocket);
                }
                if (sSLSocket != null) {
                    AbstractC2623yo.m10936k(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void m7621j(int i, int i2, int i3, InterfaceC0418J3 interfaceC0418J3, AbstractC1918ja abstractC1918ja) throws IOException {
        Request requestM7623L = m7623l();
        C0069Bd c0069BdM498i = requestM7623L.getUrl();
        for (int i4 = 0; i4 < 21; i4++) {
            m7619h(i, i2, interfaceC0418J3, abstractC1918ja);
            requestM7623L = m7622k(i2, i3, requestM7623L, c0069BdM498i);
            if (requestM7623L == null) {
                return;
            }
            Socket socket = this.f5512c;
            if (socket != null) {
                AbstractC2623yo.m10936k(socket);
            }
            this.f5512c = null;
            this.f5518i = null;
            this.f5517h = null;
            abstractC1918ja.m8138g(interfaceC0418J3, this.f5528s.m5678d(), this.f5528s.m5676b(), null);
        }
    }

    public final Request m7622k(int i, int i2, Request request, C0069Bd c0069Bd) throws IOException {
        String str = "CONNECT " + AbstractC2623yo.m10916L(c0069Bd, true) + " HTTP/1.1";
        while (true) {
            InterfaceC2547x3 interfaceC2547x3 = this.f5517h;
            AbstractC0116Ce.m473b(interfaceC2547x3);
            InterfaceC2501w3 interfaceC2501w3 = this.f5518i;
            AbstractC0116Ce.m473b(interfaceC2501w3);
            C2336sd c2336sd = new C2336sd(null, this, interfaceC2547x3, interfaceC2501w3);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            interfaceC2547x3.mo239d().mo439g(i, timeUnit);
            interfaceC2501w3.mo114d().mo439g(i2, timeUnit);
            c2336sd.m9552A(request.m494e(), str);
            c2336sd.mo9532c();
            Response.a aVarMo9534e = c2336sd.mo9534e(false);
            AbstractC0116Ce.m473b(aVarMo9534e);
            Response c0490KkM2404c = aVarMo9534e.m2419r(request).m2404c();
            c2336sd.m9561z(c0490KkM2404c);
            int iM2396j = c0490KkM2404c.getStatus();
            if (iM2396j == 200) {
                if (interfaceC2547x3.mo7341c().mo7333K() && interfaceC2501w3.mo5929c().mo7333K()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iM2396j != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + c0490KkM2404c.getStatus());
            }
            Request requestMo2575A = this.f5528s.m5675a().m10417h().mo2575a(this.f5528s, c0490KkM2404c);
            if (requestMo2575A == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (AbstractC0538Lm.m2720l("close", Response.m2383w(c0490KkM2404c, "Connection", null, 2, null), true)) {
                return requestMo2575A;
            }
            request = requestMo2575A;
        }
    }

    public final Request m7623l() {
        Request requestM500B = new Request.a().m506h(this.f5528s.m5675a().m10421l()).m503e("CONNECT", null).m501c("Host", AbstractC2623yo.m10916L(this.f5528s.m5675a().m10421l(), true)).m501c("Proxy-Connection", "Keep-Alive").m501c("User-Agent", "okhttp/4.9.1").m500b();
        Request requestMo2575A = this.f5528s.m5675a().m10417h().mo2575a(this.f5528s, new Response.a().m2419r(requestM500B).m2417p(EnumC2342sj.HTTP_1_1).m2408g(407).m2414m("Preemptive Authenticate").m2403b(AbstractC2623yo.f8129c).m2420s(-1L).m2418q(-1L).m2411j("Proxy-Authenticate", "OkHttp-Preemptive").m2404c());
        return requestMo2575A != null ? requestMo2575A : requestM500B;
    }

    public final void m7624m(C1858i6 c1858i6, int i, InterfaceC0418J3 interfaceC0418J3, AbstractC1918ja abstractC1918ja) throws Throwable {
        if (this.f5528s.m5675a().m10420k() != null) {
            abstractC1918ja.m8131B(interfaceC0418J3);
            m7620i(c1858i6);
            abstractC1918ja.m8130A(interfaceC0418J3, this.f5514e);
            if (this.f5515f == EnumC2342sj.HTTP_2) {
                m7610E(i);
                return;
            }
            return;
        }
        List listM10415f = this.f5528s.m5675a().m10415f();
        EnumC2342sj enumC2342sj = EnumC2342sj.H2_PRIOR_KNOWLEDGE;
        if (!listM10415f.contains(enumC2342sj)) {
            this.f5513d = this.f5512c;
            this.f5515f = EnumC2342sj.HTTP_1_1;
        } else {
            this.f5513d = this.f5512c;
            this.f5515f = enumC2342sj;
            m7610E(i);
        }
    }

    public final List m7625n() {
        return this.f5525p;
    }

    public final long m7626o() {
        return this.f5526q;
    }

    public final boolean m7627p() {
        return this.f5519j;
    }

    public final int m7628q() {
        return this.f5521l;
    }

    public C0941Uc m7629r() {
        return this.f5514e;
    }

    public final synchronized void m7630s() {
        this.f5522m++;
    }

    public final boolean m7631t(C2498w0 c2498w0, List list) {
        AbstractC0116Ce.m476e(c2498w0, "address");
        if (AbstractC2623yo.f8134h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (this.f5525p.size() >= this.f5524o || this.f5519j || !this.f5528s.m5675a().m10413d(c2498w0)) {
            return false;
        }
        if (AbstractC0116Ce.m472a(c2498w0.m10421l().m249h(), m7637z().m5675a().m10421l().m249h())) {
            return true;
        }
        if (this.f5516g == null || list == null || !m7606A(list) || c2498w0.m10414e() != C0395Ih.f1155a || !m7611F(c2498w0.m10421l())) {
            return false;
        }
        try {
            C2087n4 c2087n4M10410a = c2498w0.m10410a();
            AbstractC0116Ce.m473b(c2087n4M10410a);
            String strM249h = c2498w0.m10421l().m249h();
            C0941Uc c0941UcM7629r = m7629r();
            AbstractC0116Ce.m473b(c0941UcM7629r);
            c2087n4M10410a.m8723a(strM249h, c0941UcM7629r.m4246d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public String toString() {
        Object objM4243a;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f5528s.m5675a().m10421l().m249h());
        sb.append(':');
        sb.append(this.f5528s.m5675a().m10421l().m253l());
        sb.append(',');
        sb.append(" proxy=");
        sb.append(this.f5528s.m5676b());
        sb.append(" hostAddress=");
        sb.append(this.f5528s.m5678d());
        sb.append(" cipherSuite=");
        C0941Uc c0941Uc = this.f5514e;
        if (c0941Uc == null || (objM4243a = c0941Uc.m4243a()) == null) {
            objM4243a = "none";
        }
        sb.append(objM4243a);
        sb.append(" protocol=");
        sb.append(this.f5515f);
        sb.append('}');
        return sb.toString();
    }

    public final boolean m7632u(boolean z) {
        long j;
        if (AbstractC2623yo.f8134h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.f5512c;
        AbstractC0116Ce.m473b(socket);
        Socket socket2 = this.f5513d;
        AbstractC0116Ce.m473b(socket2);
        InterfaceC2547x3 interfaceC2547x3 = this.f5517h;
        AbstractC0116Ce.m473b(interfaceC2547x3);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        C2428ud c2428ud = this.f5516g;
        if (c2428ud != null) {
            return c2428ud.m10044g0(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.f5526q;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        return AbstractC2623yo.m10907C(socket2, interfaceC2547x3);
    }

    public final boolean m7633v() {
        return this.f5516g != null;
    }

    public final InterfaceC2333sa m7634w(OkHttpClient okHttpClient, C1882ik c1882ik) throws SocketException {
        AbstractC0116Ce.m476e(okHttpClient, "client");
        AbstractC0116Ce.m476e(c1882ik, "chain");
        Socket socket = this.f5513d;
        AbstractC0116Ce.m473b(socket);
        InterfaceC2547x3 interfaceC2547x3 = this.f5517h;
        AbstractC0116Ce.m473b(interfaceC2547x3);
        InterfaceC2501w3 interfaceC2501w3 = this.f5518i;
        AbstractC0116Ce.m473b(interfaceC2501w3);
        C2428ud c2428ud = this.f5516g;
        if (c2428ud != null) {
            return new C2474vd(okHttpClient, this, c1882ik, c2428ud);
        }
        socket.setSoTimeout(c1882ik.m7975k());
        C0125Cn c0125CnMo239d = interfaceC2547x3.mo239d();
        long jM7972h = c1882ik.m7972h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c0125CnMo239d.mo439g(jM7972h, timeUnit);
        interfaceC2501w3.mo114d().mo439g(c1882ik.m7974j(), timeUnit);
        return new C2336sd(okHttpClient, this, interfaceC2547x3, interfaceC2501w3);
    }

    public final synchronized void m7635x() {
        this.f5520k = true;
    }

    public final synchronized void m7636y() {
        this.f5519j = true;
    }

    public C1328bl m7637z() {
        return this.f5528s;
    }
}
