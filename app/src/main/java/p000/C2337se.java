package p000;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class C2337se {

    public static final C2337se f7064e = new C2337se(0, 0, 0, 0);

    public final int f7065a;

    public final int f7066b;

    public final int f7067c;

    public final int f7068d;

    public static class a {
        public static Insets m9571a(int i, int i2, int i3, int i4) {
            return Insets.of(i, i2, i3, i4);
        }
    }

    public C2337se(int i, int i2, int i3, int i4) {
        this.f7065a = i;
        this.f7066b = i2;
        this.f7067c = i3;
        this.f7068d = i4;
    }

    public static C2337se m9566a(C2337se c2337se, C2337se c2337se2) {
        return m9567b(Math.max(c2337se.f7065a, c2337se2.f7065a), Math.max(c2337se.f7066b, c2337se2.f7066b), Math.max(c2337se.f7067c, c2337se2.f7067c), Math.max(c2337se.f7068d, c2337se2.f7068d));
    }

    public static C2337se m9567b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? f7064e : new C2337se(i, i2, i3, i4);
    }

    public static C2337se m9568c(Rect rect) {
        return m9567b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static C2337se m9569d(Insets insets) {
        return m9567b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets m9570e() {
        return a.m9571a(this.f7065a, this.f7066b, this.f7067c, this.f7068d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2337se.class != obj.getClass()) {
            return false;
        }
        C2337se c2337se = (C2337se) obj;
        return this.f7068d == c2337se.f7068d && this.f7065a == c2337se.f7065a && this.f7067c == c2337se.f7067c && this.f7066b == c2337se.f7066b;
    }

    public int hashCode() {
        return (((((this.f7065a * 31) + this.f7066b) * 31) + this.f7067c) * 31) + this.f7068d;
    }

    public String toString() {
        return "Insets{left=" + this.f7065a + ", top=" + this.f7066b + ", right=" + this.f7067c + ", bottom=" + this.f7068d + '}';
    }
}
