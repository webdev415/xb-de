package p000;

import android.graphics.Rect;

public final class Insets {

    public static final Insets f7064e = new Insets(0, 0, 0, 0);

    public final int f7065a;

    public final int f7066b;

    public final int f7067c;

    public final int f7068d;

    public static class a {
        public static android.graphics.Insets m9571a(int i, int i2, int i3, int i4) {
            return android.graphics.Insets.of(i, i2, i3, i4);
        }
    }

    public Insets(int i, int i2, int i3, int i4) {
        this.f7065a = i;
        this.f7066b = i2;
        this.f7067c = i3;
        this.f7068d = i4;
    }

    public static Insets m9566a(Insets insets, Insets insets2) {
        return m9567b(Math.max(insets.f7065a, insets2.f7065a), Math.max(insets.f7066b, insets2.f7066b), Math.max(insets.f7067c, insets2.f7067c), Math.max(insets.f7068d, insets2.f7068d));
    }

    public static Insets m9567b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? f7064e : new Insets(i, i2, i3, i4);
    }

    public static Insets m9568c(Rect rect) {
        return m9567b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static Insets m9569d(android.graphics.Insets insets) {
        return m9567b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public android.graphics.Insets m9570e() {
        return a.m9571a(this.f7065a, this.f7066b, this.f7067c, this.f7068d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.f7068d == insets.f7068d && this.f7065a == insets.f7065a && this.f7067c == insets.f7067c && this.f7066b == insets.f7066b;
    }

    public int hashCode() {
        return (((((this.f7065a * 31) + this.f7066b) * 31) + this.f7067c) * 31) + this.f7068d;
    }

    public String toString() {
        return "Insets{left=" + this.f7065a + ", top=" + this.f7066b + ", right=" + this.f7067c + ", bottom=" + this.f7068d + '}';
    }
}
