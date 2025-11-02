package p000;

import java.util.List;

/* loaded from: classes.dex */
public final class C0523LG extends AbstractC0450Jq {

    public final InterfaceC0706PF f1702n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0523LG(C0382ID c0382id, String str, InterfaceC0706PF interfaceC0706PF) {
        super(str);
        this.f1702n = interfaceC0706PF;
    }

    @Override
    public final InterfaceC0909Tq mo1366b(C2357sy c2357sy, List list) {
        AbstractC1145Yw.m4999f("getValue", 2, list);
        InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
        InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
        String strMo3539g = this.f1702n.mo3539g(interfaceC0909TqM9631c.mo154h());
        return strMo3539g != null ? new C1093Xq(strMo3539g) : interfaceC0909TqM9631c2;
    }
}
