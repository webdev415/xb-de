package p000;

import java.util.concurrent.Callable;

public final class CallableC2232qA implements Callable {

    public final C0635Nr f6685a;

    public final String f6686b;

    public final BinderC0183Dz f6687c;

    public CallableC2232qA(BinderC0183Dz binderC0183Dz, C0635Nr c0635Nr, String str) {
        this.f6685a = c0635Nr;
        this.f6686b = str;
        this.f6687c = binderC0183Dz;
    }

    @Override
    public final Object call() {
        this.f6687c.f441c.m968z0();
        return this.f6687c.f441c.m959u0().m4366y(this.f6685a, this.f6686b);
    }
}
