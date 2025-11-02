package p000;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class C0113Cb extends C0125Cn {

    public C0125Cn f260f;

    public C0113Cb(C0125Cn c0125Cn) {
        AbstractC0116Ce.m476e(c0125Cn, "delegate");
        this.f260f = c0125Cn;
    }

    @Override
    public C0125Cn mo433a() {
        return this.f260f.mo433a();
    }

    @Override
    public C0125Cn mo434b() {
        return this.f260f.mo434b();
    }

    @Override
    public long mo435c() {
        return this.f260f.mo435c();
    }

    @Override
    public C0125Cn mo436d(long j) {
        return this.f260f.mo436d(j);
    }

    @Override
    public boolean mo437e() {
        return this.f260f.mo437e();
    }

    @Override
    public void mo438f() throws InterruptedIOException {
        this.f260f.mo438f();
    }

    @Override
    public C0125Cn mo439g(long j, TimeUnit timeUnit) {
        AbstractC0116Ce.m476e(timeUnit, "unit");
        return this.f260f.mo439g(j, timeUnit);
    }

    public final C0125Cn m440i() {
        return this.f260f;
    }

    public final C0113Cb m441j(C0125Cn c0125Cn) {
        AbstractC0116Ce.m476e(c0125Cn, "delegate");
        this.f260f = c0125Cn;
        return this;
    }
}
