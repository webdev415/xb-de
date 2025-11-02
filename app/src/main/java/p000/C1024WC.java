package p000;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class C1024WC extends AbstractC1675eB implements InterfaceC1677eD, InterfaceC0245FE, RandomAccess {

    public static final C1024WC f3040o = new C1024WC(new int[0], 0, false);

    public int[] f3041m;

    public int f3042n;

    public C1024WC(int[] iArr, int i, boolean z) {
        super(z);
        this.f3041m = iArr;
        this.f3042n = i;
    }

    public static C1024WC m4468g() {
        return f3040o;
    }

    @Override
    public final void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        m7403d();
        if (i < 0 || i > (i2 = this.f3042n)) {
            throw new IndexOutOfBoundsException(m4471i(i));
        }
        int[] iArr = this.f3041m;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f3041m, i, iArr2, i + 1, this.f3042n - i);
            this.f3041m = iArr2;
        }
        this.f3041m[i] = iIntValue;
        this.f3042n++;
        ((AbstractList) this).modCount++;
    }

    @Override
    public final boolean addAll(Collection collection) {
        m7403d();
        AbstractC0932UC.m4209e(collection);
        if (!(collection instanceof C1024WC)) {
            return super.addAll(collection);
        }
        C1024WC c1024wc = (C1024WC) collection;
        int i = c1024wc.f3042n;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3042n;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.f3041m;
        if (i3 > iArr.length) {
            this.f3041m = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(c1024wc.f3041m, 0, this.f3041m, this.f3042n, c1024wc.f3042n);
        this.f3042n = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1024WC)) {
            return super.equals(obj);
        }
        C1024WC c1024wc = (C1024WC) obj;
        if (this.f3042n != c1024wc.f3042n) {
            return false;
        }
        int[] iArr = c1024wc.f3041m;
        for (int i = 0; i < this.f3042n; i++) {
            if (this.f3041m[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int m4469f(int i) {
        m4472k(i);
        return this.f3041m[i];
    }

    @Override
    public final Object get(int i) {
        return Integer.valueOf(m4469f(i));
    }

    public final void m4470h(int i) {
        m7403d();
        int i2 = this.f3042n;
        int[] iArr = this.f3041m;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f3041m = iArr2;
        }
        int[] iArr3 = this.f3041m;
        int i3 = this.f3042n;
        this.f3042n = i3 + 1;
        iArr3[i3] = i;
    }

    @Override
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3042n; i2++) {
            i = (i * 31) + this.f3041m[i2];
        }
        return i;
    }

    public final String m4471i(int i) {
        return "Index:" + i + ", Size:" + this.f3042n;
    }

    @Override
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f3041m[i] == iIntValue) {
                return i;
            }
        }
        return -1;
    }

    public final void m4472k(int i) {
        if (i < 0 || i >= this.f3042n) {
            throw new IndexOutOfBoundsException(m4471i(i));
        }
    }

    @Override
    public final InterfaceC1677eD mo1538e(int i) {
        if (i >= this.f3042n) {
            return new C1024WC(Arrays.copyOf(this.f3041m, i), this.f3042n, true);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public final Object remove(int i) {
        m7403d();
        m4472k(i);
        int[] iArr = this.f3041m;
        int i2 = iArr[i];
        if (i < this.f3042n - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f3042n--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override
    public final void removeRange(int i, int i2) {
        m7403d();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f3041m;
        System.arraycopy(iArr, i2, iArr, i, this.f3042n - i2);
        this.f3042n -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override
    public final Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        m7403d();
        m4472k(i);
        int[] iArr = this.f3041m;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override
    public final int size() {
        return this.f3042n;
    }

    @Override
    public final boolean add(Object obj) {
        m4470h(((Integer) obj).intValue());
        return true;
    }
}
