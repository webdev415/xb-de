package p000;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class AbstractC2413u7 {
    public static final void m9991a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    public static final InterfaceC2367t7 m9992b(AbstractC2408u2 abstractC2408u2) {
        return (InterfaceC2367t7) abstractC2408u2.getClass().getAnnotation(InterfaceC2367t7.class);
    }

    public static final int m9993c(AbstractC2408u2 abstractC2408u2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = abstractC2408u2.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(abstractC2408u2);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement m9994d(AbstractC2408u2 abstractC2408u2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        String strM9682c;
        AbstractC0116Ce.m476e(abstractC2408u2, "<this>");
        InterfaceC2367t7 interfaceC2367t7M9992b = m9992b(abstractC2408u2);
        if (interfaceC2367t7M9992b == null) {
            return null;
        }
        m9991a(1, interfaceC2367t7M9992b.m9686v());
        int iM9993c = m9993c(abstractC2408u2);
        int i = iM9993c < 0 ? -1 : interfaceC2367t7M9992b.m9684l()[iM9993c];
        String strM4505b = C1037Wg.f3070a.m4505b(abstractC2408u2);
        if (strM4505b == null) {
            strM9682c = interfaceC2367t7M9992b.m9682c();
        } else {
            strM9682c = strM4505b + '/' + interfaceC2367t7M9992b.m9682c();
        }
        return new StackTraceElement(strM9682c, interfaceC2367t7M9992b.m9685m(), interfaceC2367t7M9992b.m9683f(), i);
    }
}
