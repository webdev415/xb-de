package p000;

/* loaded from: classes.dex */
public final class C0193E8 {

    public final C0167Dj f464a;

    public final int f465b;

    public final int f466c;

    public C0193E8(C0167Dj c0167Dj, int i, int i2) {
        this.f464a = (C0167Dj) AbstractC1177Zi.m5051c(c0167Dj, "Null dependency anInterface.");
        this.f465b = i;
        this.f466c = i2;
    }

    public static String m871a(int i) {
        if (i == 0) {
            return "direct";
        }
        if (i == 1) {
            return "provider";
        }
        if (i == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i);
    }

    public static C0193E8 m872g(Class cls) {
        return new C0193E8(cls, 0, 1);
    }

    public static C0193E8 m873h(C0167Dj c0167Dj) {
        return new C0193E8(c0167Dj, 1, 0);
    }

    public static C0193E8 m874i(Class cls) {
        return new C0193E8(cls, 1, 0);
    }

    public static C0193E8 m875j(Class cls) {
        return new C0193E8(cls, 1, 1);
    }

    public static C0193E8 m876k(Class cls) {
        return new C0193E8(cls, 2, 0);
    }

    public C0167Dj m877b() {
        return this.f464a;
    }

    public boolean m878c() {
        return this.f466c == 2;
    }

    public boolean m879d() {
        return this.f466c == 0;
    }

    public boolean m880e() {
        return this.f465b == 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0193E8)) {
            return false;
        }
        C0193E8 c0193e8 = (C0193E8) obj;
        return this.f464a.equals(c0193e8.f464a) && this.f465b == c0193e8.f465b && this.f466c == c0193e8.f466c;
    }

    public boolean m881f() {
        return this.f465b == 2;
    }

    public int hashCode() {
        return ((((this.f464a.hashCode() ^ 1000003) * 1000003) ^ this.f465b) * 1000003) ^ this.f466c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f464a);
        sb.append(", type=");
        int i = this.f465b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(m871a(this.f466c));
        sb.append("}");
        return sb.toString();
    }

    public C0193E8(Class cls, int i, int i2) {
        this(C0167Dj.m716b(cls), i, i2);
    }
}
