package p000;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class C1648dk implements InterfaceC2547x3 {

    public final C2409u3 f5325l;

    public boolean f5326m;

    public final InterfaceC2161om f5327n;

    public static final class a extends InputStream {
        public a() {
        }

        @Override
        public int available() throws IOException {
            C1648dk c1648dk = C1648dk.this;
            if (c1648dk.f5326m) {
                throw new IOException("closed");
            }
            return (int) Math.min(c1648dk.f5325l.m9911Y(), Integer.MAX_VALUE);
        }

        @Override
        public void close() throws EOFException {
            C1648dk.this.close();
        }

        @Override
        public int read() throws IOException {
            C1648dk c1648dk = C1648dk.this;
            if (c1648dk.f5326m) {
                throw new IOException("closed");
            }
            if (c1648dk.f5325l.m9911Y() == 0) {
                C1648dk c1648dk2 = C1648dk.this;
                if (c1648dk2.f5327n.mo1488n(c1648dk2.f5325l, 8192) == -1) {
                    return -1;
                }
            }
            return C1648dk.this.f5325l.mo7338R() & 255;
        }

        public String toString() {
            return C1648dk.this + ".inputStream()";
        }

        @Override
        public int read(byte[] bArr, int i, int i2) throws IOException {
            AbstractC0116Ce.m476e(bArr, "data");
            if (C1648dk.this.f5326m) {
                throw new IOException("closed");
            }
            AbstractC1342c.m5685b(bArr.length, i, i2);
            if (C1648dk.this.f5325l.m9911Y() == 0) {
                C1648dk c1648dk = C1648dk.this;
                if (c1648dk.f5327n.mo1488n(c1648dk.f5325l, 8192) == -1) {
                    return -1;
                }
            }
            return C1648dk.this.f5325l.m9902E(bArr, i, i2);
        }
    }

    public C1648dk(InterfaceC2161om interfaceC2161om) {
        AbstractC0116Ce.m476e(interfaceC2161om, "source");
        this.f5327n = interfaceC2161om;
        this.f5325l = new C2409u3();
    }

    @Override
    public String mo7330D() {
        return mo7346q(Long.MAX_VALUE);
    }

    @Override
    public byte[] mo7331F() {
        this.f5325l.m9920f0(this.f5327n);
        return this.f5325l.mo7331F();
    }

    @Override
    public void mo7332G(long j) throws EOFException {
        if (!m7344j(j)) {
            throw new EOFException();
        }
    }

    @Override
    public boolean mo7333K() {
        if (!this.f5326m) {
            return this.f5325l.mo7333K() && this.f5327n.mo1488n(this.f5325l, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override
    public byte[] mo7334N(long j) throws EOFException {
        mo7332G(j);
        return this.f5325l.mo7334N(j);
    }

    @Override
    public long mo7335O() throws EOFException {
        byte bM9932z;
        mo7332G(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!m7344j(i2)) {
                break;
            }
            bM9932z = this.f5325l.m9932z(i);
            if ((bM9932z < ((byte) 48) || bM9932z > ((byte) 57)) && ((bM9932z < ((byte) 97) || bM9932z > ((byte) 102)) && (bM9932z < ((byte) 65) || bM9932z > ((byte) 70)))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bM9932z, AbstractC2410u4.m9933a(AbstractC2410u4.m9933a(16)));
            AbstractC0116Ce.m475d(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(string);
            throw new NumberFormatException(sb.toString());
        }
        return this.f5325l.mo7335O();
    }

    @Override
    public String mo7336P(Charset charset) {
        AbstractC0116Ce.m476e(charset, "charset");
        this.f5325l.m9920f0(this.f5327n);
        return this.f5325l.mo7336P(charset);
    }

    @Override
    public InputStream mo7337Q() {
        return new a();
    }

    @Override
    public byte mo7338R() throws EOFException {
        mo7332G(1L);
        return this.f5325l.mo7338R();
    }

    public long m7339a(byte b) {
        return m7340b(b, 0L, Long.MAX_VALUE);
    }

    public long m7340b(byte b, long j, long j2) {
        if (!(!this.f5326m)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jM9899A = this.f5325l.m9899A(b, j, j2);
            if (jM9899A != -1) {
                return jM9899A;
            }
            long jM9911Y = this.f5325l.m9911Y();
            if (jM9911Y >= j2 || this.f5327n.mo1488n(this.f5325l, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, jM9911Y);
        }
        return -1L;
    }

    @Override
    public C2409u3 mo7341c() {
        return this.f5325l;
    }

    @Override
    public void close() throws EOFException {
        if (this.f5326m) {
            return;
        }
        this.f5326m = true;
        this.f5327n.close();
        this.f5325l.m9913a();
    }

    @Override
    public C0125Cn mo239d() {
        return this.f5327n.mo239d();
    }

    public int m7342g() throws EOFException {
        mo7332G(4L);
        return this.f5325l.m9905S();
    }

    public short m7343i() throws EOFException {
        mo7332G(2L);
        return this.f5325l.m9906T();
    }

    @Override
    public boolean isOpen() {
        return !this.f5326m;
    }

    public boolean m7344j(long j) {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!this.f5326m)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f5325l.m9911Y() < j) {
            if (this.f5327n.mo1488n(this.f5325l, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long mo1488n(C2409u3 c2409u3, long j) {
        AbstractC0116Ce.m476e(c2409u3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!this.f5326m)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f5325l.m9911Y() == 0 && this.f5327n.mo1488n(this.f5325l, 8192) == -1) {
            return -1L;
        }
        return this.f5325l.mo1488n(c2409u3, Math.min(j, this.f5325l.m9911Y()));
    }

    @Override
    public C0096C3 mo7345o(long j) throws EOFException {
        mo7332G(j);
        return this.f5325l.mo7345o(j);
    }

    @Override
    public String mo7346q(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        byte b = (byte) 10;
        long jM7340b = m7340b(b, 0L, j2);
        if (jM7340b != -1) {
            return AbstractC2455v3.m10310b(this.f5325l, jM7340b);
        }
        if (j2 < Long.MAX_VALUE && m7344j(j2) && this.f5325l.m9932z(j2 - 1) == ((byte) 13) && m7344j(1 + j2) && this.f5325l.m9932z(j2) == b) {
            return AbstractC2455v3.m10310b(this.f5325l, j2);
        }
        C2409u3 c2409u3 = new C2409u3();
        C2409u3 c2409u32 = this.f5325l;
        c2409u32.m9931w(c2409u3, 0L, Math.min(32, c2409u32.m9911Y()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f5325l.m9911Y(), j) + " content=" + c2409u3.m9903I().mo379m() + "…");
    }

    @Override
    public void mo7347r(long j) throws EOFException {
        if (!(!this.f5326m)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            if (this.f5325l.m9911Y() == 0 && this.f5327n.mo1488n(this.f5325l, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f5325l.m9911Y());
            this.f5325l.mo7347r(jMin);
            j -= jMin;
        }
    }

    @Override
    public int read(ByteBuffer byteBuffer) {
        AbstractC0116Ce.m476e(byteBuffer, "sink");
        if (this.f5325l.m9911Y() == 0 && this.f5327n.mo1488n(this.f5325l, 8192) == -1) {
            return -1;
        }
        return this.f5325l.read(byteBuffer);
    }

    @Override
    public short mo7348s() throws EOFException {
        mo7332G(2L);
        return this.f5325l.mo7348s();
    }

    public String toString() {
        return "buffer(" + this.f5327n + ')';
    }

    @Override
    public int mo7349v(C1739fi c1739fi) throws EOFException {
        AbstractC0116Ce.m476e(c1739fi, "options");
        if (!(!this.f5326m)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int iM10311c = AbstractC2455v3.m10311c(this.f5325l, c1739fi, true);
            if (iM10311c != -2) {
                if (iM10311c != -1) {
                    this.f5325l.mo7347r(c1739fi.m7596h()[iM10311c].m387u());
                    return iM10311c;
                }
            } else if (this.f5327n.mo1488n(this.f5325l, 8192) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override
    public int mo7350x() throws EOFException {
        mo7332G(4L);
        return this.f5325l.mo7350x();
    }
}
