package p000;

import android.database.ContentObserver;
import android.os.Handler;

public final class C2035lz extends ContentObserver {

    public final C1896iz f6113a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2035lz(C1896iz c1896iz, Handler handler) {
        super(null);
        this.f6113a = c1896iz;
    }

    @Override
    public final void onChange(boolean z) {
        this.f6113a.f5833a.set(true);
    }
}
