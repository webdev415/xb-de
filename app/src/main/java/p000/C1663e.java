package p000;

/* loaded from: classes.dex */
public final class C1663e extends AbstractC1851i {
    public C1663e(C0233F2 c0233f2) {
        super(c0233f2);
    }

    @Override
    public void mo7275h(StringBuilder sb, int i) {
        sb.append(i < 10000 ? "(3202)" : "(3203)");
    }

    @Override
    public int mo7276i(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
