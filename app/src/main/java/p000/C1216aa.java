package p000;

/* loaded from: classes.dex */
public final class C1216aa {

    public final C1083Xg f3536a = C1083Xg.f3249f;

    public int m5248a(int[] iArr, int i, int[] iArr2) throws C2548x4 {
        C1129Yg c1129Yg = new C1129Yg(this.f3536a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iM4954b = c1129Yg.m4954b(this.f3536a.m4784c(i2));
            iArr3[i - i2] = iM4954b;
            if (iM4954b != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        C1129Yg c1129YgM4785d = this.f3536a.m4785d();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iM4784c = this.f3536a.m4784c((iArr.length - 1) - i3);
                C1083Xg c1083Xg = this.f3536a;
                c1129YgM4785d = c1129YgM4785d.m4959g(new C1129Yg(c1083Xg, new int[]{c1083Xg.m4791j(0, iM4784c), 1}));
            }
        }
        C1129Yg[] c1129YgArrM5251d = m5251d(this.f3536a.m4783b(i, 1), new C1129Yg(this.f3536a, iArr3), i);
        C1129Yg c1129Yg2 = c1129YgArrM5251d[0];
        C1129Yg c1129Yg3 = c1129YgArrM5251d[1];
        int[] iArrM5249b = m5249b(c1129Yg2);
        int[] iArrM5250c = m5250c(c1129Yg3, c1129Yg2, iArrM5249b);
        for (int i4 = 0; i4 < iArrM5249b.length; i4++) {
            int length = (iArr.length - 1) - this.f3536a.m4789h(iArrM5249b[i4]);
            if (length < 0) {
                throw C2548x4.m10627a();
            }
            iArr[length] = this.f3536a.m4791j(iArr[length], iArrM5250c[i4]);
        }
        return iArrM5249b.length;
    }

    public final int[] m5249b(C1129Yg c1129Yg) throws C2548x4 {
        int iM4956d = c1129Yg.m4956d();
        int[] iArr = new int[iM4956d];
        int i = 0;
        for (int i2 = 1; i2 < this.f3536a.m4786e() && i < iM4956d; i2++) {
            if (c1129Yg.m4954b(i2) == 0) {
                iArr[i] = this.f3536a.m4788g(i2);
                i++;
            }
        }
        if (i == iM4956d) {
            return iArr;
        }
        throw C2548x4.m10627a();
    }

    public final int[] m5250c(C1129Yg c1129Yg, C1129Yg c1129Yg2, int[] iArr) {
        int iM4956d = c1129Yg2.m4956d();
        int[] iArr2 = new int[iM4956d];
        for (int i = 1; i <= iM4956d; i++) {
            iArr2[iM4956d - i] = this.f3536a.m4790i(i, c1129Yg2.m4955c(i));
        }
        C1129Yg c1129Yg3 = new C1129Yg(this.f3536a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iM4788g = this.f3536a.m4788g(iArr[i2]);
            iArr3[i2] = this.f3536a.m4790i(this.f3536a.m4791j(0, c1129Yg.m4954b(iM4788g)), this.f3536a.m4788g(c1129Yg3.m4954b(iM4788g)));
        }
        return iArr3;
    }

    public final C1129Yg[] m5251d(C1129Yg c1129Yg, C1129Yg c1129Yg2, int i) throws C2548x4 {
        if (c1129Yg.m4956d() < c1129Yg2.m4956d()) {
            c1129Yg2 = c1129Yg;
            c1129Yg = c1129Yg2;
        }
        C1129Yg c1129YgM4787f = this.f3536a.m4787f();
        C1129Yg c1129YgM4785d = this.f3536a.m4785d();
        while (true) {
            C1129Yg c1129Yg3 = c1129Yg2;
            c1129Yg2 = c1129Yg;
            c1129Yg = c1129Yg3;
            C1129Yg c1129Yg4 = c1129YgM4785d;
            C1129Yg c1129Yg5 = c1129YgM4787f;
            c1129YgM4787f = c1129Yg4;
            if (c1129Yg.m4956d() < i / 2) {
                int iM4955c = c1129YgM4787f.m4955c(0);
                if (iM4955c == 0) {
                    throw C2548x4.m10627a();
                }
                int iM4788g = this.f3536a.m4788g(iM4955c);
                return new C1129Yg[]{c1129YgM4787f.m4958f(iM4788g), c1129Yg.m4958f(iM4788g)};
            }
            if (c1129Yg.m4957e()) {
                throw C2548x4.m10627a();
            }
            C1129Yg c1129YgM4787f2 = this.f3536a.m4787f();
            int iM4788g2 = this.f3536a.m4788g(c1129Yg.m4955c(c1129Yg.m4956d()));
            while (c1129Yg2.m4956d() >= c1129Yg.m4956d() && !c1129Yg2.m4957e()) {
                int iM4956d = c1129Yg2.m4956d() - c1129Yg.m4956d();
                int iM4790i = this.f3536a.m4790i(c1129Yg2.m4955c(c1129Yg2.m4956d()), iM4788g2);
                c1129YgM4787f2 = c1129YgM4787f2.m4953a(this.f3536a.m4783b(iM4956d, iM4790i));
                c1129Yg2 = c1129Yg2.m4962j(c1129Yg.m4960h(iM4956d, iM4790i));
            }
            c1129YgM4785d = c1129YgM4787f2.m4959g(c1129YgM4787f).m4962j(c1129Yg5).m4961i();
        }
    }
}
