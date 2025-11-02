package p000;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class AbstractC0602N3 {

    public static final class a {

        public Object f1896a;

        public d f1897b;

        public C0352Hk f1898c = C0352Hk.m1593w();

        public boolean f1899d;

        public void m3281a() {
            this.f1896a = null;
            this.f1897b = null;
            this.f1898c.mo1594s(null);
        }

        public boolean m3282b(Object obj) {
            this.f1899d = true;
            d dVar = this.f1897b;
            boolean z = dVar != null && dVar.m3287b(obj);
            if (z) {
                m3284d();
            }
            return z;
        }

        public boolean m3283c() {
            this.f1899d = true;
            d dVar = this.f1897b;
            boolean z = dVar != null && dVar.m3286a(true);
            if (z) {
                m3284d();
            }
            return z;
        }

        public final void m3284d() {
            this.f1896a = null;
            this.f1897b = null;
            this.f1898c = null;
        }

        public boolean m3285e(Throwable th) {
            this.f1899d = true;
            d dVar = this.f1897b;
            boolean z = dVar != null && dVar.m3288d(th);
            if (z) {
                m3284d();
            }
            return z;
        }

        public void finalize() {
            C0352Hk c0352Hk;
            d dVar = this.f1897b;
            if (dVar != null && !dVar.isDone()) {
                dVar.m3288d(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f1896a));
            }
            if (this.f1899d || (c0352Hk = this.f1898c) == null) {
                return;
            }
            c0352Hk.mo1594s(null);
        }
    }

    public static final class b extends Throwable {
        public b(String str) {
            super(str);
        }

        @Override
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public interface c {
        Object mo404a(a aVar);
    }

    public static final class d implements InterfaceFutureC0852Sf {

        public final WeakReference f1900l;

        public final AbstractC0460K f1901m = new a();

        public class a extends AbstractC0460K {
            public a() {
            }

            @Override
            public String mo2226p() {
                a aVar = (a) d.this.f1900l.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f1896a + "]";
            }
        }

        public d(a aVar) {
            this.f1900l = new WeakReference(aVar);
        }

        public boolean m3286a(boolean z) {
            return this.f1901m.cancel(z);
        }

        public boolean m3287b(Object obj) {
            return this.f1901m.mo1594s(obj);
        }

        @Override
        public void mo2221c(Runnable runnable, Executor executor) {
            this.f1901m.mo2221c(runnable, executor);
        }

        @Override
        public boolean cancel(boolean z) {
            a aVar = (a) this.f1900l.get();
            boolean zCancel = this.f1901m.cancel(z);
            if (zCancel && aVar != null) {
                aVar.m3281a();
            }
            return zCancel;
        }

        public boolean m3288d(Throwable th) {
            return this.f1901m.mo1595t(th);
        }

        @Override
        public Object get() {
            return this.f1901m.get();
        }

        @Override
        public boolean isCancelled() {
            return this.f1901m.isCancelled();
        }

        @Override
        public boolean isDone() {
            return this.f1901m.isDone();
        }

        public String toString() {
            return this.f1901m.toString();
        }

        @Override
        public Object get(long j, TimeUnit timeUnit) {
            return this.f1901m.get(j, timeUnit);
        }
    }

    public static InterfaceFutureC0852Sf m3280a(c cVar) {
        a aVar = new a();
        d dVar = new d(aVar);
        aVar.f1897b = dVar;
        aVar.f1896a = cVar.getClass();
        try {
            Object objMo404a = cVar.mo404a(aVar);
            if (objMo404a != null) {
                aVar.f1896a = objMo404a;
            }
        } catch (Exception e) {
            dVar.m3288d(e);
        }
        return dVar;
    }
}
