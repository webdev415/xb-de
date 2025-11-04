package p000;

import android.content.Context;

public abstract class AbstractC0393If {

    public interface a {
        String mo1701a(Object obj);
    }

    public static Component m1698b(String str, String str2) {
        return Component.m1798l(AbstractC0301Gf.m1394a(str, str2), AbstractC0301Gf.class);
    }

    public static Component m1699c(final String str, final a aVar) {
        return Component.m1799m(AbstractC0301Gf.class).m1813b(Dependency.m874i(Context.class)).m1816e(new InterfaceC0604N5() {
            @Override
            public final Object mo432a(InterfaceC0466K5 interfaceC0466K5) {
                return AbstractC0393If.m1700d(str, aVar, interfaceC0466K5);
            }
        }).m1814c();
    }

    public static AbstractC0301Gf m1700d(String str, a aVar, InterfaceC0466K5 interfaceC0466K5) {
        return AbstractC0301Gf.m1394a(str, aVar.mo1701a((Context) interfaceC0466K5.mo2282a(Context.class)));
    }
}
