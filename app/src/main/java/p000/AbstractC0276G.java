package p000;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractC0276G implements InterfaceC1738fh {
    @Override
    public abstract Map mo1311a();

    public boolean mo1312b(Object obj) {
        Iterator it = mo1311a().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        return AbstractC1785gh.m7738a(this, obj);
    }

    public int hashCode() {
        return mo1311a().hashCode();
    }

    public String toString() {
        return mo1311a().toString();
    }
}
