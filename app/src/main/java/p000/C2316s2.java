package p000;

/* loaded from: classes.dex */
public final class C2316s2 implements InterfaceC0929U9 {
    public static char m9470c(char c, int i) {
        int i2 = c + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 - 256);
    }

    @Override
    public void mo776a(C1067X9 c1067x9) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!c1067x9.m4672i()) {
                break;
            }
            sb.append(c1067x9.m4666c());
            c1067x9.f3195d++;
            if (AbstractC2105nd.m8757n(c1067x9.m4667d(), c1067x9.f3195d, m9471b()) != m9471b()) {
                c1067x9.m4678o(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int iM4664a = c1067x9.m4664a() + length + 1;
        c1067x9.m4680q(iM4664a);
        boolean z = c1067x9.m4670g().m4425a() - iM4664a > 0;
        if (c1067x9.m4672i() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            c1067x9.m4681r(m9470c(sb.charAt(i), c1067x9.m4664a() + 1));
        }
    }

    public int m9471b() {
        return 5;
    }
}
