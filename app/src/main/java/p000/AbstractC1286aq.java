package p000;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import p000.C2078mw;
import p000.C2171ow;

/* loaded from: classes.dex */
public abstract class AbstractC1286aq {

    public String f3798a;

    public int f3799b;

    public Boolean f3800c;

    public Boolean f3801d;

    public Long f3802e;

    public Long f3803f;

    public AbstractC1286aq(String str, int i) {
        this.f3798a = str;
        this.f3799b = i;
    }

    public static Boolean m5555b(double d, C2078mw c2078mw) {
        try {
            return m5561h(new BigDecimal(d), c2078mw, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean m5556c(long j, C2078mw c2078mw) {
        try {
            return m5561h(new BigDecimal(j), c2078mw, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean m5557d(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    public static Boolean m5558e(String str, C2078mw c2078mw) {
        if (!C2145oG.m8905h0(str)) {
            return null;
        }
        try {
            return m5561h(new BigDecimal(str), c2078mw, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean m5559f(String str, C2171ow.b bVar, boolean z, String str2, List list, String str3, C2356sx c2356sx) {
        boolean zStartsWith;
        if (str == null) {
            return null;
        }
        if (bVar == C2171ow.b.IN_LIST) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && bVar != C2171ow.b.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (AbstractC0617NI.f1924a[bVar.ordinal()]) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (c2356sx != null) {
                        c2356sx.m9623L().m10617b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                zStartsWith = str.startsWith(str2);
                break;
            case 3:
                zStartsWith = str.endsWith(str2);
                break;
            case 4:
                zStartsWith = str.contains(str2);
                break;
            case 5:
                zStartsWith = str.equals(str2);
                break;
            case 6:
                if (list != null) {
                    zStartsWith = list.contains(str);
                    break;
                } else {
                    return null;
                }
            default:
                return null;
        }
        return Boolean.valueOf(zStartsWith);
    }

    public static Boolean m5560g(String str, C2171ow c2171ow, C2356sx c2356sx) {
        List list;
        AbstractC1085Xi.m4801j(c2171ow);
        if (str == null || !c2171ow.m8994O() || c2171ow.m8988G() == C2171ow.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        C2171ow.b bVarM8988G = c2171ow.m8988G();
        C2171ow.b bVar = C2171ow.b.IN_LIST;
        if (bVarM8988G == bVar) {
            if (c2171ow.m8995j() == 0) {
                return null;
            }
        } else if (!c2171ow.m8993N()) {
            return null;
        }
        C2171ow.b bVarM8988G2 = c2171ow.m8988G();
        boolean zM8991L = c2171ow.m8991L();
        String strM8989J = (zM8991L || bVarM8988G2 == C2171ow.b.REGEXP || bVarM8988G2 == bVar) ? c2171ow.m8989J() : c2171ow.m8989J().toUpperCase(Locale.ENGLISH);
        if (c2171ow.m8995j() == 0) {
            list = null;
        } else {
            List listM8990K = c2171ow.m8990K();
            if (!zM8991L) {
                ArrayList arrayList = new ArrayList<>(listM8990K.size());
                Iterator it = listM8990K.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                listM8990K = Collections.unmodifiableList(arrayList);
            }
            list = listM8990K;
        }
        return m5559f(str, bVarM8988G2, zM8991L, strM8989J, list, bVarM8988G2 == C2171ow.b.REGEXP ? strM8989J : null, c2356sx);
    }

    public static Boolean m5561h(BigDecimal bigDecimal, C2078mw c2078mw, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        AbstractC1085Xi.m4801j(c2078mw);
        if (c2078mw.m8649N() && c2078mw.m8644G() != C2078mw.b.UNKNOWN_COMPARISON_TYPE) {
            C2078mw.b bVarM8644G = c2078mw.m8644G();
            C2078mw.b bVar = C2078mw.b.BETWEEN;
            if (bVarM8644G == bVar) {
                if (!c2078mw.m8653R() || !c2078mw.m8652Q()) {
                    return null;
                }
            } else if (!c2078mw.m8650O()) {
                return null;
            }
            C2078mw.b bVarM8644G2 = c2078mw.m8644G();
            if (c2078mw.m8644G() == bVar) {
                if (C2145oG.m8905h0(c2078mw.m8647L()) && C2145oG.m8905h0(c2078mw.m8646K())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(c2078mw.m8647L());
                        bigDecimal4 = new BigDecimal(c2078mw.m8646K());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!C2145oG.m8905h0(c2078mw.m8645J())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(c2078mw.m8645J());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (bVarM8644G2 == bVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i = AbstractC0617NI.f1925b[bVarM8644G2.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4 || bigDecimal3 == null) {
                            return null;
                        }
                        if (bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                    if (bigDecimal2 != null) {
                        if (d == 0.0d) {
                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                        }
                        if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) < 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                } else if (bigDecimal2 != null) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
            } else if (bigDecimal2 != null) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
            }
        }
        return null;
    }

    public abstract int mo5562a();

    public abstract boolean mo5563i();

    public abstract boolean mo5564j();
}
