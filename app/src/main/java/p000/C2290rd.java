package p000;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class C2290rd {

    public static final C1033Wc[] f6932a;

    public static final Map f6933b;

    public static final C2290rd f6934c;

    public static final class a {

        public final List f6935a;

        public final InterfaceC2547x3 f6936b;

        public C1033Wc[] f6937c;

        public int f6938d;

        public int f6939e;

        public int f6940f;

        public final int f6941g;

        public int f6942h;

        public a(InterfaceC2161om interfaceC2161om, int i, int i2) {
            AbstractC0116Ce.m476e(interfaceC2161om, "source");
            this.f6941g = i;
            this.f6942h = i2;
            this.f6935a = new ArrayList<>();
            this.f6936b = AbstractC0487Kh.m2376b(interfaceC2161om);
            this.f6937c = new C1033Wc[8];
            this.f6938d = r2.length - 1;
        }

        public final void m9386a() {
            int i = this.f6942h;
            int i2 = this.f6940f;
            if (i < i2) {
                if (i == 0) {
                    m9387b();
                } else {
                    m9389d(i2 - i);
                }
            }
        }

        public final void m9387b() {
            AbstractC2637z1.m10988j(this.f6937c, null, 0, 0, 6, null);
            this.f6938d = this.f6937c.length - 1;
            this.f6939e = 0;
            this.f6940f = 0;
        }

        public final int m9388c(int i) {
            return this.f6938d + 1 + i;
        }

        public final int m9389d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f6937c.length;
                while (true) {
                    length--;
                    i2 = this.f6938d;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C1033Wc c1033Wc = this.f6937c[length];
                    AbstractC0116Ce.m473b(c1033Wc);
                    int i4 = c1033Wc.f3059a;
                    i -= i4;
                    this.f6940f -= i4;
                    this.f6939e--;
                    i3++;
                }
                C1033Wc[] c1033WcArr = this.f6937c;
                System.arraycopy(c1033WcArr, i2 + 1, c1033WcArr, i2 + 1 + i3, this.f6939e);
                this.f6938d += i3;
            }
            return i3;
        }

        public final List m9390e() {
            List listM9019G = AbstractC2181p5.m9019G(this.f6935a);
            this.f6935a.clear();
            return listM9019G;
        }

        public final C0096C3 m9391f(int i) throws IOException {
            C1033Wc c1033Wc;
            if (!m9393h(i)) {
                int iM9388c = m9388c(i - C2290rd.f6934c.m9384c().length);
                if (iM9388c >= 0) {
                    C1033Wc[] c1033WcArr = this.f6937c;
                    if (iM9388c < c1033WcArr.length) {
                        c1033Wc = c1033WcArr[iM9388c];
                        AbstractC0116Ce.m473b(c1033Wc);
                    }
                }
                throw new IOException("Header index too large " + (i + 1));
            }
            c1033Wc = C2290rd.f6934c.m9384c()[i];
            return c1033Wc.f3060b;
        }

        public final void m9392g(int i, C1033Wc c1033Wc) {
            this.f6935a.add(c1033Wc);
            int i2 = c1033Wc.f3059a;
            if (i != -1) {
                C1033Wc c1033Wc2 = this.f6937c[m9388c(i)];
                AbstractC0116Ce.m473b(c1033Wc2);
                i2 -= c1033Wc2.f3059a;
            }
            int i3 = this.f6942h;
            if (i2 > i3) {
                m9387b();
                return;
            }
            int iM9389d = m9389d((this.f6940f + i2) - i3);
            if (i == -1) {
                int i4 = this.f6939e + 1;
                C1033Wc[] c1033WcArr = this.f6937c;
                if (i4 > c1033WcArr.length) {
                    C1033Wc[] c1033WcArr2 = new C1033Wc[c1033WcArr.length * 2];
                    System.arraycopy(c1033WcArr, 0, c1033WcArr2, c1033WcArr.length, c1033WcArr.length);
                    this.f6938d = this.f6937c.length - 1;
                    this.f6937c = c1033WcArr2;
                }
                int i5 = this.f6938d;
                this.f6938d = i5 - 1;
                this.f6937c[i5] = c1033Wc;
                this.f6939e++;
            } else {
                this.f6937c[i + m9388c(i) + iM9389d] = c1033Wc;
            }
            this.f6940f += i2;
        }

        public final boolean m9393h(int i) {
            return i >= 0 && i <= C2290rd.f6934c.m9384c().length - 1;
        }

        public final int m9394i() {
            return AbstractC2623yo.m10927b(this.f6936b.mo7338R(), 255);
        }

        public final C0096C3 m9395j() {
            int iM9394i = m9394i();
            boolean z = (iM9394i & 128) == 128;
            long jM9398m = m9398m(iM9394i, 127);
            if (!z) {
                return this.f6936b.mo7345o(jM9398m);
            }
            C2409u3 c2409u3 = new C2409u3();
            C0161Dd.f398d.m698b(this.f6936b, jM9398m, c2409u3);
            return c2409u3.m9903I();
        }

        public final void m9396k() throws IOException {
            while (!this.f6936b.mo7333K()) {
                int iM10927b = AbstractC2623yo.m10927b(this.f6936b.mo7338R(), 255);
                if (iM10927b == 128) {
                    throw new IOException("index == 0");
                }
                if ((iM10927b & 128) == 128) {
                    m9397l(m9398m(iM10927b, 127) - 1);
                } else if (iM10927b == 64) {
                    m9400o();
                } else if ((iM10927b & 64) == 64) {
                    m9399n(m9398m(iM10927b, 63) - 1);
                } else if ((iM10927b & 32) == 32) {
                    int iM9398m = m9398m(iM10927b, 31);
                    this.f6942h = iM9398m;
                    if (iM9398m < 0 || iM9398m > this.f6941g) {
                        throw new IOException("Invalid dynamic table size update " + this.f6942h);
                    }
                    m9386a();
                } else if (iM10927b == 16 || iM10927b == 0) {
                    m9402q();
                } else {
                    m9401p(m9398m(iM10927b, 15) - 1);
                }
            }
        }

        public final void m9397l(int i) throws IOException {
            if (m9393h(i)) {
                this.f6935a.add(C2290rd.f6934c.m9384c()[i]);
                return;
            }
            int iM9388c = m9388c(i - C2290rd.f6934c.m9384c().length);
            if (iM9388c >= 0) {
                C1033Wc[] c1033WcArr = this.f6937c;
                if (iM9388c < c1033WcArr.length) {
                    List list = this.f6935a;
                    C1033Wc c1033Wc = c1033WcArr[iM9388c];
                    AbstractC0116Ce.m473b(c1033Wc);
                    list.add(c1033Wc);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final int m9398m(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iM9394i = m9394i();
                if ((iM9394i & 128) == 0) {
                    return i2 + (iM9394i << i4);
                }
                i2 += (iM9394i & 127) << i4;
                i4 += 7;
            }
        }

        public final void m9399n(int i) {
            m9392g(-1, new C1033Wc(m9391f(i), m9395j()));
        }

        public final void m9400o() {
            m9392g(-1, new C1033Wc(C2290rd.f6934c.m9382a(m9395j()), m9395j()));
        }

        public final void m9401p(int i) throws IOException {
            this.f6935a.add(new C1033Wc(m9391f(i), m9395j()));
        }

        public final void m9402q() throws IOException {
            this.f6935a.add(new C1033Wc(C2290rd.f6934c.m9382a(m9395j()), m9395j()));
        }

        public a(InterfaceC2161om interfaceC2161om, int i, int i2, int i3, AbstractC0881T7 abstractC0881T7) {
            this(interfaceC2161om, i, (i3 & 4) != 0 ? i : i2);
        }
    }

    public static final class b {

        public int f6943a;

        public boolean f6944b;

        public int f6945c;

        public C1033Wc[] f6946d;

        public int f6947e;

        public int f6948f;

        public int f6949g;

        public int f6950h;

        public final boolean f6951i;

        public final C2409u3 f6952j;

        public b(int i, boolean z, C2409u3 c2409u3) {
            AbstractC0116Ce.m476e(c2409u3, "out");
            this.f6950h = i;
            this.f6951i = z;
            this.f6952j = c2409u3;
            this.f6943a = Integer.MAX_VALUE;
            this.f6945c = i;
            this.f6946d = new C1033Wc[8];
            this.f6947e = r2.length - 1;
        }

        public final void m9403a() {
            int i = this.f6945c;
            int i2 = this.f6949g;
            if (i < i2) {
                if (i == 0) {
                    m9404b();
                } else {
                    m9405c(i2 - i);
                }
            }
        }

        public final void m9404b() {
            AbstractC2637z1.m10988j(this.f6946d, null, 0, 0, 6, null);
            this.f6947e = this.f6946d.length - 1;
            this.f6948f = 0;
            this.f6949g = 0;
        }

        public final int m9405c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f6946d.length;
                while (true) {
                    length--;
                    i2 = this.f6947e;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C1033Wc c1033Wc = this.f6946d[length];
                    AbstractC0116Ce.m473b(c1033Wc);
                    i -= c1033Wc.f3059a;
                    int i4 = this.f6949g;
                    C1033Wc c1033Wc2 = this.f6946d[length];
                    AbstractC0116Ce.m473b(c1033Wc2);
                    this.f6949g = i4 - c1033Wc2.f3059a;
                    this.f6948f--;
                    i3++;
                }
                C1033Wc[] c1033WcArr = this.f6946d;
                System.arraycopy(c1033WcArr, i2 + 1, c1033WcArr, i2 + 1 + i3, this.f6948f);
                C1033Wc[] c1033WcArr2 = this.f6946d;
                int i5 = this.f6947e;
                Arrays.fill(c1033WcArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.f6947e += i3;
            }
            return i3;
        }

        public final void m9406d(C1033Wc c1033Wc) {
            int i = c1033Wc.f3059a;
            int i2 = this.f6945c;
            if (i > i2) {
                m9404b();
                return;
            }
            m9405c((this.f6949g + i) - i2);
            int i3 = this.f6948f + 1;
            C1033Wc[] c1033WcArr = this.f6946d;
            if (i3 > c1033WcArr.length) {
                C1033Wc[] c1033WcArr2 = new C1033Wc[c1033WcArr.length * 2];
                System.arraycopy(c1033WcArr, 0, c1033WcArr2, c1033WcArr.length, c1033WcArr.length);
                this.f6947e = this.f6946d.length - 1;
                this.f6946d = c1033WcArr2;
            }
            int i4 = this.f6947e;
            this.f6947e = i4 - 1;
            this.f6946d[i4] = c1033Wc;
            this.f6948f++;
            this.f6949g += i;
        }

        public final void m9407e(int i) {
            this.f6950h = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.f6945c;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.f6943a = Math.min(this.f6943a, iMin);
            }
            this.f6944b = true;
            this.f6945c = iMin;
            m9403a();
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m9408f(C0096C3 r5) {
            /*
                r4 = this;
                java.lang.String r0 = "data"
                p000.AbstractC0116Ce.m476e(r5, r0)
                boolean r0 = r4.f6951i
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 == 0) goto L32
                Dd r0 = p000.C0161Dd.f398d
                int r2 = r0.m700d(r5)
                int r3 = r5.m387u()
                if (r2 >= r3) goto L32
                u3 r2 = new u3
                r2.<init>()
                r0.m699c(r5, r2)
                C3 r5 = r2.m9903I()
                int r0 = r5.m387u()
                r2 = 128(0x80, float:1.8E-43)
            L29:
                r4.m9410h(r0, r1, r2)
                u3 r0 = r4.f6952j
                r0.mo5927M(r5)
                goto L38
            L32:
                int r0 = r5.m387u()
                r2 = 0
                goto L29
            L38:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C2290rd.b.m9408f(C3):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m9409g(List r13) {
            /*
                Method dump skipped, instructions count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C2290rd.b.m9409g(java.util.List):void");
        }

        public final void m9410h(int i, int i2, int i3) {
            int i4;
            C2409u3 c2409u3;
            if (i < i2) {
                c2409u3 = this.f6952j;
                i4 = i | i3;
            } else {
                this.f6952j.mo5926L(i3 | i2);
                i4 = i - i2;
                while (i4 >= 128) {
                    this.f6952j.mo5926L(128 | (i4 & 127));
                    i4 >>>= 7;
                }
                c2409u3 = this.f6952j;
            }
            c2409u3.mo5926L(i4);
        }

        public b(int i, boolean z, C2409u3 c2409u3, int i2, AbstractC0881T7 abstractC0881T7) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, c2409u3);
        }
    }

    static {
        C2290rd c2290rd = new C2290rd();
        f6934c = c2290rd;
        C1033Wc c1033Wc = new C1033Wc(C1033Wc.f3057i, "");
        C0096C3 c0096c3 = C1033Wc.f3054f;
        C1033Wc c1033Wc2 = new C1033Wc(c0096c3, "GET");
        C1033Wc c1033Wc3 = new C1033Wc(c0096c3, "POST");
        C0096C3 c0096c32 = C1033Wc.f3055g;
        C1033Wc c1033Wc4 = new C1033Wc(c0096c32, "/");
        C1033Wc c1033Wc5 = new C1033Wc(c0096c32, "/index.html");
        C0096C3 c0096c33 = C1033Wc.f3056h;
        C1033Wc c1033Wc6 = new C1033Wc(c0096c33, "http");
        C1033Wc c1033Wc7 = new C1033Wc(c0096c33, "https");
        C0096C3 c0096c34 = C1033Wc.f3053e;
        f6932a = new C1033Wc[]{c1033Wc, c1033Wc2, c1033Wc3, c1033Wc4, c1033Wc5, c1033Wc6, c1033Wc7, new C1033Wc(c0096c34, "200"), new C1033Wc(c0096c34, "204"), new C1033Wc(c0096c34, "206"), new C1033Wc(c0096c34, "304"), new C1033Wc(c0096c34, "400"), new C1033Wc(c0096c34, "404"), new C1033Wc(c0096c34, "500"), new C1033Wc("accept-charset", ""), new C1033Wc("accept-encoding", "gzip, deflate"), new C1033Wc("accept-language", ""), new C1033Wc("accept-ranges", ""), new C1033Wc("accept", ""), new C1033Wc("access-control-allow-origin", ""), new C1033Wc("age", ""), new C1033Wc("allow", ""), new C1033Wc("authorization", ""), new C1033Wc("cache-control", ""), new C1033Wc("content-disposition", ""), new C1033Wc("content-encoding", ""), new C1033Wc("content-language", ""), new C1033Wc("content-length", ""), new C1033Wc("content-location", ""), new C1033Wc("content-range", ""), new C1033Wc("content-type", ""), new C1033Wc("cookie", ""), new C1033Wc("date", ""), new C1033Wc("etag", ""), new C1033Wc("expect", ""), new C1033Wc("expires", ""), new C1033Wc("from", ""), new C1033Wc("host", ""), new C1033Wc("if-match", ""), new C1033Wc("if-modified-since", ""), new C1033Wc("if-none-match", ""), new C1033Wc("if-range", ""), new C1033Wc("if-unmodified-since", ""), new C1033Wc("last-modified", ""), new C1033Wc("link", ""), new C1033Wc("location", ""), new C1033Wc("max-forwards", ""), new C1033Wc("proxy-authenticate", ""), new C1033Wc("proxy-authorization", ""), new C1033Wc("range", ""), new C1033Wc("referer", ""), new C1033Wc("refresh", ""), new C1033Wc("retry-after", ""), new C1033Wc("server", ""), new C1033Wc("set-cookie", ""), new C1033Wc("strict-transport-security", ""), new C1033Wc("transfer-encoding", ""), new C1033Wc("user-agent", ""), new C1033Wc("vary", ""), new C1033Wc("via", ""), new C1033Wc("www-authenticate", "")};
        f6933b = c2290rd.m9385d();
    }

    public final C0096C3 m9382a(C0096C3 c0096c3) throws IOException {
        AbstractC0116Ce.m476e(c0096c3, "name");
        int iM387u = c0096c3.m387u();
        for (int i = 0; i < iM387u; i++) {
            byte b2 = (byte) 65;
            byte b3 = (byte) 90;
            byte bM374h = c0096c3.m374h(i);
            if (b2 <= bM374h && b3 >= bM374h) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + c0096c3.m390x());
            }
        }
        return c0096c3;
    }

    public final Map m9383b() {
        return f6933b;
    }

    public final C1033Wc[] m9384c() {
        return f6932a;
    }

    public final Map m9385d() {
        C1033Wc[] c1033WcArr = f6932a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(c1033WcArr.length);
        int length = c1033WcArr.length;
        for (int i = 0; i < length; i++) {
            C1033Wc[] c1033WcArr2 = f6932a;
            if (!linkedHashMap.containsKey(c1033WcArr2[i].f3060b)) {
                linkedHashMap.put(c1033WcArr2[i].f3060b, Integer.valueOf(i));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        AbstractC0116Ce.m475d(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }
}
