package p000;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.AbstractC1255c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.AbstractComponentCallbacksC0159Db;

public final class LayoutInflaterFactory2C0435Jb extends AbstractC0389Ib implements LayoutInflater.Factory2 {

    public static boolean f1323F = false;

    public static final Interpolator f1324G = new DecelerateInterpolator(2.5f);

    public static final Interpolator f1325H = new DecelerateInterpolator(1.5f);

    public ArrayList f1328C;

    public C0527Lb f1329D;

    public ArrayList f1331c;

    public boolean f1332d;

    public ArrayList f1336h;

    public ArrayList f1337i;

    public OnBackPressedDispatcher f1338j;

    public ArrayList f1340l;

    public ArrayList f1341m;

    public ArrayList f1342n;

    public AbstractC0343Hb f1345q;

    public AbstractC0205Eb f1346r;

    public boolean f1347s;

    public boolean f1348t;

    public boolean f1349u;

    public boolean f1350v;

    public boolean f1351w;

    public ArrayList f1352x;

    public ArrayList f1353y;

    public ArrayList f1354z;

    public int f1333e = 0;

    public final ArrayList f1334f = new ArrayList<>();

    public final HashMap f1335g = new HashMap<>();

    public final AbstractC0671Oh f1339k = new a(false);

    public final CopyOnWriteArrayList f1343o = new CopyOnWriteArrayList();

    public int f1344p = 0;

    public Bundle f1326A = null;

    public SparseArray f1327B = null;

    public Runnable f1330E = new b();

    public class a extends AbstractC0671Oh {
        public a(boolean z) {
            super(z);
        }

        @Override
        public void mo1961b() {
            LayoutInflaterFactory2C0435Jb.this.m1917S();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override
        public void run() {
            LayoutInflaterFactory2C0435Jb.this.m1906G();
        }
    }

    public class c extends C0297Gb {
        public c() {
        }

        @Override
        public AbstractComponentCallbacksC0159Db mo1376a(ClassLoader classLoader, String str) {
            AbstractC0343Hb abstractC0343Hb = LayoutInflaterFactory2C0435Jb.this.f1345q;
            abstractC0343Hb.m1028a(abstractC0343Hb.m1565h(), str, null);
            return null;
        }
    }

    public static class d {

        public static final int[] f1358a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    public interface e {
        boolean mo1962a(ArrayList arrayList, ArrayList arrayList2);
    }

    public static class f implements AbstractComponentCallbacksC0159Db.b {

        public final boolean f1359a;

        public final C1620d2 f1360b;

        public int f1361c;

        public f(C1620d2 c1620d2, boolean z) {
            this.f1359a = z;
            this.f1360b = c1620d2;
        }

        public void m1963a() {
            C1620d2 c1620d2 = this.f1360b;
            c1620d2.f5267s.m1941k(c1620d2, this.f1359a, false, false);
        }

        public void m1964b() {
            boolean z = this.f1361c > 0;
            LayoutInflaterFactory2C0435Jb layoutInflaterFactory2C0435Jb = this.f1360b.f5267s;
            if (layoutInflaterFactory2C0435Jb.f1334f.size() > 0) {
                AbstractC2524wh.m10586a(layoutInflaterFactory2C0435Jb.f1334f.get(0));
                throw null;
            }
            C1620d2 c1620d2 = this.f1360b;
            c1620d2.f5267s.m1941k(c1620d2, this.f1359a, !z, true);
        }

        public boolean m1965c() {
            return this.f1361c == 0;
        }
    }

    public static void m1899H(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        while (i < i2) {
            C1620d2 c1620d2 = (C1620d2) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                c1620d2.m7280c(-1);
                c1620d2.m7284g(i == i2 + (-1));
            } else {
                c1620d2.m7280c(1);
                c1620d2.m7283f();
            }
            i++;
        }
    }

    public void m1900A() {
        this.f1348t = false;
        this.f1349u = false;
        m1901B(3);
    }

    public final void m1901B(int i) {
        try {
            this.f1332d = true;
            m1922X(i, false);
            this.f1332d = false;
            m1906G();
        } catch (Throwable th) {
            this.f1332d = false;
            throw th;
        }
    }

    public void m1902C() {
        this.f1349u = true;
        m1901B(2);
    }

    public void m1903D() {
        if (this.f1351w) {
            this.f1351w = false;
            m1944l0();
        }
    }

    public final void m1904E() {
        Iterator it = this.f1335g.values().iterator();
        while (it.hasNext()) {
            AbstractC2524wh.m10586a(it.next());
        }
    }

    public final void m1905F(boolean z) {
        if (this.f1332d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f1345q == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.f1345q.m1566i().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            m1937i();
        }
        if (this.f1352x == null) {
            this.f1352x = new ArrayList<>();
            this.f1353y = new ArrayList<>();
        }
        this.f1332d = true;
        try {
            m1908J(null, null);
        } finally {
            this.f1332d = false;
        }
    }

    public boolean m1906G() {
        m1905F(true);
        boolean z = false;
        while (m1914P(this.f1352x, this.f1353y)) {
            this.f1332d = true;
            try {
                m1930e0(this.f1352x, this.f1353y);
                m1939j();
                z = true;
            } catch (Throwable th) {
                m1939j();
                throw th;
            }
        }
        m1948n0();
        m1903D();
        m1935h();
        return z;
    }

    public final void m1907I(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        boolean z = ((C1620d2) arrayList.get(i5)).f1945q;
        ArrayList arrayList3 = this.f1354z;
        if (arrayList3 == null) {
            this.f1354z = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.f1354z.addAll(this.f1334f);
        m1916R();
        boolean z2 = false;
        for (int i6 = i5; i6 < i2; i6++) {
            C1620d2 c1620d2 = (C1620d2) arrayList.get(i6);
            if (((Boolean) arrayList2.get(i6)).booleanValue()) {
                c1620d2.m7292p(this.f1354z, null);
            } else {
                c1620d2.m7285h(this.f1354z, null);
            }
            z2 = z2 || c1620d2.f1936h;
        }
        this.f1354z.clear();
        if (!z) {
            AbstractC0665Ob.m3413s(this, arrayList, arrayList2, i, i2, false);
        }
        m1899H(arrayList, arrayList2, i, i2);
        if (z) {
            C2499w1 c2499w1 = new C2499w1();
            m1929e(c2499w1);
            int iM1928d0 = m1928d0(arrayList, arrayList2, i, i2, c2499w1);
            m1920V(c2499w1);
            i3 = iM1928d0;
        } else {
            i3 = i2;
        }
        if (i3 != i5 && z) {
            AbstractC0665Ob.m3413s(this, arrayList, arrayList2, i, i3, true);
            m1922X(this.f1344p, true);
        }
        while (i5 < i2) {
            C1620d2 c1620d22 = (C1620d2) arrayList.get(i5);
            if (((Boolean) arrayList2.get(i5)).booleanValue() && (i4 = c1620d22.f5269u) >= 0) {
                m1913O(i4);
                c1620d22.f5269u = -1;
            }
            c1620d22.m7290n();
            i5++;
        }
        if (z2) {
            m1932f0();
        }
    }

    public final void m1908J(ArrayList arrayList, ArrayList arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList arrayList3 = this.f1328C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            f fVar = (f) this.f1328C.get(i);
            if (arrayList == null || fVar.f1359a || (iIndexOf2 = arrayList.indexOf(fVar.f1360b)) == -1 || !((Boolean) arrayList2.get(iIndexOf2)).booleanValue()) {
                if (fVar.m1965c() || (arrayList != null && fVar.f1360b.m7288k(arrayList, 0, arrayList.size()))) {
                    this.f1328C.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || fVar.f1359a || (iIndexOf = arrayList.indexOf(fVar.f1360b)) == -1 || !((Boolean) arrayList2.get(iIndexOf)).booleanValue()) {
                        fVar.m1964b();
                    }
                }
                i++;
            } else {
                this.f1328C.remove(i);
                i--;
                size--;
            }
            fVar.m1963a();
            i++;
        }
    }

    public AbstractComponentCallbacksC0159Db m1909K(int i) {
        for (int size = this.f1334f.size() - 1; size >= 0; size--) {
            AbstractC2524wh.m10586a(this.f1334f.get(size));
        }
        Iterator it = this.f1335g.values().iterator();
        while (it.hasNext()) {
            AbstractC2524wh.m10586a(it.next());
        }
        return null;
    }

    public AbstractComponentCallbacksC0159Db m1910L(String str) {
        if (str != null) {
            for (int size = this.f1334f.size() - 1; size >= 0; size--) {
                AbstractC2524wh.m10586a(this.f1334f.get(size));
            }
        }
        if (str == null) {
            return null;
        }
        Iterator it = this.f1335g.values().iterator();
        while (it.hasNext()) {
            AbstractC2524wh.m10586a(it.next());
        }
        return null;
    }

    public AbstractComponentCallbacksC0159Db m1911M(String str) {
        Iterator it = this.f1335g.values().iterator();
        while (it.hasNext()) {
            AbstractC2524wh.m10586a(it.next());
        }
        return null;
    }

    public final void m1912N() {
        if (this.f1328C != null) {
            while (!this.f1328C.isEmpty()) {
                ((f) this.f1328C.remove(0)).m1964b();
            }
        }
    }

    public void m1913O(int i) {
        synchronized (this) {
            try {
                this.f1340l.set(i, null);
                if (this.f1341m == null) {
                    this.f1341m = new ArrayList<>();
                }
                if (f1323F) {
                    Log.v("FragmentManager", "Freeing back stack index " + i);
                }
                this.f1341m.add(Integer.valueOf(i));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean m1914P(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this) {
            try {
                ArrayList arrayList3 = this.f1331c;
                if (arrayList3 != null && arrayList3.size() != 0) {
                    int size = this.f1331c.size();
                    boolean zMo1962a = false;
                    for (int i = 0; i < size; i++) {
                        zMo1962a |= ((e) this.f1331c.get(i)).mo1962a(arrayList, arrayList2);
                    }
                    this.f1331c.clear();
                    this.f1345q.m1566i().removeCallbacks(this.f1330E);
                    return zMo1962a;
                }
                return false;
            } finally {
            }
        }
    }

    public int m1915Q() {
        ArrayList arrayList = this.f1336h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public AbstractComponentCallbacksC0159Db m1916R() {
        return null;
    }

    public void m1917S() {
        m1906G();
        if (this.f1339k.m3422c()) {
            m1925a0();
        } else {
            this.f1338j.m5317c();
        }
    }

    public boolean m1918T(AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db) {
        return true;
    }

    public boolean m1919U() {
        return this.f1348t || this.f1349u;
    }

    public final void m1920V(C2499w1 c2499w1) {
        if (c2499w1.size() <= 0) {
            return;
        }
        AbstractC2524wh.m10586a(c2499w1.m10429p(0));
        throw null;
    }

    public void m1922X(int i, boolean z) {
        AbstractC0343Hb abstractC0343Hb;
        if (this.f1345q == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f1344p) {
            this.f1344p = i;
            int size = this.f1334f.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC2524wh.m10586a(this.f1334f.get(i2));
                m1921W(null);
            }
            Iterator it = this.f1335g.values().iterator();
            while (it.hasNext()) {
                AbstractC2524wh.m10586a(it.next());
            }
            m1944l0();
            if (this.f1347s && (abstractC0343Hb = this.f1345q) != null && this.f1344p == 4) {
                abstractC0343Hb.mo1568k();
                this.f1347s = false;
            }
        }
    }

    public void m1923Y(AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, int i, int i2, int i3, boolean z) {
        throw null;
    }

    public void m1924Z() {
        this.f1348t = false;
        this.f1349u = false;
        int size = this.f1334f.size();
        for (int i = 0; i < size; i++) {
            AbstractC2524wh.m10586a(this.f1334f.get(i));
        }
    }

    @Override
    public void mo1688a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f1335g.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            Iterator it = this.f1335g.values().iterator();
            while (it.hasNext()) {
                AbstractC2524wh.m10586a(it.next());
                printWriter.print(str);
                printWriter.println((Object) null);
            }
        }
        int size5 = this.f1334f.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            if (size5 > 0) {
                AbstractC2524wh.m10586a(this.f1334f.get(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(0);
                printWriter.print(": ");
                throw null;
            }
        }
        ArrayList arrayList = this.f1337i;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            if (size4 > 0) {
                AbstractC2524wh.m10586a(this.f1337i.get(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(0);
                printWriter.print(": ");
                throw null;
            }
        }
        ArrayList arrayList2 = this.f1336h;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i = 0; i < size3; i++) {
                C1620d2 c1620d2 = (C1620d2) this.f1336h.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(c1620d2.toString());
                c1620d2.m7281d(str2, printWriter);
            }
        }
        synchronized (this) {
            try {
                ArrayList arrayList3 = this.f1340l;
                if (arrayList3 != null && (size2 = arrayList3.size()) > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i2 = 0; i2 < size2; i2++) {
                        C1620d2 c1620d22 = (C1620d2) this.f1340l.get(i2);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i2);
                        printWriter.print(": ");
                        printWriter.println(c1620d22);
                    }
                }
                ArrayList arrayList4 = this.f1341m;
                if (arrayList4 != null && arrayList4.size() > 0) {
                    printWriter.print(str);
                    printWriter.print("mAvailBackStackIndices: ");
                    printWriter.println(Arrays.toString(this.f1341m.toArray()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayList5 = this.f1331c;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = (e) this.f1331c.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(eVar);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1345q);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1346r);
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1344p);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1348t);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1349u);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1350v);
        if (this.f1347s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1347s);
        }
    }

    public boolean m1925a0() {
        m1937i();
        return m1926b0(null, -1, 0);
    }

    @Override
    public C0297Gb mo1689b() {
        if (super.mo1689b() == AbstractC0389Ib.f1151b) {
            m1691d(new c());
        }
        return super.mo1689b();
    }

    public final boolean m1926b0(String str, int i, int i2) {
        m1906G();
        m1905F(true);
        boolean zM1927c0 = m1927c0(this.f1352x, this.f1353y, str, i, i2);
        if (zM1927c0) {
            this.f1332d = true;
            try {
                m1930e0(this.f1352x, this.f1353y);
            } finally {
                m1939j();
            }
        }
        m1948n0();
        m1903D();
        m1935h();
        return zM1927c0;
    }

    @Override
    public List mo1690c() {
        List list;
        if (this.f1334f.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1334f) {
            list = (List) this.f1334f.clone();
        }
        return list;
    }

    public boolean m1927c0(ArrayList arrayList, ArrayList arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList arrayList3 = this.f1336h;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1336h.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    C1620d2 c1620d2 = (C1620d2) this.f1336h.get(size2);
                    if ((str != null && str.equals(c1620d2.m7286i())) || (i >= 0 && i == c1620d2.f5269u)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        C1620d2 c1620d22 = (C1620d2) this.f1336h.get(size2);
                        if (str == null || !str.equals(c1620d22.m7286i())) {
                            if (i < 0 || i != c1620d22.f5269u) {
                                break;
                            }
                        }
                    }
                }
                i3 = size2;
            } else {
                i3 = -1;
            }
            if (i3 == this.f1336h.size() - 1) {
                return false;
            }
            for (int size3 = this.f1336h.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f1336h.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public final int m1928d0(ArrayList arrayList, ArrayList arrayList2, int i, int i2, C2499w1 c2499w1) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            C1620d2 c1620d2 = (C1620d2) arrayList.get(i4);
            boolean zBooleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
            if (c1620d2.m7289m() && !c1620d2.m7288k(arrayList, i4 + 1, i2)) {
                if (this.f1328C == null) {
                    this.f1328C = new ArrayList<>();
                }
                f fVar = new f(c1620d2, zBooleanValue);
                this.f1328C.add(fVar);
                c1620d2.m7291o(fVar);
                if (zBooleanValue) {
                    c1620d2.m7283f();
                } else {
                    c1620d2.m7284g(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, c1620d2);
                }
                m1929e(c2499w1);
            }
        }
        return i3;
    }

    public final void m1929e(C2499w1 c2499w1) {
        int i = this.f1344p;
        if (i < 1) {
            return;
        }
        Math.min(i, 3);
        if (this.f1334f.size() <= 0) {
            return;
        }
        AbstractC2524wh.m10586a(this.f1334f.get(0));
        throw null;
    }

    public final void m1930e0(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        m1908J(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((C1620d2) arrayList.get(i)).f1945q) {
                if (i2 != i) {
                    m1907I(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((C1620d2) arrayList.get(i2)).f1945q) {
                        i2++;
                    }
                }
                m1907I(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            m1907I(arrayList, arrayList2, i2, size);
        }
    }

    public void m1931f(C1620d2 c1620d2) {
        if (this.f1336h == null) {
            this.f1336h = new ArrayList<>();
        }
        this.f1336h.add(c1620d2);
    }

    public void m1932f0() {
        ArrayList arrayList = this.f1342n;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        AbstractC2524wh.m10586a(this.f1342n.get(0));
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m1933g(AbstractC0343Hb abstractC0343Hb, AbstractC0205Eb abstractC0205Eb, AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db) {
        if (this.f1345q != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f1345q = abstractC0343Hb;
        this.f1346r = abstractC0205Eb;
        if (abstractC0343Hb instanceof InterfaceC0717Ph) {
            InterfaceC0717Ph interfaceC0717Ph = (InterfaceC0717Ph) abstractC0343Hb;
            OnBackPressedDispatcher onBackPressedDispatcherMo3573b = interfaceC0717Ph.mo3573b();
            this.f1338j = onBackPressedDispatcherMo3573b;
            onBackPressedDispatcherMo3573b.m5315a(interfaceC0717Ph, this.f1339k);
        }
        this.f1329D = abstractC0343Hb instanceof InterfaceC0724Po ? C0527Lb.m2652d(((InterfaceC0724Po) abstractC0343Hb).mo3586e()) : new C0527Lb(false);
    }

    public void m1934g0(Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        C0481Kb c0481Kb = (C0481Kb) parcelable;
        if (c0481Kb.f1567l == null) {
            return;
        }
        Iterator it = this.f1329D.m2654e().iterator();
        if (it.hasNext()) {
            AbstractC2524wh.m10586a(it.next());
            if (f1323F) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + ((Object) null));
            }
            Iterator it2 = c0481Kb.f1567l.iterator();
            if (it2.hasNext()) {
                String str = ((C0573Mb) it2.next()).f1809m;
                throw null;
            }
            if (f1323F) {
                Log.v("FragmentManager", "Discarding retained Fragment " + ((Object) null) + " that was not found in the set of active Fragments " + c0481Kb.f1567l);
            }
            m1923Y(null, 1, 0, 0, false);
            throw null;
        }
        this.f1335g.clear();
        Iterator it3 = c0481Kb.f1567l.iterator();
        while (it3.hasNext()) {
            C0573Mb c0573Mb = (C0573Mb) it3.next();
            if (c0573Mb != null) {
                c0573Mb.m2853a(this.f1345q.m1565h().getClassLoader(), mo1689b());
                throw null;
            }
        }
        this.f1334f.clear();
        ArrayList arrayList = c0481Kb.f1568m;
        if (arrayList != null) {
            Iterator it4 = arrayList.iterator();
            if (it4.hasNext()) {
                String str2 = (String) it4.next();
                AbstractC2524wh.m10586a(this.f1335g.get(str2));
                m1946m0(new IllegalStateException("No instantiated fragment for (" + str2 + ")"));
                throw null;
            }
        }
        if (c0481Kb.f1569n != null) {
            this.f1336h = new ArrayList<>(c0481Kb.f1569n.length);
            int i = 0;
            while (true) {
                C1666e2[] c1666e2Arr = c0481Kb.f1569n;
                if (i >= c1666e2Arr.length) {
                    break;
                }
                C1620d2 c1620d2M7383a = c1666e2Arr[i].m7383a(this);
                if (f1323F) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + c1620d2M7383a.f5269u + "): " + c1620d2M7383a);
                    PrintWriter printWriter = new PrintWriter(new C1644dg("FragmentManager"));
                    c1620d2M7383a.m7282e("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1336h.add(c1620d2M7383a);
                int i2 = c1620d2M7383a.f5269u;
                if (i2 >= 0) {
                    m1938i0(i2, c1620d2M7383a);
                }
                i++;
            }
        } else {
            this.f1336h = null;
        }
        String str3 = c0481Kb.f1570o;
        if (str3 != null) {
            AbstractC2524wh.m10586a(this.f1335g.get(str3));
            m1956v(null);
        }
        this.f1333e = c0481Kb.f1571p;
    }

    public final void m1935h() {
        this.f1335g.values().removeAll(Collections.singleton(null));
    }

    public Parcelable m1936h0() {
        m1912N();
        m1904E();
        m1906G();
        this.f1348t = true;
        if (this.f1335g.isEmpty()) {
            return null;
        }
        new ArrayList<>(this.f1335g.size());
        Iterator it = this.f1335g.values().iterator();
        while (it.hasNext()) {
            AbstractC2524wh.m10586a(it.next());
        }
        if (f1323F) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return null;
    }

    public final void m1937i() {
        if (m1919U()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public void m1938i0(int i, C1620d2 c1620d2) {
        synchronized (this) {
            try {
                if (this.f1340l == null) {
                    this.f1340l = new ArrayList<>();
                }
                int size = this.f1340l.size();
                if (i < size) {
                    if (f1323F) {
                        Log.v("FragmentManager", "Setting back stack index " + i + " to " + c1620d2);
                    }
                    this.f1340l.set(i, c1620d2);
                } else {
                    while (size < i) {
                        this.f1340l.add(null);
                        if (this.f1341m == null) {
                            this.f1341m = new ArrayList<>();
                        }
                        if (f1323F) {
                            Log.v("FragmentManager", "Adding available back stack index " + size);
                        }
                        this.f1341m.add(Integer.valueOf(size));
                        size++;
                    }
                    if (f1323F) {
                        Log.v("FragmentManager", "Adding back stack index " + i + " with " + c1620d2);
                    }
                    this.f1340l.add(c1620d2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m1939j() {
        this.f1332d = false;
        this.f1353y.clear();
        this.f1352x.clear();
    }

    public void m1940j0(AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, AbstractC1255c.b bVar) {
        throw null;
    }

    public void m1941k(C1620d2 c1620d2, boolean z, boolean z2, boolean z3) {
        if (z) {
            c1620d2.m7284g(z3);
        } else {
            c1620d2.m7283f();
        }
        ArrayList arrayList = new ArrayList<>(1);
        ArrayList arrayList2 = new ArrayList<>(1);
        arrayList.add(c1620d2);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            AbstractC0665Ob.m3413s(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            m1922X(this.f1344p, true);
        }
        Iterator it = this.f1335g.values().iterator();
        while (it.hasNext()) {
            AbstractC2524wh.m10586a(it.next());
        }
    }

    public void m1942k0(AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db) {
        m1956v(null);
        m1956v(null);
    }

    public void m1943l() {
        this.f1348t = false;
        this.f1349u = false;
        m1901B(2);
    }

    public void m1944l0() {
        Iterator it = this.f1335g.values().iterator();
        while (it.hasNext()) {
            AbstractC2524wh.m10586a(it.next());
        }
    }

    public void m1945m(Configuration configuration) {
        for (int i = 0; i < this.f1334f.size(); i++) {
            AbstractC2524wh.m10586a(this.f1334f.get(i));
        }
    }

    public final void m1946m0(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C1644dg("FragmentManager"));
        AbstractC0343Hb abstractC0343Hb = this.f1345q;
        try {
            if (abstractC0343Hb != null) {
                abstractC0343Hb.mo1567j("  ", null, printWriter, new String[0]);
            } else {
                mo1688a("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    public boolean m1947n(MenuItem menuItem) {
        if (this.f1344p < 1) {
            return false;
        }
        for (int i = 0; i < this.f1334f.size(); i++) {
            AbstractC2524wh.m10586a(this.f1334f.get(i));
        }
        return false;
    }

    public final void m1948n0() {
        ArrayList arrayList = this.f1331c;
        if (arrayList == null || arrayList.isEmpty()) {
            this.f1339k.m3425f(m1915Q() > 0 && m1918T(null));
        } else {
            this.f1339k.m3425f(true);
        }
    }

    public void m1949o() {
        this.f1348t = false;
        this.f1349u = false;
        m1901B(1);
    }

    @Override
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f1358a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !C0297Gb.m1373b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            m1909K(resourceId);
        }
        if (string != null) {
            m1910L(string);
        }
        if (id != -1) {
            m1909K(id);
        }
        if (f1323F) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + ((Object) null));
        }
        mo1689b().mo1376a(context.getClassLoader(), attributeValue);
        throw null;
    }

    public boolean m1950p(Menu menu, MenuInflater menuInflater) {
        if (this.f1344p < 1) {
            return false;
        }
        for (int i = 0; i < this.f1334f.size(); i++) {
            AbstractC2524wh.m10586a(this.f1334f.get(i));
        }
        ArrayList arrayList = this.f1337i;
        Object obj = null;
        if (arrayList == null || arrayList.size() <= 0) {
            this.f1337i = null;
            return false;
        }
        AbstractC2524wh.m10586a(this.f1337i.get(0));
        obj.getClass();
        throw null;
    }

    public void m1951q() {
        this.f1350v = true;
        m1906G();
        m1901B(0);
        this.f1345q = null;
        this.f1346r = null;
        if (this.f1338j != null) {
            this.f1339k.m3423d();
            this.f1338j = null;
        }
    }

    public void m1952r() {
        for (int i = 0; i < this.f1334f.size(); i++) {
            AbstractC2524wh.m10586a(this.f1334f.get(i));
        }
    }

    public void m1953s(boolean z) {
        for (int size = this.f1334f.size() - 1; size >= 0; size--) {
            AbstractC2524wh.m10586a(this.f1334f.get(size));
        }
    }

    public boolean m1954t(MenuItem menuItem) {
        if (this.f1344p < 1) {
            return false;
        }
        for (int i = 0; i < this.f1334f.size(); i++) {
            AbstractC2524wh.m10586a(this.f1334f.get(i));
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractC2551x7.m10630a(this.f1345q, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void m1955u(Menu menu) {
        if (this.f1344p < 1) {
            return;
        }
        for (int i = 0; i < this.f1334f.size(); i++) {
            AbstractC2524wh.m10586a(this.f1334f.get(i));
        }
    }

    public void m1957w() {
        m1901B(3);
    }

    public void m1958x(boolean z) {
        for (int size = this.f1334f.size() - 1; size >= 0; size--) {
            AbstractC2524wh.m10586a(this.f1334f.get(size));
        }
    }

    public boolean m1959y(Menu menu) {
        if (this.f1344p < 1) {
            return false;
        }
        for (int i = 0; i < this.f1334f.size(); i++) {
            AbstractC2524wh.m10586a(this.f1334f.get(i));
        }
        return false;
    }

    public void m1960z() {
        this.f1348t = false;
        this.f1349u = false;
        m1901B(4);
    }

    @Override
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void m1921W(AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db) {
    }

    public final void m1956v(AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db) {
    }
}
