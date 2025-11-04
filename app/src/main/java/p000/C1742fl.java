package p000;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class C1742fl {

    public static final a f5533i = new a(null);

    public List f5534a;

    public int f5535b;

    public List f5536c;

    public final List f5537d;

    public final Address f5538e;

    public final C1649dl f5539f;

    public final InterfaceC0418J3 f5540g;

    public final AbstractC1918ja f5541h;

    public static final class a {
        public a() {
        }

        public final String m7647a(InetSocketAddress inetSocketAddress) {
            String hostName;
            String str;
            AbstractC0116Ce.m476e(inetSocketAddress, "$this$socketHost");
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                hostName = address.getHostAddress();
                str = "address.hostAddress";
            } else {
                hostName = inetSocketAddress.getHostName();
                str = "hostName";
            }
            AbstractC0116Ce.m475d(hostName, str);
            return hostName;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b {

        public int f5542a;

        public final List f5543b;

        public b(List list) {
            AbstractC0116Ce.m476e(list, "routes");
            this.f5543b = list;
        }

        public final List m7648a() {
            return this.f5543b;
        }

        public final boolean m7649b() {
            return this.f5542a < this.f5543b.size();
        }

        public final Route m7650c() {
            if (!m7649b()) {
                throw new NoSuchElementException();
            }
            List list = this.f5543b;
            int i = this.f5542a;
            this.f5542a = i + 1;
            return (Route) list.get(i);
        }
    }

    public static final class c extends AbstractC0025Af implements InterfaceC0894Tb {

        public final Proxy f5545n;

        public final C0069Bd f5546o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Proxy proxy, C0069Bd c0069Bd) {
            super(0);
            this.f5545n = proxy;
            this.f5546o = c0069Bd;
        }

        @Override
        public final List mo4135c() {
            Proxy proxy = this.f5545n;
            if (proxy != null) {
                return AbstractC1763g5.m7692b(proxy);
            }
            URI uriM258q = this.f5546o.m258q();
            if (uriM258q.getHost() == null) {
                return AbstractC2623yo.m10945t(Proxy.NO_PROXY);
            }
            List<Proxy> listSelect = C1742fl.this.f5538e.m10418i().select(uriM258q);
            List<Proxy> list = listSelect;
            return (list == null || list.isEmpty()) ? AbstractC2623yo.m10945t(Proxy.NO_PROXY) : AbstractC2623yo.m10918N(listSelect);
        }
    }

    public C1742fl(Address address, C1649dl c1649dl, InterfaceC0418J3 interfaceC0418J3, AbstractC1918ja abstractC1918ja) {
        AbstractC0116Ce.m476e(address, "address");
        AbstractC0116Ce.m476e(c1649dl, "routeDatabase");
        AbstractC0116Ce.m476e(interfaceC0418J3, "call");
        AbstractC0116Ce.m476e(abstractC1918ja, "eventListener");
        this.f5538e = address;
        this.f5539f = c1649dl;
        this.f5540g = interfaceC0418J3;
        this.f5541h = abstractC1918ja;
        this.f5534a = AbstractC1810h5.m7783f();
        this.f5536c = AbstractC1810h5.m7783f();
        this.f5537d = new ArrayList<>();
        m7646g(address.m10421l(), address.m10416g());
    }

    public final boolean m7641b() {
        return m7642c() || (this.f5537d.isEmpty() ^ true);
    }

    public final boolean m7642c() {
        return this.f5535b < this.f5534a.size();
    }

    public final b m7643d() {
        if (!m7641b()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList<>();
        while (m7642c()) {
            Proxy proxyM7644e = m7644e();
            Iterator it = this.f5536c.iterator();
            while (it.hasNext()) {
                Route route = new Route(this.f5538e, proxyM7644e, (InetSocketAddress) it.next());
                if (this.f5539f.m7353c(route)) {
                    this.f5537d.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            AbstractC2042m5.m8435p(arrayList, this.f5537d);
            this.f5537d.clear();
        }
        return new b(arrayList);
    }

    public final Proxy m7644e() throws SocketException, UnknownHostException {
        if (m7642c()) {
            List list = this.f5534a;
            int i = this.f5535b;
            this.f5535b = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            m7645f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f5538e.m10421l().m249h() + "; exhausted proxy configurations: " + this.f5534a);
    }

    public final void m7645f(Proxy proxy) throws SocketException, UnknownHostException {
        String strM249h;
        int iM253l;
        ArrayList arrayList = new ArrayList<>();
        this.f5536c = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strM249h = this.f5538e.m10421l().m249h();
            iM253l = this.f5538e.m10421l().m253l();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strM249h = f5533i.m7647a(inetSocketAddress);
            iM253l = inetSocketAddress.getPort();
        }
        if (1 > iM253l || 65535 < iM253l) {
            throw new SocketException("No route to " + strM249h + ':' + iM253l + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(strM249h, iM253l));
            return;
        }
        this.f5541h.m8144m(this.f5540g, strM249h);
        List listMo7701a = this.f5538e.m10412c().mo7701a(strM249h);
        if (listMo7701a.isEmpty()) {
            throw new UnknownHostException(this.f5538e.m10412c() + " returned no addresses for " + strM249h);
        }
        this.f5541h.m8143l(this.f5540g, strM249h, listMo7701a);
        Iterator it = listMo7701a.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress((InetAddress) it.next(), iM253l));
        }
    }

    public final void m7646g(C0069Bd c0069Bd, Proxy proxy) {
        c cVar = new c(proxy, c0069Bd);
        this.f5541h.m8146o(this.f5540g, c0069Bd);
        List listMo4135c = cVar.mo4135c();
        this.f5534a = listMo4135c;
        this.f5535b = 0;
        this.f5541h.m8145n(this.f5540g, c0069Bd, listMo4135c);
    }
}
