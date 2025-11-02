package p000;

/* loaded from: classes.dex */
public abstract class AbstractC1944k extends AbstractC0046B {
    public AbstractC1944k(C0233F2 c0233f2) {
        super(c0233f2);
    }

    public static void m8228e(StringBuilder sb, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3 + i) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        sb.append(i4 != 10 ? i4 : 0);
    }

    public final void m8229f(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        m8230g(sb, i, length);
    }

    public final void m8230g(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int iM10664f = m173b().m10664f((i3 * 10) + i, 10);
            if (iM10664f / 100 == 0) {
                sb.append('0');
            }
            if (iM10664f / 10 == 0) {
                sb.append('0');
            }
            sb.append(iM10664f);
        }
        m8228e(sb, i2);
    }
}
