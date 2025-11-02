package p000;

public final class C0626Ni {

    public final float f1957a;

    public final float f1958b;

    public final float f1959c;

    public final float f1960d;

    public final float f1961e;

    public final float f1962f;

    public final float f1963g;

    public final float f1964h;

    public final float f1965i;

    public C0626Ni(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f1957a = f;
        this.f1958b = f4;
        this.f1959c = f7;
        this.f1960d = f2;
        this.f1961e = f5;
        this.f1962f = f8;
        this.f1963g = f3;
        this.f1964h = f6;
        this.f1965i = f9;
    }

    public static C0626Ni m3323b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return m3325d(f9, f10, f11, f12, f13, f14, f15, f16).m3327e(m3324c(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public static C0626Ni m3324c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return m3325d(f, f2, f3, f4, f5, f6, f7, f8).m3326a();
    }

    public static C0626Ni m3325d(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new C0626Ni(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new C0626Ni((f16 * f3) + (f3 - f), (f17 * f7) + (f7 - f), f, (f4 - f2) + (f16 * f4), (f8 - f2) + (f17 * f8), f2, f16, f17, 1.0f);
    }

    public C0626Ni m3326a() {
        float f = this.f1961e;
        float f2 = this.f1965i;
        float f3 = this.f1962f;
        float f4 = this.f1964h;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = this.f1963g;
        float f7 = this.f1960d;
        float f8 = (f3 * f6) - (f7 * f2);
        float f9 = (f7 * f4) - (f * f6);
        float f10 = this.f1959c;
        float f11 = this.f1958b;
        float f12 = (f10 * f4) - (f11 * f2);
        float f13 = this.f1957a;
        return new C0626Ni(f5, f8, f9, f12, (f2 * f13) - (f10 * f6), (f6 * f11) - (f4 * f13), (f11 * f3) - (f10 * f), (f10 * f7) - (f3 * f13), (f13 * f) - (f11 * f7));
    }

    public C0626Ni m3327e(C0626Ni c0626Ni) {
        float f = this.f1957a;
        float f2 = c0626Ni.f1957a;
        float f3 = this.f1960d;
        float f4 = c0626Ni.f1958b;
        float f5 = this.f1963g;
        float f6 = c0626Ni.f1959c;
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f8 = c0626Ni.f1960d;
        float f9 = c0626Ni.f1961e;
        float f10 = c0626Ni.f1962f;
        float f11 = (f * f8) + (f3 * f9) + (f5 * f10);
        float f12 = c0626Ni.f1963g;
        float f13 = c0626Ni.f1964h;
        float f14 = c0626Ni.f1965i;
        float f15 = (f * f12) + (f3 * f13) + (f5 * f14);
        float f16 = this.f1958b;
        float f17 = this.f1961e;
        float f18 = this.f1964h;
        float f19 = (f16 * f2) + (f17 * f4) + (f18 * f6);
        float f20 = (f16 * f8) + (f17 * f9) + (f18 * f10);
        float f21 = (f18 * f14) + (f16 * f12) + (f17 * f13);
        float f22 = this.f1959c;
        float f23 = this.f1962f;
        float f24 = (f2 * f22) + (f4 * f23);
        float f25 = this.f1965i;
        return new C0626Ni(f7, f11, f15, f19, f20, f21, (f6 * f25) + f24, (f8 * f22) + (f9 * f23) + (f10 * f25), (f22 * f12) + (f23 * f13) + (f25 * f14));
    }

    public void m3328f(float[] fArr) {
        float f = this.f1957a;
        float f2 = this.f1958b;
        float f3 = this.f1959c;
        float f4 = this.f1960d;
        float f5 = this.f1961e;
        float f6 = this.f1962f;
        float f7 = this.f1963g;
        float f8 = this.f1964h;
        float f9 = this.f1965i;
        int length = fArr.length - 1;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr[i];
            int i2 = i + 1;
            float f11 = fArr[i2];
            float f12 = (f3 * f10) + (f6 * f11) + f9;
            fArr[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr[i2] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }
}
