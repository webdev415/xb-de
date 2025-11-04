package p000;

public final class LibraryVersion extends AbstractC0301Gf {

    public final String libraryName;

    public final String version;

    public LibraryVersion(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.libraryName = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.version = str2;
    }

    @Override
    public String mo1395b() {
        return this.libraryName;
    }

    @Override
    public String mo1396c() {
        return this.version;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0301Gf)) {
            return false;
        }
        AbstractC0301Gf abstractC0301Gf = (AbstractC0301Gf) obj;
        return this.libraryName.equals(abstractC0301Gf.mo1395b()) && this.version.equals(abstractC0301Gf.mo1396c());
    }

    public int hashCode() {
        return ((this.libraryName.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.libraryName + ", version=" + this.version + "}";
    }
}
