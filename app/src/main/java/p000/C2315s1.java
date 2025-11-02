package p000;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class C2315s1 extends AbstractC0322H {

    public static final a f6993o = new a(null);

    public static final Object[] f6994p = new Object[0];

    public int f6995l;

    public Object[] f6996m = f6994p;

    public int f6997n;

    public static final class a {
        public a() {
        }

        public final int m9469a(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            return i3 - 2147483639 > 0 ? i2 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i3;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    @Override
    public void add(int i, Object obj) {
        AbstractC0184E.f444l.m835b(i, size());
        if (i == size()) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        m9464k(size() + 1);
        int iM9467q = m9467q(this.f6995l + i);
        if (i < ((size() + 1) >> 1)) {
            int iM9463i = m9463i(iM9467q);
            int iM9463i2 = m9463i(this.f6995l);
            int i2 = this.f6995l;
            if (iM9463i >= i2) {
                Object[] objArr = this.f6996m;
                objArr[iM9463i2] = objArr[i2];
                AbstractC2637z1.m10983e(objArr, objArr, i2, i2 + 1, iM9463i + 1);
            } else {
                Object[] objArr2 = this.f6996m;
                AbstractC2637z1.m10983e(objArr2, objArr2, i2 - 1, i2, objArr2.length);
                Object[] objArr3 = this.f6996m;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC2637z1.m10983e(objArr3, objArr3, 0, 1, iM9463i + 1);
            }
            this.f6996m[iM9463i] = obj;
            this.f6995l = iM9463i2;
        } else {
            int iM9467q2 = m9467q(this.f6995l + size());
            Object[] objArr4 = this.f6996m;
            if (iM9467q < iM9467q2) {
                AbstractC2637z1.m10983e(objArr4, objArr4, iM9467q + 1, iM9467q, iM9467q2);
            } else {
                AbstractC2637z1.m10983e(objArr4, objArr4, 1, 0, iM9467q2);
                Object[] objArr5 = this.f6996m;
                objArr5[0] = objArr5[objArr5.length - 1];
                AbstractC2637z1.m10983e(objArr5, objArr5, iM9467q + 1, iM9467q, objArr5.length - 1);
            }
            this.f6996m[iM9467q] = obj;
        }
        this.f6997n = size() + 1;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        AbstractC0116Ce.m476e(collection, "elements");
        AbstractC0184E.f444l.m835b(i, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(collection);
        }
        m9464k(size() + collection.size());
        int iM9467q = m9467q(this.f6995l + size());
        int iM9467q2 = m9467q(this.f6995l + i);
        int size = collection.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.f6995l;
            int length = i2 - size;
            if (iM9467q2 < i2) {
                Object[] objArr = this.f6996m;
                AbstractC2637z1.m10983e(objArr, objArr, length, i2, objArr.length);
                Object[] objArr2 = this.f6996m;
                if (size >= iM9467q2) {
                    AbstractC2637z1.m10983e(objArr2, objArr2, objArr2.length - size, 0, iM9467q2);
                } else {
                    AbstractC2637z1.m10983e(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f6996m;
                    AbstractC2637z1.m10983e(objArr3, objArr3, 0, size, iM9467q2);
                }
            } else if (length >= 0) {
                Object[] objArr4 = this.f6996m;
                AbstractC2637z1.m10983e(objArr4, objArr4, length, i2, iM9467q2);
            } else {
                Object[] objArr5 = this.f6996m;
                length += objArr5.length;
                int i3 = iM9467q2 - i2;
                int length2 = objArr5.length - length;
                if (length2 >= i3) {
                    AbstractC2637z1.m10983e(objArr5, objArr5, length, i2, iM9467q2);
                } else {
                    AbstractC2637z1.m10983e(objArr5, objArr5, length, i2, i2 + length2);
                    Object[] objArr6 = this.f6996m;
                    AbstractC2637z1.m10983e(objArr6, objArr6, 0, this.f6995l + length2, iM9467q2);
                }
            }
            this.f6995l = length;
            m9461g(m9466p(iM9467q2 - size), collection);
        } else {
            int length3 = iM9467q2 + size;
            if (iM9467q2 < iM9467q) {
                int i4 = size + iM9467q;
                Object[] objArr7 = this.f6996m;
                if (i4 <= objArr7.length) {
                    AbstractC2637z1.m10983e(objArr7, objArr7, length3, iM9467q2, iM9467q);
                } else if (length3 >= objArr7.length) {
                    length3 -= objArr7.length;
                    AbstractC2637z1.m10983e(objArr7, objArr7, length3, iM9467q2, iM9467q);
                } else {
                    int length4 = iM9467q - (i4 - objArr7.length);
                    AbstractC2637z1.m10983e(objArr7, objArr7, 0, length4, iM9467q);
                    Object[] objArr8 = this.f6996m;
                    AbstractC2637z1.m10983e(objArr8, objArr8, length3, iM9467q2, length4);
                }
            } else {
                Object[] objArr9 = this.f6996m;
                AbstractC2637z1.m10983e(objArr9, objArr9, size, 0, iM9467q);
                Object[] objArr10 = this.f6996m;
                if (length3 >= objArr10.length) {
                    AbstractC2637z1.m10983e(objArr10, objArr10, length3 - objArr10.length, iM9467q2, objArr10.length);
                } else {
                    AbstractC2637z1.m10983e(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f6996m;
                    AbstractC2637z1.m10983e(objArr11, objArr11, length3, iM9467q2, objArr11.length - size);
                }
            }
            m9461g(iM9467q2, collection);
        }
        return true;
    }

    public final void addFirst(Object obj) {
        m9464k(size() + 1);
        int iM9463i = m9463i(this.f6995l);
        this.f6995l = iM9463i;
        this.f6996m[iM9463i] = obj;
        this.f6997n = size() + 1;
    }

    public final void addLast(Object obj) {
        m9464k(size() + 1);
        this.f6996m[m9467q(this.f6995l + size())] = obj;
        this.f6997n = size() + 1;
    }

    @Override
    public void clear() {
        int iM9467q = m9467q(this.f6995l + size());
        int i = this.f6995l;
        if (i < iM9467q) {
            AbstractC2637z1.m10987i(this.f6996m, null, i, iM9467q);
        } else if (!isEmpty()) {
            Object[] objArr = this.f6996m;
            AbstractC2637z1.m10987i(objArr, null, this.f6995l, objArr.length);
            AbstractC2637z1.m10987i(this.f6996m, null, 0, iM9467q);
        }
        this.f6995l = 0;
        this.f6997n = 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public int mo1462d() {
        return this.f6997n;
    }

    @Override
    public Object mo1463f(int i) {
        AbstractC0184E.f444l.m834a(i, size());
        if (i == AbstractC1810h5.m7784g(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        int iM9467q = m9467q(this.f6995l + i);
        Object obj = this.f6996m[iM9467q];
        if (i < (size() >> 1)) {
            int i2 = this.f6995l;
            if (iM9467q >= i2) {
                Object[] objArr = this.f6996m;
                AbstractC2637z1.m10983e(objArr, objArr, i2 + 1, i2, iM9467q);
            } else {
                Object[] objArr2 = this.f6996m;
                AbstractC2637z1.m10983e(objArr2, objArr2, 1, 0, iM9467q);
                Object[] objArr3 = this.f6996m;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i3 = this.f6995l;
                AbstractC2637z1.m10983e(objArr3, objArr3, i3 + 1, i3, objArr3.length - 1);
            }
            Object[] objArr4 = this.f6996m;
            int i4 = this.f6995l;
            objArr4[i4] = null;
            this.f6995l = m9465o(i4);
        } else {
            int iM9467q2 = m9467q(this.f6995l + AbstractC1810h5.m7784g(this));
            Object[] objArr5 = this.f6996m;
            if (iM9467q <= iM9467q2) {
                AbstractC2637z1.m10983e(objArr5, objArr5, iM9467q, iM9467q + 1, iM9467q2 + 1);
            } else {
                AbstractC2637z1.m10983e(objArr5, objArr5, iM9467q, iM9467q + 1, objArr5.length);
                Object[] objArr6 = this.f6996m;
                objArr6[objArr6.length - 1] = objArr6[0];
                AbstractC2637z1.m10983e(objArr6, objArr6, 0, 1, iM9467q2 + 1);
            }
            this.f6996m[iM9467q2] = null;
        }
        this.f6997n = size() - 1;
        return obj;
    }

    public final void m9461g(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f6996m.length;
        while (i < length && it.hasNext()) {
            this.f6996m[i] = it.next();
            i++;
        }
        int i2 = this.f6995l;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.f6996m[i3] = it.next();
        }
        this.f6997n = size() + collection.size();
    }

    @Override
    public Object get(int i) {
        AbstractC0184E.f444l.m834a(i, size());
        return this.f6996m[m9467q(this.f6995l + i)];
    }

    public final void m9462h(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.f6996m;
        AbstractC2637z1.m10983e(objArr2, objArr, 0, this.f6995l, objArr2.length);
        Object[] objArr3 = this.f6996m;
        int length = objArr3.length;
        int i2 = this.f6995l;
        AbstractC2637z1.m10983e(objArr3, objArr, length - i2, 0, i2);
        this.f6995l = 0;
        this.f6996m = objArr;
    }

    public final int m9463i(int i) {
        return i == 0 ? AbstractC0002A1.m8o(this.f6996m) : i - 1;
    }

    @Override
    public int indexOf(Object obj) {
        int iM9467q = m9467q(this.f6995l + size());
        int length = this.f6995l;
        if (length < iM9467q) {
            while (length < iM9467q) {
                if (!AbstractC0116Ce.m472a(obj, this.f6996m[length])) {
                    length++;
                }
            }
            return -1;
        }
        if (length < iM9467q) {
            return -1;
        }
        int length2 = this.f6996m.length;
        while (true) {
            if (length >= length2) {
                for (int i = 0; i < iM9467q; i++) {
                    if (AbstractC0116Ce.m472a(obj, this.f6996m[i])) {
                        length = i + this.f6996m.length;
                    }
                }
                return -1;
            }
            if (AbstractC0116Ce.m472a(obj, this.f6996m[length])) {
                break;
            }
            length++;
        }
        return length - this.f6995l;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public final void m9464k(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f6996m;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == f6994p) {
            this.f6996m = new Object[AbstractC1132Yj.m4981b(i, 10)];
        } else {
            m9462h(f6993o.m9469a(objArr.length, i));
        }
    }

    @Override
    public int lastIndexOf(Object obj) {
        int iM8o;
        int iM9467q = m9467q(this.f6995l + size());
        int i = this.f6995l;
        if (i < iM9467q) {
            iM8o = iM9467q - 1;
            if (i <= iM8o) {
                while (!AbstractC0116Ce.m472a(obj, this.f6996m[iM8o])) {
                    if (iM8o != i) {
                        iM8o--;
                    }
                }
                return iM8o - this.f6995l;
            }
            return -1;
        }
        if (i > iM9467q) {
            int i2 = iM9467q - 1;
            while (true) {
                if (-1 >= i2) {
                    iM8o = AbstractC0002A1.m8o(this.f6996m);
                    int i3 = this.f6995l;
                    if (i3 <= iM8o) {
                        while (!AbstractC0116Ce.m472a(obj, this.f6996m[iM8o])) {
                            if (iM8o != i3) {
                                iM8o--;
                            }
                        }
                    }
                } else {
                    if (AbstractC0116Ce.m472a(obj, this.f6996m[i2])) {
                        iM8o = i2 + this.f6996m.length;
                        break;
                    }
                    i2--;
                }
            }
        }
        return -1;
    }

    public final int m9465o(int i) {
        if (i == AbstractC0002A1.m8o(this.f6996m)) {
            return 0;
        }
        return i + 1;
    }

    public final int m9466p(int i) {
        return i < 0 ? i + this.f6996m.length : i;
    }

    public final int m9467q(int i) {
        Object[] objArr = this.f6996m;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final Object m9468r() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        int iM9467q;
        AbstractC0116Ce.m476e(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f6996m.length != 0) {
            int iM9467q2 = m9467q(this.f6995l + size());
            int i = this.f6995l;
            if (i < iM9467q2) {
                iM9467q = i;
                while (i < iM9467q2) {
                    Object obj = this.f6996m[i];
                    if (!collection.contains(obj)) {
                        this.f6996m[iM9467q] = obj;
                        iM9467q++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                AbstractC2637z1.m10987i(this.f6996m, null, iM9467q, iM9467q2);
            } else {
                int length = this.f6996m.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.f6996m;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (!collection.contains(obj2)) {
                        this.f6996m[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iM9467q = m9467q(i2);
                for (int i3 = 0; i3 < iM9467q2; i3++) {
                    Object[] objArr2 = this.f6996m;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (!collection.contains(obj3)) {
                        this.f6996m[iM9467q] = obj3;
                        iM9467q = m9465o(iM9467q);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                this.f6997n = m9466p(iM9467q - this.f6995l);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f6996m;
        int i = this.f6995l;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f6995l = m9465o(i);
        this.f6997n = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iM9467q = m9467q(this.f6995l + AbstractC1810h5.m7784g(this));
        Object[] objArr = this.f6996m;
        Object obj = objArr[iM9467q];
        objArr[iM9467q] = null;
        this.f6997n = size() - 1;
        return obj;
    }

    @Override
    public boolean retainAll(Collection collection) {
        int iM9467q;
        AbstractC0116Ce.m476e(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f6996m.length != 0) {
            int iM9467q2 = m9467q(this.f6995l + size());
            int i = this.f6995l;
            if (i < iM9467q2) {
                iM9467q = i;
                while (i < iM9467q2) {
                    Object obj = this.f6996m[i];
                    if (collection.contains(obj)) {
                        this.f6996m[iM9467q] = obj;
                        iM9467q++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                AbstractC2637z1.m10987i(this.f6996m, null, iM9467q, iM9467q2);
            } else {
                int length = this.f6996m.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.f6996m;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.f6996m[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iM9467q = m9467q(i2);
                for (int i3 = 0; i3 < iM9467q2; i3++) {
                    Object[] objArr2 = this.f6996m;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        this.f6996m[iM9467q] = obj3;
                        iM9467q = m9465o(iM9467q);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                this.f6997n = m9466p(iM9467q - this.f6995l);
            }
        }
        return z;
    }

    @Override
    public Object set(int i, Object obj) {
        AbstractC0184E.f444l.m834a(i, size());
        int iM9467q = m9467q(this.f6995l + i);
        Object[] objArr = this.f6996m;
        Object obj2 = objArr[iM9467q];
        objArr[iM9467q] = obj;
        return obj2;
    }

    @Override
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        AbstractC0116Ce.m476e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        m9464k(size() + collection.size());
        m9461g(m9467q(this.f6995l + size()), collection);
        return true;
    }

    @Override
    public Object[] toArray(Object[] objArr) throws NegativeArraySizeException {
        AbstractC0116Ce.m476e(objArr, "array");
        if (objArr.length < size()) {
            objArr = AbstractC2545x1.m10624a(objArr, size());
        }
        int iM9467q = m9467q(this.f6995l + size());
        int i = this.f6995l;
        if (i < iM9467q) {
            AbstractC2637z1.m10985g(this.f6996m, objArr, 0, i, iM9467q, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f6996m;
            AbstractC2637z1.m10983e(objArr2, objArr, 0, this.f6995l, objArr2.length);
            Object[] objArr3 = this.f6996m;
            AbstractC2637z1.m10983e(objArr3, objArr, objArr3.length - this.f6995l, 0, iM9467q);
        }
        if (objArr.length > size()) {
            objArr[size()] = null;
        }
        return objArr;
    }
}
