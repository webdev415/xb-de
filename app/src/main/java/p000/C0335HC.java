package p000;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class C0335HC {

    public Map f1034a = new HashMap<>();

    public final InterfaceC0909Tq m1535a(String str) {
        if (!this.f1034a.containsKey(str)) {
            return InterfaceC0909Tq.f2785d;
        }
        try {
            return (InterfaceC0909Tq) ((Callable) this.f1034a.get(str)).call();
        } catch (Exception unused) {
            throw new IllegalStateException("Failed to create API implementation: " + str);
        }
    }

    public final void m1536b(String str, Callable callable) {
        this.f1034a.put(str, callable);
    }
}
