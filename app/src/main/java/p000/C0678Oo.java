package p000;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class C0678Oo {

    public final Map f2060a = new LinkedHashMap();

    public final void m3439a() {
        Iterator it = this.f2060a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0586Mo) it.next()).m2966a();
        }
        this.f2060a.clear();
    }

    public final AbstractC0586Mo m3440b(String str) {
        AbstractC0116Ce.m476e(str, "key");
        return (AbstractC0586Mo) this.f2060a.get(str);
    }

    public final void m3441c(String str, AbstractC0586Mo abstractC0586Mo) {
        AbstractC0116Ce.m476e(str, "key");
        AbstractC0116Ce.m476e(abstractC0586Mo, "viewModel");
        AbstractC0586Mo abstractC0586Mo2 = (AbstractC0586Mo) this.f2060a.put(str, abstractC0586Mo);
        if (abstractC0586Mo2 != null) {
            abstractC0586Mo2.mo2653c();
        }
    }
}
