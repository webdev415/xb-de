package p000;

import java.util.Map;

public abstract class AbstractC2201pg {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class a implements InterfaceC2289rc {

        public static final a f6642l = new C2721a("KEY", 0);

        public static final a f6643m = new b("VALUE", 1);

        public static final a[] f6644n = m9069c();

        public enum C2721a extends a {
            public C2721a(String str, int i) {
                super(str, i, null);
            }

            @Override
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        public enum b extends a {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        public a(String str, int i) {
        }

        public static a[] m9069c() {
            return new a[]{f6642l, f6643m};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f6644n.clone();
        }

        public a(String str, int i, AbstractC2154og abstractC2154og) {
            this(str, i);
        }
    }

    public static boolean m9065a(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static InterfaceC2289rc m9066b() {
        return a.f6642l;
    }

    public static String m9067c(Map map) {
        StringBuilder sbM7546a = AbstractC1716f5.m7546a(map.size());
        sbM7546a.append('{');
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z) {
                sbM7546a.append(", ");
            }
            sbM7546a.append(entry.getKey());
            sbM7546a.append('=');
            sbM7546a.append(entry.getValue());
            z = false;
        }
        sbM7546a.append('}');
        return sbM7546a.toString();
    }

    public static InterfaceC2289rc m9068d() {
        return a.f6643m;
    }
}
