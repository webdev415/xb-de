package p000;

import java.util.LinkedHashSet;
import java.util.Set;

public final class C1649dl {

    public final Set f5329a = new LinkedHashSet();

    public final synchronized void m7351a(Route route) {
        AbstractC0116Ce.m476e(route, "route");
        this.f5329a.remove(route);
    }

    public final synchronized void m7352b(Route route) {
        AbstractC0116Ce.m476e(route, "failedRoute");
        this.f5329a.add(route);
    }

    public final synchronized boolean m7353c(Route route) {
        AbstractC0116Ce.m476e(route, "route");
        return this.f5329a.contains(route);
    }
}
