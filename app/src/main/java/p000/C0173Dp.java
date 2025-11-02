package p000;

/* loaded from: classes.dex */
public final class C0173Dp extends C0188E3 {
    @Override
    public void mo776a(C1067X9 c1067x9) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c1067x9.m4672i()) {
                break;
            }
            char cM4666c = c1067x9.m4666c();
            c1067x9.f3195d++;
            mo777c(cM4666c, sb);
            if (sb.length() % 3 == 0) {
                C0188E3.m850g(c1067x9, sb);
                if (AbstractC2105nd.m8757n(c1067x9.m4667d(), c1067x9.f3195d, mo778e()) != mo778e()) {
                    c1067x9.m4678o(0);
                    break;
                }
            }
        }
        mo779f(c1067x9, sb);
    }

    @Override
    public int mo777c(char c, StringBuilder sb) {
        char c2;
        int i;
        if (c == '\r') {
            c2 = 0;
        } else {
            if (c != ' ') {
                if (c == '*') {
                    sb.append((char) 1);
                } else if (c != '>') {
                    if (c >= '0' && c <= '9') {
                        i = c - ',';
                    } else if (c < 'A' || c > 'Z') {
                        AbstractC2105nd.m8748e(c);
                    } else {
                        i = c - '3';
                    }
                    c2 = (char) i;
                } else {
                    c2 = 2;
                }
                return 1;
            }
            c2 = 3;
        }
        sb.append(c2);
        return 1;
    }

    @Override
    public int mo778e() {
        return 3;
    }

    @Override
    public void mo779f(C1067X9 c1067x9, StringBuilder sb) {
        c1067x9.m4679p();
        int iM4425a = c1067x9.m4670g().m4425a() - c1067x9.m4664a();
        c1067x9.f3195d -= sb.length();
        if (c1067x9.m4669f() > 1 || iM4425a > 1 || c1067x9.m4669f() != iM4425a) {
            c1067x9.m4681r((char) 254);
        }
        if (c1067x9.m4668e() < 0) {
            c1067x9.m4678o(0);
        }
    }
}
