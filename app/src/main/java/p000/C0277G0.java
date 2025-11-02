package p000;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class C0277G0 extends C0764Qi {

    public static final boolean f700e;

    public static final a f701f = new a(null);

    public final List f702d;

    public static final class a {
        public a() {
        }

        public final C0764Qi m1318a() {
            if (m1319b()) {
                return new C0277G0();
            }
            return null;
        }

        public final boolean m1319b() {
            return C0277G0.f700e;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    static {
        f700e = C0764Qi.f2268c.m3691h() && Build.VERSION.SDK_INT >= 29;
    }

    public C0277G0() {
        List listM7786i = AbstractC1810h5.m7786i(C0415J0.f1253a.m1777a(), new C2045m8(C0828S0.f2565g.m3967d()), new C2045m8(C2089n6.f6302b.m8733a()), new C2045m8(C0922U2.f2814b.m4189a()));
        ArrayList arrayList = new ArrayList<>();
        for (Object obj : listM7786i) {
            if (((InterfaceC1228am) obj).mo1775c()) {
                arrayList.add(obj);
            }
        }
        this.f702d = arrayList;
    }

    @Override
    public AbstractC2041m4 mo1314c(X509TrustManager x509TrustManager) {
        AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
        C0507L0 c0507l0M2574a = C0507L0.f1644d.m2574a(x509TrustManager);
        return c0507l0M2574a != null ? c0507l0M2574a : super.mo1314c(x509TrustManager);
    }

    @Override
    public void mo1315e(SSLSocket sSLSocket, String str, List list) {
        Object next;
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        Iterator it = this.f702d.iterator();
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
    public String mo1316g(SSLSocket sSLSocket) {
        Object next;
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        Iterator it = this.f702d.iterator();
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
    public boolean mo1317i(String str) {
        AbstractC0116Ce.m476e(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
