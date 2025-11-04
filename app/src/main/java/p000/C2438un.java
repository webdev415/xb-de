package p000;

public final class C2438un extends C0188E3 {
    @Override
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
                if (c < 'a' || c > 'z') {
                    if (c < ' ') {
                        sb.append((char) 0);
                    } else {
                        if (c <= '/') {
                            sb.append((char) 1);
                            i = c - '!';
                        } else if (c <= '@') {
                            sb.append((char) 1);
                            i = c - '+';
                        } else if (c >= '[' && c <= '_') {
                            sb.append((char) 1);
                            i = c - 'E';
                        } else if (c == '`') {
                            sb.append((char) 2);
                            i = c - '`';
                        } else if (c <= 'Z') {
                            sb.append((char) 2);
                            i = c - '@';
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
                i2 = c - 'S';
            }
            c2 = (char) i2;
        }
        sb.append(c2);
        return 1;
    }

    @Override
    public int mo778e() {
        return 2;
    }
}
