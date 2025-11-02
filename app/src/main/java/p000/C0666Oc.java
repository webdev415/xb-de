package p000;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class C0666Oc implements InterfaceC2161om {

    public byte f2041l;

    public final C1648dk f2042m;

    public final Inflater f2043n;

    public final C1968ke f2044o;

    public final CRC32 f2045p;

    public C0666Oc(InterfaceC2161om interfaceC2161om) {
        AbstractC0116Ce.m476e(interfaceC2161om, "source");
        C1648dk c1648dk = new C1648dk(interfaceC2161om);
        this.f2042m = c1648dk;
        Inflater inflater = new Inflater(true);
        this.f2043n = inflater;
        this.f2044o = new C1968ke(c1648dk, inflater);
        this.f2045p = new CRC32();
    }

    public final void m3414a(String str, int i, int i2) throws IOException {
        if (i2 == i) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3));
        AbstractC0116Ce.m475d(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    public final void m3415b() throws IOException {
        this.f2042m.mo7332G(10L);
        byte bM9932z = this.f2042m.f5325l.m9932z(3L);
        boolean z = ((bM9932z >> 1) & 1) == 1;
        if (z) {
            m3417i(this.f2042m.f5325l, 0L, 10L);
        }
        m3414a("ID1ID2", 8075, this.f2042m.mo7348s());
        this.f2042m.mo7347r(8L);
        if (((bM9932z >> 2) & 1) == 1) {
            this.f2042m.mo7332G(2L);
            if (z) {
                m3417i(this.f2042m.f5325l, 0L, 2L);
            }
            long jM9906T = this.f2042m.f5325l.m9906T();
            this.f2042m.mo7332G(jM9906T);
            if (z) {
                m3417i(this.f2042m.f5325l, 0L, jM9906T);
            }
            this.f2042m.mo7347r(jM9906T);
        }
        if (((bM9932z >> 3) & 1) == 1) {
            long jM7339a = this.f2042m.m7339a((byte) 0);
            if (jM7339a == -1) {
                throw new EOFException();
            }
            if (z) {
                m3417i(this.f2042m.f5325l, 0L, jM7339a + 1);
            }
            this.f2042m.mo7347r(jM7339a + 1);
        }
        if (((bM9932z >> 4) & 1) == 1) {
            long jM7339a2 = this.f2042m.m7339a((byte) 0);
            if (jM7339a2 == -1) {
                throw new EOFException();
            }
            if (z) {
                m3417i(this.f2042m.f5325l, 0L, jM7339a2 + 1);
            }
            this.f2042m.mo7347r(jM7339a2 + 1);
        }
        if (z) {
            m3414a("FHCRC", this.f2042m.m7343i(), (short) this.f2045p.getValue());
            this.f2045p.reset();
        }
    }

    @Override
    public void close() {
        this.f2044o.close();
    }

    @Override
    public C0125Cn mo239d() {
        return this.f2042m.mo239d();
    }

    public final void m3416g() throws IOException {
        m3414a("CRC", this.f2042m.m7342g(), (int) this.f2045p.getValue());
        m3414a("ISIZE", this.f2042m.m7342g(), (int) this.f2043n.getBytesWritten());
    }

    public final void m3417i(C2409u3 c2409u3, long j, long j2) {
        C2482vl c2482vl = c2409u3.f7345l;
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
            int iMin = (int) Math.min(c2482vl.f7760c - r6, j2);
            this.f2045p.update(c2482vl.f7758a, (int) (c2482vl.f7759b + j), iMin);
            j2 -= iMin;
            c2482vl = c2482vl.f7763f;
            AbstractC0116Ce.m473b(c2482vl);
            j = 0;
        }
    }

    @Override
    public long mo1488n(C2409u3 c2409u3, long j) throws DataFormatException, IOException {
        AbstractC0116Ce.m476e(c2409u3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f2041l == 0) {
            m3415b();
            this.f2041l = (byte) 1;
        }
        if (this.f2041l == 1) {
            long jM9911Y = c2409u3.m9911Y();
            long jMo1488n = this.f2044o.mo1488n(c2409u3, j);
            if (jMo1488n != -1) {
                m3417i(c2409u3, jM9911Y, jMo1488n);
                return jMo1488n;
            }
            this.f2041l = (byte) 2;
        }
        if (this.f2041l == 2) {
            m3416g();
            this.f2041l = (byte) 3;
            if (!this.f2042m.mo7333K()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }
}
