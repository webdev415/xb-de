package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class BaseDialogC1688Ee extends BaseDialog {

    public BrowserActivity browserActivity;

    public class a implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            BaseDialogC1688Ee.this.m7417d();
            BaseDialogC1688Ee.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            BaseDialogC1688Ee.this.m7416c();
            BaseDialogC1688Ee.this.dismiss();
        }
    }

    public BaseDialogC1688Ee(BrowserActivity browserActivity) {
        super(browserActivity);
        this.browserActivity = browserActivity;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_import_bm);
        ((TextView) findViewById(R.id.text_info)).setText(String.format(this.browserActivity.getString(R.string.str_import_bookmark_text), MySQLiteOpenHelper.getInstance().m7489C0() + ""));
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
