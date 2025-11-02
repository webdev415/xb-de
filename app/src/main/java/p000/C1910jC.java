package p000;

import java.util.List;
import java.util.Map;

public final class C1910jC implements InterfaceC0017AG {

    public final AbstractC1355cC f5935a;

    public C1910jC(AbstractC1355cC abstractC1355cC) {
        AbstractC1355cC abstractC1355cC2 = (AbstractC1355cC) AbstractC0932UC.m4210f(abstractC1355cC, "output");
        this.f5935a = abstractC1355cC2;
        abstractC1355cC2.f3935a = this;
    }

    public static C1910jC m8124P(AbstractC1355cC abstractC1355cC) {
        C1910jC c1910jC = abstractC1355cC.f3935a;
        return c1910jC != null ? c1910jC : new C1910jC(abstractC1355cC);
    }

    @Override
    public final void mo71A(int i, Object obj, InterfaceC1026WE interfaceC1026WE) {
        AbstractC1355cC abstractC1355cC = this.f5935a;
        abstractC1355cC.mo5827V(i, 3);
        interfaceC1026WE.mo4480g((InterfaceC1912jE) obj, abstractC1355cC.f3935a);
        abstractC1355cC.mo5827V(i, 4);
    }

    @Override
    public final void mo72B(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2649zD)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.mo5833m(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5792f0 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5792f0 += AbstractC1355cC.m5792f0(((Long) list.get(i3)).longValue());
            }
            this.f5935a.mo5826U(iM5792f0);
            while (i2 < list.size()) {
                this.f5935a.mo5841s(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        C2649zD c2649zD = (C2649zD) list;
        if (!z) {
            while (i2 < c2649zD.size()) {
                this.f5935a.mo5833m(i, c2649zD.mo5850j(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5792f02 = 0;
        for (int i4 = 0; i4 < c2649zD.size(); i4++) {
            iM5792f02 += AbstractC1355cC.m5792f0(c2649zD.mo5850j(i4));
        }
        this.f5935a.mo5826U(iM5792f02);
        while (i2 < c2649zD.size()) {
            this.f5935a.mo5841s(c2649zD.mo5850j(i2));
            i2++;
        }
    }

    @Override
    public final void mo73C(int i, int i2) {
        this.f5935a.m5847y0(i, i2);
    }

    @Override
    public final void mo74D(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C1024WC)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.m5847y0(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5804o0 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5804o0 += AbstractC1355cC.m5804o0(((Integer) list.get(i3)).intValue());
            }
            this.f5935a.mo5826U(iM5804o0);
            while (i2 < list.size()) {
                this.f5935a.m5846x0(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C1024WC c1024wc = (C1024WC) list;
        if (!z) {
            while (i2 < c1024wc.size()) {
                this.f5935a.m5847y0(i, c1024wc.m4469f(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5804o02 = 0;
        for (int i4 = 0; i4 < c1024wc.size(); i4++) {
            iM5804o02 += AbstractC1355cC.m5804o0(c1024wc.m4469f(i4));
        }
        this.f5935a.mo5826U(iM5804o02);
        while (i2 < c1024wc.size()) {
            this.f5935a.m5846x0(c1024wc.m4469f(i2));
            i2++;
        }
    }

    @Override
    public final void mo75E(int i, long j) {
        this.f5935a.mo5822L(i, j);
    }

    @Override
    public final void mo76F(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C1024WC)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.mo5829b0(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5809v0 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5809v0 += AbstractC1355cC.m5809v0(((Integer) list.get(i3)).intValue());
            }
            this.f5935a.mo5826U(iM5809v0);
            while (i2 < list.size()) {
                this.f5935a.mo5826U(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C1024WC c1024wc = (C1024WC) list;
        if (!z) {
            while (i2 < c1024wc.size()) {
                this.f5935a.mo5829b0(i, c1024wc.m4469f(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5809v02 = 0;
        for (int i4 = 0; i4 < c1024wc.size(); i4++) {
            iM5809v02 += AbstractC1355cC.m5809v0(c1024wc.m4469f(i4));
        }
        this.f5935a.mo5826U(iM5809v02);
        while (i2 < c1024wc.size()) {
            this.f5935a.mo5826U(c1024wc.m4469f(i2));
            i2++;
        }
    }

    @Override
    public final void mo77G(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f5935a.mo5835o(i, (AbstractC2233qB) list.get(i2));
        }
    }

    @Override
    public final void mo78H(int i, int i2) {
        this.f5935a.mo5821K(i, i2);
    }

    @Override
    public final void mo79I(int i, List list, InterfaceC1026WE interfaceC1026WE) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo94i(i, list.get(i2), interfaceC1026WE);
        }
    }

    @Override
    public final void mo80J(int i, AbstractC2233qB abstractC2233qB) {
        this.f5935a.mo5835o(i, abstractC2233qB);
    }

    @Override
    public final void mo81K(int i, long j) {
        this.f5935a.mo5833m(i, j);
    }

    @Override
    public final void mo82L(int i, int i2) {
        this.f5935a.mo5821K(i, i2);
    }

    @Override
    public final void mo83M(int i, double d) {
        this.f5935a.m5819I(i, d);
    }

    @Override
    public final void mo84N(int i, float f) {
        this.f5935a.m5820J(i, f);
    }

    @Override
    public final void mo85O(int i, long j) {
        this.f5935a.mo5833m(i, j);
    }

    @Override
    public final int mo86a() {
        return 1;
    }

    @Override
    public final void mo87b(int i, Object obj) {
        if (obj instanceof AbstractC2233qB) {
            this.f5935a.mo5823M(i, (AbstractC2233qB) obj);
        } else {
            this.f5935a.mo5836p(i, (InterfaceC1912jE) obj);
        }
    }

    @Override
    public final void mo88c(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C1024WC)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.mo5821K(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5781X = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5781X += AbstractC1355cC.m5781X(((Integer) list.get(i3)).intValue());
            }
            this.f5935a.mo5826U(iM5781X);
            while (i2 < list.size()) {
                this.f5935a.mo5818H(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C1024WC c1024wc = (C1024WC) list;
        if (!z) {
            while (i2 < c1024wc.size()) {
                this.f5935a.mo5821K(i, c1024wc.m4469f(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5781X2 = 0;
        for (int i4 = 0; i4 < c1024wc.size(); i4++) {
            iM5781X2 += AbstractC1355cC.m5781X(c1024wc.m4469f(i4));
        }
        this.f5935a.mo5826U(iM5781X2);
        while (i2 < c1024wc.size()) {
            this.f5935a.mo5818H(c1024wc.m4469f(i2));
            i2++;
        }
    }

    @Override
    public final void mo89d(int i, AbstractC0795RD abstractC0795RD, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f5935a.mo5827V(i, 2);
            this.f5935a.mo5826U(AbstractC0887TD.m4120a(abstractC0795RD, entry.getKey(), entry.getValue()));
            AbstractC0887TD.m4121b(this.f5935a, abstractC0795RD, entry.getKey(), entry.getValue());
        }
    }

    @Override
    public final void mo90e(int i) {
        this.f5935a.mo5827V(i, 4);
    }

    @Override
    public final void mo91f(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2649zD)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.mo5833m(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5778S = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5778S += AbstractC1355cC.m5778S(((Long) list.get(i3)).longValue());
            }
            this.f5935a.mo5826U(iM5778S);
            while (i2 < list.size()) {
                this.f5935a.mo5841s(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        C2649zD c2649zD = (C2649zD) list;
        if (!z) {
            while (i2 < c2649zD.size()) {
                this.f5935a.mo5833m(i, c2649zD.mo5850j(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5778S2 = 0;
        for (int i4 = 0; i4 < c2649zD.size(); i4++) {
            iM5778S2 += AbstractC1355cC.m5778S(c2649zD.mo5850j(i4));
        }
        this.f5935a.mo5826U(iM5778S2);
        while (i2 < c2649zD.size()) {
            this.f5935a.mo5841s(c2649zD.mo5850j(i2));
            i2++;
        }
    }

    @Override
    public final void mo92g(int i, boolean z) {
        this.f5935a.mo5839r(i, z);
    }

    @Override
    public final void mo93h(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C1024WC)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.mo5821K(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5794g0 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5794g0 += AbstractC1355cC.m5794g0(((Integer) list.get(i3)).intValue());
            }
            this.f5935a.mo5826U(iM5794g0);
            while (i2 < list.size()) {
                this.f5935a.mo5818H(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C1024WC c1024wc = (C1024WC) list;
        if (!z) {
            while (i2 < c1024wc.size()) {
                this.f5935a.mo5821K(i, c1024wc.m4469f(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5794g02 = 0;
        for (int i4 = 0; i4 < c1024wc.size(); i4++) {
            iM5794g02 += AbstractC1355cC.m5794g0(c1024wc.m4469f(i4));
        }
        this.f5935a.mo5826U(iM5794g02);
        while (i2 < c1024wc.size()) {
            this.f5935a.mo5818H(c1024wc.m4469f(i2));
            i2++;
        }
    }

    @Override
    public final void mo94i(int i, Object obj, InterfaceC1026WE interfaceC1026WE) {
        this.f5935a.mo5837q(i, (InterfaceC1912jE) obj, interfaceC1026WE);
    }

    @Override
    public final void mo95j(int i) {
        this.f5935a.mo5827V(i, 3);
    }

    @Override
    public final void mo96k(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C1024WC)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.mo5832l(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5800k0 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5800k0 += AbstractC1355cC.m5800k0(((Integer) list.get(i3)).intValue());
            }
            this.f5935a.mo5826U(iM5800k0);
            while (i2 < list.size()) {
                this.f5935a.mo5831k(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C1024WC c1024wc = (C1024WC) list;
        if (!z) {
            while (i2 < c1024wc.size()) {
                this.f5935a.mo5832l(i, c1024wc.m4469f(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5800k02 = 0;
        for (int i4 = 0; i4 < c1024wc.size(); i4++) {
            iM5800k02 += AbstractC1355cC.m5800k0(c1024wc.m4469f(i4));
        }
        this.f5935a.mo5826U(iM5800k02);
        while (i2 < c1024wc.size()) {
            this.f5935a.mo5831k(c1024wc.m4469f(i2));
            i2++;
        }
    }

    @Override
    public final void mo97l(int i, List list) {
        int i2 = 0;
        if (!(list instanceof InterfaceC2327sD)) {
            while (i2 < list.size()) {
                this.f5935a.mo5834n(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        InterfaceC2327sD interfaceC2327sD = (InterfaceC2327sD) list;
        while (i2 < list.size()) {
            Object objM9526e = interfaceC2327sD.m9526e(i2);
            if (objM9526e instanceof String) {
                this.f5935a.mo5834n(i, (String) objM9526e);
            } else {
                this.f5935a.mo5835o(i, (AbstractC2233qB) objM9526e);
            }
            i2++;
        }
    }

    @Override
    public final void mo98m(int i, int i2) {
        this.f5935a.mo5832l(i, i2);
    }

    @Override
    public final void mo99n(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2649zD)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.m5838q0(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5799j0 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5799j0 += AbstractC1355cC.m5799j0(((Long) list.get(i3)).longValue());
            }
            this.f5935a.mo5826U(iM5799j0);
            while (i2 < list.size()) {
                this.f5935a.m5840r0(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        C2649zD c2649zD = (C2649zD) list;
        if (!z) {
            while (i2 < c2649zD.size()) {
                this.f5935a.m5838q0(i, c2649zD.mo5850j(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5799j02 = 0;
        for (int i4 = 0; i4 < c2649zD.size(); i4++) {
            iM5799j02 += AbstractC1355cC.m5799j0(c2649zD.mo5850j(i4));
        }
        this.f5935a.mo5826U(iM5799j02);
        while (i2 < c2649zD.size()) {
            this.f5935a.m5840r0(c2649zD.mo5850j(i2));
            i2++;
        }
    }

    @Override
    public final void mo100o(int i, int i2) {
        this.f5935a.mo5829b0(i, i2);
    }

    @Override
    public final void mo101p(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2649zD)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.mo5822L(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5803n0 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5803n0 += AbstractC1355cC.m5803n0(((Long) list.get(i3)).longValue());
            }
            this.f5935a.mo5826U(iM5803n0);
            while (i2 < list.size()) {
                this.f5935a.mo5824N(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        C2649zD c2649zD = (C2649zD) list;
        if (!z) {
            while (i2 < c2649zD.size()) {
                this.f5935a.mo5822L(i, c2649zD.mo5850j(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5803n02 = 0;
        for (int i4 = 0; i4 < c2649zD.size(); i4++) {
            iM5803n02 += AbstractC1355cC.m5803n0(c2649zD.mo5850j(i4));
        }
        this.f5935a.mo5826U(iM5803n02);
        while (i2 < c2649zD.size()) {
            this.f5935a.mo5824N(c2649zD.mo5850j(i2));
            i2++;
        }
    }

    @Override
    public final void mo102q(int i, long j) {
        this.f5935a.mo5822L(i, j);
    }

    @Override
    public final void mo103r(int i, List list, InterfaceC1026WE interfaceC1026WE) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo71A(i, list.get(i2), interfaceC1026WE);
        }
    }

    @Override
    public final void mo104s(int i, long j) {
        this.f5935a.m5838q0(i, j);
    }

    @Override
    public final void mo105t(int i, int i2) {
        this.f5935a.mo5832l(i, i2);
    }

    @Override
    public final void mo106u(int i, List list, boolean z) {
        if (list instanceof AbstractC2048mB) {
            AbstractC2524wh.m10586a(list);
            if (!z) {
                throw null;
            }
            this.f5935a.mo5827V(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f5935a.mo5839r(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5795h = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM5795h += AbstractC1355cC.m5795h(((Boolean) list.get(i3)).booleanValue());
        }
        this.f5935a.mo5826U(iM5795h);
        while (i2 < list.size()) {
            this.f5935a.m5825O(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    @Override
    public final void mo107v(int i, List list, boolean z) {
        if (list instanceof AbstractC1817hC) {
            AbstractC2524wh.m10586a(list);
            if (!z) {
                throw null;
            }
            this.f5935a.mo5827V(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f5935a.m5819I(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5785c = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM5785c += AbstractC1355cC.m5785c(((Double) list.get(i3)).doubleValue());
        }
        this.f5935a.mo5826U(iM5785c);
        while (i2 < list.size()) {
            this.f5935a.m5816F(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    @Override
    public final void mo108w(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C1024WC)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.mo5832l(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5786c0 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5786c0 += AbstractC1355cC.m5786c0(((Integer) list.get(i3)).intValue());
            }
            this.f5935a.mo5826U(iM5786c0);
            while (i2 < list.size()) {
                this.f5935a.mo5831k(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        C1024WC c1024wc = (C1024WC) list;
        if (!z) {
            while (i2 < c1024wc.size()) {
                this.f5935a.mo5832l(i, c1024wc.m4469f(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5786c02 = 0;
        for (int i4 = 0; i4 < c1024wc.size(); i4++) {
            iM5786c02 += AbstractC1355cC.m5786c0(c1024wc.m4469f(i4));
        }
        this.f5935a.mo5826U(iM5786c02);
        while (i2 < c1024wc.size()) {
            this.f5935a.mo5831k(c1024wc.m4469f(i2));
            i2++;
        }
    }

    @Override
    public final void mo109x(int i, List list, boolean z) {
        if (list instanceof AbstractC0657OC) {
            AbstractC2524wh.m10586a(list);
            if (!z) {
                throw null;
            }
            this.f5935a.mo5827V(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f5935a.m5820J(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5787d = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iM5787d += AbstractC1355cC.m5787d(((Float) list.get(i3)).floatValue());
        }
        this.f5935a.mo5826U(iM5787d);
        while (i2 < list.size()) {
            this.f5935a.m5817G(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    @Override
    public final void mo110y(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof C2649zD)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.f5935a.mo5822L(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.f5935a.mo5827V(i, 2);
            int iM5784a0 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iM5784a0 += AbstractC1355cC.m5784a0(((Long) list.get(i3)).longValue());
            }
            this.f5935a.mo5826U(iM5784a0);
            while (i2 < list.size()) {
                this.f5935a.mo5824N(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        C2649zD c2649zD = (C2649zD) list;
        if (!z) {
            while (i2 < c2649zD.size()) {
                this.f5935a.mo5822L(i, c2649zD.mo5850j(i2));
                i2++;
            }
            return;
        }
        this.f5935a.mo5827V(i, 2);
        int iM5784a02 = 0;
        for (int i4 = 0; i4 < c2649zD.size(); i4++) {
            iM5784a02 += AbstractC1355cC.m5784a0(c2649zD.mo5850j(i4));
        }
        this.f5935a.mo5826U(iM5784a02);
        while (i2 < c2649zD.size()) {
            this.f5935a.mo5824N(c2649zD.mo5850j(i2));
            i2++;
        }
    }

    @Override
    public final void mo111z(int i, String str) {
        this.f5935a.mo5834n(i, str);
    }
}
