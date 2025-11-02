package p000;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractC1964ka extends AbstractC0283G6 {

    public long f6008n;

    public boolean f6009o;

    public C2315s1 f6010p;

    public static void m8264b0(AbstractC1964ka abstractC1964ka, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        abstractC1964ka.m8269a0(z);
    }

    public final void m8265W(boolean z) {
        long jM8266X = this.f6008n - m8266X(z);
        this.f6008n = jM8266X;
        if (jM8266X <= 0 && this.f6009o) {
            shutdown();
        }
    }

    public final long m8266X(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public final void m8267Y(AbstractC1020W8 abstractC1020W8) {
        C2315s1 c2315s1 = this.f6010p;
        if (c2315s1 == null) {
            c2315s1 = new C2315s1();
            this.f6010p = c2315s1;
        }
        c2315s1.addLast(abstractC1020W8);
    }

    public long mo8268Z() {
        C2315s1 c2315s1 = this.f6010p;
        return (c2315s1 == null || c2315s1.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void m8269a0(boolean z) {
        this.f6008n += m8266X(z);
        if (z) {
            return;
        }
        this.f6009o = true;
    }

    public final boolean m8270c0() {
        return this.f6008n >= m8266X(true);
    }

    public final boolean m8271d0() {
        C2315s1 c2315s1 = this.f6010p;
        if (c2315s1 != null) {
            return c2315s1.isEmpty();
        }
        return true;
    }

    public final boolean m8272e0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC1020W8 abstractC1020W8;
        C2315s1 c2315s1 = this.f6010p;
        if (c2315s1 == null || (abstractC1020W8 = (AbstractC1020W8) c2315s1.m9468r()) == null) {
            return false;
        }
        abstractC1020W8.run();
        return true;
    }

    public abstract void shutdown();
}
