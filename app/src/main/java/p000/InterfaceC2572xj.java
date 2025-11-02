package p000;

import java.util.List;

/* loaded from: classes.dex */
public interface InterfaceC2572xj {

    public static final a f8020b = new a(null);

    public static final InterfaceC2572xj f8019a = new a.C2728a();

    public static final class a {

        public static final class C2728a implements InterfaceC2572xj {
            @Override
            public boolean mo10766a(int i, List list) {
                AbstractC0116Ce.m476e(list, "requestHeaders");
                return true;
            }

            @Override
            public boolean mo10767b(int i, List list, boolean z) {
                AbstractC0116Ce.m476e(list, "responseHeaders");
                return true;
            }

            @Override
            public boolean mo10768c(int i, InterfaceC2547x3 interfaceC2547x3, int i2, boolean z) {
                AbstractC0116Ce.m476e(interfaceC2547x3, "source");
                interfaceC2547x3.mo7347r(i2);
                return true;
            }

            @Override
            public void mo10769d(int i, EnumC1159Z9 enumC1159Z9) {
                AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
            }
        }

        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    boolean mo10766a(int i, List list);

    boolean mo10767b(int i, List list, boolean z);

    boolean mo10768c(int i, InterfaceC2547x3 interfaceC2547x3, int i2, boolean z);

    void mo10769d(int i, EnumC1159Z9 enumC1159Z9);
}
