package p000;

import java.util.LinkedHashMap;
import java.util.Map;

public final class C0122Ck {

    public C0280G3 f293a;

    public final C0069Bd f294b;

    public final String f295c;

    public final C1079Xc f296d;

    public final AbstractC0168Dk f297e;

    public final Map f298f;

    public static class a {

        public C0069Bd f299a;

        public String f300b;

        public C1079Xc.a f301c;

        public AbstractC0168Dk f302d;

        public Map f303e;

        public a() {
            this.f303e = new LinkedHashMap();
            this.f300b = "GET";
            this.f301c = new C1079Xc.a();
        }

        public a m499a(String str, String str2) {
            AbstractC0116Ce.m476e(str, "name");
            AbstractC0116Ce.m476e(str2, "value");
            this.f301c.m4742a(str, str2);
            return this;
        }

        public C0122Ck m500b() {
            C0069Bd c0069Bd = this.f299a;
            if (c0069Bd != null) {
                return new C0122Ck(c0069Bd, this.f300b, this.f301c.m4745d(), this.f302d, AbstractC2623yo.m10919O(this.f303e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a m501c(String str, String str2) {
            AbstractC0116Ce.m476e(str, "name");
            AbstractC0116Ce.m476e(str2, "value");
            this.f301c.m4748g(str, str2);
            return this;
        }

        public a m502d(C1079Xc c1079Xc) {
            AbstractC0116Ce.m476e(c1079Xc, "headers");
            this.f301c = c1079Xc.m4739g();
            return this;
        }

        public a m503e(String str, AbstractC0168Dk abstractC0168Dk) {
            AbstractC0116Ce.m476e(str, "method");
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (abstractC0168Dk == null) {
                if (!(true ^ C0023Ad.m118d(str))) {
                    throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                }
            } else if (!C0023Ad.m117a(str)) {
                throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
            }
            this.f300b = str;
            this.f302d = abstractC0168Dk;
            return this;
        }

        public a m504f(AbstractC0168Dk abstractC0168Dk) {
            AbstractC0116Ce.m476e(abstractC0168Dk, "body");
            return m503e("POST", abstractC0168Dk);
        }

        public a m505g(String str) {
            AbstractC0116Ce.m476e(str, "name");
            this.f301c.m4747f(str);
            return this;
        }

        public a m506h(C0069Bd c0069Bd) {
            AbstractC0116Ce.m476e(c0069Bd, "url");
            this.f299a = c0069Bd;
            return this;
        }

        public a m507i(String str) {
            StringBuilder sb;
            int i;
            AbstractC0116Ce.m476e(str, "url");
            if (!AbstractC0538Lm.m2729u(str, "ws:", true)) {
                if (AbstractC0538Lm.m2729u(str, "wss:", true)) {
                    sb = new StringBuilder();
                    sb.append("https:");
                    i = 4;
                }
                return m506h(C0069Bd.f158l.m294d(str));
            }
            sb = new StringBuilder();
            sb.append("http:");
            i = 3;
            String strSubstring = str.substring(i);
            AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            sb.append(strSubstring);
            str = sb.toString();
            return m506h(C0069Bd.f158l.m294d(str));
        }

        public a(C0122Ck c0122Ck) {
            AbstractC0116Ce.m476e(c0122Ck, "request");
            this.f303e = new LinkedHashMap();
            this.f299a = c0122Ck.getUrl();
            this.f300b = c0122Ck.m496g();
            this.f302d = c0122Ck.m490a();
            this.f303e = c0122Ck.m492c().isEmpty() ? new LinkedHashMap() : AbstractC2339sg.m9578j(c0122Ck.m492c());
            this.f301c = c0122Ck.m494e().m4739g();
        }
    }

    public C0122Ck(C0069Bd c0069Bd, String str, C1079Xc c1079Xc, AbstractC0168Dk abstractC0168Dk, Map map) {
        AbstractC0116Ce.m476e(c0069Bd, "url");
        AbstractC0116Ce.m476e(str, "method");
        AbstractC0116Ce.m476e(c1079Xc, "headers");
        AbstractC0116Ce.m476e(map, "tags");
        this.f294b = c0069Bd;
        this.f295c = str;
        this.f296d = c1079Xc;
        this.f297e = abstractC0168Dk;
        this.f298f = map;
    }

    public final AbstractC0168Dk m490a() {
        return this.f297e;
    }

    public final C0280G3 m491b() {
        C0280G3 c0280g3 = this.f293a;
        if (c0280g3 != null) {
            return c0280g3;
        }
        C0280G3 c0280g3M1336b = C0280G3.f711p.m1336b(this.f296d);
        this.f293a = c0280g3M1336b;
        return c0280g3M1336b;
    }

    public final Map m492c() {
        return this.f298f;
    }

    public final String m493d(String str) {
        AbstractC0116Ce.m476e(str, "name");
        return this.f296d.m4737d(str);
    }

    public final C1079Xc m494e() {
        return this.f296d;
    }

    public final boolean m495f() {
        return this.f294b.m250i();
    }

    public final String m496g() {
        return this.f295c;
    }

    public final a m497h() {
        return new a(this);
    }

    public final C0069Bd getUrl() {
        return this.f294b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f295c);
        sb.append(", url=");
        sb.append(this.f294b);
        if (this.f296d.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Object obj : this.f296d) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC1810h5.m7790m();
                }
                C0258Fi c0258Fi = (C0258Fi) obj;
                String str = (String) c0258Fi.m1259a();
                String str2 = (String) c0258Fi.m1260b();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i = i2;
            }
            sb.append(']');
        }
        if (!this.f298f.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.f298f);
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
