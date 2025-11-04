package p000;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractC2005lE {

    public static final char[] f6081a;

    static {
        char[] cArr = new char[80];
        f6081a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String m8375a(InterfaceC1912jE interfaceC1912jE, String str) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        m8378d(interfaceC1912jE, sb, 0);
        return sb.toString();
    }

    public static void m8376b(int i, StringBuilder sb) {
        while (i > 0) {
            char[] cArr = f6081a;
            int length = i > cArr.length ? cArr.length : i;
            sb.append(cArr, 0, length);
            i -= length;
        }
    }

    public static void m8377c(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                m8377c(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m8377c(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        m8376b(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(AbstractC0062BF.m229a(AbstractC2233qB.m9106k((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC2233qB) {
            sb.append(": \"");
            sb.append(AbstractC0062BF.m229a((AbstractC2233qB) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC0703PC) {
            sb.append(" {");
            m8378d((AbstractC0703PC) obj, sb, i + 2);
            sb.append("\n");
            m8376b(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i3 = i + 2;
        m8377c(sb, i3, "key", entry.getKey());
        m8377c(sb, i3, "value", entry.getValue());
        sb.append("\n");
        m8376b(i, sb);
        sb.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m8378d(InterfaceC1912jE r20, StringBuilder r21, int r22) throws SecurityException {
        /*
            Method dump skipped, instructions count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2005lE.m8378d(jE, java.lang.StringBuilder, int):void");
    }
}
