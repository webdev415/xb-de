package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class BaseDialogC0904Tl extends BaseDialog {

    public BrowserActivity browserActivity;

    public BaseDialogC0904Tl(BrowserActivity browserActivity) {
        super(browserActivity);
        this.browserActivity = browserActivity;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_sync_server_update);
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(view -> {
            m4180d();
            dismiss();
        });
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(view -> {
            m4179c();
            dismiss();
        });
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
