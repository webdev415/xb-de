package p000;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import p000.AbstractC0619Nb;

public abstract class AbstractC0665Ob {

    public static final int[] f2029a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    public static final AbstractC0757Qb f2030b = new C0711Pb();

    public static final AbstractC0757Qb f2031c = m3410p();

    public static class a implements Runnable {

        public final Object f2032l;

        public final AbstractC0757Qb f2033m;

        public final View f2034n;

        public final ArrayList f2035o;

        public final ArrayList f2036p;

        public final ArrayList f2037q;

        public final Object f2038r;

        public a(Object obj, AbstractC0757Qb abstractC0757Qb, View view, AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f2032l = obj;
            this.f2033m = abstractC0757Qb;
            this.f2034n = view;
            this.f2035o = arrayList;
            this.f2036p = arrayList2;
            this.f2037q = arrayList3;
            this.f2038r = obj2;
        }

        @Override
        public void run() {
            Object obj = this.f2032l;
            if (obj != null) {
                this.f2033m.mo3548h(obj, this.f2034n);
                this.f2036p.addAll(AbstractC0665Ob.m3401g(this.f2033m, this.f2032l, null, this.f2035o, this.f2034n));
            }
            if (this.f2037q != null) {
                if (this.f2038r != null) {
                    ArrayList arrayList = new ArrayList<>();
                    arrayList.add(this.f2034n);
                    this.f2033m.mo3549i(this.f2038r, this.f2037q, arrayList);
                }
                this.f2037q.clear();
                this.f2037q.add(this.f2034n);
            }
        }
    }

    public static class b {

        public boolean f2039a;

        public boolean f2040b;
    }

    public static void m3395a(C1620d2 c1620d2, AbstractC0619Nb.a aVar, SparseArray sparseArray, boolean z, boolean z2) {
        aVar.getClass();
    }

    public static void m3396b(C1620d2 c1620d2, SparseArray sparseArray, boolean z) {
        int size = c1620d2.f1929a.size();
        for (int i = 0; i < size; i++) {
            m3395a(c1620d2, (AbstractC0619Nb.a) c1620d2.f1929a.get(i), sparseArray, false, z);
        }
    }

    public static C2453v1 m3397c(int i, ArrayList arrayList, ArrayList arrayList2, int i2, int i3) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        C2453v1 c2453v1 = new C2453v1();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C1620d2 c1620d2 = (C1620d2) arrayList.get(i4);
            if (c1620d2.m7287j(i)) {
                boolean zBooleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                ArrayList arrayList5 = c1620d2.f1943o;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = c1620d2.f1943o;
                        arrayList4 = c1620d2.f1944p;
                    } else {
                        ArrayList arrayList6 = c1620d2.f1943o;
                        arrayList3 = c1620d2.f1944p;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) c2453v1.remove(str2);
                        if (str3 != null) {
                            c2453v1.put(str, str3);
                        } else {
                            c2453v1.put(str, str2);
                        }
                    }
                }
            }
        }
        return c2453v1;
    }

    public static void m3398d(C1620d2 c1620d2, SparseArray sparseArray, boolean z) {
        if (c1620d2.f5267s.f1346r.mo1030g()) {
            for (int size = c1620d2.f1929a.size() - 1; size >= 0; size--) {
                m3395a(c1620d2, (AbstractC0619Nb.a) c1620d2.f1929a.get(size), sparseArray, true, z);
            }
        }
    }

    public static boolean m3399e(AbstractC0757Qb abstractC0757Qb, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!abstractC0757Qb.mo3546c(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static AbstractC0757Qb m3400f(AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db2) {
        ArrayList arrayList = new ArrayList<>();
        if (arrayList.isEmpty()) {
            return null;
        }
        AbstractC0757Qb abstractC0757Qb = f2030b;
        if (abstractC0757Qb != null && m3399e(abstractC0757Qb, arrayList)) {
            return abstractC0757Qb;
        }
        AbstractC0757Qb abstractC0757Qb2 = f2031c;
        if (abstractC0757Qb2 != null && m3399e(abstractC0757Qb2, arrayList)) {
            return abstractC0757Qb2;
        }
        if (abstractC0757Qb == null && abstractC0757Qb2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList m3401g(AbstractC0757Qb abstractC0757Qb, Object obj, AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, ArrayList arrayList, View view) {
        if (obj == null) {
            return null;
        }
        new ArrayList<>();
        throw null;
    }

    public static Object m3402h(AbstractC0757Qb abstractC0757Qb, ViewGroup viewGroup, View view, C2453v1 c2453v1, b bVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        bVar.getClass();
        return null;
    }

    public static Object m3403i(AbstractC0757Qb abstractC0757Qb, ViewGroup viewGroup, View view, C2453v1 c2453v1, b bVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        bVar.getClass();
        return null;
    }

    public static void m3404j(LayoutInflaterFactory2C0435Jb layoutInflaterFactory2C0435Jb, int i, b bVar, View view, C2453v1 c2453v1) {
        Object obj;
        ViewGroup viewGroup = layoutInflaterFactory2C0435Jb.f1346r.mo1030g() ? (ViewGroup) layoutInflaterFactory2C0435Jb.f1346r.mo1029d(i) : null;
        if (viewGroup == null) {
            return;
        }
        bVar.getClass();
        AbstractC0757Qb abstractC0757QbM3400f = m3400f(null, null);
        if (abstractC0757QbM3400f == null) {
            return;
        }
        boolean z = bVar.f2039a;
        boolean z2 = bVar.f2040b;
        Object objM3406l = m3406l(abstractC0757QbM3400f, null, z);
        Object objM3407m = m3407m(abstractC0757QbM3400f, null, z2);
        ArrayList arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList<>();
        Object objM3402h = m3402h(abstractC0757QbM3400f, viewGroup, view, c2453v1, bVar, arrayList, arrayList2, objM3406l, objM3407m);
        if (objM3406l == null && objM3402h == null) {
            obj = objM3407m;
            if (obj == null) {
                return;
            }
        } else {
            obj = objM3407m;
        }
        ArrayList arrayListM3401g = m3401g(abstractC0757QbM3400f, obj, null, arrayList, view);
        Object obj2 = (arrayListM3401g == null || arrayListM3401g.isEmpty()) ? null : obj;
        abstractC0757QbM3400f.mo3544a(objM3406l, view);
        Object objM3408n = m3408n(abstractC0757QbM3400f, objM3406l, obj2, objM3402h, null, bVar.f2039a);
        if (objM3408n != null) {
            ArrayList arrayList3 = new ArrayList<>();
            abstractC0757QbM3400f.mo3550k(objM3408n, objM3406l, arrayList3, obj2, arrayListM3401g, objM3402h, arrayList2);
            m3411q(abstractC0757QbM3400f, viewGroup, null, view, arrayList2, objM3406l, arrayList3, obj2, arrayListM3401g);
            abstractC0757QbM3400f.m3654l(viewGroup, arrayList2, c2453v1);
            abstractC0757QbM3400f.mo3545b(viewGroup, objM3408n);
            abstractC0757QbM3400f.m3653j(viewGroup, arrayList2, c2453v1);
        }
    }

    public static void m3405k(LayoutInflaterFactory2C0435Jb layoutInflaterFactory2C0435Jb, int i, b bVar, View view, C2453v1 c2453v1) {
        Object obj;
        ViewGroup viewGroup = layoutInflaterFactory2C0435Jb.f1346r.mo1030g() ? (ViewGroup) layoutInflaterFactory2C0435Jb.f1346r.mo1029d(i) : null;
        if (viewGroup == null) {
            return;
        }
        bVar.getClass();
        AbstractC0757Qb abstractC0757QbM3400f = m3400f(null, null);
        if (abstractC0757QbM3400f == null) {
            return;
        }
        boolean z = bVar.f2039a;
        boolean z2 = bVar.f2040b;
        ArrayList arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList<>();
        Object objM3406l = m3406l(abstractC0757QbM3400f, null, z);
        Object objM3407m = m3407m(abstractC0757QbM3400f, null, z2);
        Object objM3403i = m3403i(abstractC0757QbM3400f, viewGroup, view, c2453v1, bVar, arrayList2, arrayList, objM3406l, objM3407m);
        if (objM3406l == null && objM3403i == null) {
            obj = objM3407m;
            if (obj == null) {
                return;
            }
        } else {
            obj = objM3407m;
        }
        ArrayList arrayListM3401g = m3401g(abstractC0757QbM3400f, obj, null, arrayList2, view);
        ArrayList arrayListM3401g2 = m3401g(abstractC0757QbM3400f, objM3406l, null, arrayList, view);
        m3412r(arrayListM3401g2, 4);
        Object objM3408n = m3408n(abstractC0757QbM3400f, objM3406l, obj, objM3403i, null, z);
        if (objM3408n != null) {
            m3409o(abstractC0757QbM3400f, obj, null, arrayListM3401g);
            ArrayList arrayListM3652g = abstractC0757QbM3400f.m3652g(arrayList);
            abstractC0757QbM3400f.mo3550k(objM3408n, objM3406l, arrayListM3401g2, obj, arrayListM3401g, objM3403i, arrayList);
            abstractC0757QbM3400f.mo3545b(viewGroup, objM3408n);
            abstractC0757QbM3400f.m3655m(viewGroup, arrayList2, arrayList, arrayListM3652g, c2453v1);
            m3412r(arrayListM3401g2, 0);
            abstractC0757QbM3400f.mo3551n(objM3403i, arrayList2, arrayList);
        }
    }

    public static Object m3406l(AbstractC0757Qb abstractC0757Qb, AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, boolean z) {
        return null;
    }

    public static Object m3407m(AbstractC0757Qb abstractC0757Qb, AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, boolean z) {
        return null;
    }

    public static Object m3408n(AbstractC0757Qb abstractC0757Qb, Object obj, Object obj2, Object obj3, AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, boolean z) {
        return abstractC0757Qb.mo3547f(obj2, obj, obj3);
    }

    public static AbstractC0757Qb m3410p() {
        try {
            return (AbstractC0757Qb) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void m3411q(AbstractC0757Qb abstractC0757Qb, ViewGroup viewGroup, AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, View view, ArrayList arrayList, Object obj, ArrayList arrayList2, Object obj2, ArrayList arrayList3) {
        ViewTreeObserverOnPreDrawListenerC1038Wh.m4506a(viewGroup, new a(obj, abstractC0757Qb, view, abstractComponentCallbacksC0159Db, arrayList, arrayList2, arrayList3, obj2));
    }

    public static void m3412r(ArrayList arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i);
        }
    }

    public static void m3413s(LayoutInflaterFactory2C0435Jb layoutInflaterFactory2C0435Jb, ArrayList arrayList, ArrayList arrayList2, int i, int i2, boolean z) {
        if (layoutInflaterFactory2C0435Jb.f1344p < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            C1620d2 c1620d2 = (C1620d2) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                m3398d(c1620d2, sparseArray, z);
            } else {
                m3396b(c1620d2, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(layoutInflaterFactory2C0435Jb.f1345q.m1565h());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                C2453v1 c2453v1M3397c = m3397c(iKeyAt, arrayList, arrayList2, i, i2);
                b bVar = (b) sparseArray.valueAt(i4);
                if (z) {
                    m3405k(layoutInflaterFactory2C0435Jb, iKeyAt, bVar, view, c2453v1M3397c);
                } else {
                    m3404j(layoutInflaterFactory2C0435Jb, iKeyAt, bVar, view, c2453v1M3397c);
                }
            }
        }
    }

    public static void m3409o(AbstractC0757Qb abstractC0757Qb, Object obj, AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db, ArrayList arrayList) {
    }
}
