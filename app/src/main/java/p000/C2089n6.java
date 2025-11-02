package p000;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;
import p000.C2045m8;

public final class C2089n6 implements InterfaceC1228am {

    public static final b f6302b = new b(null);

    public static final C2045m8.a f6301a = new a();

    public static final class a implements C2045m8.a {
        @Override
        public boolean mo3968a(SSLSocket sSLSocket) {
            AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
            return C2043m6.f6134f.m8440c() && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override
        public InterfaceC1228am mo3969b(SSLSocket sSLSocket) {
            AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
            return new C2089n6();
        }
    }

    public static final class b {
        public b() {
        }

        public final C2045m8.a m8733a() {
            return C2089n6.f6301a;
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    @Override
    public boolean mo1773a(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override
    public String mo1774b(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        if (mo1773a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override
    public boolean mo1775c() {
        return C2043m6.f6134f.m8440c();
    }

    @Override
    public void mo1776d(SSLSocket sSLSocket, String str, List list) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        if (mo1773a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array = C0764Qi.f2268c.m3685b(list).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
        }
    }
}
