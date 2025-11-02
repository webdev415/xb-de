package p000;

import java.io.IOException;
import java.io.InputStream;

public final class C2106ne implements InterfaceC2161om {

    public final InputStream f6311l;

    public final C0125Cn f6312m;

    public C2106ne(InputStream inputStream, C0125Cn c0125Cn) {
        AbstractC0116Ce.m476e(inputStream, "input");
        AbstractC0116Ce.m476e(c0125Cn, "timeout");
        this.f6311l = inputStream;
        this.f6312m = c0125Cn;
    }

    @Override
    public void close() throws IOException {
        this.f6311l.close();
    }

    @Override
    public C0125Cn mo239d() {
        return this.f6312m;
    }

    @Override
    public long mo1488n(C2409u3 c2409u3, long j) throws IOException {
        AbstractC0116Ce.m476e(c2409u3, "sink");
        if (j == 0) {
            return 0L;
        }
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        try {
            this.f6312m.mo438f();
            C2482vl c2482vlM9916b0 = c2409u3.m9916b0(1);
            int i = this.f6311l.read(c2482vlM9916b0.f7758a, c2482vlM9916b0.f7760c, (int) Math.min(j, 8192 - c2482vlM9916b0.f7760c));
            if (i != -1) {
                c2482vlM9916b0.f7760c += i;
                long j2 = i;
                c2409u3.m9910X(c2409u3.m9911Y() + j2);
                return j2;
            }
            if (c2482vlM9916b0.f7759b != c2482vlM9916b0.f7760c) {
                return -1L;
            }
            c2409u3.f7345l = c2482vlM9916b0.m10397b();
            C2528wl.m10594b(c2482vlM9916b0);
            return -1L;
        } catch (AssertionError e) {
            if (AbstractC0487Kh.m2377c(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    public String toString() {
        return "source(" + this.f6311l + ')';
    }
}
