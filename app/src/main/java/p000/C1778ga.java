package p000;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class C1778ga implements InterfaceC0722Pm, InterfaceC2526wj {

    public final Map f5626a = new HashMap<>();

    public Queue f5627b = new ArrayDeque();

    public final Executor f5628c;

    public C1778ga(Executor executor) {
        this.f5628c = executor;
    }

    public static void m7716e(Map.Entry entry, AbstractC1684ea abstractC1684ea) {
        ((InterfaceC1872ia) entry.getKey()).mo3442a(abstractC1684ea);
    }

    @Override
    public synchronized void mo3584a(Class cls, Executor executor, InterfaceC1872ia interfaceC1872ia) {
        try {
            AbstractC1177Zi.m5050b(cls);
            AbstractC1177Zi.m5050b(interfaceC1872ia);
            AbstractC1177Zi.m5050b(executor);
            if (!this.f5626a.containsKey(cls)) {
                this.f5626a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f5626a.get(cls)).put(interfaceC1872ia, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void m7717c() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.f5627b;
                if (queue != null) {
                    this.f5627b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (queue != null) {
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                AbstractC2524wh.m10586a(it.next());
                m7719f(null);
            }
        }
    }

    public final synchronized Set m7718d(AbstractC1684ea abstractC1684ea) {
        throw null;
    }

    public void m7719f(final AbstractC1684ea abstractC1684ea) {
        AbstractC1177Zi.m5050b(abstractC1684ea);
        synchronized (this) {
            try {
                Queue queue = this.f5627b;
                if (queue != null) {
                    queue.add(abstractC1684ea);
                    return;
                }
                for (final Map.Entry entry : m7718d(abstractC1684ea)) {
                    ((Executor) entry.getValue()).execute(new Runnable(entry, abstractC1684ea) {

                        public final Map.Entry f5496l;

                        @Override
                        public final void run() {
                            C1778ga.m7716e(this.f5496l, null);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
