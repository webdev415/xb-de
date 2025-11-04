package p000;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class C2649zD extends AbstractC1675eB implements InterfaceC1356cD, InterfaceC0245FE, RandomAccess {

    public static final C2649zD f8235o = new C2649zD(new long[0], 0, false);

    public long[] f8236m;

    public int f8237n;

    public C2649zD(long[] jArr, int i, boolean z) {
        super(z);
        this.f8236m = jArr;
        this.f8237n = i;
    }

    public static C2649zD m10994h() {
        return f8235o;
    }

    @Override
    public final void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        m7403d();
        if (i < 0 || i > (i2 = this.f8237n)) {
            throw new IndexOutOfBoundsException(m10996g(i));
        }
        long[] jArr = this.f8236m;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f8236m, i, jArr2, i + 1, this.f8237n - i);
            this.f8236m = jArr2;
        }
        this.f8236m[i] = jLongValue;
        this.f8237n++;
        ((AbstractList) this).modCount++;
    }

    @Override
    public final boolean addAll(Collection collection) {
        m7403d();
        AbstractC0932UC.m4209e(collection);
        if (!(collection instanceof C2649zD)) {
            return super.addAll(collection);
        }
        C2649zD c2649zD = (C2649zD) collection;
        int i = c2649zD.f8237n;
        if (i == 0) {
            return false;
        }
        int i2 = this.f8237n;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.f8236m;
        if (i3 > jArr.length) {
            this.f8236m = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(c2649zD.f8236m, 0, this.f8236m, this.f8237n, c2649zD.f8237n);
        this.f8237n = i3;
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
        if (!(obj instanceof C2649zD)) {
            return super.equals(obj);
        }
        C2649zD c2649zD = (C2649zD) obj;
        if (this.f8237n != c2649zD.f8237n) {
            return false;
        }
        long[] jArr = c2649zD.f8236m;
        for (int i = 0; i < this.f8237n; i++) {
            if (this.f8236m[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void m10995f(long j) {
        m7403d();
        int i = this.f8237n;
        long[] jArr = this.f8236m;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f8236m = jArr2;
        }
        long[] jArr3 = this.f8236m;
        int i2 = this.f8237n;
        this.f8237n = i2 + 1;
        jArr3[i2] = j;
    }

    public final String m10996g(int i) {
        return "Index:" + i + ", Size:" + this.f8237n;
    }

    @Override
    public final Object get(int i) {
        return Long.valueOf(mo5850j(i));
    }

    @Override
    public final int hashCode() {
        int iM4206b = 1;
        for (int i = 0; i < this.f8237n; i++) {
            iM4206b = (iM4206b * 31) + AbstractC0932UC.m4206b(this.f8236m[i]);
        }
        return iM4206b;
    }

    public final void m10997i(int i) {
        if (i < 0 || i >= this.f8237n) {
            throw new IndexOutOfBoundsException(m10996g(i));
        }
    }

    @Override
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f8236m[i] == jLongValue) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public final long mo5850j(int i) {
        m10997i(i);
        return this.f8236m[i];
    }

    @Override
    public final InterfaceC1356cD mo1538e(int i) {
        if (i >= this.f8237n) {
            return new C2649zD(Arrays.copyOf(this.f8236m, i), this.f8237n, true);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public final Object remove(int i) {
        m7403d();
        m10997i(i);
        long[] jArr = this.f8236m;
        long j = jArr[i];
        if (i < this.f8237n - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f8237n--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override
    public final void removeRange(int i, int i2) {
        m7403d();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f8236m;
        System.arraycopy(jArr, i2, jArr, i, this.f8237n - i2);
        this.f8237n -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override
    public final Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        m7403d();
        m10997i(i);
        long[] jArr = this.f8236m;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override
    public final int size() {
        return this.f8237n;
    }

    @Override
    public final boolean add(Object obj) {
        m10995f(((Long) obj).longValue());
        return true;
    }
}
