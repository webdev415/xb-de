package p000;

import android.os.SystemClock;

/* loaded from: classes.dex */
public class C0835S7 implements InterfaceC0557M4 {

    public static final C0835S7 f2604a = new C0835S7();

    public static InterfaceC0557M4 m4014d() {
        return f2604a;
    }

    @Override
    public final long mo2815a() {
        return System.currentTimeMillis();
    }

    @Override
    public final long mo2816b() {
        return System.nanoTime();
    }

    @Override
    public final long mo2817c() {
        return SystemClock.elapsedRealtime();
    }
}
