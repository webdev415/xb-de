package p000;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;

public class C0742Q5 implements InterfaceC0833S5 {
    public static Object m3627c(String str, Component component, InterfaceC0466K5 interfaceC0466K5) {
        try {
            AbstractC2380tb.m9702b(str);
            return component.m1804h().mo432a(interfaceC0466K5);
        } finally {
            AbstractC2380tb.m9701a();
        }
    }

    @Override
    public List mo3628a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList<>();
        for (final Component componentM1811T : componentRegistrar.getComponents()) {
            final String strM1805i = componentM1811T.m1805i();
            if (strM1805i != null) {
                componentM1811T = componentM1811T.m1811t(new InterfaceC0604N5() {
                    @Override
                    public final Object mo432a(InterfaceC0466K5 interfaceC0466K5) {
                        return C0742Q5.m3627c(strM1805i, componentM1811T, interfaceC0466K5);
                    }
                });
            }
            arrayList.add(componentM1811T);
        }
        return arrayList;
    }
}
