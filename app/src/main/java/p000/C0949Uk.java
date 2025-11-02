package p000;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class C0949Uk implements InterfaceC0070Be {

    public static final a f2862b = new a(null);

    public final OkHttpClient f2863a;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0949Uk(OkHttpClient okHttpClient) {
        AbstractC0116Ce.m476e(okHttpClient, "client");
        this.f2863a = okHttpClient;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        r0 = r1.m7446s();
        r6 = m4270c(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r6 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if (r0.m9371l() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        r1.m7432D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r1.m7441m(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        r0 = r6.m490a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (r0.m723g() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        r1.m7441m(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        r0 = r7.m2392a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        p000.AbstractC2623yo.m10935j(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        if (r8 > 20) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:
    
        throw new java.net.ProtocolException("Too many follow-up requests: " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        if (r7 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        r0 = r0.m2386C().m2416o(r7.m2386C().m2403b(null).m2404c()).m2404c();
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0490Kk mo302a(InterfaceC0070Be.a r11) {
        /*
            r10 = this;
            java.lang.String r0 = "chain"
            p000.AbstractC0116Ce.m476e(r11, r0)
            ik r11 = (p000.C1882ik) r11
            Ck r0 = r11.m7973i()
            ek r1 = r11.m7969e()
            java.util.List r2 = p000.AbstractC1810h5.m7783f()
            r3 = 0
            r4 = 0
            r5 = 1
            r8 = r3
            r7 = r4
        L18:
            r6 = r5
        L19:
            r1.m7440j(r0, r6)
            boolean r6 = r1.m7450w()     // Catch: java.lang.Throwable -> L42
            if (r6 != 0) goto Lcf
            Kk r0 = r11.mo304b(r0)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L99 p000.C1695el -> Lb4
            if (r7 == 0) goto L40
            Kk$a r0 = r0.m2386C()     // Catch: java.lang.Throwable -> L42
            Kk$a r6 = r7.m2386C()     // Catch: java.lang.Throwable -> L42
            Kk$a r6 = r6.m2403b(r4)     // Catch: java.lang.Throwable -> L42
            Kk r6 = r6.m2404c()     // Catch: java.lang.Throwable -> L42
            Kk$a r0 = r0.m2416o(r6)     // Catch: java.lang.Throwable -> L42
            Kk r0 = r0.m2404c()     // Catch: java.lang.Throwable -> L42
        L40:
            r7 = r0
            goto L45
        L42:
            r11 = move-exception
            goto Ld7
        L45:
            ra r0 = r1.m7446s()     // Catch: java.lang.Throwable -> L42
            Ck r6 = r10.m4270c(r7, r0)     // Catch: java.lang.Throwable -> L42
            if (r6 != 0) goto L5e
            if (r0 == 0) goto L5a
            boolean r11 = r0.m9371l()     // Catch: java.lang.Throwable -> L42
            if (r11 == 0) goto L5a
            r1.m7432D()     // Catch: java.lang.Throwable -> L42
        L5a:
            r1.m7441m(r3)
            return r7
        L5e:
            Dk r0 = r6.m490a()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L6e
            boolean r0 = r0.m723g()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L6e
            r1.m7441m(r3)
            return r7
        L6e:
            Lk r0 = r7.m2392a()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L77
            p000.AbstractC2623yo.m10935j(r0)     // Catch: java.lang.Throwable -> L42
        L77:
            int r8 = r8 + 1
            r0 = 20
            if (r8 > r0) goto L82
            r1.m7441m(r5)
            r0 = r6
            goto L18
        L82:
            java.net.ProtocolException r11 = new java.net.ProtocolException     // Catch: java.lang.Throwable -> L42
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            r0.<init>()     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = "Too many follow-up requests: "
            r0.append(r2)     // Catch: java.lang.Throwable -> L42
            r0.append(r8)     // Catch: java.lang.Throwable -> L42
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L42
            r11.<init>(r0)     // Catch: java.lang.Throwable -> L42
            throw r11     // Catch: java.lang.Throwable -> L42
        L99:
            r6 = move-exception
            boolean r9 = r6 instanceof p000.C1764g6     // Catch: java.lang.Throwable -> L42
            r9 = r9 ^ r5
            boolean r9 = r10.m4272e(r6, r1, r0, r9)     // Catch: java.lang.Throwable -> L42
            if (r9 == 0) goto Laf
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> L42
        La5:
            java.util.List r2 = p000.AbstractC2181p5.m9014B(r2, r6)     // Catch: java.lang.Throwable -> L42
            r1.m7441m(r5)
            r6 = r3
            goto L19
        Laf:
            java.lang.Throwable r11 = p000.AbstractC2623yo.m10924T(r6, r2)     // Catch: java.lang.Throwable -> L42
            throw r11     // Catch: java.lang.Throwable -> L42
        Lb4:
            r6 = move-exception
            java.io.IOException r9 = r6.m7462c()     // Catch: java.lang.Throwable -> L42
            boolean r9 = r10.m4272e(r9, r1, r0, r3)     // Catch: java.lang.Throwable -> L42
            if (r9 == 0) goto Lc6
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Throwable -> L42
            java.io.IOException r6 = r6.m7461b()     // Catch: java.lang.Throwable -> L42
            goto La5
        Lc6:
            java.io.IOException r11 = r6.m7461b()     // Catch: java.lang.Throwable -> L42
            java.lang.Throwable r11 = p000.AbstractC2623yo.m10924T(r11, r2)     // Catch: java.lang.Throwable -> L42
            throw r11     // Catch: java.lang.Throwable -> L42
        Lcf:
            java.io.IOException r11 = new java.io.IOException     // Catch: java.lang.Throwable -> L42
            java.lang.String r0 = "Canceled"
            r11.<init>(r0)     // Catch: java.lang.Throwable -> L42
            throw r11     // Catch: java.lang.Throwable -> L42
        Ld7:
            r1.m7441m(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0949Uk.mo302a(Be$a):Kk");
    }

    public final C0122Ck m4269b(C0490Kk c0490Kk, String str) {
        String strM2383w;
        C0069Bd c0069BdM256o;
        AbstractC0168Dk abstractC0168DkM490a = null;
        if (!this.f2863a.m1998s() || (strM2383w = C0490Kk.m2383w(c0490Kk, "Location", null, 2, null)) == null || (c0069BdM256o = c0490Kk.m2390S().m498i().m256o(strM2383w)) == null) {
            return null;
        }
        if (!AbstractC0116Ce.m472a(c0069BdM256o.m257p(), c0490Kk.m2390S().m498i().m257p()) && !this.f2863a.m1999t()) {
            return null;
        }
        C0122Ck.a aVarM497h = c0490Kk.m2390S().m497h();
        if (C0023Ad.m117a(str)) {
            int iM2396j = c0490Kk.m2396j();
            C0023Ad c0023Ad = C0023Ad.f66a;
            boolean z = c0023Ad.m120c(str) || iM2396j == 308 || iM2396j == 307;
            if (c0023Ad.m119b(str) && iM2396j != 308 && iM2396j != 307) {
                str = "GET";
            } else if (z) {
                abstractC0168DkM490a = c0490Kk.m2390S().m490a();
            }
            aVarM497h.m503e(str, abstractC0168DkM490a);
            if (!z) {
                aVarM497h.m505g("Transfer-Encoding");
                aVarM497h.m505g("Content-Length");
                aVarM497h.m505g("Content-Type");
            }
        }
        if (!AbstractC2623yo.m10932g(c0490Kk.m2390S().m498i(), c0069BdM256o)) {
            aVarM497h.m505g("Authorization");
        }
        return aVarM497h.m506h(c0069BdM256o).m500b();
    }

    public final C0122Ck m4270c(C0490Kk c0490Kk, C2287ra c2287ra) throws ProtocolException {
        C1741fk c1741fkM9367h;
        C1328bl c1328blM7637z = (c2287ra == null || (c1741fkM9367h = c2287ra.m9367h()) == null) ? null : c1741fkM9367h.m7637z();
        int iM2396j = c0490Kk.m2396j();
        String strM496g = c0490Kk.m2390S().m496g();
        if (iM2396j != 307 && iM2396j != 308) {
            if (iM2396j == 401) {
                return this.f2863a.m1987c().mo2575a(c1328blM7637z, c0490Kk);
            }
            if (iM2396j == 421) {
                AbstractC0168Dk abstractC0168DkM490a = c0490Kk.m2390S().m490a();
                if ((abstractC0168DkM490a != null && abstractC0168DkM490a.m723g()) || c2287ra == null || !c2287ra.m9370k()) {
                    return null;
                }
                c2287ra.m9367h().m7635x();
                return c0490Kk.m2390S();
            }
            if (iM2396j == 503) {
                C0490Kk c0490KkM2387E = c0490Kk.m2387E();
                if ((c0490KkM2387E == null || c0490KkM2387E.m2396j() != 503) && m4274g(c0490Kk, Integer.MAX_VALUE) == 0) {
                    return c0490Kk.m2390S();
                }
                return null;
            }
            if (iM2396j == 407) {
                AbstractC0116Ce.m473b(c1328blM7637z);
                if (c1328blM7637z.m5676b().type() == Proxy.Type.HTTP) {
                    return this.f2863a.m1979C().mo2575a(c1328blM7637z, c0490Kk);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iM2396j == 408) {
                if (!this.f2863a.m1982F()) {
                    return null;
                }
                AbstractC0168Dk abstractC0168DkM490a2 = c0490Kk.m2390S().m490a();
                if (abstractC0168DkM490a2 != null && abstractC0168DkM490a2.m723g()) {
                    return null;
                }
                C0490Kk c0490KkM2387E2 = c0490Kk.m2387E();
                if ((c0490KkM2387E2 == null || c0490KkM2387E2.m2396j() != 408) && m4274g(c0490Kk, 0) <= 0) {
                    return c0490Kk.m2390S();
                }
                return null;
            }
            switch (iM2396j) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return m4269b(c0490Kk, strM496g);
    }

    public final boolean m4271d(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    public final boolean m4272e(IOException iOException, C1694ek c1694ek, C0122Ck c0122Ck, boolean z) {
        if (this.f2863a.m1982F()) {
            return !(z && m4273f(iOException, c0122Ck)) && m4271d(iOException, z) && c1694ek.m7430B();
        }
        return false;
    }

    public final boolean m4273f(IOException iOException, C0122Ck c0122Ck) {
        AbstractC0168Dk abstractC0168DkM490a = c0122Ck.m490a();
        return (abstractC0168DkM490a != null && abstractC0168DkM490a.m723g()) || (iOException instanceof FileNotFoundException);
    }

    public final int m4274g(C0490Kk c0490Kk, int i) throws NumberFormatException {
        String strM2383w = C0490Kk.m2383w(c0490Kk, "Retry-After", null, 2, null);
        if (strM2383w == null) {
            return i;
        }
        if (!new C2389tk("\\d+").m9728a(strM2383w)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strM2383w);
        AbstractC0116Ce.m475d(numValueOf, "Integer.valueOf(header)");
        return numValueOf.intValue();
    }
}
