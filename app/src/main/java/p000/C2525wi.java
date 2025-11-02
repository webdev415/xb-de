package p000;

public class C2525wi {

    public static final byte[] f7873f = {5, 0};

    public static final byte[] f7874g = {5, 0, 0, 1, 0, 0, 0, 0, 0, 0};

    public static final byte[] f7875h = {5, 3, 0, 1, 0, 0, 0, 0, 0, 0};

    public static C2525wi f7876i = null;

    public byte f7877a = 1;

    public boolean f7878b = false;

    public final byte[] f7879c = new byte[32];

    public int f7880d = 0;

    public int f7881e = 0;

    public static final C2525wi m10587c() {
        if (f7876i == null) {
            f7876i = new C2525wi();
        }
        return f7876i;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0017 A[PHI: r0
  0x0017: PHI (r0v15 byte) = (r0v3 byte), (r0v4 byte), (r0v5 byte), (r0v6 byte) binds: [B:15:0x0015, B:21:0x0028, B:24:0x002d, B:27:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] m10588a(byte r5) {
        /*
            r4 = this;
            r0 = 5
            if (r5 != r0) goto L6
            byte[] r5 = p000.C2525wi.f7873f
            return r5
        L6:
            r0 = 6
            if (r5 != r0) goto Lc
            byte[] r5 = p000.C2525wi.f7874g
            return r5
        Lc:
            r0 = 3
            if (r5 != r0) goto L12
            byte[] r5 = p000.C2525wi.f7875h
            return r5
        L12:
            r0 = 7
            r1 = 2
            r2 = 0
            if (r5 != r0) goto L26
        L17:
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r1)
        L1b:
            r5.put(r0)
        L1e:
            r5.put(r2)
            byte[] r5 = r5.array()
            return r5
        L26:
            r0 = 8
            if (r5 != r0) goto L2b
            goto L17
        L2b:
            r0 = 9
            if (r5 != r0) goto L30
            goto L17
        L30:
            r0 = 10
            if (r5 != r0) goto L35
            goto L17
        L35:
            r0 = 11
            if (r5 != r0) goto L54
            r5 = 46
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r5)
            r5.put(r0)
            long r0 = java.lang.System.currentTimeMillis()
            r5.putLong(r0)
            int r0 = r4.f7880d
            r5.putInt(r0)
            byte[] r0 = r4.f7879c
            r5.put(r0)
            goto L1e
        L54:
            r0 = 12
            if (r5 != r0) goto L6a
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r0)
            r5.put(r0)
            long r0 = java.lang.System.currentTimeMillis()
            r3 = 1
            r5.putLong(r3, r0)
            byte r0 = r4.f7877a
            goto L1b
        L6a:
            byte[] r5 = p000.C2525wi.f7875h
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2525wi.m10588a(byte):byte[]");
    }

    public int m10589b() {
        return this.f7881e;
    }

    public byte m10590d() {
        return this.f7877a;
    }

    public void m10591e(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.f7879c[i] = (byte) str.charAt(i);
        }
    }

    public void m10592f(int i) {
        this.f7880d = i;
    }
}
