package p000;

public class C2253qm implements Cloneable {

    public static final Object f6732p = new Object();

    public boolean f6733l;

    public int[] f6734m;

    public Object[] f6735n;

    public int f6736o;

    public C2253qm() {
        this(10);
    }

    public void m9164a() {
        int i = this.f6736o;
        Object[] objArr = this.f6735n;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f6736o = 0;
        this.f6733l = false;
    }

    public C2253qm clone() {
        try {
            C2253qm c2253qm = (C2253qm) super.clone();
            c2253qm.f6734m = (int[]) this.f6734m.clone();
            c2253qm.f6735n = (Object[]) this.f6735n.clone();
            return c2253qm;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void m9166c() {
        int i = this.f6736o;
        int[] iArr = this.f6734m;
        Object[] objArr = this.f6735n;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f6732p) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f6733l = false;
        this.f6736o = i2;
    }

    public Object m9167d(int i) {
        return m9168e(i, null);
    }

    public Object m9168e(int i, Object obj) {
        Object obj2;
        int iM9032a = AbstractC2182p6.m9032a(this.f6734m, this.f6736o, i);
        return (iM9032a < 0 || (obj2 = this.f6735n[iM9032a]) == f6732p) ? obj : obj2;
    }

    public int m9169f(int i) {
        if (this.f6733l) {
            m9166c();
        }
        return this.f6734m[i];
    }

    public void m9170h(int i, Object obj) {
        int iM9032a = AbstractC2182p6.m9032a(this.f6734m, this.f6736o, i);
        if (iM9032a >= 0) {
            this.f6735n[iM9032a] = obj;
            return;
        }
        int i2 = ~iM9032a;
        int i3 = this.f6736o;
        if (i2 < i3) {
            Object[] objArr = this.f6735n;
            if (objArr[i2] == f6732p) {
                this.f6734m[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f6733l && i3 >= this.f6734m.length) {
            m9166c();
            i2 = ~AbstractC2182p6.m9032a(this.f6734m, this.f6736o, i);
        }
        int i4 = this.f6736o;
        if (i4 >= this.f6734m.length) {
            int iM9035d = AbstractC2182p6.m9035d(i4 + 1);
            int[] iArr = new int[iM9035d];
            Object[] objArr2 = new Object[iM9035d];
            int[] iArr2 = this.f6734m;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f6735n;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f6734m = iArr;
            this.f6735n = objArr2;
        }
        int i5 = this.f6736o;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.f6734m;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.f6735n;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f6736o - i2);
        }
        this.f6734m[i2] = i;
        this.f6735n[i2] = obj;
        this.f6736o++;
    }

    public void m9171j(int i) {
        int iM9032a = AbstractC2182p6.m9032a(this.f6734m, this.f6736o, i);
        if (iM9032a >= 0) {
            Object[] objArr = this.f6735n;
            Object obj = objArr[iM9032a];
            Object obj2 = f6732p;
            if (obj != obj2) {
                objArr[iM9032a] = obj2;
                this.f6733l = true;
            }
        }
    }

    public int m9172m() {
        if (this.f6733l) {
            m9166c();
        }
        return this.f6736o;
    }

    public Object m9173n(int i) {
        if (this.f6733l) {
            m9166c();
        }
        return this.f6735n[i];
    }

    public String toString() {
        if (m9172m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6736o * 28);
        sb.append('{');
        for (int i = 0; i < this.f6736o; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m9169f(i));
            sb.append('=');
            Object objM9173n = m9173n(i);
            if (objM9173n != this) {
                sb.append(objM9173n);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C2253qm(int i) {
        this.f6733l = false;
        if (i == 0) {
            this.f6734m = AbstractC2182p6.f6629a;
            this.f6735n = AbstractC2182p6.f6631c;
        } else {
            int iM9035d = AbstractC2182p6.m9035d(i);
            this.f6734m = new int[iM9035d];
            this.f6735n = new Object[iM9035d];
        }
    }
}
