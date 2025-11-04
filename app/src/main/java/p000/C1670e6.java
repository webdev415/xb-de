package p000;

import java.util.concurrent.TimeUnit;

public final class C1670e6 {

    public final C1835hk f5392a;

    public C1670e6() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public final C1835hk m7389a() {
        return this.f5392a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1670e6(int i, long j, TimeUnit timeUnit) {
        this(new C1835hk(C2300rn.f6963h, i, j, timeUnit));
        AbstractC0116Ce.m476e(timeUnit, "timeUnit");
    }

    public C1670e6(C1835hk c1835hk) {
        AbstractC0116Ce.m476e(c1835hk, "delegate");
        this.f5392a = c1835hk;
    }
}
