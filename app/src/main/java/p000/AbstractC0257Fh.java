package p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractC0257Fh {

    public static final class a {

        public final List f665a;

        public final Object f666b;

        public a(Object obj, AbstractC0128Cq abstractC0128Cq) {
            AbstractC1085Xi.m4801j(obj);
            this.f666b = obj;
            this.f665a = new ArrayList<>();
        }

        public a m1258a(String str, Object obj) {
            AbstractC1085Xi.m4801j(str);
            this.f665a.add(str + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f666b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f665a.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) this.f665a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean m1255a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int m1256b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a m1257c(Object obj) {
        return new a(obj, null);
    }
}
