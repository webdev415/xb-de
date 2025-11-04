package p000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class C2556xC {

    public static final C2556xC f7946d = new C2556xC(true);

    public final AbstractC1118YE f7947a;

    public boolean f7948b;

    public boolean f7949c;

    public C2556xC() {
        this.f7947a = new C1679eF();
    }

    public static int m10634b(Map.Entry entry) {
        AbstractC2524wh.m10586a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public static int m10635c(InterfaceC0059BC interfaceC0059BC, Object obj) {
        EnumC1634dG enumC1634dGM224b = interfaceC0059BC.m224b();
        int iM223a = interfaceC0059BC.m223a();
        if (!interfaceC0059BC.m226f()) {
            return m10636d(enumC1634dGM224b, iM223a, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!interfaceC0059BC.m225d()) {
            int iM10636d = 0;
            while (i < size) {
                iM10636d += m10636d(enumC1634dGM224b, iM223a, list.get(i));
                i++;
            }
            return iM10636d;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iM10637e = 0;
        while (i < size) {
            iM10637e += m10637e(enumC1634dGM224b, list.get(i));
            i++;
        }
        return AbstractC1355cC.m5806s0(iM223a) + iM10637e + AbstractC1355cC.m5809v0(iM10637e);
    }

    public static int m10636d(EnumC1634dG enumC1634dG, int i, Object obj) {
        int iM5806s0 = AbstractC1355cC.m5806s0(i);
        if (enumC1634dG == EnumC1634dG.f5302w) {
            AbstractC0932UC.m4211g((InterfaceC1912jE) obj);
            iM5806s0 <<= 1;
        }
        return iM5806s0 + m10637e(enumC1634dG, obj);
    }

    public static int m10637e(EnumC1634dG enumC1634dG, Object obj) {
        switch (AbstractC2464vC.f7659b[enumC1634dG.ordinal()]) {
            case 1:
                return AbstractC1355cC.m5785c(((Double) obj).doubleValue());
            case 2:
                return AbstractC1355cC.m5787d(((Float) obj).floatValue());
            case 3:
                return AbstractC1355cC.m5784a0(((Long) obj).longValue());
            case 4:
                return AbstractC1355cC.m5803n0(((Long) obj).longValue());
            case 5:
                return AbstractC1355cC.m5794g0(((Integer) obj).intValue());
            case 6:
                return AbstractC1355cC.m5778S(((Long) obj).longValue());
            case 7:
                return AbstractC1355cC.m5786c0(((Integer) obj).intValue());
            case 8:
                return AbstractC1355cC.m5795h(((Boolean) obj).booleanValue());
            case 9:
                return AbstractC1355cC.m5773C((InterfaceC1912jE) obj);
            case 10:
                return AbstractC1355cC.m5779T((InterfaceC1912jE) obj);
            case 11:
                return obj instanceof AbstractC2233qB ? AbstractC1355cC.m5772B((AbstractC2233qB) obj) : AbstractC1355cC.m5771A((String) obj);
            case 12:
                return obj instanceof AbstractC2233qB ? AbstractC1355cC.m5772B((AbstractC2233qB) obj) : AbstractC1355cC.m5797i((byte[]) obj);
            case 13:
                return AbstractC1355cC.m5809v0(((Integer) obj).intValue());
            case 14:
                return AbstractC1355cC.m5800k0(((Integer) obj).intValue());
            case 15:
                return AbstractC1355cC.m5792f0(((Long) obj).longValue());
            case 16:
                return AbstractC1355cC.m5804o0(((Integer) obj).intValue());
            case 17:
                return AbstractC1355cC.m5799j0(((Long) obj).longValue());
            case 18:
                return obj instanceof InterfaceC1209aD ? AbstractC1355cC.m5781X(((InterfaceC1209aD) obj).mo1742a()) : AbstractC1355cC.m5781X(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m10638j(InterfaceC0059BC r3, Object r4) {
        /*
            dG r0 = r3.m224b()
            p000.AbstractC0932UC.m4209e(r4)
            int[] r1 = p000.AbstractC2464vC.f7658a
            xG r0 = r0.m7316c()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r1 = r2
            goto L42
        L1a:
            boolean r0 = r4 instanceof p000.InterfaceC1912jE
            if (r0 != 0) goto L42
            goto L18
        L1f:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L42
            boolean r0 = r4 instanceof p000.InterfaceC1209aD
            if (r0 == 0) goto L18
            goto L42
        L28:
            boolean r0 = r4 instanceof p000.AbstractC2233qB
            if (r0 != 0) goto L42
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L18
            goto L42
        L31:
            boolean r1 = r4 instanceof java.lang.String
            goto L42
        L34:
            boolean r1 = r4 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r1 = r4 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r1 = r4 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r1 = r4 instanceof java.lang.Long
            goto L42
        L40:
            boolean r1 = r4 instanceof java.lang.Integer
        L42:
            if (r1 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r3.m223a()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            dG r3 = r3.m224b()
            xG r3 = r3.m7316c()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r1, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2556xC.m10638j(BC, java.lang.Object):void");
    }

    public static boolean m10639k(Map.Entry entry) {
        AbstractC2524wh.m10586a(entry.getKey());
        throw null;
    }

    public final int m10640a() {
        int iM4909a = this.f7947a.m4909a();
        int iM10634b = 0;
        for (int i = 0; i < iM4909a; i++) {
            iM10634b += m10634b(this.f7947a.m4912f(i));
        }
        Iterator it = this.f7947a.m4913g().iterator();
        while (it.hasNext()) {
            iM10634b += m10634b((Map.Entry) it.next());
        }
        return iM10634b;
    }

    public final Object clone() {
        C2556xC c2556xC = new C2556xC();
        int iM4909a = this.f7947a.m4909a();
        for (int i = 0; i < iM4909a; i++) {
            Map.Entry entryM4912f = this.f7947a.m4912f(i);
            AbstractC2524wh.m10586a(entryM4912f.getKey());
            c2556xC.m10643h(null, entryM4912f.getValue());
        }
        for (Map.Entry entry : this.f7947a.m4913g()) {
            AbstractC2524wh.m10586a(entry.getKey());
            c2556xC.m10643h(null, entry.getValue());
        }
        c2556xC.f7949c = this.f7949c;
        return c2556xC;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2556xC) {
            return this.f7947a.equals(((C2556xC) obj).f7947a);
        }
        return false;
    }

    public final void m10641f(C2556xC c2556xC) {
        int iM4909a = c2556xC.f7947a.m4909a();
        for (int i = 0; i < iM4909a; i++) {
            m10642g(c2556xC.f7947a.m4912f(i));
        }
        Iterator it = c2556xC.f7947a.m4913g().iterator();
        while (it.hasNext()) {
            m10642g((Map.Entry) it.next());
        }
    }

    public final void m10642g(Map.Entry entry) {
        AbstractC2524wh.m10586a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public final void m10643h(InterfaceC0059BC interfaceC0059BC, Object obj) {
        if (!interfaceC0059BC.m226f()) {
            m10638j(interfaceC0059BC, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                m10638j(interfaceC0059BC, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        this.f7947a.put(interfaceC0059BC, obj);
    }

    public final int hashCode() {
        return this.f7947a.hashCode();
    }

    public final Iterator m10644i() {
        return this.f7947a.isEmpty() ? Collections.emptyIterator() : this.f7949c ? new C2235qD(this.f7947a.m4915k().iterator()) : this.f7947a.m4915k().iterator();
    }

    public final Iterator m10645l() {
        return this.f7947a.isEmpty() ? Collections.emptyIterator() : this.f7949c ? new C2235qD(this.f7947a.entrySet().iterator()) : this.f7947a.entrySet().iterator();
    }

    public final void m10646m() {
        if (this.f7948b) {
            return;
        }
        int iM4909a = this.f7947a.m4909a();
        for (int i = 0; i < iM4909a; i++) {
            Map.Entry entryM4912f = this.f7947a.m4912f(i);
            if (entryM4912f.getValue() instanceof AbstractC0703PC) {
                ((AbstractC0703PC) entryM4912f.getValue()).m3504D();
            }
        }
        this.f7947a.mo4916l();
        this.f7948b = true;
    }

    public final boolean m10647n() {
        int iM4909a = this.f7947a.m4909a();
        for (int i = 0; i < iM4909a; i++) {
            if (!m10639k(this.f7947a.m4912f(i))) {
                return false;
            }
        }
        Iterator it = this.f7947a.m4913g().iterator();
        while (it.hasNext()) {
            if (!m10639k((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public C2556xC(AbstractC1118YE abstractC1118YE) {
        this.f7947a = abstractC1118YE;
        m10646m();
    }

    public C2556xC(boolean z) {
        this(new C1679eF());
        m10646m();
    }
}
