package p000;

import java.util.concurrent.Executor;

public class C2223q1 extends AbstractC2023ln {

    public static volatile C2223q1 f6669c;

    public static final Executor f6670d = new Executor() {
        @Override
        public final void execute(Runnable runnable) {
            C2223q1.m9094g(runnable);
        }
    };

    public static final Executor f6671e = new Executor() {
        @Override
        public final void execute(Runnable runnable) {
            C2223q1.m9095h(runnable);
        }
    };

    public AbstractC2023ln f6672a;

    public final AbstractC2023ln f6673b;

    public C2223q1() {
        C1766g8 c1766g8 = new C1766g8();
        this.f6673b = c1766g8;
        this.f6672a = c1766g8;
    }

    public static C2223q1 m9093f() {
        if (f6669c != null) {
            return f6669c;
        }
        synchronized (C2223q1.class) {
            try {
                if (f6669c == null) {
                    f6669c = new C2223q1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6669c;
    }

    public static void m9094g(Runnable runnable) {
        m9093f().mo7699c(runnable);
    }

    public static void m9095h(Runnable runnable) {
        m9093f().mo7697a(runnable);
    }

    @Override
    public void mo7697a(Runnable runnable) {
        this.f6672a.mo7697a(runnable);
    }

    @Override
    public boolean mo7698b() {
        return this.f6672a.mo7698b();
    }

    @Override
    public void mo7699c(Runnable runnable) {
        this.f6672a.mo7699c(runnable);
    }
}
