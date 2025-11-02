package p000;

/* loaded from: classes.dex */
public final class RunnableC0872Sz implements Runnable {

    public final String f2678l;

    public final String f2679m;

    public final String f2680n;

    public final long f2681o;

    public final BinderC0183Dz f2682p;

    public RunnableC0872Sz(BinderC0183Dz binderC0183Dz, String str, String str2, String str3, long j) {
        this.f2678l = str;
        this.f2679m = str2;
        this.f2680n = str3;
        this.f2681o = j;
        this.f2682p = binderC0183Dz;
    }

    @Override
    public final void run() {
        String str = this.f2678l;
        if (str == null) {
            this.f2682p.f441c.m960v(this.f2679m, null);
        } else {
            this.f2682p.f441c.m960v(this.f2679m, new C1162ZC(this.f2680n, str, this.f2681o));
        }
    }
}
