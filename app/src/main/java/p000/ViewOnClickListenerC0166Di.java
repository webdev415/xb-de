package p000;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.net.URISyntaxException;

public class ViewOnClickListenerC0166Di extends AbstractDialogC2267r implements View.OnClickListener {

    public BrowserActivity f409b;

    public String f410c;

    public String f411d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) throws URISyntaxException {
            ViewOnClickListenerC0166Di.this.dismiss();
            ViewOnClickListenerC0166Di.this.f409b.m6302c2();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            ViewOnClickListenerC0166Di viewOnClickListenerC0166Di = ViewOnClickListenerC0166Di.this;
            AndroidSystemUtils.m8701i(viewOnClickListenerC0166Di.f409b, viewOnClickListenerC0166Di.f411d);
            Toast.makeText(ViewOnClickListenerC0166Di.this.f409b, R.string.toast_copy_to_clip_board, Toast.LENGTH_SHORT).show();
        }
    }

    public ViewOnClickListenerC0166Di(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f409b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_page_info);
        TextView textView = (TextView) findViewById(R.id.page_title);
        if (textView != null) {
            textView.setText(this.f410c);
        }
        TextView textView2 = (TextView) findViewById(R.id.page_url);
        if (textView2 != null) {
            if (!TextUtils.isEmpty(this.f411d) && this.f411d.indexOf("baidu.com") > 0) {
                this.f411d = this.f411d.replaceAll("from=[a-z0-9_]{8,20}", "from=" + SharedPreferencesHelper.getInstance().f4897c0);
            }
            textView2.setText(this.f411d);
        }
        ((Button) findViewById(R.id.btn_website_conf)).setOnClickListener(new a());
        ((Button) findViewById(R.id.btn_copy_link)).setOnClickListener(new b());
    }

    public void m714c(String str, String str2) {
        this.f410c = str;
        this.f411d = str2;
        super.show();
    }

    @Override
    public void onClick(View view) {
    }
}
