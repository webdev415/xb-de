package p000;

import java.util.Arrays;
import java.util.Map;

public final class C0878T4 extends AbstractC0946Uh {

    public static final char[] f2705d = "0123456789-$:/.+ABCD".toCharArray();

    public static final int[] f2706e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    public static final char[] f2707f = {'A', 'B', 'C', 'D'};

    public final StringBuilder f2708a = new StringBuilder(20);

    public int[] f2709b = new int[80];

    public int f2710c = 0;

    public static boolean m4111i(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) throws C2340sh {
        int i2;
        Arrays.fill(this.f2709b, 0);
        m4114l(c0233f2);
        int iM4113k = m4113k();
        this.f2708a.setLength(0);
        int i3 = iM4113k;
        while (true) {
            int iM4115m = m4115m(i3);
            if (iM4115m == -1) {
                throw C2340sh.m9579a();
            }
            this.f2708a.append((char) iM4115m);
            i2 = i3 + 8;
            if ((this.f2708a.length() > 1 && m4111i(f2707f, f2705d[iM4115m])) || i2 >= this.f2710c) {
                break;
            }
            i3 = i2;
        }
        int i4 = i3 + 7;
        int i5 = this.f2709b[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.f2709b[i2 + i7];
        }
        if (i2 < this.f2710c && i5 < i6 / 2) {
            throw C2340sh.m9579a();
        }
        m4116n(iM4113k);
        for (int i8 = 0; i8 < this.f2708a.length(); i8++) {
            StringBuilder sb = this.f2708a;
            sb.setCharAt(i8, f2705d[sb.charAt(i8)]);
        }
        char cCharAt = this.f2708a.charAt(0);
        char[] cArr = f2707f;
        if (!m4111i(cArr, cCharAt)) {
            throw C2340sh.m9579a();
        }
        StringBuilder sb2 = this.f2708a;
        if (!m4111i(cArr, sb2.charAt(sb2.length() - 1))) {
            throw C2340sh.m9579a();
        }
        if (this.f2708a.length() <= 3) {
            throw C2340sh.m9579a();
        }
        if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f2708a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f2708a.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < iM4113k; i10++) {
            i9 += this.f2709b[i10];
        }
        float f = i9;
        while (iM4113k < i4) {
            i9 += this.f2709b[iM4113k];
            iM4113k++;
        }
        float f2 = i;
        return new C0720Pk(this.f2708a.toString(), null, new C0857Sk[]{new C0857Sk(f, f2), new C0857Sk(i9, f2)}, BarcodeFormat.CODABAR);
    }

    public final void m4112j(int i) {
        int[] iArr = this.f2709b;
        int i2 = this.f2710c;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.f2710c = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[i3 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f2709b = iArr2;
        }
    }

    public final int m4113k() throws C2340sh {
        for (int i = 1; i < this.f2710c; i += 2) {
            int iM4115m = m4115m(i);
            if (iM4115m != -1 && m4111i(f2707f, f2705d[iM4115m])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.f2709b[i3];
                }
                if (i == 1 || this.f2709b[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw C2340sh.m9579a();
    }

    public final void m4114l(C0233F2 c0233f2) throws C2340sh {
        int i = 0;
        this.f2710c = 0;
        int iM1192n = c0233f2.m1192n(0);
        int iM1193o = c0233f2.m1193o();
        if (iM1192n >= iM1193o) {
            throw C2340sh.m9579a();
        }
        boolean z = true;
        while (iM1192n < iM1193o) {
            if (c0233f2.m1189h(iM1192n) != z) {
                i++;
            } else {
                m4112j(i);
                z = !z;
                i = 1;
            }
            iM1192n++;
        }
        m4112j(i);
    }

    public final int m4115m(int i) {
        int i2 = i + 7;
        if (i2 >= this.f2710c) {
            return -1;
        }
        int[] iArr = this.f2709b;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = f2706e;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }

    public final void m4116n(int i) throws C2340sh {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int[] iArr2 = new int[4];
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int length = this.f2708a.length() - 1;
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = f2706e[this.f2708a.charAt(i3)];
            for (int i5 = 6; i5 >= 0; i5--) {
                int i6 = (i5 & 1) + ((i4 & 1) << 1);
                iArr[i6] = iArr[i6] + this.f2709b[i2 + i5];
                iArr2[i6] = iArr2[i6] + 1;
                i4 >>= 1;
            }
            if (i3 >= length) {
                break;
            }
            i2 += 8;
            i3++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i7 = 0; i7 < 2; i7++) {
            fArr2[i7] = 0.0f;
            int i8 = i7 + 2;
            int i9 = iArr[i8];
            int i10 = iArr2[i8];
            float f = ((iArr[i7] / iArr2[i7]) + (i9 / i10)) / 2.0f;
            fArr2[i8] = f;
            fArr[i7] = f;
            fArr[i8] = ((i9 * 2.0f) + 1.5f) / i10;
        }
        int i11 = i;
        int i12 = 0;
        loop3: while (true) {
            int i13 = f2706e[this.f2708a.charAt(i12)];
            for (int i14 = 6; i14 >= 0; i14--) {
                int i15 = (i14 & 1) + ((i13 & 1) << 1);
                float f2 = this.f2709b[i11 + i14];
                if (f2 < fArr2[i15] || f2 > fArr[i15]) {
                    break loop3;
                }
                i13 >>= 1;
            }
            if (i12 >= length) {
                return;
            }
            i11 += 8;
            i12++;
        }
        throw C2340sh.m9579a();
    }
}
