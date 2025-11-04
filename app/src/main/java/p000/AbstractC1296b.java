package p000;

public abstract class AbstractC1296b {
    public static final byte[] m5573a(String str) {
        AbstractC0116Ce.m476e(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(C2502w4.f7789b);
        AbstractC0116Ce.m475d(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String m5574b(byte[] bArr) {
        AbstractC0116Ce.m476e(bArr, "$this$toUtf8String");
        return new String(bArr, C2502w4.f7789b);
    }
}
