package p000;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractC1737fg {

    public final LinkedHashMap f5498a;

    public int f5499b;

    public int f5500c;

    public int f5501d;

    public int f5502e;

    public int f5503f;

    public int f5504g;

    public int f5505h;

    public AbstractC1737fg(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f5500c = i;
        this.f5498a = new LinkedHashMap(0, 0.75f, true);
    }

    public abstract Object mo4858a(Object obj);

    public final Object m7587c(Object obj) {
        Object objPut;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Object obj2 = this.f5498a.get(obj);
                if (obj2 != null) {
                    this.f5504g++;
                    return obj2;
                }
                this.f5505h++;
                Object objMo4858a = mo4858a(obj);
                if (objMo4858a == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.f5502e++;
                        objPut = this.f5498a.put(obj, objMo4858a);
                        if (objPut != null) {
                            this.f5498a.put(obj, objPut);
                        } else {
                            this.f5499b += m7590f(obj, objMo4858a);
                        }
                    } finally {
                    }
                }
                if (objPut != null) {
                    m7586b(false, obj, objMo4858a, objPut);
                    return objPut;
                }
                m7593i(this.f5500c);
                return objMo4858a;
            } finally {
            }
        }
    }

    public final Object m7588d(Object obj, Object obj2) {
        Object objPut;
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f5501d++;
                this.f5499b += m7590f(obj, obj2);
                objPut = this.f5498a.put(obj, obj2);
                if (objPut != null) {
                    this.f5499b -= m7590f(obj, objPut);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objPut != null) {
            m7586b(false, obj, objPut, obj2);
        }
        m7593i(this.f5500c);
        return objPut;
    }

    public final Object m7589e(Object obj) {
        Object objRemove;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                objRemove = this.f5498a.remove(obj);
                if (objRemove != null) {
                    this.f5499b -= m7590f(obj, objRemove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objRemove != null) {
            m7586b(false, obj, objRemove, null);
        }
        return objRemove;
    }

    public final int m7590f(Object obj, Object obj2) {
        int iM7591g = m7591g(obj, obj2);
        if (iM7591g >= 0) {
            return iM7591g;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    public int m7591g(Object obj, Object obj2) {
        return 1;
    }

    public final synchronized Map m7592h() {
        return new LinkedHashMap(this.f5498a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7593i(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f5499b     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L55
            java.util.LinkedHashMap r0 = r4.f5498a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r4.f5499b     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L55
            goto L14
        L12:
            r5 = move-exception
            goto L74
        L14:
            int r0 = r4.f5499b     // Catch: java.lang.Throwable -> L12
            if (r0 <= r5) goto L53
            java.util.LinkedHashMap r0 = r4.f5498a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L53
        L21:
            java.util.LinkedHashMap r0 = r4.f5498a     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap r2 = r4.f5498a     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            int r2 = r4.f5499b     // Catch: java.lang.Throwable -> L12
            int r3 = r4.m7590f(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r3
            r4.f5499b = r2     // Catch: java.lang.Throwable -> L12
            int r2 = r4.f5503f     // Catch: java.lang.Throwable -> L12
            r3 = 1
            int r2 = r2 + r3
            r4.f5503f = r2     // Catch: java.lang.Throwable -> L12
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            r2 = 0
            r4.m7586b(r3, r1, r0, r2)
            goto L0
        L53:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            return
        L55:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r5     // Catch: java.lang.Throwable -> L12
        L74:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC1737fg.m7593i(int):void");
    }

    public final synchronized String toString() {
        int i;
        int i2;
        try {
            i = this.f5504g;
            i2 = this.f5505h + i;
        } catch (Throwable th) {
            throw th;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f5500c), Integer.valueOf(this.f5504g), Integer.valueOf(this.f5505h), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public void m7586b(boolean z, Object obj, Object obj2, Object obj3) {
    }
}
