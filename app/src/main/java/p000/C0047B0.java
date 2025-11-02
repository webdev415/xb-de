package p000;

import java.util.ArrayList;
import java.util.List;

public final class C0047B0 {

    public final C0325H2 f104a;

    public final int f106c;

    public final int f107d;

    public final int f108e;

    public final int f109f;

    public final float f110g;

    public final InterfaceC0903Tk f112i;

    public final List f105b = new ArrayList<>(5);

    public final int[] f111h = new int[3];

    public C0047B0(C0325H2 c0325h2, int i, int i2, int i3, int i4, float f, InterfaceC0903Tk interfaceC0903Tk) {
        this.f104a = c0325h2;
        this.f106c = i;
        this.f107d = i2;
        this.f108e = i3;
        this.f109f = i4;
        this.f110g = f;
        this.f112i = interfaceC0903Tk;
    }

    public static float m176a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    public final float m177b(int i, int i2, int i3, int i4) {
        C0325H2 c0325h2 = this.f104a;
        int iM1496j = c0325h2.m1496j();
        int[] iArr = this.f111h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && c0325h2.m1493e(i2, i5)) {
            int i6 = iArr[1];
            if (i6 > i3) {
                break;
            }
            iArr[1] = i6 + 1;
            i5--;
        }
        if (i5 >= 0 && iArr[1] <= i3) {
            while (i5 >= 0 && !c0325h2.m1493e(i2, i5)) {
                int i7 = iArr[0];
                if (i7 > i3) {
                    break;
                }
                iArr[0] = i7 + 1;
                i5--;
            }
            if (iArr[0] > i3) {
                return Float.NaN;
            }
            int i8 = i + 1;
            while (i8 < iM1496j && c0325h2.m1493e(i2, i8)) {
                int i9 = iArr[1];
                if (i9 > i3) {
                    break;
                }
                iArr[1] = i9 + 1;
                i8++;
            }
            if (i8 != iM1496j && iArr[1] <= i3) {
                while (i8 < iM1496j && !c0325h2.m1493e(i2, i8)) {
                    int i10 = iArr[2];
                    if (i10 > i3) {
                        break;
                    }
                    iArr[2] = i10 + 1;
                    i8++;
                }
                int i11 = iArr[2];
                if (i11 <= i3 && Math.abs(((iArr[0] + iArr[1]) + i11) - i4) * 5 < i4 * 2 && m179d(iArr)) {
                    return m176a(iArr, i8);
                }
            }
        }
        return Float.NaN;
    }

    public C0001A0 m178c() throws C2340sh {
        C0001A0 c0001a0M180e;
        C0001A0 c0001a0M180e2;
        int i = this.f106c;
        int i2 = this.f109f;
        int i3 = this.f108e + i;
        int i4 = this.f107d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.f104a.m1493e(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            while (i7 < i3) {
                if (!this.f104a.m1493e(i7, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i8 != 2) {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                } else {
                    if (m179d(iArr) && (c0001a0M180e2 = m180e(iArr, i6, i7)) != null) {
                        return c0001a0M180e2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                }
                i7++;
            }
            if (m179d(iArr) && (c0001a0M180e = m180e(iArr, i6, i3)) != null) {
                return c0001a0M180e;
            }
        }
        if (this.f105b.isEmpty()) {
            throw C2340sh.m9579a();
        }
        return (C0001A0) this.f105b.get(0);
    }

    public final boolean m179d(int[] iArr) {
        float f = this.f110g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    public final C0001A0 m180e(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fM176a = m176a(iArr, i2);
        float fM177b = m177b(i, (int) fM176a, iArr[1] * 2, i3);
        if (Float.isNaN(fM177b)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (C0001A0 c0001a0 : this.f105b) {
            if (c0001a0.m2f(f, fM177b, fM176a)) {
                return c0001a0.m3g(fM177b, fM176a, f);
            }
        }
        C0001A0 c0001a02 = new C0001A0(fM176a, fM177b, f);
        this.f105b.add(c0001a02);
        InterfaceC0903Tk interfaceC0903Tk = this.f112i;
        if (interfaceC0903Tk == null) {
            return null;
        }
        interfaceC0903Tk.mo3293a(c0001a02);
        return null;
    }
}
