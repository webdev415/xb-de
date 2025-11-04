package p000;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import sun.misc.Unsafe;

public final class C2236qE implements InterfaceC1026WE {

    public static final int[] f6694q = new int[0];

    public static final Unsafe f6695r = AbstractC0476KF.m2340p();

    public final int[] f6696a;

    public final Object[] f6697b;

    public final int f6698c;

    public final int f6699d;

    public final InterfaceC1912jE f6700e;

    public final boolean f6701f;

    public final boolean f6702g;

    public final boolean f6703h;

    public final int[] f6704i;

    public final int f6705j;

    public final int f6706k;

    public final InterfaceC2558xE f6707l;

    public final InterfaceC2557xD f6708m;

    public final AbstractC0430JF f6709n;

    public final AbstractC2188pC f6710o;

    public final InterfaceC0979VD f6711p;

    public C2236qE(int[] iArr, Object[] objArr, int i, int i2, InterfaceC1912jE interfaceC1912jE, boolean z, int[] iArr2, int i3, int i4, InterfaceC2558xE interfaceC2558xE, InterfaceC2557xD interfaceC2557xD, AbstractC0430JF abstractC0430JF, AbstractC2188pC abstractC2188pC, InterfaceC0979VD interfaceC0979VD) {
        this.f6696a = iArr;
        this.f6697b = objArr;
        this.f6698c = i;
        this.f6699d = i2;
        this.f6702g = interfaceC1912jE instanceof AbstractC0703PC;
        this.f6701f = abstractC2188pC != null && abstractC2188pC.mo9046d(interfaceC1912jE);
        this.f6703h = false;
        this.f6704i = iArr2;
        this.f6705j = i3;
        this.f6706k = i4;
        this.f6707l = interfaceC2558xE;
        this.f6708m = interfaceC2557xD;
        this.f6709n = abstractC0430JF;
        this.f6710o = abstractC2188pC;
        this.f6700e = interfaceC1912jE;
        this.f6711p = interfaceC0979VD;
    }

    public static boolean m9111A(Object obj, int i, InterfaceC1026WE interfaceC1026WE) {
        return interfaceC1026WE.mo4477d(AbstractC0476KF.m2320B(obj, i & 1048575));
    }

    public static float m9112B(Object obj, long j) {
        return ((Float) AbstractC0476KF.m2320B(obj, j)).floatValue();
    }

    public static int m9113H(Object obj, long j) {
        return ((Integer) AbstractC0476KF.m2320B(obj, j)).intValue();
    }

    public static C0338HF m9114I(Object obj) {
        AbstractC0703PC abstractC0703PC = (AbstractC0703PC) obj;
        C0338HF c0338hf = abstractC0703PC.zzb;
        if (c0338hf != C0338HF.m1543k()) {
            return c0338hf;
        }
        C0338HF c0338hfM1544l = C0338HF.m1544l();
        abstractC0703PC.zzb = c0338hfM1544l;
        return c0338hfM1544l;
    }

    public static long m9115M(Object obj, long j) {
        return ((Long) AbstractC0476KF.m2320B(obj, j)).longValue();
    }

    public static boolean m9116P(Object obj, long j) {
        return ((Boolean) AbstractC0476KF.m2320B(obj, j)).booleanValue();
    }

    public static void m9117R(Object obj) {
        if (m9119T(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    public static boolean m9118S(int i) {
        return (i & 536870912) != 0;
    }

    public static boolean m9119T(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractC0703PC) {
            return ((AbstractC0703PC) obj).m3506F();
        }
        return true;
    }

    public static double m9120j(Object obj, long j) {
        return ((Double) AbstractC0476KF.m2320B(obj, j)).doubleValue();
    }

    public static Field m9121r(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x038c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static C2236qE m9122s(Class r32, InterfaceC1725fE r33, InterfaceC2558xE r34, InterfaceC2557xD r35, AbstractC0430JF r36, AbstractC2188pC r37, InterfaceC0979VD r38) {
        /*
            Method dump skipped, instructions count: 1043
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2236qE.m9122s(java.lang.Class, fE, xE, xD, JF, pC, VD):qE");
    }

    public static void m9123t(int i, Object obj, InterfaceC0017AG interfaceC0017AG) {
        if (obj instanceof String) {
            interfaceC0017AG.mo111z(i, (String) obj);
        } else {
            interfaceC0017AG.mo80J(i, (AbstractC2233qB) obj);
        }
    }

    public static void m9124x(AbstractC0430JF abstractC0430JF, Object obj, InterfaceC0017AG interfaceC0017AG) {
        abstractC0430JF.mo1881h(abstractC0430JF.mo1884k(obj), interfaceC0017AG);
    }

    public final int m9125C(int i) {
        return this.f6696a[i + 2];
    }

    public final void m9126D(Object obj, int i) {
        int iM9125C = m9125C(i);
        long j = 1048575 & iM9125C;
        if (j == 1048575) {
            return;
        }
        AbstractC0476KF.m2332h(obj, j, (1 << (iM9125C >>> 20)) | AbstractC0476KF.m2344t(obj, j));
    }

    public final void m9127E(Object obj, int i, int i2) {
        AbstractC0476KF.m2332h(obj, m9125C(i2) & 1048575, i);
    }

    public final void m9128F(Object obj, Object obj2, int i) {
        int i2 = this.f6696a[i];
        if (m9131K(obj2, i2, i)) {
            long jM9129G = m9129G(i) & 1048575;
            Unsafe unsafe = f6695r;
            Object object = unsafe.getObject(obj2, jM9129G);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f6696a[i] + " is present but null: " + String.valueOf(obj2));
            }
            InterfaceC1026WE interfaceC1026WEM9134O = m9134O(i);
            if (!m9131K(obj, i2, i)) {
                if (m9119T(object)) {
                    Object objMo4474a = interfaceC1026WEM9134O.mo4474a();
                    interfaceC1026WEM9134O.mo4476c(objMo4474a, object);
                    unsafe.putObject(obj, jM9129G, objMo4474a);
                } else {
                    unsafe.putObject(obj, jM9129G, object);
                }
                m9127E(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jM9129G);
            if (!m9119T(object2)) {
                Object objMo4474a2 = interfaceC1026WEM9134O.mo4474a();
                interfaceC1026WEM9134O.mo4476c(objMo4474a2, object2);
                unsafe.putObject(obj, jM9129G, objMo4474a2);
                object2 = objMo4474a2;
            }
            interfaceC1026WEM9134O.mo4476c(object2, object);
        }
    }

    public final int m9129G(int i) {
        return this.f6696a[i + 1];
    }

    public final boolean m9130J(Object obj, int i) {
        int iM9125C = m9125C(i);
        long j = iM9125C & 1048575;
        if (j != 1048575) {
            return (AbstractC0476KF.m2344t(obj, j) & (1 << (iM9125C >>> 20))) != 0;
        }
        int iM9129G = m9129G(i);
        long j2 = iM9129G & 1048575;
        switch ((iM9129G & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(AbstractC0476KF.m2325a(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(AbstractC0476KF.m2338n(obj, j2)) != 0;
            case 2:
                return AbstractC0476KF.m2348x(obj, j2) != 0;
            case 3:
                return AbstractC0476KF.m2348x(obj, j2) != 0;
            case 4:
                return AbstractC0476KF.m2344t(obj, j2) != 0;
            case 5:
                return AbstractC0476KF.m2348x(obj, j2) != 0;
            case 6:
                return AbstractC0476KF.m2344t(obj, j2) != 0;
            case 7:
                return AbstractC0476KF.m2324F(obj, j2);
            case 8:
                Object objM2320B = AbstractC0476KF.m2320B(obj, j2);
                if (objM2320B instanceof String) {
                    return !((String) objM2320B).isEmpty();
                }
                if (objM2320B instanceof AbstractC2233qB) {
                    return !AbstractC2233qB.f6688m.equals(objM2320B);
                }
                throw new IllegalArgumentException();
            case 9:
                return AbstractC0476KF.m2320B(obj, j2) != null;
            case 10:
                return !AbstractC2233qB.f6688m.equals(AbstractC0476KF.m2320B(obj, j2));
            case 11:
                return AbstractC0476KF.m2344t(obj, j2) != 0;
            case 12:
                return AbstractC0476KF.m2344t(obj, j2) != 0;
            case 13:
                return AbstractC0476KF.m2344t(obj, j2) != 0;
            case 14:
                return AbstractC0476KF.m2348x(obj, j2) != 0;
            case 15:
                return AbstractC0476KF.m2344t(obj, j2) != 0;
            case 16:
                return AbstractC0476KF.m2348x(obj, j2) != 0;
            case 17:
                return AbstractC0476KF.m2320B(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean m9131K(Object obj, int i, int i2) {
        return AbstractC0476KF.m2344t(obj, (long) (m9125C(i2) & 1048575)) == i;
    }

    public final boolean m9132L(Object obj, Object obj2, int i) {
        return m9130J(obj, i) == m9130J(obj2, i);
    }

    public final InterfaceC1116YC m9133N(int i) {
        return (InterfaceC1116YC) this.f6697b[((i / 3) << 1) + 1];
    }

    public final InterfaceC1026WE m9134O(int i) {
        int i2 = (i / 3) << 1;
        InterfaceC1026WE interfaceC1026WE = (InterfaceC1026WE) this.f6697b[i2];
        if (interfaceC1026WE != null) {
            return interfaceC1026WE;
        }
        InterfaceC1026WE interfaceC1026WEM1872b = C0429JE.m1871a().m1872b((Class) this.f6697b[i2 + 1]);
        this.f6697b[i2] = interfaceC1026WEM1872b;
        return interfaceC1026WEM1872b;
    }

    public final Object m9135Q(int i) {
        return this.f6697b[(i / 3) << 1];
    }

    @Override
    public final Object mo4474a() {
        return this.f6707l.mo10331b(this.f6700e);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01da, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01e7, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01f4, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0201, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x020e, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x021b, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0229, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0237, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0245, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0253, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0356, code lost:
    
        if (m9147z(r18, r11, r14, r16, r5) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0366, code lost:
    
        if (m9147z(r18, r11, r14, r16, r5) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x03e3, code lost:
    
        if (m9147z(r18, r11, r14, r16, r5) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
    
        if (m9131K(r18, r13, r11) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0098, code lost:
    
        r0 = p000.AbstractC1355cC.m5790e0(r13, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
    
        if (m9131K(r18, r13, r11) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a3, code lost:
    
        r1 = p000.AbstractC1355cC.m5805p0(r13, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0107, code lost:
    
        if (m9131K(r18, r13, r11) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0109, code lost:
    
        r0 = p000.AbstractC1355cC.m5813z(r13, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x019b, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x019d, code lost:
    
        r1 = (p000.AbstractC1355cC.m5806s0(r13) + p000.AbstractC1355cC.m5809v0(r0)) + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01b3, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c0, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01cd, code lost:
    
        if (r0 > 0) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2 A[PHI: r0
  0x00d2: PHI (r0v190 java.lang.Object) = (r0v43 java.lang.Object), (r0v49 java.lang.Object), (r0v185 java.lang.Object), (r0v194 java.lang.Object) binds: [B:176:0x03d3, B:169:0x03a3, B:60:0x00f8, B:51:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb A[PHI: r0
  0x00fb: PHI (r0v181 java.lang.Object) = (r0v43 java.lang.Object), (r0v185 java.lang.Object) binds: [B:176:0x03d3, B:60:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int mo4475b(Object r18) {
        /*
            Method dump skipped, instructions count: 1410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2236qE.mo4475b(java.lang.Object):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo4476c(Object r7, Object r8) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2236qE.mo4476c(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo4477d(Object r18) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2236qE.mo4477d(java.lang.Object):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f4 A[PHI: r3
  0x00f4: PHI (r3v9 java.lang.Object) = (r3v6 java.lang.Object), (r3v10 java.lang.Object) binds: [B:74:0x0110, B:68:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int mo4478e(Object r9) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2236qE.mo4478e(java.lang.Object):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:200)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo4479f(Object r8) {
        /*
            r7 = this;
            boolean r0 = m9119T(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof p000.AbstractC0703PC
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            PC r0 = (p000.AbstractC0703PC) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.mo3513h(r2)
            r0.zza = r1
            r0.m3505E()
        L1a:
            int[] r0 = r7.f6696a
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L77
            int r2 = r7.m9129G(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            long r3 = (long) r3
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r2 = r2 & r5
            int r2 = r2 >>> 20
            r5 = 9
            if (r2 == r5) goto L6d
            r5 = 60
            if (r2 == r5) goto L55
            r5 = 68
            if (r2 == r5) goto L55
            switch(r2) {
                case 17: goto L6d;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L74
        L3d:
            sun.misc.Unsafe r2 = p000.C2236qE.f6695r
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L74
            VD r6 = r7.f6711p
            java.lang.Object r5 = r6.mo4373h(r5)
            r2.putObject(r8, r3, r5)
            goto L74
        L4f:
            xD r2 = r7.f6708m
            r2.mo10330b(r8, r3)
            goto L74
        L55:
            int[] r2 = r7.f6696a
            r2 = r2[r1]
            boolean r2 = r7.m9131K(r8, r2, r1)
            if (r2 == 0) goto L74
        L5f:
            WE r2 = r7.m9134O(r1)
            sun.misc.Unsafe r5 = p000.C2236qE.f6695r
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.mo4479f(r3)
            goto L74
        L6d:
            boolean r2 = r7.m9130J(r8, r1)
            if (r2 == 0) goto L74
            goto L5f
        L74:
            int r1 = r1 + 3
            goto L1d
        L77:
            JF r0 = r7.f6709n
            r0.mo1885l(r8)
            boolean r0 = r7.f6701f
            if (r0 == 0) goto L85
            pC r0 = r7.f6710o
            r0.mo9048f(r8)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2236qE.mo4479f(java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo4480g(Object r24, InterfaceC0017AG r25) {
        /*
            Method dump skipped, instructions count: 3186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2236qE.mo4480g(java.lang.Object, AG):void");
    }

    @Override
    public final void mo4481h(Object obj, byte[] bArr, int i, int i2, C1769gB c1769gB) throws C1771gD {
        m9138m(obj, bArr, i, i2, 0, c1769gB);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo4482i(Object r10, Object r11) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2236qE.mo4482i(java.lang.Object, java.lang.Object):boolean");
    }

    public final int m9136k(int i) {
        if (i < this.f6698c || i > this.f6699d) {
            return -1;
        }
        return m9137l(i, 0);
    }

    public final int m9137l(int i, int i2) {
        int length = (this.f6696a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f6696a[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:195:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0af2  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0874 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:545:0x0b73 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:587:0x0864 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:202:0x05b6 -> B:191:0x0590). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:231:0x064a -> B:223:0x0629). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:253:0x0697 -> B:243:0x066e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m9138m(Object r31, byte[] r32, int r33, int r34, int r35, C1769gB r36) throws C1771gD {
        /*
            Method dump skipped, instructions count: 3180
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2236qE.m9138m(java.lang.Object, byte[], int, int, int, gB):int");
    }

    public final Object m9139n(int i, int i2, Map map, InterfaceC1116YC interfaceC1116YC, Object obj, AbstractC0430JF abstractC0430JF, Object obj2) {
        this.f6711p.mo4367b(m9135Q(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!interfaceC1116YC.mo797e(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = abstractC0430JF.mo1882i(obj2);
                }
                C0012AB c0012abM9109u = AbstractC2233qB.m9109u(AbstractC0887TD.m4120a(null, entry.getKey(), entry.getValue()));
                try {
                    AbstractC0887TD.m4121b(c0012abM9109u.m69b(), null, entry.getKey(), entry.getValue());
                    abstractC0430JF.mo1876c(obj, i2, c0012abM9109u.m68a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    public final Object m9140o(Object obj, int i) {
        InterfaceC1026WE interfaceC1026WEM9134O = m9134O(i);
        long jM9129G = m9129G(i) & 1048575;
        if (!m9130J(obj, i)) {
            return interfaceC1026WEM9134O.mo4474a();
        }
        Object object = f6695r.getObject(obj, jM9129G);
        if (m9119T(object)) {
            return object;
        }
        Object objMo4474a = interfaceC1026WEM9134O.mo4474a();
        if (object != null) {
            interfaceC1026WEM9134O.mo4476c(objMo4474a, object);
        }
        return objMo4474a;
    }

    public final Object m9141p(Object obj, int i, int i2) {
        InterfaceC1026WE interfaceC1026WEM9134O = m9134O(i2);
        if (!m9131K(obj, i, i2)) {
            return interfaceC1026WEM9134O.mo4474a();
        }
        Object object = f6695r.getObject(obj, m9129G(i2) & 1048575);
        if (m9119T(object)) {
            return object;
        }
        Object objMo4474a = interfaceC1026WEM9134O.mo4474a();
        if (object != null) {
            interfaceC1026WEM9134O.mo4476c(objMo4474a, object);
        }
        return objMo4474a;
    }

    public final Object m9142q(Object obj, int i, Object obj2, AbstractC0430JF abstractC0430JF, Object obj3) {
        InterfaceC1116YC interfaceC1116YCM9133N;
        int i2 = this.f6696a[i];
        Object objM2320B = AbstractC0476KF.m2320B(obj, m9129G(i) & 1048575);
        return (objM2320B == null || (interfaceC1116YCM9133N = m9133N(i)) == null) ? obj2 : m9139n(i, i2, this.f6711p.mo4369d(objM2320B), interfaceC1116YCM9133N, obj2, abstractC0430JF, obj3);
    }

    public final void m9143u(Object obj, int i, int i2, Object obj2) {
        f6695r.putObject(obj, m9129G(i2) & 1048575, obj2);
        m9127E(obj, i, i2);
    }

    public final void m9144v(Object obj, int i, Object obj2) {
        f6695r.putObject(obj, m9129G(i) & 1048575, obj2);
        m9126D(obj, i);
    }

    public final void m9145w(Object obj, Object obj2, int i) {
        if (m9130J(obj2, i)) {
            long jM9129G = m9129G(i) & 1048575;
            Unsafe unsafe = f6695r;
            Object object = unsafe.getObject(obj2, jM9129G);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f6696a[i] + " is present but null: " + String.valueOf(obj2));
            }
            InterfaceC1026WE interfaceC1026WEM9134O = m9134O(i);
            if (!m9130J(obj, i)) {
                if (m9119T(object)) {
                    Object objMo4474a = interfaceC1026WEM9134O.mo4474a();
                    interfaceC1026WEM9134O.mo4476c(objMo4474a, object);
                    unsafe.putObject(obj, jM9129G, objMo4474a);
                } else {
                    unsafe.putObject(obj, jM9129G, object);
                }
                m9126D(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jM9129G);
            if (!m9119T(object2)) {
                Object objMo4474a2 = interfaceC1026WEM9134O.mo4474a();
                interfaceC1026WEM9134O.mo4476c(objMo4474a2, object2);
                unsafe.putObject(obj, jM9129G, objMo4474a2);
                object2 = objMo4474a2;
            }
            interfaceC1026WEM9134O.mo4476c(object2, object);
        }
    }

    public final void m9146y(InterfaceC0017AG interfaceC0017AG, int i, Object obj, int i2) {
        if (obj != null) {
            this.f6711p.mo4367b(m9135Q(i2));
            interfaceC0017AG.mo89d(i, null, this.f6711p.mo4371f(obj));
        }
    }

    public final boolean m9147z(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? m9130J(obj, i) : (i3 & i4) != 0;
    }
}
