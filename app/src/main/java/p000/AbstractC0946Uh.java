package p000;

import java.util.Arrays;
import java.util.Map;

public abstract class AbstractC0946Uh implements InterfaceC1226ak {
    public static float m4263f(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static void m4264g(C0233F2 c0233f2, int i, int[] iArr) throws C2340sh {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iM1193o = c0233f2.m1193o();
        if (i >= iM1193o) {
            throw C2340sh.m9579a();
        }
        boolean z = !c0233f2.m1189h(i);
        while (i < iM1193o) {
            if (c0233f2.m1189h(i) == z) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != iM1193o) {
                throw C2340sh.m9579a();
            }
        }
    }

    public static void m4265h(C0233F2 c0233f2, int i, int[] iArr) throws C2340sh {
        int length = iArr.length;
        boolean zM1189h = c0233f2.m1189h(i);
        while (i > 0 && length >= 0) {
            i--;
            if (c0233f2.m1189h(i) != zM1189h) {
                length--;
                zM1189h = !zM1189h;
            }
        }
        if (length >= 0) {
            throw C2340sh.m9579a();
        }
        m4264g(c0233f2, i + 1, iArr);
    }

    @Override
    public C0720Pk decode(BinaryBitmap binaryBitmap) {
        return mo139b(binaryBitmap, null);
    }

    @Override
    public C0720Pk mo139b(BinaryBitmap binaryBitmap, Map map) throws C2340sh {
        try {
            return m4266e(binaryBitmap, map);
        } catch (C2340sh e) {
            if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER) || !binaryBitmap.m601e()) {
                throw e;
            }
            BinaryBitmap binaryBitmapM602F = binaryBitmap.m602f();
            C0720Pk c0720PkM4266e = m4266e(binaryBitmapM602F, map);
            Map mapM3578d = c0720PkM4266e.m3578d();
            int iIntValue = 270;
            if (mapM3578d != null) {
                EnumC0811Rk enumC0811Rk = EnumC0811Rk.ORIENTATION;
                if (mapM3578d.containsKey(enumC0811Rk)) {
                    iIntValue = (((Integer) mapM3578d.get(enumC0811Rk)).intValue() + 270) % 360;
                }
            }
            c0720PkM4266e.m3582h(EnumC0811Rk.ORIENTATION, Integer.valueOf(iIntValue));
            C0857Sk[] c0857SkArrM3579e = c0720PkM4266e.m3579e();
            if (c0857SkArrM3579e != null) {
                int iM599c = binaryBitmapM602F.m599c();
                for (int i = 0; i < c0857SkArrM3579e.length; i++) {
                    c0857SkArrM3579e[i] = new C0857Sk((iM599c - c0857SkArrM3579e[i].m4068d()) - 1.0f, c0857SkArrM3579e[i].m4067c());
                }
            }
            return c0720PkM4266e;
        }
    }

    public abstract C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map);

    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C0720Pk m4266e(BinaryBitmap r22, Map r23) throws C2340sh {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0946Uh.m4266e(D2, java.util.Map):Pk");
    }

    @Override
    public void mo140c() {
    }
}
