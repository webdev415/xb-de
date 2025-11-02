package p000;

import android.os.SystemClock;

public abstract class AbstractC2391tm {
    public static AbstractC2391tm m9746a(long j, long j2, long j3) {
        return new C0967V1(j, j2, j3);
    }

    public static AbstractC2391tm m9747e() {
        return m9746a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long mo4307b();

    public abstract long mo4308c();

    public abstract long mo4309d();
}
