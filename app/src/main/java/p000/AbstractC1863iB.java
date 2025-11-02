package p000;

/* loaded from: classes.dex */
public abstract class AbstractC1863iB {

    public static volatile int f5791a = 100;

    public static double m7878a(byte[] bArr, int i) {
        return Double.longBitsToDouble(m7897t(bArr, i));
    }

    public static int m7879b(int i, byte[] bArr, int i2, int i3, Object obj, InterfaceC1912jE interfaceC1912jE, AbstractC0430JF abstractC0430JF, C1769gB c1769gB) {
        c1769gB.f5604d.m8237b(interfaceC1912jE, i >>> 3);
        return m7881d(i, bArr, i2, i3, C2236qE.m9114I(obj), c1769gB);
    }

    public static int m7880c(int i, byte[] bArr, int i2, int i3, InterfaceC1865iD interfaceC1865iD, C1769gB c1769gB) {
        C1024WC c1024wc = (C1024WC) interfaceC1865iD;
        int iM7895r = m7895r(bArr, i2, c1769gB);
        while (true) {
            c1024wc.m4470h(c1769gB.f5601a);
            if (iM7895r >= i3) {
                break;
            }
            int iM7895r2 = m7895r(bArr, iM7895r, c1769gB);
            if (i != c1769gB.f5601a) {
                break;
            }
            iM7895r = m7895r(bArr, iM7895r2, c1769gB);
        }
        return iM7895r;
    }

    public static int m7881d(int i, byte[] bArr, int i2, int i3, C0338HF c0338hf, C1769gB c1769gB) {
        if ((i >>> 3) == 0) {
            throw C1771gD.m7703b();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iM7896s = m7896s(bArr, i2, c1769gB);
            c0338hf.m1548e(i, Long.valueOf(c1769gB.f5602b));
            return iM7896s;
        }
        if (i4 == 1) {
            c0338hf.m1548e(i, Long.valueOf(m7897t(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iM7895r = m7895r(bArr, i2, c1769gB);
            int i5 = c1769gB.f5601a;
            if (i5 < 0) {
                throw C1771gD.m7705d();
            }
            if (i5 > bArr.length - iM7895r) {
                throw C1771gD.m7708g();
            }
            c0338hf.m1548e(i, i5 == 0 ? AbstractC2233qB.f6688m : AbstractC2233qB.m9108p(bArr, iM7895r, i5));
            return iM7895r + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw C1771gD.m7703b();
            }
            c0338hf.m1548e(i, Integer.valueOf(m7894q(bArr, i2)));
            return i2 + 4;
        }
        C0338HF c0338hfM1544l = C0338HF.m1544l();
        int i6 = (i & (-8)) | 4;
        int i7 = c1769gB.f5605e + 1;
        c1769gB.f5605e = i7;
        m7890m(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iM7895r2 = m7895r(bArr, i2, c1769gB);
            int i9 = c1769gB.f5601a;
            i8 = i9;
            if (i9 == i6) {
                i2 = iM7895r2;
                break;
            }
            int iM7881d = m7881d(i8, bArr, iM7895r2, i3, c0338hfM1544l, c1769gB);
            i8 = i9;
            i2 = iM7881d;
        }
        c1769gB.f5605e--;
        if (i2 > i3 || i8 != i6) {
            throw C1771gD.m7706e();
        }
        c0338hf.m1548e(i, c0338hfM1544l);
        return i2;
    }

    public static int m7882e(int i, byte[] bArr, int i2, C1769gB c1769gB) {
        int i3;
        int i4 = i & 127;
        int i5 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            i3 = b << 7;
        } else {
            int i6 = i4 | ((b & Byte.MAX_VALUE) << 7);
            int i7 = i2 + 2;
            byte b2 = bArr[i5];
            if (b2 >= 0) {
                c1769gB.f5601a = i6 | (b2 << 14);
                return i7;
            }
            i4 = i6 | ((b2 & Byte.MAX_VALUE) << 14);
            i5 = i2 + 3;
            byte b3 = bArr[i7];
            if (b3 >= 0) {
                i3 = b3 << 21;
            } else {
                int i8 = i4 | ((b3 & Byte.MAX_VALUE) << 21);
                int i9 = i2 + 4;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    c1769gB.f5601a = i8 | (b4 << 28);
                    return i9;
                }
                int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 28);
                while (true) {
                    int i11 = i9 + 1;
                    if (bArr[i9] >= 0) {
                        c1769gB.f5601a = i10;
                        return i11;
                    }
                    i9 = i11;
                }
            }
        }
        c1769gB.f5601a = i4 | i3;
        return i5;
    }

    public static int m7883f(Object obj, InterfaceC1026WE interfaceC1026WE, byte[] bArr, int i, int i2, int i3, C1769gB c1769gB) {
        C2236qE c2236qE = (C2236qE) interfaceC1026WE;
        int i4 = c1769gB.f5605e + 1;
        c1769gB.f5605e = i4;
        m7890m(i4);
        int iM9138m = c2236qE.m9138m(obj, bArr, i, i2, i3, c1769gB);
        c1769gB.f5605e--;
        c1769gB.f5603c = obj;
        return iM9138m;
    }

    public static int m7884g(Object obj, InterfaceC1026WE interfaceC1026WE, byte[] bArr, int i, int i2, C1769gB c1769gB) {
        int iM7882e = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iM7882e = m7882e(i3, bArr, iM7882e, c1769gB);
            i3 = c1769gB.f5601a;
        }
        int i4 = iM7882e;
        if (i3 < 0 || i3 > i2 - i4) {
            throw C1771gD.m7708g();
        }
        int i5 = c1769gB.f5605e + 1;
        c1769gB.f5605e = i5;
        m7890m(i5);
        int i6 = i3 + i4;
        interfaceC1026WE.mo4481h(obj, bArr, i4, i6, c1769gB);
        c1769gB.f5605e--;
        c1769gB.f5603c = obj;
        return i6;
    }

    public static int m7885h(InterfaceC1026WE interfaceC1026WE, int i, byte[] bArr, int i2, int i3, InterfaceC1865iD interfaceC1865iD, C1769gB c1769gB) {
        int i4 = (i & (-8)) | 4;
        int iM7886i = m7886i(interfaceC1026WE, bArr, i2, i3, i4, c1769gB);
        while (true) {
            interfaceC1865iD.add(c1769gB.f5603c);
            if (iM7886i >= i3) {
                break;
            }
            int iM7895r = m7895r(bArr, iM7886i, c1769gB);
            if (i != c1769gB.f5601a) {
                break;
            }
            iM7886i = m7886i(interfaceC1026WE, bArr, iM7895r, i3, i4, c1769gB);
        }
        return iM7886i;
    }

    public static int m7886i(InterfaceC1026WE interfaceC1026WE, byte[] bArr, int i, int i2, int i3, C1769gB c1769gB) {
        Object objMo4474a = interfaceC1026WE.mo4474a();
        int iM7883f = m7883f(objMo4474a, interfaceC1026WE, bArr, i, i2, i3, c1769gB);
        interfaceC1026WE.mo4479f(objMo4474a);
        c1769gB.f5603c = objMo4474a;
        return iM7883f;
    }

    public static int m7887j(InterfaceC1026WE interfaceC1026WE, byte[] bArr, int i, int i2, C1769gB c1769gB) {
        Object objMo4474a = interfaceC1026WE.mo4474a();
        int iM7884g = m7884g(objMo4474a, interfaceC1026WE, bArr, i, i2, c1769gB);
        interfaceC1026WE.mo4479f(objMo4474a);
        c1769gB.f5603c = objMo4474a;
        return iM7884g;
    }

    public static int m7888k(byte[] bArr, int i, C1769gB c1769gB) {
        int iM7895r = m7895r(bArr, i, c1769gB);
        int i2 = c1769gB.f5601a;
        if (i2 < 0) {
            throw C1771gD.m7705d();
        }
        if (i2 > bArr.length - iM7895r) {
            throw C1771gD.m7708g();
        }
        if (i2 == 0) {
            c1769gB.f5603c = AbstractC2233qB.f6688m;
            return iM7895r;
        }
        c1769gB.f5603c = AbstractC2233qB.m9108p(bArr, iM7895r, i2);
        return iM7895r + i2;
    }

    public static int m7889l(byte[] bArr, int i, InterfaceC1865iD interfaceC1865iD, C1769gB c1769gB) {
        C1024WC c1024wc = (C1024WC) interfaceC1865iD;
        int iM7895r = m7895r(bArr, i, c1769gB);
        int i2 = c1769gB.f5601a + iM7895r;
        while (iM7895r < i2) {
            iM7895r = m7895r(bArr, iM7895r, c1769gB);
            c1024wc.m4470h(c1769gB.f5601a);
        }
        if (iM7895r == i2) {
            return iM7895r;
        }
        throw C1771gD.m7708g();
    }

    public static void m7890m(int i) throws C1771gD {
        if (i >= f5791a) {
            throw C1771gD.m7707f();
        }
    }

    public static float m7891n(byte[] bArr, int i) {
        return Float.intBitsToFloat(m7894q(bArr, i));
    }

    public static int m7892o(InterfaceC1026WE interfaceC1026WE, int i, byte[] bArr, int i2, int i3, InterfaceC1865iD interfaceC1865iD, C1769gB c1769gB) {
        int iM7887j = m7887j(interfaceC1026WE, bArr, i2, i3, c1769gB);
        while (true) {
            interfaceC1865iD.add(c1769gB.f5603c);
            if (iM7887j >= i3) {
                break;
            }
            int iM7895r = m7895r(bArr, iM7887j, c1769gB);
            if (i != c1769gB.f5601a) {
                break;
            }
            iM7887j = m7887j(interfaceC1026WE, bArr, iM7895r, i3, c1769gB);
        }
        return iM7887j;
    }

    public static int m7893p(byte[] bArr, int i, C1769gB c1769gB) {
        int iM7895r = m7895r(bArr, i, c1769gB);
        int i2 = c1769gB.f5601a;
        if (i2 < 0) {
            throw C1771gD.m7705d();
        }
        if (i2 == 0) {
            c1769gB.f5603c = "";
            return iM7895r;
        }
        c1769gB.f5603c = AbstractC1073XF.m4713d(bArr, iM7895r, i2);
        return iM7895r + i2;
    }

    public static int m7894q(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int m7895r(byte[] bArr, int i, C1769gB c1769gB) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return m7882e(b, bArr, i2, c1769gB);
        }
        c1769gB.f5601a = b;
        return i2;
    }

    public static int m7896s(byte[] bArr, int i, C1769gB c1769gB) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c1769gB.f5602b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        c1769gB.f5602b = j2;
        return i3;
    }

    public static long m7897t(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }
}
