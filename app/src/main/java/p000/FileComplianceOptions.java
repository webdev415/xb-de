package p000;

public final class FileComplianceOptions extends AbstractC1844ht {

    public final String f2548c;

    public final boolean f2549d;

    public final boolean f2550e;

    public final EnumC2075mt f2551f;

    public FileComplianceOptions(String str, boolean z, boolean z2, InterfaceC0636Ns interfaceC0636Ns, InterfaceC0544Ls interfaceC0544Ls, EnumC2075mt enumC2075mt) {
        this.f2548c = str;
        this.f2549d = z;
        this.f2550e = z2;
        this.f2551f = enumC2075mt;
    }

    @Override
    public final InterfaceC0636Ns mo3955a() {
        return null;
    }

    @Override
    public final InterfaceC0544Ls mo3956b() {
        return null;
    }

    @Override
    public final EnumC2075mt mo3957c() {
        return this.f2551f;
    }

    @Override
    public final String mo3958d() {
        return this.f2548c;
    }

    @Override
    public final boolean mo3959e() {
        return this.f2549d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1844ht) {
            AbstractC1844ht abstractC1844ht = (AbstractC1844ht) obj;
            if (this.f2548c.equals(abstractC1844ht.mo3958d()) && this.f2549d == abstractC1844ht.mo3959e() && this.f2550e == abstractC1844ht.mo3960f()) {
                abstractC1844ht.mo3955a();
                abstractC1844ht.mo3956b();
                if (this.f2551f.equals(abstractC1844ht.mo3957c())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final boolean mo3960f() {
        return this.f2550e;
    }

    public final int hashCode() {
        return ((((((this.f2548c.hashCode() ^ 1000003) * 1000003) ^ (this.f2549d ? 1231 : 1237)) * 1000003) ^ (this.f2550e ? 1231 : 1237)) * 583896283) ^ this.f2551f.hashCode();
    }

    public final String toString() {
        return "FileComplianceOptions{fileOwner=" + this.f2548c + ", hasDifferentDmaOwner=" + this.f2549d + ", skipChecks=" + this.f2550e + ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=" + String.valueOf(this.f2551f) + "}";
    }
}
