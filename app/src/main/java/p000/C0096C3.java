package p000;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes.dex */
public class C0096C3 implements Serializable, Comparable {

    public transient int f236l;

    public transient String f237m;

    public final byte[] f238n;

    public static final a f235p = new a(null);

    public static final C0096C3 f234o = new C0096C3(new byte[0]);

    public static final class a {
        public a() {
        }

        public static C0096C3 m392e(a aVar, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            return aVar.m396d(bArr, i, i2);
        }

        public final C0096C3 m393a(String str) {
            AbstractC0116Ce.m476e(str, "$this$decodeHex");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((AbstractC0142D3.m607e(str.charAt(i2)) << 4) + AbstractC0142D3.m607e(str.charAt(i2 + 1)));
            }
            return new C0096C3(bArr);
        }

        public final C0096C3 m394b(String str, Charset charset) {
            AbstractC0116Ce.m476e(str, "$this$encode");
            AbstractC0116Ce.m476e(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            AbstractC0116Ce.m475d(bytes, "(this as java.lang.String).getBytes(charset)");
            return new C0096C3(bytes);
        }

        public final C0096C3 m395c(String str) {
            AbstractC0116Ce.m476e(str, "$this$encodeUtf8");
            C0096C3 c0096c3 = new C0096C3(AbstractC1296b.m5573a(str));
            c0096c3.m385s(str);
            return c0096c3;
        }

        public final C0096C3 m396d(byte[] bArr, int i, int i2) {
            AbstractC0116Ce.m476e(bArr, "$this$toByteString");
            AbstractC1342c.m5685b(bArr.length, i, i2);
            return new C0096C3(AbstractC2637z1.m10986h(bArr, i, i2 + i));
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0096C3(byte[] bArr) {
        AbstractC0116Ce.m476e(bArr, "data");
        this.f238n = bArr;
    }

    public String mo371c() {
        return AbstractC1195a.m5087b(m375i(), null, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(C0096C3 r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            p000.AbstractC0116Ce.m476e(r10, r0)
            int r0 = r9.m387u()
            int r1 = r10.m387u()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.m374h(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.m374h(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = r5
            goto L34
        L2c:
            r3 = r6
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0096C3.compareTo(C3):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0096C3) {
            C0096C3 c0096c3 = (C0096C3) obj;
            if (c0096c3.m387u() == m375i().length && c0096c3.mo383q(0, m375i(), 0, m375i().length)) {
                return true;
            }
        }
        return false;
    }

    public C0096C3 mo373g(String str) {
        AbstractC0116Ce.m476e(str, "algorithm");
        byte[] bArrDigest = MessageDigest.getInstance(str).digest(this.f238n);
        AbstractC0116Ce.m475d(bArrDigest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new C0096C3(bArrDigest);
    }

    public final byte m374h(int i) {
        return mo381o(i);
    }

    public int hashCode() {
        int iM376j = m376j();
        if (iM376j != 0) {
            return iM376j;
        }
        int iHashCode = Arrays.hashCode(m375i());
        m384r(iHashCode);
        return iHashCode;
    }

    public final byte[] m375i() {
        return this.f238n;
    }

    public final int m376j() {
        return this.f236l;
    }

    public int mo377k() {
        return m375i().length;
    }

    public final String m378l() {
        return this.f237m;
    }

    public String mo379m() {
        char[] cArr = new char[m375i().length * 2];
        int i = 0;
        for (byte b : m375i()) {
            int i2 = i + 1;
            cArr[i] = AbstractC0142D3.m608f()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = AbstractC0142D3.m608f()[b & 15];
        }
        return new String(cArr);
    }

    public byte[] mo380n() {
        return m375i();
    }

    public byte mo381o(int i) {
        return m375i()[i];
    }

    public boolean mo382p(int i, C0096C3 c0096c3, int i2, int i3) {
        AbstractC0116Ce.m476e(c0096c3, "other");
        return c0096c3.mo383q(i2, m375i(), i, i3);
    }

    public boolean mo383q(int i, byte[] bArr, int i2, int i3) {
        AbstractC0116Ce.m476e(bArr, "other");
        return i >= 0 && i <= m375i().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && AbstractC1342c.m5684a(m375i(), i, bArr, i2, i3);
    }

    public final void m384r(int i) {
        this.f236l = i;
    }

    public final void m385s(String str) {
        this.f237m = str;
    }

    public C0096C3 m386t() {
        return mo373g("SHA-256");
    }

    public String toString() {
        StringBuilder sb;
        if (m375i().length == 0) {
            return "[size=0]";
        }
        int iM605c = AbstractC0142D3.m605c(m375i(), 64);
        if (iM605c != -1) {
            String strM390x = m390x();
            if (strM390x == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strM390x.substring(0, iM605c);
            AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String strM2727s = AbstractC0538Lm.m2727s(AbstractC0538Lm.m2727s(AbstractC0538Lm.m2727s(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (iM605c < strM390x.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(m375i().length);
                sb.append(" text=");
                sb.append(strM2727s);
                sb.append("…]");
            } else {
                sb = new StringBuilder();
                sb.append("[text=");
                sb.append(strM2727s);
                sb.append(']');
            }
        } else if (m375i().length <= 64) {
            sb = new StringBuilder();
            sb.append("[hex=");
            sb.append(mo379m());
            sb.append(']');
        } else {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(m375i().length);
            sb.append(" hex=");
            if (!(64 <= m375i().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + m375i().length + ')').toString());
            }
            sb.append((64 == m375i().length ? this : new C0096C3(AbstractC2637z1.m10986h(m375i(), 0, 64))).mo379m());
            sb.append("…]");
        }
        return sb.toString();
    }

    public final int m387u() {
        return mo377k();
    }

    public final boolean m388v(C0096C3 c0096c3) {
        AbstractC0116Ce.m476e(c0096c3, "prefix");
        return mo382p(0, c0096c3, 0, c0096c3.m387u());
    }

    public C0096C3 mo389w() {
        byte b;
        for (int i = 0; i < m375i().length; i++) {
            byte b2 = m375i()[i];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] bArrM375i = m375i();
                byte[] bArrCopyOf = Arrays.copyOf(bArrM375i, bArrM375i.length);
                AbstractC0116Ce.m475d(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b4 = bArrCopyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        bArrCopyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new C0096C3(bArrCopyOf);
            }
        }
        return this;
    }

    public String m390x() {
        String strM378l = m378l();
        if (strM378l != null) {
            return strM378l;
        }
        String strM5574b = AbstractC1296b.m5574b(mo380n());
        m385s(strM5574b);
        return strM5574b;
    }

    public void mo391y(C2409u3 c2409u3, int i, int i2) {
        AbstractC0116Ce.m476e(c2409u3, "buffer");
        AbstractC0142D3.m606d(this, c2409u3, i, i2);
    }
}
