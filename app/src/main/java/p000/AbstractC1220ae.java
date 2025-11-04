package p000;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

public abstract class AbstractC1220ae extends AbstractC1034Wd implements Set {

    public transient AbstractC1080Xd f3539m;

    public static int m5253o(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            AbstractC1131Yi.m4969e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (iHighestOneBit * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static AbstractC1220ae m5254p(int i, Object... objArr) {
        if (i == 0) {
            return m5256t();
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return m5257u(obj);
        }
        int iM5253o = m5253o(i);
        Object[] objArr2 = new Object[iM5253o];
        int i2 = iM5253o - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object objM709a = AbstractC0165Dh.m709a(objArr[i5], i5);
            int iHashCode = objM709a.hashCode();
            int iM4389b = AbstractC0987Vc.m4389b(iHashCode);
            while (true) {
                int i6 = iM4389b & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = objM709a;
                    objArr2[i6] = objM709a;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(objM709a)) {
                    break;
                }
                iM4389b++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new C1088Xl(obj3);
        }
        if (m5253o(i4) < iM5253o / 2) {
            return m5254p(i4, objArr);
        }
        if (m5259w(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new C2527wk(objArr, i3, objArr2, i2, i4);
    }

    public static AbstractC1220ae m5255q(Collection collection) {
        if ((collection instanceof AbstractC1220ae) && !(collection instanceof SortedSet)) {
            AbstractC1220ae abstractC1220ae = (AbstractC1220ae) collection;
            if (!abstractC1220ae.mo4497i()) {
                return abstractC1220ae;
            }
        }
        Object[] array = collection.toArray();
        return m5254p(array.length, array);
    }

    public static AbstractC1220ae m5256t() {
        return C2527wk.f7883t;
    }

    public static AbstractC1220ae m5257u(Object obj) {
        return new C1088Xl(obj);
    }

    public static AbstractC1220ae m5258v(Object obj, Object obj2, Object obj3) {
        return m5254p(3, obj, obj2, obj3);
    }

    public static boolean m5259w(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof AbstractC1220ae) && mo5262s() && ((AbstractC1220ae) obj).mo5262s() && hashCode() != obj.hashCode()) {
            return false;
        }
        return AbstractC0583Ml.m2913a(this, obj);
    }

    @Override
    public int hashCode() {
        return AbstractC0583Ml.m2914b(this);
    }

    public AbstractC1080Xd mo5260k() {
        AbstractC1080Xd abstractC1080Xd = this.f3539m;
        if (abstractC1080Xd != null) {
            return abstractC1080Xd;
        }
        AbstractC1080Xd abstractC1080XdMo5261r = mo5261r();
        this.f3539m = abstractC1080XdMo5261r;
        return abstractC1080XdMo5261r;
    }

    public AbstractC1080Xd mo5261r() {
        return AbstractC1080Xd.m4756k(toArray());
    }

    public boolean mo5262s() {
        return false;
    }
}
