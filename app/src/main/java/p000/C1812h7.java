package p000;

import p000.C0080Bo;

/* loaded from: classes.dex */
public final class C1812h7 {

    public final int f5692a;

    public final byte[] f5693b;

    public C1812h7(int i, byte[] bArr) {
        this.f5692a = i;
        this.f5693b = bArr;
    }

    public static C1812h7[] m7806b(byte[] bArr, C0080Bo c0080Bo) {
        C0080Bo.c cVarM331d = c0080Bo.m331d();
        C0080Bo.b[] bVarArrM338a = cVarM331d.m338a();
        int iM336a = 0;
        for (C0080Bo.b bVar : bVarArrM338a) {
            iM336a += bVar.m336a();
        }
        C1812h7[] c1812h7Arr = new C1812h7[iM336a];
        int i = 0;
        for (C0080Bo.b bVar2 : bVarArrM338a) {
            int i2 = 0;
            while (i2 < bVar2.m336a()) {
                int iM337b = bVar2.m337b();
                c1812h7Arr[i] = new C1812h7(iM337b, new byte[cVarM331d.m339b() + iM337b]);
                i2++;
                i++;
            }
        }
        int length = c1812h7Arr[0].f5693b.length - cVarM331d.m339b();
        int i3 = length - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            while (i6 < i) {
                c1812h7Arr[i6].f5693b[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        boolean z = c0080Bo.m335i() == 24;
        int i7 = z ? 8 : i;
        int i8 = 0;
        while (i8 < i7) {
            c1812h7Arr[i8].f5693b[i3] = bArr[i4];
            i8++;
            i4++;
        }
        int length2 = c1812h7Arr[0].f5693b.length;
        while (length < length2) {
            int i9 = 0;
            while (i9 < i) {
                int i10 = z ? (i9 + 8) % i : i9;
                c1812h7Arr[i10].f5693b[(!z || i10 <= 7) ? length : length - 1] = bArr[i4];
                i9++;
                i4++;
            }
            length++;
        }
        if (i4 == bArr.length) {
            return c1812h7Arr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] m7807a() {
        return this.f5693b;
    }

    public int m7808c() {
        return this.f5692a;
    }
}
