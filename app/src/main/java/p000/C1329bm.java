package p000;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class C1329bm extends C0324H1 {

    public final Socket f3883m;

    public C1329bm(Socket socket) {
        AbstractC0116Ce.m476e(socket, "socket");
        this.f3883m = socket;
    }

    @Override
    public IOException mo1476t(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override
    public void mo1480x() throws IOException {
        Level level;
        StringBuilder sb;
        Logger logger;
        Exception exc;
        try {
            this.f3883m.close();
        } catch (AssertionError e) {
            if (!AbstractC0487Kh.m2377c(e)) {
                throw e;
            }
            Logger logger2 = AbstractC0533Lh.f1717a;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e;
            logger = logger2;
            sb.append("Failed to close timed out socket ");
            sb.append(this.f3883m);
            logger.log(level, sb.toString(), (Throwable) exc);
        } catch (Exception e2) {
            Logger logger3 = AbstractC0533Lh.f1717a;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e2;
            logger = logger3;
            sb.append("Failed to close timed out socket ");
            sb.append(this.f3883m);
            logger.log(level, sb.toString(), (Throwable) exc);
        }
    }
}
