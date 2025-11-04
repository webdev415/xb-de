package p000;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class Route {

    public final Address f3880a;

    public final Proxy f3881b;

    public final InetSocketAddress f3882c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        AbstractC0116Ce.m476e(address, "address");
        AbstractC0116Ce.m476e(proxy, "proxy");
        AbstractC0116Ce.m476e(inetSocketAddress, "socketAddress");
        this.f3880a = address;
        this.f3881b = proxy;
        this.f3882c = inetSocketAddress;
    }

    public final Address m5675a() {
        return this.f3880a;
    }

    public final Proxy getProxy() {
        return this.f3881b;
    }

    public final boolean m5677c() {
        return this.f3880a.m10420k() != null && this.f3881b.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress getHostAddress() {
        return this.f3882c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (AbstractC0116Ce.m472a(route.f3880a, this.f3880a) && AbstractC0116Ce.m472a(route.f3881b, this.f3881b) && AbstractC0116Ce.m472a(route.f3882c, this.f3882c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f3880a.hashCode()) * 31) + this.f3881b.hashCode()) * 31) + this.f3882c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f3882c + '}';
    }
}
