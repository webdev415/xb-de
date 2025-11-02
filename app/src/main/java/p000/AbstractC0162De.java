package p000;

/* loaded from: classes.dex */
public abstract class AbstractC0162De {

    public static final class a extends AbstractC0628Nk {

        public int f402m;

        public final InterfaceC1920jc f403n;

        public final Object f404o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC2458v6 interfaceC2458v6, InterfaceC1920jc interfaceC1920jc, Object obj) {
            super(interfaceC2458v6);
            this.f403n = interfaceC1920jc;
            this.f404o = obj;
            AbstractC0116Ce.m474c(interfaceC2458v6, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override
        public Object mo706i(Object obj) throws Throwable {
            int i = this.f402m;
            if (i == 0) {
                this.f402m = 1;
                AbstractC0766Qk.m3696b(obj);
                AbstractC0116Ce.m474c(this.f403n, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((InterfaceC1920jc) AbstractC0860Sn.m4073a(this.f403n, 2)).mo858j(this.f404o, this);
            }
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f402m = 2;
            AbstractC0766Qk.m3696b(obj);
            return obj;
        }
    }

    public static final class b extends AbstractC2504w6 {

        public int f405o;

        public final InterfaceC1920jc f406p;

        public final Object f407q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC2458v6 interfaceC2458v6, InterfaceC0191E6 interfaceC0191E6, InterfaceC1920jc interfaceC1920jc, Object obj) {
            super(interfaceC2458v6, interfaceC0191E6);
            this.f406p = interfaceC1920jc;
            this.f407q = obj;
            AbstractC0116Ce.m474c(interfaceC2458v6, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override
        public Object mo706i(Object obj) throws Throwable {
            int i = this.f405o;
            if (i == 0) {
                this.f405o = 1;
                AbstractC0766Qk.m3696b(obj);
                AbstractC0116Ce.m474c(this.f406p, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((InterfaceC1920jc) AbstractC0860Sn.m4073a(this.f406p, 2)).mo858j(this.f407q, this);
            }
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f405o = 2;
            AbstractC0766Qk.m3696b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static InterfaceC2458v6 m704a(InterfaceC1920jc interfaceC1920jc, Object obj, InterfaceC2458v6 interfaceC2458v6) {
        AbstractC0116Ce.m476e(interfaceC1920jc, "<this>");
        AbstractC0116Ce.m476e(interfaceC2458v6, "completion");
        InterfaceC2458v6 interfaceC2458v6M10324a = AbstractC2459v7.m10324a(interfaceC2458v6);
        if (interfaceC1920jc instanceof AbstractC2408u2) {
            return ((AbstractC2408u2) interfaceC1920jc).mo2875a(obj, interfaceC2458v6M10324a);
        }
        InterfaceC0191E6 interfaceC0191E6Mo197f = interfaceC2458v6M10324a.mo197f();
        return interfaceC0191E6Mo197f == C0608N9.f1911l ? new a(interfaceC2458v6M10324a, interfaceC1920jc, obj) : new b(interfaceC2458v6M10324a, interfaceC0191E6Mo197f, interfaceC1920jc, obj);
    }

    public static InterfaceC2458v6 m705b(InterfaceC2458v6 interfaceC2458v6) {
        InterfaceC2458v6 interfaceC2458v6M10432l;
        AbstractC0116Ce.m476e(interfaceC2458v6, "<this>");
        AbstractC2504w6 abstractC2504w6 = interfaceC2458v6 instanceof AbstractC2504w6 ? (AbstractC2504w6) interfaceC2458v6 : null;
        return (abstractC2504w6 == null || (interfaceC2458v6M10432l = abstractC2504w6.m10432l()) == null) ? interfaceC2458v6 : interfaceC2458v6M10432l;
    }
}
