package p000;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class C2528wl {

    public static final int f7891c;

    public static final AtomicReference[] f7892d;

    public static final C2528wl f7893e = new C2528wl();

    public static final int f7889a = 65536;

    public static final C2482vl f7890b = new C2482vl(new byte[0], 0, 0, false, false);

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f7891c = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        f7892d = atomicReferenceArr;
    }

    public static final void m10594b(C2482vl c2482vl) {
        AbstractC0116Ce.m476e(c2482vl, "segment");
        if (!(c2482vl.f7763f == null && c2482vl.f7764g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (c2482vl.f7761d) {
            return;
        }
        AtomicReference atomicReferenceM10596a = f7893e.m10596a();
        C2482vl c2482vl2 = (C2482vl) atomicReferenceM10596a.get();
        if (c2482vl2 == f7890b) {
            return;
        }
        int i = c2482vl2 != null ? c2482vl2.f7760c : 0;
        if (i >= f7889a) {
            return;
        }
        c2482vl.f7763f = c2482vl2;
        c2482vl.f7759b = 0;
        c2482vl.f7760c = i + 8192;
        if (AbstractC1639db.m7321a(atomicReferenceM10596a, c2482vl2, c2482vl)) {
            return;
        }
        c2482vl.f7763f = null;
    }

    public static final C2482vl m10595c() {
        AtomicReference atomicReferenceM10596a = f7893e.m10596a();
        C2482vl c2482vl = f7890b;
        C2482vl c2482vl2 = (C2482vl) atomicReferenceM10596a.getAndSet(c2482vl);
        if (c2482vl2 == c2482vl) {
            return new C2482vl();
        }
        if (c2482vl2 == null) {
            atomicReferenceM10596a.set(null);
            return new C2482vl();
        }
        atomicReferenceM10596a.set(c2482vl2.f7763f);
        c2482vl2.f7763f = null;
        c2482vl2.f7760c = 0;
        return c2482vl2;
    }

    public final AtomicReference m10596a() {
        Thread threadCurrentThread = Thread.currentThread();
        AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
        return f7892d[(int) (threadCurrentThread.getId() & (f7891c - 1))];
    }
}
