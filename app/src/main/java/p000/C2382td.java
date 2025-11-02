package p000;

/* loaded from: classes.dex */
public final class C2382td {

    public static final String[] f7220d;

    public static final C2382td f7221e = new C2382td();

    public static final C0096C3 f7217a = C0096C3.f235p.m395c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public static final String[] f7218b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    public static final String[] f7219c = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            AbstractC0116Ce.m475d(binaryString, "Integer.toBinaryString(it)");
            strArr[i] = AbstractC0538Lm.m2726r(AbstractC2623yo.m10942q("%8s", binaryString), ' ', '0', false, 4, null);
        }
        f7220d = strArr;
        String[] strArr2 = f7219c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i2 = iArr[0];
        strArr2[i2 | 8] = AbstractC0116Ce.m481j(strArr2[i2], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = f7219c;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + "|" + strArr3[i4];
            strArr3[i6 | 8] = strArr3[i5] + "|" + strArr3[i4] + "|PADDED";
        }
        int length = f7219c.length;
        for (int i7 = 0; i7 < length; i7++) {
            String[] strArr4 = f7219c;
            if (strArr4[i7] == null) {
                strArr4[i7] = f7220d[i7];
            }
        }
    }

    public final String m9703a(int i, int i2) {
        String str;
        int i3;
        Object obj;
        String str2;
        String str3;
        if (i2 == 0) {
            return "";
        }
        if (i != 2 && i != 3) {
            if (i == 4 || i == 6) {
                return i2 == 1 ? "ACK" : f7220d[i2];
            }
            if (i != 7 && i != 8) {
                String[] strArr = f7219c;
                if (i2 < strArr.length) {
                    str = strArr[i2];
                    AbstractC0116Ce.m473b(str);
                } else {
                    str = f7220d[i2];
                }
                String str4 = str;
                if (i == 5 && (i2 & 4) != 0) {
                    i3 = 4;
                    obj = null;
                    str2 = "HEADERS";
                    str3 = "PUSH_PROMISE";
                } else {
                    if (i != 0 || (i2 & 32) == 0) {
                        return str4;
                    }
                    i3 = 4;
                    obj = null;
                    str2 = "PRIORITY";
                    str3 = "COMPRESSED";
                }
                return AbstractC0538Lm.m2727s(str4, str2, str3, false, i3, obj);
            }
        }
        return f7220d[i2];
    }

    public final String m9704b(int i) {
        String[] strArr = f7218b;
        return i < strArr.length ? strArr[i] : AbstractC2623yo.m10942q("0x%02x", Integer.valueOf(i));
    }

    public final String m9705c(boolean z, int i, int i2, int i3, int i4) {
        return AbstractC2623yo.m10942q("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), m9704b(i3), m9703a(i3, i4));
    }
}
