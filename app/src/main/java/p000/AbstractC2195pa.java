package p000;

import java.util.concurrent.CancellationException;

public abstract class AbstractC2195pa {
    public static final CancellationException m9058a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
