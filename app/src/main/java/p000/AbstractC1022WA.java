package p000;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractC1022WA implements InterfaceC1912jE {
    protected int zza = 0;

    public static void m4463f(Iterable iterable, List list) {
        AbstractC2233qB abstractC2233qBM9107o;
        AbstractC0932UC.m4209e(iterable);
        if (!(iterable instanceof InterfaceC2327sD)) {
            if (iterable instanceof InterfaceC0245FE) {
                list.addAll((Collection) iterable);
                return;
            }
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
            return;
        }
        List listM9525a = ((InterfaceC2327sD) iterable).m9525a();
        InterfaceC2327sD interfaceC2327sD = (InterfaceC2327sD) list;
        int size3 = list.size();
        for (Object obj2 : listM9525a) {
            if (obj2 == null) {
                String str2 = "Element at index " + (interfaceC2327sD.size() - size3) + " is null.";
                for (int size4 = interfaceC2327sD.size() - 1; size4 >= size3; size4--) {
                    interfaceC2327sD.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            if (obj2 instanceof AbstractC2233qB) {
                abstractC2233qBM9107o = (AbstractC2233qB) obj2;
            } else if (obj2 instanceof byte[]) {
                abstractC2233qBM9107o = AbstractC2233qB.m9107o((byte[]) obj2);
            } else {
                interfaceC2327sD.add((String) obj2);
            }
            interfaceC2327sD.m9527m(abstractC2233qBM9107o);
        }
    }

    public abstract int mo3511e(InterfaceC1026WE interfaceC1026WE);

    public abstract int mo3512g();

    public abstract void mo3513h(int i);

    public final byte[] m4464i() {
        try {
            byte[] bArr = new byte[mo3509c()];
            AbstractC1355cC abstractC1355cCM5774D = AbstractC1355cC.m5774D(bArr);
            mo3510d(abstractC1355cCM5774D);
            abstractC1355cCM5774D.m5815E();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
