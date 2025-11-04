package p000;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractC0649O4 {
    public static final void m3381a(Closeable closeable, Throwable th) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC2241qa.m9151a(th, th2);
            }
        }
    }
}
