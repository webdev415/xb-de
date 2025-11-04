package p000;

public final class C2664zj {

    public final boolean f8266a;

    public C2664zj(boolean z) {
        this.f8266a = z;
    }

    public void m11038a(C0857Sk[] c0857SkArr) {
        if (!this.f8266a || c0857SkArr == null || c0857SkArr.length < 3) {
            return;
        }
        C0857Sk c0857Sk = c0857SkArr[0];
        c0857SkArr[0] = c0857SkArr[2];
        c0857SkArr[2] = c0857Sk;
    }
}
