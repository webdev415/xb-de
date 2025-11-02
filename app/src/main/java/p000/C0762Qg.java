package p000;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
public class C0762Qg implements InterfaceC0529Ld {

    public int f2263i;

    public int f2255a = 0;

    public Drawable f2256b = null;

    public CharSequence f2257c = null;

    public Object f2258d = null;

    public View f2259e = null;

    public boolean f2260f = false;

    public boolean f2261g = true;

    public boolean f2262h = false;

    public boolean f2264j = false;

    public boolean f2265k = false;

    @Override
    public void mo2662a(Drawable drawable) {
        this.f2256b = drawable;
    }

    @Override
    public void mo2663b(int i) {
        this.f2255a = i;
    }

    @Override
    public CharSequence getTitle() {
        return this.f2257c;
    }

    @Override
    public View mo2665d() {
        return this.f2259e;
    }

    @Override
    public Object mo2666e() {
        return this.f2258d;
    }

    public boolean equals(Object obj) {
        return obj instanceof C0762Qg ? ((C0762Qg) obj).mo2683v() == mo2683v() : super.equals(obj);
    }

    @Override
    public void mo2667f(boolean z) {
        this.f2261g = z;
    }

    @Override
    public void mo2668g() {
        this.f2264j = true;
    }

    @Override
    public int mo2669h() {
        return this.f2263i;
    }

    @Override
    public void mo2670i(boolean z) {
        this.f2260f = z;
    }

    @Override
    public void mo2671j(boolean z) {
        this.f2262h = z;
    }

    @Override
    public void mo2672k(boolean z) {
        this.f2265k = z;
    }

    @Override
    public void mo2673l(CharSequence charSequence) {
        this.f2257c = charSequence;
    }

    @Override
    public void mo2674m(View view) {
        this.f2259e = view;
    }

    @Override
    public void mo2675n(int i) {
        this.f2263i = i;
    }

    @Override
    public void mo2676o(Object obj) {
        this.f2258d = obj;
    }

    @Override
    public boolean mo2677p() {
        return this.f2262h;
    }

    @Override
    public boolean mo2678q() {
        return this.f2261g;
    }

    @Override
    public Drawable getIcon() {
        return this.f2256b;
    }

    @Override
    public boolean mo2680s() {
        return this.f2265k;
    }

    @Override
    public boolean mo2681t() {
        return this.f2264j;
    }

    @Override
    public boolean mo2682u() {
        return this.f2260f;
    }

    @Override
    public int mo2683v() {
        return this.f2255a;
    }
}
