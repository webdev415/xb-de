package p000;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class C1045Wo {

    public static final C1045Wo f3118b;

    public final l f3119a;

    public static class a {

        public static Field f3120a;

        public static Field f3121b;

        public static Field f3122c;

        public static boolean f3123d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f3120a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f3121b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f3122c = declaredField3;
                declaredField3.setAccessible(true);
                f3123d = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static C1045Wo m4562a(View view) throws IllegalAccessException, IllegalArgumentException {
            if (f3123d && view.isAttachedToWindow()) {
                try {
                    Object obj = f3120a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f3121b.get(obj);
                        Rect rect2 = (Rect) f3122c.get(obj);
                        if (rect != null && rect2 != null) {
                            C1045Wo c1045WoM4563a = new b().m4564b(Insets.m9568c(rect)).m4565c(Insets.m9568c(rect2)).m4563a();
                            c1045WoM4563a.m4559p(c1045WoM4563a);
                            c1045WoM4563a.m4547d(view.getRootView());
                            return c1045WoM4563a;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
            }
            return null;
        }
    }

    public static final class b {

        public final f f3124a;

        public b() {
            int i = Build.VERSION.SDK_INT;
            this.f3124a = i >= 30 ? new e() : i >= 29 ? new d() : new c();
        }

        public C1045Wo m4563a() {
            return this.f3124a.mo4567b();
        }

        public b m4564b(Insets insets) {
            this.f3124a.mo4568d(insets);
            return this;
        }

        public b m4565c(Insets insets) {
            this.f3124a.mo4569f(insets);
            return this;
        }

        public b(C1045Wo c1045Wo) {
            int i = Build.VERSION.SDK_INT;
            this.f3124a = i >= 30 ? new e(c1045Wo) : i >= 29 ? new d(c1045Wo) : new c(c1045Wo);
        }
    }

    public static class c extends f {

        public static Field f3125e = null;

        public static boolean f3126f = false;

        public static Constructor f3127g = null;

        public static boolean f3128h = false;

        public WindowInsets f3129c;

        public Insets f3130d;

        public c() {
            this.f3129c = m4566h();
        }

        private static WindowInsets m4566h() {
            if (!f3126f) {
                try {
                    f3125e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                f3126f = true;
            }
            Field field = f3125e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!f3128h) {
                try {
                    f3127g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                f3128h = true;
            }
            Constructor constructor = f3127g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }

        @Override
        public C1045Wo mo4567b() {
            m4573a();
            C1045Wo c1045WoM4542s = C1045Wo.m4542s(this.f3129c);
            c1045WoM4542s.m4557n(this.f3133b);
            c1045WoM4542s.m4560q(this.f3130d);
            return c1045WoM4542s;
        }

        @Override
        public void mo4568d(Insets insets) {
            this.f3130d = insets;
        }

        @Override
        public void mo4569f(Insets insets) {
            WindowInsets windowInsets = this.f3129c;
            if (windowInsets != null) {
                this.f3129c = windowInsets.replaceSystemWindowInsets(insets.f7065a, insets.f7066b, insets.f7067c, insets.f7068d);
            }
        }

        public c(C1045Wo c1045Wo) {
            super(c1045Wo);
            this.f3129c = c1045Wo.m4561r();
        }
    }

    public static class d extends f {

        public final WindowInsets.Builder f3131c;

        public d() {
            this.f3131c = AbstractC1699ep.m7472a();
        }

        @Override
        public C1045Wo mo4567b() {
            m4573a();
            C1045Wo c1045WoM4542s = C1045Wo.m4542s(this.f3131c.build());
            c1045WoM4542s.m4557n(this.f3133b);
            return c1045WoM4542s;
        }

        @Override
        public void mo4570c(Insets insets) {
            this.f3131c.setMandatorySystemGestureInsets(insets.m9570e());
        }

        @Override
        public void mo4568d(Insets insets) {
            this.f3131c.setStableInsets(insets.m9570e());
        }

        @Override
        public void mo4571e(Insets insets) {
            this.f3131c.setSystemGestureInsets(insets.m9570e());
        }

        @Override
        public void mo4569f(Insets insets) {
            this.f3131c.setSystemWindowInsets(insets.m9570e());
        }

        @Override
        public void mo4572g(Insets insets) {
            this.f3131c.setTappableElementInsets(insets.m9570e());
        }

        public d(C1045Wo c1045Wo) {
            super(c1045Wo);
            WindowInsets windowInsetsM4561r = c1045Wo.m4561r();
            this.f3131c = windowInsetsM4561r != null ? AbstractC1652dp.m7364a(windowInsetsM4561r) : AbstractC1699ep.m7472a();
        }
    }

    public static class e extends d {
        public e() {
        }

        public e(C1045Wo c1045Wo) {
            super(c1045Wo);
        }
    }

    public static class f {

        public final C1045Wo f3132a;

        public Insets[] f3133b;

        public f() {
            this(new C1045Wo((C1045Wo) null));
        }

        public final void m4573a() {
            Insets[] insetsArr = this.f3133b;
            if (insetsArr != null) {
                Insets insetsM4549F = insetsArr[m.m4599c(1)];
                Insets insetsM4549F2 = this.f3133b[m.m4599c(2)];
                if (insetsM4549F2 == null) {
                    insetsM4549F2 = this.f3132a.m4549f(2);
                }
                if (insetsM4549F == null) {
                    insetsM4549F = this.f3132a.m4549f(1);
                }
                mo4569f(Insets.m9566a(insetsM4549F, insetsM4549F2));
                Insets insets = this.f3133b[m.m4599c(16)];
                if (insets != null) {
                    mo4571e(insets);
                }
                Insets insets2 = this.f3133b[m.m4599c(32)];
                if (insets2 != null) {
                    mo4570c(insets2);
                }
                Insets insets3 = this.f3133b[m.m4599c(64)];
                if (insets3 != null) {
                    mo4572g(insets3);
                }
            }
        }

        public abstract C1045Wo mo4567b();

        public abstract void mo4568d(Insets insets);

        public abstract void mo4569f(Insets insets);

        public f(C1045Wo c1045Wo) {
            this.f3132a = c1045Wo;
        }

        public void mo4570c(Insets insets) {
        }

        public void mo4571e(Insets insets) {
        }

        public void mo4572g(Insets insets) {
        }
    }

    public static class g extends l {

        public static boolean f3134h = false;

        public static Method f3135i;

        public static Class f3136j;

        public static Field f3137k;

        public static Field f3138l;

        public final WindowInsets windowInsets;

        public Insets[] f3140d;

        public Insets f3141e;

        public C1045Wo f3142f;

        public Insets f3143g;

        public g(C1045Wo c1045Wo, g gVar) {
            this(c1045Wo, new WindowInsets(gVar.windowInsets));
        }

        @SuppressLint({"WrongConstant"})
        private Insets m4574s(int i, boolean z) {
            Insets insetsM9566A = Insets.f7064e;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    insetsM9566A = Insets.m9566a(insetsM9566A, m4586t(i2, z));
                }
            }
            return insetsM9566A;
        }

        private Insets m4575u() {
            C1045Wo c1045Wo = this.f3142f;
            return c1045Wo != null ? c1045Wo.m4550g() : Insets.f7064e;
        }

        private Insets m4576v(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f3134h) {
                m4577w();
            }
            Method method = f3135i;
            if (method != null && f3136j != null && f3137k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f3137k.get(f3138l.get(objInvoke));
                    if (rect != null) {
                        return Insets.m9568c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void m4577w() throws ClassNotFoundException, SecurityException {
            try {
                f3135i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f3136j = cls;
                f3137k = cls.getDeclaredField("mVisibleInsets");
                f3138l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f3137k.setAccessible(true);
                f3138l.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            f3134h = true;
        }

        @Override
        public void mo4578d(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Insets insetsM4576V = m4576v(view);
            if (insetsM4576V == null) {
                insetsM4576V = Insets.f7064e;
            }
            mo4584p(insetsM4576V);
        }

        @Override
        public void mo4579e(C1045Wo c1045Wo) {
            c1045Wo.m4559p(this.f3142f);
            c1045Wo.m4558o(this.f3143g);
        }

        @Override
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f3143g, ((g) obj).f3143g);
            }
            return false;
        }

        @Override
        public Insets mo4580g(int i) {
            return m4574s(i, false);
        }

        @Override
        public final Insets mo4581k() {
            if (this.f3141e == null) {
                this.f3141e = Insets.m9567b(this.windowInsets.getSystemWindowInsetLeft(), this.windowInsets.getSystemWindowInsetTop(), this.windowInsets.getSystemWindowInsetRight(), this.windowInsets.getSystemWindowInsetBottom());
            }
            return this.f3141e;
        }

        @Override
        public boolean mo4582n() {
            return this.windowInsets.isRound();
        }

        @Override
        public void mo4583o(Insets[] insetsArr) {
            this.f3140d = insetsArr;
        }

        @Override
        public void mo4584p(Insets insets) {
            this.f3143g = insets;
        }

        @Override
        public void mo4585q(C1045Wo c1045Wo) {
            this.f3142f = c1045Wo;
        }

        public Insets m4586t(int i, boolean z) {
            Insets insetsM4550G;
            int i2;
            if (i == 1) {
                return z ? Insets.m9567b(0, Math.max(m4575u().f7066b, mo4581k().f7066b), 0, 0) : Insets.m9567b(0, mo4581k().f7066b, 0, 0);
            }
            if (i == 2) {
                if (z) {
                    Insets insetsM4575U = m4575u();
                    Insets insetsMo4589I = mo4589i();
                    return Insets.m9567b(Math.max(insetsM4575U.f7065a, insetsMo4589I.f7065a), 0, Math.max(insetsM4575U.f7067c, insetsMo4589I.f7067c), Math.max(insetsM4575U.f7068d, insetsMo4589I.f7068d));
                }
                Insets insetsMo4581K = mo4581k();
                C1045Wo c1045Wo = this.f3142f;
                insetsM4550G = c1045Wo != null ? c1045Wo.m4550g() : null;
                int iMin = insetsMo4581K.f7068d;
                if (insetsM4550G != null) {
                    iMin = Math.min(iMin, insetsM4550G.f7068d);
                }
                return Insets.m9567b(insetsMo4581K.f7065a, 0, insetsMo4581K.f7067c, iMin);
            }
            if (i != 8) {
                if (i == 16) {
                    return mo4595j();
                }
                if (i == 32) {
                    return mo4594h();
                }
                if (i == 64) {
                    return mo4596l();
                }
                if (i != 128) {
                    return Insets.f7064e;
                }
                C1045Wo c1045Wo2 = this.f3142f;
                DisplayCutoutCompat displayCutoutCompatM4548E = c1045Wo2 != null ? c1045Wo2.m4548e() : mo4593f();
                return displayCutoutCompatM4548E != null ? Insets.m9567b(displayCutoutCompatM4548E.m5756b(), displayCutoutCompatM4548E.m5758d(), displayCutoutCompatM4548E.m5757c(), displayCutoutCompatM4548E.m5755a()) : Insets.f7064e;
            }
            Insets[] insetsArr = this.f3140d;
            insetsM4550G = insetsArr != null ? insetsArr[m.m4599c(8)] : null;
            if (insetsM4550G != null) {
                return insetsM4550G;
            }
            Insets insetsMo4581K2 = mo4581k();
            Insets insetsM4575U2 = m4575u();
            int i3 = insetsMo4581K2.f7068d;
            if (i3 > insetsM4575U2.f7068d) {
                return Insets.m9567b(0, 0, 0, i3);
            }
            Insets insets = this.f3143g;
            return (insets == null || insets.equals(Insets.f7064e) || (i2 = this.f3143g.f7068d) <= insetsM4575U2.f7068d) ? Insets.f7064e : Insets.m9567b(0, 0, 0, i2);
        }

        public g(C1045Wo c1045Wo, WindowInsets windowInsets) {
            super(c1045Wo);
            this.f3141e = null;
            this.windowInsets = windowInsets;
        }
    }

    public static class h extends g {

        public Insets f3144m;

        public h(C1045Wo c1045Wo, h hVar) {
            super(c1045Wo, hVar);
            this.f3144m = null;
            this.f3144m = hVar.f3144m;
        }

        @Override
        public C1045Wo mo4587b() {
            return C1045Wo.m4542s(this.windowInsets.consumeStableInsets());
        }

        @Override
        public C1045Wo mo4588c() {
            return C1045Wo.m4542s(this.windowInsets.consumeSystemWindowInsets());
        }

        @Override
        public final Insets mo4589i() {
            if (this.f3144m == null) {
                this.f3144m = Insets.m9567b(this.windowInsets.getStableInsetLeft(), this.windowInsets.getStableInsetTop(), this.windowInsets.getStableInsetRight(), this.windowInsets.getStableInsetBottom());
            }
            return this.f3144m;
        }

        @Override
        public boolean mo4590m() {
            return this.windowInsets.isConsumed();
        }

        @Override
        public void mo4591r(Insets insets) {
            this.f3144m = insets;
        }

        public h(C1045Wo c1045Wo, WindowInsets windowInsets) {
            super(c1045Wo, windowInsets);
            this.f3144m = null;
        }
    }

    public static class i extends h {
        public i(C1045Wo c1045Wo, i iVar) {
            super(c1045Wo, iVar);
        }

        @Override
        public C1045Wo mo4592a() {
            return C1045Wo.m4542s(this.windowInsets.consumeDisplayCutout());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.windowInsets, iVar.windowInsets) && Objects.equals(this.f3143g, iVar.f3143g);
        }

        @Override
        public DisplayCutoutCompat mo4593f() {
            return DisplayCutoutCompat.m5754e(this.windowInsets.getDisplayCutout());
        }

        @Override
        public int hashCode() {
            return this.windowInsets.hashCode();
        }

        public i(C1045Wo c1045Wo, WindowInsets windowInsets) {
            super(c1045Wo, windowInsets);
        }
    }

    public static class j extends i {

        public Insets f3145n;

        public Insets f3146o;

        public Insets f3147p;

        public j(C1045Wo c1045Wo, j jVar) {
            super(c1045Wo, jVar);
            this.f3145n = null;
            this.f3146o = null;
            this.f3147p = null;
        }

        @Override
        public Insets mo4594h() {
            if (this.f3146o == null) {
                this.f3146o = Insets.m9569d(this.windowInsets.getMandatorySystemGestureInsets());
            }
            return this.f3146o;
        }

        @Override
        public Insets mo4595j() {
            if (this.f3145n == null) {
                this.f3145n = Insets.m9569d(this.windowInsets.getSystemGestureInsets());
            }
            return this.f3145n;
        }

        @Override
        public Insets mo4596l() {
            if (this.f3147p == null) {
                this.f3147p = Insets.m9569d(this.windowInsets.getTappableElementInsets());
            }
            return this.f3147p;
        }

        public j(C1045Wo c1045Wo, WindowInsets windowInsets) {
            super(c1045Wo, windowInsets);
            this.f3145n = null;
            this.f3146o = null;
            this.f3147p = null;
        }

        @Override
        public void mo4591r(Insets insets) {
        }
    }

    public static class k extends j {

        public static final C1045Wo f3148q = C1045Wo.m4542s(WindowInsets.CONSUMED);

        public k(C1045Wo c1045Wo, k kVar) {
            super(c1045Wo, kVar);
        }

        @Override
        public Insets mo4580g(int i) {
            return Insets.m9569d(this.windowInsets.getInsets(n.m4605a(i)));
        }

        public k(C1045Wo c1045Wo, WindowInsets windowInsets) {
            super(c1045Wo, windowInsets);
        }

        @Override
        public final void mo4578d(View view) {
        }
    }

    public static final class m {
        public static int m4597a() {
            return 128;
        }

        public static int m4598b() {
            return 8;
        }

        public static int m4599c(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
        }

        public static int m4600d() {
            return 32;
        }

        public static int m4601e() {
            return 2;
        }

        public static int m4602f() {
            return 1;
        }

        public static int getType() {
            return 7;
        }

        public static int m4604h() {
            return 16;
        }
    }

    public static final class n {
        public static int m4605a(int i) {
            int iStatusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i2 |= iStatusBars;
                }
            }
            return i2;
        }
    }

    static {
        f3118b = Build.VERSION.SDK_INT >= 30 ? k.f3148q : l.f3149b;
    }

    public C1045Wo(C1045Wo c1045Wo) {
        if (c1045Wo == null) {
            this.f3119a = new l(this);
            return;
        }
        l lVar = c1045Wo.f3119a;
        int i2 = Build.VERSION.SDK_INT;
        this.f3119a = (i2 < 30 || !(lVar instanceof k)) ? (i2 < 29 || !(lVar instanceof j)) ? (i2 < 28 || !(lVar instanceof i)) ? lVar instanceof h ? new h(this, (h) lVar) : lVar instanceof g ? new g(this, (g) lVar) : new l(this) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.mo4579e(this);
    }

    public static C1045Wo m4542s(WindowInsets windowInsets) {
        return m4543t(windowInsets, null);
    }

    public static C1045Wo m4543t(WindowInsets windowInsets, View view) {
        C1045Wo c1045Wo = new C1045Wo((WindowInsets) AbstractC1225aj.m5300a(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            c1045Wo.m4559p(AbstractC0448Jo.m2080i(view));
            c1045Wo.m4547d(view.getRootView());
        }
        return c1045Wo;
    }

    public C1045Wo m4544a() {
        return this.f3119a.mo4592a();
    }

    public C1045Wo m4545b() {
        return this.f3119a.mo4587b();
    }

    public C1045Wo m4546c() {
        return this.f3119a.mo4588c();
    }

    public void m4547d(View view) {
        this.f3119a.mo4578d(view);
    }

    public DisplayCutoutCompat m4548e() {
        return this.f3119a.mo4593f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1045Wo) {
            return AbstractC0349Hh.m1589a(this.f3119a, ((C1045Wo) obj).f3119a);
        }
        return false;
    }

    public Insets m4549f(int i2) {
        return this.f3119a.mo4580g(i2);
    }

    public Insets m4550g() {
        return this.f3119a.mo4589i();
    }

    public int m4551h() {
        return this.f3119a.mo4581k().f7068d;
    }

    public int hashCode() {
        l lVar = this.f3119a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public int m4552i() {
        return this.f3119a.mo4581k().f7065a;
    }

    public int m4553j() {
        return this.f3119a.mo4581k().f7067c;
    }

    public int m4554k() {
        return this.f3119a.mo4581k().f7066b;
    }

    public boolean m4555l() {
        return this.f3119a.mo4590m();
    }

    public C1045Wo m4556m(int i2, int i3, int i4, int i5) {
        return new b(this).m4565c(Insets.m9567b(i2, i3, i4, i5)).m4563a();
    }

    public void m4557n(Insets[] insetsArr) {
        this.f3119a.mo4583o(insetsArr);
    }

    public void m4558o(Insets insets) {
        this.f3119a.mo4584p(insets);
    }

    public void m4559p(C1045Wo c1045Wo) {
        this.f3119a.mo4585q(c1045Wo);
    }

    public void m4560q(Insets insets) {
        this.f3119a.mo4591r(insets);
    }

    public WindowInsets m4561r() {
        l lVar = this.f3119a;
        if (lVar instanceof g) {
            return ((g) lVar).windowInsets;
        }
        return null;
    }

    public C1045Wo(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        this.f3119a = i2 >= 30 ? new k(this, windowInsets) : i2 >= 29 ? new j(this, windowInsets) : i2 >= 28 ? new i(this, windowInsets) : new h(this, windowInsets);
    }

    public static class l {

        public static final C1045Wo f3149b = new b().m4563a().m4544a().m4545b().m4546c();

        public final C1045Wo f3150a;

        public l(C1045Wo c1045Wo) {
            this.f3150a = c1045Wo;
        }

        public C1045Wo mo4592a() {
            return this.f3150a;
        }

        public C1045Wo mo4587b() {
            return this.f3150a;
        }

        public C1045Wo mo4588c() {
            return this.f3150a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return mo4582n() == lVar.mo4582n() && mo4590m() == lVar.mo4590m() && AbstractC0349Hh.m1589a(mo4581k(), lVar.mo4581k()) && AbstractC0349Hh.m1589a(mo4589i(), lVar.mo4589i()) && AbstractC0349Hh.m1589a(mo4593f(), lVar.mo4593f());
        }

        public DisplayCutoutCompat mo4593f() {
            return null;
        }

        public Insets mo4580g(int i) {
            return Insets.f7064e;
        }

        public Insets mo4594h() {
            return mo4581k();
        }

        public int hashCode() {
            return AbstractC0349Hh.m1590b(Boolean.valueOf(mo4582n()), Boolean.valueOf(mo4590m()), mo4581k(), mo4589i(), mo4593f());
        }

        public Insets mo4589i() {
            return Insets.f7064e;
        }

        public Insets mo4595j() {
            return mo4581k();
        }

        public Insets mo4581k() {
            return Insets.f7064e;
        }

        public Insets mo4596l() {
            return mo4581k();
        }

        public boolean mo4590m() {
            return false;
        }

        public boolean mo4582n() {
            return false;
        }

        public void mo4578d(View view) {
        }

        public void mo4579e(C1045Wo c1045Wo) {
        }

        public void mo4583o(Insets[] insetsArr) {
        }

        public void mo4584p(Insets insets) {
        }

        public void mo4585q(C1045Wo c1045Wo) {
        }

        public void mo4591r(Insets insets) {
        }
    }
}
