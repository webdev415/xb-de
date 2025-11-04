package p000;

import java.net.Proxy;

public final class C0260Fk {

    public static final C0260Fk f676a = new C0260Fk();

    public final String m1270a(Request request, Proxy.Type type) {
        AbstractC0116Ce.m476e(request, "request");
        AbstractC0116Ce.m476e(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.m496g());
        sb.append(' ');
        C0260Fk c0260Fk = f676a;
        boolean zM1271b = c0260Fk.m1271b(request, type);
        C0069Bd c0069BdM498i = request.getUrl();
        if (zM1271b) {
            sb.append(c0069BdM498i);
        } else {
            sb.append(c0260Fk.m1272c(c0069BdM498i));
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final boolean m1271b(Request request, Proxy.Type type) {
        return !request.m495f() && type == Proxy.Type.HTTP;
    }

    public final String m1272c(C0069Bd c0069Bd) {
        AbstractC0116Ce.m476e(c0069Bd, "url");
        String strM245d = c0069Bd.m245d();
        String strM247f = c0069Bd.m247f();
        if (strM247f == null) {
            return strM245d;
        }
        return strM245d + '?' + strM247f;
    }
}
