package p000;

import android.p001os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.AbstractC0674Ok;

public final class C2642z6 extends AtomicBoolean implements OutcomeReceiver {

    public final InterfaceC2458v6 f8174l;

    public C2642z6(InterfaceC2458v6 interfaceC2458v6) {
        super(false);
        this.f8174l = interfaceC2458v6;
    }

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            InterfaceC2458v6 interfaceC2458v6 = this.f8174l;
            AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
            interfaceC2458v6.mo198h(AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(th)));
        }
    }

    public void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.f8174l.mo198h(AbstractC0674Ok.m3431a(obj));
        }
    }

    @Override
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
