package p000;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import p000.C2520wd;

/* loaded from: classes.dex */
public final class C2428ud implements Closeable {

    public static final C0767Ql f7403N;

    public static final c f7404O = new c(null);

    public long f7405A;

    public long f7406B;

    public long f7407C;

    public final C0767Ql f7408D;

    public C0767Ql f7409E;

    public long f7410F;

    public long f7411G;

    public long f7412H;

    public long f7413I;

    public final Socket f7414J;

    public final C2612yd f7415K;

    public final e f7416L;

    public final Set f7417M;

    public final boolean f7418l;

    public final d f7419m;

    public final Map f7420n;

    public final String f7421o;

    public int f7422p;

    public int f7423q;

    public boolean f7424r;

    public final C2300rn f7425s;

    public final C2254qn f7426t;

    public final C2254qn f7427u;

    public final C2254qn f7428v;

    public final InterfaceC2572xj f7429w;

    public long f7430x;

    public long f7431y;

    public long f7432z;

    public static final class a extends AbstractC1791gn {

        public final String f7433e;

        public final C2428ud f7434f;

        public final long f7435g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, C2428ud c2428ud, long j) {
            super(str2, false, 2, null);
            this.f7433e = str;
            this.f7434f = c2428ud;
            this.f7435g = j;
        }

        @Override
        public long mo7750f() throws IOException {
            boolean z;
            synchronized (this.f7434f) {
                if (this.f7434f.f7431y < this.f7434f.f7430x) {
                    z = true;
                } else {
                    this.f7434f.f7430x++;
                    z = false;
                }
            }
            C2428ud c2428ud = this.f7434f;
            if (z) {
                c2428ud.m10032U(null);
                return -1L;
            }
            c2428ud.m10061y0(false, 1, 0);
            return this.f7435g;
        }
    }

    public static final class b {

        public Socket f7436a;

        public String f7437b;

        public InterfaceC2547x3 f7438c;

        public InterfaceC2501w3 f7439d;

        public d f7440e;

        public InterfaceC2572xj f7441f;

        public int f7442g;

        public boolean f7443h;

        public final C2300rn f7444i;

        public b(boolean z, C2300rn c2300rn) {
            AbstractC0116Ce.m476e(c2300rn, "taskRunner");
            this.f7443h = z;
            this.f7444i = c2300rn;
            this.f7440e = d.f7445a;
            this.f7441f = InterfaceC2572xj.f8019a;
        }

        public final C2428ud m10063a() {
            return new C2428ud(this);
        }

        public final boolean m10064b() {
            return this.f7443h;
        }

        public final String m10065c() {
            String str = this.f7437b;
            if (str == null) {
                AbstractC0116Ce.m486o("connectionName");
            }
            return str;
        }

        public final d m10066d() {
            return this.f7440e;
        }

        public final int m10067e() {
            return this.f7442g;
        }

        public final InterfaceC2572xj m10068f() {
            return this.f7441f;
        }

        public final InterfaceC2501w3 m10069g() {
            InterfaceC2501w3 interfaceC2501w3 = this.f7439d;
            if (interfaceC2501w3 == null) {
                AbstractC0116Ce.m486o("sink");
            }
            return interfaceC2501w3;
        }

        public final Socket m10070h() {
            Socket socket = this.f7436a;
            if (socket == null) {
                AbstractC0116Ce.m486o("socket");
            }
            return socket;
        }

        public final InterfaceC2547x3 m10071i() {
            InterfaceC2547x3 interfaceC2547x3 = this.f7438c;
            if (interfaceC2547x3 == null) {
                AbstractC0116Ce.m486o("source");
            }
            return interfaceC2547x3;
        }

        public final C2300rn m10072j() {
            return this.f7444i;
        }

        public final b m10073k(d dVar) {
            AbstractC0116Ce.m476e(dVar, "listener");
            this.f7440e = dVar;
            return this;
        }

        public final b m10074l(int i) {
            this.f7442g = i;
            return this;
        }

        public final b m10075m(Socket socket, String str, InterfaceC2547x3 interfaceC2547x3, InterfaceC2501w3 interfaceC2501w3) {
            StringBuilder sb;
            AbstractC0116Ce.m476e(socket, "socket");
            AbstractC0116Ce.m476e(str, "peerName");
            AbstractC0116Ce.m476e(interfaceC2547x3, "source");
            AbstractC0116Ce.m476e(interfaceC2501w3, "sink");
            this.f7436a = socket;
            if (this.f7443h) {
                sb = new StringBuilder();
                sb.append(AbstractC2623yo.f8135i);
                sb.append(' ');
            } else {
                sb = new StringBuilder();
                sb.append("MockWebServer ");
            }
            sb.append(str);
            this.f7437b = sb.toString();
            this.f7438c = interfaceC2547x3;
            this.f7439d = interfaceC2501w3;
            return this;
        }
    }

    public static final class c {
        public c() {
        }

        public final C0767Ql m10076a() {
            return C2428ud.f7403N;
        }

        public c(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static abstract class d {

        public static final b f7446b = new b(null);

        public static final d f7445a = new a();

        public static final class a extends d {
            @Override
            public void mo7614b(C2566xd c2566xd) {
                AbstractC0116Ce.m476e(c2566xd, "stream");
                c2566xd.m10683d(EnumC1159Z9.REFUSED_STREAM, null);
            }
        }

        public static final class b {
            public b() {
            }

            public b(AbstractC0881T7 abstractC0881T7) {
                this();
            }
        }

        public void mo7613a(C2428ud c2428ud, C0767Ql c0767Ql) {
            AbstractC0116Ce.m476e(c2428ud, "connection");
            AbstractC0116Ce.m476e(c0767Ql, "settings");
        }

        public abstract void mo7614b(C2566xd c2566xd);
    }

    public static final class f extends AbstractC1791gn {

        public final String f7475e;

        public final boolean f7476f;

        public final C2428ud f7477g;

        public final int f7478h;

        public final C2409u3 f7479i;

        public final int f7480j;

        public final boolean f7481k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z, String str2, boolean z2, C2428ud c2428ud, int i, C2409u3 c2409u3, int i2, boolean z3) {
            super(str2, z2);
            this.f7475e = str;
            this.f7476f = z;
            this.f7477g = c2428ud;
            this.f7478h = i;
            this.f7479i = c2409u3;
            this.f7480j = i2;
            this.f7481k = z3;
        }

        @Override
        public long mo7750f() {
            try {
                boolean zMo10768c = this.f7477g.f7429w.mo10768c(this.f7478h, this.f7479i, this.f7480j, this.f7481k);
                if (zMo10768c) {
                    this.f7477g.m10043f0().m10878z(this.f7478h, EnumC1159Z9.CANCEL);
                }
                if (!zMo10768c && !this.f7481k) {
                    return -1L;
                }
                synchronized (this.f7477g) {
                    this.f7477g.f7417M.remove(Integer.valueOf(this.f7478h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class g extends AbstractC1791gn {

        public final String f7482e;

        public final boolean f7483f;

        public final C2428ud f7484g;

        public final int f7485h;

        public final List f7486i;

        public final boolean f7487j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z, String str2, boolean z2, C2428ud c2428ud, int i, List list, boolean z3) {
            super(str2, z2);
            this.f7482e = str;
            this.f7483f = z;
            this.f7484g = c2428ud;
            this.f7485h = i;
            this.f7486i = list;
            this.f7487j = z3;
        }

        @Override
        public long mo7750f() {
            boolean zMo10767b = this.f7484g.f7429w.mo10767b(this.f7485h, this.f7486i, this.f7487j);
            if (zMo10767b) {
                try {
                    this.f7484g.m10043f0().m10878z(this.f7485h, EnumC1159Z9.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!zMo10767b && !this.f7487j) {
                return -1L;
            }
            synchronized (this.f7484g) {
                this.f7484g.f7417M.remove(Integer.valueOf(this.f7485h));
            }
            return -1L;
        }
    }

    public static final class h extends AbstractC1791gn {

        public final String f7488e;

        public final boolean f7489f;

        public final C2428ud f7490g;

        public final int f7491h;

        public final List f7492i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z, String str2, boolean z2, C2428ud c2428ud, int i, List list) {
            super(str2, z2);
            this.f7488e = str;
            this.f7489f = z;
            this.f7490g = c2428ud;
            this.f7491h = i;
            this.f7492i = list;
        }

        @Override
        public long mo7750f() {
            if (!this.f7490g.f7429w.mo10766a(this.f7491h, this.f7492i)) {
                return -1L;
            }
            try {
                this.f7490g.m10043f0().m10878z(this.f7491h, EnumC1159Z9.CANCEL);
                synchronized (this.f7490g) {
                    this.f7490g.f7417M.remove(Integer.valueOf(this.f7491h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class i extends AbstractC1791gn {

        public final String f7493e;

        public final boolean f7494f;

        public final C2428ud f7495g;

        public final int f7496h;

        public final EnumC1159Z9 f7497i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z, String str2, boolean z2, C2428ud c2428ud, int i, EnumC1159Z9 enumC1159Z9) {
            super(str2, z2);
            this.f7493e = str;
            this.f7494f = z;
            this.f7495g = c2428ud;
            this.f7496h = i;
            this.f7497i = enumC1159Z9;
        }

        @Override
        public long mo7750f() {
            this.f7495g.f7429w.mo10769d(this.f7496h, this.f7497i);
            synchronized (this.f7495g) {
                this.f7495g.f7417M.remove(Integer.valueOf(this.f7496h));
                C2116no c2116no = C2116no.f6480a;
            }
            return -1L;
        }
    }

    public static final class j extends AbstractC1791gn {

        public final String f7498e;

        public final boolean f7499f;

        public final C2428ud f7500g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, boolean z, String str2, boolean z2, C2428ud c2428ud) {
            super(str2, z2);
            this.f7498e = str;
            this.f7499f = z;
            this.f7500g = c2428ud;
        }

        @Override
        public long mo7750f() throws IOException {
            this.f7500g.m10061y0(false, 2, 0);
            return -1L;
        }
    }

    public static final class k extends AbstractC1791gn {

        public final String f7501e;

        public final boolean f7502f;

        public final C2428ud f7503g;

        public final int f7504h;

        public final EnumC1159Z9 f7505i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z, String str2, boolean z2, C2428ud c2428ud, int i, EnumC1159Z9 enumC1159Z9) {
            super(str2, z2);
            this.f7501e = str;
            this.f7502f = z;
            this.f7503g = c2428ud;
            this.f7504h = i;
            this.f7505i = enumC1159Z9;
        }

        @Override
        public long mo7750f() throws IOException {
            try {
                this.f7503g.m10062z0(this.f7504h, this.f7505i);
                return -1L;
            } catch (IOException e) {
                this.f7503g.m10032U(e);
                return -1L;
            }
        }
    }

    public static final class l extends AbstractC1791gn {

        public final String f7506e;

        public final boolean f7507f;

        public final C2428ud f7508g;

        public final int f7509h;

        public final long f7510i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z, String str2, boolean z2, C2428ud c2428ud, int i, long j) {
            super(str2, z2);
            this.f7506e = str;
            this.f7507f = z;
            this.f7508g = c2428ud;
            this.f7509h = i;
            this.f7510i = j;
        }

        @Override
        public long mo7750f() throws IOException {
            try {
                this.f7508g.m10043f0().m10866B(this.f7509h, this.f7510i);
                return -1L;
            } catch (IOException e) {
                this.f7508g.m10032U(e);
                return -1L;
            }
        }
    }

    static {
        C0767Ql c0767Ql = new C0767Ql();
        c0767Ql.m3704h(7, 65535);
        c0767Ql.m3704h(5, 16384);
        f7403N = c0767Ql;
    }

    public C2428ud(b bVar) {
        AbstractC0116Ce.m476e(bVar, "builder");
        boolean zM10064b = bVar.m10064b();
        this.f7418l = zM10064b;
        this.f7419m = bVar.m10066d();
        this.f7420n = new LinkedHashMap();
        String strM10065c = bVar.m10065c();
        this.f7421o = strM10065c;
        this.f7423q = bVar.m10064b() ? 3 : 2;
        C2300rn c2300rnM10072j = bVar.m10072j();
        this.f7425s = c2300rnM10072j;
        C2254qn c2254qnM9445i = c2300rnM10072j.m9445i();
        this.f7426t = c2254qnM9445i;
        this.f7427u = c2300rnM10072j.m9445i();
        this.f7428v = c2300rnM10072j.m9445i();
        this.f7429w = bVar.m10068f();
        C0767Ql c0767Ql = new C0767Ql();
        if (bVar.m10064b()) {
            c0767Ql.m3704h(7, 16777216);
        }
        C2116no c2116no = C2116no.f6480a;
        this.f7408D = c0767Ql;
        this.f7409E = f7403N;
        this.f7413I = r2.m3699c();
        this.f7414J = bVar.m10070h();
        this.f7415K = new C2612yd(bVar.m10069g(), zM10064b);
        this.f7416L = new e(this, new C2520wd(bVar.m10071i(), zM10064b));
        this.f7417M = new LinkedHashSet();
        if (bVar.m10067e() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(bVar.m10067e());
            String str = strM10065c + " ping";
            c2254qnM9445i.m9183i(new a(str, str, this, nanos), nanos);
        }
    }

    public static void m10026u0(C2428ud c2428ud, boolean z, C2300rn c2300rn, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            c2300rn = C2300rn.f6963h;
        }
        c2428ud.m10057t0(z, c2300rn);
    }

    public final void m10029A0(int i2, EnumC1159Z9 enumC1159Z9) {
        AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
        C2254qn c2254qn = this.f7426t;
        String str = this.f7421o + '[' + i2 + "] writeSynReset";
        c2254qn.m9183i(new k(str, true, str, true, this, i2, enumC1159Z9), 0L);
    }

    public final void m10030B0(int i2, long j2) {
        C2254qn c2254qn = this.f7426t;
        String str = this.f7421o + '[' + i2 + "] windowUpdate";
        c2254qn.m9183i(new l(str, true, str, true, this, i2, j2), 0L);
    }

    public final void m10031T(EnumC1159Z9 enumC1159Z9, EnumC1159Z9 enumC1159Z92, IOException iOException) throws IOException {
        int i2;
        C2566xd[] c2566xdArr;
        AbstractC0116Ce.m476e(enumC1159Z9, "connectionCode");
        AbstractC0116Ce.m476e(enumC1159Z92, "streamCode");
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
        try {
            m10056s0(enumC1159Z9);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (!this.f7420n.isEmpty()) {
                    Object[] array = this.f7420n.values().toArray(new C2566xd[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    c2566xdArr = (C2566xd[]) array;
                    this.f7420n.clear();
                } else {
                    c2566xdArr = null;
                }
                C2116no c2116no = C2116no.f6480a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c2566xdArr != null) {
            for (C2566xd c2566xd : c2566xdArr) {
                try {
                    c2566xd.m10683d(enumC1159Z92, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f7415K.close();
        } catch (IOException unused3) {
        }
        try {
            this.f7414J.close();
        } catch (IOException unused4) {
        }
        this.f7426t.m9187n();
        this.f7427u.m9187n();
        this.f7428v.m9187n();
    }

    public final void m10032U(IOException iOException) throws IOException {
        EnumC1159Z9 enumC1159Z9 = EnumC1159Z9.PROTOCOL_ERROR;
        m10031T(enumC1159Z9, enumC1159Z9, iOException);
    }

    public final boolean m10033V() {
        return this.f7418l;
    }

    public final String m10034W() {
        return this.f7421o;
    }

    public final int m10035X() {
        return this.f7422p;
    }

    public final d m10036Y() {
        return this.f7419m;
    }

    public final int m10037Z() {
        return this.f7423q;
    }

    public final C0767Ql m10038a0() {
        return this.f7408D;
    }

    public final C0767Ql m10039b0() {
        return this.f7409E;
    }

    public final synchronized C2566xd m10040c0(int i2) {
        return (C2566xd) this.f7420n.get(Integer.valueOf(i2));
    }

    @Override
    public void close() throws IOException {
        m10031T(EnumC1159Z9.NO_ERROR, EnumC1159Z9.CANCEL, null);
    }

    public final Map m10041d0() {
        return this.f7420n;
    }

    public final long m10042e0() {
        return this.f7413I;
    }

    public final C2612yd m10043f0() {
        return this.f7415K;
    }

    public final void flush() {
        this.f7415K.flush();
    }

    public final synchronized boolean m10044g0(long j2) {
        if (this.f7424r) {
            return false;
        }
        if (this.f7405A < this.f7432z) {
            if (j2 >= this.f7407C) {
                return false;
            }
        }
        return true;
    }

    public final C2566xd m10045h0(int i2, List list, boolean z) {
        int i3;
        C2566xd c2566xd;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.f7415K) {
            try {
                synchronized (this) {
                    try {
                        if (this.f7423q > 1073741823) {
                            m10056s0(EnumC1159Z9.REFUSED_STREAM);
                        }
                        if (this.f7424r) {
                            throw new C1764g6();
                        }
                        i3 = this.f7423q;
                        this.f7423q = i3 + 2;
                        c2566xd = new C2566xd(i3, this, z3, false, null);
                        z2 = !z || this.f7412H >= this.f7413I || c2566xd.m10697r() >= c2566xd.m10696q();
                        if (c2566xd.m10700u()) {
                            this.f7420n.put(Integer.valueOf(i3), c2566xd);
                        }
                        C2116no c2116no = C2116no.f6480a;
                    } finally {
                    }
                }
                if (i2 == 0) {
                    this.f7415K.m10874l(z3, i3, list);
                } else {
                    if (!(true ^ this.f7418l)) {
                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                    }
                    this.f7415K.m10877w(i2, i3, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            this.f7415K.flush();
        }
        return c2566xd;
    }

    public final C2566xd m10046i0(List list, boolean z) {
        AbstractC0116Ce.m476e(list, "requestHeaders");
        return m10045h0(0, list, z);
    }

    public final void m10047j0(int i2, InterfaceC2547x3 interfaceC2547x3, int i3, boolean z) {
        AbstractC0116Ce.m476e(interfaceC2547x3, "source");
        C2409u3 c2409u3 = new C2409u3();
        long j2 = i3;
        interfaceC2547x3.mo7332G(j2);
        interfaceC2547x3.mo1488n(c2409u3, j2);
        C2254qn c2254qn = this.f7427u;
        String str = this.f7421o + '[' + i2 + "] onData";
        c2254qn.m9183i(new f(str, true, str, true, this, i2, c2409u3, i3, z), 0L);
    }

    public final void m10048k0(int i2, List list, boolean z) {
        AbstractC0116Ce.m476e(list, "requestHeaders");
        C2254qn c2254qn = this.f7427u;
        String str = this.f7421o + '[' + i2 + "] onHeaders";
        c2254qn.m9183i(new g(str, true, str, true, this, i2, list, z), 0L);
    }

    public final void m10049l0(int i2, List list) {
        AbstractC0116Ce.m476e(list, "requestHeaders");
        synchronized (this) {
            if (this.f7417M.contains(Integer.valueOf(i2))) {
                m10029A0(i2, EnumC1159Z9.PROTOCOL_ERROR);
                return;
            }
            this.f7417M.add(Integer.valueOf(i2));
            C2254qn c2254qn = this.f7427u;
            String str = this.f7421o + '[' + i2 + "] onRequest";
            c2254qn.m9183i(new h(str, true, str, true, this, i2, list), 0L);
        }
    }

    public final void m10050m0(int i2, EnumC1159Z9 enumC1159Z9) {
        AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
        C2254qn c2254qn = this.f7427u;
        String str = this.f7421o + '[' + i2 + "] onReset";
        c2254qn.m9183i(new i(str, true, str, true, this, i2, enumC1159Z9), 0L);
    }

    public final boolean m10051n0(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public final synchronized C2566xd m10052o0(int i2) {
        C2566xd c2566xd;
        c2566xd = (C2566xd) this.f7420n.remove(Integer.valueOf(i2));
        notifyAll();
        return c2566xd;
    }

    public final void m10053p0() {
        synchronized (this) {
            long j2 = this.f7405A;
            long j3 = this.f7432z;
            if (j2 < j3) {
                return;
            }
            this.f7432z = j3 + 1;
            this.f7407C = System.nanoTime() + 1000000000;
            C2116no c2116no = C2116no.f6480a;
            C2254qn c2254qn = this.f7426t;
            String str = this.f7421o + " ping";
            c2254qn.m9183i(new j(str, true, str, true, this), 0L);
        }
    }

    public final void m10054q0(int i2) {
        this.f7422p = i2;
    }

    public final void m10055r0(C0767Ql c0767Ql) {
        AbstractC0116Ce.m476e(c0767Ql, "<set-?>");
        this.f7409E = c0767Ql;
    }

    public final void m10056s0(EnumC1159Z9 enumC1159Z9) {
        AbstractC0116Ce.m476e(enumC1159Z9, "statusCode");
        synchronized (this.f7415K) {
            synchronized (this) {
                if (this.f7424r) {
                    return;
                }
                this.f7424r = true;
                int i2 = this.f7422p;
                C2116no c2116no = C2116no.f6480a;
                this.f7415K.m10873k(i2, enumC1159Z9, AbstractC2623yo.f8127a);
            }
        }
    }

    public final void m10057t0(boolean z, C2300rn c2300rn) {
        AbstractC0116Ce.m476e(c2300rn, "taskRunner");
        if (z) {
            this.f7415K.m10869b();
            this.f7415K.m10865A(this.f7408D);
            if (this.f7408D.m3699c() != 65535) {
                this.f7415K.m10866B(0, r7 - 65535);
            }
        }
        C2254qn c2254qnM9445i = c2300rn.m9445i();
        String str = this.f7421o;
        c2254qnM9445i.m9183i(new C2208pn(this.f7416L, str, true, str, true), 0L);
    }

    public final synchronized void m10058v0(long j2) {
        long j3 = this.f7410F + j2;
        this.f7410F = j3;
        long j4 = j3 - this.f7411G;
        if (j4 >= this.f7408D.m3699c() / 2) {
            m10030B0(0, j4);
            this.f7411G += j4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.f7415K.m10875p());
        r6 = r2;
        r8.f7412H += r6;
        r4 = p000.C2116no.f6480a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m10059w0(int r9, boolean r10, C2409u3 r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            yd r12 = r8.f7415K
            r12.m10870g(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L6c
            monitor-enter(r8)
        L12:
            long r4 = r8.f7412H     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            long r6 = r8.f7413I     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.Map r2 = r8.f7420n     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            if (r2 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            goto L12
        L2a:
            r9 = move-exception
            goto L6a
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L5d
        L34:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L2a
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L2a
            yd r4 = r8.f7415K     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.m10875p()     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.f7412H     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.f7412H = r4     // Catch: java.lang.Throwable -> L2a
            no r4 = p000.C2116no.f6480a     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            yd r4 = r8.f7415K
            if (r10 == 0) goto L58
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L58
            r5 = 1
            goto L59
        L58:
            r5 = r3
        L59:
            r4.m10870g(r5, r9, r11, r2)
            goto Ld
        L5d:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L6a:
            monitor-exit(r8)
            throw r9
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2428ud.m10059w0(int, boolean, u3, long):void");
    }

    public final void m10060x0(int i2, boolean z, List list) {
        AbstractC0116Ce.m476e(list, "alternating");
        this.f7415K.m10874l(z, i2, list);
    }

    public final void m10061y0(boolean z, int i2, int i3) throws IOException {
        try {
            this.f7415K.m10876u(z, i2, i3);
        } catch (IOException e2) {
            m10032U(e2);
        }
    }

    public final void m10062z0(int i2, EnumC1159Z9 enumC1159Z9) {
        AbstractC0116Ce.m476e(enumC1159Z9, "statusCode");
        this.f7415K.m10878z(i2, enumC1159Z9);
    }

    public final class e implements C2520wd.c, InterfaceC0894Tb {

        public final C2520wd f7447l;

        public final C2428ud f7448m;

        public static final class a extends AbstractC1791gn {

            public final String f7449e;

            public final boolean f7450f;

            public final e f7451g;

            public final C2205pk f7452h;

            public final boolean f7453i;

            public final C0767Ql f7454j;

            public final C2158ok f7455k;

            public final C2205pk f7456l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z, String str2, boolean z2, e eVar, C2205pk c2205pk, boolean z3, C0767Ql c0767Ql, C2158ok c2158ok, C2205pk c2205pk2) {
                super(str2, z2);
                this.f7449e = str;
                this.f7450f = z;
                this.f7451g = eVar;
                this.f7452h = c2205pk;
                this.f7453i = z3;
                this.f7454j = c0767Ql;
                this.f7455k = c2158ok;
                this.f7456l = c2205pk2;
            }

            @Override
            public long mo7750f() {
                this.f7451g.f7448m.m10036Y().mo7613a(this.f7451g.f7448m, (C0767Ql) this.f7452h.f6647l);
                return -1L;
            }
        }

        public static final class b extends AbstractC1791gn {

            public final String f7457e;

            public final boolean f7458f;

            public final C2566xd f7459g;

            public final e f7460h;

            public final C2566xd f7461i;

            public final int f7462j;

            public final List f7463k;

            public final boolean f7464l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z, String str2, boolean z2, C2566xd c2566xd, e eVar, C2566xd c2566xd2, int i, List list, boolean z3) {
                super(str2, z2);
                this.f7457e = str;
                this.f7458f = z;
                this.f7459g = c2566xd;
                this.f7460h = eVar;
                this.f7461i = c2566xd2;
                this.f7462j = i;
                this.f7463k = list;
                this.f7464l = z3;
            }

            @Override
            public long mo7750f() {
                try {
                    this.f7460h.f7448m.m10036Y().mo7614b(this.f7459g);
                    return -1L;
                } catch (IOException e) {
                    C0764Qi.f2268c.m3690g().m3679j("Http2Connection.Listener failure for " + this.f7460h.f7448m.m10034W(), 4, e);
                    try {
                        this.f7459g.m10683d(EnumC1159Z9.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        public static final class c extends AbstractC1791gn {

            public final String f7465e;

            public final boolean f7466f;

            public final e f7467g;

            public final int f7468h;

            public final int f7469i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z, String str2, boolean z2, e eVar, int i, int i2) {
                super(str2, z2);
                this.f7465e = str;
                this.f7466f = z;
                this.f7467g = eVar;
                this.f7468h = i;
                this.f7469i = i2;
            }

            @Override
            public long mo7750f() throws IOException {
                this.f7467g.f7448m.m10061y0(true, this.f7468h, this.f7469i);
                return -1L;
            }
        }

        public static final class d extends AbstractC1791gn {

            public final String f7470e;

            public final boolean f7471f;

            public final e f7472g;

            public final boolean f7473h;

            public final C0767Ql f7474i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(String str, boolean z, String str2, boolean z2, e eVar, boolean z3, C0767Ql c0767Ql) {
                super(str2, z2);
                this.f7470e = str;
                this.f7471f = z;
                this.f7472g = eVar;
                this.f7473h = z3;
                this.f7474i = c0767Ql;
            }

            @Override
            public long mo7750f() {
                this.f7472g.m10087o(this.f7473h, this.f7474i);
                return -1L;
            }
        }

        public e(C2428ud c2428ud, C2520wd c2520wd) {
            AbstractC0116Ce.m476e(c2520wd, "reader");
            this.f7448m = c2428ud;
            this.f7447l = c2520wd;
        }

        @Override
        public void mo10077a(int i, EnumC1159Z9 enumC1159Z9, C0096C3 c0096c3) {
            int i2;
            C2566xd[] c2566xdArr;
            AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
            AbstractC0116Ce.m476e(c0096c3, "debugData");
            c0096c3.m387u();
            synchronized (this.f7448m) {
                Object[] array = this.f7448m.m10041d0().values().toArray(new C2566xd[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                c2566xdArr = (C2566xd[]) array;
                this.f7448m.f7424r = true;
                C2116no c2116no = C2116no.f6480a;
            }
            for (C2566xd c2566xd : c2566xdArr) {
                if (c2566xd.m10689j() > i && c2566xd.m10699t()) {
                    c2566xd.m10704y(EnumC1159Z9.REFUSED_STREAM);
                    this.f7448m.m10052o0(c2566xd.m10689j());
                }
            }
        }

        @Override
        public void mo10078b(boolean z, int i, int i2, List list) {
            AbstractC0116Ce.m476e(list, "headerBlock");
            if (this.f7448m.m10051n0(i)) {
                this.f7448m.m10048k0(i, list, z);
                return;
            }
            synchronized (this.f7448m) {
                C2566xd c2566xdM10040c0 = this.f7448m.m10040c0(i);
                if (c2566xdM10040c0 != null) {
                    C2116no c2116no = C2116no.f6480a;
                    c2566xdM10040c0.m10703x(AbstractC2623yo.m10915K(list), z);
                    return;
                }
                if (this.f7448m.f7424r) {
                    return;
                }
                if (i <= this.f7448m.m10035X()) {
                    return;
                }
                if (i % 2 == this.f7448m.m10037Z() % 2) {
                    return;
                }
                C2566xd c2566xd = new C2566xd(i, this.f7448m, false, z, AbstractC2623yo.m10915K(list));
                this.f7448m.m10054q0(i);
                this.f7448m.m10041d0().put(Integer.valueOf(i), c2566xd);
                C2254qn c2254qnM9445i = this.f7448m.f7425s.m9445i();
                String str = this.f7448m.m10034W() + '[' + i + "] onStream";
                c2254qnM9445i.m9183i(new b(str, true, str, true, c2566xd, this, c2566xdM10040c0, i, list, z), 0L);
            }
        }

        @Override
        public /* bridge */ Object mo4135c() throws Throwable {
            m10088p();
            return C2116no.f6480a;
        }

        @Override
        public void mo10079d(boolean z, int i, InterfaceC2547x3 interfaceC2547x3, int i2) {
            AbstractC0116Ce.m476e(interfaceC2547x3, "source");
            if (this.f7448m.m10051n0(i)) {
                this.f7448m.m10047j0(i, interfaceC2547x3, i2, z);
                return;
            }
            C2566xd c2566xdM10040c0 = this.f7448m.m10040c0(i);
            if (c2566xdM10040c0 == null) {
                this.f7448m.m10029A0(i, EnumC1159Z9.PROTOCOL_ERROR);
                long j = i2;
                this.f7448m.m10058v0(j);
                interfaceC2547x3.mo7347r(j);
                return;
            }
            c2566xdM10040c0.m10702w(interfaceC2547x3, i2);
            if (z) {
                c2566xdM10040c0.m10703x(AbstractC2623yo.f8128b, true);
            }
        }

        @Override
        public void mo10081g(int i, long j) {
            Object obj;
            if (i == 0) {
                Object obj2 = this.f7448m;
                synchronized (obj2) {
                    C2428ud c2428ud = this.f7448m;
                    c2428ud.f7413I = c2428ud.m10042e0() + j;
                    C2428ud c2428ud2 = this.f7448m;
                    if (c2428ud2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                    c2428ud2.notifyAll();
                    C2116no c2116no = C2116no.f6480a;
                    obj = obj2;
                }
            } else {
                C2566xd c2566xdM10040c0 = this.f7448m.m10040c0(i);
                if (c2566xdM10040c0 == null) {
                    return;
                }
                synchronized (c2566xdM10040c0) {
                    c2566xdM10040c0.m10680a(j);
                    C2116no c2116no2 = C2116no.f6480a;
                    obj = c2566xdM10040c0;
                }
            }
        }

        @Override
        public void mo10082h(int i, int i2, List list) {
            AbstractC0116Ce.m476e(list, "requestHeaders");
            this.f7448m.m10049l0(i2, list);
        }

        @Override
        public void mo10083i(boolean z, int i, int i2) {
            if (!z) {
                C2254qn c2254qn = this.f7448m.f7426t;
                String str = this.f7448m.m10034W() + " ping";
                c2254qn.m9183i(new c(str, true, str, true, this, i, i2), 0L);
                return;
            }
            synchronized (this.f7448m) {
                try {
                    if (i == 1) {
                        this.f7448m.f7431y++;
                    } else if (i != 2) {
                        if (i == 3) {
                            this.f7448m.f7406B++;
                            C2428ud c2428ud = this.f7448m;
                            if (c2428ud == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            c2428ud.notifyAll();
                        }
                        C2116no c2116no = C2116no.f6480a;
                    } else {
                        this.f7448m.f7405A++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override
        public void mo10084k(int i, EnumC1159Z9 enumC1159Z9) {
            AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
            if (this.f7448m.m10051n0(i)) {
                this.f7448m.m10050m0(i, enumC1159Z9);
                return;
            }
            C2566xd c2566xdM10052o0 = this.f7448m.m10052o0(i);
            if (c2566xdM10052o0 != null) {
                c2566xdM10052o0.m10704y(enumC1159Z9);
            }
        }

        @Override
        public void mo10086m(boolean z, C0767Ql c0767Ql) {
            AbstractC0116Ce.m476e(c0767Ql, "settings");
            C2254qn c2254qn = this.f7448m.f7426t;
            String str = this.f7448m.m10034W() + " applyAndAckSettings";
            c2254qn.m9183i(new d(str, true, str, true, this, z, c0767Ql), 0L);
        }

        public final void m10087o(boolean z, C0767Ql c0767Ql) {
            C2428ud c2428ud;
            C0767Ql c0767Ql2;
            C2566xd[] c2566xdArr;
            AbstractC0116Ce.m476e(c0767Ql, "settings");
            C2158ok c2158ok = new C2158ok();
            C2205pk c2205pk = new C2205pk();
            C2205pk c2205pk2 = new C2205pk();
            synchronized (this.f7448m.m10043f0()) {
                C2428ud c2428ud2 = this.f7448m;
                synchronized (c2428ud2) {
                    try {
                        C0767Ql c0767QlM10039b0 = this.f7448m.m10039b0();
                        if (z) {
                            c0767Ql2 = c0767Ql;
                        } else {
                            c0767Ql2 = new C0767Ql();
                            c0767Ql2.m3703g(c0767QlM10039b0);
                            c0767Ql2.m3703g(c0767Ql);
                            C2116no c2116no = C2116no.f6480a;
                        }
                        c2205pk2.f6647l = c0767Ql2;
                        long jM3699c = c0767Ql2.m3699c() - c0767QlM10039b0.m3699c();
                        c2158ok.f6580l = jM3699c;
                        if (jM3699c == 0 || this.f7448m.m10041d0().isEmpty()) {
                            c2566xdArr = null;
                        } else {
                            Object[] array = this.f7448m.m10041d0().values().toArray(new C2566xd[0]);
                            if (array == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            c2566xdArr = (C2566xd[]) array;
                        }
                        c2205pk.f6647l = c2566xdArr;
                        this.f7448m.m10055r0((C0767Ql) c2205pk2.f6647l);
                        C2254qn c2254qn = this.f7448m.f7428v;
                        String str = this.f7448m.m10034W() + " onSettings";
                        c2428ud = c2428ud2;
                        try {
                            c2254qn.m9183i(new a(str, true, str, true, this, c2205pk2, z, c0767Ql, c2158ok, c2205pk), 0L);
                            C2116no c2116no2 = C2116no.f6480a;
                            try {
                                this.f7448m.m10043f0().m10868a((C0767Ql) c2205pk2.f6647l);
                            } catch (IOException e) {
                                this.f7448m.m10032U(e);
                            }
                            C2116no c2116no3 = C2116no.f6480a;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c2428ud = c2428ud2;
                    }
                }
            }
            Object obj = c2205pk.f6647l;
            if (((C2566xd[]) obj) != null) {
                C2566xd[] c2566xdArr2 = (C2566xd[]) obj;
                AbstractC0116Ce.m473b(c2566xdArr2);
                for (C2566xd c2566xd : c2566xdArr2) {
                    synchronized (c2566xd) {
                        c2566xd.m10680a(c2158ok.f6580l);
                        C2116no c2116no4 = C2116no.f6480a;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [Z9] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, wd] */
        public void m10088p() throws Throwable {
            EnumC1159Z9 enumC1159Z9;
            EnumC1159Z9 enumC1159Z92;
            EnumC1159Z9 enumC1159Z93 = EnumC1159Z9.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.f7447l.m10547g(this);
                    while (this.f7447l.m10546b(false, this)) {
                    }
                    enumC1159Z92 = EnumC1159Z9.NO_ERROR;
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    enumC1159Z9 = enumC1159Z93;
                    this.f7448m.m10031T(enumC1159Z9, enumC1159Z93, e);
                    AbstractC2623yo.m10935j(this.f7447l);
                    throw th;
                }
                try {
                    this.f7448m.m10031T(enumC1159Z92, EnumC1159Z9.CANCEL, null);
                    enumC1159Z9 = enumC1159Z92;
                } catch (IOException e3) {
                    e = e3;
                    EnumC1159Z9 enumC1159Z94 = EnumC1159Z9.PROTOCOL_ERROR;
                    C2428ud c2428ud = this.f7448m;
                    c2428ud.m10031T(enumC1159Z94, enumC1159Z94, e);
                    enumC1159Z9 = c2428ud;
                    enumC1159Z93 = this.f7447l;
                    AbstractC2623yo.m10935j(enumC1159Z93);
                }
                enumC1159Z93 = this.f7447l;
                AbstractC2623yo.m10935j(enumC1159Z93);
            } catch (Throwable th2) {
                th = th2;
                this.f7448m.m10031T(enumC1159Z9, enumC1159Z93, e);
                AbstractC2623yo.m10935j(this.f7447l);
                throw th;
            }
        }

        @Override
        public void mo10080f() {
        }

        @Override
        public void mo10085l(int i, int i2, int i3, boolean z) {
        }
    }
}
