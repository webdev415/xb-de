package p000;

import java.io.EOFException;

public abstract class AbstractC2455v3 {

    public static final byte[] f7653a = AbstractC1296b.m5573a("0123456789abcdef");

    public static final byte[] m10309a() {
        return f7653a;
    }

    public static final String m10310b(C2409u3 c2409u3, long j) throws EOFException {
        AbstractC0116Ce.m476e(c2409u3, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (c2409u3.m9932z(j2) == ((byte) 13)) {
                String strM9909W = c2409u3.m9909W(j2);
                c2409u3.mo7347r(2L);
                return strM9909W;
            }
        }
        String strM9909W2 = c2409u3.m9909W(j);
        c2409u3.mo7347r(1L);
        return strM9909W2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        if (r19 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int m10311c(C2409u3 r17, C1739fi r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 174
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2455v3.m10311c(u3, fi, boolean):int");
    }

    public static int m10312d(C2409u3 c2409u3, C1739fi c1739fi, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m10311c(c2409u3, c1739fi, z);
    }
}
