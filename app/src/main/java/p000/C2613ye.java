package p000;

import java.util.NoSuchElementException;

public final class C2613ye extends AbstractC2521we {

    public final int f8094l;

    public final int f8095m;

    public boolean f8096n;

    public int f8097o;

    public C2613ye(int i, int i2, int i3) {
        this.f8094l = i3;
        this.f8095m = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.f8096n = z;
        this.f8097o = z ? i : i2;
    }

    @Override
    public int mo10565b() {
        int i = this.f8097o;
        if (i != this.f8095m) {
            this.f8097o = this.f8094l + i;
        } else {
            if (!this.f8096n) {
                throw new NoSuchElementException();
            }
            this.f8096n = false;
        }
        return i;
    }

    @Override
    public boolean hasNext() {
        return this.f8096n;
    }
}
