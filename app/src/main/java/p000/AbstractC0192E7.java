package p000;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public abstract class AbstractC0192E7 {

    public static final char[] f462a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    public static class a {

        public static final int[] f463a;

        static {
            int[] iArr = new int[EnumC0991Vg.values().length];
            f463a = iArr;
            try {
                iArr[EnumC0991Vg.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f463a[EnumC0991Vg.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f463a[EnumC0991Vg.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f463a[EnumC0991Vg.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f463a[EnumC0991Vg.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f463a[EnumC0991Vg.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f463a[EnumC0991Vg.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f463a[EnumC0991Vg.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f463a[EnumC0991Vg.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f463a[EnumC0991Vg.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static C0698P7 m863a(byte[] bArr, C0126Co c0126Co, EnumC1363ca enumC1363ca, Map map) throws C2610yb {
        EnumC0991Vg enumC0991Vg;
        C0509L2 c0509l2 = new C0509L2(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList<>(1);
        int i = -1;
        int iM2579d = -1;
        boolean z = false;
        EnumC2364t4 enumC2364t4M9678e = null;
        do {
            try {
                EnumC0991Vg enumC0991VgM4405c = c0509l2.m2576a() < 4 ? EnumC0991Vg.TERMINATOR : EnumC0991Vg.m4405c(c0509l2.m2579d(4));
                int[] iArr = a.f463a;
                switch (iArr[enumC0991VgM4405c.ordinal()]) {
                    case 5:
                        enumC0991Vg = enumC0991VgM4405c;
                        break;
                    case 6:
                    case 7:
                        enumC0991Vg = enumC0991VgM4405c;
                        z = true;
                        break;
                    case 8:
                        enumC0991Vg = enumC0991VgM4405c;
                        if (c0509l2.m2576a() < 16) {
                            throw C2610yb.m10853a();
                        }
                        int iM2579d2 = c0509l2.m2579d(8);
                        iM2579d = c0509l2.m2579d(8);
                        i = iM2579d2;
                        break;
                    case 9:
                        enumC0991Vg = enumC0991VgM4405c;
                        enumC2364t4M9678e = EnumC2364t4.m9678e(m869g(c0509l2));
                        if (enumC2364t4M9678e == null) {
                            throw C2610yb.m10853a();
                        }
                        break;
                    case 10:
                        enumC0991Vg = enumC0991VgM4405c;
                        int iM2579d3 = c0509l2.m2579d(4);
                        int iM2579d4 = c0509l2.m2579d(enumC0991Vg.m4407g(c0126Co));
                        if (iM2579d3 == 1) {
                            m866d(c0509l2, sb, iM2579d4);
                        }
                        break;
                    default:
                        int iM2579d5 = c0509l2.m2579d(enumC0991VgM4405c.m4407g(c0126Co));
                        int i2 = iArr[enumC0991VgM4405c.ordinal()];
                        if (i2 == 1) {
                            enumC0991Vg = enumC0991VgM4405c;
                            m868f(c0509l2, sb, iM2579d5);
                        } else if (i2 == 2) {
                            enumC0991Vg = enumC0991VgM4405c;
                            m864b(c0509l2, sb, iM2579d5, z);
                        } else if (i2 == 3) {
                            enumC0991Vg = enumC0991VgM4405c;
                            m865c(c0509l2, sb, iM2579d5, enumC2364t4M9678e, arrayList, map);
                        } else {
                            if (i2 != 4) {
                                throw C2610yb.m10853a();
                            }
                            m867e(c0509l2, sb, iM2579d5);
                            enumC0991Vg = enumC0991VgM4405c;
                        }
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw C2610yb.m10853a();
            }
        } while (enumC0991Vg != EnumC0991Vg.TERMINATOR);
        return new C0698P7(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, enumC1363ca == null ? null : enumC1363ca.toString(), i, iM2579d);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m864b(C0509L2 r3, StringBuilder r4, int r5, boolean r6) throws C2610yb {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.m2576a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.m2579d(r2)
            int r2 = r1 / 45
            char r2 = m870h(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = m870h(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            yb r3 = p000.C2610yb.m10853a()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.m2576a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.m2579d(r2)
            char r3 = m870h(r3)
            r4.append(r3)
            goto L47
        L42:
            yb r3 = p000.C2610yb.m10853a()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0192E7.m864b(L2, java.lang.StringBuilder, int, boolean):void");
    }

    public static void m865c(C0509L2 c0509l2, StringBuilder sb, int i, EnumC2364t4 enumC2364t4, Collection collection, Map map) throws C2610yb {
        if ((i << 3) > c0509l2.m2576a()) {
            throw C2610yb.m10853a();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) c0509l2.m2579d(8);
        }
        try {
            sb.append(new String(bArr, enumC2364t4 == null ? AbstractC0032Am.m142a(bArr, map) : enumC2364t4.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw C2610yb.m10853a();
        }
    }

    public static void m866d(C0509L2 c0509l2, StringBuilder sb, int i) throws C2610yb {
        if (i * 13 > c0509l2.m2576a()) {
            throw C2610yb.m10853a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iM2579d = c0509l2.m2579d(13);
            int i3 = (iM2579d % 96) | ((iM2579d / 96) << 8);
            int i4 = i3 + (i3 < 2560 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw C2610yb.m10853a();
        }
    }

    public static void m867e(C0509L2 c0509l2, StringBuilder sb, int i) throws C2610yb {
        if (i * 13 > c0509l2.m2576a()) {
            throw C2610yb.m10853a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iM2579d = c0509l2.m2579d(13);
            int i3 = (iM2579d % 192) | ((iM2579d / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw C2610yb.m10853a();
        }
    }

    public static void m868f(C0509L2 c0509l2, StringBuilder sb, int i) throws C2610yb {
        while (i >= 3) {
            if (c0509l2.m2576a() < 10) {
                throw C2610yb.m10853a();
            }
            int iM2579d = c0509l2.m2579d(10);
            if (iM2579d >= 1000) {
                throw C2610yb.m10853a();
            }
            sb.append(m870h(iM2579d / 100));
            sb.append(m870h((iM2579d / 10) % 10));
            sb.append(m870h(iM2579d % 10));
            i -= 3;
        }
        if (i == 2) {
            if (c0509l2.m2576a() < 7) {
                throw C2610yb.m10853a();
            }
            int iM2579d2 = c0509l2.m2579d(7);
            if (iM2579d2 >= 100) {
                throw C2610yb.m10853a();
            }
            sb.append(m870h(iM2579d2 / 10));
            sb.append(m870h(iM2579d2 % 10));
            return;
        }
        if (i == 1) {
            if (c0509l2.m2576a() < 4) {
                throw C2610yb.m10853a();
            }
            int iM2579d3 = c0509l2.m2579d(4);
            if (iM2579d3 >= 10) {
                throw C2610yb.m10853a();
            }
            sb.append(m870h(iM2579d3));
        }
    }

    public static int m869g(C0509L2 c0509l2) throws C2610yb {
        int iM2579d = c0509l2.m2579d(8);
        if ((iM2579d & 128) == 0) {
            return iM2579d & 127;
        }
        if ((iM2579d & 192) == 128) {
            return c0509l2.m2579d(8) | ((iM2579d & 63) << 8);
        }
        if ((iM2579d & 224) == 192) {
            return c0509l2.m2579d(16) | ((iM2579d & 31) << 16);
        }
        throw C2610yb.m10853a();
    }

    public static char m870h(int i) throws C2610yb {
        char[] cArr = f462a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw C2610yb.m10853a();
    }
}
