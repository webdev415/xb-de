package p000;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class C1971kh implements Comparator {

    public static final C1971kh f6022l = new C1971kh();

    @Override
    public int compare(Comparable comparable, Comparable comparable2) {
        AbstractC0116Ce.m476e(comparable, "a");
        AbstractC0116Ce.m476e(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    @Override
    public final Comparator reversed() {
        return C0995Vk.f2986l;
    }
}
