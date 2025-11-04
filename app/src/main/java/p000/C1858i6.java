package p000;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

public final class C1858i6 {

    public int f5781a;

    public boolean f5782b;

    public boolean f5783c;

    public final List f5784d;

    public C1858i6(List list) {
        AbstractC0116Ce.m476e(list, "connectionSpecs");
        this.f5784d = list;
    }

    public final ConnectionSpec m7867a(SSLSocket sSLSocket) throws UnknownServiceException, CloneNotSupportedException {
        ConnectionSpec connectionSpec;
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        int i = this.f5781a;
        int size = this.f5784d.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = (ConnectionSpec) this.f5784d.get(i);
            i++;
            if (connectionSpec.m7795e(sSLSocket)) {
                this.f5781a = i;
                break;
            }
        }
        if (connectionSpec != null) {
            this.f5782b = m7869c(sSLSocket);
            connectionSpec.m7793c(sSLSocket, this.f5783c);
            return connectionSpec;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f5783c);
        sb.append(',');
        sb.append(" modes=");
        sb.append(this.f5784d);
        sb.append(',');
        sb.append(" supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        AbstractC0116Ce.m473b(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        AbstractC0116Ce.m475d(string, "java.util.Arrays.toString(this)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean m7868b(IOException iOException) {
        AbstractC0116Ce.m476e(iOException, "e");
        this.f5783c = true;
        return (!this.f5782b || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !(iOException instanceof SSLException)) ? false : true;
    }

    public final boolean m7869c(SSLSocket sSLSocket) {
        int size = this.f5784d.size();
        for (int i = this.f5781a; i < size; i++) {
            if (((ConnectionSpec) this.f5784d.get(i)).m7795e(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
