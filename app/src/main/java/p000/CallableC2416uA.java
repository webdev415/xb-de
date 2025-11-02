package p000;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class CallableC2416uA implements Callable {

    public final C0569MG f7375a;

    public final Bundle f7376b;

    public final BinderC0183Dz f7377c;

    public CallableC2416uA(BinderC0183Dz binderC0183Dz, C0569MG c0569mg, Bundle bundle) {
        this.f7375a = c0569mg;
        this.f7376b = bundle;
        this.f7377c = binderC0183Dz;
    }

    @Override
    public final Object call() {
        this.f7377c.f441c.m968z0();
        C0200EF c0200ef = this.f7377c.f441c;
        C0569MG c0569mg = this.f7375a;
        Bundle bundle = this.f7376b;
        c0200ef.mo354l().mo356n();
        if (!C1963kI.m8253a() || !c0200ef.m941i0().m10798H(c0569mg.f1787l, AbstractC0818Rr.f2444H0) || c0569mg.f1787l == null) {
            return new ArrayList<>();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    c0200ef.mo349g().m9618G().m10616a("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        C0496Kq c0496KqM946l0 = c0200ef.m946l0();
                        String str = c0569mg.f1787l;
                        int i2 = intArray[i];
                        long j = longArray[i];
                        AbstractC1085Xi.m4795d(str);
                        c0496KqM946l0.mo356n();
                        c0496KqM946l0.m10440u();
                        try {
                            int iDelete = c0496KqM946l0.m2467B().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                            c0496KqM946l0.mo349g().m9622K().m10619d("Pruned " + iDelete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            c0496KqM946l0.mo349g().m9618G().m10618c("Error pruning trigger URIs. appId", C2356sx.m9613v(str), e);
                        }
                    }
                }
            }
        }
        return c0200ef.m946l0().m2507W0(c0569mg.f1787l);
    }
}
