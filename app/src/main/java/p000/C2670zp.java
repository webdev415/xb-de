package p000;

import android.content.Context;

/* loaded from: classes.dex */
public class C2670zp {

    public static final C2670zp f8279b = new C2670zp();

    public C2617yi f8280a = null;

    public static C2617yi m11048a(Context context) {
        return f8279b.m11049b(context);
    }

    public final synchronized C2617yi m11049b(Context context) {
        try {
            if (this.f8280a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f8280a = new C2617yi(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f8280a;
    }
}
