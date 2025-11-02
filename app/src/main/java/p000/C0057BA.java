package p000;

import android.net.Uri;

/* loaded from: classes.dex */
public final class C0057BA {

    public final String f139a;

    public final Uri f140b;

    public final String f141c;

    public final String f142d;

    public final boolean f143e;

    public final boolean f144f;

    public final boolean f145g;

    public final boolean f146h;

    public final InterfaceC2289rc f147i;

    public C0057BA(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public final AbstractC2001lA m216a(String str, double d) {
        return AbstractC2001lA.m8362g(this, str, Double.valueOf(-3.0d), true);
    }

    public final AbstractC2001lA m217b(String str, long j) {
        return AbstractC2001lA.m8363h(this, str, Long.valueOf(j), true);
    }

    public final AbstractC2001lA m218c(String str, String str2) {
        return AbstractC2001lA.m8364i(this, str, str2, true);
    }

    public final AbstractC2001lA m219d(String str, boolean z) {
        return AbstractC2001lA.m8361f(this, str, Boolean.valueOf(z), true);
    }

    public final C0057BA m220e() {
        return new C0057BA(this.f139a, this.f140b, this.f141c, this.f142d, this.f143e, this.f144f, true, this.f146h, this.f147i);
    }

    public final C0057BA m221f() {
        if (!this.f141c.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        InterfaceC2289rc interfaceC2289rc = this.f147i;
        if (interfaceC2289rc == null) {
            return new C0057BA(this.f139a, this.f140b, this.f141c, this.f142d, true, this.f144f, this.f145g, this.f146h, interfaceC2289rc);
        }
        throw new IllegalStateException("Cannot skip gservices both always and conditionally");
    }

    public C0057BA(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, InterfaceC2289rc interfaceC2289rc) {
        this.f139a = str;
        this.f140b = uri;
        this.f141c = str2;
        this.f142d = str3;
        this.f143e = z;
        this.f144f = z2;
        this.f145g = z3;
        this.f146h = z4;
        this.f147i = interfaceC2289rc;
    }
}
