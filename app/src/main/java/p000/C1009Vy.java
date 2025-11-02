package p000;

import java.util.List;

/* loaded from: classes.dex */
public final class C1009Vy implements InterfaceC0800RI {

    public final C0596My f3012a;

    public C1009Vy(C0596My c0596My) {
        this.f3012a = c0596My;
    }

    @Override
    public final void mo3797a(EnumC0019AI enumC0019AI, String str, List list, boolean z, boolean z2) {
        C2540wx c2540wxM9617F;
        int i = AbstractC1193Zy.f3478a[enumC0019AI.ordinal()];
        if (i == 1) {
            c2540wxM9617F = this.f3012a.mo349g().m9617F();
        } else if (i == 2) {
            C2356sx c2356sxMo349g = this.f3012a.mo349g();
            c2540wxM9617F = z ? c2356sxMo349g.m9620I() : !z2 ? c2356sxMo349g.m9619H() : c2356sxMo349g.m9618G();
        } else if (i != 3) {
            c2540wxM9617F = i != 4 ? this.f3012a.mo349g().m9621J() : this.f3012a.mo349g().m9622K();
        } else {
            C2356sx c2356sxMo349g2 = this.f3012a.mo349g();
            c2540wxM9617F = z ? c2356sxMo349g2.m9625N() : !z2 ? c2356sxMo349g2.m9624M() : c2356sxMo349g2.m9623L();
        }
        int size = list.size();
        if (size == 1) {
            c2540wxM9617F.m10617b(str, list.get(0));
            return;
        }
        if (size == 2) {
            c2540wxM9617F.m10618c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            c2540wxM9617F.m10616a(str);
        } else {
            c2540wxM9617F.m10619d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
