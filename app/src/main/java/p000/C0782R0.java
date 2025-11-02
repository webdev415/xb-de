package p000;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import p000.C2299rm;

public final class C0782R0 extends C0764Qi {

    public static final boolean f2305f;

    public static final a f2306g = new a(null);

    public final List f2307d;

    public final C0603N4 f2308e;

    public static final class a {
        public a() {
        }

        public final C0764Qi m3747a() {
            if (m3748b()) {
                return new C0782R0();
            }
            return null;
        }

        public final boolean m3748b() {
            return C0782R0.f2305f;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b implements InterfaceC0723Pn {

        public final X509TrustManager f2309a;

        public final Method f2310b;

        public b(X509TrustManager x509TrustManager, Method method) {
            AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
            AbstractC0116Ce.m476e(method, "findByIssuerAndSignatureMethod");
            this.f2309a = x509TrustManager;
            this.f2310b = method;
        }

        @Override
        public X509Certificate mo3585a(X509Certificate x509Certificate) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            AbstractC0116Ce.m476e(x509Certificate, "cert");
            try {
                Object objInvoke = this.f2310b.invoke(this.f2309a, x509Certificate);
                if (objInvoke != null) {
                    return ((TrustAnchor) objInvoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC0116Ce.m472a(this.f2309a, bVar.f2309a) && AbstractC0116Ce.m472a(this.f2310b, bVar.f2310b);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.f2309a;
            int iHashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.f2310b;
            return iHashCode + (method != null ? method.hashCode() : 0);
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f2309a + ", findByIssuerAndSignatureMethod=" + this.f2310b + ")";
        }
    }

    static {
        boolean z = false;
        if (C0764Qi.f2268c.m3691h() && Build.VERSION.SDK_INT < 30) {
            z = true;
        }
        f2305f = z;
    }

    public C0782R0() {
        List listM7786i = AbstractC1810h5.m7786i(C2299rm.a.m9435b(C2299rm.f6960j, null, 1, null), new C2045m8(C0828S0.f2565g.m3967d()), new C2045m8(C2089n6.f6302b.m8733a()), new C2045m8(C0922U2.f2814b.m4189a()));
        ArrayList arrayList = new ArrayList<>();
        for (Object obj : listM7786i) {
            if (((InterfaceC1228am) obj).mo1775c()) {
                arrayList.add(obj);
            }
        }
        this.f2307d = arrayList;
        this.f2308e = C0603N4.f1903d.m3291a();
    }

    @Override
    public AbstractC2041m4 mo1314c(X509TrustManager x509TrustManager) {
        AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
        C0507L0 c0507l0M2574a = C0507L0.f1644d.m2574a(x509TrustManager);
        return c0507l0M2574a != null ? c0507l0M2574a : super.mo1314c(x509TrustManager);
    }

    @Override
    public InterfaceC0723Pn mo3676d(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            AbstractC0116Ce.m475d(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo3676d(x509TrustManager);
        }
    }

    @Override
    public void mo1315e(SSLSocket sSLSocket, String str, List list) {
        Object next;
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        Iterator it = this.f2307d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((InterfaceC1228am) next).mo1773a(sSLSocket)) {
                    break;
                }
            }
        }
        InterfaceC1228am interfaceC1228am = (InterfaceC1228am) next;
        if (interfaceC1228am != null) {
            interfaceC1228am.mo1776d(sSLSocket, str, list);
        }
    }

    @Override
    public void mo3677f(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        AbstractC0116Ce.m476e(socket, "socket");
        AbstractC0116Ce.m476e(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e;
            }
            throw new IOException("Exception in connect", e);
        }
    }

    @Override
    public String mo1316g(SSLSocket sSLSocket) {
        Object next;
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        Iterator it = this.f2307d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((InterfaceC1228am) next).mo1773a(sSLSocket)) {
                break;
            }
        }
        InterfaceC1228am interfaceC1228am = (InterfaceC1228am) next;
        if (interfaceC1228am != null) {
            return interfaceC1228am.mo1774b(sSLSocket);
        }
        return null;
    }

    @Override
    public Object mo3678h(String str) {
        AbstractC0116Ce.m476e(str, "closer");
        return this.f2308e.m3289a(str);
    }

    @Override
    public boolean mo1317i(String str) {
        AbstractC0116Ce.m476e(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override
    public void mo3680l(String str, Object obj) {
        AbstractC0116Ce.m476e(str, "message");
        if (this.f2308e.m3290b(obj)) {
            return;
        }
        C0764Qi.m3674k(this, str, 5, null, 4, null);
    }
}
