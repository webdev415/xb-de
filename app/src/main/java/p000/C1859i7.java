package p000;

public class C1859i7 {

    public final int f5785a;

    public final int f5786b;

    public C1859i7(int i, int i2) {
        this.f5785a = i;
        this.f5786b = i2;
    }

    public final int m7870a() {
        return this.f5786b;
    }

    public final int m7871b() {
        return this.f5785a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1859i7)) {
            return false;
        }
        C1859i7 c1859i7 = (C1859i7) obj;
        return this.f5785a == c1859i7.f5785a && this.f5786b == c1859i7.f5786b;
    }

    public final int hashCode() {
        return this.f5785a ^ this.f5786b;
    }

    public final String toString() {
        return this.f5785a + "(" + this.f5786b + ')';
    }
}
