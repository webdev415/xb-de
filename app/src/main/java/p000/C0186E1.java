package p000;

import android.graphics.drawable.Drawable;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;

/* loaded from: classes.dex */
public class C0186E1 {

    public static C0186E1 f451a;

    public class a implements C0232F1.d {

        public final b f452a;

        public class RunnableC2685a implements Runnable {

            public final String f454l;

            public RunnableC2685a(String str) {
                this.f454l = str;
            }

            @Override
            public void run() {
                a.this.f452a.mo846a(C0988Vd.m4391d().m4399i(this.f454l, SharedPreferencesHelper.getInstance().homeIconStyle));
            }
        }

        public a(b bVar) {
            this.f452a = bVar;
        }

        @Override
        public void mo844a(String str, String str2) {
            BrowserActivity.getActivity().runOnUiThread(new RunnableC2685a(str));
        }

        @Override
        public void mo845b() {
            this.f452a.mo847b();
        }
    }

    public interface b {
        void mo846a(Drawable drawable);

        void mo847b();
    }

    public static C0186E1 m842a() {
        if (f451a == null) {
            f451a = new C0186E1();
        }
        return f451a;
    }

    public void m843b(String str, b bVar) {
        C0232F1.m1169l().m1174i(str, new a(bVar));
    }
}
