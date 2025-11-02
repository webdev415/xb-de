package p000;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class C1037Wg {

    public static final C1037Wg f3070a = new C1037Wg();

    public static final a f3071b = new a(null, null, null);

    public static a f3072c;

    public static final class a {

        public final Method f3073a;

        public final Method f3074b;

        public final Method f3075c;

        public a(Method method, Method method2, Method method3) {
            this.f3073a = method;
            this.f3074b = method2;
            this.f3075c = method3;
        }
    }

    public final a m4504a(AbstractC2408u2 abstractC2408u2) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", null), abstractC2408u2.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), abstractC2408u2.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f3072c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f3071b;
            f3072c = aVar2;
            return aVar2;
        }
    }

    public final String m4505b(AbstractC2408u2 abstractC2408u2) {
        AbstractC0116Ce.m476e(abstractC2408u2, "continuation");
        a aVarM4504a = f3072c;
        if (aVarM4504a == null) {
            aVarM4504a = m4504a(abstractC2408u2);
        }
        if (aVarM4504a == f3071b) {
            return null;
        }
        Method method = aVarM4504a.f3073a;
        Object objInvoke = method != null ? method.invoke(abstractC2408u2.getClass(), null) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVarM4504a.f3074b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVarM4504a.f3075c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
