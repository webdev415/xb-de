package p000;

import android.graphics.Rect;

/* loaded from: classes.dex */
public class C1178Zj {

    public byte[] f3455a;

    public int f3456b;

    public int f3457c;

    public C1178Zj(byte[] bArr, int i, int i2) {
        this.f3455a = bArr;
        this.f3456b = i;
        this.f3457c = i2;
    }

    public static byte[] m5053e(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i4] = bArr[i5];
            i4--;
        }
        return bArr2;
    }

    public static byte[] m5054f(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = i2 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i) + i5];
                i4--;
            }
        }
        return bArr2;
    }

    public static byte[] m5055g(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i * i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        return bArr2;
    }

    public C1178Zj m5056a(Rect rect, int i) {
        int iWidth = rect.width() / i;
        int iHeight = rect.height() / i;
        int i2 = rect.top;
        byte[] bArr = new byte[iWidth * iHeight];
        if (i == 1) {
            int i3 = (i2 * this.f3456b) + rect.left;
            for (int i4 = 0; i4 < iHeight; i4++) {
                System.arraycopy(this.f3455a, i3, bArr, i4 * iWidth, iWidth);
                i3 += this.f3456b;
            }
        } else {
            int i5 = (i2 * this.f3456b) + rect.left;
            for (int i6 = 0; i6 < iHeight; i6++) {
                int i7 = i6 * iWidth;
                int i8 = i5;
                for (int i9 = 0; i9 < iWidth; i9++) {
                    bArr[i7] = this.f3455a[i8];
                    i8 += i;
                    i7++;
                }
                i5 += this.f3456b * i;
            }
        }
        return new C1178Zj(bArr, iWidth, iHeight);
    }

    public byte[] m5057b() {
        return this.f3455a;
    }

    public int m5058c() {
        return this.f3457c;
    }

    public int m5059d() {
        return this.f3456b;
    }

    public C1178Zj m5060h(int i) {
        return i != 90 ? i != 180 ? i != 270 ? this : new C1178Zj(m5054f(this.f3455a, this.f3456b, this.f3457c), this.f3457c, this.f3456b) : new C1178Zj(m5053e(this.f3455a, this.f3456b, this.f3457c), this.f3456b, this.f3457c) : new C1178Zj(m5055g(this.f3455a, this.f3456b, this.f3457c), this.f3457c, this.f3456b);
    }
}
