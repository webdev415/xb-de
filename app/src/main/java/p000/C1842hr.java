package p000;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class C1842hr implements InterfaceC0909Tq {
    @Override
    public final InterfaceC0909Tq mo151c() {
        return InterfaceC0909Tq.f2785d;
    }

    @Override
    public final Boolean mo152d() {
        return Boolean.FALSE;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof C1842hr;
    }

    @Override
    public final Double mo153f() {
        return Double.valueOf(Double.NaN);
    }

    @Override
    public final String mo154h() {
        return "undefined";
    }

    @Override
    public final Iterator mo155i() {
        return null;
    }

    @Override
    public final InterfaceC0909Tq mo156o(String str, C2357sy c2357sy, List list) {
        throw new IllegalStateException(String.format("Undefined has no function %s", str));
    }
}
