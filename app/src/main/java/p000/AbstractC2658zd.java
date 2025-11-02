package p000;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import p000.C0096C3;

/* loaded from: classes.dex */
public abstract class AbstractC2658zd {

    public static final C0096C3 f8254a;

    public static final C0096C3 f8255b;

    static {
        C0096C3.a aVar = C0096C3.f235p;
        f8254a = aVar.m395c("\"\\");
        f8255b = aVar.m395c("\t ,=");
    }

    public static final List m11019a(C1079Xc c1079Xc, String str) {
        AbstractC0116Ce.m476e(c1079Xc, "$this$parseChallenges");
        AbstractC0116Ce.m476e(str, "headerName");
        ArrayList arrayList = new ArrayList<>();
        int size = c1079Xc.size();
        for (int i = 0; i < size; i++) {
            if (AbstractC0538Lm.m2720l(str, c1079Xc.m4738f(i), true)) {
                try {
                    m11021c(new C2409u3().mo5925H(c1079Xc.m4740h(i)), arrayList);
                } catch (EOFException e) {
                    C0764Qi.f2268c.m3690g().m3679j("Unable to parse challenge", 5, e);
                }
            }
        }
        return arrayList;
    }

    public static final boolean m11020b(C0490Kk c0490Kk) {
        AbstractC0116Ce.m476e(c0490Kk, "$this$promisesBody");
        if (AbstractC0116Ce.m472a(c0490Kk.m2390S().m496g(), "HEAD")) {
            return false;
        }
        int iM2396j = c0490Kk.m2396j();
        return (((iM2396j >= 100 && iM2396j < 200) || iM2396j == 204 || iM2396j == 304) && AbstractC2623yo.m10944s(c0490Kk) == -1 && !AbstractC0538Lm.m2720l("chunked", C0490Kk.m2383w(c0490Kk, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0085, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0085, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m11021c(C2409u3 r7, List r8) throws EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            m11025g(r7)
            java.lang.String r1 = m11023e(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = m11025g(r7)
            java.lang.String r3 = m11023e(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.mo7333K()
            if (r7 != 0) goto L1f
            return
        L1f:
            o4 r7 = new o4
            java.util.Map r0 = p000.AbstractC2339sg.m9572d()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            byte r4 = (byte) r4
            int r5 = p000.AbstractC2623yo.m10911G(r7, r4)
            boolean r6 = m11025g(r7)
            if (r2 != 0) goto L68
            if (r6 != 0) goto L41
            boolean r2 = r7.mo7333K()
            if (r2 == 0) goto L68
        L41:
            o4 r2 = new o4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "="
            java.lang.String r3 = p000.AbstractC0538Lm.m2723o(r3, r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "Collections.singletonMap…ek + \"=\".repeat(eqCount))"
            p000.AbstractC0116Ce.m475d(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L68:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = p000.AbstractC2623yo.m10911G(r7, r4)
            int r5 = r5 + r6
        L72:
            if (r3 != 0) goto L83
            java.lang.String r3 = m11023e(r7)
            boolean r5 = m11025g(r7)
            if (r5 == 0) goto L7f
            goto L85
        L7f:
            int r5 = p000.AbstractC2623yo.m10911G(r7, r4)
        L83:
            if (r5 != 0) goto L90
        L85:
            o4 r4 = new o4
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L90:
            r6 = 1
            if (r5 <= r6) goto L94
            return
        L94:
            boolean r6 = m11025g(r7)
            if (r6 == 0) goto L9b
            return
        L9b:
            r6 = 34
            byte r6 = (byte) r6
            boolean r6 = m11026h(r7, r6)
            if (r6 == 0) goto La9
            java.lang.String r6 = m11022d(r7)
            goto Lad
        La9:
            java.lang.String r6 = m11023e(r7)
        Lad:
            if (r6 == 0) goto Lc7
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lb8
            return
        Lb8:
            boolean r3 = m11025g(r7)
            if (r3 != 0) goto Lc5
            boolean r3 = r7.mo7333K()
            if (r3 != 0) goto Lc5
            return
        Lc5:
            r3 = r0
            goto L72
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2658zd.m11021c(u3, java.util.List):void");
    }

    public static final String m11022d(C2409u3 c2409u3) throws EOFException {
        byte b = (byte) 34;
        if (!(c2409u3.mo7338R() == b)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        C2409u3 c2409u32 = new C2409u3();
        while (true) {
            long jM9900B = c2409u3.m9900B(f8254a);
            if (jM9900B == -1) {
                return null;
            }
            if (c2409u3.m9932z(jM9900B) == b) {
                c2409u32.mo115h(c2409u3, jM9900B);
                c2409u3.mo7338R();
                return c2409u32.m9908V();
            }
            if (c2409u3.m9911Y() == jM9900B + 1) {
                return null;
            }
            c2409u32.mo115h(c2409u3, jM9900B);
            c2409u3.mo7338R();
            c2409u32.mo115h(c2409u3, 1L);
        }
    }

    public static final String m11023e(C2409u3 c2409u3) {
        long jM9900B = c2409u3.m9900B(f8255b);
        if (jM9900B == -1) {
            jM9900B = c2409u3.m9911Y();
        }
        if (jM9900B != 0) {
            return c2409u3.m9909W(jM9900B);
        }
        return null;
    }

    public static final void m11024f(InterfaceC0053B6 interfaceC0053B6, C0069Bd c0069Bd, C1079Xc c1079Xc) {
        AbstractC0116Ce.m476e(interfaceC0053B6, "$this$receiveHeaders");
        AbstractC0116Ce.m476e(c0069Bd, "url");
        AbstractC0116Ce.m476e(c1079Xc, "headers");
        if (interfaceC0053B6 == InterfaceC0053B6.f121a) {
            return;
        }
        List listM32e = C0007A6.f14n.m32e(c0069Bd, c1079Xc);
        if (listM32e.isEmpty()) {
            return;
        }
        interfaceC0053B6.mo200b(c0069Bd, listM32e);
    }

    public static final boolean m11025g(C2409u3 c2409u3) throws EOFException {
        boolean z = false;
        while (!c2409u3.mo7333K()) {
            byte bM9932z = c2409u3.m9932z(0L);
            if (bM9932z == 9 || bM9932z == 32) {
                c2409u3.mo7338R();
            } else {
                if (bM9932z != 44) {
                    break;
                }
                c2409u3.mo7338R();
                z = true;
            }
        }
        return z;
    }

    public static final boolean m11026h(C2409u3 c2409u3, byte b) {
        return !c2409u3.mo7333K() && c2409u3.m9932z(0L) == b;
    }
}
