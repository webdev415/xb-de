package p000;

import java.util.concurrent.Executor;

public final class ExecutorC2555xB implements Executor {

    public final C1207aB f7945l;

    public ExecutorC2555xB(C1207aB c1207aB) {
        this.f7945l = c1207aB;
    }

    @Override
    public final void execute(Runnable runnable) {
        this.f7945l.mo354l().m7374C(runnable);
    }
}
