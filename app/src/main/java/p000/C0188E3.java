package p000;

/* loaded from: classes.dex */
public class C0188E3 implements InterfaceC0929U9 {
    public static String m849d(CharSequence charSequence) {
        int iCharAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * '(') + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    public static void m850g(C1067X9 c1067x9, StringBuilder sb) {
        c1067x9.m4682s(m849d(sb));
        sb.delete(0, 3);
    }

    @Override
    public void mo776a(C1067X9 c1067x9) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c1067x9.m4672i()) {
                break;
            }
            char cM4666c = c1067x9.m4666c();
            c1067x9.f3195d++;
            int iMo777c = mo777c(cM4666c, sb);
            int iM4664a = c1067x9.m4664a() + ((sb.length() / 3) << 1);
            c1067x9.m4680q(iM4664a);
            int iM4425a = c1067x9.m4670g().m4425a() - iM4664a;
            if (!c1067x9.m4672i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && iM4425a != 2) {
                    iMo777c = m851b(c1067x9, sb, sb2, iMo777c);
                }
                while (sb.length() % 3 == 1 && (iMo777c > 3 || iM4425a != 1)) {
                    iMo777c = m851b(c1067x9, sb, sb2, iMo777c);
                }
            } else if (sb.length() % 3 == 0 && AbstractC2105nd.m8757n(c1067x9.m4667d(), c1067x9.f3195d, mo778e()) != mo778e()) {
                c1067x9.m4678o(0);
                break;
            }
        }
        mo779f(c1067x9, sb);
    }

    public final int m851b(C1067X9 c1067x9, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        c1067x9.f3195d--;
        int iMo777c = mo777c(c1067x9.m4666c(), sb2);
        c1067x9.m4674k();
        return iMo777c;
    }

    public int mo777c(char c, StringBuilder sb) {
        int i;
        int i2;
        char c2;
        if (c == ' ') {
            c2 = 3;
        } else {
            if (c >= '0' && c <= '9') {
                i2 = c - ',';
            } else {
                if (c < 'A' || c > 'Z') {
                    if (c < ' ') {
                        sb.append((char) 0);
                    } else {
                        if (c <= '/') {
                            sb.append((char) 1);
                            i = c - '!';
                        } else if (c <= '@') {
                            sb.append((char) 1);
                            i = c - '+';
                        } else if (c <= '_') {
                            sb.append((char) 1);
                            i = c - 'E';
                        } else {
                            if (c > 127) {
                                sb.append("\u0001\u001e");
                                return mo777c((char) (c - 128), sb) + 2;
                            }
                            sb.append((char) 2);
                            i = c - '`';
                        }
                        c = (char) i;
                    }
                    sb.append(c);
                    return 2;
                }
                i2 = c - '3';
            }
            c2 = (char) i2;
        }
        sb.append(c2);
        return 1;
    }

    public int mo778e() {
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo779f(C1067X9 r8, StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 3
            int r0 = r0 / r1
            r2 = 1
            int r0 = r0 << r2
            int r3 = r9.length()
            int r3 = r3 % r1
            int r4 = r8.m4664a()
            int r4 = r4 + r0
            r8.m4680q(r4)
            Vm r0 = r8.m4670g()
            int r0 = r0.m4425a()
            int r0 = r0 - r4
            r4 = 2
            r5 = 0
            r6 = 254(0xfe, float:3.56E-43)
            if (r3 != r4) goto L3b
            r9.append(r5)
        L27:
            int r0 = r9.length()
            if (r0 < r1) goto L31
            m850g(r8, r9)
            goto L27
        L31:
            boolean r9 = r8.m4672i()
            if (r9 == 0) goto L6d
        L37:
            r8.m4681r(r6)
            goto L6d
        L3b:
            if (r0 != r2) goto L58
            if (r3 != r2) goto L58
        L3f:
            int r0 = r9.length()
            if (r0 < r1) goto L49
            m850g(r8, r9)
            goto L3f
        L49:
            boolean r9 = r8.m4672i()
            if (r9 == 0) goto L52
            r8.m4681r(r6)
        L52:
            int r9 = r8.f3195d
            int r9 = r9 - r2
            r8.f3195d = r9
            goto L6d
        L58:
            if (r3 != 0) goto L71
        L5a:
            int r2 = r9.length()
            if (r2 < r1) goto L64
            m850g(r8, r9)
            goto L5a
        L64:
            if (r0 > 0) goto L37
            boolean r9 = r8.m4672i()
            if (r9 == 0) goto L6d
            goto L37
        L6d:
            r8.m4678o(r5)
            return
        L71:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Unexpected case. Please report!"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0188E3.mo779f(X9, java.lang.StringBuilder):void");
    }
}
