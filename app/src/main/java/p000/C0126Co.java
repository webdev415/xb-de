package p000;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* loaded from: classes.dex */
public final class C0126Co {

    public static final int[] f310e = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    public static final C0126Co[] f311f = m510b();

    public final int f312a;

    public final int[] f313b;

    public final b[] f314c;

    public final int f315d;

    public static final class a {

        public final int f316a;

        public final int f317b;

        public a(int i, int i2) {
            this.f316a = i;
            this.f317b = i2;
        }

        public int m520a() {
            return this.f316a;
        }

        public int m521b() {
            return this.f317b;
        }
    }

    public static final class b {

        public final int f318a;

        public final a[] f319b;

        public b(int i, a... aVarArr) {
            this.f318a = i;
            this.f319b = aVarArr;
        }

        public a[] m522a() {
            return this.f319b;
        }

        public int m523b() {
            return this.f318a;
        }

        public int m524c() {
            int iM520a = 0;
            for (a aVar : this.f319b) {
                iM520a += aVar.m520a();
            }
            return iM520a;
        }

        public int m525d() {
            return this.f318a * m524c();
        }
    }

    public C0126Co(int i, int[] iArr, b... bVarArr) {
        this.f312a = i;
        this.f313b = iArr;
        this.f314c = bVarArr;
        int iM523b = bVarArr[0].m523b();
        int iM520a = 0;
        for (a aVar : bVarArr[0].m522a()) {
            iM520a += aVar.m520a() * (aVar.m521b() + iM523b);
        }
        this.f315d = iM520a;
    }

    public static C0126Co[] m510b() {
        return new C0126Co[]{new C0126Co(1, new int[0], new b(7, new a(1, 19)), new b(10, new a(1, 16)), new b(13, new a(1, 13)), new b(17, new a(1, 9))), new C0126Co(2, new int[]{6, 18}, new b(10, new a(1, 34)), new b(16, new a(1, 28)), new b(22, new a(1, 22)), new b(28, new a(1, 16))), new C0126Co(3, new int[]{6, 22}, new b(15, new a(1, 55)), new b(26, new a(1, 44)), new b(18, new a(2, 17)), new b(22, new a(2, 13))), new C0126Co(4, new int[]{6, 26}, new b(20, new a(1, 80)), new b(18, new a(2, 32)), new b(26, new a(2, 24)), new b(16, new a(4, 9))), new C0126Co(5, new int[]{6, 30}, new b(26, new a(1, 108)), new b(24, new a(2, 43)), new b(18, new a(2, 15), new a(2, 16)), new b(22, new a(2, 11), new a(2, 12))), new C0126Co(6, new int[]{6, 34}, new b(18, new a(2, 68)), new b(16, new a(4, 27)), new b(24, new a(4, 19)), new b(28, new a(4, 15))), new C0126Co(7, new int[]{6, 22, 38}, new b(20, new a(2, 78)), new b(18, new a(4, 31)), new b(18, new a(2, 14), new a(4, 15)), new b(26, new a(4, 13), new a(1, 14))), new C0126Co(8, new int[]{6, 24, 42}, new b(24, new a(2, 97)), new b(22, new a(2, 38), new a(2, 39)), new b(22, new a(4, 18), new a(2, 19)), new b(26, new a(4, 14), new a(2, 15))), new C0126Co(9, new int[]{6, 26, 46}, new b(30, new a(2, 116)), new b(22, new a(3, 36), new a(2, 37)), new b(20, new a(4, 16), new a(4, 17)), new b(24, new a(4, 12), new a(4, 13))), new C0126Co(10, new int[]{6, 28, 50}, new b(18, new a(2, 68), new a(2, 69)), new b(26, new a(4, 43), new a(1, 44)), new b(24, new a(6, 19), new a(2, 20)), new b(28, new a(6, 15), new a(2, 16))), new C0126Co(11, new int[]{6, 30, 54}, new b(20, new a(4, 81)), new b(30, new a(1, 50), new a(4, 51)), new b(28, new a(4, 22), new a(4, 23)), new b(24, new a(3, 12), new a(8, 13))), new C0126Co(12, new int[]{6, 32, 58}, new b(24, new a(2, 92), new a(2, 93)), new b(22, new a(6, 36), new a(2, 37)), new b(26, new a(4, 20), new a(6, 21)), new b(28, new a(7, 14), new a(4, 15))), new C0126Co(13, new int[]{6, 34, 62}, new b(26, new a(4, 107)), new b(22, new a(8, 37), new a(1, 38)), new b(24, new a(8, 20), new a(4, 21)), new b(22, new a(12, 11), new a(4, 12))), new C0126Co(14, new int[]{6, 26, 46, 66}, new b(30, new a(3, 115), new a(1, 116)), new b(24, new a(4, 40), new a(5, 41)), new b(20, new a(11, 16), new a(5, 17)), new b(24, new a(11, 12), new a(5, 13))), new C0126Co(15, new int[]{6, 26, 48, 70}, new b(22, new a(5, 87), new a(1, 88)), new b(24, new a(5, 41), new a(5, 42)), new b(30, new a(5, 24), new a(7, 25)), new b(24, new a(11, 12), new a(7, 13))), new C0126Co(16, new int[]{6, 26, 50, 74}, new b(24, new a(5, 98), new a(1, 99)), new b(28, new a(7, 45), new a(3, 46)), new b(24, new a(15, 19), new a(2, 20)), new b(30, new a(3, 15), new a(13, 16))), new C0126Co(17, new int[]{6, 30, 54, 78}, new b(28, new a(1, 107), new a(5, 108)), new b(28, new a(10, 46), new a(1, 47)), new b(28, new a(1, 22), new a(15, 23)), new b(28, new a(2, 14), new a(17, 15))), new C0126Co(18, new int[]{6, 30, 56, 82}, new b(30, new a(5, 120), new a(1, 121)), new b(26, new a(9, 43), new a(4, 44)), new b(28, new a(17, 22), new a(1, 23)), new b(28, new a(2, 14), new a(19, 15))), new C0126Co(19, new int[]{6, 30, 58, 86}, new b(28, new a(3, 113), new a(4, 114)), new b(26, new a(3, 44), new a(11, 45)), new b(26, new a(17, 21), new a(4, 22)), new b(26, new a(9, 13), new a(16, 14))), new C0126Co(20, new int[]{6, 34, 62, 90}, new b(28, new a(3, 107), new a(5, 108)), new b(26, new a(3, 41), new a(13, 42)), new b(30, new a(15, 24), new a(5, 25)), new b(28, new a(15, 15), new a(10, 16))), new C0126Co(21, new int[]{6, 28, 50, 72, 94}, new b(28, new a(4, 116), new a(4, 117)), new b(26, new a(17, 42)), new b(28, new a(17, 22), new a(6, 23)), new b(30, new a(19, 16), new a(6, 17))), new C0126Co(22, new int[]{6, 26, 50, 74, 98}, new b(28, new a(2, 111), new a(7, 112)), new b(28, new a(17, 46)), new b(30, new a(7, 24), new a(16, 25)), new b(24, new a(34, 13))), new C0126Co(23, new int[]{6, 30, 54, 78, 102}, new b(30, new a(4, 121), new a(5, ModuleDescriptor.MODULE_VERSION)), new b(28, new a(4, 47), new a(14, 48)), new b(30, new a(11, 24), new a(14, 25)), new b(30, new a(16, 15), new a(14, 16))), new C0126Co(24, new int[]{6, 28, 54, 80, 106}, new b(30, new a(6, 117), new a(4, 118)), new b(28, new a(6, 45), new a(14, 46)), new b(30, new a(11, 24), new a(16, 25)), new b(30, new a(30, 16), new a(2, 17))), new C0126Co(25, new int[]{6, 32, 58, 84, 110}, new b(26, new a(8, 106), new a(4, 107)), new b(28, new a(8, 47), new a(13, 48)), new b(30, new a(7, 24), new a(22, 25)), new b(30, new a(22, 15), new a(13, 16))), new C0126Co(26, new int[]{6, 30, 58, 86, 114}, new b(28, new a(10, 114), new a(2, 115)), new b(28, new a(19, 46), new a(4, 47)), new b(28, new a(28, 22), new a(6, 23)), new b(30, new a(33, 16), new a(4, 17))), new C0126Co(27, new int[]{6, 34, 62, 90, 118}, new b(30, new a(8, ModuleDescriptor.MODULE_VERSION), new a(4, 123)), new b(28, new a(22, 45), new a(3, 46)), new b(30, new a(8, 23), new a(26, 24)), new b(30, new a(12, 15), new a(28, 16))), new C0126Co(28, new int[]{6, 26, 50, 74, 98, ModuleDescriptor.MODULE_VERSION}, new b(30, new a(3, 117), new a(10, 118)), new b(28, new a(3, 45), new a(23, 46)), new b(30, new a(4, 24), new a(31, 25)), new b(30, new a(11, 15), new a(31, 16))), new C0126Co(29, new int[]{6, 30, 54, 78, 102, 126}, new b(30, new a(7, 116), new a(7, 117)), new b(28, new a(21, 45), new a(7, 46)), new b(30, new a(1, 23), new a(37, 24)), new b(30, new a(19, 15), new a(26, 16))), new C0126Co(30, new int[]{6, 26, 52, 78, 104, 130}, new b(30, new a(5, 115), new a(10, 116)), new b(28, new a(19, 47), new a(10, 48)), new b(30, new a(15, 24), new a(25, 25)), new b(30, new a(23, 15), new a(25, 16))), new C0126Co(31, new int[]{6, 30, 56, 82, 108, 134}, new b(30, new a(13, 115), new a(3, 116)), new b(28, new a(2, 46), new a(29, 47)), new b(30, new a(42, 24), new a(1, 25)), new b(30, new a(23, 15), new a(28, 16))), new C0126Co(32, new int[]{6, 34, 60, 86, 112, 138}, new b(30, new a(17, 115)), new b(28, new a(10, 46), new a(23, 47)), new b(30, new a(10, 24), new a(35, 25)), new b(30, new a(19, 15), new a(35, 16))), new C0126Co(33, new int[]{6, 30, 58, 86, 114, 142}, new b(30, new a(17, 115), new a(1, 116)), new b(28, new a(14, 46), new a(21, 47)), new b(30, new a(29, 24), new a(19, 25)), new b(30, new a(11, 15), new a(46, 16))), new C0126Co(34, new int[]{6, 34, 62, 90, 118, 146}, new b(30, new a(13, 115), new a(6, 116)), new b(28, new a(14, 46), new a(23, 47)), new b(30, new a(44, 24), new a(7, 25)), new b(30, new a(59, 16), new a(1, 17))), new C0126Co(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new b(30, new a(12, 121), new a(7, ModuleDescriptor.MODULE_VERSION)), new b(28, new a(12, 47), new a(26, 48)), new b(30, new a(39, 24), new a(14, 25)), new b(30, new a(22, 15), new a(41, 16))), new C0126Co(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new b(30, new a(6, 121), new a(14, ModuleDescriptor.MODULE_VERSION)), new b(28, new a(6, 47), new a(34, 48)), new b(30, new a(46, 24), new a(10, 25)), new b(30, new a(2, 15), new a(64, 16))), new C0126Co(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new b(30, new a(17, ModuleDescriptor.MODULE_VERSION), new a(4, 123)), new b(28, new a(29, 46), new a(14, 47)), new b(30, new a(49, 24), new a(10, 25)), new b(30, new a(24, 15), new a(46, 16))), new C0126Co(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new b(30, new a(4, ModuleDescriptor.MODULE_VERSION), new a(18, 123)), new b(28, new a(13, 46), new a(32, 47)), new b(30, new a(48, 24), new a(14, 25)), new b(30, new a(42, 15), new a(32, 16))), new C0126Co(39, new int[]{6, 26, 54, 82, 110, 138, 166}, new b(30, new a(20, 117), new a(4, 118)), new b(28, new a(40, 47), new a(7, 48)), new b(30, new a(43, 24), new a(22, 25)), new b(30, new a(10, 15), new a(67, 16))), new C0126Co(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new b(30, new a(19, 118), new a(6, 119)), new b(28, new a(18, 47), new a(31, 48)), new b(30, new a(34, 24), new a(34, 25)), new b(30, new a(20, 15), new a(61, 16)))};
    }

    public static C0126Co m511c(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = f310e;
            if (i3 >= iArr.length) {
                if (i2 <= 3) {
                    return m513i(i4);
                }
                return null;
            }
            int i5 = iArr[i3];
            if (i5 == i) {
                return m513i(i3 + 7);
            }
            int iM11006e = C2656zb.m11006e(i, i5);
            if (iM11006e < i2) {
                i4 = i3 + 7;
                i2 = iM11006e;
            }
            i3++;
        }
    }

    public static C0126Co m512g(int i) throws C2610yb {
        if (i % 4 != 1) {
            throw C2610yb.m10853a();
        }
        try {
            return m513i((i - 17) / 4);
        } catch (IllegalArgumentException unused) {
            throw C2610yb.m10853a();
        }
    }

    public static C0126Co m513i(int i) {
        if (i <= 0 || i > 40) {
            throw new IllegalArgumentException();
        }
        return f311f[i - 1];
    }

    public C0325H2 m514a() {
        int iM516e = m516e();
        C0325H2 c0325h2 = new C0325H2(iM516e);
        c0325h2.m1502s(0, 0, 9, 9);
        int i = iM516e - 8;
        c0325h2.m1502s(i, 0, 8, 9);
        c0325h2.m1502s(0, i, 9, 8);
        int length = this.f313b.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = this.f313b[i2] - 2;
            for (int i4 = 0; i4 < length; i4++) {
                if ((i2 != 0 || (i4 != 0 && i4 != length - 1)) && (i2 != length - 1 || i4 != 0)) {
                    c0325h2.m1502s(this.f313b[i4] - 2, i3, 5, 5);
                }
            }
        }
        int i5 = iM516e - 17;
        c0325h2.m1502s(6, 9, 1, i5);
        c0325h2.m1502s(9, 6, i5, 1);
        if (this.f312a > 6) {
            int i6 = iM516e - 11;
            c0325h2.m1502s(i6, 0, 3, 6);
            c0325h2.m1502s(0, i6, 6, 3);
        }
        return c0325h2;
    }

    public int[] m515d() {
        return this.f313b;
    }

    public int m516e() {
        return (this.f312a * 4) + 17;
    }

    public b m517f(EnumC1363ca enumC1363ca) {
        return this.f314c[enumC1363ca.ordinal()];
    }

    public int m518h() {
        return this.f315d;
    }

    public int m519j() {
        return this.f312a;
    }

    public String toString() {
        return String.valueOf(this.f312a);
    }
}
