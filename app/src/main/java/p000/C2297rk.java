package p000;

/* loaded from: classes.dex */
public class C2297rk {
    public InterfaceC2246qf m9429a(Class cls) {
        return new C0419J4(cls);
    }

    public InterfaceC2292rf m9430b(Class cls, String str) {
        return new C2663zi(cls, str);
    }

    public String m9432d(InterfaceC2335sc interfaceC2335sc) {
        String string = interfaceC2335sc.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String m9433e(AbstractC0025Af abstractC0025Af) {
        return m9432d(abstractC0025Af);
    }

    public InterfaceC2338sf m9431c(AbstractC2204pj abstractC2204pj) {
        return abstractC2204pj;
    }
}
