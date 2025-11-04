package p000;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

public final class C0027Ah extends ProxySelector {

    public static final C0027Ah f77a = new C0027Ah();

    @Override
    public List select(URI uri) {
        if (uri != null) {
            return AbstractC1763g5.m7692b(Proxy.NO_PROXY);
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }

    @Override
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }
}
