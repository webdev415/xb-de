package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class RunnableC1146Yx implements Runnable {

    public final InterfaceC0870Sx f3369l;

    public final int f3370m;

    public final Throwable f3371n;

    public final byte[] f3372o;

    public final String f3373p;

    public final Map f3374q;

    public RunnableC1146Yx(String str, InterfaceC0870Sx interfaceC0870Sx, int i, Throwable th, byte[] bArr, Map map) {
        AbstractC1085Xi.m4801j(interfaceC0870Sx);
        this.f3369l = interfaceC0870Sx;
        this.f3370m = i;
        this.f3371n = th;
        this.f3372o = bArr;
        this.f3373p = str;
        this.f3374q = map;
    }

    @Override
    public final void run() {
        this.f3369l.mo430a(this.f3373p, this.f3370m, this.f3371n, this.f3372o, this.f3374q);
    }
}
