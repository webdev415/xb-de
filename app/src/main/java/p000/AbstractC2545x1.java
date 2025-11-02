package p000;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public abstract class AbstractC2545x1 {
    public static final Object[] m10624a(Object[] objArr, int i) throws NegativeArraySizeException {
        AbstractC0116Ce.m476e(objArr, "reference");
        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
        AbstractC0116Ce.m474c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }

    public static final void m10625b(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }
}
