package p000;

public final class C0187E2 extends AbstractC0217En {

    public final short f456c;

    public final short f457d;

    public C0187E2(AbstractC0217En abstractC0217En, int i, int i2) {
        super(abstractC0217En);
        this.f456c = (short) i;
        this.f457d = (short) i2;
    }

    @Override
    public void mo848c(C0233F2 c0233f2, byte[] bArr) {
        int i;
        int i2 = 0;
        while (true) {
            short s = this.f457d;
            if (i2 >= s) {
                return;
            }
            if (i2 == 0 || (i2 == 31 && s <= 62)) {
                int i3 = 5;
                c0233f2.m1185c(31, 5);
                short s2 = this.f457d;
                if (s2 > 62) {
                    i = s2 - 31;
                    i3 = 16;
                } else if (i2 == 0) {
                    c0233f2.m1185c(Math.min((int) s2, 31), 5);
                } else {
                    i = s2 - 31;
                }
                c0233f2.m1185c(i, i3);
            }
            c0233f2.m1185c(bArr[this.f456c + i2], 8);
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f456c);
        sb.append("::");
        sb.append((this.f456c + this.f457d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
