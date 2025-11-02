package p000;

import p000.InterfaceC0191E6;

/* loaded from: classes.dex */
public abstract class AbstractC2530wn {

    public static final C0951Um f7898a = new C0951Um("NO_THREAD_ELEMENTS");

    public static final InterfaceC1920jc f7899b = a.f7902m;

    public static final InterfaceC1920jc f7900c = b.f7903m;

    public static final InterfaceC1920jc f7901d = c.f7904m;

    public static final class a extends AbstractC0025Af implements InterfaceC1920jc {

        public static final a f7902m = new a();

        public a() {
            super(2);
        }

        @Override
        public final Object mo858j(Object obj, InterfaceC0191E6.b bVar) {
            if (!(bVar instanceof InterfaceC2484vn)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    public static final class b extends AbstractC0025Af implements InterfaceC1920jc {

        public static final b f7903m = new b();

        public b() {
            super(2);
        }

        @Override
        public final InterfaceC2484vn mo858j(InterfaceC2484vn interfaceC2484vn, InterfaceC0191E6.b bVar) {
            if (interfaceC2484vn != null) {
                return interfaceC2484vn;
            }
            if (bVar instanceof InterfaceC2484vn) {
                return (InterfaceC2484vn) bVar;
            }
            return null;
        }
    }

    public static final class c extends AbstractC0025Af implements InterfaceC1920jc {

        public static final c f7904m = new c();

        public c() {
            super(2);
        }

        @Override
        public final C0079Bn mo858j(C0079Bn c0079Bn, InterfaceC0191E6.b bVar) {
            if (bVar instanceof InterfaceC2484vn) {
                InterfaceC2484vn interfaceC2484vn = (InterfaceC2484vn) bVar;
                c0079Bn.m325a(interfaceC2484vn, interfaceC2484vn.m10402C(c0079Bn.f194a));
            }
            return c0079Bn;
        }
    }

    public static final void m10598a(InterfaceC0191E6 interfaceC0191E6, Object obj) {
        if (obj == f7898a) {
            return;
        }
        if (obj instanceof C0079Bn) {
            ((C0079Bn) obj).m326b(interfaceC0191E6);
            return;
        }
        Object objMo853E = interfaceC0191E6.mo853E(null, f7900c);
        AbstractC0116Ce.m474c(objMo853E, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((InterfaceC2484vn) objMo853E).m10403j(interfaceC0191E6, obj);
    }

    public static final Object m10599b(InterfaceC0191E6 interfaceC0191E6) {
        Object objMo853E = interfaceC0191E6.mo853E(0, f7899b);
        AbstractC0116Ce.m473b(objMo853E);
        return objMo853E;
    }

    public static final Object m10600c(InterfaceC0191E6 interfaceC0191E6, Object obj) {
        if (obj == null) {
            obj = m10599b(interfaceC0191E6);
        }
        if (obj == 0) {
            return f7898a;
        }
        if (obj instanceof Integer) {
            return interfaceC0191E6.mo853E(new C0079Bn(interfaceC0191E6, ((Number) obj).intValue()), f7901d);
        }
        AbstractC0116Ce.m474c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((InterfaceC2484vn) obj).m10402C(interfaceC0191E6);
    }
}
