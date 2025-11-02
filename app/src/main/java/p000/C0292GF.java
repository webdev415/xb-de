package p000;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class C0292GF implements InterfaceC0870Sx {

    public final String f871a;

    public final List f872b;

    public final C0200EF f873c;

    public C0292GF(C0200EF c0200ef, String str, List list) {
        this.f871a = str;
        this.f872b = list;
        this.f873c = c0200ef;
    }

    @Override
    public final void mo430a(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.f873c.m918K(true, i, th, bArr, this.f871a, this.f872b);
    }
}
