package p000;

/* loaded from: classes.dex */
public final class RunnableC2632yx implements Runnable {

    public final int f8157l;

    public final String f8158m;

    public final Object f8159n;

    public final Object f8160o;

    public final Object f8161p;

    public final C2356sx f8162q;

    public RunnableC2632yx(C2356sx c2356sx, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f8157l = i;
        this.f8158m = str;
        this.f8159n = obj;
        this.f8160o = obj2;
        this.f8161p = obj3;
        this.f8162q = c2356sx;
    }

    @Override
    public final void run() {
        C2356sx c2356sx;
        char c;
        C1755fy c1755fyM9224F = this.f8162q.f8058a.m9224F();
        if (!c1755fyM9224F.m10439s()) {
            this.f8162q.m9627y(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.f8162q.f7084c == 0) {
            if (this.f8162q.mo347e().m10820v()) {
                c2356sx = this.f8162q;
                c = 'C';
            } else {
                c2356sx = this.f8162q;
                c = 'c';
            }
            c2356sx.f7084c = c;
        }
        if (this.f8162q.f7085d < 0) {
            this.f8162q.f7085d = 102001L;
        }
        String strSubstring = "2" + "01VDIWEA?".charAt(this.f8157l) + this.f8162q.f7084c + this.f8162q.f7085d + ":" + C2356sx.m9615x(true, this.f8158m, this.f8159n, this.f8160o, this.f8161p);
        if (strSubstring.length() > 1024) {
            strSubstring = this.f8158m.substring(0, 1024);
        }
        C2126ny c2126ny = c1755fyM9224F.f5555f;
        if (c2126ny != null) {
            c2126ny.m8811b(strSubstring, 1L);
        }
    }
}
