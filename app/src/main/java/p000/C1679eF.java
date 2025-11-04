package p000;

import java.util.Iterator;
import java.util.Map;

public final class C1679eF extends AbstractC1118YE {
    public C1679eF() {
        super();
    }

    @Override
    public final void mo4916l() {
        if (!m4917n()) {
            if (m4909a() > 0) {
                AbstractC2524wh.m10586a(m4912f(0).getKey());
                throw null;
            }
            Iterator it = m4913g().iterator();
            if (it.hasNext()) {
                AbstractC2524wh.m10586a(((Entry) it.next()).getKey());
                throw null;
            }
        }
        super.mo4916l();
    }
}
