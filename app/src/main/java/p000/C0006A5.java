package p000;

/* loaded from: classes.dex */
public final class C0006A5 {

    public final Object f6a;

    public final InterfaceC0986Vb f7b;

    public final Object f8c;

    public final Throwable f9d;

    public C0006A5(Object obj, AbstractC1107Y3 abstractC1107Y3, InterfaceC0986Vb interfaceC0986Vb, Object obj2, Throwable th) {
        this.f6a = obj;
        this.f7b = interfaceC0986Vb;
        this.f8c = obj2;
        this.f9d = th;
    }

    public static C0006A5 m17b(C0006A5 c0006a5, Object obj, AbstractC1107Y3 abstractC1107Y3, InterfaceC0986Vb interfaceC0986Vb, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = c0006a5.f6a;
        }
        if ((i & 2) != 0) {
            c0006a5.getClass();
            abstractC1107Y3 = null;
        }
        AbstractC1107Y3 abstractC1107Y32 = abstractC1107Y3;
        if ((i & 4) != 0) {
            interfaceC0986Vb = c0006a5.f7b;
        }
        InterfaceC0986Vb interfaceC0986Vb2 = interfaceC0986Vb;
        if ((i & 8) != 0) {
            obj2 = c0006a5.f8c;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = c0006a5.f9d;
        }
        return c0006a5.m18a(obj, abstractC1107Y32, interfaceC0986Vb2, obj4, th);
    }

    public final C0006A5 m18a(Object obj, AbstractC1107Y3 abstractC1107Y3, InterfaceC0986Vb interfaceC0986Vb, Object obj2, Throwable th) {
        return new C0006A5(obj, abstractC1107Y3, interfaceC0986Vb, obj2, th);
    }

    public final boolean m19c() {
        return this.f9d != null;
    }

    public final void m20d(C1347c4 c1347c4, Throwable th) {
        InterfaceC0986Vb interfaceC0986Vb = this.f7b;
        if (interfaceC0986Vb != null) {
            c1347c4.m5715k(interfaceC0986Vb, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0006A5)) {
            return false;
        }
        C0006A5 c0006a5 = (C0006A5) obj;
        return AbstractC0116Ce.m472a(this.f6a, c0006a5.f6a) && AbstractC0116Ce.m472a(null, null) && AbstractC0116Ce.m472a(this.f7b, c0006a5.f7b) && AbstractC0116Ce.m472a(this.f8c, c0006a5.f8c) && AbstractC0116Ce.m472a(this.f9d, c0006a5.f9d);
    }

    public int hashCode() {
        Object obj = this.f6a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 961;
        InterfaceC0986Vb interfaceC0986Vb = this.f7b;
        int iHashCode2 = (iHashCode + (interfaceC0986Vb == null ? 0 : interfaceC0986Vb.hashCode())) * 31;
        Object obj2 = this.f8c;
        int iHashCode3 = (iHashCode2 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f9d;
        return iHashCode3 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f6a + ", cancelHandler=" + ((Object) null) + ", onCancellation=" + this.f7b + ", idempotentResume=" + this.f8c + ", cancelCause=" + this.f9d + ')';
    }

    public C0006A5(Object obj, AbstractC1107Y3 abstractC1107Y3, InterfaceC0986Vb interfaceC0986Vb, Object obj2, Throwable th, int i, AbstractC0881T7 abstractC0881T7) {
        this(obj, (i & 2) != 0 ? null : abstractC1107Y3, (i & 4) != 0 ? null : interfaceC0986Vb, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
