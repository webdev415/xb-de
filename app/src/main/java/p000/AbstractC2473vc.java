package p000;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public abstract class AbstractC2473vc {
    public static void m10347a(InputStream inputStream, OutputStream outputStream) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i == -1) {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                return;
            }
            gZIPOutputStream.write(bArr, 0, i);
        }
    }

    public static byte[] m10348b(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m10347a(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }
}
