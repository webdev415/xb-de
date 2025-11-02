package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class AbstractDialogC1688ee extends AbstractDialogC2267r {

    public BrowserActivity f5421b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1688ee.this.m7417d();
            AbstractDialogC1688ee.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1688ee.this.m7416c();
            AbstractDialogC1688ee.this.dismiss();
        }
    }

    public AbstractDialogC1688ee(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f5421b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_import_bm);
        ((TextView) findViewById(R.id.text_info)).setText(String.format(this.f5421b.getString(R.string.str_import_bookmark_text), MySQLiteOpenHelper.getInstance().m7489C0() + ""));
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new a());
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public abstract void mo7415b(int i);

    public void m7417d() {
        int i;
        RadioButton radioButton = (RadioButton) findViewById(R.id.bm_merge);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.bm_overwrite);
        if (radioButton.isChecked()) {
            i = 0;
        } else if (!radioButton2.isChecked()) {
            return;
        } else {
            i = 1;
        }
        mo7415b(i);
    }

    public void m7416c() {
    }
}
