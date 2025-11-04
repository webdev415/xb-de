package p000;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.BrowserActivityDelegate;
import com.mmbox.xbrowser.ContentDataManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

public class ViewOnClickListenerC0309Gn implements View.OnClickListener, View.OnLongClickListener {

    public BrowserActivity f966b;

    public int f969e;

    public float f970f;

    public float f973i;

    public int f979o;

    public ImageView f965a = null;

    public ImageView f967c = null;

    public LinearLayout f968d = null;

    public boolean f971g = false;

    public ImageView f972h = null;

    public ImageView f974j = null;

    public TextView f975k = null;

    public TextView f976l = null;

    public TextView f977m = null;

    public TextView f978n = null;

    public class a implements View.OnTouchListener {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                int r4 = r5.getAction()
                r0 = 1
                if (r4 == 0) goto L63
                if (r4 == r0) goto L42
                r1 = 2
                if (r4 == r1) goto L10
                r5 = 3
                if (r4 == r5) goto L42
                goto L6c
            L10:
                float r4 = r5.getY()
                Gn r5 = p000.ViewOnClickListenerC0309Gn.this
                float r5 = p000.ViewOnClickListenerC0309Gn.m1413a(r5)
                float r4 = r4 - r5
                Gn r5 = p000.ViewOnClickListenerC0309Gn.this
                boolean r5 = p000.ViewOnClickListenerC0309Gn.m1415c(r5)
                if (r5 != 0) goto L3c
                r5 = 0
                int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r5 >= 0) goto L3c
                float r5 = java.lang.Math.abs(r4)
                Gn r1 = p000.ViewOnClickListenerC0309Gn.this
                float r2 = r1.f973i
                int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r5 < 0) goto L3c
                p000.ViewOnClickListenerC0309Gn.m1417e(r1)
                Gn r5 = p000.ViewOnClickListenerC0309Gn.this
                p000.ViewOnClickListenerC0309Gn.m1416d(r5, r0)
            L3c:
                Gn r5 = p000.ViewOnClickListenerC0309Gn.this
                p000.ViewOnClickListenerC0309Gn.m1418f(r5, r4)
                goto L6c
            L42:
                Gn r4 = p000.ViewOnClickListenerC0309Gn.this
                boolean r4 = p000.ViewOnClickListenerC0309Gn.m1415c(r4)
                if (r4 == 0) goto L6c
                Gn r4 = p000.ViewOnClickListenerC0309Gn.this
                boolean r4 = p000.ViewOnClickListenerC0309Gn.m1419g(r4)
                if (r4 == 0) goto L57
                Gn r4 = p000.ViewOnClickListenerC0309Gn.this
                p000.ViewOnClickListenerC0309Gn.m1420h(r4)
            L57:
                Gn r4 = p000.ViewOnClickListenerC0309Gn.this
                p000.ViewOnClickListenerC0309Gn.m1421i(r4)
                Gn r4 = p000.ViewOnClickListenerC0309Gn.this
                r5 = 0
                p000.ViewOnClickListenerC0309Gn.m1416d(r4, r5)
                goto L6c
            L63:
                Gn r4 = p000.ViewOnClickListenerC0309Gn.this
                float r5 = r5.getY()
                p000.ViewOnClickListenerC0309Gn.m1414b(r4, r5)
            L6c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.ViewOnClickListenerC0309Gn.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public ViewOnClickListenerC0309Gn(BrowserActivity browserActivity) {
        this.f979o = 0;
        this.f966b = browserActivity;
        m1434q();
        this.f979o = 0;
        boolean z = SharedPreferencesHelper.getInstance().acceptEula;
    }

    public final void m1423A() {
        ImageButton imageButton = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_home);
        if (imageButton != null) {
            imageButton.setImageLevel(this.f979o);
            imageButton.setEnabled(true);
            imageButton.setOnClickListener(this);
            ThemeManager.getInstance().m9500u().mo1389h(imageButton);
        }
    }

    public final void m1424B() {
        ImageButton imageButton;
        ImageButton imageButton2 = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_refresh);
        boolean z = true;
        if (imageButton2 != null) {
            imageButton2.setImageLevel(this.f979o);
            imageButton2.setEnabled(true);
            imageButton2.setOnClickListener(this);
            ThemeManager.getInstance().m9500u().mo1389h(imageButton2);
        }
        int i = this.f979o;
        if ((i == 0 || i == 0) && (imageButton = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_forward)) != null) {
            String strM6855G = SharedPreferencesHelper.getInstance().getDefaultActionForKey("long_press_forward_btn");
            if (!this.f966b.isNextTabValid() && (TextUtils.isEmpty(strM6855G) || strM6855G.equals("not_set") || strM6855G.equals("none"))) {
                z = false;
            }
            imageButton.setEnabled(z);
            ThemeManager.getInstance().m9500u().mo1389h(imageButton);
        }
    }

    public final void m1425C() {
        ImageButton imageButton = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_forward);
        if (imageButton != null) {
            imageButton.setImageLevel(this.f979o);
            boolean z = true;
            imageButton.setEnabled(true);
            imageButton.setOnClickListener(this);
            ThemeManager.getInstance().m9500u().mo1389h(imageButton);
            int i = this.f979o;
            if (i == 0 || i == 0) {
                String strM6855G = SharedPreferencesHelper.getInstance().getDefaultActionForKey("long_press_forward_btn");
                if (!this.f966b.isNextTabValid() && (TextUtils.isEmpty(strM6855G) || strM6855G.equals("not_set") || strM6855G.equals("none"))) {
                    z = false;
                }
                imageButton.setEnabled(z);
                ThemeManager.getInstance().m9500u().mo1389h(imageButton);
            }
        }
    }

    public final void m1426D() {
        String strM6855G = SharedPreferencesHelper.getInstance().getDefaultActionForKey("long_press_back_btn");
        ImageView imageView = (ImageView) this.f966b.findViewById(R.id.toolbar_btn_back);
        if (imageView != null) {
            imageView.setEnabled(this.f966b.isPreviousTabValid() || !(TextUtils.isEmpty(strM6855G) || strM6855G.equals("not_set") || strM6855G.equals("none")));
            ThemeManager.getInstance().m9500u().mo1389h(imageView);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1427E() {
        /*
            r3 = this;
            com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesHelper.getInstance()
            int r0 = r0.f4890Y
            r1 = 4097(0x1001, float:5.741E-42)
            if (r0 != r1) goto L1f
            com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesHelper.getInstance()
            java.lang.String r1 = "search-bar-at-top.toolbar_layout"
            java.lang.String r2 = "layout_1"
            java.lang.String r0 = r0.m6871P(r1, r2)
            java.lang.String r1 = "layout_5"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L43
            goto L3f
        L1f:
            com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesHelper.getInstance()
            java.lang.String r1 = "search-bar-at-bottom.toolbar_layout"
            java.lang.String r2 = "layout_4"
            java.lang.String r0 = r0.m6871P(r1, r2)
            java.lang.String r1 = "layout_3"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            r3.m1423A()
            goto L46
        L37:
            java.lang.String r1 = "layout_6"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L43
        L3f:
            r3.m1424B()
            goto L46
        L43:
            r3.m1425C()
        L46:
            r3.m1426D()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ViewOnClickListenerC0309Gn.m1427E():void");
    }

    public final void m1428k() {
        TextView textView = this.f975k;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = this.f976l;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        ImageView imageView = this.f967c;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.f974j;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        ImageView imageView3 = this.f965a;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        ImageView imageView4 = (ImageView) this.f966b.findViewById(R.id.toolbox_btn);
        imageView4.setOnClickListener(this);
        imageView4.setOnLongClickListener(this);
        ImageButton imageButton = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_forward);
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
            imageButton.setOnLongClickListener(this);
        }
        ImageButton imageButton2 = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_back);
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
            imageButton2.setLongClickable(true);
            imageButton2.setOnLongClickListener(this);
        }
        ImageButton imageButton3 = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_home);
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this);
            imageButton3.setLongClickable(true);
            imageButton3.setOnLongClickListener(this);
        }
        ImageButton imageButton4 = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_refresh);
        if (imageButton4 != null) {
            imageButton4.setOnClickListener(this);
        }
        ImageButton imageButton5 = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_muti_window);
        if (imageButton5 != null) {
            imageButton5.setOnClickListener(this);
            imageButton5.setLongClickable(true);
            imageButton5.setOnLongClickListener(this);
        }
        ImageButton imageButton6 = (ImageButton) this.f966b.findViewById(R.id.toolbar_btn_menu);
        if (imageButton6 != null) {
            imageButton6.setOnClickListener(this);
            imageButton6.setLongClickable(true);
            imageButton6.setOnLongClickListener(this);
        }
        ImageView imageView5 = (ImageView) this.f966b.findViewById(R.id.toolbox_btn);
        if (imageView5 != null) {
            imageView5.setLongClickable(true);
            imageView5.setOnLongClickListener(this);
        }
        View viewFindViewById = this.f966b.findViewById(R.id.fake_search_box_bottom);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(this);
        }
        View viewFindViewById2 = this.f966b.findViewById(R.id.fake_search_box_top);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1429l(int r4) {
        /*
            r3 = this;
            android.widget.ImageView r0 = r3.f965a
            r1 = 0
            r0.setVisibility(r1)
            if (r4 != 0) goto Le
        L8:
            android.widget.ImageView r0 = r3.f965a
            r0.setImageLevel(r1)
            goto L29
        Le:
            r0 = 1
            if (r4 != 0) goto L16
            int r2 = r3.f979o
            if (r2 != r0) goto L29
            goto L8
        L16:
            if (r4 != r0) goto L8
            android.widget.ImageView r2 = r3.f965a
            r2.setImageLevel(r0)
            android.widget.ImageView r0 = r3.f974j
            r2 = 8
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r3.f967c
            r0.setVisibility(r1)
        L29:
            r3.f979o = r4
            r3.m1427E()
            com.mmbox.xbrowser.BrowserActivity r0 = r3.f966b
            r0.m6204E2(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ViewOnClickListenerC0309Gn.m1429l(int):void");
    }

    public final int m1430m() {
        String strM6855G = SharedPreferencesHelper.getInstance().getDefaultActionForKey("push_bottom_toolbar_up");
        return strM6855G.equals("search") ? R.drawable.ic_search : strM6855G.equals("refresh") ? R.drawable.ic_refresh : strM6855G.equals("close_tab") ? R.drawable.ic_stop_or_close : R.drawable.ic_home;
    }

    public int m1431n() {
        return this.f979o;
    }

    public final void m1432o() {
        this.f966b.getActivityDelegate().mo6439y(SharedPreferencesHelper.getInstance().getDefaultActionForKey("push_bottom_toolbar_up"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        if (r5 == 3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a5, code lost:
    
        if ((com.mmbox.xbrowser.SharedPreferencesHelper.getInstance().f4890Y & 4098) == 4098) goto L15;
     */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(View r5) throws android.content.res.Resources.NotFoundException, java.net.URISyntaxException {
        /*
            Method dump skipped, instructions count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ViewOnClickListenerC0309Gn.onClick(android.view.View):void");
    }

    @Override
    public boolean onLongClick(View view) {
        BrowserActivityDelegate browserActivityDelegateM6218I0;
        String strM6855G;
        SharedPreferencesHelper sharedPreferencesHelperM6833I;
        String str;
        int id = view.getId();
        if (id == R.id.toolbar_btn_back) {
            boolean zMo6439y = this.f966b.getActivityDelegate().mo6439y(SharedPreferencesHelper.getInstance().getDefaultActionForKey("long_press_back_btn"));
            if (zMo6439y) {
                return zMo6439y;
            }
            this.f966b.getActivityDelegate().mo6411T();
            return true;
        }
        if (id != R.id.toolbox_btn) {
            switch (id) {
                case R.id.toolbar_btn_forward /* 2131165564 */:
                    browserActivityDelegateM6218I0 = this.f966b.getActivityDelegate();
                    sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
                    str = "long_press_forward_btn";
                    break;
                case R.id.toolbar_btn_home /* 2131165565 */:
                    browserActivityDelegateM6218I0 = this.f966b.getActivityDelegate();
                    sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
                    str = "long_press_home";
                    break;
                case R.id.toolbar_btn_menu /* 2131165566 */:
                    browserActivityDelegateM6218I0 = this.f966b.getActivityDelegate();
                    sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
                    str = "long_press_menu";
                    break;
                case R.id.toolbar_btn_muti_window /* 2131165567 */:
                    browserActivityDelegateM6218I0 = this.f966b.getActivityDelegate();
                    sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
                    str = "long_press_multi_tab";
                    break;
                default:
                    return false;
            }
            strM6855G = sharedPreferencesHelperM6833I.getDefaultActionForKey(str);
        } else {
            browserActivityDelegateM6218I0 = this.f966b.getActivityDelegate();
            strM6855G = "copy_url";
        }
        browserActivityDelegateM6218I0.mo6439y(strM6855G);
        return true;
    }

    public final void m1433p() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f972h, "translationY", 0.0f, r0.getHeight());
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfFloat.addListener(new b());
        objectAnimatorOfFloat.start();
    }

    public void m1434q() {
        this.f965a = (ImageView) this.f966b.findViewById(R.id.btn_loading_state);
        this.f967c = (ImageView) this.f966b.findViewById(R.id.default_indicator);
        this.f974j = (ImageView) this.f966b.findViewById(R.id.fav_icon);
        this.f975k = (TextView) this.f966b.findViewById(R.id.blocking_indicator_top);
        this.f976l = (TextView) this.f966b.findViewById(R.id.blocking_indicator_bottom);
        this.f977m = (TextView) this.f966b.findViewById(R.id.fake_search_box_top);
        this.f978n = (TextView) this.f966b.findViewById(R.id.fake_search_box_bottom);
        m1435r();
        m1428k();
    }

    public void m1435r() {
        BrowserActivity browserActivity;
        int i;
        a aVar;
        this.f969e = (int) this.f966b.getResources().getDimension(R.dimen.toolbar_indicator_threshold);
        boolean z = !SharedPreferencesHelper.getInstance().getDefaultActionForKey("push_bottom_toolbar_up").equals("none");
        this.f972h = (ImageView) this.f966b.findViewById(R.id.toolbar_push_indicator);
        if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4098) == 4098) {
            browserActivity = this.f966b;
            i = R.id.toolbar_mixed_container;
        } else {
            browserActivity = this.f966b;
            i = R.id.toolbar_container;
        }
        this.f968d = (LinearLayout) browserActivity.findViewById(i);
        LinearLayout linearLayout = this.f968d;
        if (linearLayout == null) {
            return;
        }
        if (z) {
            this.f972h.setImageResource(m1430m());
            this.f973i = ViewConfiguration.get(this.f966b).getScaledTouchSlop();
            this.f972h.setBackgroundResource(R.drawable.toolbar_indicator_start_bg);
            aVar = new a();
            linearLayout = this.f968d;
        } else {
            aVar = null;
        }
        linearLayout.setOnTouchListener(aVar);
    }

    public final boolean m1436s() {
        return Math.abs(this.f972h.getTranslationY()) >= ((float) this.f969e);
    }

    public void m1438u(Drawable drawable) {
        if (drawable == null) {
            this.f974j.setVisibility(View.GONE);
            return;
        }
        this.f967c.setVisibility(View.GONE);
        this.f974j.setVisibility(View.VISIBLE);
        this.f974j.setImageDrawable(drawable);
    }

    public void m1439v(String str) {
        TextView textView = this.f977m;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f978n;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    public void m1440w(String str) {
        TextView textView = (TextView) this.f966b.findViewById(R.id.blocking_indicator_top);
        TextView textView2 = (TextView) this.f966b.findViewById(R.id.blocking_indicator_bottom);
        if (SharedPreferencesHelper.getInstance().showAdBlockToast && !TextUtils.isEmpty(str) && str.startsWith("http")) {
            int iM6601Y = ContentDataManager.getInstance().m6601Y(str);
            if (iM6601Y > 0) {
                if (textView != null) {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(iM6601Y + "");
                }
                if (textView2 != null) {
                    textView2.setVisibility(View.VISIBLE);
                    textView2.setText(iM6601Y + "");
                    return;
                }
                return;
            }
            if (textView != null) {
                textView.setVisibility(View.GONE);
            }
            if (textView2 == null) {
                return;
            }
        } else {
            if (textView != null) {
                textView.setVisibility(View.GONE);
            }
            if (textView2 == null) {
                return;
            }
        }
        textView2.setVisibility(View.GONE);
    }

    public void m1441x(boolean z) {
        ImageView imageView;
        int i;
        if (z) {
            imageView = this.f967c;
            i = 1;
        } else {
            imageView = this.f967c;
            i = 0;
        }
        imageView.setImageLevel(i);
    }

    public final void m1442y() {
        this.f972h.setVisibility(View.VISIBLE);
        this.f972h.setColorFilter(-1);
    }

    public final void m1443z(float f) {
        ImageView imageView;
        int i;
        float fMax = Math.max(0.0f, -f);
        int i2 = this.f969e;
        if (fMax > i2) {
            fMax = i2;
        }
        this.f972h.setTranslationY(-fMax);
        if (fMax >= this.f969e) {
            imageView = this.f972h;
            i = R.drawable.toolbar_indicator_end_bg;
        } else {
            imageView = this.f972h;
            i = R.drawable.toolbar_indicator_start_bg;
        }
        imageView.setBackgroundResource(i);
    }

    public void m1437t() {
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            ViewOnClickListenerC0309Gn.this.f972h.clearColorFilter();
            ViewOnClickListenerC0309Gn.this.f972h.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onAnimationCancel(Animator animator) {
        }

        @Override
        public void onAnimationRepeat(Animator animator) {
        }

        @Override
        public void onAnimationStart(Animator animator) {
        }
    }
}
