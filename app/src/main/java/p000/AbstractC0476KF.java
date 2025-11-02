package p000;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class AbstractC0476KF {

    public static final Unsafe f1556a;

    public static final Class f1557b;

    public static final boolean f1558c;

    public static final boolean f1559d;

    public static final b f1560e;

    public static final boolean f1561f;

    public static final boolean f1562g;

    public static final long f1563h;

    public static final boolean f1564i;

    public static final class a extends b {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override
        public final double mo2351a(Object obj, long j) {
            return Double.longBitsToDouble(m2363m(obj, j));
        }

        @Override
        public final void mo2352b(Object obj, long j, byte b) {
            if (AbstractC0476KF.f1564i) {
                AbstractC0476KF.m2345u(obj, j, b);
            } else {
                AbstractC0476KF.m2349y(obj, j, b);
            }
        }

        @Override
        public final void mo2353c(Object obj, long j, double d) {
            m2359f(obj, j, Double.doubleToLongBits(d));
        }

        @Override
        public final void mo2354d(Object obj, long j, float f) {
            m2358e(obj, j, Float.floatToIntBits(f));
        }

        @Override
        public final void mo2355g(Object obj, long j, boolean z) {
            if (AbstractC0476KF.f1564i) {
                AbstractC0476KF.m2335k(obj, j, z);
            } else {
                AbstractC0476KF.m2342r(obj, j, z);
            }
        }

        @Override
        public final float mo2356i(Object obj, long j) {
            return Float.intBitsToFloat(m2362l(obj, j));
        }

        @Override
        public final boolean mo2357k(Object obj, long j) {
            return AbstractC0476KF.f1564i ? AbstractC0476KF.m2322D(obj, j) : AbstractC0476KF.m2323E(obj, j);
        }
    }

    public static abstract class b {

        public Unsafe f1565a;

        public b(Unsafe unsafe) {
            this.f1565a = unsafe;
        }

        public abstract double mo2351a(Object obj, long j);

        public abstract void mo2352b(Object obj, long j, byte b);

        public abstract void mo2353c(Object obj, long j, double d);

        public abstract void mo2354d(Object obj, long j, float f);

        public final void m2358e(Object obj, long j, int i) {
            this.f1565a.putInt(obj, j, i);
        }

        public final void m2359f(Object obj, long j, long j2) {
            this.f1565a.putLong(obj, j, j2);
        }

        public abstract void mo2355g(Object obj, long j, boolean z);

        public final boolean m2360h() {
            Unsafe unsafe = this.f1565a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                AbstractC0476KF.m2336l(th);
                return false;
            }
        }

        public abstract float mo2356i(Object obj, long j);

        public final boolean m2361j() {
            Unsafe unsafe = this.f1565a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return AbstractC0476KF.m2321C() != null;
            } catch (Throwable th) {
                AbstractC0476KF.m2336l(th);
                return false;
            }
        }

        public abstract boolean mo2357k(Object obj, long j);

        public final int m2362l(Object obj, long j) {
            return this.f1565a.getInt(obj, j);
        }

        public final long m2363m(Object obj, long j) {
            return this.f1565a.getLong(obj, j);
        }
    }

    public static final class c extends b {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override
        public final double mo2351a(Object obj, long j) {
            return Double.longBitsToDouble(m2363m(obj, j));
        }

        @Override
        public final void mo2352b(Object obj, long j, byte b) {
            if (AbstractC0476KF.f1564i) {
                AbstractC0476KF.m2345u(obj, j, b);
            } else {
                AbstractC0476KF.m2349y(obj, j, b);
            }
        }

        @Override
        public final void mo2353c(Object obj, long j, double d) {
            m2359f(obj, j, Double.doubleToLongBits(d));
        }

        @Override
        public final void mo2354d(Object obj, long j, float f) {
            m2358e(obj, j, Float.floatToIntBits(f));
        }

        @Override
        public final void mo2355g(Object obj, long j, boolean z) {
            if (AbstractC0476KF.f1564i) {
                AbstractC0476KF.m2335k(obj, j, z);
            } else {
                AbstractC0476KF.m2342r(obj, j, z);
            }
        }

        @Override
        public final float mo2356i(Object obj, long j) {
            return Float.intBitsToFloat(m2362l(obj, j));
        }

        @Override
        public final boolean mo2357k(Object obj, long j) {
            return AbstractC0476KF.f1564i ? AbstractC0476KF.m2322D(obj, j) : AbstractC0476KF.m2323E(obj, j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    static {
        /*
            sun.misc.Unsafe r0 = m2340p()
            p000.AbstractC0476KF.f1556a = r0
            java.lang.Class r1 = p000.AbstractC1354cB.m5770a()
            p000.AbstractC0476KF.f1557b = r1
            java.lang.Class r1 = java.lang.Long.TYPE
            boolean r1 = m2319A(r1)
            p000.AbstractC0476KF.f1558c = r1
            java.lang.Class r2 = java.lang.Integer.TYPE
            boolean r2 = m2319A(r2)
            p000.AbstractC0476KF.f1559d = r2
            if (r0 == 0) goto L2e
            if (r1 == 0) goto L26
            KF$c r1 = new KF$c
            r1.<init>(r0)
            goto L2f
        L26:
            if (r2 == 0) goto L2e
            KF$a r1 = new KF$a
            r1.<init>(r0)
            goto L2f
        L2e:
            r1 = 0
        L2f:
            p000.AbstractC0476KF.f1560e = r1
            r0 = 0
            if (r1 != 0) goto L36
            r2 = r0
            goto L3a
        L36:
            boolean r2 = r1.m2361j()
        L3a:
            p000.AbstractC0476KF.f1561f = r2
            if (r1 != 0) goto L40
            r2 = r0
            goto L44
        L40:
            boolean r2 = r1.m2360h()
        L44:
            p000.AbstractC0476KF.f1562g = r2
            java.lang.Class<byte[]> r2 = byte[].class
            int r2 = m2339o(r2)
            long r2 = (long) r2
            p000.AbstractC0476KF.f1563h = r2
            java.lang.Class<boolean[]> r2 = boolean[].class
            m2339o(r2)
            m2343s(r2)
            java.lang.Class<int[]> r2 = int[].class
            m2339o(r2)
            m2343s(r2)
            java.lang.Class<long[]> r2 = long[].class
            m2339o(r2)
            m2343s(r2)
            java.lang.Class<float[]> r2 = float[].class
            m2339o(r2)
            m2343s(r2)
            java.lang.Class<double[]> r2 = double[].class
            m2339o(r2)
            m2343s(r2)
            java.lang.Class<java.lang.Object[]> r2 = java.lang.Object[].class
            m2339o(r2)
            m2343s(r2)
            java.lang.reflect.Field r2 = m2321C()
            if (r2 == 0) goto L8d
            if (r1 != 0) goto L88
            goto L8d
        L88:
            sun.misc.Unsafe r1 = r1.f1565a
            r1.objectFieldOffset(r2)
        L8d:
            java.nio.ByteOrder r1 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN
            if (r1 != r2) goto L96
            r0 = 1
        L96:
            p000.AbstractC0476KF.f1564i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0476KF.<clinit>():void");
    }

    public static boolean m2319A(Class cls) {
        try {
            Class cls2 = f1557b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Object m2320B(Object obj, long j) {
        return f1560e.f1565a.getObject(obj, j);
    }

    public static Field m2321C() {
        Field fieldM2328d = m2328d(Buffer.class, "effectiveDirectAddress");
        if (fieldM2328d != null) {
            return fieldM2328d;
        }
        Field fieldM2328d2 = m2328d(Buffer.class, "address");
        if (fieldM2328d2 == null || fieldM2328d2.getType() != Long.TYPE) {
            return null;
        }
        return fieldM2328d2;
    }

    public static boolean m2322D(Object obj, long j) {
        return ((byte) (m2344t(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)))) != 0;
    }

    public static boolean m2323E(Object obj, long j) {
        return ((byte) (m2344t(obj, (-4) & j) >>> ((int) ((j & 3) << 3)))) != 0;
    }

    public static boolean m2324F(Object obj, long j) {
        return f1560e.mo2357k(obj, j);
    }

    public static double m2325a(Object obj, long j) {
        return f1560e.mo2351a(obj, j);
    }

    public static Object m2326b(Class cls) {
        try {
            return f1556a.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Field m2328d(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m2330f(Object obj, long j, double d) {
        f1560e.mo2353c(obj, j, d);
    }

    public static void m2331g(Object obj, long j, float f) {
        f1560e.mo2354d(obj, j, f);
    }

    public static void m2332h(Object obj, long j, int i) {
        f1560e.m2358e(obj, j, i);
    }

    public static void m2333i(Object obj, long j, long j2) {
        f1560e.m2359f(obj, j, j2);
    }

    public static void m2334j(Object obj, long j, Object obj2) {
        f1560e.f1565a.putObject(obj, j, obj2);
    }

    public static void m2335k(Object obj, long j, boolean z) {
        m2345u(obj, j, z ? (byte) 1 : (byte) 0);
    }

    public static void m2336l(Throwable th) {
        Logger.getLogger(AbstractC0476KF.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + String.valueOf(th));
    }

    public static void m2337m(byte[] bArr, long j, byte b2) {
        f1560e.mo2352b(bArr, f1563h + j, b2);
    }

    public static float m2338n(Object obj, long j) {
        return f1560e.mo2356i(obj, j);
    }

    public static int m2339o(Class cls) {
        if (f1562g) {
            return f1560e.f1565a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static Unsafe m2340p() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C0889TF());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m2342r(Object obj, long j, boolean z) {
        m2349y(obj, j, z ? (byte) 1 : (byte) 0);
    }

    public static int m2343s(Class cls) {
        if (f1562g) {
            return f1560e.f1565a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static int m2344t(Object obj, long j) {
        return f1560e.m2362l(obj, j);
    }

    public static void m2345u(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int iM2344t = m2344t(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        m2332h(obj, j2, ((255 & b2) << i) | (iM2344t & (~(255 << i))));
    }

    public static void m2346v(Object obj, long j, boolean z) {
        f1560e.mo2355g(obj, j, z);
    }

    public static boolean m2347w() {
        return f1562g;
    }

    public static long m2348x(Object obj, long j) {
        return f1560e.m2363m(obj, j);
    }

    public static void m2349y(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        m2332h(obj, j2, ((255 & b2) << i) | (m2344t(obj, j2) & (~(255 << i))));
    }

    public static boolean m2350z() {
        return f1561f;
    }
}
