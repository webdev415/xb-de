package p000;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public enum EnumC1698eo implements Executor {
    INSTANCE;


    public static final Handler f5463m = new Handler(Looper.getMainLooper());

    @Override
    public void execute(Runnable runnable) {
        f5463m.post(runnable);
    }
}
