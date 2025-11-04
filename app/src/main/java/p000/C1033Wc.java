package p000;

import p000.C0096C3;

public final class C1033Wc {

    public static final C0096C3 f3052d;

    public static final C0096C3 f3053e;

    public static final C0096C3 f3054f;

    public static final C0096C3 f3055g;

    public static final C0096C3 f3056h;

    public static final C0096C3 f3057i;

    public static final a f3058j = new a(null);

    public final int f3059a;

    public final C0096C3 f3060b;

    public final C0096C3 f3061c;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    static {
        C0096C3.a aVar = C0096C3.f235p;
        f3052d = aVar.m395c(":");
        f3053e = aVar.m395c(":status");
        f3054f = aVar.m395c(":method");
        f3055g = aVar.m395c(":path");
        f3056h = aVar.m395c(":scheme");
        f3057i = aVar.m395c(":authority");
    }

    public C1033Wc(C0096C3 c0096c3, C0096C3 c0096c32) {
        AbstractC0116Ce.m476e(c0096c3, "name");
        AbstractC0116Ce.m476e(c0096c32, "value");
        this.f3060b = c0096c3;
        this.f3061c = c0096c32;
        this.f3059a = c0096c3.m387u() + 32 + c0096c32.m387u();
    }

    public final C0096C3 m4491a() {
        return this.f3060b;
    }

    public final C0096C3 m4492b() {
        return this.f3061c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1033Wc)) {
            return false;
        }
        C1033Wc c1033Wc = (C1033Wc) obj;
        return AbstractC0116Ce.m472a(this.f3060b, c1033Wc.f3060b) && AbstractC0116Ce.m472a(this.f3061c, c1033Wc.f3061c);
    }

    public int hashCode() {
        C0096C3 c0096c3 = this.f3060b;
        int iHashCode = (c0096c3 != null ? c0096c3.hashCode() : 0) * 31;
        C0096C3 c0096c32 = this.f3061c;
        return iHashCode + (c0096c32 != null ? c0096c32.hashCode() : 0);
    }

    public String toString() {
        return this.f3060b.m390x() + ": " + this.f3061c.m390x();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1033Wc(C0096C3 c0096c3, String str) {
        this(c0096c3, C0096C3.f235p.m395c(str));
        AbstractC0116Ce.m476e(c0096c3, "name");
        AbstractC0116Ce.m476e(str, "value");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1033Wc(String str, String str2) {
        AbstractC0116Ce.m476e(str, "name");
        AbstractC0116Ce.m476e(str2, "value");
        C0096C3.a aVar = C0096C3.f235p;
        this(aVar.m395c(str), aVar.m395c(str2));
    }
}
