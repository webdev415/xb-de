package p000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class C0571MI extends AbstractC0450Jq {

    public boolean f1804n;

    public boolean f1805o;

    public final C1029WH f1806p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0571MI(C1029WH c1029wh, boolean z, boolean z2) {
        super("log");
        this.f1806p = c1029wh;
        this.f1804n = z;
        this.f1805o = z2;
    }

    @Override
    public final InterfaceC0909Tq mo1366b(C2357sy c2357sy, List list) {
        List arrayList;
        InterfaceC0800RI interfaceC0800RI;
        AbstractC1145Yw.m5003j("log", 1, list);
        if (list.size() == 1) {
            this.f1806p.f3049n.mo3797a(EnumC0019AI.INFO, c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo154h(), Collections.emptyList(), this.f1804n, this.f1805o);
        } else {
            EnumC0019AI enumC0019AIM113c = EnumC0019AI.m113c(AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue()));
            String strMo154h = c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo154h();
            if (list.size() == 2) {
                interfaceC0800RI = this.f1806p.f3049n;
                arrayList = Collections.emptyList();
            } else {
                arrayList = new ArrayList<>();
                for (int i = 2; i < Math.min(list.size(), 5); i++) {
                    arrayList.add(c2357sy.m9631c((InterfaceC0909Tq) list.get(i)).mo154h());
                }
                interfaceC0800RI = this.f1806p.f3049n;
            }
            interfaceC0800RI.mo3797a(enumC0019AIM113c, strMo154h, arrayList, this.f1804n, this.f1805o);
        }
        return InterfaceC0909Tq.f2785d;
    }
}
