package p000;

import android.content.Context;

/* loaded from: classes.dex */
public final class C2588xz extends AbstractC2646zA {

    public final Context f8039a;

    public final InterfaceC0813Rm f8040b;

    public C2588xz(Context context, InterfaceC0813Rm interfaceC0813Rm) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.f8039a = context;
        this.f8040b = interfaceC0813Rm;
    }

    @Override
    public final Context mo10825a() {
        return this.f8039a;
    }

    @Override
    public final InterfaceC0813Rm mo10826b() {
        return this.f8040b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2646zA) {
            AbstractC2646zA abstractC2646zA = (AbstractC2646zA) obj;
            if (this.f8039a.equals(abstractC2646zA.mo10825a())) {
                InterfaceC0813Rm interfaceC0813Rm = this.f8040b;
                InterfaceC0813Rm interfaceC0813RmMo10826b = abstractC2646zA.mo10826b();
                if (interfaceC0813Rm != null ? interfaceC0813Rm.equals(interfaceC0813RmMo10826b) : interfaceC0813RmMo10826b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f8039a.hashCode() ^ 1000003) * 1000003;
        InterfaceC0813Rm interfaceC0813Rm = this.f8040b;
        return iHashCode ^ (interfaceC0813Rm == null ? 0 : interfaceC0813Rm.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.f8039a) + ", hermeticFileOverrides=" + String.valueOf(this.f8040b) + "}";
    }
}
