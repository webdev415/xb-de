package p000;

public final class C0728Ps extends AbstractC1750ft {

    public String f2177a;

    public boolean f2178b;

    public EnumC2075mt f2179c;

    public byte f2180d;

    @Override
    public final AbstractC1750ft mo3587a(EnumC2075mt enumC2075mt) {
        if (enumC2075mt == null) {
            throw new NullPointerException("Null filePurpose");
        }
        this.f2179c = enumC2075mt;
        return this;
    }

    @Override
    public final AbstractC1750ft mo3588b(boolean z) {
        this.f2180d = (byte) (this.f2180d | 1);
        return this;
    }

    @Override
    public final AbstractC1844ht mo3589c() {
        if (this.f2180d == 3 && this.f2177a != null && this.f2179c != null) {
            return new C0819Rs(this.f2177a, this.f2178b, this.f2179c);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f2177a == null) {
            sb.append(" fileOwner");
        }
        if ((this.f2180d & 1) == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if ((this.f2180d & 2) == 0) {
            sb.append(" skipChecks");
        }
        if (this.f2179c == null) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:" + String.valueOf(sb));
    }

    @Override
    public final AbstractC1750ft mo3590d(boolean z) {
        this.f2178b = z;
        this.f2180d = (byte) (this.f2180d | 2);
        return this;
    }

    public final AbstractC1750ft m3591e(String str) {
        this.f2177a = str;
        return this;
    }
}
