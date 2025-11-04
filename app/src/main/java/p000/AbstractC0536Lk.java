package p000;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public abstract class AbstractC0536Lk implements Closeable {

    public static final a f1726l = new a(null);

    public static final class a {

        public static final class C2691a extends AbstractC0536Lk {

            public final InterfaceC2547x3 f1727m;

            public final C0716Pg f1728n;

            public final long f1729o;

            public C2691a(InterfaceC2547x3 interfaceC2547x3, C0716Pg c0716Pg, long j) {
                this.f1727m = interfaceC2547x3;
                this.f1728n = c0716Pg;
                this.f1729o = j;
            }

            @Override
            public long mo2711i() {
                return this.f1729o;
            }

            @Override
            public C0716Pg mo2712j() {
                return this.f1728n;
            }

            @Override
            public InterfaceC2547x3 mo2713k() {
                return this.f1727m;
            }
        }

        public a() {
        }

        public static AbstractC0536Lk m2715c(a aVar, byte[] bArr, C0716Pg c0716Pg, int i, Object obj) {
            if ((i & 1) != 0) {
                c0716Pg = null;
            }
            return aVar.m2717b(bArr, c0716Pg);
        }

        public final AbstractC0536Lk m2716a(InterfaceC2547x3 interfaceC2547x3, C0716Pg c0716Pg, long j) {
            AbstractC0116Ce.m476e(interfaceC2547x3, "$this$asResponseBody");
            return new C2691a(interfaceC2547x3, c0716Pg, j);
        }

        public final AbstractC0536Lk m2717b(byte[] bArr, C0716Pg c0716Pg) {
            AbstractC0116Ce.m476e(bArr, "$this$toResponseBody");
            return m2716a(new C2409u3().mo5930e(bArr), c0716Pg, bArr.length);
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public final InputStream byteStream() {
        return mo2713k().mo7337Q();
    }

    public final byte[] m2709b() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jMo2711i = mo2711i();
        if (jMo2711i > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + jMo2711i);
        }
        InterfaceC2547x3 interfaceC2547x3Mo2713k = mo2713k();
        try {
            byte[] bArrMo7331F = interfaceC2547x3Mo2713k.mo7331F();
            AbstractC0649O4.m3381a(interfaceC2547x3Mo2713k, null);
            int length = bArrMo7331F.length;
            if (jMo2711i == -1 || jMo2711i == length) {
                return bArrMo7331F;
            }
            throw new IOException("Content-Length (" + jMo2711i + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    @Override
    public void close() {
        AbstractC2623yo.m10935j(mo2713k());
    }

    public final Charset m2710g() {
        Charset charsetM3569c;
        C0716Pg c0716PgMo2712j = mo2712j();
        return (c0716PgMo2712j == null || (charsetM3569c = c0716PgMo2712j.m3569c(C2502w4.f7789b)) == null) ? C2502w4.f7789b : charsetM3569c;
    }

    public abstract long mo2711i();

    public abstract C0716Pg mo2712j();

    public abstract InterfaceC2547x3 mo2713k();

    public final String m2714l() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        InterfaceC2547x3 interfaceC2547x3Mo2713k = mo2713k();
        try {
            String strMo7336P = interfaceC2547x3Mo2713k.mo7336P(AbstractC2623yo.m10909E(interfaceC2547x3Mo2713k, m2710g()));
            AbstractC0649O4.m3381a(interfaceC2547x3Mo2713k, null);
            return strMo7336P;
        } finally {
        }
    }
}
