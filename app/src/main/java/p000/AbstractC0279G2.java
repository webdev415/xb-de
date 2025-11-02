package p000;

import java.util.List;

public abstract class AbstractC0279G2 {
    public static C0233F2 m1320a(List list) {
        int size = list.size() << 1;
        int i = size - 1;
        if (((C0342Ha) list.get(list.size() - 1)).m1563c() == null) {
            i = size - 2;
        }
        C0233F2 c0233f2 = new C0233F2(i * 12);
        int i2 = 0;
        int iM7871b = ((C0342Ha) list.get(0)).m1563c().m7871b();
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & iM7871b) != 0) {
                c0233f2.m1197u(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            C0342Ha c0342Ha = (C0342Ha) list.get(i4);
            int iM7871b2 = c0342Ha.m1562b().m7871b();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & iM7871b2) != 0) {
                    c0233f2.m1197u(i2);
                }
                i2++;
            }
            if (c0342Ha.m1563c() != null) {
                int iM7871b3 = c0342Ha.m1563c().m7871b();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & iM7871b3) != 0) {
                        c0233f2.m1197u(i2);
                    }
                    i2++;
                }
            }
        }
        return c0233f2;
    }
}
