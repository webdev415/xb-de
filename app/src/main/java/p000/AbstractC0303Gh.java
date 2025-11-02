package p000;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbstractC0303Gh extends AbstractC0434Ja {
    public static boolean m1398a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int m1399b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
