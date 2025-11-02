package p000;

public final class C2527wk extends AbstractC1220ae {

    public static final Object[] f7882s;

    public static final C2527wk f7883t;

    public final transient Object[] f7884n;

    public final transient int f7885o;

    public final transient Object[] f7886p;

    public final transient int f7887q;

    public final transient int f7888r;

    static {
        Object[] objArr = new Object[0];
        f7882s = objArr;
        f7883t = new C2527wk(objArr, 0, objArr, 0, 0);
    }

    public C2527wk(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f7884n = objArr;
        this.f7885o = i;
        this.f7886p = objArr2;
        this.f7887q = i2;
        this.f7888r = i3;
    }

    @Override
    public boolean contains(Object obj) {
        Object[] objArr = this.f7886p;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iM4390c = AbstractC0987Vc.m4390c(obj);
        while (true) {
            int i = iM4390c & this.f7887q;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iM4390c = i + 1;
        }
    }

    @Override
    public int mo4493d(Object[] objArr, int i) {
        System.arraycopy(this.f7884n, 0, objArr, i, this.f7888r);
        return i + this.f7888r;
    }

    @Override
    public Object[] mo4494f() {
        return this.f7884n;
    }

    @Override
    public int mo4495g() {
        return this.f7888r;
    }

    @Override
    public int mo4496h() {
        return 0;
    }

    @Override
    public int hashCode() {
        return this.f7885o;
    }

    @Override
    public boolean mo4497i() {
        return false;
    }

    @Override
    public AbstractC1080Xd mo5261r() {
        return AbstractC1080Xd.m4757o(this.f7884n, this.f7888r);
    }

    @Override
    public boolean mo5262s() {
        return true;
    }

    @Override
    public int size() {
        return this.f7888r;
    }

    @Override
    public AbstractC2209po iterator() {
        return mo5260k().iterator();
    }
}
