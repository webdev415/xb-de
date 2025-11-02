package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class C2136o7 implements InterfaceC0081Bp {
    public static C0325H2 m8840b(C0050B3 c0050b3, int i, int i2) {
        C0325H2 c0325h2;
        int iM193e = c0050b3.m193e();
        int iM192d = c0050b3.m192d();
        int iMax = Math.max(i, iM193e);
        int iMax2 = Math.max(i2, iM192d);
        int iMin = Math.min(iMax / iM193e, iMax2 / iM192d);
        int i3 = (iMax - (iM193e * iMin)) / 2;
        int i4 = (iMax2 - (iM192d * iMin)) / 2;
        if (i2 < iM192d || i < iM193e) {
            c0325h2 = new C0325H2(iM193e, iM192d);
            i3 = 0;
            i4 = 0;
        } else {
            c0325h2 = new C0325H2(i, i2);
        }
        c0325h2.m1490b();
        int i5 = 0;
        while (i5 < iM192d) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < iM193e) {
                if (c0050b3.m190b(i7, i5) == 1) {
                    c0325h2.m1502s(i6, i4, iMin, iMin);
                }
                i7++;
                i6 += iMin;
            }
            i5++;
            i4 += iMin;
        }
        return c0325h2;
    }

    public static C0325H2 m8841c(C1672e8 c1672e8, C0997Vm c0997Vm, int i, int i2) {
        int iM4432h = c0997Vm.m4432h();
        int iM4431g = c0997Vm.m4431g();
        C0050B3 c0050b3 = new C0050B3(c0997Vm.m4434j(), c0997Vm.m4433i());
        int i3 = 0;
        for (int i4 = 0; i4 < iM4431g; i4++) {
            if (i4 % c0997Vm.f2995e == 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < c0997Vm.m4434j(); i6++) {
                    c0050b3.m195g(i5, i3, i6 % 2 == 0);
                    i5++;
                }
                i3++;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < iM4432h; i8++) {
                if (i8 % c0997Vm.f2994d == 0) {
                    c0050b3.m195g(i7, i3, true);
                    i7++;
                }
                c0050b3.m195g(i7, i3, c1672e8.m7394e(i8, i4));
                int i9 = i7 + 1;
                int i10 = c0997Vm.f2994d;
                if (i8 % i10 == i10 - 1) {
                    c0050b3.m195g(i9, i3, i4 % 2 == 0);
                    i7 += 2;
                } else {
                    i7 = i9;
                }
            }
            int i11 = i3 + 1;
            int i12 = c0997Vm.f2995e;
            if (i4 % i12 == i12 - 1) {
                int i13 = 0;
                for (int i14 = 0; i14 < c0997Vm.m4434j(); i14++) {
                    c0050b3.m195g(i13, i11, true);
                    i13++;
                }
                i3 += 2;
            } else {
                i3 = i11;
            }
        }
        return m8840b(c0050b3, i, i2);
    }

    @Override
    public C0325H2 mo319a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        }
        EnumC1043Wm enumC1043Wm = EnumC1043Wm.FORCE_NONE;
        if (map != null) {
            EnumC1043Wm enumC1043Wm2 = (EnumC1043Wm) map.get(EnumC0883T9.DATA_MATRIX_SHAPE);
            if (enumC1043Wm2 != null) {
                enumC1043Wm = enumC1043Wm2;
            }
            AbstractC2524wh.m10586a(map.get(EnumC0883T9.MIN_SIZE));
            AbstractC2524wh.m10586a(map.get(EnumC0883T9.MAX_SIZE));
        }
        String strM8745b = AbstractC2105nd.m8745b(str, enumC1043Wm, null, null);
        C0997Vm c0997VmM4424l = C0997Vm.m4424l(strM8745b.length(), enumC1043Wm, null, null, true);
        C1672e8 c1672e8 = new C1672e8(AbstractC1317ba.m5658b(strM8745b, c0997VmM4424l), c0997VmM4424l.m4432h(), c0997VmM4424l.m4431g());
        c1672e8.m7397h();
        return m8841c(c1672e8, c0997VmM4424l, i, i2);
    }
}
