package p000;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.C2290rd;

public final class C2520wd implements Closeable {

    public static final Logger f7857p;

    public static final a f7858q = new a(null);

    public final b f7859l;

    public final C2290rd.a f7860m;

    public final InterfaceC2547x3 f7861n;

    public final boolean f7862o;

    public static final class a {
        public a() {
        }

        public final Logger m10556a() {
            return C2520wd.f7857p;
        }

        public final int m10557b(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i3 + " > remaining length " + i);
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public interface c {
        void mo10077a(int i, EnumC1159Z9 enumC1159Z9, C0096C3 c0096c3);

        void mo10078b(boolean z, int i, int i2, List list);

        void mo10079d(boolean z, int i, InterfaceC2547x3 interfaceC2547x3, int i2);

        void mo10080f();

        void mo10081g(int i, long j);

        void mo10082h(int i, int i2, List list);

        void mo10083i(boolean z, int i, int i2);

        void mo10084k(int i, EnumC1159Z9 enumC1159Z9);

        void mo10085l(int i, int i2, int i3, boolean z);

        void mo10086m(boolean z, C0767Ql c0767Ql);
    }

    static {
        Logger logger = Logger.getLogger(C2382td.class.getName());
        AbstractC0116Ce.m475d(logger, "Logger.getLogger(Http2::class.java.name)");
        f7857p = logger;
    }

    public C2520wd(InterfaceC2547x3 interfaceC2547x3, boolean z) {
        AbstractC0116Ce.m476e(interfaceC2547x3, "source");
        this.f7861n = interfaceC2547x3;
        this.f7862o = z;
        b bVar = new b(interfaceC2547x3);
        this.f7859l = bVar;
        this.f7860m = new C2290rd.a(bVar, 4096, 0, 4, null);
    }

    public final void m10543A(c cVar, int i, int i2, int i3) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i + " != 4");
        }
        if (i3 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int iMo7350x = this.f7861n.mo7350x();
        EnumC1159Z9 enumC1159Z9M5027a = EnumC1159Z9.f3405B.m5027a(iMo7350x);
        if (enumC1159Z9M5027a != null) {
            cVar.mo10084k(i3, enumC1159Z9M5027a);
            return;
        }
        throw new IOException("TYPE_RST_STREAM unexpected error code: " + iMo7350x);
    }

    public final void m10544B(c cVar, int i, int i2, int i3) throws IOException {
        int iMo7350x;
        if (i3 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i2 & 1) != 0) {
            if (i != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            cVar.mo10080f();
            return;
        }
        if (i % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + i);
        }
        C0767Ql c0767Ql = new C0767Ql();
        C2567xe c2567xeM4986g = AbstractC1132Yj.m4986g(AbstractC1132Yj.m4987h(0, i), 6);
        int iM10716d = c2567xeM4986g.m10716d();
        int iM10717f = c2567xeM4986g.m10717f();
        int iM10718g = c2567xeM4986g.m10718g();
        if (iM10718g < 0 ? iM10716d >= iM10717f : iM10716d <= iM10717f) {
            while (true) {
                int iM10928c = AbstractC2623yo.m10928c(this.f7861n.mo7348s(), 65535);
                iMo7350x = this.f7861n.mo7350x();
                if (iM10928c != 2) {
                    if (iM10928c == 3) {
                        iM10928c = 4;
                    } else if (iM10928c != 4) {
                        if (iM10928c == 5 && (iMo7350x < 16384 || iMo7350x > 16777215)) {
                            break;
                        }
                    } else {
                        if (iMo7350x < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iM10928c = 7;
                    }
                } else if (iMo7350x != 0 && iMo7350x != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                c0767Ql.m3704h(iM10928c, iMo7350x);
                if (iM10716d == iM10717f) {
                    break;
                } else {
                    iM10716d += iM10718g;
                }
            }
            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + iMo7350x);
        }
        cVar.mo10086m(false, c0767Ql);
    }

    public final void m10545C(c cVar, int i, int i2, int i3) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i);
        }
        long jM10929d = AbstractC2623yo.m10929d(this.f7861n.mo7350x(), 2147483647L);
        if (jM10929d == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        cVar.mo10081g(i3, jM10929d);
    }

    public final boolean m10546b(boolean z, c cVar) throws IOException {
        AbstractC0116Ce.m476e(cVar, "handler");
        try {
            this.f7861n.mo7332G(9L);
            int iM10910F = AbstractC2623yo.m10910F(this.f7861n);
            if (iM10910F > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + iM10910F);
            }
            int iM10927b = AbstractC2623yo.m10927b(this.f7861n.mo7338R(), 255);
            int iM10927b2 = AbstractC2623yo.m10927b(this.f7861n.mo7338R(), 255);
            int iMo7350x = this.f7861n.mo7350x() & Integer.MAX_VALUE;
            Logger logger = f7857p;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C2382td.f7221e.m9705c(true, iMo7350x, iM10910F, iM10927b, iM10927b2));
            }
            if (z && iM10927b != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + C2382td.f7221e.m9704b(iM10927b));
            }
            switch (iM10927b) {
                case 0:
                    m10548i(cVar, iM10910F, iM10927b2, iMo7350x);
                    return true;
                case 1:
                    m10551l(cVar, iM10910F, iM10927b2, iMo7350x);
                    return true;
                case 2:
                    m10554w(cVar, iM10910F, iM10927b2, iMo7350x);
                    return true;
                case 3:
                    m10543A(cVar, iM10910F, iM10927b2, iMo7350x);
                    return true;
                case 4:
                    m10544B(cVar, iM10910F, iM10927b2, iMo7350x);
                    return true;
                case 5:
                    m10555z(cVar, iM10910F, iM10927b2, iMo7350x);
                    return true;
                case 6:
                    m10552p(cVar, iM10910F, iM10927b2, iMo7350x);
                    return true;
                case 7:
                    m10549j(cVar, iM10910F, iM10927b2, iMo7350x);
                    return true;
                case 8:
                    m10545C(cVar, iM10910F, iM10927b2, iMo7350x);
                    return true;
                default:
                    this.f7861n.mo7347r(iM10910F);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    @Override
    public void close() {
        this.f7861n.close();
    }

    public final void m10547g(c cVar) throws IOException {
        AbstractC0116Ce.m476e(cVar, "handler");
        if (this.f7862o) {
            if (!m10546b(true, cVar)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        InterfaceC2547x3 interfaceC2547x3 = this.f7861n;
        C0096C3 c0096c3 = C2382td.f7217a;
        C0096C3 c0096c3Mo7345o = interfaceC2547x3.mo7345o(c0096c3.m387u());
        Logger logger = f7857p;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(AbstractC2623yo.m10942q("<< CONNECTION " + c0096c3Mo7345o.mo379m(), new Object[0]));
        }
        if (!AbstractC0116Ce.m472a(c0096c3, c0096c3Mo7345o)) {
            throw new IOException("Expected a connection header but was " + c0096c3Mo7345o.m390x());
        }
    }

    public final void m10548i(c cVar, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z = (i2 & 1) != 0;
        if ((i2 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iM10927b = (i2 & 8) != 0 ? AbstractC2623yo.m10927b(this.f7861n.mo7338R(), 255) : 0;
        cVar.mo10079d(z, i3, this.f7861n, f7858q.m10557b(i, i2, iM10927b));
        this.f7861n.mo7347r(iM10927b);
    }

    public final void m10549j(c cVar, int i, int i2, int i3) throws IOException {
        if (i < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + i);
        }
        if (i3 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int iMo7350x = this.f7861n.mo7350x();
        int iMo7350x2 = this.f7861n.mo7350x();
        int i4 = i - 8;
        EnumC1159Z9 enumC1159Z9M5027a = EnumC1159Z9.f3405B.m5027a(iMo7350x2);
        if (enumC1159Z9M5027a == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + iMo7350x2);
        }
        C0096C3 c0096c3Mo7345o = C0096C3.f234o;
        if (i4 > 0) {
            c0096c3Mo7345o = this.f7861n.mo7345o(i4);
        }
        cVar.mo10077a(iMo7350x, enumC1159Z9M5027a, c0096c3Mo7345o);
    }

    public final List m10550k(int i, int i2, int i3, int i4) throws IOException {
        this.f7859l.m10561i(i);
        b bVar = this.f7859l;
        bVar.m10562j(bVar.m10558a());
        this.f7859l.m10563k(i2);
        this.f7859l.m10560g(i3);
        this.f7859l.m10564l(i4);
        this.f7860m.m9396k();
        return this.f7860m.m9390e();
    }

    public final void m10551l(c cVar, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z = (i2 & 1) != 0;
        int iM10927b = (i2 & 8) != 0 ? AbstractC2623yo.m10927b(this.f7861n.mo7338R(), 255) : 0;
        if ((i2 & 32) != 0) {
            m10553u(cVar, i3);
            i -= 5;
        }
        cVar.mo10078b(z, i3, -1, m10550k(f7858q.m10557b(i, i2, iM10927b), iM10927b, i2, i3));
    }

    public final void m10552p(c cVar, int i, int i2, int i3) throws IOException {
        if (i != 8) {
            throw new IOException("TYPE_PING length != 8: " + i);
        }
        if (i3 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        cVar.mo10083i((i2 & 1) != 0, this.f7861n.mo7350x(), this.f7861n.mo7350x());
    }

    public final void m10553u(c cVar, int i) {
        int iMo7350x = this.f7861n.mo7350x();
        cVar.mo10085l(i, iMo7350x & Integer.MAX_VALUE, AbstractC2623yo.m10927b(this.f7861n.mo7338R(), 255) + 1, (((int) 2147483648L) & iMo7350x) != 0);
    }

    public final void m10554w(c cVar, int i, int i2, int i3) throws IOException {
        if (i == 5) {
            if (i3 == 0) {
                throw new IOException("TYPE_PRIORITY streamId == 0");
            }
            m10553u(cVar, i3);
        } else {
            throw new IOException("TYPE_PRIORITY length: " + i + " != 5");
        }
    }

    public final void m10555z(c cVar, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iM10927b = (i2 & 8) != 0 ? AbstractC2623yo.m10927b(this.f7861n.mo7338R(), 255) : 0;
        cVar.mo10082h(i3, this.f7861n.mo7350x() & Integer.MAX_VALUE, m10550k(f7858q.m10557b(i - 4, i2, iM10927b), iM10927b, i2, i3));
    }

    public static final class b implements InterfaceC2161om {

        public int f7863l;

        public int f7864m;

        public int f7865n;

        public int f7866o;

        public int f7867p;

        public final InterfaceC2547x3 f7868q;

        public b(InterfaceC2547x3 interfaceC2547x3) {
            AbstractC0116Ce.m476e(interfaceC2547x3, "source");
            this.f7868q = interfaceC2547x3;
        }

        public final int m10558a() {
            return this.f7866o;
        }

        public final void m10559b() throws IOException {
            int i = this.f7865n;
            int iM10910F = AbstractC2623yo.m10910F(this.f7868q);
            this.f7866o = iM10910F;
            this.f7863l = iM10910F;
            int iM10927b = AbstractC2623yo.m10927b(this.f7868q.mo7338R(), 255);
            this.f7864m = AbstractC2623yo.m10927b(this.f7868q.mo7338R(), 255);
            a aVar = C2520wd.f7858q;
            if (aVar.m10556a().isLoggable(Level.FINE)) {
                aVar.m10556a().fine(C2382td.f7221e.m9705c(true, this.f7865n, this.f7863l, iM10927b, this.f7864m));
            }
            int iMo7350x = this.f7868q.mo7350x() & Integer.MAX_VALUE;
            this.f7865n = iMo7350x;
            if (iM10927b == 9) {
                if (iMo7350x != i) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iM10927b + " != TYPE_CONTINUATION");
            }
        }

        @Override
        public C0125Cn mo239d() {
            return this.f7868q.mo239d();
        }

        public final void m10560g(int i) {
            this.f7864m = i;
        }

        public final void m10561i(int i) {
            this.f7866o = i;
        }

        public final void m10562j(int i) {
            this.f7863l = i;
        }

        public final void m10563k(int i) {
            this.f7867p = i;
        }

        public final void m10564l(int i) {
            this.f7865n = i;
        }

        @Override
        public long mo1488n(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "sink");
            while (true) {
                int i = this.f7866o;
                if (i != 0) {
                    long jMo1488n = this.f7868q.mo1488n(c2409u3, Math.min(j, i));
                    if (jMo1488n == -1) {
                        return -1L;
                    }
                    this.f7866o -= (int) jMo1488n;
                    return jMo1488n;
                }
                this.f7868q.mo7347r(this.f7867p);
                this.f7867p = 0;
                if ((this.f7864m & 4) != 0) {
                    return -1L;
                }
                m10559b();
            }
        }

        @Override
        public void close() {
        }
    }
}
