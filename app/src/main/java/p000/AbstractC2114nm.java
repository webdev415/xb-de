package p000;

import java.util.Comparator;
import java.util.SortedSet;

public abstract class AbstractC2114nm {
    public static Comparator m8795a(SortedSet sortedSet) {
        Comparator comparator = sortedSet.comparator();
        return comparator == null ? AbstractC1786gi.m7740c() : comparator;
    }

    public static boolean m8796b(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        AbstractC1131Yi.m4973i(comparator);
        AbstractC1131Yi.m4973i(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = m8795a((SortedSet) iterable);
        } else {
            if (!(iterable instanceof InterfaceC2068mm)) {
                return false;
            }
            comparator2 = ((InterfaceC2068mm) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
