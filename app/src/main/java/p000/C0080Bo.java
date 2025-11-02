package p000;

/* loaded from: classes.dex */
public final class C0080Bo {

    public static final C0080Bo[] f198h = m327a();

    public final int f199a;

    public final int f200b;

    public final int f201c;

    public final int f202d;

    public final int f203e;

    public final c f204f;

    public final int f205g;

    public static final class b {

        public final int f206a;

        public final int f207b;

        public b(int i, int i2) {
            this.f206a = i;
            this.f207b = i2;
        }

        public int m336a() {
            return this.f206a;
        }

        public int m337b() {
            return this.f207b;
        }
    }

    public C0080Bo(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.f199a = i;
        this.f200b = i2;
        this.f201c = i3;
        this.f202d = i4;
        this.f203e = i5;
        this.f204f = cVar;
        int iM339b = cVar.m339b();
        int iM336a = 0;
        for (b bVar : cVar.m338a()) {
            iM336a += bVar.m336a() * (bVar.m337b() + iM339b);
        }
        this.f205g = iM336a;
    }

    public static C0080Bo[] m327a() {
        int i = 1;
        int i2 = 5;
        C0080Bo c0080Bo = new C0080Bo(1, 10, 10, 8, 8, new c(i2, new b(i, 3)));
        C0080Bo c0080Bo2 = new C0080Bo(2, 12, 12, 10, 10, new c(7, new b(i, i2)));
        C0080Bo c0080Bo3 = new C0080Bo(3, 14, 14, 12, 12, new c(10, new b(i, 8)));
        int i3 = 12;
        C0080Bo c0080Bo4 = new C0080Bo(4, 16, 16, 14, 14, new c(i3, new b(i, i3)));
        int i4 = 18;
        C0080Bo c0080Bo5 = new C0080Bo(5, 18, 18, 16, 16, new c(14, new b(i, i4)));
        C0080Bo c0080Bo6 = new C0080Bo(6, 20, 20, 18, 18, new c(i4, new b(i, 22)));
        C0080Bo c0080Bo7 = new C0080Bo(7, 22, 22, 20, 20, new c(20, new b(i, 30)));
        int i5 = 36;
        C0080Bo c0080Bo8 = new C0080Bo(8, 24, 24, 22, 22, new c(24, new b(i, i5)));
        C0080Bo c0080Bo9 = new C0080Bo(9, 26, 26, 24, 24, new c(28, new b(i, 44)));
        C0080Bo c0080Bo10 = new C0080Bo(10, 32, 32, 14, 14, new c(i5, new b(i, 62)));
        int i6 = 42;
        int i7 = 56;
        int i8 = 2;
        int i9 = 4;
        return new C0080Bo[]{c0080Bo, c0080Bo2, c0080Bo3, c0080Bo4, c0080Bo5, c0080Bo6, c0080Bo7, c0080Bo8, c0080Bo9, c0080Bo10, new C0080Bo(11, 36, 36, 16, 16, new c(i6, new b(i, 86))), new C0080Bo(12, 40, 40, 18, 18, new c(48, new b(i, 114))), new C0080Bo(13, 44, 44, 20, 20, new c(i7, new b(i, 144))), new C0080Bo(14, 48, 48, 22, 22, new c(68, new b(i, 174))), new C0080Bo(15, 52, 52, 24, 24, new c(i6, new b(i8, 102))), new C0080Bo(16, 64, 64, 14, 14, new c(i7, new b(i8, 140))), new C0080Bo(17, 72, 72, 16, 16, new c(36, new b(i9, 92))), new C0080Bo(18, 80, 80, 18, 18, new c(48, new b(i9, 114))), new C0080Bo(19, 88, 88, 20, 20, new c(i7, new b(i9, 144))), new C0080Bo(20, 96, 96, 22, 22, new c(68, new b(i9, 174))), new C0080Bo(21, 104, 104, 24, 24, new c(i7, new b(6, 136))), new C0080Bo(22, 120, 120, 18, 18, new c(68, new b(6, 175))), new C0080Bo(23, 132, 132, 20, 20, new c(62, new b(8, 163))), new C0080Bo(24, 144, 144, 22, 22, new c(62, new b(8, 156), new b(i8, 155))), new C0080Bo(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new C0080Bo(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new C0080Bo(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new C0080Bo(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new C0080Bo(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new C0080Bo(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public static C0080Bo m328h(int i, int i2) throws C2610yb {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw C2610yb.m10853a();
        }
        for (C0080Bo c0080Bo : f198h) {
            if (c0080Bo.f200b == i && c0080Bo.f201c == i2) {
                return c0080Bo;
            }
        }
        throw C2610yb.m10853a();
    }

    public int m329b() {
        return this.f203e;
    }

    public int m330c() {
        return this.f202d;
    }

    public c m331d() {
        return this.f204f;
    }

    public int m332e() {
        return this.f201c;
    }

    public int m333f() {
        return this.f200b;
    }

    public int m334g() {
        return this.f205g;
    }

    public int m335i() {
        return this.f199a;
    }

    public String toString() {
        return String.valueOf(this.f199a);
    }

    public static final class c {

        public final int f208a;

        public final b[] f209b;

        public c(int i, b bVar) {
            this.f208a = i;
            this.f209b = new b[]{bVar};
        }

        public b[] m338a() {
            return this.f209b;
        }

        public int m339b() {
            return this.f208a;
        }

        public c(int i, b bVar, b bVar2) {
            this.f208a = i;
            this.f209b = new b[]{bVar, bVar2};
        }
    }
}
