package p000;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class C1093Xq implements InterfaceC0909Tq, Iterable {

    public final String f3292l;

    public C1093Xq(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.f3292l = str;
    }

    @Override
    public final InterfaceC0909Tq mo151c() {
        return new C1093Xq(this.f3292l);
    }

    @Override
    public final Boolean mo152d() {
        return Boolean.valueOf(!this.f3292l.isEmpty());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1093Xq) {
            return this.f3292l.equals(((C1093Xq) obj).f3292l);
        }
        return false;
    }

    @Override
    public final Double mo153f() {
        double d;
        if (this.f3292l.isEmpty()) {
            d = 0.0d;
        } else {
            try {
                return Double.valueOf(this.f3292l);
            } catch (NumberFormatException unused) {
                d = Double.NaN;
            }
        }
        return Double.valueOf(d);
    }

    @Override
    public final String mo154h() {
        return this.f3292l;
    }

    public final int hashCode() {
        return this.f3292l.hashCode();
    }

    @Override
    public final Iterator mo155i() {
        return new C1654dr(this);
    }

    @Override
    public final Iterator iterator() {
        return new C1334br(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb A[PHI: r6 r7 r14 r15
  0x00cb: PHI (r6v31 java.lang.String) = 
  (r6v4 java.lang.String)
  (r6v5 java.lang.String)
  (r6v6 java.lang.String)
  (r6v7 java.lang.String)
  (r6v32 java.lang.String)
 binds: [B:111:0x019c, B:107:0x018a, B:103:0x0178, B:99:0x0166, B:43:0x00c3] A[DONT_GENERATE, DONT_INLINE]
  0x00cb: PHI (r7v13 java.lang.String) = 
  (r7v1 java.lang.String)
  (r7v2 java.lang.String)
  (r7v3 java.lang.String)
  (r7v4 java.lang.String)
  (r7v14 java.lang.String)
 binds: [B:111:0x019c, B:107:0x018a, B:103:0x0178, B:99:0x0166, B:43:0x00c3] A[DONT_GENERATE, DONT_INLINE]
  0x00cb: PHI (r14v10 java.lang.String) = 
  (r14v1 java.lang.String)
  (r14v2 java.lang.String)
  (r14v3 java.lang.String)
  (r14v4 java.lang.String)
  (r14v11 java.lang.String)
 binds: [B:111:0x019c, B:107:0x018a, B:103:0x0178, B:99:0x0166, B:43:0x00c3] A[DONT_GENERATE, DONT_INLINE]
  0x00cb: PHI (r15v7 java.lang.String) = 
  (r15v1 java.lang.String)
  (r15v2 java.lang.String)
  (r15v3 java.lang.String)
  (r15v4 java.lang.String)
  (r15v8 java.lang.String)
 binds: [B:111:0x019c, B:107:0x018a, B:103:0x0178, B:99:0x0166, B:43:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015a  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final InterfaceC0909Tq mo156o(String r22, C2357sy r23, java.util.List r24) {
        /*
            Method dump skipped, instructions count: 1782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1093Xq.mo156o(java.lang.String, sy, java.util.List):Tq");
    }

    public final String toString() {
        return "\"" + this.f3292l + "\"";
    }
}
