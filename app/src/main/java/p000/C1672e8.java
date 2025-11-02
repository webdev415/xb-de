package p000;

import java.util.Arrays;

/* loaded from: classes.dex */
public class C1672e8 {

    public final CharSequence f5393a;

    public final int f5394b;

    public final int f5395c;

    public final byte[] f5396d;

    public C1672e8(CharSequence charSequence, int i, int i2) {
        this.f5393a = charSequence;
        this.f5395c = i;
        this.f5394b = i2;
        byte[] bArr = new byte[i * i2];
        this.f5396d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    public final void m7390a(int i) {
        m7395f(this.f5394b - 1, 0, i, 1);
        m7395f(this.f5394b - 1, 1, i, 2);
        m7395f(this.f5394b - 1, 2, i, 3);
        m7395f(0, this.f5395c - 2, i, 4);
        m7395f(0, this.f5395c - 1, i, 5);
        m7395f(1, this.f5395c - 1, i, 6);
        m7395f(2, this.f5395c - 1, i, 7);
        m7395f(3, this.f5395c - 1, i, 8);
    }

    public final void m7391b(int i) {
        m7395f(this.f5394b - 3, 0, i, 1);
        m7395f(this.f5394b - 2, 0, i, 2);
        m7395f(this.f5394b - 1, 0, i, 3);
        m7395f(0, this.f5395c - 4, i, 4);
        m7395f(0, this.f5395c - 3, i, 5);
        m7395f(0, this.f5395c - 2, i, 6);
        m7395f(0, this.f5395c - 1, i, 7);
        m7395f(1, this.f5395c - 1, i, 8);
    }

    public final void m7392c(int i) {
        m7395f(this.f5394b - 3, 0, i, 1);
        m7395f(this.f5394b - 2, 0, i, 2);
        m7395f(this.f5394b - 1, 0, i, 3);
        m7395f(0, this.f5395c - 2, i, 4);
        m7395f(0, this.f5395c - 1, i, 5);
        m7395f(1, this.f5395c - 1, i, 6);
        m7395f(2, this.f5395c - 1, i, 7);
        m7395f(3, this.f5395c - 1, i, 8);
    }

    public final void m7393d(int i) {
        m7395f(this.f5394b - 1, 0, i, 1);
        m7395f(this.f5394b - 1, this.f5395c - 1, i, 2);
        m7395f(0, this.f5395c - 3, i, 3);
        m7395f(0, this.f5395c - 2, i, 4);
        m7395f(0, this.f5395c - 1, i, 5);
        m7395f(1, this.f5395c - 3, i, 6);
        m7395f(1, this.f5395c - 2, i, 7);
        m7395f(1, this.f5395c - 1, i, 8);
    }

    public final boolean m7394e(int i, int i2) {
        return this.f5396d[(i2 * this.f5395c) + i] == 1;
    }

    public final void m7395f(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.f5394b;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.f5395c;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        m7398i(i2, i, (this.f5393a.charAt(i3) & (1 << (8 - i4))) != 0);
    }

    public final boolean m7396g(int i, int i2) {
        return this.f5396d[(i2 * this.f5395c) + i] < 0;
    }

    public final void m7397h() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 4;
        while (true) {
            if (i5 == this.f5394b && i3 == 0) {
                m7390a(i4);
                i4++;
            }
            if (i5 == this.f5394b - 2 && i3 == 0 && this.f5395c % 4 != 0) {
                m7391b(i4);
                i4++;
            }
            if (i5 == this.f5394b - 2 && i3 == 0 && this.f5395c % 8 == 4) {
                m7392c(i4);
                i4++;
            }
            if (i5 == this.f5394b + 4 && i3 == 2 && this.f5395c % 8 == 0) {
                m7393d(i4);
                i4++;
            }
            while (true) {
                if (i5 < this.f5394b && i3 >= 0 && m7396g(i3, i5)) {
                    m7399j(i5, i3, i4);
                    i4++;
                }
                int i6 = i5 - 2;
                int i7 = i3 + 2;
                if (i6 < 0 || i7 >= this.f5395c) {
                    break;
                }
                i5 = i6;
                i3 = i7;
            }
            int i8 = i5 - 1;
            int i9 = i3 + 5;
            while (true) {
                if (i8 >= 0 && i9 < this.f5395c && m7396g(i9, i8)) {
                    m7399j(i8, i9, i4);
                    i4++;
                }
                int i10 = i8 + 2;
                int i11 = i9 - 2;
                i = this.f5394b;
                if (i10 >= i || i11 < 0) {
                    break;
                }
                i8 = i10;
                i9 = i11;
            }
            i5 = i8 + 5;
            i3 = i9 - 1;
            if (i5 >= i && i3 >= (i2 = this.f5395c)) {
                break;
            }
        }
        if (m7396g(i2 - 1, i - 1)) {
            m7398i(this.f5395c - 1, this.f5394b - 1, true);
            m7398i(this.f5395c - 2, this.f5394b - 2, true);
        }
    }

    public final void m7398i(int i, int i2, boolean z) {
        this.f5396d[(i2 * this.f5395c) + i] = z ? (byte) 1 : (byte) 0;
    }

    public final void m7399j(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        m7395f(i4, i5, i3, 1);
        int i6 = i2 - 1;
        m7395f(i4, i6, i3, 2);
        int i7 = i - 1;
        m7395f(i7, i5, i3, 3);
        m7395f(i7, i6, i3, 4);
        m7395f(i7, i2, i3, 5);
        m7395f(i, i5, i3, 6);
        m7395f(i, i6, i3, 7);
        m7395f(i, i2, i3, 8);
    }
}
