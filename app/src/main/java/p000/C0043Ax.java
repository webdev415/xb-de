package p000;

import android.os.Bundle;

public final class C0043Ax {

    public String name;

    public String origin;

    public long f97c;

    public Bundle params;

    public C0043Ax(String str, String str2, Bundle bundle, long j) {
        this.name = str;
        this.origin = str2;
        this.params = bundle == null ? new Bundle() : bundle;
        this.f97c = j;
    }

    public static C0043Ax m169b(C0635Nr c0635Nr) {
        return new C0043Ax(c0635Nr.name, c0635Nr.origin, c0635Nr.params.m785h(), c0635Nr.f1977o);
    }

    public final C0635Nr m170a() {
        return new C0635Nr(this.name, new C0175Dr(new Bundle(this.params)), this.origin, this.f97c);
    }

    public final String toString() {
        return "origin=" + this.origin + ",name=" + this.name + ",params=" + this.params;
    }
}
