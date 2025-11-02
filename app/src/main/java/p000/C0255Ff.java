package p000;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class C0255Ff implements InterfaceC2388tj {

    public volatile Set f664b = null;

    public volatile Set f663a = Collections.newSetFromMap(new ConcurrentHashMap());

    public C0255Ff(Collection collection) {
        this.f663a.addAll(collection);
    }

    public static C0255Ff m1250b(Collection collection) {
        return new C0255Ff((Set) collection);
    }

    public synchronized void m1251a(InterfaceC2388tj interfaceC2388tj) {
        Set set;
        Object obj;
        try {
            if (this.f664b == null) {
                set = this.f663a;
                obj = interfaceC2388tj;
            } else {
                set = this.f664b;
                obj = interfaceC2388tj.get();
            }
            set.add(obj);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override
    public Set get() {
        if (this.f664b == null) {
            synchronized (this) {
                try {
                    if (this.f664b == null) {
                        this.f664b = Collections.newSetFromMap(new ConcurrentHashMap());
                        m1253d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f664b);
    }

    public final synchronized void m1253d() {
        try {
            Iterator it = this.f663a.iterator();
            while (it.hasNext()) {
                this.f664b.add(((InterfaceC2388tj) it.next()).get());
            }
            this.f663a = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
