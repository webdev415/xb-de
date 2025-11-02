package p000;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;

public class C0742Q5 implements InterfaceC0833S5 {
    public static Object m3627c(String str, C0420J5 c0420j5, InterfaceC0466K5 interfaceC0466K5) {
        try {
            AbstractC2380tb.m9702b(str);
            return c0420j5.m1804h().mo432a(interfaceC0466K5);
        } finally {
            AbstractC2380tb.m9701a();
        }
    }

    @Override
    public List mo3628a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList<>();
        for (final C0420J5 c0420j5M1811t : componentRegistrar.getComponents()) {
            final String strM1805i = c0420j5M1811t.m1805i();
            if (strM1805i != null) {
                c0420j5M1811t = c0420j5M1811t.m1811t(new InterfaceC0604N5() {
                    @Override
                    public final Object mo432a(InterfaceC0466K5 interfaceC0466K5) {
                        return C0742Q5.m3627c(strM1805i, c0420j5M1811t, interfaceC0466K5);
                    }
                });
            }
            arrayList.add(c0420j5M1811t);
        }
        return arrayList;
    }
}
