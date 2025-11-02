package p000;

/* loaded from: classes.dex */
public final class C2497w extends AbstractC1325bi {

    public static final C2497w f7765l = new C2497w();

    public static AbstractC1325bi m10409e() {
        return f7765l;
    }

    @Override
    public Object mo5673b() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override
    public boolean mo5674c() {
        return false;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return 2040732332;
    }

    public String toString() {
        return "Optional.absent()";
    }
}
