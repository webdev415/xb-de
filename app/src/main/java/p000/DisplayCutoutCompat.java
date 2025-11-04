package p000;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.List;

public final class DisplayCutoutCompat {

    public final DisplayCutout f3930a;

    public static class a {
        public static DisplayCutout m5759a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        public static List<Rect> m5760b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        public static int m5761c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        public static int m5762d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        public static int m5763e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        public static int m5764f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    public DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.f3930a = displayCutout;
    }

    public static DisplayCutoutCompat m5754e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    public int m5755a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.m5761c(this.f3930a);
        }
        return 0;
    }

    public int m5756b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.m5762d(this.f3930a);
        }
        return 0;
    }

    public int m5757c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.m5763e(this.f3930a);
        }
        return 0;
    }

    public int m5758d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.m5764f(this.f3930a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        return AbstractC0349Hh.m1589a(this.f3930a, ((DisplayCutoutCompat) obj).f3930a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f3930a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f3930a + "}";
    }
}
