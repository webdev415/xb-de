package p000;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import p000.C1898j0;

/* loaded from: classes.dex */
public class C0736Q {

    public static final View.AccessibilityDelegate f2186c = new View.AccessibilityDelegate();

    public final View.AccessibilityDelegate f2187a;

    public final View.AccessibilityDelegate f2188b;

    public static final class a extends View.AccessibilityDelegate {

        public final C0736Q f2189a;

        public a(C0736Q c0736q) {
            this.f2189a = c0736q;
        }

        @Override
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2189a.m3608a(view, accessibilityEvent);
        }

        @Override
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            C1945k0 c1945k0M3609b = this.f2189a.m3609b(view);
            if (c1945k0M3609b != null) {
                return (AccessibilityNodeProvider) c1945k0M3609b.m8231a();
            }
            return null;
        }

        @Override
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2189a.mo3612f(view, accessibilityEvent);
        }

        @Override
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            C1898j0 c1898j0M8011d0 = C1898j0.m8011d0(accessibilityNodeInfo);
            c1898j0M8011d0.m8040Z(AbstractC0448Jo.m2084m(view));
            c1898j0M8011d0.m8038X(AbstractC0448Jo.m2083l(view));
            c1898j0M8011d0.m8039Y(AbstractC0448Jo.m2078g(view));
            c1898j0M8011d0.m8044b0(AbstractC0448Jo.m2081j(view));
            this.f2189a.mo3613g(view, c1898j0M8011d0);
            c1898j0M8011d0.m8047d(accessibilityNodeInfo.getText(), view);
            List listM3607c = C0736Q.m3607c(view);
            for (int i = 0; i < listM3607c.size(); i++) {
                c1898j0M8011d0.m8043b((C1898j0.a) listM3607c.get(i));
            }
        }

        @Override
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2189a.m3614h(view, accessibilityEvent);
        }

        @Override
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2189a.m3615i(viewGroup, view, accessibilityEvent);
        }

        @Override
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f2189a.mo3616j(view, i, bundle);
        }

        @Override
        public void sendAccessibilityEvent(View view, int i) {
            this.f2189a.m3618l(view, i);
        }

        @Override
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2189a.m3619m(view, accessibilityEvent);
        }
    }

    public C0736Q() {
        this(f2186c);
    }

    public static List m3607c(View view) {
        List list = (List) view.getTag(AbstractC0397Ij.f1163H);
        return list == null ? Collections.emptyList() : list;
    }

    public boolean m3608a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2187a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public C1945k0 m3609b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f2187a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new C1945k0(accessibilityNodeProvider);
        }
        return null;
    }

    public View.AccessibilityDelegate m3610d() {
        return this.f2188b;
    }

    public final boolean m3611e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrM8014n = C1898j0.m8014n(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; clickableSpanArrM8014n != null && i < clickableSpanArrM8014n.length; i++) {
                if (clickableSpan.equals(clickableSpanArrM8014n[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void mo3612f(View view, AccessibilityEvent accessibilityEvent) {
        this.f2187a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void mo3613g(View view, C1898j0 c1898j0) {
        this.f2187a.onInitializeAccessibilityNodeInfo(view, c1898j0.m8046c0());
    }

    public void m3614h(View view, AccessibilityEvent accessibilityEvent) {
        this.f2187a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean m3615i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2187a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean mo3616j(View view, int i, Bundle bundle) {
        List listM3607c = m3607c(view);
        boolean zPerformAccessibilityAction = false;
        int i2 = 0;
        while (true) {
            if (i2 >= listM3607c.size()) {
                break;
            }
            C1898j0.a aVar = (C1898j0.a) listM3607c.get(i2);
            if (aVar.m8068a() == i) {
                zPerformAccessibilityAction = aVar.m8070c(view, bundle);
                break;
            }
            i2++;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f2187a.performAccessibilityAction(view, i, bundle);
        }
        return (zPerformAccessibilityAction || i != AbstractC0397Ij.f1173a || bundle == null) ? zPerformAccessibilityAction : m3617k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public final boolean m3617k(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(AbstractC0397Ij.f1164I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!m3611e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public void m3618l(View view, int i) {
        this.f2187a.sendAccessibilityEvent(view, i);
    }

    public void m3619m(View view, AccessibilityEvent accessibilityEvent) {
        this.f2187a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0736Q(View.AccessibilityDelegate accessibilityDelegate) {
        this.f2187a = accessibilityDelegate;
        this.f2188b = new a(this);
    }
}
