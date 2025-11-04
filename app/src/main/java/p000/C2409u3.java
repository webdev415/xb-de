package p000;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

public final class C2409u3 implements InterfaceC2547x3, InterfaceC2501w3, Cloneable, ByteChannel {

    public C2482vl f7345l;

    public long f7346m;

    public static final class a extends InputStream {
        public a() {
        }

        @Override
        public int available() {
            return (int) Math.min(C2409u3.this.m9911Y(), Integer.MAX_VALUE);
        }

        @Override
        public int read() {
            if (C2409u3.this.m9911Y() > 0) {
                return C2409u3.this.mo7338R() & 255;
            }
            return -1;
        }

        public String toString() {
            return C2409u3.this + ".inputStream()";
        }

        @Override
        public int read(byte[] bArr, int i, int i2) {
            AbstractC0116Ce.m476e(bArr, "sink");
            return C2409u3.this.m9902E(bArr, i, i2);
        }

        @Override
        public void close() {
        }
    }

    public long m9899A(byte b, long j, long j2) {
        C2482vl c2482vl;
        int i;
        long jM9911Y = 0;
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("size=" + m9911Y() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > m9911Y()) {
            j2 = m9911Y();
        }
        if (j == j2 || (c2482vl = this.f7345l) == null) {
            return -1L;
        }
        if (m9911Y() - j < j) {
            jM9911Y = m9911Y();
            while (jM9911Y > j) {
                c2482vl = c2482vl.f7764g;
                AbstractC0116Ce.m473b(c2482vl);
                jM9911Y -= c2482vl.f7760c - c2482vl.f7759b;
            }
            while (jM9911Y < j2) {
                byte[] bArr = c2482vl.f7758a;
                int iMin = (int) Math.min(c2482vl.f7760c, (c2482vl.f7759b + j2) - jM9911Y);
                i = (int) ((c2482vl.f7759b + j) - jM9911Y);
                while (i < iMin) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                jM9911Y += c2482vl.f7760c - c2482vl.f7759b;
                c2482vl = c2482vl.f7763f;
                AbstractC0116Ce.m473b(c2482vl);
                j = jM9911Y;
            }
            return -1L;
        }
        while (true) {
            long j3 = (c2482vl.f7760c - c2482vl.f7759b) + jM9911Y;
            if (j3 > j) {
                break;
            }
            c2482vl = c2482vl.f7763f;
            AbstractC0116Ce.m473b(c2482vl);
            jM9911Y = j3;
        }
        while (jM9911Y < j2) {
            byte[] bArr2 = c2482vl.f7758a;
            int iMin2 = (int) Math.min(c2482vl.f7760c, (c2482vl.f7759b + j2) - jM9911Y);
            i = (int) ((c2482vl.f7759b + j) - jM9911Y);
            while (i < iMin2) {
                if (bArr2[i] != b) {
                    i++;
                }
            }
            jM9911Y += c2482vl.f7760c - c2482vl.f7759b;
            c2482vl = c2482vl.f7763f;
            AbstractC0116Ce.m473b(c2482vl);
            j = jM9911Y;
        }
        return -1L;
        return (i - c2482vl.f7759b) + jM9911Y;
    }

    public long m9900B(C0096C3 c0096c3) {
        AbstractC0116Ce.m476e(c0096c3, "targetBytes");
        return m9901C(c0096c3, 0L);
    }

    public long m9901C(C0096C3 c0096c3, long j) {
        int i;
        AbstractC0116Ce.m476e(c0096c3, "targetBytes");
        long jM9911Y = 0;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        C2482vl c2482vl = this.f7345l;
        if (c2482vl == null) {
            return -1L;
        }
        if (m9911Y() - j < j) {
            jM9911Y = m9911Y();
            while (jM9911Y > j) {
                c2482vl = c2482vl.f7764g;
                AbstractC0116Ce.m473b(c2482vl);
                jM9911Y -= c2482vl.f7760c - c2482vl.f7759b;
            }
            if (c0096c3.m387u() == 2) {
                byte bM374h = c0096c3.m374h(0);
                byte bM374h2 = c0096c3.m374h(1);
                while (jM9911Y < m9911Y()) {
                    byte[] bArr = c2482vl.f7758a;
                    i = (int) ((c2482vl.f7759b + j) - jM9911Y);
                    int i2 = c2482vl.f7760c;
                    while (i < i2) {
                        byte b = bArr[i];
                        if (b != bM374h && b != bM374h2) {
                            i++;
                        }
                    }
                    jM9911Y += c2482vl.f7760c - c2482vl.f7759b;
                    c2482vl = c2482vl.f7763f;
                    AbstractC0116Ce.m473b(c2482vl);
                    j = jM9911Y;
                }
                return -1L;
            }
            byte[] bArrMo380n = c0096c3.mo380n();
            while (jM9911Y < m9911Y()) {
                byte[] bArr2 = c2482vl.f7758a;
                i = (int) ((c2482vl.f7759b + j) - jM9911Y);
                int i3 = c2482vl.f7760c;
                while (i < i3) {
                    byte b2 = bArr2[i];
                    for (byte b3 : bArrMo380n) {
                        if (b2 != b3) {
                        }
                    }
                    i++;
                }
                jM9911Y += c2482vl.f7760c - c2482vl.f7759b;
                c2482vl = c2482vl.f7763f;
                AbstractC0116Ce.m473b(c2482vl);
                j = jM9911Y;
            }
            return -1L;
        }
        while (true) {
            long j2 = (c2482vl.f7760c - c2482vl.f7759b) + jM9911Y;
            if (j2 > j) {
                break;
            }
            c2482vl = c2482vl.f7763f;
            AbstractC0116Ce.m473b(c2482vl);
            jM9911Y = j2;
        }
        if (c0096c3.m387u() == 2) {
            byte bM374h3 = c0096c3.m374h(0);
            byte bM374h4 = c0096c3.m374h(1);
            while (jM9911Y < m9911Y()) {
                byte[] bArr3 = c2482vl.f7758a;
                i = (int) ((c2482vl.f7759b + j) - jM9911Y);
                int i4 = c2482vl.f7760c;
                while (i < i4) {
                    byte b4 = bArr3[i];
                    if (b4 != bM374h3 && b4 != bM374h4) {
                        i++;
                    }
                }
                jM9911Y += c2482vl.f7760c - c2482vl.f7759b;
                c2482vl = c2482vl.f7763f;
                AbstractC0116Ce.m473b(c2482vl);
                j = jM9911Y;
            }
            return -1L;
        }
        byte[] bArrMo380n2 = c0096c3.mo380n();
        while (jM9911Y < m9911Y()) {
            byte[] bArr4 = c2482vl.f7758a;
            i = (int) ((c2482vl.f7759b + j) - jM9911Y);
            int i5 = c2482vl.f7760c;
            while (i < i5) {
                byte b5 = bArr4[i];
                for (byte b6 : bArrMo380n2) {
                    if (b5 != b6) {
                    }
                }
                i++;
            }
            jM9911Y += c2482vl.f7760c - c2482vl.f7759b;
            c2482vl = c2482vl.f7763f;
            AbstractC0116Ce.m473b(c2482vl);
            j = jM9911Y;
        }
        return -1L;
        return (i - c2482vl.f7759b) + jM9911Y;
    }

    @Override
    public String mo7330D() {
        return mo7346q(Long.MAX_VALUE);
    }

    public int m9902E(byte[] bArr, int i, int i2) {
        AbstractC0116Ce.m476e(bArr, "sink");
        AbstractC1342c.m5685b(bArr.length, i, i2);
        C2482vl c2482vl = this.f7345l;
        if (c2482vl == null) {
            return -1;
        }
        int iMin = Math.min(i2, c2482vl.f7760c - c2482vl.f7759b);
        byte[] bArr2 = c2482vl.f7758a;
        int i3 = c2482vl.f7759b;
        AbstractC2637z1.m10982d(bArr2, bArr, i, i3, i3 + iMin);
        c2482vl.f7759b += iMin;
        m9910X(m9911Y() - iMin);
        if (c2482vl.f7759b != c2482vl.f7760c) {
            return iMin;
        }
        this.f7345l = c2482vl.m10397b();
        C2528wl.m10594b(c2482vl);
        return iMin;
    }

    @Override
    public byte[] mo7331F() {
        return mo7334N(m9911Y());
    }

    @Override
    public void mo7332G(long j) throws EOFException {
        if (this.f7346m < j) {
            throw new EOFException();
        }
    }

    public C0096C3 m9903I() {
        return mo7345o(m9911Y());
    }

    public void m9904J(byte[] bArr) throws EOFException {
        AbstractC0116Ce.m476e(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int iM9902E = m9902E(bArr, i, bArr.length - i);
            if (iM9902E == -1) {
                throw new EOFException();
            }
            i += iM9902E;
        }
    }

    @Override
    public boolean mo7333K() {
        return this.f7346m == 0;
    }

    @Override
    public byte[] mo7334N(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (m9911Y() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        m9904J(bArr);
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae A[EDGE_INSN: B:43:0x00ae->B:37:0x00ae BREAK  A[LOOP:0: B:5:0x000d->B:45:?], SYNTHETIC] */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo7335O() throws EOFException {
        /*
            r14 = this;
            long r0 = r14.m9911Y()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb8
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            vl r6 = r14.f7345l
            p000.AbstractC0116Ce.m473b(r6)
            byte[] r7 = r6.f7758a
            int r8 = r6.f7759b
            int r9 = r6.f7760c
        L18:
            if (r8 >= r9) goto L9a
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7b
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            u3 r0 = new u3
            r0.<init>()
            u3 r0 = r0.mo5932m(r4)
            u3 r0 = r0.mo5926L(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.m9908V()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L7b:
            if (r0 == 0) goto L7f
            r1 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = p000.AbstractC1342c.m5688e(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9a:
            if (r8 != r9) goto La6
            vl r7 = r6.m10397b()
            r14.f7345l = r7
            p000.C2528wl.m10594b(r6)
            goto La8
        La6:
            r6.f7759b = r8
        La8:
            if (r1 != 0) goto Lae
            vl r6 = r14.f7345l
            if (r6 != 0) goto Ld
        Lae:
            long r1 = r14.m9911Y()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.m9910X(r1)
            return r4
        Lb8:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2409u3.mo7335O():long");
    }

    @Override
    public String mo7336P(Charset charset) {
        AbstractC0116Ce.m476e(charset, "charset");
        return m9907U(this.f7346m, charset);
    }

    @Override
    public InputStream mo7337Q() {
        return new a();
    }

    @Override
    public byte mo7338R() throws EOFException {
        if (m9911Y() == 0) {
            throw new EOFException();
        }
        C2482vl c2482vl = this.f7345l;
        AbstractC0116Ce.m473b(c2482vl);
        int i = c2482vl.f7759b;
        int i2 = c2482vl.f7760c;
        int i3 = i + 1;
        byte b = c2482vl.f7758a[i];
        m9910X(m9911Y() - 1);
        if (i3 == i2) {
            this.f7345l = c2482vl.m10397b();
            C2528wl.m10594b(c2482vl);
        } else {
            c2482vl.f7759b = i3;
        }
        return b;
    }

    public int m9905S() {
        return AbstractC1342c.m5686c(mo7350x());
    }

    public short m9906T() {
        return AbstractC1342c.m5687d(mo7348s());
    }

    public String m9907U(long j, Charset charset) throws EOFException {
        AbstractC0116Ce.m476e(charset, "charset");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (this.f7346m < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        C2482vl c2482vl = this.f7345l;
        AbstractC0116Ce.m473b(c2482vl);
        int i = c2482vl.f7759b;
        if (i + j > c2482vl.f7760c) {
            return new String(mo7334N(j), charset);
        }
        int i2 = (int) j;
        String str = new String(c2482vl.f7758a, i, i2, charset);
        int i3 = c2482vl.f7759b + i2;
        c2482vl.f7759b = i3;
        this.f7346m -= j;
        if (i3 == c2482vl.f7760c) {
            this.f7345l = c2482vl.m10397b();
            C2528wl.m10594b(c2482vl);
        }
        return str;
    }

    public String m9908V() {
        return m9907U(this.f7346m, C2502w4.f7789b);
    }

    public String m9909W(long j) throws EOFException {
        return m9907U(j, C2502w4.f7789b);
    }

    public final void m9910X(long j) {
        this.f7346m = j;
    }

    public final long m9911Y() {
        return this.f7346m;
    }

    public final C0096C3 m9912Z() {
        if (m9911Y() <= ((long) Integer.MAX_VALUE)) {
            return m9914a0((int) m9911Y());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + m9911Y()).toString());
    }

    public final void m9913a() throws EOFException {
        mo7347r(m9911Y());
    }

    public final C0096C3 m9914a0(int i) {
        if (i == 0) {
            return C0096C3.f234o;
        }
        AbstractC1342c.m5685b(m9911Y(), 0L, i);
        C2482vl c2482vl = this.f7345l;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            AbstractC0116Ce.m473b(c2482vl);
            int i5 = c2482vl.f7760c;
            int i6 = c2482vl.f7759b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            c2482vl = c2482vl.f7763f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        C2482vl c2482vl2 = this.f7345l;
        int i7 = 0;
        while (i2 < i) {
            AbstractC0116Ce.m473b(c2482vl2);
            bArr[i7] = c2482vl2.f7758a;
            i2 += c2482vl2.f7760c - c2482vl2.f7759b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = c2482vl2.f7759b;
            c2482vl2.f7761d = true;
            i7++;
            c2482vl2 = c2482vl2.f7763f;
        }
        return new C2574xl(bArr, iArr);
    }

    public C2409u3 clone() {
        return m9930u();
    }

    public final C2482vl m9916b0(int i) {
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        C2482vl c2482vl = this.f7345l;
        if (c2482vl != null) {
            AbstractC0116Ce.m473b(c2482vl);
            C2482vl c2482vl2 = c2482vl.f7764g;
            AbstractC0116Ce.m473b(c2482vl2);
            return (c2482vl2.f7760c + i > 8192 || !c2482vl2.f7762e) ? c2482vl2.m10398c(C2528wl.m10595c()) : c2482vl2;
        }
        C2482vl c2482vlM10595c = C2528wl.m10595c();
        this.f7345l = c2482vlM10595c;
        c2482vlM10595c.f7764g = c2482vlM10595c;
        c2482vlM10595c.f7763f = c2482vlM10595c;
        return c2482vlM10595c;
    }

    @Override
    public C2409u3 mo5927M(C0096C3 c0096c3) {
        AbstractC0116Ce.m476e(c0096c3, "byteString");
        c0096c3.mo391y(this, 0, c0096c3.m387u());
        return this;
    }

    @Override
    public C0125Cn mo239d() {
        return C0125Cn.f305d;
    }

    @Override
    public C2409u3 mo5930e(byte[] bArr) {
        AbstractC0116Ce.m476e(bArr, "source");
        return mo5931f(bArr, 0, bArr.length);
    }

    @Override
    public C2409u3 mo5931f(byte[] bArr, int i, int i2) {
        AbstractC0116Ce.m476e(bArr, "source");
        long j = i2;
        AbstractC1342c.m5685b(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            C2482vl c2482vlM9916b0 = m9916b0(1);
            int iMin = Math.min(i3 - i, 8192 - c2482vlM9916b0.f7760c);
            int i4 = i + iMin;
            AbstractC2637z1.m10982d(bArr, c2482vlM9916b0.f7758a, c2482vlM9916b0.f7760c, i, i4);
            c2482vlM9916b0.f7760c += iMin;
            i = i4;
        }
        m9910X(m9911Y() + j);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2409u3) {
            C2409u3 c2409u3 = (C2409u3) obj;
            if (m9911Y() == c2409u3.m9911Y()) {
                if (m9911Y() == 0) {
                    return true;
                }
                C2482vl c2482vl = this.f7345l;
                AbstractC0116Ce.m473b(c2482vl);
                C2482vl c2482vl2 = c2409u3.f7345l;
                AbstractC0116Ce.m473b(c2482vl2);
                int i = c2482vl.f7759b;
                int i2 = c2482vl2.f7759b;
                long j = 0;
                while (j < m9911Y()) {
                    long jMin = Math.min(c2482vl.f7760c - i, c2482vl2.f7760c - i2);
                    long j2 = 0;
                    while (j2 < jMin) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (c2482vl.f7758a[i] == c2482vl2.f7758a[i2]) {
                            j2++;
                            i = i3;
                            i2 = i4;
                        }
                    }
                    if (i == c2482vl.f7760c) {
                        c2482vl = c2482vl.f7763f;
                        AbstractC0116Ce.m473b(c2482vl);
                        i = c2482vl.f7759b;
                    }
                    if (i2 == c2482vl2.f7760c) {
                        c2482vl2 = c2482vl2.f7763f;
                        AbstractC0116Ce.m473b(c2482vl2);
                        i2 = c2482vl2.f7759b;
                    }
                    j += jMin;
                }
                return true;
            }
        }
        return false;
    }

    public long m9920f0(InterfaceC2161om interfaceC2161om) {
        AbstractC0116Ce.m476e(interfaceC2161om, "source");
        long j = 0;
        while (true) {
            long jMo1488n = interfaceC2161om.mo1488n(this, 8192);
            if (jMo1488n == -1) {
                return j;
            }
            j += jMo1488n;
        }
    }

    @Override
    public C2409u3 mo5926L(int i) {
        C2482vl c2482vlM9916b0 = m9916b0(1);
        byte[] bArr = c2482vlM9916b0.f7758a;
        int i2 = c2482vlM9916b0.f7760c;
        c2482vlM9916b0.f7760c = i2 + 1;
        bArr[i2] = (byte) i;
        m9910X(m9911Y() + 1);
        return this;
    }

    @Override
    public void mo115h(C2409u3 c2409u3, long j) {
        C2482vl c2482vl;
        AbstractC0116Ce.m476e(c2409u3, "source");
        if (!(c2409u3 != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        AbstractC1342c.m5685b(c2409u3.m9911Y(), 0L, j);
        while (j > 0) {
            C2482vl c2482vl2 = c2409u3.f7345l;
            AbstractC0116Ce.m473b(c2482vl2);
            int i = c2482vl2.f7760c;
            AbstractC0116Ce.m473b(c2409u3.f7345l);
            if (j < i - r2.f7759b) {
                C2482vl c2482vl3 = this.f7345l;
                if (c2482vl3 != null) {
                    AbstractC0116Ce.m473b(c2482vl3);
                    c2482vl = c2482vl3.f7764g;
                } else {
                    c2482vl = null;
                }
                if (c2482vl != null && c2482vl.f7762e) {
                    if ((c2482vl.f7760c + j) - (c2482vl.f7761d ? 0 : c2482vl.f7759b) <= 8192) {
                        C2482vl c2482vl4 = c2409u3.f7345l;
                        AbstractC0116Ce.m473b(c2482vl4);
                        c2482vl4.m10401f(c2482vl, (int) j);
                        c2409u3.m9910X(c2409u3.m9911Y() - j);
                        m9910X(m9911Y() + j);
                        return;
                    }
                }
                C2482vl c2482vl5 = c2409u3.f7345l;
                AbstractC0116Ce.m473b(c2482vl5);
                c2409u3.f7345l = c2482vl5.m10400e((int) j);
            }
            C2482vl c2482vl6 = c2409u3.f7345l;
            AbstractC0116Ce.m473b(c2482vl6);
            long j2 = c2482vl6.f7760c - c2482vl6.f7759b;
            c2409u3.f7345l = c2482vl6.m10397b();
            C2482vl c2482vl7 = this.f7345l;
            if (c2482vl7 == null) {
                this.f7345l = c2482vl6;
                c2482vl6.f7764g = c2482vl6;
                c2482vl6.f7763f = c2482vl6;
            } else {
                AbstractC0116Ce.m473b(c2482vl7);
                C2482vl c2482vl8 = c2482vl7.f7764g;
                AbstractC0116Ce.m473b(c2482vl8);
                c2482vl8.m10398c(c2482vl6).m10396a();
            }
            c2409u3.m9910X(c2409u3.m9911Y() - j2);
            m9910X(m9911Y() + j2);
            j -= j2;
        }
    }

    @Override
    public C2409u3 mo5932m(long j) {
        if (j == 0) {
            return mo5926L(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        C2482vl c2482vlM9916b0 = m9916b0(i);
        byte[] bArr = c2482vlM9916b0.f7758a;
        int i2 = c2482vlM9916b0.f7760c;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = AbstractC2455v3.m10309a()[(int) (15 & j)];
            j >>>= 4;
        }
        c2482vlM9916b0.f7760c += i;
        m9910X(m9911Y() + i);
        return this;
    }

    public int hashCode() {
        C2482vl c2482vl = this.f7345l;
        if (c2482vl == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c2482vl.f7760c;
            for (int i3 = c2482vl.f7759b; i3 < i2; i3++) {
                i = (i * 31) + c2482vl.f7758a[i3];
            }
            c2482vl = c2482vl.f7763f;
            AbstractC0116Ce.m473b(c2482vl);
        } while (c2482vl != this.f7345l);
        return i;
    }

    @Override
    public C2409u3 mo5934y(int i) {
        C2482vl c2482vlM9916b0 = m9916b0(4);
        byte[] bArr = c2482vlM9916b0.f7758a;
        int i2 = c2482vlM9916b0.f7760c;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        c2482vlM9916b0.f7760c = i2 + 4;
        m9910X(m9911Y() + 4);
        return this;
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    public final long m9924j() {
        long jM9911Y = m9911Y();
        if (jM9911Y == 0) {
            return 0L;
        }
        C2482vl c2482vl = this.f7345l;
        AbstractC0116Ce.m473b(c2482vl);
        C2482vl c2482vl2 = c2482vl.f7764g;
        AbstractC0116Ce.m473b(c2482vl2);
        if (c2482vl2.f7760c < 8192 && c2482vl2.f7762e) {
            jM9911Y -= r3 - c2482vl2.f7759b;
        }
        return jM9911Y;
    }

    @Override
    public C2409u3 mo5933t(int i) {
        C2482vl c2482vlM9916b0 = m9916b0(2);
        byte[] bArr = c2482vlM9916b0.f7758a;
        int i2 = c2482vlM9916b0.f7760c;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        c2482vlM9916b0.f7760c = i2 + 2;
        m9910X(m9911Y() + 2);
        return this;
    }

    public C2409u3 m9926k0(String str, int i, int i2, Charset charset) {
        AbstractC0116Ce.m476e(str, "string");
        AbstractC0116Ce.m476e(charset, "charset");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (!(i2 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        if (AbstractC0116Ce.m472a(charset, C2502w4.f7789b)) {
            return m9928m0(str, i, i2);
        }
        String strSubstring = str.substring(i, i2);
        AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (strSubstring == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strSubstring.getBytes(charset);
        AbstractC0116Ce.m475d(bytes, "(this as java.lang.String).getBytes(charset)");
        return mo5931f(bytes, 0, bytes.length);
    }

    @Override
    public C2409u3 mo5925H(String str) {
        AbstractC0116Ce.m476e(str, "string");
        return m9928m0(str, 0, str.length());
    }

    public C2409u3 m9928m0(String str, int i, int i2) {
        long jM9911Y;
        long j;
        AbstractC0116Ce.m476e(str, "string");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (!(i2 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                C2482vl c2482vlM9916b0 = m9916b0(1);
                byte[] bArr = c2482vlM9916b0.f7758a;
                int i3 = c2482vlM9916b0.f7760c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt;
                while (i4 < iMin) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) cCharAt2;
                    i4++;
                }
                int i5 = c2482vlM9916b0.f7760c;
                int i6 = (i3 + i4) - i5;
                c2482vlM9916b0.f7760c = i5 + i6;
                m9910X(m9911Y() + i6);
                i = i4;
            } else {
                if (cCharAt < 2048) {
                    C2482vl c2482vlM9916b02 = m9916b0(2);
                    byte[] bArr2 = c2482vlM9916b02.f7758a;
                    int i7 = c2482vlM9916b02.f7760c;
                    bArr2[i7] = (byte) ((cCharAt >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt & '?') | 128);
                    c2482vlM9916b02.f7760c = i7 + 2;
                    jM9911Y = m9911Y();
                    j = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    C2482vl c2482vlM9916b03 = m9916b0(3);
                    byte[] bArr3 = c2482vlM9916b03.f7758a;
                    int i8 = c2482vlM9916b03.f7760c;
                    bArr3[i8] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt & '?') | 128);
                    c2482vlM9916b03.f7760c = i8 + 3;
                    jM9911Y = m9911Y();
                    j = 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        mo5926L(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        C2482vl c2482vlM9916b04 = m9916b0(4);
                        byte[] bArr4 = c2482vlM9916b04.f7758a;
                        int i11 = c2482vlM9916b04.f7760c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        c2482vlM9916b04.f7760c = i11 + 4;
                        m9910X(m9911Y() + 4);
                        i += 2;
                    }
                }
                m9910X(jM9911Y + j);
                i++;
            }
        }
        return this;
    }

    @Override
    public long mo1488n(C2409u3 c2409u3, long j) {
        AbstractC0116Ce.m476e(c2409u3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (m9911Y() == 0) {
            return -1L;
        }
        if (j > m9911Y()) {
            j = m9911Y();
        }
        c2409u3.mo115h(this, j);
        return j;
    }

    public C2409u3 m9929n0(int i) {
        long jM9911Y;
        long j;
        if (i < 128) {
            mo5926L(i);
        } else {
            if (i < 2048) {
                C2482vl c2482vlM9916b0 = m9916b0(2);
                byte[] bArr = c2482vlM9916b0.f7758a;
                int i2 = c2482vlM9916b0.f7760c;
                bArr[i2] = (byte) ((i >> 6) | 192);
                bArr[i2 + 1] = (byte) ((i & 63) | 128);
                c2482vlM9916b0.f7760c = i2 + 2;
                jM9911Y = m9911Y();
                j = 2;
            } else if (55296 <= i && 57343 >= i) {
                mo5926L(63);
            } else if (i < 65536) {
                C2482vl c2482vlM9916b02 = m9916b0(3);
                byte[] bArr2 = c2482vlM9916b02.f7758a;
                int i3 = c2482vlM9916b02.f7760c;
                bArr2[i3] = (byte) ((i >> 12) | 224);
                bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
                bArr2[i3 + 2] = (byte) ((i & 63) | 128);
                c2482vlM9916b02.f7760c = i3 + 3;
                jM9911Y = m9911Y();
                j = 3;
            } else {
                if (i > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: 0x" + AbstractC1342c.m5689f(i));
                }
                C2482vl c2482vlM9916b03 = m9916b0(4);
                byte[] bArr3 = c2482vlM9916b03.f7758a;
                int i4 = c2482vlM9916b03.f7760c;
                bArr3[i4] = (byte) ((i >> 18) | 240);
                bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
                bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
                bArr3[i4 + 3] = (byte) ((i & 63) | 128);
                c2482vlM9916b03.f7760c = i4 + 4;
                jM9911Y = m9911Y();
                j = 4;
            }
            m9910X(jM9911Y + j);
        }
        return this;
    }

    @Override
    public C0096C3 mo7345o(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (m9911Y() < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new C0096C3(mo7334N(j));
        }
        C0096C3 c0096c3M9914a0 = m9914a0((int) j);
        mo7347r(j);
        return c0096c3M9914a0;
    }

    @Override
    public String mo7346q(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        byte b = (byte) 10;
        long jM9899A = m9899A(b, 0L, j2);
        if (jM9899A != -1) {
            return AbstractC2455v3.m10310b(this, jM9899A);
        }
        if (j2 < m9911Y() && m9932z(j2 - 1) == ((byte) 13) && m9932z(j2) == b) {
            return AbstractC2455v3.m10310b(this, j2);
        }
        C2409u3 c2409u3 = new C2409u3();
        m9931w(c2409u3, 0L, Math.min(32, m9911Y()));
        throw new EOFException("\\n not found: limit=" + Math.min(m9911Y(), j) + " content=" + c2409u3.m9903I().mo379m() + (char) 8230);
    }

    @Override
    public void mo7347r(long j) throws EOFException {
        while (j > 0) {
            C2482vl c2482vl = this.f7345l;
            if (c2482vl == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, c2482vl.f7760c - c2482vl.f7759b);
            long j2 = iMin;
            m9910X(m9911Y() - j2);
            j -= j2;
            int i = c2482vl.f7759b + iMin;
            c2482vl.f7759b = i;
            if (i == c2482vl.f7760c) {
                this.f7345l = c2482vl.m10397b();
                C2528wl.m10594b(c2482vl);
            }
        }
    }

    @Override
    public int read(ByteBuffer byteBuffer) {
        AbstractC0116Ce.m476e(byteBuffer, "sink");
        C2482vl c2482vl = this.f7345l;
        if (c2482vl == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), c2482vl.f7760c - c2482vl.f7759b);
        byteBuffer.put(c2482vl.f7758a, c2482vl.f7759b, iMin);
        int i = c2482vl.f7759b + iMin;
        c2482vl.f7759b = i;
        this.f7346m -= iMin;
        if (i == c2482vl.f7760c) {
            this.f7345l = c2482vl.m10397b();
            C2528wl.m10594b(c2482vl);
        }
        return iMin;
    }

    @Override
    public short mo7348s() throws EOFException {
        if (m9911Y() < 2) {
            throw new EOFException();
        }
        C2482vl c2482vl = this.f7345l;
        AbstractC0116Ce.m473b(c2482vl);
        int i = c2482vl.f7759b;
        int i2 = c2482vl.f7760c;
        if (i2 - i < 2) {
            return (short) (((mo7338R() & 255) << 8) | (mo7338R() & 255));
        }
        byte[] bArr = c2482vl.f7758a;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        m9910X(m9911Y() - 2);
        if (i5 == i2) {
            this.f7345l = c2482vl.m10397b();
            C2528wl.m10594b(c2482vl);
        } else {
            c2482vl.f7759b = i5;
        }
        return (short) i6;
    }

    public String toString() {
        return m9912Z().toString();
    }

    public final C2409u3 m9930u() {
        C2409u3 c2409u3 = new C2409u3();
        if (m9911Y() != 0) {
            C2482vl c2482vl = this.f7345l;
            AbstractC0116Ce.m473b(c2482vl);
            C2482vl c2482vlM10399d = c2482vl.m10399d();
            c2409u3.f7345l = c2482vlM10399d;
            c2482vlM10399d.f7764g = c2482vlM10399d;
            c2482vlM10399d.f7763f = c2482vlM10399d;
            for (C2482vl c2482vl2 = c2482vl.f7763f; c2482vl2 != c2482vl; c2482vl2 = c2482vl2.f7763f) {
                C2482vl c2482vl3 = c2482vlM10399d.f7764g;
                AbstractC0116Ce.m473b(c2482vl3);
                AbstractC0116Ce.m473b(c2482vl2);
                c2482vl3.m10398c(c2482vl2.m10399d());
            }
            c2409u3.m9910X(m9911Y());
        }
        return c2409u3;
    }

    @Override
    public int mo7349v(C1739fi c1739fi) throws EOFException {
        AbstractC0116Ce.m476e(c1739fi, "options");
        int iM10312d = AbstractC2455v3.m10312d(this, c1739fi, false, 2, null);
        if (iM10312d == -1) {
            return -1;
        }
        mo7347r(c1739fi.m7596h()[iM10312d].m387u());
        return iM10312d;
    }

    public final C2409u3 m9931w(C2409u3 c2409u3, long j, long j2) {
        AbstractC0116Ce.m476e(c2409u3, "out");
        AbstractC1342c.m5685b(m9911Y(), j, j2);
        if (j2 != 0) {
            c2409u3.m9910X(c2409u3.m9911Y() + j2);
            C2482vl c2482vl = this.f7345l;
            while (true) {
                AbstractC0116Ce.m473b(c2482vl);
                int i = c2482vl.f7760c;
                int i2 = c2482vl.f7759b;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                c2482vl = c2482vl.f7763f;
            }
            while (j2 > 0) {
                AbstractC0116Ce.m473b(c2482vl);
                C2482vl c2482vlM10399d = c2482vl.m10399d();
                int i3 = c2482vlM10399d.f7759b + ((int) j);
                c2482vlM10399d.f7759b = i3;
                c2482vlM10399d.f7760c = Math.min(i3 + ((int) j2), c2482vlM10399d.f7760c);
                C2482vl c2482vl2 = c2409u3.f7345l;
                if (c2482vl2 == null) {
                    c2482vlM10399d.f7764g = c2482vlM10399d;
                    c2482vlM10399d.f7763f = c2482vlM10399d;
                    c2409u3.f7345l = c2482vlM10399d;
                } else {
                    AbstractC0116Ce.m473b(c2482vl2);
                    C2482vl c2482vl3 = c2482vl2.f7764g;
                    AbstractC0116Ce.m473b(c2482vl3);
                    c2482vl3.m10398c(c2482vlM10399d);
                }
                j2 -= c2482vlM10399d.f7760c - c2482vlM10399d.f7759b;
                c2482vl = c2482vl.f7763f;
                j = 0;
            }
        }
        return this;
    }

    @Override
    public int write(ByteBuffer byteBuffer) {
        AbstractC0116Ce.m476e(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            C2482vl c2482vlM9916b0 = m9916b0(1);
            int iMin = Math.min(i, 8192 - c2482vlM9916b0.f7760c);
            byteBuffer.get(c2482vlM9916b0.f7758a, c2482vlM9916b0.f7760c, iMin);
            i -= iMin;
            c2482vlM9916b0.f7760c += iMin;
        }
        this.f7346m += iRemaining;
        return iRemaining;
    }

    @Override
    public int mo7350x() throws EOFException {
        if (m9911Y() < 4) {
            throw new EOFException();
        }
        C2482vl c2482vl = this.f7345l;
        AbstractC0116Ce.m473b(c2482vl);
        int i = c2482vl.f7759b;
        int i2 = c2482vl.f7760c;
        if (i2 - i < 4) {
            return ((mo7338R() & 255) << 24) | ((mo7338R() & 255) << 16) | ((mo7338R() & 255) << 8) | (mo7338R() & 255);
        }
        byte[] bArr = c2482vl.f7758a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        m9910X(m9911Y() - 4);
        if (i5 == i2) {
            this.f7345l = c2482vl.m10397b();
            C2528wl.m10594b(c2482vl);
        } else {
            c2482vl.f7759b = i5;
        }
        return i6;
    }

    public final byte m9932z(long j) {
        AbstractC1342c.m5685b(m9911Y(), j, 1L);
        C2482vl c2482vl = this.f7345l;
        if (c2482vl == null) {
            AbstractC0116Ce.m473b(null);
            throw null;
        }
        if (m9911Y() - j < j) {
            long jM9911Y = m9911Y();
            while (jM9911Y > j) {
                c2482vl = c2482vl.f7764g;
                AbstractC0116Ce.m473b(c2482vl);
                jM9911Y -= c2482vl.f7760c - c2482vl.f7759b;
            }
            AbstractC0116Ce.m473b(c2482vl);
            return c2482vl.f7758a[(int) ((c2482vl.f7759b + j) - jM9911Y)];
        }
        long j2 = 0;
        while (true) {
            long j3 = (c2482vl.f7760c - c2482vl.f7759b) + j2;
            if (j3 > j) {
                AbstractC0116Ce.m473b(c2482vl);
                return c2482vl.f7758a[(int) ((c2482vl.f7759b + j) - j2)];
            }
            c2482vl = c2482vl.f7763f;
            AbstractC0116Ce.m473b(c2482vl);
            j2 = j3;
        }
    }

    @Override
    public C2409u3 mo7341c() {
        return this;
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }
}
