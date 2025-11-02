package p000;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class C0950Ul {

    public static Object[] f2864o;

    public static int f2865p;

    public static Object[] f2866q;

    public static int f2867r;

    public int[] f2868l;

    public Object[] f2869m;

    public int f2870n;

    public C0950Ul() {
        this.f2868l = AbstractC2182p6.f6629a;
        this.f2869m = AbstractC2182p6.f6631c;
        this.f2870n = 0;
    }

    public static int m4275b(int[] iArr, int i, int i2) {
        try {
            return AbstractC2182p6.m9032a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void m4276d(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0950Ul.class) {
                try {
                    if (f2867r < 10) {
                        objArr[0] = f2866q;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        f2866q = objArr;
                        f2867r++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0950Ul.class) {
                try {
                    if (f2865p < 10) {
                        objArr[0] = f2864o;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f2864o = objArr;
                        f2865p++;
                    }
                } finally {
                }
            }
        }
    }

    public final void m4277a(int i) {
        if (i == 8) {
            synchronized (C0950Ul.class) {
                try {
                    Object[] objArr = f2866q;
                    if (objArr != null) {
                        this.f2869m = objArr;
                        f2866q = (Object[]) objArr[0];
                        this.f2868l = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f2867r--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (C0950Ul.class) {
                try {
                    Object[] objArr2 = f2864o;
                    if (objArr2 != null) {
                        this.f2869m = objArr2;
                        f2864o = (Object[]) objArr2[0];
                        this.f2868l = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f2865p--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f2868l = new int[i];
        this.f2869m = new Object[i << 1];
    }

    public void m4278c(int i) {
        int i2 = this.f2870n;
        int[] iArr = this.f2868l;
        if (iArr.length < i) {
            Object[] objArr = this.f2869m;
            m4277a(i);
            if (this.f2870n > 0) {
                System.arraycopy(iArr, 0, this.f2868l, 0, i2);
                System.arraycopy(objArr, 0, this.f2869m, 0, i2 << 1);
            }
            m4276d(iArr, objArr, i2);
        }
        if (this.f2870n != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.f2870n;
        if (i > 0) {
            int[] iArr = this.f2868l;
            Object[] objArr = this.f2869m;
            this.f2868l = AbstractC2182p6.f6629a;
            this.f2869m = AbstractC2182p6.f6631c;
            this.f2870n = 0;
            m4276d(iArr, objArr, i);
        }
        if (this.f2870n > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m4280f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m4282h(obj) >= 0;
    }

    public int m4279e(Object obj, int i) {
        int i2 = this.f2870n;
        if (i2 == 0) {
            return -1;
        }
        int iM4275b = m4275b(this.f2868l, i2, i);
        if (iM4275b < 0 || obj.equals(this.f2869m[iM4275b << 1])) {
            return iM4275b;
        }
        int i3 = iM4275b + 1;
        while (i3 < i2 && this.f2868l[i3] == i) {
            if (obj.equals(this.f2869m[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iM4275b - 1; i4 >= 0 && this.f2868l[i4] == i; i4--) {
            if (obj.equals(this.f2869m[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0950Ul) {
            C0950Ul c0950Ul = (C0950Ul) obj;
            if (size() != c0950Ul.size()) {
                return false;
            }
            for (int i = 0; i < this.f2870n; i++) {
                try {
                    Object objM4283i = m4283i(i);
                    Object objM4286l = m4286l(i);
                    Object obj2 = c0950Ul.get(objM4283i);
                    if (objM4286l == null) {
                        if (obj2 != null || !c0950Ul.containsKey(objM4283i)) {
                            return false;
                        }
                    } else if (!objM4286l.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f2870n; i2++) {
                try {
                    Object objM4283i2 = m4283i(i2);
                    Object objM4286l2 = m4286l(i2);
                    Object obj3 = map.get(objM4283i2);
                    if (objM4286l2 == null) {
                        if (obj3 != null || !map.containsKey(objM4283i2)) {
                            return false;
                        }
                    } else if (!objM4286l2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int m4280f(Object obj) {
        return obj == null ? m4281g() : m4279e(obj, obj.hashCode());
    }

    public int m4281g() {
        int i = this.f2870n;
        if (i == 0) {
            return -1;
        }
        int iM4275b = m4275b(this.f2868l, i, 0);
        if (iM4275b < 0 || this.f2869m[iM4275b << 1] == null) {
            return iM4275b;
        }
        int i2 = iM4275b + 1;
        while (i2 < i && this.f2868l[i2] == 0) {
            if (this.f2869m[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iM4275b - 1; i3 >= 0 && this.f2868l[i3] == 0; i3--) {
            if (this.f2869m[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iM4280f = m4280f(obj);
        return iM4280f >= 0 ? this.f2869m[(iM4280f << 1) + 1] : obj2;
    }

    public int m4282h(Object obj) {
        int i = this.f2870n * 2;
        Object[] objArr = this.f2869m;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f2868l;
        Object[] objArr = this.f2869m;
        int i = this.f2870n;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public Object m4283i(int i) {
        return this.f2869m[i << 1];
    }

    public boolean isEmpty() {
        return this.f2870n <= 0;
    }

    public Object m4284j(int i) {
        Object[] objArr = this.f2869m;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.f2870n;
        int i4 = 0;
        if (i3 <= 1) {
            m4276d(this.f2868l, objArr, i3);
            this.f2868l = AbstractC2182p6.f6629a;
            this.f2869m = AbstractC2182p6.f6631c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f2868l;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.f2869m;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.f2869m;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                m4277a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.f2870n) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f2868l, 0, i);
                    System.arraycopy(objArr, 0, this.f2869m, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.f2868l, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.f2869m, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.f2870n) {
            throw new ConcurrentModificationException();
        }
        this.f2870n = i4;
        return obj;
    }

    public Object m4285k(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f2869m;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public Object m4286l(int i) {
        return this.f2869m[(i << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i;
        int iM4279e;
        int i2 = this.f2870n;
        if (obj == null) {
            iM4279e = m4281g();
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iM4279e = m4279e(obj, iHashCode);
        }
        if (iM4279e >= 0) {
            int i3 = (iM4279e << 1) + 1;
            Object[] objArr = this.f2869m;
            Object obj3 = objArr[i3];
            objArr[i3] = obj2;
            return obj3;
        }
        int i4 = ~iM4279e;
        int[] iArr = this.f2868l;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.f2869m;
            m4277a(i5);
            if (i2 != this.f2870n) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f2868l;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f2869m, 0, objArr2.length);
            }
            m4276d(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.f2868l;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f2869m;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.f2870n - i4) << 1);
        }
        int i7 = this.f2870n;
        if (i2 == i7) {
            int[] iArr4 = this.f2868l;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f2869m;
                int i8 = i4 << 1;
                objArr4[i8] = obj;
                objArr4[i8 + 1] = obj2;
                this.f2870n = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iM4280f = m4280f(obj);
        if (iM4280f >= 0) {
            return m4284j(iM4280f);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int iM4280f = m4280f(obj);
        if (iM4280f >= 0) {
            return m4285k(iM4280f, obj2);
        }
        return null;
    }

    public int size() {
        return this.f2870n;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2870n * 28);
        sb.append('{');
        for (int i = 0; i < this.f2870n; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object objM4283i = m4283i(i);
            if (objM4283i != this) {
                sb.append(objM4283i);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objM4286l = m4286l(i);
            if (objM4286l != this) {
                sb.append(objM4286l);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C0950Ul(int i) {
        if (i == 0) {
            this.f2868l = AbstractC2182p6.f6629a;
            this.f2869m = AbstractC2182p6.f6631c;
        } else {
            m4277a(i);
        }
        this.f2870n = 0;
    }

    public boolean remove(Object obj, Object obj2) {
        int iM4280f = m4280f(obj);
        if (iM4280f < 0) {
            return false;
        }
        Object objM4286l = m4286l(iM4280f);
        if (obj2 != objM4286l && (obj2 == null || !obj2.equals(objM4286l))) {
            return false;
        }
        m4284j(iM4280f);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iM4280f = m4280f(obj);
        if (iM4280f < 0) {
            return false;
        }
        Object objM4286l = m4286l(iM4280f);
        if (objM4286l != obj2 && (obj2 == null || !obj2.equals(objM4286l))) {
            return false;
        }
        m4285k(iM4280f, obj3);
        return true;
    }
}
