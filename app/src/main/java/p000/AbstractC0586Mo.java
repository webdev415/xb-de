package p000;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractC0586Mo {

    public final Map f1859a = new HashMap<>();

    public final Set f1860b = new LinkedHashSet();

    public volatile boolean f1861c = false;

    public static void m2965b(Object obj) throws IOException {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final void m2966a() {
        this.f1861c = true;
        Map map = this.f1859a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator it = this.f1859a.values().iterator();
                    while (it.hasNext()) {
                        m2965b(it.next());
                    }
                } finally {
                }
            }
        }
        Set set = this.f1860b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator it2 = this.f1860b.iterator();
                    while (it2.hasNext()) {
                        m2965b((Closeable) it2.next());
                    }
                } finally {
                }
            }
        }
        mo2653c();
    }

    public void mo2653c() {
    }
}
