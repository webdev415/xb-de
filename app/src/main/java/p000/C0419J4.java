package p000;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class C0419J4 implements InterfaceC2246qf, InterfaceC0373I4 {

    public static final a f1259b = new a(null);

    public static final Map f1260c;

    public static final HashMap f1261d;

    public static final HashMap f1262e;

    public static final HashMap f1263f;

    public static final Map f1264g;

    public final Class f1265a;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    static {
        List listM7785h = AbstractC1810h5.m7785h(InterfaceC0894Tb.class, InterfaceC0986Vb.class, InterfaceC1920jc.class, InterfaceC1966kc.class, InterfaceC2012lc.class, InterfaceC2058mc.class, InterfaceC2104nc.class, InterfaceC2150oc.class, InterfaceC2197pc.class, InterfaceC2243qc.class, InterfaceC0940Ub.class, InterfaceC1032Wb.class, InterfaceC1078Xb.class, InterfaceC1124Yb.class, InterfaceC1170Zb.class, InterfaceC1218ac.class, InterfaceC1319bc.class, InterfaceC1365cc.class, InterfaceC1640dc.class, InterfaceC1686ec.class, InterfaceC1780gc.class, InterfaceC1827hc.class, InterfaceC1874ic.class);
        ArrayList arrayList = new ArrayList<>(AbstractC1857i5.m7866n(listM7785h, 10));
        int i = 0;
        for (Object obj : listM7785h) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC1810h5.m7790m();
            }
            arrayList.add(AbstractC0769Qn.m3706a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        f1260c = AbstractC2339sg.m9575g(arrayList);
        HashMap map = new HashMap<>();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f1261d = map;
        HashMap map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f1262e = map2;
        HashMap map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        AbstractC0116Ce.m475d(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            AbstractC0116Ce.m475d(str, "kotlinName");
            sb.append(AbstractC0584Mm.m2955m0(str, '.', null, 2, null));
            sb.append("CompanionObject");
            C0258Fi c0258FiM3706a = AbstractC0769Qn.m3706a(sb.toString(), str + ".Companion");
            map3.put(c0258FiM3706a.m1261c(), c0258FiM3706a.m1262d());
        }
        for (Map.Entry entry : f1260c.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f1263f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC2293rg.m9412a(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), AbstractC0584Mm.m2955m0((String) entry2.getValue(), '.', null, 2, null));
        }
        f1264g = linkedHashMap;
    }

    public C0419J4(Class cls) {
        AbstractC0116Ce.m476e(cls, "jClass");
        this.f1265a = cls;
    }

    @Override
    public Class mo1674a() {
        return this.f1265a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0419J4) && AbstractC0116Ce.m472a(AbstractC2153of.m8963a(this), AbstractC2153of.m8963a((InterfaceC2246qf) obj));
    }

    public int hashCode() {
        return AbstractC2153of.m8963a(this).hashCode();
    }

    public String toString() {
        return mo1674a().toString() + " (Kotlin reflection is not available)";
    }
}
