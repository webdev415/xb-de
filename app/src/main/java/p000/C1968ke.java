package p000;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class C1968ke implements InterfaceC2161om {

    public int f6016l;

    public boolean f6017m;

    public final InterfaceC2547x3 f6018n;

    public final Inflater f6019o;

    public C1968ke(InterfaceC2547x3 interfaceC2547x3, Inflater inflater) {
        AbstractC0116Ce.m476e(interfaceC2547x3, "source");
        AbstractC0116Ce.m476e(inflater, "inflater");
        this.f6018n = interfaceC2547x3;
        this.f6019o = inflater;
    }

    public final long m8293a(C2409u3 c2409u3, long j) throws DataFormatException, IOException {
        AbstractC0116Ce.m476e(c2409u3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!this.f6017m)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j == 0) {
            return 0L;
        }
        try {
            C2482vl c2482vlM9916b0 = c2409u3.m9916b0(1);
            int iMin = (int) Math.min(j, 8192 - c2482vlM9916b0.f7760c);
            m8294b();
            int iInflate = this.f6019o.inflate(c2482vlM9916b0.f7758a, c2482vlM9916b0.f7760c, iMin);
            m8295g();
            if (iInflate > 0) {
                c2482vlM9916b0.f7760c += iInflate;
                long j2 = iInflate;
                c2409u3.m9910X(c2409u3.m9911Y() + j2);
                return j2;
            }
            if (c2482vlM9916b0.f7759b == c2482vlM9916b0.f7760c) {
                c2409u3.f7345l = c2482vlM9916b0.m10397b();
                C2528wl.m10594b(c2482vlM9916b0);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    public final boolean m8294b() {
        if (!this.f6019o.needsInput()) {
            return false;
        }
        if (this.f6018n.mo7333K()) {
            return true;
        }
        C2482vl c2482vl = this.f6018n.mo7341c().f7345l;
        AbstractC0116Ce.m473b(c2482vl);
        int i = c2482vl.f7760c;
        int i2 = c2482vl.f7759b;
        int i3 = i - i2;
        this.f6016l = i3;
        this.f6019o.setInput(c2482vl.f7758a, i2, i3);
        return false;
    }

    @Override
    public void close() {
        if (this.f6017m) {
            return;
        }
        this.f6019o.end();
        this.f6017m = true;
        this.f6018n.close();
    }

    @Override
    public C0125Cn mo239d() {
        return this.f6018n.mo239d();
    }

    public final void m8295g() {
        int i = this.f6016l;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f6019o.getRemaining();
        this.f6016l -= remaining;
        this.f6018n.mo7347r(remaining);
    }

    @Override
    public long mo1488n(C2409u3 c2409u3, long j) throws DataFormatException, IOException {
        AbstractC0116Ce.m476e(c2409u3, "sink");
        do {
            long jM8293a = m8293a(c2409u3, j);
            if (jM8293a > 0) {
                return jM8293a;
            }
            if (this.f6019o.finished() || this.f6019o.needsDictionary()) {
                return -1L;
            }
        } while (!this.f6018n.mo7333K());
        throw new EOFException("source exhausted prematurely");
    }
}
