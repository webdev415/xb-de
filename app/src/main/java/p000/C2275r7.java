package p000;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class C2275r7 {

    public static C2275r7 f6898e;

    public Context f6899a = null;

    public ArrayList f6900b = null;

    public ArrayList f6901c = new ArrayList<>();

    public InterfaceC0094C1 f6902d = null;

    public static C2275r7 m9348e() {
        if (f6898e == null) {
            f6898e = new C2275r7();
        }
        return f6898e;
    }

    public void m9349a(InterfaceC2183p7 interfaceC2183p7, boolean z, InterfaceC2229q7 interfaceC2229q7, HashMap map) {
        if (interfaceC2183p7 != null) {
            this.f6902d.mo364a(interfaceC2183p7.mo9039e(), z, interfaceC2229q7, map);
        }
    }

    public void m9350b(String str, boolean z, InterfaceC2229q7 interfaceC2229q7, HashMap map) {
        m9349a(m9352d(str), z, interfaceC2229q7, map);
    }

    public InterfaceC2183p7 m9351c(String str) {
        InterfaceC2183p7 interfaceC2183p7 = null;
        try {
            Iterator it = this.f6900b.iterator();
            while (it.hasNext()) {
                InterfaceC2183p7 interfaceC2183p72 = (InterfaceC2183p7) it.next();
                if (interfaceC2183p72.mo61f().equals(str)) {
                    InterfaceC2183p7 interfaceC2183p73 = (InterfaceC2183p7) interfaceC2183p72.getClass().newInstance();
                    try {
                        interfaceC2183p73.mo9042i(this.f6899a);
                        interfaceC2183p7 = interfaceC2183p73;
                    } catch (Exception e) {
                        e = e;
                        interfaceC2183p7 = interfaceC2183p73;
                        e.printStackTrace();
                        return interfaceC2183p7;
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return interfaceC2183p7;
    }

    public synchronized InterfaceC2183p7 m9352d(String str) {
        try {
            Iterator it = this.f6901c.iterator();
            while (it.hasNext()) {
                InterfaceC2183p7 interfaceC2183p7 = (InterfaceC2183p7) it.next();
                if (interfaceC2183p7.mo8842b().equals(str)) {
                    return interfaceC2183p7;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void m9353f(Context context) {
        this.f6900b = new ArrayList<>();
        this.f6902d = new C0140D1(context);
        this.f6899a = context;
    }

    public void m9354g(String str) {
        m9355h(str, null);
    }

    public void m9355h(String str, InterfaceC2229q7 interfaceC2229q7) {
        m9350b(str, false, interfaceC2229q7, null);
    }

    public InterfaceC2183p7 m9356i(String str) {
        try {
            Iterator it = this.f6901c.iterator();
            while (it.hasNext()) {
                InterfaceC2183p7 interfaceC2183p7 = (InterfaceC2183p7) it.next();
                if (interfaceC2183p7.mo9039e().equals(str)) {
                    return interfaceC2183p7;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void m9357j(InterfaceC2183p7 interfaceC2183p7) {
        if (interfaceC2183p7 == null) {
            return;
        }
        InterfaceC2183p7 interfaceC2183p7M9352d = m9352d(interfaceC2183p7.mo8842b());
        if (interfaceC2183p7M9352d != null) {
            interfaceC2183p7M9352d.mo9036a(interfaceC2183p7.mo9039e());
        } else {
            this.f6901c.add(interfaceC2183p7);
        }
    }

    public void m9358k(InterfaceC2183p7 interfaceC2183p7) {
        this.f6900b.add(interfaceC2183p7);
    }
}
