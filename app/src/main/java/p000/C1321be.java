package p000;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import p000.AbstractC1126Yd;
import p000.AbstractC1172Zd;

public class C1321be extends AbstractC1172Zd implements InterfaceC1738fh {

    public final transient AbstractC1220ae f3873n;

    public static final class a extends AbstractC1172Zd.a {
        public C1321be m5665a() {
            Collection collectionEntrySet = this.f3440a.entrySet();
            Comparator comparator = this.f3441b;
            if (comparator != null) {
                collectionEntrySet = AbstractC1786gi.m7739a(comparator).m7742d().m7741b(collectionEntrySet);
            }
            return C1321be.m5662e(collectionEntrySet, this.f3442c);
        }
    }

    public C1321be(AbstractC1126Yd abstractC1126Yd, int i, Comparator comparator) {
        super(abstractC1126Yd, i);
        this.f3873n = m5661d(comparator);
    }

    public static AbstractC1220ae m5661d(Comparator comparator) {
        return comparator == null ? AbstractC1220ae.m5256t() : AbstractC1367ce.m5888C(comparator);
    }

    public static C1321be m5662e(Collection collection, Comparator comparator) {
        if (collection.isEmpty()) {
            return m5663f();
        }
        AbstractC1126Yd.a aVar = new AbstractC1126Yd.a(collection.size());
        Iterator it = collection.iterator();
        int size = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            AbstractC1220ae abstractC1220aeM5664g = m5664g(comparator, (Collection) entry.getValue());
            if (!abstractC1220aeM5664g.isEmpty()) {
                aVar.m4950e(key, abstractC1220aeM5664g);
                size += abstractC1220aeM5664g.size();
            }
        }
        return new C1321be(aVar.m4947b(), size, comparator);
    }

    public static C1321be m5663f() {
        return C0654O9.f2009o;
    }

    public static AbstractC1220ae m5664g(Comparator comparator, Collection collection) {
        return comparator == null ? AbstractC1220ae.m5255q(collection) : AbstractC1367ce.m5892z(comparator, collection);
    }
}
