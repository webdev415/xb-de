package p000;

public abstract class AbstractC1131Yi {
    public static String m4965a(int i, int i2, String str) {
        if (i < 0) {
            return AbstractC0078Bm.m323a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return AbstractC0078Bm.m323a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static String m4966b(int i, int i2, String str) {
        if (i < 0) {
            return AbstractC0078Bm.m323a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return AbstractC0078Bm.m323a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static String m4967c(int i, int i2, int i3) {
        return (i < 0 || i > i3) ? m4966b(i, i3, "start index") : (i2 < 0 || i2 > i3) ? m4966b(i2, i3, "end index") : AbstractC0078Bm.m323a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static void m4968d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m4969e(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m4970f(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(AbstractC0078Bm.m323a(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static int m4971g(int i, int i2) {
        return m4972h(i, i2, "index");
    }

    public static int m4972h(int i, int i2, String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(m4965a(i, i2, str));
        }
        return i;
    }

    public static Object m4973i(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object m4974j(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static int m4975k(int i, int i2) {
        return m4976l(i, i2, "index");
    }

    public static int m4976l(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m4966b(i, i2, str));
        }
        return i;
    }

    public static void m4977m(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(m4967c(i, i2, i3));
        }
    }

    public static void m4978n(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m4979o(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void m4980p(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(AbstractC0078Bm.m323a(str, obj));
        }
    }
}
