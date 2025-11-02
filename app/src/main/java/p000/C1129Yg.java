package p000;

public final class C1129Yg {

    public final C1083Xg f3355a;

    public final int[] f3356b;

    public C1129Yg(C1083Xg c1083Xg, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f3355a = c1083Xg;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f3356b = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f3356b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.f3356b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    public C1129Yg m4953a(C1129Yg c1129Yg) {
        if (!this.f3355a.equals(c1129Yg.f3355a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (m4957e()) {
            return c1129Yg;
        }
        if (c1129Yg.m4957e()) {
            return this;
        }
        int[] iArr = this.f3356b;
        int[] iArr2 = c1129Yg.f3356b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.f3355a.m4782a(iArr2[i - length], iArr[i]);
        }
        return new C1129Yg(this.f3355a, iArr3);
    }

    public int m4954b(int i) {
        if (i == 0) {
            return m4955c(0);
        }
        if (i == 1) {
            int iM4782a = 0;
            for (int i2 : this.f3356b) {
                iM4782a = this.f3355a.m4782a(iM4782a, i2);
            }
            return iM4782a;
        }
        int[] iArr = this.f3356b;
        int iM4782a2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            C1083Xg c1083Xg = this.f3355a;
            iM4782a2 = c1083Xg.m4782a(c1083Xg.m4790i(i, iM4782a2), this.f3356b[i3]);
        }
        return iM4782a2;
    }

    public int m4955c(int i) {
        return this.f3356b[(r0.length - 1) - i];
    }

    public int m4956d() {
        return this.f3356b.length - 1;
    }

    public boolean m4957e() {
        return this.f3356b[0] == 0;
    }

    public C1129Yg m4958f(int i) {
        if (i == 0) {
            return this.f3355a.m4787f();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f3356b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f3355a.m4790i(this.f3356b[i2], i);
        }
        return new C1129Yg(this.f3355a, iArr);
    }

    public C1129Yg m4959g(C1129Yg c1129Yg) {
        if (!this.f3355a.equals(c1129Yg.f3355a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (m4957e() || c1129Yg.m4957e()) {
            return this.f3355a.m4787f();
        }
        int[] iArr = this.f3356b;
        int length = iArr.length;
        int[] iArr2 = c1129Yg.f3356b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                C1083Xg c1083Xg = this.f3355a;
                iArr3[i4] = c1083Xg.m4782a(iArr3[i4], c1083Xg.m4790i(i2, iArr2[i3]));
            }
        }
        return new C1129Yg(this.f3355a, iArr3);
    }

    public C1129Yg m4960h(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f3355a.m4787f();
        }
        int length = this.f3356b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f3355a.m4790i(this.f3356b[i3], i2);
        }
        return new C1129Yg(this.f3355a, iArr);
    }

    public C1129Yg m4961i() {
        int length = this.f3356b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f3355a.m4791j(0, this.f3356b[i]);
        }
        return new C1129Yg(this.f3355a, iArr);
    }

    public C1129Yg m4962j(C1129Yg c1129Yg) {
        if (this.f3355a.equals(c1129Yg.f3355a)) {
            return c1129Yg.m4957e() ? this : m4953a(c1129Yg.m4961i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(m4956d() * 8);
        for (int iM4956d = m4956d(); iM4956d >= 0; iM4956d--) {
            int iM4955c = m4955c(iM4956d);
            if (iM4955c != 0) {
                if (iM4955c < 0) {
                    sb.append(" - ");
                    iM4955c = -iM4955c;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iM4956d == 0 || iM4955c != 1) {
                    sb.append(iM4955c);
                }
                if (iM4956d != 0) {
                    if (iM4956d == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iM4956d);
                    }
                }
            }
        }
        return sb.toString();
    }
}
