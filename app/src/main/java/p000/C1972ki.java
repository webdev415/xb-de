package p000;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class C1972ki implements InterfaceC1134Yl {

    public final OutputStream f6023l;

    public final C0125Cn f6024m;

    public C1972ki(OutputStream outputStream, C0125Cn c0125Cn) {
        AbstractC0116Ce.m476e(outputStream, "out");
        AbstractC0116Ce.m476e(c0125Cn, "timeout");
        this.f6023l = outputStream;
        this.f6024m = c0125Cn;
    }

    @Override
    public void close() throws IOException {
        this.f6023l.close();
    }

    @Override
    public C0125Cn mo114d() {
        return this.f6024m;
    }

    @Override
    public void flush() throws IOException {
        this.f6023l.flush();
    }

    @Override
    public void mo115h(C2409u3 c2409u3, long j) throws IOException {
        AbstractC0116Ce.m476e(c2409u3, "source");
        AbstractC1342c.m5685b(c2409u3.m9911Y(), 0L, j);
        while (j > 0) {
            this.f6024m.mo438f();
            C2482vl c2482vl = c2409u3.f7345l;
            AbstractC0116Ce.m473b(c2482vl);
            int iMin = (int) Math.min(j, c2482vl.f7760c - c2482vl.f7759b);
            this.f6023l.write(c2482vl.f7758a, c2482vl.f7759b, iMin);
            c2482vl.f7759b += iMin;
            long j2 = iMin;
            j -= j2;
            c2409u3.m9910X(c2409u3.m9911Y() - j2);
            if (c2482vl.f7759b == c2482vl.f7760c) {
                c2409u3.f7345l = c2482vl.m10397b();
                C2528wl.m10594b(c2482vl);
            }
        }
    }

    public String toString() {
        return "sink(" + this.f6023l + ')';
    }
}
