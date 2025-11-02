package p000;

import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;
import com.mmbox.widget.messagebox.C1418a;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.net.URISyntaxException;

public class C2363t3 {

    public static C2363t3 f7138c;

    public boolean f7139a = false;

    public BrowserActivity f7140b = null;

    public class a implements Runnable {
        public a() {
        }

        @Override
        public void run() {
            Toast.makeText(C2363t3.this.f7140b, R.string.toast_long_press_menu_show_page_tool_menu, Toast.LENGTH_LONG).show();
        }
    }

    public static C2363t3 m9665a() {
        if (f7138c == null) {
            f7138c = new C2363t3();
        }
        return f7138c;
    }

    public boolean m9666b(int i) {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("showed_tips", "");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i);
        sb.append("]");
        return strM6871P.indexOf(sb.toString()) >= 0;
    }

    public void m9667c(BrowserActivity browserActivity) {
        this.f7140b = browserActivity;
    }

    public void m9668d(int i) {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("showed_tips", "");
        String str = "[" + i + "]";
        if (m9666b(i)) {
            return;
        }
        SharedPreferencesHelper.getInstance().putString("showed_tips", strM6871P + "," + str);
    }

    public final void m9669e() {
        C1418a.m6110b().m6115f(this.f7140b.getBrowserFrameLayout(), this.f7140b.getString(R.string.tips_ad_block), null, false);
        this.f7139a = true;
    }

    public final void m9670f() {
        C1418a.m6110b().m6115f(this.f7140b.getBrowserFrameLayout(), this.f7140b.getString(R.string.tips_fullscreen_gesture), null, false);
        this.f7139a = true;
    }

    public final void m9671g() {
        C1418a.m6110b().m6115f(this.f7140b.getBrowserFrameLayout(), this.f7140b.getString(R.string.tips_multi_bm), null, false);
        this.f7139a = true;
    }

    public void m9672h(int i) {
        m9673i(i, true);
    }

    public void m9673i(int i, boolean z) {
        if ((!SharedPreferencesHelper.getInstance().m6928y().equals("browser") || this.f7139a) && z) {
            return;
        }
        if ((System.currentTimeMillis() - SharedPreferencesHelper.getInstance().m6862K("last_tip_show_times", 0L) >= 10 || !z) && !m9666b(i)) {
            Log.i("tips", "prepare show tips >>>>>>>>>>>>> tips id:" + i);
            if (i == 3) {
                m9674j();
            } else if (i == 6) {
                m9675k();
            } else if (i == 17) {
                m9669e();
            } else if (i == 31) {
                m9676l();
            } else if (i == 112) {
                m9670f();
            } else if (i == 21) {
                m9671g();
            } else if (i == 22) {
                this.f7140b.getHandler().postDelayed(new a(), 1000L);
            }
            m9668d(i);
            SharedPreferencesHelper.getInstance().m6919s0("last_tip_show_times", System.currentTimeMillis());
        }
    }

    public final void m9674j() {
        this.f7139a = true;
        this.f7140b.getHandler().postDelayed(new d(), 6000L);
    }

    public void m9675k() {
        this.f7139a = true;
        this.f7140b.getHandler().postDelayed(new c(), 6000L);
    }

    public final void m9676l() {
        this.f7139a = true;
        this.f7140b.getHandler().postDelayed(new b(), 6000L);
    }

    public class b implements Runnable {
        public b() {
        }

        @Override
        public void run() throws Resources.NotFoundException {
            C1418a.m6110b().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getResources().getString(R.string.message_update_qr_scan_addon), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_install), new a(), false);
        }

        public class a implements MessageBoxBase.MessageBoxListener {
            public a() {
            }

            @Override
            public void onShown() throws URISyntaxException {
                C2363t3.this.f7140b.m6307d2("x:addon");
            }

            @Override
            public void onDismissed() {
            }

            @Override
            public void onDismiss() {
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override
        public void run() {
            C1418a.m6110b().m6115f(C2363t3.this.f7140b.getBrowserFrameLayout(), C2363t3.this.f7140b.getString(R.string.tips_open_link_in_bg), new a(), false);
        }

        public class a implements MessageBoxBase.MessageBoxListener {
            public a() {
            }

            @Override
            public void onShown() {
            }

            @Override
            public void onDismissed() {
            }

            @Override
            public void onDismiss() {
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override
        public void run() {
            C1418a.m6110b().m6115f(C2363t3.this.f7140b.getBrowserFrameLayout(), C2363t3.this.f7140b.getString(R.string.tips_long_press_to_delete), new a(), false);
        }

        public class a implements MessageBoxBase.MessageBoxListener {
            public a() {
            }

            @Override
            public void onShown() {
            }

            @Override
            public void onDismissed() {
            }

            @Override
            public void onDismiss() {
            }
        }
    }
}
