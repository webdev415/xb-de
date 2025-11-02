package p000;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public final class C2081mz extends FutureTask implements Comparable {

    public final long f6278l;

    public final boolean f6279m;

    public final String f6280n;

    public final C1662dz f6281o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2081mz(C1662dz c1662dz, Runnable runnable, boolean z, String str) {
        super(AbstractC1050Wt.m4606a().mo4993b(runnable), null);
        this.f6281o = c1662dz;
        AbstractC1085Xi.m4801j(str);
        long andIncrement = C1662dz.f5351l.getAndIncrement();
        this.f6278l = andIncrement;
        this.f6280n = str;
        this.f6279m = z;
        if (andIncrement == Long.MAX_VALUE) {
            c1662dz.mo349g().m9618G().m10616a("Tasks index overflow");
        }
    }

    @Override
    public final int compareTo(Object obj) {
        C2081mz c2081mz = (C2081mz) obj;
        boolean z = this.f6279m;
        if (z != c2081mz.f6279m) {
            return z ? -1 : 1;
        }
        long j = this.f6278l;
        long j2 = c2081mz.f6278l;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.f6281o.mo349g().m9620I().m10617b("Two tasks share the same index. index", Long.valueOf(this.f6278l));
        return 0;
    }

    @Override
    public final void setException(Throwable th) {
        this.f6281o.mo349g().m9618G().m10617b(this.f6280n, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2081mz(C1662dz c1662dz, Callable callable, boolean z, String str) {
        super(AbstractC1050Wt.m4606a().mo4992a(callable));
        this.f6281o = c1662dz;
        AbstractC1085Xi.m4801j(str);
        long andIncrement = C1662dz.f5351l.getAndIncrement();
        this.f6278l = andIncrement;
        this.f6280n = str;
        this.f6279m = z;
        if (andIncrement == Long.MAX_VALUE) {
            c1662dz.mo349g().m9618G().m10616a("Tasks index overflow");
        }
    }
}
