package p000;

import java.util.Arrays;

public final class C0338HF {

    public static final C0338HF f1038f = new C0338HF(0, new int[0], new Object[0], false);

    public int f1039a;

    public int[] f1040b;

    public Object[] f1041c;

    public int f1042d;

    public boolean f1043e;

    public C0338HF() {
        this(0, new int[8], new Object[8], true);
    }

    public static C0338HF m1541c(C0338HF c0338hf, C0338HF c0338hf2) {
        int i = c0338hf.f1039a + c0338hf2.f1039a;
        int[] iArrCopyOf = Arrays.copyOf(c0338hf.f1040b, i);
        System.arraycopy(c0338hf2.f1040b, 0, iArrCopyOf, c0338hf.f1039a, c0338hf2.f1039a);
        Object[] objArrCopyOf = Arrays.copyOf(c0338hf.f1041c, i);
        System.arraycopy(c0338hf2.f1041c, 0, objArrCopyOf, c0338hf.f1039a, c0338hf2.f1039a);
        return new C0338HF(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static void m1542f(int i, Object obj, InterfaceC0017AG interfaceC0017AG) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            interfaceC0017AG.mo102q(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            interfaceC0017AG.mo81K(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            interfaceC0017AG.mo80J(i2, (AbstractC2233qB) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 != 5) {
                throw new RuntimeException(C1771gD.m7702a());
            }
            interfaceC0017AG.mo105t(i2, ((Integer) obj).intValue());
        } else if (interfaceC0017AG.mo86a() == 1) {
            interfaceC0017AG.mo95j(i2);
            ((C0338HF) obj).m1552j(interfaceC0017AG);
            interfaceC0017AG.mo90e(i2);
        } else {
            interfaceC0017AG.mo90e(i2);
            ((C0338HF) obj).m1552j(interfaceC0017AG);
            interfaceC0017AG.mo95j(i2);
        }
    }

    public static C0338HF m1543k() {
        return f1038f;
    }

    public static C0338HF m1544l() {
        return new C0338HF();
    }

    public final int m1545a() {
        int iM5802m0;
        int i = this.f1042d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1039a; i3++) {
            int i4 = this.f1040b[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iM5802m0 = AbstractC1355cC.m5802m0(i5, ((Long) this.f1041c[i3]).longValue());
            } else if (i6 == 1) {
                iM5802m0 = AbstractC1355cC.m5775P(i5, ((Long) this.f1041c[i3]).longValue());
            } else if (i6 == 2) {
                iM5802m0 = AbstractC1355cC.m5776Q(i5, (AbstractC2233qB) this.f1041c[i3]);
            } else if (i6 == 3) {
                iM5802m0 = (AbstractC1355cC.m5806s0(i5) << 1) + ((C0338HF) this.f1041c[i3]).m1545a();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(C1771gD.m7702a());
                }
                iM5802m0 = AbstractC1355cC.m5796h0(i5, ((Integer) this.f1041c[i3]).intValue());
            }
            i2 += iM5802m0;
        }
        this.f1042d = i2;
        return i2;
    }

    public final C0338HF m1546b(C0338HF c0338hf) {
        if (c0338hf.equals(f1038f)) {
            return this;
        }
        m1554n();
        int i = this.f1039a + c0338hf.f1039a;
        m1547d(i);
        System.arraycopy(c0338hf.f1040b, 0, this.f1040b, this.f1039a, c0338hf.f1039a);
        System.arraycopy(c0338hf.f1041c, 0, this.f1041c, this.f1039a, c0338hf.f1039a);
        this.f1039a = i;
        return this;
    }

    public final void m1547d(int i) {
        int[] iArr = this.f1040b;
        if (i > iArr.length) {
            int i2 = this.f1039a;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.f1040b = Arrays.copyOf(iArr, i);
            this.f1041c = Arrays.copyOf(this.f1041c, i);
        }
    }

    public final void m1548e(int i, Object obj) {
        m1554n();
        m1547d(this.f1039a + 1);
        int[] iArr = this.f1040b;
        int i2 = this.f1039a;
        iArr[i2] = i;
        this.f1041c[i2] = obj;
        this.f1039a = i2 + 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0338HF)) {
            return false;
        }
        C0338HF c0338hf = (C0338HF) obj;
        int i = this.f1039a;
        if (i == c0338hf.f1039a) {
            int[] iArr = this.f1040b;
            int[] iArr2 = c0338hf.f1040b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.f1041c;
                    Object[] objArr2 = c0338hf.f1041c;
                    int i3 = this.f1039a;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final void m1549g(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f1039a; i2++) {
            AbstractC2005lE.m8377c(sb, i, String.valueOf(this.f1040b[i2] >>> 3), this.f1041c[i2]);
        }
    }

    public final void m1550h(InterfaceC0017AG interfaceC0017AG) {
        if (interfaceC0017AG.mo86a() == 2) {
            for (int i = this.f1039a - 1; i >= 0; i--) {
                interfaceC0017AG.mo87b(this.f1040b[i] >>> 3, this.f1041c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f1039a; i2++) {
            interfaceC0017AG.mo87b(this.f1040b[i2] >>> 3, this.f1041c[i2]);
        }
    }

    public final int hashCode() {
        int i = this.f1039a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f1040b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.f1041c;
        int i6 = this.f1039a;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int m1551i() {
        int i = this.f1042d;
        if (i != -1) {
            return i;
        }
        int iM5783Z = 0;
        for (int i2 = 0; i2 < this.f1039a; i2++) {
            iM5783Z += AbstractC1355cC.m5783Z(this.f1040b[i2] >>> 3, (AbstractC2233qB) this.f1041c[i2]);
        }
        this.f1042d = iM5783Z;
        return iM5783Z;
    }

    public final void m1552j(InterfaceC0017AG interfaceC0017AG) {
        if (this.f1039a == 0) {
            return;
        }
        if (interfaceC0017AG.mo86a() == 1) {
            for (int i = 0; i < this.f1039a; i++) {
                m1542f(this.f1040b[i], this.f1041c[i], interfaceC0017AG);
            }
            return;
        }
        for (int i2 = this.f1039a - 1; i2 >= 0; i2--) {
            m1542f(this.f1040b[i2], this.f1041c[i2], interfaceC0017AG);
        }
    }

    public final void m1553m() {
        if (this.f1043e) {
            this.f1043e = false;
        }
    }

    public final void m1554n() {
        if (!this.f1043e) {
            throw new UnsupportedOperationException();
        }
    }

    public C0338HF(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f1042d = -1;
        this.f1039a = i;
        this.f1040b = iArr;
        this.f1041c = objArr;
        this.f1043e = z;
    }
}
