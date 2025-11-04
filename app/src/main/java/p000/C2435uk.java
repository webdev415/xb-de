package p000;

import java.util.Objects;

public class C2435uk extends AbstractC1080Xd {

    public static final AbstractC1080Xd f7562p = new C2435uk(new Object[0], 0);

    public final transient Object[] f7563n;

    public final transient int f7564o;

    public C2435uk(Object[] objArr, int i) {
        this.f7563n = objArr;
        this.f7564o = i;
    }

    @Override
    public int mo4493d(Object[] objArr, int i) {
        System.arraycopy(this.f7563n, 0, objArr, i, this.f7564o);
        return i + this.f7564o;
    }

    @Override
    public Object[] mo4494f() {
        return this.f7563n;
    }

    @Override
    public int mo4495g() {
        return this.f7564o;
    }

    @Override
    public Object get(int i) {
        AbstractC1131Yi.m4971g(i, this.f7564o);
        Object obj = this.f7563n[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override
    public int mo4496h() {
        return 0;
    }

    @Override
    public boolean mo4497i() {
        return false;
    }

    @Override
    public int size() {
        return this.f7564o;
    }
}
