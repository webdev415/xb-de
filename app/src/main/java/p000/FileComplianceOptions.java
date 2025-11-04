package p000;

public final class FileComplianceOptions extends AbstractC1844ht {

    public final String fileOwner;

    public final boolean hasDifferentDmaOwner;

    public final boolean skipChecks;

    public final EnumC2075mt filePurpose;

    public FileComplianceOptions(String str, boolean z, boolean z2, InterfaceC0636Ns interfaceC0636Ns, InterfaceC0544Ls interfaceC0544Ls, EnumC2075mt enumC2075mt) {
        this.fileOwner = str;
        this.hasDifferentDmaOwner = z;
        this.skipChecks = z2;
        this.filePurpose = enumC2075mt;
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
        return this.filePurpose;
    }

    @Override
    public final String mo3958d() {
        return this.fileOwner;
    }

    @Override
    public final boolean mo3959e() {
        return this.hasDifferentDmaOwner;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1844ht) {
            AbstractC1844ht abstractC1844ht = (AbstractC1844ht) obj;
            if (this.fileOwner.equals(abstractC1844ht.mo3958d()) && this.hasDifferentDmaOwner == abstractC1844ht.mo3959e() && this.skipChecks == abstractC1844ht.mo3960f()) {
                abstractC1844ht.mo3955a();
                abstractC1844ht.mo3956b();
                if (this.filePurpose.equals(abstractC1844ht.mo3957c())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final boolean mo3960f() {
        return this.skipChecks;
    }

    public final int hashCode() {
        return ((((((this.fileOwner.hashCode() ^ 1000003) * 1000003) ^ (this.hasDifferentDmaOwner ? 1231 : 1237)) * 1000003) ^ (this.skipChecks ? 1231 : 1237)) * 583896283) ^ this.filePurpose.hashCode();
    }

    public final String toString() {
        return "FileComplianceOptions{fileOwner=" + this.fileOwner + ", hasDifferentDmaOwner=" + this.hasDifferentDmaOwner
                + ", skipChecks=" + this.skipChecks
                + ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=" + this.filePurpose + "}";
    }
}
