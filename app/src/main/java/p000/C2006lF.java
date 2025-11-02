package p000;

/* loaded from: classes.dex */
public final class C2006lF {

    public final InterfaceC0557M4 f6082a;

    public long f6083b;

    public C2006lF(InterfaceC0557M4 interfaceC0557M4) {
        AbstractC1085Xi.m4801j(interfaceC0557M4);
        this.f6082a = interfaceC0557M4;
    }

    public final void m8379a() {
        this.f6083b = 0L;
    }

    public final boolean m8380b(long j) {
        return this.f6083b == 0 || this.f6082a.mo2817c() - this.f6083b >= 3600000;
    }

    public final void m8381c() {
        this.f6083b = this.f6082a.mo2817c();
    }
}
