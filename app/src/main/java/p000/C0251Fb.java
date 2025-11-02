package p000;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class C0251Fb {

    public final AbstractC0343Hb f662a;

    public C0251Fb(AbstractC0343Hb abstractC0343Hb) {
        this.f662a = abstractC0343Hb;
    }

    public static C0251Fb m1222b(AbstractC0343Hb abstractC0343Hb) {
        return new C0251Fb((AbstractC0343Hb) AbstractC1225aj.m5301b(abstractC0343Hb, "callbacks == null"));
    }

    public void m1223a(AbstractComponentCallbacksC0159Db abstractComponentCallbacksC0159Db) {
        AbstractC0343Hb abstractC0343Hb = this.f662a;
        abstractC0343Hb.f1055e.m1933g(abstractC0343Hb, abstractC0343Hb, abstractComponentCallbacksC0159Db);
    }

    public void m1224c() {
        this.f662a.f1055e.m1943l();
    }

    public void m1225d(Configuration configuration) {
        this.f662a.f1055e.m1945m(configuration);
    }

    public boolean m1226e(MenuItem menuItem) {
        return this.f662a.f1055e.m1947n(menuItem);
    }

    public void m1227f() {
        this.f662a.f1055e.m1949o();
    }

    public boolean m1228g(Menu menu, MenuInflater menuInflater) {
        return this.f662a.f1055e.m1950p(menu, menuInflater);
    }

    public void m1229h() {
        this.f662a.f1055e.m1951q();
    }

    public void m1230i() {
        this.f662a.f1055e.m1952r();
    }

    public void m1231j(boolean z) {
        this.f662a.f1055e.m1953s(z);
    }

    public boolean m1232k(MenuItem menuItem) {
        return this.f662a.f1055e.m1954t(menuItem);
    }

    public void m1233l(Menu menu) {
        this.f662a.f1055e.m1955u(menu);
    }

    public void m1234m() {
        this.f662a.f1055e.m1957w();
    }

    public void m1235n(boolean z) {
        this.f662a.f1055e.m1958x(z);
    }

    public boolean m1236o(Menu menu) {
        return this.f662a.f1055e.m1959y(menu);
    }

    public void m1237p() {
        this.f662a.f1055e.m1960z();
    }

    public void m1238q() {
        this.f662a.f1055e.m1900A();
    }

    public void m1239r() {
        this.f662a.f1055e.m1902C();
    }

    public boolean m1240s() {
        return this.f662a.f1055e.m1906G();
    }

    public AbstractComponentCallbacksC0159Db m1241t(String str) {
        this.f662a.f1055e.m1911M(str);
        return null;
    }

    public AbstractC0389Ib m1242u() {
        return this.f662a.f1055e;
    }

    public void m1243v() {
        this.f662a.f1055e.m1924Z();
    }

    public View m1244w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f662a.f1055e.onCreateView(view, str, context, attributeSet);
    }

    public void m1245x(Parcelable parcelable) {
        AbstractC0343Hb abstractC0343Hb = this.f662a;
        if (!(abstractC0343Hb instanceof InterfaceC0724Po)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        abstractC0343Hb.f1055e.m1934g0(parcelable);
    }

    public Parcelable m1246y() {
        return this.f662a.f1055e.m1936h0();
    }
}
