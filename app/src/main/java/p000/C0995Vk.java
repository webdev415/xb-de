package p000;

import java.util.Comparator;

public final class C0995Vk implements Comparator {

    public static final C0995Vk f2986l = new C0995Vk();

    @Override
    public int compare(Comparable comparable, Comparable comparable2) {
        AbstractC0116Ce.m476e(comparable, "a");
        AbstractC0116Ce.m476e(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @Override
    public final Comparator reversed() {
        return C1971kh.f6022l;
    }
}
