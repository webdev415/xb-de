package p000;

public abstract class AbstractC1330bn {

    public static final int f3884a = Runtime.getRuntime().availableProcessors();

    public static final int m5679a() {
        return f3884a;
    }

    public static final String m5680b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
