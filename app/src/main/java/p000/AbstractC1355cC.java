package p000;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractC1355cC extends AbstractC1956kB {

    public static final Logger f3933b = Logger.getLogger(AbstractC1355cC.class.getName());

    public static final boolean f3934c = AbstractC0476KF.m2347w();

    public C1910jC f3935a;

    public static class a extends AbstractC1355cC {

        public final byte[] f3936d;

        public final int f3937e;

        public int f3938f;

        public a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.f3936d = bArr;
            this.f3938f = 0;
            this.f3937e = i2;
        }

        public final void m5848A0(byte[] bArr, int i, int i2) throws b {
            try {
                System.arraycopy(bArr, i, this.f3936d, this.f3938f, i2);
                this.f3938f += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3938f), Integer.valueOf(this.f3937e), Integer.valueOf(i2)), e);
            }
        }

        @Override
        public final void mo5818H(int i) {
            if (i >= 0) {
                mo5826U(i);
            } else {
                mo5824N(i);
            }
        }

        @Override
        public final void mo5821K(int i, int i2) {
            mo5827V(i, 0);
            mo5818H(i2);
        }

        @Override
        public final void mo5822L(int i, long j) {
            mo5827V(i, 0);
            mo5824N(j);
        }

        @Override
        public final void mo5823M(int i, AbstractC2233qB abstractC2233qB) {
            mo5827V(1, 3);
            mo5829b0(2, i);
            mo5835o(3, abstractC2233qB);
            mo5827V(1, 4);
        }

        @Override
        public final void mo5824N(long j) throws b {
            if (AbstractC1355cC.f3934c && mo5828b() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f3936d;
                    int i = this.f3938f;
                    this.f3938f = i + 1;
                    AbstractC0476KF.m2337m(bArr, i, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f3936d;
                int i2 = this.f3938f;
                this.f3938f = i2 + 1;
                AbstractC0476KF.m2337m(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f3936d;
                    int i3 = this.f3938f;
                    this.f3938f = i3 + 1;
                    bArr3[i3] = (byte) (((int) j) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3938f), Integer.valueOf(this.f3937e), 1), e);
                }
            }
            byte[] bArr4 = this.f3936d;
            int i4 = this.f3938f;
            this.f3938f = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override
        public final void mo5826U(int i) throws b {
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr = this.f3936d;
                    int i2 = this.f3938f;
                    this.f3938f = i2 + 1;
                    bArr[i2] = (byte) (i | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3938f), Integer.valueOf(this.f3937e), 1), e);
                }
            }
            byte[] bArr2 = this.f3936d;
            int i3 = this.f3938f;
            this.f3938f = i3 + 1;
            bArr2[i3] = (byte) i;
        }

        @Override
        public final void mo5827V(int i, int i2) {
            mo5826U((i << 3) | i2);
        }

        @Override
        public final void mo5849a(byte[] bArr, int i, int i2) throws b {
            m5848A0(bArr, i, i2);
        }

        @Override
        public final int mo5828b() {
            return this.f3937e - this.f3938f;
        }

        @Override
        public final void mo5829b0(int i, int i2) {
            mo5827V(i, 0);
            mo5826U(i2);
        }

        @Override
        public final void mo5830j(byte b) throws b {
            try {
                byte[] bArr = this.f3936d;
                int i = this.f3938f;
                this.f3938f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3938f), Integer.valueOf(this.f3937e), 1), e);
            }
        }

        @Override
        public final void mo5831k(int i) throws b {
            try {
                byte[] bArr = this.f3936d;
                int i2 = this.f3938f;
                int i3 = i2 + 1;
                this.f3938f = i3;
                bArr[i2] = (byte) i;
                int i4 = i2 + 2;
                this.f3938f = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i2 + 3;
                this.f3938f = i5;
                bArr[i4] = (byte) (i >> 16);
                this.f3938f = i2 + 4;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3938f), Integer.valueOf(this.f3937e), 1), e);
            }
        }

        @Override
        public final void mo5832l(int i, int i2) {
            mo5827V(i, 5);
            mo5831k(i2);
        }

        @Override
        public final void mo5833m(int i, long j) {
            mo5827V(i, 1);
            mo5841s(j);
        }

        @Override
        public final void mo5834n(int i, String str) {
            mo5827V(i, 2);
            mo5842t(str);
        }

        @Override
        public final void mo5835o(int i, AbstractC2233qB abstractC2233qB) {
            mo5827V(i, 2);
            mo5844v(abstractC2233qB);
        }

        @Override
        public final void mo5836p(int i, InterfaceC1912jE interfaceC1912jE) {
            mo5827V(1, 3);
            mo5829b0(2, i);
            mo5827V(3, 2);
            mo5845w(interfaceC1912jE);
            mo5827V(1, 4);
        }

        @Override
        public final void mo5837q(int i, InterfaceC1912jE interfaceC1912jE, InterfaceC1026WE interfaceC1026WE) {
            mo5827V(i, 2);
            mo5826U(((AbstractC1022WA) interfaceC1912jE).mo3511e(interfaceC1026WE));
            interfaceC1026WE.mo4480g(interfaceC1912jE, this.f3935a);
        }

        @Override
        public final void mo5839r(int i, boolean z) {
            mo5827V(i, 0);
            mo5830j(z ? (byte) 1 : (byte) 0);
        }

        @Override
        public final void mo5841s(long j) throws b {
            try {
                byte[] bArr = this.f3936d;
                int i = this.f3938f;
                int i2 = i + 1;
                this.f3938f = i2;
                bArr[i] = (byte) j;
                int i3 = i + 2;
                this.f3938f = i3;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i + 3;
                this.f3938f = i4;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i + 4;
                this.f3938f = i5;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i + 5;
                this.f3938f = i6;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i + 6;
                this.f3938f = i7;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i + 7;
                this.f3938f = i8;
                bArr[i7] = (byte) (j >> 48);
                this.f3938f = i + 8;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3938f), Integer.valueOf(this.f3937e), 1), e);
            }
        }

        @Override
        public final void mo5842t(String str) throws b {
            int i = this.f3938f;
            try {
                int iM5809v0 = AbstractC1355cC.m5809v0(str.length() * 3);
                int iM5809v02 = AbstractC1355cC.m5809v0(str.length());
                if (iM5809v02 != iM5809v0) {
                    mo5826U(AbstractC1073XF.m4710a(str));
                    this.f3938f = AbstractC1073XF.m4711b(str, this.f3936d, this.f3938f, mo5828b());
                    return;
                }
                int i2 = i + iM5809v02;
                this.f3938f = i2;
                int iM4711b = AbstractC1073XF.m4711b(str, this.f3936d, i2, mo5828b());
                this.f3938f = i;
                mo5826U((iM4711b - i) - iM5809v02);
                this.f3938f = iM4711b;
            } catch (C1727fG e) {
                this.f3938f = i;
                m5843u(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new b(e2);
            }
        }

        @Override
        public final void mo5844v(AbstractC2233qB abstractC2233qB) {
            mo5826U(abstractC2233qB.mo2843s());
            abstractC2233qB.mo2841q(this);
        }

        @Override
        public final void mo5845w(InterfaceC1912jE interfaceC1912jE) {
            mo5826U(interfaceC1912jE.mo3509c());
            interfaceC1912jE.mo3510d(this);
        }
    }

    public static class b extends IOException {
        public b(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        public b(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public AbstractC1355cC() {
    }

    public static int m5771A(String str) {
        int length;
        try {
            length = AbstractC1073XF.m4710a(str);
        } catch (C1727fG unused) {
            length = str.getBytes(AbstractC0932UC.f2839a).length;
        }
        return m5809v0(length) + length;
    }

    public static int m5772B(AbstractC2233qB abstractC2233qB) {
        int iMo2843s = abstractC2233qB.mo2843s();
        return m5809v0(iMo2843s) + iMo2843s;
    }

    public static int m5773C(InterfaceC1912jE interfaceC1912jE) {
        return interfaceC1912jE.mo3509c();
    }

    public static AbstractC1355cC m5774D(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int m5775P(int i, long j) {
        return m5809v0(i << 3) + 8;
    }

    public static int m5776Q(int i, AbstractC2233qB abstractC2233qB) {
        int iM5809v0 = m5809v0(i << 3);
        int iMo2843s = abstractC2233qB.mo2843s();
        return iM5809v0 + m5809v0(iMo2843s) + iMo2843s;
    }

    public static int m5777R(int i, InterfaceC1912jE interfaceC1912jE, InterfaceC1026WE interfaceC1026WE) {
        return m5809v0(i << 3) + m5793g(interfaceC1912jE, interfaceC1026WE);
    }

    public static int m5778S(long j) {
        return 8;
    }

    public static int m5779T(InterfaceC1912jE interfaceC1912jE) {
        int iMo3509c = interfaceC1912jE.mo3509c();
        return m5809v0(iMo3509c) + iMo3509c;
    }

    public static int m5781X(int i) {
        return m5803n0(i);
    }

    public static int m5782Y(int i, long j) {
        return m5809v0(i << 3) + m5803n0(j);
    }

    public static int m5783Z(int i, AbstractC2233qB abstractC2233qB) {
        return (m5809v0(8) << 1) + m5810w0(2, i) + m5776Q(3, abstractC2233qB);
    }

    public static int m5784a0(long j) {
        return m5803n0(j);
    }

    public static int m5785c(double d) {
        return 8;
    }

    public static int m5786c0(int i) {
        return 4;
    }

    public static int m5787d(float f) {
        return 4;
    }

    public static int m5788d0(int i, int i2) {
        return m5809v0(i << 3) + m5803n0(i2);
    }

    public static int m5789e(int i, double d) {
        return m5809v0(i << 3) + 8;
    }

    public static int m5790e0(int i, long j) {
        return m5809v0(i << 3) + 8;
    }

    public static int m5791f(int i, float f) {
        return m5809v0(i << 3) + 4;
    }

    public static int m5792f0(long j) {
        return 8;
    }

    public static int m5793g(InterfaceC1912jE interfaceC1912jE, InterfaceC1026WE interfaceC1026WE) {
        int iMo3511e = ((AbstractC1022WA) interfaceC1912jE).mo3511e(interfaceC1026WE);
        return m5809v0(iMo3511e) + iMo3511e;
    }

    public static int m5794g0(int i) {
        return m5803n0(i);
    }

    public static int m5795h(boolean z) {
        return 1;
    }

    public static int m5796h0(int i, int i2) {
        return m5809v0(i << 3) + 4;
    }

    public static int m5797i(byte[] bArr) {
        int length = bArr.length;
        return m5809v0(length) + length;
    }

    public static int m5798i0(int i, long j) {
        return m5809v0(i << 3) + m5803n0(m5808u0(j));
    }

    public static int m5799j0(long j) {
        return m5803n0(m5808u0(j));
    }

    public static int m5800k0(int i) {
        return 4;
    }

    public static int m5801l0(int i, int i2) {
        return m5809v0(i << 3) + m5803n0(i2);
    }

    public static int m5802m0(int i, long j) {
        return m5809v0(i << 3) + m5803n0(j);
    }

    public static int m5803n0(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int m5804o0(int i) {
        return m5809v0(m5814z0(i));
    }

    public static int m5805p0(int i, int i2) {
        return m5809v0(i << 3) + 4;
    }

    public static int m5806s0(int i) {
        return m5809v0(i << 3);
    }

    public static int m5807t0(int i, int i2) {
        return m5809v0(i << 3) + m5809v0(m5814z0(i2));
    }

    public static long m5808u0(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int m5809v0(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int m5810w0(int i, int i2) {
        return m5809v0(i << 3) + m5809v0(i2);
    }

    public static int m5811x(int i, String str) {
        return m5809v0(i << 3) + m5771A(str);
    }

    public static int m5812y(int i, InterfaceC1912jE interfaceC1912jE, InterfaceC1026WE interfaceC1026WE) {
        return (m5809v0(i << 3) << 1) + ((AbstractC1022WA) interfaceC1912jE).mo3511e(interfaceC1026WE);
    }

    public static int m5813z(int i, boolean z) {
        return m5809v0(i << 3) + 1;
    }

    public static int m5814z0(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public final void m5815E() {
        if (mo5828b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void m5816F(double d) {
        mo5841s(Double.doubleToRawLongBits(d));
    }

    public final void m5817G(float f) {
        mo5831k(Float.floatToRawIntBits(f));
    }

    public abstract void mo5818H(int i);

    public final void m5819I(int i, double d) {
        mo5833m(i, Double.doubleToRawLongBits(d));
    }

    public final void m5820J(int i, float f) {
        mo5832l(i, Float.floatToRawIntBits(f));
    }

    public abstract void mo5821K(int i, int i2);

    public abstract void mo5822L(int i, long j);

    public abstract void mo5823M(int i, AbstractC2233qB abstractC2233qB);

    public abstract void mo5824N(long j);

    public final void m5825O(boolean z) {
        mo5830j(z ? (byte) 1 : (byte) 0);
    }

    public abstract void mo5826U(int i);

    public abstract void mo5827V(int i, int i2);

    public abstract int mo5828b();

    public abstract void mo5829b0(int i, int i2);

    public abstract void mo5830j(byte b2);

    public abstract void mo5831k(int i);

    public abstract void mo5832l(int i, int i2);

    public abstract void mo5833m(int i, long j);

    public abstract void mo5834n(int i, String str);

    public abstract void mo5835o(int i, AbstractC2233qB abstractC2233qB);

    public abstract void mo5836p(int i, InterfaceC1912jE interfaceC1912jE);

    public abstract void mo5837q(int i, InterfaceC1912jE interfaceC1912jE, InterfaceC1026WE interfaceC1026WE);

    public final void m5838q0(int i, long j) {
        mo5822L(i, m5808u0(j));
    }

    public abstract void mo5839r(int i, boolean z);

    public final void m5840r0(long j) {
        mo5824N(m5808u0(j));
    }

    public abstract void mo5841s(long j);

    public abstract void mo5842t(String str);

    public final void m5843u(String str, C1727fG c1727fG) throws b {
        f3933b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) c1727fG);
        byte[] bytes = str.getBytes(AbstractC0932UC.f2839a);
        try {
            mo5826U(bytes.length);
            mo5849a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new b(e);
        }
    }

    public abstract void mo5844v(AbstractC2233qB abstractC2233qB);

    public abstract void mo5845w(InterfaceC1912jE interfaceC1912jE);

    public final void m5846x0(int i) {
        mo5826U(m5814z0(i));
    }

    public final void m5847y0(int i, int i2) {
        mo5829b0(i, m5814z0(i2));
    }
}
