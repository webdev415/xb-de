package p000;

import java.lang.ref.WeakReference;

public abstract class AbstractBinderC0473KC extends AbstractBinderC0195EA {

    public static final WeakReference f1552e = new WeakReference(null);

    public WeakReference f1553d;

    public AbstractBinderC0473KC(byte[] bArr) {
        super(bArr);
        this.f1553d = f1552e;
    }

    @Override
    public final byte[] mo884R() {
        byte[] bArrMo587S;
        synchronized (this) {
            try {
                bArrMo587S = (byte[]) this.f1553d.get();
                if (bArrMo587S == null) {
                    bArrMo587S = mo587S();
                    this.f1553d = new WeakReference(bArrMo587S);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrMo587S;
    }

    public abstract byte[] mo587S();
}
