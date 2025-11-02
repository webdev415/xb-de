package p000;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000.InterfaceC1991l0;

/* loaded from: classes.dex */
public class C1898j0 {

    public static int f5843d;

    public final AccessibilityNodeInfo f5844a;

    public int f5845b = -1;

    public int f5846c = -1;

    public static class a {

        public static final a f5847A;

        public static final a f5848B;

        public static final a f5849C;

        public static final a f5850D;

        public static final a f5851E;

        public static final a f5852F;

        public static final a f5853G;

        public static final a f5854H;

        public static final a f5855I;

        public static final a f5856J;

        public static final a f5857K;

        public static final a f5858L;

        public static final a f5859M;

        public static final a f5860N;

        public static final a f5861O;

        public static final a f5862P;

        public static final a f5863Q;

        public static final a f5864R;

        public static final a f5865S;

        public static final a f5866T;

        public static final a f5867U;

        public static final a f5868d = new a(1, null);

        public static final a f5869e = new a(2, null);

        public static final a f5870f = new a(4, null);

        public static final a f5871g = new a(8, null);

        public static final a f5872h = new a(16, null);

        public static final a f5873i = new a(32, null);

        public static final a f5874j = new a(64, null);

        public static final a f5875k = new a(128, null);

        public static final a f5876l = new a(256, null, InterfaceC1991l0.b.class);

        public static final a f5877m = new a(512, null, InterfaceC1991l0.b.class);

        public static final a f5878n = new a(1024, null, InterfaceC1991l0.c.class);

        public static final a f5879o = new a(2048, null, InterfaceC1991l0.c.class);

        public static final a f5880p = new a(4096, null);

        public static final a f5881q = new a(8192, null);

        public static final a f5882r = new a(16384, null);

        public static final a f5883s = new a(32768, null);

        public static final a f5884t = new a(65536, null);

        public static final a f5885u = new a(131072, null, InterfaceC1991l0.g.class);

        public static final a f5886v = new a(262144, null);

        public static final a f5887w = new a(524288, null);

        public static final a f5888x = new a(1048576, null);

        public static final a f5889y = new a(2097152, null, InterfaceC1991l0.h.class);

        public static final a f5890z;

        public final Object f5891a;

        public final int f5892b;

        public final Class f5893c;

        static {
            int i = Build.VERSION.SDK_INT;
            f5890z = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            f5847A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, InterfaceC1991l0.e.class);
            f5848B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            f5849C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            f5850D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            f5851E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            f5852F = new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            f5853G = new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            f5854H = new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            f5855I = new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            f5856J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            f5857K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, InterfaceC1991l0.f.class);
            f5858L = new a(i >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, InterfaceC1991l0.d.class);
            f5859M = new a(i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            f5860N = new a(i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            f5861O = new a(i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            f5862P = new a(i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            f5863Q = new a(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            f5864R = new a(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            f5865S = new a(i >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            f5866T = new a(i >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            f5867U = new a(i >= 34 ? d.m8084a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        public int m8068a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f5891a).getId();
        }

        public CharSequence m8069b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f5891a).getLabel();
        }

        public boolean m8070c(View view, Bundle bundle) {
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.f5891a;
            Object obj3 = ((a) obj).f5891a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f5891a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strM8013h = C1898j0.m8013h(this.f5892b);
            if (strM8013h.equals("ACTION_UNKNOWN") && m8069b() != null) {
                strM8013h = m8069b().toString();
            }
            sb.append(strM8013h);
            return sb.toString();
        }

        public a(int i, CharSequence charSequence, Class cls) {
            this(null, i, charSequence, null, cls);
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(Object obj, int i, CharSequence charSequence, InterfaceC1991l0 interfaceC1991l0, Class cls) {
            this.f5892b = i;
            this.f5891a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i, charSequence) : obj;
            this.f5893c = cls;
        }
    }

    public static class b {
        public static Object m8071a(int i, float f, float f2, float f3) {
            return new AccessibilityNodeInfo.RangeInfo(i, f, f2, f3);
        }

        public static CharSequence m8072b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void m8073c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    public static class c {
        public static e m8074a(boolean z, int i, int i2, int i3, int i4, boolean z2, String str, String str2) {
            return new e(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z).setColumnIndex(i).setRowIndex(i2).setColumnSpan(i3).setRowSpan(i4).setSelected(z2).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static C1898j0 m8075b(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
            return C1898j0.m8012e0(accessibilityNodeInfo.getChild(i, i2));
        }

        public static String m8076c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String m8077d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo m8078e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static C1898j0 m8079f(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            return C1898j0.m8012e0(accessibilityNodeInfo.getParent(i));
        }

        public static String m8080g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean m8081h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void m8082i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setTextSelectable(z);
        }

        public static void m8083j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    public static class d {
        public static AccessibilityNodeInfo.AccessibilityAction m8084a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void m8085b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence m8086c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long m8087d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean m8088e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean m8089f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void m8090g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z);
        }

        public static void m8091h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void m8092i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void m8093j(AccessibilityNodeInfo accessibilityNodeInfo, long j) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j));
        }

        public static void m8094k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z);
        }

        public static void m8095l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z);
        }
    }

    public static class e {

        public final Object f5894a;

        public e(Object obj) {
            this.f5894a = obj;
        }
    }

    public C1898j0(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f5844a = accessibilityNodeInfo;
    }

    public static C1898j0 m8011d0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C1898j0(accessibilityNodeInfo);
    }

    public static C1898j0 m8012e0(Object obj) {
        if (obj != null) {
            return new C1898j0(obj);
        }
        return null;
    }

    public static String m8013h(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] m8014n(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public String m8015A() {
        return this.f5844a.getViewIdResourceName();
    }

    public final boolean m8016B() {
        return !m8049f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public final int m8017C(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i)).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f5843d;
        f5843d = i2 + 1;
        return i2;
    }

    public boolean m8018D() {
        return Build.VERSION.SDK_INT >= 34 ? d.m8089f(this.f5844a) : m8051i(64);
    }

    public boolean m8019E() {
        return this.f5844a.isCheckable();
    }

    public boolean m8020F() {
        return this.f5844a.isChecked();
    }

    public boolean m8021G() {
        return this.f5844a.isClickable();
    }

    public boolean m8022H() {
        return this.f5844a.isContextClickable();
    }

    public boolean m8023I() {
        return this.f5844a.isEnabled();
    }

    public boolean m8024J() {
        return this.f5844a.isFocusable();
    }

    public boolean m8025K() {
        return this.f5844a.isFocused();
    }

    public boolean m8026L() {
        return m8051i(67108864);
    }

    public boolean m8027M() {
        return this.f5844a.isImportantForAccessibility();
    }

    public boolean m8028N() {
        return this.f5844a.isLongClickable();
    }

    public boolean m8029O() {
        return this.f5844a.isPassword();
    }

    public boolean m8030P() {
        return this.f5844a.isScrollable();
    }

    public boolean m8031Q() {
        return this.f5844a.isSelected();
    }

    public boolean m8032R() {
        return Build.VERSION.SDK_INT >= 33 ? c.m8081h(this.f5844a) : m8051i(8388608);
    }

    public boolean m8033S() {
        return this.f5844a.isVisibleToUser();
    }

    public boolean m8034T(int i, Bundle bundle) {
        return this.f5844a.performAction(i, bundle);
    }

    public final void m8035U(View view) {
        SparseArray sparseArrayM8063v = m8063v(view);
        if (sparseArrayM8063v != null) {
            ArrayList arrayList = new ArrayList<>();
            for (int i = 0; i < sparseArrayM8063v.size(); i++) {
                if (((WeakReference) sparseArrayM8063v.valueAt(i)).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sparseArrayM8063v.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public final void m8036V(int i, boolean z) {
        Bundle bundleM8059r = m8059r();
        if (bundleM8059r != null) {
            int i2 = bundleM8059r.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            bundleM8059r.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    public void m8037W(CharSequence charSequence) {
        this.f5844a.setClassName(charSequence);
    }

    public void m8038X(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5844a.setHeading(z);
        } else {
            m8036V(2, z);
        }
    }

    public void m8039Y(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5844a.setPaneTitle(charSequence);
        } else {
            this.f5844a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void m8040Z(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5844a.setScreenReaderFocusable(z);
        } else {
            m8036V(1, z);
        }
    }

    public void m8041a(int i) {
        this.f5844a.addAction(i);
    }

    public void m8042a0(boolean z) {
        this.f5844a.setScrollable(z);
    }

    public void m8043b(a aVar) {
        this.f5844a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f5891a);
    }

    public void m8044b0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.m8073c(this.f5844a, charSequence);
        } else {
            this.f5844a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public final void m8045c(ClickableSpan clickableSpan, Spanned spanned, int i) {
        m8049f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        m8049f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        m8049f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        m8049f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    public AccessibilityNodeInfo m8046c0() {
        return this.f5844a;
    }

    public void m8047d(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            m8048e();
            m8035U(view);
            ClickableSpan[] clickableSpanArrM8014n = m8014n(charSequence);
            if (clickableSpanArrM8014n == null || clickableSpanArrM8014n.length <= 0) {
                return;
            }
            m8059r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", AbstractC0397Ij.f1173a);
            SparseArray sparseArrayM8061t = m8061t(view);
            for (int i = 0; i < clickableSpanArrM8014n.length; i++) {
                int iM8017C = m8017C(clickableSpanArrM8014n[i], sparseArrayM8061t);
                sparseArrayM8061t.put(iM8017C, new WeakReference(clickableSpanArrM8014n[i]));
                m8045c(clickableSpanArrM8014n[i], (Spanned) charSequence, iM8017C);
            }
        }
    }

    public final void m8048e() {
        this.f5844a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f5844a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f5844a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f5844a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C1898j0)) {
            return false;
        }
        C1898j0 c1898j0 = (C1898j0) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5844a;
        if (accessibilityNodeInfo == null) {
            if (c1898j0.f5844a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(c1898j0.f5844a)) {
            return false;
        }
        return this.f5846c == c1898j0.f5846c && this.f5845b == c1898j0.f5845b;
    }

    public final List m8049f(String str) {
        ArrayList<Integer> integerArrayList = this.f5844a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<><>();
        this.f5844a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public List m8050g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f5844a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList<>();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new a(actionList.get(i)));
        }
        return arrayList;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5844a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final boolean m8051i(int i) {
        Bundle bundleM8059r = m8059r();
        return bundleM8059r != null && (bundleM8059r.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    public void m8052j(Rect rect) {
        this.f5844a.getBoundsInParent(rect);
    }

    public void m8053k(Rect rect) {
        this.f5844a.getBoundsInScreen(rect);
    }

    public void m8054l(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.m8085b(this.f5844a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f5844a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public CharSequence m8055m() {
        return this.f5844a.getClassName();
    }

    public CharSequence m8056o() {
        return Build.VERSION.SDK_INT >= 34 ? d.m8086c(this.f5844a) : this.f5844a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public CharSequence m8057p() {
        return this.f5844a.getContentDescription();
    }

    public CharSequence m8058q() {
        return this.f5844a.getError();
    }

    public Bundle m8059r() {
        return this.f5844a.getExtras();
    }

    public int m8060s() {
        return this.f5844a.getMaxTextLength();
    }

    public final SparseArray m8061t(View view) {
        SparseArray sparseArrayM8063v = m8063v(view);
        if (sparseArrayM8063v != null) {
            return sparseArrayM8063v;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(AbstractC0397Ij.f1164I, sparseArray);
        return sparseArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m8052j(rect);
        sb.append("; boundsInParent: " + rect);
        m8053k(rect);
        sb.append("; boundsInScreen: " + rect);
        m8054l(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(m8062u());
        sb.append("; className: ");
        sb.append(m8055m());
        sb.append("; text: ");
        sb.append(m8065x());
        sb.append("; error: ");
        sb.append(m8058q());
        sb.append("; maxTextLength: ");
        sb.append(m8060s());
        sb.append("; stateDescription: ");
        sb.append(m8064w());
        sb.append("; contentDescription: ");
        sb.append(m8057p());
        sb.append("; tooltipText: ");
        sb.append(m8066y());
        sb.append("; viewIdResName: ");
        sb.append(m8015A());
        sb.append("; uniqueId: ");
        sb.append(m8067z());
        sb.append("; checkable: ");
        sb.append(m8019E());
        sb.append("; checked: ");
        sb.append(m8020F());
        sb.append("; focusable: ");
        sb.append(m8024J());
        sb.append("; focused: ");
        sb.append(m8025K());
        sb.append("; selected: ");
        sb.append(m8031Q());
        sb.append("; clickable: ");
        sb.append(m8021G());
        sb.append("; longClickable: ");
        sb.append(m8028N());
        sb.append("; contextClickable: ");
        sb.append(m8022H());
        sb.append("; enabled: ");
        sb.append(m8023I());
        sb.append("; password: ");
        sb.append(m8029O());
        sb.append("; scrollable: " + m8030P());
        sb.append("; containerTitle: ");
        sb.append(m8056o());
        sb.append("; granularScrollingSupported: ");
        sb.append(m8026L());
        sb.append("; importantForAccessibility: ");
        sb.append(m8027M());
        sb.append("; visible: ");
        sb.append(m8033S());
        sb.append("; isTextSelectable: ");
        sb.append(m8032R());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(m8018D());
        sb.append("; [");
        List listM8050g = m8050g();
        for (int i = 0; i < listM8050g.size(); i++) {
            a aVar = (a) listM8050g.get(i);
            String strM8013h = m8013h(aVar.m8068a());
            if (strM8013h.equals("ACTION_UNKNOWN") && aVar.m8069b() != null) {
                strM8013h = aVar.m8069b().toString();
            }
            sb.append(strM8013h);
            if (i != listM8050g.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence m8062u() {
        return this.f5844a.getPackageName();
    }

    public final SparseArray m8063v(View view) {
        return (SparseArray) view.getTag(AbstractC0397Ij.f1164I);
    }

    public CharSequence m8064w() {
        return Build.VERSION.SDK_INT >= 30 ? b.m8072b(this.f5844a) : this.f5844a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public CharSequence m8065x() {
        if (!m8016B()) {
            return this.f5844a.getText();
        }
        List listM8049f = m8049f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listM8049f2 = m8049f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listM8049f3 = m8049f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listM8049f4 = m8049f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f5844a.getText(), 0, this.f5844a.getText().length()));
        for (int i = 0; i < listM8049f.size(); i++) {
            spannableString.setSpan(new C0690P(((Integer) listM8049f4.get(i)).intValue(), this, m8059r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listM8049f.get(i)).intValue(), ((Integer) listM8049f2.get(i)).intValue(), ((Integer) listM8049f3.get(i)).intValue());
        }
        return spannableString;
    }

    public CharSequence m8066y() {
        return Build.VERSION.SDK_INT >= 28 ? this.f5844a.getTooltipText() : this.f5844a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public String m8067z() {
        return Build.VERSION.SDK_INT >= 33 ? c.m8080g(this.f5844a) : this.f5844a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public C1898j0(Object obj) {
        this.f5844a = (AccessibilityNodeInfo) obj;
    }
}
