package p000;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class ImportBookmarkDialog extends BaseDialog {

    public BrowserActivity browserActivity;

    public ImportBookmarkDialog(BrowserActivity browserActivity) {
        super(browserActivity);
        this.browserActivity = browserActivity;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_import_bm);
        ((TextView) findViewById(R.id.text_info)).setText(String.format(this.browserActivity.getString(R.string.str_import_bookmark_text), MySQLiteOpenHelper.getInstance().getPendingSize() + ""));
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(view -> {
            onOK();
            dismiss();
        });
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(view -> {
            onCancel();
            dismiss();
        });
    }

    public abstract void onOK(int type);

    public void onOK() {
        RadioButton radioButton = (RadioButton) findViewById(R.id.bm_merge);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.bm_overwrite);
        if (radioButton.isChecked()) {
            onOK(0);
        } else if (radioButton2.isChecked()) {
            onOK(1);
        }
    }

    public void onCancel() {
    }
}
