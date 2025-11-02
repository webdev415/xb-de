package p000;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class C1695el extends RuntimeException {

    public IOException f5454l;

    public final IOException f5455m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1695el(IOException iOException) {
        super(iOException);
        AbstractC0116Ce.m476e(iOException, "firstConnectException");
        this.f5455m = iOException;
        this.f5454l = iOException;
    }

    public final void m7460a(IOException iOException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC0116Ce.m476e(iOException, "e");
        AbstractC2241qa.m9151a(this.f5455m, iOException);
        this.f5454l = iOException;
    }

    public final IOException m7461b() {
        return this.f5455m;
    }

    public final IOException m7462c() {
        return this.f5454l;
    }
}
