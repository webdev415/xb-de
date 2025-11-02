package p000;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import p000.AbstractC2434uj;

public class C2619yk extends AbstractC2434uj {

    public final Socket f8118n;

    public InputStream f8119o;

    public OutputStream f8120p;

    public Socket f8121q;

    public InputStream f8122r;

    public OutputStream f8123s;

    public a f8124t;

    public final String[] f8116l = {"223834806b7807dc710ac1d30c488a59", "2aa42335ba9b7fb80bd9c9f67298b724", "cb37a03c2a2d7439cadfffae2de254e9"};

    public final byte[] f8117m = new byte[4096];

    public boolean f8125u = false;

    public C2619yk(Socket socket, a aVar) {
        this.f8118n = socket;
        this.f8124t = aVar;
    }

    private void m10900i() throws InterruptedException {
        C1926ji c1926ji = new C1926ji(this.f8119o, this.f8123s, this.f8124t);
        c1926ji.m3430e("client --->" + this.f8118n.getInetAddress() + ":" + this.f8118n.getPort() + " to " + this.f8121q.getInetAddress() + ":" + this.f8121q.getPort());
        C2060me c2060me = new C2060me(this.f8122r, this.f8120p, this.f8124t);
        c2060me.m3430e("server ----> " + this.f8121q.getInetAddress() + ":" + this.f8121q.getPort() + " to " + this.f8118n.getInetAddress() + ":" + this.f8121q.getLocalPort());
        c1926ji.m3429d(16);
        c2060me.m3429d(1);
        c1926ji.start();
        c2060me.start();
        c1926ji.join();
        c2060me.join();
        this.f8125u = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x018d A[Catch: IOException -> 0x0193, TryCatch #1 {IOException -> 0x0193, blocks: (B:28:0x0189, B:30:0x018d, B:33:0x0195, B:35:0x0199, B:36:0x019e, B:38:0x01a2, B:39:0x01a7, B:41:0x01ab, B:42:0x01b0, B:44:0x01b4, B:45:0x01b7, B:47:0x01bb, B:75:0x0238, B:77:0x023c, B:78:0x0241, B:80:0x0245, B:81:0x024a, B:83:0x024e, B:84:0x0253, B:86:0x0257, B:87:0x025c, B:89:0x0260, B:90:0x0263, B:92:0x0267, B:3:0x0006, B:8:0x0031, B:10:0x0083, B:12:0x0089, B:13:0x009a, B:16:0x00a2, B:17:0x00c4, B:18:0x00d6, B:20:0x00e1, B:22:0x010c, B:24:0x011e, B:25:0x012f, B:27:0x0186, B:50:0x01c5, B:51:0x01fd), top: B:96:0x0006, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0199 A[Catch: IOException -> 0x0193, TryCatch #1 {IOException -> 0x0193, blocks: (B:28:0x0189, B:30:0x018d, B:33:0x0195, B:35:0x0199, B:36:0x019e, B:38:0x01a2, B:39:0x01a7, B:41:0x01ab, B:42:0x01b0, B:44:0x01b4, B:45:0x01b7, B:47:0x01bb, B:75:0x0238, B:77:0x023c, B:78:0x0241, B:80:0x0245, B:81:0x024a, B:83:0x024e, B:84:0x0253, B:86:0x0257, B:87:0x025c, B:89:0x0260, B:90:0x0263, B:92:0x0267, B:3:0x0006, B:8:0x0031, B:10:0x0083, B:12:0x0089, B:13:0x009a, B:16:0x00a2, B:17:0x00c4, B:18:0x00d6, B:20:0x00e1, B:22:0x010c, B:24:0x011e, B:25:0x012f, B:27:0x0186, B:50:0x01c5, B:51:0x01fd), top: B:96:0x0006, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a2 A[Catch: IOException -> 0x0193, TryCatch #1 {IOException -> 0x0193, blocks: (B:28:0x0189, B:30:0x018d, B:33:0x0195, B:35:0x0199, B:36:0x019e, B:38:0x01a2, B:39:0x01a7, B:41:0x01ab, B:42:0x01b0, B:44:0x01b4, B:45:0x01b7, B:47:0x01bb, B:75:0x0238, B:77:0x023c, B:78:0x0241, B:80:0x0245, B:81:0x024a, B:83:0x024e, B:84:0x0253, B:86:0x0257, B:87:0x025c, B:89:0x0260, B:90:0x0263, B:92:0x0267, B:3:0x0006, B:8:0x0031, B:10:0x0083, B:12:0x0089, B:13:0x009a, B:16:0x00a2, B:17:0x00c4, B:18:0x00d6, B:20:0x00e1, B:22:0x010c, B:24:0x011e, B:25:0x012f, B:27:0x0186, B:50:0x01c5, B:51:0x01fd), top: B:96:0x0006, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ab A[Catch: IOException -> 0x0193, TryCatch #1 {IOException -> 0x0193, blocks: (B:28:0x0189, B:30:0x018d, B:33:0x0195, B:35:0x0199, B:36:0x019e, B:38:0x01a2, B:39:0x01a7, B:41:0x01ab, B:42:0x01b0, B:44:0x01b4, B:45:0x01b7, B:47:0x01bb, B:75:0x0238, B:77:0x023c, B:78:0x0241, B:80:0x0245, B:81:0x024a, B:83:0x024e, B:84:0x0253, B:86:0x0257, B:87:0x025c, B:89:0x0260, B:90:0x0263, B:92:0x0267, B:3:0x0006, B:8:0x0031, B:10:0x0083, B:12:0x0089, B:13:0x009a, B:16:0x00a2, B:17:0x00c4, B:18:0x00d6, B:20:0x00e1, B:22:0x010c, B:24:0x011e, B:25:0x012f, B:27:0x0186, B:50:0x01c5, B:51:0x01fd), top: B:96:0x0006, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b4 A[Catch: IOException -> 0x0193, TryCatch #1 {IOException -> 0x0193, blocks: (B:28:0x0189, B:30:0x018d, B:33:0x0195, B:35:0x0199, B:36:0x019e, B:38:0x01a2, B:39:0x01a7, B:41:0x01ab, B:42:0x01b0, B:44:0x01b4, B:45:0x01b7, B:47:0x01bb, B:75:0x0238, B:77:0x023c, B:78:0x0241, B:80:0x0245, B:81:0x024a, B:83:0x024e, B:84:0x0253, B:86:0x0257, B:87:0x025c, B:89:0x0260, B:90:0x0263, B:92:0x0267, B:3:0x0006, B:8:0x0031, B:10:0x0083, B:12:0x0089, B:13:0x009a, B:16:0x00a2, B:17:0x00c4, B:18:0x00d6, B:20:0x00e1, B:22:0x010c, B:24:0x011e, B:25:0x012f, B:27:0x0186, B:50:0x01c5, B:51:0x01fd), top: B:96:0x0006, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01bb A[Catch: IOException -> 0x0193, TRY_LEAVE, TryCatch #1 {IOException -> 0x0193, blocks: (B:28:0x0189, B:30:0x018d, B:33:0x0195, B:35:0x0199, B:36:0x019e, B:38:0x01a2, B:39:0x01a7, B:41:0x01ab, B:42:0x01b0, B:44:0x01b4, B:45:0x01b7, B:47:0x01bb, B:75:0x0238, B:77:0x023c, B:78:0x0241, B:80:0x0245, B:81:0x024a, B:83:0x024e, B:84:0x0253, B:86:0x0257, B:87:0x025c, B:89:0x0260, B:90:0x0263, B:92:0x0267, B:3:0x0006, B:8:0x0031, B:10:0x0083, B:12:0x0089, B:13:0x009a, B:16:0x00a2, B:17:0x00c4, B:18:0x00d6, B:20:0x00e1, B:22:0x010c, B:24:0x011e, B:25:0x012f, B:27:0x0186, B:50:0x01c5, B:51:0x01fd), top: B:96:0x0006, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo4779e() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2619yk.mo4779e():void");
    }

    public final boolean m10901h(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.f8116l;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equals(str)) {
                return true;
            }
            i++;
        }
    }
}
