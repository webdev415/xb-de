package p000;

public final class CompletedContinuation {

    public final Object result;

    public final InterfaceC0986Vb onCancellation;

    public final Object idempotentResume;

    public final Throwable cancelCause;

    public CompletedContinuation(Object obj, AbstractC1107Y3 abstractC1107Y3, InterfaceC0986Vb interfaceC0986Vb, Object obj2, Throwable th) {
        this.result = obj;
        this.onCancellation = interfaceC0986Vb;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public static CompletedContinuation m17b(CompletedContinuation completedContinuation, Object obj, AbstractC1107Y3 abstractC1107Y3, InterfaceC0986Vb interfaceC0986Vb, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = completedContinuation.result;
        }
        if ((i & 2) != 0) {
            completedContinuation.getClass();
            abstractC1107Y3 = null;
        }
        AbstractC1107Y3 abstractC1107Y32 = abstractC1107Y3;
        if ((i & 4) != 0) {
            interfaceC0986Vb = completedContinuation.onCancellation;
        }
        InterfaceC0986Vb interfaceC0986Vb2 = interfaceC0986Vb;
        if ((i & 8) != 0) {
            obj2 = completedContinuation.idempotentResume;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = completedContinuation.cancelCause;
        }
        return completedContinuation.m18a(obj, abstractC1107Y32, interfaceC0986Vb2, obj4, th);
    }

    public final CompletedContinuation m18a(Object obj, AbstractC1107Y3 abstractC1107Y3, InterfaceC0986Vb interfaceC0986Vb, Object obj2, Throwable th) {
        return new CompletedContinuation(obj, abstractC1107Y3, interfaceC0986Vb, obj2, th);
    }

    public final boolean m19c() {
        return this.cancelCause != null;
    }

    public final void m20d(C1347c4 c1347c4, Throwable th) {
        InterfaceC0986Vb interfaceC0986Vb = this.onCancellation;
        if (interfaceC0986Vb != null) {
            c1347c4.m5715k(interfaceC0986Vb, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return AbstractC0116Ce.m472a(this.result, completedContinuation.result) && AbstractC0116Ce.m472a(null, null) && AbstractC0116Ce.m472a(this.onCancellation, completedContinuation.onCancellation) && AbstractC0116Ce.m472a(this.idempotentResume, completedContinuation.idempotentResume) && AbstractC0116Ce.m472a(this.cancelCause, completedContinuation.cancelCause);
    }

    public int hashCode() {
        Object obj = this.result;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 961;
        InterfaceC0986Vb interfaceC0986Vb = this.onCancellation;
        int iHashCode2 = (iHashCode + (interfaceC0986Vb == null ? 0 : interfaceC0986Vb.hashCode())) * 31;
        Object obj2 = this.idempotentResume;
        int iHashCode3 = (iHashCode2 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.cancelCause;
        return iHashCode3 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + null + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public CompletedContinuation(Object obj, AbstractC1107Y3 abstractC1107Y3, InterfaceC0986Vb interfaceC0986Vb, Object obj2, Throwable th, int i, AbstractC0881T7 abstractC0881T7) {
        this(obj, (i & 2) != 0 ? null : abstractC1107Y3, (i & 4) != 0 ? null : interfaceC0986Vb, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
