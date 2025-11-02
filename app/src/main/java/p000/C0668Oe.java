package p000;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class C0668Oe extends C0855Si {

    public static final class a {

        public static final a f2046a = new a();

        public static final Integer f2047b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            f2047b = num;
        }
    }

    private final boolean m3419c(int i) {
        Integer num = a.f2047b;
        return num == null || num.intValue() >= i;
    }

    @Override
    public void mo3420a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC0116Ce.m476e(th, "cause");
        AbstractC0116Ce.m476e(th2, "exception");
        if (m3419c(19)) {
            th.addSuppressed(th2);
        } else {
            super.mo3420a(th, th2);
        }
    }
}
