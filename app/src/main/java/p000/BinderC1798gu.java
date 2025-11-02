package p000;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class BinderC1798gu extends AbstractBinderC2353su {

    public final AtomicReference f5650c = new AtomicReference();

    public boolean f5651d;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
    
        r3 = r3.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static Object m7760Q(Bundle r3, Class r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L3e
            java.lang.String r1 = "r"
            java.lang.Object r3 = r3.get(r1)
            if (r3 == 0) goto L3e
            java.lang.Object r3 = r4.cast(r3)     // Catch: java.lang.ClassCastException -> L10
            return r3
        L10:
            r0 = move-exception
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getCanonicalName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected object type. Expected, Received"
            r1.append(r2)
            java.lang.String r2 = ": %s, %s"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r3 = new java.lang.Object[]{r4, r3}
            java.lang.String r3 = java.lang.String.format(r1, r3)
            java.lang.String r4 = "AM"
            android.util.Log.w(r4, r3, r0)
            throw r0
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.BinderC1798gu.m7760Q(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    public final Bundle m7761P(long j) {
        Bundle bundle;
        synchronized (this.f5650c) {
            if (!this.f5651d) {
                try {
                    this.f5650c.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.f5650c.get();
        }
        return bundle;
    }

    public final Long m7762R(long j) {
        return (Long) m7760Q(m7761P(j), Long.class);
    }

    public final String m7763S(long j) {
        return (String) m7760Q(m7761P(j), String.class);
    }

    @Override
    public final void mo7764f(Bundle bundle) {
        synchronized (this.f5650c) {
            try {
                try {
                    this.f5650c.set(bundle);
                    this.f5651d = true;
                } finally {
                    this.f5650c.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
