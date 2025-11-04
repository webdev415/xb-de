package p000;

public final class C0244FD implements InterfaceC0934UE {

    public static final InterfaceC1632dE f656b = new C0152DD();

    public final InterfaceC1632dE f657a;

    public C0244FD() {
        this(new C0612ND(C0840SC.m4018c(), f656b));
    }

    @Override
    public final InterfaceC1026WE mo1214a(Class cls) {
        AbstractC1211aF.m5227l(cls);
        InterfaceC1725fE interfaceC1725fEMo633a = this.f657a.mo633a(cls);
        if (interfaceC1725fEMo633a.mo4021c()) {
            return C2374tE.m9688j(AbstractC1211aF.m5223h(), AbstractC2280rC.m9359a(), interfaceC1725fEMo633a.mo4019a());
        }
        return C2236qE.m9122s(cls, interfaceC1725fEMo633a, AbstractC0061BE.m228a(), AbstractC0060BD.m227a(), AbstractC1211aF.m5223h(), AbstractC0704PD.f2108a[interfaceC1725fEMo633a.mo4020b().ordinal()] != 1 ? AbstractC2280rC.m9359a() : null, AbstractC1163ZD.m5029a());
    }

    public C0244FD(InterfaceC1632dE interfaceC1632dE) {
        this.f657a = (InterfaceC1632dE) AbstractC0932UC.m4210f(interfaceC1632dE, "messageInfoFactory");
    }
}
