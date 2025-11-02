package p000;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC1038Wh implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    public final View f3076a;

    public ViewTreeObserver f3077b;

    public final Runnable f3078c;

    public ViewTreeObserverOnPreDrawListenerC1038Wh(View view, Runnable runnable) {
        this.f3076a = view;
        this.f3077b = view.getViewTreeObserver();
        this.f3078c = runnable;
    }

    public static ViewTreeObserverOnPreDrawListenerC1038Wh m4506a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        ViewTreeObserverOnPreDrawListenerC1038Wh viewTreeObserverOnPreDrawListenerC1038Wh = new ViewTreeObserverOnPreDrawListenerC1038Wh(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC1038Wh);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC1038Wh);
        return viewTreeObserverOnPreDrawListenerC1038Wh;
    }

    public void m4507b() {
        (this.f3077b.isAlive() ? this.f3077b : this.f3076a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f3076a.removeOnAttachStateChangeListener(this);
    }

    @Override
    public boolean onPreDraw() {
        m4507b();
        this.f3078c.run();
        return true;
    }

    @Override
    public void onViewAttachedToWindow(View view) {
        this.f3077b = view.getViewTreeObserver();
    }

    @Override
    public void onViewDetachedFromWindow(View view) {
        m4507b();
    }
}
