package p000;

public abstract class AbstractC0886TC {
    public static String m4119a(String str, String[] strArr, String[] strArr2) {
        AbstractC1085Xi.m4801j(strArr);
        AbstractC1085Xi.m4801j(strArr2);
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < iMin; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i];
            }
        }
        return null;
    }
}
