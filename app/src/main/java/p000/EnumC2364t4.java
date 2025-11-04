package p000;

import java.util.HashMap;
import java.util.Map;

public enum EnumC2364t4 {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");


    public static final Map f7162O = new HashMap<>();

    public static final Map f7163P = new HashMap<>();

    public final int[] f7178l;

    public final String[] f7179m;

    static {
        for (EnumC2364t4 enumC2364t4 : values()) {
            for (int i : enumC2364t4.f7178l) {
                f7162O.put(Integer.valueOf(i), enumC2364t4);
            }
            f7163P.put(enumC2364t4.name(), enumC2364t4);
            for (String str : enumC2364t4.f7179m) {
                f7163P.put(str, enumC2364t4);
            }
        }
    }

    EnumC2364t4(int i) {
        this(new int[]{i}, new String[0]);
    }

    public static EnumC2364t4 m9677c(String str) {
        return (EnumC2364t4) f7163P.get(str);
    }

    public static EnumC2364t4 m9678e(int i) throws C2610yb {
        if (i < 0 || i >= 900) {
            throw C2610yb.m10853a();
        }
        return (EnumC2364t4) f7162O.get(Integer.valueOf(i));
    }

    public int m9679g() {
        return this.f7178l[0];
    }

    EnumC2364t4(int i, String... strArr) {
        this.f7178l = new int[]{i};
        this.f7179m = strArr;
    }

    EnumC2364t4(int[] iArr, String... strArr) {
        this.f7178l = iArr;
        this.f7179m = strArr;
    }
}
