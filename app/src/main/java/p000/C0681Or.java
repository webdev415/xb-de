package p000;

import java.util.Arrays;
import java.util.Comparator;

public final class C0681Or implements Comparator {

    public final AbstractC0450Jq f2064l;

    public final C2357sy f2065m;

    public C0681Or(AbstractC0450Jq abstractC0450Jq, C2357sy c2357sy) {
        this.f2064l = abstractC0450Jq;
        this.f2065m = c2357sy;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        InterfaceC0909Tq interfaceC0909Tq = (InterfaceC0909Tq) obj;
        InterfaceC0909Tq interfaceC0909Tq2 = (InterfaceC0909Tq) obj2;
        AbstractC0450Jq abstractC0450Jq = this.f2064l;
        C2357sy c2357sy = this.f2065m;
        if (interfaceC0909Tq instanceof C1842hr) {
            return !(interfaceC0909Tq2 instanceof C1842hr) ? 1 : 0;
        }
        if (interfaceC0909Tq2 instanceof C1842hr) {
            return -1;
        }
        return abstractC0450Jq == null ? interfaceC0909Tq.mo154h().compareTo(interfaceC0909Tq2.mo154h()) : (int) AbstractC1145Yw.m4994a(abstractC0450Jq.mo1366b(c2357sy, Arrays.asList(interfaceC0909Tq, interfaceC0909Tq2)).mo153f().doubleValue());
    }
}
