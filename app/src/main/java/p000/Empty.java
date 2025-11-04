package p000;

public final class Empty implements InterfaceC1876ie {

    public final boolean f1760l;

    public Empty(boolean z) {
        this.f1760l = z;
    }

    @Override
    public boolean mo2837a() {
        return this.f1760l;
    }

    @Override
    public C2202ph mo2838f() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(mo2837a() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
