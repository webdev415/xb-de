package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class C0560M7 {

    public final C2020lk f1755a = new C2020lk(C2611yc.f8075l);

    public final void m2827a(byte[] bArr, int i) throws C2548x4 {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f1755a.m8404a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (C2112nk unused) {
            throw C2548x4.m10627a();
        }
    }

    public C0698P7 m2828b(C0325H2 c0325h2, Map map) throws C2610yb, C2548x4 {
        C2548x4 e;
        C0417J2 c0417j2 = new C0417J2(c0325h2);
        C2610yb c2610yb = null;
        try {
            return m2829c(c0417j2, map);
        } catch (C2548x4 e2) {
            e = e2;
            try {
                c0417j2.m1788f();
                c0417j2.m1789g(true);
                c0417j2.m1787e();
                c0417j2.m1786d();
                c0417j2.m1784b();
                C0698P7 c0698p7M2829c = m2829c(c0417j2, map);
                c0698p7M2829c.m3488m(new C2664zj(true));
                return c0698p7M2829c;
            } catch (C2548x4 | C2610yb unused) {
                if (c2610yb != null) {
                    throw c2610yb;
                }
                throw e;
            }
        } catch (C2610yb e3) {
            e = null;
            c2610yb = e3;
            c0417j2.m1788f();
            c0417j2.m1789g(true);
            c0417j2.m1787e();
            c0417j2.m1786d();
            c0417j2.m1784b();
            C0698P7 c0698p7M2829c2 = m2829c(c0417j2, map);
            c0698p7M2829c2.m3488m(new C2664zj(true));
            return c0698p7M2829c2;
        }
    }

    public final C0698P7 m2829c(C0417J2 c0417j2, Map map) throws C2610yb, C2548x4 {
        C0126Co c0126CoM1787e = c0417j2.m1787e();
        EnumC1363ca enumC1363caM11008d = c0417j2.m1786d().m11008d();
        C1765g7[] c1765g7ArrM7693b = C1765g7.m7693b(c0417j2.m1785c(), c0126CoM1787e, enumC1363caM11008d);
        int iM7695c = 0;
        for (C1765g7 c1765g7 : c1765g7ArrM7693b) {
            iM7695c += c1765g7.m7695c();
        }
        byte[] bArr = new byte[iM7695c];
        int i = 0;
        for (C1765g7 c1765g72 : c1765g7ArrM7693b) {
            byte[] bArrM7694a = c1765g72.m7694a();
            int iM7695c2 = c1765g72.m7695c();
            m2827a(bArrM7694a, iM7695c2);
            int i2 = 0;
            while (i2 < iM7695c2) {
                bArr[i] = bArrM7694a[i2];
                i2++;
                i++;
            }
        }
        return AbstractC0192E7.m863a(bArr, c0126CoM1787e, enumC1363caM11008d, map);
    }
}
