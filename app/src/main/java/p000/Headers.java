package p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Headers implements Iterable {

    public static final b f3227m = new b(null);

    public final String[] f3228l;

    public static final class a {

        public final List f3229a = new ArrayList<>(20);

        public final a m4742a(String str, String str2) {
            AbstractC0116Ce.m476e(str, "name");
            AbstractC0116Ce.m476e(str2, "value");
            b bVar = Headers.f3227m;
            bVar.m4752d(str);
            bVar.m4753e(str2, str);
            m4744c(str, str2);
            return this;
        }

        public final a m4743b(String str) {
            AbstractC0116Ce.m476e(str, "line");
            int iM2928L = AbstractC0584Mm.m2928L(str, ':', 1, false, 4, null);
            if (iM2928L != -1) {
                String strSubstring = str.substring(0, iM2928L);
                AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = str.substring(iM2928L + 1);
                AbstractC0116Ce.m475d(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                m4744c(strSubstring, strSubstring2);
            } else {
                if (str.charAt(0) == ':') {
                    str = str.substring(1);
                    AbstractC0116Ce.m475d(str, "(this as java.lang.String).substring(startIndex)");
                }
                m4744c("", str);
            }
            return this;
        }

        public final a m4744c(String str, String str2) {
            AbstractC0116Ce.m476e(str, "name");
            AbstractC0116Ce.m476e(str2, "value");
            this.f3229a.add(str);
            this.f3229a.add(AbstractC0584Mm.m2956n0(str2).toString());
            return this;
        }

        public final Headers m4745d() {
            Object[] array = this.f3229a.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final List m4746e() {
            return this.f3229a;
        }

        public final a m4747f(String str) {
            AbstractC0116Ce.m476e(str, "name");
            int i = 0;
            while (i < this.f3229a.size()) {
                if (AbstractC0538Lm.m2720l(str, (String) this.f3229a.get(i), true)) {
                    this.f3229a.remove(i);
                    this.f3229a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final a m4748g(String str, String str2) {
            AbstractC0116Ce.m476e(str, "name");
            AbstractC0116Ce.m476e(str2, "value");
            b bVar = Headers.f3227m;
            bVar.m4752d(str);
            bVar.m4753e(str2, str);
            m4747f(str);
            m4744c(str, str2);
            return this;
        }
    }

    public static final class b {
        public b() {
        }

        public final void m4752d(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(AbstractC2623yo.m10942q("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        public final void m4753e(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    throw new IllegalArgumentException(AbstractC2623yo.m10942q("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str).toString());
                }
            }
        }

        public final String m4754f(String[] strArr, String str) {
            C2567xe c2567xeM4986g = AbstractC1132Yj.m4986g(AbstractC1132Yj.m4985f(strArr.length - 2, 0), 2);
            int iM10716d = c2567xeM4986g.m10716d();
            int iM10717f = c2567xeM4986g.m10717f();
            int iM10718g = c2567xeM4986g.m10718g();
            if (iM10718g >= 0) {
                if (iM10716d > iM10717f) {
                    return null;
                }
            } else if (iM10716d < iM10717f) {
                return null;
            }
            while (!AbstractC0538Lm.m2720l(str, strArr[iM10716d], true)) {
                if (iM10716d == iM10717f) {
                    return null;
                }
                iM10716d += iM10718g;
            }
            return strArr[iM10716d + 1];
        }

        public final Headers m4755g(String... strArr) throws CloneNotSupportedException {
            AbstractC0116Ce.m476e(strArr, "namesAndValues");
            if (!(strArr.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr2 = (String[]) objClone;
            int length = strArr2.length;
            for (int i = 0; i < length; i++) {
                String str = strArr2[i];
                if (!(str != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr2[i] = AbstractC0584Mm.m2956n0(str).toString();
            }
            C2567xe c2567xeM4986g = AbstractC1132Yj.m4986g(AbstractC1132Yj.m4987h(0, strArr2.length), 2);
            int iM10716d = c2567xeM4986g.m10716d();
            int iM10717f = c2567xeM4986g.m10717f();
            int iM10718g = c2567xeM4986g.m10718g();
            if (iM10718g < 0 ? iM10716d >= iM10717f : iM10716d <= iM10717f) {
                while (true) {
                    String str2 = strArr2[iM10716d];
                    String str3 = strArr2[iM10716d + 1];
                    m4752d(str2);
                    m4753e(str3, str2);
                    if (iM10716d == iM10717f) {
                        break;
                    }
                    iM10716d += iM10718g;
                }
            }
            return new Headers(strArr2, null);
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public Headers(String[] strArr) {
        this.f3228l = strArr;
    }

    public final String m4737d(String str) {
        AbstractC0116Ce.m476e(str, "name");
        return f3227m.m4754f(this.f3228l, str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.f3228l, ((Headers) obj).f3228l);
    }

    public final String m4738f(int i) {
        return this.f3228l[i * 2];
    }

    public final a m4739g() {
        a aVar = new a();
        AbstractC2042m5.m8436q(aVar.m4746e(), this.f3228l);
        return aVar;
    }

    public final String m4740h(int i) {
        return this.f3228l[(i * 2) + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3228l);
    }

    public final List m4741i(String str) {
        AbstractC0116Ce.m476e(str, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (AbstractC0538Lm.m2720l(str, m4738f(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>(2);
                }
                arrayList.add(m4740h(i));
            }
        }
        if (arrayList == null) {
            return AbstractC1810h5.m7783f();
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        AbstractC0116Ce.m475d(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }

    @Override
    public Iterator iterator() {
        int size = size();
        C0258Fi[] c0258FiArr = new C0258Fi[size];
        for (int i = 0; i < size; i++) {
            c0258FiArr[i] = AbstractC0769Qn.m3706a(m4738f(i), m4740h(i));
        }
        return AbstractC2407u1.m9895a(c0258FiArr);
    }

    public final int size() {
        return this.f3228l.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(m4738f(i));
            sb.append(": ");
            sb.append(m4740h(i));
            sb.append("\n");
        }
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public Headers(String[] strArr, AbstractC0881T7 abstractC0881T7) {
        this(strArr);
    }
}
