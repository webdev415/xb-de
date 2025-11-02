package p000;

/* loaded from: classes.dex */
public class C0564MB extends AbstractC0196EB {

    public final byte[] f1762o;

    public C0564MB(byte[] bArr) {
        super();
        bArr.getClass();
        this.f1762o = bArr;
    }

    @Override
    public byte mo2839d(int i) {
        return this.f1762o[i];
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2233qB) || mo2843s() != ((AbstractC2233qB) obj).mo2843s()) {
            return false;
        }
        if (mo2843s() == 0) {
            return true;
        }
        if (!(obj instanceof C0564MB)) {
            return obj.equals(this);
        }
        C0564MB c0564mb = (C0564MB) obj;
        int iM9110f = m9110f();
        int iM9110f2 = c0564mb.m9110f();
        if (iM9110f == 0 || iM9110f2 == 0 || iM9110f == iM9110f2) {
            return mo887v(c0564mb, 0, mo2843s());
        }
        return false;
    }

    @Override
    public final AbstractC2233qB mo2840i(int i, int i2) {
        int iM9105h = AbstractC2233qB.m9105h(0, i2, mo2843s());
        return iM9105h == 0 ? AbstractC2233qB.f6688m : new C2601yB(this.f1762o, mo2845w(), iM9105h);
    }

    @Override
    public final void mo2841q(AbstractC1956kB abstractC1956kB) {
        abstractC1956kB.mo5849a(this.f1762o, mo2845w(), mo2843s());
    }

    @Override
    public byte mo2842r(int i) {
        return this.f1762o[i];
    }

    @Override
    public int mo2843s() {
        return this.f1762o.length;
    }

    @Override
    public final int mo2844t(int i, int i2, int i3) {
        return AbstractC0932UC.m4205a(i, this.f1762o, mo2845w(), i3);
    }

    @Override
    public final boolean mo887v(AbstractC2233qB abstractC2233qB, int i, int i2) {
        if (i2 > abstractC2233qB.mo2843s()) {
            throw new IllegalArgumentException("Length too large: " + i2 + mo2843s());
        }
        if (i2 > abstractC2233qB.mo2843s()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + abstractC2233qB.mo2843s());
        }
        if (!(abstractC2233qB instanceof C0564MB)) {
            return abstractC2233qB.mo2840i(0, i2).equals(mo2840i(0, i2));
        }
        C0564MB c0564mb = (C0564MB) abstractC2233qB;
        byte[] bArr = this.f1762o;
        byte[] bArr2 = c0564mb.f1762o;
        int iMo2845w = mo2845w() + i2;
        int iMo2845w2 = mo2845w();
        int iMo2845w3 = c0564mb.mo2845w();
        while (iMo2845w2 < iMo2845w) {
            if (bArr[iMo2845w2] != bArr2[iMo2845w3]) {
                return false;
            }
            iMo2845w2++;
            iMo2845w3++;
        }
        return true;
    }

    public int mo2845w() {
        return 0;
    }
}
