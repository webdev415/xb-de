package p000;

import android.graphics.Rect;
import java.util.List;

/* loaded from: classes.dex */
public class C1205a9 {

    public C1180Zl f3494a;

    public int f3495b;

    public boolean f3496c = false;

    public AbstractC1647dj f3497d = new C2426ub();

    public C1205a9(int i, C1180Zl c1180Zl) {
        this.f3495b = i;
        this.f3494a = c1180Zl;
    }

    public C1180Zl m5102a(List list, boolean z) {
        return this.f3497d.m7326b(list, m5103b(z));
    }

    public C1180Zl m5103b(boolean z) {
        C1180Zl c1180Zl = this.f3494a;
        if (c1180Zl == null) {
            return null;
        }
        return z ? c1180Zl.m5068e() : c1180Zl;
    }

    public int m5104c() {
        return this.f3495b;
    }

    public Rect m5105d(C1180Zl c1180Zl) {
        return this.f3497d.mo7328d(c1180Zl, this.f3494a);
    }

    public void m5106e(AbstractC1647dj abstractC1647dj) {
        this.f3497d = abstractC1647dj;
    }
}
