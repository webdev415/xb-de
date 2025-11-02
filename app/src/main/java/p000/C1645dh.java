package p000;

import java.util.Collection;
import java.util.Map;

public final class C1645dh extends AbstractC0946Uh {

    public static final AbstractC1182Zn[] f5320b = new AbstractC1182Zn[0];

    public final AbstractC1182Zn[] f5321a;

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1645dh(Map r3) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 != 0) goto L7
            r3 = 0
            goto Lf
        L7:
            A7 r0 = p000.EnumC0008A7.POSSIBLE_FORMATS
            java.lang.Object r3 = r3.get(r0)
            java.util.Collection r3 = (java.util.Collection) r3
        Lf:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L55
            m2 r1 = p000.EnumC2039m2.EAN_13
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L27
            G9 r1 = new G9
            r1.<init>()
        L23:
            r0.add(r1)
            goto L35
        L27:
            m2 r1 = p000.EnumC2039m2.UPC_A
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L35
            Un r1 = new Un
            r1.<init>()
            goto L23
        L35:
            m2 r1 = p000.EnumC2039m2.EAN_8
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L45
            I9 r1 = new I9
            r1.<init>()
            r0.add(r1)
        L45:
            m2 r1 = p000.EnumC2039m2.UPC_E
            boolean r3 = r3.contains(r1)
            if (r3 == 0) goto L55
            bo r3 = new bo
            r3.<init>()
            r0.add(r3)
        L55:
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L73
            G9 r3 = new G9
            r3.<init>()
            r0.add(r3)
            I9 r3 = new I9
            r3.<init>()
            r0.add(r3)
            bo r3 = new bo
            r3.<init>()
            r0.add(r3)
        L73:
            Zn[] r3 = p000.C1645dh.f5320b
            java.lang.Object[] r3 = r0.toArray(r3)
            Zn[] r3 = (p000.AbstractC1182Zn[]) r3
            r2.f5321a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1645dh.<init>(java.util.Map):void");
    }

    @Override
    public void mo140c() {
        for (AbstractC1182Zn abstractC1182Zn : this.f5321a) {
            abstractC1182Zn.mo140c();
        }
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) throws C2340sh {
        int[] iArrM5076q = AbstractC1182Zn.m5076q(c0233f2);
        for (AbstractC1182Zn abstractC1182Zn : this.f5321a) {
            try {
                C0720Pk c0720PkMo4288n = abstractC1182Zn.mo4288n(i, c0233f2, iArrM5076q, map);
                boolean z = c0720PkMo4288n.m3576b() == BarcodeFormat.EAN_13 && c0720PkMo4288n.m3580f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z || !z2) {
                    return c0720PkMo4288n;
                }
                C0720Pk c0720Pk = new C0720Pk(c0720PkMo4288n.m3580f().substring(1), c0720PkMo4288n.m3577c(), c0720PkMo4288n.m3579e(), BarcodeFormat.UPC_A);
                c0720Pk.m3581g(c0720PkMo4288n.m3578d());
                return c0720Pk;
            } catch (AbstractC1327bk unused) {
            }
        }
        throw C2340sh.m9579a();
    }
}
