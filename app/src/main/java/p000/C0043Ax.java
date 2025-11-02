package p000;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class C0043Ax {

    public String f95a;

    public String f96b;

    public long f97c;

    public Bundle f98d;

    public C0043Ax(String str, String str2, Bundle bundle, long j) {
        this.f95a = str;
        this.f96b = str2;
        this.f98d = bundle == null ? new Bundle() : bundle;
        this.f97c = j;
    }

    public static C0043Ax m169b(C0635Nr c0635Nr) {
        return new C0043Ax(c0635Nr.f1974l, c0635Nr.f1976n, c0635Nr.f1975m.m785h(), c0635Nr.f1977o);
    }

    public final C0635Nr m170a() {
        return new C0635Nr(this.f95a, new C0175Dr(new Bundle(this.f98d)), this.f96b, this.f97c);
    }

    public final String toString() {
        return "origin=" + this.f96b + ",name=" + this.f95a + ",params=" + String.valueOf(this.f98d);
    }
}
