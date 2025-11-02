package p000;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class AbstractC0622Ne {

    public class a extends AbstractC2209po {

        public boolean f1954l;

        public final Object f1955m;

        public a(Object obj) {
            this.f1955m = obj;
        }

        @Override
        public boolean hasNext() {
            return !this.f1954l;
        }

        @Override
        public Object next() {
            if (this.f1954l) {
                throw new NoSuchElementException();
            }
            this.f1954l = true;
            return this.f1955m;
        }
    }

    public static boolean m3318a(Collection collection, Iterator it) {
        AbstractC1131Yi.m4973i(collection);
        AbstractC1131Yi.m4973i(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static boolean m3319b(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !AbstractC0303Gh.m1398a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static AbstractC2209po m3320c(Object obj) {
        return new a(obj);
    }
}
