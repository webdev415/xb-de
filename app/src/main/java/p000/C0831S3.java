package p000;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes.dex */
public class C0831S3 {

    public static final String f2582n = "S3";

    public C1061X3 f2583a;

    public C1015W3 f2584b;

    public C0877T3 f2585c;

    public Handler f2586d;

    public C1205a9 f2587e;

    public Handler f2590h;

    public boolean f2588f = false;

    public boolean f2589g = true;

    public C0969V3 f2591i = new C0969V3();

    public Runnable f2592j = new a();

    public Runnable f2593k = new b();

    public Runnable f2594l = new c();

    public Runnable f2595m = new d();

    public class a implements Runnable {
        public a() {
        }

        @Override
        public void run() {
            try {
                Log.d(C0831S3.f2582n, "Opening camera");
                C0831S3.this.f2585c.m4098l();
            } catch (Exception e) {
                C0831S3.this.m4005t(e);
                Log.e(C0831S3.f2582n, "Failed to open camera", e);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override
        public void run() {
            try {
                Log.d(C0831S3.f2582n, "Configuring camera");
                C0831S3.this.f2585c.m4092e();
                if (C0831S3.this.f2586d != null) {
                    C0831S3.this.f2586d.obtainMessage(AbstractC0351Hj.f1073j, C0831S3.this.m4000o()).sendToTarget();
                }
            } catch (Exception e) {
                C0831S3.this.m4005t(e);
                Log.e(C0831S3.f2582n, "Failed to configure camera", e);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override
        public void run() {
            try {
                Log.d(C0831S3.f2582n, "Starting preview");
                C0831S3.this.f2585c.m4105s(C0831S3.this.f2584b);
                C0831S3.this.f2585c.m4107u();
            } catch (Exception e) {
                C0831S3.this.m4005t(e);
                Log.e(C0831S3.f2582n, "Failed to start preview", e);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override
        public void run() {
            try {
                Log.d(C0831S3.f2582n, "Closing camera");
                C0831S3.this.f2585c.m4108v();
                C0831S3.this.f2585c.m4091d();
            } catch (Exception e) {
                Log.e(C0831S3.f2582n, "Failed to close camera", e);
            }
            C0831S3.this.f2589g = true;
            C0831S3.this.f2586d.sendEmptyMessage(AbstractC0351Hj.f1066c);
            C0831S3.this.f2583a.m4621b();
        }
    }

    public C0831S3(Context context) {
        AbstractC2669zo.m11047a();
        this.f2583a = C1061X3.m4619d();
        C0877T3 c0877t3 = new C0877T3(context);
        this.f2585c = c0877t3;
        c0877t3.m4101o(this.f2591i);
        this.f2590h = new Handler();
    }

    public void m3994A(final boolean z) {
        AbstractC2669zo.m11047a();
        if (this.f2588f) {
            this.f2583a.m4622c(new Runnable() {
                @Override
                public final void run() {
                    this.f2195l.m4004s(z);
                }
            });
        }
    }

    public void m3995B() {
        AbstractC2669zo.m11047a();
        m3996C();
        this.f2583a.m4622c(this.f2594l);
    }

    public final void m3996C() {
        if (!this.f2588f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    public void m3997l() {
        AbstractC2669zo.m11047a();
        if (this.f2588f) {
            this.f2583a.m4622c(this.f2595m);
        } else {
            this.f2589g = true;
        }
        this.f2588f = false;
    }

    public void m3998m() {
        AbstractC2669zo.m11047a();
        m3996C();
        this.f2583a.m4622c(this.f2593k);
    }

    public C1205a9 m3999n() {
        return this.f2587e;
    }

    public final C1180Zl m4000o() {
        return this.f2585c.m4095h();
    }

    public boolean m4001p() {
        return this.f2589g;
    }

    public final void m4002q(InterfaceC1372cj interfaceC1372cj) {
        this.f2585c.m4099m(interfaceC1372cj);
    }

    public final void m4003r(final InterfaceC1372cj interfaceC1372cj) {
        if (this.f2588f) {
            this.f2583a.m4622c(new Runnable() {
                @Override
                public final void run() {
                    this.f2319l.m4002q(interfaceC1372cj);
                }
            });
        } else {
            Log.d(f2582n, "Camera is closed, not requesting preview");
        }
    }

    public final void m4004s(boolean z) {
        this.f2585c.m4106t(z);
    }

    public final void m4005t(Exception exc) {
        Handler handler = this.f2586d;
        if (handler != null) {
            handler.obtainMessage(AbstractC0351Hj.f1067d, exc).sendToTarget();
        }
    }

    public void m4006u() {
        AbstractC2669zo.m11047a();
        this.f2588f = true;
        this.f2589g = false;
        this.f2583a.m4623e(this.f2592j);
    }

    public void m4007v(final InterfaceC1372cj interfaceC1372cj) {
        this.f2590h.post(new Runnable() {
            @Override
            public final void run() {
                this.f2074l.m4003r(interfaceC1372cj);
            }
        });
    }

    public void m4008w(C0969V3 c0969v3) {
        if (this.f2588f) {
            return;
        }
        this.f2591i = c0969v3;
        this.f2585c.m4101o(c0969v3);
    }

    public void m4009x(C1205a9 c1205a9) {
        this.f2587e = c1205a9;
        this.f2585c.m4103q(c1205a9);
    }

    public void m4010y(Handler handler) {
        this.f2586d = handler;
    }

    public void m4011z(C1015W3 c1015w3) {
        this.f2584b = c1015w3;
    }
}
