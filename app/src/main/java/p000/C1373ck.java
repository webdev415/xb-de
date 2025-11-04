package p000;

import java.nio.ByteBuffer;

public final class C1373ck implements InterfaceC2501w3 {

    public final C2409u3 f3986l;

    public boolean f3987m;

    public final InterfaceC1134Yl f3988n;

    public C1373ck(InterfaceC1134Yl interfaceC1134Yl) {
        AbstractC0116Ce.m476e(interfaceC1134Yl, "sink");
        this.f3988n = interfaceC1134Yl;
        this.f3986l = new C2409u3();
    }

    @Override
    public InterfaceC2501w3 mo5925H(String str) {
        AbstractC0116Ce.m476e(str, "string");
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f3986l.mo5925H(str);
        return m5928a();
    }

    @Override
    public InterfaceC2501w3 mo5926L(int i) {
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f3986l.mo5926L(i);
        return m5928a();
    }

    @Override
    public InterfaceC2501w3 mo5927M(C0096C3 c0096c3) {
        AbstractC0116Ce.m476e(c0096c3, "byteString");
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f3986l.mo5927M(c0096c3);
        return m5928a();
    }

    public InterfaceC2501w3 m5928a() {
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        long jM9924j = this.f3986l.m9924j();
        if (jM9924j > 0) {
            this.f3988n.mo115h(this.f3986l, jM9924j);
        }
        return this;
    }

    @Override
    public C2409u3 mo5929c() {
        return this.f3986l;
    }

    @Override
    public void close() throws Throwable {
        if (this.f3987m) {
            return;
        }
        try {
            if (this.f3986l.m9911Y() > 0) {
                InterfaceC1134Yl interfaceC1134Yl = this.f3988n;
                C2409u3 c2409u3 = this.f3986l;
                interfaceC1134Yl.mo115h(c2409u3, c2409u3.m9911Y());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f3988n.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f3987m = true;
        if (th != null) {
            throw th;
        }
    }

    @Override
    public C0125Cn mo114d() {
        return this.f3988n.mo114d();
    }

    @Override
    public InterfaceC2501w3 mo5930e(byte[] bArr) {
        AbstractC0116Ce.m476e(bArr, "source");
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f3986l.mo5930e(bArr);
        return m5928a();
    }

    @Override
    public InterfaceC2501w3 mo5931f(byte[] bArr, int i, int i2) {
        AbstractC0116Ce.m476e(bArr, "source");
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f3986l.mo5931f(bArr, i, i2);
        return m5928a();
    }

    @Override
    public void flush() {
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f3986l.m9911Y() > 0) {
            InterfaceC1134Yl interfaceC1134Yl = this.f3988n;
            C2409u3 c2409u3 = this.f3986l;
            interfaceC1134Yl.mo115h(c2409u3, c2409u3.m9911Y());
        }
        this.f3988n.flush();
    }

    @Override
    public void mo115h(C2409u3 c2409u3, long j) {
        AbstractC0116Ce.m476e(c2409u3, "source");
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f3986l.mo115h(c2409u3, j);
        m5928a();
    }

    @Override
    public boolean isOpen() {
        return !this.f3987m;
    }

    @Override
    public InterfaceC2501w3 mo5932m(long j) {
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f3986l.mo5932m(j);
        return m5928a();
    }

    @Override
    public InterfaceC2501w3 mo5933t(int i) {
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f3986l.mo5933t(i);
        return m5928a();
    }

    public String toString() {
        return "buffer(" + this.f3988n + ')';
    }

    @Override
    public int write(ByteBuffer byteBuffer) {
        AbstractC0116Ce.m476e(byteBuffer, "source");
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f3986l.write(byteBuffer);
        m5928a();
        return iWrite;
    }

    @Override
    public InterfaceC2501w3 mo5934y(int i) {
        if (!(!this.f3987m)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f3986l.mo5934y(i);
        return m5928a();
    }
}
