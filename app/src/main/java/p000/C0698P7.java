package p000;

import java.util.List;

/* loaded from: classes.dex */
public final class C0698P7 {

    public final byte[] f2078a;

    public int f2079b;

    public final String f2080c;

    public final List f2081d;

    public final String f2082e;

    public Integer f2083f;

    public Integer f2084g;

    public Object f2085h;

    public final int f2086i;

    public final int f2087j;

    public C0698P7(byte[] bArr, String str, List list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List m3476a() {
        return this.f2081d;
    }

    public String m3477b() {
        return this.f2082e;
    }

    public int m3478c() {
        return this.f2079b;
    }

    public Object m3479d() {
        return this.f2085h;
    }

    public byte[] m3480e() {
        return this.f2078a;
    }

    public int m3481f() {
        return this.f2086i;
    }

    public int m3482g() {
        return this.f2087j;
    }

    public String m3483h() {
        return this.f2080c;
    }

    public boolean m3484i() {
        return this.f2086i >= 0 && this.f2087j >= 0;
    }

    public void m3485j(Integer num) {
        this.f2084g = num;
    }

    public void m3486k(Integer num) {
        this.f2083f = num;
    }

    public void m3487l(int i) {
        this.f2079b = i;
    }

    public void m3488m(Object obj) {
        this.f2085h = obj;
    }

    public C0698P7(byte[] bArr, String str, List list, String str2, int i, int i2) {
        this.f2078a = bArr;
        this.f2079b = bArr == null ? 0 : bArr.length * 8;
        this.f2080c = str;
        this.f2081d = list;
        this.f2082e = str2;
        this.f2086i = i2;
        this.f2087j = i;
    }
}
