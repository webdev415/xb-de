package p000;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class C0646O1 {

    public static final String f1990i = "O1";

    public static final Collection f1991j;

    public boolean f1992a;

    public boolean f1993b;

    public final boolean f1994c;

    public final Camera f1995d;

    public Handler f1996e;

    public int f1997f = 1;

    public final Handler.Callback f1998g;

    public final Camera.AutoFocusCallback f1999h;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override
        public boolean handleMessage(Message message) {
            if (message.what != C0646O1.this.f1997f) {
                return false;
            }
            C0646O1.this.m3362h();
            return true;
        }
    }

    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        public final void m3366b() {
            C0646O1.this.f1993b = false;
            C0646O1.this.m3360f();
        }

        @Override
        public void onAutoFocus(boolean z, Camera camera) {
            C0646O1.this.f1996e.post(new Runnable() {
                @Override
                public final void run() {
                    this.f2072l.m3366b();
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList<>(2);
        f1991j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public C0646O1(Camera camera, C0969V3 c0969v3) {
        a aVar = new a();
        this.f1998g = aVar;
        this.f1999h = new b();
        this.f1996e = new Handler(aVar);
        this.f1995d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = c0969v3.m4322c() && f1991j.contains(focusMode);
        this.f1994c = z;
        Log.i(f1990i, "Current focus mode '" + focusMode + "'; use auto focus? " + z);
        m3363i();
    }

    public final synchronized void m3360f() {
        if (!this.f1992a && !this.f1996e.hasMessages(this.f1997f)) {
            Handler handler = this.f1996e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f1997f), 2000L);
        }
    }

    public final void m3361g() {
        this.f1996e.removeMessages(this.f1997f);
    }

    public final void m3362h() {
        if (!this.f1994c || this.f1992a || this.f1993b) {
            return;
        }
        try {
            this.f1995d.autoFocus(this.f1999h);
            this.f1993b = true;
        } catch (RuntimeException e) {
            Log.w(f1990i, "Unexpected exception while focusing", e);
            m3360f();
        }
    }

    public void m3363i() {
        this.f1992a = false;
        m3362h();
    }

    public void m3364j() {
        this.f1992a = true;
        this.f1993b = false;
        m3361g();
        if (this.f1994c) {
            try {
                this.f1995d.cancelAutoFocus();
            } catch (RuntimeException e) {
                Log.w(f1990i, "Unexpected exception while cancelling focusing", e);
            }
        }
    }
}
