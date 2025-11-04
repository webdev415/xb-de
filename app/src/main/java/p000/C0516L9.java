package p000;

public final class C0516L9 implements InterfaceC0929U9 {
    public static void m2643b(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            AbstractC2105nd.m8748e(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    private static String m2644c(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(0) << 18) + ((length >= 2 ? charSequence.charAt(1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(3) : (char) 0);
        char c = (char) ((iCharAt >> 16) & 255);
        char c2 = (char) ((iCharAt >> 8) & 255);
        char c3 = (char) (iCharAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        if (length >= 2) {
            sb.append(c2);
        }
        if (length >= 3) {
            sb.append(c3);
        }
        return sb.toString();
    }

    public static void m2645e(C1067X9 c1067x9, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                c1067x9.m4679p();
                int iM4425a = c1067x9.m4670g().m4425a() - c1067x9.m4664a();
                int iM4669f = c1067x9.m4669f();
                if (iM4669f > iM4425a) {
                    c1067x9.m4680q(c1067x9.m4664a() + 1);
                    iM4425a = c1067x9.m4670g().m4425a() - c1067x9.m4664a();
                }
                if (iM4669f <= iM4425a && iM4425a <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i = length - 1;
            String strM2644c = m2644c(charSequence);
            if (!(!c1067x9.m4672i()) || i > 2) {
                z = false;
            }
            if (i <= 2) {
                c1067x9.m4680q(c1067x9.m4664a() + i);
                if (c1067x9.m4670g().m4425a() - c1067x9.m4664a() >= 3) {
                    c1067x9.m4680q(c1067x9.m4664a() + strM2644c.length());
                    z = false;
                }
            }
            if (z) {
                c1067x9.m4674k();
                c1067x9.f3195d -= i;
            } else {
                c1067x9.m4682s(strM2644c);
            }
        } finally {
            c1067x9.m4678o(0);
        }
    }

    @Override
    public void mo776a(C1067X9 c1067x9) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c1067x9.m4672i()) {
                break;
            }
            m2643b(c1067x9.m4666c(), sb);
            c1067x9.f3195d++;
            if (sb.length() >= 4) {
                c1067x9.m4682s(m2644c(sb));
                sb.delete(0, 4);
                if (AbstractC2105nd.m8757n(c1067x9.m4667d(), c1067x9.f3195d, m2646d()) != m2646d()) {
                    c1067x9.m4678o(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        m2645e(c1067x9, sb);
    }

    public int m2646d() {
        return 4;
    }
}
