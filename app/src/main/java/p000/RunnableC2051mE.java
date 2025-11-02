package p000;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class RunnableC2051mE implements Runnable {

    public final AtomicReference f6150l;

    public final String f6151m;

    public final String f6152n;

    public final String f6153o;

    public final C0569MG f6154p;

    public final boolean f6155q;

    public final C2142oD f6156r;

    public RunnableC2051mE(C2142oD c2142oD, AtomicReference atomicReference, String str, String str2, String str3, C0569MG c0569mg, boolean z) {
        this.f6150l = atomicReference;
        this.f6151m = str;
        this.f6152n = str2;
        this.f6153o = str3;
        this.f6154p = c0569mg;
        this.f6155q = z;
        this.f6156r = c2142oD;
    }

    @Override
    public final void run() {
        AtomicReference atomicReference;
        InterfaceC1707ex interfaceC1707ex;
        AtomicReference atomicReference2;
        List listMo833z;
        synchronized (this.f6150l) {
            try {
                try {
                    interfaceC1707ex = this.f6156r.f6550d;
                } catch (RemoteException e) {
                    this.f6156r.mo349g().m9618G().m10619d("(legacy) Failed to get user properties; remote exception", C2356sx.m9613v(this.f6151m), this.f6152n, e);
                    this.f6150l.set(Collections.emptyList());
                    atomicReference = this.f6150l;
                }
                if (interfaceC1707ex == null) {
                    this.f6156r.mo349g().m9618G().m10619d("(legacy) Failed to get user properties; not connected to service", C2356sx.m9613v(this.f6151m), this.f6152n, this.f6153o);
                    this.f6150l.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f6151m)) {
                    AbstractC1085Xi.m4801j(this.f6154p);
                    atomicReference2 = this.f6150l;
                    listMo833z = interfaceC1707ex.mo831x(this.f6152n, this.f6153o, this.f6155q, this.f6154p);
                } else {
                    atomicReference2 = this.f6150l;
                    listMo833z = interfaceC1707ex.mo833z(this.f6151m, this.f6152n, this.f6153o, this.f6155q);
                }
                atomicReference2.set(listMo833z);
                this.f6156r.m8849m0();
                atomicReference = this.f6150l;
                atomicReference.notify();
            } finally {
                this.f6150l.notify();
            }
        }
    }
}
