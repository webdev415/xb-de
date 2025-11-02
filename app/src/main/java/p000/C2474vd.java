package p000;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class C2474vd implements InterfaceC2333sa {

    public volatile C2566xd f7668a;

    public final EnumC2342sj f7669b;

    public volatile boolean f7670c;

    public final C1741fk f7671d;

    public final C1882ik f7672e;

    public final C2428ud f7673f;

    public static final a f7667i = new a(null);

    public static final List f7665g = AbstractC2623yo.m10945t("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    public static final List f7666h = AbstractC2623yo.m10945t("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    public static final class a {
        public a() {
        }

        public final List m10351a(C0122Ck c0122Ck) {
            AbstractC0116Ce.m476e(c0122Ck, "request");
            C1079Xc c1079XcM494e = c0122Ck.m494e();
            ArrayList arrayList = new ArrayList<>(c1079XcM494e.size() + 4);
            arrayList.add(new C1033Wc(C1033Wc.f3054f, c0122Ck.m496g()));
            arrayList.add(new C1033Wc(C1033Wc.f3055g, C0260Fk.f676a.m1272c(c0122Ck.m498i())));
            String strM493d = c0122Ck.m493d("Host");
            if (strM493d != null) {
                arrayList.add(new C1033Wc(C1033Wc.f3057i, strM493d));
            }
            arrayList.add(new C1033Wc(C1033Wc.f3056h, c0122Ck.m498i().m257p()));
            int size = c1079XcM494e.size();
            for (int i = 0; i < size; i++) {
                String strM4738f = c1079XcM494e.m4738f(i);
                Locale locale = Locale.US;
                AbstractC0116Ce.m475d(locale, "Locale.US");
                if (strM4738f == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = strM4738f.toLowerCase(locale);
                AbstractC0116Ce.m475d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!C2474vd.f7665g.contains(lowerCase) || (AbstractC0116Ce.m472a(lowerCase, "te") && AbstractC0116Ce.m472a(c1079XcM494e.m4740h(i), "trailers"))) {
                    arrayList.add(new C1033Wc(lowerCase, c1079XcM494e.m4740h(i)));
                }
            }
            return arrayList;
        }

        public final C0490Kk.a m10352b(C1079Xc c1079Xc, EnumC2342sj enumC2342sj) throws ProtocolException, NumberFormatException {
            AbstractC0116Ce.m476e(c1079Xc, "headerBlock");
            AbstractC0116Ce.m476e(enumC2342sj, "protocol");
            C1079Xc.a aVar = new C1079Xc.a();
            int size = c1079Xc.size();
            C2529wm c2529wmM10597a = null;
            for (int i = 0; i < size; i++) {
                String strM4738f = c1079Xc.m4738f(i);
                String strM4740h = c1079Xc.m4740h(i);
                if (AbstractC0116Ce.m472a(strM4738f, ":status")) {
                    c2529wmM10597a = C2529wm.f7894d.m10597a("HTTP/1.1 " + strM4740h);
                } else if (!C2474vd.f7666h.contains(strM4738f)) {
                    aVar.m4744c(strM4738f, strM4740h);
                }
            }
            if (c2529wmM10597a != null) {
                return new C0490Kk.a().m2417p(enumC2342sj).m2408g(c2529wmM10597a.f7896b).m2414m(c2529wmM10597a.f7897c).m2412k(aVar.m4745d());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C2474vd(OkHttpClient okHttpClient, C1741fk c1741fk, C1882ik c1882ik, C2428ud c2428ud) {
        AbstractC0116Ce.m476e(okHttpClient, "client");
        AbstractC0116Ce.m476e(c1741fk, "connection");
        AbstractC0116Ce.m476e(c1882ik, "chain");
        AbstractC0116Ce.m476e(c2428ud, "http2Connection");
        this.f7671d = c1741fk;
        this.f7672e = c1882ik;
        this.f7673f = c2428ud;
        List listM1977A = okHttpClient.m1977A();
        EnumC2342sj enumC2342sj = EnumC2342sj.H2_PRIOR_KNOWLEDGE;
        this.f7669b = listM1977A.contains(enumC2342sj) ? enumC2342sj : EnumC2342sj.HTTP_2;
    }

    @Override
    public void mo9530a(C0122Ck c0122Ck) throws IOException {
        AbstractC0116Ce.m476e(c0122Ck, "request");
        if (this.f7668a != null) {
            return;
        }
        this.f7668a = this.f7673f.m10046i0(f7667i.m10351a(c0122Ck), c0122Ck.m490a() != null);
        if (this.f7670c) {
            C2566xd c2566xd = this.f7668a;
            AbstractC0116Ce.m473b(c2566xd);
            c2566xd.m10685f(EnumC1159Z9.CANCEL);
            throw new IOException("Canceled");
        }
        C2566xd c2566xd2 = this.f7668a;
        AbstractC0116Ce.m473b(c2566xd2);
        C0125Cn c0125CnM10701v = c2566xd2.m10701v();
        long jM7972h = this.f7672e.m7972h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c0125CnM10701v.mo439g(jM7972h, timeUnit);
        C2566xd c2566xd3 = this.f7668a;
        AbstractC0116Ce.m473b(c2566xd3);
        c2566xd3.m10679E().mo439g(this.f7672e.m7974j(), timeUnit);
    }

    @Override
    public InterfaceC2161om mo9531b(C0490Kk c0490Kk) {
        AbstractC0116Ce.m476e(c0490Kk, "response");
        C2566xd c2566xd = this.f7668a;
        AbstractC0116Ce.m473b(c2566xd);
        return c2566xd.m10695p();
    }

    @Override
    public void mo9532c() {
        C2566xd c2566xd = this.f7668a;
        AbstractC0116Ce.m473b(c2566xd);
        c2566xd.m10693n().close();
    }

    @Override
    public void cancel() {
        this.f7670c = true;
        C2566xd c2566xd = this.f7668a;
        if (c2566xd != null) {
            c2566xd.m10685f(EnumC1159Z9.CANCEL);
        }
    }

    @Override
    public void mo9533d() {
        this.f7673f.flush();
    }

    @Override
    public C0490Kk.a mo9534e(boolean z) throws ProtocolException, NumberFormatException {
        C2566xd c2566xd = this.f7668a;
        AbstractC0116Ce.m473b(c2566xd);
        C0490Kk.a aVarM10352b = f7667i.m10352b(c2566xd.m10677C(), this.f7669b);
        if (z && aVarM10352b.m2409h() == 100) {
            return null;
        }
        return aVarM10352b;
    }

    @Override
    public InterfaceC1134Yl mo9535f(C0122Ck c0122Ck, long j) {
        AbstractC0116Ce.m476e(c0122Ck, "request");
        C2566xd c2566xd = this.f7668a;
        AbstractC0116Ce.m473b(c2566xd);
        return c2566xd.m10693n();
    }

    @Override
    public long mo9536g(C0490Kk c0490Kk) {
        AbstractC0116Ce.m476e(c0490Kk, "response");
        if (AbstractC2658zd.m11020b(c0490Kk)) {
            return AbstractC2623yo.m10944s(c0490Kk);
        }
        return 0L;
    }

    @Override
    public C1741fk mo9537h() {
        return this.f7671d;
    }
}
