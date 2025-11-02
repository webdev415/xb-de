package p000;

import java.util.ArrayList;
import java.util.Map;

public final class C2341si implements InterfaceC1226ak {

    public static final C0720Pk[] f7070a = new C0720Pk[0];

    public static C0720Pk[] m9580d(BinaryBitmap binaryBitmap, Map map, boolean z) {
        ArrayList arrayList = new ArrayList<>();
        C2203pi c2203piM2831b = AbstractC0561M8.m2831b(binaryBitmap, map, z);
        for (C0857Sk[] c0857SkArr : c2203piM2831b.m9073b()) {
            C0698P7 c0698p7M10160i = AbstractC2433ui.m10160i(c2203piM2831b.m9072a(), c0857SkArr[4], c0857SkArr[5], c0857SkArr[6], c0857SkArr[7], m9583g(c0857SkArr), m9581e(c0857SkArr));
            C0720Pk c0720Pk = new C0720Pk(c0698p7M10160i.m3483h(), c0698p7M10160i.m3480e(), c0857SkArr, BarcodeFormat.PDF_417);
            c0720Pk.m3582h(EnumC0811Rk.ERROR_CORRECTION_LEVEL, c0698p7M10160i.m3477b());
            C2387ti c2387ti = (C2387ti) c0698p7M10160i.m3479d();
            if (c2387ti != null) {
                c0720Pk.m3582h(EnumC0811Rk.PDF417_EXTRA_METADATA, c2387ti);
            }
            arrayList.add(c0720Pk);
        }
        return (C0720Pk[]) arrayList.toArray(f7070a);
    }

    public static int m9581e(C0857Sk[] c0857SkArr) {
        return Math.max(Math.max(m9582f(c0857SkArr[0], c0857SkArr[4]), (m9582f(c0857SkArr[6], c0857SkArr[2]) * 17) / 18), Math.max(m9582f(c0857SkArr[1], c0857SkArr[5]), (m9582f(c0857SkArr[7], c0857SkArr[3]) * 17) / 18));
    }

    public static int m9582f(C0857Sk c0857Sk, C0857Sk c0857Sk2) {
        if (c0857Sk == null || c0857Sk2 == null) {
            return 0;
        }
        return (int) Math.abs(c0857Sk.m4067c() - c0857Sk2.m4067c());
    }

    public static int m9583g(C0857Sk[] c0857SkArr) {
        return Math.min(Math.min(m9584h(c0857SkArr[0], c0857SkArr[4]), (m9584h(c0857SkArr[6], c0857SkArr[2]) * 17) / 18), Math.min(m9584h(c0857SkArr[1], c0857SkArr[5]), (m9584h(c0857SkArr[7], c0857SkArr[3]) * 17) / 18));
    }

    public static int m9584h(C0857Sk c0857Sk, C0857Sk c0857Sk2) {
        if (c0857Sk == null || c0857Sk2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(c0857Sk.m4067c() - c0857Sk2.m4067c());
    }

    @Override
    public C0720Pk decode(BinaryBitmap binaryBitmap) {
        return mo139b(binaryBitmap, null);
    }

    @Override
    public C0720Pk mo139b(BinaryBitmap binaryBitmap, Map map) throws C2340sh {
        C0720Pk c0720Pk;
        C0720Pk[] c0720PkArrM9580d = m9580d(binaryBitmap, map, false);
        if (c0720PkArrM9580d.length == 0 || (c0720Pk = c0720PkArrM9580d[0]) == null) {
            throw C2340sh.m9579a();
        }
        return c0720Pk;
    }

    @Override
    public void mo140c() {
    }
}
