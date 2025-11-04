package p000;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class SingleTextFieldDialog extends BaseDialog {

    public BrowserActivity browserActivity;

    public String text;

    public int hint;

    public SingleTextFieldDialog(BrowserActivity browserActivity, int hint) {
        super(browserActivity);
        this.text = null;
        this.browserActivity = browserActivity;
        this.hint = hint;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_single_text_field);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        Button button = (Button) findViewById(R.id.btn_ok);
        editText.setText(text);
        if (hint != 0) {
            editText.setHint(hint);
        }
        button.setOnClickListener(view -> {
            onOK(editText.getText().toString());
            dismiss();
        });
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(view -> dismiss());
    }

    public abstract void onOK(String str);
}
