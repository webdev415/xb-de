package p000;

import java.util.concurrent.Callable;

public final class C0892TI extends C1316bJ {

    public final Callable f2745f;

    public C0892TI(Callable callable, AbstractC0709PI abstractC0709PI) {
        super();
        this.f2745f = callable;
    }

    @Override
    public final String mo4132a() {
        try {
            return (String) this.f2745f.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
