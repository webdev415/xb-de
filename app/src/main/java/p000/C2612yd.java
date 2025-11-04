package p000;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p000.C2290rd;

public final class C2612yd implements Closeable {

    public final C2409u3 f8088l;

    public int f8089m;

    public boolean f8090n;

    public final C2290rd.b f8091o;

    public final InterfaceC2501w3 f8092p;

    public final boolean f8093q;

    public static final a f8087s = new a(null);

    public static final Logger f8086r = Logger.getLogger(C2382td.class.getName());

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C2612yd(InterfaceC2501w3 interfaceC2501w3, boolean z) {
        AbstractC0116Ce.m476e(interfaceC2501w3, "sink");
        this.f8092p = interfaceC2501w3;
        this.f8093q = z;
        C2409u3 c2409u3 = new C2409u3();
        this.f8088l = c2409u3;
        this.f8089m = 16384;
        this.f8091o = new C2290rd.b(0, false, c2409u3, 3, null);
    }

    public final synchronized void m10865A(C0767Ql c0767Ql) {
        try {
            AbstractC0116Ce.m476e(c0767Ql, "settings");
            if (this.f8090n) {
                throw new IOException("closed");
            }
            int i = 0;
            m10872j(0, c0767Ql.m3705i() * 6, 4, 0);
            while (i < 10) {
                if (c0767Ql.m3702f(i)) {
                    this.f8092p.mo5933t(i != 4 ? i != 7 ? i : 4 : 3);
                    this.f8092p.mo5934y(c0767Ql.m3697a(i));
                }
                i++;
            }
            this.f8092p.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m10866B(int i, long j) {
        if (this.f8090n) {
            throw new IOException("closed");
        }
        if (!(j != 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        m10872j(i, 4, 8, 0);
        this.f8092p.mo5934y((int) j);
        this.f8092p.flush();
    }

    public final void m10867C(int i, long j) {
        while (j > 0) {
            long jMin = Math.min(this.f8089m, j);
            j -= jMin;
            m10872j(i, (int) jMin, 9, j == 0 ? 4 : 0);
            this.f8092p.mo115h(this.f8088l, jMin);
        }
    }

    public final synchronized void m10868a(C0767Ql c0767Ql) {
        try {
            AbstractC0116Ce.m476e(c0767Ql, "peerSettings");
            if (this.f8090n) {
                throw new IOException("closed");
            }
            this.f8089m = c0767Ql.m3701e(this.f8089m);
            if (c0767Ql.m3698b() != -1) {
                this.f8091o.m9407e(c0767Ql.m3698b());
            }
            m10872j(0, 0, 4, 1);
            this.f8092p.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m10869b() {
        try {
            if (this.f8090n) {
                throw new IOException("closed");
            }
            if (this.f8093q) {
                Logger logger = f8086r;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(AbstractC2623yo.m10942q(">> CONNECTION " + C2382td.f7217a.mo379m(), new Object[0]));
                }
                this.f8092p.mo5927M(C2382td.f7217a);
                this.f8092p.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public synchronized void close() {
        this.f8090n = true;
        this.f8092p.close();
    }

    public final synchronized void flush() {
        if (this.f8090n) {
            throw new IOException("closed");
        }
        this.f8092p.flush();
    }

    public final synchronized void m10870g(boolean z, int i, C2409u3 c2409u3, int i2) {
        if (this.f8090n) {
            throw new IOException("closed");
        }
        m10871i(i, z ? 1 : 0, c2409u3, i2);
    }

    public final void m10871i(int i, int i2, C2409u3 c2409u3, int i3) {
        m10872j(i, i3, 0, i2);
        if (i3 > 0) {
            InterfaceC2501w3 interfaceC2501w3 = this.f8092p;
            AbstractC0116Ce.m473b(c2409u3);
            interfaceC2501w3.mo115h(c2409u3, i3);
        }
    }

    public final void m10872j(int i, int i2, int i3, int i4) {
        Logger logger = f8086r;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C2382td.f7221e.m9705c(false, i, i2, i3, i4));
        }
        if (!(i2 <= this.f8089m)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f8089m + ": " + i2).toString());
        }
        if (!((((int) 2147483648L) & i) == 0)) {
            throw new IllegalArgumentException(("reserved bit set: " + i).toString());
        }
        AbstractC2623yo.m10925U(this.f8092p, i2);
        this.f8092p.mo5926L(i3 & 255);
        this.f8092p.mo5926L(i4 & 255);
        this.f8092p.mo5934y(i & Integer.MAX_VALUE);
    }

    public final synchronized void m10873k(int i, EnumC1159Z9 enumC1159Z9, byte[] bArr) {
        try {
            AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
            AbstractC0116Ce.m476e(bArr, "debugData");
            if (this.f8090n) {
                throw new IOException("closed");
            }
            if (!(enumC1159Z9.m5026c() != -1)) {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
            m10872j(0, bArr.length + 8, 7, 0);
            this.f8092p.mo5934y(i);
            this.f8092p.mo5934y(enumC1159Z9.m5026c());
            if (!(bArr.length == 0)) {
                this.f8092p.mo5930e(bArr);
            }
            this.f8092p.flush();
        } finally {
        }
    }

    public final synchronized void m10874l(boolean z, int i, List list) {
        AbstractC0116Ce.m476e(list, "headerBlock");
        if (this.f8090n) {
            throw new IOException("closed");
        }
        this.f8091o.m9409g(list);
        long jM9911Y = this.f8088l.m9911Y();
        long jMin = Math.min(this.f8089m, jM9911Y);
        int i2 = jM9911Y == jMin ? 4 : 0;
        if (z) {
            i2 |= 1;
        }
        m10872j(i, (int) jMin, 1, i2);
        this.f8092p.mo115h(this.f8088l, jMin);
        if (jM9911Y > jMin) {
            m10867C(i, jM9911Y - jMin);
        }
    }

    public final int m10875p() {
        return this.f8089m;
    }

    public final synchronized void m10876u(boolean z, int i, int i2) {
        if (this.f8090n) {
            throw new IOException("closed");
        }
        m10872j(0, 8, 6, z ? 1 : 0);
        this.f8092p.mo5934y(i);
        this.f8092p.mo5934y(i2);
        this.f8092p.flush();
    }

    public final synchronized void m10877w(int i, int i2, List list) {
        AbstractC0116Ce.m476e(list, "requestHeaders");
        if (this.f8090n) {
            throw new IOException("closed");
        }
        this.f8091o.m9409g(list);
        long jM9911Y = this.f8088l.m9911Y();
        int iMin = (int) Math.min(this.f8089m - 4, jM9911Y);
        long j = iMin;
        m10872j(i, iMin + 4, 5, jM9911Y == j ? 4 : 0);
        this.f8092p.mo5934y(i2 & Integer.MAX_VALUE);
        this.f8092p.mo115h(this.f8088l, j);
        if (jM9911Y > j) {
            m10867C(i, jM9911Y - j);
        }
    }

    public final synchronized void m10878z(int i, EnumC1159Z9 enumC1159Z9) {
        AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
        if (this.f8090n) {
            throw new IOException("closed");
        }
        if (!(enumC1159Z9.m5026c() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        m10872j(i, 4, 3, 0);
        this.f8092p.mo5934y(enumC1159Z9.m5026c());
        this.f8092p.flush();
    }
}
