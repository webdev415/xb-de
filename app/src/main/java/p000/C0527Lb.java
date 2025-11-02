package p000;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p000.C0632No;

/* loaded from: classes.dex */
public class C0527Lb extends AbstractC0586Mo {

    public static final C0632No.a f1704j = new a();

    public final boolean f1708g;

    public final HashSet f1705d = new HashSet();

    public final HashMap f1706e = new HashMap<>();

    public final HashMap f1707f = new HashMap<>();

    public boolean f1709h = false;

    public boolean f1710i = false;

    public static class a implements C0632No.a {
        @Override
        public AbstractC0586Mo mo2655a(Class cls) {
            return new C0527Lb(true);
        }
    }

    public C0527Lb(boolean z) {
        this.f1708g = z;
    }

    public static C0527Lb m2652d(C0678Oo c0678Oo) {
        return (C0527Lb) new C0632No(c0678Oo, f1704j).m3330a(C0527Lb.class);
    }

    @Override
    public void mo2653c() {
        if (LayoutInflaterFactory2C0435Jb.f1323F) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1709h = true;
    }

    public Collection m2654e() {
        return this.f1705d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0527Lb c0527Lb = (C0527Lb) obj;
        return this.f1705d.equals(c0527Lb.f1705d) && this.f1706e.equals(c0527Lb.f1706e) && this.f1707f.equals(c0527Lb.f1707f);
    }

    public int hashCode() {
        return (((this.f1705d.hashCode() * 31) + this.f1706e.hashCode()) * 31) + this.f1707f.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1705d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f1706e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f1707f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
