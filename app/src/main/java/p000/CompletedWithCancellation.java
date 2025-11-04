package p000;

public final class CompletedWithCancellation {

    public final Object result;

    public final InterfaceC0986Vb onCancellation;

    public CompletedWithCancellation(Object obj, InterfaceC0986Vb interfaceC0986Vb) {
        this.result = obj;
        this.onCancellation = interfaceC0986Vb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedWithCancellation)) {
            return false;
        }
        CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) obj;
        return AbstractC0116Ce.m472a(this.result, completedWithCancellation.result) && AbstractC0116Ce.m472a(this.onCancellation, completedWithCancellation.onCancellation);
    }

    public int hashCode() {
        Object obj = this.result;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.onCancellation.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.result + ", onCancellation=" + this.onCancellation + ')';
    }
}
