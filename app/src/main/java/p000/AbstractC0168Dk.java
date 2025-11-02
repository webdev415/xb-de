package p000;

import java.nio.charset.Charset;

public abstract class AbstractC0168Dk {

    public static final a f416a = new a(null);

    public static final class a {

        public static final class C2684a extends AbstractC0168Dk {

            public final byte[] f417b;

            public final C0716Pg f418c;

            public final int f419d;

            public final int f420e;

            public C2684a(byte[] bArr, C0716Pg c0716Pg, int i, int i2) {
                this.f417b = bArr;
                this.f418c = c0716Pg;
                this.f419d = i;
                this.f420e = i2;
            }

            @Override
            public long mo720a() {
                return this.f419d;
            }

            @Override
            public C0716Pg mo721b() {
                return this.f418c;
            }

            @Override
            public void mo724h(InterfaceC2501w3 interfaceC2501w3) {
                AbstractC0116Ce.m476e(interfaceC2501w3, "sink");
                interfaceC2501w3.mo5931f(this.f417b, this.f420e, this.f419d);
            }
        }

        public a() {
        }

        public static AbstractC0168Dk m725e(a aVar, C0716Pg c0716Pg, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return aVar.m728b(c0716Pg, bArr, i, i2);
        }

        public static AbstractC0168Dk m726f(a aVar, byte[] bArr, C0716Pg c0716Pg, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                c0716Pg = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return aVar.m730d(bArr, c0716Pg, i, i2);
        }

        public final AbstractC0168Dk m727a(C0716Pg c0716Pg, String str) {
            AbstractC0116Ce.m476e(str, "content");
            return m729c(str, c0716Pg);
        }

        public final AbstractC0168Dk m728b(C0716Pg c0716Pg, byte[] bArr, int i, int i2) {
            AbstractC0116Ce.m476e(bArr, "content");
            return m730d(bArr, c0716Pg, i, i2);
        }

        public final AbstractC0168Dk m729c(String str, C0716Pg c0716Pg) {
            AbstractC0116Ce.m476e(str, "$this$toRequestBody");
            Charset charset = C2502w4.f7789b;
            if (c0716Pg != null) {
                Charset charsetM3566d = C0716Pg.m3566d(c0716Pg, null, 1, null);
                if (charsetM3566d == null) {
                    c0716Pg = C0716Pg.f2145g.m3572b(c0716Pg + "; charset=utf-8");
                } else {
                    charset = charsetM3566d;
                }
            }
            byte[] bytes = str.getBytes(charset);
            AbstractC0116Ce.m475d(bytes, "(this as java.lang.String).getBytes(charset)");
            return m730d(bytes, c0716Pg, 0, bytes.length);
        }

        public final AbstractC0168Dk m730d(byte[] bArr, C0716Pg c0716Pg, int i, int i2) {
            AbstractC0116Ce.m476e(bArr, "$this$toRequestBody");
            AbstractC2623yo.m10934i(bArr.length, i, i2);
            return new C2684a(bArr, c0716Pg, i2, i);
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final AbstractC0168Dk m717c(C0716Pg c0716Pg, String str) {
        return f416a.m727a(c0716Pg, str);
    }

    public static final AbstractC0168Dk m718d(C0716Pg c0716Pg, byte[] bArr) {
        return a.m725e(f416a, c0716Pg, bArr, 0, 0, 12, null);
    }

    public static final AbstractC0168Dk m719e(String str, C0716Pg c0716Pg) {
        return f416a.m729c(str, c0716Pg);
    }

    public abstract long mo720a();

    public abstract C0716Pg mo721b();

    public boolean m722f() {
        return false;
    }

    public boolean m723g() {
        return false;
    }

    public abstract void mo724h(InterfaceC2501w3 interfaceC2501w3);
}
