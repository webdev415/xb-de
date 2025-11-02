package p000;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractC1810h5 extends AbstractC1763g5 {
    public static final Collection m7780c(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        return new C2269r1(objArr, false);
    }

    public static final int m7781d(List list, Comparable comparable, int i, int i2) {
        AbstractC0116Ce.m476e(list, "<this>");
        m7789l(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iM10833a = AbstractC2595y5.m10833a((Comparable) list.get(i4), comparable);
            if (iM10833a < 0) {
                i = i4 + 1;
            } else {
                if (iM10833a <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static int m7782e(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return m7781d(list, comparable, i, i2);
    }

    public static List m7783f() {
        return C0746Q9.f2208l;
    }

    public static int m7784g(List list) {
        AbstractC0116Ce.m476e(list, "<this>");
        return list.size() - 1;
    }

    public static List m7785h(Object... objArr) {
        AbstractC0116Ce.m476e(objArr, "elements");
        return objArr.length > 0 ? AbstractC2637z1.m10981c(objArr) : m7783f();
    }

    public static List m7786i(Object... objArr) {
        AbstractC0116Ce.m476e(objArr, "elements");
        return AbstractC0002A1.m5l(objArr);
    }

    public static List m7787j(Object... objArr) {
        AbstractC0116Ce.m476e(objArr, "elements");
        return objArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new C2269r1(objArr, true));
    }

    public static List m7788k(List list) {
        AbstractC0116Ce.m476e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : AbstractC1763g5.m7692b(list.get(0)) : m7783f();
    }

    public static final void m7789l(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    public static void m7790m() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
