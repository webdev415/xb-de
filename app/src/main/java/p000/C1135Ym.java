package p000;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class C1135Ym implements InterfaceC0071Bf, Serializable {

    public InterfaceC0894Tb f3358l;

    public volatile Object f3359m;

    public final Object f3360n;

    public C1135Ym(InterfaceC0894Tb interfaceC0894Tb, Object obj) {
        AbstractC0116Ce.m476e(interfaceC0894Tb, "initializer");
        this.f3358l = interfaceC0894Tb;
        this.f3359m = C0906Tn.f2781a;
        this.f3360n = obj == null ? this : obj;
    }

    public boolean m4989a() {
        return this.f3359m != C0906Tn.f2781a;
    }

    @Override
    public Object getValue() {
        Object objMo4135c;
        Object obj = this.f3359m;
        C0906Tn c0906Tn = C0906Tn.f2781a;
        if (obj != c0906Tn) {
            return obj;
        }
        synchronized (this.f3360n) {
            objMo4135c = this.f3359m;
            if (objMo4135c == c0906Tn) {
                InterfaceC0894Tb interfaceC0894Tb = this.f3358l;
                AbstractC0116Ce.m473b(interfaceC0894Tb);
                objMo4135c = interfaceC0894Tb.mo4135c();
                this.f3359m = objMo4135c;
                this.f3358l = null;
            }
        }
        return objMo4135c;
    }

    public String toString() {
        return m4989a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public C1135Ym(InterfaceC0894Tb interfaceC0894Tb, Object obj, int i, AbstractC0881T7 abstractC0881T7) {
        this(interfaceC0894Tb, (i & 2) != 0 ? null : obj);
    }
}
