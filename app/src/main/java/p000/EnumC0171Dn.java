package p000;

/* loaded from: classes.dex */
public enum EnumC0171Dn {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");


    public static final a f428s = new a(null);

    public final String f429l;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final EnumC0171Dn m735a(String str) {
            AbstractC0116Ce.m476e(str, "javaName");
            int iHashCode = str.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return EnumC0171Dn.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return EnumC0171Dn.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return EnumC0171Dn.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return EnumC0171Dn.TLS_1_0;
                }
            } else if (str.equals("SSLv3")) {
                return EnumC0171Dn.SSL_3_0;
            }
            throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    EnumC0171Dn(String str) {
        this.f429l = str;
    }

    public final String m734c() {
        return this.f429l;
    }
}
