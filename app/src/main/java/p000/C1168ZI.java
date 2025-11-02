package p000;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class C1168ZI extends AbstractC0450Jq {

    public final Callable f3434n;

    public C1168ZI(String str, Callable callable) {
        super(str);
        this.f3434n = callable;
    }

    @Override
    public final InterfaceC0909Tq mo1366b(C2357sy c2357sy, List list) {
        try {
            return AbstractC0103CA.m414a(this.f3434n.call());
        } catch (Exception unused) {
            return InterfaceC0909Tq.f2785d;
        }
    }
}
