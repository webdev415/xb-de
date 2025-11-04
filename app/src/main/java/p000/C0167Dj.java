package p000;

public final class C0167Dj {

    public final Class f414a;

    public final Class f415b;

    public @interface a {
    }

    public C0167Dj(Class cls, Class cls2) {
        this.f414a = cls;
        this.f415b = cls2;
    }

    public static C0167Dj m715a(Class cls, Class cls2) {
        return new C0167Dj(cls, cls2);
    }

    public static C0167Dj m716b(Class cls) {
        return new C0167Dj(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0167Dj.class != obj.getClass()) {
            return false;
        }
        C0167Dj c0167Dj = (C0167Dj) obj;
        if (this.f415b.equals(c0167Dj.f415b)) {
            return this.f414a.equals(c0167Dj.f414a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f415b.hashCode() * 31) + this.f414a.hashCode();
    }

    public String toString() {
        if (this.f414a == a.class) {
            return this.f415b.getName();
        }
        return "@" + this.f414a.getName() + " " + this.f415b.getName();
    }
}
