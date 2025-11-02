package p000;

/* loaded from: classes.dex */
public abstract class AbstractC1878ig extends AbstractC0283G6 {
    public abstract AbstractC1878ig mo3817W();

    public final String m7964X() {
        AbstractC1878ig abstractC1878igMo3817W;
        AbstractC1878ig abstractC1878igM5025c = C1158Z8.m5025c();
        if (this == abstractC1878igM5025c) {
            return "Dispatchers.Main";
        }
        try {
            abstractC1878igMo3817W = abstractC1878igM5025c.mo3817W();
        } catch (UnsupportedOperationException unused) {
            abstractC1878igMo3817W = null;
        }
        if (this == abstractC1878igMo3817W) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
