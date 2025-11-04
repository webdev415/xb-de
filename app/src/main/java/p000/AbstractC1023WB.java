package p000;

public abstract class AbstractC1023WB {

    public static volatile int f3038b = 100;

    public int f3039a;

    public AbstractC1023WB() {
        this.f3039a = f3038b;
    }

    public static long m4465b(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static AbstractC1023WB m4466c(byte[] bArr, int i, int i2, boolean z) {
        C0931UB c0931ub = new C0931UB(bArr, i2);
        try {
            c0931ub.mo4202a(i2);
            return c0931ub;
        } catch (C1771gD e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int m4467e(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int mo4202a(int i);

    public abstract int mo4203d();
}
