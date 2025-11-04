package p000;

public abstract class AbstractC1174Zf {

    public static final Object f3443a = new C0951Um("CONDITION_FALSE");

    public static final Object m5039a() {
        return f3443a;
    }

    public static final C1222ag m5040b(Object obj) {
        C1222ag c1222ag;
        C2665zk c2665zk = obj instanceof C2665zk ? (C2665zk) obj : null;
        if (c2665zk != null && (c1222ag = c2665zk.f8267a) != null) {
            return c1222ag;
        }
        AbstractC0116Ce.m474c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (C1222ag) obj;
    }
}
