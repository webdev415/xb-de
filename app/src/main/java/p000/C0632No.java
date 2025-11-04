package p000;

import p000.AbstractC0926U6;

public class C0632No {

    public final C0678Oo f1966a;

    public final a f1967b;

    public final AbstractC0926U6 f1968c;

    public interface a {

        public static final C2695a f1969a = C2695a.f1970a;

        public static final class C2695a {

            public static final C2695a f1970a = new C2695a();
        }

        AbstractC0586Mo mo2655a(Class cls);

        default AbstractC0586Mo m3332b(Class cls, AbstractC0926U6 abstractC0926U6) {
            AbstractC0116Ce.m476e(cls, "modelClass");
            AbstractC0116Ce.m476e(abstractC0926U6, "extras");
            return mo2655a(cls);
        }
    }

    public static class b implements a {

        public static final a f1971b = new a(null);

        public static final AbstractC0926U6.b f1972c = a.C2696a.f1973a;

        public static final class a {

            public static final class C2696a implements AbstractC0926U6.b {

                public static final C2696a f1973a = new C2696a();
            }

            public a() {
            }

            public a(AbstractC0881T7 abstractC0881T7) {
                this();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0632No(C0678Oo c0678Oo, a aVar) {
        this(c0678Oo, aVar, null, 4, null);
        AbstractC0116Ce.m476e(c0678Oo, "store");
        AbstractC0116Ce.m476e(aVar, "factory");
    }

    public AbstractC0586Mo m3330a(Class cls) {
        AbstractC0116Ce.m476e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return m3331b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public AbstractC0586Mo m3331b(String str, Class cls) {
        AbstractC0586Mo abstractC0586MoMo2655a;
        AbstractC0116Ce.m476e(str, "key");
        AbstractC0116Ce.m476e(cls, "modelClass");
        AbstractC0586Mo abstractC0586MoM3440b = this.f1966a.m3440b(str);
        if (cls.isInstance(abstractC0586MoM3440b)) {
            AbstractC0116Ce.m474c(abstractC0586MoM3440b, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return abstractC0586MoM3440b;
        }
        C1879ih c1879ih = new C1879ih(this.f1968c);
        c1879ih.m7965b(b.f1972c, str);
        try {
            abstractC0586MoMo2655a = this.f1967b.m3332b(cls, c1879ih);
        } catch (AbstractMethodError unused) {
            abstractC0586MoMo2655a = this.f1967b.mo2655a(cls);
        }
        this.f1966a.m3441c(str, abstractC0586MoMo2655a);
        return abstractC0586MoMo2655a;
    }

    public C0632No(C0678Oo c0678Oo, a aVar, AbstractC0926U6 abstractC0926U6) {
        AbstractC0116Ce.m476e(c0678Oo, "store");
        AbstractC0116Ce.m476e(aVar, "factory");
        AbstractC0116Ce.m476e(abstractC0926U6, "defaultCreationExtras");
        this.f1966a = c0678Oo;
        this.f1967b = aVar;
        this.f1968c = abstractC0926U6;
    }

    public C0632No(C0678Oo c0678Oo, a aVar, AbstractC0926U6 abstractC0926U6, int i, AbstractC0881T7 abstractC0881T7) {
        this(c0678Oo, aVar, (i & 4) != 0 ? AbstractC0926U6.a.f2823b : abstractC0926U6);
    }
}
