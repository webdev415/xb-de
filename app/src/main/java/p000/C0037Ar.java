package p000;

/* loaded from: classes.dex */
public final class C0037Ar extends AbstractC1935jr {
    public C0037Ar() {
        this.f5966a.add(EnumC2259qs.EQUALS);
        this.f5966a.add(EnumC2259qs.GREATER_THAN);
        this.f5966a.add(EnumC2259qs.GREATER_THAN_EQUALS);
        this.f5966a.add(EnumC2259qs.IDENTITY_EQUALS);
        this.f5966a.add(EnumC2259qs.IDENTITY_NOT_EQUALS);
        this.f5966a.add(EnumC2259qs.LESS_THAN);
        this.f5966a.add(EnumC2259qs.LESS_THAN_EQUALS);
        this.f5966a.add(EnumC2259qs.NOT_EQUALS);
    }

    public static boolean m157c(InterfaceC0909Tq interfaceC0909Tq, InterfaceC0909Tq interfaceC0909Tq2) {
        InterfaceC0909Tq c0036Aq;
        InterfaceC0909Tq c0036Aq2;
        while (!interfaceC0909Tq.getClass().equals(interfaceC0909Tq2.getClass())) {
            if (((interfaceC0909Tq instanceof C1842hr) || (interfaceC0909Tq instanceof C0726Pq)) && ((interfaceC0909Tq2 instanceof C1842hr) || (interfaceC0909Tq2 instanceof C0726Pq))) {
                return true;
            }
            boolean z = interfaceC0909Tq instanceof C0036Aq;
            if (z && (interfaceC0909Tq2 instanceof C1093Xq)) {
                c0036Aq2 = new C0036Aq(interfaceC0909Tq2.mo153f());
            } else {
                boolean z2 = interfaceC0909Tq instanceof C1093Xq;
                if (z2 && (interfaceC0909Tq2 instanceof C0036Aq)) {
                    c0036Aq = new C0036Aq(interfaceC0909Tq.mo153f());
                } else if (interfaceC0909Tq instanceof C2395tq) {
                    c0036Aq = new C0036Aq(interfaceC0909Tq.mo153f());
                } else if (interfaceC0909Tq2 instanceof C2395tq) {
                    c0036Aq2 = new C0036Aq(interfaceC0909Tq2.mo153f());
                } else if ((z2 || z) && (interfaceC0909Tq2 instanceof InterfaceC0358Hq)) {
                    c0036Aq2 = new C1093Xq(interfaceC0909Tq2.mo154h());
                } else {
                    if (!(interfaceC0909Tq instanceof InterfaceC0358Hq) || (!(interfaceC0909Tq2 instanceof C1093Xq) && !(interfaceC0909Tq2 instanceof C0036Aq))) {
                        return false;
                    }
                    c0036Aq = new C1093Xq(interfaceC0909Tq.mo154h());
                }
                interfaceC0909Tq = c0036Aq;
            }
            interfaceC0909Tq2 = c0036Aq2;
        }
        if ((interfaceC0909Tq instanceof C1842hr) || (interfaceC0909Tq instanceof C0726Pq)) {
            return true;
        }
        return interfaceC0909Tq instanceof C0036Aq ? (Double.isNaN(interfaceC0909Tq.mo153f().doubleValue()) || Double.isNaN(interfaceC0909Tq2.mo153f().doubleValue()) || interfaceC0909Tq.mo153f().doubleValue() != interfaceC0909Tq2.mo153f().doubleValue()) ? false : true : interfaceC0909Tq instanceof C1093Xq ? interfaceC0909Tq.mo154h().equals(interfaceC0909Tq2.mo154h()) : interfaceC0909Tq instanceof C2395tq ? interfaceC0909Tq.mo152d().equals(interfaceC0909Tq2.mo152d()) : interfaceC0909Tq == interfaceC0909Tq2;
    }

    public static boolean m158d(InterfaceC0909Tq interfaceC0909Tq, InterfaceC0909Tq interfaceC0909Tq2) {
        if (interfaceC0909Tq instanceof InterfaceC0358Hq) {
            interfaceC0909Tq = new C1093Xq(interfaceC0909Tq.mo154h());
        }
        if (interfaceC0909Tq2 instanceof InterfaceC0358Hq) {
            interfaceC0909Tq2 = new C1093Xq(interfaceC0909Tq2.mo154h());
        }
        if ((interfaceC0909Tq instanceof C1093Xq) && (interfaceC0909Tq2 instanceof C1093Xq)) {
            return interfaceC0909Tq.mo154h().compareTo(interfaceC0909Tq2.mo154h()) < 0;
        }
        double dDoubleValue = interfaceC0909Tq.mo153f().doubleValue();
        double dDoubleValue2 = interfaceC0909Tq2.mo153f().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == -0.0d) || ((dDoubleValue == -0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    public static boolean m159e(InterfaceC0909Tq interfaceC0909Tq, InterfaceC0909Tq interfaceC0909Tq2) {
        if (interfaceC0909Tq instanceof InterfaceC0358Hq) {
            interfaceC0909Tq = new C1093Xq(interfaceC0909Tq.mo154h());
        }
        if (interfaceC0909Tq2 instanceof InterfaceC0358Hq) {
            interfaceC0909Tq2 = new C1093Xq(interfaceC0909Tq2.mo154h());
        }
        return (((interfaceC0909Tq instanceof C1093Xq) && (interfaceC0909Tq2 instanceof C1093Xq)) || !(Double.isNaN(interfaceC0909Tq.mo153f().doubleValue()) || Double.isNaN(interfaceC0909Tq2.mo153f().doubleValue()))) && !m158d(interfaceC0909Tq2, interfaceC0909Tq);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final InterfaceC0909Tq mo160b(String r4, C2357sy r5, java.util.List r6) {
        /*
            r3 = this;
            qs r0 = p000.AbstractC1145Yw.m4998e(r4)
            r1 = 2
            p000.AbstractC1145Yw.m5000g(r0, r1, r6)
            r0 = 0
            java.lang.Object r0 = r6.get(r0)
            Tq r0 = (p000.InterfaceC0909Tq) r0
            Tq r0 = r5.m9631c(r0)
            r1 = 1
            java.lang.Object r6 = r6.get(r1)
            Tq r6 = (p000.InterfaceC0909Tq) r6
            Tq r5 = r5.m9631c(r6)
            int[] r6 = p000.AbstractC0313Gr.f991a
            qs r2 = p000.AbstractC1145Yw.m4998e(r4)
            int r2 = r2.ordinal()
            r6 = r6[r2]
            switch(r6) {
                case 1: goto L56;
                case 2: goto L51;
                case 3: goto L4c;
                case 4: goto L47;
                case 5: goto L42;
                case 6: goto L3d;
                case 7: goto L38;
                case 8: goto L32;
                default: goto L2d;
            }
        L2d:
            Tq r4 = super.m8207a(r4)
            return r4
        L32:
            boolean r4 = m157c(r0, r5)
        L36:
            r4 = r4 ^ r1
            goto L5a
        L38:
            boolean r4 = m159e(r0, r5)
            goto L5a
        L3d:
            boolean r4 = m158d(r0, r5)
            goto L5a
        L42:
            boolean r4 = p000.AbstractC1145Yw.m5001h(r0, r5)
            goto L36
        L47:
            boolean r4 = p000.AbstractC1145Yw.m5001h(r0, r5)
            goto L5a
        L4c:
            boolean r4 = m159e(r5, r0)
            goto L5a
        L51:
            boolean r4 = m158d(r5, r0)
            goto L5a
        L56:
            boolean r4 = m157c(r0, r5)
        L5a:
            if (r4 == 0) goto L5f
            Tq r4 = p000.InterfaceC0909Tq.f2790i
            return r4
        L5f:
            Tq r4 = p000.InterfaceC0909Tq.f2791j
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0037Ar.mo160b(java.lang.String, sy, java.util.List):Tq");
    }
}
