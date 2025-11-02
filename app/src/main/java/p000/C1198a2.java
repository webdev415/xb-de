package p000;

/* loaded from: classes.dex */
public final class C1198a2 implements InterfaceC1226ak {
    @Override
    public C0720Pk decode(BinaryBitmap binaryBitmap) {
        return mo139b(binaryBitmap, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060 A[LOOP:0: B:32:0x005e->B:33:0x0060, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0091  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0720Pk mo139b(BinaryBitmap r11, java.util.Map r12) throws C2340sh, C2610yb {
        /*
            r10 = this;
            K8 r0 = new K8
            H2 r11 = r11.m597a()
            r0.<init>(r11)
            r11 = 0
            r1 = 0
            Z1 r2 = r0.m2298a(r11)     // Catch: p000.C2610yb -> L25 p000.C2340sh -> L28
            Sk[] r3 = r2.m3385b()     // Catch: p000.C2610yb -> L25 p000.C2340sh -> L28
            J7 r4 = new J7     // Catch: p000.C2610yb -> L21 p000.C2340sh -> L23
            r4.<init>()     // Catch: p000.C2610yb -> L21 p000.C2340sh -> L23
            P7 r2 = r4.m1830c(r2)     // Catch: p000.C2610yb -> L21 p000.C2340sh -> L23
            r4 = r3
            r3 = r1
            r1 = r2
            r2 = r3
            goto L31
        L21:
            r2 = move-exception
            goto L2b
        L23:
            r2 = move-exception
            goto L2f
        L25:
            r2 = move-exception
            r3 = r1
            goto L2b
        L28:
            r2 = move-exception
            r3 = r1
            goto L2f
        L2b:
            r4 = r3
            r3 = r2
            r2 = r1
            goto L31
        L2f:
            r4 = r3
            r3 = r1
        L31:
            if (r1 != 0) goto L45
            r1 = 1
            Z1 r0 = r0.m2298a(r1)     // Catch: p000.C2610yb -> L47 p000.C2340sh -> L49
            Sk[] r4 = r0.m3385b()     // Catch: p000.C2610yb -> L47 p000.C2340sh -> L49
            J7 r1 = new J7     // Catch: p000.C2610yb -> L47 p000.C2340sh -> L49
            r1.<init>()     // Catch: p000.C2610yb -> L47 p000.C2340sh -> L49
            P7 r1 = r1.m1830c(r0)     // Catch: p000.C2610yb -> L47 p000.C2340sh -> L49
        L45:
            r6 = r4
            goto L51
        L47:
            r11 = move-exception
            goto L4a
        L49:
            r11 = move-exception
        L4a:
            if (r2 != 0) goto L50
            if (r3 == 0) goto L4f
            throw r3
        L4f:
            throw r11
        L50:
            throw r2
        L51:
            if (r12 == 0) goto L68
            A7 r0 = p000.EnumC0008A7.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r12 = r12.get(r0)
            Tk r12 = (p000.InterfaceC0903Tk) r12
            if (r12 == 0) goto L68
            int r0 = r6.length
        L5e:
            if (r11 >= r0) goto L68
            r2 = r6[r11]
            r12.mo3293a(r2)
            int r11 = r11 + 1
            goto L5e
        L68:
            Pk r11 = new Pk
            java.lang.String r3 = r1.m3483h()
            byte[] r4 = r1.m3480e()
            int r5 = r1.m3478c()
            m2 r7 = p000.EnumC2039m2.AZTEC
            long r8 = java.lang.System.currentTimeMillis()
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.List r12 = r1.m3476a()
            if (r12 == 0) goto L8b
            Rk r0 = p000.EnumC0811Rk.BYTE_SEGMENTS
            r11.m3582h(r0, r12)
        L8b:
            java.lang.String r12 = r1.m3477b()
            if (r12 == 0) goto L96
            Rk r0 = p000.EnumC0811Rk.ERROR_CORRECTION_LEVEL
            r11.m3582h(r0, r12)
        L96:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1198a2.mo139b(D2, java.util.Map):Pk");
    }

    @Override
    public void mo140c() {
    }
}
