package p000;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public class DialogC0812Rl extends AbstractDialogC2267r {

    public BrowserActivity f2415b;

    public String f2416c;

    public String f2417d;

    public int f2418e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) throws Resources.NotFoundException {
            DialogC0812Rl.this.m3827c();
            DialogC0812Rl.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            DialogC0812Rl.this.m3826b();
            DialogC0812Rl.this.dismiss();
        }
    }

    public DialogC0812Rl(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f2416c = null;
        this.f2417d = null;
        this.f2418e = 0;
        this.f2415b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_area_text_box);
        EditText editText = (EditText) findViewById(R.id.text_info);
        editText.setText(this.f2416c);
        editText.selectAll();
        Button button = (Button) findViewById(R.id.btn_ok);
        button.setText(R.string.btn_text_share);
        button.setOnClickListener(new a());
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public void m3826b() {
        dismiss();
    }

    public void m3827c() throws Resources.NotFoundException {
        AndroidSystemUtils.m8689W(getContext(), ((EditText) findViewById(R.id.text_info)).getEditableText().toString(), this.f2417d, getContext().getResources().getString(R.string.share_sign), getContext().getResources().getString(R.string.choose_app));
        if (this.f2418e == 0) {
            EventQueueManager.getInstance().processEvent(7);
        }
    }

    public void m3828d(String str, String str2, int i) {
        this.f2417d = str2;
        this.f2416c = str;
        this.f2418e = i;
        show();
    }
}
