package p000;

/* loaded from: classes.dex */
public final class C2036m implements InterfaceC0929U9 {
    public static char m8429b(char c, char c2) {
        if (AbstractC2105nd.m8749f(c) && AbstractC2105nd.m8749f(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }

    @Override
    public void mo776a(C1067X9 c1067x9) {
        if (AbstractC2105nd.m8744a(c1067x9.m4667d(), c1067x9.f3195d) >= 2) {
            c1067x9.m4681r(m8429b(c1067x9.m4667d().charAt(c1067x9.f3195d), c1067x9.m4667d().charAt(c1067x9.f3195d + 1)));
            c1067x9.f3195d += 2;
            return;
        }
        char cM4666c = c1067x9.m4666c();
        int iM8757n = AbstractC2105nd.m8757n(c1067x9.m4667d(), c1067x9.f3195d, m8430c());
        if (iM8757n == m8430c()) {
            if (!AbstractC2105nd.m8750g(cM4666c)) {
                c1067x9.m4681r((char) (cM4666c + 1));
                c1067x9.f3195d++;
                return;
            } else {
                c1067x9.m4681r((char) 235);
                c1067x9.m4681r((char) (cM4666c - 127));
                c1067x9.f3195d++;
                return;
            }
        }
        if (iM8757n == 1) {
            c1067x9.m4681r((char) 230);
            c1067x9.m4678o(1);
            return;
        }
        if (iM8757n == 2) {
            c1067x9.m4681r((char) 239);
            c1067x9.m4678o(2);
            return;
        }
        if (iM8757n == 3) {
            c1067x9.m4681r((char) 238);
            c1067x9.m4678o(3);
        } else if (iM8757n == 4) {
            c1067x9.m4681r((char) 240);
            c1067x9.m4678o(4);
        } else {
            if (iM8757n != 5) {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(iM8757n)));
            }
            c1067x9.m4681r((char) 231);
            c1067x9.m4678o(5);
        }
    }

    public int m8430c() {
        return 0;
    }
}
