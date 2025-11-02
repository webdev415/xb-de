package p000;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractC0757Qb {

    public class a implements Runnable {

        public final int f2224l;

        public final ArrayList f2225m;

        public final ArrayList f2226n;

        public final ArrayList f2227o;

        public final ArrayList f2228p;

        public a(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f2224l = i;
            this.f2225m = arrayList;
            this.f2226n = arrayList2;
            this.f2227o = arrayList3;
            this.f2228p = arrayList4;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.f2224l; i++) {
                AbstractC0448Jo.m2096y((View) this.f2225m.get(i), (String) this.f2226n.get(i));
                AbstractC0448Jo.m2096y((View) this.f2227o.get(i), (String) this.f2228p.get(i));
            }
        }
    }

    public class b implements Runnable {

        public final ArrayList f2230l;

        public final Map f2231m;

        public b(ArrayList arrayList, Map map) {
            this.f2230l = arrayList;
            this.f2231m = map;
        }

        @Override
        public void run() {
            int size = this.f2230l.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f2230l.get(i);
                String strM2082k = AbstractC0448Jo.m2082k(view);
                if (strM2082k != null) {
                    AbstractC0448Jo.m2096y(view, AbstractC0757Qb.m3650d(this.f2231m, strM2082k));
                }
            }
        }
    }

    public class c implements Runnable {

        public final ArrayList f2233l;

        public final Map f2234m;

        public c(ArrayList arrayList, Map map) {
            this.f2233l = arrayList;
            this.f2234m = map;
        }

        @Override
        public void run() {
            int size = this.f2233l.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f2233l.get(i);
                AbstractC0448Jo.m2096y(view, (String) this.f2234m.get(AbstractC0448Jo.m2082k(view)));
            }
        }
    }

    public static String m3650d(Map map, String str) {
        for (Map.Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    public static boolean m3651e(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void mo3544a(Object obj, View view);

    public abstract void mo3545b(ViewGroup viewGroup, Object obj);

    public abstract boolean mo3546c(Object obj);

    public abstract Object mo3547f(Object obj, Object obj2, Object obj3);

    public ArrayList m3652g(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            arrayList2.add(AbstractC0448Jo.m2082k(view));
            AbstractC0448Jo.m2096y(view, null);
        }
        return arrayList2;
    }

    public abstract void mo3548h(Object obj, View view);

    public abstract void mo3549i(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public void m3653j(ViewGroup viewGroup, ArrayList arrayList, Map map) {
        ViewTreeObserverOnPreDrawListenerC1038Wh.m4506a(viewGroup, new c(arrayList, map));
    }

    public abstract void mo3550k(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public void m3654l(View view, ArrayList arrayList, Map map) {
        ViewTreeObserverOnPreDrawListenerC1038Wh.m4506a(view, new b(arrayList, map));
    }

    public void m3655m(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            String strM2082k = AbstractC0448Jo.m2082k(view2);
            arrayList4.add(strM2082k);
            if (strM2082k != null) {
                AbstractC0448Jo.m2096y(view2, null);
                String str = (String) map.get(strM2082k);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        AbstractC0448Jo.m2096y((View) arrayList2.get(i2), strM2082k);
                        break;
                    }
                    i2++;
                }
            }
        }
        ViewTreeObserverOnPreDrawListenerC1038Wh.m4506a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void mo3551n(Object obj, ArrayList arrayList, ArrayList arrayList2);
}
