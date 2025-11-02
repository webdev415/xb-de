package p000;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public abstract class AbstractC2578xp {
    public static boolean m10784a(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
