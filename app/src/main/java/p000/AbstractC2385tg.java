package p000;

public abstract class AbstractC2385tg {
    public static int m9708a(C0050B3 c0050b3) {
        return m9709b(c0050b3, true) + m9709b(c0050b3, false);
    }

    public static int m9709b(C0050B3 c0050b3, boolean z) {
        int iM192d = z ? c0050b3.m192d() : c0050b3.m193e();
        int iM193e = z ? c0050b3.m193e() : c0050b3.m192d();
        byte[][] bArrM191c = c0050b3.m191c();
        int i = 0;
        for (int i2 = 0; i2 < iM192d; i2++) {
            byte b = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < iM193e; i4++) {
                byte b2 = z ? bArrM191c[i2][i4] : bArrM191c[i4][i2];
                if (b2 == b) {
                    i3++;
                } else {
                    if (i3 >= 5) {
                        i += i3 - 2;
                    }
                    i3 = 1;
                    b = b2;
                }
            }
            if (i3 >= 5) {
                i += i3 - 2;
            }
        }
        return i;
    }

    public static int m9710c(C0050B3 c0050b3) {
        byte[][] bArrM191c = c0050b3.m191c();
        int iM193e = c0050b3.m193e();
        int iM192d = c0050b3.m192d();
        int i = 0;
        for (int i2 = 0; i2 < iM192d - 1; i2++) {
            byte[] bArr = bArrM191c[i2];
            int i3 = 0;
            while (i3 < iM193e - 1) {
                byte b = bArr[i3];
                int i4 = i3 + 1;
                if (b == bArr[i4]) {
                    byte[] bArr2 = bArrM191c[i2 + 1];
                    if (b == bArr2[i3] && b == bArr2[i4]) {
                        i++;
                    }
                }
                i3 = i4;
            }
        }
        return i * 3;
    }

    public static int m9711d(C0050B3 c0050b3) {
        byte[][] bArrM191c = c0050b3.m191c();
        int iM193e = c0050b3.m193e();
        int iM192d = c0050b3.m192d();
        int i = 0;
        for (int i2 = 0; i2 < iM192d; i2++) {
            for (int i3 = 0; i3 < iM193e; i3++) {
                byte[] bArr = bArrM191c[i2];
                int i4 = i3 + 6;
                if (i4 < iM193e && bArr[i3] == 1 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1 && bArr[i3 + 3] == 1 && bArr[i3 + 4] == 1 && bArr[i3 + 5] == 0 && bArr[i4] == 1 && (m9714g(bArr, i3 - 4, i3) || m9714g(bArr, i3 + 7, i3 + 11))) {
                    i++;
                }
                int i5 = i2 + 6;
                if (i5 < iM192d && bArrM191c[i2][i3] == 1 && bArrM191c[i2 + 1][i3] == 0 && bArrM191c[i2 + 2][i3] == 1 && bArrM191c[i2 + 3][i3] == 1 && bArrM191c[i2 + 4][i3] == 1 && bArrM191c[i2 + 5][i3] == 0 && bArrM191c[i5][i3] == 1 && (m9715h(bArrM191c, i3, i2 - 4, i2) || m9715h(bArrM191c, i3, i2 + 7, i2 + 11))) {
                    i++;
                }
            }
        }
        return i * 40;
    }

    public static int m9712e(C0050B3 c0050b3) {
        byte[][] bArrM191c = c0050b3.m191c();
        int iM193e = c0050b3.m193e();
        int iM192d = c0050b3.m192d();
        int i = 0;
        for (int i2 = 0; i2 < iM192d; i2++) {
            byte[] bArr = bArrM191c[i2];
            for (int i3 = 0; i3 < iM193e; i3++) {
                if (bArr[i3] == 1) {
                    i++;
                }
            }
        }
        int iM192d2 = c0050b3.m192d() * c0050b3.m193e();
        return ((Math.abs((i << 1) - iM192d2) * 10) / iM192d2) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m9713f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L30;
                case 1: goto L31;
                case 2: goto L38;
                case 3: goto L34;
                case 4: goto L2c;
                case 5: goto L25;
                case 6: goto L1e;
                case 7: goto L14;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid mask pattern: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L14:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
        L1c:
            r1 = r1 & r0
            goto L3a
        L1e:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L1c
        L25:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L3a
        L2c:
            int r3 = r3 / 2
            int r2 = r2 / 3
        L30:
            int r3 = r3 + r2
        L31:
            r1 = r3 & 1
            goto L3a
        L34:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L3a
        L38:
            int r1 = r2 % 3
        L3a:
            if (r1 != 0) goto L3d
            return r0
        L3d:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2385tg.m9713f(int, int, int):boolean");
    }

    public static boolean m9714g(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, bArr.length);
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean m9715h(byte[][] bArr, int i, int i2, int i3) {
        int iMin = Math.min(i3, bArr.length);
        for (int iMax = Math.max(i2, 0); iMax < iMin; iMax++) {
            if (bArr[iMax][i] == 1) {
                return false;
            }
        }
        return true;
    }
}
