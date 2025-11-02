package p000;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class AbstractC2233qB implements Serializable, Iterable {

    public static final AbstractC2233qB f6688m = new C0564MB(AbstractC0932UC.f2840b);

    public static final InterfaceC2509wB f6689n = new C0839SB();

    public int f6690l = 0;

    static {
        new C2417uB();
    }

    public static int m9104g(byte b) {
        return b & 255;
    }

    public static int m9105h(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public static AbstractC2233qB m9106k(String str) {
        return new C0564MB(str.getBytes(AbstractC0932UC.f2839a));
    }

    public static AbstractC2233qB m9107o(byte[] bArr) {
        return m9108p(bArr, 0, bArr.length);
    }

    public static AbstractC2233qB m9108p(byte[] bArr, int i, int i2) {
        m9105h(i, i + i2, bArr.length);
        return new C0564MB(f6689n.mo4017a(bArr, i, i2));
    }

    public static C0012AB m9109u(int i) {
        return new C0012AB(i);
    }

    public abstract byte mo2839d(int i);

    public abstract boolean equals(Object obj);

    public final int m9110f() {
        return this.f6690l;
    }

    public final int hashCode() {
        int iMo2844t = this.f6690l;
        if (iMo2844t == 0) {
            int iMo2843s = mo2843s();
            iMo2844t = mo2844t(iMo2843s, 0, iMo2843s);
            if (iMo2844t == 0) {
                iMo2844t = 1;
            }
            this.f6690l = iMo2844t;
        }
        return iMo2844t;
    }

    public abstract AbstractC2233qB mo2840i(int i, int i2);

    @Override
    public Iterator iterator() {
        return new C2140oB(this);
    }

    public abstract void mo2841q(AbstractC1956kB abstractC1956kB);

    public abstract byte mo2842r(int i);

    public abstract int mo2843s();

    public abstract int mo2844t(int i, int i2, int i3);

    public final String toString() {
        String strM229a;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer numValueOf = Integer.valueOf(mo2843s());
        if (mo2843s() <= 50) {
            strM229a = AbstractC0062BF.m229a(this);
        } else {
            strM229a = AbstractC0062BF.m229a(mo2840i(0, 47)) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", hexString, numValueOf, strM229a);
    }
}
