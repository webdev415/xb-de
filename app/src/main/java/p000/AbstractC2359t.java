package p000;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mmbox.widget.BrowserMainContainer;
import com.mmbox.xbrowser.BrowserFrameLayout;
import com.xbrowser.play.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class AbstractC2359t {

    public FrameLayout f7102a;

    public h f7103b;

    public InterfaceC0529Ld.a f7104c;

    public g adapter;

    public Context context;

    public final int f7107f;

    public final int f7108g;

    public View f7109h;

    public DialogInterface.OnDismissListener f7110i;

    public HashMap f7111j;

    public boolean f7112k;

    public TouchDelegate f7113l;

    public TouchDelegate f7114m;

    public class a extends TouchDelegate {

        public final FrameLayout f7115a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Rect rect, View view, FrameLayout frameLayout) {
            super(rect, view);
            this.f7115a = frameLayout;
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!m9656x() || motionEvent.getActionMasked() != 0) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            f7103b.getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                return false;
            }
            FrameLayout frameLayout = this.f7115a;
            if (frameLayout instanceof BrowserFrameLayout) {
                ((BrowserFrameLayout) frameLayout).m6472u();
            }
            m9655v();
            return true;
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setRect(new Rect(0, 0, f7103b.getWidth(), f7103b.getHeight()));
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override
        public void run() {
            AbstractC2359t abstractC2359t = AbstractC2359t.this;
            abstractC2359t.f7102a.removeView(abstractC2359t.f7103b);
            f7112k = false;
        }
    }

    public class g extends BaseAdapter {

        public ArrayList f7122a = new ArrayList<>(5);

        public class a implements Comparator {
            @Override
            public int compare(InterfaceC0529Ld interfaceC0529Ld, InterfaceC0529Ld interfaceC0529Ld2) {
                return interfaceC0529Ld.mo2669h() - interfaceC0529Ld2.mo2669h();
            }
        }

        public void m9657d(InterfaceC0529Ld interfaceC0529Ld) {
            this.f7122a.add(interfaceC0529Ld);
        }

        public void m9658e(View view, int i) {
            InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) getItem(i);
            interfaceC0529Ld.mo2674m(view);
            ((TextView) view.findViewById(R.id.menu_item_title)).setText(interfaceC0529Ld.getTitle());
            ((ImageView) view.findViewById(R.id.menu_item_icon)).setImageDrawable(interfaceC0529Ld.getIcon());
            view.setTag(interfaceC0529Ld);
            mo1710A(view, i);
        }

        public void m9659f() {
            this.f7122a.clear();
        }

        public ArrayList m9660g() {
            return this.f7122a;
        }

        @Override
        public int getCount() {
            return this.f7122a.size();
        }

        @Override
        public Object getItem(int i) {
            return this.f7122a.get(i);
        }

        @Override
        public long getItemId(int i) {
            return ((InterfaceC0529Ld) this.f7122a.get(i)).mo2683v();
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null) {
                view = getMenuItemView(parent);
            } else {
                ThemeManager.getInstance().m9500u().setLayoutView(view);
            }
            m9658e(view, position);
            return view;
        }

        public void m9661h(InterfaceC0529Ld interfaceC0529Ld) {
            this.f7122a.remove(interfaceC0529Ld);
        }

        public void m9662i() {
            Collections.sort(this.f7122a, new a());
        }
    }

    public class h extends FrameLayout {
        public h(Context context) {
            super(context);
            setFocusable(true);
            setFocusableInTouchMode(true);
            setId(4665);
        }

        @Override
        public void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            canvas.drawColor(0);
        }

        @Override
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 4) {
                m9655v();
                return true;
            }
            if (keyEvent.getKeyCode() == 82) {
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if ((motionEvent.getAction() != 0 || (x >= 0 && x < getWidth() && y >= 0 && y < getHeight())) && motionEvent.getAction() != 4) {
                super.onTouchEvent(motionEvent);
                return true;
            }
            m9655v();
            return true;
        }
    }

    public AbstractC2359t(FrameLayout frameLayout, InterfaceC0529Ld.a aVar, int i, int i2) {
        this(frameLayout, aVar, i, i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m9639m() {
        new Handler().post(new f());
        DialogInterface.OnDismissListener onDismissListener = this.f7110i;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(null);
        }
    }

    public abstract void mo1710A(View view, int i);

    public void m9640C(String str, String str2) {
        if (this.f7111j == null) {
            this.f7111j = new HashMap<>();
        }
        this.f7111j.put(str, str2);
    }

    public void m9641D(InterfaceC0529Ld.a aVar) {
        this.f7104c = aVar;
    }

    public void m9642E(View view) {
        this.f7109h = view;
        this.f7103b.removeAllViews();
        this.f7103b.addView(view);
    }

    public void mo7047F(int i, int i2, int i3) {
        BrowserMainContainer browserMainContainer;
        if (m9656x() || mo9012r() == 0) {
            return;
        }
        this.adapter.m9662i();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f7107f, this.f7108g);
        layoutParams.gravity = i3;
        this.f7103b.getWidth();
        this.f7103b.getHeight();
        int iM5580D = PhoneUtils.getInstance().getScreenHeight();
        int iM5581E = PhoneUtils.getInstance().getScreenWidth();
        if (this.f7108g < 0) {
            int iMo6668y = mo6668y();
            int i4 = this.f7107f;
            int dimension = (int) getContext().getResources().getDimension(R.dimen.ctx_menu_right_margin);
            int dimension2 = (int) getContext().getResources().getDimension(R.dimen.ctx_menu_top_margin);
            if (i + i4 + dimension > iM5581E) {
                i = (iM5581E - i4) - dimension;
            }
            if (i2 + iMo6668y + dimension2 > iM5580D && (i2 = ((iM5580D - iMo6668y) - dimension2) - PhoneUtils.getInstance().getNavigationBarHeight()) < 0) {
                i2 = dimension2;
            }
        }
        if (i3 == 51) {
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i2;
        } else if (i3 == 83) {
            layoutParams.leftMargin = i;
            layoutParams.bottomMargin = i2;
        } else {
            layoutParams.gravity = 51;
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i2;
        }
        this.f7109h.measure(0, 0);
        Animation animationMo1715u = mo1715u();
        if (animationMo1715u != null) {
            animationMo1715u.setAnimationListener(new d());
            this.f7109h.startAnimation(animationMo1715u);
        }
        if (mo7057z() && (browserMainContainer = (BrowserMainContainer) this.f7102a.findViewById(R.id.main_content)) != null) {
            browserMainContainer.m6105a(true);
        }
        this.f7102a.removeView(this.f7103b);
        this.f7102a.addView(this.f7103b, layoutParams);
        this.f7112k = true;
        this.f7114m = this.f7102a.getTouchDelegate();
        this.f7102a.setTouchDelegate(this.f7113l);
        this.f7103b.requestFocus();
        mo9006G();
    }

    public void mo9006G() {
        this.adapter.notifyDataSetChanged();
    }

    public InterfaceC0529Ld m9643c(InterfaceC0529Ld interfaceC0529Ld) {
        this.adapter.m9657d(interfaceC0529Ld);
        return interfaceC0529Ld;
    }

    public InterfaceC0529Ld m9644d(CharSequence charSequence, int i) {
        return m9645e(charSequence, i, 0);
    }

    public InterfaceC0529Ld m9645e(CharSequence charSequence, int i, int i2) {
        return m9646f(charSequence, null, i, i2);
    }

    public InterfaceC0529Ld m9646f(CharSequence charSequence, Drawable drawable, int i, int i2) {
        return mo9011g(charSequence, drawable, i, i2, null);
    }

    public InterfaceC0529Ld mo9011g(CharSequence charSequence, Drawable drawable, int i, int i2, Object obj) {
        C0762Qg c0762Qg = new C0762Qg();
        c0762Qg.mo2673l(charSequence);
        c0762Qg.mo2662a(drawable);
        c0762Qg.mo2663b(i);
        c0762Qg.mo2675n(i2);
        c0762Qg.mo2676o(obj);
        this.adapter.m9657d(c0762Qg);
        return c0762Qg;
    }

    public void setOnItemClickListener(AbsListView absListView) {
        absListView.setOnItemClickListener((adapterView, view, i, j) -> {
            InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) adapterView.getAdapter().getItem(i);
            if (!interfaceC0529Ld.mo2677p() && interfaceC0529Ld.mo2683v() != -1) {
                m9655v();
            }
            f7104c.mo1615w(interfaceC0529Ld, null);
        });
    }

    public void initListView(AbsListView listView) {
        listView.setAdapter(adapter);
        setOnItemClickListener(listView);
    }

    public void m9649j() {
        this.adapter.m9659f();
        HashMap map = this.f7111j;
        if (map != null) {
            map.clear();
        }
    }

    public abstract View getMenuItemView(ViewGroup viewGroup);

    public g mo7056l() {
        return new g();
    }

    public Context getContext() {
        return this.context;
    }

    public String m9651o(String str) {
        HashMap map = this.f7111j;
        if (map != null) {
            return (String) map.get(str);
        }
        return null;
    }

    public Animation mo1714p() {
        return null;
    }

    public Rect m9652q() {
        Rect rect = new Rect();
        h hVar = this.f7103b;
        if (hVar != null) {
            hVar.getHitRect(rect);
        }
        return rect;
    }

    public int mo9012r() {
        return this.adapter.getCount();
    }

    public g m9653s() {
        return this.adapter;
    }

    public View m9654t() {
        return this.f7109h;
    }

    public Animation mo1715u() {
        return null;
    }

    public void m9655v() {
        BrowserMainContainer browserMainContainer;
        if (mo7057z() && (browserMainContainer = (BrowserMainContainer) this.f7102a.findViewById(R.id.main_content)) != null) {
            browserMainContainer.m6105a(false);
        }
        Animation animationMo1714p = mo1714p();
        if (animationMo1714p == null || !this.f7112k) {
            m9639m();
        } else {
            animationMo1714p.setAnimationListener(new e());
            this.f7109h.startAnimation(animationMo1714p);
        }
        this.f7112k = false;
        this.f7102a.setTouchDelegate(this.f7114m);
    }

    public boolean m9656x() {
        return this.f7112k;
    }

    public int mo6668y() {
        return -1;
    }

    public boolean mo7057z() {
        return false;
    }

    public AbstractC2359t(FrameLayout frameLayout, InterfaceC0529Ld.a aVar, int i, int i2, boolean z) {
        this.adapter = null;
        this.f7109h = null;
        this.f7111j = null;
        this.f7112k = false;
        this.f7113l = null;
        this.f7114m = null;
        Rect rect = new Rect();
        frameLayout.getHitRect(rect);
        this.f7113l = new a(rect, frameLayout, frameLayout);
        this.f7107f = i;
        this.f7108g = i2;
        this.f7102a = frameLayout;
        this.f7103b = new h(frameLayout.getContext());
        if (z) {
            this.f7103b.setElevation((int) frameLayout.getContext().getResources().getDimension(R.dimen.menu_shadow_elevation));
            this.f7103b.setOutlineProvider(new b());
        }
        this.f7104c = aVar;
        this.context = frameLayout.getContext();
        this.adapter = mo7056l();
    }

    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }
    }

    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            m9639m();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }
    }
}
