package p000;

import p000.C0126Co;

public final class C1765g7 {

    public final int f5590a;

    public final byte[] f5591b;

    public C1765g7(int i, byte[] bArr) {
        this.f5590a = i;
        this.f5591b = bArr;
    }

    public static C1765g7[] m7693b(byte[] bArr, C0126Co c0126Co, EnumC1363ca enumC1363ca) {
        if (bArr.length != c0126Co.m518h()) {
            throw new IllegalArgumentException();
        }
        C0126Co.b bVarM517f = c0126Co.m517f(enumC1363ca);
        C0126Co.a[] aVarArrM522a = bVarM517f.m522a();
        int iM520a = 0;
        for (C0126Co.a aVar : aVarArrM522a) {
            iM520a += aVar.m520a();
        }
        C1765g7[] c1765g7Arr = new C1765g7[iM520a];
        int i = 0;
        for (C0126Co.a aVar2 : aVarArrM522a) {
            int i2 = 0;
            while (i2 < aVar2.m520a()) {
                int iM521b = aVar2.m521b();
                c1765g7Arr[i] = new C1765g7(iM521b, new byte[bVarM517f.m523b() + iM521b]);
                i2++;
                i++;
            }
        }
        int length = c1765g7Arr[0].f5591b.length;
        int i3 = iM520a - 1;
        while (i3 >= 0 && c1765g7Arr[i3].f5591b.length != length) {
            i3--;
        }
        int i4 = i3 + 1;
        int iM523b = length - bVarM517f.m523b();
        int i5 = 0;
        for (int i6 = 0; i6 < iM523b; i6++) {
            int i7 = 0;
            while (i7 < i) {
                c1765g7Arr[i7].f5591b[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        int i8 = i4;
        while (i8 < i) {
            c1765g7Arr[i8].f5591b[iM523b] = bArr[i5];
            i8++;
            i5++;
        }
        int length2 = c1765g7Arr[0].f5591b.length;
        while (iM523b < length2) {
            int i9 = 0;
            while (i9 < i) {
                c1765g7Arr[i9].f5591b[i9 < i4 ? iM523b : iM523b + 1] = bArr[i5];
                i9++;
                i5++;
            }
            iM523b++;
        }
        return c1765g7Arr;
    }

    public byte[] m7694a() {
        return this.f5591b;
    }

    public int m7695c() {
        return this.f5590a;
    }
}
