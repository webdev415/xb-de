package p000;

import java.util.Map;

public final class C1691eh implements InterfaceC0081Bp {

    public static class a {

        public static final int[] f5426a;

        static {
            int[] iArr = new int[BarcodeFormat.values().length];
            f5426a = iArr;
            try {
                iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5426a[BarcodeFormat.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5426a[BarcodeFormat.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5426a[BarcodeFormat.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5426a[BarcodeFormat.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5426a[BarcodeFormat.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5426a[BarcodeFormat.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5426a[BarcodeFormat.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5426a[BarcodeFormat.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5426a[BarcodeFormat.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5426a[BarcodeFormat.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f5426a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f5426a[BarcodeFormat.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override
    public C0325H2 mo319a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) {
        InterfaceC0081Bp c0424j9;
        switch (a.f5426a[barcodeFormat.ordinal()]) {
            case 1:
                c0424j9 = new C0424J9();
                break;
            case 2:
                c0424j9 = new C1377co();
                break;
            case 3:
                c0424j9 = new C0332H9();
                break;
            case 4:
                c0424j9 = new C0998Vn();
                break;
            case 5:
                c0424j9 = new C0075Bj();
                break;
            case 6:
                c0424j9 = new C1108Y4();
                break;
            case 7:
                c0424j9 = new C1201a5();
                break;
            case 8:
                c0424j9 = new C1016W4();
                break;
            case 9:
                c0424j9 = new C0759Qd();
                break;
            case 10:
                c0424j9 = new C2479vi();
                break;
            case 11:
                c0424j9 = new C0924U4();
                break;
            case 12:
                c0424j9 = new C2136o7();
                break;
            case 13:
                c0424j9 = new C1299b2();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(barcodeFormat)));
        }
        return c0424j9.mo319a(str, barcodeFormat, i, i2, map);
    }

    public C0325H2 m7419b(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return mo319a(str, barcodeFormat, i, i2, null);
    }
}
