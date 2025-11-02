package p000;

import java.io.Serializable;
import p000.InterfaceC0191E6;

/* loaded from: classes.dex */
public final class C2227q5 implements InterfaceC0191E6, Serializable {

    public final InterfaceC0191E6 f6680l;

    public final b f6681m;

    public static final class a extends AbstractC0025Af implements InterfaceC1920jc {

        public static final a f6682m = new a();

        public a() {
            super(2);
        }

        @Override
        public final String mo858j(String str, b bVar) {
            AbstractC0116Ce.m476e(str, "acc");
            AbstractC0116Ce.m476e(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public C2227q5(InterfaceC0191E6 interfaceC0191E6, b bVar) {
        AbstractC0116Ce.m476e(interfaceC0191E6, "left");
        AbstractC0116Ce.m476e(bVar, "element");
        this.f6680l = interfaceC0191E6;
        this.f6681m = bVar;
    }

    @Override
    public InterfaceC0191E6 mo852B(c cVar) {
        AbstractC0116Ce.m476e(cVar, "key");
        if (this.f6681m.mo855b(cVar) != null) {
            return this.f6680l;
        }
        InterfaceC0191E6 interfaceC0191E6Mo852B = this.f6680l.mo852B(cVar);
        return interfaceC0191E6Mo852B == this.f6680l ? this : interfaceC0191E6Mo852B == C0608N9.f1911l ? this.f6681m : new C2227q5(interfaceC0191E6Mo852B, this.f6681m);
    }

    @Override
    public Object mo853E(Object obj, InterfaceC1920jc interfaceC1920jc) {
        AbstractC0116Ce.m476e(interfaceC1920jc, "operation");
        return interfaceC1920jc.mo858j(this.f6680l.mo853E(obj, interfaceC1920jc), this.f6681m);
    }

    @Override
    public InterfaceC0191E6 mo854I(InterfaceC0191E6 interfaceC0191E6) {
        return InterfaceC0191E6.a.m856a(this, interfaceC0191E6);
    }

    @Override
    public b mo855b(c cVar) {
        AbstractC0116Ce.m476e(cVar, "key");
        C2227q5 c2227q5 = this;
        while (true) {
            b bVarMo855b = c2227q5.f6681m.mo855b(cVar);
            if (bVarMo855b != null) {
                return bVarMo855b;
            }
            InterfaceC0191E6 interfaceC0191E6 = c2227q5.f6680l;
            if (!(interfaceC0191E6 instanceof C2227q5)) {
                return interfaceC0191E6.mo855b(cVar);
            }
            c2227q5 = (C2227q5) interfaceC0191E6;
        }
    }

    public final boolean m9100c(b bVar) {
        return AbstractC0116Ce.m472a(mo855b(bVar.getKey()), bVar);
    }

    public final boolean m9101d(C2227q5 c2227q5) {
        while (m9100c(c2227q5.f6681m)) {
            InterfaceC0191E6 interfaceC0191E6 = c2227q5.f6680l;
            if (!(interfaceC0191E6 instanceof C2227q5)) {
                AbstractC0116Ce.m474c(interfaceC0191E6, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return m9100c((b) interfaceC0191E6);
            }
            c2227q5 = (C2227q5) interfaceC0191E6;
        }
        return false;
    }

    public final int m9102e() {
        int i = 2;
        C2227q5 c2227q5 = this;
        while (true) {
            InterfaceC0191E6 interfaceC0191E6 = c2227q5.f6680l;
            c2227q5 = interfaceC0191E6 instanceof C2227q5 ? (C2227q5) interfaceC0191E6 : null;
            if (c2227q5 == null) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C2227q5) {
                C2227q5 c2227q5 = (C2227q5) obj;
                if (c2227q5.m9102e() != m9102e() || !c2227q5.m9101d(this)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f6680l.hashCode() + this.f6681m.hashCode();
    }

    public String toString() {
        return '[' + ((String) mo853E("", a.f6682m)) + ']';
    }
}
