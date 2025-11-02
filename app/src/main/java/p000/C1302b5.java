package p000;

/* loaded from: classes.dex */
public final class C1302b5 {

    public final int f3837a;

    public final int f3838b;

    public final int f3839c;

    public final int f3840d;

    public int f3841e = -1;

    public C1302b5(int i, int i2, int i3, int i4) {
        this.f3837a = i;
        this.f3838b = i2;
        this.f3839c = i3;
        this.f3840d = i4;
    }

    public int m5633a() {
        return this.f3839c;
    }

    public int m5634b() {
        return this.f3838b;
    }

    public int m5635c() {
        return this.f3841e;
    }

    public int m5636d() {
        return this.f3837a;
    }

    public int m5637e() {
        return this.f3840d;
    }

    public int m5638f() {
        return this.f3838b - this.f3837a;
    }

    public boolean m5639g() {
        return m5640h(this.f3841e);
    }

    public boolean m5640h(int i) {
        return i != -1 && this.f3839c == (i % 3) * 3;
    }

    public void m5641i(int i) {
        this.f3841e = i;
    }

    public void m5642j() {
        this.f3841e = ((this.f3840d / 30) * 3) + (this.f3839c / 3);
    }

    public String toString() {
        return this.f3841e + "|" + this.f3840d;
    }
}
