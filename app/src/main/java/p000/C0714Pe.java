package p000;

public class C0714Pe extends C0668Oe {

    public static final class a {

        public static final a f2141a = new a();

        public static final Integer f2142b;

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
            f2142b = num;
        }
    }

    @Override
    public AbstractC0994Vj mo3562b() {
        return m3563c(34) ? new C0947Ui() : super.mo3562b();
    }

    public final boolean m3563c(int i) {
        Integer num = a.f2142b;
        return num == null || num.intValue() >= i;
    }
}
