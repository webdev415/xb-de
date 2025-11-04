package p000;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class C1926ji extends AbstractC0672Oi {

    public final InputStream f5956n;

    public final OutputStream f5957o;

    public a f5958p;

    public final byte[] f5959q = new byte[8192];

    public interface a {
        void mo8178b(byte[] bArr, int i);

        void mo8179c();

        void mo8180d();
    }

    public C1926ji(InputStream inputStream, OutputStream outputStream, a aVar) {
        this.f5956n = inputStream;
        this.f5957o = outputStream;
        this.f5958p = aVar;
    }

    @Override
    public void run() {
        System.out.println("===========  create output pipe to send data ===============");
        if (f5958p != null) {
            f5958p.mo8180d();
        }
        int i = 0;
        while (true) {
            try {
                try {
                    int i2 = this.f5956n.read(this.f5959q);
                    if (i2 == -1) {
                        break;
                    }
                    if (i2 > 0) {
                        if ((m3428c() & 16) == 16) {
                            AbstractC0672Oi.m3426a(this.f5959q, 0, i2);
                        }
                        if ((m3428c() & 1) == 1) {
                            AbstractC0672Oi.m3427b(this.f5959q, 0, i2);
                        }
                        this.f5957o.write(this.f5959q, 0, i2);
                        a aVar2 = this.f5958p;
                        if (aVar2 != null) {
                            aVar2.mo8178b(this.f5959q, i2);
                        }
                        this.f5957o.flush();
                        i += i2;
                    }
                } catch (Exception unused) {
                    a aVar3 = this.f5958p;
                    if (aVar3 != null) {
                        aVar3.mo8179c();
                    }
                    if (this.f2052l == null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                if (this.f2052l != null) {
                    System.out.println(this.f2052l + " Output pipe closed total  data size: [" + i + "]");
                }
                throw th;
            }
        }
        if (this.f2052l != null) {
            System.out.println(f2052l +
                    " Output pipe closed total  data size: [" +
                    i +
                    "]");
        }
    }
}
