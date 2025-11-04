package p000;

import java.util.Comparator;

public final class C2417uB implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        AbstractC2233qB abstractC2233qB = (AbstractC2233qB) obj;
        AbstractC2233qB abstractC2233qB2 = (AbstractC2233qB) obj2;
        InterfaceC0104CB interfaceC0104CB = (InterfaceC0104CB) abstractC2233qB.iterator();
        InterfaceC0104CB interfaceC0104CB2 = (InterfaceC0104CB) abstractC2233qB2.iterator();
        while (interfaceC0104CB.hasNext() && interfaceC0104CB2.hasNext()) {
            int iCompare = Integer.compare(AbstractC2233qB.m9104g(interfaceC0104CB.mo416a()), AbstractC2233qB.m9104g(interfaceC0104CB2.mo416a()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(abstractC2233qB.mo2843s(), abstractC2233qB2.mo2843s());
    }
}
