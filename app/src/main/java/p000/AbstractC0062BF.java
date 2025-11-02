package p000;

public abstract class AbstractC0062BF {
    public static String m229a(AbstractC2233qB abstractC2233qB) {
        String str;
        C2651zF c2651zF = new C2651zF(abstractC2233qB);
        StringBuilder sb = new StringBuilder(c2651zF.mo1215a());
        for (int i = 0; i < c2651zF.mo1215a(); i++) {
            int iMo1216e = c2651zF.mo1216e(i);
            if (iMo1216e == 34) {
                str = "\\\"";
            } else if (iMo1216e == 39) {
                str = "\\'";
            } else if (iMo1216e != 92) {
                switch (iMo1216e) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (iMo1216e < 32 || iMo1216e > 126) {
                            sb.append('\\');
                            sb.append((char) (((iMo1216e >>> 6) & 3) + 48));
                            sb.append((char) (((iMo1216e >>> 3) & 7) + 48));
                            iMo1216e = (iMo1216e & 7) + 48;
                        }
                        sb.append((char) iMo1216e);
                        continue;
                        break;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
