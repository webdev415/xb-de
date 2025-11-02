package p000;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractC1172Zd extends AbstractC2500w2 implements Serializable {

    public final transient AbstractC1126Yd f3438l;

    public final transient int f3439m;

    public static class a {

        public final Map f3440a = AbstractC0809Ri.m3825c();

        public Comparator f3441b;

        public Comparator f3442c;
    }

    public AbstractC1172Zd(AbstractC1126Yd abstractC1126Yd, int i) {
        this.f3438l = abstractC1126Yd;
        this.f3439m = i;
    }

    @Override
    public boolean mo1312b(Object obj) {
        return obj != null && super.mo1312b(obj);
    }

    @Override
    public AbstractC1126Yd mo1311a() {
        return this.f3438l;
    }

    @Override
    public /* bridge */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public /* bridge */ int hashCode() {
        return super.hashCode();
    }

    @Override
    public /* bridge */ String toString() {
        return super.toString();
    }
}
