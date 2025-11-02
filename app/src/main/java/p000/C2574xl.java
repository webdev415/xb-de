package p000;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class C2574xl extends C0096C3 {

    public final transient byte[][] f8023q;

    public final transient int[] f8024r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2574xl(byte[][] bArr, int[] iArr) {
        super(C0096C3.f234o.m375i());
        AbstractC0116Ce.m476e(bArr, "segments");
        AbstractC0116Ce.m476e(iArr, "directory");
        this.f8023q = bArr;
        this.f8024r = iArr;
    }

    public final byte[][] m10777A() {
        return this.f8023q;
    }

    public byte[] m10778B() {
        byte[] bArr = new byte[m387u()];
        int length = m10777A().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = m10780z()[length + i];
            int i5 = m10780z()[i];
            int i6 = i5 - i2;
            AbstractC2637z1.m10982d(m10777A()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public final C0096C3 m10779C() {
        return new C0096C3(m10778B());
    }

    @Override
    public String mo371c() {
        return m10779C().mo371c();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0096C3) {
            C0096C3 c0096c3 = (C0096C3) obj;
            if (c0096c3.m387u() == m387u() && mo382p(0, c0096c3, 0, m387u())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public C0096C3 mo373g(String str) throws NoSuchAlgorithmException {
        AbstractC0116Ce.m476e(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = m10777A().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = m10780z()[length + i];
            int i4 = m10780z()[i];
            messageDigest.update(m10777A()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        AbstractC0116Ce.m475d(bArrDigest, "digest.digest()");
        return new C0096C3(bArrDigest);
    }

    @Override
    public int hashCode() {
        int iM376j = m376j();
        if (iM376j != 0) {
            return iM376j;
        }
        int length = m10777A().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = m10780z()[length + i];
            int i5 = m10780z()[i];
            byte[] bArr = m10777A()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        m384r(i2);
        return i2;
    }

    @Override
    public int mo377k() {
        return m10780z()[m10777A().length - 1];
    }

    @Override
    public String mo379m() {
        return m10779C().mo379m();
    }

    @Override
    public byte[] mo380n() {
        return m10778B();
    }

    @Override
    public byte mo381o(int i) {
        AbstractC1342c.m5685b(m10780z()[m10777A().length - 1], i, 1L);
        int iM10903b = AbstractC2620yl.m10903b(this, i);
        return m10777A()[iM10903b][(i - (iM10903b == 0 ? 0 : m10780z()[iM10903b - 1])) + m10780z()[m10777A().length + iM10903b]];
    }

    @Override
    public boolean mo382p(int i, C0096C3 c0096c3, int i2, int i3) {
        AbstractC0116Ce.m476e(c0096c3, "other");
        if (i < 0 || i > m387u() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iM10903b = AbstractC2620yl.m10903b(this, i);
        while (i < i4) {
            int i5 = iM10903b == 0 ? 0 : m10780z()[iM10903b - 1];
            int i6 = m10780z()[iM10903b] - i5;
            int i7 = m10780z()[m10777A().length + iM10903b];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!c0096c3.mo383q(i2, m10777A()[iM10903b], i7 + (i - i5), iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iM10903b++;
        }
        return true;
    }

    @Override
    public boolean mo383q(int i, byte[] bArr, int i2, int i3) {
        AbstractC0116Ce.m476e(bArr, "other");
        if (i < 0 || i > m387u() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iM10903b = AbstractC2620yl.m10903b(this, i);
        while (i < i4) {
            int i5 = iM10903b == 0 ? 0 : m10780z()[iM10903b - 1];
            int i6 = m10780z()[iM10903b] - i5;
            int i7 = m10780z()[m10777A().length + iM10903b];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!AbstractC1342c.m5684a(m10777A()[iM10903b], i7 + (i - i5), bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iM10903b++;
        }
        return true;
    }

    @Override
    public String toString() {
        return m10779C().toString();
    }

    @Override
    public C0096C3 mo389w() {
        return m10779C().mo389w();
    }

    @Override
    public void mo391y(C2409u3 c2409u3, int i, int i2) {
        AbstractC0116Ce.m476e(c2409u3, "buffer");
        int i3 = i2 + i;
        int iM10903b = AbstractC2620yl.m10903b(this, i);
        while (i < i3) {
            int i4 = iM10903b == 0 ? 0 : m10780z()[iM10903b - 1];
            int i5 = m10780z()[iM10903b] - i4;
            int i6 = m10780z()[m10777A().length + iM10903b];
            int iMin = Math.min(i3, i5 + i4) - i;
            int i7 = i6 + (i - i4);
            C2482vl c2482vl = new C2482vl(m10777A()[iM10903b], i7, i7 + iMin, true, false);
            C2482vl c2482vl2 = c2409u3.f7345l;
            if (c2482vl2 == null) {
                c2482vl.f7764g = c2482vl;
                c2482vl.f7763f = c2482vl;
                c2409u3.f7345l = c2482vl;
            } else {
                AbstractC0116Ce.m473b(c2482vl2);
                C2482vl c2482vl3 = c2482vl2.f7764g;
                AbstractC0116Ce.m473b(c2482vl3);
                c2482vl3.m10398c(c2482vl);
            }
            i += iMin;
            iM10903b++;
        }
        c2409u3.m9910X(c2409u3.m9911Y() + m387u());
    }

    public final int[] m10780z() {
        return this.f8024r;
    }
}
