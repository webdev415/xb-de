package p000;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class C0372I3 {

    public static final a f1116c = new a(null);

    public final Request f1117a;

    public final Response f1118b;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean m1667a(Response r5, Request r6) {
            /*
                r4 = this;
                java.lang.String r0 = "response"
                p000.AbstractC0116Ce.m476e(r5, r0)
                java.lang.String r0 = "request"
                p000.AbstractC0116Ce.m476e(r6, r0)
                int r0 = r5.code()
                r1 = 200(0xc8, float:2.8E-43)
                r2 = 0
                if (r0 == r1) goto L65
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 == r1) goto L65
                r1 = 414(0x19e, float:5.8E-43)
                if (r0 == r1) goto L65
                r1 = 501(0x1f5, float:7.02E-43)
                if (r0 == r1) goto L65
                r1 = 203(0xcb, float:2.84E-43)
                if (r0 == r1) goto L65
                r1 = 204(0xcc, float:2.86E-43)
                if (r0 == r1) goto L65
                r1 = 307(0x133, float:4.3E-43)
                if (r0 == r1) goto L3b
                r1 = 308(0x134, float:4.32E-43)
                if (r0 == r1) goto L65
                r1 = 404(0x194, float:5.66E-43)
                if (r0 == r1) goto L65
                r1 = 405(0x195, float:5.68E-43)
                if (r0 == r1) goto L65
                switch(r0) {
                    case 300: goto L65;
                    case 301: goto L65;
                    case 302: goto L3b;
                    default: goto L3a;
                }
            L3a:
                return r2
            L3b:
                java.lang.String r0 = "Expires"
                r1 = 2
                r3 = 0
                java.lang.String r0 = p000.Response.m2383w(r5, r0, r3, r1, r3)
                if (r0 != 0) goto L65
                G3 r0 = r5.m2393b()
                int r0 = r0.m1323c()
                r1 = -1
                if (r0 != r1) goto L65
                G3 r0 = r5.m2393b()
                boolean r0 = r0.m1322b()
                if (r0 != 0) goto L65
                G3 r0 = r5.m2393b()
                boolean r0 = r0.m1321a()
                if (r0 != 0) goto L65
                return r2
            L65:
                G3 r5 = r5.m2393b()
                boolean r5 = r5.m1328h()
                if (r5 != 0) goto L7a
                G3 r5 = r6.m491b()
                boolean r5 = r5.m1328h()
                if (r5 != 0) goto L7a
                r2 = 1
            L7a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0372I3.a.m1667a(Kk, Ck):boolean");
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b {

        public Date f1119a;

        public String f1120b;

        public Date f1121c;

        public String f1122d;

        public Date f1123e;

        public long f1124f;

        public long f1125g;

        public String f1126h;

        public int f1127i;

        public final long f1128j;

        public final Request f1129k;

        public final Response f1130l;

        public b(long j, Request request, Response response) {
            AbstractC0116Ce.m476e(request, "request");
            this.f1128j = j;
            this.f1129k = request;
            this.f1130l = response;
            this.f1127i = -1;
            if (response != null) {
                this.f1124f = response.m2391T();
                this.f1125g = response.m2389J();
                Headers headersM2401Z = response.getHeaders();
                int size = headersM2401Z.size();
                for (int i = 0; i < size; i++) {
                    String strM4738f = headersM2401Z.m4738f(i);
                    String strM4740h = headersM2401Z.m4740h(i);
                    if (AbstractC0538Lm.m2720l(strM4738f, "Date", true)) {
                        this.f1119a = AbstractC2321s7.m9522a(strM4740h);
                        this.f1120b = strM4740h;
                    } else if (AbstractC0538Lm.m2720l(strM4738f, "Expires", true)) {
                        this.f1123e = AbstractC2321s7.m9522a(strM4740h);
                    } else if (AbstractC0538Lm.m2720l(strM4738f, "Last-Modified", true)) {
                        this.f1121c = AbstractC2321s7.m9522a(strM4740h);
                        this.f1122d = strM4740h;
                    } else if (AbstractC0538Lm.m2720l(strM4738f, "ETag", true)) {
                        this.f1126h = strM4740h;
                    } else if (AbstractC0538Lm.m2720l(strM4738f, "Age", true)) {
                        this.f1127i = AbstractC2623yo.m10921Q(strM4740h, -1);
                    }
                }
            }
        }

        public final long m1668a() {
            Date date = this.f1119a;
            long jMax = date != null ? Math.max(0L, this.f1125g - date.getTime()) : 0L;
            int i = this.f1127i;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.f1125g;
            return jMax + (j - this.f1124f) + (this.f1128j - j);
        }

        public final C0372I3 m1669b() {
            C0372I3 c0372i3M1670c = m1670c();
            return (c0372i3M1670c.m1666b() == null || !this.f1129k.m491b().m1329i()) ? c0372i3M1670c : new C0372I3(null, null);
        }

        public final C0372I3 m1670c() {
            String str;
            if (this.f1130l == null) {
                return new C0372I3(this.f1129k, null);
            }
            if ((!this.f1129k.m495f() || this.f1130l.m2398l() != null) && C0372I3.f1116c.m1667a(this.f1130l, this.f1129k)) {
                C0280G3 c0280g3M491b = this.f1129k.m491b();
                if (c0280g3M491b.m1327g() || m1672e(this.f1129k)) {
                    return new C0372I3(this.f1129k, null);
                }
                C0280G3 c0280g3M2393b = this.f1130l.m2393b();
                long jM1668a = m1668a();
                long jM1671d = m1671d();
                if (c0280g3M491b.m1323c() != -1) {
                    jM1671d = Math.min(jM1671d, TimeUnit.SECONDS.toMillis(c0280g3M491b.m1323c()));
                }
                long millis = 0;
                long millis2 = c0280g3M491b.m1325e() != -1 ? TimeUnit.SECONDS.toMillis(c0280g3M491b.m1325e()) : 0L;
                if (!c0280g3M2393b.m1326f() && c0280g3M491b.m1324d() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(c0280g3M491b.m1324d());
                }
                if (!c0280g3M2393b.m1327g()) {
                    long j = millis2 + jM1668a;
                    if (j < millis + jM1671d) {
                        Response.a aVarM2386C = this.f1130l.m2386C();
                        if (j >= jM1671d) {
                            aVarM2386C.m2402a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jM1668a > 86400000 && m1673f()) {
                            aVarM2386C.m2402a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new C0372I3(null, aVarM2386C.m2404c());
                    }
                }
                String str2 = this.f1126h;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.f1121c != null) {
                        str2 = this.f1122d;
                    } else {
                        if (this.f1119a == null) {
                            return new C0372I3(this.f1129k, null);
                        }
                        str2 = this.f1120b;
                    }
                    str = "If-Modified-Since";
                }
                Headers.a aVarM4739g = this.f1129k.m494e().m4739g();
                AbstractC0116Ce.m473b(str2);
                aVarM4739g.m4744c(str, str2);
                return new C0372I3(this.f1129k.m497h().m502d(aVarM4739g.m4745d()).m500b(), this.f1130l);
            }
            return new C0372I3(this.f1129k, null);
        }

        public final long m1671d() {
            Response response = this.f1130l;
            AbstractC0116Ce.m473b(response);
            if (response.m2393b().m1323c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.m1323c());
            }
            Date date = this.f1123e;
            if (date != null) {
                Date date2 = this.f1119a;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.f1125g);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f1121c == null || this.f1130l.getRequest().getUrl().m254m() != null) {
                return 0L;
            }
            Date date3 = this.f1119a;
            long time2 = date3 != null ? date3.getTime() : this.f1124f;
            Date date4 = this.f1121c;
            AbstractC0116Ce.m473b(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / 10;
            }
            return 0L;
        }

        public final boolean m1672e(Request request) {
            return (request.m493d("If-Modified-Since") == null && request.m493d("If-None-Match") == null) ? false : true;
        }

        public final boolean m1673f() {
            Response response = this.f1130l;
            AbstractC0116Ce.m473b(response);
            return response.m2393b().m1323c() == -1 && this.f1123e == null;
        }
    }

    public C0372I3(Request request, Response response) {
        this.f1117a = request;
        this.f1118b = response;
    }

    public final Response m1665a() {
        return this.f1118b;
    }

    public final Request m1666b() {
        return this.f1117a;
    }
}
