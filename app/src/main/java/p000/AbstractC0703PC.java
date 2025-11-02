package p000;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractC0703PC extends AbstractC1022WA {
    private static Map<Class<?>, AbstractC0703PC> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected C0338HF zzb = C0338HF.m1543k();

    public static class a extends AbstractC1114YA {
        public a(AbstractC0703PC abstractC0703PC) {
        }
    }

    public static abstract class b extends AbstractC0930UA {

        public final AbstractC0703PC f2098l;

        public AbstractC0703PC f2099m;

        public b(AbstractC0703PC abstractC0703PC) {
            this.f2098l = abstractC0703PC;
            if (abstractC0703PC.m3506F()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f2099m = abstractC0703PC.m3518z();
        }

        public static void m3519j(Object obj, Object obj2) {
            C0429JE.m1871a().m1873c(obj).mo4476c(obj, obj2);
        }

        @Override
        public Object clone() {
            b bVar = (b) this.f2098l.mo567m(c.f2104e, null, null);
            bVar.f2099m = (AbstractC0703PC) mo3523k();
            return bVar;
        }

        @Override
        public final AbstractC0930UA mo3520e(byte[] bArr, int i, int i2) {
            return m3529s(bArr, 0, i2, C1957kC.f5977c);
        }

        @Override
        public final AbstractC0930UA mo3521f(byte[] bArr, int i, int i2, C1957kC c1957kC) {
            return m3529s(bArr, 0, i2, c1957kC);
        }

        public final b m3522h(AbstractC0703PC abstractC0703PC) {
            if (this.f2098l.equals(abstractC0703PC)) {
                return this;
            }
            if (!this.f2099m.m3506F()) {
                m3528r();
            }
            m3519j(this.f2099m, abstractC0703PC);
            return this;
        }

        public final AbstractC0703PC m3526o() {
            AbstractC0703PC abstractC0703PC = (AbstractC0703PC) mo3523k();
            if (AbstractC0703PC.m3503v(abstractC0703PC, true)) {
                return abstractC0703PC;
            }
            throw new C0154DF(abstractC0703PC);
        }

        @Override
        public AbstractC0703PC mo3523k() {
            if (!this.f2099m.m3506F()) {
                return this.f2099m;
            }
            this.f2099m.m3504D();
            return this.f2099m;
        }

        public final void m3527q() {
            if (this.f2099m.m3506F()) {
                return;
            }
            m3528r();
        }

        public void m3528r() {
            AbstractC0703PC abstractC0703PCM3518z = this.f2098l.m3518z();
            m3519j(abstractC0703PCM3518z, this.f2099m);
            this.f2099m = abstractC0703PCM3518z;
        }

        public final b m3529s(byte[] bArr, int i, int i2, C1957kC c1957kC) throws C1771gD {
            if (!this.f2099m.m3506F()) {
                m3528r();
            }
            try {
                C0429JE.m1871a().m1873c(this.f2099m).mo4481h(this.f2099m, bArr, 0, i2, new C1769gB(c1957kC));
                return this;
            } catch (C1771gD e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw C1771gD.m7708g();
            }
        }
    }

    public enum c {

        public static final int f2100a = 1;

        public static final int f2101b = 2;

        public static final int f2102c = 3;

        public static final int f2103d = 4;

        public static final int f2104e = 5;

        public static final int f2105f = 6;

        public static final int f2106g = 7;

        public static final int[] f2107h = {1, 2, 3, 4, 5, 6, 7};

        public static int[] m3530a() {
            return (int[]) f2107h.clone();
        }
    }

    public static class d extends AbstractC2095nC {
    }

    public static InterfaceC1677eD m3493A() {
        return C1024WC.m4468g();
    }

    public static InterfaceC1356cD m3494B() {
        return C2649zD.m10994h();
    }

    public static InterfaceC1865iD m3495C() {
        return C0337HE.m1537h();
    }

    private final int m3496j() {
        return C0429JE.m1871a().m1873c(this).mo4478e(this);
    }

    public static Object m3497n(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object m3498o(InterfaceC1912jE interfaceC1912jE, String str, Object[] objArr) {
        return new C0842SE(interfaceC1912jE, str, objArr);
    }

    public static AbstractC0703PC m3499r(Class cls) throws ClassNotFoundException {
        AbstractC0703PC abstractC0703PC = zzc.get(cls);
        if (abstractC0703PC == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0703PC = zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC0703PC == null) {
            abstractC0703PC = (AbstractC0703PC) ((AbstractC0703PC) AbstractC0476KF.m2326b(cls)).mo567m(c.f2105f, null, null);
            if (abstractC0703PC == null) {
                throw new IllegalStateException();
            }
            zzc.put(cls, abstractC0703PC);
        }
        return abstractC0703PC;
    }

    public static InterfaceC1356cD m3500s(InterfaceC1356cD interfaceC1356cD) {
        int size = interfaceC1356cD.size();
        return interfaceC1356cD.mo1538e(size == 0 ? 10 : size << 1);
    }

    public static InterfaceC1865iD m3501t(InterfaceC1865iD interfaceC1865iD) {
        int size = interfaceC1865iD.size();
        return interfaceC1865iD.mo1538e(size == 0 ? 10 : size << 1);
    }

    public static void m3502u(Class cls, AbstractC0703PC abstractC0703PC) {
        abstractC0703PC.m3505E();
        zzc.put(cls, abstractC0703PC);
    }

    public static final boolean m3503v(AbstractC0703PC abstractC0703PC, boolean z) {
        byte bByteValue = ((Byte) abstractC0703PC.mo567m(c.f2100a, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zMo4477d = C0429JE.m1871a().m1873c(abstractC0703PC).mo4477d(abstractC0703PC);
        if (z) {
            abstractC0703PC.mo567m(c.f2101b, zMo4477d ? abstractC0703PC : null, null);
        }
        return zMo4477d;
    }

    public final void m3504D() {
        C0429JE.m1871a().m1873c(this).mo4479f(this);
        m3505E();
    }

    public final void m3505E() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final boolean m3506F() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override
    public final InterfaceC1819hE mo3507a() {
        return (b) mo567m(c.f2104e, null, null);
    }

    @Override
    public final InterfaceC1912jE mo3508b() {
        return (AbstractC0703PC) mo567m(c.f2105f, null, null);
    }

    @Override
    public final int mo3509c() {
        return mo3511e(null);
    }

    @Override
    public final void mo3510d(AbstractC1355cC abstractC1355cC) {
        C0429JE.m1871a().m1873c(this).mo4480g(this, C1910jC.m8124P(abstractC1355cC));
    }

    @Override
    public final int mo3511e(InterfaceC1026WE interfaceC1026WE) {
        if (!m3506F()) {
            if (mo3512g() != Integer.MAX_VALUE) {
                return mo3512g();
            }
            int iM3515w = m3515w(interfaceC1026WE);
            mo3513h(iM3515w);
            return iM3515w;
        }
        int iM3515w2 = m3515w(interfaceC1026WE);
        if (iM3515w2 >= 0) {
            return iM3515w2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iM3515w2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return C0429JE.m1871a().m1873c(this).mo4482i(this, (AbstractC0703PC) obj);
        }
        return false;
    }

    @Override
    public final int mo3512g() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override
    public final void mo3513h(int i) {
        if (i >= 0) {
            this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
    }

    public int hashCode() {
        if (m3506F()) {
            return m3496j();
        }
        if (this.zza == 0) {
            this.zza = m3496j();
        }
        return this.zza;
    }

    public abstract Object mo567m(int i, Object obj, Object obj2);

    public final b m3514q(AbstractC0703PC abstractC0703PC) {
        return m3516x().m3522h(abstractC0703PC);
    }

    public String toString() {
        return AbstractC2005lE.m8375a(this, super.toString());
    }

    public final int m3515w(InterfaceC1026WE interfaceC1026WE) {
        return interfaceC1026WE == null ? C0429JE.m1871a().m1873c(this).mo4475b(this) : interfaceC1026WE.mo4475b(this);
    }

    public final b m3516x() {
        return (b) mo567m(c.f2104e, null, null);
    }

    public final b m3517y() {
        return ((b) mo567m(c.f2104e, null, null)).m3522h(this);
    }

    public final AbstractC0703PC m3518z() {
        return (AbstractC0703PC) mo567m(c.f2103d, null, null);
    }
}
