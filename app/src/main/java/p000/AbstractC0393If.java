package p000;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class AbstractC0393If {

    public interface a {
        String mo1701a(Object obj);
    }

    public static C0420J5 m1698b(String str, String str2) {
        return C0420J5.m1798l(AbstractC0301Gf.m1394a(str, str2), AbstractC0301Gf.class);
    }

    public static C0420J5 m1699c(final String str, final a aVar) {
        return C0420J5.m1799m(AbstractC0301Gf.class).m1813b(C0193E8.m874i(Context.class)).m1816e(new InterfaceC0604N5() {
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
