package p000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class C1001Vq extends AbstractC0450Jq implements InterfaceC0358Hq {

    public final List f3001n;

    public final List f3002o;

    public C2357sy f3003p;

    public C1001Vq(String str, List list, List list2, C2357sy c2357sy) {
        super(str);
        this.f3001n = new ArrayList<>();
        this.f3003p = c2357sy;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f3001n.add(((InterfaceC0909Tq) it.next()).mo154h());
            }
        }
        this.f3002o = new ArrayList<>(list2);
    }

    @Override
    public final InterfaceC0909Tq mo1366b(C2357sy c2357sy, List list) {
        String str;
        InterfaceC0909Tq interfaceC0909TqM9631c;
        C2357sy c2357syM9632d = this.f3003p.m9632d();
        for (int i = 0; i < this.f3001n.size(); i++) {
            if (i < list.size()) {
                str = (String) this.f3001n.get(i);
                interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(i));
            } else {
                str = (String) this.f3001n.get(i);
                interfaceC0909TqM9631c = InterfaceC0909Tq.f2785d;
            }
            c2357syM9632d.m9633e(str, interfaceC0909TqM9631c);
        }
        for (InterfaceC0909Tq interfaceC0909Tq : this.f3002o) {
            InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357syM9632d.m9631c(interfaceC0909Tq);
            if (interfaceC0909TqM9631c2 instanceof C1185Zq) {
                interfaceC0909TqM9631c2 = c2357syM9632d.m9631c(interfaceC0909Tq);
            }
            if (interfaceC0909TqM9631c2 instanceof C0174Dq) {
                return ((C0174Dq) interfaceC0909TqM9631c2).m780a();
            }
        }
        return InterfaceC0909Tq.f2785d;
    }

    @Override
    public final InterfaceC0909Tq mo151c() {
        return new C1001Vq(this);
    }

    public C1001Vq(C1001Vq c1001Vq) {
        super(c1001Vq.f1460l);
        ArrayList arrayList = new ArrayList<>(c1001Vq.f3001n.size());
        this.f3001n = arrayList;
        arrayList.addAll(c1001Vq.f3001n);
        ArrayList arrayList2 = new ArrayList<>(c1001Vq.f3002o.size());
        this.f3002o = arrayList2;
        arrayList2.addAll(c1001Vq.f3002o);
        this.f3003p = c1001Vq.f3003p;
    }
}
