package p000;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class C0206Ec {

    public static volatile C0206Ec f522b;

    public final Set f523a = new HashSet();

    public static C0206Ec m1031a() {
        C0206Ec c0206Ec = f522b;
        if (c0206Ec == null) {
            synchronized (C0206Ec.class) {
                try {
                    c0206Ec = f522b;
                    if (c0206Ec == null) {
                        c0206Ec = new C0206Ec();
                        f522b = c0206Ec;
                    }
                } finally {
                }
            }
        }
        return c0206Ec;
    }

    public Set m1032b() {
        Set setUnmodifiableSet;
        synchronized (this.f523a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f523a);
        }
        return setUnmodifiableSet;
    }
}
