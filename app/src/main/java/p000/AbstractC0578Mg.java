package p000;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;

/* loaded from: classes.dex */
public abstract class AbstractC0578Mg {

    public static final b f1822a = new b(null);

    public static final class a extends AbstractC0578Mg {

        public final AbstractC0532Lg f1823b;

        public static final class C2692a extends AbstractC0905Tm implements InterfaceC1920jc {

            public int f1824p;

            public C2692a(AbstractC0101C8 abstractC0101C8, InterfaceC2458v6 interfaceC2458v6) {
                super(2, interfaceC2458v6);
            }

            @Override
            public final InterfaceC2458v6 mo2875a(Object obj, InterfaceC2458v6 interfaceC2458v6) {
                return a.this.new C2692a(null, interfaceC2458v6);
            }

            @Override
            public final Object mo706i(Object obj) throws Throwable {
                Object objM1037c = AbstractC0208Ee.m1037c();
                int i = this.f1824p;
                if (i == 0) {
                    AbstractC0766Qk.m3696b(obj);
                    AbstractC0532Lg abstractC0532Lg = a.this.f1823b;
                    this.f1824p = 1;
                    if (abstractC0532Lg.mo2684a(null, this) == objM1037c) {
                        return objM1037c;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC0766Qk.m3696b(obj);
                }
                return C2116no.f6480a;
            }

            @Override
            public final Object mo858j(InterfaceC0559M6 interfaceC0559M6, InterfaceC2458v6 interfaceC2458v6) {
                return ((C2692a) mo2875a(interfaceC0559M6, interfaceC2458v6)).mo706i(C2116no.f6480a);
            }
        }

        public static final class b extends AbstractC0905Tm implements InterfaceC1920jc {

            public int f1826p;

            public b(InterfaceC2458v6 interfaceC2458v6) {
                super(2, interfaceC2458v6);
            }

            @Override
            public final InterfaceC2458v6 mo2875a(Object obj, InterfaceC2458v6 interfaceC2458v6) {
                return a.this.new b(interfaceC2458v6);
            }

            @Override
            public final Object mo706i(Object obj) throws Throwable {
                Object objM1037c = AbstractC0208Ee.m1037c();
                int i = this.f1826p;
                if (i == 0) {
                    AbstractC0766Qk.m3696b(obj);
                    AbstractC0532Lg abstractC0532Lg = a.this.f1823b;
                    this.f1826p = 1;
                    obj = abstractC0532Lg.mo2685b(this);
                    if (obj == objM1037c) {
                        return objM1037c;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC0766Qk.m3696b(obj);
                }
                return obj;
            }

            @Override
            public final Object mo858j(InterfaceC0559M6 interfaceC0559M6, InterfaceC2458v6 interfaceC2458v6) {
                return ((b) mo2875a(interfaceC0559M6, interfaceC2458v6)).mo706i(C2116no.f6480a);
            }
        }

        public static final class c extends AbstractC0905Tm implements InterfaceC1920jc {

            public int f1828p;

            public final Uri f1830r;

            public final InputEvent f1831s;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Uri uri, InputEvent inputEvent, InterfaceC2458v6 interfaceC2458v6) {
                super(2, interfaceC2458v6);
                this.f1830r = uri;
                this.f1831s = inputEvent;
            }

            @Override
            public final InterfaceC2458v6 mo2875a(Object obj, InterfaceC2458v6 interfaceC2458v6) {
                return a.this.new c(this.f1830r, this.f1831s, interfaceC2458v6);
            }

            @Override
            public final Object mo706i(Object obj) throws Throwable {
                Object objM1037c = AbstractC0208Ee.m1037c();
                int i = this.f1828p;
                if (i == 0) {
                    AbstractC0766Qk.m3696b(obj);
                    AbstractC0532Lg abstractC0532Lg = a.this.f1823b;
                    Uri uri = this.f1830r;
                    InputEvent inputEvent = this.f1831s;
                    this.f1828p = 1;
                    if (abstractC0532Lg.mo2686c(uri, inputEvent, this) == objM1037c) {
                        return objM1037c;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC0766Qk.m3696b(obj);
                }
                return C2116no.f6480a;
            }

            @Override
            public final Object mo858j(InterfaceC0559M6 interfaceC0559M6, InterfaceC2458v6 interfaceC2458v6) {
                return ((c) mo2875a(interfaceC0559M6, interfaceC2458v6)).mo706i(C2116no.f6480a);
            }
        }

        public static final class d extends AbstractC0905Tm implements InterfaceC1920jc {

            public int f1832p;

            public final Uri f1834r;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Uri uri, InterfaceC2458v6 interfaceC2458v6) {
                super(2, interfaceC2458v6);
                this.f1834r = uri;
            }

            @Override
            public final InterfaceC2458v6 mo2875a(Object obj, InterfaceC2458v6 interfaceC2458v6) {
                return a.this.new d(this.f1834r, interfaceC2458v6);
            }

            @Override
            public final Object mo706i(Object obj) throws Throwable {
                Object objM1037c = AbstractC0208Ee.m1037c();
                int i = this.f1832p;
                if (i == 0) {
                    AbstractC0766Qk.m3696b(obj);
                    AbstractC0532Lg abstractC0532Lg = a.this.f1823b;
                    Uri uri = this.f1834r;
                    this.f1832p = 1;
                    if (abstractC0532Lg.mo2687d(uri, this) == objM1037c) {
                        return objM1037c;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC0766Qk.m3696b(obj);
                }
                return C2116no.f6480a;
            }

            @Override
            public final Object mo858j(InterfaceC0559M6 interfaceC0559M6, InterfaceC2458v6 interfaceC2458v6) {
                return ((d) mo2875a(interfaceC0559M6, interfaceC2458v6)).mo706i(C2116no.f6480a);
            }
        }

        public static final class e extends AbstractC0905Tm implements InterfaceC1920jc {

            public int f1835p;

            public e(AbstractC0770Qo abstractC0770Qo, InterfaceC2458v6 interfaceC2458v6) {
                super(2, interfaceC2458v6);
            }

            @Override
            public final InterfaceC2458v6 mo2875a(Object obj, InterfaceC2458v6 interfaceC2458v6) {
                return a.this.new e(null, interfaceC2458v6);
            }

            @Override
            public final Object mo706i(Object obj) throws Throwable {
                Object objM1037c = AbstractC0208Ee.m1037c();
                int i = this.f1835p;
                if (i == 0) {
                    AbstractC0766Qk.m3696b(obj);
                    AbstractC0532Lg abstractC0532Lg = a.this.f1823b;
                    this.f1835p = 1;
                    if (abstractC0532Lg.mo2688e(null, this) == objM1037c) {
                        return objM1037c;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC0766Qk.m3696b(obj);
                }
                return C2116no.f6480a;
            }

            @Override
            public final Object mo858j(InterfaceC0559M6 interfaceC0559M6, InterfaceC2458v6 interfaceC2458v6) {
                return ((e) mo2875a(interfaceC0559M6, interfaceC2458v6)).mo706i(C2116no.f6480a);
            }
        }

        public static final class f extends AbstractC0905Tm implements InterfaceC1920jc {

            public int f1837p;

            public f(AbstractC0815Ro abstractC0815Ro, InterfaceC2458v6 interfaceC2458v6) {
                super(2, interfaceC2458v6);
            }

            @Override
            public final InterfaceC2458v6 mo2875a(Object obj, InterfaceC2458v6 interfaceC2458v6) {
                return a.this.new f(null, interfaceC2458v6);
            }

            @Override
            public final Object mo706i(Object obj) throws Throwable {
                Object objM1037c = AbstractC0208Ee.m1037c();
                int i = this.f1837p;
                if (i == 0) {
                    AbstractC0766Qk.m3696b(obj);
                    AbstractC0532Lg abstractC0532Lg = a.this.f1823b;
                    this.f1837p = 1;
                    if (abstractC0532Lg.mo2689f(null, this) == objM1037c) {
                        return objM1037c;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC0766Qk.m3696b(obj);
                }
                return C2116no.f6480a;
            }

            @Override
            public final Object mo858j(InterfaceC0559M6 interfaceC0559M6, InterfaceC2458v6 interfaceC2458v6) {
                return ((f) mo2875a(interfaceC0559M6, interfaceC2458v6)).mo706i(C2116no.f6480a);
            }
        }

        public a(AbstractC0532Lg abstractC0532Lg) {
            AbstractC0116Ce.m476e(abstractC0532Lg, "mMeasurementManager");
            this.f1823b = abstractC0532Lg;
        }

        @Override
        public InterfaceFutureC0852Sf mo2868b() {
            return AbstractC0145D6.m613c(AbstractC2639z3.m10990b(AbstractC0605N6.m3292a(C1158Z8.m5023a()), null, null, new b(null), 3, null), null, 1, null);
        }

        @Override
        public InterfaceFutureC0852Sf mo2869c(Uri uri) {
            AbstractC0116Ce.m476e(uri, "trigger");
            return AbstractC0145D6.m613c(AbstractC2639z3.m10990b(AbstractC0605N6.m3292a(C1158Z8.m5023a()), null, null, new d(uri, null), 3, null), null, 1, null);
        }

        public InterfaceFutureC0852Sf m2871e(AbstractC0101C8 abstractC0101C8) {
            AbstractC0116Ce.m476e(abstractC0101C8, "deletionRequest");
            return AbstractC0145D6.m613c(AbstractC2639z3.m10990b(AbstractC0605N6.m3292a(C1158Z8.m5023a()), null, null, new C2692a(abstractC0101C8, null), 3, null), null, 1, null);
        }

        public InterfaceFutureC0852Sf m2872f(Uri uri, InputEvent inputEvent) {
            AbstractC0116Ce.m476e(uri, "attributionSource");
            return AbstractC0145D6.m613c(AbstractC2639z3.m10990b(AbstractC0605N6.m3292a(C1158Z8.m5023a()), null, null, new c(uri, inputEvent, null), 3, null), null, 1, null);
        }

        public InterfaceFutureC0852Sf m2873g(AbstractC0770Qo abstractC0770Qo) {
            AbstractC0116Ce.m476e(abstractC0770Qo, "request");
            return AbstractC0145D6.m613c(AbstractC2639z3.m10990b(AbstractC0605N6.m3292a(C1158Z8.m5023a()), null, null, new e(abstractC0770Qo, null), 3, null), null, 1, null);
        }

        public InterfaceFutureC0852Sf m2874h(AbstractC0815Ro abstractC0815Ro) {
            AbstractC0116Ce.m476e(abstractC0815Ro, "request");
            return AbstractC0145D6.m613c(AbstractC2639z3.m10990b(AbstractC0605N6.m3292a(C1158Z8.m5023a()), null, null, new f(abstractC0815Ro, null), 3, null), null, 1, null);
        }
    }

    public static final class b {
        public b() {
        }

        public final AbstractC0578Mg m2882a(Context context) {
            AbstractC0116Ce.m476e(context, "context");
            AbstractC0532Lg abstractC0532LgM2697a = AbstractC0532Lg.f1715a.m2697a(context);
            if (abstractC0532LgM2697a != null) {
                return new a(abstractC0532LgM2697a);
            }
            return null;
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final AbstractC0578Mg m2867a(Context context) {
        return f1822a.m2882a(context);
    }

    public abstract InterfaceFutureC0852Sf mo2868b();

    public abstract InterfaceFutureC0852Sf mo2869c(Uri uri);
}
