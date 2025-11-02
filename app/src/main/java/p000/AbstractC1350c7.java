package p000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class AbstractC1350c7 {

    public static class b {

        public final C0420J5 f3920a;

        public final Set f3921b = new HashSet();

        public final Set f3922c = new HashSet();

        public b(C0420J5 c0420j5) {
            this.f3920a = c0420j5;
        }

        public void m5736a(b bVar) {
            this.f3921b.add(bVar);
        }

        public void m5737b(b bVar) {
            this.f3922c.add(bVar);
        }

        public C0420J5 m5738c() {
            return this.f3920a;
        }

        public Set m5739d() {
            return this.f3921b;
        }

        public boolean m5740e() {
            return this.f3921b.isEmpty();
        }

        public boolean m5741f() {
            return this.f3922c.isEmpty();
        }

        public void m5742g(b bVar) {
            this.f3922c.remove(bVar);
        }
    }

    public static class c {

        public final C0167Dj f3923a;

        public final boolean f3924b;

        public c(C0167Dj c0167Dj, boolean z) {
            this.f3923a = c0167Dj;
            this.f3924b = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f3923a.equals(this.f3923a) && cVar.f3924b == this.f3924b;
        }

        public int hashCode() {
            return ((this.f3923a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f3924b).hashCode();
        }
    }

    public static void m5733a(List list) {
        Set<b> setM5735c = m5735c(list);
        Set setM5734b = m5734b(setM5735c);
        int i = 0;
        while (!setM5734b.isEmpty()) {
            b bVar = (b) setM5734b.iterator().next();
            setM5734b.remove(bVar);
            i++;
            for (b bVar2 : bVar.m5739d()) {
                bVar2.m5742g(bVar);
                if (bVar2.m5741f()) {
                    setM5734b.add(bVar2);
                }
            }
        }
        if (i == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList<>();
        for (b bVar3 : setM5735c) {
            if (!bVar3.m5741f() && !bVar3.m5740e()) {
                arrayList.add(bVar3.m5738c());
            }
        }
        throw new C0239F8(arrayList);
    }

    public static Set m5734b(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.m5741f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    public static Set m5735c(List list) {
        Set<b> set;
        HashMap map = new HashMap<>(list.size());
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (C0193E8 c0193e8 : bVar.m5738c().m1803g()) {
                            if (c0193e8.m879d() && (set = (Set) map.get(new c(c0193e8.m877b(), c0193e8.m881f()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.m5736a(bVar2);
                                    bVar2.m5737b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            C0420J5 c0420j5 = (C0420J5) it.next();
            b bVar3 = new b(c0420j5);
            for (C0167Dj c0167Dj : c0420j5.m1806j()) {
                c cVar = new c(c0167Dj, !c0420j5.m1810p());
                if (!map.containsKey(cVar)) {
                    map.put(cVar, new HashSet());
                }
                Set set2 = (Set) map.get(cVar);
                if (!set2.isEmpty() && !cVar.f3924b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", c0167Dj));
                }
                set2.add(bVar3);
            }
        }
    }
}
