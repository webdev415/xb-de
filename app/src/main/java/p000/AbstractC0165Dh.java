package p000;

/* loaded from: classes.dex */
public abstract class AbstractC0165Dh {
    public static Object m709a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i);
        throw new NullPointerException(sb.toString());
    }

    public static Object[] m710b(Object... objArr) {
        m711c(objArr, objArr.length);
        return objArr;
    }

    public static Object[] m711c(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            m709a(objArr[i2], i2);
        }
        return objArr;
    }

    public static Object[] m712d(Object[] objArr, int i) {
        return AbstractC0809Ri.m3824b(objArr, i);
    }
}
