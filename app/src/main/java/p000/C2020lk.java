package p000;

/* loaded from: classes.dex */
public final class C2020lk {

    public final C2611yc f6094a;

    public C2020lk(C2611yc c2611yc) {
        this.f6094a = c2611yc;
    }

    public void m8404a(int[] iArr, int i) throws C2112nk {
        C2657zc c2657zc = new C2657zc(this.f6094a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            C2611yc c2611yc = this.f6094a;
            int iM11011c = c2657zc.m11011c(c2611yc.m10857c(c2611yc.m10858d() + i2));
            iArr2[(i - 1) - i2] = iM11011c;
            if (iM11011c != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        C2657zc[] c2657zcArrM8407d = m8407d(this.f6094a.m10856b(i, 1), new C2657zc(this.f6094a, iArr2), i);
        C2657zc c2657zc2 = c2657zcArrM8407d[0];
        C2657zc c2657zc3 = c2657zcArrM8407d[1];
        int[] iArrM8405b = m8405b(c2657zc2);
        int[] iArrM8406c = m8406c(c2657zc3, iArrM8405b);
        for (int i3 = 0; i3 < iArrM8405b.length; i3++) {
            int length = (iArr.length - 1) - this.f6094a.m10863i(iArrM8405b[i3]);
            if (length < 0) {
                throw new C2112nk("Bad error location");
            }
            iArr[length] = C2611yc.m10855a(iArr[length], iArrM8406c[i3]);
        }
    }

    public final int[] m8405b(C2657zc c2657zc) throws C2112nk {
        int iM11014f = c2657zc.m11014f();
        if (iM11014f == 1) {
            return new int[]{c2657zc.m11012d(1)};
        }
        int[] iArr = new int[iM11014f];
        int i = 0;
        for (int i2 = 1; i2 < this.f6094a.m10860f() && i < iM11014f; i2++) {
            if (c2657zc.m11011c(i2) == 0) {
                iArr[i] = this.f6094a.m10862h(i2);
                i++;
            }
        }
        if (i == iM11014f) {
            return iArr;
        }
        throw new C2112nk("Error locator degree does not match number of roots");
    }

    public final int[] m8406c(C2657zc c2657zc, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iM10862h = this.f6094a.m10862h(iArr[i]);
            int iM10864j = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iM10864j2 = this.f6094a.m10864j(iArr[i2], iM10862h);
                    iM10864j = this.f6094a.m10864j(iM10864j, (iM10864j2 & 1) == 0 ? iM10864j2 | 1 : iM10864j2 & (-2));
                }
            }
            iArr2[i] = this.f6094a.m10864j(c2657zc.m11011c(iM10862h), this.f6094a.m10862h(iM10864j));
            if (this.f6094a.m10858d() != 0) {
                iArr2[i] = this.f6094a.m10864j(iArr2[i], iM10862h);
            }
        }
        return iArr2;
    }

    public final C2657zc[] m8407d(C2657zc c2657zc, C2657zc c2657zc2, int i) throws C2112nk {
        if (c2657zc.m11014f() < c2657zc2.m11014f()) {
            c2657zc2 = c2657zc;
            c2657zc = c2657zc2;
        }
        C2657zc c2657zcM10861g = this.f6094a.m10861g();
        C2657zc c2657zcM10859e = this.f6094a.m10859e();
        do {
            C2657zc c2657zc3 = c2657zc2;
            c2657zc2 = c2657zc;
            c2657zc = c2657zc3;
            C2657zc c2657zc4 = c2657zcM10859e;
            C2657zc c2657zc5 = c2657zcM10861g;
            c2657zcM10861g = c2657zc4;
            if (c2657zc.m11014f() < i / 2) {
                int iM11012d = c2657zcM10861g.m11012d(0);
                if (iM11012d == 0) {
                    throw new C2112nk("sigmaTilde(0) was zero");
                }
                int iM10862h = this.f6094a.m10862h(iM11012d);
                return new C2657zc[]{c2657zcM10861g.m11016h(iM10862h), c2657zc.m11016h(iM10862h)};
            }
            if (c2657zc.m11015g()) {
                throw new C2112nk("r_{i-1} was zero");
            }
            C2657zc c2657zcM10861g2 = this.f6094a.m10861g();
            int iM10862h2 = this.f6094a.m10862h(c2657zc.m11012d(c2657zc.m11014f()));
            while (c2657zc2.m11014f() >= c2657zc.m11014f() && !c2657zc2.m11015g()) {
                int iM11014f = c2657zc2.m11014f() - c2657zc.m11014f();
                int iM10864j = this.f6094a.m10864j(c2657zc2.m11012d(c2657zc2.m11014f()), iM10862h2);
                c2657zcM10861g2 = c2657zcM10861g2.m11009a(this.f6094a.m10856b(iM11014f, iM10864j));
                c2657zc2 = c2657zc2.m11009a(c2657zc.m11018j(iM11014f, iM10864j));
            }
            c2657zcM10859e = c2657zcM10861g2.m11017i(c2657zcM10861g).m11009a(c2657zc5);
        } while (c2657zc2.m11014f() < c2657zc.m11014f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }
}
