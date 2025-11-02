package p000;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public class DialogC1975kl extends AbstractDialogC2267r {

    public final BrowserActivity f6028b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            String string = ((EditText) DialogC1975kl.this.findViewById(R.id.folder_name)).getText().toString();
            if (string.indexOf(47) >= 0 || string.indexOf(92) >= 0) {
                Toast.makeText(DialogC1975kl.this.f6028b, R.string.toast_folder_name_invalid, Toast.LENGTH_LONG).show();
                return;
            }
            if (TextUtils.isEmpty(string)) {
                string = DialogC1975kl.this.f6028b.getString(R.string.default_tabs_folder_name);
            }
            DialogC1975kl.this.f6028b.m6383z2(string);
            DialogC1975kl.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            DialogC1975kl.this.dismiss();
        }
    }

    public DialogC1975kl(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f6028b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_save_all_tabs);
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new a());
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }
}
