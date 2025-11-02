package p000;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p000.C2045m8;

public class C0828S0 implements InterfaceC1228am {

    public static final C2045m8.a f2564f;

    public static final a f2565g;

    public final Method f2566a;

    public final Method f2567b;

    public final Method f2568c;

    public final Method f2569d;

    public final Class f2570e;

    public static final class a {

        public static final class C2699a implements C2045m8.a {

            public final String f2571a;

            public C2699a(String str) {
                this.f2571a = str;
            }

            @Override
            public boolean mo3968a(SSLSocket sSLSocket) {
                AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
                String name = sSLSocket.getClass().getName();
                AbstractC0116Ce.m475d(name, "sslSocket.javaClass.name");
                return AbstractC0538Lm.m2731w(name, this.f2571a + '.', false, 2, null);
            }

            @Override
            public InterfaceC1228am mo3969b(SSLSocket sSLSocket) {
                AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
                return C0828S0.f2565g.m3965b(sSLSocket.getClass());
            }
        }

        public a() {
        }

        public final C0828S0 m3965b(Class cls) {
            Class superclass = cls;
            while (superclass != null && (!AbstractC0116Ce.m472a(superclass.getSimpleName(), "OpenSSLSocketImpl"))) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            AbstractC0116Ce.m473b(superclass);
            return new C0828S0(superclass);
        }

        public final C2045m8.a m3966c(String str) {
            AbstractC0116Ce.m476e(str, "packageName");
            return new C2699a(str);
        }

        public final C2045m8.a m3967d() {
            return C0828S0.f2564f;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f2565g = aVar;
        f2564f = aVar.m3966c("com.google.android.gms.org.conscrypt");
    }

    public C0828S0(Class cls) throws NoSuchMethodException, SecurityException {
        AbstractC0116Ce.m476e(cls, "sslSocketClass");
        this.f2570e = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        AbstractC0116Ce.m475d(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f2566a = declaredMethod;
        this.f2567b = cls.getMethod("setHostname", String.class);
        this.f2568c = cls.getMethod("getAlpnSelectedProtocol", null);
        this.f2569d = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override
    public boolean mo1773a(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        return this.f2570e.isInstance(sSLSocket);
    }

    @Override
    public String mo1774b(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        if (!mo1773a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f2568c.invoke(sSLSocket, null);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            AbstractC0116Ce.m475d(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (NullPointerException e2) {
            if (AbstractC0116Ce.m472a(e2.getMessage(), "ssl == null")) {
                return null;
            }
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override
    public boolean mo1775c() {
        return C0782R0.f2306g.m3748b();
    }

    @Override
    public void mo1776d(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        if (mo1773a(sSLSocket)) {
            try {
                this.f2566a.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f2567b.invoke(sSLSocket, str);
                }
                this.f2569d.invoke(sSLSocket, C0764Qi.f2268c.m3686c(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }
}
