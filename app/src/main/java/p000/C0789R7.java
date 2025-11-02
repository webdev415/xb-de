package p000;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

public class C0789R7 {

    public static final String f2328k = "R7";

    public C0831S3 f2329a;

    public HandlerThread f2330b;

    public Handler f2331c;

    public C0606N7 f2332d;

    public Handler f2333e;

    public Rect f2334f;

    public boolean f2335g = false;

    public final Object f2336h = new Object();

    public final Handler.Callback f2337i = new a();

    public final InterfaceC1372cj f2338j = new b();

    public class a implements Handler.Callback {
        public a() {
        }

        @Override
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == AbstractC0351Hj.f1068e) {
                C0789R7.this.m3757g((C2207pm) message.obj);
                return true;
            }
            if (i != AbstractC0351Hj.f1072i) {
                return true;
            }
            C0789R7.this.m3758h();
            return true;
        }
    }

    public class b implements InterfaceC1372cj {
        public b() {
        }

        @Override
        public void mo3763a(Exception exc) {
            synchronized (C0789R7.this.f2336h) {
                try {
                    if (C0789R7.this.f2335g) {
                        C0789R7.this.f2331c.obtainMessage(AbstractC0351Hj.f1072i).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override
        public void mo3764b(C2207pm c2207pm) {
            synchronized (C0789R7.this.f2336h) {
                try {
                    if (C0789R7.this.f2335g) {
                        C0789R7.this.f2331c.obtainMessage(AbstractC0351Hj.f1068e, c2207pm).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public C0789R7(C0831S3 c0831s3, C0606N7 c0606n7, Handler handler) {
        AbstractC2669zo.m11047a();
        this.f2329a = c0831s3;
        this.f2332d = c0606n7;
        this.f2333e = handler;
    }

    public AbstractC1784gg m3756f(C2207pm c2207pm) {
        if (this.f2334f == null) {
            return null;
        }
        return c2207pm.m9074a();
    }

    public final void m3757g(C2207pm c2207pm) {
        Message messageObtain;
        long jCurrentTimeMillis = System.currentTimeMillis();
        c2207pm.m9077d(this.f2334f);
        AbstractC1784gg abstractC1784ggM3756f = m3756f(c2207pm);
        C0720Pk c0720PkM3295c = abstractC1784ggM3756f != null ? this.f2332d.m3295c(abstractC1784ggM3756f) : null;
        if (c0720PkM3295c != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Log.d(f2328k, "Found barcode in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
            if (this.f2333e != null) {
                messageObtain = Message.obtain(this.f2333e, AbstractC0351Hj.f1070g, new C2178p2(c0720PkM3295c, c2207pm));
                messageObtain.setData(new Bundle());
                messageObtain.sendToTarget();
            }
        } else {
            Handler handler = this.f2333e;
            if (handler != null) {
                messageObtain = Message.obtain(handler, AbstractC0351Hj.f1069f);
                messageObtain.sendToTarget();
            }
        }
        if (this.f2333e != null) {
            Message.obtain(this.f2333e, AbstractC0351Hj.f1071h, C2178p2.m9000e(this.f2332d.m3296d(), c2207pm)).sendToTarget();
        }
        m3758h();
    }

    public final void m3758h() {
        this.f2329a.m4007v(this.f2338j);
    }

    public void m3759i(Rect rect) {
        this.f2334f = rect;
    }

    public void m3760j(C0606N7 c0606n7) {
        this.f2332d = c0606n7;
    }

    public void m3761k() {
        AbstractC2669zo.m11047a();
        HandlerThread handlerThread = new HandlerThread(f2328k);
        this.f2330b = handlerThread;
        handlerThread.start();
        this.f2331c = new Handler(this.f2330b.getLooper(), this.f2337i);
        this.f2335g = true;
        m3758h();
    }

    public void m3762l() {
        AbstractC2669zo.m11047a();
        synchronized (this.f2336h) {
            this.f2335g = false;
            this.f2331c.removeCallbacksAndMessages(null);
            this.f2330b.quit();
        }
    }
}
