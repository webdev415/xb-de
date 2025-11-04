package p000;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;

public final class C0851Se implements InterfaceC0508L1 {

    public final InterfaceC1767g9 f2646d;

    public C0851Se(InterfaceC1767g9 interfaceC1767g9) {
        AbstractC0116Ce.m476e(interfaceC1767g9, "defaultDns");
        this.f2646d = interfaceC1767g9;
    }

    @Override
    public Request mo2575a(Route route, Response response) {
        Proxy proxyM5676b;
        InterfaceC1767g9 interfaceC1767g9M10412c;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        Address addressM5675A;
        AbstractC0116Ce.m476e(response, "response");
        List<C2133o4> listM2395i = response.m2395i();
        Request requestM2390S = response.getRequest();
        C0069Bd c0069BdM498i = requestM2390S.getUrl();
        boolean z = response.getStatus() == 407;
        if (route == null || (proxyM5676b = route.getProxy()) == null) {
            proxyM5676b = Proxy.NO_PROXY;
        }
        for (C2133o4 c2133o4 : listM2395i) {
            if (AbstractC0538Lm.m2720l("Basic", c2133o4.m8839c(), true)) {
                if (route == null || (addressM5675A = route.m5675a()) == null || (interfaceC1767g9M10412c = addressM5675A.m10412c()) == null) {
                    interfaceC1767g9M10412c = this.f2646d;
                }
                if (z) {
                    SocketAddress socketAddressAddress = proxyM5676b.address();
                    if (socketAddressAddress == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    AbstractC0116Ce.m475d(proxyM5676b, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, m4055b(proxyM5676b, c0069BdM498i, interfaceC1767g9M10412c), inetSocketAddress.getPort(), c0069BdM498i.m257p(), c2133o4.m8838b(), c2133o4.m8839c(), c0069BdM498i.m259r(), Authenticator.RequestorType.PROXY);
                } else {
                    String strM249h = c0069BdM498i.m249h();
                    AbstractC0116Ce.m475d(proxyM5676b, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(strM249h, m4055b(proxyM5676b, c0069BdM498i, interfaceC1767g9M10412c), c0069BdM498i.m253l(), c0069BdM498i.m257p(), c2133o4.m8838b(), c2133o4.m8839c(), c0069BdM498i.m259r(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    AbstractC0116Ce.m475d(userName, "auth.userName");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    AbstractC0116Ce.m475d(password, "auth.password");
                    return requestM2390S.m497h().m501c(str, C0972V6.m4332a(userName, new String(password), c2133o4.m8837a())).m500b();
                }
            }
        }
        return null;
    }

    public final InetAddress m4055b(Proxy proxy, C0069Bd c0069Bd, InterfaceC1767g9 interfaceC1767g9) {
        Proxy.Type type = proxy.type();
        if (type != null && AbstractC0805Re.f2396a[type.ordinal()] == 1) {
            return (InetAddress) AbstractC2181p5.m9026u(interfaceC1767g9.mo7701a(c0069Bd.m249h()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        if (socketAddressAddress == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        AbstractC0116Ce.m475d(address, "(address() as InetSocketAddress).address");
        return address;
    }

    public C0851Se(InterfaceC1767g9 interfaceC1767g9, int i, AbstractC0881T7 abstractC0881T7) {
        this((i & 1) != 0 ? InterfaceC1767g9.f5597a : interfaceC1767g9);
    }
}
