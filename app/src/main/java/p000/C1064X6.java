package p000;

/* loaded from: classes.dex */
public final class C1064X6 {

    public int f3186a = 0;

    public a f3187b = a.NUMERIC;

    public enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int m4651a() {
        return this.f3186a;
    }

    public void m4652b(int i) {
        this.f3186a += i;
    }

    public boolean m4653c() {
        return this.f3187b == a.ALPHA;
    }

    public boolean m4654d() {
        return this.f3187b == a.ISO_IEC_646;
    }

    public void m4655e() {
        this.f3187b = a.ALPHA;
    }

    public void m4656f() {
        this.f3187b = a.ISO_IEC_646;
    }

    public void m4657g() {
        this.f3187b = a.NUMERIC;
    }

    public void m4658h(int i) {
        this.f3186a = i;
    }
}
