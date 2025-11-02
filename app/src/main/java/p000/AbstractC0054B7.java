package p000;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class AbstractC0054B7 {

    public static final char[] f124b;

    public static final char[] f126d;

    public static final char[] f123a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static final char[] f125c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static final char[] f127e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    public static class a {

        public static final int[] f128a;

        static {
            int[] iArr = new int[b.values().length];
            f128a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f128a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f128a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f128a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f128a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f124b = cArr;
        f126d = cArr;
    }

    public static C0698P7 m201a(byte[] bArr) throws C2610yb {
        C0509L2 c0509l2 = new C0509L2(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList<>(1);
        b bVarM203c = b.ASCII_ENCODE;
        do {
            b bVar = b.ASCII_ENCODE;
            if (bVarM203c == bVar) {
                bVarM203c = m203c(c0509l2, sb, sb2);
            } else {
                int i = a.f128a[bVarM203c.ordinal()];
                if (i == 1) {
                    m205e(c0509l2, sb);
                } else if (i == 2) {
                    m207g(c0509l2, sb);
                } else if (i == 3) {
                    m202b(c0509l2, sb);
                } else if (i == 4) {
                    m206f(c0509l2, sb);
                } else {
                    if (i != 5) {
                        throw C2610yb.m10853a();
                    }
                    m204d(c0509l2, sb, arrayList);
                }
                bVarM203c = bVar;
            }
            if (bVarM203c == b.PAD_ENCODE) {
                break;
            }
        } while (c0509l2.m2576a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new C0698P7(bArr, string, arrayList, null);
    }

    public static void m202b(C0509L2 c0509l2, StringBuilder sb) throws C2610yb {
        int iM2579d;
        char c;
        int i;
        int[] iArr = new int[3];
        while (c0509l2.m2576a() != 8 && (iM2579d = c0509l2.m2579d(8)) != 254) {
            m208h(iM2579d, c0509l2.m2579d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    c = '\r';
                } else if (i3 == 1) {
                    c = '*';
                } else if (i3 == 2) {
                    c = '>';
                } else if (i3 != 3) {
                    if (i3 < 14) {
                        i = i3 + 44;
                    } else {
                        if (i3 >= 40) {
                            throw C2610yb.m10853a();
                        }
                        i = i3 + 51;
                    }
                    c = (char) i;
                } else {
                    c = ' ';
                }
                sb.append(c);
            }
            if (c0509l2.m2576a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static b m203c(C0509L2 c0509l2, StringBuilder sb, StringBuilder sb2) throws C2610yb {
        String str;
        boolean z = false;
        do {
            int iM2579d = c0509l2.m2579d(8);
            if (iM2579d == 0) {
                throw C2610yb.m10853a();
            }
            if (iM2579d > 128) {
                if (iM2579d != 129) {
                    if (iM2579d > 229) {
                        switch (iM2579d) {
                            case 230:
                                return b.C40_ENCODE;
                            case 231:
                                return b.BASE256_ENCODE;
                            case 232:
                                sb.append((char) 29);
                                break;
                            case 233:
                            case 234:
                            case 241:
                                break;
                            case 235:
                                z = true;
                                break;
                            case 236:
                                str = "[)>\u001e05\u001d";
                                sb.append(str);
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                str = "[)>\u001e06\u001d";
                                sb.append(str);
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return b.ANSIX12_ENCODE;
                            case 239:
                                return b.TEXT_ENCODE;
                            case 240:
                                return b.EDIFACT_ENCODE;
                            default:
                                if (iM2579d != 254 || c0509l2.m2576a() != 0) {
                                    throw C2610yb.m10853a();
                                }
                                break;
                        }
                    } else {
                        int i = iM2579d - 130;
                        if (i < 10) {
                            sb.append('0');
                        }
                        sb.append(i);
                    }
                } else {
                    return b.PAD_ENCODE;
                }
            } else {
                if (z) {
                    iM2579d += 128;
                }
                sb.append((char) (iM2579d - 1));
                return b.ASCII_ENCODE;
            }
        } while (c0509l2.m2576a() > 0);
        return b.ASCII_ENCODE;
    }

    public static void m204d(C0509L2 c0509l2, StringBuilder sb, Collection collection) throws C2610yb {
        int iM2578c = c0509l2.m2578c();
        int i = iM2578c + 2;
        int iM209i = m209i(c0509l2.m2579d(8), iM2578c + 1);
        if (iM209i == 0) {
            iM209i = c0509l2.m2576a() / 8;
        } else if (iM209i >= 250) {
            iM209i = ((iM209i - 249) * 250) + m209i(c0509l2.m2579d(8), i);
            i = iM2578c + 3;
        }
        if (iM209i < 0) {
            throw C2610yb.m10853a();
        }
        byte[] bArr = new byte[iM209i];
        int i2 = 0;
        while (i2 < iM209i) {
            if (c0509l2.m2576a() < 8) {
                throw C2610yb.m10853a();
            }
            bArr[i2] = (byte) m209i(c0509l2.m2579d(8), i);
            i2++;
            i++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e)));
        }
    }

    public static void m205e(C0509L2 c0509l2, StringBuilder sb) throws C2610yb {
        int iM2579d;
        int i;
        char c;
        char c2;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (c0509l2.m2576a() != 8 && (iM2579d = c0509l2.m2579d(8)) != 254) {
            m208h(iM2579d, c0509l2.m2579d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 == 1) {
                        if (z) {
                            i = i4 + 128;
                            c2 = (char) i;
                            sb.append(c2);
                            z = false;
                        }
                        c = (char) i4;
                        sb.append(c);
                    } else if (i2 == 2) {
                        char[] cArr = f124b;
                        if (i4 < cArr.length) {
                            c = cArr[i4];
                            if (z) {
                                c2 = (char) (c + 128);
                                sb.append(c2);
                                z = false;
                            }
                        } else if (i4 == 27) {
                            c = 29;
                        } else {
                            if (i4 != 30) {
                                throw C2610yb.m10853a();
                            }
                            z = true;
                        }
                        sb.append(c);
                    } else {
                        if (i2 != 3) {
                            throw C2610yb.m10853a();
                        }
                        if (z) {
                            i = i4 + 224;
                            c2 = (char) i;
                            sb.append(c2);
                            z = false;
                        } else {
                            i4 += 96;
                            c = (char) i4;
                            sb.append(c);
                        }
                    }
                    i2 = 0;
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = f123a;
                    if (i4 >= cArr2.length) {
                        throw C2610yb.m10853a();
                    }
                    char c3 = cArr2[i4];
                    if (z) {
                        sb.append((char) (c3 + 128));
                        z = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (c0509l2.m2576a() <= 0) {
                return;
            }
        }
    }

    public static void m206f(C0509L2 c0509l2, StringBuilder sb) {
        while (c0509l2.m2576a() > 16) {
            for (int i = 0; i < 4; i++) {
                int iM2579d = c0509l2.m2579d(6);
                if (iM2579d == 31) {
                    int iM2577b = 8 - c0509l2.m2577b();
                    if (iM2577b != 8) {
                        c0509l2.m2579d(iM2577b);
                        return;
                    }
                    return;
                }
                if ((iM2579d & 32) == 0) {
                    iM2579d |= 64;
                }
                sb.append((char) iM2579d);
            }
            if (c0509l2.m2576a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        if (r3 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
    
        r3 = (char) (r4 + 128);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0055, code lost:
    
        if (r3 != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m207g(C0509L2 r9, StringBuilder r10) throws C2610yb {
        /*
            r0 = 3
            int[] r1 = new int[r0]
            r2 = 0
            r3 = r2
            r4 = r3
        L6:
            int r5 = r9.m2576a()
            r6 = 8
            if (r5 != r6) goto Lf
            return
        Lf:
            int r5 = r9.m2579d(r6)
            r7 = 254(0xfe, float:3.56E-43)
            if (r5 != r7) goto L18
            return
        L18:
            int r6 = r9.m2579d(r6)
            m208h(r5, r6, r1)
            r5 = r2
        L20:
            if (r5 >= r0) goto L94
            r6 = r1[r5]
            if (r4 == 0) goto L72
            r7 = 1
            if (r4 == r7) goto L6a
            r8 = 2
            if (r4 == r8) goto L4e
            if (r4 != r0) goto L49
            char[] r4 = p000.AbstractC0054B7.f127e
            int r7 = r4.length
            if (r6 >= r7) goto L44
            char r4 = r4[r6]
            if (r3 == 0) goto L3f
        L37:
            int r4 = r4 + 128
            char r3 = (char) r4
        L3a:
            r10.append(r3)
            r3 = r2
            goto L42
        L3f:
            r10.append(r4)
        L42:
            r4 = r2
            goto L8c
        L44:
            yb r9 = p000.C2610yb.m10853a()
            throw r9
        L49:
            yb r9 = p000.C2610yb.m10853a()
            throw r9
        L4e:
            char[] r4 = p000.AbstractC0054B7.f126d
            int r8 = r4.length
            if (r6 >= r8) goto L58
            char r4 = r4[r6]
            if (r3 == 0) goto L3f
            goto L37
        L58:
            r4 = 27
            if (r6 == r4) goto L67
            r3 = 30
            if (r6 != r3) goto L62
            r3 = r7
            goto L42
        L62:
            yb r9 = p000.C2610yb.m10853a()
            throw r9
        L67:
            r4 = 29
            goto L3f
        L6a:
            if (r3 == 0) goto L70
            int r6 = r6 + 128
            char r3 = (char) r6
            goto L3a
        L70:
            char r4 = (char) r6
            goto L3f
        L72:
            if (r6 >= r0) goto L78
            int r6 = r6 + 1
            r4 = r6
            goto L8c
        L78:
            char[] r7 = p000.AbstractC0054B7.f125c
            int r8 = r7.length
            if (r6 >= r8) goto L8f
            char r6 = r7[r6]
            if (r3 == 0) goto L89
            int r6 = r6 + 128
            char r3 = (char) r6
            r10.append(r3)
            r3 = r2
            goto L8c
        L89:
            r10.append(r6)
        L8c:
            int r5 = r5 + 1
            goto L20
        L8f:
            yb r9 = p000.C2610yb.m10853a()
            throw r9
        L94:
            int r5 = r9.m2576a()
            if (r5 > 0) goto L6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0054B7.m207g(L2, java.lang.StringBuilder):void");
    }

    public static void m208h(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    public static int m209i(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
