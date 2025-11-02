package p000;

public class C2567xe implements Iterable {

    public static final a f8004o = new a(null);

    public final int f8005l;

    public final int f8006m;

    public final int f8007n;

    public static final class a {
        public a() {
        }

        public final C2567xe m10720a(int i, int i2, int i3) {
            return new C2567xe(i, i2, i3);
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C2567xe(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f8005l = i;
        this.f8006m = AbstractC2157oj.m8967b(i, i2, i3);
        this.f8007n = i3;
    }

    public final int m10716d() {
        return this.f8005l;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2567xe) {
            if (!isEmpty() || !((C2567xe) obj).isEmpty()) {
                C2567xe c2567xe = (C2567xe) obj;
                if (this.f8005l != c2567xe.f8005l || this.f8006m != c2567xe.f8006m || this.f8007n != c2567xe.f8007n) {
                }
            }
            return true;
        }
        return false;
    }

    public final int m10717f() {
        return this.f8006m;
    }

    public final int m10718g() {
        return this.f8007n;
    }

    @Override
    public AbstractC2521we iterator() {
        return new C2613ye(this.f8005l, this.f8006m, this.f8007n);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f8005l * 31) + this.f8006m) * 31) + this.f8007n;
    }

    public boolean isEmpty() {
        if (this.f8007n > 0) {
            if (this.f8005l <= this.f8006m) {
                return false;
            }
        } else if (this.f8005l >= this.f8006m) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f8007n > 0) {
            sb = new StringBuilder();
            sb.append(this.f8005l);
            sb.append("..");
            sb.append(this.f8006m);
            sb.append(" step ");
            i = this.f8007n;
        } else {
            sb = new StringBuilder();
            sb.append(this.f8005l);
            sb.append(" downTo ");
            sb.append(this.f8006m);
            sb.append(" step ");
            i = -this.f8007n;
        }
        sb.append(i);
        return sb.toString();
    }
}
