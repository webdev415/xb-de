package p000;

/* loaded from: classes.dex */
public class C1180Zl implements Comparable {

    public final int f3463l;

    public final int f3464m;

    public C1180Zl(int i, int i2) {
        this.f3463l = i;
        this.f3464m = i2;
    }

    @Override
    public int compareTo(C1180Zl c1180Zl) {
        int i = this.f3464m * this.f3463l;
        int i2 = c1180Zl.f3464m * c1180Zl.f3463l;
        if (i2 < i) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public C1180Zl m5068e() {
        return new C1180Zl(this.f3464m, this.f3463l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1180Zl c1180Zl = (C1180Zl) obj;
        return this.f3463l == c1180Zl.f3463l && this.f3464m == c1180Zl.f3464m;
    }

    public C1180Zl m5069g(C1180Zl c1180Zl) {
        int i = this.f3463l;
        int i2 = c1180Zl.f3464m;
        int i3 = i * i2;
        int i4 = c1180Zl.f3463l;
        int i5 = this.f3464m;
        return i3 <= i4 * i5 ? new C1180Zl(i4, (i5 * i4) / i) : new C1180Zl((i * i2) / i5, i2);
    }

    public C1180Zl m5070h(C1180Zl c1180Zl) {
        int i = this.f3463l;
        int i2 = c1180Zl.f3464m;
        int i3 = i * i2;
        int i4 = c1180Zl.f3463l;
        int i5 = this.f3464m;
        return i3 >= i4 * i5 ? new C1180Zl(i4, (i5 * i4) / i) : new C1180Zl((i * i2) / i5, i2);
    }

    public int hashCode() {
        return (this.f3463l * 31) + this.f3464m;
    }

    public String toString() {
        return this.f3463l + "x" + this.f3464m;
    }
}
