package p000;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class HandlerC2680zz extends Handler {

    public final Looper f8288a;

    public HandlerC2680zz(Looper looper) {
        super(looper);
        this.f8288a = Looper.getMainLooper();
    }

    public HandlerC2680zz(Looper looper, Callback callback) {
        super(looper, callback);
        this.f8288a = Looper.getMainLooper();
    }
}
