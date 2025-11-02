package p000;

import java.util.concurrent.Executor;

public final class ExecutorC1626d8 extends AbstractC2425ua implements Executor {

    public static final ExecutorC1626d8 f5272o = new ExecutorC1626d8();

    public static final AbstractC0283G6 f5273p = C2163oo.f6589n.mo1353V(AbstractC1376cn.m5944e("kotlinx.coroutines.io.parallelism", AbstractC1132Yj.m4981b(64, AbstractC1229an.m5302a()), 0, 0, 12, null));

    @Override
    public void mo1351T(InterfaceC0191E6 interfaceC0191E6, Runnable runnable) {
        f5273p.mo1351T(interfaceC0191E6, runnable);
    }

    @Override
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override
    public void execute(Runnable runnable) {
        mo1351T(C0608N9.f1911l, runnable);
    }

    @Override
    public String toString() {
        return "Dispatchers.IO";
    }
}
