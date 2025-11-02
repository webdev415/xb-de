package p000;

import java.util.Map;

public final class C0998Vn implements InterfaceC0081Bp {

    public final C0332H9 f2999a = new C0332H9();

    @Override
    public C0325H2 mo319a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return this.f2999a.mo319a("0".concat(String.valueOf(str)), BarcodeFormat.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(barcodeFormat)));
    }
}
