package p000;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractC0561M8 {

    public static final int[] f1756a = {0, 4, 1, 5};

    public static final int[] f1757b = {6, 2, 7, 3};

    public static final int[] f1758c = {8, 1, 1, 1, 1, 1, 1, 3};

    public static final int[] f1759d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static void m2830a(C0857Sk[] c0857SkArr, C0857Sk[] c0857SkArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            c0857SkArr[iArr[i]] = c0857SkArr2[i];
        }
    }

    public static C2203pi m2831b(BinaryBitmap binaryBitmap, Map map, boolean z) {
        C0325H2 c0325h2M597a = binaryBitmap.m597a();
        List listM2832c = m2832c(z, c0325h2M597a);
        if (listM2832c.isEmpty()) {
            c0325h2M597a = c0325h2M597a.clone();
            c0325h2M597a.m1500q();
            listM2832c = m2832c(z, c0325h2M597a);
        }
        return new C2203pi(c0325h2M597a, listM2832c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r3.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r4 = (p000.C0857Sk[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r7 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.m4068d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.m4068d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static List m2832c(boolean r8, C0325H2 r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
            r3 = r2
        L8:
            r4 = r3
        L9:
            int r5 = r9.m1496j()
            if (r2 >= r5) goto L73
            Sk[] r3 = m2835f(r9, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L4f
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L4f
            if (r4 == 0) goto L73
            java.util.Iterator r3 = r0.iterator()
        L23:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L4b
            java.lang.Object r4 = r3.next()
            Sk[] r4 = (p000.C0857Sk[]) r4
            r7 = r4[r6]
            if (r7 == 0) goto L3d
            float r2 = (float) r2
            float r7 = r7.m4068d()
            float r2 = java.lang.Math.max(r2, r7)
            int r2 = (int) r2
        L3d:
            r4 = r4[r5]
            if (r4 == 0) goto L23
            float r4 = r4.m4068d()
            int r4 = (int) r4
            int r2 = java.lang.Math.max(r2, r4)
            goto L23
        L4b:
            int r2 = r2 + 5
            r3 = r1
            goto L8
        L4f:
            r0.add(r3)
            if (r8 == 0) goto L73
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L68
            float r4 = r4.m4067c()
            int r4 = (int) r4
            r2 = r3[r2]
        L60:
            float r2 = r2.m4068d()
            int r2 = (int) r2
            r3 = r4
            r4 = r6
            goto L9
        L68:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.m4067c()
            int r4 = (int) r4
            r2 = r3[r2]
            goto L60
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0561M8.m2832c(boolean, H2):java.util.List");
    }

    public static int[] m2833d(C0325H2 c0325h2, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (c0325h2.m1493e(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        boolean z = false;
        while (i < i3) {
            if (c0325h2.m1493e(i, i2) != z) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (m2836g(iArr2, iArr) < 0.42f) {
                        return new int[]{i6, i};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z = !z;
            }
            i++;
        }
        if (i7 != length - 1 || m2836g(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    public static C0857Sk[] m2834e(C0325H2 c0325h2, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        C0857Sk[] c0857SkArr = new C0857Sk[4];
        int[] iArr2 = new int[iArr.length];
        int i6 = i3;
        while (true) {
            if (i6 >= i) {
                z = false;
                break;
            }
            int[] iArrM2833d = m2833d(c0325h2, i4, i6, i2, iArr, iArr2);
            if (iArrM2833d != null) {
                int i7 = i6;
                int[] iArr3 = iArrM2833d;
                while (i7 > 0) {
                    int i8 = i7 - 1;
                    int[] iArrM2833d2 = m2833d(c0325h2, i4, i8, i2, iArr, iArr2);
                    if (iArrM2833d2 == null) {
                        break;
                    }
                    iArr3 = iArrM2833d2;
                    i7 = i8;
                }
                float f = i7;
                c0857SkArr[0] = new C0857Sk(iArr3[0], f);
                c0857SkArr[1] = new C0857Sk(iArr3[1], f);
                z = true;
                i6 = i7;
            } else {
                i6 += 5;
            }
        }
        int i9 = i6 + 1;
        if (z) {
            int[] iArr4 = {(int) c0857SkArr[0].m4067c(), (int) c0857SkArr[1].m4067c()};
            int i10 = i9;
            int i11 = 0;
            while (true) {
                if (i10 >= i) {
                    i5 = i11;
                    break;
                }
                i5 = i11;
                int[] iArrM2833d3 = m2833d(c0325h2, iArr4[0], i10, i2, iArr, iArr2);
                if (iArrM2833d3 != null && Math.abs(iArr4[0] - iArrM2833d3[0]) < 5 && Math.abs(iArr4[1] - iArrM2833d3[1]) < 5) {
                    iArr4 = iArrM2833d3;
                    i11 = 0;
                } else {
                    if (i5 > 25) {
                        break;
                    }
                    i11 = i5 + 1;
                }
                i10++;
            }
            i9 = i10 - (i5 + 1);
            float f2 = i9;
            c0857SkArr[2] = new C0857Sk(iArr4[0], f2);
            c0857SkArr[3] = new C0857Sk(iArr4[1], f2);
        }
        if (i9 - i6 < 10) {
            Arrays.fill(c0857SkArr, (Object) null);
        }
        return c0857SkArr;
    }

    public static C0857Sk[] m2835f(C0325H2 c0325h2, int i, int i2) {
        int iM1496j = c0325h2.m1496j();
        int iM1499o = c0325h2.m1499o();
        C0857Sk[] c0857SkArr = new C0857Sk[8];
        m2830a(c0857SkArr, m2834e(c0325h2, iM1496j, iM1499o, i, i2, f1758c), f1756a);
        C0857Sk c0857Sk = c0857SkArr[4];
        if (c0857Sk != null) {
            i2 = (int) c0857Sk.m4067c();
            i = (int) c0857SkArr[4].m4068d();
        }
        m2830a(c0857SkArr, m2834e(c0325h2, iM1496j, iM1499o, i, i2, f1759d), f1757b);
        return c0857SkArr;
    }

    public static float m2836g(int[] iArr, int[] iArr2) {
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
        float f = i;
        float f2 = f / i2;
        float f3 = 0.8f * f2;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f5 = iArr2[i4] * f2;
            float f6 = iArr[i4];
            float f7 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f7 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f7;
        }
        return f4 / f;
    }
}
