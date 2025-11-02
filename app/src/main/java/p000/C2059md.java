package p000;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class C2059md {

    public static final String[] f6175b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    public static final int[][] f6176c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    public static final int[][] f6177d;

    public static final int[][] f6178e;

    public final byte[] f6179a;

    public class a implements Comparator {
        public a() {
        }

        @Override
        public int compare(C2437um c2437um, C2437um c2437um2) {
            return c2437um.m10189e() - c2437um2.m10189e();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        f6177d = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            f6177d[0][i] = i - 63;
        }
        f6177d[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            f6177d[1][i2] = i2 - 95;
        }
        f6177d[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            f6177d[2][i3] = i3 - 46;
        }
        int[] iArr2 = f6177d[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i4 = 0; i4 < 28; i4++) {
            f6177d[3][iArr3[i4]] = i4;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i5 = 0; i5 < 31; i5++) {
            int i6 = iArr4[i5];
            if (i6 > 0) {
                f6177d[4][i6] = i5;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        f6178e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f6178e;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public C2059md(byte[] bArr) {
        this.f6179a = bArr;
    }

    public static Collection m8461b(Iterable iterable) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            C2437um c2437um = (C2437um) it.next();
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    linkedList.add(c2437um);
                    break;
                }
                C2437um c2437um2 = (C2437um) it2.next();
                if (c2437um2.m10191g(c2437um)) {
                    break;
                }
                if (c2437um.m10191g(c2437um2)) {
                    it2.remove();
                }
            }
        }
        return linkedList;
    }

    public static void m8462d(C2437um c2437um, int i, int i2, Collection collection) {
        C2437um c2437umM10187c = c2437um.m10187c(i);
        collection.add(c2437umM10187c.m10192h(4, i2));
        if (c2437um.m10190f() != 4) {
            collection.add(c2437umM10187c.m10193i(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(c2437umM10187c.m10192h(2, 16 - i2).m10192h(2, 1));
        }
        if (c2437um.m10188d() > 0) {
            collection.add(c2437um.m10186a(i).m10186a(i + 1));
        }
    }

    public static Collection m8463f(Iterable iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            m8462d((C2437um) it.next(), i, i2, linkedList);
        }
        return m8461b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0233F2 m8464a() {
        /*
            r8 = this;
            um r0 = p000.C2437um.f7565e
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r1
        L8:
            byte[] r3 = r8.f6179a
            int r4 = r3.length
            if (r2 >= r4) goto L4c
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L15
            r5 = r3[r4]
            goto L16
        L15:
            r5 = r1
        L16:
            r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L38
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L34
            r6 = 46
            if (r3 == r6) goto L30
            r6 = 58
            if (r3 == r6) goto L2c
        L2a:
            r3 = r1
            goto L3d
        L2c:
            if (r5 != r7) goto L2a
            r3 = 5
            goto L3d
        L30:
            if (r5 != r7) goto L2a
            r3 = 3
            goto L3d
        L34:
            if (r5 != r7) goto L2a
            r3 = 4
            goto L3d
        L38:
            r3 = 10
            if (r5 != r3) goto L2a
            r3 = 2
        L3d:
            if (r3 <= 0) goto L45
            java.util.Collection r0 = m8463f(r0, r2, r3)
            r2 = r4
            goto L49
        L45:
            java.util.Collection r0 = r8.m8466e(r0, r2)
        L49:
            int r2 = r2 + 1
            goto L8
        L4c:
            md$a r1 = new md$a
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            um r0 = (p000.C2437um) r0
            byte[] r1 = r8.f6179a
            F2 r0 = r0.m10194j(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2059md.m8464a():F2");
    }

    public final void m8465c(C2437um c2437um, int i, Collection collection) {
        char c = (char) (this.f6179a[i] & 255);
        boolean z = f6177d[c2437um.m10190f()][c] > 0;
        C2437um c2437umM10187c = null;
        for (int i2 = 0; i2 <= 4; i2++) {
            int i3 = f6177d[i2][c];
            if (i3 > 0) {
                if (c2437umM10187c == null) {
                    c2437umM10187c = c2437um.m10187c(i);
                }
                if (!z || i2 == c2437um.m10190f() || i2 == 2) {
                    collection.add(c2437umM10187c.m10192h(i2, i3));
                }
                if (!z && f6178e[c2437um.m10190f()][i2] >= 0) {
                    collection.add(c2437umM10187c.m10193i(i2, i3));
                }
            }
        }
        if (c2437um.m10188d() > 0 || f6177d[c2437um.m10190f()][c] == 0) {
            collection.add(c2437um.m10186a(i));
        }
    }

    public final Collection m8466e(Iterable iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            m8465c((C2437um) it.next(), i, linkedList);
        }
        return m8461b(linkedList);
    }
}
