package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public class DialogC0076Bk extends AbstractDialogC2267r {

    public String f190b;

    public BrowserActivity f191c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            DialogC0076Bk.this.m322c();
            DialogC0076Bk.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            DialogC0076Bk.this.m321b();
            DialogC0076Bk.this.dismiss();
        }
    }

    public DialogC0076Bk(BrowserActivity browserActivity, String str) {
        super(browserActivity);
        this.f191c = browserActivity;
        this.f190b = str;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_area_text_box);
        ((EditText) findViewById(R.id.text_info)).setHint(R.string.report_site_hint);
        Button button = (Button) findViewById(R.id.btn_ok);
        button.setText(R.string.btn_text_submit);
        button.setOnClickListener(new a());
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public void m321b() {
        dismiss();
    }

    public void m322c() {
        C1344c1.m5691d().m5699i(((EditText) findViewById(R.id.text_info)).getText().toString(), "report_site", this.f190b);
        Toast.makeText(this.f191c, R.string.toast_data_reported, Toast.LENGTH_LONG).show();
    }
}
