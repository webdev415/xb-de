package p000;

/* loaded from: classes.dex */
public abstract class AbstractC2620yl {
    public static final int m10902a(int[] iArr, int i, int i2, int i3) {
        AbstractC0116Ce.m476e(iArr, "$this$binarySearch");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final int m10903b(C2574xl c2574xl, int i) {
        AbstractC0116Ce.m476e(c2574xl, "$this$segment");
        int iM10902a = m10902a(c2574xl.m10780z(), i + 1, 0, c2574xl.m10777A().length);
        return iM10902a >= 0 ? iM10902a : ~iM10902a;
    }
}
