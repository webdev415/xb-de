package p000;

import java.io.Closeable;
import java.io.IOException;

public abstract class AbstractC0621Nd {
    public static void m3317a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
