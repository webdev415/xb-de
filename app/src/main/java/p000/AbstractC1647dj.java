package p000;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractC1647dj {

    public static final String f5322a = "dj";

    public class a implements Comparator {

        public final C1180Zl f5323l;

        public a(C1180Zl c1180Zl) {
            this.f5323l = c1180Zl;
        }

        @Override
        public int compare(C1180Zl c1180Zl, C1180Zl c1180Zl2) {
            return Float.compare(AbstractC1647dj.this.mo7327c(c1180Zl2, this.f5323l), AbstractC1647dj.this.mo7327c(c1180Zl, this.f5323l));
        }
    }

    public List m7325a(List list, C1180Zl c1180Zl) {
        if (c1180Zl == null) {
            return list;
        }
        Collections.sort(list, new a(c1180Zl));
        return list;
    }

    public C1180Zl m7326b(List list, C1180Zl c1180Zl) {
        List listM7325a = m7325a(list, c1180Zl);
        String str = f5322a;
        Log.i(str, "Viewfinder size: " + c1180Zl);
        Log.i(str, "Preview in order of preference: " + listM7325a);
        return (C1180Zl) listM7325a.get(0);
    }

    public abstract float mo7327c(C1180Zl c1180Zl, C1180Zl c1180Zl2);

    public abstract Rect mo7328d(C1180Zl c1180Zl, C1180Zl c1180Zl2);
}
