package p000;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class AbstractC2181p5 extends AbstractC2134o5 {

    public static final class a implements InterfaceC0031Al {

        public final Iterable f6628a;

        public a(Iterable iterable) {
            this.f6628a = iterable;
        }

        @Override
        public Iterator iterator() {
            return this.f6628a.iterator();
        }
    }

    public static List m9013A(Collection collection, Iterable iterable) {
        AbstractC0116Ce.m476e(collection, "<this>");
        AbstractC0116Ce.m476e(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList<>(collection);
            AbstractC2042m5.m8435p(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList<>(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List m9014B(Collection collection, Object obj) {
        AbstractC0116Ce.m476e(collection, "<this>");
        ArrayList arrayList = new ArrayList<>(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object m9015C(Iterable iterable) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        if (iterable instanceof List) {
            return m9016D((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final Object m9016D(List list) {
        AbstractC0116Ce.m476e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final List m9017E(Iterable iterable, int i) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return AbstractC1810h5.m7783f();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return m9019G(iterable);
            }
            if (i == 1) {
                return AbstractC1763g5.m7692b(m9025t(iterable));
            }
        }
        ArrayList arrayList = new ArrayList<>(i);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return AbstractC1810h5.m7788k(arrayList);
    }

    public static final Collection m9018F(Iterable iterable, Collection collection) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        AbstractC0116Ce.m476e(collection, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static List m9019G(Iterable iterable) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return AbstractC1810h5.m7788k(m9020H(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC1810h5.m7783f();
        }
        if (size != 1) {
            return m9021I(collection);
        }
        return AbstractC1763g5.m7692b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final List m9020H(Iterable iterable) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        return iterable instanceof Collection ? m9021I((Collection) iterable) : (List) m9018F(iterable, new ArrayList<>());
    }

    public static List m9021I(Collection collection) {
        AbstractC0116Ce.m476e(collection, "<this>");
        return new ArrayList<>(collection);
    }

    public static Set m9022J(Iterable iterable) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return AbstractC0675Ol.m3435c((Set) m9018F(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC0675Ol.m3434b();
        }
        if (size != 1) {
            return (Set) m9018F(iterable, new LinkedHashSet(AbstractC2293rg.m9412a(collection.size())));
        }
        return AbstractC0629Nl.m3329a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static InterfaceC0031Al m9023r(Iterable iterable) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        return new a(iterable);
    }

    public static List m9024s(List list, int i) {
        AbstractC0116Ce.m476e(list, "<this>");
        if (i >= 0) {
            return m9017E(list, AbstractC1132Yj.m4981b(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final Object m9025t(Iterable iterable) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        if (iterable instanceof List) {
            return m9026u((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object m9026u(List list) {
        AbstractC0116Ce.m476e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final Appendable m9027v(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC0986Vb interfaceC0986Vb) throws IOException {
        AbstractC0116Ce.m476e(iterable, "<this>");
        AbstractC0116Ce.m476e(appendable, "buffer");
        AbstractC0116Ce.m476e(charSequence, "separator");
        AbstractC0116Ce.m476e(charSequence2, "prefix");
        AbstractC0116Ce.m476e(charSequence3, "postfix");
        AbstractC0116Ce.m476e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            AbstractC0170Dm.m733a(appendable, obj, interfaceC0986Vb);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String m9029x(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC0986Vb interfaceC0986Vb) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        AbstractC0116Ce.m476e(charSequence, "separator");
        AbstractC0116Ce.m476e(charSequence2, "prefix");
        AbstractC0116Ce.m476e(charSequence3, "postfix");
        AbstractC0116Ce.m476e(charSequence4, "truncated");
        String string = ((StringBuilder) m9027v(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, interfaceC0986Vb)).toString();
        AbstractC0116Ce.m475d(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static String m9030y(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC0986Vb interfaceC0986Vb, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            interfaceC0986Vb = null;
        }
        return m9029x(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, interfaceC0986Vb);
    }

    public static Object m9031z(List list) {
        AbstractC0116Ce.m476e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(AbstractC1810h5.m7784g(list));
    }
}
