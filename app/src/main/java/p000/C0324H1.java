package p000;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class C0324H1 extends C0125Cn {

    public static final long f998i;

    public static final long f999j;

    public static C0324H1 f1000k;

    public static final a f1001l = new a(null);

    public boolean f1002f;

    public C0324H1 f1003g;

    public long f1004h;

    public static final class a {
        public a() {
        }

        public final C0324H1 m1483c() throws InterruptedException {
            C0324H1 c0324h1 = C0324H1.f1000k;
            AbstractC0116Ce.m473b(c0324h1);
            C0324H1 c0324h12 = c0324h1.f1003g;
            long jNanoTime = System.nanoTime();
            if (c0324h12 == null) {
                C0324H1.class.wait(C0324H1.f998i);
                C0324H1 c0324h13 = C0324H1.f1000k;
                AbstractC0116Ce.m473b(c0324h13);
                if (c0324h13.f1003g != null || System.nanoTime() - jNanoTime < C0324H1.f999j) {
                    return null;
                }
                return C0324H1.f1000k;
            }
            long jM1477u = c0324h12.m1477u(jNanoTime);
            if (jM1477u > 0) {
                long j = jM1477u / 1000000;
                C0324H1.class.wait(j, (int) (jM1477u - (1000000 * j)));
                return null;
            }
            C0324H1 c0324h14 = C0324H1.f1000k;
            AbstractC0116Ce.m473b(c0324h14);
            c0324h14.f1003g = c0324h12.f1003g;
            c0324h12.f1003g = null;
            return c0324h12;
        }

        public final boolean m1484d(C0324H1 c0324h1) {
            synchronized (C0324H1.class) {
                for (C0324H1 c0324h12 = C0324H1.f1000k; c0324h12 != null; c0324h12 = c0324h12.f1003g) {
                    if (c0324h12.f1003g == c0324h1) {
                        c0324h12.f1003g = c0324h1.f1003g;
                        c0324h1.f1003g = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0053 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x001c, B:12:0x0028, B:13:0x0031, B:18:0x0042, B:19:0x004a, B:21:0x0053, B:24:0x0063, B:25:0x0068, B:27:0x0078, B:28:0x007d, B:17:0x003b, B:31:0x0081, B:32:0x0086), top: B:35:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0078 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x001c, B:12:0x0028, B:13:0x0031, B:18:0x0042, B:19:0x004a, B:21:0x0053, B:24:0x0063, B:25:0x0068, B:27:0x0078, B:28:0x007d, B:17:0x003b, B:31:0x0081, B:32:0x0086), top: B:35:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0068 A[EDGE_INSN: B:36:0x0068->B:25:0x0068 BREAK  A[LOOP:0: B:19:0x004a->B:24:0x0063], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m1485e(C0324H1 r6, long r7, boolean r9) {
            /*
                r5 = this;
                java.lang.Class<H1> r0 = p000.C0324H1.class
                monitor-enter(r0)
                H1 r1 = p000.C0324H1.m1465i()     // Catch: java.lang.Throwable -> L1a
                if (r1 != 0) goto L1c
                H1 r1 = new H1     // Catch: java.lang.Throwable -> L1a
                r1.<init>()     // Catch: java.lang.Throwable -> L1a
                p000.C0324H1.m1470o(r1)     // Catch: java.lang.Throwable -> L1a
                H1$b r1 = new H1$b     // Catch: java.lang.Throwable -> L1a
                r1.<init>()     // Catch: java.lang.Throwable -> L1a
                r1.start()     // Catch: java.lang.Throwable -> L1a
                goto L1c
            L1a:
                r6 = move-exception
                goto L87
            L1c:
                long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L1a
                r3 = 0
                int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r3 == 0) goto L36
                if (r9 == 0) goto L36
                long r3 = r6.mo435c()     // Catch: java.lang.Throwable -> L1a
                long r3 = r3 - r1
                long r7 = java.lang.Math.min(r7, r3)     // Catch: java.lang.Throwable -> L1a
            L31:
                long r7 = r7 + r1
                p000.C0324H1.m1472q(r6, r7)     // Catch: java.lang.Throwable -> L1a
                goto L42
            L36:
                if (r3 == 0) goto L39
                goto L31
            L39:
                if (r9 == 0) goto L81
                long r7 = r6.mo435c()     // Catch: java.lang.Throwable -> L1a
                p000.C0324H1.m1472q(r6, r7)     // Catch: java.lang.Throwable -> L1a
            L42:
                long r7 = p000.C0324H1.m1469n(r6, r1)     // Catch: java.lang.Throwable -> L1a
                H1 r9 = p000.C0324H1.m1465i()     // Catch: java.lang.Throwable -> L1a
            L4a:
                p000.AbstractC0116Ce.m473b(r9)     // Catch: java.lang.Throwable -> L1a
                H1 r3 = p000.C0324H1.m1468l(r9)     // Catch: java.lang.Throwable -> L1a
                if (r3 == 0) goto L68
                H1 r3 = p000.C0324H1.m1468l(r9)     // Catch: java.lang.Throwable -> L1a
                p000.AbstractC0116Ce.m473b(r3)     // Catch: java.lang.Throwable -> L1a
                long r3 = p000.C0324H1.m1469n(r3, r1)     // Catch: java.lang.Throwable -> L1a
                int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r3 >= 0) goto L63
                goto L68
            L63:
                H1 r9 = p000.C0324H1.m1468l(r9)     // Catch: java.lang.Throwable -> L1a
                goto L4a
            L68:
                H1 r7 = p000.C0324H1.m1468l(r9)     // Catch: java.lang.Throwable -> L1a
                p000.C0324H1.m1471p(r6, r7)     // Catch: java.lang.Throwable -> L1a
                p000.C0324H1.m1471p(r9, r6)     // Catch: java.lang.Throwable -> L1a
                H1 r6 = p000.C0324H1.m1465i()     // Catch: java.lang.Throwable -> L1a
                if (r9 != r6) goto L7d
                java.lang.Class<H1> r6 = p000.C0324H1.class
                r6.notify()     // Catch: java.lang.Throwable -> L1a
            L7d:
                no r6 = p000.C2116no.f6480a     // Catch: java.lang.Throwable -> L1a
                monitor-exit(r0)
                return
            L81:
                java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L1a
                r6.<init>()     // Catch: java.lang.Throwable -> L1a
                throw r6     // Catch: java.lang.Throwable -> L1a
            L87:
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0324H1.a.m1485e(H1, long, boolean):void");
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override
        public void run() {
            C0324H1 c0324h1M1483c;
            while (true) {
                try {
                    synchronized (C0324H1.class) {
                        c0324h1M1483c = C0324H1.f1001l.m1483c();
                        if (c0324h1M1483c == C0324H1.f1000k) {
                            C0324H1.f1000k = null;
                            return;
                        }
                        C2116no c2116no = C2116no.f6480a;
                    }
                    if (c0324h1M1483c != null) {
                        c0324h1M1483c.mo1480x();
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
            }
        }
    }

    public static final class c implements InterfaceC1134Yl {

        public final InterfaceC1134Yl f1006m;

        public c(InterfaceC1134Yl interfaceC1134Yl) {
            this.f1006m = interfaceC1134Yl;
        }

        @Override
        public C0324H1 mo114d() {
            return C0324H1.this;
        }

        @Override
        public void close() throws IOException {
            C0324H1 c0324h1 = C0324H1.this;
            c0324h1.m1474r();
            try {
                this.f1006m.close();
                C2116no c2116no = C2116no.f6480a;
                if (c0324h1.m1475s()) {
                    throw c0324h1.m1473m(null);
                }
            } catch (IOException e) {
                if (!c0324h1.m1475s()) {
                    throw e;
                }
                throw c0324h1.m1473m(e);
            } finally {
                c0324h1.m1475s();
            }
        }

        @Override
        public void flush() throws IOException {
            C0324H1 c0324h1 = C0324H1.this;
            c0324h1.m1474r();
            try {
                this.f1006m.flush();
                C2116no c2116no = C2116no.f6480a;
                if (c0324h1.m1475s()) {
                    throw c0324h1.m1473m(null);
                }
            } catch (IOException e) {
                if (!c0324h1.m1475s()) {
                    throw e;
                }
                throw c0324h1.m1473m(e);
            } finally {
                c0324h1.m1475s();
            }
        }

        @Override
        public void mo115h(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "source");
            AbstractC1342c.m5685b(c2409u3.m9911Y(), 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                C2482vl c2482vl = c2409u3.f7345l;
                while (true) {
                    AbstractC0116Ce.m473b(c2482vl);
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += c2482vl.f7760c - c2482vl.f7759b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    c2482vl = c2482vl.f7763f;
                }
                C0324H1 c0324h1 = C0324H1.this;
                c0324h1.m1474r();
                try {
                    this.f1006m.mo115h(c2409u3, j2);
                    C2116no c2116no = C2116no.f6480a;
                    if (c0324h1.m1475s()) {
                        throw c0324h1.m1473m(null);
                    }
                    j -= j2;
                } catch (IOException e) {
                    if (!c0324h1.m1475s()) {
                        throw e;
                    }
                    throw c0324h1.m1473m(e);
                } finally {
                    c0324h1.m1475s();
                }
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f1006m + ')';
        }
    }

    public static final class d implements InterfaceC2161om {

        public final InterfaceC2161om f1008m;

        public d(InterfaceC2161om interfaceC2161om) {
            this.f1008m = interfaceC2161om;
        }

        @Override
        public C0324H1 mo239d() {
            return C0324H1.this;
        }

        @Override
        public void close() throws IOException {
            C0324H1 c0324h1 = C0324H1.this;
            c0324h1.m1474r();
            try {
                this.f1008m.close();
                C2116no c2116no = C2116no.f6480a;
                if (c0324h1.m1475s()) {
                    throw c0324h1.m1473m(null);
                }
            } catch (IOException e) {
                if (!c0324h1.m1475s()) {
                    throw e;
                }
                throw c0324h1.m1473m(e);
            } finally {
                c0324h1.m1475s();
            }
        }

        @Override
        public long mo1488n(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "sink");
            C0324H1 c0324h1 = C0324H1.this;
            c0324h1.m1474r();
            try {
                long jMo1488n = this.f1008m.mo1488n(c2409u3, j);
                if (c0324h1.m1475s()) {
                    throw c0324h1.m1473m(null);
                }
                return jMo1488n;
            } catch (IOException e) {
                if (c0324h1.m1475s()) {
                    throw c0324h1.m1473m(e);
                }
                throw e;
            } finally {
                c0324h1.m1475s();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f1008m + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f998i = millis;
        f999j = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final IOException m1473m(IOException iOException) {
        return mo1476t(iOException);
    }

    public final void m1474r() {
        if (!(!this.f1002f)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long jM509h = m509h();
        boolean zMo437e = mo437e();
        if (jM509h != 0 || zMo437e) {
            this.f1002f = true;
            f1001l.m1485e(this, jM509h, zMo437e);
        }
    }

    public final boolean m1475s() {
        if (!this.f1002f) {
            return false;
        }
        this.f1002f = false;
        return f1001l.m1484d(this);
    }

    public IOException mo1476t(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long m1477u(long j) {
        return this.f1004h - j;
    }

    public final InterfaceC1134Yl m1478v(InterfaceC1134Yl interfaceC1134Yl) {
        AbstractC0116Ce.m476e(interfaceC1134Yl, "sink");
        return new c(interfaceC1134Yl);
    }

    public final InterfaceC2161om m1479w(InterfaceC2161om interfaceC2161om) {
        AbstractC0116Ce.m476e(interfaceC2161om, "source");
        return new d(interfaceC2161om);
    }

    public void mo1480x() {
    }
}
