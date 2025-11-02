package p000;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class C1694ek implements InterfaceC0418J3 {

    public final OkHttpClient f5431A;

    public final C0122Ck f5432B;

    public final boolean f5433C;

    public final C1835hk f5434l;

    public final AbstractC1918ja f5435m;

    public final c f5436n;

    public final AtomicBoolean f5437o;

    public Object f5438p;

    public C2379ta f5439q;

    public C1741fk f5440r;

    public boolean f5441s;

    public C2287ra f5442t;

    public boolean f5443u;

    public boolean f5444v;

    public boolean f5445w;

    public volatile boolean f5446x;

    public volatile C2287ra f5447y;

    public volatile C1741fk f5448z;

    public final class a implements Runnable {

        public volatile AtomicInteger f5449l;

        public final InterfaceC0556M3 f5450m;

        public final C1694ek f5451n;

        public a(C1694ek c1694ek, InterfaceC0556M3 interfaceC0556M3) {
            AbstractC0116Ce.m476e(interfaceC0556M3, "responseCallback");
            this.f5451n = c1694ek;
            this.f5450m = interfaceC0556M3;
            this.f5449l = new AtomicInteger(0);
        }

        public final void m7454a(ExecutorService executorService) {
            AbstractC0116Ce.m476e(executorService, "executorService");
            C1112Y8 c1112y8M1995o = this.f5451n.m7442n().m1995o();
            if (AbstractC2623yo.f8134h && Thread.holdsLock(c1112y8M1995o)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c1112y8M1995o);
                throw new AssertionError(sb.toString());
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.f5451n.m7452y(interruptedIOException);
                    this.f5450m.mo1181b(this.f5451n, interruptedIOException);
                    this.f5451n.m7442n().m1995o().m4879f(this);
                }
            } catch (Throwable th) {
                this.f5451n.m7442n().m1995o().m4879f(this);
                throw th;
            }
        }

        public final C1694ek m7455b() {
            return this.f5451n;
        }

        public final AtomicInteger m7456c() {
            return this.f5449l;
        }

        public final String m7457d() {
            return this.f5451n.m7447t().m498i().m249h();
        }

        public final void m7458e(a aVar) {
            AbstractC0116Ce.m476e(aVar, "other");
            this.f5449l = aVar.f5449l;
        }

        @Override
        public void run() {
            boolean z;
            Throwable th;
            IOException e;
            C1112Y8 c1112y8M1995o;
            String str = "OkHttp " + this.f5451n.m7453z();
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "currentThread");
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                this.f5451n.f5436n.m1474r();
                try {
                    try {
                        z = true;
                    } catch (IOException e2) {
                        z = false;
                        e = e2;
                    } catch (Throwable th2) {
                        z = false;
                        th = th2;
                    }
                    try {
                        this.f5450m.mo1180a(this.f5451n, this.f5451n.m7448u());
                        c1112y8M1995o = this.f5451n.m7442n().m1995o();
                    } catch (IOException e3) {
                        e = e3;
                        if (z) {
                            C0764Qi.f2268c.m3690g().m3679j("Callback failure for " + this.f5451n.m7434F(), 4, e);
                        } else {
                            this.f5450m.mo1181b(this.f5451n, e);
                        }
                        c1112y8M1995o = this.f5451n.m7442n().m1995o();
                        c1112y8M1995o.m4879f(this);
                    } catch (Throwable th3) {
                        th = th3;
                        this.f5451n.cancel();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            AbstractC2241qa.m9151a(iOException, th);
                            this.f5450m.mo1181b(this.f5451n, iOException);
                        }
                        throw th;
                    }
                    c1112y8M1995o.m4879f(this);
                } catch (Throwable th4) {
                    this.f5451n.m7442n().m1995o().m4879f(this);
                    throw th4;
                }
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    public static final class b extends WeakReference {

        public final Object f5452a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C1694ek c1694ek, Object obj) {
            super(c1694ek);
            AbstractC0116Ce.m476e(c1694ek, "referent");
            this.f5452a = obj;
        }

        public final Object m7459a() {
            return this.f5452a;
        }
    }

    public static final class c extends C0324H1 {
        public c() {
        }

        @Override
        public void mo1480x() {
            C1694ek.this.cancel();
        }
    }

    public C1694ek(OkHttpClient okHttpClient, C0122Ck c0122Ck, boolean z) {
        AbstractC0116Ce.m476e(okHttpClient, "client");
        AbstractC0116Ce.m476e(c0122Ck, "originalRequest");
        this.f5431A = okHttpClient;
        this.f5432B = c0122Ck;
        this.f5433C = z;
        this.f5434l = okHttpClient.m1992j().m7389a();
        this.f5435m = okHttpClient.m1997r().mo8158a(this);
        c cVar = new c();
        cVar.mo439g(okHttpClient.m1989e(), TimeUnit.MILLISECONDS);
        C2116no c2116no = C2116no.f6480a;
        this.f5436n = cVar;
        this.f5437o = new AtomicBoolean();
        this.f5445w = true;
    }

    public final Socket m7429A() {
        C1741fk c1741fk = this.f5440r;
        AbstractC0116Ce.m473b(c1741fk);
        if (AbstractC2623yo.f8134h && !Thread.holdsLock(c1741fk)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(c1741fk);
            throw new AssertionError(sb.toString());
        }
        List listM7625n = c1741fk.m7625n();
        Iterator it = listM7625n.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (AbstractC0116Ce.m472a((C1694ek) ((Reference) it.next()).get(), this)) {
                break;
            }
            i++;
        }
        if (!(i != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        listM7625n.remove(i);
        this.f5440r = null;
        if (listM7625n.isEmpty()) {
            c1741fk.m7607B(System.nanoTime());
            if (this.f5434l.m7846c(c1741fk)) {
                return c1741fk.m7609D();
            }
        }
        return null;
    }

    public final boolean m7430B() {
        C2379ta c2379ta = this.f5439q;
        AbstractC0116Ce.m473b(c2379ta);
        return c2379ta.m9697e();
    }

    public final void m7431C(C1741fk c1741fk) {
        this.f5448z = c1741fk;
    }

    public final void m7432D() {
        if (!(!this.f5441s)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f5441s = true;
        this.f5436n.m1475s();
    }

    public final IOException m7433E(IOException iOException) {
        if (this.f5441s || !this.f5436n.m1475s()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final String m7434F() {
        StringBuilder sb = new StringBuilder();
        sb.append(m7450w() ? "canceled " : "");
        sb.append(this.f5433C ? "web socket" : "call");
        sb.append(" to ");
        sb.append(m7453z());
        return sb.toString();
    }

    public final void m7435c(C1741fk c1741fk) {
        AbstractC0116Ce.m476e(c1741fk, "connection");
        if (!AbstractC2623yo.f8134h || Thread.holdsLock(c1741fk)) {
            if (!(this.f5440r == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.f5440r = c1741fk;
            c1741fk.m7625n().add(new b(this, this.f5438p));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(c1741fk);
        throw new AssertionError(sb.toString());
    }

    @Override
    public void cancel() {
        if (this.f5446x) {
            return;
        }
        this.f5446x = true;
        C2287ra c2287ra = this.f5447y;
        if (c2287ra != null) {
            c2287ra.m9361b();
        }
        C1741fk c1741fk = this.f5448z;
        if (c1741fk != null) {
            c1741fk.m7615d();
        }
        this.f5435m.m8137f(this);
    }

    public final IOException m7436d(IOException iOException) throws IOException {
        Socket socketM7429A;
        boolean z = AbstractC2623yo.f8134h;
        if (z && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        C1741fk c1741fk = this.f5440r;
        if (c1741fk != null) {
            if (z && Thread.holdsLock(c1741fk)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread threadCurrentThread2 = Thread.currentThread();
                AbstractC0116Ce.m475d(threadCurrentThread2, "Thread.currentThread()");
                sb2.append(threadCurrentThread2.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(c1741fk);
                throw new AssertionError(sb2.toString());
            }
            synchronized (c1741fk) {
                socketM7429A = m7429A();
            }
            if (this.f5440r == null) {
                if (socketM7429A != null) {
                    AbstractC2623yo.m10936k(socketM7429A);
                }
                this.f5435m.m8142k(this, c1741fk);
            } else {
                if (!(socketM7429A == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        IOException iOExceptionM7433E = m7433E(iOException);
        if (iOException != null) {
            AbstractC1918ja abstractC1918ja = this.f5435m;
            AbstractC0116Ce.m473b(iOExceptionM7433E);
            abstractC1918ja.m8135d(this, iOExceptionM7433E);
        } else {
            this.f5435m.m8134c(this);
        }
        return iOExceptionM7433E;
    }

    public final void m7437e() {
        this.f5438p = C0764Qi.f2268c.m3690g().mo3678h("response.body().close()");
        this.f5435m.m8136e(this);
    }

    public C1694ek clone() {
        return new C1694ek(this.f5431A, this.f5432B, this.f5433C);
    }

    @Override
    public C0490Kk mo1790g() {
        if (!this.f5437o.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.f5436n.m1474r();
        m7437e();
        try {
            this.f5431A.m1995o().m4875b(this);
            return m7448u();
        } finally {
            this.f5431A.m1995o().m4880g(this);
        }
    }

    public final C2498w0 m7439h(C0069Bd c0069Bd) {
        SSLSocketFactory sSLSocketFactoryM1984H;
        HostnameVerifier hostnameVerifierM2001v;
        C2087n4 c2087n4M1990f;
        if (c0069Bd.m250i()) {
            sSLSocketFactoryM1984H = this.f5431A.m1984H();
            hostnameVerifierM2001v = this.f5431A.m2001v();
            c2087n4M1990f = this.f5431A.m1990f();
        } else {
            sSLSocketFactoryM1984H = null;
            hostnameVerifierM2001v = null;
            c2087n4M1990f = null;
        }
        return new C2498w0(c0069Bd.m249h(), c0069Bd.m253l(), this.f5431A.m1996q(), this.f5431A.m1983G(), sSLSocketFactoryM1984H, hostnameVerifierM2001v, c2087n4M1990f, this.f5431A.m1979C(), this.f5431A.m1978B(), this.f5431A.m1977A(), this.f5431A.m1993m(), this.f5431A.m1980D());
    }

    @Override
    public void mo1791i(InterfaceC0556M3 interfaceC0556M3) {
        AbstractC0116Ce.m476e(interfaceC0556M3, "responseCallback");
        if (!this.f5437o.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        m7437e();
        this.f5431A.m1995o().m4874a(new a(this, interfaceC0556M3));
    }

    public final void m7440j(C0122Ck c0122Ck, boolean z) {
        AbstractC0116Ce.m476e(c0122Ck, "request");
        if (!(this.f5442t == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.f5444v)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.f5443u)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            C2116no c2116no = C2116no.f6480a;
        }
        if (z) {
            this.f5439q = new C2379ta(this.f5434l, m7439h(c0122Ck.m498i()), this, this.f5435m);
        }
    }

    public final void m7441m(boolean z) {
        C2287ra c2287ra;
        synchronized (this) {
            if (!this.f5445w) {
                throw new IllegalStateException("released".toString());
            }
            C2116no c2116no = C2116no.f6480a;
        }
        if (z && (c2287ra = this.f5447y) != null) {
            c2287ra.m9363d();
        }
        this.f5442t = null;
    }

    public final OkHttpClient m7442n() {
        return this.f5431A;
    }

    public final C1741fk m7443o() {
        return this.f5440r;
    }

    public final AbstractC1918ja m7444q() {
        return this.f5435m;
    }

    public final boolean m7445r() {
        return this.f5433C;
    }

    public final C2287ra m7446s() {
        return this.f5442t;
    }

    public final C0122Ck m7447t() {
        return this.f5432B;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C0490Kk m7448u() throws Throwable {
        /*
            r12 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            Jh r0 = r12.f5431A
            java.util.List r0 = r0.m2002w()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            p000.AbstractC2042m5.m8435p(r2, r0)
            Uk r0 = new Uk
            Jh r1 = r12.f5431A
            r0.<init>(r1)
            r2.add(r0)
            W2 r0 = new W2
            Jh r1 = r12.f5431A
            B6 r1 = r1.m1994n()
            r0.<init>(r1)
            r2.add(r0)
            H3 r0 = new H3
            Jh r1 = r12.f5431A
            r1.m1988d()
            r9 = 0
            r0.<init>(r9)
            r2.add(r0)
            c6 r0 = p000.C1349c6.f3919a
            r2.add(r0)
            boolean r0 = r12.f5433C
            if (r0 != 0) goto L4a
            Jh r0 = r12.f5431A
            java.util.List r0 = r0.m2003x()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            p000.AbstractC2042m5.m8435p(r2, r0)
        L4a:
            K3 r0 = new K3
            boolean r1 = r12.f5433C
            r0.<init>(r1)
            r2.add(r0)
            ik r10 = new ik
            Ck r5 = r12.f5432B
            Jh r0 = r12.f5431A
            int r6 = r0.m1991h()
            Jh r0 = r12.f5431A
            int r7 = r0.m1981E()
            Jh r0 = r12.f5431A
            int r8 = r0.m1986J()
            r3 = 0
            r4 = 0
            r0 = r10
            r1 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            Ck r1 = r12.f5432B     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            Kk r1 = r10.mo304b(r1)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            boolean r2 = r12.m7450w()     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            if (r2 != 0) goto L82
            r12.m7452y(r9)
            return r1
        L82:
            p000.AbstractC2623yo.m10935j(r1)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            java.lang.String r2 = "Canceled"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
            throw r1     // Catch: java.lang.Throwable -> L8d java.io.IOException -> L8f
        L8d:
            r1 = move-exception
            goto La5
        L8f:
            r0 = move-exception
            r1 = 1
            java.io.IOException r0 = r12.m7452y(r0)     // Catch: java.lang.Throwable -> L9f
            if (r0 != 0) goto La4
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Throwable"
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L9f
            throw r0     // Catch: java.lang.Throwable -> L9f
        L9f:
            r0 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
            goto La5
        La4:
            throw r0     // Catch: java.lang.Throwable -> L9f
        La5:
            if (r0 != 0) goto Laa
            r12.m7452y(r9)
        Laa:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1694ek.m7448u():Kk");
    }

    public final C2287ra m7449v(C1882ik c1882ik) throws IOException {
        AbstractC0116Ce.m476e(c1882ik, "chain");
        synchronized (this) {
            if (!this.f5445w) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.f5444v)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.f5443u)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            C2116no c2116no = C2116no.f6480a;
        }
        C2379ta c2379ta = this.f5439q;
        AbstractC0116Ce.m473b(c2379ta);
        C2287ra c2287ra = new C2287ra(this, this.f5435m, c2379ta, c2379ta.m9693a(this.f5431A, c1882ik));
        this.f5442t = c2287ra;
        this.f5447y = c2287ra;
        synchronized (this) {
            this.f5443u = true;
            this.f5444v = true;
        }
        if (this.f5446x) {
            throw new IOException("Canceled");
        }
        return c2287ra;
    }

    public boolean m7450w() {
        return this.f5446x;
    }

    public final IOException m7451x(C2287ra c2287ra, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        AbstractC0116Ce.m476e(c2287ra, "exchange");
        boolean z4 = true;
        if (!AbstractC0116Ce.m472a(c2287ra, this.f5447y)) {
            return iOException;
        }
        synchronized (this) {
            z3 = false;
            if (z) {
                try {
                    if (!this.f5443u) {
                        if (z2 || !this.f5444v) {
                            z4 = false;
                        }
                    }
                    if (z) {
                        this.f5443u = false;
                    }
                    if (z2) {
                        this.f5444v = false;
                    }
                    boolean z5 = this.f5443u;
                    boolean z6 = (z5 || this.f5444v) ? false : true;
                    if (z5 || this.f5444v || this.f5445w) {
                        z4 = false;
                    }
                    z3 = z6;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z2) {
                }
                z4 = false;
            }
            C2116no c2116no = C2116no.f6480a;
        }
        if (z3) {
            this.f5447y = null;
            C1741fk c1741fk = this.f5440r;
            if (c1741fk != null) {
                c1741fk.m7630s();
            }
        }
        return z4 ? m7436d(iOException) : iOException;
    }

    public final IOException m7452y(IOException iOException) {
        boolean z;
        synchronized (this) {
            try {
                z = false;
                if (this.f5445w) {
                    this.f5445w = false;
                    if (!this.f5443u && !this.f5444v) {
                        z = true;
                    }
                }
                C2116no c2116no = C2116no.f6480a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z ? m7436d(iOException) : iOException;
    }

    public final String m7453z() {
        return this.f5432B.m498i().m255n();
    }
}
