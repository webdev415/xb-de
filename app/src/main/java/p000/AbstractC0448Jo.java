package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.contentcapture.ContentCaptureSession;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import p000.C0736Q;
import p000.C1045Wo;

/* loaded from: classes.dex */
public abstract class AbstractC0448Jo {

    public static Field f1443a = null;

    public static boolean f1444b = false;

    public static final int[] f1445c = {AbstractC0397Ij.f1174b, AbstractC0397Ij.f1175c, AbstractC0397Ij.f1186n, AbstractC0397Ij.f1197y, AbstractC0397Ij.f1157B, AbstractC0397Ij.f1158C, AbstractC0397Ij.f1159D, AbstractC0397Ij.f1160E, AbstractC0397Ij.f1161F, AbstractC0397Ij.f1162G, AbstractC0397Ij.f1176d, AbstractC0397Ij.f1177e, AbstractC0397Ij.f1178f, AbstractC0397Ij.f1179g, AbstractC0397Ij.f1180h, AbstractC0397Ij.f1181i, AbstractC0397Ij.f1182j, AbstractC0397Ij.f1183k, AbstractC0397Ij.f1184l, AbstractC0397Ij.f1185m, AbstractC0397Ij.f1187o, AbstractC0397Ij.f1188p, AbstractC0397Ij.f1189q, AbstractC0397Ij.f1190r, AbstractC0397Ij.f1191s, AbstractC0397Ij.f1192t, AbstractC0397Ij.f1193u, AbstractC0397Ij.f1194v, AbstractC0397Ij.f1195w, AbstractC0397Ij.f1196x, AbstractC0397Ij.f1198z, AbstractC0397Ij.f1156A};

    public static final InterfaceC0854Sh f1446d = new InterfaceC0854Sh() {
    };

    public static final e f1447e = new e();

    public class a extends f {
        public a(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override
        public Boolean mo2098b(View view) {
            return Boolean.valueOf(j.m2143d(view));
        }
    }

    public class b extends f {
        public b(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override
        public CharSequence mo2098b(View view) {
            return j.m2141b(view);
        }
    }

    public class c extends f {
        public c(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override
        public CharSequence mo2098b(View view) {
            return l.m2157b(view);
        }
    }

    public class d extends f {
        public d(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override
        public Boolean mo2098b(View view) {
            return Boolean.valueOf(j.m2142c(view));
        }
    }

    public static abstract class f {

        public final int f1449a;

        public final Class f1450b;

        public final int f1451c;

        public final int f1452d;

        public f(int i, Class cls, int i2) {
            this(i, cls, 0, i2);
        }

        public final boolean m2105a() {
            return Build.VERSION.SDK_INT >= this.f1451c;
        }

        public abstract Object mo2098b(View view);

        public Object m2106c(View view) {
            if (m2105a()) {
                return mo2098b(view);
            }
            Object tag = view.getTag(this.f1449a);
            if (this.f1450b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public f(int i, Class cls, int i2, int i3) {
            this.f1449a = i;
            this.f1450b = cls;
            this.f1452d = i2;
            this.f1451c = i3;
        }
    }

    public static class g {
        public static WindowInsets m2107a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets m2108b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void m2109c(View view) {
            view.requestApplyInsets();
        }
    }

    public static class h {

        public class a implements View.OnApplyWindowInsetsListener {

            public C1045Wo f1453a = null;

            public final View f1454b;

            public final InterfaceC0625Nh f1455c;

            public a(View view, InterfaceC0625Nh interfaceC0625Nh) {
                this.f1454b = view;
                this.f1455c = interfaceC0625Nh;
            }

            @Override
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                C1045Wo c1045WoM4543t = C1045Wo.m4543t(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    h.m2110a(windowInsets, this.f1454b);
                    if (c1045WoM4543t.equals(this.f1453a)) {
                        return this.f1455c.mo3322a(view, c1045WoM4543t).m4561r();
                    }
                }
                this.f1453a = c1045WoM4543t;
                C1045Wo c1045WoMo3322a = this.f1455c.mo3322a(view, c1045WoM4543t);
                if (i >= 30) {
                    return c1045WoMo3322a.m4561r();
                }
                AbstractC0448Jo.m2090s(view);
                return c1045WoMo3322a.m4561r();
            }
        }

        public static void m2110a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(AbstractC0397Ij.f1172Q);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static C1045Wo m2111b(View view, C1045Wo c1045Wo, Rect rect) {
            WindowInsets windowInsetsM4561r = c1045Wo.m4561r();
            if (windowInsetsM4561r != null) {
                return C1045Wo.m4543t(view.computeSystemWindowInsets(windowInsetsM4561r, rect), view);
            }
            rect.setEmpty();
            return c1045Wo;
        }

        public static boolean m2112c(View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        public static boolean m2113d(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        public static boolean m2114e(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        public static boolean m2115f(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        public static ColorStateList m2116g(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode m2117h(View view) {
            return view.getBackgroundTintMode();
        }

        public static float m2118i(View view) {
            return view.getElevation();
        }

        public static C1045Wo m2119j(View view) {
            return C1045Wo.a.m4562a(view);
        }

        public static String m2120k(View view) {
            return view.getTransitionName();
        }

        public static float m2121l(View view) {
            return view.getTranslationZ();
        }

        public static float m2122m(View view) {
            return view.getZ();
        }

        public static boolean m2123n(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean m2124o(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean m2125p(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void m2126q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void m2127r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void m2128s(View view, float f) {
            view.setElevation(f);
        }

        public static void m2129t(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        public static void m2130u(View view, InterfaceC0625Nh interfaceC0625Nh) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(AbstractC0397Ij.f1167L, interfaceC0625Nh);
            }
            if (interfaceC0625Nh == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(AbstractC0397Ij.f1172Q));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, interfaceC0625Nh));
            }
        }

        public static void m2131v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void m2132w(View view, float f) {
            view.setTranslationZ(f);
        }

        public static void m2133x(View view, float f) {
            view.setZ(f);
        }

        public static boolean m2134y(View view, int i) {
            return view.startNestedScroll(i);
        }

        public static void m2135z(View view) {
            view.stopNestedScroll();
        }
    }

    public static class i {
        public static C1045Wo m2136a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            C1045Wo c1045WoM4542s = C1045Wo.m4542s(rootWindowInsets);
            c1045WoM4542s.m4559p(c1045WoM4542s);
            c1045WoM4542s.m4547d(view.getRootView());
            return c1045WoM4542s;
        }

        public static int m2137b(View view) {
            return view.getScrollIndicators();
        }

        public static void m2138c(View view, int i) {
            view.setScrollIndicators(i);
        }

        public static void m2139d(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    public static class j {
        public static void m2140a(View view, final m mVar) {
            int i = AbstractC0397Ij.f1171P;
            C0950Ul c0950Ul = (C0950Ul) view.getTag(i);
            if (c0950Ul == null) {
                c0950Ul = new C0950Ul();
                view.setTag(i, c0950Ul);
            }
            Objects.requireNonNull(mVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(mVar) {
                @Override
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            c0950Ul.put(mVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static CharSequence m2141b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean m2142c(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean m2143d(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void m2144e(View view, m mVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            C0950Ul c0950Ul = (C0950Ul) view.getTag(AbstractC0397Ij.f1171P);
            if (c0950Ul == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) c0950Ul.get(mVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static <T> T m2145f(View view, int i) {
            return (T) view.requireViewById(i);
        }

        public static void m2146g(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        public static void m2147h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void m2148i(View view, AbstractC1059X1 abstractC1059X1) {
            view.setAutofillId(null);
        }

        public static void m2149j(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    public static class k {
        public static View.AccessibilityDelegate m2150a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static ContentCaptureSession m2151b(View view) {
            return view.getContentCaptureSession();
        }

        public static List<Rect> m2152c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void m2153d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        public static void m2154e(View view, AbstractC2228q6 abstractC2228q6) {
            view.setContentCaptureSession(null);
        }

        public static void m2155f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public static class l {
        public static int m2156a(View view) {
            return view.getImportantForContentCapture();
        }

        public static CharSequence m2157b(View view) {
            return view.getStateDescription();
        }

        public static boolean m2158c(View view) {
            return view.isImportantForContentCapture();
        }

        public static void m2159d(View view, int i) {
            view.setImportantForContentCapture(i);
        }

        public static void m2160e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public interface m {
    }

    public static class n {

        public static final ArrayList f1456d = new ArrayList<>();

        public WeakHashMap f1457a = null;

        public SparseArray f1458b = null;

        public WeakReference f1459c = null;

        public static n m2161a(View view) {
            int i = AbstractC0397Ij.f1170O;
            n nVar = (n) view.getTag(i);
            if (nVar != null) {
                return nVar;
            }
            n nVar2 = new n();
            view.setTag(i, nVar2);
            return nVar2;
        }

        public boolean m2162b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                m2167g();
            }
            View viewM2163c = m2163c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewM2163c != null && !KeyEvent.isModifierKey(keyCode)) {
                    m2164d().put(keyCode, new WeakReference(viewM2163c));
                }
            }
            return viewM2163c != null;
        }

        public final View m2163c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f1457a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewM2163c = m2163c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewM2163c != null) {
                            return viewM2163c;
                        }
                    }
                }
                if (m2165e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final SparseArray m2164d() {
            if (this.f1458b == null) {
                this.f1458b = new SparseArray();
            }
            return this.f1458b;
        }

        public final boolean m2165e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(AbstractC0397Ij.f1171P);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            AbstractC2524wh.m10586a(arrayList.get(size));
            throw null;
        }

        public boolean m2166f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f1459c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f1459c = new WeakReference(keyEvent);
            SparseArray sparseArrayM2164d = m2164d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayM2164d.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayM2164d.valueAt(iIndexOfKey);
                sparseArrayM2164d.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayM2164d.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                m2165e(view, keyEvent);
            }
            return true;
        }

        public final void m2167g() {
            WeakHashMap weakHashMap = this.f1457a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f1456d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f1457a == null) {
                        this.f1457a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f1456d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f1457a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f1457a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static f m2072a() {
        return new d(AbstractC0397Ij.f1165J, Boolean.class, 28);
    }

    public static C1045Wo m2073b(View view, C1045Wo c1045Wo) {
        WindowInsets windowInsetsM4561r = c1045Wo.m4561r();
        if (windowInsetsM4561r != null) {
            WindowInsets windowInsetsM2107a = g.m2107a(view, windowInsetsM4561r);
            if (!windowInsetsM2107a.equals(windowInsetsM4561r)) {
                return C1045Wo.m4543t(windowInsetsM2107a, view);
            }
        }
        return c1045Wo;
    }

    public static boolean m2074c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return n.m2161a(view).m2162b(view, keyEvent);
    }

    public static boolean m2075d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return n.m2161a(view).m2166f(keyEvent);
    }

    public static View.AccessibilityDelegate m2076e(View view) {
        return Build.VERSION.SDK_INT >= 29 ? k.m2150a(view) : m2077f(view);
    }

    public static View.AccessibilityDelegate m2077f(View view) {
        if (f1444b) {
            return null;
        }
        if (f1443a == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1443a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1444b = true;
                return null;
            }
        }
        try {
            Object obj = f1443a.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1444b = true;
            return null;
        }
    }

    public static CharSequence m2078g(View view) {
        return (CharSequence) m2087p().m2106c(view);
    }

    public static int m2079h(View view) {
        return view.getImportantForAccessibility();
    }

    public static C1045Wo m2080i(View view) {
        return i.m2136a(view);
    }

    public static CharSequence m2081j(View view) {
        return (CharSequence) m2097z().m2106c(view);
    }

    public static String m2082k(View view) {
        return h.m2120k(view);
    }

    public static boolean m2083l(View view) {
        Boolean bool = (Boolean) m2072a().m2106c(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean m2084m(View view) {
        Boolean bool = (Boolean) m2091t().m2106c(view);
        return bool != null && bool.booleanValue();
    }

    public static void m2085n(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = m2078g(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z) {
                    accessibilityEventObtain.getText().add(m2078g(view));
                    m2094w(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i2);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(m2078g(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static C1045Wo m2086o(View view, C1045Wo c1045Wo) {
        WindowInsets windowInsetsM4561r = c1045Wo.m4561r();
        if (windowInsetsM4561r != null) {
            WindowInsets windowInsetsM2108b = g.m2108b(view, windowInsetsM4561r);
            if (!windowInsetsM2108b.equals(windowInsetsM4561r)) {
                return C1045Wo.m4543t(windowInsetsM2108b, view);
            }
        }
        return c1045Wo;
    }

    public static f m2087p() {
        return new b(AbstractC0397Ij.f1166K, CharSequence.class, 8, 28);
    }

    public static void m2088q(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m2089r(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m2090s(View view) {
        g.m2109c(view);
    }

    public static f m2091t() {
        return new a(AbstractC0397Ij.f1168M, Boolean.class, 28);
    }

    public static void m2092u(View view, C0736Q c0736q) {
        if (c0736q == null && (m2076e(view) instanceof C0736Q.a)) {
            c0736q = new C0736Q();
        }
        m2094w(view);
        view.setAccessibilityDelegate(c0736q == null ? null : c0736q.m3610d());
    }

    public static void m2093v(View view, int i2) {
        view.setImportantForAccessibility(i2);
    }

    public static void m2094w(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static void m2095x(View view, InterfaceC0625Nh interfaceC0625Nh) {
        h.m2130u(view, interfaceC0625Nh);
    }

    public static void m2096y(View view, String str) {
        h.m2131v(view, str);
    }

    public static f m2097z() {
        return new c(AbstractC0397Ij.f1169N, CharSequence.class, 64, 30);
    }

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        public final WeakHashMap f1448a = new WeakHashMap();

        public final void m2103a(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z) {
                AbstractC0448Jo.m2085n(view, z ? 16 : 32);
                entry.setValue(Boolean.valueOf(z));
            }
        }

        public final void m2104b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f1448a.entrySet().iterator();
                while (it.hasNext()) {
                    m2103a((Map.Entry) it.next());
                }
            }
        }

        @Override
        public void onViewAttachedToWindow(View view) {
            m2104b(view);
        }

        @Override
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
