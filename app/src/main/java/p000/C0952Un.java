package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class C0952Un extends AbstractC1182Zn {

    public final AbstractC1182Zn f2872i = new C0286G9();

    public static C0720Pk m4287t(C0720Pk c0720Pk) throws C2610yb {
        String strM3580f = c0720Pk.m3580f();
        if (strM3580f.charAt(0) != '0') {
            throw C2610yb.m10853a();
        }
        C0720Pk c0720Pk2 = new C0720Pk(strM3580f.substring(1), null, c0720Pk.m3579e(), BarcodeFormat.UPC_A);
        if (c0720Pk.m3578d() != null) {
            c0720Pk2.m3581g(c0720Pk.m3578d());
        }
        return c0720Pk2;
    }

    @Override
    public C0720Pk decode(BinaryBitmap binaryBitmap) {
        return m4287t(this.f2872i.decode(binaryBitmap));
    }

    @Override
    public C0720Pk mo139b(BinaryBitmap binaryBitmap, Map map) {
        return m4287t(this.f2872i.mo139b(binaryBitmap, map));
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) {
        return m4287t(this.f2872i.mo3558d(i, c0233f2, map));
    }

    @Override
    public int mo1359m(C0233F2 c0233f2, int[] iArr, StringBuilder sb) {
        return this.f2872i.mo1359m(c0233f2, iArr, sb);
    }

    @Override
    public C0720Pk mo4288n(int i, C0233F2 c0233f2, int[] iArr, Map map) {
        return m4287t(this.f2872i.mo4288n(i, c0233f2, iArr, map));
    }

    @Override
    public BarcodeFormat mo1360r() {
        return BarcodeFormat.UPC_A;
    }
}
