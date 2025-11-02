package p000;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class C0280G3 {

    public final boolean f712a;

    public final boolean f713b;

    public final int f714c;

    public final int f715d;

    public final boolean f716e;

    public final boolean f717f;

    public final boolean f718g;

    public final int f719h;

    public final int f720i;

    public final boolean f721j;

    public final boolean f722k;

    public final boolean f723l;

    public String f724m;

    public static final b f711p = new b(null);

    public static final C0280G3 f709n = new a().m1333d().m1330a();

    public static final C0280G3 f710o = new a().m1334e().m1332c(Integer.MAX_VALUE, TimeUnit.SECONDS).m1330a();

    public static final class a {

        public boolean f725a;

        public boolean f726b;

        public int f727c = -1;

        public int f728d = -1;

        public int f729e = -1;

        public boolean f730f;

        public boolean f731g;

        public boolean f732h;

        public final C0280G3 m1330a() {
            return new C0280G3(this.f725a, this.f726b, this.f727c, -1, false, false, false, this.f728d, this.f729e, this.f730f, this.f731g, this.f732h, null, null);
        }

        public final int m1331b(long j) {
            if (j > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        public final a m1332c(int i, TimeUnit timeUnit) {
            AbstractC0116Ce.m476e(timeUnit, "timeUnit");
            if (i >= 0) {
                this.f728d = m1331b(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i).toString());
        }

        public final a m1333d() {
            this.f725a = true;
            return this;
        }

        public final a m1334e() {
            this.f730f = true;
            return this;
        }
    }

    public static final class b {
        public b() {
        }

        public final int m1335a(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (AbstractC0584Mm.m2917A(str2, str.charAt(i), false, 2, null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final C0280G3 m1336b(C1079Xc r32) {
            /*
                Method dump skipped, instructions count: 415
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0280G3.b.m1336b(Xc):G3");
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0280G3(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f712a = z;
        this.f713b = z2;
        this.f714c = i;
        this.f715d = i2;
        this.f716e = z3;
        this.f717f = z4;
        this.f718g = z5;
        this.f719h = i3;
        this.f720i = i4;
        this.f721j = z6;
        this.f722k = z7;
        this.f723l = z8;
        this.f724m = str;
    }

    public final boolean m1321a() {
        return this.f716e;
    }

    public final boolean m1322b() {
        return this.f717f;
    }

    public final int m1323c() {
        return this.f714c;
    }

    public final int m1324d() {
        return this.f719h;
    }

    public final int m1325e() {
        return this.f720i;
    }

    public final boolean m1326f() {
        return this.f718g;
    }

    public final boolean m1327g() {
        return this.f712a;
    }

    public final boolean m1328h() {
        return this.f713b;
    }

    public final boolean m1329i() {
        return this.f721j;
    }

    public String toString() {
        String str = this.f724m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f712a) {
            sb.append("no-cache, ");
        }
        if (this.f713b) {
            sb.append("no-store, ");
        }
        if (this.f714c != -1) {
            sb.append("max-age=");
            sb.append(this.f714c);
            sb.append(", ");
        }
        if (this.f715d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f715d);
            sb.append(", ");
        }
        if (this.f716e) {
            sb.append("private, ");
        }
        if (this.f717f) {
            sb.append("public, ");
        }
        if (this.f718g) {
            sb.append("must-revalidate, ");
        }
        if (this.f719h != -1) {
            sb.append("max-stale=");
            sb.append(this.f719h);
            sb.append(", ");
        }
        if (this.f720i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f720i);
            sb.append(", ");
        }
        if (this.f721j) {
            sb.append("only-if-cached, ");
        }
        if (this.f722k) {
            sb.append("no-transform, ");
        }
        if (this.f723l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "StringBuilder().apply(builderAction).toString()");
        this.f724m = string;
        return string;
    }

    public C0280G3(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, AbstractC0881T7 abstractC0881T7) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }
}
