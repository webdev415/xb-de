package p000;

/* loaded from: classes.dex */
public final class C1031Wa extends C0857Sk {

    public final float f3050c;

    public final int f3051d;

    public C1031Wa(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    public boolean m4487f(float f, float f2, float f3) {
        if (Math.abs(f2 - m4068d()) > f || Math.abs(f3 - m4067c()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.f3050c);
        return fAbs <= 1.0f || fAbs <= this.f3050c;
    }

    public C1031Wa m4488g(float f, float f2, float f3) {
        int i = this.f3051d;
        int i2 = i + 1;
        float fM4067c = (i * m4067c()) + f2;
        float f4 = i2;
        return new C1031Wa(fM4067c / f4, ((this.f3051d * m4068d()) + f) / f4, ((this.f3051d * this.f3050c) + f3) / f4, i2);
    }

    public int m4489h() {
        return this.f3051d;
    }

    public float m4490i() {
        return this.f3050c;
    }

    public C1031Wa(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f3050c = f3;
        this.f3051d = i;
    }
}
