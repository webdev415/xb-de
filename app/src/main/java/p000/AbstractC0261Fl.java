package p000;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractC0261Fl extends AbstractC0215El {

    public static final class a implements Iterable {

        public final InterfaceC0031Al f677l;

        public a(InterfaceC0031Al interfaceC0031Al) {
            this.f677l = interfaceC0031Al;
        }

        @Override
        public Iterator iterator() {
            return this.f677l.iterator();
        }
    }

    public static Iterable m1273c(InterfaceC0031Al interfaceC0031Al) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "<this>");
        return new a(interfaceC0031Al);
    }

    public static InterfaceC0031Al m1274d(InterfaceC0031Al interfaceC0031Al, int i) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "<this>");
        if (i >= 0) {
            return i == 0 ? interfaceC0031Al : interfaceC0031Al instanceof InterfaceC2092n9 ? ((InterfaceC2092n9) interfaceC0031Al).mo8446a(i) : new C2046m9(interfaceC0031Al, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final Appendable m1275e(InterfaceC0031Al interfaceC0031Al, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC0986Vb interfaceC0986Vb) throws IOException {
        AbstractC0116Ce.m476e(interfaceC0031Al, "<this>");
        AbstractC0116Ce.m476e(appendable, "buffer");
        AbstractC0116Ce.m476e(charSequence, "separator");
        AbstractC0116Ce.m476e(charSequence2, "prefix");
        AbstractC0116Ce.m476e(charSequence3, "postfix");
        AbstractC0116Ce.m476e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : interfaceC0031Al) {
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

    public static final String m1276f(InterfaceC0031Al interfaceC0031Al, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC0986Vb interfaceC0986Vb) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "<this>");
        AbstractC0116Ce.m476e(charSequence, "separator");
        AbstractC0116Ce.m476e(charSequence2, "prefix");
        AbstractC0116Ce.m476e(charSequence3, "postfix");
        AbstractC0116Ce.m476e(charSequence4, "truncated");
        String string = ((StringBuilder) m1275e(interfaceC0031Al, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, interfaceC0986Vb)).toString();
        AbstractC0116Ce.m475d(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static String m1277g(InterfaceC0031Al interfaceC0031Al, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC0986Vb interfaceC0986Vb, int i2, Object obj) {
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
        return m1276f(interfaceC0031Al, charSequence, charSequence5, charSequence6, i3, charSequence7, interfaceC0986Vb);
    }

    public static InterfaceC0031Al m1278h(InterfaceC0031Al interfaceC0031Al, InterfaceC0986Vb interfaceC0986Vb) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "<this>");
        AbstractC0116Ce.m476e(interfaceC0986Vb, "transform");
        return new C0677On(interfaceC0031Al, interfaceC0986Vb);
    }

    public static final Collection m1279i(InterfaceC0031Al interfaceC0031Al, Collection collection) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "<this>");
        AbstractC0116Ce.m476e(collection, "destination");
        Iterator it = interfaceC0031Al.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static List m1280j(InterfaceC0031Al interfaceC0031Al) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "<this>");
        return AbstractC1810h5.m7788k(m1281k(interfaceC0031Al));
    }

    public static final List m1281k(InterfaceC0031Al interfaceC0031Al) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "<this>");
        return (List) m1279i(interfaceC0031Al, new ArrayList<>());
    }
}
