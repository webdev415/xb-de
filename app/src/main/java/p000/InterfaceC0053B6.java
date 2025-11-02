package p000;

import java.util.List;

/* loaded from: classes.dex */
public interface InterfaceC0053B6 {

    public static final a f122b = new a(null);

    public static final InterfaceC0053B6 f121a = new a.C2681a();

    public static final class a {

        public static final class C2681a implements InterfaceC0053B6 {
            @Override
            public List mo199a(C0069Bd c0069Bd) {
                AbstractC0116Ce.m476e(c0069Bd, "url");
                return AbstractC1810h5.m7783f();
            }

            @Override
            public void mo200b(C0069Bd c0069Bd, List list) {
                AbstractC0116Ce.m476e(c0069Bd, "url");
                AbstractC0116Ce.m476e(list, "cookies");
            }
        }

        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    List mo199a(C0069Bd c0069Bd);

    void mo200b(C0069Bd c0069Bd, List list);
}
