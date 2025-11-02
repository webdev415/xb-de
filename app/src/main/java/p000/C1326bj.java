package p000;

/* loaded from: classes.dex */
public final class C1326bj extends AbstractC1325bi {

    public final Object f3877l;

    public C1326bj(Object obj) {
        this.f3877l = obj;
    }

    @Override
    public Object mo5673b() {
        return this.f3877l;
    }

    @Override
    public boolean mo5674c() {
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1326bj) {
            return this.f3877l.equals(((C1326bj) obj).f3877l);
        }
        return false;
    }

    public int hashCode() {
        return this.f3877l.hashCode() + 1502476572;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f3877l);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
