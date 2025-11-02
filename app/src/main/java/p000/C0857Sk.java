package p000;

/* loaded from: classes.dex */
public class C0857Sk {

    public final float f2659a;

    public final float f2660b;

    public C0857Sk(float f, float f2) {
        this.f2659a = f;
        this.f2660b = f2;
    }

    public static float m4064a(C0857Sk c0857Sk, C0857Sk c0857Sk2, C0857Sk c0857Sk3) {
        float f = c0857Sk2.f2659a;
        float f2 = c0857Sk2.f2660b;
        return ((c0857Sk3.f2659a - f) * (c0857Sk.f2660b - f2)) - ((c0857Sk3.f2660b - f2) * (c0857Sk.f2659a - f));
    }

    public static float m4065b(C0857Sk c0857Sk, C0857Sk c0857Sk2) {
        return AbstractC2477vg.m10354a(c0857Sk.f2659a, c0857Sk.f2660b, c0857Sk2.f2659a, c0857Sk2.f2660b);
    }

    public static void m4066e(C0857Sk[] c0857SkArr) {
        C0857Sk c0857Sk;
        C0857Sk c0857Sk2;
        C0857Sk c0857Sk3;
        float fM4065b = m4065b(c0857SkArr[0], c0857SkArr[1]);
        float fM4065b2 = m4065b(c0857SkArr[1], c0857SkArr[2]);
        float fM4065b3 = m4065b(c0857SkArr[0], c0857SkArr[2]);
        if (fM4065b2 >= fM4065b && fM4065b2 >= fM4065b3) {
            c0857Sk = c0857SkArr[0];
            c0857Sk2 = c0857SkArr[1];
            c0857Sk3 = c0857SkArr[2];
        } else if (fM4065b3 < fM4065b2 || fM4065b3 < fM4065b) {
            c0857Sk = c0857SkArr[2];
            c0857Sk2 = c0857SkArr[0];
            c0857Sk3 = c0857SkArr[1];
        } else {
            c0857Sk = c0857SkArr[1];
            c0857Sk2 = c0857SkArr[0];
            c0857Sk3 = c0857SkArr[2];
        }
        if (m4064a(c0857Sk2, c0857Sk, c0857Sk3) < 0.0f) {
            C0857Sk c0857Sk4 = c0857Sk3;
            c0857Sk3 = c0857Sk2;
            c0857Sk2 = c0857Sk4;
        }
        c0857SkArr[0] = c0857Sk2;
        c0857SkArr[1] = c0857Sk;
        c0857SkArr[2] = c0857Sk3;
    }

    public final float m4067c() {
        return this.f2659a;
    }

    public final float m4068d() {
        return this.f2660b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0857Sk) {
            C0857Sk c0857Sk = (C0857Sk) obj;
            if (this.f2659a == c0857Sk.f2659a && this.f2660b == c0857Sk.f2660b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f2659a) * 31) + Float.floatToIntBits(this.f2660b);
    }

    public final String toString() {
        return "(" + this.f2659a + ',' + this.f2660b + ')';
    }
}
