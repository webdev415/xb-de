package p000;

import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class C1860i8 implements InterfaceC2347so {

    public final String f5787a;

    public final C0206Ec f5788b;

    public C1860i8(Set set, C0206Ec c0206Ec) {
        this.f5787a = m7875e(set);
        this.f5788b = c0206Ec;
    }

    public static C0420J5 m7873c() {
        return C0420J5.m1796e(InterfaceC2347so.class).m1813b(C0193E8.m876k(AbstractC0301Gf.class)).m1816e(new InterfaceC0604N5() {
            @Override
            public final Object mo432a(InterfaceC0466K5 interfaceC0466K5) {
                return C1860i8.m7874d(interfaceC0466K5);
            }
        }).m1814c();
    }

    public static InterfaceC2347so m7874d(InterfaceC0466K5 interfaceC0466K5) {
        return new C1860i8(interfaceC0466K5.m2286e(AbstractC0301Gf.class), C0206Ec.m1031a());
    }

    public static String m7875e(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC0301Gf abstractC0301Gf = (AbstractC0301Gf) it.next();
            sb.append(abstractC0301Gf.mo1395b());
            sb.append('/');
            sb.append(abstractC0301Gf.mo1396c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override
    public String mo7876a() {
        if (this.f5788b.m1032b().isEmpty()) {
            return this.f5787a;
        }
        return this.f5787a + ' ' + m7875e(this.f5788b.m1032b());
    }
}
