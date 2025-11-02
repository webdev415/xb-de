package p000;

/* loaded from: classes.dex */
public final class C1804h extends AbstractC1990l {

    public final String f5672c;

    public final String f5673d;

    public C1804h(C0233F2 c0233f2, String str, String str2) {
        super(c0233f2);
        this.f5672c = str2;
        this.f5673d = str;
    }

    @Override
    public String mo175d() throws C2340sh {
        if (m174c().m1193o() != 84) {
            throw C2340sh.m9579a();
        }
        StringBuilder sb = new StringBuilder();
        m8229f(sb, 8);
        m8343j(sb, 48, 20);
        m7775k(sb, 68);
        return sb.toString();
    }

    @Override
    public void mo7275h(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.f5673d);
        sb.append(i / 100000);
        sb.append(')');
    }

    @Override
    public int mo7276i(int i) {
        return i % 100000;
    }

    public final void m7775k(StringBuilder sb, int i) {
        int iM10664f = m173b().m10664f(i, 16);
        if (iM10664f == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f5672c);
        sb.append(')');
        int i2 = iM10664f % 32;
        int i3 = iM10664f / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }
}
