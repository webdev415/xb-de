package p000;

import java.util.ArrayList;
import java.util.List;

public final class C2066mk {

    public final C2611yc f6254a;

    public final List f6255b;

    public C2066mk(C2611yc c2611yc) {
        this.f6254a = c2611yc;
        ArrayList arrayList = new ArrayList<>();
        this.f6255b = arrayList;
        arrayList.add(new C2657zc(c2611yc, new int[]{1}));
    }

    public final C2657zc m8638a(int i) {
        if (i >= this.f6255b.size()) {
            List list = this.f6255b;
            C2657zc c2657zcM11017i = (C2657zc) list.get(list.size() - 1);
            for (int size = this.f6255b.size(); size <= i; size++) {
                C2611yc c2611yc = this.f6254a;
                c2657zcM11017i = c2657zcM11017i.m11017i(new C2657zc(c2611yc, new int[]{1, c2611yc.m10857c((size - 1) + c2611yc.m10858d())}));
                this.f6255b.add(c2657zcM11017i);
            }
        }
        return (C2657zc) this.f6255b.get(i);
    }

    public void m8639b(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        C2657zc c2657zcM8638a = m8638a(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrM11013e = new C2657zc(this.f6254a, iArr2).m11018j(i, 1).m11010b(c2657zcM8638a)[1].m11013e();
        int length2 = i - iArrM11013e.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(iArrM11013e, 0, iArr, length + length2, iArrM11013e.length);
    }
}
