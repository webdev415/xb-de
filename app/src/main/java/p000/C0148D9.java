package p000;

/* loaded from: classes.dex */
public final class C0148D9 extends IllegalStateException {
    public C0148D9(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException m629a(AbstractC1838hn abstractC1838hn) {
        if (!abstractC1838hn.mo4725g()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excMo4722d = abstractC1838hn.mo4722d();
        return new C0148D9("Complete with: ".concat(excMo4722d != null ? "failure" : abstractC1838hn.mo4726h() ? "result ".concat(String.valueOf(abstractC1838hn.mo4723e())) : abstractC1838hn.mo4724f() ? "cancellation" : "unknown issue"), excMo4722d);
    }
}
