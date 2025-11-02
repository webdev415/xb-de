package p000;

import java.util.Iterator;
import java.util.LinkedList;

public final class C2437um {

    public static final C2437um f7565e = new C2437um(AbstractC0217En.f535b, 0, 0, 0);

    public final int f7566a;

    public final AbstractC0217En f7567b;

    public final int f7568c;

    public final int f7569d;

    public C2437um(AbstractC0217En abstractC0217En, int i, int i2, int i3) {
        this.f7567b = abstractC0217En;
        this.f7566a = i;
        this.f7568c = i2;
        this.f7569d = i3;
    }

    public static int m10185b(C2437um c2437um) {
        int i = c2437um.f7568c;
        if (i > 62) {
            return 21;
        }
        if (i > 31) {
            return 20;
        }
        return i > 0 ? 10 : 0;
    }

    public C2437um m10186a(int i) {
        AbstractC0217En abstractC0217EnM1077a = this.f7567b;
        int i2 = this.f7566a;
        int i3 = this.f7569d;
        if (i2 == 4 || i2 == 2) {
            int i4 = C2059md.f6176c[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            abstractC0217EnM1077a = abstractC0217EnM1077a.m1077a(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.f7568c;
        C2437um c2437um = new C2437um(abstractC0217EnM1077a, i2, i7 + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return c2437um.f7568c == 2078 ? c2437um.m10187c(i + 1) : c2437um;
    }

    public C2437um m10187c(int i) {
        int i2 = this.f7568c;
        return i2 == 0 ? this : new C2437um(this.f7567b.m1078b(i - i2, i2), this.f7566a, 0, this.f7569d);
    }

    public int m10188d() {
        return this.f7568c;
    }

    public int m10189e() {
        return this.f7569d;
    }

    public int m10190f() {
        return this.f7566a;
    }

    public boolean m10191g(C2437um c2437um) {
        int iM10185b = this.f7569d + (C2059md.f6176c[this.f7566a][c2437um.f7566a] >> 16);
        int i = this.f7568c;
        int i2 = c2437um.f7568c;
        if (i < i2) {
            iM10185b += m10185b(c2437um) - m10185b(this);
        } else if (i > i2 && i2 > 0) {
            iM10185b += 10;
        }
        return iM10185b <= c2437um.f7569d;
    }

    public C2437um m10192h(int i, int i2) {
        int i3 = this.f7569d;
        AbstractC0217En abstractC0217EnM1077a = this.f7567b;
        int i4 = this.f7566a;
        if (i != i4) {
            int i5 = C2059md.f6176c[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            abstractC0217EnM1077a = abstractC0217EnM1077a.m1077a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new C2437um(abstractC0217EnM1077a.m1077a(i2, i8), i, 0, i3 + i8);
    }

    public C2437um m10193i(int i, int i2) {
        AbstractC0217En abstractC0217En = this.f7567b;
        int i3 = this.f7566a;
        int i4 = i3 == 2 ? 4 : 5;
        return new C2437um(abstractC0217En.m1077a(C2059md.f6178e[i3][i], i4).m1077a(i2, 5), this.f7566a, 0, this.f7569d + i4 + 5);
    }

    public C0233F2 m10194j(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (AbstractC0217En abstractC0217EnM1079d = m10187c(bArr.length).f7567b; abstractC0217EnM1079d != null; abstractC0217EnM1079d = abstractC0217EnM1079d.m1079d()) {
            linkedList.addFirst(abstractC0217EnM1079d);
        }
        C0233F2 c0233f2 = new C0233F2();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((AbstractC0217En) it.next()).mo848c(c0233f2, bArr);
        }
        return c0233f2;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", C2059md.f6175b[this.f7566a], Integer.valueOf(this.f7569d), Integer.valueOf(this.f7568c));
    }
}
