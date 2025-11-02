package p000;

import java.util.concurrent.CancellationException;
import p000.AbstractC0602N3;

/* loaded from: classes.dex */
public abstract class AbstractC0145D6 {

    public static final class a extends AbstractC0025Af implements InterfaceC0986Vb {

        public final AbstractC0602N3.a f354m;

        public final InterfaceC1953k8 f355n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC0602N3.a aVar, InterfaceC1953k8 interfaceC1953k8) {
            super(1);
            this.f354m = aVar;
            this.f355n = interfaceC1953k8;
        }

        public final void m615a(Throwable th) {
            if (th == null) {
                this.f354m.m3282b(this.f355n.mo8235k());
            } else if (th instanceof CancellationException) {
                this.f354m.m3283c();
            } else {
                this.f354m.m3285e(th);
            }
        }

        @Override
        public /* bridge */ Object mo15n(Object obj) {
            m615a((Throwable) obj);
            return C2116no.f6480a;
        }
    }

    public static final InterfaceFutureC0852Sf m612b(final InterfaceC1953k8 interfaceC1953k8, final Object obj) {
        AbstractC0116Ce.m476e(interfaceC1953k8, "<this>");
        InterfaceFutureC0852Sf interfaceFutureC0852SfM3280a = AbstractC0602N3.m3280a(new AbstractC0602N3.c() {
            @Override
            public final Object mo404a(AbstractC0602N3.a aVar) {
                return AbstractC0145D6.m614d(interfaceC1953k8, obj, aVar);
            }
        });
        AbstractC0116Ce.m475d(interfaceFutureC0852SfM3280a, "getFuture { completer ->…        }\n    }\n    tag\n}");
        return interfaceFutureC0852SfM3280a;
    }

    public static InterfaceFutureC0852Sf m613c(InterfaceC1953k8 interfaceC1953k8, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return m612b(interfaceC1953k8, obj);
    }

    public static final Object m614d(InterfaceC1953k8 interfaceC1953k8, Object obj, AbstractC0602N3.a aVar) {
        AbstractC0116Ce.m476e(interfaceC1953k8, "$this_asListenableFuture");
        AbstractC0116Ce.m476e(aVar, "completer");
        interfaceC1953k8.mo4773w(new a(aVar, interfaceC1953k8));
        return obj;
    }
}
