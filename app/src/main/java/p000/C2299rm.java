package p000;

public final class C2299rm extends C0828S0 {

    public static final a f6960j = new a(null);

    public final Class f6961h;

    public final Class f6962i;

    public static final class a {
        public a() {
        }

        public static InterfaceC1228am m9435b(a aVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.m9436a(str);
        }

        public final InterfaceC1228am m9436a(String str) throws ClassNotFoundException {
            AbstractC0116Ce.m476e(str, "packageName");
            try {
                Class<?> cls = Class.forName(str + ".OpenSSLSocketImpl");
                Class<?> cls2 = Class.forName(str + ".OpenSSLSocketFactoryImpl");
                Class<?> cls3 = Class.forName(str + ".SSLParametersImpl");
                AbstractC0116Ce.m475d(cls3, "paramsClass");
                return new C2299rm(cls, cls2, cls3);
            } catch (Exception e) {
                C0764Qi.f2268c.m3690g().m3679j("unable to load android socket classes", 5, e);
                return null;
            }
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2299rm(Class cls, Class cls2, Class cls3) {
        super(cls);
        AbstractC0116Ce.m476e(cls, "sslSocketClass");
        AbstractC0116Ce.m476e(cls2, "sslSocketFactoryClass");
        AbstractC0116Ce.m476e(cls3, "paramClass");
        this.f6961h = cls2;
        this.f6962i = cls3;
    }
}
