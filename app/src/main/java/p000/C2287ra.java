package p000;

import java.io.IOException;
import java.net.ProtocolException;
import p000.C0490Kk;

public final class C2287ra {

    public boolean f6915a;

    public final C1741fk f6916b;

    public final C1694ek f6917c;

    public final AbstractC1918ja f6918d;

    public final C2379ta f6919e;

    public final InterfaceC2333sa f6920f;

    public final class a extends AbstractC0021Ab {

        public boolean f6921m;

        public long f6922n;

        public boolean f6923o;

        public final long f6924p;

        public final C2287ra f6925q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C2287ra c2287ra, InterfaceC1134Yl interfaceC1134Yl, long j) {
            super(interfaceC1134Yl);
            AbstractC0116Ce.m476e(interfaceC1134Yl, "delegate");
            this.f6925q = c2287ra;
            this.f6924p = j;
        }

        private final IOException m9380a(IOException iOException) {
            if (this.f6921m) {
                return iOException;
            }
            this.f6921m = true;
            return this.f6925q.m9360a(this.f6922n, false, true, iOException);
        }

        @Override
        public void close() throws IOException {
            if (this.f6923o) {
                return;
            }
            this.f6923o = true;
            long j = this.f6924p;
            if (j != -1 && this.f6922n != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                m9380a(null);
            } catch (IOException e) {
                throw m9380a(e);
            }
        }

        @Override
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw m9380a(e);
            }
        }

        @Override
        public void mo115h(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "source");
            if (!(!this.f6923o)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.f6924p;
            if (j2 == -1 || this.f6922n + j <= j2) {
                try {
                    super.mo115h(c2409u3, j);
                    this.f6922n += j;
                    return;
                } catch (IOException e) {
                    throw m9380a(e);
                }
            }
            throw new ProtocolException("expected " + this.f6924p + " bytes but received " + (this.f6922n + j));
        }
    }

    public final class b extends AbstractC0067Bb {

        public long f6926m;

        public boolean f6927n;

        public boolean f6928o;

        public boolean f6929p;

        public final long f6930q;

        public final C2287ra f6931r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C2287ra c2287ra, InterfaceC2161om interfaceC2161om, long j) {
            super(interfaceC2161om);
            AbstractC0116Ce.m476e(interfaceC2161om, "delegate");
            this.f6931r = c2287ra;
            this.f6930q = j;
            this.f6927n = true;
            if (j == 0) {
                m9381b(null);
            }
        }

        public final IOException m9381b(IOException iOException) {
            if (this.f6928o) {
                return iOException;
            }
            this.f6928o = true;
            if (iOException == null && this.f6927n) {
                this.f6927n = false;
                this.f6931r.m9368i().m8153v(this.f6931r.m9366g());
            }
            return this.f6931r.m9360a(this.f6926m, true, false, iOException);
        }

        @Override
        public void close() throws IOException {
            if (this.f6929p) {
                return;
            }
            this.f6929p = true;
            try {
                super.close();
                m9381b(null);
            } catch (IOException e) {
                throw m9381b(e);
            }
        }

        @Override
        public long mo1488n(C2409u3 c2409u3, long j) throws IOException {
            AbstractC0116Ce.m476e(c2409u3, "sink");
            if (!(!this.f6929p)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long jMo1488n = m238a().mo1488n(c2409u3, j);
                if (this.f6927n) {
                    this.f6927n = false;
                    this.f6931r.m9368i().m8153v(this.f6931r.m9366g());
                }
                if (jMo1488n == -1) {
                    m9381b(null);
                    return -1L;
                }
                long j2 = this.f6926m + jMo1488n;
                long j3 = this.f6930q;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.f6930q + " bytes but received " + j2);
                }
                this.f6926m = j2;
                if (j2 == j3) {
                    m9381b(null);
                }
                return jMo1488n;
            } catch (IOException e) {
                throw m9381b(e);
            }
        }
    }

    public C2287ra(C1694ek c1694ek, AbstractC1918ja abstractC1918ja, C2379ta c2379ta, InterfaceC2333sa interfaceC2333sa) {
        AbstractC0116Ce.m476e(c1694ek, "call");
        AbstractC0116Ce.m476e(abstractC1918ja, "eventListener");
        AbstractC0116Ce.m476e(c2379ta, "finder");
        AbstractC0116Ce.m476e(interfaceC2333sa, "codec");
        this.f6917c = c1694ek;
        this.f6918d = abstractC1918ja;
        this.f6919e = c2379ta;
        this.f6920f = interfaceC2333sa;
        this.f6916b = interfaceC2333sa.mo9537h();
    }

    public final IOException m9360a(long j, boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            m9378s(iOException);
        }
        if (z2) {
            AbstractC1918ja abstractC1918ja = this.f6918d;
            C1694ek c1694ek = this.f6917c;
            if (iOException != null) {
                abstractC1918ja.m8149r(c1694ek, iOException);
            } else {
                abstractC1918ja.m8147p(c1694ek, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.f6918d.m8154w(this.f6917c, iOException);
            } else {
                this.f6918d.m8152u(this.f6917c, j);
            }
        }
        return this.f6917c.m7451x(this, z2, z, iOException);
    }

    public final void m9361b() {
        this.f6920f.cancel();
    }

    public final InterfaceC1134Yl m9362c(C0122Ck c0122Ck, boolean z) {
        AbstractC0116Ce.m476e(c0122Ck, "request");
        this.f6915a = z;
        AbstractC0168Dk abstractC0168DkM490a = c0122Ck.m490a();
        AbstractC0116Ce.m473b(abstractC0168DkM490a);
        long jMo720a = abstractC0168DkM490a.mo720a();
        this.f6918d.m8148q(this.f6917c);
        return new a(this, this.f6920f.mo9535f(c0122Ck, jMo720a), jMo720a);
    }

    public final void m9363d() {
        this.f6920f.cancel();
        this.f6917c.m7451x(this, true, true, null);
    }

    public final void m9364e() {
        try {
            this.f6920f.mo9532c();
        } catch (IOException e) {
            this.f6918d.m8149r(this.f6917c, e);
            m9378s(e);
            throw e;
        }
    }

    public final void m9365f() {
        try {
            this.f6920f.mo9533d();
        } catch (IOException e) {
            this.f6918d.m8149r(this.f6917c, e);
            m9378s(e);
            throw e;
        }
    }

    public final C1694ek m9366g() {
        return this.f6917c;
    }

    public final C1741fk m9367h() {
        return this.f6916b;
    }

    public final AbstractC1918ja m9368i() {
        return this.f6918d;
    }

    public final C2379ta m9369j() {
        return this.f6919e;
    }

    public final boolean m9370k() {
        return !AbstractC0116Ce.m472a(this.f6919e.m9696d().m10421l().m249h(), this.f6916b.m7637z().m5675a().m10421l().m249h());
    }

    public final boolean m9371l() {
        return this.f6915a;
    }

    public final void m9372m() {
        this.f6920f.mo9537h().m7636y();
    }

    public final void m9373n() {
        this.f6917c.m7451x(this, true, false, null);
    }

    public final AbstractC0536Lk m9374o(C0490Kk c0490Kk) {
        AbstractC0116Ce.m476e(c0490Kk, "response");
        try {
            String strM2383w = C0490Kk.m2383w(c0490Kk, "Content-Type", null, 2, null);
            long jMo9536g = this.f6920f.mo9536g(c0490Kk);
            return new C1928jk(strM2383w, jMo9536g, AbstractC0487Kh.m2376b(new b(this, this.f6920f.mo9531b(c0490Kk), jMo9536g)));
        } catch (IOException e) {
            this.f6918d.m8154w(this.f6917c, e);
            m9378s(e);
            throw e;
        }
    }

    public final C0490Kk.a m9375p(boolean z) {
        try {
            C0490Kk.a aVarMo9534e = this.f6920f.mo9534e(z);
            if (aVarMo9534e != null) {
                aVarMo9534e.m2413l(this);
            }
            return aVarMo9534e;
        } catch (IOException e) {
            this.f6918d.m8154w(this.f6917c, e);
            m9378s(e);
            throw e;
        }
    }

    public final void m9376q(C0490Kk c0490Kk) {
        AbstractC0116Ce.m476e(c0490Kk, "response");
        this.f6918d.m8155x(this.f6917c, c0490Kk);
    }

    public final void m9377r() {
        this.f6918d.m8156y(this.f6917c);
    }

    public final void m9378s(IOException iOException) {
        this.f6919e.m9700h(iOException);
        this.f6920f.mo9537h().m7612G(this.f6917c, iOException);
    }

    public final void m9379t(C0122Ck c0122Ck) {
        AbstractC0116Ce.m476e(c0122Ck, "request");
        try {
            this.f6918d.m8151t(this.f6917c);
            this.f6920f.mo9530a(c0122Ck);
            this.f6918d.m8150s(this.f6917c, c0122Ck);
        } catch (IOException e) {
            this.f6918d.m8149r(this.f6917c, e);
            m9378s(e);
            throw e;
        }
    }
}
