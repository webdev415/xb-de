package p000;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public abstract class AbstractC1113Y9 {
    public static int m4885a(int i) {
        return ((i + 7) & (-8)) / 8;
    }

    public static byte[] m4886b(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static RuntimeException m4887c(String str) {
        return new IllegalStateException(str);
    }

    public static byte[] m4888d(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 < 0) {
                throw m4887c("Not enough bytes to read: " + i);
            }
            i2 += i3;
        }
        return bArr;
    }

    public static byte[] m4889e(InputStream inputStream, int i, int i2) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[2048];
            int i3 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i3 < i) {
                int i4 = inputStream.read(bArr2);
                if (i4 < 0) {
                    throw m4887c("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i + " bytes");
                }
                inflater.setInput(bArr2, 0, i4);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i2 - iInflate);
                    i3 += i4;
                } catch (DataFormatException e) {
                    throw m4887c(e.getMessage());
                }
            }
            if (i3 == i) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw m4887c("Inflater did not finish");
            }
            throw m4887c("Didn't read enough bytes during decompression. expected=" + i + " actual=" + i3);
        } finally {
            inflater.end();
        }
    }

    public static String m4890f(InputStream inputStream, int i) {
        return new String(m4888d(inputStream, i), StandardCharsets.UTF_8);
    }

    public static long m4891g(InputStream inputStream, int i) throws IOException {
        byte[] bArrM4888d = m4888d(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (bArrM4888d[i2] & 255) << (i2 * 8);
        }
        return j;
    }

    public static int m4892h(InputStream inputStream) {
        return (int) m4891g(inputStream, 2);
    }

    public static long m4893i(InputStream inputStream) {
        return m4891g(inputStream, 4);
    }

    public static int m4894j(InputStream inputStream) {
        return (int) m4891g(inputStream, 1);
    }

    public static int m4895k(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    public static void m4896l(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static void m4897m(OutputStream outputStream, byte[] bArr) throws IOException {
        m4901q(outputStream, bArr.length);
        byte[] bArrM4886b = m4886b(bArr);
        m4901q(outputStream, bArrM4886b.length);
        outputStream.write(bArrM4886b);
    }

    public static void m4898n(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void m4899o(OutputStream outputStream, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        outputStream.write(bArr);
    }

    public static void m4900p(OutputStream outputStream, int i) throws IOException {
        m4899o(outputStream, i, 2);
    }

    public static void m4901q(OutputStream outputStream, long j) throws IOException {
        m4899o(outputStream, j, 4);
    }

    public static void m4902r(OutputStream outputStream, int i) throws IOException {
        m4899o(outputStream, i, 1);
    }
}
