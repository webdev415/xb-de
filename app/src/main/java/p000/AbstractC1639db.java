package p000;

import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractC1639db {
    public static boolean m7321a(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
