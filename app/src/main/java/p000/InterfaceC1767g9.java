package p000;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: classes.dex */
public interface InterfaceC1767g9 {

    public static final a f5598b = new a(null);

    public static final InterfaceC1767g9 f5597a = new a.C2715a();

    public static final class a {

        public static final class C2715a implements InterfaceC1767g9 {
            @Override
            public List mo7701a(String str) throws UnknownHostException {
                AbstractC0116Ce.m476e(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    AbstractC0116Ce.m475d(allByName, "InetAddress.getAllByName(hostname)");
                    return AbstractC0002A1.m12s(allByName);
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
        }

        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    List mo7701a(String str);
}
