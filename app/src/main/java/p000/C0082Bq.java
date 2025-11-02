package p000;

import java.util.EnumMap;
import p000.C0425JA;

/* loaded from: classes.dex */
public final class C0082Bq {

    public final EnumMap f210a;

    public C0082Bq() {
        this.f210a = new EnumMap(C0425JA.a.class);
    }

    public static C0082Bq m340a(String str) {
        EnumMap enumMap = new EnumMap(C0425JA.a.class);
        if (str.length() >= C0425JA.a.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                C0425JA.a[] aVarArrValues = C0425JA.a.values();
                int length = aVarArrValues.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put((EnumMap) aVarArrValues[i], (C0425JA.a) EnumC0404Iq.m1718e(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new C0082Bq(enumMap);
            }
        }
        return new C0082Bq();
    }

    public final EnumC0404Iq m341b(C0425JA.a aVar) {
        EnumC0404Iq enumC0404Iq = (EnumC0404Iq) this.f210a.get(aVar);
        return enumC0404Iq == null ? EnumC0404Iq.UNSET : enumC0404Iq;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m342c(C0425JA.a r3, int r4) {
        /*
            r2 = this;
            Iq r0 = p000.EnumC0404Iq.UNSET
            r1 = -30
            if (r4 == r1) goto L1e
            r1 = -20
            if (r4 == r1) goto L1b
            r1 = -10
            if (r4 == r1) goto L18
            if (r4 == 0) goto L1b
            r1 = 30
            if (r4 == r1) goto L15
            goto L20
        L15:
            Iq r0 = p000.EnumC0404Iq.INITIALIZATION
            goto L20
        L18:
            Iq r0 = p000.EnumC0404Iq.MANIFEST
            goto L20
        L1b:
            Iq r0 = p000.EnumC0404Iq.API
            goto L20
        L1e:
            Iq r0 = p000.EnumC0404Iq.TCF
        L20:
            java.util.EnumMap r4 = r2.f210a
            r4.put(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0082Bq.m342c(JA$a, int):void");
    }

    public final void m343d(C0425JA.a aVar, EnumC0404Iq enumC0404Iq) {
        this.f210a.put((EnumMap) aVar, (C0425JA.a) enumC0404Iq);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (C0425JA.a aVar : C0425JA.a.values()) {
            EnumC0404Iq enumC0404Iq = (EnumC0404Iq) this.f210a.get(aVar);
            if (enumC0404Iq == null) {
                enumC0404Iq = EnumC0404Iq.UNSET;
            }
            sb.append(enumC0404Iq.f1224l);
        }
        return sb.toString();
    }

    public C0082Bq(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(C0425JA.a.class);
        this.f210a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
