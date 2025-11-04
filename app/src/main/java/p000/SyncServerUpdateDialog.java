package p000;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class SyncServerUpdateDialog extends BaseDialog {

    public BrowserActivity browserActivity;

    public SyncServerUpdateDialog(BrowserActivity browserActivity) {
        super(browserActivity);
        this.browserActivity = browserActivity;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_sync_server_update);
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(view -> {
            onOK();
            dismiss();
        });
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(view -> {
            onCancel();
            dismiss();
        });
    }

    public abstract void onOK(int i);

    public void onOK() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.rb_force_push);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rb_pull_from_server);
        if (radioButton.isChecked()) {
            onOK(0);
        } else if (radioButton2.isChecked()) {
            onOK(1);
        }
    }

    public void onCancel() {
    }
}
