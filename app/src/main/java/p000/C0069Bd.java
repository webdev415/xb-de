package p000;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class C0069Bd {

    public final boolean f159a;

    public final String f160b;

    public final String f161c;

    public final String f162d;

    public final String f163e;

    public final int f164f;

    public final List f165g;

    public final List f166h;

    public final String f167i;

    public final String f168j;

    public static final b f158l = new b(null);

    public static final char[] f157k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final class a {

        public static final C2682a f169i = new C2682a(null);

        public String f170a;

        public String f173d;

        public final List f175f;

        public List f176g;

        public String f177h;

        public String f171b = "";

        public String f172c = "";

        public int f174e = -1;

        public static final class C2682a {
            public C2682a() {
            }

            public final int m286e(String str, int i, int i2) throws NumberFormatException {
                try {
                    int i3 = Integer.parseInt(b.m290b(C0069Bd.f158l, str, i, i2, "", false, false, false, false, null, 248, null));
                    if (1 <= i3 && 65535 >= i3) {
                        return i3;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            public final int m287f(String str, int i, int i2) {
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == ':') {
                        return i;
                    }
                    if (cCharAt == '[') {
                        do {
                            i++;
                            if (i < i2) {
                            }
                        } while (str.charAt(i) != ']');
                    }
                    i++;
                }
                return i2;
            }

            public final int m288g(String str, int i, int i2) {
                if (i2 - i < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i);
                if ((AbstractC0116Ce.m477f(cCharAt, 97) < 0 || AbstractC0116Ce.m477f(cCharAt, ModuleDescriptor.MODULE_VERSION) > 0) && (AbstractC0116Ce.m477f(cCharAt, 65) < 0 || AbstractC0116Ce.m477f(cCharAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i++;
                    if (i >= i2) {
                        return -1;
                    }
                    char cCharAt2 = str.charAt(i);
                    if ('a' > cCharAt2 || 'z' < cCharAt2) {
                        if ('A' > cCharAt2 || 'Z' < cCharAt2) {
                            if ('0' > cCharAt2 || '9' < cCharAt2) {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            public final int m289h(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }

            public C2682a(AbstractC0881T7 abstractC0881T7) {
                this();
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList<>();
            this.f175f = arrayList;
            arrayList.add("");
        }

        public final C0069Bd m260a() {
            ArrayList arrayList;
            String str = this.f170a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            b bVar = C0069Bd.f158l;
            String strM291g = b.m291g(bVar, this.f171b, 0, 0, false, 7, null);
            String strM291g2 = b.m291g(bVar, this.f172c, 0, 0, false, 7, null);
            String str2 = this.f173d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iM261b = m261b();
            List list = this.f175f;
            ArrayList arrayList2 = new ArrayList<>(AbstractC1857i5.m7866n(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(b.m291g(C0069Bd.f158l, (String) it.next(), 0, 0, false, 7, null));
            }
            List list2 = this.f176g;
            if (list2 != null) {
                List<String> list3 = list2;
                arrayList = new ArrayList<>(AbstractC1857i5.m7866n(list3, 10));
                for (String str3 : list3) {
                    arrayList.add(str3 != null ? b.m291g(C0069Bd.f158l, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.f177h;
            return new C0069Bd(str, strM291g, strM291g2, str2, iM261b, arrayList2, arrayList, str4 != null ? b.m291g(C0069Bd.f158l, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final int m261b() {
            int i = this.f174e;
            if (i != -1) {
                return i;
            }
            b bVar = C0069Bd.f158l;
            String str = this.f170a;
            AbstractC0116Ce.m473b(str);
            return bVar.m293c(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final a m262c(String r14) {
            /*
                r13 = this;
                if (r14 == 0) goto L1d
                Bd$b r12 = p000.C0069Bd.f158l
                r10 = 211(0xd3, float:2.96E-43)
                r11 = 0
                r2 = 0
                r3 = 0
                java.lang.String r4 = " \"'<>#"
                r5 = 1
                r6 = 0
                r7 = 1
                r8 = 0
                r9 = 0
                r0 = r12
                r1 = r14
                java.lang.String r14 = p000.C0069Bd.b.m290b(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r14 == 0) goto L1d
                java.util.List r14 = r12.m298i(r14)
                goto L1e
            L1d:
                r14 = 0
            L1e:
                r13.f176g = r14
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0069Bd.a.m262c(java.lang.String):Bd$a");
        }

        public final List m263d() {
            return this.f175f;
        }

        public final a m264e(String str) {
            AbstractC0116Ce.m476e(str, "host");
            String strM9063e = AbstractC2198pd.m9063e(b.m291g(C0069Bd.f158l, str, 0, 0, false, 7, null));
            if (strM9063e != null) {
                this.f173d = strM9063e;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final boolean m265f(String str) {
            return AbstractC0116Ce.m472a(str, ".") || AbstractC0538Lm.m2720l(str, "%2e", true);
        }

        public final boolean m266g(String str) {
            return AbstractC0116Ce.m472a(str, "..") || AbstractC0538Lm.m2720l(str, "%2e.", true) || AbstractC0538Lm.m2720l(str, ".%2e", true) || AbstractC0538Lm.m2720l(str, "%2e%2e", true);
        }

        public final a m267h(C0069Bd c0069Bd, String str) throws NumberFormatException {
            int iM10939n;
            int i;
            int i2;
            boolean z;
            int i3;
            String str2;
            int i4;
            boolean z2;
            boolean z3;
            AbstractC0116Ce.m476e(str, "input");
            int iM10949x = AbstractC2623yo.m10949x(str, 0, 0, 3, null);
            int iM10951z = AbstractC2623yo.m10951z(str, iM10949x, 0, 2, null);
            C2682a c2682a = f169i;
            int iM288g = c2682a.m288g(str, iM10949x, iM10951z);
            String str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            boolean z4 = true;
            char c = 65535;
            if (iM288g != -1) {
                if (AbstractC0538Lm.m2728t(str, "https:", iM10949x, true)) {
                    this.f170a = "https";
                    iM10949x += 6;
                } else {
                    if (!AbstractC0538Lm.m2728t(str, "http:", iM10949x, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str.substring(0, iM288g);
                        AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f170a = "http";
                    iM10949x += 5;
                }
            } else {
                if (c0069Bd == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f170a = c0069Bd.m257p();
            }
            int iM289h = c2682a.m289h(str, iM10949x, iM10951z);
            char c2 = '?';
            char c3 = '#';
            if (iM289h >= 2 || c0069Bd == null || (!AbstractC0116Ce.m472a(c0069Bd.m257p(), this.f170a))) {
                int i5 = iM10949x + iM289h;
                boolean z5 = false;
                boolean z6 = false;
                while (true) {
                    iM10939n = AbstractC2623yo.m10939n(str, "@/\\?#", i5, iM10951z);
                    char cCharAt = iM10939n != iM10951z ? str.charAt(iM10939n) : c;
                    if (cCharAt == c || cCharAt == c3 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c2) {
                        break;
                    }
                    if (cCharAt != '@') {
                        z = z4;
                        i3 = iM10951z;
                        str2 = str3;
                    } else {
                        if (z5) {
                            z = z4;
                            i3 = iM10951z;
                            str2 = str3;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.f172c);
                            sb2.append("%40");
                            i4 = iM10939n;
                            sb2.append(b.m290b(C0069Bd.f158l, str, i5, iM10939n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.f172c = sb2.toString();
                            z2 = z6;
                        } else {
                            int iM10938m = AbstractC2623yo.m10938m(str, ':', i5, iM10939n);
                            b bVar = C0069Bd.f158l;
                            z = z4;
                            i3 = iM10951z;
                            str2 = str3;
                            String strM290b = b.m290b(bVar, str, i5, iM10938m, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z6) {
                                strM290b = this.f171b + "%40" + strM290b;
                            }
                            this.f171b = strM290b;
                            i4 = iM10939n;
                            if (iM10938m != i4) {
                                this.f172c = b.m290b(bVar, str, iM10938m + 1, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z3 = z;
                            } else {
                                z3 = z5;
                            }
                            z5 = z3;
                            z2 = z;
                        }
                        i5 = i4 + 1;
                        z6 = z2;
                    }
                    str3 = str2;
                    iM10951z = i3;
                    z4 = z;
                    c3 = '#';
                    c2 = '?';
                    c = 65535;
                }
                boolean z7 = z4;
                i = iM10951z;
                String str4 = str3;
                C2682a c2682a2 = f169i;
                int iM287f = c2682a2.m287f(str, i5, iM10939n);
                int i6 = iM287f + 1;
                if (i6 < iM10939n) {
                    i2 = i5;
                    this.f173d = AbstractC2198pd.m9063e(b.m291g(C0069Bd.f158l, str, i5, iM287f, false, 4, null));
                    int iM286e = c2682a2.m286e(str, i6, iM10939n);
                    this.f174e = iM286e;
                    if (!(iM286e != -1 ? z7 : false)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String strSubstring2 = str.substring(i6, iM10939n);
                        AbstractC0116Ce.m475d(strSubstring2, str4);
                        sb3.append(strSubstring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    i2 = i5;
                    b bVar2 = C0069Bd.f158l;
                    this.f173d = AbstractC2198pd.m9063e(b.m291g(bVar2, str, i2, iM287f, false, 4, null));
                    String str5 = this.f170a;
                    AbstractC0116Ce.m473b(str5);
                    this.f174e = bVar2.m293c(str5);
                }
                if (!(this.f173d != null ? z7 : false)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String strSubstring3 = str.substring(i2, iM287f);
                    AbstractC0116Ce.m475d(strSubstring3, str4);
                    sb4.append(strSubstring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                iM10949x = iM10939n;
            } else {
                this.f171b = c0069Bd.m248g();
                this.f172c = c0069Bd.m244c();
                this.f173d = c0069Bd.m249h();
                this.f174e = c0069Bd.m253l();
                this.f175f.clear();
                this.f175f.addAll(c0069Bd.m246e());
                if (iM10949x == iM10951z || str.charAt(iM10949x) == '#') {
                    m262c(c0069Bd.m247f());
                }
                i = iM10951z;
            }
            int i7 = i;
            int iM10939n2 = AbstractC2623yo.m10939n(str, "?#", iM10949x, i7);
            m273n(str, iM10949x, iM10939n2);
            if (iM10939n2 < i7 && str.charAt(iM10939n2) == '?') {
                int iM10938m2 = AbstractC2623yo.m10938m(str, '#', iM10939n2, i7);
                b bVar3 = C0069Bd.f158l;
                this.f176g = bVar3.m298i(b.m290b(bVar3, str, iM10939n2 + 1, iM10938m2, " \"'<>#", true, false, true, false, null, 208, null));
                iM10939n2 = iM10938m2;
            }
            if (iM10939n2 < i7 && str.charAt(iM10939n2) == '#') {
                this.f177h = b.m290b(C0069Bd.f158l, str, iM10939n2 + 1, i7, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final a m268i(String str) {
            AbstractC0116Ce.m476e(str, "password");
            this.f172c = b.m290b(C0069Bd.f158l, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final void m269j() {
            if (((String) this.f175f.remove(r0.size() - 1)).length() != 0 || !(!this.f175f.isEmpty())) {
                this.f175f.add("");
            } else {
                this.f175f.set(r0.size() - 1, "");
            }
        }

        public final a m270k(int i) {
            if (1 <= i && 65535 >= i) {
                this.f174e = i;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i).toString());
        }

        public final void m271l(String str, int i, int i2, boolean z, boolean z2) {
            String strM290b = b.m290b(C0069Bd.f158l, str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, false, null, 240, null);
            if (m265f(strM290b)) {
                return;
            }
            if (m266g(strM290b)) {
                m269j();
                return;
            }
            if (((CharSequence) this.f175f.get(r2.size() - 1)).length() == 0) {
                this.f175f.set(r2.size() - 1, strM290b);
            } else {
                this.f175f.add(strM290b);
            }
            if (z) {
                this.f175f.add("");
            }
        }

        public final a m272m() {
            String str = this.f173d;
            this.f173d = str != null ? new C2389tk("[\"<>^`{|}]").m9729b(str, "") : null;
            int size = this.f175f.size();
            for (int i = 0; i < size; i++) {
                List list = this.f175f;
                list.set(i, b.m290b(C0069Bd.f158l, (String) list.get(i), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List list2 = this.f176g;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = (String) list2.get(i2);
                    list2.set(i2, str2 != null ? b.m290b(C0069Bd.f158l, str2, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.f177h;
            this.f177h = str3 != null ? b.m290b(C0069Bd.f158l, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null) : null;
            return this;
        }

        public final void m273n(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f175f.clear();
                this.f175f.add("");
                i++;
            } else {
                List list = this.f175f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = AbstractC2623yo.m10939n(str, "/\\", i3, i2);
                boolean z = i < i2;
                m271l(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        public final a m274o(String str) {
            AbstractC0116Ce.m476e(str, "scheme");
            String str2 = "http";
            if (!AbstractC0538Lm.m2720l(str, "http", true)) {
                str2 = "https";
                if (!AbstractC0538Lm.m2720l(str, "https", true)) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.f170a = str2;
            return this;
        }

        public final void m275p(String str) {
            this.f177h = str;
        }

        public final void m276q(String str) {
            AbstractC0116Ce.m476e(str, "<set-?>");
            this.f172c = str;
        }

        public final void m277r(String str) {
            AbstractC0116Ce.m476e(str, "<set-?>");
            this.f171b = str;
        }

        public final void m278s(String str) {
            this.f173d = str;
        }

        public final void m279t(int i) {
            this.f174e = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.f170a
                if (r1 == 0) goto L12
                r0.append(r1)
                java.lang.String r1 = "://"
            Le:
                r0.append(r1)
                goto L15
            L12:
                java.lang.String r1 = "//"
                goto Le
            L15:
                java.lang.String r1 = r6.f171b
                int r1 = r1.length()
                r2 = 58
                if (r1 <= 0) goto L20
                goto L28
            L20:
                java.lang.String r1 = r6.f172c
                int r1 = r1.length()
                if (r1 <= 0) goto L42
            L28:
                java.lang.String r1 = r6.f171b
                r0.append(r1)
                java.lang.String r1 = r6.f172c
                int r1 = r1.length()
                if (r1 <= 0) goto L3d
                r0.append(r2)
                java.lang.String r1 = r6.f172c
                r0.append(r1)
            L3d:
                r1 = 64
                r0.append(r1)
            L42:
                java.lang.String r1 = r6.f173d
                if (r1 == 0) goto L67
                p000.AbstractC0116Ce.m473b(r1)
                r3 = 2
                r4 = 0
                r5 = 0
                boolean r1 = p000.AbstractC0584Mm.m2917A(r1, r2, r5, r3, r4)
                if (r1 == 0) goto L62
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.f173d
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L67
            L62:
                java.lang.String r1 = r6.f173d
                r0.append(r1)
            L67:
                int r1 = r6.f174e
                r3 = -1
                if (r1 != r3) goto L70
                java.lang.String r1 = r6.f170a
                if (r1 == 0) goto L89
            L70:
                int r1 = r6.m261b()
                java.lang.String r3 = r6.f170a
                if (r3 == 0) goto L83
                Bd$b r4 = p000.C0069Bd.f158l
                p000.AbstractC0116Ce.m473b(r3)
                int r3 = r4.m293c(r3)
                if (r1 == r3) goto L89
            L83:
                r0.append(r2)
                r0.append(r1)
            L89:
                Bd$b r1 = p000.C0069Bd.f158l
                java.util.List r2 = r6.f175f
                r1.m297h(r2, r0)
                java.util.List r2 = r6.f176g
                if (r2 == 0) goto La1
                r2 = 63
                r0.append(r2)
                java.util.List r2 = r6.f176g
                p000.AbstractC0116Ce.m473b(r2)
                r1.m299j(r2, r0)
            La1:
                java.lang.String r1 = r6.f177h
                if (r1 == 0) goto Laf
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.f177h
                r0.append(r1)
            Laf:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                p000.AbstractC0116Ce.m475d(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0069Bd.a.toString():java.lang.String");
        }

        public final void m280u(String str) {
            this.f170a = str;
        }

        public final a m281v(String str) {
            AbstractC0116Ce.m476e(str, "username");
            this.f171b = b.m290b(C0069Bd.f158l, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }
    }

    public static final class b {
        public b() {
        }

        public static String m290b(b bVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            return bVar.m292a(str, (i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? str.length() : i2, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? false : z4, (i3 & 128) != 0 ? null : charset);
        }

        public static String m291g(b bVar, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return bVar.m296f(str, i, i2, z);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final String m292a(String r14, int r15, int r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, Charset r22) throws java.io.EOFException {
            /*
                r13 = this;
                r2 = r14
                r4 = r16
                r5 = r17
                java.lang.String r0 = "$this$canonicalize"
                p000.AbstractC0116Ce.m476e(r14, r0)
                java.lang.String r0 = "encodeSet"
                p000.AbstractC0116Ce.m476e(r5, r0)
                r3 = r15
            L10:
                if (r3 >= r4) goto L71
                int r0 = r14.codePointAt(r3)
                r1 = 32
                if (r0 < r1) goto L25
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 == r1) goto L25
                r1 = 128(0x80, float:1.8E-43)
                if (r0 < r1) goto L27
                if (r21 == 0) goto L25
                goto L27
            L25:
                r11 = r13
                goto L4f
            L27:
                char r1 = (char) r0
                r6 = 2
                r7 = 0
                r8 = 0
                boolean r1 = p000.AbstractC0584Mm.m2917A(r5, r1, r8, r6, r7)
                if (r1 != 0) goto L25
                r1 = 37
                if (r0 != r1) goto L41
                if (r18 == 0) goto L25
                if (r19 == 0) goto L41
                r11 = r13
                boolean r1 = r13.m295e(r14, r3, r4)
                if (r1 == 0) goto L4f
                goto L42
            L41:
                r11 = r13
            L42:
                r1 = 43
                if (r0 != r1) goto L49
                if (r20 == 0) goto L49
                goto L4f
            L49:
                int r0 = java.lang.Character.charCount(r0)
                int r3 = r3 + r0
                goto L10
            L4f:
                u3 r12 = new u3
                r12.<init>()
                r0 = r15
                r12.m9928m0(r14, r15, r3)
                r0 = r13
                r1 = r12
                r2 = r14
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r9 = r21
                r10 = r22
                r0.m300k(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                java.lang.String r0 = r12.m9908V()
                return r0
            L71:
                r11 = r13
                r0 = r15
                java.lang.String r0 = r14.substring(r15, r16)
                java.lang.String r1 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                p000.AbstractC0116Ce.m475d(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0069Bd.b.m292a(java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):java.lang.String");
        }

        public final int m293c(String str) {
            AbstractC0116Ce.m476e(str, "scheme");
            int iHashCode = str.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && str.equals("https")) {
                    return 443;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        public final C0069Bd m294d(String str) {
            AbstractC0116Ce.m476e(str, "$this$toHttpUrl");
            return new a().m267h(null, str).m260a();
        }

        public final boolean m295e(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && AbstractC2623yo.m10908D(str.charAt(i + 1)) != -1 && AbstractC2623yo.m10908D(str.charAt(i3)) != -1;
        }

        public final String m296f(String str, int i, int i2, boolean z) {
            AbstractC0116Ce.m476e(str, "$this$percentDecode");
            for (int i3 = i; i3 < i2; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    C2409u3 c2409u3 = new C2409u3();
                    c2409u3.m9928m0(str, i, i3);
                    m301l(c2409u3, str, i3, i2, z);
                    return c2409u3.m9908V();
                }
            }
            String strSubstring = str.substring(i, i2);
            AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void m297h(List list, StringBuilder sb) {
            AbstractC0116Ce.m476e(list, "$this$toPathString");
            AbstractC0116Ce.m476e(sb, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append('/');
                sb.append((String) list.get(i));
            }
        }

        public final List m298i(String str) {
            String strSubstring;
            AbstractC0116Ce.m476e(str, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList<>();
            int i = 0;
            while (i <= str.length()) {
                int iM2928L = AbstractC0584Mm.m2928L(str, '&', i, false, 4, null);
                if (iM2928L == -1) {
                    iM2928L = str.length();
                }
                int i2 = iM2928L;
                int iM2928L2 = AbstractC0584Mm.m2928L(str, '=', i, false, 4, null);
                if (iM2928L2 == -1 || iM2928L2 > i2) {
                    String strSubstring2 = str.substring(i, i2);
                    AbstractC0116Ce.m475d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    strSubstring = null;
                } else {
                    String strSubstring3 = str.substring(i, iM2928L2);
                    AbstractC0116Ce.m475d(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                    strSubstring = str.substring(iM2928L2 + 1, i2);
                    AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(strSubstring);
                i = i2 + 1;
            }
            return arrayList;
        }

        public final void m299j(List list, StringBuilder sb) {
            AbstractC0116Ce.m476e(list, "$this$toQueryString");
            AbstractC0116Ce.m476e(sb, "out");
            C2567xe c2567xeM4986g = AbstractC1132Yj.m4986g(AbstractC1132Yj.m4987h(0, list.size()), 2);
            int iM10716d = c2567xeM4986g.m10716d();
            int iM10717f = c2567xeM4986g.m10717f();
            int iM10718g = c2567xeM4986g.m10718g();
            if (iM10718g >= 0) {
                if (iM10716d > iM10717f) {
                    return;
                }
            } else if (iM10716d < iM10717f) {
                return;
            }
            while (true) {
                String str = (String) list.get(iM10716d);
                String str2 = (String) list.get(iM10716d + 1);
                if (iM10716d > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (iM10716d == iM10717f) {
                    return;
                } else {
                    iM10716d += iM10718g;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0096 A[LOOP:1: B:52:0x0090->B:54:0x0096, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m300k(C2409u3 r15, String r16, int r17, int r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23, Charset r24) throws java.io.EOFException {
            /*
                Method dump skipped, instructions count: 202
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0069Bd.b.m300k(u3, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        public final void m301l(C2409u3 c2409u3, String str, int i, int i2, boolean z) {
            int i3;
            while (i < i2) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int iCodePointAt = str.codePointAt(i);
                if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                    int iM10908D = AbstractC2623yo.m10908D(str.charAt(i + 1));
                    int iM10908D2 = AbstractC2623yo.m10908D(str.charAt(i3));
                    if (iM10908D == -1 || iM10908D2 == -1) {
                        c2409u3.m9929n0(iCodePointAt);
                        i += Character.charCount(iCodePointAt);
                    } else {
                        c2409u3.mo5926L((iM10908D << 4) + iM10908D2);
                        i = Character.charCount(iCodePointAt) + i3;
                    }
                } else if (iCodePointAt == 43 && z) {
                    c2409u3.mo5926L(32);
                    i++;
                } else {
                    c2409u3.m9929n0(iCodePointAt);
                    i += Character.charCount(iCodePointAt);
                }
            }
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0069Bd(String str, String str2, String str3, String str4, int i, List list, List list2, String str5, String str6) {
        AbstractC0116Ce.m476e(str, "scheme");
        AbstractC0116Ce.m476e(str2, "username");
        AbstractC0116Ce.m476e(str3, "password");
        AbstractC0116Ce.m476e(str4, "host");
        AbstractC0116Ce.m476e(list, "pathSegments");
        AbstractC0116Ce.m476e(str6, "url");
        this.f160b = str;
        this.f161c = str2;
        this.f162d = str3;
        this.f163e = str4;
        this.f164f = i;
        this.f165g = list;
        this.f166h = list2;
        this.f167i = str5;
        this.f168j = str6;
        this.f159a = AbstractC0116Ce.m472a(str, "https");
    }

    public final String m243b() {
        if (this.f167i == null) {
            return null;
        }
        int iM2928L = AbstractC0584Mm.m2928L(this.f168j, '#', 0, false, 6, null) + 1;
        String str = this.f168j;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iM2928L);
        AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String m244c() {
        if (this.f162d.length() == 0) {
            return "";
        }
        int iM2928L = AbstractC0584Mm.m2928L(this.f168j, ':', this.f160b.length() + 3, false, 4, null) + 1;
        int iM2928L2 = AbstractC0584Mm.m2928L(this.f168j, '@', 0, false, 6, null);
        String str = this.f168j;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iM2928L, iM2928L2);
        AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String m245d() {
        int iM2928L = AbstractC0584Mm.m2928L(this.f168j, '/', this.f160b.length() + 3, false, 4, null);
        String str = this.f168j;
        int iM10939n = AbstractC2623yo.m10939n(str, "?#", iM2928L, str.length());
        String str2 = this.f168j;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iM2928L, iM10939n);
        AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List m246e() {
        int iM2928L = AbstractC0584Mm.m2928L(this.f168j, '/', this.f160b.length() + 3, false, 4, null);
        String str = this.f168j;
        int iM10939n = AbstractC2623yo.m10939n(str, "?#", iM2928L, str.length());
        ArrayList arrayList = new ArrayList<>();
        while (iM2928L < iM10939n) {
            int i = iM2928L + 1;
            int iM10938m = AbstractC2623yo.m10938m(this.f168j, '/', i, iM10939n);
            String str2 = this.f168j;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str2.substring(i, iM10938m);
            AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iM2928L = iM10938m;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0069Bd) && AbstractC0116Ce.m472a(((C0069Bd) obj).f168j, this.f168j);
    }

    public final String m247f() {
        if (this.f166h == null) {
            return null;
        }
        int iM2928L = AbstractC0584Mm.m2928L(this.f168j, '?', 0, false, 6, null) + 1;
        String str = this.f168j;
        int iM10938m = AbstractC2623yo.m10938m(str, '#', iM2928L, str.length());
        String str2 = this.f168j;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iM2928L, iM10938m);
        AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String m248g() {
        if (this.f161c.length() == 0) {
            return "";
        }
        int length = this.f160b.length() + 3;
        String str = this.f168j;
        int iM10939n = AbstractC2623yo.m10939n(str, ":@", length, str.length());
        String str2 = this.f168j;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(length, iM10939n);
        AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String m249h() {
        return this.f163e;
    }

    public int hashCode() {
        return this.f168j.hashCode();
    }

    public final boolean m250i() {
        return this.f159a;
    }

    public final a m251j() {
        a aVar = new a();
        aVar.m280u(this.f160b);
        aVar.m277r(m248g());
        aVar.m276q(m244c());
        aVar.m278s(this.f163e);
        aVar.m279t(this.f164f != f158l.m293c(this.f160b) ? this.f164f : -1);
        aVar.m263d().clear();
        aVar.m263d().addAll(m246e());
        aVar.m262c(m247f());
        aVar.m275p(m243b());
        return aVar;
    }

    public final a m252k(String str) {
        AbstractC0116Ce.m476e(str, "link");
        try {
            return new a().m267h(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final int m253l() {
        return this.f164f;
    }

    public final String m254m() {
        if (this.f166h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        f158l.m299j(this.f166h, sb);
        return sb.toString();
    }

    public final String m255n() {
        a aVarM252k = m252k("/...");
        AbstractC0116Ce.m473b(aVarM252k);
        return aVarM252k.m281v("").m268i("").m260a().toString();
    }

    public final C0069Bd m256o(String str) {
        AbstractC0116Ce.m476e(str, "link");
        a aVarM252k = m252k(str);
        if (aVarM252k != null) {
            return aVarM252k.m260a();
        }
        return null;
    }

    public final String m257p() {
        return this.f160b;
    }

    public final URI m258q() {
        String string = m251j().m272m().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new C2389tk("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").m9729b(string, ""));
                AbstractC0116Ce.m475d(uriCreate, "try {\n        val stripp…e) // Unexpected!\n      }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final URL m259r() {
        try {
            return new URL(this.f168j);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return this.f168j;
    }
}
