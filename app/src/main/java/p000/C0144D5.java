package p000;

/* loaded from: classes.dex */
public final class C0144D5 {

    public final Object f352a;

    public final InterfaceC0986Vb f353b;

    public C0144D5(Object obj, InterfaceC0986Vb interfaceC0986Vb) {
        this.f352a = obj;
        this.f353b = interfaceC0986Vb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0144D5)) {
            return false;
        }
        C0144D5 c0144d5 = (C0144D5) obj;
        return AbstractC0116Ce.m472a(this.f352a, c0144d5.f352a) && AbstractC0116Ce.m472a(this.f353b, c0144d5.f353b);
    }

    public int hashCode() {
        Object obj = this.f352a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f353b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f352a + ", onCancellation=" + this.f353b + ')';
    }
}
