package p000;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class C1773gF extends C2421uF {

    public final AbstractC1118YE f5616m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1773gF(AbstractC1118YE abstractC1118YE) {
        super(abstractC1118YE);
        this.f5616m = abstractC1118YE;
    }

    @Override
    public final Iterator iterator() {
        return new C1358cF(this.f5616m);
    }
}
