package p000;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class C1071XD extends LinkedHashMap {

    public static final C1071XD f3209m;

    public boolean f3210l;

    static {
        C1071XD c1071xd = new C1071XD();
        f3209m = c1071xd;
        c1071xd.f3210l = false;
    }

    public C1071XD() {
        this.f3210l = true;
    }

    public static int m4703a(Object obj) {
        if (obj instanceof byte[]) {
            return AbstractC0932UC.m4208d((byte[]) obj);
        }
        if (obj instanceof InterfaceC1209aD) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    public static C1071XD m4704b() {
        return f3209m;
    }

    public final void m4705c(C1071XD c1071xd) {
        m4709h();
        if (c1071xd.isEmpty()) {
            return;
        }
        putAll(c1071xd);
    }

    @Override
    public final void clear() {
        m4709h();
        super.clear();
    }

    public final C1071XD m4706d() {
        return isEmpty() ? new C1071XD() : new C1071XD(this);
    }

    public final void m4707e() {
        this.f3210l = false;
    }

    @Override
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[RETURN] */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L5d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L59
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L16
        L14:
            r7 = r1
            goto L5a
        L16:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L1e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L35
            goto L14
        L35:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L52
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L52
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L56
        L52:
            boolean r3 = r4.equals(r3)
        L56:
            if (r3 != 0) goto L1e
            goto L14
        L59:
            r7 = r0
        L5a:
            if (r7 == 0) goto L5d
            return r0
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1071XD.equals(java.lang.Object):boolean");
    }

    public final boolean m4708f() {
        return this.f3210l;
    }

    public final void m4709h() {
        if (!this.f3210l) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int iM4703a = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            iM4703a += m4703a(entry.getValue()) ^ m4703a(entry.getKey());
        }
        return iM4703a;
    }

    @Override
    public final Object put(Object obj, Object obj2) {
        m4709h();
        AbstractC0932UC.m4209e(obj);
        AbstractC0932UC.m4209e(obj2);
        return super.put(obj, obj2);
    }

    @Override
    public final void putAll(Map map) {
        m4709h();
        for (Object obj : map.keySet()) {
            AbstractC0932UC.m4209e(obj);
            AbstractC0932UC.m4209e(map.get(obj));
        }
        super.putAll(map);
    }

    @Override
    public final Object remove(Object obj) {
        m4709h();
        return super.remove(obj);
    }

    public C1071XD(Map map) {
        super(map);
        this.f3210l = true;
    }
}
