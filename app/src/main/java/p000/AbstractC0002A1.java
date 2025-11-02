package p000;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class AbstractC0002A1 extends AbstractC2637z1 {
    public static final boolean m4k(Object[] objArr, Object obj) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        return m9p(objArr, obj) >= 0;
    }

    public static final List m5l(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        return (List) m6m(objArr, new ArrayList<>());
    }

    public static final Collection m6m(Object[] objArr, Collection collection) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        AbstractC0116Ce.m476e(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static C2659ze m7n(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        return new C2659ze(0, m8o(objArr));
    }

    public static int m8o(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        return objArr.length - 1;
    }

    public static final int m9p(Object[] objArr, Object obj) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (AbstractC0116Ce.m472a(obj, objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static char m10q(char[] cArr) {
        AbstractC0116Ce.m476e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object m11r(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static List m12s(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? m13t(objArr) : AbstractC1763g5.m7692b(objArr[0]) : AbstractC1810h5.m7783f();
    }

    public static List m13t(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        return new ArrayList<>(AbstractC1810h5.m7780c(objArr));
    }
}
