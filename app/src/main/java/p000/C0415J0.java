package p000;

import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class C0415J0 implements InterfaceC1228am {

    public static final a f1253a = new a(null);

    public static final class a {
        public a() {
        }

        public final InterfaceC1228am m1777a() {
            if (m1778b()) {
                return new C0415J0();
            }
            return null;
        }

        public final boolean m1778b() {
            return C0764Qi.f2268c.m3691h() && Build.VERSION.SDK_INT >= 29;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    @Override
    public boolean mo1773a(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override
    public String mo1774b(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || (applicationProtocol.hashCode() == 0 && applicationProtocol.equals(""))) {
            return null;
        }
        return applicationProtocol;
    }

    @Override
    public boolean mo1775c() {
        return f1253a.m1778b();
    }

    @Override
    public void mo1776d(SSLSocket sSLSocket, String str, List list) throws IOException {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            AbstractC0116Ce.m475d(sSLParameters, "sslParameters");
            Object[] array = C0764Qi.f2268c.m3685b(list).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }
}
