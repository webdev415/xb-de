package p000;

import java.util.concurrent.TimeUnit;

public class C0214Ek {

    public static final long f528d = TimeUnit.HOURS.toMillis(24);

    public static final long f529e = TimeUnit.MINUTES.toMillis(30);

    public final C0034Ao f530a = C0034Ao.m143c();

    public long f531b;

    public int f532c;

    public static boolean m1065c(int i) {
        return i == 429 || (i >= 500 && i < 600);
    }

    public static boolean m1066d(int i) {
        return (i >= 200 && i < 300) || i == 401 || i == 404;
    }

    public final synchronized long m1067a(int i) {
        if (m1065c(i)) {
            return (long) Math.min(Math.pow(2.0d, this.f532c) + this.f530a.m149e(), f529e);
        }
        return f528d;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m1068b() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f532c     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L16
            Ao r0 = r4.f530a     // Catch: java.lang.Throwable -> L14
            long r0 = r0.m147a()     // Catch: java.lang.Throwable -> L14
            long r2 = r4.f531b     // Catch: java.lang.Throwable -> L14
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L12
            goto L16
        L12:
            r0 = 0
            goto L17
        L14:
            r0 = move-exception
            goto L19
        L16:
            r0 = 1
        L17:
            monitor-exit(r4)
            return r0
        L19:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0214Ek.m1068b():boolean");
    }

    public final synchronized void m1069e() {
        this.f532c = 0;
    }

    public synchronized void m1070f(int i) {
        if (m1066d(i)) {
            m1069e();
            return;
        }
        this.f532c++;
        this.f531b = this.f530a.m147a() + m1067a(i);
    }
}
