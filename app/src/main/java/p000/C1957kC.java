package p000;

import java.util.Collections;
import java.util.Map;
import p000.AbstractC0703PC;

public class C1957kC {

    public static volatile C1957kC f5976b;

    public static final C1957kC f5977c = new C1957kC(true);

    public final Map f5978a = Collections.emptyMap();

    public static final class a {

        public final Object f5979a;

        public final int f5980b;

        public a(Object obj, int i) {
            this.f5979a = obj;
            this.f5980b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5979a == aVar.f5979a && this.f5980b == aVar.f5980b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f5979a) * 65535) + this.f5980b;
        }
    }

    public C1957kC(boolean z) {
    }

    public static C1957kC m8236a() {
        C1957kC c1957kC = f5976b;
        if (c1957kC != null) {
            return c1957kC;
        }
        synchronized (C1957kC.class) {
            try {
                C1957kC c1957kC2 = f5976b;
                if (c1957kC2 != null) {
                    return c1957kC2;
                }
                C1957kC c1957kCM2846a = AbstractC0565MC.m2846a(C1957kC.class);
                f5976b = c1957kCM2846a;
                return c1957kCM2846a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final AbstractC0703PC.d m8237b(InterfaceC1912jE interfaceC1912jE, int i) {
        AbstractC2524wh.m10586a(this.f5978a.get(new a(interfaceC1912jE, i)));
        return null;
    }
}
