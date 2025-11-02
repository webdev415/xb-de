package p000;

public final class C2657zc {

    public final C2611yc f8252a;

    public final int[] f8253b;

    public C2657zc(C2611yc c2611yc, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f8252a = c2611yc;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f8253b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f8253b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.f8253b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public C2657zc m11009a(C2657zc c2657zc) {
        if (!this.f8252a.equals(c2657zc.f8252a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (m11015g()) {
            return c2657zc;
        }
        if (c2657zc.m11015g()) {
            return this;
        }
        int[] iArr = this.f8253b;
        int[] iArr2 = c2657zc.f8253b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = C2611yc.m10855a(iArr2[i - length], iArr[i]);
        }
        return new C2657zc(this.f8252a, iArr3);
    }

    public C2657zc[] m11010b(C2657zc c2657zc) {
        if (!this.f8252a.equals(c2657zc.f8252a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c2657zc.m11015g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        C2657zc c2657zcM10861g = this.f8252a.m10861g();
        int iM10862h = this.f8252a.m10862h(c2657zc.m11012d(c2657zc.m11014f()));
        C2657zc c2657zcM11009a = this;
        while (c2657zcM11009a.m11014f() >= c2657zc.m11014f() && !c2657zcM11009a.m11015g()) {
            int iM11014f = c2657zcM11009a.m11014f() - c2657zc.m11014f();
            int iM10864j = this.f8252a.m10864j(c2657zcM11009a.m11012d(c2657zcM11009a.m11014f()), iM10862h);
            C2657zc c2657zcM11018j = c2657zc.m11018j(iM11014f, iM10864j);
            c2657zcM10861g = c2657zcM10861g.m11009a(this.f8252a.m10856b(iM11014f, iM10864j));
            c2657zcM11009a = c2657zcM11009a.m11009a(c2657zcM11018j);
        }
        return new C2657zc[]{c2657zcM10861g, c2657zcM11009a};
    }

    public int m11011c(int i) {
        if (i == 0) {
            return m11012d(0);
        }
        if (i == 1) {
            int iM10855a = 0;
            for (int i2 : this.f8253b) {
                iM10855a = C2611yc.m10855a(iM10855a, i2);
            }
            return iM10855a;
        }
        int[] iArr = this.f8253b;
        int iM10855a2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            iM10855a2 = C2611yc.m10855a(this.f8252a.m10864j(i, iM10855a2), this.f8253b[i3]);
        }
        return iM10855a2;
    }

    public int m11012d(int i) {
        return this.f8253b[(r0.length - 1) - i];
    }

    public int[] m11013e() {
        return this.f8253b;
    }

    public int m11014f() {
        return this.f8253b.length - 1;
    }

    public boolean m11015g() {
        return this.f8253b[0] == 0;
    }

    public C2657zc m11016h(int i) {
        if (i == 0) {
            return this.f8252a.m10861g();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f8253b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f8252a.m10864j(this.f8253b[i2], i);
        }
        return new C2657zc(this.f8252a, iArr);
    }

    public C2657zc m11017i(C2657zc c2657zc) {
        if (!this.f8252a.equals(c2657zc.f8252a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (m11015g() || c2657zc.m11015g()) {
            return this.f8252a.m10861g();
        }
        int[] iArr = this.f8253b;
        int length = iArr.length;
        int[] iArr2 = c2657zc.f8253b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = C2611yc.m10855a(iArr3[i4], this.f8252a.m10864j(i2, iArr2[i3]));
            }
        }
        return new C2657zc(this.f8252a, iArr3);
    }

    public C2657zc m11018j(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f8252a.m10861g();
        }
        int length = this.f8253b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f8252a.m10864j(this.f8253b[i3], i2);
        }
        return new C2657zc(this.f8252a, iArr);
    }

    public String toString() {
        char c;
        if (m11015g()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(m11014f() * 8);
        int iM11014f = m11014f();
        while (iM11014f >= 0) {
            int iM11012d = m11012d(iM11014f);
            if (iM11012d != 0) {
                if (iM11012d < 0) {
                    sb.append(iM11014f == m11014f() ? "-" : " - ");
                    iM11012d = -iM11012d;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iM11014f == 0 || iM11012d != 1) {
                    int iM10863i = this.f8252a.m10863i(iM11012d);
                    if (iM10863i == 0) {
                        c = '1';
                    } else if (iM10863i == 1) {
                        c = 'a';
                    } else {
                        sb.append("a^");
                        sb.append(iM10863i);
                    }
                    sb.append(c);
                }
                if (iM11014f != 0) {
                    if (iM11014f == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iM11014f);
                    }
                }
            }
            iM11014f--;
        }
        return sb.toString();
    }
}
