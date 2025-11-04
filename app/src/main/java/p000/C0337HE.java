package p000;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

public final class C0337HE extends AbstractC1675eB implements RandomAccess {

    public static final C0337HE f1035o = new C0337HE(new Object[0], 0, false);

    public Object[] f1036m;

    public int f1037n;

    public C0337HE(Object[] objArr, int i, boolean z) {
        super(z);
        this.f1036m = objArr;
        this.f1037n = i;
    }

    public static C0337HE m1537h() {
        return f1035o;
    }

    @Override
    public final void add(int i, Object obj) {
        int i2;
        m7403d();
        if (i < 0 || i > (i2 = this.f1037n)) {
            throw new IndexOutOfBoundsException(m1539f(i));
        }
        Object[] objArr = this.f1036m;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.f1036m, i, objArr2, i + 1, this.f1037n - i);
            this.f1036m = objArr2;
        }
        this.f1036m[i] = obj;
        this.f1037n++;
        ((AbstractList) this).modCount++;
    }

    @Override
    public final InterfaceC1865iD mo1538e(int i) {
        if (i >= this.f1037n) {
            return new C0337HE(Arrays.copyOf(this.f1036m, i), this.f1037n, true);
        }
        throw new IllegalArgumentException();
    }

    public final String m1539f(int i) {
        return "Index:" + i + ", Size:" + this.f1037n;
    }

    public final void m1540g(int i) {
        if (i < 0 || i >= this.f1037n) {
            throw new IndexOutOfBoundsException(m1539f(i));
        }
    }

    @Override
    public final Object get(int i) {
        m1540g(i);
        return this.f1036m[i];
    }

    @Override
    public final Object remove(int i) {
        m7403d();
        m1540g(i);
        Object[] objArr = this.f1036m;
        Object obj = objArr[i];
        if (i < this.f1037n - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.f1037n--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override
    public final Object set(int i, Object obj) {
        m7403d();
        m1540g(i);
        Object[] objArr = this.f1036m;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override
    public final int size() {
        return this.f1037n;
    }

    @Override
    public final boolean add(Object obj) {
        m7403d();
        int i = this.f1037n;
        Object[] objArr = this.f1036m;
        if (i == objArr.length) {
            this.f1036m = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f1036m;
        int i2 = this.f1037n;
        this.f1037n = i2 + 1;
        objArr2[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
