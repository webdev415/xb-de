package p000;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class C0445Jl {

    public static C0445Jl f1436e;

    public Socket f1437a = null;

    public ArrayList f1438b = new ArrayList<>();

    public HashMap f1439c = new HashMap<>();

    public int f1440d = 3;

    public static C0445Jl m2065b() {
        if (f1436e == null) {
            f1436e = new C0445Jl();
        }
        return f1436e;
    }

    public InterfaceC0353Hl m2066a(Proxy proxy) {
        if (proxy.serverType == 2) {
            return null;
        }
        return proxy.serverType == 1
                ? new C1375cm(proxy.localPort, proxy.proxyHost, proxy.getProxyPort())
                : new C1375cm(proxy.localPort, proxy.proxyHost, proxy.getProxyPort());
    }

    public InterfaceC0353Hl m2067c(Proxy proxy) {
        InterfaceC0353Hl interfaceC0353HlM2068d = m2068d(proxy.localPort);
        if (interfaceC0353HlM2068d != null) {
            return interfaceC0353HlM2068d;
        }
        InterfaceC0353Hl interfaceC0353HlM2066a = m2066a(proxy);
        this.f1439c.put("localhost_" + proxy.localPort, interfaceC0353HlM2066a);
        return interfaceC0353HlM2066a;
    }

    public final InterfaceC0353Hl m2068d(int i) {
        return (InterfaceC0353Hl) this.f1439c.get("localhost_" + i);
    }

    public void m2069e(Proxy proxy) {
        for (int i = 0; i < this.f1438b.size(); i++) {
            Proxy proxy2 = (Proxy) this.f1438b.get(i);
            if (proxy2.getProxyPort() == proxy.getProxyPort() && proxy2.proxyHost.equals(proxy.proxyHost)) {
                return;
            }
        }
        this.f1438b.add(proxy);
    }
}
