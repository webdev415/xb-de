package p000;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class C1328bl {

    public final C2498w0 f3880a;

    public final Proxy f3881b;

    public final InetSocketAddress f3882c;

    public C1328bl(C2498w0 c2498w0, Proxy proxy, InetSocketAddress inetSocketAddress) {
        AbstractC0116Ce.m476e(c2498w0, "address");
        AbstractC0116Ce.m476e(proxy, "proxy");
        AbstractC0116Ce.m476e(inetSocketAddress, "socketAddress");
        this.f3880a = c2498w0;
        this.f3881b = proxy;
        this.f3882c = inetSocketAddress;
    }

    public final C2498w0 m5675a() {
        return this.f3880a;
    }

    public final Proxy m5676b() {
        return this.f3881b;
    }

    public final boolean m5677c() {
        return this.f3880a.m10420k() != null && this.f3881b.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress m5678d() {
        return this.f3882c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1328bl) {
            C1328bl c1328bl = (C1328bl) obj;
            if (AbstractC0116Ce.m472a(c1328bl.f3880a, this.f3880a) && AbstractC0116Ce.m472a(c1328bl.f3881b, this.f3881b) && AbstractC0116Ce.m472a(c1328bl.f3882c, this.f3882c)) {
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
