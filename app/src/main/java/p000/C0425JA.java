package p000;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public final class C0425JA {

    public static final C0425JA f1295c = new C0425JA(null, null, 100);

    public final EnumMap f1296a;

    public final int f1297b;

    public enum a {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");


        public final String f1303l;

        a(String str) {
            this.f1303l = str;
        }
    }

    public C0425JA(Boolean bool, Boolean bool2, int i) {
        EnumMap enumMap = new EnumMap(a.class);
        this.f1296a = enumMap;
        enumMap.put((EnumMap) a.AD_STORAGE, (a) m1843f(bool));
        enumMap.put((EnumMap) a.ANALYTICS_STORAGE, (a) m1843f(bool2));
        this.f1297b = i;
    }

    public static char m1839a(EnumC0333HA enumC0333HA) {
        if (enumC0333HA == null) {
            return '-';
        }
        int iOrdinal = enumC0333HA.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static String m1840c(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static String m1841d(Bundle bundle) {
        String string;
        a[] aVarArr = EnumC0517LA.STORAGE.f1696l;
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            Boolean bool = null;
            if (i >= length) {
                return null;
            }
            a aVar = aVarArr[i];
            if (bundle.containsKey(aVar.f1303l) && (string = bundle.getString(aVar.f1303l)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i++;
        }
    }

    public static EnumC0333HA m1842e(char c) {
        return c != '+' ? c != '0' ? c != '1' ? EnumC0333HA.UNINITIALIZED : EnumC0333HA.GRANTED : EnumC0333HA.DENIED : EnumC0333HA.POLICY;
    }

    public static EnumC0333HA m1843f(Boolean bool) {
        return bool == null ? EnumC0333HA.UNINITIALIZED : bool.booleanValue() ? EnumC0333HA.GRANTED : EnumC0333HA.DENIED;
    }

    public static EnumC0333HA m1844g(String str) {
        return str == null ? EnumC0333HA.UNINITIALIZED : str.equals("granted") ? EnumC0333HA.GRANTED : str.equals("denied") ? EnumC0333HA.DENIED : EnumC0333HA.UNINITIALIZED;
    }

    public static C0425JA m1845h(Bundle bundle, int i) {
        if (bundle == null) {
            return new C0425JA(null, null, i);
        }
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : EnumC0517LA.STORAGE.f1696l) {
            enumMap.put((EnumMap) aVar, (a) m1844g(bundle.getString(aVar.f1303l)));
        }
        return new C0425JA(enumMap, i);
    }

    public static C0425JA m1846i(String str, int i) {
        EnumMap enumMap = new EnumMap(a.class);
        if (str == null) {
            str = "";
        }
        a[] aVarArrM2648c = EnumC0517LA.STORAGE.m2648c();
        for (int i2 = 0; i2 < aVarArrM2648c.length; i2++) {
            int i3 = i2 + 2;
            enumMap.put((EnumMap) aVarArrM2648c[i2], (a) (i3 < str.length() ? m1842e(str.charAt(i3)) : EnumC0333HA.UNINITIALIZED));
        }
        return new C0425JA(enumMap, i);
    }

    public static C0425JA m1847j(EnumC0333HA enumC0333HA, EnumC0333HA enumC0333HA2, int i) {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put((EnumMap) a.AD_STORAGE, (a) enumC0333HA);
        enumMap.put((EnumMap) a.ANALYTICS_STORAGE, (a) enumC0333HA2);
        return new C0425JA(enumMap, -10);
    }

    public static boolean m1848l(int i, int i2) {
        if (i == -20 && i2 == -30) {
            return true;
        }
        return (i == -30 && i2 == -20) || i == i2 || i < i2;
    }

    public static String m1849p(EnumC0333HA enumC0333HA) {
        int iOrdinal = enumC0333HA.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return "granted";
    }

    public static C0425JA m1850q(String str) {
        return m1846i(str, 100);
    }

    public final boolean m1851A() {
        return m1856m(a.AD_STORAGE);
    }

    public final boolean m1852B() {
        return m1856m(a.ANALYTICS_STORAGE);
    }

    public final boolean m1853C() {
        Iterator it = this.f1296a.values().iterator();
        while (it.hasNext()) {
            if (((EnumC0333HA) it.next()) != EnumC0333HA.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final int m1854b() {
        return this.f1297b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0425JA)) {
            return false;
        }
        C0425JA c0425ja = (C0425JA) obj;
        for (a aVar : EnumC0517LA.STORAGE.f1696l) {
            if (this.f1296a.get(aVar) != c0425ja.f1296a.get(aVar)) {
                return false;
            }
        }
        return this.f1297b == c0425ja.f1297b;
    }

    public final int hashCode() {
        int iHashCode = this.f1297b * 17;
        Iterator it = this.f1296a.values().iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((EnumC0333HA) it.next()).hashCode();
        }
        return iHashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C0425JA m1855k(C0425JA r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<JA$a> r1 = p000.C0425JA.a.class
            r0.<init>(r1)
            LA r1 = p000.EnumC0517LA.STORAGE
            JA$a[] r1 = p000.EnumC0517LA.m2647e(r1)
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L4d
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f1296a
            java.lang.Object r5 = r5.get(r4)
            HA r5 = (p000.EnumC0333HA) r5
            java.util.EnumMap r6 = r9.f1296a
            java.lang.Object r6 = r6.get(r4)
            HA r6 = (p000.EnumC0333HA) r6
            if (r5 != 0) goto L26
            goto L35
        L26:
            if (r6 != 0) goto L29
            goto L45
        L29:
            HA r7 = p000.EnumC0333HA.UNINITIALIZED
            if (r5 != r7) goto L2e
            goto L35
        L2e:
            if (r6 != r7) goto L31
            goto L45
        L31:
            HA r7 = p000.EnumC0333HA.POLICY
            if (r5 != r7) goto L37
        L35:
            r5 = r6
            goto L45
        L37:
            if (r6 != r7) goto L3a
            goto L45
        L3a:
            HA r7 = p000.EnumC0333HA.DENIED
            if (r5 == r7) goto L44
            if (r6 != r7) goto L41
            goto L44
        L41:
            HA r5 = p000.EnumC0333HA.GRANTED
            goto L45
        L44:
            r5 = r7
        L45:
            if (r5 == 0) goto L4a
            r0.put(r4, r5)
        L4a:
            int r3 = r3 + 1
            goto Lf
        L4d:
            JA r9 = new JA
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0425JA.m1855k(JA):JA");
    }

    public final boolean m1856m(a aVar) {
        return ((EnumC0333HA) this.f1296a.get(aVar)) != EnumC0333HA.DENIED;
    }

    public final boolean m1857n(C0425JA c0425ja, a... aVarArr) {
        for (a aVar : aVarArr) {
            if (!c0425ja.m1856m(aVar) && m1856m(aVar)) {
                return true;
            }
        }
        return false;
    }

    public final Bundle m1858o() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f1296a.entrySet()) {
            String strM1849p = m1849p((EnumC0333HA) entry.getValue());
            if (strM1849p != null) {
                bundle.putString(((a) entry.getKey()).f1303l, strM1849p);
            }
        }
        return bundle;
    }

    public final C0425JA m1859r(C0425JA c0425ja) {
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : EnumC0517LA.STORAGE.f1696l) {
            EnumC0333HA enumC0333HA = (EnumC0333HA) this.f1296a.get(aVar);
            if (enumC0333HA == EnumC0333HA.UNINITIALIZED) {
                enumC0333HA = (EnumC0333HA) c0425ja.f1296a.get(aVar);
            }
            if (enumC0333HA != null) {
                enumMap.put((EnumMap) aVar, (a) enumC0333HA);
            }
        }
        return new C0425JA(enumMap, this.f1297b);
    }

    public final boolean m1860s(C0425JA c0425ja, a... aVarArr) {
        for (a aVar : aVarArr) {
            EnumC0333HA enumC0333HA = (EnumC0333HA) this.f1296a.get(aVar);
            EnumC0333HA enumC0333HA2 = (EnumC0333HA) c0425ja.f1296a.get(aVar);
            EnumC0333HA enumC0333HA3 = EnumC0333HA.DENIED;
            if (enumC0333HA == enumC0333HA3 && enumC0333HA2 != enumC0333HA3) {
                return true;
            }
        }
        return false;
    }

    public final EnumC0333HA m1861t() {
        EnumC0333HA enumC0333HA = (EnumC0333HA) this.f1296a.get(a.AD_STORAGE);
        return enumC0333HA == null ? EnumC0333HA.UNINITIALIZED : enumC0333HA;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(m1840c(this.f1297b));
        for (a aVar : EnumC0517LA.STORAGE.f1696l) {
            sb.append(",");
            sb.append(aVar.f1303l);
            sb.append("=");
            EnumC0333HA enumC0333HA = (EnumC0333HA) this.f1296a.get(aVar);
            if (enumC0333HA == null) {
                enumC0333HA = EnumC0333HA.UNINITIALIZED;
            }
            sb.append(enumC0333HA);
        }
        return sb.toString();
    }

    public final boolean m1862u(C0425JA c0425ja) {
        return m1860s(c0425ja, (a[]) this.f1296a.keySet().toArray(new a[0]));
    }

    public final EnumC0333HA m1863v() {
        EnumC0333HA enumC0333HA = (EnumC0333HA) this.f1296a.get(a.ANALYTICS_STORAGE);
        return enumC0333HA == null ? EnumC0333HA.UNINITIALIZED : enumC0333HA;
    }

    public final Boolean m1864w() {
        EnumC0333HA enumC0333HA = (EnumC0333HA) this.f1296a.get(a.AD_STORAGE);
        if (enumC0333HA == null) {
            return null;
        }
        int iOrdinal = enumC0333HA.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return Boolean.FALSE;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    public final Boolean m1865x() {
        EnumC0333HA enumC0333HA = (EnumC0333HA) this.f1296a.get(a.ANALYTICS_STORAGE);
        if (enumC0333HA == null) {
            return null;
        }
        int iOrdinal = enumC0333HA.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return Boolean.FALSE;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final String m1866y() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            LA r1 = p000.EnumC0517LA.STORAGE
            JA$a[] r1 = r1.m2648c()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L3a
            r4 = r1[r3]
            java.util.EnumMap r5 = r7.f1296a
            java.lang.Object r4 = r5.get(r4)
            HA r4 = (p000.EnumC0333HA) r4
            r5 = 45
            if (r4 == 0) goto L34
            int r4 = r4.ordinal()
            if (r4 == 0) goto L34
            r6 = 1
            if (r4 == r6) goto L32
            r6 = 2
            if (r4 == r6) goto L2f
            r6 = 3
            if (r4 == r6) goto L32
            goto L34
        L2f:
            r5 = 48
            goto L34
        L32:
            r5 = 49
        L34:
            r0.append(r5)
            int r3 = r3 + 1
            goto Lf
        L3a:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0425JA.m1866y():java.lang.String");
    }

    public final String m1867z() {
        StringBuilder sb = new StringBuilder("G1");
        for (a aVar : EnumC0517LA.STORAGE.m2648c()) {
            sb.append(m1839a((EnumC0333HA) this.f1296a.get(aVar)));
        }
        return sb.toString();
    }

    public C0425JA(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(a.class);
        this.f1296a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f1297b = i;
    }
}
