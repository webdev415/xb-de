package p000;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractC0533Lh {

    public static final Logger f1717a = Logger.getLogger("okio.Okio");

    public static final boolean m2699b(AssertionError assertionError) {
        AbstractC0116Ce.m476e(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? AbstractC0584Mm.m2918B(message, "getsockname failed", false, 2, null) : false;
    }

    public static final InterfaceC1134Yl m2700c(Socket socket) throws IOException {
        AbstractC0116Ce.m476e(socket, "$this$sink");
        C1329bm c1329bm = new C1329bm(socket);
        OutputStream outputStream = socket.getOutputStream();
        AbstractC0116Ce.m475d(outputStream, "getOutputStream()");
        return c1329bm.m1478v(new C1972ki(outputStream, c1329bm));
    }

    public static final InterfaceC2161om m2701d(InputStream inputStream) {
        AbstractC0116Ce.m476e(inputStream, "$this$source");
        return new C2106ne(inputStream, new C0125Cn());
    }

    public static final InterfaceC2161om m2702e(Socket socket) throws IOException {
        AbstractC0116Ce.m476e(socket, "$this$source");
        C1329bm c1329bm = new C1329bm(socket);
        InputStream inputStream = socket.getInputStream();
        AbstractC0116Ce.m475d(inputStream, "getInputStream()");
        return c1329bm.m1479w(new C2106ne(inputStream, c1329bm));
    }
}
