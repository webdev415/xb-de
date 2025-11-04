package p000;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address {

    public final C0069Bd f7766a;

    public final List f7767b;

    public final List f7768c;

    public final InterfaceC1767g9 f7769d;

    public final SocketFactory f7770e;

    public final SSLSocketFactory f7771f;

    public final HostnameVerifier f7772g;

    public final C2087n4 f7773h;

    public final InterfaceC0508L1 f7774i;

    public final Proxy f7775j;

    public final ProxySelector f7776k;

    public Address(String str, int i, InterfaceC1767g9 interfaceC1767g9, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C2087n4 c2087n4, InterfaceC0508L1 interfaceC0508L1, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        AbstractC0116Ce.m476e(str, "uriHost");
        AbstractC0116Ce.m476e(interfaceC1767g9, "dns");
        AbstractC0116Ce.m476e(socketFactory, "socketFactory");
        AbstractC0116Ce.m476e(interfaceC0508L1, "proxyAuthenticator");
        AbstractC0116Ce.m476e(list, "protocols");
        AbstractC0116Ce.m476e(list2, "connectionSpecs");
        AbstractC0116Ce.m476e(proxySelector, "proxySelector");
        this.f7769d = interfaceC1767g9;
        this.f7770e = socketFactory;
        this.f7771f = sSLSocketFactory;
        this.f7772g = hostnameVerifier;
        this.f7773h = c2087n4;
        this.f7774i = interfaceC0508L1;
        this.f7775j = proxy;
        this.f7776k = proxySelector;
        this.f7766a = new C0069Bd.a().m274o(sSLSocketFactory != null ? "https" : "http").m264e(str).m270k(i).m260a();
        this.f7767b = AbstractC2623yo.m10918N(list);
        this.f7768c = AbstractC2623yo.m10918N(list2);
    }

    public final C2087n4 m10410a() {
        return this.f7773h;
    }

    public final List m10411b() {
        return this.f7768c;
    }

    public final InterfaceC1767g9 m10412c() {
        return this.f7769d;
    }

    public final boolean m10413d(Address address) {
        AbstractC0116Ce.m476e(address, "that");
        return AbstractC0116Ce.m472a(this.f7769d, address.f7769d) && AbstractC0116Ce.m472a(this.f7774i, address.f7774i) && AbstractC0116Ce.m472a(this.f7767b, address.f7767b) && AbstractC0116Ce.m472a(this.f7768c, address.f7768c) && AbstractC0116Ce.m472a(this.f7776k, address.f7776k) && AbstractC0116Ce.m472a(this.f7775j, address.f7775j) && AbstractC0116Ce.m472a(this.f7771f, address.f7771f) && AbstractC0116Ce.m472a(this.f7772g, address.f7772g) && AbstractC0116Ce.m472a(this.f7773h, address.f7773h) && this.f7766a.m253l() == address.f7766a.m253l();
    }

    public final HostnameVerifier m10414e() {
        return this.f7772g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (AbstractC0116Ce.m472a(this.f7766a, address.f7766a) && m10413d(address)) {
                return true;
            }
        }
        return false;
    }

    public final List m10415f() {
        return this.f7767b;
    }

    public final Proxy m10416g() {
        return this.f7775j;
    }

    public final InterfaceC0508L1 m10417h() {
        return this.f7774i;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f7766a.hashCode()) * 31) + this.f7769d.hashCode()) * 31) + this.f7774i.hashCode()) * 31) + this.f7767b.hashCode()) * 31) + this.f7768c.hashCode()) * 31) + this.f7776k.hashCode()) * 31) + Objects.hashCode(this.f7775j)) * 31) + Objects.hashCode(this.f7771f)) * 31) + Objects.hashCode(this.f7772g)) * 31) + Objects.hashCode(this.f7773h);
    }

    public final ProxySelector m10418i() {
        return this.f7776k;
    }

    public final SocketFactory m10419j() {
        return this.f7770e;
    }

    public final SSLSocketFactory m10420k() {
        return this.f7771f;
    }

    public final C0069Bd m10421l() {
        return this.f7766a;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f7766a.m249h());
        sb2.append(':');
        sb2.append(this.f7766a.m253l());
        sb2.append(", ");
        if (this.f7775j != null) {
            sb = new StringBuilder();
            sb.append("proxy=");
            obj = this.f7775j;
        } else {
            sb = new StringBuilder();
            sb.append("proxySelector=");
            obj = this.f7776k;
        }
        sb.append(obj);
        sb2.append(sb.toString());
        sb2.append("}");
        return sb2.toString();
    }
}
