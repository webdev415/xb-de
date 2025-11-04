package p000;

import java.util.concurrent.Callable;

public final class CallableC0935UF implements Callable {

    public final C0569MG f2845a;

    public final C0200EF f2846b;

    public CallableC0935UF(C0200EF c0200ef, C0569MG c0569mg) {
        this.f2845a = c0569mg;
        this.f2846b = c0200ef;
    }

    @Override
    public final Object call() {
        C2540wx c2540wxM9622K;
        String str;
        if (this.f2846b.m923V((String) AbstractC1085Xi.m4801j(this.f2845a.f1787l)).m1852B() && C0425JA.m1850q(this.f2845a.f1776G).m1852B()) {
            C2403ty c2403tyM944k = this.f2846b.m944k(this.f2845a);
            if (c2403tyM944k != null) {
                return c2403tyM944k.m9850m();
            }
            c2540wxM9622K = this.f2846b.mo349g().m9623L();
            str = "App info was null when attempting to get app instance id";
        } else {
            c2540wxM9622K = this.f2846b.mo349g().m9622K();
            str = "Analytics storage consent denied. Returning null app instance id";
        }
        c2540wxM9622K.m10616a(str);
        return null;
    }
}
