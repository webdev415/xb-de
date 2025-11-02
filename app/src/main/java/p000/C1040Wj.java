package p000;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* loaded from: classes.dex */
public class C1040Wj {

    public static final byte f3101a = Byte.parseByte("01110000", 2);

    public static final byte f3102b = Byte.parseByte("00001111", 2);

    public static String m4533b(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    public static byte[] m4534c(UUID uuid, byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        return byteBufferWrap.array();
    }

    public String m4535a() {
        byte[] bArrM4534c = m4534c(UUID.randomUUID(), new byte[17]);
        byte b = bArrM4534c[0];
        bArrM4534c[16] = b;
        bArrM4534c[0] = (byte) ((b & f3102b) | f3101a);
        return m4533b(bArrM4534c);
    }
}
