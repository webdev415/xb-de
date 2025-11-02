package p000;

import android.content.res.Resources;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;
import com.mmbox.widget.messagebox.C1418a;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.mmbox.xbrowser.user.BackgroundWebviewHandler;
import com.xbrowser.play.R;
import java.io.File;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public class DialogC2021ll extends AbstractDialogC2267r {

    public final BrowserActivity f6095b;

    public class b implements C0232F1.d {

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() throws Resources.NotFoundException {
                DialogC2021ll.this.m8413g();
            }
        }

        public class RunnableC2716b implements Runnable {
            public RunnableC2716b() {
            }

            @Override
            public void run() {
                Toast.makeText(DialogC2021ll.this.f6095b, "save as file failed", Toast.LENGTH_SHORT).show();
            }
        }

        public b() {
        }

        @Override
        public void mo844a(String str, String str2) {
            DialogC2021ll.this.f6095b.runOnUiThread(new a());
        }

        @Override
        public void mo845b() {
            DialogC2021ll.this.f6095b.runOnUiThread(new RunnableC2716b());
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override
        public void onClick(View view) throws Resources.NotFoundException {
            DialogC2021ll.this.m8411e(0);
            DialogC2021ll.this.dismiss();
            DialogC2021ll.this.m8413g();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override
        public void onClick(View view) throws Resources.NotFoundException {
            DialogC2021ll.this.m8411e(1);
            DialogC2021ll.this.dismiss();
            DialogC2021ll.this.m8413g();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override
        public void onClick(View view) {
            DialogC2021ll.this.m8411e(2);
            DialogC2021ll.this.dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override
        public void onClick(View view) throws Resources.NotFoundException {
            DialogC2021ll.this.m8411e(3);
            DialogC2021ll.this.dismiss();
            DialogC2021ll.this.m8413g();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override
        public void onClick(View view) throws Resources.NotFoundException {
            DialogC2021ll.this.m8411e(4);
            DialogC2021ll.this.dismiss();
            DialogC2021ll.this.m8413g();
        }
    }

    public DialogC2021ll(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f6095b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_save_page);
        ((Button) findViewById(R.id.save_as_mht)).setOnClickListener(new c());
        ((Button) findViewById(R.id.save_as_pdf)).setOnClickListener(new d());
        ((Button) findViewById(R.id.save_as_img)).setOnClickListener(new e());
        ((Button) findViewById(R.id.save_as_html)).setOnClickListener(new f());
        ((Button) findViewById(R.id.save_as_text)).setOnClickListener(new g());
    }

    public final void m8410d(WebView webView, String str) {
        String str2 = this.f6095b.getString(R.string.app_name) + " Document";
        new C0442Ji(new PrintAttributes.Builder().setMediaSize(PrintAttributes.MediaSize.ISO_A4).setResolution(new PrintAttributes.Resolution("pdf", "pdf", 600, 600)).setMinMargins(PrintAttributes.Margins.NO_MARGINS).build()).m2044c(webView.createPrintDocumentAdapter(str2), new File(PhoneUtils.getInstance().getOfflinesDirPath()), str);
    }

    public void m8411e(int i) {
        BrowserActivity browserActivity;
        String str;
        if (i == 0) {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f6095b.m6222J0().m9316y();
            if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
                return;
            }
            BackgroundWebviewHandler.m7163i(((WebViewBrowserController) interfaceC1300b3).m6770F0());
            return;
        }
        if (i == 3) {
            browserActivity = this.f6095b;
            str = "_XJSAPI_.save_source()";
        } else {
            if (i != 4) {
                if (i == 1 || i == 2) {
                    InterfaceC1300b3 interfaceC1300b32 = (InterfaceC1300b3) this.f6095b.m6222J0().m9316y();
                    if (interfaceC1300b32 instanceof WebViewBrowserController) {
                        WebView webViewM6770F0 = ((WebViewBrowserController) interfaceC1300b32).m6770F0();
                        String title = webViewM6770F0.getTitle();
                        String url = webViewM6770F0.getUrl();
                        if (i == 1) {
                            m8410d(webViewM6770F0, NetworkUtils.sanitizeFileName(title, url.hashCode() + "", ".pdf"));
                            return;
                        }
                        m8412f(url, NetworkUtils.sanitizeFileName(title, url.hashCode() + "", ".jpg"), "jpg");
                        return;
                    }
                    return;
                }
                return;
            }
            browserActivity = this.f6095b;
            str = "_XJSAPI_.save_text()";
        }
        browserActivity.m6361u0(str);
    }

    public final void m8412f(String str, String str2, String str3) {
        String str4 = ApiEndpointsManager.getInstance().getSavePageAsEndpoint() + "?url=" + str + "&type=" + str3;
        String strM5612s = PhoneUtils.getInstance().getOfflinesDirPath();
        Toast.makeText(this.f6095b, R.string.toast_convert_file_pls_wait, Toast.LENGTH_LONG).show();
        C0232F1.m1169l().m1171f(strM5612s, str4, str2, new b());
    }

    public final void m8413g() throws Resources.NotFoundException {
        C1418a.m6110b().m6117h(this.f6095b.getBrowserFrameLayout(), this.f6095b.getString(R.string.toast_web_page_saved), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_view), new a());
    }

    public class a implements MessageBoxBase.MessageBoxListener {
        public a() {
        }

        @Override
        public void onShown() throws URISyntaxException {
            DialogC2021ll.this.f6095b.m6287Z1();
        }

        @Override
        public void onDismissed() {
        }

        @Override
        public void onDismiss() {
        }
    }
}
