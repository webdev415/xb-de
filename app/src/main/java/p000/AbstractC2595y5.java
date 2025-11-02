package p000;

import java.util.Comparator;

/* loaded from: classes.dex */
public abstract class AbstractC2595y5 {
    public static int m10833a(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static Comparator m10834b() {
        C1971kh c1971kh = C1971kh.f6022l;
        AbstractC0116Ce.m474c(c1971kh, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return c1971kh;
    }
}
