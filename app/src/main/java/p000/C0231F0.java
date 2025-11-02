package p000;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class C0231F0 implements InterfaceC0185E0 {

    public static volatile InterfaceC0185E0 f609c;

    public final C1012W0 f610a;

    public final Map f611b;

    public C0231F0(C1012W0 c1012w0) {
        AbstractC1085Xi.m4801j(c1012w0);
        this.f610a = c1012w0;
        this.f611b = new ConcurrentHashMap();
    }

    public static InterfaceC0185E0 m1164a(C1364cb c1364cb, Context context, InterfaceC0722Pm interfaceC0722Pm) {
        AbstractC1085Xi.m4801j(c1364cb);
        AbstractC1085Xi.m4801j(context);
        AbstractC1085Xi.m4801j(interfaceC0722Pm);
        AbstractC1085Xi.m4801j(context.getApplicationContext());
        if (f609c == null) {
            synchronized (C0231F0.class) {
                try {
                    if (f609c == null) {
                        Bundle bundle = new Bundle(1);
                        if (c1364cb.m5878t()) {
                            interfaceC0722Pm.mo3584a(AbstractC1952k7.class, new Executor() {
                                @Override
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new InterfaceC1872ia() {
                                @Override
                                public final void mo3442a(AbstractC1684ea abstractC1684ea) {
                                    C0231F0.m1165b(abstractC1684ea);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", c1364cb.m5877s());
                        }
                        f609c = new C0231F0(C0224Eu.m1102h(context, null, null, null, bundle).m1130w());
                    }
                } finally {
                }
            }
        }
        return f609c;
    }

    public static void m1165b(AbstractC1684ea abstractC1684ea) {
        throw null;
    }
}
