package p000;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class C2499w1 implements Collection, Set {

    public static final int[] f7777p = new int[0];

    public static final Object[] f7778q = new Object[0];

    public static Object[] f7779r;

    public static int f7780s;

    public static Object[] f7781t;

    public static int f7782u;

    public int[] f7783l;

    public Object[] f7784m;

    public int f7785n;

    public AbstractC2108ng f7786o;

    public class a extends AbstractC2108ng {
        public a() {
        }

        @Override
        public void mo8770a() {
            C2499w1.this.clear();
        }

        @Override
        public Object mo8771b(int i, int i2) {
            return C2499w1.this.f7784m[i];
        }

        @Override
        public Map mo8772c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override
        public int mo8773d() {
            return C2499w1.this.f7785n;
        }

        @Override
        public int mo8774e(Object obj) {
            return C2499w1.this.indexOf(obj);
        }

        @Override
        public int mo8775f(Object obj) {
            return C2499w1.this.indexOf(obj);
        }

        @Override
        public void mo8776g(Object obj, Object obj2) {
            C2499w1.this.add(obj);
        }

        @Override
        public void mo8777h(int i) {
            C2499w1.this.m10428o(i);
        }

        @Override
        public Object mo8778i(int i, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public C2499w1() {
        this(0);
    }

    public static void m10422g(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C2499w1.class) {
                try {
                    if (f7782u < 10) {
                        objArr[0] = f7781t;
                        objArr[1] = iArr;
                        for (int i2 = i - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        f7781t = objArr;
                        f7782u++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C2499w1.class) {
                try {
                    if (f7780s < 10) {
                        objArr[0] = f7779r;
                        objArr[1] = iArr;
                        for (int i3 = i - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f7779r = objArr;
                        f7780s++;
                    }
                } finally {
                }
            }
        }
    }

    @Override
    public boolean add(Object obj) {
        int i;
        int iM10426i;
        if (obj == null) {
            iM10426i = m10427k();
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iM10426i = m10426i(obj, iHashCode);
        }
        if (iM10426i >= 0) {
            return false;
        }
        int i2 = ~iM10426i;
        int i3 = this.f7785n;
        int[] iArr = this.f7783l;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.f7784m;
            m10423d(i4);
            int[] iArr2 = this.f7783l;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f7784m, 0, objArr.length);
            }
            m10422g(iArr, objArr, this.f7785n);
        }
        int i5 = this.f7785n;
        if (i2 < i5) {
            int[] iArr3 = this.f7783l;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.f7784m;
            System.arraycopy(objArr2, i2, objArr2, i6, this.f7785n - i2);
        }
        this.f7783l[i2] = i;
        this.f7784m[i2] = obj;
        this.f7785n++;
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        m10424f(this.f7785n + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override
    public void clear() {
        int i = this.f7785n;
        if (i != 0) {
            m10422g(this.f7783l, this.f7784m, i);
            this.f7783l = f7777p;
            this.f7784m = f7778q;
            this.f7785n = 0;
        }
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void m10423d(int i) {
        if (i == 8) {
            synchronized (C2499w1.class) {
                try {
                    Object[] objArr = f7781t;
                    if (objArr != null) {
                        this.f7784m = objArr;
                        f7781t = (Object[]) objArr[0];
                        this.f7783l = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f7782u--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (C2499w1.class) {
                try {
                    Object[] objArr2 = f7779r;
                    if (objArr2 != null) {
                        this.f7784m = objArr2;
                        f7779r = (Object[]) objArr2[0];
                        this.f7783l = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f7780s--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f7783l = new int[i];
        this.f7784m = new Object[i];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.f7785n; i++) {
                try {
                    if (!set.contains(m10429p(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void m10424f(int i) {
        int[] iArr = this.f7783l;
        if (iArr.length < i) {
            Object[] objArr = this.f7784m;
            m10423d(i);
            int i2 = this.f7785n;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f7783l, 0, i2);
                System.arraycopy(objArr, 0, this.f7784m, 0, this.f7785n);
            }
            m10422g(iArr, objArr, this.f7785n);
        }
    }

    public final AbstractC2108ng m10425h() {
        if (this.f7786o == null) {
            this.f7786o = new a();
        }
        return this.f7786o;
    }

    @Override
    public int hashCode() {
        int[] iArr = this.f7783l;
        int i = this.f7785n;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public final int m10426i(Object obj, int i) {
        int i2 = this.f7785n;
        if (i2 == 0) {
            return -1;
        }
        int iM9032a = AbstractC2182p6.m9032a(this.f7783l, i2, i);
        if (iM9032a < 0 || obj.equals(this.f7784m[iM9032a])) {
            return iM9032a;
        }
        int i3 = iM9032a + 1;
        while (i3 < i2 && this.f7783l[i3] == i) {
            if (obj.equals(this.f7784m[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iM9032a - 1; i4 >= 0 && this.f7783l[i4] == i; i4--) {
            if (obj.equals(this.f7784m[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? m10427k() : m10426i(obj, obj.hashCode());
    }

    @Override
    public boolean isEmpty() {
        return this.f7785n <= 0;
    }

    @Override
    public Iterator iterator() {
        return m10425h().m8780m().iterator();
    }

    public final int m10427k() {
        int i = this.f7785n;
        if (i == 0) {
            return -1;
        }
        int iM9032a = AbstractC2182p6.m9032a(this.f7783l, i, 0);
        if (iM9032a < 0 || this.f7784m[iM9032a] == null) {
            return iM9032a;
        }
        int i2 = iM9032a + 1;
        while (i2 < i && this.f7783l[i2] == 0) {
            if (this.f7784m[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iM9032a - 1; i3 >= 0 && this.f7783l[i3] == 0; i3--) {
            if (this.f7784m[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public Object m10428o(int i) {
        Object[] objArr = this.f7784m;
        Object obj = objArr[i];
        int i2 = this.f7785n;
        if (i2 <= 1) {
            m10422g(this.f7783l, objArr, i2);
            this.f7783l = f7777p;
            this.f7784m = f7778q;
            this.f7785n = 0;
        } else {
            int[] iArr = this.f7783l;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i3 = i2 - 1;
                this.f7785n = i3;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, iArr, i, i3 - i);
                    Object[] objArr2 = this.f7784m;
                    System.arraycopy(objArr2, i4, objArr2, i, this.f7785n - i);
                }
                this.f7784m[this.f7785n] = null;
            } else {
                m10423d(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.f7785n--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f7783l, 0, i);
                    System.arraycopy(objArr, 0, this.f7784m, 0, i);
                }
                int i5 = this.f7785n;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, this.f7783l, i, i5 - i);
                    System.arraycopy(objArr, i6, this.f7784m, i, this.f7785n - i);
                }
            }
        }
        return obj;
    }

    public Object m10429p(int i) {
        return this.f7784m[i];
    }

    @Override
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        m10428o(iIndexOf);
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override
    public boolean retainAll(Collection collection) {
        boolean z = false;
        for (int i = this.f7785n - 1; i >= 0; i--) {
            if (!collection.contains(this.f7784m[i])) {
                m10428o(i);
                z = true;
            }
        }
        return z;
    }

    @Override
    public int size() {
        return this.f7785n;
    }

    @Override
    public Object[] toArray() {
        int i = this.f7785n;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f7784m, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f7785n * 14);
        sb.append('{');
        for (int i = 0; i < this.f7785n; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object objM10429p = m10429p(i);
            if (objM10429p != this) {
                sb.append(objM10429p);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C2499w1(int i) {
        if (i == 0) {
            this.f7783l = f7777p;
            this.f7784m = f7778q;
        } else {
            m10423d(i);
        }
        this.f7785n = 0;
    }

    @Override
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f7785n) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f7785n);
        }
        System.arraycopy(this.f7784m, 0, objArr, 0, this.f7785n);
        int length = objArr.length;
        int i = this.f7785n;
        if (length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
