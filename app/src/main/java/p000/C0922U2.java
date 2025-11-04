package p000;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import p000.C2045m8;

public final class C0922U2 implements InterfaceC1228am {

    public static final b f2814b = new b(null);

    public static final C2045m8.a f2813a = new a();

    public static final class a implements C2045m8.a {
        @Override
        public boolean mo3968a(SSLSocket sSLSocket) {
            AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
            C0876T2.f2686f.m4086b();
            return false;
        }

        @Override
        public InterfaceC1228am mo3969b(SSLSocket sSLSocket) {
            AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
            return new C0922U2();
        }
    }

    public static final class b {
        public b() {
        }

        public final C2045m8.a m4189a() {
            return C0922U2.f2813a;
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    @Override
    public boolean mo1773a(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        return false;
    }

    @Override
    public String mo1774b(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override
    public boolean mo1775c() {
        return C0876T2.f2686f.m4086b();
    }

    @Override
    public void mo1776d(SSLSocket sSLSocket, String str, List list) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        if (mo1773a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            AbstractC0116Ce.m475d(parameters, "sslParameters");
            Object[] array = C0764Qi.f2268c.m3685b(list).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }
}
