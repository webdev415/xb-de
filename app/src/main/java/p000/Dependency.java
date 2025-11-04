package p000;

public final class Dependency {

    public final C0167Dj anInterface;

    public final int type;

    public final int injection;

    public Dependency(C0167Dj c0167Dj, int i, int i2) {
        this.anInterface = (C0167Dj) AbstractC1177Zi.m5051c(c0167Dj, "Null dependency anInterface.");
        this.type = i;
        this.injection = i2;
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

    public static Dependency m872g(Class cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency m873h(C0167Dj c0167Dj) {
        return new Dependency(c0167Dj, 1, 0);
    }

    public static Dependency m874i(Class cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency m875j(Class cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency m876k(Class cls) {
        return new Dependency(cls, 2, 0);
    }

    public C0167Dj m877b() {
        return this.anInterface;
    }

    public boolean m878c() {
        return this.injection == 2;
    }

    public boolean m879d() {
        return this.injection == 0;
    }

    public boolean m880e() {
        return this.type == 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        return this.anInterface.equals(dependency.anInterface) && this.type == dependency.type && this.injection == dependency.injection;
    }

    public boolean m881f() {
        return this.type == 2;
    }

    public int hashCode() {
        return ((((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ this.type) * 1000003) ^ this.injection;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.anInterface);
        sb.append(", type=");
        int i = this.type;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(m871a(this.injection));
        sb.append("}");
        return sb.toString();
    }

    public Dependency(Class cls, int i, int i2) {
        this(C0167Dj.m716b(cls), i, i2);
    }
}
