package p000;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

public class ViewOnClickListenerC1110Y6 extends AbstractDialogC2267r implements View.OnClickListener {

    public BrowserActivity f3304b;

    public String f3305c;

    public class a implements View.OnClickListener {

        public final EditText f3306a;

        public a(EditText editText) {
            this.f3306a = editText;
        }

        @Override
        public void onClick(View view) {
            String strTrim = this.f3306a.getText().toString().trim();
            if (TextUtils.isEmpty(strTrim)) {
                Toast.makeText(ViewOnClickListenerC1110Y6.this.f3304b, "invalid url", Toast.LENGTH_SHORT).show();
                return;
            }
            SharedPreferencesHelper.getInstance().m6861J0(strTrim);
            ViewOnClickListenerC1110Y6.this.dismiss();
            ViewOnClickListenerC1110Y6.this.f3304b.m6361u0("native_call_update_set_home_btn()");
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            ViewOnClickListenerC1110Y6.this.dismiss();
        }
    }

    public ViewOnClickListenerC1110Y6(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f3305c = null;
        this.f3304b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_single_text_field);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        editText.setHint(R.string.change_home_page_hint);
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new a(editText));
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public void m4873b(String str) {
        this.f3305c = str;
        show();
    }

    @Override
    public void onClick(View view) {
    }
}
