package p000;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.mmbox.xbrowser.MenuConfigManager;
import com.xbrowser.play.R;
import java.util.ArrayList;

public class C2179p3 extends AbstractC2359t {

    public final int f6613n;

    public ArrayList f6614o;

    public final ArrayList f6615p;

    public final int f6616q;

    public a f6617r;

    public InterfaceC0120Ci f6618s;

    public ViewPager f6619t;

    public class a extends AbstractC0212Ei {
        public a() {
        }

        @Override
        public void mo1042a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(((b) C2179p3.this.f6615p.get(i)).f6622b);
        }

        @Override
        public int mo1045d() {
            return C2179p3.this.f6615p.size();
        }

        @Override
        public Object mo1048g(ViewGroup viewGroup, int i) {
            GridView gridView = ((b) C2179p3.this.f6615p.get(i)).f6622b;
            viewGroup.addView(gridView);
            return gridView;
        }

        @Override
        public boolean mo1049h(View view, Object obj) {
            return view == obj;
        }
    }

    public class b {

        public g f6621a = null;

        public GridView f6622b = null;

        public b() {
        }
    }

    public C2179p3(FrameLayout frameLayout, InterfaceC0529Ld.a aVar, int i, int i2) throws Resources.NotFoundException {
        super(frameLayout, aVar, i, i2, false);
        this.f6613n = 12;
        this.f6614o = null;
        this.f6616q = 1;
        this.f6617r = null;
        this.f6618s = null;
        this.f6619t = null;
        View viewM9007I = m9007I(null);
        this.f6615p = new ArrayList<>();
        this.f6617r = new a();
        this.f6614o = new ArrayList<>();
        ViewPager viewPager = (ViewPager) viewM9007I.findViewById(R.id.pager);
        this.f6619t = viewPager;
        viewPager.setAdapter(this.f6617r);
        InterfaceC0120Ci interfaceC0120Ci = (InterfaceC0120Ci) viewM9007I.findViewById(R.id.indicator);
        this.f6618s = interfaceC0120Ci;
        interfaceC0120Ci.setViewPager(this.f6619t);
        m9642E(viewM9007I);
    }

    @Override
    public void mo1710A(View view, int i) {
        ThemeManager.getInstance().m9500u().setLayoutView(view);
    }

    @Override
    public void mo7047F(int i, int i2, int i3) {
        if (this.f6615p.size() == 0 || MenuConfigManager.getInstance().m7031n()) {
            m9009K();
        }
        m9654t().requestFocus();
        super.mo7047F(i, i2, i3);
    }

    @Override
    public void mo9006G() {
        this.f6617r.m1050i();
    }

    public View m9007I(ViewGroup viewGroup) {
        return ThemeManager.getInstance().m9487h(viewGroup);
    }

    public InterfaceC0529Ld m9008J(int i) {
        for (int i2 = 0; i2 < this.f6614o.size(); i2++) {
            InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) this.f6614o.get(i2);
            if (interfaceC0529Ld.mo2683v() == i) {
                return interfaceC0529Ld;
            }
        }
        return null;
    }

    public final void m9009K() {
        this.f6615p.clear();
        int size = this.f6614o.size();
        int i = size % 12 == 0 ? size / 12 : (size / 12) + 1;
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = new b();
            bVar.f6622b = (GridView) View.inflate(this.context, R.layout.main_menu_view, null);
            bVar.f6621a = new g();
            for (int i3 = 0; i3 < 12; i3++) {
                int i4 = (i2 * 12) + i3;
                if (i4 < this.f6614o.size()) {
                    bVar.f6621a.m9657d((InterfaceC0529Ld) this.f6614o.get(i4));
                }
            }
            bVar.f6621a.m9662i();
            bVar.f6622b.setAdapter((ListAdapter) bVar.f6621a);
            setOnItemClickListener(bVar.f6622b);
            this.f6615p.add(bVar);
        }
        int dimension = (int) getContext().getResources().getDimension(R.dimen.main_menu_col_width);
        ViewGroup.LayoutParams layoutParams = this.f6619t.getLayoutParams();
        if (size <= 4) {
            layoutParams.height = dimension;
            this.f6619t.setLayoutParams(layoutParams);
        } else if (size <= 8) {
            dimension *= 2;
            layoutParams.height = dimension;
            this.f6619t.setLayoutParams(layoutParams);
        }
        this.f6617r.m1050i();
        this.f6618s.mo489c();
    }

    public void m9010L(int i) {
        InterfaceC0529Ld interfaceC0529LdM9008J = m9008J(i);
        int iIndexOf = this.f6614o.indexOf(interfaceC0529LdM9008J);
        if (iIndexOf >= 0) {
            GridView gridView = ((b) this.f6615p.get(iIndexOf / 12)).f6622b;
            int i2 = iIndexOf % 12;
            View childAt = gridView.getChildAt(i2);
            ((TextView) childAt.findViewById(R.id.menu_item_title)).setText(interfaceC0529LdM9008J.getTitle());
            ((ImageView) childAt.findViewById(R.id.menu_item_icon)).setImageDrawable(interfaceC0529LdM9008J.getIcon());
            childAt.setTag(interfaceC0529LdM9008J);
            mo1710A(childAt, i2);
        }
    }

    @Override
    public InterfaceC0529Ld mo9011g(CharSequence charSequence, Drawable drawable, int i, int i2, Object obj) {
        C0762Qg c0762Qg = new C0762Qg();
        c0762Qg.mo2673l(charSequence);
        c0762Qg.mo2662a(drawable);
        c0762Qg.mo2663b(i);
        c0762Qg.mo2675n(i2);
        c0762Qg.mo2676o(obj);
        this.f6614o.add(c0762Qg);
        return c0762Qg;
    }

    @Override
    public View getMenuItemView(ViewGroup viewGroup) {
        return ThemeManager.getInstance().m9486g(viewGroup);
    }

    @Override
    public Animation mo1714p() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, m9654t().getMeasuredHeight());
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    @Override
    public int mo9012r() {
        return this.f6614o.size();
    }

    @Override
    public Animation mo1715u() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, m9654t().getMeasuredHeight(), 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    @Override
    public boolean mo7057z() {
        return true;
    }
}
