package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class C0147D8 implements InterfaceC0031Al {

    public final CharSequence f367a;

    public final int f368b;

    public final int f369c;

    public final InterfaceC1920jc f370d;

    public static final class a implements Iterator {

        public int f371l = -1;

        public int f372m;

        public int f373n;

        public C2659ze f374o;

        public int f375p;

        public a() {
            int iM4984e = AbstractC1132Yj.m4984e(C0147D8.this.f368b, 0, C0147D8.this.f367a.length());
            this.f372m = iM4984e;
            this.f373n = iM4984e;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m627b() {
            /*
                r6 = this;
                int r0 = r6.f373n
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f371l = r1
                r0 = 0
                r6.f374o = r0
                goto L99
            Lc:
                D8 r0 = p000.C0147D8.this
                int r0 = p000.C0147D8.m625d(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f375p
                int r0 = r0 + r3
                r6.f375p = r0
                D8 r4 = p000.C0147D8.this
                int r4 = p000.C0147D8.m625d(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f373n
                D8 r4 = p000.C0147D8.this
                java.lang.CharSequence r4 = p000.C0147D8.m624c(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                ze r0 = new ze
                int r1 = r6.f372m
                D8 r4 = p000.C0147D8.this
                java.lang.CharSequence r4 = p000.C0147D8.m624c(r4)
                int r4 = p000.AbstractC0584Mm.m2923G(r4)
                r0.<init>(r1, r4)
            L42:
                r6.f374o = r0
            L44:
                r6.f373n = r2
                goto L97
            L47:
                D8 r0 = p000.C0147D8.this
                jc r0 = p000.C0147D8.m623b(r0)
                D8 r4 = p000.C0147D8.this
                java.lang.CharSequence r4 = p000.C0147D8.m624c(r4)
                int r5 = r6.f373n
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.mo858j(r4, r5)
                Fi r0 = (p000.C0258Fi) r0
                if (r0 != 0) goto L73
                ze r0 = new ze
                int r1 = r6.f372m
                D8 r4 = p000.C0147D8.this
                java.lang.CharSequence r4 = p000.C0147D8.m624c(r4)
                int r4 = p000.AbstractC0584Mm.m2923G(r4)
                r0.<init>(r1, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.m1259a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.m1260b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f372m
                ze r4 = p000.AbstractC1132Yj.m4987h(r4, r2)
                r6.f374o = r4
                int r2 = r2 + r0
                r6.f372m = r2
                if (r0 != 0) goto L95
                r1 = r3
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f371l = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0147D8.a.m627b():void");
        }

        @Override
        public C2659ze next() {
            if (this.f371l == -1) {
                m627b();
            }
            if (this.f371l == 0) {
                throw new NoSuchElementException();
            }
            C2659ze c2659ze = this.f374o;
            AbstractC0116Ce.m474c(c2659ze, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f374o = null;
            this.f371l = -1;
            return c2659ze;
        }

        @Override
        public boolean hasNext() {
            if (this.f371l == -1) {
                m627b();
            }
            return this.f371l == 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C0147D8(CharSequence charSequence, int i, int i2, InterfaceC1920jc interfaceC1920jc) {
        AbstractC0116Ce.m476e(charSequence, "input");
        AbstractC0116Ce.m476e(interfaceC1920jc, "getNextMatch");
        this.f367a = charSequence;
        this.f368b = i;
        this.f369c = i2;
        this.f370d = interfaceC1920jc;
    }

    @Override
    public Iterator iterator() {
        return new a();
    }
}
