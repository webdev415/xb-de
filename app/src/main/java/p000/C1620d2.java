package p000;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;
import p000.AbstractC0619Nb;
import p000.AbstractComponentCallbacksC0159Db;
import p000.LayoutInflaterFactory2C0435Jb;

/* loaded from: classes.dex */
public final class C1620d2 extends AbstractC0619Nb implements LayoutInflaterFactory2C0435Jb.e {

    public final LayoutInflaterFactory2C0435Jb f5267s;

    public boolean f5268t;

    public int f5269u = -1;

    public C1620d2(LayoutInflaterFactory2C0435Jb layoutInflaterFactory2C0435Jb) {
        this.f5267s = layoutInflaterFactory2C0435Jb;
    }

    public static boolean m7279l(a aVar) {
        aVar.getClass();
        return false;
    }

    @Override
    public boolean mo1962a(ArrayList arrayList, ArrayList arrayList2) {
        if (LayoutInflaterFactory2C0435Jb.f1323F) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1936h) {
            return true;
        }
        this.f5267s.m1931f(this);
        return true;
    }

    public void m7280c(int i) {
        if (this.f1936h) {
            if (LayoutInflaterFactory2C0435Jb.f1323F) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f1929a.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a) this.f1929a.get(i2)).getClass();
            }
        }
    }

    public void m7281d(String str, PrintWriter printWriter) {
        m7282e(str, printWriter, true);
    }

    public void m7282e(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1938j);
            printWriter.print(" mIndex=");
            printWriter.print(this.f5269u);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f5268t);
            if (this.f1934f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1934f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1935g));
            }
            if (this.f1930b != 0 || this.f1931c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1930b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1931c));
            }
            if (this.f1932d != 0 || this.f1933e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1932d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1933e));
            }
            if (this.f1939k != 0 || this.f1940l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1939k));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1940l);
            }
            if (this.f1941m != 0 || this.f1942n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1941m));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1942n);
            }
        }
        if (this.f1929a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1929a.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.f1929a.get(i);
            switch (aVar.f1947a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f1947a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println((Object) null);
            if (z) {
                if (aVar.f1948b != 0 || aVar.f1949c != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1948b));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1949c));
                }
                if (aVar.f1950d != 0 || aVar.f1951e != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1950d));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1951e));
                }
            }
        }
    }

    public void m7283f() {
        int size = this.f1929a.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.f1929a.get(i);
            aVar.getClass();
            switch (aVar.f1947a) {
                case 1:
                    throw null;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1947a);
                case 3:
                    throw null;
                case 4:
                    throw null;
                case 5:
                    throw null;
                case 6:
                    throw null;
                case 7:
                    throw null;
                case 8:
                case 9:
                    this.f5267s.m1942k0(null);
                    break;
                case 10:
                    this.f5267s.m1940j0(null, aVar.f1953g);
                    break;
            }
        }
        if (this.f1945q) {
            return;
        }
        LayoutInflaterFactory2C0435Jb layoutInflaterFactory2C0435Jb = this.f5267s;
        layoutInflaterFactory2C0435Jb.m1922X(layoutInflaterFactory2C0435Jb.f1344p, true);
    }

    public void m7284g(boolean z) {
        for (int size = this.f1929a.size() - 1; size >= 0; size--) {
            a aVar = (a) this.f1929a.get(size);
            aVar.getClass();
            switch (aVar.f1947a) {
                case 1:
                    throw null;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1947a);
                case 3:
                    throw null;
                case 4:
                    throw null;
                case 5:
                    throw null;
                case 6:
                    throw null;
                case 7:
                    throw null;
                case 8:
                case 9:
                    this.f5267s.m1942k0(null);
                    break;
                case 10:
                    this.f5267s.m1940j0(null, aVar.f1952f);
                    break;
            }
        }
        if (this.f1945q || !z) {
            return;
        }
        LayoutInflaterFactory2C0435Jb layoutInflaterFactory2C0435Jb = this.f5267s;
        layoutInflaterFactory2C0435Jb.m1922X(layoutInflaterFactory2C0435Jb.f1344p, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AbstractComponentCallbacksC0159Db m7285h(ArrayList r7, AbstractComponentCallbacksC0159Db r8) {
        /*
            r6 = this;
            r0 = 0
        L1:
            java.util.ArrayList r1 = r6.f1929a
            int r1 = r1.size()
            if (r0 >= r1) goto L4c
            java.util.ArrayList r1 = r6.f1929a
            java.lang.Object r1 = r1.get(r0)
            Nb$a r1 = (p000.AbstractC0619Nb.a) r1
            int r1 = r1.f1947a
            r2 = 1
            r3 = 0
            if (r1 == r2) goto L47
            r4 = 2
            if (r1 == r4) goto L46
            r4 = 3
            r5 = 9
            if (r1 == r4) goto L38
            r4 = 6
            if (r1 == r4) goto L38
            r4 = 7
            if (r1 == r4) goto L47
            r4 = 8
            if (r1 == r4) goto L2a
            goto L4a
        L2a:
            java.util.ArrayList r1 = r6.f1929a
            Nb$a r4 = new Nb$a
            r4.<init>(r5, r8)
            r1.add(r0, r4)
        L34:
            int r0 = r0 + 1
            r8 = r3
            goto L4a
        L38:
            r7.remove(r3)
            java.util.ArrayList r8 = r6.f1929a
            Nb$a r1 = new Nb$a
            r1.<init>(r5, r3)
            r8.add(r0, r1)
            goto L34
        L46:
            throw r3
        L47:
            r7.add(r3)
        L4a:
            int r0 = r0 + r2
            goto L1
        L4c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1620d2.m7285h(java.util.ArrayList, Db):Db");
    }

    public String m7286i() {
        return this.f1938j;
    }

    public boolean m7287j(int i) {
        int size = this.f1929a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((a) this.f1929a.get(i2)).getClass();
        }
        return false;
    }

    public boolean m7288k(ArrayList arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f1929a.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((a) this.f1929a.get(i3)).getClass();
        }
        return false;
    }

    public boolean m7289m() {
        for (int i = 0; i < this.f1929a.size(); i++) {
            if (m7279l((a) this.f1929a.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void m7290n() {
        if (this.f1946r != null) {
            for (int i = 0; i < this.f1946r.size(); i++) {
                ((Runnable) this.f1946r.get(i)).run();
            }
            this.f1946r = null;
        }
    }

    public void m7291o(AbstractComponentCallbacksC0159Db.b bVar) {
        for (int i = 0; i < this.f1929a.size(); i++) {
            a aVar = (a) this.f1929a.get(i);
            if (m7279l(aVar)) {
                aVar.getClass();
                throw null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AbstractComponentCallbacksC0159Db m7292p(ArrayList r7, AbstractComponentCallbacksC0159Db r8) {
        /*
            r6 = this;
            java.util.ArrayList r0 = r6.f1929a
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L2f
            java.util.ArrayList r2 = r6.f1929a
            java.lang.Object r2 = r2.get(r0)
            Nb$a r2 = (p000.AbstractC0619Nb.a) r2
            int r3 = r2.f1947a
            r4 = 0
            if (r3 == r1) goto L29
            r5 = 3
            if (r3 == r5) goto L25
            switch(r3) {
                case 6: goto L25;
                case 7: goto L29;
                case 8: goto L23;
                case 9: goto L23;
                case 10: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L2c
        L1e:
            androidx.lifecycle.c$b r3 = r2.f1952f
            r2.f1953g = r3
            goto L2c
        L23:
            r8 = r4
            goto L2c
        L25:
            r7.add(r4)
            goto L2c
        L29:
            r7.remove(r4)
        L2c:
            int r0 = r0 + (-1)
            goto L8
        L2f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1620d2.m7292p(java.util.ArrayList, Db):Db");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f5269u >= 0) {
            sb.append(" #");
            sb.append(this.f5269u);
        }
        if (this.f1938j != null) {
            sb.append(" ");
            sb.append(this.f1938j);
        }
        sb.append("}");
        return sb.toString();
    }
}
