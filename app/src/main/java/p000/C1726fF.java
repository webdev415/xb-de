package p000;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import p000.C0425JA;

/* loaded from: classes.dex */
public final class C1726fF {

    public static final String[] f5492b = {"GoogleConsent", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "CmpSdkID"};

    public final Map f5493a;

    public C1726fF(Map map) {
        HashMap map2 = new HashMap<>();
        this.f5493a = map2;
        map2.putAll(map);
    }

    public static int m7569a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    public static String m7570c(String str, boolean z) {
        if (!z || str.length() <= 4) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 1;
        while (true) {
            if (i >= 64) {
                i = 0;
                break;
            }
            if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i)) {
                break;
            }
            i++;
        }
        charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(1 | i);
        return String.valueOf(charArray);
    }

    public static C1726fF m7571d(SharedPreferences sharedPreferences) {
        HashMap map = new HashMap<>();
        String strM7572f = m7572f(sharedPreferences, "IABTCF_VendorConsents");
        if (!"\u0000".equals(strM7572f) && strM7572f.length() > 754) {
            map.put("GoogleConsent", String.valueOf(strM7572f.charAt(754)));
        }
        int iM7569a = m7569a(sharedPreferences, "IABTCF_gdprApplies");
        if (iM7569a != -1) {
            map.put("gdprApplies", String.valueOf(iM7569a));
        }
        int iM7569a2 = m7569a(sharedPreferences, "IABTCF_EnableAdvertiserConsentMode");
        if (iM7569a2 != -1) {
            map.put("EnableAdvertiserConsentMode", String.valueOf(iM7569a2));
        }
        int iM7569a3 = m7569a(sharedPreferences, "IABTCF_PolicyVersion");
        if (iM7569a3 != -1) {
            map.put("PolicyVersion", String.valueOf(iM7569a3));
        }
        String strM7572f2 = m7572f(sharedPreferences, "IABTCF_PurposeConsents");
        if (!"\u0000".equals(strM7572f2)) {
            map.put("PurposeConsents", strM7572f2);
        }
        int iM7569a4 = m7569a(sharedPreferences, "IABTCF_CmpSdkID");
        if (iM7569a4 != -1) {
            map.put("CmpSdkID", String.valueOf(iM7569a4));
        }
        return new C1726fF(map);
    }

    public static String m7572f(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "\u0000");
        } catch (ClassCastException unused) {
            return "\u0000";
        }
    }

    public final Bundle m7573b() {
        if (!"1".equals(this.f5493a.get("GoogleConsent")) || !"1".equals(this.f5493a.get("gdprApplies")) || !"1".equals(this.f5493a.get("EnableAdvertiserConsentMode"))) {
            return Bundle.EMPTY;
        }
        int iM7577i = m7577i();
        if (iM7577i < 0) {
            return Bundle.EMPTY;
        }
        String str = (String) this.f5493a.get("PurposeConsents");
        if (TextUtils.isEmpty(str)) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        String str2 = "denied";
        if (str.length() > 0) {
            bundle.putString(C0425JA.a.AD_STORAGE.f1303l, str.charAt(0) == '1' ? "granted" : "denied");
        }
        if (str.length() > 3) {
            bundle.putString(C0425JA.a.AD_PERSONALIZATION.f1303l, (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
        }
        if (str.length() > 6 && iM7577i >= 4) {
            String str3 = C0425JA.a.AD_USER_DATA.f1303l;
            if (str.charAt(0) == '1' && str.charAt(6) == '1') {
                str2 = "granted";
            }
            bundle.putString(str3, str2);
        }
        return bundle;
    }

    public final String m7574e() {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int iM7576h = m7576h();
        if (iM7576h < 0 || iM7576h > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt((iM7576h >> 6) & 63));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iM7576h & 63));
        }
        int iM7577i = m7577i();
        if (iM7577i < 0 || iM7577i > 63) {
            sb.append("0");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iM7577i));
        }
        AbstractC1085Xi.m4792a(true);
        int i = "1".equals(this.f5493a.get("gdprApplies")) ? 2 : 0;
        int i2 = i | 4;
        if ("1".equals(this.f5493a.get("EnableAdvertiserConsentMode"))) {
            i2 = i | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i2));
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1726fF) {
            return m7575g().equalsIgnoreCase(((C1726fF) obj).m7575g());
        }
        return false;
    }

    public final String m7575g() {
        StringBuilder sb = new StringBuilder();
        for (String str : f5492b) {
            if (this.f5493a.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) this.f5493a.get(str));
            }
        }
        return sb.toString();
    }

    public final int m7576h() {
        try {
            String str = (String) this.f5493a.get("CmpSdkID");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final int hashCode() {
        return m7575g().hashCode();
    }

    public final int m7577i() {
        try {
            String str = (String) this.f5493a.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final String toString() {
        return m7575g();
    }
}
