package p000;

import java.util.LinkedHashSet;
import java.util.Set;

public final class C1649dl {

    public final Set f5329a = new LinkedHashSet();

    public final synchronized void m7351a(C1328bl c1328bl) {
        AbstractC0116Ce.m476e(c1328bl, "route");
        this.f5329a.remove(c1328bl);
    }

    public final synchronized void m7352b(C1328bl c1328bl) {
        AbstractC0116Ce.m476e(c1328bl, "failedRoute");
        this.f5329a.add(c1328bl);
    }

    public final synchronized boolean m7353c(C1328bl c1328bl) {
        AbstractC0116Ce.m476e(c1328bl, "route");
        return this.f5329a.contains(c1328bl);
    }
}
