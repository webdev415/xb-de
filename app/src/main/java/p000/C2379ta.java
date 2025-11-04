package p000;

import java.io.IOException;

public final class C2379ta {

    public C1742fl.b f7207a;

    public C1742fl f7208b;

    public int f7209c;

    public int f7210d;

    public int f7211e;

    public Route f7212f;

    public final C1835hk f7213g;

    public final Address f7214h;

    public final C1694ek f7215i;

    public final AbstractC1918ja f7216j;

    public C2379ta(C1835hk c1835hk, Address address, C1694ek c1694ek, AbstractC1918ja abstractC1918ja) {
        AbstractC0116Ce.m476e(c1835hk, "connectionPool");
        AbstractC0116Ce.m476e(address, "address");
        AbstractC0116Ce.m476e(c1694ek, "call");
        AbstractC0116Ce.m476e(abstractC1918ja, "eventListener");
        this.f7213g = c1835hk;
        this.f7214h = address;
        this.f7215i = c1694ek;
        this.f7216j = abstractC1918ja;
    }

    public final InterfaceC2333sa m9693a(OkHttpClient okHttpClient, C1882ik c1882ik) {
        AbstractC0116Ce.m476e(okHttpClient, "client");
        AbstractC0116Ce.m476e(c1882ik, "chain");
        try {
            return m9695c(c1882ik.m7970f(), c1882ik.m7972h(), c1882ik.m7974j(), okHttpClient.m2005z(), okHttpClient.m1982F(), !AbstractC0116Ce.m472a(c1882ik.m7973i().m496g(), "GET")).m7634w(okHttpClient, c1882ik);
        } catch (C1695el e) {
            m9700h(e.m7462c());
            throw e;
        } catch (IOException e2) {
            m9700h(e2);
            throw new C1695el(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final Connection m9694b(int r15, int r16, int r17, int r18, boolean r19) throws IOException {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2379ta.m9694b(int, int, int, int, boolean):fk");
    }

    public final Connection m9695c(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            Connection connectionM9694B = m9694b(i, i2, i3, i4, z);
            if (connectionM9694B.m7632u(z2)) {
                return connectionM9694B;
            }
            connectionM9694B.m7636y();
            if (this.f7212f == null) {
                C1742fl.b bVar = this.f7207a;
                if (bVar != null ? bVar.m7649b() : true) {
                    continue;
                } else {
                    C1742fl c1742fl = this.f7208b;
                    if (!(c1742fl != null ? c1742fl.m7641b() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    public final Address m9696d() {
        return this.f7214h;
    }

    public final boolean m9697e() {
        C1742fl c1742fl;
        if (this.f7209c == 0 && this.f7210d == 0 && this.f7211e == 0) {
            return false;
        }
        if (this.f7212f != null) {
            return true;
        }
        Route routeM9698F = m9698f();
        if (routeM9698F != null) {
            this.f7212f = routeM9698F;
            return true;
        }
        C1742fl.b bVar = this.f7207a;
        if ((bVar == null || !bVar.m7649b()) && (c1742fl = this.f7208b) != null) {
            return c1742fl.m7641b();
        }
        return true;
    }

    public final Route m9698f() {
        Connection connectionM7443O;
        if (this.f7209c > 1 || this.f7210d > 1 || this.f7211e > 0 || (connectionM7443O = this.f7215i.m7443o()) == null) {
            return null;
        }
        synchronized (connectionM7443O) {
            if (connectionM7443O.m7628q() != 0) {
                return null;
            }
            if (AbstractC2623yo.m10932g(connectionM7443O.m7637z().m5675a().m10421l(), this.f7214h.m10421l())) {
                return connectionM7443O.m7637z();
            }
            return null;
        }
    }

    public final boolean m9699g(C0069Bd c0069Bd) {
        AbstractC0116Ce.m476e(c0069Bd, "url");
        C0069Bd c0069BdM10421l = this.f7214h.m10421l();
        return c0069Bd.m253l() == c0069BdM10421l.m253l() && AbstractC0116Ce.m472a(c0069Bd.m249h(), c0069BdM10421l.m249h());
    }

    public final void m9700h(IOException iOException) {
        AbstractC0116Ce.m476e(iOException, "e");
        this.f7212f = null;
        if ((iOException instanceof C2575xm) && ((C2575xm) iOException).f8025l == EnumC1159Z9.REFUSED_STREAM) {
            this.f7209c++;
        } else if (iOException instanceof C1764g6) {
            this.f7210d++;
        } else {
            this.f7211e++;
        }
    }
}
