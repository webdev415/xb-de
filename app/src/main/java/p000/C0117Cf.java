package p000;

public class C0117Cf implements InterfaceC2388tj {

    public static final Object f289c = new Object();

    public volatile Object f290a = f289c;

    public volatile InterfaceC2388tj f291b;

    public C0117Cf(InterfaceC2388tj interfaceC2388tj) {
        this.f291b = interfaceC2388tj;
    }

    @Override
    public Object get() {
        Object obj = this.f290a;
        Object obj2 = f289c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f290a;
                    if (obj == obj2) {
                        obj = this.f291b.get();
                        this.f290a = obj;
                        this.f291b = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
