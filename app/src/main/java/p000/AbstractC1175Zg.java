package p000;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractC1175Zg {

    public static final class b {

        public final String f3444a;

        public final a f3445b;

        public a f3446c;

        public boolean f3447d;

        public boolean f3448e;

        public static class a {

            public String f3449a;

            public Object f3450b;

            public a f3451c;

            public a() {
            }
        }

        public b(String str) {
            a aVar = new a();
            this.f3445b = aVar;
            this.f3446c = aVar;
            this.f3447d = false;
            this.f3448e = false;
            this.f3444a = (String) AbstractC1131Yi.m4973i(str);
        }

        public static boolean m5042d(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof AbstractC1325bi ? !((AbstractC1325bi) obj).mo5674c() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public final a m5043a() {
            a aVar = new a();
            this.f3446c.f3451c = aVar;
            this.f3446c = aVar;
            return aVar;
        }

        public final b m5044b(Object obj) {
            m5043a().f3450b = obj;
            return this;
        }

        public b m5045c(Object obj) {
            return m5044b(obj);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public String toString() {
            /*
                r7 = this;
                boolean r0 = r7.f3447d
                boolean r1 = r7.f3448e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = 32
                r2.<init>(r3)
                java.lang.String r3 = r7.f3444a
                r2.append(r3)
                r3 = 123(0x7b, float:1.72E-43)
                r2.append(r3)
                Zg$b$a r3 = r7.f3445b
                Zg$b$a r3 = r3.f3451c
                java.lang.String r4 = ""
            L1b:
                if (r3 == 0) goto L61
                java.lang.Object r5 = r3.f3450b
                if (r5 != 0) goto L24
                if (r0 != 0) goto L5e
                goto L2c
            L24:
                if (r1 == 0) goto L2c
                boolean r6 = m5042d(r5)
                if (r6 != 0) goto L5e
            L2c:
                r2.append(r4)
                java.lang.String r4 = r3.f3449a
                if (r4 == 0) goto L3b
                r2.append(r4)
                r4 = 61
                r2.append(r4)
            L3b:
                if (r5 == 0) goto L59
                java.lang.Class r4 = r5.getClass()
                boolean r4 = r4.isArray()
                if (r4 == 0) goto L59
                java.lang.Object[] r4 = new java.lang.Object[]{r5}
                java.lang.String r4 = java.util.Arrays.deepToString(r4)
                int r5 = r4.length()
                r6 = 1
                int r5 = r5 - r6
                r2.append(r4, r6, r5)
                goto L5c
            L59:
                r2.append(r5)
            L5c:
                java.lang.String r4 = ", "
            L5e:
                Zg$b$a r3 = r3.f3451c
                goto L1b
            L61:
                r0 = 125(0x7d, float:1.75E-43)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC1175Zg.b.toString():java.lang.String");
        }
    }

    public static b m5041a(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
