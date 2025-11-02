package p000;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class C0720Pk {

    public final String f2169a;

    public final byte[] f2170b;

    public final int f2171c;

    public C0857Sk[] f2172d;

    public final BarcodeFormat f2173e;

    public Map f2174f;

    public final long f2175g;

    public C0720Pk(String str, byte[] bArr, int i, C0857Sk[] c0857SkArr, BarcodeFormat barcodeFormat, long j) {
        this.f2169a = str;
        this.f2170b = bArr;
        this.f2171c = i;
        this.f2172d = c0857SkArr;
        this.f2173e = barcodeFormat;
        this.f2174f = null;
        this.f2175g = j;
    }

    public void m3575a(C0857Sk[] c0857SkArr) {
        C0857Sk[] c0857SkArr2 = this.f2172d;
        if (c0857SkArr2 == null) {
            this.f2172d = c0857SkArr;
            return;
        }
        if (c0857SkArr == null || c0857SkArr.length <= 0) {
            return;
        }
        C0857Sk[] c0857SkArr3 = new C0857Sk[c0857SkArr2.length + c0857SkArr.length];
        System.arraycopy(c0857SkArr2, 0, c0857SkArr3, 0, c0857SkArr2.length);
        System.arraycopy(c0857SkArr, 0, c0857SkArr3, c0857SkArr2.length, c0857SkArr.length);
        this.f2172d = c0857SkArr3;
    }

    public BarcodeFormat m3576b() {
        return this.f2173e;
    }

    public byte[] m3577c() {
        return this.f2170b;
    }

    public Map m3578d() {
        return this.f2174f;
    }

    public C0857Sk[] m3579e() {
        return this.f2172d;
    }

    public String m3580f() {
        return this.f2169a;
    }

    public void m3581g(Map map) {
        if (map != null) {
            Map map2 = this.f2174f;
            if (map2 == null) {
                this.f2174f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void m3582h(EnumC0811Rk enumC0811Rk, Object obj) {
        if (this.f2174f == null) {
            this.f2174f = new EnumMap(EnumC0811Rk.class);
        }
        this.f2174f.put(enumC0811Rk, obj);
    }

    public String toString() {
        return this.f2169a;
    }

    public C0720Pk(String str, byte[] bArr, C0857Sk[] c0857SkArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, c0857SkArr, barcodeFormat, System.currentTimeMillis());
    }

    public C0720Pk(String str, byte[] bArr, C0857Sk[] c0857SkArr, BarcodeFormat barcodeFormat, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, c0857SkArr, barcodeFormat, j);
    }
}
