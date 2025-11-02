package p000;

import java.util.List;

/* loaded from: classes.dex */
public final class C0589Mr extends AbstractC1935jr {
    public C0589Mr() {
        this.f5966a.add(EnumC2259qs.AND);
        this.f5966a.add(EnumC2259qs.NOT);
        this.f5966a.add(EnumC2259qs.OR);
    }

    @Override
    public final InterfaceC0909Tq mo160b(String str, C2357sy c2357sy, List list) {
        int i = AbstractC0864Sr.f2677a[AbstractC1145Yw.m4998e(str).ordinal()];
        if (i == 1) {
            AbstractC1145Yw.m5000g(EnumC2259qs.AND, 2, list);
            InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
            if (!interfaceC0909TqM9631c.mo152d().booleanValue()) {
                return interfaceC0909TqM9631c;
            }
        } else {
            if (i == 2) {
                AbstractC1145Yw.m5000g(EnumC2259qs.NOT, 1, list);
                return new C2395tq(Boolean.valueOf(!c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo152d().booleanValue()));
            }
            if (i != 3) {
                return super.m8207a(str);
            }
            AbstractC1145Yw.m5000g(EnumC2259qs.OR, 2, list);
            InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
            if (interfaceC0909TqM9631c2.mo152d().booleanValue()) {
                return interfaceC0909TqM9631c2;
            }
        }
        return c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
    }
}
