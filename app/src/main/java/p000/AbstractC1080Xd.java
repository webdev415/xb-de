package p000;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class AbstractC1080Xd extends AbstractC1034Wd implements List, RandomAccess {

    public static final AbstractC2255qo f3230m = new a(C2435uk.f7562p, 0);

    public static class a extends AbstractC0092C {

        public final AbstractC1080Xd f3231n;

        public a(AbstractC1080Xd abstractC1080Xd, int i) {
            super(abstractC1080Xd.size(), i);
            this.f3231n = abstractC1080Xd;
        }

        @Override
        public Object mo363b(int i) {
            return this.f3231n.get(i);
        }
    }

    public static class b extends AbstractC1080Xd {

        public final transient AbstractC1080Xd f3232n;

        public b(AbstractC1080Xd abstractC1080Xd) {
            this.f3232n = abstractC1080Xd;
        }

        @Override
        public boolean contains(Object obj) {
            return this.f3232n.contains(obj);
        }

        @Override
        public Object get(int i) {
            AbstractC1131Yi.m4971g(i, size());
            return this.f3232n.get(m4766x(i));
        }

        @Override
        public boolean mo4497i() {
            return this.f3232n.mo4497i();
        }

        @Override
        public int indexOf(Object obj) {
            int iLastIndexOf = this.f3232n.lastIndexOf(obj);
            if (iLastIndexOf >= 0) {
                return m4766x(iLastIndexOf);
            }
            return -1;
        }

        @Override
        public /* bridge */ Iterator iterator() {
            return super.iterator();
        }

        @Override
        public int lastIndexOf(Object obj) {
            int iIndexOf = this.f3232n.indexOf(obj);
            if (iIndexOf >= 0) {
                return m4766x(iIndexOf);
            }
            return -1;
        }

        @Override
        public /* bridge */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override
        public int size() {
            return this.f3232n.size();
        }

        @Override
        public AbstractC1080Xd mo4763t() {
            return this.f3232n;
        }

        @Override
        public AbstractC1080Xd subList(int i, int i2) {
            AbstractC1131Yi.m4977m(i, i2, size());
            return this.f3232n.subList(m4767y(i2), m4767y(i)).mo4763t();
        }

        public final int m4766x(int i) {
            return (size() - 1) - i;
        }

        public final int m4767y(int i) {
            return size() - i;
        }

        @Override
        public /* bridge */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }
    }

    public class c extends AbstractC1080Xd {

        public final transient int f3233n;

        public final transient int f3234o;

        public c(int i, int i2) {
            this.f3233n = i;
            this.f3234o = i2;
        }

        @Override
        public Object[] mo4494f() {
            return AbstractC1080Xd.this.mo4494f();
        }

        @Override
        public int mo4495g() {
            return AbstractC1080Xd.this.mo4496h() + this.f3233n + this.f3234o;
        }

        @Override
        public Object get(int i) {
            AbstractC1131Yi.m4971g(i, this.f3234o);
            return AbstractC1080Xd.this.get(i + this.f3233n);
        }

        @Override
        public int mo4496h() {
            return AbstractC1080Xd.this.mo4496h() + this.f3233n;
        }

        @Override
        public boolean mo4497i() {
            return true;
        }

        @Override
        public /* bridge */ Iterator iterator() {
            return super.iterator();
        }

        @Override
        public /* bridge */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override
        public int size() {
            return this.f3234o;
        }

        @Override
        public AbstractC1080Xd subList(int i, int i2) {
            AbstractC1131Yi.m4977m(i, i2, this.f3234o);
            AbstractC1080Xd abstractC1080Xd = AbstractC1080Xd.this;
            int i3 = this.f3233n;
            return abstractC1080Xd.subList(i + i3, i2 + i3);
        }

        @Override
        public /* bridge */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }
    }

    public static AbstractC1080Xd m4756k(Object[] objArr) {
        return m4757o(objArr, objArr.length);
    }

    public static AbstractC1080Xd m4757o(Object[] objArr, int i) {
        return i == 0 ? m4758s() : new C2435uk(objArr, i);
    }

    public static AbstractC1080Xd m4758s() {
        return C2435uk.f7562p;
    }

    public static AbstractC1080Xd m4759u(Comparator comparator, Iterable iterable) {
        AbstractC1131Yi.m4973i(comparator);
        Object[] objArrM2866b = AbstractC0576Me.m2866b(iterable);
        AbstractC0165Dh.m710b(objArrM2866b);
        Arrays.sort(objArrM2866b, comparator);
        return m4756k(objArrM2866b);
    }

    @Override
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override
    public int mo4493d(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override
    public boolean equals(Object obj) {
        return AbstractC0898Tf.m4153a(this, obj);
    }

    @Override
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return AbstractC0898Tf.m4154b(this, obj);
    }

    @Override
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return AbstractC0898Tf.m4156d(this, obj);
    }

    @Override
    public AbstractC2209po iterator() {
        return listIterator();
    }

    @Override
    public AbstractC2255qo listIterator() {
        return listIterator(0);
    }

    @Override
    public AbstractC2255qo listIterator(int i) {
        AbstractC1131Yi.m4975k(i, size());
        return isEmpty() ? f3230m : new a(this, i);
    }

    @Override
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public AbstractC1080Xd mo4763t() {
        return size() <= 1 ? this : new b(this);
    }

    @Override
    public AbstractC1080Xd subList(int i, int i2) {
        AbstractC1131Yi.m4977m(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? m4758s() : m4765w(i, i2);
    }

    public AbstractC1080Xd m4765w(int i, int i2) {
        return new c(i, i2 - i);
    }
}
