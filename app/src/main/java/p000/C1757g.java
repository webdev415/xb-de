package p000;

/* loaded from: classes.dex */
public final class C1757g extends AbstractC1944k {
    public C1757g(C0233F2 c0233f2) {
        super(c0233f2);
    }

    @Override
    public String mo175d() throws C2340sh {
        if (m174c().m1193o() < 48) {
            throw C2340sh.m9579a();
        }
        StringBuilder sb = new StringBuilder();
        m8229f(sb, 8);
        int iM10664f = m173b().m10664f(48, 2);
        sb.append("(393");
        sb.append(iM10664f);
        sb.append(')');
        int iM10664f2 = m173b().m10664f(50, 10);
        if (iM10664f2 / 100 == 0) {
            sb.append('0');
        }
        if (iM10664f2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iM10664f2);
        sb.append(m173b().m10661c(60, null).m1355b());
        return sb.toString();
    }
}
