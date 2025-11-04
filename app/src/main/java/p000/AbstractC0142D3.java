package p000;

public abstract class AbstractC0142D3 {

    public static final char[] f345a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int m605c(byte[] r18, int r19) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0142D3.m605c(byte[], int):int");
    }

    public static final void m606d(C0096C3 c0096c3, C2409u3 c2409u3, int i, int i2) {
        AbstractC0116Ce.m476e(c0096c3, "$this$commonWrite");
        AbstractC0116Ce.m476e(c2409u3, "buffer");
        c2409u3.mo5931f(c0096c3.m375i(), i, i2);
    }

    public static final int m607e(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        if ('a' <= c && 'f' >= c) {
            return c - 'W';
        }
        if ('A' <= c && 'F' >= c) {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final char[] m608f() {
        return f345a;
    }
}
