package p000;

/* loaded from: classes.dex */
public final class C1088Xl extends AbstractC1220ae {

    public final transient Object f3260n;

    public C1088Xl(Object obj) {
        this.f3260n = AbstractC1131Yi.m4973i(obj);
    }

    @Override
    public boolean contains(Object obj) {
        return this.f3260n.equals(obj);
    }

    @Override
    public int mo4493d(Object[] objArr, int i) {
        objArr[i] = this.f3260n;
        return i + 1;
    }

    @Override
    public final int hashCode() {
        return this.f3260n.hashCode();
    }

    @Override
    public boolean mo4497i() {
        return false;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String toString() {
        String string = this.f3260n.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2);
        sb.append('[');
        sb.append(string);
        sb.append(']');
        return sb.toString();
    }

    @Override
    public AbstractC2209po iterator() {
        return AbstractC0622Ne.m3320c(this.f3260n);
    }
}
