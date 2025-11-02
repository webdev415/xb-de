package p000;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class AbstractC0674Ok implements Serializable {

    public static final a f2054l = new a(null);

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b implements Serializable {

        public final Throwable f2055l;

        public b(Throwable th) {
            AbstractC0116Ce.m476e(th, "exception");
            this.f2055l = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && AbstractC0116Ce.m472a(this.f2055l, ((b) obj).f2055l);
        }

        public int hashCode() {
            return this.f2055l.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f2055l + ')';
        }
    }

    public static final Throwable m3432b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f2055l;
        }
        return null;
    }

    public static final boolean m3433c(Object obj) {
        return obj instanceof b;
    }

    public static Object m3431a(Object obj) {
        return obj;
    }
}
