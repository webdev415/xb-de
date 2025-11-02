package p000;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class C0429JE {

    public static final C0429JE f1310c = new C0429JE();

    public final ConcurrentMap f1312b = new ConcurrentHashMap();

    public final InterfaceC0934UE f1311a = new C0244FD();

    public static C0429JE m1871a() {
        return f1310c;
    }

    public final InterfaceC1026WE m1872b(Class cls) {
        AbstractC0932UC.m4210f(cls, "messageType");
        InterfaceC1026WE interfaceC1026WE = (InterfaceC1026WE) this.f1312b.get(cls);
        if (interfaceC1026WE != null) {
            return interfaceC1026WE;
        }
        InterfaceC1026WE interfaceC1026WEMo1214a = this.f1311a.mo1214a(cls);
        AbstractC0932UC.m4210f(cls, "messageType");
        AbstractC0932UC.m4210f(interfaceC1026WEMo1214a, "schema");
        InterfaceC1026WE interfaceC1026WE2 = (InterfaceC1026WE) this.f1312b.putIfAbsent(cls, interfaceC1026WEMo1214a);
        return interfaceC1026WE2 != null ? interfaceC1026WE2 : interfaceC1026WEMo1214a;
    }

    public final InterfaceC1026WE m1873c(Object obj) {
        return m1872b(obj.getClass());
    }
}
