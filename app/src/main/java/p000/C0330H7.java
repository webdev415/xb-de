package p000;

public final class C0330H7 extends AbstractC0376I7 {

    public final int f1020b;

    public final int f1021c;

    public C0330H7(int i, int i2, int i3) throws C2610yb {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw C2610yb.m10853a();
        }
        this.f1020b = i2;
        this.f1021c = i3;
    }

    public int m1512b() {
        return this.f1020b;
    }

    public int m1513c() {
        return this.f1021c;
    }

    public boolean m1514d() {
        return this.f1020b == 10;
    }

    public boolean m1515e() {
        return this.f1021c == 10;
    }
}
