package p000;

/* loaded from: classes.dex */
public final class C1077Xa {

    public final int f3224a;

    public final int[] f3225b;

    public final C0857Sk[] f3226c;

    public C1077Xa(int i, int[] iArr, int i2, int i3, int i4) {
        this.f3224a = i;
        this.f3225b = iArr;
        float f = i2;
        float f2 = i4;
        this.f3226c = new C0857Sk[]{new C0857Sk(f, f2), new C0857Sk(i3, f2)};
    }

    public C0857Sk[] m4734a() {
        return this.f3226c;
    }

    public int[] m4735b() {
        return this.f3225b;
    }

    public int m4736c() {
        return this.f3224a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1077Xa) && this.f3224a == ((C1077Xa) obj).f3224a;
    }

    public int hashCode() {
        return this.f3224a;
    }
}
