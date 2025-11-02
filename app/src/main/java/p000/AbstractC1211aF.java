package p000;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class AbstractC1211aF {

    public static final AbstractC0430JF f3525a = new C0614NF();

    public static int m5191A(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * AbstractC1355cC.m5775P(i, 0L);
    }

    public static int m5192B(List list) {
        return list.size() << 3;
    }

    public static void m5193C(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo108w(i, list, z);
    }

    public static int m5194D(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m5195E(list) + (size * AbstractC1355cC.m5806s0(i));
    }

    public static int m5195E(List list) {
        int iM5794g0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1024WC) {
            C1024WC c1024wc = (C1024WC) list;
            iM5794g0 = 0;
            while (i < size) {
                iM5794g0 += AbstractC1355cC.m5794g0(c1024wc.m4469f(i));
                i++;
            }
        } else {
            iM5794g0 = 0;
            while (i < size) {
                iM5794g0 += AbstractC1355cC.m5794g0(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iM5794g0;
    }

    public static void m5196F(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo91f(i, list, z);
    }

    public static int m5197G(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return m5198H(list) + (list.size() * AbstractC1355cC.m5806s0(i));
    }

    public static int m5198H(List list) {
        int iM5784a0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2649zD) {
            C2649zD c2649zD = (C2649zD) list;
            iM5784a0 = 0;
            while (i < size) {
                iM5784a0 += AbstractC1355cC.m5784a0(c2649zD.mo5850j(i));
                i++;
            }
        } else {
            iM5784a0 = 0;
            while (i < size) {
                iM5784a0 += AbstractC1355cC.m5784a0(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iM5784a0;
    }

    public static void m5199I(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo109x(i, list, z);
    }

    public static int m5200J(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m5201K(list) + (size * AbstractC1355cC.m5806s0(i));
    }

    public static int m5201K(List list) {
        int iM5804o0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1024WC) {
            C1024WC c1024wc = (C1024WC) list;
            iM5804o0 = 0;
            while (i < size) {
                iM5804o0 += AbstractC1355cC.m5804o0(c1024wc.m4469f(i));
                i++;
            }
        } else {
            iM5804o0 = 0;
            while (i < size) {
                iM5804o0 += AbstractC1355cC.m5804o0(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iM5804o0;
    }

    public static void m5202L(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo93h(i, list, z);
    }

    public static int m5203M(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m5204N(list) + (size * AbstractC1355cC.m5806s0(i));
    }

    public static int m5204N(List list) {
        int iM5799j0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2649zD) {
            C2649zD c2649zD = (C2649zD) list;
            iM5799j0 = 0;
            while (i < size) {
                iM5799j0 += AbstractC1355cC.m5799j0(c2649zD.mo5850j(i));
                i++;
            }
        } else {
            iM5799j0 = 0;
            while (i < size) {
                iM5799j0 += AbstractC1355cC.m5799j0(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iM5799j0;
    }

    public static void m5205O(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo110y(i, list, z);
    }

    public static int m5206P(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m5207Q(list) + (size * AbstractC1355cC.m5806s0(i));
    }

    public static int m5207Q(List list) {
        int iM5809v0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1024WC) {
            C1024WC c1024wc = (C1024WC) list;
            iM5809v0 = 0;
            while (i < size) {
                iM5809v0 += AbstractC1355cC.m5809v0(c1024wc.m4469f(i));
                i++;
            }
        } else {
            iM5809v0 = 0;
            while (i < size) {
                iM5809v0 += AbstractC1355cC.m5809v0(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iM5809v0;
    }

    public static void m5208R(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo96k(i, list, z);
    }

    public static int m5209S(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m5210T(list) + (size * AbstractC1355cC.m5806s0(i));
    }

    public static int m5210T(List list) {
        int iM5803n0;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C2649zD) {
            C2649zD c2649zD = (C2649zD) list;
            iM5803n0 = 0;
            while (i < size) {
                iM5803n0 += AbstractC1355cC.m5803n0(c2649zD.mo5850j(i));
                i++;
            }
        } else {
            iM5803n0 = 0;
            while (i < size) {
                iM5803n0 += AbstractC1355cC.m5803n0(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iM5803n0;
    }

    public static void m5211U(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo72B(i, list, z);
    }

    public static void m5212V(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo74D(i, list, z);
    }

    public static void m5213W(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo99n(i, list, z);
    }

    public static void m5214X(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo76F(i, list, z);
    }

    public static void m5215Y(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo101p(i, list, z);
    }

    public static int m5216a(int i, Object obj, InterfaceC1026WE interfaceC1026WE) {
        return AbstractC1355cC.m5777R(i, (InterfaceC1912jE) obj, interfaceC1026WE);
    }

    public static int m5217b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM5806s0 = size * AbstractC1355cC.m5806s0(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iM5806s0 += AbstractC1355cC.m5772B((AbstractC2233qB) list.get(i2));
        }
        return iM5806s0;
    }

    public static int m5218c(int i, List list, InterfaceC1026WE interfaceC1026WE) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM5812y = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iM5812y += AbstractC1355cC.m5812y(i, (InterfaceC1912jE) list.get(i2), interfaceC1026WE);
        }
        return iM5812y;
    }

    public static int m5219d(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * AbstractC1355cC.m5813z(i, true);
    }

    public static int m5220e(List list) {
        return list.size();
    }

    public static Object m5221f(Object obj, int i, int i2, Object obj2, AbstractC0430JF abstractC0430JF) {
        if (obj2 == null) {
            obj2 = abstractC0430JF.mo1882i(obj);
        }
        abstractC0430JF.mo1879f(obj2, i, i2);
        return obj2;
    }

    public static Object m5222g(Object obj, int i, List list, InterfaceC1116YC interfaceC1116YC, Object obj2, AbstractC0430JF abstractC0430JF) {
        if (interfaceC1116YC == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (interfaceC1116YC.mo797e(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = m5221f(obj, i, iIntValue, obj2, abstractC0430JF);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!interfaceC1116YC.mo797e(iIntValue2)) {
                    obj2 = m5221f(obj, i, iIntValue2, obj2, abstractC0430JF);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    public static AbstractC0430JF m5223h() {
        return f3525a;
    }

    public static void m5224i(int i, List list, InterfaceC0017AG interfaceC0017AG) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo77G(i, list);
    }

    public static void m5225j(int i, List list, InterfaceC0017AG interfaceC0017AG, InterfaceC1026WE interfaceC1026WE) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo103r(i, list, interfaceC1026WE);
    }

    public static void m5226k(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo106u(i, list, z);
    }

    public static void m5227l(Class cls) {
        AbstractC0703PC.class.isAssignableFrom(cls);
    }

    public static void m5228m(AbstractC2188pC abstractC2188pC, Object obj, Object obj2) {
        C2556xC c2556xCMo9044b = abstractC2188pC.mo9044b(obj2);
        if (c2556xCMo9044b.f7947a.isEmpty()) {
            return;
        }
        abstractC2188pC.mo9047e(obj).m10641f(c2556xCMo9044b);
    }

    public static void m5229n(InterfaceC0979VD interfaceC0979VD, Object obj, Object obj2, long j) {
        AbstractC0476KF.m2334j(obj, j, interfaceC0979VD.mo4368c(AbstractC0476KF.m2320B(obj, j), AbstractC0476KF.m2320B(obj2, j)));
    }

    public static void m5230o(AbstractC0430JF abstractC0430JF, Object obj, Object obj2) {
        abstractC0430JF.mo1883j(obj, abstractC0430JF.mo1875b(abstractC0430JF.mo1884k(obj), abstractC0430JF.mo1884k(obj2)));
    }

    public static boolean m5231p(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int m5232q(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iM5806s0 = AbstractC1355cC.m5806s0(i) * size;
        if (list instanceof InterfaceC2327sD) {
            InterfaceC2327sD interfaceC2327sD = (InterfaceC2327sD) list;
            while (i2 < size) {
                Object objM9526e = interfaceC2327sD.m9526e(i2);
                iM5806s0 += objM9526e instanceof AbstractC2233qB ? AbstractC1355cC.m5772B((AbstractC2233qB) objM9526e) : AbstractC1355cC.m5771A((String) objM9526e);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iM5806s0 += obj instanceof AbstractC2233qB ? AbstractC1355cC.m5772B((AbstractC2233qB) obj) : AbstractC1355cC.m5771A((String) obj);
                i2++;
            }
        }
        return iM5806s0;
    }

    public static int m5233r(int i, List list, InterfaceC1026WE interfaceC1026WE) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM5806s0 = AbstractC1355cC.m5806s0(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            iM5806s0 += AbstractC1355cC.m5793g((InterfaceC1912jE) list.get(i2), interfaceC1026WE);
        }
        return iM5806s0;
    }

    public static int m5234s(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m5235t(list) + (size * AbstractC1355cC.m5806s0(i));
    }

    public static int m5235t(List list) {
        int iM5781X;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C1024WC) {
            C1024WC c1024wc = (C1024WC) list;
            iM5781X = 0;
            while (i < size) {
                iM5781X += AbstractC1355cC.m5781X(c1024wc.m4469f(i));
                i++;
            }
        } else {
            iM5781X = 0;
            while (i < size) {
                iM5781X += AbstractC1355cC.m5781X(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iM5781X;
    }

    public static void m5236u(int i, List list, InterfaceC0017AG interfaceC0017AG) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo97l(i, list);
    }

    public static void m5237v(int i, List list, InterfaceC0017AG interfaceC0017AG, InterfaceC1026WE interfaceC1026WE) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo79I(i, list, interfaceC1026WE);
    }

    public static void m5238w(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo107v(i, list, z);
    }

    public static int m5239x(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * AbstractC1355cC.m5796h0(i, 0);
    }

    public static int m5240y(List list) {
        return list.size() << 2;
    }

    public static void m5241z(int i, List list, InterfaceC0017AG interfaceC0017AG, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0017AG.mo88c(i, list, z);
    }
}
