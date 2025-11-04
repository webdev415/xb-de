package p000;

import android.database.ContentObserver;
import android.os.Handler;

public final class C0551Lz extends ContentObserver {

    public final C0413Iz f1747a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0551Lz(C0413Iz c0413Iz, Handler handler) {
        super(null);
        this.f1747a = c0413Iz;
    }

    @Override
    public final void onChange(boolean z) {
        this.f1747a.m1761e();
    }
}
