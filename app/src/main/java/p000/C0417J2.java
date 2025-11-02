package p000;

public final class C0417J2 {

    public final C0325H2 f1255a;

    public C0126Co f1256b;

    public C2656zb f1257c;

    public boolean f1258d;

    public C0417J2(C0325H2 c0325h2) throws C2610yb {
        int iM1496j = c0325h2.m1496j();
        if (iM1496j < 21 || (iM1496j & 3) != 1) {
            throw C2610yb.m10853a();
        }
        this.f1255a = c0325h2;
    }

    public final int m1783a(int i, int i2, int i3) {
        return this.f1258d ? this.f1255a.m1493e(i2, i) : this.f1255a.m1493e(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public void m1784b() {
        int i = 0;
        while (i < this.f1255a.m1499o()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f1255a.m1496j(); i3++) {
                if (this.f1255a.m1493e(i, i3) != this.f1255a.m1493e(i3, i)) {
                    this.f1255a.m1492d(i3, i);
                    this.f1255a.m1492d(i, i3);
                }
            }
            i = i2;
        }
    }

    public byte[] m1785c() throws C2610yb {
        C2656zb c2656zbM1786d = m1786d();
        C0126Co c0126CoM1787e = m1787e();
        EnumC1998l7 enumC1998l7 = EnumC1998l7.values()[c2656zbM1786d.m11007c()];
        int iM1496j = this.f1255a.m1496j();
        enumC1998l7.m8359e(this.f1255a, iM1496j);
        C0325H2 c0325h2M514a = c0126CoM1787e.m514a();
        byte[] bArr = new byte[c0126CoM1787e.m518h()];
        int i = iM1496j - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < iM1496j; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!c0325h2M514a.m1493e(i9, i7)) {
                        i4++;
                        i5 <<= 1;
                        if (this.f1255a.m1493e(i9, i7)) {
                            i5 |= 1;
                        }
                        if (i4 == 8) {
                            bArr[i3] = (byte) i5;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == c0126CoM1787e.m518h()) {
            return bArr;
        }
        throw C2610yb.m10853a();
    }

    public C2656zb m1786d() throws C2610yb {
        C2656zb c2656zb = this.f1257c;
        if (c2656zb != null) {
            return c2656zb;
        }
        int iM1783a = 0;
        int iM1783a2 = 0;
        for (int i = 0; i < 6; i++) {
            iM1783a2 = m1783a(i, 8, iM1783a2);
        }
        int iM1783a3 = m1783a(8, 7, m1783a(8, 8, m1783a(7, 8, iM1783a2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iM1783a3 = m1783a(8, i2, iM1783a3);
        }
        int iM1496j = this.f1255a.m1496j();
        int i3 = iM1496j - 7;
        for (int i4 = iM1496j - 1; i4 >= i3; i4--) {
            iM1783a = m1783a(8, i4, iM1783a);
        }
        for (int i5 = iM1496j - 8; i5 < iM1496j; i5++) {
            iM1783a = m1783a(i5, 8, iM1783a);
        }
        C2656zb c2656zbM11004a = C2656zb.m11004a(iM1783a3, iM1783a);
        this.f1257c = c2656zbM11004a;
        if (c2656zbM11004a != null) {
            return c2656zbM11004a;
        }
        throw C2610yb.m10853a();
    }

    public C0126Co m1787e() throws C2610yb {
        C0126Co c0126Co = this.f1256b;
        if (c0126Co != null) {
            return c0126Co;
        }
        int iM1496j = this.f1255a.m1496j();
        int i = (iM1496j - 17) / 4;
        if (i <= 6) {
            return C0126Co.m513i(i);
        }
        int i2 = iM1496j - 11;
        int iM1783a = 0;
        int iM1783a2 = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = iM1496j - 9; i4 >= i2; i4--) {
                iM1783a2 = m1783a(i4, i3, iM1783a2);
            }
        }
        C0126Co c0126CoM511c = C0126Co.m511c(iM1783a2);
        if (c0126CoM511c != null && c0126CoM511c.m516e() == iM1496j) {
            this.f1256b = c0126CoM511c;
            return c0126CoM511c;
        }
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = iM1496j - 9; i6 >= i2; i6--) {
                iM1783a = m1783a(i5, i6, iM1783a);
            }
        }
        C0126Co c0126CoM511c2 = C0126Co.m511c(iM1783a);
        if (c0126CoM511c2 == null || c0126CoM511c2.m516e() != iM1496j) {
            throw C2610yb.m10853a();
        }
        this.f1256b = c0126CoM511c2;
        return c0126CoM511c2;
    }

    public void m1788f() {
        if (this.f1257c == null) {
            return;
        }
        EnumC1998l7.values()[this.f1257c.m11007c()].m8359e(this.f1255a, this.f1255a.m1496j());
    }

    public void m1789g(boolean z) {
        this.f1256b = null;
        this.f1257c = null;
        this.f1258d = z;
    }
}
