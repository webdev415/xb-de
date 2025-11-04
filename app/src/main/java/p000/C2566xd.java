package p000;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;

public final class C2566xd {

    public static final a f7976o = new a(null);

    public long f7977a;

    public long f7978b;

    public long f7979c;

    public long f7980d;

    public final ArrayDeque f7981e;

    public boolean f7982f;

    public final c f7983g;

    public final b f7984h;

    public final d f7985i;

    public final d f7986j;

    public EnumC1159Z9 f7987k;

    public IOException f7988l;

    public final int f7989m;

    public final C2428ud f7990n;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public final class b implements InterfaceC1134Yl {

        public final C2409u3 f7991l = new C2409u3();

        public Headers f7992m;

        public boolean f7993n;

        public boolean f7994o;

        public b(boolean z) {
            this.f7994o = z;
        }

        public final void m10706a(boolean z) throws IOException {
            long jMin;
            boolean z2;
            synchronized (C2566xd.this) {
                try {
                    C2566xd.this.m10698s().m1474r();
                    while (C2566xd.this.m10697r() >= C2566xd.this.m10696q() && !this.f7994o && !this.f7993n && C2566xd.this.m10687h() == null) {
                        try {
                            C2566xd.this.m10678D();
                        } finally {
                        }
                    }
                    C2566xd.this.m10698s().m10715y();
                    C2566xd.this.m10682c();
                    jMin = Math.min(C2566xd.this.m10696q() - C2566xd.this.m10697r(), this.f7991l.m9911Y());
                    C2566xd c2566xd = C2566xd.this;
                    c2566xd.m10676B(c2566xd.m10697r() + jMin);
                    z2 = z && jMin == this.f7991l.m9911Y() && C2566xd.this.m10687h() == null;
                    C2116no c2116no = C2116no.f6480a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            C2566xd.this.m10698s().m1474r();
            try {
                C2566xd.this.m10686g().m10059w0(C2566xd.this.m10689j(), z2, this.f7991l, jMin);
            } finally {
            }
        }

        public final boolean m10707b() {
            return this.f7993n;
        }

        @Override
        public void close() throws IOException {
            C2566xd c2566xd = C2566xd.this;
            if (AbstractC2623yo.f8134h && Thread.holdsLock(c2566xd)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c2566xd);
                throw new AssertionError(sb.toString());
            }
            synchronized (C2566xd.this) {
                if (this.f7993n) {
                    return;
                }
                boolean z = C2566xd.this.m10687h() == null;
                C2116no c2116no = C2116no.f6480a;
                if (!C2566xd.this.m10694o().f7994o) {
                    boolean z2 = this.f7991l.m9911Y() > 0;
                    if (this.f7992m != null) {
                        while (this.f7991l.m9911Y() > 0) {
                            m10706a(false);
                        }
                        C2428ud c2428udM10686g = C2566xd.this.m10686g();
                        int iM10689j = C2566xd.this.m10689j();
                        Headers headers = this.f7992m;
                        AbstractC0116Ce.m473b(headers);
                        c2428udM10686g.m10060x0(iM10689j, z, AbstractC2623yo.m10914J(headers));
                    } else if (z2) {
                        while (this.f7991l.m9911Y() > 0) {
                            m10706a(true);
                        }
                    } else if (z) {
                        C2566xd.this.m10686g().m10059w0(C2566xd.this.m10689j(), true, null, 0L);
                    }
                }
                synchronized (C2566xd.this) {
                    this.f7993n = true;
                    C2116no c2116no2 = C2116no.f6480a;
                }
                C2566xd.this.m10686g().flush();
                C2566xd.this.m10681b();
            }
        }

        @Override
        public C0125Cn mo114d() {
            return C2566xd.this.m10698s();
        }

        @Override
        public void flush() throws IOException {
            C2566xd c2566xd = C2566xd.this;
            if (AbstractC2623yo.f8134h && Thread.holdsLock(c2566xd)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c2566xd);
                throw new AssertionError(sb.toString());
            }
            synchronized (C2566xd.this) {
                C2566xd.this.m10682c();
                C2116no c2116no = C2116no.f6480a;
            }
            while (this.f7991l.m9911Y() > 0) {
                m10706a(false);
                C2566xd.this.m10686g().flush();
            }
        }

        public final boolean m10708g() {
            return this.f7994o;
        }

        @Override
        public void mo115h(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "source");
            C2566xd c2566xd = C2566xd.this;
            if (!AbstractC2623yo.f8134h || !Thread.holdsLock(c2566xd)) {
                this.f7991l.mo115h(c2409u3, j);
                while (this.f7991l.m9911Y() >= 16384) {
                    m10706a(false);
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(c2566xd);
            throw new AssertionError(sb.toString());
        }
    }

    public final class c implements InterfaceC2161om {

        public final C2409u3 f7996l = new C2409u3();

        public final C2409u3 f7997m = new C2409u3();

        public Headers f7998n;

        public boolean f7999o;

        public final long f8000p;

        public boolean f8001q;

        public c(long j, boolean z) {
            this.f8000p = j;
            this.f8001q = z;
        }

        public final boolean m10709a() {
            return this.f7999o;
        }

        public final boolean m10710b() {
            return this.f8001q;
        }

        @Override
        public void close() {
            long jM9911Y;
            synchronized (C2566xd.this) {
                this.f7999o = true;
                jM9911Y = this.f7997m.m9911Y();
                this.f7997m.m9913a();
                C2566xd c2566xd = C2566xd.this;
                if (c2566xd == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                c2566xd.notifyAll();
                C2116no c2116no = C2116no.f6480a;
            }
            if (jM9911Y > 0) {
                m10714k(jM9911Y);
            }
            C2566xd.this.m10681b();
        }

        @Override
        public C0125Cn mo239d() {
            return C2566xd.this.m10692m();
        }

        public final void m10711g(InterfaceC2547x3 interfaceC2547x3, long j) throws EOFException {
            boolean z;
            boolean z2;
            long jM9911Y;
            AbstractC0116Ce.m476e(interfaceC2547x3, "source");
            C2566xd c2566xd = C2566xd.this;
            if (AbstractC2623yo.f8134h && Thread.holdsLock(c2566xd)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST NOT hold lock on ");
                sb.append(c2566xd);
                throw new AssertionError(sb.toString());
            }
            while (j > 0) {
                synchronized (C2566xd.this) {
                    z = this.f8001q;
                    z2 = this.f7997m.m9911Y() + j > this.f8000p;
                    C2116no c2116no = C2116no.f6480a;
                }
                if (z2) {
                    interfaceC2547x3.mo7347r(j);
                    C2566xd.this.m10685f(EnumC1159Z9.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    interfaceC2547x3.mo7347r(j);
                    return;
                }
                long jMo1488n = interfaceC2547x3.mo1488n(this.f7996l, j);
                if (jMo1488n == -1) {
                    throw new EOFException();
                }
                j -= jMo1488n;
                synchronized (C2566xd.this) {
                    try {
                        if (this.f7999o) {
                            jM9911Y = this.f7996l.m9911Y();
                            this.f7996l.m9913a();
                        } else {
                            boolean z3 = this.f7997m.m9911Y() == 0;
                            this.f7997m.m9920f0(this.f7996l);
                            if (z3) {
                                C2566xd c2566xd2 = C2566xd.this;
                                if (c2566xd2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                }
                                c2566xd2.notifyAll();
                            }
                            jM9911Y = 0;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (jM9911Y > 0) {
                    m10714k(jM9911Y);
                }
            }
        }

        public final void m10712i(boolean z) {
            this.f8001q = z;
        }

        public final void m10713j(Headers headers) {
            this.f7998n = headers;
        }

        public final void m10714k(long j) {
            C2566xd c2566xd = C2566xd.this;
            if (!AbstractC2623yo.f8134h || !Thread.holdsLock(c2566xd)) {
                C2566xd.this.m10686g().m10058v0(j);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(c2566xd);
            throw new AssertionError(sb.toString());
        }

        /* JADX WARN: Finally extract failed */
        @Override
        public long mo1488n(C2409u3 c2409u3, long j) throws IOException {
            IOException iOExceptionM10688i;
            long jMo1488n;
            boolean z;
            AbstractC0116Ce.m476e(c2409u3, "sink");
            long j2 = 0;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            while (true) {
                synchronized (C2566xd.this) {
                    C2566xd.this.m10692m().m1474r();
                    try {
                        if (C2566xd.this.m10687h() != null) {
                            iOExceptionM10688i = C2566xd.this.m10688i();
                            if (iOExceptionM10688i == null) {
                                EnumC1159Z9 enumC1159Z9M10687h = C2566xd.this.m10687h();
                                AbstractC0116Ce.m473b(enumC1159Z9M10687h);
                                iOExceptionM10688i = new C2575xm(enumC1159Z9M10687h);
                            }
                        } else {
                            iOExceptionM10688i = null;
                        }
                        if (this.f7999o) {
                            throw new IOException("stream closed");
                        }
                        if (this.f7997m.m9911Y() > j2) {
                            C2409u3 c2409u32 = this.f7997m;
                            jMo1488n = c2409u32.mo1488n(c2409u3, Math.min(j, c2409u32.m9911Y()));
                            C2566xd c2566xd = C2566xd.this;
                            c2566xd.m10675A(c2566xd.m10691l() + jMo1488n);
                            long jM10691l = C2566xd.this.m10691l() - C2566xd.this.m10690k();
                            if (iOExceptionM10688i == null && jM10691l >= C2566xd.this.m10686g().m10038a0().m3699c() / 2) {
                                C2566xd.this.m10686g().m10030B0(C2566xd.this.m10689j(), jM10691l);
                                C2566xd c2566xd2 = C2566xd.this;
                                c2566xd2.m10705z(c2566xd2.m10691l());
                            }
                        } else if (this.f8001q || iOExceptionM10688i != null) {
                            jMo1488n = -1;
                        } else {
                            C2566xd.this.m10678D();
                            jMo1488n = -1;
                            z = true;
                            C2566xd.this.m10692m().m10715y();
                            C2116no c2116no = C2116no.f6480a;
                        }
                        z = false;
                        C2566xd.this.m10692m().m10715y();
                        C2116no c2116no2 = C2116no.f6480a;
                    } catch (Throwable th) {
                        C2566xd.this.m10692m().m10715y();
                        throw th;
                    }
                }
                if (!z) {
                    if (jMo1488n != -1) {
                        m10714k(jMo1488n);
                        return jMo1488n;
                    }
                    if (iOExceptionM10688i == null) {
                        return -1L;
                    }
                    AbstractC0116Ce.m473b(iOExceptionM10688i);
                    throw iOExceptionM10688i;
                }
                j2 = 0;
            }
        }
    }

    public final class d extends C0324H1 {
        public d() {
        }

        @Override
        public IOException mo1476t(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override
        public void mo1480x() {
            C2566xd.this.m10685f(EnumC1159Z9.CANCEL);
            C2566xd.this.m10686g().m10053p0();
        }

        public final void m10715y() throws IOException {
            if (m1475s()) {
                throw mo1476t(null);
            }
        }
    }

    public C2566xd(int i, C2428ud c2428ud, boolean z, boolean z2, Headers headers) {
        AbstractC0116Ce.m476e(c2428ud, "connection");
        this.f7989m = i;
        this.f7990n = c2428ud;
        this.f7980d = c2428ud.m10039b0().m3699c();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f7981e = arrayDeque;
        this.f7983g = new c(c2428ud.m10038a0().m3699c(), z2);
        this.f7984h = new b(z);
        this.f7985i = new d();
        this.f7986j = new d();
        if (headers == null) {
            if (!m10699t()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!m10699t())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(headers);
        }
    }

    public final void m10675A(long j) {
        this.f7977a = j;
    }

    public final void m10676B(long j) {
        this.f7979c = j;
    }

    public final synchronized Headers m10677C() {
        Object objRemoveFirst;
        this.f7985i.m1474r();
        while (this.f7981e.isEmpty() && this.f7987k == null) {
            try {
                m10678D();
            } catch (Throwable th) {
                this.f7985i.m10715y();
                throw th;
            }
        }
        this.f7985i.m10715y();
        if (!(!this.f7981e.isEmpty())) {
            IOException iOException = this.f7988l;
            if (iOException != null) {
                throw iOException;
            }
            EnumC1159Z9 enumC1159Z9 = this.f7987k;
            AbstractC0116Ce.m473b(enumC1159Z9);
            throw new C2575xm(enumC1159Z9);
        }
        objRemoveFirst = this.f7981e.removeFirst();
        AbstractC0116Ce.m475d(objRemoveFirst, "headersQueue.removeFirst()");
        return (Headers) objRemoveFirst;
    }

    public final void m10678D() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final C0125Cn m10679E() {
        return this.f7986j;
    }

    public final void m10680a(long j) {
        this.f7980d += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public final void m10681b() {
        boolean z;
        boolean zM10700u;
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
        synchronized (this) {
            try {
                z = !this.f7983g.m10710b() && this.f7983g.m10709a() && (this.f7984h.m10708g() || this.f7984h.m10707b());
                zM10700u = m10700u();
                C2116no c2116no = C2116no.f6480a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            m10683d(EnumC1159Z9.CANCEL, null);
        } else {
            if (zM10700u) {
                return;
            }
            this.f7990n.m10052o0(this.f7989m);
        }
    }

    public final void m10682c() throws IOException {
        if (this.f7984h.m10707b()) {
            throw new IOException("stream closed");
        }
        if (this.f7984h.m10708g()) {
            throw new IOException("stream finished");
        }
        if (this.f7987k != null) {
            IOException iOException = this.f7988l;
            if (iOException != null) {
                throw iOException;
            }
            EnumC1159Z9 enumC1159Z9 = this.f7987k;
            AbstractC0116Ce.m473b(enumC1159Z9);
            throw new C2575xm(enumC1159Z9);
        }
    }

    public final void m10683d(EnumC1159Z9 enumC1159Z9, IOException iOException) {
        AbstractC0116Ce.m476e(enumC1159Z9, "rstStatusCode");
        if (m10684e(enumC1159Z9, iOException)) {
            this.f7990n.m10062z0(this.f7989m, enumC1159Z9);
        }
    }

    public final boolean m10684e(EnumC1159Z9 enumC1159Z9, IOException iOException) {
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
        synchronized (this) {
            if (this.f7987k != null) {
                return false;
            }
            if (this.f7983g.m10710b() && this.f7984h.m10708g()) {
                return false;
            }
            this.f7987k = enumC1159Z9;
            this.f7988l = iOException;
            notifyAll();
            C2116no c2116no = C2116no.f6480a;
            this.f7990n.m10052o0(this.f7989m);
            return true;
        }
    }

    public final void m10685f(EnumC1159Z9 enumC1159Z9) {
        AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
        if (m10684e(enumC1159Z9, null)) {
            this.f7990n.m10029A0(this.f7989m, enumC1159Z9);
        }
    }

    public final C2428ud m10686g() {
        return this.f7990n;
    }

    public final synchronized EnumC1159Z9 m10687h() {
        return this.f7987k;
    }

    public final IOException m10688i() {
        return this.f7988l;
    }

    public final int m10689j() {
        return this.f7989m;
    }

    public final long m10690k() {
        return this.f7978b;
    }

    public final long m10691l() {
        return this.f7977a;
    }

    public final d m10692m() {
        return this.f7985i;
    }

    public final InterfaceC1134Yl m10693n() {
        synchronized (this) {
            try {
                if (!(this.f7982f || m10699t())) {
                    throw new IllegalStateException("reply before requesting the sink".toString());
                }
                C2116no c2116no = C2116no.f6480a;
            } finally {
            }
        }
        return this.f7984h;
    }

    public final b m10694o() {
        return this.f7984h;
    }

    public final c m10695p() {
        return this.f7983g;
    }

    public final long m10696q() {
        return this.f7980d;
    }

    public final long m10697r() {
        return this.f7979c;
    }

    public final d m10698s() {
        return this.f7986j;
    }

    public final boolean m10699t() {
        return this.f7990n.m10033V() == ((this.f7989m & 1) == 1);
    }

    public final synchronized boolean m10700u() {
        try {
            if (this.f7987k != null) {
                return false;
            }
            if (this.f7983g.m10710b() || this.f7983g.m10709a()) {
                if (this.f7984h.m10708g() || this.f7984h.m10707b()) {
                    if (this.f7982f) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final C0125Cn m10701v() {
        return this.f7985i;
    }

    public final void m10702w(InterfaceC2547x3 interfaceC2547x3, int i) {
        AbstractC0116Ce.m476e(interfaceC2547x3, "source");
        if (!AbstractC2623yo.f8134h || !Thread.holdsLock(this)) {
            this.f7983g.m10711g(interfaceC2547x3, i);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    public final void m10703x(Headers headers, boolean z) {
        boolean zM10700u;
        AbstractC0116Ce.m476e(headers, "headers");
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
        synchronized (this) {
            try {
                if (this.f7982f && z) {
                    this.f7983g.m10713j(headers);
                } else {
                    this.f7982f = true;
                    this.f7981e.add(headers);
                }
                if (z) {
                    this.f7983g.m10712i(true);
                }
                zM10700u = m10700u();
                notifyAll();
                C2116no c2116no = C2116no.f6480a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zM10700u) {
            return;
        }
        this.f7990n.m10052o0(this.f7989m);
    }

    public final synchronized void m10704y(EnumC1159Z9 enumC1159Z9) {
        AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
        if (this.f7987k == null) {
            this.f7987k = enumC1159Z9;
            notifyAll();
        }
    }

    public final void m10705z(long j) {
        this.f7978b = j;
    }
}
