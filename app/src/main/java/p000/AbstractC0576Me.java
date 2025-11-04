package p000;

import java.util.Collection;

public abstract class AbstractC0576Me {
    public static Collection m2865a(Iterable iterable) {
        return iterable instanceof Collection ? (Collection) iterable : AbstractC0898Tf.m4159g(iterable.iterator());
    }

    public static Object[] m2866b(Iterable iterable) {
        return m2865a(iterable).toArray();
    }
}
