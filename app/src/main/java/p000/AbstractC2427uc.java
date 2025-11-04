package p000;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract class AbstractC2427uc extends AbstractC0620Nc {

    public static final class a implements Runnable {

        public final Future f7401l;

        public final InterfaceC2381tc f7402m;

        public a(Future future, InterfaceC2381tc interfaceC2381tc) {
            this.f7401l = future;
            this.f7402m = interfaceC2381tc;
        }

        @Override
        public void run() {
            try {
                this.f7402m.mo630a(AbstractC2427uc.m10009b(this.f7401l));
            } catch (Error e) {
                e = e;
                this.f7402m.mo631b(e);
            } catch (RuntimeException e2) {
                e = e2;
                this.f7402m.mo631b(e);
            } catch (ExecutionException e3) {
                this.f7402m.mo631b(e3.getCause());
            }
        }

        public String toString() {
            return AbstractC1175Zg.m5041a(this).m5045c(this.f7402m).toString();
        }
    }

    public static void m10008a(InterfaceFutureC0852Sf interfaceFutureC0852Sf, InterfaceC2381tc interfaceC2381tc, Executor executor) {
        AbstractC1131Yi.m4973i(interfaceC2381tc);
        interfaceFutureC0852Sf.mo2221c(new a(interfaceFutureC0852Sf, interfaceC2381tc), executor);
    }

    public static Object m10009b(Future future) {
        AbstractC1131Yi.m4980p(future.isDone(), "Future was expected to be done: %s", future);
        return AbstractC2070mo.m8640a(future);
    }
}
