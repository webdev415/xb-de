package p000;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class C0470K9 {

    public final List f1549a = new ArrayList<>();

    public final List f1550b = new ArrayList<>();

    public final void m2314a(int[] iArr, String str) {
        this.f1549a.add(iArr);
        this.f1550b.add(str);
    }

    public final synchronized void m2315b() {
        if (this.f1549a.isEmpty()) {
            m2314a(new int[]{0, 19}, "US/CA");
            m2314a(new int[]{30, 39}, "US");
            m2314a(new int[]{60, 139}, "US/CA");
            m2314a(new int[]{300, 379}, "FR");
            m2314a(new int[]{380}, "BG");
            m2314a(new int[]{383}, "SI");
            m2314a(new int[]{385}, "HR");
            m2314a(new int[]{387}, "BA");
            m2314a(new int[]{400, 440}, "DE");
            m2314a(new int[]{450, 459}, "JP");
            m2314a(new int[]{460, 469}, "RU");
            m2314a(new int[]{471}, "TW");
            m2314a(new int[]{474}, "EE");
            m2314a(new int[]{475}, "LV");
            m2314a(new int[]{476}, "AZ");
            m2314a(new int[]{477}, "LT");
            m2314a(new int[]{478}, "UZ");
            m2314a(new int[]{479}, "LK");
            m2314a(new int[]{480}, "PH");
            m2314a(new int[]{481}, "BY");
            m2314a(new int[]{482}, "UA");
            m2314a(new int[]{484}, "MD");
            m2314a(new int[]{485}, "AM");
            m2314a(new int[]{486}, "GE");
            m2314a(new int[]{487}, "KZ");
            m2314a(new int[]{489}, "HK");
            m2314a(new int[]{490, 499}, "JP");
            m2314a(new int[]{500, 509}, "GB");
            m2314a(new int[]{520}, "GR");
            m2314a(new int[]{528}, "LB");
            m2314a(new int[]{529}, "CY");
            m2314a(new int[]{531}, "MK");
            m2314a(new int[]{535}, "MT");
            m2314a(new int[]{539}, "IE");
            m2314a(new int[]{540, 549}, "BE/LU");
            m2314a(new int[]{560}, "PT");
            m2314a(new int[]{569}, "IS");
            m2314a(new int[]{570, 579}, "DK");
            m2314a(new int[]{590}, "PL");
            m2314a(new int[]{594}, "RO");
            m2314a(new int[]{599}, "HU");
            m2314a(new int[]{600, 601}, "ZA");
            m2314a(new int[]{603}, "GH");
            m2314a(new int[]{608}, "BH");
            m2314a(new int[]{609}, "MU");
            m2314a(new int[]{611}, "MA");
            m2314a(new int[]{613}, "DZ");
            m2314a(new int[]{616}, "KE");
            m2314a(new int[]{618}, "CI");
            m2314a(new int[]{619}, "TN");
            m2314a(new int[]{621}, "SY");
            m2314a(new int[]{622}, "EG");
            m2314a(new int[]{624}, "LY");
            m2314a(new int[]{625}, "JO");
            m2314a(new int[]{626}, "IR");
            m2314a(new int[]{627}, "KW");
            m2314a(new int[]{628}, "SA");
            m2314a(new int[]{629}, "AE");
            m2314a(new int[]{640, 649}, "FI");
            m2314a(new int[]{690, 695}, "CN");
            m2314a(new int[]{700, 709}, "NO");
            m2314a(new int[]{729}, "IL");
            m2314a(new int[]{730, 739}, "SE");
            m2314a(new int[]{740}, "GT");
            m2314a(new int[]{741}, "SV");
            m2314a(new int[]{742}, "HN");
            m2314a(new int[]{743}, "NI");
            m2314a(new int[]{744}, "CR");
            m2314a(new int[]{745}, "PA");
            m2314a(new int[]{746}, "DO");
            m2314a(new int[]{750}, "MX");
            m2314a(new int[]{754, 755}, "CA");
            m2314a(new int[]{759}, "VE");
            m2314a(new int[]{760, 769}, "CH");
            m2314a(new int[]{770}, "CO");
            m2314a(new int[]{773}, "UY");
            m2314a(new int[]{775}, "PE");
            m2314a(new int[]{777}, "BO");
            m2314a(new int[]{779}, "AR");
            m2314a(new int[]{780}, "CL");
            m2314a(new int[]{784}, "PY");
            m2314a(new int[]{785}, "PE");
            m2314a(new int[]{786}, "EC");
            m2314a(new int[]{789, 790}, "BR");
            m2314a(new int[]{800, 839}, "IT");
            m2314a(new int[]{840, 849}, "ES");
            m2314a(new int[]{850}, "CU");
            m2314a(new int[]{858}, "SK");
            m2314a(new int[]{859}, "CZ");
            m2314a(new int[]{860}, "YU");
            m2314a(new int[]{865}, "MN");
            m2314a(new int[]{867}, "KP");
            m2314a(new int[]{868, 869}, "TR");
            m2314a(new int[]{870, 879}, "NL");
            m2314a(new int[]{880}, "KR");
            m2314a(new int[]{885}, "TH");
            m2314a(new int[]{888}, "SG");
            m2314a(new int[]{890}, "IN");
            m2314a(new int[]{893}, "VN");
            m2314a(new int[]{896}, "PK");
            m2314a(new int[]{899}, "ID");
            m2314a(new int[]{900, 919}, "AT");
            m2314a(new int[]{930, 939}, "AU");
            m2314a(new int[]{940, 949}, "AZ");
            m2314a(new int[]{955}, "MY");
            m2314a(new int[]{958}, "MO");
        }
    }

    public String m2316c(String str) throws NumberFormatException {
        int[] iArr;
        int i;
        m2315b();
        int i2 = Integer.parseInt(str.substring(0, 3));
        int size = this.f1549a.size();
        for (int i3 = 0; i3 < size && i2 >= (i = (iArr = (int[]) this.f1549a.get(i3))[0]); i3++) {
            if (iArr.length != 1) {
                i = iArr[1];
            }
            if (i2 <= i) {
                return (String) this.f1550b.get(i3);
            }
        }
        return null;
    }
}
