package p000;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

public final class C2356sx extends AbstractC2508wA {

    public char f7084c;

    public long f7085d;

    public String f7086e;

    public final C2540wx f7087f;

    public final C2540wx f7088g;

    public final C2540wx f7089h;

    public final C2540wx f7090i;

    public final C2540wx f7091j;

    public final C2540wx f7092k;

    public final C2540wx f7093l;

    public final C2540wx f7094m;

    public final C2540wx f7095n;

    public C2356sx(C2266qz c2266qz) {
        super(c2266qz);
        this.f7084c = (char) 0;
        this.f7085d = -1L;
        this.f7087f = new C2540wx(this, 6, false, false);
        this.f7088g = new C2540wx(this, 6, true, false);
        this.f7089h = new C2540wx(this, 6, false, true);
        this.f7090i = new C2540wx(this, 5, false, false);
        this.f7091j = new C2540wx(this, 5, true, false);
        this.f7092k = new C2540wx(this, 5, false, true);
        this.f7093l = new C2540wx(this, 4, false, false);
        this.f7094m = new C2540wx(this, 3, false, false);
        this.f7095n = new C2540wx(this, 2, false, false);
    }

    public static String m9610E(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? (C0064BH.m231a() && ((Boolean) AbstractC0818Rr.f2438E0.m4296a(null)).booleanValue()) ? "" : str : str.substring(0, iLastIndexOf);
    }

    private final String m9611P() {
        String str;
        synchronized (this) {
            try {
                if (this.f7086e == null) {
                    this.f7086e = this.f8058a.m9233O() != null ? this.f8058a.m9233O() : "FA";
                }
                AbstractC1085Xi.m4801j(this.f7086e);
                str = this.f7086e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public static Object m9613v(String str) {
        if (str == null) {
            return null;
        }
        return new C0824Rx(str);
    }

    public static String m9614w(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof C0824Rx ? ((C0824Rx) obj).f2562a : z ? "-" : String.valueOf(obj);
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String strM9610E = m9610E(C2266qz.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && m9610E(className).equals(strM9610E)) {
                sb.append(": ");
                sb.append(stackTraceElement);
                break;
            }
            i++;
        }
        return sb.toString();
    }

    public static String m9615x(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strM9614w = m9614w(z, obj);
        String strM9614w2 = m9614w(z, obj2);
        String strM9614w3 = m9614w(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strM9614w)) {
            sb.append(str2);
            sb.append(strM9614w);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strM9614w2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strM9614w2);
        }
        if (!TextUtils.isEmpty(strM9614w3)) {
            sb.append(str3);
            sb.append(strM9614w3);
        }
        return sb.toString();
    }

    public final boolean m9616C(int i) {
        return Log.isLoggable(m9611P(), i);
    }

    public final C2540wx m9617F() {
        return this.f7094m;
    }

    public final C2540wx m9618G() {
        return this.f7087f;
    }

    public final C2540wx m9619H() {
        return this.f7089h;
    }

    public final C2540wx m9620I() {
        return this.f7088g;
    }

    public final C2540wx m9621J() {
        return this.f7093l;
    }

    public final C2540wx m9622K() {
        return this.f7095n;
    }

    public final C2540wx m9623L() {
        return this.f7090i;
    }

    public final C2540wx m9624M() {
        return this.f7092k;
    }

    public final C2540wx m9625N() {
        return this.f7091j;
    }

    public final String m9626O() {
        Pair pairM8810a;
        if (mo351i().f5555f == null || (pairM8810a = mo351i().f5555f.m8810a()) == null || pairM8810a == C1755fy.f5550B) {
            return null;
        }
        return String.valueOf(pairM8810a.second) + ":" + ((String) pairM8810a.first);
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    @Override
    public final /* bridge */ C1755fy mo351i() {
        return super.mo351i();
    }

    @Override
    public final /* bridge */ C2514wG mo352j() {
        return super.mo352j();
    }

    @Override
    public final /* bridge */ void mo353k() {
        super.mo353k();
    }

    @Override
    public final /* bridge */ C1662dz mo354l() {
        return super.mo354l();
    }

    @Override
    public final /* bridge */ void mo355m() {
        super.mo355m();
    }

    @Override
    public final /* bridge */ void mo356n() {
        super.mo356n();
    }

    @Override
    public final boolean mo357t() {
        return false;
    }

    public final void m9627y(int i, String str) {
        Log.println(i, m9611P(), str);
    }

    public final void m9628z(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        String str2;
        if (!z && m9616C(i)) {
            m9627y(i, m9615x(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        AbstractC1085Xi.m4801j(str);
        C1662dz c1662dzM9225G = this.f8058a.m9225G();
        if (c1662dzM9225G == null) {
            str2 = "Scheduler not set. Not logging error/warn";
        } else {
            if (c1662dzM9225G.m10439s()) {
                if (i < 0) {
                    i = 0;
                }
                if (i >= 9) {
                    i = 8;
                }
                c1662dzM9225G.m7374C(new RunnableC2632yx(this, i, str, obj, obj2, obj3));
                return;
            }
            str2 = "Scheduler not initialized. Not logging error/warn";
        }
        m9627y(6, str2);
    }
}
