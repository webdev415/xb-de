package p000;

/* loaded from: classes.dex */
public final class C0001A0 extends C0857Sk {

    public final float f2c;

    public C0001A0(float f, float f2, float f3) {
        super(f, f2);
        this.f2c = f3;
    }

    public boolean m2f(float f, float f2, float f3) {
        if (Math.abs(f2 - m4068d()) > f || Math.abs(f3 - m4067c()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.f2c);
        return fAbs <= 1.0f || fAbs <= this.f2c;
    }

    public C0001A0 m3g(float f, float f2, float f3) {
        return new C0001A0((m4067c() + f2) / 2.0f, (m4068d() + f) / 2.0f, (this.f2c + f3) / 2.0f);
    }
}
