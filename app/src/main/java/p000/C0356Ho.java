package p000;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.VideoSniffingManager;
import com.xbrowser.play.R;
import org.json.JSONException;

public class C0356Ho implements InterfaceC0529Ld.a {

    public static C0356Ho f1076l;

    public FrameLayout f1078b;

    public FrameLayout f1080d;

    public Button f1082f;

    public PopupWindow f1083g;

    public int f1085i;

    public int f1086j;

    public int f1087k;

    public BrowserActivity f1077a = null;

    public boolean f1079c = false;

    public CharSequence f1081e = "1.0x";

    public final Runnable f1084h = new d();

    public class a implements View.OnClickListener {

        public final TextView f1088a;

        public a(TextView textView) {
            this.f1088a = textView;
        }

        @Override
        public void onClick(View view) {
            C0356Ho.this.f1081e = this.f1088a.getText();
            C0356Ho.this.m1612o();
            C0356Ho.this.f1083g.dismiss();
        }
    }

    public class b implements View.OnClickListener {

        public final TextView f1090a;

        public b(TextView textView) {
            this.f1090a = textView;
        }

        @Override
        public void onClick(View view) {
            C0356Ho.this.f1081e = this.f1090a.getText();
            C0356Ho.this.m1612o();
            C0356Ho.this.f1083g.dismiss();
        }
    }

    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override
        public void onDismiss() {
            C0356Ho.this.m1607j();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override
        public void run() {
            PopupWindow popupWindow = C0356Ho.this.f1083g;
            if (popupWindow == null || !popupWindow.isShowing()) {
                C0356Ho.this.m1606h();
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override
        public void onClick(View view) {
            C0356Ho.this.m1611n();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override
        public void onClick(View view) {
            if (C0356Ho.this.f1077a.getRequestedOrientation() == 6) {
                C0356Ho.this.f1077a.setRequestedOrientation(7);
            } else {
                C0356Ho.this.f1077a.setRequestedOrientation(6);
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override
        public void onClick(View view) throws JSONException, Resources.NotFoundException {
            String strM6234M0 = C0356Ho.this.f1077a.m6234M0();
            String strMo1574c = C0356Ho.this.f1077a.getBrowserController().mo1574c();
            if (C0356Ho.this.f1077a.m6358t1(strM6234M0)) {
                C0356Ho.this.f1077a.m6321h0(strM6234M0);
            } else {
                String string = C0356Ho.this.f1077a.getString(R.string.common_bookmark_folder_video);
                String str = "/" + string;
                if (!C0356Ho.this.f1077a.m6358t1(str)) {
                    C0356Ho.this.f1077a.m6368w(string, str, "/", true);
                }
                C0356Ho.this.f1077a.m6368w(strMo1574c, strM6234M0, str, false);
            }
            C0356Ho.this.m1614q();
        }
    }

    public class h implements View.OnClickListener {

        public final TextView f1097a;

        public h(TextView textView) {
            this.f1097a = textView;
        }

        @Override
        public void onClick(View view) {
            C0356Ho.this.f1081e = this.f1097a.getText();
            C0356Ho.this.m1612o();
            C0356Ho.this.f1083g.dismiss();
        }
    }

    public class i implements View.OnClickListener {

        public final TextView f1099a;

        public i(TextView textView) {
            this.f1099a = textView;
        }

        @Override
        public void onClick(View view) {
            C0356Ho.this.f1081e = this.f1099a.getText();
            C0356Ho.this.m1612o();
            C0356Ho.this.f1083g.dismiss();
        }
    }

    public class j implements View.OnClickListener {

        public final TextView f1101a;

        public j(TextView textView) {
            this.f1101a = textView;
        }

        @Override
        public void onClick(View view) {
            C0356Ho.this.f1081e = this.f1101a.getText();
            C0356Ho.this.m1612o();
            C0356Ho.this.f1083g.dismiss();
        }
    }

    public class k implements View.OnClickListener {

        public final TextView f1103a;

        public k(TextView textView) {
            this.f1103a = textView;
        }

        @Override
        public void onClick(View view) {
            C0356Ho.this.f1081e = this.f1103a.getText();
            C0356Ho.this.m1612o();
            C0356Ho.this.f1083g.dismiss();
        }
    }

    public class l implements View.OnClickListener {

        public final TextView f1105a;

        public l(TextView textView) {
            this.f1105a = textView;
        }

        @Override
        public void onClick(View view) {
            C0356Ho.this.f1081e = this.f1105a.getText();
            C0356Ho.this.m1612o();
            C0356Ho.this.f1083g.dismiss();
        }
    }

    public static C0356Ho getInstance() {
        if (f1076l == null) {
            f1076l = new C0356Ho();
        }
        return f1076l;
    }

    public final void m1605g(View view) {
        TextView textView = (TextView) view.findViewById(R.id.speed_1);
        m1613p(textView);
        textView.setClickable(true);
        textView.setOnClickListener(new h(textView));
        TextView textView2 = (TextView) view.findViewById(R.id.speed_2);
        m1613p(textView2);
        textView2.setClickable(true);
        textView2.setOnClickListener(new i(textView2));
        TextView textView3 = (TextView) view.findViewById(R.id.speed_3);
        m1613p(textView3);
        textView3.setClickable(true);
        textView3.setOnClickListener(new j(textView3));
        TextView textView4 = (TextView) view.findViewById(R.id.speed_4);
        m1613p(textView4);
        textView4.setClickable(true);
        textView4.setOnClickListener(new k(textView4));
        TextView textView5 = (TextView) view.findViewById(R.id.speed_5);
        m1613p(textView5);
        textView5.setClickable(true);
        textView5.setOnClickListener(new l(textView5));
        TextView textView6 = (TextView) view.findViewById(R.id.speed_6);
        m1613p(textView6);
        textView6.setClickable(true);
        textView6.setOnClickListener(new a(textView6));
        TextView textView7 = (TextView) view.findViewById(R.id.speed_7);
        m1613p(textView7);
        textView7.setClickable(true);
        textView7.setOnClickListener(new b(textView7));
    }

    public void m1606h() {
        this.f1080d.removeView(this.f1078b);
        this.f1079c = false;
    }

    public final void m1607j() {
        this.f1077a.getHandler().removeCallbacks(this.f1084h);
        this.f1077a.getHandler().postDelayed(this.f1084h, 3000L);
    }

    public void init(BrowserActivity browserActivity) {
        this.f1077a = browserActivity;
        this.f1078b = new FrameLayout(browserActivity);
        this.f1078b.addView(View.inflate(this.f1077a, R.layout.float_video_control_box, null));
        this.f1085i = (int) this.f1077a.getResources().getDimension(R.dimen.vidoe_control_bottom_margin);
        this.f1086j = (int) this.f1077a.getResources().getDimension(R.dimen.vidoe_control_right_margin);
        Button button = (Button) this.f1078b.findViewById(R.id.adjust_speed);
        this.f1082f = button;
        if (button != null) {
            button.setClickable(true);
            this.f1082f.setOnClickListener(new e());
        }
        ((ImageView) this.f1078b.findViewById(R.id.video_rotation)).setOnClickListener(new f());
        ((ImageView) this.f1078b.findViewById(R.id.bookmark_video)).setOnClickListener(new g());
    }

    public void m1609l() {
        this.f1081e = "1.0x";
        m1612o();
    }

    public void m1610m(FrameLayout frameLayout) {
        this.f1080d = frameLayout;
        if (!this.f1079c) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            layoutParams.rightMargin = this.f1086j;
            layoutParams.bottomMargin = this.f1085i;
            this.f1080d.addView(this.f1078b, layoutParams);
            this.f1079c = true;
            m1614q();
        }
        m1607j();
    }

    public final void m1611n() {
        int dimension = (int) this.f1077a.getResources().getDimension(R.dimen.speed_menu_width);
        this.f1087k = dimension;
        int i2 = this.f1086j + dimension;
        View viewInflate = View.inflate(this.f1077a, R.layout.pop_video_speed, null);
        PopupWindow popupWindow = new PopupWindow(viewInflate, this.f1087k, -2);
        this.f1083g = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.f1083g.showAtLocation(this.f1080d, 21, i2, 0);
        this.f1083g.setOnDismissListener(new c());
        m1605g(viewInflate);
    }

    public final void m1612o() {
        String string = this.f1081e.toString();
        String strSubstring = string.substring(0, string.indexOf(120));
        this.f1082f.setText(this.f1081e);
        this.f1077a.updateTitle("_XJSAPI_.update_play_speed(" + strSubstring + ")");
    }

    public final void m1613p(TextView textView) {
        textView.setTextColor(this.f1081e.equals(textView.getText()) ? -16711936 : -1);
    }

    public final void m1614q() {
        Button button;
        int i2;
        String strM6234M0 = this.f1077a.m6234M0();
        ImageView imageView = (ImageView) this.f1078b.findViewById(R.id.bookmark_video);
        if (this.f1077a.m6358t1(strM6234M0)) {
            imageView.setColorFilter(AbstractC2128o.f6486Q);
        } else {
            imageView.clearColorFilter();
        }
        if (VideoSniffingManager.getInstance().m7000j().f2130b == 0) {
            button = this.f1082f;
            i2 = 8;
        } else {
            button = this.f1082f;
            i2 = 0;
        }
        button.setVisibility(i2);
    }

    @Override
    public void mo1615w(InterfaceC0529Ld interfaceC0529Ld, ContextMenu.ContextMenuInfo contextMenuInfo) {
    }
}
