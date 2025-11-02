package p000;

import java.util.List;

public final class C1029WH extends AbstractC0450Jq {

    public final InterfaceC0800RI f3049n;

    public C1029WH(InterfaceC0800RI interfaceC0800RI) {
        super("internal.logger");
        this.f3049n = interfaceC0800RI;
        this.f1461m.put("log", new C0571MI(this, false, true));
        this.f1461m.put("silent", new C2239qH(this, "silent"));
        ((AbstractC0450Jq) this.f1461m.get("silent")).mo1619p("log", new C0571MI(this, true, true));
        this.f1461m.put("unmonitored", new C0387II(this, "unmonitored"));
        ((AbstractC0450Jq) this.f1461m.get("unmonitored")).mo1619p("log", new C0571MI(this, false, false));
    }

    @Override
    public final InterfaceC0909Tq mo1366b(C2357sy c2357sy, List list) {
        return InterfaceC0909Tq.f2785d;
    }
}
