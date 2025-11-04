package p000;

public final class C1934jq extends AbstractC1286aq {

    public C2124nw f5964g;

    public final C0846SI f5965h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1934jq(C0846SI c0846si, String str, int i, C2124nw c2124nw) {
        super(str, i);
        this.f5965h = c0846si;
        this.f5964g = c2124nw;
    }

    @Override
    public final int mo5562a() {
        return this.f5964g.m8808j();
    }

    @Override
    public final boolean mo5563i() {
        return false;
    }

    @Override
    public final boolean mo5564j() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean m8206k(Long l, Long l2, C0779Qx c0779Qx, boolean z) {
        C2540wx c2540wxM9623L;
        String strM9213g;
        String str;
        Boolean boolM5560g;
        byte b = C2469vH.m10335a() && this.f5965h.mo347e().m10800J(this.f3798a, AbstractC0818Rr.f2521n0);
        boolean zM8803L = this.f5964g.m8803L();
        boolean zM8804M = this.f5964g.m8804M();
        boolean zM8805N = this.f5964g.m8805N();
        byte b2 = zM8803L || zM8804M || zM8805N;
        Boolean boolM5557d = null;
        boolM5557d = null;
        if (z && b2 != true) {
            this.f5965h.mo349g().m9622K().m10618c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f3799b), this.f5964g.m8806O() ? Integer.valueOf(this.f5964g.m8808j()) : null);
            return true;
        }
        C2032lw c2032lwM8801H = this.f5964g.m8801H();
        boolean zM8421M = c2032lwM8801H.m8421M();
        if (c0779Qx.m3735Y()) {
            if (c2032lwM8801H.m8423O()) {
                boolM5560g = AbstractC1286aq.m5556c(c0779Qx.m3729P(), c2032lwM8801H.m8418J());
                boolM5557d = AbstractC1286aq.m5557d(boolM5560g, zM8421M);
            } else {
                c2540wxM9623L = this.f5965h.mo349g().m9623L();
                strM9213g = this.f5965h.mo350h().m9213g(c0779Qx.m3731U());
                str = "No number filter for long property. property";
                c2540wxM9623L.m10617b(str, strM9213g);
            }
        } else if (!c0779Qx.m3733W()) {
            if (c0779Qx.m3737a0()) {
                if (c2032lwM8801H.m8425Q()) {
                    boolM5560g = AbstractC1286aq.m5560g(c0779Qx.m3732V(), c2032lwM8801H.m8419K(), this.f5965h.mo349g());
                } else if (!c2032lwM8801H.m8423O()) {
                    c2540wxM9623L = this.f5965h.mo349g().m9623L();
                    strM9213g = this.f5965h.mo350h().m9213g(c0779Qx.m3731U());
                    str = "No string or number filter defined. property";
                } else if (C2145oG.m8905h0(c0779Qx.m3732V())) {
                    boolM5560g = AbstractC1286aq.m5558e(c0779Qx.m3732V(), c2032lwM8801H.m8418J());
                } else {
                    this.f5965h.mo349g().m9623L().m10618c("Invalid user property value for Numeric number filter. property, value", this.f5965h.mo350h().m9213g(c0779Qx.m3731U()), c0779Qx.m3732V());
                }
                boolM5557d = AbstractC1286aq.m5557d(boolM5560g, zM8421M);
            } else {
                c2540wxM9623L = this.f5965h.mo349g().m9623L();
                strM9213g = this.f5965h.mo350h().m9213g(c0779Qx.m3731U());
                str = "User property has no value, property";
            }
            c2540wxM9623L.m10617b(str, strM9213g);
        } else if (c2032lwM8801H.m8423O()) {
            boolM5560g = AbstractC1286aq.m5555b(c0779Qx.m3727G(), c2032lwM8801H.m8418J());
            boolM5557d = AbstractC1286aq.m5557d(boolM5560g, zM8421M);
        } else {
            c2540wxM9623L = this.f5965h.mo349g().m9623L();
            strM9213g = this.f5965h.mo350h().m9213g(c0779Qx.m3731U());
            str = "No number filter for double property. property";
            c2540wxM9623L.m10617b(str, strM9213g);
        }
        this.f5965h.mo349g().m9622K().m10617b("Property filter result", boolM5557d == null ? "null" : boolM5557d);
        if (boolM5557d == null) {
            return false;
        }
        this.f3800c = Boolean.TRUE;
        if (zM8805N && !boolM5557d.booleanValue()) {
            return true;
        }
        if (!z || this.f5964g.m8803L()) {
            this.f3801d = boolM5557d;
        }
        if (boolM5557d.booleanValue() && b2 != false && c0779Qx.m3736Z()) {
            long jM3730R = c0779Qx.m3730R();
            if (l != null) {
                jM3730R = l.longValue();
            }
            if (b != false && this.f5964g.m8803L() && !this.f5964g.m8804M() && l2 != null) {
                jM3730R = l2.longValue();
            }
            if (this.f5964g.m8804M()) {
                this.f3803f = Long.valueOf(jM3730R);
            } else {
                this.f3802e = Long.valueOf(jM3730R);
            }
        }
        return true;
    }
}
