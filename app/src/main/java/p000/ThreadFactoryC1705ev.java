package p000;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class ThreadFactoryC1705ev implements ThreadFactory {

    public ThreadFactory f5472a = Executors.defaultThreadFactory();

    public ThreadFactoryC1705ev(C0224Eu c0224Eu) {
    }

    @Override
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f5472a.newThread(runnable);
        threadNewThread.setName("ScionFrontendApi");
        return threadNewThread;
    }
}
