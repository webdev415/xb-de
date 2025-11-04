package p000;

public abstract class AbstractC0901Ti {

    public static final C0855Si f2766a;

    static {
        C0855Si c0855Si;
        Object objNewInstance;
        try {
            objNewInstance = C0714Pe.class.newInstance();
            AbstractC0116Ce.m475d(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                } catch (ClassCastException e) {
                    ClassLoader classLoader = objNewInstance.getClass().getClassLoader();
                    ClassLoader classLoader2 = C0855Si.class.getClassLoader();
                    if (AbstractC0116Ce.m472a(classLoader, classLoader2)) {
                        throw e;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                }
            } catch (ClassNotFoundException unused) {
                Object objNewInstance2 = C0668Oe.class.newInstance();
                AbstractC0116Ce.m475d(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c0855Si = (C0855Si) objNewInstance2;
                    } catch (ClassNotFoundException unused2) {
                        c0855Si = new C0855Si();
                    }
                } catch (ClassCastException e2) {
                    ClassLoader classLoader3 = objNewInstance2.getClass().getClassLoader();
                    ClassLoader classLoader4 = C0855Si.class.getClassLoader();
                    if (AbstractC0116Ce.m472a(classLoader3, classLoader4)) {
                        throw e2;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
                }
            }
        } catch (ClassNotFoundException unused3) {
            Object objNewInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            AbstractC0116Ce.m475d(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    if (objNewInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    c0855Si = (C0855Si) objNewInstance3;
                } catch (ClassNotFoundException unused4) {
                    Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    AbstractC0116Ce.m475d(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (objNewInstance4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c0855Si = (C0855Si) objNewInstance4;
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = objNewInstance4.getClass().getClassLoader();
                        ClassLoader classLoader6 = C0855Si.class.getClassLoader();
                        if (AbstractC0116Ce.m472a(classLoader5, classLoader6)) {
                            throw e3;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                    }
                }
            } catch (ClassCastException e4) {
                ClassLoader classLoader7 = objNewInstance3.getClass().getClassLoader();
                ClassLoader classLoader8 = C0855Si.class.getClassLoader();
                if (AbstractC0116Ce.m472a(classLoader7, classLoader8)) {
                    throw e4;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
            }
        }
        if (objNewInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        c0855Si = (C0855Si) objNewInstance;
        f2766a = c0855Si;
    }
}
