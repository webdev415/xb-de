package p000;

public final class C0968V2 {

    public final C0325H2 f2911a;

    public final C0857Sk f2912b;

    public final C0857Sk f2913c;

    public final C0857Sk f2914d;

    public final C0857Sk f2915e;

    public final int f2916f;

    public final int f2917g;

    public final int f2918h;

    public final int f2919i;

    public C0968V2(C0325H2 c0325h2, C0857Sk c0857Sk, C0857Sk c0857Sk2, C0857Sk c0857Sk3, C0857Sk c0857Sk4) throws C2340sh {
        boolean z = c0857Sk == null || c0857Sk2 == null;
        boolean z2 = c0857Sk3 == null || c0857Sk4 == null;
        if (z && z2) {
            throw C2340sh.m9579a();
        }
        if (z) {
            c0857Sk = new C0857Sk(0.0f, c0857Sk3.m4068d());
            c0857Sk2 = new C0857Sk(0.0f, c0857Sk4.m4068d());
        } else if (z2) {
            c0857Sk3 = new C0857Sk(c0325h2.m1499o() - 1, c0857Sk.m4068d());
            c0857Sk4 = new C0857Sk(c0325h2.m1499o() - 1, c0857Sk2.m4068d());
        }
        this.f2911a = c0325h2;
        this.f2912b = c0857Sk;
        this.f2913c = c0857Sk2;
        this.f2914d = c0857Sk3;
        this.f2915e = c0857Sk4;
        this.f2916f = (int) Math.min(c0857Sk.m4067c(), c0857Sk2.m4067c());
        this.f2917g = (int) Math.max(c0857Sk3.m4067c(), c0857Sk4.m4067c());
        this.f2918h = (int) Math.min(c0857Sk.m4068d(), c0857Sk3.m4068d());
        this.f2919i = (int) Math.max(c0857Sk2.m4068d(), c0857Sk4.m4068d());
    }

    public static C0968V2 m4310j(C0968V2 c0968v2, C0968V2 c0968v22) {
        return c0968v2 == null ? c0968v22 : c0968v22 == null ? c0968v2 : new C0968V2(c0968v2.f2911a, c0968v2.f2912b, c0968v2.f2913c, c0968v22.f2914d, c0968v22.f2915e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0968V2 m4311a(int r13, int r14, boolean r15) {
        /*
            r12 = this;
            Sk r0 = r12.f2912b
            Sk r1 = r12.f2913c
            Sk r2 = r12.f2914d
            Sk r3 = r12.f2915e
            if (r13 <= 0) goto L2a
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.m4068d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            Sk r13 = new Sk
            float r4 = r4.m4067c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L27
            r8 = r13
        L25:
            r10 = r2
            goto L2c
        L27:
            r10 = r13
            r8 = r0
            goto L2c
        L2a:
            r8 = r0
            goto L25
        L2c:
            if (r14 <= 0) goto L5d
            if (r15 == 0) goto L33
            Sk r13 = r12.f2913c
            goto L35
        L33:
            Sk r13 = r12.f2915e
        L35:
            float r0 = r13.m4068d()
            int r0 = (int) r0
            int r0 = r0 + r14
            H2 r14 = r12.f2911a
            int r14 = r14.m1496j()
            if (r0 < r14) goto L4b
            H2 r14 = r12.f2911a
            int r14 = r14.m1496j()
            int r0 = r14 + (-1)
        L4b:
            Sk r14 = new Sk
            float r13 = r13.m4067c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L5a
            r9 = r14
        L58:
            r11 = r3
            goto L5f
        L5a:
            r11 = r14
            r9 = r1
            goto L5f
        L5d:
            r9 = r1
            goto L58
        L5f:
            V2 r13 = new V2
            H2 r7 = r12.f2911a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0968V2.m4311a(int, int, boolean):V2");
    }

    public C0857Sk m4312b() {
        return this.f2913c;
    }

    public C0857Sk m4313c() {
        return this.f2915e;
    }

    public int m4314d() {
        return this.f2917g;
    }

    public int m4315e() {
        return this.f2919i;
    }

    public int m4316f() {
        return this.f2916f;
    }

    public int m4317g() {
        return this.f2918h;
    }

    public C0857Sk m4318h() {
        return this.f2912b;
    }

    public C0857Sk m4319i() {
        return this.f2914d;
    }

    public C0968V2(C0968V2 c0968v2) {
        this.f2911a = c0968v2.f2911a;
        this.f2912b = c0968v2.f2912b;
        this.f2913c = c0968v2.f2913c;
        this.f2914d = c0968v2.f2914d;
        this.f2915e = c0968v2.f2915e;
        this.f2916f = c0968v2.f2916f;
        this.f2917g = c0968v2.f2917g;
        this.f2918h = c0968v2.f2918h;
        this.f2919i = c0968v2.f2919i;
    }
}
