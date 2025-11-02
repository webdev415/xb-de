package p000;

import java.util.Objects;

/* loaded from: classes.dex */
public final class C0342Ha {

    public final C1859i7 f1048a;

    public final C1859i7 f1049b;

    public final C1077Xa f1050c;

    public C0342Ha(C1859i7 c1859i7, C1859i7 c1859i72, C1077Xa c1077Xa) {
        this.f1048a = c1859i7;
        this.f1049b = c1859i72;
        this.f1050c = c1077Xa;
    }

    public C1077Xa m1561a() {
        return this.f1050c;
    }

    public C1859i7 m1562b() {
        return this.f1048a;
    }

    public C1859i7 m1563c() {
        return this.f1049b;
    }

    public boolean m1564d() {
        return this.f1049b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0342Ha)) {
            return false;
        }
        C0342Ha c0342Ha = (C0342Ha) obj;
        return Objects.equals(this.f1048a, c0342Ha.f1048a) && Objects.equals(this.f1049b, c0342Ha.f1049b) && Objects.equals(this.f1050c, c0342Ha.f1050c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f1048a) ^ Objects.hashCode(this.f1049b)) ^ Objects.hashCode(this.f1050c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f1048a);
        sb.append(" , ");
        sb.append(this.f1049b);
        sb.append(" : ");
        C1077Xa c1077Xa = this.f1050c;
        sb.append(c1077Xa == null ? "null" : Integer.valueOf(c1077Xa.m4736c()));
        sb.append(" ]");
        return sb.toString();
    }
}
