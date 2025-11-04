package p000;

import android.content.ContentResolver;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class C1896iz implements InterfaceC1943jz {

    public final AtomicBoolean f5833a = new AtomicBoolean();

    public HashMap f5834b = null;

    public final HashMap f5835c = new HashMap<>(16, 1.0f);

    public final HashMap f5836d = new HashMap<>(16, 1.0f);

    public final HashMap f5837e = new HashMap<>(16, 1.0f);

    public final HashMap f5838f = new HashMap<>(16, 1.0f);

    public Object f5839g = null;

    public boolean f5840h = false;

    public String[] f5841i = new String[0];

    public final InterfaceC2496vz f5842j = new C2312rz();

    @Override
    public final String mo8010a(ContentResolver contentResolver, String str, String str2) {
        if (contentResolver == null) {
            throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
        }
        synchronized (this) {
            try {
                if (this.f5834b == null) {
                    this.f5833a.set(false);
                    this.f5834b = new HashMap<>(16, 1.0f);
                    this.f5839g = new Object();
                    contentResolver.registerContentObserver(AbstractC1803gz.f5668a, true, new C2035lz(this, null));
                } else if (this.f5833a.getAndSet(false)) {
                    this.f5834b.clear();
                    this.f5835c.clear();
                    this.f5836d.clear();
                    this.f5837e.clear();
                    this.f5838f.clear();
                    this.f5839g = new Object();
                    this.f5840h = false;
                }
                Object obj = this.f5839g;
                if (this.f5834b.containsKey(str)) {
                    String str3 = (String) this.f5834b.get(str);
                    return str3 != null ? str3 : null;
                }
                for (String str4 : this.f5841i) {
                    if (str.startsWith(str4)) {
                        if (!this.f5840h) {
                            try {
                                HashMap map = (HashMap) this.f5842j.mo9453a(contentResolver, this.f5841i, new InterfaceC2220pz() {
                                    @Override
                                    public final Map mo8814e(int i) {
                                        return new HashMap<>(i, 1.0f);
                                    }
                                });
                                if (!map.isEmpty()) {
                                    Set setKeySet = map.keySet();
                                    setKeySet.removeAll(this.f5835c.keySet());
                                    setKeySet.removeAll(this.f5836d.keySet());
                                    setKeySet.removeAll(this.f5837e.keySet());
                                    setKeySet.removeAll(this.f5838f.keySet());
                                }
                                if (!map.isEmpty()) {
                                    if (this.f5834b.isEmpty()) {
                                        this.f5834b = map;
                                    } else {
                                        this.f5834b.putAll(map);
                                    }
                                }
                                this.f5840h = true;
                            } catch (C2404tz unused) {
                            }
                            if (this.f5834b.containsKey(str)) {
                                String str5 = (String) this.f5834b.get(str);
                                return str5 != null ? str5 : null;
                            }
                        }
                        return null;
                    }
                }
                try {
                    String strMo9454b = this.f5842j.mo9454b(contentResolver, str);
                    if (strMo9454b != null && strMo9454b.equals(null)) {
                        strMo9454b = null;
                    }
                    synchronized (this) {
                        try {
                            if (obj == this.f5839g) {
                                this.f5834b.put(str, strMo9454b);
                            }
                        } finally {
                        }
                    }
                    if (strMo9454b != null) {
                        return strMo9454b;
                    }
                    return null;
                } catch (C2404tz unused2) {
                    return null;
                }
            } finally {
            }
        }
    }
}
