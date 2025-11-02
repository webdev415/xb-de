package p000;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractC2001lA {

    public static final Object f6062h = new Object();

    public static volatile AbstractC2646zA f6063i;

    public static C0471KA f6064j;

    public static final AtomicInteger f6065k;

    public final C0057BA f6066a;

    public final String f6067b;

    public Object f6068c;

    public volatile int f6069d;

    public volatile Object f6070e;

    public final boolean f6071f;

    public volatile boolean f6072g;

    static {
        new AtomicReference();
        f6064j = new C0471KA(new InterfaceC0747QA() {
            @Override
            public final boolean mo3644a() {
                return AbstractC2001lA.m8367n();
            }
        });
        f6065k = new AtomicInteger();
    }

    public AbstractC2001lA(C0057BA c0057ba, String str, Object obj, boolean z) {
        this.f6069d = -1;
        String str2 = c0057ba.f139a;
        if (str2 == null && c0057ba.f140b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (str2 != null && c0057ba.f140b != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.f6066a = c0057ba;
        this.f6067b = str;
        this.f6068c = obj;
        this.f6071f = z;
        this.f6072g = false;
    }

    public static AbstractC2001lA m8361f(C0057BA c0057ba, String str, Boolean bool, boolean z) {
        return new C2278rA(c0057ba, str, bool, true);
    }

    public static AbstractC2001lA m8362g(C0057BA c0057ba, String str, Double d, boolean z) {
        return new C2554xA(c0057ba, str, d, true);
    }

    public static AbstractC2001lA m8363h(C0057BA c0057ba, String str, Long l, boolean z) {
        return new C2370tA(c0057ba, str, l, true);
    }

    public static AbstractC2001lA m8364i(C0057BA c0057ba, String str, String str2, boolean z) {
        return new C2462vA(c0057ba, str, str2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m8365l(final android.content.Context r3) {
        /*
            zA r0 = p000.AbstractC2001lA.f6063i
            if (r0 != 0) goto L4e
            if (r3 != 0) goto L7
            goto L4e
        L7:
            java.lang.Object r0 = p000.AbstractC2001lA.f6062h
            monitor-enter(r0)
            zA r1 = p000.AbstractC2001lA.f6063i     // Catch: java.lang.Throwable -> L48
            if (r1 != 0) goto L4a
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L48
            zA r1 = p000.AbstractC2001lA.f6063i     // Catch: java.lang.Throwable -> L22
            android.content.Context r2 = r3.getApplicationContext()     // Catch: java.lang.Throwable -> L22
            if (r2 != 0) goto L18
            goto L19
        L18:
            r3 = r2
        L19:
            if (r1 == 0) goto L24
            android.content.Context r2 = r1.mo10825a()     // Catch: java.lang.Throwable -> L22
            if (r2 == r3) goto L44
            goto L24
        L22:
            r3 = move-exception
            goto L46
        L24:
            if (r1 == 0) goto L2f
            p000.C0413Iz.m1758d()     // Catch: java.lang.Throwable -> L22
            p000.C0287GA.m1363c()     // Catch: java.lang.Throwable -> L22
            p000.C1102Xz.m4860b()     // Catch: java.lang.Throwable -> L22
        L2f:
            pA r1 = new pA     // Catch: java.lang.Throwable -> L22
            r1.<init>()     // Catch: java.lang.Throwable -> L22
            Rm r1 = p000.AbstractC0859Sm.m4071a(r1)     // Catch: java.lang.Throwable -> L22
            xz r2 = new xz     // Catch: java.lang.Throwable -> L22
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L22
            p000.AbstractC2001lA.f6063i = r2     // Catch: java.lang.Throwable -> L22
            java.util.concurrent.atomic.AtomicInteger r3 = p000.AbstractC2001lA.f6065k     // Catch: java.lang.Throwable -> L22
            r3.incrementAndGet()     // Catch: java.lang.Throwable -> L22
        L44:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            goto L4a
        L46:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            throw r3     // Catch: java.lang.Throwable -> L48
        L48:
            r3 = move-exception
            goto L4c
        L4a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L48
            return
        L4c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L48
            throw r3
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2001lA.m8365l(android.content.Context):void");
    }

    public static void m8366m() {
        f6065k.incrementAndGet();
    }

    public static boolean m8367n() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007c A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:8:0x001c, B:10:0x0020, B:12:0x0029, B:14:0x0039, B:20:0x0055, B:22:0x0060, B:35:0x0080, B:38:0x0088, B:39:0x008d, B:40:0x0091, B:25:0x0067, B:34:0x007c, B:28:0x006e, B:31:0x0075, B:41:0x0095), top: B:47:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final Object m8368b() {
        /*
            r8 = this;
            boolean r0 = r8.f6071f
            if (r0 != 0) goto L11
            KA r0 = p000.AbstractC2001lA.f6064j
            java.lang.String r1 = r8.f6067b
            boolean r0 = r0.m2317a(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            p000.AbstractC1131Yi.m4979o(r0, r1)
        L11:
            java.util.concurrent.atomic.AtomicInteger r0 = p000.AbstractC2001lA.f6065k
            int r0 = r0.get()
            int r1 = r8.f6069d
            if (r1 >= r0) goto L99
            monitor-enter(r8)
            int r1 = r8.f6069d     // Catch: java.lang.Throwable -> L4e
            if (r1 >= r0) goto L95
            zA r1 = p000.AbstractC2001lA.f6063i     // Catch: java.lang.Throwable -> L4e
            bi r2 = p000.AbstractC1325bi.m5671a()     // Catch: java.lang.Throwable -> L4e
            r3 = 0
            if (r1 == 0) goto L50
            Rm r2 = r1.mo10826b()     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> L4e
            bi r2 = (p000.AbstractC1325bi) r2     // Catch: java.lang.Throwable -> L4e
            boolean r4 = r2.mo5674c()     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L50
            java.lang.Object r3 = r2.mo5673b()     // Catch: java.lang.Throwable -> L4e
            Zz r3 = (p000.InterfaceC1194Zz) r3     // Catch: java.lang.Throwable -> L4e
            BA r4 = r8.f6066a     // Catch: java.lang.Throwable -> L4e
            android.net.Uri r5 = r4.f140b     // Catch: java.lang.Throwable -> L4e
            java.lang.String r6 = r4.f139a     // Catch: java.lang.Throwable -> L4e
            java.lang.String r4 = r4.f142d     // Catch: java.lang.Throwable -> L4e
            java.lang.String r7 = r8.f6067b     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = r3.mo3606a(r5, r6, r4, r7)     // Catch: java.lang.Throwable -> L4e
            goto L50
        L4e:
            r0 = move-exception
            goto L97
        L50:
            if (r1 == 0) goto L54
            r4 = 1
            goto L55
        L54:
            r4 = 0
        L55:
            java.lang.String r5 = "Must call PhenotypeFlagInitializer.maybeInit() first"
            p000.AbstractC1131Yi.m4979o(r4, r5)     // Catch: java.lang.Throwable -> L4e
            BA r4 = r8.f6066a     // Catch: java.lang.Throwable -> L4e
            boolean r4 = r4.f144f     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L6e
            java.lang.Object r4 = r8.m8370d(r1)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L67
            goto L80
        L67:
            java.lang.Object r4 = r8.m8372j(r1)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L7c
            goto L80
        L6e:
            java.lang.Object r4 = r8.m8372j(r1)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L75
            goto L80
        L75:
            java.lang.Object r4 = r8.m8370d(r1)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L7c
            goto L80
        L7c:
            java.lang.Object r4 = r8.m8374o()     // Catch: java.lang.Throwable -> L4e
        L80:
            boolean r1 = r2.mo5674c()     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L91
            if (r3 != 0) goto L8d
            java.lang.Object r4 = r8.m8374o()     // Catch: java.lang.Throwable -> L4e
            goto L91
        L8d:
            java.lang.Object r4 = r8.mo8369c(r3)     // Catch: java.lang.Throwable -> L4e
        L91:
            r8.f6070e = r4     // Catch: java.lang.Throwable -> L4e
            r8.f6069d = r0     // Catch: java.lang.Throwable -> L4e
        L95:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L4e
            goto L99
        L97:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L4e
            throw r0
        L99:
            java.lang.Object r0 = r8.f6070e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2001lA.m8368b():java.lang.Object");
    }

    public abstract Object mo8369c(Object obj);

    public final Object m8370d(AbstractC2646zA abstractC2646zA) {
        InterfaceC2289rc interfaceC2289rc;
        C0057BA c0057ba = this.f6066a;
        if (!c0057ba.f143e && ((interfaceC2289rc = c0057ba.f147i) == null || ((Boolean) interfaceC2289rc.apply(abstractC2646zA.mo10825a())).booleanValue())) {
            C1102Xz c1102XzM4859a = C1102Xz.m4859a(abstractC2646zA.mo10825a());
            C0057BA c0057ba2 = this.f6066a;
            Object objMo1365g = c1102XzM4859a.mo1365g(c0057ba2.f143e ? null : m8371e(c0057ba2.f141c));
            if (objMo1365g != null) {
                return mo8369c(objMo1365g);
            }
        }
        return null;
    }

    public final String m8371e(String str) {
        if (str != null && str.isEmpty()) {
            return this.f6067b;
        }
        return str + this.f6067b;
    }

    public final Object m8372j(AbstractC2646zA abstractC2646zA) {
        Object objMo1365g;
        InterfaceC0643Nz interfaceC0643NzM1757b = this.f6066a.f140b != null ? AbstractC1815hA.m7817b(abstractC2646zA.mo10825a(), this.f6066a.f140b) ? this.f6066a.f146h ? C0413Iz.m1757b(abstractC2646zA.mo10825a().getContentResolver(), AbstractC1721fA.m7566a(AbstractC1721fA.m7567b(abstractC2646zA.mo10825a(), this.f6066a.f140b.getLastPathSegment())), new Runnable() {
            @Override
            public final void run() {
                AbstractC2001lA.m8366m();
            }
        }) : C0413Iz.m1757b(abstractC2646zA.mo10825a().getContentResolver(), this.f6066a.f140b, new Runnable() {
            @Override
            public final void run() {
                AbstractC2001lA.m8366m();
            }
        }) : null : C0287GA.m1362b(abstractC2646zA.mo10825a(), this.f6066a.f139a, new Runnable() {
            @Override
            public final void run() {
                AbstractC2001lA.m8366m();
            }
        });
        if (interfaceC0643NzM1757b == null || (objMo1365g = interfaceC0643NzM1757b.mo1365g(m8373k())) == null) {
            return null;
        }
        return mo8369c(objMo1365g);
    }

    public final String m8373k() {
        return m8371e(this.f6066a.f142d);
    }

    public final Object m8374o() {
        return this.f6068c;
    }
}
