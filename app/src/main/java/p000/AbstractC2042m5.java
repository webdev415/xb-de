package p000;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractC2042m5 extends AbstractC1996l5 {
    public static boolean m8435p(Collection collection, Iterable iterable) {
        AbstractC0116Ce.m476e(collection, "<this>");
        AbstractC0116Ce.m476e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean m8436q(Collection collection, Object[] objArr) {
        AbstractC0116Ce.m476e(collection, "<this>");
        AbstractC0116Ce.m476e(objArr, "elements");
        return collection.addAll(AbstractC2637z1.m10981c(objArr));
    }
}
