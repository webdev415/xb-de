package p000;

import java.util.List;
import javax.net.ssl.SSLSocket;

public final class C2045m8 implements InterfaceC1228am {

    public InterfaceC1228am f6139a;

    public final a f6140b;

    public interface a {
        boolean mo3968a(SSLSocket sSLSocket);

        InterfaceC1228am mo3969b(SSLSocket sSLSocket);
    }

    public C2045m8(a aVar) {
        AbstractC0116Ce.m476e(aVar, "socketAdapterFactory");
        this.f6140b = aVar;
    }

    @Override
    public boolean mo1773a(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        return this.f6140b.mo3968a(sSLSocket);
    }

    @Override
    public String mo1774b(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        InterfaceC1228am interfaceC1228amM8443e = m8443e(sSLSocket);
        if (interfaceC1228amM8443e != null) {
            return interfaceC1228amM8443e.mo1774b(sSLSocket);
        }
        return null;
    }

    @Override
    public boolean mo1775c() {
        return true;
    }

    @Override
    public void mo1776d(SSLSocket sSLSocket, String str, List list) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        InterfaceC1228am interfaceC1228amM8443e = m8443e(sSLSocket);
        if (interfaceC1228amM8443e != null) {
            interfaceC1228amM8443e.mo1776d(sSLSocket, str, list);
        }
    }

    public final synchronized InterfaceC1228am m8443e(SSLSocket sSLSocket) {
        try {
            if (this.f6139a == null && this.f6140b.mo3968a(sSLSocket)) {
                this.f6139a = this.f6140b.mo3969b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f6139a;
    }
}
