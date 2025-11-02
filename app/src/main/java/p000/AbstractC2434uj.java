package p000;

import androidx.annotation.NonNull;

import java.io.UnsupportedEncodingException;

public abstract class AbstractC2434uj extends Thread {

    public interface a extends C1926ji.a, C2060me.a {
        void mo10181g(Exception exc);
    }

    public class b {

        public String f7559a = null;

        public int port = 80;

        @NonNull
        public String toString() {
            return this.f7559a + ":" + this.port;
        }
    }

    public static final String m10175a(byte[] bArr, int i, int i2) {
        StringBuilder stringBuffer = new StringBuilder(bArr.length);
        while (i < i2) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
            stringBuffer.append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    public static final void m10176b(String str, byte[] bArr, boolean z) {
        String str2 = !z ? "<- " : "-> ";
        int length = bArr.length;
        if (length >= 64) {
            length = 64;
        }
        log(str2 + str + ": " + m10175a(bArr, 0, length));
    }

    public static String m10177c(byte[] bArr, int i, int i2) {
        StringBuilder stringBuffer = new StringBuilder();
        while (i <= i2) {
            stringBuffer.append(bArr[i] & 255);
            stringBuffer.append(".");
            i++;
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public static int m10178d(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i <= i2) {
            i3 = (i3 << 8) | (bArr[i] & 255);
            i++;
        }
        return i3;
    }

    public static final void log(String msg) {
        System.out.println(msg);
    }

    public abstract void mo4779e();

    public b m10180g(byte[] bArr) {
        b bVar = new b();
        int addressType = bArr[3];
        if (addressType == 1) {
            bVar.f7559a = m10177c(bArr, 4, 7);
            bVar.port = m10178d(bArr, 8, 9);
        } else if (addressType == 3) {
            int i2 = bArr[4];
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 5, bArr2, 0, i2);
            try {
                bVar.f7559a = new String(bArr2, "ISO8859-1");
                bVar.port = m10178d(bArr, i2 + 5, i2 + 6);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not support address type:" + addressType);
            return null;
        }
        return bVar;
    }

    @Override
    public void run() {
        try {
            mo4779e();
        } catch (Exception unused) {
        }
    }
}
