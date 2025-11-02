package p000;

/* loaded from: classes.dex */
public final class C2565xc {

    public final C0233F2 f7973a;

    public final C1064X6 f7974b = new C1064X6();

    public final StringBuilder f7975c = new StringBuilder();

    public C2565xc(C0233F2 c0233f2) {
        this.f7973a = c0233f2;
    }

    public static int m10658g(C0233F2 c0233f2, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (c0233f2.m1189h(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public String m10659a(StringBuilder sb, int i) throws C2340sh {
        String str = null;
        while (true) {
            C0284G7 c0284g7M10661c = m10661c(i, str);
            String strM3392a = AbstractC0664Oa.m3392a(c0284g7M10661c.m1355b());
            if (strM3392a != null) {
                sb.append(strM3392a);
            }
            String strValueOf = c0284g7M10661c.m1357d() ? String.valueOf(c0284g7M10661c.m1356c()) : null;
            if (i == c0284g7M10661c.m1677a()) {
                return sb.toString();
            }
            i = c0284g7M10661c.m1677a();
            str = strValueOf;
        }
    }

    public final C0238F7 m10660b(int i) {
        char c;
        int iM10664f = m10664f(i, 5);
        if (iM10664f == 15) {
            return new C0238F7(i + 5, '$');
        }
        if (iM10664f >= 5 && iM10664f < 15) {
            return new C0238F7(i + 5, (char) (iM10664f + 43));
        }
        int iM10664f2 = m10664f(i, 6);
        if (iM10664f2 >= 32 && iM10664f2 < 58) {
            return new C0238F7(i + 6, (char) (iM10664f2 + 33));
        }
        switch (iM10664f2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iM10664f2)));
        }
        return new C0238F7(i + 6, c);
    }

    public C0284G7 m10661c(int i, String str) {
        this.f7975c.setLength(0);
        if (str != null) {
            this.f7975c.append(str);
        }
        this.f7974b.m4658h(i);
        C0284G7 c0284g7M10672o = m10672o();
        return (c0284g7M10672o == null || !c0284g7M10672o.m1357d()) ? new C0284G7(this.f7974b.m4651a(), this.f7975c.toString()) : new C0284G7(this.f7974b.m4651a(), this.f7975c.toString(), c0284g7M10672o.m1356c());
    }

    public final C0238F7 m10662d(int i) throws C2610yb {
        int iM10664f = m10664f(i, 5);
        if (iM10664f == 15) {
            return new C0238F7(i + 5, '$');
        }
        char c = '+';
        if (iM10664f >= 5 && iM10664f < 15) {
            return new C0238F7(i + 5, (char) (iM10664f + 43));
        }
        int iM10664f2 = m10664f(i, 7);
        if (iM10664f2 >= 64 && iM10664f2 < 90) {
            return new C0238F7(i + 7, (char) (iM10664f2 + 1));
        }
        if (iM10664f2 >= 90 && iM10664f2 < 116) {
            return new C0238F7(i + 7, (char) (iM10664f2 + 7));
        }
        switch (m10664f(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw C2610yb.m10853a();
        }
        return new C0238F7(i + 8, c);
    }

    public final C0330H7 m10663e(int i) {
        int i2 = i + 7;
        if (i2 > this.f7973a.m1193o()) {
            int iM10664f = m10664f(i, 4);
            return iM10664f == 0 ? new C0330H7(this.f7973a.m1193o(), 10, 10) : new C0330H7(this.f7973a.m1193o(), iM10664f - 1, 10);
        }
        int iM10664f2 = m10664f(i, 7) - 8;
        return new C0330H7(i2, iM10664f2 / 11, iM10664f2 % 11);
    }

    public int m10664f(int i, int i2) {
        return m10658g(this.f7973a, i, i2);
    }

    public final boolean m10665h(int i) {
        int i2 = i + 3;
        if (i2 > this.f7973a.m1193o()) {
            return false;
        }
        while (i < i2) {
            if (this.f7973a.m1189h(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean m10666i(int i) {
        int i2;
        if (i + 1 > this.f7973a.m1193o()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.f7973a.m1193o(); i3++) {
            if (i3 == 2) {
                if (!this.f7973a.m1189h(i + 2)) {
                    return false;
                }
            } else if (this.f7973a.m1189h(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean m10667j(int i) {
        int i2;
        if (i + 1 > this.f7973a.m1193o()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.f7973a.m1193o(); i3++) {
            if (this.f7973a.m1189h(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean m10668k(int i) {
        int iM10664f;
        if (i + 5 > this.f7973a.m1193o()) {
            return false;
        }
        int iM10664f2 = m10664f(i, 5);
        if (iM10664f2 < 5 || iM10664f2 >= 16) {
            return i + 6 <= this.f7973a.m1193o() && (iM10664f = m10664f(i, 6)) >= 16 && iM10664f < 63;
        }
        return true;
    }

    public final boolean m10669l(int i) {
        int iM10664f;
        if (i + 5 > this.f7973a.m1193o()) {
            return false;
        }
        int iM10664f2 = m10664f(i, 5);
        if (iM10664f2 >= 5 && iM10664f2 < 16) {
            return true;
        }
        if (i + 7 > this.f7973a.m1193o()) {
            return false;
        }
        int iM10664f3 = m10664f(i, 7);
        if (iM10664f3 < 64 || iM10664f3 >= 116) {
            return i + 8 <= this.f7973a.m1193o() && (iM10664f = m10664f(i, 8)) >= 232 && iM10664f < 253;
        }
        return true;
    }

    public final boolean m10670m(int i) {
        if (i + 7 > this.f7973a.m1193o()) {
            return i + 4 <= this.f7973a.m1193o();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.f7973a.m1189h(i3);
            }
            if (this.f7973a.m1189h(i2)) {
                return true;
            }
            i2++;
        }
    }

    public final C0601N2 m10671n() {
        while (m10668k(this.f7974b.m4651a())) {
            C0238F7 c0238f7M10660b = m10660b(this.f7974b.m4651a());
            this.f7974b.m4658h(c0238f7M10660b.m1677a());
            if (c0238f7M10660b.m1212c()) {
                return new C0601N2(new C0284G7(this.f7974b.m4651a(), this.f7975c.toString()), true);
            }
            this.f7975c.append(c0238f7M10660b.m1211b());
        }
        if (m10665h(this.f7974b.m4651a())) {
            this.f7974b.m4652b(3);
            this.f7974b.m4657g();
        } else if (m10666i(this.f7974b.m4651a())) {
            if (this.f7974b.m4651a() + 5 < this.f7973a.m1193o()) {
                this.f7974b.m4652b(5);
            } else {
                this.f7974b.m4658h(this.f7973a.m1193o());
            }
            this.f7974b.m4656f();
        }
        return new C0601N2(false);
    }

    public final C0284G7 m10672o() {
        C0601N2 c0601n2M10671n;
        boolean zM3279b;
        do {
            int iM4651a = this.f7974b.m4651a();
            c0601n2M10671n = this.f7974b.m4653c() ? m10671n() : this.f7974b.m4654d() ? m10673p() : m10674q();
            zM3279b = c0601n2M10671n.m3279b();
            if (iM4651a == this.f7974b.m4651a() && !zM3279b) {
                break;
            }
        } while (!zM3279b);
        return c0601n2M10671n.m3278a();
    }

    public final C0601N2 m10673p() throws C2610yb {
        while (m10669l(this.f7974b.m4651a())) {
            C0238F7 c0238f7M10662d = m10662d(this.f7974b.m4651a());
            this.f7974b.m4658h(c0238f7M10662d.m1677a());
            if (c0238f7M10662d.m1212c()) {
                return new C0601N2(new C0284G7(this.f7974b.m4651a(), this.f7975c.toString()), true);
            }
            this.f7975c.append(c0238f7M10662d.m1211b());
        }
        if (m10665h(this.f7974b.m4651a())) {
            this.f7974b.m4652b(3);
            this.f7974b.m4657g();
        } else if (m10666i(this.f7974b.m4651a())) {
            if (this.f7974b.m4651a() + 5 < this.f7973a.m1193o()) {
                this.f7974b.m4652b(5);
            } else {
                this.f7974b.m4658h(this.f7973a.m1193o());
            }
            this.f7974b.m4655e();
        }
        return new C0601N2(false);
    }

    public final C0601N2 m10674q() {
        while (m10670m(this.f7974b.m4651a())) {
            C0330H7 c0330h7M10663e = m10663e(this.f7974b.m4651a());
            this.f7974b.m4658h(c0330h7M10663e.m1677a());
            if (c0330h7M10663e.m1514d()) {
                return new C0601N2(c0330h7M10663e.m1515e() ? new C0284G7(this.f7974b.m4651a(), this.f7975c.toString()) : new C0284G7(this.f7974b.m4651a(), this.f7975c.toString(), c0330h7M10663e.m1513c()), true);
            }
            this.f7975c.append(c0330h7M10663e.m1512b());
            if (c0330h7M10663e.m1515e()) {
                return new C0601N2(new C0284G7(this.f7974b.m4651a(), this.f7975c.toString()), true);
            }
            this.f7975c.append(c0330h7M10663e.m1513c());
        }
        if (m10667j(this.f7974b.m4651a())) {
            this.f7974b.m4655e();
            this.f7974b.m4652b(4);
        }
        return new C0601N2(false);
    }
}
