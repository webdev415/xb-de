package p000;

public abstract class AbstractC2589y extends C1877if implements InterfaceC1081Xe, InterfaceC2458v6, InterfaceC0559M6 {

    public final InterfaceC0191E6 f8041n;

    public AbstractC2589y(InterfaceC0191E6 interfaceC0191E6, boolean z, boolean z2) {
        super(z2);
        if (z) {
            m7918W((InterfaceC1081Xe) interfaceC0191E6.mo855b(InterfaceC1081Xe.f3236c));
        }
        this.f8041n = interfaceC0191E6.mo854I(this);
    }

    public final void m10827A0(EnumC0743Q6 enumC0743Q6, Object obj, InterfaceC1920jc interfaceC1920jc) {
        enumC0743Q6.m3630e(interfaceC1920jc, obj, this);
    }

    @Override
    public final void mo7917V(Throwable th) {
        AbstractC0467K6.m2289a(this.f8041n, th);
    }

    @Override
    public boolean mo4769a() {
        return super.mo4769a();
    }

    @Override
    public InterfaceC0191E6 mo2826c() {
        return this.f8041n;
    }

    @Override
    public String mo7924c0() {
        String strM1203b = AbstractC0237F6.m1203b(this.f8041n);
        if (strM1203b == null) {
            return super.mo7924c0();
        }
        return '\"' + strM1203b + "\":" + super.mo7924c0();
    }

    @Override
    public final InterfaceC0191E6 mo197f() {
        return this.f8041n;
    }

    @Override
    public final void mo198h(Object obj) {
        Object objM7922a0 = m7922a0(AbstractC0282G5.m1348c(obj, null, 1, null));
        if (objM7922a0 == AbstractC1923jf.f5949b) {
            return;
        }
        m10828x0(objM7922a0);
    }

    @Override
    public final void mo7929h0(Object obj) {
        if (!(obj instanceof C0098C5)) {
            m10830z0(obj);
        } else {
            C0098C5 c0098c5 = (C0098C5) obj;
            m10829y0(c0098c5.f244a, c0098c5.m402a());
        }
    }

    @Override
    public String mo7950x() {
        return AbstractC2505w7.m10433a(this) + " was cancelled";
    }

    public void m10828x0(Object obj) {
        m7939q(obj);
    }

    public void m10830z0(Object obj) {
    }

    public void m10829y0(Throwable th, boolean z) {
    }
}
