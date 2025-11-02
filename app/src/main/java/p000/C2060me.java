package p000;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/* loaded from: classes.dex */
public class C2060me extends AbstractC0672Oi {

    public final InputStream f6181n;

    public final OutputStream f6182o;

    public a f6183p;

    public final byte[] f6184q = new byte[8192];

    public interface a {
        void mo8468a();

        void mo8469e(byte[] bArr, int i);

        void mo8470f();
    }

    public C2060me(InputStream inputStream, OutputStream outputStream, a aVar) {
        this.f6181n = inputStream;
        this.f6182o = outputStream;
        this.f6183p = aVar;
    }

    @Override
    public void run() {
        PrintStream printStream;
        StringBuilder sb;
        System.out.println("===========  create input pipe to receive data ===============");
        a aVar = this.f6183p;
        if (aVar != null) {
            aVar.mo8468a();
        }
        int i = 0;
        while (true) {
            try {
                try {
                    int i2 = this.f6181n.read(this.f6184q);
                    if (i2 == -1) {
                        break;
                    }
                    if (i2 > 0) {
                        if ((m3428c() & 1) == 1) {
                            AbstractC0672Oi.m3427b(this.f6184q, 0, i2);
                        }
                        if ((m3428c() & 16) == 16) {
                            AbstractC0672Oi.m3426a(this.f6184q, 0, i2);
                        }
                        this.f6182o.write(this.f6184q, 0, i2);
                        a aVar2 = this.f6183p;
                        if (aVar2 != null) {
                            aVar2.mo8469e(this.f6184q, i2);
                        }
                        this.f6182o.flush();
                        i += i2;
                    }
                } catch (Exception unused) {
                    a aVar3 = this.f6183p;
                    if (aVar3 != null) {
                        aVar3.mo8470f();
                    }
                    if (this.f2052l == null) {
                        return;
                    }
                    printStream = System.out;
                    sb = new StringBuilder();
                }
            } catch (Throwable th) {
                if (this.f2052l != null) {
                    System.out.println(this.f2052l + " Input Pipe closed total  data size: [" + i + "] ");
                }
                throw th;
            }
        }
        if (this.f2052l != null) {
            printStream = System.out;
            sb = new StringBuilder();
            sb.append(this.f2052l);
            sb.append(" Input Pipe closed total  data size: [");
            sb.append(i);
            sb.append("] ");
            printStream.println(sb.toString());
        }
    }
}
