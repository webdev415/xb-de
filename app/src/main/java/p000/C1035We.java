package p000;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public class C1035We extends C0764Qi {

    public static final boolean f3063d;

    public static final a f3064e = new a(null);

    public static final class a {
        public a() {
        }

        public final C1035We m4500a() {
            if (m4501b()) {
                return new C1035We();
            }
            return null;
        }

        public final boolean m4501b() {
            return C1035We.f3063d;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    static {
        String property = System.getProperty("java.specification.version");
        Integer numM2446f = property != null ? AbstractC0492Km.m2446f(property) : null;
        boolean z = false;
        if (numM2446f == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (numM2446f.intValue() >= 9) {
            z = true;
        }
        f3063d = z;
    }

    @Override
    public void mo1315e(SSLSocket sSLSocket, String str, List list) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        List listM3685b = C0764Qi.f2268c.m3685b(list);
        AbstractC0116Ce.m475d(sSLParameters, "sslParameters");
        Object[] array = listM3685b.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        sSLParameters.setApplicationProtocols((String[]) array);
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override
    public String mo1316g(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                return null;
            }
            if (applicationProtocol.hashCode() == 0) {
                if (applicationProtocol.equals("")) {
                    return null;
                }
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
