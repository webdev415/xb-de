package p000;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class C1324bh extends AbstractC0946Uh {

    public static final AbstractC0946Uh[] f3875b = new AbstractC0946Uh[0];

    public final AbstractC0946Uh[] f3876a;

    public C1324bh(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList<>();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new C1645dh(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new C1062X4(z));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new C1154Z4());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new C0970V4());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new C0713Pd());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new C0878T4());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new C0856Sj());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new C0902Tj());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C1645dh(map));
            arrayList.add(new C1062X4());
            arrayList.add(new C0878T4());
            arrayList.add(new C1154Z4());
            arrayList.add(new C0970V4());
            arrayList.add(new C0713Pd());
            arrayList.add(new C0856Sj());
            arrayList.add(new C0902Tj());
        }
        this.f3876a = (AbstractC0946Uh[]) arrayList.toArray(f3875b);
    }

    @Override
    public void mo140c() {
        for (AbstractC0946Uh abstractC0946Uh : this.f3876a) {
            abstractC0946Uh.mo140c();
        }
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) throws C2340sh {
        for (AbstractC0946Uh abstractC0946Uh : this.f3876a) {
            try {
                return abstractC0946Uh.mo3558d(i, c0233f2, map);
            } catch (AbstractC1327bk unused) {
            }
        }
        throw C2340sh.m9579a();
    }
}
