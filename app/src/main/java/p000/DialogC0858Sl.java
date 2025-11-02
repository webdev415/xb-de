package p000;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.C1539a;
import com.xbrowser.play.R;
import org.json.JSONException;

/* loaded from: classes.dex */
public class DialogC0858Sl extends AbstractDialogC2267r {

    public BrowserActivity f2661b;

    public String f2662c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) throws JSONException {
            EditText editText = (EditText) DialogC0858Sl.this.findViewById(R.id.share_rule_desc);
            EditText editText2 = (EditText) DialogC0858Sl.this.findViewById(R.id.share_rule_title);
            EditText editText3 = (EditText) DialogC0858Sl.this.findViewById(R.id.from_user);
            String string = editText2.getText().toString();
            String string2 = editText.getText().toString();
            String string3 = editText3.getText().toString();
            if (TextUtils.isEmpty(string)) {
                Toast.makeText(DialogC0858Sl.this.f2661b, R.string.toast_fill_rule_source_name, Toast.LENGTH_SHORT).show();
            } else {
                C1539a.getInstance().m6590S0(string, string2, DialogC0858Sl.this.f2662c, string3);
                DialogC0858Sl.this.dismiss();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            DialogC0858Sl.this.m4069b();
            DialogC0858Sl.this.dismiss();
        }
    }

    public DialogC0858Sl(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f2661b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_share_rule_source);
        ((TextView) findViewById(R.id.source_url)).setText(this.f2662c);
        TextView textView = (TextView) findViewById(R.id.from_user);
        textView.setText(C2439uo.getInstance().getUser().getUserNick());
        if (C2439uo.getInstance().m10206D()) {
            textView.setText(C2439uo.getInstance().getUser().getUserNick());
        }
        Button button = (Button) findViewById(R.id.btn_ok);
        button.setText(R.string.btn_text_share);
        button.setOnClickListener(new a());
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public void m4069b() {
        dismiss();
    }

    public void m4070c(String str) {
        this.f2662c = str;
        show();
    }
}
