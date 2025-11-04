package p000;

import java.nio.charset.StandardCharsets;

public final class C1067X9 {

    public final String f3192a;

    public EnumC1043Wm f3193b;

    public final StringBuilder f3194c;

    public int f3195d;

    public int f3196e;

    public C0997Vm f3197f;

    public int f3198g;

    public C1067X9(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & 255);
            if (c == '?' && str.charAt(i) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c);
        }
        this.f3192a = sb.toString();
        this.f3193b = EnumC1043Wm.FORCE_NONE;
        this.f3194c = new StringBuilder(str.length());
        this.f3196e = -1;
    }

    public int m4664a() {
        return this.f3194c.length();
    }

    public StringBuilder m4665b() {
        return this.f3194c;
    }

    public char m4666c() {
        return this.f3192a.charAt(this.f3195d);
    }

    public String m4667d() {
        return this.f3192a;
    }

    public int m4668e() {
        return this.f3196e;
    }

    public int m4669f() {
        return m4671h() - this.f3195d;
    }

    public C0997Vm m4670g() {
        return this.f3197f;
    }

    public final int m4671h() {
        return this.f3192a.length() - this.f3198g;
    }

    public boolean m4672i() {
        return this.f3195d < m4671h();
    }

    public void m4673j() {
        this.f3196e = -1;
    }

    public void m4674k() {
        this.f3197f = null;
    }

    public void m4676m(int i) {
        this.f3198g = i;
    }

    public void m4677n(EnumC1043Wm enumC1043Wm) {
        this.f3193b = enumC1043Wm;
    }

    public void m4678o(int i) {
        this.f3196e = i;
    }

    public void m4679p() {
        m4680q(m4664a());
    }

    public void m4680q(int i) {
        C0997Vm c0997Vm = this.f3197f;
        if (c0997Vm == null || i > c0997Vm.m4425a()) {
            this.f3197f = C0997Vm.m4424l(i, this.f3193b, null, null, true);
        }
    }

    public void m4681r(char c) {
        this.f3194c.append(c);
    }

    public void m4682s(String str) {
        this.f3194c.append(str);
    }

    public void m4675l(AbstractC0882T8 abstractC0882T8, AbstractC0882T8 abstractC0882T82) {
    }
}
