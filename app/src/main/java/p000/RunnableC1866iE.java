package p000;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class RunnableC1866iE implements Runnable {

    public final AtomicReference f5793l;

    public final String f5794m;

    public final String f5795n;

    public final String f5796o;

    public final C0569MG f5797p;

    public final C2142oD f5798q;

    public RunnableC1866iE(C2142oD c2142oD, AtomicReference atomicReference, String str, String str2, String str3, C0569MG c0569mg) {
        this.f5793l = atomicReference;
        this.f5794m = str;
        this.f5795n = str2;
        this.f5796o = str3;
        this.f5797p = c0569mg;
        this.f5798q = c2142oD;
    }

    @Override
    public final void run() {
        AtomicReference atomicReference;
        InterfaceC1707ex interfaceC1707ex;
        AtomicReference atomicReference2;
        List listMo799A;
        synchronized (this.f5793l) {
            try {
                try {
                    interfaceC1707ex = this.f5798q.f6550d;
                } catch (RemoteException e) {
                    this.f5798q.mo349g().m9618G().m10619d("(legacy) Failed to get conditional properties; remote exception", C2356sx.m9613v(this.f5794m), this.f5795n, e);
                    this.f5793l.set(Collections.emptyList());
                    atomicReference = this.f5793l;
                }
                if (interfaceC1707ex == null) {
                    this.f5798q.mo349g().m9618G().m10619d("(legacy) Failed to get conditional properties; not connected to service", C2356sx.m9613v(this.f5794m), this.f5795n, this.f5796o);
                    this.f5793l.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f5794m)) {
                    AbstractC1085Xi.m4801j(this.f5797p);
                    atomicReference2 = this.f5793l;
                    listMo799A = interfaceC1707ex.mo822k(this.f5795n, this.f5796o, this.f5797p);
                } else {
                    atomicReference2 = this.f5793l;
                    listMo799A = interfaceC1707ex.mo799A(this.f5794m, this.f5795n, this.f5796o);
                }
                atomicReference2.set(listMo799A);
                this.f5798q.m8849m0();
                atomicReference = this.f5793l;
                atomicReference.notify();
            } finally {
                this.f5793l.notify();
            }
        }
    }
}
