package p000;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class C1063X5 implements InterfaceC0466K5, InterfaceC0650O5 {

    public static final InterfaceC2388tj f3173i = new InterfaceC2388tj() {
        @Override
        public final Object get() {
            return Collections.emptySet();
        }
    };

    public final Map f3174a;

    public final Map f3175b;

    public final Map f3176c;

    public final List f3177d;

    public Set f3178e;

    public final C1778ga f3179f;

    public final AtomicReference f3180g;

    public final InterfaceC0833S5 f3181h;

    public C1063X5(Executor executor, Iterable iterable, Collection collection, InterfaceC0833S5 interfaceC0833S5) {
        this.f3174a = new HashMap<>();
        this.f3175b = new HashMap<>();
        this.f3176c = new HashMap<>();
        this.f3178e = new HashSet();
        this.f3180g = new AtomicReference();
        C1778ga c1778ga = new C1778ga(executor);
        this.f3179f = c1778ga;
        this.f3181h = interfaceC0833S5;
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(Component.m1802s(c1778ga, C1778ga.class, InterfaceC0722Pm.class, InterfaceC2526wj.class));
        arrayList.add(Component.m1802s(this, InterfaceC0650O5.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component != null) {
                arrayList.add(component);
            }
        }
        this.f3177d = m4633o(iterable);
        m4636l(arrayList);
    }

    public static b m4632k(Executor executor) {
        return new b(executor);
    }

    public static List m4633o(Iterable iterable) {
        ArrayList arrayList = new ArrayList<>();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override
    public synchronized InterfaceC2388tj mo2283b(C0167Dj c0167Dj) {
        C0255Ff c0255Ff = (C0255Ff) this.f3176c.get(c0167Dj);
        if (c0255Ff != null) {
            return c0255Ff;
        }
        return f3173i;
    }

    @Override
    public synchronized InterfaceC2388tj mo2287f(C0167Dj c0167Dj) {
        AbstractC1177Zi.m5051c(c0167Dj, "Null interface requested.");
        return (InterfaceC2388tj) this.f3175b.get(c0167Dj);
    }

    public final void m4636l(List list) {
        ArrayList arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator it = this.f3177d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((InterfaceC2388tj) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f3181h.mo3628a(componentRegistrar));
                        it.remove();
                    }
                } catch (C0346He e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Object[] array = ((Component) it2.next()).m1806j().toArray();
                int length = array.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Object obj = array[i];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f3178e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f3178e.add(obj.toString());
                        }
                        i++;
                    }
                }
            }
            if (this.f3174a.isEmpty()) {
                AbstractC1350c7.m5733a(list);
            } else {
                ArrayList arrayList2 = new ArrayList<>(this.f3174a.keySet());
                arrayList2.addAll(list);
                AbstractC1350c7.m5733a(arrayList2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                final Component component = (Component) it3.next();
                this.f3174a.put(component, new C0117Cf(new InterfaceC2388tj() {
                    @Override
                    public final Object get() {
                        return this.f2820a.m4639p(component);
                    }
                }));
            }
            arrayList.addAll(m4642u(list));
            arrayList.addAll(m4643v());
            m4641t();
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        m4640s();
    }

    public final void m4637m(Map map, boolean z) {
        for (Map.Entry entry : map.entrySet()) {
            Component component = (Component) entry.getKey();
            InterfaceC2388tj interfaceC2388tj = (InterfaceC2388tj) entry.getValue();
            if (component.m1808n() || (component.m1809o() && z)) {
                interfaceC2388tj.get();
            }
        }
        this.f3179f.m7717c();
    }

    public void m4638n(boolean z) {
        HashMap map;
        if (AbstractC1639db.m7321a(this.f3180g, null, Boolean.valueOf(z))) {
            synchronized (this) {
                map = new HashMap<>(this.f3174a);
            }
            m4637m(map, z);
        }
    }

    public final Object m4639p(Component component) {
        return component.m1804h().mo432a(new C0582Mk(component, this));
    }

    public final void m4640s() {
        Boolean bool = (Boolean) this.f3180g.get();
        if (bool != null) {
            m4637m(this.f3174a, bool.booleanValue());
        }
    }

    public final void m4641t() {
        Map map;
        C0167Dj c0167DjM877b;
        InterfaceC2388tj interfaceC2388tjM7422c;
        for (Component component : this.f3174a.keySet()) {
            for (Dependency dependency : component.m1803g()) {
                if (dependency.m881f() && !this.f3176c.containsKey(dependency.m877b())) {
                    map = this.f3176c;
                    c0167DjM877b = dependency.m877b();
                    interfaceC2388tjM7422c = C0255Ff.m1250b(Collections.emptySet());
                } else if (this.f3175b.containsKey(dependency.m877b())) {
                    continue;
                } else {
                    if (dependency.m880e()) {
                        throw new C0853Sg(String.format("Unsatisfied dependency for component %s: %s", component, dependency.m877b()));
                    }
                    if (!dependency.m881f()) {
                        map = this.f3175b;
                        c0167DjM877b = dependency.m877b();
                        interfaceC2388tjM7422c = C1692ei.m7422c();
                    }
                }
                map.put(c0167DjM877b, interfaceC2388tjM7422c);
            }
        }
    }

    public final List m4642u(List list) {
        ArrayList arrayList = new ArrayList<>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component.m1810p()) {
                final InterfaceC2388tj interfaceC2388tj = (InterfaceC2388tj) this.f3174a.get(component);
                for (C0167Dj c0167Dj : component.m1806j()) {
                    if (this.f3175b.containsKey(c0167Dj)) {
                        final C1692ei c1692ei = (C1692ei) ((InterfaceC2388tj) this.f3175b.get(c0167Dj));
                        arrayList.add(new Runnable() {
                            @Override
                            public final void run() {
                                c1692ei.m7425f(interfaceC2388tj);
                            }
                        });
                    } else {
                        this.f3175b.put(c0167Dj, interfaceC2388tj);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List m4643v() {
        ArrayList arrayList = new ArrayList<>();
        HashMap map = new HashMap<>();
        for (Map.Entry entry : this.f3174a.entrySet()) {
            Component component = (Component) entry.getKey();
            if (!component.m1810p()) {
                InterfaceC2388tj interfaceC2388tj = (InterfaceC2388tj) entry.getValue();
                for (C0167Dj c0167Dj : component.m1806j()) {
                    if (!map.containsKey(c0167Dj)) {
                        map.put(c0167Dj, new HashSet());
                    }
                    ((Set) map.get(c0167Dj)).add(interfaceC2388tj);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f3176c.containsKey(entry2.getKey())) {
                final C0255Ff c0255Ff = (C0255Ff) this.f3176c.get(entry2.getKey());
                for (final InterfaceC2388tj interfaceC2388tj2 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() {
                        @Override
                        public final void run() {
                            c0255Ff.m1251a(interfaceC2388tj2);
                        }
                    });
                }
            } else {
                this.f3176c.put((C0167Dj) entry2.getKey(), C0255Ff.m1250b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    public static final class b {

        public final Executor f3182a;

        public final List f3183b = new ArrayList<>();

        public final List f3184c = new ArrayList<>();

        public InterfaceC0833S5 f3185d = InterfaceC0833S5.f2600a;

        public b(Executor executor) {
            this.f3182a = executor;
        }

        public b m4646b(Component component) {
            this.f3184c.add(component);
            return this;
        }

        public b m4647c(final ComponentRegistrar componentRegistrar) {
            this.f3183b.add(new InterfaceC2388tj() {
                @Override
                public final Object get() {
                    return b.m4645f(componentRegistrar);
                }
            });
            return this;
        }

        public b m4648d(Collection collection) {
            this.f3183b.addAll(collection);
            return this;
        }

        public C1063X5 m4649e() {
            return new C1063X5(this.f3182a, this.f3183b, this.f3184c, this.f3185d);
        }

        public b m4650g(InterfaceC0833S5 interfaceC0833S5) {
            this.f3185d = interfaceC0833S5;
            return this;
        }

        public static ComponentRegistrar m4645f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }
}
