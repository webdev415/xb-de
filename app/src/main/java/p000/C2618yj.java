package p000;

public final class C2618yj {

    public EnumC0991Vg f8111a;

    public EnumC1363ca f8112b;

    public C0126Co f8113c;

    public int f8114d = -1;

    public C0050B3 f8115e;

    public static boolean m10893b(int i) {
        return i >= 0 && i < 8;
    }

    public C0050B3 m10894a() {
        return this.f8115e;
    }

    public void m10895c(EnumC1363ca enumC1363ca) {
        this.f8112b = enumC1363ca;
    }

    public void m10896d(int i) {
        this.f8114d = i;
    }

    public void m10897e(C0050B3 c0050b3) {
        this.f8115e = c0050b3;
    }

    public void m10898f(EnumC0991Vg enumC0991Vg) {
        this.f8111a = enumC0991Vg;
    }

    public void m10899g(C0126Co c0126Co) {
        this.f8113c = c0126Co;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f8111a);
        sb.append("\n ecLevel: ");
        sb.append(this.f8112b);
        sb.append("\n version: ");
        sb.append(this.f8113c);
        sb.append("\n maskPattern: ");
        sb.append(this.f8114d);
        if (this.f8115e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f8115e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
