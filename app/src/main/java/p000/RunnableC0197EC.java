package p000;

import android.net.Uri;

public final class RunnableC0197EC implements Runnable {

    public final boolean f468l;

    public final Uri f469m;

    public final String f470n;

    public final String f471o;

    public final C2602yC f472p;

    public RunnableC0197EC(C2602yC c2602yC, boolean z, Uri uri, String str, String str2) {
        this.f468l = z;
        this.f469m = uri;
        this.f470n = str;
        this.f471o = str2;
        this.f472p = c2602yC;
    }

    @Override
    public final void run() {
        C2602yC.m10838a(this.f472p, this.f468l, this.f469m, this.f470n, this.f471o);
    }
}
