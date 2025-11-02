package p000;

public final class C0267Fr {

    public final String f683a;

    public final String f684b;

    public final long f685c;

    public final long f686d;

    public final long f687e;

    public final long f688f;

    public final long f689g;

    public final Long f690h;

    public final Long f691i;

    public final Long f692j;

    public final Boolean f693k;

    public C0267Fr(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4795d(str2);
        AbstractC1085Xi.m4792a(j >= 0);
        AbstractC1085Xi.m4792a(j2 >= 0);
        AbstractC1085Xi.m4792a(j3 >= 0);
        AbstractC1085Xi.m4792a(j5 >= 0);
        this.f683a = str;
        this.f684b = str2;
        this.f685c = j;
        this.f686d = j2;
        this.f687e = j3;
        this.f688f = j4;
        this.f689g = j5;
        this.f690h = l;
        this.f691i = l2;
        this.f692j = l3;
        this.f693k = bool;
    }

    public final C0267Fr m1291a(long j) {
        return new C0267Fr(this.f683a, this.f684b, this.f685c, this.f686d, this.f687e, j, this.f689g, this.f690h, this.f691i, this.f692j, this.f693k);
    }

    public final C0267Fr m1292b(long j, long j2) {
        return new C0267Fr(this.f683a, this.f684b, this.f685c, this.f686d, this.f687e, this.f688f, j, Long.valueOf(j2), this.f691i, this.f692j, this.f693k);
    }

    public final C0267Fr m1293c(Long l, Long l2, Boolean bool) {
        return new C0267Fr(this.f683a, this.f684b, this.f685c, this.f686d, this.f687e, this.f688f, this.f689g, this.f690h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    public C0267Fr(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        this(str, str2, 0L, 0L, 0L, j3, 0L, null, null, null, null);
    }
}
