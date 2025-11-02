package p000;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class C0897Te extends C0764Qi {

    public static final b f2757i = new b(null);

    public final Method f2758d;

    public final Method f2759e;

    public final Method f2760f;

    public final Class f2761g;

    public final Class f2762h;

    public static final class a implements InvocationHandler {

        public boolean f2763a;

        public String f2764b;

        public final List f2765c;

        public a(List list) {
            AbstractC0116Ce.m476e(list, "protocols");
            this.f2765c = list;
        }

        public final String m4150a() {
            return this.f2764b;
        }

        public final boolean m4151b() {
            return this.f2763a;
        }

        @Override
        public Object invoke(Object obj, Method method, Object[] objArr) {
            AbstractC0116Ce.m476e(obj, "proxy");
            AbstractC0116Ce.m476e(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (AbstractC0116Ce.m472a(name, "supports") && AbstractC0116Ce.m472a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (AbstractC0116Ce.m472a(name, "unsupported") && AbstractC0116Ce.m472a(Void.TYPE, returnType)) {
                this.f2763a = true;
                return null;
            }
            if (AbstractC0116Ce.m472a(name, "protocols") && objArr.length == 0) {
                return this.f2765c;
            }
            if ((AbstractC0116Ce.m472a(name, "selectProtocol") || AbstractC0116Ce.m472a(name, "select")) && AbstractC0116Ce.m472a(String.class, returnType) && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List list = (List) obj2;
                    int size = list.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Object obj3 = list.get(i);
                            if (obj3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) obj3;
                            if (!this.f2765c.contains(str)) {
                                if (i == size) {
                                    break;
                                }
                                i++;
                            } else {
                                this.f2764b = str;
                                return str;
                            }
                        }
                    }
                    String str2 = (String) this.f2765c.get(0);
                    this.f2764b = str2;
                    return str2;
                }
            }
            if ((!AbstractC0116Ce.m472a(name, "protocolSelected") && !AbstractC0116Ce.m472a(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj4 = objArr[0];
            if (obj4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.f2764b = (String) obj4;
            return null;
        }
    }

    public static final class b {
        public b() {
        }

        public final C0764Qi m4152a() {
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                AbstractC0116Ce.m475d(property, "jvmVersion");
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method method = cls.getMethod("put", SSLSocket.class, cls2);
                Method method2 = cls.getMethod("get", SSLSocket.class);
                Method method3 = cls.getMethod("remove", SSLSocket.class);
                AbstractC0116Ce.m475d(method, "putMethod");
                AbstractC0116Ce.m475d(method2, "getMethod");
                AbstractC0116Ce.m475d(method3, "removeMethod");
                AbstractC0116Ce.m475d(cls3, "clientProviderClass");
                AbstractC0116Ce.m475d(cls4, "serverProviderClass");
                return new C0897Te(method, method2, method3, cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0897Te(Method method, Method method2, Method method3, Class cls, Class cls2) {
        AbstractC0116Ce.m476e(method, "putMethod");
        AbstractC0116Ce.m476e(method2, "getMethod");
        AbstractC0116Ce.m476e(method3, "removeMethod");
        AbstractC0116Ce.m476e(cls, "clientProviderClass");
        AbstractC0116Ce.m476e(cls2, "serverProviderClass");
        this.f2758d = method;
        this.f2759e = method2;
        this.f2760f = method3;
        this.f2761g = cls;
        this.f2762h = cls2;
    }

    @Override
    public void mo3675b(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        try {
            this.f2760f.invoke(null, sSLSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override
    public void mo1315e(SSLSocket sSLSocket, String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        try {
            this.f2758d.invoke(null, sSLSocket, Proxy.newProxyInstance(C0764Qi.class.getClassLoader(), new Class[]{this.f2761g, this.f2762h}, new a(C0764Qi.f2268c.m3685b(list))));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override
    public String mo1316g(SSLSocket sSLSocket) throws IllegalArgumentException {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f2759e.invoke(null, sSLSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            a aVar = (a) invocationHandler;
            if (!aVar.m4151b() && aVar.m4150a() == null) {
                C0764Qi.m3674k(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (aVar.m4151b()) {
                return null;
            }
            return aVar.m4150a();
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
