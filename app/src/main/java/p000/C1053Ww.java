package p000;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class C1053Ww extends AbstractC0771Qp {

    public final AbstractC2454v2 f3160g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1053Ww(AbstractC2454v2 abstractC2454v2, int i, Bundle bundle) {
        super(abstractC2454v2, i, null);
        this.f3160g = abstractC2454v2;
    }

    @Override
    public final void mo1621f(C1717f6 c1717f6) {
        if (this.f3160g.m10290f() && AbstractC2454v2.m10276U(this.f3160g)) {
            AbstractC2454v2.m10273Q(this.f3160g, 16);
        } else {
            this.f3160g.f7641p.mo10308a(c1717f6);
            this.f3160g.m10306y(c1717f6);
        }
    }

    @Override
    public final boolean mo1622g() {
        this.f3160g.f7641p.mo10308a(C1717f6.f5480p);
        return true;
    }
}
