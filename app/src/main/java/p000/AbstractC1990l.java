package p000;

public abstract class AbstractC1990l extends AbstractC1944k {
    public AbstractC1990l(C0233F2 c0233f2) {
        super(c0233f2);
    }

    public abstract void mo7275h(StringBuilder sb, int i);

    public abstract int mo7276i(int i);

    public final void m8343j(StringBuilder sb, int i, int i2) {
        int iM10664f = m173b().m10664f(i, i2);
        mo7275h(sb, iM10664f);
        int iMo7276i = mo7276i(iM10664f);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (iMo7276i / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(iMo7276i);
    }
}
