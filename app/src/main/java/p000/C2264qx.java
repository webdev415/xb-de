package p000;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class C2264qx {

    public static final AtomicReference f6819b = new AtomicReference();

    public static final AtomicReference f6820c = new AtomicReference();

    public static final AtomicReference f6821d = new AtomicReference();

    public final InterfaceC2172ox f6822a;

    public C2264qx(InterfaceC2172ox interfaceC2172ox) {
        this.f6822a = interfaceC2172ox;
    }

    public static String m9207c(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        AbstractC1085Xi.m4801j(strArr);
        AbstractC1085Xi.m4801j(strArr2);
        AbstractC1085Xi.m4801j(atomicReference);
        AbstractC1085Xi.m4792a(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (Objects.equals(str, strArr[i])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        if (strArr3[i] == null) {
                            strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                        }
                        str2 = strArr3[i];
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String m9208a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f6822a.mo5648a()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(m9212f(str));
            sb.append("=");
            Object obj = bundle.get(str);
            sb.append(obj instanceof Bundle ? m9211e(new Object[]{obj}) : obj instanceof Object[] ? m9211e((Object[]) obj) : obj instanceof ArrayList ? m9211e(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sb.append("}]");
        return sb.toString();
    }

    public final String m9209b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f6822a.mo5648a() ? str : m9207c(str, AbstractC0701PA.f2094c, AbstractC0701PA.f2092a, f6819b);
    }

    public final String m9210d(C0635Nr c0635Nr) {
        if (c0635Nr == null) {
            return null;
        }
        if (!this.f6822a.mo5648a()) {
            return c0635Nr.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(c0635Nr.f1976n);
        sb.append(",name=");
        sb.append(m9209b(c0635Nr.f1974l));
        sb.append(",params=");
        C0175Dr c0175Dr = c0635Nr.f1975m;
        sb.append(c0175Dr != null ? !this.f6822a.mo5648a() ? c0175Dr.toString() : m9208a(c0175Dr.m785h()) : null);
        return sb.toString();
    }

    public final String m9211e(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            String strM9208a = obj instanceof Bundle ? m9208a((Bundle) obj) : String.valueOf(obj);
            if (strM9208a != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(strM9208a);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final String m9212f(String str) {
        if (str == null) {
            return null;
        }
        return !this.f6822a.mo5648a() ? str : m9207c(str, AbstractC0609NA.f1913b, AbstractC0609NA.f1912a, f6820c);
    }

    public final String m9213g(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f6822a.mo5648a()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return m9207c(str, AbstractC0884TA.f2727b, AbstractC0884TA.f2726a, f6821d);
        }
        return "experiment_id(" + str + ")";
    }
}
