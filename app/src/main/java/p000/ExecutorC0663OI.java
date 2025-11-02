package p000;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ExecutorC0663OI implements Executor {

    public final Handler f2023l = new HandlerC1046Wp(Looper.getMainLooper());

    @Override
    public final void execute(Runnable runnable) {
        this.f2023l.post(runnable);
    }
}
