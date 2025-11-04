package p000;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Request {

    public C0280G3 f293a;

    public final C0069Bd url;

    public final String method;

    public final Headers headers;

    public final AbstractC0168Dk f297e;

    public final Map tags;

    public static class Builder {

        public C0069Bd f299a;

        public String method;

        public Headers.a f301c;

        public AbstractC0168Dk f302d;

        public Map f303e;

        public Builder() {
            this.f303e = new LinkedHashMap();
            this.method = "GET";
            this.f301c = new Headers.a();
        }

        public Builder addHeader(String str, String str2) {
            AbstractC0116Ce.m476e(str, "name");
            AbstractC0116Ce.m476e(str2, "value");
            this.f301c.m4742a(str, str2);
            return this;
        }

        public Request m500b() {
            C0069Bd c0069Bd = this.f299a;
            if (c0069Bd != null) {
                return new Request(c0069Bd, this.method, this.f301c.m4745d(), this.f302d, AbstractC2623yo.m10919O(this.f303e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public Builder m501c(String str, String str2) {
            AbstractC0116Ce.m476e(str, "name");
            AbstractC0116Ce.m476e(str2, "value");
            this.f301c.m4748g(str, str2);
            return this;
        }

        public Builder m502d(Headers headers) {
            AbstractC0116Ce.m476e(headers, "headers");
            this.f301c = headers.m4739g();
            return this;
        }

        public Builder m503e(String method, AbstractC0168Dk abstractC0168Dk) {
            AbstractC0116Ce.m476e(method, "method");
            if (method.isEmpty()) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (abstractC0168Dk == null) {
                if (C0023Ad.m118d(method)) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!C0023Ad.m117a(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.method = method;
            this.f302d = abstractC0168Dk;
            return this;
        }

        public Builder m504f(AbstractC0168Dk abstractC0168Dk) {
            AbstractC0116Ce.m476e(abstractC0168Dk, "body");
            return m503e("POST", abstractC0168Dk);
        }

        public Builder m505g(String str) {
            AbstractC0116Ce.m476e(str, "name");
            this.f301c.m4747f(str);
            return this;
        }

        public Builder m506h(C0069Bd c0069Bd) {
            AbstractC0116Ce.m476e(c0069Bd, "url");
            this.f299a = c0069Bd;
            return this;
        }

        public Builder url(String str) {
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

        public Builder(Request request) {
            AbstractC0116Ce.m476e(request, "request");
            this.f303e = new LinkedHashMap();
            this.f299a = request.getUrl();
            this.method = request.m496g();
            this.f302d = request.m490a();
            this.f303e = request.m492c().isEmpty() ? new LinkedHashMap() : AbstractC2339sg.m9578j(request.m492c());
            this.f301c = request.m494e().m4739g();
        }
    }

    public Request(C0069Bd url, String method, Headers headers, AbstractC0168Dk abstractC0168Dk, Map tags) {
        AbstractC0116Ce.m476e(url, "url");
        AbstractC0116Ce.m476e(method, "method");
        AbstractC0116Ce.m476e(headers, "headers");
        AbstractC0116Ce.m476e(tags, "tags");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.f297e = abstractC0168Dk;
        this.tags = tags;
    }

    public final AbstractC0168Dk m490a() {
        return this.f297e;
    }

    public final C0280G3 m491b() {
        C0280G3 c0280g3 = this.f293a;
        if (c0280g3 != null) {
            return c0280g3;
        }
        C0280G3 c0280g3M1336b = C0280G3.f711p.m1336b(this.headers);
        this.f293a = c0280g3M1336b;
        return c0280g3M1336b;
    }

    public final Map m492c() {
        return this.tags;
    }

    public final String m493d(String str) {
        AbstractC0116Ce.m476e(str, "name");
        return this.headers.m4737d(str);
    }

    public final Headers m494e() {
        return this.headers;
    }

    public final boolean m495f() {
        return this.url.m250i();
    }

    public final String m496g() {
        return this.method;
    }

    public final Builder m497h() {
        return new Builder(this);
    }

    public final C0069Bd getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Object obj : this.headers) {
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
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
