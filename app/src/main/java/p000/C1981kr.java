package p000;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import p000.C0425JA;

public final class C1981kr {

    public static final C1981kr f6034f = new C1981kr(null, 100);

    public final int f6035a;

    public final String f6036b;

    public final Boolean f6037c;

    public final String f6038d;

    public final EnumMap f6039e;

    public C1981kr(Boolean bool, int i) {
        this(bool, i, (Boolean) null, (String) null);
    }

    public static Boolean m8307b(Bundle bundle) {
        EnumC0333HA enumC0333HAM1844g;
        if (bundle == null || (enumC0333HAM1844g = C0425JA.m1844g(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i = AbstractC1889ir.f5830a[enumC0333HAM1844g.ordinal()];
        if (i == 3) {
            return Boolean.FALSE;
        }
        if (i != 4) {
            return null;
        }
        return Boolean.TRUE;
    }

    public static C1981kr m8308c(Bundle bundle, int i) {
        if (bundle == null) {
            return new C1981kr(null, i);
        }
        EnumMap enumMap = new EnumMap(C0425JA.a.class);
        for (C0425JA.a aVar : EnumC0517LA.DMA.m2648c()) {
            enumMap.put((EnumMap) aVar, (C0425JA.a) C0425JA.m1844g(bundle.getString(aVar.f1303l)));
        }
        return new C1981kr(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static C1981kr m8309d(String str) throws NumberFormatException {
        if (str == null || str.length() <= 0) {
            return f6034f;
        }
        String[] strArrSplit = str.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(C0425JA.a.class);
        C0425JA.a[] aVarArrM2648c = EnumC0517LA.DMA.m2648c();
        int length = aVarArrM2648c.length;
        int i2 = 1;
        int i3 = 0;
        while (i3 < length) {
            enumMap.put((EnumMap) aVarArrM2648c[i3], (C0425JA.a) C0425JA.m1842e(strArrSplit[i2].charAt(0)));
            i3++;
            i2++;
        }
        return new C1981kr(enumMap, i, (Boolean) null, (String) null);
    }

    public static C1981kr m8310e(EnumC0333HA enumC0333HA, int i) {
        EnumMap enumMap = new EnumMap(C0425JA.a.class);
        enumMap.put((EnumMap) C0425JA.a.AD_USER_DATA, (C0425JA.a) enumC0333HA);
        return new C1981kr(enumMap, -10, (Boolean) null, (String) null);
    }

    public final int m8311a() {
        return this.f6035a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1981kr)) {
            return false;
        }
        C1981kr c1981kr = (C1981kr) obj;
        if (this.f6036b.equalsIgnoreCase(c1981kr.f6036b) && Objects.equals(this.f6037c, c1981kr.f6037c)) {
            return Objects.equals(this.f6038d, c1981kr.f6038d);
        }
        return false;
    }

    public final Bundle m8312f() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f6039e.entrySet()) {
            String strM1849p = C0425JA.m1849p((EnumC0333HA) entry.getValue());
            if (strM1849p != null) {
                bundle.putString(((C0425JA.a) entry.getKey()).f1303l, strM1849p);
            }
        }
        Boolean bool = this.f6037c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.f6038d;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final EnumC0333HA m8313g() {
        EnumC0333HA enumC0333HA = (EnumC0333HA) this.f6039e.get(C0425JA.a.AD_USER_DATA);
        return enumC0333HA == null ? EnumC0333HA.UNINITIALIZED : enumC0333HA;
    }

    public final Boolean m8314h() {
        return this.f6037c;
    }

    public final int hashCode() {
        Boolean bool = this.f6037c;
        int i = bool == null ? 3 : bool == Boolean.TRUE ? 7 : 13;
        String str = this.f6038d;
        return this.f6036b.hashCode() + (i * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final String m8315i() {
        return this.f6038d;
    }

    public final String m8316j() {
        return this.f6036b;
    }

    public final boolean m8317k() {
        Iterator it = this.f6039e.values().iterator();
        while (it.hasNext()) {
            if (((EnumC0333HA) it.next()) != EnumC0333HA.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String m8318l() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6035a);
        for (C0425JA.a aVar : EnumC0517LA.DMA.m2648c()) {
            sb.append(":");
            sb.append(C0425JA.m1839a((EnumC0333HA) this.f6039e.get(aVar)));
        }
        return sb.toString();
    }

    public final String toString() {
        int i;
        String str;
        StringBuilder sb = new StringBuilder("source=");
        sb.append(C0425JA.m1840c(this.f6035a));
        for (C0425JA.a aVar : EnumC0517LA.DMA.m2648c()) {
            sb.append(",");
            sb.append(aVar.f1303l);
            sb.append("=");
            EnumC0333HA enumC0333HA = (EnumC0333HA) this.f6039e.get(aVar);
            if (enumC0333HA == null || (i = AbstractC1889ir.f5830a[enumC0333HA.ordinal()]) == 1) {
                sb.append("uninitialized");
            } else {
                if (i == 2) {
                    str = "eu_consent_policy";
                } else if (i == 3) {
                    str = "denied";
                } else if (i == 4) {
                    str = "granted";
                }
                sb.append(str);
            }
        }
        if (this.f6037c != null) {
            sb.append(",isDmaRegion=");
            sb.append(this.f6037c);
        }
        if (this.f6038d != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(this.f6038d);
        }
        return sb.toString();
    }

    public C1981kr(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(C0425JA.a.class);
        this.f6039e = enumMap;
        enumMap.put((EnumMap) C0425JA.a.AD_USER_DATA, (C0425JA.a) C0425JA.m1843f(bool));
        this.f6035a = i;
        this.f6036b = m8318l();
        this.f6037c = bool2;
        this.f6038d = str;
    }

    public C1981kr(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(C0425JA.a.class);
        this.f6039e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f6035a = i;
        this.f6036b = m8318l();
        this.f6037c = bool;
        this.f6038d = str;
    }
}
