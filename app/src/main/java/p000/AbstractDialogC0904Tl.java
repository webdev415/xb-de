package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class AbstractDialogC0904Tl extends AbstractDialogC2267r {

    public BrowserActivity f2777b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC0904Tl.this.m4180d();
            AbstractDialogC0904Tl.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC0904Tl.this.m4179c();
            AbstractDialogC0904Tl.this.dismiss();
        }
    }

    public AbstractDialogC0904Tl(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f2777b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_sync_server_update);
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new a());
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public abstract void mo4178b(int i);

    public void m4180d() {
        int i;
        RadioButton radioButton = (RadioButton) findViewById(R.id.rb_force_push);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rb_pull_from_server);
        if (radioButton.isChecked()) {
            i = 0;
        } else if (!radioButton2.isChecked()) {
            return;
        } else {
            i = 1;
        }
        mo4178b(i);
    }

    public void m4179c() {
    }
}
