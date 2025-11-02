package p000;

import java.io.IOException;

/* loaded from: classes.dex */
public enum EnumC2342sj {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    public static final a f7078t = new a(null);

    public final String f7079l;

    public static final class a {
        public a() {
        }

        public final EnumC2342sj m9586a(String str) throws IOException {
            AbstractC0116Ce.m476e(str, "protocol");
            EnumC2342sj enumC2342sj = EnumC2342sj.HTTP_1_0;
            if (!AbstractC0116Ce.m472a(str, enumC2342sj.f7079l)) {
                enumC2342sj = EnumC2342sj.HTTP_1_1;
                if (!AbstractC0116Ce.m472a(str, enumC2342sj.f7079l)) {
                    enumC2342sj = EnumC2342sj.H2_PRIOR_KNOWLEDGE;
                    if (!AbstractC0116Ce.m472a(str, enumC2342sj.f7079l)) {
                        enumC2342sj = EnumC2342sj.HTTP_2;
                        if (!AbstractC0116Ce.m472a(str, enumC2342sj.f7079l)) {
                            enumC2342sj = EnumC2342sj.SPDY_3;
                            if (!AbstractC0116Ce.m472a(str, enumC2342sj.f7079l)) {
                                enumC2342sj = EnumC2342sj.QUIC;
                                if (!AbstractC0116Ce.m472a(str, enumC2342sj.f7079l)) {
                                    throw new IOException("Unexpected protocol: " + str);
                                }
                            }
                        }
                    }
                }
            }
            return enumC2342sj;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    EnumC2342sj(String str) {
        this.f7079l = str;
    }

    @Override
    public String toString() {
        return this.f7079l;
    }
}
