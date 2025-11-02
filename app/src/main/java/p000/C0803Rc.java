package p000;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

public final class C0803Rc extends AbstractC0849Sc implements InterfaceC2091n8 {
    private volatile C0803Rc _immediate;

    public final Handler f2390n;

    public final String f2391o;

    public final boolean f2392p;

    public final C0803Rc f2393q;

    public C0803Rc(Handler handler, String str) {
        this(handler, str, false);
    }

    @Override
    public void mo1351T(InterfaceC0191E6 interfaceC0191E6, Runnable runnable) {
        if (this.f2390n.post(runnable)) {
            return;
        }
        m3818Y(interfaceC0191E6, runnable);
    }

    @Override
    public boolean mo1352U(InterfaceC0191E6 interfaceC0191E6) {
        return (this.f2392p && AbstractC0116Ce.m472a(Looper.myLooper(), this.f2390n.getLooper())) ? false : true;
    }

    public final void m3818Y(InterfaceC0191E6 interfaceC0191E6, Runnable runnable) {
        AbstractC1736ff.m7584c(interfaceC0191E6, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C1158Z8.m5024b().mo1351T(interfaceC0191E6, runnable);
    }

    @Override
    public C0803Rc mo3817W() {
        return this.f2393q;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0803Rc) && ((C0803Rc) obj).f2390n == this.f2390n;
    }

    public int hashCode() {
        return System.identityHashCode(this.f2390n);
    }

    @Override
    public String toString() {
        String strM7964X = m7964X();
        if (strM7964X != null) {
            return strM7964X;
        }
        String string = this.f2391o;
        if (string == null) {
            string = this.f2390n.toString();
        }
        if (!this.f2392p) {
            return string;
        }
        return string + ".immediate";
    }

    public C0803Rc(Handler handler, String str, int i, AbstractC0881T7 abstractC0881T7) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public C0803Rc(Handler handler, String str, boolean z) {
        super(null);
        this.f2390n = handler;
        this.f2391o = str;
        this.f2392p = z;
        this._immediate = z ? this : null;
        C0803Rc c0803Rc = this._immediate;
        if (c0803Rc == null) {
            c0803Rc = new C0803Rc(handler, str, true);
            this._immediate = c0803Rc;
        }
        this.f2393q = c0803Rc;
    }
}
