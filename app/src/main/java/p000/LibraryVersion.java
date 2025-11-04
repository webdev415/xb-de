package p000;

public final class C0875T1 extends AbstractC0301Gf {

    public final String f2683a;

    public final String f2684b;

    public C0875T1(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f2683a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f2684b = str2;
    }

    @Override
    public String mo1395b() {
        return this.f2683a;
    }

    @Override
    public String mo1396c() {
        return this.f2684b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0301Gf)) {
            return false;
        }
        AbstractC0301Gf abstractC0301Gf = (AbstractC0301Gf) obj;
        return this.f2683a.equals(abstractC0301Gf.mo1395b()) && this.f2684b.equals(abstractC0301Gf.mo1396c());
    }

    public int hashCode() {
        return ((this.f2683a.hashCode() ^ 1000003) * 1000003) ^ this.f2684b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f2683a + ", version=" + this.f2684b + "}";
    }
}
